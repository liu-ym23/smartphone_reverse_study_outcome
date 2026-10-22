package androidx.constraintlayout.solver;

import ai.j0;
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

    public SolverVariableValues(ArrayRow r5, Cache r10) {
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
        this.mRow = r5;
        this.mCache = r10;
        clear();
    }

    private void addToHashMap(SolverVariable r5, int r10) {
        int r11 = r5.f437id % this.HASH_SIZE;
        int[] r12 = this.keys;
        int r13 = r12[r11];
        if (r13 != (-1)) goto L5;
        r12[r11] = r10;
    L9:
        this.nextKeys[r10] = -1;
        return;
    L5:
        int[] r14 = this.nextKeys;
        int r15 = r14[r13];
        if (r15 == (-1)) goto L8;
        r13 = r15;
        goto L5
    L8:
        r14[r13] = r10;
        goto L9
    }

    private void addVariable(int r5, SolverVariable r10, float r11) {
        this.variables[r5] = r10.f437id;
        this.values[r5] = r11;
        this.previous[r5] = -1;
        this.next[r5] = -1;
        r10.addToRow(this.mRow);
        r10.usageInRowCount++;
        this.mCount++;
    }

    private void displayHash() {
        int r5 = 0;
    L4:
        if (r5 >= this.HASH_SIZE) goto L15;
        if (this.keys[r5] == (-1)) goto L14;
        String r10 = hashCode() + " hash [" + r5 + "] => ";
        int r11 = this.keys[r5];
        boolean r12 = false;
    L8:
        if (r12 == true) goto L13;
        StringBuilder r13 = j0.w(r10, " ");
        r13.append(this.variables[r11]);
        r10 = r13.toString();
        int r14 = this.nextKeys[r11];
        if (r14 != (-1)) goto L11;
        r12 = HASH;
        goto L8
    L11:
        r11 = r14;
        goto L8
    L13:
        System.out.println(r10);
    L14:
        r5 = r5 + 1;
        goto L4
    }

    private int findEmptySlot() {
        int r5 = 0;
    L4:
        if (r5 >= this.SIZE) goto L9;
        if (this.variables[r5] == (-1)) goto L7;
        r5 = r5 + 1;
        goto L4
    L7:
        return r5;
    L9:
        return -1;
    }

    private void increaseSize() {
        int r5 = this.SIZE * 2;
        this.variables = Arrays.copyOf(this.variables, r5);
        this.values = Arrays.copyOf(this.values, r5);
        this.previous = Arrays.copyOf(this.previous, r5);
        this.next = Arrays.copyOf(this.next, r5);
        this.nextKeys = Arrays.copyOf(this.nextKeys, r5);
        int r10 = this.SIZE;
    L3:
        if (r10 >= r5) goto L5;
        this.variables[r10] = -1;
        this.nextKeys[r10] = -1;
        r10 = r10 + 1;
        goto L3
    L5:
        this.SIZE = r5;
    }

    private void insertVariable(int r5, SolverVariable r10, float r11) {
        int r12 = findEmptySlot();
        addVariable(r12, r10, r11);
        if (r5 == (-1)) goto L5;
        this.previous[r12] = r5;
        int[] r13 = this.next;
        r13[r12] = r13[r5];
        r13[r5] = r12;
    L9:
        int r14 = this.next[r12];
        if (r14 == (-1)) goto L12;
        this.previous[r14] = r12;
    L12:
        addToHashMap(r10, r12);
        return;
    L5:
        this.previous[r12] = -1;
        if (this.mCount <= 0) goto L8;
        this.next[r12] = this.head;
        this.head = r12;
        goto L9
    L8:
        this.next[r12] = -1;
        goto L9
    }

    private void removeFromHashMap(SolverVariable r10) {
        int r11 = r10.f437id;
        int r5 = r11 % this.HASH_SIZE;
        int[] r12 = this.keys;
        int r13 = r12[r5];
        if (r13 != (-1)) goto L6;
        return;
    L6:
        if (this.variables[r13] != r11) goto L8;
        int[] r14 = this.nextKeys;
        r12[r5] = r14[r13];
        r14[r13] = -1;
        return;
    L8:
        int[] r15 = this.nextKeys;
        int r16 = r15[r13];
        if (r16 == (-1)) goto L13;
        if (this.variables[r16] == r11) goto L13;
        r13 = r16;
    L13:
        if (r16 != (-1)) goto L15;
        return;
    L15:
        if (this.variables[r16] != r11) goto L22;
        r15[r13] = r15[r16];
        r15[r16] = -1;
        return;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void add(SolverVariable r5, float r10, boolean r11) {
        float r12 = epsilon;
        if (r10 > (-r12)) goto L5;
    L7:
        int r13 = indexOf(r5);
        if (r13 != (-1)) goto L10;
        put(r5, r10);
        return;
    L10:
        float[] r14 = this.values;
        float r15 = r14[r13] + r10;
        r14[r13] = r15;
        float r16 = epsilon;
        if (r15 > (-r16)) goto L13;
        return;
    L13:
        if (r15 >= r16) goto L18;
        r14[r13] = 0.0f;
        remove(r5, r11);
        return;
    L18:
        return;
    L5:
        if (r10 >= r12) goto L7;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void clear() {
        int r5 = this.mCount;
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L8;
        SolverVariable r11 = getVariable(r10);
        if (r11 == null) goto L7;
        r11.removeFromRow(this.mRow);
    L7:
        r10 = r10 + 1;
        goto L3
    L8:
        int r12 = 0;
    L10:
        if (r12 >= this.SIZE) goto L12;
        this.variables[r12] = -1;
        this.nextKeys[r12] = -1;
        r12 = r12 + 1;
        goto L10
    L12:
        int r13 = 0;
    L14:
        if (r13 >= this.HASH_SIZE) goto L16;
        this.keys[r13] = -1;
        r13 = r13 + 1;
        goto L14
    L16:
        this.mCount = 0;
        this.head = -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable r5) {
        if (indexOf(r5) == (-1)) goto L5;
        return HASH;
    L5:
        return false;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void display() {
        int r5 = this.mCount;
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
    public void divideByAmount(float r10) {
        int r5 = this.mCount;
        int r11 = this.head;
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L8;
        float[] r13 = this.values;
        r13[r11] = r13[r11] / r10;
        r11 = this.next[r11];
        if (r11 == (-1)) goto L11;
        r12 = r12 + 1;
        goto L3
    L11:
        return;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float get(SolverVariable r5) {
        int r10 = indexOf(r5);
        if (r10 != (-1)) goto L5;
        return 0.0f;
    L5:
        return this.values[r10];
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.mCount;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int r10) {
        int r5 = this.mCount;
        if (r5 != 0) goto L5;
        return null;
    L5:
        int r11 = this.head;
        int r12 = 0;
    L6:
        if (r12 >= r5) goto L16;
        if (r12 != r10) goto L12;
        if (r11 == (-1)) goto L12;
        return this.mCache.mIndexedVariables[this.variables[r11]];
    L12:
        r11 = this.next[r11];
        if (r11 == (-1)) goto L16;
        r12 = r12 + 1;
    L16:
        return null;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float getVariableValue(int r5) {
        int r10 = this.mCount;
        int r11 = this.head;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L11;
        if (r12 == r5) goto L6;
        r11 = this.next[r11];
        if (r11 == (-1)) goto L16;
        r12 = r12 + 1;
        goto L3
    L16:
        return 0.0f;
    L6:
        return this.values[r11];
    L11:
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable r5) {
        if (this.mCount == 0) goto L22;
        if (r5 == null) goto L22;
        int r10 = r5.f437id;
        int r11 = r10 % this.HASH_SIZE;
        int r12 = this.keys[r11];
        if (r12 != (-1)) goto L10;
        return -1;
    L10:
        if (this.variables[r12] != r10) goto L12;
        return r12;
    L12:
        r12 = this.nextKeys[r12];
        if (r12 == (-1)) goto L17;
        if (this.variables[r12] != r10) goto L12;
    L17:
        if (r12 != (-1)) goto L20;
        return -1;
    L20:
        if (this.variables[r12] != r10) goto L22;
        return r12;
    L22:
        return -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void invert() {
        int r5 = this.mCount;
        int r10 = this.head;
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L8;
        float[] r12 = this.values;
        r12[r10] = r12[r10] * (-1.0f);
        r10 = this.next[r10];
        if (r10 == (-1)) goto L11;
        r11 = r11 + 1;
        goto L3
    L11:
        return;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void put(SolverVariable r10, float r11) {
        float r5 = epsilon;
        if (r11 > (-r5)) goto L5;
    L8:
        int r12 = 0;
        if (this.mCount != 0) goto L11;
        addVariable(0, r10, r11);
        addToHashMap(r10, 0);
        this.head = 0;
        return;
    L11:
        int r13 = indexOf(r10);
        if (r13 == (-1)) goto L15;
        this.values[r13] = r11;
        return;
    L15:
        if ((this.mCount + 1) < this.SIZE) goto L17;
        increaseSize();
    L17:
        int r14 = this.mCount;
        int r15 = this.head;
        int r16 = -1;
    L18:
        if (r12 >= r14) goto L29;
        int r17 = this.variables[r15];
        int r18 = r10.f437id;
        if (r17 == r18) goto L21;
        if (r17 >= r18) goto L25;
        r16 = r15;
    L25:
        r15 = this.next[r15];
        if (r15 == (-1)) goto L29;
        r12 = r12 + 1;
        goto L18
    L21:
        this.values[r15] = r11;
        return;
    L29:
        insertVariable(r16, r10, r11);
        return;
    L5:
        if (r11 >= r5) goto L8;
        remove(r10, HASH);
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float remove(SolverVariable r10, boolean r11) {
        int r5 = indexOf(r10);
        if (r5 != (-1)) goto L6;
        return 0.0f;
    L6:
        removeFromHashMap(r10);
        float r12 = this.values[r5];
        if (this.head != r5) goto L9;
        this.head = this.next[r5];
    L9:
        this.variables[r5] = -1;
        int[] r13 = this.previous;
        int r14 = r13[r5];
        if (r14 == (-1)) goto L12;
        int[] r15 = this.next;
        r15[r14] = r15[r5];
    L12:
        int r16 = this.next[r5];
        if (r16 == (-1)) goto L15;
        r13[r16] = r13[r5];
    L15:
        this.mCount--;
        r10.usageInRowCount--;
        if (r11 == false) goto L18;
        r10.removeFromRow(this.mRow);
    L18:
        return r12;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return 0;
    }

    public String toString() {
        String r5 = hashCode() + " { ";
        int r10 = this.mCount;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L18;
        SolverVariable r12 = getVariable(r11);
        if (r12 == null) goto L16;
        String r13 = r5 + r12 + " = " + getVariableValue(r11) + " ";
        int r14 = indexOf(r12);
        String r15 = j0.j(r13, "[p: ");
        if (this.previous[r14] == (-1)) goto L10;
        StringBuilder r16 = j0.u(r15);
        r16.append(this.mCache.mIndexedVariables[this.variables[this.previous[r14]]]);
        String r17 = r16.toString();
    L11:
        String r18 = j0.j(r17, ", n: ");
        if (this.next[r14] == (-1)) goto L14;
        StringBuilder r19 = j0.u(r18);
        r19.append(this.mCache.mIndexedVariables[this.variables[this.next[r14]]]);
        String r20 = r19.toString();
    L15:
        r5 = j0.j(r20, "]");
        goto L16
    L14:
        r20 = j0.j(r18, "none");
        goto L15
    L10:
        r17 = j0.j(r15, "none");
    L16:
        r11 = r11 + 1;
        goto L3
    L18:
        return j0.j(r5, " }");
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float use(ArrayRow r10, boolean r11) {
        float r5 = get(r10.variable);
        remove(r10.variable, r11);
        SolverVariableValues r12 = (SolverVariableValues) r10.variables;
        int r13 = r12.getCurrentSize();
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L8;
        int r16 = r12.variables[r15];
        if (r16 == (-1)) goto L7;
        add(this.mCache.mIndexedVariables[r16], r12.values[r15] * r5, r11);
        r14 = r14 + 1;
    L7:
        r15 = r15 + 1;
        goto L3
    L8:
        return r5;
    }
}
