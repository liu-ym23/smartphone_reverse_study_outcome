package com.bytedance.android.live.core.utils;

import android.webkit.WebView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class LoadUrlUtils {
    static final a IMPL = null;

    public static class a {
        public void a(WebView r1, String r2) {
            throw null;
        }

        public a() {
        }
    }

    public static class b extends a {
        public b() {
        }

        @Override // com.bytedance.android.live.core.utils.LoadUrlUtils.a
        public final void a(WebView r3, String r4) {
            if (r3 != null) goto L4;
            return;
        L4:
            boolean r0 = false;
            if (r4 != null) goto L7;
        L13:
            if (r0 == true) goto L21;
            r3.loadUrl(r4);     // Catch: Throwable -> L16
            return;
        L22:
            return;
        L21:
            return;
        L7:
            if (r4.startsWith("javascript:") == false) goto L13;
            r3.evaluateJavascript(r4, null);     // Catch: Throwable -> L11
            r0 = true;
        L11:
            th = move-exception;
            boolean r1 = th instanceof IllegalStateException;
            goto L13
        }
    }

    public LoadUrlUtils() {
    }

    static {
        IMPL = new b();
    }

    public static void loadUrl(WebView r1, String r2) {
        IMPL.a(r1, r2);
    }
}
