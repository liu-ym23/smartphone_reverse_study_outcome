package com.bytedance.android.anniex.lite.flow;

import android.net.Uri;
import com.bytedance.android.anniex.engine.AnnieXLynxEngineManager;
import com.bytedance.ies.bullet.service.base.h;
import com.lynx.tasm.TemplateData;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import na.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends com.bytedance.android.anniex.lite.flow.base.b implements c {
    @Override // na.c
    public final void a() {
        if (h.A() == false) goto L6;
        CoroutineScopeKt.cancel$default(this.d, null, 1, null);
        return;
    }

    @Override // com.bytedance.android.anniex.lite.flow.base.b
    public final void e() {
        super.e();
        AnnieXLynxEngineManager.a.a(this.b, this.c);
    }

    @Override // com.bytedance.android.anniex.lite.flow.base.e
    public final void onRelease() {
        e();
    }

    @Override // na.c
    public final ra.a c(String r10, Uri r11, String r12, TemplateData r13) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r12, "sessionId");
        com.bytedance.android.anniex.lite.b.a.getClass();
        return com.bytedance.android.anniex.lite.b.b(r10, r11, r12, r13);
    }
}
