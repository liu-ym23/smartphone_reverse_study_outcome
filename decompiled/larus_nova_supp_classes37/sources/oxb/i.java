package oxb;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface i extends j {
    void A(WebResourceRequest r1);

    WebResourceResponse k(WebView r1, String r2);

    boolean shouldOverrideUrlLoading(WebView r1, WebResourceRequest r2);

    boolean shouldOverrideUrlLoading(WebView r1, String r2);

    void z(String r1);
}
