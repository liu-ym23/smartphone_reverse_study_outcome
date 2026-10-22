package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import android.app.Activity;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.bpea.cert.token.TokenCert;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements qh0.a<rh0.a> {
    public static final TokenCert b = null;
    public final qh0.f.b a;

    public static final class a {
    }

    static {
        b = TokenCert.Companion.with("bpea-androidcamerapermissionchecker_request_permission");
    }

    public e(qh0.f.b r2) {
        Intrinsics.checkNotNullParameter(r2, "createConfig");
        this.a = r2;
    }

    @Override // qh0.a
    public final void a(qh0.d<rh0.a> r6) {
        Intrinsics.checkNotNullParameter(r6, "consumer");
        TokenCert r0 = b;
        Activity r1 = ContextUtil.contextToActivity(this.a.getContext());
        if (r1 == null) goto L6;
        SettingKey r2 = m60.i.a;
        m60.i.b r3 = new m60.i.b(r1);
        r3.d = new f(r1, r6, r0);
        g r4 = new g(this, r6, r0);
        h r5 = new h(this, r6, r0);
        String[] r7 = {"android.permission.CAMERA"};
        r3.b(r4, r5, r0, (String[]) Arrays.copyOf(r7, r7.length));
        return;
    }
}
