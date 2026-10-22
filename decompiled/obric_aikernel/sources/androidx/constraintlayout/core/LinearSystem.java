package androidx.constraintlayout.core;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class LinearSystem {
    public static long ARRAY_ROW_CREATION = 0;
    public static final boolean DEBUG = false;
    private static final boolean DEBUG_CONSTRAINTS = false;
    public static final boolean FULL_DEBUG = false;
    public static final boolean MEASURE = false;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0;
    public static boolean OPTIMIZED_ENGINE = false;
    private static int POOL_SIZE = 1000;
    public static boolean SIMPLIFY_SYNONYMS = true;
    public static boolean SKIP_COLUMNS = true;
    public static boolean USE_BASIC_SYNONYMS = true;
    public static boolean USE_DEPENDENCY_ORDERING = false;
    public static boolean USE_SYNONYMS = true;
    public static Metrics sMetrics;
    private int TABLE_SIZE;
    public boolean graphOptimizer;
    public boolean hasSimpleDefinition;
    private boolean[] mAlreadyTestedCandidates;
    final Cache mCache;
    private Row mGoal;
    private int mMaxColumns;
    private int mMaxRows;
    int mNumColumns;
    int mNumRows;
    private SolverVariable[] mPoolVariables;
    private int mPoolVariablesCount;
    ArrayRow[] mRows;
    private Row mTempGoal;
    private HashMap<String, SolverVariable> mVariables;
    int mVariablesID;
    public boolean newgraphOptimizer;

    interface Row {
        void addError(SolverVariable r10);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem r10, boolean[] r11);

        void initFromRow(Row r10);

        boolean isEmpty();

        void updateFromFinalVariable(LinearSystem r10, SolverVariable r11, boolean r12);

        void updateFromRow(LinearSystem r10, ArrayRow r11, boolean r12);

        void updateFromSystem(LinearSystem r10);
    }

    class ValuesRow extends ArrayRow {
        final /* synthetic */ LinearSystem this$0;

        public ValuesRow(LinearSystem r10, Cache r11) {
            this.this$0 = r10;
            this.variables = new SolverVariableValues(this, r11);
        }
    }

    static {
    }

    public LinearSystem() {
        this.hasSimpleDefinition = false;
        this.mVariablesID = 0;
        this.mVariables = null;
        this.TABLE_SIZE = 32;
        this.mMaxColumns = 32;
        this.mRows = null;
        this.graphOptimizer = false;
        this.newgraphOptimizer = false;
        this.mAlreadyTestedCandidates = new boolean[32];
        this.mNumColumns = 1;
        this.mNumRows = 0;
        this.mMaxRows = 32;
        this.mPoolVariables = new SolverVariable[POOL_SIZE];
        this.mPoolVariablesCount = 0;
        this.mRows = new ArrayRow[32];
        releaseRows();
        Cache r10 = new Cache();
        this.mCache = r10;
        this.mGoal = new PriorityGoalRow(r10);
        if (OPTIMIZED_ENGINE == false) goto L5;
        Row r11 = new ValuesRow(this, r10);
    L6:
        this.mTempGoal = r11;
        return;
    L5:
        r11 = new ArrayRow(r10);
        goto L6
    }

    private SolverVariable acquireSolverVariable(SolverVariable.Type r10, String r11) {
        SolverVariable r12 = this.mCache.solverVariablePool.acquire();
        if (r12 != null) goto L5;
        r12 = new SolverVariable(r10, r11);
    L6:
        r12.setType(r10, r11);
        int r13 = this.mPoolVariablesCount;
        int r14 = POOL_SIZE;
        if (r13 < r14) goto L9;
        int r15 = r14 * 2;
        POOL_SIZE = r15;
        this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, r15);
    L9:
        SolverVariable[] r16 = this.mPoolVariables;
        int r17 = this.mPoolVariablesCount;
        this.mPoolVariablesCount = r17 + 1;
        r16[r17] = r12;
        return r12;
    L5:
        r12.reset();
        goto L6
    }

    private void addError(ArrayRow r10) {
        r10.addError(this, 0);
    }

    private final void addRow(ArrayRow r10) {
        if (SIMPLIFY_SYNONYMS == true) goto L5;
    L7:
        ArrayRow[] r11 = this.mRows;
        int r12 = this.mNumRows;
        r11[r12] = r10;
        SolverVariable r13 = r10.variable;
        r13.definitionId = r12;
        this.mNumRows = r12 + 1;
        r13.updateReferencesWithNewDefinition(this, r10);
    L9:
        if (SIMPLIFY_SYNONYMS == true) goto L11;
        return;
    L11:
        if (this.hasSimpleDefinition == false) goto L47;
        int r14 = 0;
    L14:
        if (r14 >= this.mNumRows) goto L37;
        if (this.mRows[r14] != null) goto L18;
        System.out.println("WTF");
    L18:
        ArrayRow[] r15 = this.mRows;
        if (r15[r14] == null) goto L36;
        if (r15[r14].isSimpleDefinition == false) goto L36;
        ArrayRow r16 = r15[r14];
        r16.variable.setFinalValue(this, r16.constantValue);
        if (OPTIMIZED_ENGINE == false) goto L25;
        Pools.Pool<ArrayRow> r17 = this.mCache.optimizedArrayRowPool;
    L26:
        r17.release(r16);
        this.mRows[r14] = null;
        int r18 = r14 + 1;
        int r19 = r18;
    L27:
        int r20 = this.mNumRows;
        if (r18 >= r20) goto L33;
        ArrayRow[] r21 = this.mRows;
        int r22 = r18 - 1;
        r21[r22] = r21[r18];
        if (r21[r22].variable.definitionId != r18) goto L32;
        r21[r22].variable.definitionId = r22;
    L32:
        r19 = r18;
        r18 = r18 + 1;
        goto L27
    L33:
        if (r19 >= r20) goto L35;
        this.mRows[r19] = null;
    L35:
        this.mNumRows = r20 - 1;
        r14 = r14 - 1;
        goto L36
    L25:
        r17 = this.mCache.arrayRowPool;
    L36:
        r14 = r14 + 1;
        goto L14
    L37:
        this.hasSimpleDefinition = false;
        return;
    L47:
        return;
    L5:
        if (r10.isSimpleDefinition == false) goto L7;
        r10.variable.setFinalValue(this, r10.constantValue);
        goto L9
    }

    private void addSingleError(ArrayRow r10, int r11) {
        addSingleError(r10, r11, 0);
    }

    private void computeValues() {
        int r10 = 0;
    L4:
        if (r10 >= this.mNumRows) goto L6;
        ArrayRow r11 = this.mRows[r10];
        SolverVariable r12 = r11.variable;
        r12.computedValue = r11.constantValue;
        r10 = r10 + 1;
        goto L4
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem r10, SolverVariable r11, SolverVariable r12, float r13) {
        return r10.createRow().createRowDimensionPercent(r11, r12, r13);
    }

    private SolverVariable createVariable(String r10, SolverVariable.Type r11) {
        Metrics r12 = sMetrics;
        if (r12 == null) goto L6;
        r12.variables++;
    L6:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L8;
        increaseTableSize();
    L8:
        SolverVariable r13 = acquireSolverVariable(r11, null);
        r13.setName(r10);
        int r14 = this.mVariablesID + 1;
        this.mVariablesID = r14;
        this.mNumColumns++;
        r13.id = r14;
        if (this.mVariables != null) goto L11;
        this.mVariables = new HashMap();
    L11:
        this.mVariables.put(r10, r13);
        this.mCache.mIndexedVariables[this.mVariablesID] = r13;
        return r13;
    }

    private void displayRows() {
        displaySolverVariables();
        String r10 = "";
        int r11 = 0;
    L4:
        if (r11 >= this.mNumRows) goto L6;
        r10 = (r10 + this.mRows[r11]) + "\n";
        r11 = r11 + 1;
        goto L4
    L6:
        System.out.println(r10 + this.mGoal + "\n");
    }

    private void displaySolverVariables() {
        System.out.println("Display Rows (" + this.mNumRows + "x" + this.mNumColumns + ")\n");
    }

    private int enforceBFS(Row r20) {
        int r10 = 0;
    L4:
        if (r10 >= this.mNumRows) goto L12;
        ArrayRow[] r11 = this.mRows;
        if (r11[r10].variable.mType == SolverVariable.Type.UNRESTRICTED) goto L11;
        if (r11[r10].constantValue >= 0.0f) goto L11;
        boolean r12 = true;
    L13:
        if (r12 == false) goto L73;
        boolean r13 = false;
        int r14 = 0;
    L15:
        if (r13 == true) goto L98;
        Metrics r15 = sMetrics;
        if (r15 == null) goto L19;
        r15.bfs++;
    L19:
        r14 = r14 + 1;
        float r16 = Float.MAX_VALUE;
        int r17 = 0;
        int r18 = -1;
        int r19 = -1;
        int r110 = 0;
    L21:
        if (r17 >= this.mNumRows) goto L63;
        ArrayRow r111 = this.mRows[r17];
        if (r111.variable.mType == SolverVariable.Type.UNRESTRICTED) goto L61;
        if (r111.isSimpleDefinition == true) goto L61;
        if (r111.constantValue >= 0.0f) goto L61;
        int r112 = 9;
        if (SKIP_COLUMNS == false) goto L46;
        int r21 = r111.variables.getCurrentSize();
        int r22 = 0;
    L33:
        if (r22 >= r21) goto L61;
        SolverVariable r23 = r111.variables.getVariable(r22);
        float r24 = r111.variables.get(r23);
        if (r24 <= 0.0f) goto L45;
        int r25 = 0;
    L38:
        if (r25 >= r112) goto L45;
        float r113 = r23.strengthVector[r25] / r24;
        if (r113 >= r16) goto L42;
        if (r25 != r110) goto L42;
    L43:
        r19 = r23.id;
        r110 = r25;
        r18 = r17;
        r16 = r113;
    L44:
        r25 = r25 + 1;
        r112 = 9;
    L42:
        if (r25 <= r110) goto L44;
    L45:
        r22 = r22 + 1;
        r112 = 9;
        goto L33
    L46:
        int r26 = 1;
    L48:
        if (r26 >= this.mNumColumns) goto L61;
        SolverVariable r27 = this.mCache.mIndexedVariables[r26];
        float r28 = r111.variables.get(r27);
        if (r28 <= 0.0f) goto L60;
        int r29 = 0;
    L53:
        if (r29 >= 9) goto L60;
        float r114 = r27.strengthVector[r29] / r28;
        if (r114 >= r16) goto L57;
        if (r29 != r110) goto L57;
    L58:
        r19 = r26;
        r110 = r29;
        r18 = r17;
        r16 = r114;
    L59:
        r29 = r29 + 1;
    L57:
        if (r29 <= r110) goto L59;
    L60:
        r26 = r26 + 1;
    L61:
        r17 = r17 + 1;
        goto L21
    L63:
        if (r18 == (-1)) goto L68;
        ArrayRow r30 = this.mRows[r18];
        r30.variable.definitionId = -1;
        Metrics r31 = sMetrics;
        if (r31 == null) goto L67;
        r31.pivots++;
    L67:
        r30.pivot(this.mCache.mIndexedVariables[r19]);
        SolverVariable r32 = r30.variable;
        r32.definitionId = r18;
        r32.updateReferencesWithNewDefinition(this, r30);
    L70:
        if (r14 <= (this.mNumColumns / 2)) goto L15;
        r13 = true;
        goto L15
    L68:
        r13 = true;
        goto L70
    L98:
        return r14;
    L73:
        return 0;
    L11:
        r10 = r10 + 1;
        goto L4
    L12:
        r12 = false;
        goto L13
    }

    private String getDisplaySize(int r10) {
        int r11 = r10 * 4;
        int r12 = r11 / 1024;
        int r13 = r12 / 1024;
        if (r13 > 0) goto L5;
        if (r12 <= 0) goto L10;
        return "" + r12 + " Kb";
    L10:
        return "" + r11 + " bytes";
    L5:
        return "" + r13 + " Mb";
    }

    private String getDisplayStrength(int r10) {
        if (r10 != 1) goto L7;
        return "LOW";
    L7:
        if (r10 != 2) goto L11;
        return "MEDIUM";
    L11:
        if (r10 != 3) goto L15;
        return "HIGH";
    L15:
        if (r10 != 4) goto L19;
        return "HIGHEST";
    L19:
        if (r10 != 5) goto L23;
        return "EQUALITY";
    L23:
        if (r10 != 8) goto L27;
        return "FIXED";
    L27:
        if (r10 != 6) goto L30;
        return "BARRIER";
    L30:
        return "NONE";
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    private void increaseTableSize() {
        int r10 = this.TABLE_SIZE * 2;
        this.TABLE_SIZE = r10;
        this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, r10);
        Cache r11 = this.mCache;
        r11.mIndexedVariables = (SolverVariable[]) Arrays.copyOf(r11.mIndexedVariables, this.TABLE_SIZE);
        int r12 = this.TABLE_SIZE;
        this.mAlreadyTestedCandidates = new boolean[r12];
        this.mMaxColumns = r12;
        this.mMaxRows = r12;
        Metrics r13 = sMetrics;
        if (r13 == null) goto L6;
        r13.tableSizeIncrease++;
        r13.maxTableSize = Math.max(r13.maxTableSize, r12);
        Metrics r14 = sMetrics;
        r14.lastTableSize = r14.maxTableSize;
        return;
    }

    private final int optimize(Row r13, boolean r14) {
        Metrics r15 = sMetrics;
        if (r15 == null) goto L5;
        r15.optimize++;
    L5:
        int r10 = 0;
    L7:
        if (r10 >= this.mNumColumns) goto L9;
        this.mAlreadyTestedCandidates[r10] = false;
        r10 = r10 + 1;
        goto L7
    L9:
        boolean r11 = false;
        int r12 = 0;
    L10:
        if (r11 == true) goto L50;
        Metrics r16 = sMetrics;
        if (r16 == null) goto L14;
        r16.iterations++;
    L14:
        r12 = r12 + 1;
        if (r12 >= (this.mNumColumns * 2)) goto L16;
        if (r13.getKey() == null) goto L20;
        this.mAlreadyTestedCandidates[r13.getKey().id] = true;
    L20:
        SolverVariable r17 = r13.getPivotCandidate(this, this.mAlreadyTestedCandidates);
        if (r17 == null) goto L26;
        boolean[] r18 = this.mAlreadyTestedCandidates;
        int r19 = r17.id;
        if (r18[r19] == true) goto L24;
        r18[r19] = true;
        goto L26
    L24:
        return r12;
    L26:
        if (r17 != null) goto L27;
        r11 = true;
        goto L10
    L27:
        float r20 = Float.MAX_VALUE;
        int r21 = 0;
        int r22 = -1;
    L29:
        if (r21 >= this.mNumRows) goto L44;
        ArrayRow r23 = this.mRows[r21];
        if (r23.variable.mType == SolverVariable.Type.UNRESTRICTED) goto L43;
        if (r23.isSimpleDefinition == true) goto L43;
        if (r23.hasVariable(r17) == false) goto L43;
        float r110 = r23.variables.get(r17);
        if (r110 >= 0.0f) goto L43;
        float r24 = (-r23.constantValue) / r110;
        if (r24 >= r20) goto L43;
        r22 = r21;
        r20 = r24;
    L43:
        r21 = r21 + 1;
        goto L29
    L44:
        if (r22 <= (-1)) goto L10;
        ArrayRow r25 = this.mRows[r22];
        r25.variable.definitionId = -1;
        Metrics r26 = sMetrics;
        if (r26 == null) goto L48;
        r26.pivots++;
    L48:
        r25.pivot(r17);
        SolverVariable r27 = r25.variable;
        r27.definitionId = r22;
        r27.updateReferencesWithNewDefinition(this, r25);
        goto L10
    L16:
        return r12;
    L50:
        return r12;
    }

    private void releaseRows() {
        int r10 = 0;
        if (OPTIMIZED_ENGINE == false) goto L11;
    L5:
        if (r10 >= this.mNumRows) goto L16;
        ArrayRow r11 = this.mRows[r10];
        if (r11 == null) goto L9;
        this.mCache.optimizedArrayRowPool.release(r11);
    L9:
        this.mRows[r10] = null;
        r10 = r10 + 1;
        goto L5
    L16:
        return;
    L11:
        if (r10 >= this.mNumRows) goto L23;
        ArrayRow r12 = this.mRows[r10];
        if (r12 == null) goto L15;
        this.mCache.arrayRowPool.release(r12);
    L15:
        this.mRows[r10] = null;
        r10 = r10 + 1;
        goto L11
    }

    public void addCenterPoint(ConstraintWidget r17, ConstraintWidget r18, float r19, int r20) {
        ConstraintAnchor.Type r10 = ConstraintAnchor.Type.LEFT;
        SolverVariable r11 = createObjectVariable(r17.getAnchor(r10));
        ConstraintAnchor.Type r12 = ConstraintAnchor.Type.TOP;
        SolverVariable r13 = createObjectVariable(r17.getAnchor(r12));
        ConstraintAnchor.Type r14 = ConstraintAnchor.Type.RIGHT;
        SolverVariable r15 = createObjectVariable(r17.getAnchor(r14));
        ConstraintAnchor.Type r16 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable r21 = createObjectVariable(r17.getAnchor(r16));
        SolverVariable r22 = createObjectVariable(r18.getAnchor(r10));
        SolverVariable r110 = createObjectVariable(r18.getAnchor(r12));
        SolverVariable r23 = createObjectVariable(r18.getAnchor(r14));
        SolverVariable r111 = createObjectVariable(r18.getAnchor(r16));
        ArrayRow r24 = createRow();
        double r25 = r19;
        double r26 = r20;
        r24.createRowWithAngle(r13, r21, r110, r111, (float) (Math.sin(r25) * r26));
        addConstraint(r24);
        ArrayRow r27 = createRow();
        r27.createRowWithAngle(r11, r15, r22, r23, (float) (Math.cos(r25) * r26));
        addConstraint(r27);
    }

    public void addCentering(SolverVariable r12, SolverVariable r13, int r14, float r15, SolverVariable r16, SolverVariable r17, int r18, int r19) {
        ArrayRow r10 = createRow();
        r10.createRowCentering(r12, r13, r14, r15, r16, r17, r18);
        if (r19 == 8) goto L5;
        r10.addError(this, r19);
    L5:
        addConstraint(r10);
    }

    public void addConstraint(ArrayRow r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Metrics r11 = sMetrics;
        if (r11 == null) goto L9;
        r11.constraints++;
        if (r10.isSimpleDefinition == false) goto L9;
        r11.simpleconstraints++;
    L9:
        boolean r12 = true;
        if ((this.mNumRows + 1) < this.mMaxRows) goto L12;
    L13:
        increaseTableSize();
    L14:
        boolean r13 = false;
        if (r10.isSimpleDefinition == true) goto L46;
        r10.updateFromSystem(this);
        if (r10.isEmpty() == false) goto L19;
        return;
    L19:
        r10.ensurePositiveConstant();
        if (r10.chooseSubject(this) == false) goto L41;
        SolverVariable r14 = createExtraVariable();
        r10.variable = r14;
        int r15 = this.mNumRows;
        addRow(r10);
        if (this.mNumRows != (r15 + 1)) goto L41;
        this.mTempGoal.initFromRow(r10);
        optimize(this.mTempGoal, true);
        if (r14.definitionId != (-1)) goto L43;
        if (r10.variable != r14) goto L34;
        SolverVariable r16 = r10.pickPivot(r14);
        if (r16 == null) goto L34;
        Metrics r17 = sMetrics;
        if (r17 == null) goto L32;
        r17.pivots++;
    L32:
        r10.pivot(r16);
    L34:
        if (r10.isSimpleDefinition == true) goto L37;
        r10.variable.updateReferencesWithNewDefinition(this, r10);
    L37:
        if (OPTIMIZED_ENGINE == false) goto L39;
        Pools.Pool<ArrayRow> r18 = this.mCache.optimizedArrayRowPool;
    L40:
        r18.release(r10);
        this.mNumRows--;
        goto L43
    L39:
        r18 = this.mCache.arrayRowPool;
    L43:
        if (r10.hasKeyVariable() == true) goto L45;
        return;
    L45:
        r13 = r12;
    L41:
        r12 = false;
    L46:
        if (r13 == true) goto L49;
        addRow(r10);
        return;
    L49:
        return;
    L12:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L14;
        goto L13
    }

    public ArrayRow addEquality(SolverVariable r10, SolverVariable r11, int r12, int r13) {
        if (USE_BASIC_SYNONYMS == false) goto L11;
        if (r13 != 8) goto L11;
        if (r11.isFinalValue == false) goto L11;
        if (r10.definitionId != (-1)) goto L11;
        r10.setFinalValue(this, r11.computedValue + r12);
        return null;
    L11:
        ArrayRow r14 = createRow();
        r14.createRowEquals(r10, r11, r12);
        if (r13 == 8) goto L14;
        r14.addError(this, r13);
    L14:
        addConstraint(r14);
        return r14;
    }

    public void addEquality(SolverVariable r10, int r11) {
        if (USE_BASIC_SYNONYMS == true) goto L5;
    L18:
        int r12 = r10.definitionId;
        if (r12 == (-1)) goto L27;
        ArrayRow r13 = this.mRows[r12];
        if (r13.isSimpleDefinition == false) goto L24;
    L22:
        r13.constantValue = r11;
        return;
    L24:
        if (r13.variables.getCurrentSize() != 0) goto L26;
        r13.isSimpleDefinition = true;
        goto L22
    L26:
        ArrayRow r14 = createRow();
        r14.createRowEquals(r10, r11);
    L28:
        addConstraint(r14);
        return;
    L27:
        r14 = createRow();
        r14.createRowDefinition(r10, r11);
        goto L28
    L5:
        if (r10.definitionId != (-1)) goto L18;
        float r15 = r11;
        r10.setFinalValue(this, r15);
        int r16 = 0;
    L8:
        if (r16 >= (this.mVariablesID + 1)) goto L17;
        SolverVariable r17 = this.mCache.mIndexedVariables[r16];
        if (r17 == null) goto L16;
        if (r17.isSynonym == false) goto L16;
        if (r17.synonym != r10.id) goto L16;
        r17.setFinalValue(this, r17.synonymDelta + r15);
    L16:
        r16 = r16 + 1;
        goto L8
    }

    public void addGreaterBarrier(SolverVariable r10, SolverVariable r11, int r12, boolean r13) {
        ArrayRow r14 = createRow();
        SolverVariable r15 = createSlackVariable();
        r15.strength = 0;
        r14.createRowGreaterThan(r10, r11, r15, r12);
        addConstraint(r14);
    }

    public void addGreaterThan(SolverVariable r10, SolverVariable r11, int r12, int r13) {
        ArrayRow r14 = createRow();
        SolverVariable r15 = createSlackVariable();
        r15.strength = 0;
        r14.createRowGreaterThan(r10, r11, r15, r12);
        if (r13 == 8) goto L5;
        addSingleError(r14, (int) (r14.variables.get(r15) * (-1.0f)), r13);
    L5:
        addConstraint(r14);
    }

    public void addLowerBarrier(SolverVariable r10, SolverVariable r11, int r12, boolean r13) {
        ArrayRow r14 = createRow();
        SolverVariable r15 = createSlackVariable();
        r15.strength = 0;
        r14.createRowLowerThan(r10, r11, r15, r12);
        addConstraint(r14);
    }

    public void addLowerThan(SolverVariable r10, SolverVariable r11, int r12, int r13) {
        ArrayRow r14 = createRow();
        SolverVariable r15 = createSlackVariable();
        r15.strength = 0;
        r14.createRowLowerThan(r10, r11, r15, r12);
        if (r13 == 8) goto L5;
        addSingleError(r14, (int) (r14.variables.get(r15) * (-1.0f)), r13);
    L5:
        addConstraint(r14);
    }

    public void addRatio(SolverVariable r10, SolverVariable r11, SolverVariable r12, SolverVariable r13, float r14, int r15) {
        ArrayRow r16 = createRow();
        r16.createRowDimensionRatio(r10, r11, r12, r13, r14);
        if (r15 == 8) goto L5;
        r16.addError(this, r15);
    L5:
        addConstraint(r16);
    }

    void addSingleError(ArrayRow r10, int r11, int r12) {
        r10.addSingleError(createErrorVariable(r12, null), r11);
    }

    public void addSynonym(SolverVariable r10, SolverVariable r11, int r12) {
        if (r10.definitionId != (-1)) goto L12;
        if (r12 != 0) goto L12;
        if (r11.isSynonym == false) goto L9;
        r11 = this.mCache.mIndexedVariables[r11.synonym];
    L9:
        if (r10.isSynonym == false) goto L11;
        SolverVariable r13 = this.mCache.mIndexedVariables[r10.synonym];
        return;
    L11:
        r10.setSynonym(this, r11, 0.0f);
        return;
    L12:
        addEquality(r10, r11, r12, 8);
    }

    final void cleanupRows() {
        int r10 = 0;
    L4:
        if (r10 >= this.mNumRows) goto L20;
        ArrayRow r11 = this.mRows[r10];
        if (r11.variables.getCurrentSize() != 0) goto L9;
        r11.isSimpleDefinition = true;
    L9:
        if (r11.isSimpleDefinition == false) goto L19;
        SolverVariable r12 = r11.variable;
        r12.computedValue = r11.constantValue;
        r12.removeFromRow(r11);
        int r13 = r10;
    L11:
        int r14 = this.mNumRows;
        if (r13 >= (r14 - 1)) goto L14;
        ArrayRow[] r15 = this.mRows;
        int r16 = r13 + 1;
        r15[r13] = r15[r16];
        r13 = r16;
        goto L11
    L14:
        this.mRows[r14 - 1] = null;
        this.mNumRows = r14 - 1;
        r10 = r10 - 1;
        if (OPTIMIZED_ENGINE == false) goto L17;
        Pools.Pool<ArrayRow> r17 = this.mCache.optimizedArrayRowPool;
    L18:
        r17.release(r11);
        goto L19
    L17:
        r17 = this.mCache.arrayRowPool;
    L19:
        r10 = r10 + 1;
        goto L4
    }

    public SolverVariable createErrorVariable(int r10, String r11) {
        Metrics r12 = sMetrics;
        if (r12 == null) goto L6;
        r12.errors++;
    L6:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L8;
        increaseTableSize();
    L8:
        SolverVariable r13 = acquireSolverVariable(SolverVariable.Type.ERROR, r11);
        int r14 = this.mVariablesID + 1;
        this.mVariablesID = r14;
        this.mNumColumns++;
        r13.id = r14;
        r13.strength = r10;
        this.mCache.mIndexedVariables[r14] = r13;
        this.mGoal.addError(r13);
        return r13;
    }

    public SolverVariable createExtraVariable() {
        Metrics r10 = sMetrics;
        if (r10 == null) goto L6;
        r10.extravariables++;
    L6:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L8;
        increaseTableSize();
    L8:
        SolverVariable r11 = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int r12 = this.mVariablesID + 1;
        this.mVariablesID = r12;
        this.mNumColumns++;
        r11.id = r12;
        this.mCache.mIndexedVariables[r12] = r11;
        return r11;
    }

    public SolverVariable createObjectVariable(Object r10) {
        SolverVariable r11 = null;
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L9;
        increaseTableSize();
    L9:
        if ((r10 instanceof ConstraintAnchor) == false) goto L22;
        ConstraintAnchor r12 = (ConstraintAnchor) r10;
        r11 = r12.getSolverVariable();
        if (r11 != null) goto L13;
        r12.resetSolverVariable(this.mCache);
        r11 = r12.getSolverVariable();
    L13:
        int r13 = r11.id;
        if (r13 != (-1)) goto L16;
    L19:
        if (r13 == (-1)) goto L21;
        r11.reset();
    L21:
        int r14 = this.mVariablesID + 1;
        this.mVariablesID = r14;
        this.mNumColumns++;
        r11.id = r14;
        r11.mType = SolverVariable.Type.UNRESTRICTED;
        this.mCache.mIndexedVariables[r14] = r11;
        goto L22
    L16:
        if (r13 > this.mVariablesID) goto L19;
        if (this.mCache.mIndexedVariables[r13] == null) goto L19;
    L22:
        return r11;
    }

    public ArrayRow createRow() {
        if (OPTIMIZED_ENGINE == false) goto L7;
        ArrayRow r10 = this.mCache.optimizedArrayRowPool.acquire();
        if (r10 != null) goto L10;
        r10 = new ValuesRow(this, this.mCache);
        OPTIMIZED_ARRAY_ROW_CREATION++;
    L11:
        SolverVariable.increaseErrorId();
        return r10;
    L10:
        r10.reset();
        goto L11
    L7:
        r10 = this.mCache.arrayRowPool.acquire();
        if (r10 != null) goto L10;
        r10 = new ArrayRow(this.mCache);
        ARRAY_ROW_CREATION++;
        goto L11
    }

    public SolverVariable createSlackVariable() {
        Metrics r10 = sMetrics;
        if (r10 == null) goto L6;
        r10.slackvariables++;
    L6:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L8;
        increaseTableSize();
    L8:
        SolverVariable r11 = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int r12 = this.mVariablesID + 1;
        this.mVariablesID = r12;
        this.mNumColumns++;
        r11.id = r12;
        this.mCache.mIndexedVariables[r12] = r11;
        return r11;
    }

    public void displayReadableRows() {
        displaySolverVariables();
        String r10 = " num vars " + this.mVariablesID + "\n";
        int r11 = 0;
        int r12 = 0;
    L4:
        if (r12 >= (this.mVariablesID + 1)) goto L11;
        SolverVariable r13 = this.mCache.mIndexedVariables[r12];
        if (r13 == null) goto L10;
        if (r13.isFinalValue == false) goto L10;
        r10 = r10 + " $[" + r12 + "] => " + r13 + " = " + r13.computedValue + "\n";
    L10:
        r12 = r12 + 1;
        goto L4
    L11:
        String r14 = r10 + "\n";
        int r15 = 0;
    L13:
        if (r15 >= (this.mVariablesID + 1)) goto L20;
        SolverVariable[] r16 = this.mCache.mIndexedVariables;
        SolverVariable r17 = r16[r15];
        if (r17 == null) goto L19;
        if (r17.isSynonym == false) goto L19;
        r14 = r14 + " ~[" + r15 + "] => " + r17 + " = " + r16[r17.synonym] + " + " + r17.synonymDelta + "\n";
    L19:
        r15 = r15 + 1;
        goto L13
    L20:
        String r18 = r14 + "\n\n #  ";
    L22:
        if (r11 >= this.mNumRows) goto L25;
        r18 = (r18 + this.mRows[r11].toReadableString()) + "\n #  ";
        r11 = r11 + 1;
        goto L22
    L25:
        if (this.mGoal == null) goto L27;
        r18 = r18 + "Goal: " + this.mGoal + "\n";
    L27:
        System.out.println(r18);
    }

    void displaySystemInformation() {
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r10 >= this.TABLE_SIZE) goto L9;
        ArrayRow[] r12 = this.mRows;
        if (r12[r10] == null) goto L8;
        r11 = r11 + r12[r10].sizeInBytes();
    L8:
        r10 = r10 + 1;
        goto L4
    L9:
        int r13 = 0;
        int r14 = 0;
    L11:
        if (r13 >= this.mNumRows) goto L16;
        ArrayRow[] r15 = this.mRows;
        if (r15[r13] == null) goto L15;
        r14 = r14 + r15[r13].sizeInBytes();
    L15:
        r13 = r13 + 1;
        goto L11
    L16:
        PrintStream r16 = System.out;
        StringBuilder r17 = new StringBuilder();
        r17.append("Linear System -> Table size: ");
        r17.append(this.TABLE_SIZE);
        r17.append(" (");
        int r18 = this.TABLE_SIZE;
        r17.append(getDisplaySize(r18 * r18));
        r17.append(") -- row sizes: ");
        r17.append(getDisplaySize(r11));
        r17.append(", actual size: ");
        r17.append(getDisplaySize(r14));
        r17.append(" rows: ");
        r17.append(this.mNumRows);
        r17.append("/");
        r17.append(this.mMaxRows);
        r17.append(" cols: ");
        r17.append(this.mNumColumns);
        r17.append("/");
        r17.append(this.mMaxColumns);
        r17.append(" ");
        r17.append(0);
        r17.append(" occupied cells, ");
        r17.append(getDisplaySize(0));
        r16.println(r17.toString());
    }

    public void displayVariablesReadableRows() {
        displaySolverVariables();
        String r10 = "";
        int r11 = 0;
    L4:
        if (r11 >= this.mNumRows) goto L9;
        if (this.mRows[r11].variable.mType != SolverVariable.Type.UNRESTRICTED) goto L8;
        r10 = (r10 + this.mRows[r11].toReadableString()) + "\n";
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        System.out.println(r10 + this.mGoal + "\n");
    }

    public void fillMetrics(Metrics r10) {
        sMetrics = r10;
    }

    public Cache getCache() {
        return this.mCache;
    }

    Row getGoal() {
        return this.mGoal;
    }

    public int getMemoryUsed() {
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r10 >= this.mNumRows) goto L9;
        ArrayRow[] r12 = this.mRows;
        if (r12[r10] == null) goto L8;
        r11 = r11 + r12[r10].sizeInBytes();
    L8:
        r10 = r10 + 1;
        goto L4
    L9:
        return r11;
    }

    public int getNumEquations() {
        return this.mNumRows;
    }

    public int getNumVariables() {
        return this.mVariablesID;
    }

    public int getObjectVariableValue(Object r10) {
        SolverVariable r11 = ((ConstraintAnchor) r10).getSolverVariable();
        if (r11 != null) goto L5;
        return 0;
    L5:
        return (int) (r11.computedValue + 0.5f);
    }

    ArrayRow getRow(int r10) {
        return this.mRows[r10];
    }

    float getValueFor(String r10) {
        SolverVariable r11 = getVariable(r10, SolverVariable.Type.UNRESTRICTED);
        if (r11 != null) goto L7;
        return 0.0f;
    L7:
        return r11.computedValue;
    }

    SolverVariable getVariable(String r10, SolverVariable.Type r11) {
        if (this.mVariables != null) goto L5;
        this.mVariables = new HashMap();
    L5:
        SolverVariable r12 = this.mVariables.get(r10);
        if (r12 == null) goto L8;
        return r12;
    L8:
        return createVariable(r10, r11);
    }

    public void minimize() {
        Metrics r10 = sMetrics;
        if (r10 == null) goto L6;
        r10.minimize++;
    L6:
        if (this.mGoal.isEmpty() == false) goto L10;
        computeValues();
        return;
    L10:
        if (this.graphOptimizer == false) goto L12;
    L15:
        Metrics r11 = sMetrics;
        if (r11 == null) goto L18;
        r11.graphOptimizer++;
    L18:
        boolean r12 = false;
        int r13 = 0;
    L20:
        if (r13 >= this.mNumRows) goto L25;
        if (this.mRows[r13].isSimpleDefinition == false) goto L26;
        r13 = r13 + 1;
    L26:
        if (r12 == false) goto L14;
        Metrics r14 = sMetrics;
        if (r14 == null) goto L31;
        r14.fullySolved++;
    L31:
        computeValues();
        return;
    L14:
        minimizeGoal(this.mGoal);
        return;
    L25:
        r12 = true;
        goto L26
    L12:
        if (this.newgraphOptimizer == false) goto L14;
        goto L14
    }

    void minimizeGoal(Row r10) {
        Metrics r11 = sMetrics;
        if (r11 == null) goto L5;
        r11.minimizeGoal++;
        r11.maxVariables = Math.max(r11.maxVariables, this.mNumColumns);
        Metrics r12 = sMetrics;
        r12.maxRows = Math.max(r12.maxRows, this.mNumRows);
    L5:
        enforceBFS(r10);
        optimize(r10, false);
        computeValues();
    }

    public void removeRow(ArrayRow r10) {
        if (r10.isSimpleDefinition == false) goto L27;
        SolverVariable r11 = r10.variable;
        if (r11 == null) goto L28;
        int r12 = r11.definitionId;
        if (r12 == (-1)) goto L15;
    L8:
        int r13 = this.mNumRows;
        if (r12 >= (r13 - 1)) goto L14;
        ArrayRow[] r14 = this.mRows;
        int r15 = r12 + 1;
        SolverVariable r16 = r14[r15].variable;
        if (r16.definitionId != r15) goto L13;
        r16.definitionId = r12;
    L13:
        r14[r12] = r14[r15];
        r12 = r15;
        goto L8
    L14:
        this.mNumRows = r13 - 1;
    L15:
        SolverVariable r17 = r10.variable;
        if (r17.isFinalValue == true) goto L18;
        r17.setFinalValue(this, r10.constantValue);
    L18:
        boolean r18 = OPTIMIZED_ENGINE;
        Cache r19 = this.mCache;
        if (r18 == false) goto L21;
        Pools.Pool<ArrayRow> r20 = r19.optimizedArrayRowPool;
    L22:
        r20.release(r10);
        return;
    L21:
        r20 = r19.arrayRowPool;
        goto L22
    L28:
        return;
    }

    public void reset() {
        int r10 = 0;
    L3:
        Cache r11 = this.mCache;
        SolverVariable[] r12 = r11.mIndexedVariables;
        if (r10 >= r12.length) goto L9;
        SolverVariable r13 = r12[r10];
        if (r13 == null) goto L8;
        r13.reset();
    L8:
        r10 = r10 + 1;
        goto L3
    L9:
        r11.solverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
        this.mPoolVariablesCount = 0;
        Arrays.fill(this.mCache.mIndexedVariables, null);
        HashMap<String, SolverVariable> r14 = this.mVariables;
        if (r14 == null) goto L12;
        r14.clear();
    L12:
        this.mVariablesID = 0;
        this.mGoal.clear();
        this.mNumColumns = 1;
        int r15 = 0;
    L14:
        if (r15 >= this.mNumRows) goto L19;
        ArrayRow[] r16 = this.mRows;
        if (r16[r15] == null) goto L18;
        r16[r15].used = false;
    L18:
        r15 = r15 + 1;
        goto L14
    L19:
        releaseRows();
        this.mNumRows = 0;
        if (OPTIMIZED_ENGINE == false) goto L22;
        Row r17 = new ValuesRow(this, this.mCache);
    L23:
        this.mTempGoal = r17;
        return;
    L22:
        r17 = new ArrayRow(this.mCache);
        goto L23
    }
}
