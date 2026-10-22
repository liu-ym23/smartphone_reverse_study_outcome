package zc;

import android.util.Log;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f14330b;

    public a() {
        this.f14329a = "OUI_SDK";
        this.f14330b = false;
    }

    public final void a(int r8, String r10, String r11, Throwable r12) {
        i.f(r11, "msg");
        if (r10 != null) goto L5;
    L8:
        boolean r13 = true;
    L9:
        if (r13 == true) goto L13;
        r11 = defpackage.a.f(r10, "-->", r11);
    L13:
        if (this.f14330b == false) goto L15;
        StringBuilder r14 = new StringBuilder("[");
        Thread r15 = Thread.currentThread();
        i.e(r15, "Thread.currentThread()");
        r14.append(r15.getName());
        r14.append("]|");
        r14.append(r11);
        r11 = r14.toString();
    L15:
        String r16 = this.f14329a;
        if (r8 != 1) goto L18;
        Log.v(r16, r11);
        return;
    L18:
        if (r8 != 2) goto L20;
        Log.d(r16, r11);
        return;
    L20:
        if (r8 != 4) goto L22;
        Log.i(r16, r11);
        return;
    L22:
        if (r8 != 8) goto L24;
        if (r12 != null) goto L31;
        Log.w(r16, r11);
        return;
    L31:
        Log.w(r16, r11, r12);
        return;
    L24:
        if (r8 != 16) goto L42;
        if (r12 != null) goto L28;
        Log.e(r16, r11);
        return;
    L28:
        Log.e(r16, r11, r12);
        return;
    L42:
        return;
    L5:
        if (r10.length() == 0) goto L8;
        r13 = false;
        goto L9
    }
}
