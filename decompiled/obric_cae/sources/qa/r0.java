package qa;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s4 f10961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10962c;

    public r0(Context r8, s4 r10, String r11) {
        this.f10960a = r8.getApplicationContext();
        this.f10961b = r10;
        this.f10962c = r11;
    }

    public final byte[] a() {
        Context r8 = this.f10960a;
        s4 r10 = this.f10961b;
        String r11 = this.f10962c;
        StringBuilder r12 = new StringBuilder();
        r12.append("\"sdkversion\":\"");     // Catch: Throwable -> L10
        r12.append(r10.b());     // Catch: Throwable -> L10
        r12.append("\",\"product\":\"");     // Catch: Throwable -> L10
        r12.append(r10.a());     // Catch: Throwable -> L10
        r12.append("\",\"nt\":\"");     // Catch: Throwable -> L10
        int r13 = k4.d(r8);     // Catch: Throwable -> L6
    L8:
        r12.append(r13);     // Catch: Throwable -> L10
        r12.append("\",\"details\":");     // Catch: Throwable -> L10
        r12.append(r11);     // Catch: Throwable -> L10
    L13:
        return t4.i(r12.toString());
    L6:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L10
        r13 = -1;
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L13
    }
}
