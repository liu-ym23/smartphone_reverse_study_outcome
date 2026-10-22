package com.xiphias.browser.scanner.barcode;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b0\tJ$\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b0\tJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/xiphias/browser/scanner/barcode/OptionalBarcodeDecoderFactory;", "", "<init>", "()V", "createZxing", "Lcom/xiphias/browser/scanner/barcode/BarcodeDecoder;", "context", "Landroid/content/Context;", "resultCallback", "Lkotlin/Function1;", "Lcom/xiphias/browser/scanner/barcode/BarDecodeResult;", "", "createBach", "loadProvider", "Lcom/xiphias/browser/scanner/barcode/BarcodeDecoderProvider;", "className", "", "BACH_PROVIDER_CLASS", "ZXING_PROVIDER_CLASS", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f16333a = null;

    static {
        f16333a = new f();
    }

    private f() {
    }

    private final c a(String r3) {
        Object r4 = ZeusTransformUtils.forName(r3, "com.obric.memorydata.plugin").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: ReflectiveOperationException -> L5
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.xiphias.browser.scanner.barcode.BarcodeDecoderProvider");     // Catch: ReflectiveOperationException -> L5
        return (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        throw new IllegalStateException("The selected scanner capability is not included in this AScan artifact", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final b a(Context r3, Function1<? super a, Unit> r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Function1<? super a, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "resultCallback");
        return a("com.xiphias.browser.scanner.zxing.ZxingBarcodeDecoderProvider").a(r5, r6);
    }

    public final b b(Context r3, Function1<? super a, Unit> r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Function1<? super a, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "resultCallback");
        return a("com.xiphias.browser.scanner.bach.BachBarcodeDecoderProvider").a(r5, r6);
    }
}
