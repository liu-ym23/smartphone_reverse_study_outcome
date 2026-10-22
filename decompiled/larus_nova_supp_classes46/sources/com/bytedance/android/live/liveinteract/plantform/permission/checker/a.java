package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import android.app.Activity;
import android.os.Build;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.bpea.cert.token.TokenCert;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements qh0.a<rh0.a>, qh0.d<rh0.a> {
    public static final TokenCert d = null;
    public qh0.d<rh0.a> a;
    public final qh0.f.a b;
    public final qh0.a<rh0.a> c;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.permission.checker.a$a, reason: collision with other inner class name */
    public static final class C0061a {
    }

    static {
        d = TokenCert.Companion.with("bpea-androidpermissionchecker_request_permission");
    }

    @Override // qh0.a
    public final void a(qh0.d<rh0.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "consumer");
        this.a = r2;
        qh0.a<rh0.a> r3 = this.c;
        if (r3 == null) goto L5;
        r3.a(this);
        return;
    L5:
        c(null);
    }

    @Override // qh0.d
    public final void b(BaseCheckException r3) {
        Intrinsics.checkNotNullParameter(r3, "exception");
        qh0.d<rh0.a> r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r0.b(r3);
    }

    public final void c(rh0.a r7) {
        if (vm2.e.o() == true) goto L5;
    L20:
        qh0.d<rh0.a> r8 = this.a;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L23:
        r8.onResult(null);
        return;
    L5:
        if (Build.VERSION.SDK_INT < 31) goto L20;
        com.bytedance.android.livesdk.sharedpref.e r9 = com.bytedance.android.livesdk.sharedpref.c.o;
        if (((Boolean) r9.getValue()).booleanValue() == true) goto L20;
        TokenCert r2 = d;
        Activity r3 = ContextUtil.contextToActivity(this.b.getContext());
        if (r3 == null) goto L15;
        SettingKey r0 = m60.i.a;
        m60.i.b r1 = new m60.i.b(r3);
        r1.d = new b(r3, r2);
        c r4 = new c(this, r2);
        d r5 = new d(this, r2);
        ArrayList r6 = new ArrayList();
        r6.add("android.permission.BLUETOOTH_CONNECT");
        Object[] r10 = r6.toArray(new String[0]);
        if (r10 == null) goto L14;
        String[] r11 = (String[]) r10;
        r1.b(r4, r5, r2, (String[]) Arrays.copyOf(r11, r11.length));
    L19:
        com.bytedance.android.livesdk.sharedpref.f.d(r9, Boolean.TRUE);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L15:
        qh0.d<rh0.a> r12 = this.a;
        if (r12 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L18:
        r12.onResult(null);
        goto L19
    }

    @Override // qh0.d
    public final /* bridge */ /* synthetic */ void onResult(rh0.a r1) {
        c(r1);
    }

    public a(qh0.f.a r2, qh0.a<rh0.a> r3) {
        Intrinsics.checkNotNullParameter(r2, "createConfig");
        this.b = r2;
        this.c = r3;
    }
}
