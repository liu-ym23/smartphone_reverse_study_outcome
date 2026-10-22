package f1b;

import android.net.Uri;
import android.util.LruCache;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
import swb.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e extends y0b.c {
    public final WebView a;

    public e(WebView r2) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        this.a = r2;
    }

    @Override // y0b.c
    public final WebResourceResponse a(Uri r4) {
        if (r4 == null) goto L5;
        String r5 = UriProtector.getQueryParameter(r4, "path");
    L6:
        if (r5 == null) goto L11;
        LruCache<String, String> r1 = l0b.a.a;
        Intrinsics.checkNotNullParameter(r5, "key");
        String r6 = l0b.a.a.get(r5);
        if (r6 == null) goto L11;
        return new WebResourceResponse(j.i(r6), Charset.defaultCharset().name(), ContentResolverWrapper.openInputStream(this.a.getContext().getContentResolver(), UriProtector.parse(r6)));
    L11:
        return null;
    L5:
        r5 = null;
        goto L6
    }
}
