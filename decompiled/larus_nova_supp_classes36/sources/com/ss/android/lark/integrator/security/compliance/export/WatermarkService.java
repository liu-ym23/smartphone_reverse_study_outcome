package com.ss.android.lark.integrator.security.compliance.export;

import android.app.Dialog;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback;
import com.ss.android.lark.watermark.userscope.ToolsV3Kt;
import com.ss.android.lark.watermark.userscope.WatermarkImplFactoryV3;
import com.ss.android.lark.watermark.v2.o;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@OfficeSDKUserScope
public final class WatermarkService implements d {
    public final WatermarkImplFactoryV3 a;
    public final com.ss.android.lark.watermark.userscope.c b;
    public final Lazy c;
    public final Lazy d;

    @Override // com.ss.android.lark.integrator.security.compliance.export.d
    public final void K(Dialog r4) {
        Intrinsics.checkNotNullParameter(r4, "dialog");
        boolean r1 = true;
        if (((Boolean) this.d.getValue()).booleanValue() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        p4c.d r2 = ToolsV3Kt.a();
        if (r2 == null) goto L11;
        r1 = r2.enableDoubaoDialogWatermarkGlobalOnly();
    L11:
        if (r1 == true) goto L13;
        ((o) this.c.getValue()).a(r4, Boolean.valueOf(r0));
        return;
    L13:
        if (((Boolean) this.d.getValue()).booleanValue() == false) goto L17;
        ((o) this.c.getValue()).a(r4, Boolean.TRUE);
        return;
    L17:
        return;
    L5:
        if (((o) this.c.getValue()).s() != 0) goto L7;
        r0 = true;
        goto L8
    }

    @Override // com.ss.android.lark.integrator.security.compliance.export.d
    public final void L8(Dialog r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        ((o) this.c.getValue()).b(r2);
    }

    @Inject
    public WatermarkService(WatermarkImplFactoryV3 r2, com.ss.android.lark.watermark.userscope.c r3) {
        Intrinsics.checkNotNullParameter(r2, "watermarkImplFactoryV3");
        Intrinsics.checkNotNullParameter(r3, "watermarkModule");
        this.a = r2;
        this.b = r3;
        this.c = LazyKt.lazy(new WatermarkService$watermarkImpl$2(this));
        this.d = LazyKt.lazy(WatermarkService$enableDoubaoWatermark$2.INSTANCE);
    }

    @Override // com.ss.android.lark.integrator.security.compliance.export.d
    public final void w0(String r2, String r3, ByteString r4, IGetWaterMarkResourceCallback r5) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r5, "callback");
        this.b.w0(r2, r3, r4, r5);
    }
}
