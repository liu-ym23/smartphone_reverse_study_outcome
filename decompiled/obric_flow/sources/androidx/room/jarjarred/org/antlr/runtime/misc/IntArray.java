package androidx.room.jarjarred.org.antlr.runtime.misc;

/* JADX INFO: loaded from: classes.dex */
public class IntArray {
    public static final int INITIAL_SIZE = 10;
    public int[] data;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected int f632p;

    public IntArray() {
        this.f632p = -1;
    }

    public void add(int r5) {
        ensureCapacity(this.f632p + 1);
        int[] r10 = this.data;
        int r11 = this.f632p + 1;
        this.f632p = r11;
        r10[r11] = r5;
    }

    public void clear() {
        this.f632p = -1;
    }

    public void ensureCapacity(int r5) {
        int[] r10 = this.data;
        if (r10 != null) goto L5;
        this.data = new int[10];
        return;
    L5:
        int r11 = r5 + 1;
        if (r11 < r10.length) goto L14;
        int r12 = r10.length * 2;
        if (r5 > r12) goto L11;
        r11 = r12;
    L11:
        int[] r13 = new int[r11];
        System.arraycopy(r10, 0, r13, 0, r10.length);
        this.data = r13;
        return;
    }

    public int pop() {
        int[] r5 = this.data;
        int r10 = this.f632p;
        int r11 = r5[r10];
        this.f632p = r10 - 1;
        return r11;
    }

    public void push(int r5) {
        add(r5);
    }

    public int size() {
        return this.f632p;
    }
}
