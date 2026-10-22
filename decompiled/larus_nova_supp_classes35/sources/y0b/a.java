package y0b;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements b {
    public final Map<String, c> a;

    public a(WebView r4, ChameleonConfig r5) {
        Intrinsics.checkNotNullParameter(r4, "webView");
        Intrinsics.checkNotNullParameter(r5, "chameleonConfig");
        DependencyContainer r0 = DependencyContainer.a;
        com.ss.android.lark.officesdk.di.core.b r1 = null;
        com.ss.android.lark.officesdk.di.core.b r2 = DependencyContainer.a(x0b.a.class, null);
        if ((r2 instanceof x0b.a) == false) goto L6;
        r1 = r2;
    L6:
        x0b.a r3 = (x0b.a) r1;
        if (r3 == null) goto L11;
        Map<String, c> r6 = r3.h0(r4, r5);
        if (r6 == null) goto L11;
    L12:
        this.a = r6;
        return;
    L11:
        r6 = MapsKt.emptyMap();
        goto L12
    }

    @Override // y0b.b
    public final WebResourceResponse shouldInterceptRequest(Uri r7, String r8, Map<String, String> r9) {
        if (r7 == null) goto L16;
        String r0 = r7.getPath();
        if (r0 == null) goto L17;
        List r10 = StringsKt.split$default(r0, new String[]{"/"}, false, 0, 6, null);
        if (Intrinsics.areEqual(CollectionsKt.getOrNull(r10, 1), "cache-resource") == false) goto L18;
        String r11 = (String) CollectionsKt.getOrNull(r10, 2);
        if (r11 != null) goto L11;
        return null;
    L11:
        if (this.a.containsKey(r11) == false) goto L20;
        c r12 = this.a.get(r11);
        if (r12 != null) goto L15;
        return null;
    L15:
        return r12.a(r7);
    L20:
        return null;
    L18:
        return null;
    L17:
        return null;
    L16:
        return null;
    }
}
