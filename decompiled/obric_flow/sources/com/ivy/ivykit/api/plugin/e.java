package com.ivy.ivykit.api.plugin;

import android.content.Context;
import android.graphics.Bitmap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements IIvyWebService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ e f9489a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f9490b = null;

    static {
        f9489a = new e();
        f9490b = LazyKt.lazy(IIvyWebService$Companion$impl$2.f9475a);
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyWebService
    public final rl.a createIvyWebClient(String r12, String r13, ol.d r14, ol.c r15, ol.e r16, ol.g r17, ol.f r18, Bitmap r19, ol.a r20) {
        Intrinsics.checkNotNullParameter(r12, "bizId");
        Intrinsics.checkNotNullParameter(r13, "schema");
        IIvyWebService r5 = (IIvyWebService) f9490b.getValue();
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.createIvyWebClient(r12, r13, r14, r15, r16, r17, r18, r19, null);
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyWebService
    public final ql.b createIvyWebView(String r5, rl.a r10, Context r11) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r10, "webViewClient");
        Intrinsics.checkNotNullParameter(r11, "context");
        IIvyWebService r12 = (IIvyWebService) f9490b.getValue();
        if (r12 != null) goto L5;
        return null;
    L5:
        return r12.createIvyWebView(r5, r10, r11);
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyWebService
    public final void preCreateWebview(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        IIvyWebService r10 = (IIvyWebService) f9490b.getValue();
        if (r10 == null) goto L6;
        r10.preCreateWebview(r5);
        return;
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyWebService
    public final void tryStartChromium(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        IIvyWebService r10 = (IIvyWebService) f9490b.getValue();
        if (r10 == null) goto L6;
        r10.tryStartChromium(r5);
        return;
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyWebService
    public final void tryWarmup(boolean r5, boolean r10) {
        IIvyWebService r11 = (IIvyWebService) f9490b.getValue();
        if (r11 == null) goto L6;
        r11.tryWarmup(r5, r10);
        return;
    }
}
