package com.bytedance.android.live.revenue.common;

import android.net.Uri;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u {
    @Deprecated(message = "使用UriQueryView替换，以及在此基础上封装新的工具函数")
    public static final Map<String, String> d() {
        com.bytedance.android.live.revenue.core.util.j.a r0 = com.bytedance.android.live.revenue.core.util.j.C0;
        yz0.g r1 = (yz0.g) com.bytedance.android.live.revenue.core.util.f.d(r0.a(), yz0.g.class);
        String r2 = null;
        if (r1 == null) goto L5;
        IRoomBase r3 = r1.mo444getRoom();
    L6:
        yz0.g r4 = (yz0.g) com.bytedance.android.live.revenue.core.util.f.d(r0.a(), yz0.g.class);
        if (r4 == null) goto L11;
        IBaseUser r5 = r4.getUser();
        if (r5 == null) goto L11;
        r2 = r5.getIdString();
    L11:
        Pair[] r6 = new Pair[3];
        if (r3 == null) goto L15;
        String r7 = r3.getIdStr();
        if (r7 == null) goto L15;
    L16:
        r6[0] = TuplesKt.to("room_id", r7);
        if (r3 == null) goto L22;
        IBaseUser r8 = r3.getOwnerKt();
        if (r8 == null) goto L22;
        String r9 = r8.getIdString();
        if (r9 == null) goto L22;
    L23:
        r6[1] = TuplesKt.to("anchor_id", r9);
        if (r2 != null) goto L26;
        r2 = "";
    L26:
        r6[2] = TuplesKt.to("user_id", r2);
        return MapsKt.mapOf(r6);
    L22:
        r9 = "";
    L15:
        r7 = "";
        goto L16
    L5:
        r3 = null;
        goto L6
    }

    public static String a(String r5, Map r6) {
        List r0 = CollectionsKt.listOf(new String[]{"url", "fallback_url"});
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r0, "urlList");
        if (r5 == null) goto L17;
        int r2 = com.bytedance.revenue.platform.api.core.e.a;
        Intrinsics.checkNotNullParameter(r5, "schemeString");
        Uri r7 = UriProtector.parse(r5);
        Uri.Builder r3 = f(r7, r0).buildUpon();
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        String r4 = (String) r1.next();
        String r8 = UriProtector.getQueryParameter(r7, r4);
        if (r8 != null) goto L11;
        r8 = "";
    L11:
        r3.appendQueryParameter(r4, e(r8, r6));
        goto L7
    L13:
        return r3.toString();
    L17:
        return "";
    }

    @Deprecated(message = "使用UriQueryView替换，以及在此基础上封装新的工具函数")
    public static final String b(String r7, Map<String, String> r8) {
        Intrinsics.checkNotNullParameter(r8, "params");
        String r0 = "";
        if (r7 != null) goto L5;
        return "";
    L5:
        int r1 = com.bytedance.revenue.platform.api.core.e.a;
        Intrinsics.checkNotNullParameter(r7, "schemeString");
        Uri r9 = UriProtector.parse(r7);
        Uri.Builder r4 = f(r9, CollectionsKt.listOf(new String[]{"url", "fallback_url"})).buildUpon();
        String r5 = UriProtector.getQueryParameter(r9, "url");
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        r4.appendQueryParameter("url", e(r5, r8));
        String r10 = UriProtector.getQueryParameter(r9, "fallback_url");
        if (r10 == null) goto L21;
        if (r10.length() <= 0) goto L13;
        boolean r6 = true;
    L14:
        if (r6 != true) goto L21;
        Intrinsics.checkNotNullParameter(r10, "schemeString");
        Uri r12 = UriProtector.parse(r10);
        Uri.Builder r2 = f(r12, CollectionsKt.listOf("url")).buildUpon();
        String r13 = UriProtector.getQueryParameter(r12, "url");
        if (r13 == null) goto L19;
        r0 = r13;
    L19:
        r2.appendQueryParameter("url", e(r0, r8));
        r4.appendQueryParameter("fallback_url", r2.toString());
        goto L21
    L13:
        r6 = false;
    L21:
        return r4.toString();
    }

    @Deprecated(message = "使用UriQueryView替换，以及在此基础上封装新的工具函数")
    public static final String c(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return "";
    L9:
        int r1 = com.bytedance.revenue.platform.api.core.e.a;
        Intrinsics.checkNotNullParameter(r2, "schemeString");
        Uri.Builder r4 = UriProtector.parse(r2).buildUpon();
        Iterator<Map.Entry<String, String>> r5 = r3.entrySet().iterator();
    L11:
        if (r5.hasNext() == false) goto L14;
        Map.Entry<String, String> r6 = r5.next();
        r4.appendQueryParameter(r6.getKey(), r6.getValue());
        goto L11
    L14:
        return r4.build().toString();
    L5:
        r0 = false;
        goto L6
    }

    @Deprecated(message = "使用UriQueryView替换，以及在此基础上封装新的工具函数")
    public static final String e(String r3, Map<String, String> r4) {
        int r0 = com.bytedance.revenue.platform.api.core.e.a;
        Intrinsics.checkNotNullParameter(r3, "schemeString");
        Uri.Builder r5 = UriProtector.parse(r3).buildUpon();
        Iterator<Map.Entry<String, String>> r1 = d().entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry<String, String> r2 = r1.next();
        r5.appendQueryParameter(r2.getKey(), r2.getValue());
        goto L4
    L6:
        Iterator<Map.Entry<String, String>> r6 = r4.entrySet().iterator();
    L8:
        if (r6.hasNext() == false) goto L11;
        Map.Entry<String, String> r7 = r6.next();
        r5.appendQueryParameter(r7.getKey(), r7.getValue());
        goto L8
    L11:
        return r5.toString();
    }

    @Deprecated(message = "使用UriQueryView替换，以及在此基础上封装新的工具函数")
    public static final Uri f(Uri r5, List<String> r6) {
        Set r0 = UriProtector.getQueryParameterNames(r5);
        Uri.Builder r1 = r5.buildUpon().clearQuery();
        ArrayList r2 = new ArrayList();
        Iterator r3 = r0.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r4 = r3.next();
        if ((!r6.contains((String) r4)) == false) goto L4;
        r2.add(r4);
        goto L4
    L8:
        Iterator r7 = r2.iterator();
    L10:
        if (r7.hasNext() == false) goto L13;
        String r8 = (String) r7.next();
        r1.appendQueryParameter(r8, UriProtector.getQueryParameter(r5, r8));
        goto L10
    L13:
        return r1.build();
    }
}
