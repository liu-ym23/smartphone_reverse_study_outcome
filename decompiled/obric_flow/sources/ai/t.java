package ai;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends w0 {
    public static final t d = null;
    public static final t e = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f295c;

    static {
        d = new t(0);
        e = new t(1);
    }

    public /* synthetic */ t(int r5) {
        this.f295c = r5;
    }

    @Override // ai.w0
    public final void a(e0 r5, Object r10) {
        switch(this.f295c) {
            case 0: goto L18;
            case 1: goto L13;
            case 2: goto L9;
            default: goto L4;
        };
    L4:
        if (r10 == null) goto L8;
        r5.d = r10.toString();
        return;
    L8:
        throw new NullPointerException("@Url parameter is null.");
    L9:
        if (r10 != null) goto L12;
        return;
    L12:
        throw new RuntimeException("wrong type:" + r10.getClass() + ",not implement QueryParamObject");
    L13:
        okhttp3.j0 r11 = (okhttp3.j0) r10;
        if (r11 == null) goto L16;
        okhttp3.i0 r12 = r5.s;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r11, "part");
        r12.f20662c.add(r11);
    L16:
        r5.f202u = true;
        return;
    L18:
        okhttp3.q0 r13 = (okhttp3.q0) r10;
        if (r13 == null) goto L23;
        r5.f201t = r13;
        r5.f202u = true;
        return;
    L23:
        throw new IllegalArgumentException("Body parameter value must not be null.");
    }
}
