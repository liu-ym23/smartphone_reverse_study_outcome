package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.abs.ScanCodeResultModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class z1 {
    public final /* synthetic */ a2 a;

    public final void a() {
        Intrinsics.checkNotNullParameter("DefaultScanCodeService默认返回", com.bytedance.android.ec.core.event.a.KEY_RESULT);
        a2 r0 = this.a;
        ScanCodeResultModel r10 = new ScanCodeResultModel();
        r10.a(ScanCodeResultModel.Code.Success);
        r10.b("Scan Success !");
        r10.setResult("DefaultScanCodeService默认返回");
        r0.finishWithResult(r10);
    }

    public z1(a2 r1) {
        this.a = r1;
    }
}
