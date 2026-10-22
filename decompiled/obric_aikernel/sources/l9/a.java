package l9;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10916a = null;

    static {
        f10916a = new a();
    }

    private a() {
    }

    public final int a(boolean r10, int r11, int r12) {
        if (r10 == false) goto L9;
        if (r12 > 0) goto L8;
        r12 = 1;
    L8:
        return r11 % r12;
    L9:
        return r11;
    }
}
