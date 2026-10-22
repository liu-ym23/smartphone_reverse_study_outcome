package com.bytedance.pia.core.setting;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.pia.core.utils.j;
import com.lynx.tasm.p;
import io.reactivex.internal.observers.h;
import kotlin.Lazy;
import lh.g;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f7084a = null;

    static {
        f7084a = new b();
        new a(null, 15);
    }

    public final synchronized void a(Uri r10) {
        monitor-enter(this);
        if (r10 != null) goto L45;
        monitor-exit(this);
        return;
    L45:
    L14:
        th = move-exception;
        throw th;
    L7:
        if (j.z(r10) == false) goto L33;
        Lazy r5 = Settings.B;     // Catch: Throwable -> L14
        String r11 = ((g) p.a().A.getValue()).a(r10);     // Catch: Throwable -> L14
        if (r11 != null) goto L12;
    L16:
        String r12 = r10.getAuthority();     // Catch: Throwable -> L14
        String r13 = r10.getPath();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r12) == true) goto L33;
        if (TextUtils.isEmpty(r13) == true) goto L33;
        StringBuilder r14 = new StringBuilder("pia_page/");     // Catch: Throwable -> L14
        String r15 = h.b(r12, r13);     // Catch: Throwable -> L14
        int r16 = 0;
    L23:
        if (r16 >= r15.length()) goto L32;
        char r17 = r15.charAt(r16);     // Catch: Throwable -> L14
        if (r17 != '-') goto L27;
        r14.append("--");     // Catch: Throwable -> L14
    L31:
        r16 = r16 + 1;     // Catch: Throwable -> L14
        goto L23
    L27:
        if (r17 == '.') goto L29;
        r14.append(r17);     // Catch: Throwable -> L14
        goto L31
    L29:
        r14.append('-');     // Catch: Throwable -> L14
        goto L31
    L32:
        r11 = r14.toString();     // Catch: Throwable -> L14
    L34:
        if (r11 != null) goto L36;
    L41:
        monitor-exit(this);
        return;
    L36:
        if (r11.length() == 0) goto L41;
        Application r18 = zg.b.f23438a;     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L12:
        if (r11.length() != 0) goto L34;
    L33:
        r11 = null;
        goto L34
    }
}
