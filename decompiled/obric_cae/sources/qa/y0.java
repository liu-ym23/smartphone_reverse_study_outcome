package qa;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class y0 extends c1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d0 f11228d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object[] f11229e;

    public y0(d1 r8, c0 r10, String r11, Object... r12) {
        super(r8);
        this.f11227c = r11;
        this.f11228d = r10;
        this.f11229e = r12;
    }

    @Override // qa.c1
    public final byte[] b(byte[] r8) {
        String r10 = t4.c(r8);
        if (TextUtils.isEmpty(r10) == false) goto L12;
        return null;
    L12:
        String r11 = String.format(t4.n(this.f11227c), this.f11229e);     // Catch: Throwable -> L8
    L11:
        return t4.i("{\"pinfo\":\"" + t4.c(this.f11228d.b(t4.i(r11))) + "\",\"els\":[" + r10 + "]}");
    L8:
        th = move-exception;
        th.printStackTrace();
        q.f("ofm", "gpj", th);
        r11 = "";
        goto L11
    }
}
