package androidx.constraintlayout.core;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class SolverVariableValues implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean HASH = true;
    private static float epsilon = 0.001f;
    private int HASH_SIZE;
    private final int NONE;
    private int SIZE;
    int head;
    int[] keys;
    protected final Cache mCache;
    int mCount;
    private final ArrayRow mRow;
    int[] next;
    int[] nextKeys;
    int[] previous;
    float[] values;
    int[] variables;

    static {
    }

    SolverVariableValues(ArrayRow r10, Cache r11) {
        this.NONE = -1;
        this.SIZE = 16;
        this.HASH_SIZE = 16;
        this.keys = new int[16];
        this.nextKeys = new int[16];
        this.variables = new int[16];
        this.values = new float[16];
        this.previous = new int[16];
        this.next = new int[16];
        this.mCount = 0;
        this.head = -1;
        this.mRow = r10;
        this.mCache = r11;
        clear();
    }

    private void addToHashMap(SolverVariable r10, int r11) {
        int r12 = r10.id % this.HASH_SIZE;
        int[] r13 = this.keys;
        int r14 = r13[r12];
        if (r14 != (-1)) goto L5;
        r13[r12] = r11;
    L9:
        this.nextKeys[r11] = -1;
        return;
    L5:
        int[] r15 = this.nextKeys;
        if (r15[r14] == (-1)) goto L8;
        r14 = r15[r14];
        goto L5
    L8:
        r15[r14] = r11;
        goto L9
    }

    private void addVariable(int r10, SolverVariable r11, float r12) {
        this.variables[r10] = r11.id;
        this.values[r10] = r12;
        this.previous[r10] = -1;
        this.next[r10] = -1;
        r11.addToRow(this.mRow);
        r11.usageInRowCount++;
        this.mCount++;
    }

    private void displayHash() {
        int r10 = 0;
    L4:
        if (r10 >= this.HASH_SIZE) goto L15;
        if (this.keys[r10] == (-1)) goto L14;
        String r11 = hashCode() + " hash [" + r10 + "] => ";
        int r12 = this.keys[r10];
        boolean r13 = false;
    L8:
        if (r13 == true) goto L13;
        r11 = r11 + " " + this.variables[r12];
        int[] r14 = this.nextKeys;
        if (r14[r12] != (-1)) goto L11;
        r13 = true;
        goto L8
    L11:
        r12 = r14[r12];
        goto L8
    L13:
        System.out.println(r11);
    L14:
        r10 = r10 + 1;
        goto L4
    }

    private int findEmptySlot() {
        int r10 = 0;
    L4:
        if (r10 >= this.SIZE) goto L9;
        if (this.variables[r10] == (-1)) goto L7;
        r10 = r10 + 1;
        goto L4
    L7:
        return r10;
    L9:
        return -1;
    }

    private void increaseSize() {
        int r10 = this.SIZE * 2;
        this.variables = Arrays.copyOf(this.variables, r10);
        this.values = Arrays.copyOf(this.values, r10);
        this.previous = Arrays.copyOf(this.previous, r10);
        this.next = Arrays.copyOf(this.next, r10);
        this.nextKeys = Arrays.copyOf(this.nextKeys, r10);
        int r11 = this.SIZE;
    L3:
        if (r11 >= r10) goto L5;
        this.variables[r11] = -1;
        this.nextKeys[r11] = -1;
        r11 = r11 + 1;
        goto L3
    L5:
        this.SIZE = r10;
    }

    private void insertVariable(int r10, SolverVariable r11, float r12) {
        int r13 = findEmptySlot();
        addVariable(r13, r11, r12);
        if (r10 == (-1)) goto L5;
        this.previous[r13] = r10;
        int[] r14 = this.next;
        r14[r13] = r14[r10];
        r14[r10] = r13;
    L9:
        int[] r15 = this.next;
        if (r15[r13] == (-1)) goto L12;
        this.previous[r15[r13]] = r13;
    L12:
        addToHashMap(r11, r13);
        return;
    L5:
        this.previous[r13] = -1;
        if (this.mCount <= 0) goto L8;
        this.next[r13] = this.head;
        this.head = r13;
        goto L9
    L8:
        this.next[r13] = -1;
        goto L9
    }

    private void removeFromHashMap(SolverVariable r10) {
        int r11 = r10.id;
        int r12 = r11 % this.HASH_SIZE;
        int[] r13 = this.keys;
        int r14 = r13[r12];
        if (r14 != (-1)) goto L6;
        return;
    L6:
        if (this.variables[r14] != r11) goto L8;
        int[] r15 = this.nextKeys;
        r13[r12] = r15[r14];
        r15[r14] = -1;
        return;
    L8:
        int[] r16 = this.nextKeys;
        if (r16[r14] == (-1)) goto L13;
        if (this.variables[r16[r14]] == r11) goto L13;
        r14 = r16[r14];
    L13:
        int r17 = r16[r14];
        if (r17 != (-1)) goto L16;
        return;
    L16:
        if (this.variables[r17] != r11) goto L23;
        r16[r14] = r16[r17];
        r16[r17] = -1;
        return;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void add(SolverVariable r10, float r11, boolean r12) {
        float r13 = epsilon;
        if (r11 > (-r13)) goto L5;
    L7:
        int r14 = indexOf(r10);
        if (r14 != (-1)) goto L10;
        put(r10, r11);
        return;
    L10:
        float[] r15 = this.values;
        r15[r14] = r15[r14] + r11;
        float r16 = r15[r14];
        float r17 = epsilon;
        if (r16 > (-r17)) goto L13;
        return;
    L13:
        if (r15[r14] >= r17) goto L18;
        r15[r14] = 0.0f;
        remove(r10, r12);
        return;
    L18:
        return;
    L5:
        if (r11 >= r13) goto L7;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void clear() {
        int r10 = this.mCount;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        SolverVariable r12 = getVariable(r11);
        if (r12 == null) goto L7;
        r12.removeFromRow(this.mRow);
    L7:
        r11 = r11 + 1;
        goto L3
    L8:
        int r13 = 0;
    L10:
        if (r13 >= this.SIZE) goto L12;
        this.variables[r13] = -1;
        this.nextKeys[r13] = -1;
        r13 = r13 + 1;
        goto L10
    L12:
        int r14 = 0;
    L14:
        if (r14 >= this.HASH_SIZE) goto L16;
        this.keys[r14] = -1;
        r14 = r14 + 1;
        goto L14
    L16:
        this.mCount = 0;
        this.head = -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable r10) {
        if (indexOf(r10) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void display() {
        int r10 = this.mCount;
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
        int r11 = this.mCount;
        int r12 = this.head;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L8;
        float[] r14 = this.values;
        r14[r12] = r14[r12] / r10;
        r12 = this.next[r12];
        if (r12 == (-1)) goto L11;
        r13 = r13 + 1;
        goto L3
    L11:
        return;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float get(SolverVariable r10) {
        int r11 = indexOf(r10);
        if (r11 != (-1)) goto L5;
        return 0.0f;
    L5:
        return this.values[r11];
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.mCount;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int r10) {
        int r11 = this.mCount;
        if (r11 != 0) goto L5;
        return null;
    L5:
        int r12 = this.head;
        int r13 = 0;
    L6:
        if (r13 >= r11) goto L16;
        if (r13 != r10) goto L12;
        if (r12 == (-1)) goto L12;
        return this.mCache.mIndexedVariables[this.variables[r12]];
    L12:
        r12 = this.next[r12];
        if (r12 == (-1)) goto L16;
        r13 = r13 + 1;
    L16:
        return null;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float getVariableValue(int r10) {
        int r11 = this.mCount;
        int r12 = this.head;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L11;
        if (r13 == r10) goto L6;
        r12 = this.next[r12];
        if (r12 == (-1)) goto L16;
        r13 = r13 + 1;
        goto L3
    L16:
        return 0.0f;
    L6:
        return this.values[r12];
    L11:
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable r10) {
        if (this.mCount == 0) goto L24;
        if (r10 == null) goto L24;
        int r11 = r10.id;
        int r12 = r11 % this.HASH_SIZE;
        int r13 = this.keys[r12];
        if (r13 != (-1)) goto L10;
        return -1;
    L10:
        if (this.variables[r13] != r11) goto L12;
        return r13;
    L12:
        int[] r14 = this.nextKeys;
        if (r14[r13] == (-1)) goto L18;
        if (this.variables[r14[r13]] == r11) goto L18;
        r13 = r14[r13];
    L18:
        if (r14[r13] != (-1)) goto L21;
        return -1;
    L21:
        if (this.variables[r14[r13]] != r11) goto L24;
        return r14[r13];
    L24:
        return -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void invert() {
        int r10 = this.mCount;
        int r11 = this.head;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L8;
        float[] r13 = this.values;
        r13[r11] = r13[r11] * (-1.0f);
        r11 = this.next[r11];
        if (r11 == (-1)) goto L11;
        r12 = r12 + 1;
        goto L3
    L11:
        return;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void put(SolverVariable r10, float r11) {
        float r12 = epsilon;
        if (r11 > (-r12)) goto L5;
    L8:
        int r13 = 0;
        if (this.mCount != 0) goto L11;
        addVariable(0, r10, r11);
        addToHashMap(r10, 0);
        this.head = 0;
        return;
    L11:
        int r14 = indexOf(r10);
        if (r14 == (-1)) goto L15;
        this.values[r14] = r11;
        return;
    L15:
        if ((this.mCount + 1) < this.SIZE) goto L17;
        increaseSize();
    L17:
        int r15 = this.mCount;
        int r16 = this.head;
        int r17 = -1;
    L18:
        if (r13 >= r15) goto L30;
        int[] r18 = this.variables;
        int r19 = r18[r16];
        int r20 = r10.id;
        if (r19 == r20) goto L21;
        if (r18[r16] >= r20) goto L26;
        r17 = r16;
    L26:
        r16 = this.next[r16];
        if (r16 == (-1)) goto L30;
        r13 = r13 + 1;
        goto L18
    L21:
        this.values[r16] = r11;
        return;
    L30:
        insertVariable(r17, r10, r11);
        return;
    L5:
        if (r11 >= r12) goto L8;
        remove(r10, true);
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float remove(SolverVariable r10, boolean r11) {
        int r12 = indexOf(r10);
        if (r12 != (-1)) goto L6;
        return 0.0f;
    L6:
        removeFromHashMap(r10);
        float r13 = this.values[r12];
        if (this.head != r12) goto L9;
        this.head = this.next[r12];
    L9:
        this.variables[r12] = -1;
        int[] r14 = this.previous;
        if (r14[r12] == (-1)) goto L12;
        int[] r15 = this.next;
        r15[r14[r12]] = r15[r12];
    L12:
        int[] r16 = this.next;
        if (r16[r12] == (-1)) goto L15;
        r14[r16[r12]] = r14[r12];
    L15:
        this.mCount--;
        r10.usageInRowCount--;
        if (r11 == false) goto L18;
        r10.removeFromRow(this.mRow);
    L18:
        return r13;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return 0;
    }

    public String toString() {
        String r10 = hashCode() + " { ";
        int r11 = this.mCount;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L18;
        SolverVariable r13 = getVariable(r12);
        if (r13 == null) goto L16;
        String r14 = r10 + r13 + " = " + getVariableValue(r12) + " ";
        int r15 = indexOf(r13);
        String r16 = r14 + "[p: ";
        if (this.previous[r15] == (-1)) goto L10;
        StringBuilder r17 = new StringBuilder();
        r17.append(r16);
        r17.append(this.mCache.mIndexedVariables[this.variables[this.previous[r15]]]);
    L11:
        String r18 = r17.toString() + ", n: ";
        if (this.next[r15] == (-1)) goto L14;
        String r19 = r18 + this.mCache.mIndexedVariables[this.variables[this.next[r15]]];
    L15:
        r10 = r19 + "]";
        goto L16
    L14:
        r19 = r18 + "none";
        goto L15
    L10:
        r17 = new StringBuilder();
        r17.append(r16);
        r17.append("none");
    L16:
        r12 = r12 + 1;
        goto L3
    L18:
        return r10 + " }";
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float use(ArrayRow r10, boolean r11) {
        float r12 = get(r10.variable);
        remove(r10.variable, r11);
        SolverVariableValues r13 = (SolverVariableValues) r10.variables;
        int r14 = r13.getCurrentSize();
        int r15 = 0;
        int r16 = 0;
    L3:
        if (r15 >= r14) goto L8;
        int[] r17 = r13.variables;
        if (r17[r16] == (-1)) goto L7;
        add(this.mCache.mIndexedVariables[r17[r16]], r13.values[r16] * r12, r11);
        r15 = r15 + 1;
    L7:
        r16 = r16 + 1;
        goto L3
    L8:
        return r12;
    }
}
