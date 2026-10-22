package com.bytedance.ai.lynx;

import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.LynxView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends com.bytedance.ies.bullet.core.container.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.sdk.xbridge.cn.platform.lynx.a f2194c;
    public final /* synthetic */ LynxView d;

    public m(com.bytedance.sdk.xbridge.cn.platform.lynx.a r5, LynxView r10, String r11, String r12) {
        this.f2192a = r11;
        this.f2193b = r12;
        this.f2194c = r5;
        this.d = r10;
    }

    @Override // com.bytedance.ies.bullet.core.container.e
    public final void c(com.bytedance.ies.bullet.lynx.impl.b r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        String r10 = r5.f5650b;
        Object r11 = (JSONObject) r5.f5651c;
        LynxView r12 = this.d;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Intrinsics.checkNotNullParameter(r10, "eventName");
        boolean r13 = r11 instanceof List;
        if (r13 == false) goto L10;
        if (r13 == false) goto L6;
        List r14 = (List) r11;
    L7:
        if (r14 != null) goto L9;
        r14 = new ArrayList();
    L9:
        com.bytedance.android.anniex.utils.e.e(r12, r10, new JavaOnlyArray(r14));
        return;
    L6:
        r14 = null;
        goto L7
    L10:
        com.bytedance.android.anniex.utils.e.e(r12, r10, new JavaOnlyArray(Arrays.asList(new Object[]{r11})));
    }

    @Override // com.bytedance.ies.bullet.core.container.e
    public final com.bytedance.ies.bullet.core.e getBulletContext() {
        Lazy r5 = com.bytedance.ies.bullet.core.f.f5312b;
        td.b.b().getClass();
        com.bytedance.ies.bullet.core.e r10 = new com.bytedance.ies.bullet.core.e();
        String r11 = this.f2192a;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r10.f5291a = r11;
        r10.f = this.f2193b;
        r10.f5294h = this.f2194c.f7453a;
        return r10;
    }

    @Override // com.bytedance.ies.bullet.core.container.e
    public final String getSessionId() {
        return this.f2192a;
    }
}
