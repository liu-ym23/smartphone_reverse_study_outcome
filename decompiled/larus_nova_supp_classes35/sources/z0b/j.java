package z0b;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.OpenConfig;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ModelChameleonActivity;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.officesdk.utils.di.u;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import ntb.l;
import ntb.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j implements y0b.b {
    public final ChameleonWebView a;
    public final ChameleonConfig b;

    public j(ChameleonWebView r2, ChameleonConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        Intrinsics.checkNotNullParameter(r3, "chameleonConfig");
        this.a = r2;
        this.b = r3;
    }

    @Override // y0b.b
    public final WebResourceResponse shouldInterceptRequest(Uri r3, String r4, Map<String, String> r5) {
        if (StringsKt.endsWith$default(String.valueOf(r3), "lark-api-injected.js", false, 2, null) == false) goto L40;
        Fragment r6 = this.a.getFragment();
        if (r6 == null) goto L7;
        FragmentActivity r7 = r6.getActivity();
    L9:
        if ((r7 instanceof ModelChameleonActivity) == false) goto L19;
        int r8 = u.a;
        Fragment r9 = this.a.getFragment();
        if (r9 == null) goto L13;
        FragmentActivity r10 = r9.getActivity();
    L14:
        if (r10 == null) goto L33;
        DependencyContainer r11 = DependencyContainer.a;
        y r12 = DependencyContainer.a(y.class, null);
        if (r12 == null) goto L33;
        boolean r13 = r12.H();
    L35:
        byte[] r14 = new byte[0];
        DependencyContainer r0 = DependencyContainer.a;
        l r1 = DependencyContainer.a(l.class, null);
        if (r1 == null) goto L38;
        r14 = r1.z(this.a.getIsVisible(), Boolean.valueOf(!r13)).getBytes(Charsets.UTF_8);
    L38:
        WebResourceResponse r15 = new WebResourceResponse("text/html", "UTF-8", new ByteArrayInputStream(r14));
        HashMap r16 = new HashMap();
        r16.put("Cache-Control", "no-cache, no-store, must-revalidate");
        r16.put("Pragma", "no-cache");
        r16.put("Expires", DocTabPayload.DocType.UNKNOWN);
        r15.setResponseHeaders(r16);
        return r15;
    L33:
        r13 = false;
        goto L35
    L13:
        r10 = null;
        goto L14
    L19:
        sua.a r17 = (sua.a) swb.a.a(sua.a.class);
        if (r17 == null) goto L26;
        Fragment r2 = this.a.getFragment();
        if (r2 == null) goto L24;
        FragmentActivity r18 = r2.getActivity();
    L25:
        boolean r19 = r17.isRunningInForseti(r18);
    L27:
        if (r19 == false) goto L34;
        OpenConfig r20 = this.b.getOpenConfig();
        if (r20 == null) goto L34;
        if (r20.isModelView() == true) goto L33;
    L34:
        r13 = true;
        goto L35
    L24:
        r18 = null;
        goto L25
    L26:
        r19 = false;
        goto L27
    L7:
        r7 = null;
        goto L9
    L40:
        return null;
    }
}
