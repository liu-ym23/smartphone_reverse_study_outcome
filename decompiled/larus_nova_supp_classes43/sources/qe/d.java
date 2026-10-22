package qe;

import android.webkit.WebView;
import com.bytedance.android.livesdkapi.jsb.IExternalLiveWebCallback;
import kotlin.jvm.internal.Intrinsics;
import pd.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements IExternalLiveWebCallback {
    public final /* synthetic */ i a;

    public d(i r1) {
        this.a = r1;
    }

    public final void onPageFinished(WebView r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "webView");
        i r0 = this.a;
        if (r0 == null) goto L6;
        r0.onPageFinished(r10, r11);
        return;
    }

    public final void onPageStarted(WebView r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "webView");
        i r0 = this.a;
        if (r0 == null) goto L6;
        r0.onPageStarted(r10, r11);
        return;
    }

    public final void onReceivedError(WebView r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "webView");
        i r0 = this.a;
        if (r0 == null) goto L6;
        r0.onReceivedError(r10, r11, r12);
        return;
    }
}
