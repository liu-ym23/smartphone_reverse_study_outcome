package com.ss.android.token;

import android.content.Context;
import com.bytedance.android.sdk.bdticketguard.j1;
import com.bytedance.android.sdk.bdticketguard.setting.l;
import com.bytedance.android.sdk.bdticketguard.setting.m;
import com.bytedance.android.sdk.bdticketguard.w0;
import com.bytedance.sdk.account.impl.j;
import com.ss.android.account.k;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.reflect.KProperty;
import ta7.b;
import ta7.c;
import tb7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c0 implements c {
    public static volatile boolean a;
    public static final AtomicBoolean b = null;
    public static final c0 c = null;

    public c0() {
    }

    static {
        c = new c0();
        b = new AtomicBoolean(false);
    }

    public final void M(b r15) {
        wqa.f r0 = k.b;
        if (r0 == null) goto L32;
        Context r1 = r0.getApplicationContext();
        if (r1 != null) goto L7;
        return;
    L7:
        if (r15.a != 0) goto L34;
        a.d("TokenGuardLoginListener", "Login status changed, check");
        if (j.m(r1).isLogin() == true) goto L11;
        return;
    L11:
        if (a == true) goto L36;
        a.d("TokenGuardLoginListener", "Login status changed to login, do login attestation");
        wqa.f r2 = k.b;
        if (r2 == null) goto L19;
        Context r3 = r2.getApplicationContext();
        if (r3 == null) goto L19;
        if (h0.d(r3) != true) goto L19;
        boolean r4 = true;
    L20:
        if (r4 == false) goto L37;
        l.l0.getClass();
        m r5 = l.n;
        KProperty[] r6 = l.d;
        KProperty r7 = r6[9];
        if (((Boolean) r5.a.a()).booleanValue() == true) goto L25;
        return;
    L25:
        if (b.compareAndSet(false, true) == true) goto L27;
        a.d("TokenGuardLoginListener", "doLoginAttestation, login attestation is triggered");
        return;
    L27:
        j1 r8 = w0.a;
        j1 r9 = w0.a;
        if (r9 == null) goto L30;
        a.d("TokenGuardLoginListener", "startKeyAttestation by login");
        m r10 = l.p;
        KProperty r11 = r6[11];
        r9.n(new com.bytedance.android.sdk.bdticketguard.data.a("login", true, true, 1000, ((Number) r10.a.a()).longValue() * 1000, ((Number) l.g().a()).intValue(), TokenGuardLoginListener.doLoginAttestation.1.INSTANCE));
        return;
    L30:
        a.d("TokenGuardLoginListener", "startKeyAttestation service is null");
        return;
    L37:
        return;
    L19:
        r4 = false;
        goto L20
    L36:
        return;
    L34:
        return;
    }
}
