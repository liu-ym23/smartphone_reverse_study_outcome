package lxb;

import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.quality.hang.HangRecoveryStrategy;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import otb.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements lxb.a {

    public static final class a {
    }

    static {
    }

    public b() {
        HangRecoveryStrategy r0 = HangRecoveryStrategy.TERMINATE_RENDER_PROCESS;
    }

    @Override // lxb.a
    public final boolean a(OfficeWebView r2) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        Lazy<n> r3 = TTWebViewUtil.a;
        TTWebViewUtil.a.d(null);
        return false;
    }
}
