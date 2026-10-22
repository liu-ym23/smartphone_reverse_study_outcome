package androidx.constraintlayout.core;

import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class SolverVariable implements Comparable<SolverVariable> {
    private static final boolean INTERNAL_DEBUG = false;
    static final int MAX_STRENGTH = 9;
    public static final int STRENGTH_BARRIER = 6;
    public static final int STRENGTH_CENTERING = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 8;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    private static final boolean VAR_USE_HASH = false;
    private static int uniqueConstantId = 1;
    private static int uniqueErrorId = 1;
    private static int uniqueId = 1;
    private static int uniqueSlackId = 1;
    private static int uniqueUnrestrictedId = 1;
    public float computedValue;
    int definitionId;
    float[] goalStrengthVector;
    public int id;
    public boolean inGoal;
    HashSet<ArrayRow> inRows;
    public boolean isFinalValue;
    boolean isSynonym;
    ArrayRow[] mClientEquations;
    int mClientEquationsCount;
    private String mName;
    Type mType;
    public int strength;
    float[] strengthVector;
    int synonym;
    float synonymDelta;
    public int usageInRowCount;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.SolverVariable$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$SolverVariable$Type = null;

        static {
            int[] r10 = new int[Type.values().length];
            $SwitchMap$androidx$constraintlayout$core$SolverVariable$Type = r10;
            r10[Type.UNRESTRICTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$constraintlayout$core$SolverVariable$Type[Type.CONSTANT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$constraintlayout$core$SolverVariable$Type[Type.SLACK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$androidx$constraintlayout$core$SolverVariable$Type[Type.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$androidx$constraintlayout$core$SolverVariable$Type[Type.UNKNOWN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type CONSTANT = null;
        public static final Type ERROR = null;
        public static final Type SLACK = null;
        public static final Type UNKNOWN = null;
        public static final Type UNRESTRICTED = null;

        static {
            Type r10 = new Type("UNRESTRICTED", 0);
            UNRESTRICTED = r10;
            Type r11 = new Type("CONSTANT", 1);
            CONSTANT = r11;
            Type r12 = new Type("SLACK", 2);
            SLACK = r12;
            Type r13 = new Type("ERROR", 3);
            ERROR = r13;
            Type r14 = new Type("UNKNOWN", 4);
            UNKNOWN = r14;
            $VALUES = new Type[]{r10, r11, r12, r13, r14};
        }

        private Type(String r10, int r11) {
            super(r10, r11);
        }

        public static Type valueOf(String r10) {
            return (Type) Enum.valueOf(Type.class, r10);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    static {
    }

    public SolverVariable(Type r10, String r11) {
        this.id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.strengthVector = new float[9];
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        this.inRows = null;
        this.mType = r10;
    }

    public SolverVariable(String r10, Type r11) {
        this.id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.strengthVector = new float[9];
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        this.inRows = null;
        this.mName = r10;
        this.mType = r11;
    }

    private static String getUniqueName(Type r10, String r11) {
        if (r11 == null) goto L6;
        StringBuilder r12 = new StringBuilder();
        r12.append(r11);
        int r13 = uniqueErrorId;
    L4:
        r12.append(r13);
        return r12.toString();
    L6:
        int r14 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$SolverVariable$Type[r10.ordinal()];
        if (r14 != 1) goto L9;
        r12 = new StringBuilder();
        r12.append("U");
        r13 = uniqueUnrestrictedId + 1;
        uniqueUnrestrictedId = r13;
        goto L4
    L9:
        if (r14 != 2) goto L11;
        r12 = new StringBuilder();
        r12.append("C");
        r13 = uniqueConstantId + 1;
        uniqueConstantId = r13;
        goto L4
    L11:
        if (r14 != 3) goto L13;
        r12 = new StringBuilder();
        r12.append("S");
        r13 = uniqueSlackId + 1;
        uniqueSlackId = r13;
        goto L4
    L13:
        if (r14 != 4) goto L15;
        r12 = new StringBuilder();
        r12.append("e");
        r13 = uniqueErrorId + 1;
        uniqueErrorId = r13;
        goto L4
    L15:
        if (r14 != 5) goto L18;
        r12 = new StringBuilder();
        r12.append("V");
        r13 = uniqueId + 1;
        uniqueId = r13;
        goto L4
    L18:
        throw new AssertionError(r10.name());
    }

    static void increaseErrorId() {
        uniqueErrorId++;
    }

    public final void addToRow(ArrayRow r10) {
        int r11 = 0;
    L3:
        int r12 = this.mClientEquationsCount;
        if (r11 >= r12) goto L9;
        if (this.mClientEquations[r11] == r10) goto L7;
        r11 = r11 + 1;
        goto L3
    L7:
        return;
    L9:
        ArrayRow[] r13 = this.mClientEquations;
        if (r12 < r13.length) goto L12;
        this.mClientEquations = (ArrayRow[]) Arrays.copyOf(r13, r13.length * 2);
    L12:
        ArrayRow[] r14 = this.mClientEquations;
        int r15 = this.mClientEquationsCount;
        r14[r15] = r10;
        this.mClientEquationsCount = r15 + 1;
    }

    void clearStrengths() {
        int r10 = 0;
    L4:
        if (r10 >= 9) goto L6;
        this.strengthVector[r10] = 0.0f;
        r10 = r10 + 1;
        goto L4
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(SolverVariable r10) {
        return this.id - r10.id;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(SolverVariable r10) {
        return compareTo2(r10);
    }

    public String getName() {
        return this.mName;
    }

    public final void removeFromRow(ArrayRow r10) {
        int r11 = this.mClientEquationsCount;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L12;
        if (this.mClientEquations[r12] == r10) goto L7;
        r12 = r12 + 1;
    L7:
        if (r12 >= (r11 - 1)) goto L9;
        ArrayRow[] r13 = this.mClientEquations;
        int r14 = r12 + 1;
        r13[r12] = r13[r14];
        r12 = r14;
        goto L7
    L9:
        this.mClientEquationsCount--;
        return;
    }

    public void reset() {
        this.mName = null;
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.id = -1;
        this.definitionId = -1;
        this.computedValue = 0.0f;
        this.isFinalValue = false;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        int r10 = this.mClientEquationsCount;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.mClientEquations[r11] = null;
        r11 = r11 + 1;
        goto L3
    L5:
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inGoal = false;
        Arrays.fill(this.goalStrengthVector, 0.0f);
    }

    public void setFinalValue(LinearSystem r10, float r11) {
        this.computedValue = r11;
        this.isFinalValue = true;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        int r12 = this.mClientEquationsCount;
        this.definitionId = -1;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        this.mClientEquations[r13].updateFromFinalVariable(r10, this, false);
        r13 = r13 + 1;
        goto L3
    L5:
        this.mClientEquationsCount = 0;
    }

    public void setName(String r10) {
        this.mName = r10;
    }

    public void setSynonym(LinearSystem r10, SolverVariable r11, float r12) {
        this.isSynonym = true;
        this.synonym = r11.id;
        this.synonymDelta = r12;
        int r13 = this.mClientEquationsCount;
        this.definitionId = -1;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        this.mClientEquations[r14].updateFromSynonymVariable(r10, this, false);
        r14 = r14 + 1;
        goto L3
    L5:
        this.mClientEquationsCount = 0;
        r10.displayReadableRows();
    }

    public void setType(Type r10, String r11) {
        this.mType = r10;
    }

    String strengthsToString() {
        String r10 = this + "[";
        boolean r11 = true;
        int r12 = 0;
        boolean r13 = false;
    L4:
        if (r12 >= this.strengthVector.length) goto L19;
        String r14 = r10 + this.strengthVector[r12];
        float[] r15 = this.strengthVector;
        if (r15[r12] <= 0.0f) goto L9;
        r13 = false;
    L12:
        if (r15[r12] == 0.0f) goto L15;
        r11 = false;
    L15:
        if (r12 >= (r15.length - 1)) goto L17;
        StringBuilder r16 = new StringBuilder();
        r16.append(r14);
        String r17 = ", ";
    L18:
        r16.append(r17);
        r10 = r16.toString();
        r12 = r12 + 1;
        goto L4
    L17:
        r16 = new StringBuilder();
        r16.append(r14);
        r17 = "] ";
        goto L18
    L9:
        if (r15[r12] >= 0.0f) goto L12;
        r13 = true;
        goto L12
    L19:
        if (r13 == false) goto L21;
        r10 = r10 + " (-)";
    L21:
        if (r11 == true) goto L23;
        return r10;
    L23:
        return r10 + " (*)";
    }

    public String toString() {
        if (this.mName == null) goto L5;
        StringBuilder r10 = new StringBuilder();
        r10.append("");
        r10.append(this.mName);
    L7:
        return r10.toString();
    L5:
        r10 = new StringBuilder();
        r10.append("");
        r10.append(this.id);
        goto L7
    }

    public final void updateReferencesWithNewDefinition(LinearSystem r10, ArrayRow r11) {
        int r12 = this.mClientEquationsCount;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        this.mClientEquations[r13].updateFromRow(r10, r11, false);
        r13 = r13 + 1;
        goto L3
    L5:
        this.mClientEquationsCount = 0;
    }
}
