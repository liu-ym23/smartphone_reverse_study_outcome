package i0;

/* JADX INFO: loaded from: classes.dex */
public class d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f8081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8082b;

    public d(int r8) {
        if (r8 <= 0) goto L7;
        this.f8081a = new Object[r8];
        return;
    L7:
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    public T a() {
        int r8 = this.f8082b;
        if (r8 <= 0) goto L6;
        int r10 = r8 - 1;
        Object[] r11 = this.f8081a;
        T r12 = (T) r11[r10];
        r11[r10] = null;
        this.f8082b = r8 - 1;
        return r12;
    L6:
        return null;
    }

    public boolean b(T r8) {
        int r10 = 0;
    L3:
        int r11 = this.f8082b;
        Object[] r12 = this.f8081a;
        if (r10 >= r11) goto L9;
        if (r12[r10] == r8) goto L7;
        r10 = r10 + 1;
        goto L3
    L7:
        boolean r13 = true;
    L10:
        if (r13 == true) goto L17;
        if (r11 >= r12.length) goto L15;
        r12[r11] = r8;
        this.f8082b = r11 + 1;
        return true;
    L15:
        return false;
    L17:
        throw new IllegalStateException("Already in the pool!");
    L9:
        r13 = false;
        goto L10
    }
}
