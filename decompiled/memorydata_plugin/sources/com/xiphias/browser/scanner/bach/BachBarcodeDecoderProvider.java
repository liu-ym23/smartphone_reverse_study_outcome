package com.xiphias.browser.scanner.bach;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.xiphias.browser.scanner.barcode.b;
import com.xiphias.browser.scanner.barcode.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b0\tH\u0016¨\u0006\f"}, d2 = {"Lcom/xiphias/browser/scanner/bach/BachBarcodeDecoderProvider;", "Lcom/xiphias/browser/scanner/barcode/BarcodeDecoderProvider;", "<init>", "()V", "create", "Lcom/xiphias/browser/scanner/barcode/BarcodeDecoder;", "context", "Landroid/content/Context;", "resultCallback", "Lkotlin/Function1;", "Lcom/xiphias/browser/scanner/barcode/BarDecodeResult;", "", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BachBarcodeDecoderProvider implements c {
    public BachBarcodeDecoderProvider() {
    }

    @Override // com.xiphias.browser.scanner.barcode.c
    public b a(Context r2, Function1<? super com.xiphias.browser.scanner.barcode.a, Unit> r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r4, "resultCallback");
        return (b) ZeusTransformUtils.preCheckCast(new BachBarCoder(r1, r4), b.class, "com.obric.memorydata.plugin");
    }
}
