package com.ivy.ivykit.api.plugin;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.Keep;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\bg\u0018\u0000 %2\u00020\u0001:\u0001&Js\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u001f\u0010\u001eJ#\u0010#\u001a\u00020\u001c2\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020 H&¢\u0006\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/ivy/ivykit/api/plugin/IIvyWebService;", "", "", "bizId", "schema", "Lol/d;", "callback", "Lol/c;", "lifeCycle", "Lol/e;", "eventCallbacks", "Lol/g;", "scrollCallbacks", "Lol/f;", "responseCallbacks", "Landroid/graphics/Bitmap;", "defaultVideoPoster", "Lol/a;", "registerHolderCallback", "Lrl/a;", "createIvyWebClient", "(Ljava/lang/String;Ljava/lang/String;Lol/d;Lol/c;Lol/e;Lol/g;Lol/f;Landroid/graphics/Bitmap;Lol/a;)Lrl/a;", "webViewClient", "Landroid/content/Context;", "context", "Lql/b;", "createIvyWebView", "(Ljava/lang/String;Lrl/a;Landroid/content/Context;)Lql/b;", "", "preCreateWebview", "(Landroid/content/Context;)V", "tryStartChromium", "", "runInIdle", "checkGlobalWebViewWarmupStatus", "tryWarmup", "(ZZ)V", "Companion", "com/ivy/ivykit/api/plugin/e", "ivy_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IIvyWebService {
    public static final e Companion = null;

    static {
        Companion = e.f9489a;
    }

    rl.a createIvyWebClient(String r5, String r10, ol.d r11, ol.c r12, ol.e r13, ol.g r14, ol.f r15, Bitmap r16, ol.a r17);

    ql.b createIvyWebView(String r5, rl.a r10, Context r11);

    void preCreateWebview(Context r5);

    void tryStartChromium(Context r5);

    void tryWarmup(boolean r5, boolean r10);
}
