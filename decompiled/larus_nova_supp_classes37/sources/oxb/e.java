package oxb;

import com.ss.android.lark.officesdk.di.core.deps.webview.PlatformPluginVersion;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.webview_api.adapter.OfficeRenderInWebViewServiceAdapter;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface e extends j {
    void G(OfficeRenderInWebViewServiceAdapter.a r1);

    void I(String r1, gxb.c r2);

    void J(OfficeWebView r1);

    void L(String r1, gxb.c r2);

    void a(String r1);

    otb.c c(String r1);

    boolean d();

    exb.e f(String r1);

    otb.i g(String r1);

    exb.a getLogger();

    void h(String r1);

    Map<PlatformPluginVersion, Boolean> p();

    void w(otb.b r1);

    void x(otb.b r1);
}
