package com.bytedance.ies.bullet.lynx.resource.forest;

import android.text.TextUtils;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.w;
import com.lynx.tasm.behavior.ui.utils.n;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends fo.h implements com.bytedance.ies.bullet.forest.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5756b;

    public c(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "downloadEngine");
        this.f5755a = r5;
        this.f5756b = r10;
    }

    @Override // fo.h
    public final void a(n r10, final fo.g r11) {
        Intrinsics.checkNotNullParameter(r10, "request");
        Intrinsics.checkNotNullParameter(r11, "callback");
        String r12 = (String) r10.f10761a;
        if (TextUtils.isEmpty(r12) == true) goto L5;
    L4:
        String r5 = r12;
        if (r5 == null) goto L9;
        zm.c r13 = com.bytedance.ies.bullet.forest.f.f5397a;
        Scene r14 = Scene.f4346b;
        Function1<w, Unit> r15 = new ForestExternalJSProvider$request$2$1(r11);
        String r16 = this.f5756b;
        com.bytedance.ies.bullet.forest.f.e(r5, this.f5755a, r14, r16, null, null, r15, 225);
        return;
    L9:
        return;
    L5:
        r12 = null;
        goto L4
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final String forestDownloadEngine(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.c(r5);
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final boolean hasGeckoModelInfo(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.n(r5);
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final String sessionID(com.bytedance.ies.bullet.core.e r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        return r5.getSessionId();
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final boolean useForest(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.q(r5);
    }
}
