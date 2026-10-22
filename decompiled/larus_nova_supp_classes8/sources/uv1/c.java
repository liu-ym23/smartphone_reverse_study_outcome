package uv1;

import android.text.TextUtils;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.foundation.depend.LocationResult;
import com.bytedance.android.livesdk.feed.x0;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    @JvmStatic
    public static final com.bytedance.android.livesdk.feed.feed.e b() {
        ILiveService r0 = TTLiveService.getLiveService();
        if (r0 == null) goto L7;
        ILiveOntologyInfoManager r1 = r0.getLiveOntologyRecord();
        if (r1 == null) goto L7;
        String r2 = r1.getDrawerUrl();
    L9:
        if (TextUtils.isEmpty(r2) == false) goto L16;
        boolean r3 = x0.d;
        List<com.bytedance.android.livesdk.feed.feed.e> r4 = x0.a.a().c();
        if (r4 == null) goto L16;
        if (r4.size() <= 0) goto L16;
        return (com.bytedance.android.livesdk.feed.feed.e) ListProtector.get(r4, 0);
    L16:
        return null;
    L7:
        r2 = null;
        goto L9
    }

    static {
    }

    @JvmStatic
    public static final String c(com.bytedance.android.livesdk.feed.feed.e r8) {
        Intrinsics.checkNotNullParameter(r8, "itemTab");
        ILiveService r0 = TTLiveService.getLiveService();
        if (r0 == null) goto L8;
        ILiveOntologyInfoManager r1 = r0.getLiveOntologyRecord();
        if (r1 == null) goto L8;
        String r2 = r1.getDrawerUrl();
        if (r2 == null) goto L8;
    L9:
        boolean r3 = x0.d;
        List<com.bytedance.android.livesdk.feed.feed.e> r4 = x0.a.a().c();
        boolean r5 = false;
        if ((r4 instanceof Collection) == true) goto L12;
    L14:
        Iterator<T> r6 = r4.iterator();
    L16:
        if (r6.hasNext() == false) goto L23;
        if (((com.bytedance.android.livesdk.feed.feed.e) r6.next()).getType() != 3) goto L20;
        boolean r7 = true;
    L21:
        if (r7 == false) goto L16;
        r5 = true;
        goto L23
    L20:
        r7 = false;
    L23:
        List<String> r9 = bx1.a.a;
        ILiveService r10 = TTLiveService.getLiveService();
        if (r10 == null) goto L28;
        ILiveOntologyInfoManager r11 = r10.getLiveOntologyRecord();
        if (r11 == null) goto L28;
        String r12 = r11.getEnterFromMerge();
    L29:
        ILiveService r13 = TTLiveService.getLiveService();
        if (r13 == null) goto L34;
        ILiveOntologyInfoManager r14 = r13.getLiveOntologyRecord();
        if (r14 == null) goto L34;
        r14.getEnterMethod();
    L34:
        boolean r15 = bx1.a.a(r12);
        if (r8.getType() != 1) goto L45;
        ILiveService r16 = TTLiveService.getLiveService();
        if (r16 == null) goto L45;
        ILiveOntologyInfoManager r17 = r16.getLiveOntologyRecord();
        if (r17 == null) goto L45;
        if (r17.isEnableReplaceRecommend() != true) goto L45;
        if (r15 == false) goto L44;
        if (r5 == true) goto L45;
    L44:
        String r18 = new UrlBuilder(r2).addParam("tab_id", r8.f()).build();
    L47:
        if (TextUtils.isEmpty(r18) == false) goto L54;
        if (r8.getType() != 5) goto L51;
        String r19 = "webcast/appointment/feed/";
    L52:
        r18 = new UrlBuilder(r19).addParam("source_key", r8.j() + "_drawer_cover").addParam("need_map", 1).addParam("tab_id", r8.f()).build();
        goto L54
    L51:
        r19 = "/webcast/feed/";
    L54:
        if (r8.getType() != 3) goto L58;
        LocationResult r20 = TTLiveSDK.hostService().appContext().getNearByLocation();
        if (r20 == null) goto L58;
        r18 = UriProtector.parse(r18).buildUpon().appendQueryParameter("city_code", r20.cityCode).appendQueryParameter("city_name", r20.city).build().toString();
    L58:
        if (r18 != null) goto L61;
        return "";
    L61:
        return r18;
    L45:
        r18 = "";
    L28:
        r12 = null;
        goto L29
    L12:
        if (r4.isEmpty() == false) goto L14;
    L8:
        r2 = "";
        goto L9
    }

    @JvmStatic
    public static final String d(com.bytedance.android.livesdk.feed.feed.e r3) {
        ILiveService r0 = TTLiveService.getLiveService();
        String r1 = null;
        if (r0 == null) goto L7;
        ILiveOntologyInfoManager r2 = r0.getLiveOntologyRecord();
        if (r2 == null) goto L7;
        String r4 = r2.getDrawerUrl();
    L9:
        if (TextUtils.isEmpty(r4) == true) goto L11;
        Intrinsics.checkNotNull(r4);
        return r4;
    L11:
        if (r3 == null) goto L13;
        r1 = r3.n();
    L13:
        if (r1 != null) goto L18;
        return "";
    L18:
        return r3.n();
    L7:
        r4 = null;
        goto L9
    }

    @JvmStatic
    public static final b a(String r7, String r8, long r9, int r11) {
        return new b(r7, r8, r9, r11);
    }
}
