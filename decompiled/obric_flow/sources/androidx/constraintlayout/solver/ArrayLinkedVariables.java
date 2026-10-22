package androidx.constraintlayout.solver;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
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

    public ArrayLinkedVariables(ArrayRow r5, Cache r10) {
        this.currentSize = 0;
        this.ROW_SIZE = 8;
        this.candidate = null;
        this.mArrayIndices = new int[8];
        this.mArrayNextIndices = new int[8];
        this.mArrayValues = new float[8];
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.mRow = r5;
        this.mCache = r10;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void add(SolverVariable r10, float r11, boolean r12) {
        float r5 = epsilon;
        if (r11 > (-r5)) goto L5;
    L7:
        int r13 = this.mHead;
        if (r13 != (-1)) goto L15;
        this.mHead = 0;
        this.mArrayValues[0] = r11;
        this.mArrayIndices[0] = r10.f437id;
        this.mArrayNextIndices[0] = -1;
        r10.usageInRowCount++;
        r10.addToRow(this.mRow);
        this.currentSize++;
        if (this.mDidFillOnce == true) goto L81;
        int r14 = this.mLast + 1;
        this.mLast = r14;
        int[] r15 = this.mArrayIndices;
        if (r14 < r15.length) goto L82;
        this.mDidFillOnce = true;
        this.mLast = r15.length - 1;
        return;
    L82:
        return;
    L81:
        return;
    L15:
        int r16 = 0;
        int r17 = -1;
    L16:
        if (r13 == (-1)) goto L42;
        if (r16 >= this.currentSize) goto L42;
        int r18 = this.mArrayIndices[r13];
        int r19 = r10.f437id;
        if (r18 == r19) goto L21;
        if (r18 >= r19) goto L41;
        r17 = r13;
    L41:
        r13 = this.mArrayNextIndices[r13];
        r16 = r16 + 1;
        goto L16
    L21:
        float[] r20 = this.mArrayValues;
        float r21 = r20[r13] + r11;
        float r110 = epsilon;
        if (r21 > (-r110)) goto L24;
    L26:
        r20[r13] = r21;
        if (r21 == 0.0f) goto L29;
        return;
    L29:
        if (r13 != this.mHead) goto L31;
        this.mHead = this.mArrayNextIndices[r13];
    L32:
        if (r12 == false) goto L35;
        r10.removeFromRow(this.mRow);
    L35:
        if (this.mDidFillOnce == false) goto L37;
        this.mLast = r13;
    L37:
        r10.usageInRowCount--;
        this.currentSize--;
        return;
    L31:
        int[] r111 = this.mArrayNextIndices;
        r111[r17] = r111[r13];
        goto L32
    L24:
        if (r21 >= r110) goto L26;
        r21 = 0.0f;
    L42:
        int r112 = this.mLast;
        int r22 = r112 + 1;
        if (this.mDidFillOnce == false) goto L48;
        int[] r23 = this.mArrayIndices;
        if (r23[r112] == (-1)) goto L49;
        r112 = r23.length;
    L49:
        int[] r24 = this.mArrayIndices;
        if (r112 >= r24.length) goto L52;
    L60:
        int[] r25 = this.mArrayIndices;
        if (r112 < r25.length) goto L63;
        r112 = r25.length;
        int r26 = this.ROW_SIZE * 2;
        this.ROW_SIZE = r26;
        this.mDidFillOnce = false;
        this.mLast = r112 - 1;
        this.mArrayValues = Arrays.copyOf(this.mArrayValues, r26);
        this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
        this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
    L63:
        this.mArrayIndices[r112] = r10.f437id;
        this.mArrayValues[r112] = r11;
        if (r17 == (-1)) goto L66;
        int[] r113 = this.mArrayNextIndices;
        r113[r112] = r113[r17];
        r113[r17] = r112;
    L67:
        r10.usageInRowCount++;
        r10.addToRow(this.mRow);
        this.currentSize++;
        if (this.mDidFillOnce == true) goto L70;
        this.mLast++;
    L70:
        int r27 = this.mLast;
        int[] r114 = this.mArrayIndices;
        if (r27 < r114.length) goto L84;
        this.mDidFillOnce = true;
        this.mLast = r114.length - 1;
        return;
    L84:
        return;
    L66:
        this.mArrayNextIndices[r112] = this.mHead;
        this.mHead = r112;
        goto L67
    L52:
        if (this.currentSize >= r24.length) goto L60;
        int r28 = 0;
    L54:
        int[] r29 = this.mArrayIndices;
        if (r28 >= r29.length) goto L60;
        if (r29[r28] == (-1)) goto L58;
        r28 = r28 + 1;
        goto L54
    L58:
        r112 = r28;
        goto L60
    L48:
        r112 = r22;
        goto L49
    L5:
        if (r11 >= r5) goto L7;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void clear() {
        int r5 = this.mHead;
        int r10 = 0;
    L4:
        if (r5 == (-1)) goto L11;
        if (r10 >= this.currentSize) goto L11;
        SolverVariable r11 = this.mCache.mIndexedVariables[this.mArrayIndices[r5]];
        if (r11 == null) goto L10;
        r11.removeFromRow(this.mRow);
    L10:
        r5 = this.mArrayNextIndices[r5];
        r10 = r10 + 1;
    L11:
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.currentSize = 0;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable r10) {
        int r5 = this.mHead;
        if (r5 != (-1)) goto L5;
        return false;
    L5:
        int r11 = 0;
    L6:
        if (r5 == (-1)) goto L14;
        if (r11 >= this.currentSize) goto L14;
        if (this.mArrayIndices[r5] == r10.f437id) goto L11;
        r5 = this.mArrayNextIndices[r5];
        r11 = r11 + 1;
        goto L6
    L11:
        return true;
    L14:
        return false;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void display() {
        int r5 = this.currentSize;
        System.out.print("{ ");
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L9;
        SolverVariable r11 = getVariable(r10);
        if (r11 == null) goto L8;
        System.out.print(r11 + " = " + getVariableValue(r10) + " ");
    L8:
        r10 = r10 + 1;
        goto L3
    L9:
        System.out.println(" }");
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void divideByAmount(float r5) {
        int r10 = this.mHead;
        int r11 = 0;
    L4:
        if (r10 == (-1)) goto L8;
        if (r11 >= this.currentSize) goto L11;
        float[] r12 = this.mArrayValues;
        r12[r10] = r12[r10] / r5;
        r10 = this.mArrayNextIndices[r10];
        r11 = r11 + 1;
        goto L4
    L11:
        return;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final float get(SolverVariable r5) {
        int r10 = this.mHead;
        int r11 = 0;
    L4:
        if (r10 == (-1)) goto L12;
        if (r11 >= this.currentSize) goto L17;
        if (this.mArrayIndices[r10] == r5.f437id) goto L10;
        r10 = this.mArrayNextIndices[r10];
        r11 = r11 + 1;
        goto L4
    L10:
        return this.mArrayValues[r10];
    L17:
        return 0.0f;
    L12:
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.currentSize;
    }

    public int getHead() {
        return this.mHead;
    }

    public final int getId(int r5) {
        return this.mArrayIndices[r5];
    }

    public final int getNextIndice(int r5) {
        return this.mArrayNextIndices[r5];
    }

    public SolverVariable getPivotCandidate() {
        SolverVariable r5 = this.candidate;
        if (r5 != null) goto L18;
        int r10 = this.mHead;
        int r11 = 0;
        SolverVariable r12 = null;
    L6:
        if (r10 == (-1)) goto L17;
        if (r11 >= this.currentSize) goto L17;
        if (this.mArrayValues[r10] >= 0.0f) goto L16;
        SolverVariable r13 = this.mCache.mIndexedVariables[this.mArrayIndices[r10]];
        if (r12 != null) goto L14;
    L15:
        r12 = r13;
        goto L16
    L14:
        if (r12.strength < r13.strength) goto L15;
    L16:
        r10 = this.mArrayNextIndices[r10];
        r11 = r11 + 1;
    L17:
        return r12;
    L18:
        return r5;
    }

    public final float getValue(int r5) {
        return this.mArrayValues[r5];
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int r5) {
        int r10 = this.mHead;
        int r11 = 0;
    L4:
        if (r10 == (-1)) goto L11;
        if (r11 >= this.currentSize) goto L16;
        if (r11 == r5) goto L9;
        r10 = this.mArrayNextIndices[r10];
        r11 = r11 + 1;
        goto L4
    L9:
        return this.mCache.mIndexedVariables[this.mArrayIndices[r10]];
    L16:
        return null;
    L11:
        return null;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float getVariableValue(int r5) {
        int r10 = this.mHead;
        int r11 = 0;
    L4:
        if (r10 == (-1)) goto L11;
        if (r11 >= this.currentSize) goto L16;
        if (r11 == r5) goto L9;
        r10 = this.mArrayNextIndices[r10];
        r11 = r11 + 1;
        goto L4
    L9:
        return this.mArrayValues[r10];
    L16:
        return 0.0f;
    L11:
        return 0.0f;
    }

    public boolean hasAtLeastOnePositiveVariable() {
        int r5 = this.mHead;
        int r10 = 0;
    L4:
        if (r5 == (-1)) goto L12;
        if (r10 >= this.currentSize) goto L12;
        if (this.mArrayValues[r5] > 0.0f) goto L9;
        r5 = this.mArrayNextIndices[r5];
        r10 = r10 + 1;
        goto L4
    L9:
        return true;
    L12:
        return false;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable r10) {
        int r5 = this.mHead;
        if (r5 != (-1)) goto L5;
        return -1;
    L5:
        int r11 = 0;
    L6:
        if (r5 == (-1)) goto L13;
        if (r11 >= this.currentSize) goto L13;
        if (this.mArrayIndices[r5] == r10.f437id) goto L11;
        r5 = this.mArrayNextIndices[r5];
        r11 = r11 + 1;
        goto L6
    L11:
        return r5;
    L13:
        return -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void invert() {
        int r5 = this.mHead;
        int r10 = 0;
    L4:
        if (r5 == (-1)) goto L8;
        if (r10 >= this.currentSize) goto L11;
        float[] r11 = this.mArrayValues;
        r11[r5] = r11[r5] * (-1.0f);
        r5 = this.mArrayNextIndices[r5];
        r10 = r10 + 1;
        goto L4
    L11:
        return;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void put(SolverVariable r10, float r11) {
        if (r11 != 0.0f) goto L6;
        remove(r10, true);
        return;
    L6:
        int r5 = this.mHead;
        if (r5 != (-1)) goto L14;
        this.mHead = 0;
        this.mArrayValues[0] = r11;
        this.mArrayIndices[0] = r10.f437id;
        this.mArrayNextIndices[0] = -1;
        r10.usageInRowCount++;
        r10.addToRow(this.mRow);
        this.currentSize++;
        if (this.mDidFillOnce == true) goto L67;
        int r12 = this.mLast + 1;
        this.mLast = r12;
        int[] r13 = this.mArrayIndices;
        if (r12 < r13.length) goto L68;
        this.mDidFillOnce = true;
        this.mLast = r13.length - 1;
        return;
    L68:
        return;
    L67:
        return;
    L14:
        int r14 = 0;
        int r15 = -1;
    L15:
        if (r5 == (-1)) goto L25;
        if (r14 >= this.currentSize) goto L25;
        int r16 = this.mArrayIndices[r5];
        int r17 = r10.f437id;
        if (r16 == r17) goto L20;
        if (r16 >= r17) goto L24;
        r15 = r5;
    L24:
        r5 = this.mArrayNextIndices[r5];
        r14 = r14 + 1;
        goto L15
    L20:
        this.mArrayValues[r5] = r11;
        return;
    L25:
        int r18 = this.mLast;
        int r19 = r18 + 1;
        if (this.mDidFillOnce == false) goto L31;
        int[] r20 = this.mArrayIndices;
        if (r20[r18] == (-1)) goto L32;
        r18 = r20.length;
    L32:
        int[] r21 = this.mArrayIndices;
        if (r18 >= r21.length) goto L35;
    L43:
        int[] r22 = this.mArrayIndices;
        if (r18 < r22.length) goto L46;
        r18 = r22.length;
        int r23 = this.ROW_SIZE * 2;
        this.ROW_SIZE = r23;
        this.mDidFillOnce = false;
        this.mLast = r18 - 1;
        this.mArrayValues = Arrays.copyOf(this.mArrayValues, r23);
        this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
        this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
    L46:
        this.mArrayIndices[r18] = r10.f437id;
        this.mArrayValues[r18] = r11;
        if (r15 == (-1)) goto L49;
        int[] r110 = this.mArrayNextIndices;
        r110[r18] = r110[r15];
        r110[r15] = r18;
    L50:
        r10.usageInRowCount++;
        r10.addToRow(this.mRow);
        int r24 = this.currentSize + 1;
        this.currentSize = r24;
        if (this.mDidFillOnce == true) goto L53;
        this.mLast++;
    L53:
        int[] r111 = this.mArrayIndices;
        if (r24 < r111.length) goto L57;
        this.mDidFillOnce = true;
    L57:
        if (this.mLast < r111.length) goto L69;
        this.mDidFillOnce = true;
        this.mLast = r111.length - 1;
        return;
    L69:
        return;
    L49:
        this.mArrayNextIndices[r18] = this.mHead;
        this.mHead = r18;
        goto L50
    L35:
        if (this.currentSize >= r21.length) goto L43;
        int r25 = 0;
    L37:
        int[] r26 = this.mArrayIndices;
        if (r25 >= r26.length) goto L43;
        if (r26[r25] == (-1)) goto L41;
        r25 = r25 + 1;
        goto L37
    L41:
        r18 = r25;
        goto L43
    L31:
        r18 = r19;
        goto L32
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final float remove(SolverVariable r10, boolean r11) {
        if (this.candidate != r10) goto L5;
        this.candidate = null;
    L5:
        int r5 = this.mHead;
        if (r5 != (-1)) goto L8;
        return 0.0f;
    L8:
        int r12 = 0;
        int r13 = -1;
    L9:
        if (r5 == (-1)) goto L26;
        if (r12 >= this.currentSize) goto L26;
        if (this.mArrayIndices[r5] == r10.f437id) goto L15;
        r12 = r12 + 1;
        r13 = r5;
        r5 = this.mArrayNextIndices[r5];
        goto L9
    L15:
        if (r5 != this.mHead) goto L17;
        this.mHead = this.mArrayNextIndices[r5];
    L18:
        if (r11 == false) goto L20;
        r10.removeFromRow(this.mRow);
    L20:
        r10.usageInRowCount--;
        this.currentSize--;
        this.mArrayIndices[r5] = -1;
        if (this.mDidFillOnce == false) goto L24;
        this.mLast = r5;
    L24:
        return this.mArrayValues[r5];
    L17:
        int[] r14 = this.mArrayNextIndices;
        r14[r13] = r14[r5];
    L26:
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return (this.mArrayIndices.length * 12) + 36;
    }

    public String toString() {
        int r5 = this.mHead;
        String r10 = "";
        int r11 = 0;
    L4:
        if (r5 == (-1)) goto L8;
        if (r11 >= this.currentSize) goto L8;
        StringBuilder r12 = j0.u(a.r(j0.u(j0.j(r10, " -> ")), this.mArrayValues[r5], " : "));
        r12.append(this.mCache.mIndexedVariables[this.mArrayIndices[r5]]);
        r10 = r12.toString();
        r5 = this.mArrayNextIndices[r5];
        r11 = r11 + 1;
    L8:
        return r10;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float use(ArrayRow r10, boolean r11) {
        float r5 = get(r10.variable);
        remove(r10.variable, r11);
        ArrayRow.ArrayRowVariables r12 = r10.variables;
        int r13 = r12.getCurrentSize();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        SolverVariable r15 = r12.getVariable(r14);
        add(r15, r12.get(r15) * r5, r11);
        r14 = r14 + 1;
        goto L3
    L5:
        return r5;
    }
}
