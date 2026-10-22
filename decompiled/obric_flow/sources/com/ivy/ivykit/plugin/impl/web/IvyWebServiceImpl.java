package com.ivy.ivykit.plugin.impl.web;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.Keep;
import com.ivy.ivykit.api.plugin.IIvyWebService;
import com.ss.android.ugc.aweme.framework.services.annotation.ServiceImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@ServiceImpl
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003Je\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b!\u0010 J\u001f\u0010%\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0016¢\u0006\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/ivy/ivykit/plugin/impl/web/IvyWebServiceImpl;", "Lcom/ivy/ivykit/api/plugin/IIvyWebService;", "<init>", "()V", "", "bizId", "schema", "Lol/d;", "callback", "Lol/c;", "lifeCycle", "Lol/e;", "eventCallbacks", "Lol/g;", "scrollCallbacks", "Lol/f;", "responseCallbacks", "Landroid/graphics/Bitmap;", "defaultVideoPoster", "Lol/a;", "registerHolderCallback", "Lrl/a;", "createIvyWebClient", "(Ljava/lang/String;Ljava/lang/String;Lol/d;Lol/c;Lol/e;Lol/g;Lol/f;Landroid/graphics/Bitmap;Lol/a;)Lrl/a;", "webViewClient", "Landroid/content/Context;", "context", "Lql/b;", "createIvyWebView", "(Ljava/lang/String;Lrl/a;Landroid/content/Context;)Lql/b;", "", "preCreateWebview", "(Landroid/content/Context;)V", "tryStartChromium", "", "runInIdle", "checkGlobalWebViewWarmupStatus", "tryWarmup", "(ZZ)V", "ivy_plugin_impl_bullet_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IvyWebServiceImpl implements IIvyWebService {
    public IvyWebServiceImpl() {
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyWebService
    public rl.a createIvyWebClient(String r11, String r12, ol.d r13, ol.c r14, ol.e r15, ol.g r16, ol.f r17, Bitmap r18, ol.a r19) {
        Intrinsics.checkNotNullParameter(r11, "bizId");
        Intrinsics.checkNotNullParameter(r12, "schema");
        return new j(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyWebService
    public ql.b createIvyWebView(String r5, rl.a r10, Context r11) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r10, "webViewClient");
        Intrinsics.checkNotNullParameter(r11, "context");
        if ((r10 instanceof j) == true) goto L6;
        r10 = null;
    L6:
        if (r10 != null) goto L8;
        return null;
    L8:
        return new h(r5, (j) r10, r11);
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyWebService
    public void preCreateWebview(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyWebService
    public void tryStartChromium(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyWebService
    public void tryWarmup(boolean r5, boolean r10) {
    }
}
