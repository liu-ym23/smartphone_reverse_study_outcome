package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import android.app.Activity;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.bpea.cert.token.TokenCert;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements qh0.a<rh0.a>, qh0.d<rh0.a> {
    public static final TokenCert d = null;
    public qh0.d<rh0.a> a;
    public final qh0.f.c b;
    public final qh0.a<rh0.a> c;

    public static final class a {
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

    public final void c(rh0.a r10) {
        TokenCert r11 = d;
        Activity r0 = ContextUtil.contextToActivity(this.b.getContext());
        if (r0 != null) goto L8;
        qh0.d<rh0.a> r12 = this.a;
        if (r12 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L7:
        qh0.f.c r1 = this.b;
        r12.b(new BaseCheckException(r1.c, r1.b, BaseCheckException.CheckType.AndroidPermission, "context is not Activity", null, 16, null));
        return;
    L8:
        SettingKey r2 = m60.i.a;
        m60.i.b r3 = new m60.i.b(r0);
        r3.d = new j(r0, r11);
        k r4 = new k(this, r11);
        l r5 = new l(this, r11);
        boolean r6 = true;
        if (this.b.c == 1) goto L11;
    L13:
        r6 = false;
    L14:
        ArrayList r7 = new ArrayList();
        r7.add("android.permission.RECORD_AUDIO");
        if (r6 == false) goto L17;
        r7.add("android.permission.CAMERA");
    L17:
        Object[] r8 = r7.toArray(new String[0]);
        if (r8 == null) goto L22;
        String[] r9 = (String[]) r8;
        r3.b(r4, r5, r11, (String[]) Arrays.copyOf(r9, r9.length));
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L11:
        if (((Boolean) vm2.g.f.getValue(null, vm2.g.a[4])).booleanValue() == false) goto L13;
        goto L13
    }

    @Override // qh0.d
    public final /* bridge */ /* synthetic */ void onResult(rh0.a r1) {
        c(r1);
    }

    public i(qh0.f.c r2, qh0.a<rh0.a> r3) {
        Intrinsics.checkNotNullParameter(r2, "createConfig");
        this.b = r2;
        this.c = r3;
    }
}
