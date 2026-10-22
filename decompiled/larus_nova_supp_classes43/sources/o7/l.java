package o7;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.card.base.HybridDomainUtils;
import com.bytedance.android.annie.param.n;
import com.bytedance.android.annie.service.network.IAnnieNetworkService;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.common.util.JellyBeanMR1V17Compat;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ttnet.config.AppConfig;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final String b(StringBuilder r10) {
        Intrinsics.checkNotNullParameter(r10, "customUABuilder");
        StringBuilder r0 = new StringBuilder(" ");
        com.bytedance.android.annie.ng.g.b().getClass();
        o8.a r1 = com.bytedance.android.annie.ng.e.a;
        r0.append(r1.b);
        r0.append('_');
        com.bytedance.android.annie.ng.g.b().getClass();
        r0.append(r1.c);
        r10.append(r0.toString());
        StringBuilder r11 = new StringBuilder(" AppVersion/");
        com.bytedance.android.annie.ng.g.b().getClass();
        r11.append(r1.c);
        r10.append(r11.toString());
        r10.append(" JsSdk/2.0");
        r10.append(" NetType/" + ((IAnnieNetworkService) Annie.getService$default(IAnnieNetworkService.class, null, 2, null)).getNetworkAccessType().toUpperCase(Locale.ROOT));
        StringBuilder r12 = new StringBuilder(" Channel/");
        com.bytedance.android.annie.ng.g.b().getClass();
        r12.append(r1.e);
        r10.append(r12.toString());
        r10.append(" ByteLocale/" + Locale.CHINA.getLanguage());
        r10.append(" Region/" + Locale.CHINA.getCountry());
        StringBuilder r13 = new StringBuilder(" App/");
        com.bytedance.android.annie.ng.g.b().getClass();
        r13.append(r1.b);
        r10.append(r13.toString());
        r10.append(" Webcast_ByteLocale/" + Locale.CHINA.getLanguage());
        String r14 = ((i9.d) Annie.getService$default(i9.d.class, null, 2, null)).k0();
        if (r14 == null) goto L6;
        r10.append(" WebcastSDK/".concat(r14));
    L6:
        if (com.bytedance.android.annie.ng.g.b().c.a == false) goto L11;
        com.bytedance.android.annie.ng.g.b().getClass();
        if (r1.k == false) goto L10;
        r10.append(" AppTheme/light");
        goto L11
    L10:
        r10.append(" AppTheme/dark");
    L11:
        String r15 = ((n) Annie.getService$default(n.class, null, 2, null)).N0();
        if (r15 == null) goto L15;
        r10.append(r15);
    L15:
        return r10.toString();
    }

    @JvmStatic
    public static final boolean f(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return false;
    L6:
        if (StringsKt.startsWith$default(r10, "http://", false, 2, null) == false) goto L8;
    L9:
        return true;
    L8:
        if (StringsKt.startsWith$default(r10, "https://", false, 2, null) == true) goto L9;
        return false;
    }

    @JvmStatic
    public static final boolean g(String r10) {
        if (e.a() == false) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L11:
        boolean r11 = true;
    L12:
        if (r11 == false) goto L30;
        return false;
    L30:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L16
        Object r13 = Result.constructor-impl(new URI(r10).getHost());     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r13) == false) goto L21;
        r13 = null;
    L21:
        String r14 = (String) r13;
        if (r14 == null) goto L29;
        Iterator r15 = ((List) HybridDomainUtils.a.getValue()).iterator();
    L25:
        if (r15.hasNext() == false) goto L29;
        if (h(r14, (String) r15.next()) == false) goto L25;
        return true;
    L29:
        return false;
    L16:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L8:
        if (StringsKt.isBlank(r10) == true) goto L11;
        r11 = false;
        goto L12
    }

    @JvmStatic
    public static final String e(Context r1, WebView r10) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r10, "webView");
        String r11 = r10.getSettings().getUserAgentString();
        if (TextUtils.isEmpty(r11) == true) goto L5;
        return r11;
    L5:
        String r12 = JellyBeanMR1V17Compat.getWebViewDefaultUserAgent(r1);
        if (r12 != null) goto L9;
        return "";
    L9:
        return r12;
    }

    public static boolean h(String r10, String r11) {
        if (StringsKt.isBlank(r10) == false) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L27;
        if (r11 != null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == true) goto L27;
        if (r10.length() < r11.length()) goto L27;
        if (StringsKt.endsWith$default(r10, r11, false, 2, null) == false) goto L27;
        if (Intrinsics.areEqual(r11, r10) == false) goto L23;
        return true;
    L23:
        if (StringsKt.endsWith$default(r10, ".".concat(r11), false, 2, null) == true) goto L29;
        return false;
    L29:
        return true;
    L9:
        if (StringsKt.isBlank(r11) == true) goto L12;
        r1 = false;
    L27:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    public static void a(Map r10, Set r11, Uri.Builder r12) {
        Iterator r13 = r10.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L16;
        Map.Entry r0 = (Map.Entry) r13.next();
        CharSequence r1 = (CharSequence) r0.getValue();
        if (r1 != null) goto L8;
    L11:
        boolean r14 = true;
    L12:
        if (r14 == true) goto L4;
        if (r11.contains(r0.getKey()) == true) goto L4;
        r12.appendQueryParameter((String) r0.getKey(), (String) r0.getValue());
        goto L4
    L8:
        if (StringsKt.isBlank(r1) == true) goto L11;
        r14 = false;
        goto L12
    }

    @JvmStatic
    public static final String c(String r10, WebView r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r12, "loaderName");
        if (g(r10) == true) goto L5;
        return r10;
    L5:
        Uri r13 = UriProtector.parse(r10);
        Set r0 = UriProtector.getQueryParameterNames(r13);
        Uri.Builder r14 = r13.buildUpon();
        Map<String, String> r1 = ((com.bytedance.android.annie.service.network.i) Annie.getService$default(com.bytedance.android.annie.service.network.i.class, null, 2, null)).s1();
        x8.a.d("WebViewUtil", "===WebViewUtil 拼接公共参数===", false);
        if (r1 == null) goto L8;
        x8.a.d("WebViewUtil", r1.toString(), false);
    L8:
        a(r1, r0, r14);
        Iterator r15 = ((CopyOnWriteArrayList) p9.a.b).iterator();
    L10:
        if (r15.hasNext() == false) goto L13;
        a(((p9.h) r15.next()).a(r10, IHybridComponent.HybridType.H5, r12), r0, r14);
        goto L10
    L13:
        return r14.build().toString();
    }

    @JvmStatic
    public static final String d(String r16, WebView r17, Map<String, String> r18, String r19, String r20) {
        String r10 = r16;
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r17, "webview");
        Intrinsics.checkNotNullParameter(r18, "headers");
        String r11 = null;
        if (StringsKt.isBlank(r16) == false) goto L5;
        return null;
    L5:
        ((aa.b) Annie.getService$default(aa.b.class, null, 2, null)).y1(r17);
        boolean r12 = f(r16);
        if (TextUtils.equals(UriProtector.getQueryParameter(UriProtector.parse(r16), "keep_origin_url"), "1") == false) goto L10;
        boolean r13 = false;
    L12:
        if (com.bytedance.android.annie.ng.g.b().a.b == false) goto L53;
        URI r14 = URI.create(r16);
        String r15 = r14.getHost();
        if (r15 != null) goto L16;
    L18:
        boolean r110 = false;
    L19:
        if (r110 == false) goto L53;
        List<String> r21 = AnnieConfigSettingKeys.LIVE_WEBVIEW_DEBUG_BOE_ALLOW_LIST.a();
        if (r21 == null) goto L35;
        Iterator<String> r22 = r21.iterator();
    L24:
        if (r22.hasNext() == false) goto L35;
        String r111 = r22.next();
        if (r15 != null) goto L28;
    L30:
        boolean r112 = false;
    L31:
        if (r112 == false) goto L24;
        if (r15 == null) goto L34;
        r11 = StringsKt.replace$default(r15, ".boe-gateway.byted.org", "", false, 4, null);
    L34:
        r15 = r11;
        goto L35
    L28:
        if (StringsKt.startsWith$default(r15, r111, false, 2, null) != true) goto L30;
        r112 = true;
    L35:
        String r23 = r14.getScheme();
        int r24 = r14.getPort();
        String r25 = r14.getRawPath();
        String r26 = r14.getRawQuery();
        String r27 = r14.getRawFragment();
        StringBuilder r28 = new StringBuilder();
        if (r15 == null) goto L42;
        if (r23 == null) goto L39;
        r28.append(r23);
        r28.append("://");
    L39:
        r28.append(r15);
        if (r24 <= 0) goto L42;
        r28.append(':');
        r28.append(r24);
    L42:
        if (r25 != null) goto L44;
    L45:
        r28.append('/');
    L46:
        if (r25 == null) goto L48;
        r28.append(r25);
    L48:
        if (r26 == null) goto L50;
        r28.append('?');
        r28.append(r26);
    L50:
        if (r27 == null) goto L52;
        r28.append('#');
        r28.append(r27);
    L52:
        r10 = new URI(r28.toString()).toString();
        goto L53
    L44:
        if (r25.startsWith("/") == true) goto L46;
    L16:
        if (StringsKt.endsWith$default(r15, ".boe-gateway.byted.org", false, 2, null) != true) goto L18;
        r110 = true;
    L53:
        Context r29 = r17.getContext();
        if (r29 == null) goto L58;
        if (r13 == false) goto L58;
        if (r12 == false) goto L58;
        r10 = AppConfig.getInstance(r29).filterUrlOnUIThread(r10);
    L58:
        if (r19 != null) goto L60;
        String r30 = "https://nativeapp.toutiao.com";
    L61:
        r18.put("Referer", r30);
        if (r20 != null) goto L64;
        String r1 = "";
    L66:
        return c(r10, r17, r1);
    L64:
        r1 = r20;
        goto L66
    L60:
        r30 = r19;
    L10:
        r13 = true;
        goto L12
    }
}
