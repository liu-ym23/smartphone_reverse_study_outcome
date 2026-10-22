package com.xiphias.browser.scanner.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/xiphias/browser/scanner/feature/OptionalVisionFeature;", "", "<init>", "()V", "provider", "Lcom/xiphias/browser/scanner/feature/VisionFeatureProvider;", "PROVIDER_CLASS", "", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16322a = null;

    static {
        f16322a = new a();
    }

    private a() {
    }

    public final b a() {
        Object r0 = ZeusTransformUtils.forName("com.xiphias.browser.scanner.vision.VisionFeatureProviderImpl", "com.obric.memorydata.plugin").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: ReflectiveOperationException -> L5
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.xiphias.browser.scanner.feature.VisionFeatureProvider");     // Catch: ReflectiveOperationException -> L5
        return (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        throw new IllegalStateException("Vision search is not included in this AScan artifact", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }
}
