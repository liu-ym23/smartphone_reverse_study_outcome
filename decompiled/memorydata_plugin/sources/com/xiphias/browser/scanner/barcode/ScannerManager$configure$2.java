package com.xiphias.browser.scanner.barcode;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class ScannerManager$configure$2 extends FunctionReferenceImpl implements Function1<a, Unit> {
    ScannerManager$configure$2(Object r8) {
        super(1, r8, d.class, "onResult", "onResult(Lcom/xiphias/browser/scanner/barcode/BarDecodeResult;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(a r3) {
        invoke2((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(a r3) {
        ((d) ZeusTransformUtils.preCheckCast(this.receiver, d.class, "com.obric.memorydata.plugin")).a(r3);
    }
}
