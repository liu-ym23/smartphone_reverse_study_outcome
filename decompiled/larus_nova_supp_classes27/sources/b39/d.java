package b39;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.disk.api.CacheHandlerBusiness;
import com.larus.utils.logger.FLogger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d {
    public static final String[] a = null;
    public static final List<String> b = null;

    public d() {
    }

    static {
        a = new String[]{"flow/home", "flow/chat", "flow/webview", "flow/profile", "flow/profile_edit", "flow/chat_setting", "flow/notice_page_dispatch", "flow/notice_page", "flow/create_bot", "flow/global_search", "flow/app_setting", "flow/video_feed", CacheHandlerBusiness.WEBVIEW, "chat_page", "discover", "privacy_info"};
        b = CollectionsKt.listOf(new String[]{"flow/webview", CacheHandlerBusiness.WEBVIEW, "webview_native_nav", "flow/commerce_credit_web"});
    }

    public static String a(Uri r7) {
        if (r7 == null) goto L5;
        String r1 = r7.getSchemeSpecificPart();
    L6:
        if (r1 == null) goto L10;
        List r8 = StringsKt.split$default(r1, new String[]{"?"}, false, 0, 6, null);
        if (r8 == null) goto L10;
        String r9 = (String) CollectionsKt.first(r8);
    L11:
        boolean r2 = false;
        if (r9 != null) goto L14;
    L16:
        if (r2 == true) goto L18;
        return null;
    L18:
        return r9.substring(2);
    L14:
        if (StringsKt.startsWith$default(r9, "//", false, 2, null) != true) goto L16;
        r2 = true;
    L10:
        r9 = null;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    public static boolean b(final Context r6, Uri r7, List r8, List r9, final boolean r10, boolean r11) {
        String r0 = a(r7);
        if (CollectionsKt.contains(r8, r0) == false) goto L6;
        FLogger.a.w("DeeplinkGate", "router in blockList: " + r0);
        b.b(r7);
        return false;
    L6:
        FLogger r12 = FLogger.a;
        r12.d("DeeplinkGate", "router check pass: " + r7 + " |" + r10);
        if (r11 == true) goto L9;
    L32:
        Set r13 = UriProtector.getQueryParameterNames(r7);
        Intrinsics.checkNotNull(r13);
        Set r14 = r13;
        if ((r14 instanceof Collection) == true) goto L35;
    L37:
        Iterator r15 = r14.iterator();
    L39:
        if (r15.hasNext() == false) goto L48;
        String r1 = (String) r15.next();
        if (r9 != null) goto L43;
    L45:
        boolean r2 = false;
    L46:
        if (r2 == false) goto L39;
        boolean r16 = false;
    L49:
        if (r16 == false) goto L51;
        final Uri r17 = r7;
    L63:
        final boolean r18 = Intrinsics.areEqual(UriProtector.getQueryParameter(r7, "no_anim"), "1");
        new Handler(Looper.getMainLooper()).post(new c(r17, r6, r10, r18));
        b.c(r7);
        return true;
    L51:
        Uri.Builder r110 = r7.buildUpon().clearQuery();
        Iterator r20 = r14.iterator();
    L53:
        if (r20.hasNext() == false) goto L62;
        String r3 = (String) r20.next();
        if (r9 != null) goto L57;
    L59:
        boolean r4 = false;
    L60:
        if (r4 == true) goto L53;
        r110.appendQueryParameter(r3, UriProtector.getQueryParameter(r7, r3));
        goto L53
    L57:
        if (r9.contains(r3) != true) goto L59;
        r4 = true;
        goto L60
    L62:
        r17 = r110.build();
        goto L63
    L43:
        if (r9.contains(r1) != true) goto L45;
        r2 = true;
    L48:
        r16 = true;
        goto L49
    L35:
        if (r14.isEmpty() == false) goto L37;
    L9:
        if (CollectionsKt.contains(b, a(r7)) == false) goto L28;
        String r111 = UriProtector.getQueryParameter(r7, "link_url");
        if (r111 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == false) goto L19;
        r111 = UriProtector.getQueryParameter(r7, "url");
    L19:
        if (r111 != null) goto L21;
    L24:
        boolean r21 = true;
    L25:
        if (r21 == false) goto L27;
        boolean r112 = false;
    L29:
        if (r112 == true) goto L32;
        r12.w("DeeplinkGate", "router check query invalid: " + r7);
        b.b(r7);
        return false;
    L27:
        r112 = StringsKt.startsWith$default(r111, "http", false, 2, null);
        goto L29
    L21:
        if (r111.length() == 0) goto L24;
        r21 = false;
        goto L25
    L13:
        if (r111.length() == 0) goto L16;
        r5 = false;
        goto L17
    L28:
        r112 = true;
        goto L29
    }
}
