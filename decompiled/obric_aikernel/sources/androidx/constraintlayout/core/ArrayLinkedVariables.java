package androidx.constraintlayout.core;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ArrayLinkedVariables implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    static final int NONE = -1;
    private static float epsilon = 0.001f;
    private int ROW_SIZE;
    private SolverVariable candidate;
    int currentSize;
    private int[] mArrayIndices;
    private int[] mArrayNextIndices;
    private float[] mArrayValues;
    protected final Cache mCache;
    private boolean mDidFillOnce;
    private int mHead;
    private int mLast;
    private final ArrayRow mRow;

    static {
    }

    ArrayLinkedVariables(ArrayRow r10, Cache r11) {
        this.currentSize = 0;
        this.ROW_SIZE = 8;
        this.candidate = null;
        this.mArrayIndices = new int[8];
        this.mArrayNextIndices = new int[8];
        this.mArrayValues = new float[8];
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.mRow = r10;
        this.mCache = r11;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void add(SolverVariable r10, float r11, boolean r12) {
        float r13 = epsilon;
        if (r11 > (-r13)) goto L5;
    L7:
        int r14 = this.mHead;
        if (r14 != (-1)) goto L15;
        this.mHead = 0;
        this.mArrayValues[0] = r11;
        this.mArrayIndices[0] = r10.id;
        this.mArrayNextIndices[0] = -1;
        r10.usageInRowCount++;
        r10.addToRow(this.mRow);
        this.currentSize++;
        if (this.mDidFillOnce == true) goto L82;
        int r15 = this.mLast + 1;
        this.mLast = r15;
        int[] r16 = this.mArrayIndices;
        if (r15 < r16.length) goto L83;
        this.mDidFillOnce = true;
        this.mLast = r16.length - 1;
        return;
    L83:
        return;
    L82:
        return;
    L15:
        int r17 = 0;
        int r18 = -1;
    L16:
        if (r14 == (-1)) goto L43;
        if (r17 >= this.currentSize) goto L43;
        int[] r19 = this.mArrayIndices;
        int r20 = r19[r14];
        int r21 = r10.id;
        if (r20 == r21) goto L21;
        if (r19[r14] >= r21) goto L42;
        r18 = r14;
    L42:
        r14 = this.mArrayNextIndices[r14];
        r17 = r17 + 1;
        goto L16
    L21:
        float[] r22 = this.mArrayValues;
        float r23 = r22[r14] + r11;
        float r110 = epsilon;
        if (r23 > (-r110)) goto L24;
    L26:
        r22[r14] = r23;
        if (r23 == 0.0f) goto L29;
        return;
    L29:
        if (r14 != this.mHead) goto L31;
        this.mHead = this.mArrayNextIndices[r14];
    L32:
        if (r12 == false) goto L35;
        r10.removeFromRow(this.mRow);
    L35:
        if (this.mDidFillOnce == false) goto L37;
        this.mLast = r14;
    L37:
        r10.usageInRowCount--;
        this.currentSize--;
        return;
    L31:
        int[] r111 = this.mArrayNextIndices;
        r111[r18] = r111[r14];
        goto L32
    L24:
        if (r23 >= r110) goto L26;
        r23 = 0.0f;
    L43:
        int r112 = this.mLast;
        int r24 = r112 + 1;
        if (this.mDidFillOnce == false) goto L49;
        int[] r25 = this.mArrayIndices;
        if (r25[r112] == (-1)) goto L50;
        r112 = r25.length;
    L50:
        int[] r26 = this.mArrayIndices;
        if (r112 >= r26.length) goto L53;
    L61:
        int[] r27 = this.mArrayIndices;
        if (r112 < r27.length) goto L64;
        r112 = r27.length;
        int r28 = this.ROW_SIZE * 2;
        this.ROW_SIZE = r28;
        this.mDidFillOnce = false;
        this.mLast = r112 - 1;
        this.mArrayValues = Arrays.copyOf(this.mArrayValues, r28);
        this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
        this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
    L64:
        this.mArrayIndices[r112] = r10.id;
        this.mArrayValues[r112] = r11;
        int[] r113 = this.mArrayNextIndices;
        if (r18 == (-1)) goto L67;
        r113[r112] = r113[r18];
        r113[r18] = r112;
    L68:
        r10.usageInRowCount++;
        r10.addToRow(this.mRow);
        this.currentSize++;
        if (this.mDidFillOnce == true) goto L71;
        this.mLast++;
    L71:
        int r114 = this.mLast;
        int[] r115 = this.mArrayIndices;
        if (r114 < r115.length) goto L85;
        this.mDidFillOnce = true;
        this.mLast = r115.length - 1;
        return;
    L85:
        return;
    L67:
        r113[r112] = this.mHead;
        this.mHead = r112;
        goto L68
    L53:
        if (this.currentSize >= r26.length) goto L61;
        int r29 = 0;
    L55:
        int[] r30 = this.mArrayIndices;
        if (r29 >= r30.length) goto L61;
        if (r30[r29] == (-1)) goto L59;
        r29 = r29 + 1;
        goto L55
    L59:
        r112 = r29;
        goto L61
    L49:
        r112 = r24;
        goto L50
    L5:
        if (r11 >= r13) goto L7;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void clear() {
        int r10 = this.mHead;
        int r11 = 0;
    L4:
        if (r10 == (-1)) goto L11;
        if (r11 >= this.currentSize) goto L11;
        SolverVariable r12 = this.mCache.mIndexedVariables[this.mArrayIndices[r10]];
        if (r12 == null) goto L10;
        r12.removeFromRow(this.mRow);
    L10:
        r10 = this.mArrayNextIndices[r10];
        r11 = r11 + 1;
    L11:
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.currentSize = 0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable r10) {
        int r11 = this.mHead;
        if (r11 != (-1)) goto L5;
        return false;
    L5:
        int r12 = 0;
    L6:
        if (r11 == (-1)) goto L14;
        if (r12 >= this.currentSize) goto L14;
        if (this.mArrayIndices[r11] == r10.id) goto L11;
        r11 = this.mArrayNextIndices[r11];
        r12 = r12 + 1;
        goto L6
    L11:
        return true;
    L14:
        return false;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void display() {
        int r10 = this.currentSize;
        System.out.print("{ ");
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        SolverVariable r12 = getVariable(r11);
        if (r12 == null) goto L8;
        System.out.print(r12 + " = " + getVariableValue(r11) + " ");
    L8:
        r11 = r11 + 1;
        goto L3
    L9:
        System.out.println(" }");
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void divideByAmount(float r10) {
        int r11 = this.mHead;
        int r12 = 0;
    L4:
        if (r11 == (-1)) goto L8;
        if (r12 >= this.currentSize) goto L11;
        float[] r13 = this.mArrayValues;
        r13[r11] = r13[r11] / r10;
        r11 = this.mArrayNextIndices[r11];
        r12 = r12 + 1;
        goto L4
    L11:
        return;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float get(SolverVariable r10) {
        int r11 = this.mHead;
        int r12 = 0;
    L4:
        if (r11 == (-1)) goto L12;
        if (r12 >= this.currentSize) goto L17;
        if (this.mArrayIndices[r11] == r10.id) goto L10;
        r11 = this.mArrayNextIndices[r11];
        r12 = r12 + 1;
        goto L4
    L10:
        return this.mArrayValues[r11];
    L17:
        return 0.0f;
    L12:
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.currentSize;
    }

    public int getHead() {
        return this.mHead;
    }

    public final int getId(int r10) {
        return this.mArrayIndices[r10];
    }

    public final int getNextIndice(int r10) {
        return this.mArrayNextIndices[r10];
    }

    SolverVariable getPivotCandidate() {
        SolverVariable r10 = this.candidate;
        if (r10 != null) goto L18;
        int r11 = this.mHead;
        int r12 = 0;
        SolverVariable r13 = null;
    L6:
        if (r11 == (-1)) goto L17;
        if (r12 >= this.currentSize) goto L17;
        if (this.mArrayValues[r11] >= 0.0f) goto L16;
        SolverVariable r14 = this.mCache.mIndexedVariables[this.mArrayIndices[r11]];
        if (r13 != null) goto L14;
    L15:
        r13 = r14;
        goto L16
    L14:
        if (r13.strength < r14.strength) goto L15;
    L16:
        r11 = this.mArrayNextIndices[r11];
        r12 = r12 + 1;
    L17:
        return r13;
    L18:
        return r10;
    }

    public final float getValue(int r10) {
        return this.mArrayValues[r10];
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int r10) {
        int r11 = this.mHead;
        int r12 = 0;
    L4:
        if (r11 == (-1)) goto L11;
        if (r12 >= this.currentSize) goto L16;
        if (r12 == r10) goto L9;
        r11 = this.mArrayNextIndices[r11];
        r12 = r12 + 1;
        goto L4
    L9:
        return this.mCache.mIndexedVariables[this.mArrayIndices[r11]];
    L16:
        return null;
    L11:
        return null;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float getVariableValue(int r10) {
        int r11 = this.mHead;
        int r12 = 0;
    L4:
        if (r11 == (-1)) goto L11;
        if (r12 >= this.currentSize) goto L16;
        if (r12 == r10) goto L9;
        r11 = this.mArrayNextIndices[r11];
        r12 = r12 + 1;
        goto L4
    L9:
        return this.mArrayValues[r11];
    L16:
        return 0.0f;
    L11:
        return 0.0f;
    }

    boolean hasAtLeastOnePositiveVariable() {
        int r10 = this.mHead;
        int r11 = 0;
    L4:
        if (r10 == (-1)) goto L12;
        if (r11 >= this.currentSize) goto L12;
        if (this.mArrayValues[r10] > 0.0f) goto L9;
        r10 = this.mArrayNextIndices[r10];
        r11 = r11 + 1;
        goto L4
    L9:
        return true;
    L12:
        return false;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable r10) {
        int r11 = this.mHead;
        if (r11 != (-1)) goto L5;
        return -1;
    L5:
        int r12 = 0;
    L6:
        if (r11 == (-1)) goto L13;
        if (r12 >= this.currentSize) goto L13;
        if (this.mArrayIndices[r11] == r10.id) goto L11;
        r11 = this.mArrayNextIndices[r11];
        r12 = r12 + 1;
        goto L6
    L11:
        return r11;
    L13:
        return -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void invert() {
        int r10 = this.mHead;
        int r11 = 0;
    L4:
        if (r10 == (-1)) goto L8;
        if (r11 >= this.currentSize) goto L11;
        float[] r12 = this.mArrayValues;
        r12[r10] = r12[r10] * (-1.0f);
        r10 = this.mArrayNextIndices[r10];
        r11 = r11 + 1;
        goto L4
    L11:
        return;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void put(SolverVariable r10, float r11) {
        if (r11 != 0.0f) goto L6;
        remove(r10, true);
        return;
    L6:
        int r12 = this.mHead;
        if (r12 != (-1)) goto L14;
        this.mHead = 0;
        this.mArrayValues[0] = r11;
        this.mArrayIndices[0] = r10.id;
        this.mArrayNextIndices[0] = -1;
        r10.usageInRowCount++;
        r10.addToRow(this.mRow);
        this.currentSize++;
        if (this.mDidFillOnce == true) goto L68;
        int r13 = this.mLast + 1;
        this.mLast = r13;
        int[] r14 = this.mArrayIndices;
        if (r13 < r14.length) goto L69;
        this.mDidFillOnce = true;
        this.mLast = r14.length - 1;
        return;
    L69:
        return;
    L68:
        return;
    L14:
        int r15 = 0;
        int r16 = -1;
    L15:
        if (r12 == (-1)) goto L26;
        if (r15 >= this.currentSize) goto L26;
        int[] r17 = this.mArrayIndices;
        int r18 = r17[r12];
        int r19 = r10.id;
        if (r18 == r19) goto L20;
        if (r17[r12] >= r19) goto L25;
        r16 = r12;
    L25:
        r12 = this.mArrayNextIndices[r12];
        r15 = r15 + 1;
        goto L15
    L20:
        this.mArrayValues[r12] = r11;
        return;
    L26:
        int r20 = this.mLast;
        int r21 = r20 + 1;
        if (this.mDidFillOnce == false) goto L32;
        int[] r22 = this.mArrayIndices;
        if (r22[r20] == (-1)) goto L33;
        r20 = r22.length;
    L33:
        int[] r23 = this.mArrayIndices;
        if (r20 >= r23.length) goto L36;
    L44:
        int[] r24 = this.mArrayIndices;
        if (r20 < r24.length) goto L47;
        r20 = r24.length;
        int r25 = this.ROW_SIZE * 2;
        this.ROW_SIZE = r25;
        this.mDidFillOnce = false;
        this.mLast = r20 - 1;
        this.mArrayValues = Arrays.copyOf(this.mArrayValues, r25);
        this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
        this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
    L47:
        this.mArrayIndices[r20] = r10.id;
        this.mArrayValues[r20] = r11;
        int[] r110 = this.mArrayNextIndices;
        if (r16 == (-1)) goto L50;
        r110[r20] = r110[r16];
        r110[r16] = r20;
    L51:
        r10.usageInRowCount++;
        r10.addToRow(this.mRow);
        int r111 = this.currentSize + 1;
        this.currentSize = r111;
        if (this.mDidFillOnce == true) goto L54;
        this.mLast++;
    L54:
        int[] r112 = this.mArrayIndices;
        if (r111 < r112.length) goto L58;
        this.mDidFillOnce = true;
    L58:
        if (this.mLast < r112.length) goto L70;
        this.mDidFillOnce = true;
        this.mLast = r112.length - 1;
        return;
    L70:
        return;
    L50:
        r110[r20] = this.mHead;
        this.mHead = r20;
        goto L51
    L36:
        if (this.currentSize >= r23.length) goto L44;
        int r26 = 0;
    L38:
        int[] r27 = this.mArrayIndices;
        if (r26 >= r27.length) goto L44;
        if (r27[r26] == (-1)) goto L42;
        r26 = r26 + 1;
        goto L38
    L42:
        r20 = r26;
        goto L44
    L32:
        r20 = r21;
        goto L33
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float remove(SolverVariable r10, boolean r11) {
        if (this.candidate != r10) goto L5;
        this.candidate = null;
    L5:
        int r12 = this.mHead;
        if (r12 != (-1)) goto L8;
        return 0.0f;
    L8:
        int r13 = 0;
        int r14 = -1;
    L9:
        if (r12 == (-1)) goto L26;
        if (r13 >= this.currentSize) goto L26;
        if (this.mArrayIndices[r12] == r10.id) goto L15;
        r13 = r13 + 1;
        r14 = r12;
        r12 = this.mArrayNextIndices[r12];
        goto L9
    L15:
        if (r12 != this.mHead) goto L17;
        this.mHead = this.mArrayNextIndices[r12];
    L18:
        if (r11 == false) goto L20;
        r10.removeFromRow(this.mRow);
    L20:
        r10.usageInRowCount--;
        this.currentSize--;
        this.mArrayIndices[r12] = -1;
        if (this.mDidFillOnce == false) goto L24;
        this.mLast = r12;
    L24:
        return this.mArrayValues[r12];
    L17:
        int[] r15 = this.mArrayNextIndices;
        r15[r14] = r15[r12];
    L26:
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return (((this.mArrayIndices.length * 4) * 3) + 0) + 36;
    }

    public String toString() {
        int r10 = this.mHead;
        String r11 = "";
        int r12 = 0;
    L4:
        if (r10 == (-1)) goto L8;
        if (r12 >= this.currentSize) goto L8;
        r11 = ((r11 + " -> ") + this.mArrayValues[r10] + " : ") + this.mCache.mIndexedVariables[this.mArrayIndices[r10]];
        r10 = this.mArrayNextIndices[r10];
        r12 = r12 + 1;
    L8:
        return r11;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float use(ArrayRow r10, boolean r11) {
        float r12 = get(r10.variable);
        remove(r10.variable, r11);
        ArrayRow.ArrayRowVariables r13 = r10.variables;
        int r14 = r13.getCurrentSize();
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L5;
        SolverVariable r16 = r13.getVariable(r15);
        add(r16, r13.get(r16) * r12, r11);
        r15 = r15 + 1;
        goto L3
    L5:
        return r12;
    }
}
