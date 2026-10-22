package androidx.constraintlayout.solver;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
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

    public interface Row {
        void addError(SolverVariable r5);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem r5, boolean[] r10);

        void initFromRow(Row r5);

        boolean isEmpty();

        void updateFromFinalVariable(LinearSystem r5, SolverVariable r10, boolean r11);

        void updateFromRow(LinearSystem r5, ArrayRow r10, boolean r11);

        void updateFromSystem(LinearSystem r5);
    }

    public class ValuesRow extends ArrayRow {
        final /* synthetic */ LinearSystem this$0;

        public ValuesRow(LinearSystem r5, Cache r10) {
            this.this$0 = r5;
            this.variables = new SolverVariableValues(this, r10);
        }
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
        Cache r5 = new Cache();
        this.mCache = r5;
        this.mGoal = new PriorityGoalRow(r5);
        if (OPTIMIZED_ENGINE == false) goto L5;
        this.mTempGoal = new ValuesRow(this, r5);
        return;
    L5:
        this.mTempGoal = new ArrayRow(r5);
    }

    private SolverVariable acquireSolverVariable(SolverVariable.Type r5, String r10) {
        SolverVariable r11 = this.mCache.solverVariablePool.acquire();
        if (r11 != null) goto L5;
        r11 = new SolverVariable(r5, r10);
        r11.setType(r5, r10);
    L6:
        int r12 = this.mPoolVariablesCount;
        int r13 = POOL_SIZE;
        if (r12 < r13) goto L9;
        int r14 = r13 * 2;
        POOL_SIZE = r14;
        this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, r14);
    L9:
        SolverVariable[] r15 = this.mPoolVariables;
        int r16 = this.mPoolVariablesCount;
        this.mPoolVariablesCount = r16 + 1;
        r15[r16] = r11;
        return r11;
    L5:
        r11.reset();
        r11.setType(r5, r10);
        goto L6
    }

    private void addError(ArrayRow r5) {
        r5.addError(this, 0);
    }

    private final void addRow(ArrayRow r10) {
        if (SIMPLIFY_SYNONYMS == true) goto L5;
    L7:
        ArrayRow[] r5 = this.mRows;
        int r11 = this.mNumRows;
        r5[r11] = r10;
        SolverVariable r12 = r10.variable;
        r12.definitionId = r11;
        this.mNumRows = r11 + 1;
        r12.updateReferencesWithNewDefinition(this, r10);
    L9:
        if (SIMPLIFY_SYNONYMS == true) goto L11;
        return;
    L11:
        if (this.hasSimpleDefinition == false) goto L47;
        int r13 = 0;
    L14:
        if (r13 >= this.mNumRows) goto L37;
        if (this.mRows[r13] != null) goto L18;
        System.out.println("WTF");
    L18:
        ArrayRow r14 = this.mRows[r13];
        if (r14 == null) goto L36;
        if (r14.isSimpleDefinition == false) goto L36;
        r14.variable.setFinalValue(this, r14.constantValue);
        if (OPTIMIZED_ENGINE == false) goto L25;
        this.mCache.optimizedArrayRowPool.release(r14);
    L26:
        this.mRows[r13] = null;
        int r15 = r13 + 1;
        int r16 = r15;
    L27:
        int r17 = this.mNumRows;
        if (r15 >= r17) goto L33;
        ArrayRow[] r18 = this.mRows;
        int r19 = r15 - 1;
        ArrayRow r20 = r18[r15];
        r18[r19] = r20;
        SolverVariable r21 = r20.variable;
        if (r21.definitionId != r15) goto L32;
        r21.definitionId = r19;
    L32:
        r16 = r15;
        r15 = r15 + 1;
        goto L27
    L33:
        if (r16 >= r17) goto L35;
        this.mRows[r16] = null;
    L35:
        this.mNumRows = r17 - 1;
        r13 = r13 - 1;
        goto L36
    L25:
        this.mCache.arrayRowPool.release(r14);
    L36:
        r13 = r13 + 1;
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

    private void addSingleError(ArrayRow r5, int r10) {
        addSingleError(r5, r10, 0);
    }

    private void computeValues() {
        int r5 = 0;
    L4:
        if (r5 >= this.mNumRows) goto L6;
        ArrayRow r10 = this.mRows[r5];
        SolverVariable r11 = r10.variable;
        r11.computedValue = r10.constantValue;
        r5 = r5 + 1;
        goto L4
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem r5, SolverVariable r10, SolverVariable r11, float r12) {
        return r5.createRow().createRowDimensionPercent(r10, r11, r12);
    }

    private SolverVariable createVariable(String r10, SolverVariable.Type r11) {
        Metrics r5 = sMetrics;
        if (r5 == null) goto L6;
        r5.variables++;
    L6:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L8;
        increaseTableSize();
    L8:
        SolverVariable r12 = acquireSolverVariable(r11, null);
        r12.setName(r10);
        int r13 = this.mVariablesID + 1;
        this.mVariablesID = r13;
        this.mNumColumns++;
        r12.f437id = r13;
        if (this.mVariables != null) goto L11;
        this.mVariables = new HashMap();
    L11:
        this.mVariables.put(r10, r12);
        this.mCache.mIndexedVariables[this.mVariablesID] = r12;
        return r12;
    }

    private void displayRows() {
        displaySolverVariables();
        String r5 = "";
        int r10 = 0;
    L4:
        if (r10 >= this.mNumRows) goto L6;
        StringBuilder r11 = j0.u(r5);
        r11.append(this.mRows[r10]);
        r5 = j0.j(r11.toString(), "\n");
        r10 = r10 + 1;
        goto L4
    L6:
        StringBuilder r12 = j0.u(r5);
        r12.append(this.mGoal);
        r12.append("\n");
        String r13 = r12.toString();
        System.out.println(r13);
    }

    private void displaySolverVariables() {
        StringBuilder r5 = new StringBuilder("Display Rows (");
        r5.append(this.mNumRows);
        r5.append("x");
        String r10 = a.s(r5, this.mNumColumns, ")\n");
        System.out.println(r10);
    }

    private int enforceBFS(Row r20) throws Exception {
        int r5 = 0;
    L4:
        if (r5 >= this.mNumRows) goto L69;
        ArrayRow r10 = this.mRows[r5];
        if (r10.variable.mType == SolverVariable.Type.UNRESTRICTED) goto L68;
        if (r10.constantValue >= 0.0f) goto L68;
        boolean r11 = false;
        int r12 = 0;
    L11:
        if (r11 == true) goto L94;
        Metrics r13 = sMetrics;
        if (r13 == null) goto L15;
        r13.bfs++;
    L15:
        r12 = r12 + 1;
        float r14 = Float.MAX_VALUE;
        int r15 = 0;
        int r16 = -1;
        int r17 = -1;
        int r18 = 0;
    L16:
        int r19 = 1;
        if (r15 >= this.mNumRows) goto L58;
        ArrayRow r110 = this.mRows[r15];
        if (r110.variable.mType == SolverVariable.Type.UNRESTRICTED) goto L56;
        if (r110.isSimpleDefinition == true) goto L56;
        if (r110.constantValue >= 0.0f) goto L56;
        int r111 = 9;
        if (SKIP_COLUMNS == false) goto L43;
        int r21 = r110.variables.getCurrentSize();
        int r112 = 0;
    L29:
        if (r112 >= r21) goto L56;
        SolverVariable r22 = r110.variables.getVariable(r112);
        float r23 = r110.variables.get(r22);
        if (r23 <= 0.0f) goto L41;
        int r24 = 0;
    L34:
        if (r24 >= r111) goto L41;
        float r113 = r22.strengthVector[r24] / r23;
        if (r113 >= r14) goto L38;
        if (r24 != r18) goto L38;
    L39:
        r18 = r24;
        r17 = r22.f437id;
        r16 = r15;
        r14 = r113;
    L40:
        r24 = r24 + 1;
        r111 = 9;
    L38:
        if (r24 <= r18) goto L40;
    L41:
        r112 = r112 + 1;
        r111 = 9;
    L43:
        if (r19 >= this.mNumColumns) goto L56;
        SolverVariable r25 = this.mCache.mIndexedVariables[r19];
        float r26 = r110.variables.get(r25);
        if (r26 <= 0.0f) goto L55;
        int r27 = 0;
    L48:
        if (r27 >= 9) goto L55;
        float r114 = r25.strengthVector[r27] / r26;
        if (r114 >= r14) goto L52;
        if (r27 != r18) goto L52;
    L53:
        r18 = r27;
        r16 = r15;
        r17 = r19;
        r14 = r114;
    L54:
        r27 = r27 + 1;
    L52:
        if (r27 <= r18) goto L54;
    L55:
        r19 = r19 + 1;
    L56:
        r15 = r15 + 1;
        goto L16
    L58:
        if (r16 == (-1)) goto L63;
        ArrayRow r28 = this.mRows[r16];
        r28.variable.definitionId = -1;
        Metrics r29 = sMetrics;
        if (r29 == null) goto L62;
        r29.pivots++;
    L62:
        r28.pivot(this.mCache.mIndexedVariables[r17]);
        SolverVariable r30 = r28.variable;
        r30.definitionId = r16;
        r30.updateReferencesWithNewDefinition(this, r28);
    L65:
        if (r12 <= (this.mNumColumns / 2)) goto L11;
        r11 = true;
        goto L11
    L63:
        r11 = true;
        goto L65
    L94:
        return r12;
    L68:
        r5 = r5 + 1;
        goto L4
    L69:
        return 0;
    }

    private String getDisplaySize(int r5) {
        int r10 = r5 * 4;
        int r11 = r10 / 1024;
        int r12 = r11 / 1024;
        if (r12 > 0) goto L5;
        if (r11 <= 0) goto L10;
        return j0.h(r11, "", " Kb");
    L10:
        return j0.h(r10, "", " bytes");
    L5:
        return j0.h(r12, "", " Mb");
    }

    private String getDisplayStrength(int r5) {
        if (r5 != 1) goto L7;
        return "LOW";
    L7:
        if (r5 != 2) goto L11;
        return "MEDIUM";
    L11:
        if (r5 != 3) goto L15;
        return "HIGH";
    L15:
        if (r5 != 4) goto L19;
        return "HIGHEST";
    L19:
        if (r5 != 5) goto L23;
        return "EQUALITY";
    L23:
        if (r5 != 8) goto L27;
        return "FIXED";
    L27:
        if (r5 != 6) goto L30;
        return "BARRIER";
    L30:
        return "NONE";
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    private void increaseTableSize() {
        int r5 = this.TABLE_SIZE * 2;
        this.TABLE_SIZE = r5;
        this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, r5);
        Cache r10 = this.mCache;
        r10.mIndexedVariables = (SolverVariable[]) Arrays.copyOf(r10.mIndexedVariables, this.TABLE_SIZE);
        int r11 = this.TABLE_SIZE;
        this.mAlreadyTestedCandidates = new boolean[r11];
        this.mMaxColumns = r11;
        this.mMaxRows = r11;
        Metrics r12 = sMetrics;
        if (r12 == null) goto L6;
        r12.tableSizeIncrease++;
        r12.maxTableSize = Math.max(r12.maxTableSize, r11);
        Metrics r13 = sMetrics;
        r13.lastTableSize = r13.maxTableSize;
        return;
    }

    private final int optimize(Row r13, boolean r14) {
        Metrics r15 = sMetrics;
        if (r15 == null) goto L5;
        r15.optimize++;
    L5:
        int r5 = 0;
    L7:
        if (r5 >= this.mNumColumns) goto L9;
        this.mAlreadyTestedCandidates[r5] = false;
        r5 = r5 + 1;
        goto L7
    L9:
        boolean r10 = false;
        int r11 = 0;
    L10:
        if (r10 == true) goto L50;
        Metrics r12 = sMetrics;
        if (r12 == null) goto L14;
        r12.iterations++;
    L14:
        r11 = r11 + 1;
        if (r11 >= (this.mNumColumns * 2)) goto L16;
        if (r13.getKey() == null) goto L20;
        this.mAlreadyTestedCandidates[r13.getKey().f437id] = true;
    L20:
        SolverVariable r16 = r13.getPivotCandidate(this, this.mAlreadyTestedCandidates);
        if (r16 == null) goto L26;
        boolean[] r17 = this.mAlreadyTestedCandidates;
        int r18 = r16.f437id;
        if (r17[r18] == true) goto L24;
        r17[r18] = true;
        goto L26
    L24:
        return r11;
    L26:
        if (r16 != null) goto L27;
        r10 = true;
        goto L10
    L27:
        float r19 = Float.MAX_VALUE;
        int r20 = 0;
        int r21 = -1;
    L29:
        if (r20 >= this.mNumRows) goto L44;
        ArrayRow r22 = this.mRows[r20];
        if (r22.variable.mType == SolverVariable.Type.UNRESTRICTED) goto L43;
        if (r22.isSimpleDefinition == true) goto L43;
        if (r22.hasVariable(r16) == false) goto L43;
        float r110 = r22.variables.get(r16);
        if (r110 >= 0.0f) goto L43;
        float r23 = (-r22.constantValue) / r110;
        if (r23 >= r19) goto L43;
        r21 = r20;
        r19 = r23;
    L43:
        r20 = r20 + 1;
        goto L29
    L44:
        if (r21 <= (-1)) goto L10;
        ArrayRow r24 = this.mRows[r21];
        r24.variable.definitionId = -1;
        Metrics r25 = sMetrics;
        if (r25 == null) goto L48;
        r25.pivots++;
    L48:
        r24.pivot(r16);
        SolverVariable r26 = r24.variable;
        r26.definitionId = r21;
        r26.updateReferencesWithNewDefinition(this, r24);
        goto L10
    L16:
        return r11;
    L50:
        return r11;
    }

    private void releaseRows() {
        int r5 = 0;
        if (OPTIMIZED_ENGINE == false) goto L11;
    L5:
        if (r5 >= this.mNumRows) goto L16;
        ArrayRow r10 = this.mRows[r5];
        if (r10 == null) goto L9;
        this.mCache.optimizedArrayRowPool.release(r10);
    L9:
        this.mRows[r5] = null;
        r5 = r5 + 1;
        goto L5
    L16:
        return;
    L11:
        if (r5 >= this.mNumRows) goto L23;
        ArrayRow r11 = this.mRows[r5];
        if (r11 == null) goto L15;
        this.mCache.arrayRowPool.release(r11);
    L15:
        this.mRows[r5] = null;
        r5 = r5 + 1;
        goto L11
    }

    public void addCenterPoint(ConstraintWidget r17, ConstraintWidget r18, float r19, int r20) {
        ConstraintAnchor.Type r5 = ConstraintAnchor.Type.LEFT;
        SolverVariable r10 = createObjectVariable(r17.getAnchor(r5));
        ConstraintAnchor.Type r11 = ConstraintAnchor.Type.TOP;
        SolverVariable r12 = createObjectVariable(r17.getAnchor(r11));
        ConstraintAnchor.Type r13 = ConstraintAnchor.Type.RIGHT;
        SolverVariable r14 = createObjectVariable(r17.getAnchor(r13));
        ConstraintAnchor.Type r15 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable r16 = createObjectVariable(r17.getAnchor(r15));
        SolverVariable r21 = createObjectVariable(r18.getAnchor(r5));
        SolverVariable r110 = createObjectVariable(r18.getAnchor(r11));
        SolverVariable r22 = createObjectVariable(r18.getAnchor(r13));
        SolverVariable r111 = createObjectVariable(r18.getAnchor(r15));
        ArrayRow r23 = createRow();
        double r24 = r19;
        double r25 = r20;
        r23.createRowWithAngle(r12, r16, r110, r111, (float) (Math.sin(r24) * r25));
        addConstraint(r23);
        ArrayRow r26 = createRow();
        r26.createRowWithAngle(r10, r14, r21, r22, (float) (Math.cos(r24) * r25));
        addConstraint(r26);
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
        Metrics r5 = sMetrics;
        if (r5 == null) goto L9;
        r5.constraints++;
        if (r10.isSimpleDefinition == false) goto L9;
        r5.simpleconstraints++;
    L9:
        boolean r11 = true;
        if ((this.mNumRows + 1) < this.mMaxRows) goto L12;
    L13:
        increaseTableSize();
    L14:
        boolean r12 = false;
        if (r10.isSimpleDefinition == true) goto L46;
        r10.updateFromSystem(this);
        if (r10.isEmpty() == false) goto L19;
        return;
    L19:
        r10.ensurePositiveConstant();
        if (r10.chooseSubject(this) == false) goto L41;
        SolverVariable r13 = createExtraVariable();
        r10.variable = r13;
        int r14 = this.mNumRows;
        addRow(r10);
        if (this.mNumRows != (r14 + 1)) goto L41;
        this.mTempGoal.initFromRow(r10);
        optimize(this.mTempGoal, true);
        if (r13.definitionId != (-1)) goto L43;
        if (r10.variable != r13) goto L34;
        SolverVariable r15 = r10.pickPivot(r13);
        if (r15 == null) goto L34;
        Metrics r16 = sMetrics;
        if (r16 == null) goto L32;
        r16.pivots++;
    L32:
        r10.pivot(r15);
    L34:
        if (r10.isSimpleDefinition == true) goto L37;
        r10.variable.updateReferencesWithNewDefinition(this, r10);
    L37:
        if (OPTIMIZED_ENGINE == false) goto L39;
        this.mCache.optimizedArrayRowPool.release(r10);
    L40:
        this.mNumRows--;
        goto L43
    L39:
        this.mCache.arrayRowPool.release(r10);
    L43:
        if (r10.hasKeyVariable() == true) goto L45;
        return;
    L45:
        r12 = r11;
    L41:
        r11 = false;
    L46:
        if (r12 == true) goto L49;
        addRow(r10);
        return;
    L49:
        return;
    L12:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L14;
        goto L13
    }

    public ArrayRow addEquality(SolverVariable r5, SolverVariable r10, int r11, int r12) {
        if (USE_BASIC_SYNONYMS == false) goto L11;
        if (r12 != 8) goto L11;
        if (r10.isFinalValue == false) goto L11;
        if (r5.definitionId != (-1)) goto L11;
        r5.setFinalValue(this, r10.computedValue + r11);
        return null;
    L11:
        ArrayRow r13 = createRow();
        r13.createRowEquals(r5, r10, r11);
        if (r12 == 8) goto L14;
        r13.addError(this, r12);
    L14:
        addConstraint(r13);
        return r13;
    }

    public void addGreaterBarrier(SolverVariable r5, SolverVariable r10, int r11, boolean r12) {
        ArrayRow r13 = createRow();
        SolverVariable r14 = createSlackVariable();
        r14.strength = 0;
        r13.createRowGreaterThan(r5, r10, r14, r11);
        addConstraint(r13);
    }

    public void addGreaterThan(SolverVariable r5, SolverVariable r10, int r11, int r12) {
        ArrayRow r13 = createRow();
        SolverVariable r14 = createSlackVariable();
        r14.strength = 0;
        r13.createRowGreaterThan(r5, r10, r14, r11);
        if (r12 == 8) goto L5;
        addSingleError(r13, (int) (r13.variables.get(r14) * (-1.0f)), r12);
    L5:
        addConstraint(r13);
    }

    public void addLowerBarrier(SolverVariable r5, SolverVariable r10, int r11, boolean r12) {
        ArrayRow r13 = createRow();
        SolverVariable r14 = createSlackVariable();
        r14.strength = 0;
        r13.createRowLowerThan(r5, r10, r14, r11);
        addConstraint(r13);
    }

    public void addLowerThan(SolverVariable r5, SolverVariable r10, int r11, int r12) {
        ArrayRow r13 = createRow();
        SolverVariable r14 = createSlackVariable();
        r14.strength = 0;
        r13.createRowLowerThan(r5, r10, r14, r11);
        if (r12 == 8) goto L5;
        addSingleError(r13, (int) (r13.variables.get(r14) * (-1.0f)), r12);
    L5:
        addConstraint(r13);
    }

    public void addRatio(SolverVariable r10, SolverVariable r11, SolverVariable r12, SolverVariable r13, float r14, int r15) {
        ArrayRow r16 = createRow();
        r16.createRowDimensionRatio(r10, r11, r12, r13, r14);
        if (r15 == 8) goto L5;
        r16.addError(this, r15);
    L5:
        addConstraint(r16);
    }

    public void addSynonym(SolverVariable r5, SolverVariable r10, int r11) {
        if (r5.definitionId != (-1)) goto L12;
        if (r11 != 0) goto L12;
        if (r10.isSynonym == false) goto L9;
        r10 = this.mCache.mIndexedVariables[r10.synonym];
    L9:
        if (r5.isSynonym == false) goto L11;
        SolverVariable r12 = this.mCache.mIndexedVariables[r5.synonym];
        return;
    L11:
        r5.setSynonym(this, r10, 0.0f);
        return;
    L12:
        addEquality(r5, r10, r11, 8);
    }

    public final void cleanupRows() {
        int r5 = 0;
    L4:
        if (r5 >= this.mNumRows) goto L19;
        ArrayRow r10 = this.mRows[r5];
        if (r10.variables.getCurrentSize() != 0) goto L9;
        r10.isSimpleDefinition = true;
    L9:
        if (r10.isSimpleDefinition == false) goto L18;
        SolverVariable r11 = r10.variable;
        r11.computedValue = r10.constantValue;
        r11.removeFromRow(r10);
        int r12 = r5;
    L11:
        int r13 = this.mNumRows;
        if (r12 >= (r13 - 1)) goto L14;
        ArrayRow[] r14 = this.mRows;
        int r15 = r12 + 1;
        r14[r12] = r14[r15];
        r12 = r15;
        goto L11
    L14:
        this.mRows[r13 - 1] = null;
        this.mNumRows = r13 - 1;
        r5 = r5 - 1;
        if (OPTIMIZED_ENGINE == false) goto L17;
        this.mCache.optimizedArrayRowPool.release(r10);
        goto L18
    L17:
        this.mCache.arrayRowPool.release(r10);
    L18:
        r5 = r5 + 1;
        goto L4
    }

    public SolverVariable createErrorVariable(int r10, String r11) {
        Metrics r5 = sMetrics;
        if (r5 == null) goto L6;
        r5.errors++;
    L6:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L8;
        increaseTableSize();
    L8:
        SolverVariable r12 = acquireSolverVariable(SolverVariable.Type.ERROR, r11);
        int r13 = this.mVariablesID + 1;
        this.mVariablesID = r13;
        this.mNumColumns++;
        r12.f437id = r13;
        r12.strength = r10;
        this.mCache.mIndexedVariables[r13] = r12;
        this.mGoal.addError(r12);
        return r12;
    }

    public SolverVariable createExtraVariable() {
        Metrics r5 = sMetrics;
        if (r5 == null) goto L6;
        r5.extravariables++;
    L6:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L8;
        increaseTableSize();
    L8:
        SolverVariable r10 = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int r11 = this.mVariablesID + 1;
        this.mVariablesID = r11;
        this.mNumColumns++;
        r10.f437id = r11;
        this.mCache.mIndexedVariables[r11] = r10;
        return r10;
    }

    public SolverVariable createObjectVariable(Object r5) {
        SolverVariable r10 = null;
        if (r5 != null) goto L6;
        return null;
    L6:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L9;
        increaseTableSize();
    L9:
        if ((r5 instanceof ConstraintAnchor) == false) goto L22;
        ConstraintAnchor r11 = (ConstraintAnchor) r5;
        r10 = r11.getSolverVariable();
        if (r10 != null) goto L13;
        r11.resetSolverVariable(this.mCache);
        r10 = r11.getSolverVariable();
    L13:
        int r12 = r10.f437id;
        if (r12 != (-1)) goto L16;
    L19:
        if (r12 == (-1)) goto L21;
        r10.reset();
    L21:
        int r13 = this.mVariablesID + 1;
        this.mVariablesID = r13;
        this.mNumColumns++;
        r10.f437id = r13;
        r10.mType = SolverVariable.Type.UNRESTRICTED;
        this.mCache.mIndexedVariables[r13] = r10;
        goto L22
    L16:
        if (r12 > this.mVariablesID) goto L19;
        if (this.mCache.mIndexedVariables[r12] == null) goto L19;
    L22:
        return r10;
    }

    public ArrayRow createRow() {
        if (OPTIMIZED_ENGINE == false) goto L8;
        ArrayRow r5 = this.mCache.optimizedArrayRowPool.acquire();
        if (r5 != null) goto L7;
        r5 = new ValuesRow(this, this.mCache);
        OPTIMIZED_ARRAY_ROW_CREATION++;
    L12:
        SolverVariable.increaseErrorId();
        return r5;
    L7:
        r5.reset();
        goto L12
    L8:
        r5 = this.mCache.arrayRowPool.acquire();
        if (r5 != null) goto L11;
        r5 = new ArrayRow(this.mCache);
        ARRAY_ROW_CREATION++;
        goto L12
    L11:
        r5.reset();
        goto L12
    }

    public SolverVariable createSlackVariable() {
        Metrics r5 = sMetrics;
        if (r5 == null) goto L6;
        r5.slackvariables++;
    L6:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L8;
        increaseTableSize();
    L8:
        SolverVariable r10 = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int r11 = this.mVariablesID + 1;
        this.mVariablesID = r11;
        this.mNumColumns++;
        r10.f437id = r11;
        this.mCache.mIndexedVariables[r11] = r10;
        return r10;
    }

    public void displayReadableRows() {
        displaySolverVariables();
        String r5 = a.s(new StringBuilder(" num vars "), this.mVariablesID, "\n");
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r11 >= (this.mVariablesID + 1)) goto L11;
        SolverVariable r12 = this.mCache.mIndexedVariables[r11];
        if (r12 == null) goto L10;
        if (r12.isFinalValue == false) goto L10;
        StringBuilder r13 = new StringBuilder();
        r13.append(r5);
        r13.append(" $[");
        r13.append(r11);
        r13.append("] => ");
        r13.append(r12);
        r13.append(" = ");
        r5 = a.r(r13, r12.computedValue, "\n");
    L10:
        r11 = r11 + 1;
        goto L4
    L11:
        String r14 = j0.j(r5, "\n");
        int r15 = 0;
    L13:
        if (r15 >= (this.mVariablesID + 1)) goto L20;
        SolverVariable[] r16 = this.mCache.mIndexedVariables;
        SolverVariable r17 = r16[r15];
        if (r17 == null) goto L19;
        if (r17.isSynonym == false) goto L19;
        SolverVariable r18 = r16[r17.synonym];
        StringBuilder r19 = new StringBuilder();
        r19.append(r14);
        r19.append(" ~[");
        r19.append(r15);
        r19.append("] => ");
        r19.append(r17);
        r19.append(" = ");
        r19.append(r18);
        r19.append(" + ");
        r14 = a.r(r19, r17.synonymDelta, "\n");
    L19:
        r15 = r15 + 1;
        goto L13
    L20:
        String r20 = j0.j(r14, "\n\n #  ");
    L22:
        if (r10 >= this.mNumRows) goto L25;
        StringBuilder r21 = j0.u(r20);
        r21.append(this.mRows[r10].toReadableString());
        r20 = j0.j(r21.toString(), "\n #  ");
        r10 = r10 + 1;
        goto L22
    L25:
        if (this.mGoal == null) goto L27;
        StringBuilder r22 = j0.w(r20, "Goal: ");
        r22.append(this.mGoal);
        r22.append("\n");
        r20 = r22.toString();
    L27:
        System.out.println(r20);
    }

    public void displaySystemInformations() {
        int r5 = 0;
        int r10 = 0;
    L4:
        if (r5 >= this.TABLE_SIZE) goto L9;
        ArrayRow r11 = this.mRows[r5];
        if (r11 == null) goto L8;
        r10 = r10 + r11.sizeInBytes();
    L8:
        r5 = r5 + 1;
        goto L4
    L9:
        int r12 = 0;
        int r13 = 0;
    L11:
        if (r12 >= this.mNumRows) goto L16;
        ArrayRow r14 = this.mRows[r12];
        if (r14 == null) goto L15;
        r13 = r13 + r14.sizeInBytes();
    L15:
        r12 = r12 + 1;
        goto L11
    L16:
        PrintStream r15 = System.out;
        StringBuilder r16 = new StringBuilder("Linear System -> Table size: ");
        r16.append(this.TABLE_SIZE);
        r16.append(" (");
        int r17 = this.TABLE_SIZE;
        r16.append(getDisplaySize(r17 * r17));
        r16.append(") -- row sizes: ");
        r16.append(getDisplaySize(r10));
        r16.append(", actual size: ");
        r16.append(getDisplaySize(r13));
        r16.append(" rows: ");
        r16.append(this.mNumRows);
        r16.append("/");
        r16.append(this.mMaxRows);
        r16.append(" cols: ");
        r16.append(this.mNumColumns);
        r16.append("/");
        r16.append(this.mMaxColumns);
        r16.append(" 0 occupied cells, ");
        r16.append(getDisplaySize(0));
        r15.println(r16.toString());
    }

    public void displayVariablesReadableRows() {
        displaySolverVariables();
        String r5 = "";
        int r10 = 0;
    L4:
        if (r10 >= this.mNumRows) goto L9;
        if (this.mRows[r10].variable.mType != SolverVariable.Type.UNRESTRICTED) goto L8;
        StringBuilder r11 = j0.u(r5);
        r11.append(this.mRows[r10].toReadableString());
        r5 = j0.j(r11.toString(), "\n");
    L8:
        r10 = r10 + 1;
        goto L4
    L9:
        StringBuilder r12 = j0.u(r5);
        r12.append(this.mGoal);
        r12.append("\n");
        String r13 = r12.toString();
        System.out.println(r13);
    }

    public void fillMetrics(Metrics r5) {
        sMetrics = r5;
    }

    public Cache getCache() {
        return this.mCache;
    }

    public Row getGoal() {
        return this.mGoal;
    }

    public int getMemoryUsed() {
        int r5 = 0;
        int r10 = 0;
    L4:
        if (r5 >= this.mNumRows) goto L9;
        ArrayRow r11 = this.mRows[r5];
        if (r11 == null) goto L8;
        r10 = r11.sizeInBytes() + r10;
    L8:
        r5 = r5 + 1;
        goto L4
    L9:
        return r10;
    }

    public int getNumEquations() {
        return this.mNumRows;
    }

    public int getNumVariables() {
        return this.mVariablesID;
    }

    public int getObjectVariableValue(Object r5) {
        SolverVariable r10 = ((ConstraintAnchor) r5).getSolverVariable();
        if (r10 != null) goto L5;
        return 0;
    L5:
        return (int) (r10.computedValue + 0.5f);
    }

    public ArrayRow getRow(int r5) {
        return this.mRows[r5];
    }

    public float getValueFor(String r5) {
        SolverVariable r10 = getVariable(r5, SolverVariable.Type.UNRESTRICTED);
        if (r10 != null) goto L7;
        return 0.0f;
    L7:
        return r10.computedValue;
    }

    public SolverVariable getVariable(String r5, SolverVariable.Type r10) {
        if (this.mVariables != null) goto L5;
        this.mVariables = new HashMap();
    L5:
        SolverVariable r11 = this.mVariables.get(r5);
        if (r11 == null) goto L8;
        return r11;
    L8:
        return createVariable(r5, r10);
    }

    public void minimize() throws Exception {
        Metrics r5 = sMetrics;
        if (r5 == null) goto L6;
        r5.minimize++;
    L6:
        if (this.mGoal.isEmpty() == false) goto L10;
        computeValues();
        return;
    L10:
        if (this.graphOptimizer == false) goto L12;
    L15:
        Metrics r10 = sMetrics;
        if (r10 == null) goto L18;
        r10.graphOptimizer++;
    L18:
        int r11 = 0;
    L20:
        if (r11 >= this.mNumRows) goto L25;
        if (this.mRows[r11].isSimpleDefinition == false) goto L23;
        r11 = r11 + 1;
        goto L20
    L23:
        minimizeGoal(this.mGoal);
        return;
    L25:
        Metrics r12 = sMetrics;
        if (r12 == null) goto L28;
        r12.fullySolved++;
    L28:
        computeValues();
        return;
    L12:
        if (this.newgraphOptimizer == true) goto L15;
        minimizeGoal(this.mGoal);
    }

    public void minimizeGoal(Row r10) throws Exception {
        Metrics r5 = sMetrics;
        if (r5 == null) goto L5;
        r5.minimizeGoal++;
        r5.maxVariables = Math.max(r5.maxVariables, this.mNumColumns);
        Metrics r11 = sMetrics;
        r11.maxRows = Math.max(r11.maxRows, this.mNumRows);
    L5:
        enforceBFS(r10);
        optimize(r10, false);
        computeValues();
    }

    public void removeRow(ArrayRow r10) {
        if (r10.isSimpleDefinition == false) goto L26;
        SolverVariable r5 = r10.variable;
        if (r5 == null) goto L27;
        int r11 = r5.definitionId;
        if (r11 == (-1)) goto L15;
    L8:
        int r12 = this.mNumRows;
        if (r11 >= (r12 - 1)) goto L14;
        ArrayRow[] r13 = this.mRows;
        int r14 = r11 + 1;
        ArrayRow r15 = r13[r14];
        SolverVariable r16 = r15.variable;
        if (r16.definitionId != r14) goto L13;
        r16.definitionId = r11;
    L13:
        r13[r11] = r15;
        r11 = r14;
        goto L8
    L14:
        this.mNumRows = r12 - 1;
    L15:
        SolverVariable r17 = r10.variable;
        if (r17.isFinalValue == true) goto L19;
        r17.setFinalValue(this, r10.constantValue);
    L19:
        if (OPTIMIZED_ENGINE == false) goto L21;
        this.mCache.optimizedArrayRowPool.release(r10);
        return;
    L21:
        this.mCache.arrayRowPool.release(r10);
        return;
    L27:
        return;
    }

    public void reset() {
        int r5 = 0;
    L3:
        Cache r10 = this.mCache;
        SolverVariable[] r11 = r10.mIndexedVariables;
        if (r5 >= r11.length) goto L9;
        SolverVariable r12 = r11[r5];
        if (r12 == null) goto L8;
        r12.reset();
    L8:
        r5 = r5 + 1;
        goto L3
    L9:
        r10.solverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
        this.mPoolVariablesCount = 0;
        Arrays.fill(this.mCache.mIndexedVariables, null);
        HashMap<String, SolverVariable> r13 = this.mVariables;
        if (r13 == null) goto L12;
        r13.clear();
    L12:
        this.mVariablesID = 0;
        this.mGoal.clear();
        this.mNumColumns = 1;
        int r14 = 0;
    L14:
        if (r14 >= this.mNumRows) goto L19;
        ArrayRow r15 = this.mRows[r14];
        if (r15 == null) goto L18;
        r15.used = false;
    L18:
        r14 = r14 + 1;
        goto L14
    L19:
        releaseRows();
        this.mNumRows = 0;
        if (OPTIMIZED_ENGINE == false) goto L22;
        this.mTempGoal = new ValuesRow(this, this.mCache);
        return;
    L22:
        this.mTempGoal = new ArrayRow(this.mCache);
    }

    public void addSingleError(ArrayRow r5, int r10, int r11) {
        r5.addSingleError(createErrorVariable(r11, null), r10);
    }

    public void addEquality(SolverVariable r10, int r11) {
        if (USE_BASIC_SYNONYMS == true) goto L5;
    L18:
        int r5 = r10.definitionId;
        if (r5 == (-1)) goto L27;
        ArrayRow r12 = this.mRows[r5];
        if (r12.isSimpleDefinition == false) goto L24;
        r12.constantValue = r11;
        return;
    L24:
        if (r12.variables.getCurrentSize() != 0) goto L26;
        r12.isSimpleDefinition = true;
        r12.constantValue = r11;
        return;
    L26:
        ArrayRow r13 = createRow();
        r13.createRowEquals(r10, r11);
        addConstraint(r13);
        return;
    L27:
        ArrayRow r14 = createRow();
        r14.createRowDefinition(r10, r11);
        addConstraint(r14);
        return;
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
        if (r17.synonym != r10.f437id) goto L16;
        r17.setFinalValue(this, r17.synonymDelta + r15);
    L16:
        r16 = r16 + 1;
        goto L8
    }
}
