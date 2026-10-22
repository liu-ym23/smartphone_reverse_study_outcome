package androidx.constraintlayout.solver;

import ai.j0;
import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class SolverVariable {
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

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public int f437id;
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

    /* JADX INFO: renamed from: androidx.constraintlayout.solver.SolverVariable$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type = null;

        static {
            int[] r5 = new int[Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type = r5;
            r5[Type.UNRESTRICTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.CONSTANT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.SLACK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.UNKNOWN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
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
            Type r5 = new Type("UNRESTRICTED", 0);
            UNRESTRICTED = r5;
            Type r10 = new Type("CONSTANT", 1);
            CONSTANT = r10;
            Type r11 = new Type("SLACK", 2);
            SLACK = r11;
            Type r12 = new Type("ERROR", 3);
            ERROR = r12;
            Type r13 = new Type("UNKNOWN", 4);
            UNKNOWN = r13;
            $VALUES = new Type[]{r5, r10, r11, r12, r13};
        }

        private Type(String r5, int r10) {
            super(r5, r10);
        }

        public static Type valueOf(String r5) {
            return (Type) Enum.valueOf(Type.class, r5);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    public SolverVariable(String r5, Type r10) {
        this.f437id = -1;
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
        this.mName = r5;
        this.mType = r10;
    }

    private static String getUniqueName(Type r5, String r10) {
        if (r10 == null) goto L5;
        StringBuilder r11 = j0.u(r10);
        r11.append(uniqueErrorId);
        return r11.toString();
    L5:
        int r12 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[r5.ordinal()];
        if (r12 != 1) goto L8;
        StringBuilder r13 = new StringBuilder("U");
        int r14 = uniqueUnrestrictedId + 1;
        uniqueUnrestrictedId = r14;
        r13.append(r14);
        return r13.toString();
    L8:
        if (r12 != 2) goto L10;
        StringBuilder r15 = new StringBuilder("C");
        int r16 = uniqueConstantId + 1;
        uniqueConstantId = r16;
        r15.append(r16);
        return r15.toString();
    L10:
        if (r12 != 3) goto L12;
        StringBuilder r17 = new StringBuilder(ExifInterface.LATITUDE_SOUTH);
        int r18 = uniqueSlackId + 1;
        uniqueSlackId = r18;
        r17.append(r18);
        return r17.toString();
    L12:
        if (r12 != 4) goto L14;
        StringBuilder r19 = new StringBuilder("e");
        int r20 = uniqueErrorId + 1;
        uniqueErrorId = r20;
        r19.append(r20);
        return r19.toString();
    L14:
        if (r12 != 5) goto L18;
        StringBuilder r21 = new StringBuilder(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        int r22 = uniqueId + 1;
        uniqueId = r22;
        r21.append(r22);
        return r21.toString();
    L18:
        throw new AssertionError(r5.name());
    }

    public static void increaseErrorId() {
        uniqueErrorId++;
    }

    public final void addToRow(ArrayRow r5) {
        int r10 = 0;
    L3:
        int r11 = this.mClientEquationsCount;
        if (r10 >= r11) goto L9;
        if (this.mClientEquations[r10] == r5) goto L7;
        r10 = r10 + 1;
        goto L3
    L7:
        return;
    L9:
        ArrayRow[] r12 = this.mClientEquations;
        if (r11 < r12.length) goto L12;
        this.mClientEquations = (ArrayRow[]) Arrays.copyOf(r12, r12.length * 2);
    L12:
        ArrayRow[] r13 = this.mClientEquations;
        int r14 = this.mClientEquationsCount;
        r13[r14] = r5;
        this.mClientEquationsCount = r14 + 1;
    }

    public void clearStrengths() {
        int r5 = 0;
    L4:
        if (r5 >= 9) goto L6;
        this.strengthVector[r5] = 0.0f;
        r5 = r5 + 1;
        goto L4
    }

    public String getName() {
        return this.mName;
    }

    public final void removeFromRow(ArrayRow r5) {
        int r10 = this.mClientEquationsCount;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L12;
        if (this.mClientEquations[r11] == r5) goto L7;
        r11 = r11 + 1;
    L7:
        if (r11 >= (r10 - 1)) goto L9;
        ArrayRow[] r12 = this.mClientEquations;
        int r13 = r11 + 1;
        r12[r11] = r12[r13];
        r11 = r13;
        goto L7
    L9:
        this.mClientEquationsCount--;
        return;
    }

    public void reset() {
        this.mName = null;
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.f437id = -1;
        this.definitionId = -1;
        this.computedValue = 0.0f;
        this.isFinalValue = false;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        int r5 = this.mClientEquationsCount;
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L5;
        this.mClientEquations[r10] = null;
        r10 = r10 + 1;
        goto L3
    L5:
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inGoal = false;
        Arrays.fill(this.goalStrengthVector, 0.0f);
    }

    public void setFinalValue(LinearSystem r5, float r10) {
        this.computedValue = r10;
        this.isFinalValue = true;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        int r11 = this.mClientEquationsCount;
        this.definitionId = -1;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.mClientEquations[r12].updateFromFinalVariable(r5, this, false);
        r12 = r12 + 1;
        goto L3
    L5:
        this.mClientEquationsCount = 0;
    }

    public void setName(String r5) {
        this.mName = r5;
    }

    public void setSynonym(LinearSystem r5, SolverVariable r10, float r11) {
        this.isSynonym = true;
        this.synonym = r10.f437id;
        this.synonymDelta = r11;
        int r12 = this.mClientEquationsCount;
        this.definitionId = -1;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        this.mClientEquations[r13].updateFromSynonymVariable(r5, this, false);
        r13 = r13 + 1;
        goto L3
    L5:
        this.mClientEquationsCount = 0;
        r5.displayReadableRows();
    }

    public void setType(Type r5, String r10) {
        this.mType = r5;
    }

    public String strengthsToString() {
        String r5 = this + "[";
        int r10 = 0;
        boolean r11 = false;
        boolean r12 = true;
    L4:
        if (r10 >= this.strengthVector.length) goto L19;
        StringBuilder r13 = j0.u(r5);
        r13.append(this.strengthVector[r10]);
        String r14 = r13.toString();
        float[] r15 = this.strengthVector;
        float r16 = r15[r10];
        if (r16 <= 0.0f) goto L9;
        r11 = false;
    L12:
        if (r16 == 0.0f) goto L15;
        r12 = false;
    L15:
        if (r10 >= (r15.length - 1)) goto L17;
        r5 = j0.j(r14, ", ");
    L18:
        r10 = r10 + 1;
        goto L4
    L17:
        r5 = j0.j(r14, "] ");
        goto L18
    L9:
        if (r16 >= 0.0f) goto L12;
        r11 = true;
        goto L12
    L19:
        if (r11 == false) goto L21;
        r5 = j0.j(r5, " (-)");
    L21:
        if (r12 == true) goto L23;
        return r5;
    L23:
        return j0.j(r5, " (*)");
    }

    public String toString() {
        if (this.mName == null) goto L6;
        return "" + this.mName;
    L6:
        return "" + this.f437id;
    }

    public final void updateReferencesWithNewDefinition(LinearSystem r5, ArrayRow r10) {
        int r11 = this.mClientEquationsCount;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.mClientEquations[r12].updateFromRow(r5, r10, false);
        r12 = r12 + 1;
        goto L3
    L5:
        this.mClientEquationsCount = 0;
    }

    public SolverVariable(Type r5, String r10) {
        this.f437id = -1;
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
        this.mType = r5;
    }
}
