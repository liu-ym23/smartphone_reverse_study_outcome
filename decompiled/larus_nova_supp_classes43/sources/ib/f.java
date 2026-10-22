package ib;

import android.webkit.WebView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface f {

    public static class a implements f {
        public a() {
        }

        public void a(String r1, WebView r10) {
        }

        public void b(String r1, WebView r10, String r11) {
        }

        @Override // ib.f
        public void onLoadFail(String r1, WebView r10, Throwable r11) {
            Intrinsics.checkNotNullParameter(r11, "e");
        }

        @Override // ib.f
        public void onLoadStart(String r1, WebView r10) {
        }

        @Override // ib.f
        public void onLoadUriSuccess(String r1, WebView r10) {
        }
    }

    void onLoadFail(String r1, WebView r10, Throwable r11);

    void onLoadStart(String r1, WebView r10);

    void onLoadUriSuccess(String r1, WebView r10);
}
