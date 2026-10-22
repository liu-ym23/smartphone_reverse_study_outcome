package j1;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f18228b;

    public /* synthetic */ f(g r5, int r10) {
        this.f18227a = r10;
        this.f18228b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g r5 = this.f18228b;
        switch(this.f18227a) {
            case 0: goto L28;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");
        Intrinsics.checkNotNullParameter("[WebViewAIBridgePort] try use web message channel", "msg");
        a1.a.f43a.d("ai_bridge", "[WebViewAIBridgePort] try use web message channel");
        WebView r10 = (WebView) r5.f18229c.get();
        if (r10 != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(c1.b.c().getLooper(), Looper.myLooper()) == true) goto L10;
        Intrinsics.checkNotNullParameter("ThreadUtils", "tag");
        Intrinsics.checkNotNullParameter("checkMainThread not in main thread", "msg");
        a1.a.f43a.e("ThreadUtils", "checkMainThread not in main thread", null);
    L10:
        WebSettings r11 = r10.getSettings();
        int r12 = -1;
        if (r11 == null) goto L24;
        String r13 = r11.getUserAgentString();
        if (r13 == null) goto L24;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L17
        Object r15 = Result.m124constructorimpl(Integer.valueOf(Integer.parseInt(StringsKt.X(StringsKt.S(r13.toLowerCase(Locale.getDefault()), "chrome/"), "."))));     // Catch: Throwable -> L17
    L20:
        if (Result.m130isFailureimpl(r15) == false) goto L22;
        r15 = -1;
    L22:
        r12 = ((Number) r15).intValue();
    L17:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r15 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L24:
        if (r12 < 66) goto L35;
        WebMessagePort[] r17 = r10.createWebMessageChannel();
        r17[0].setWebMessageCallback(new hh.b(r5, r17, 1), (Handler) c1.b.f1104c.getValue());
        r10.postWebMessage(new WebMessage("__channel_init__", new WebMessagePort[]{r17[1]}), Uri.EMPTY);
        return;
    L35:
        return;
    L28:
        WebMessagePort r18 = r5.e;
        if (r18 == null) goto L36;
        r18.close();
        return;
    }
}
