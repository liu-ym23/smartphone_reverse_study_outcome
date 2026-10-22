package lxb;

import android.os.Build;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewRenderProcess;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.quality.hang.HangRecoveryStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements lxb.a {

    public static final class a {
    }

    static {
    }

    public c() {
        HangRecoveryStrategy r0 = HangRecoveryStrategy.TERMINATE_RENDER_PROCESS;
    }

    @Override // lxb.a
    public final boolean a(OfficeWebView r5) {
        Intrinsics.checkNotNullParameter(r5, "webView");
        if (Build.VERSION.SDK_INT >= 29) goto L13;
        j.e("TerminateRprRecovery", "recover: api < 29, skip terminate");
        return false;
    L13:
        WebViewRenderProcess r6 = WebViewCompat.getWebViewRenderProcess(r5);     // Catch: Throwable -> L10
        if (r6 == null) goto L15;
        return r6.terminate();
    L15:
        return false;
    L10:
        th = move-exception;
        j.c("TerminateRprRecovery", "terminate render process error", th);
        return false;
    }
}
