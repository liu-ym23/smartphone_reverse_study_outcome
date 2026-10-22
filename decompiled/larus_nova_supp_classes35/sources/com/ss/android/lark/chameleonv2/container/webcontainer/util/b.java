package com.ss.android.lark.chameleonv2.container.webcontainer.util;

import android.app.Application;
import com.ss.android.lark.chameleon.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.officesdk.utils.di.e;
import com.ss.android.lark.officesdk.utils.di.j;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final Map<String, Pair<ChameleonConfig, List<AbsChameleonPlugin>>> a = null;

    public static boolean a() {
        int r1 = com.ss.android.lark.officesdk.utils.di.d.a;     // Catch: Exception -> L8
        Application r2 = com.ss.android.lark.officesdk.utils.di.d.a.a();     // Catch: Exception -> L8
        int r3 = e.a;     // Catch: Exception -> L8
        boolean r4 = e.a.b(r2);     // Catch: Exception -> L8
        boolean r5 = e.a.a(r2);     // Catch: Exception -> L8
        if (r4 == true) goto L6;
        if (r5 == true) goto L6;
        return false;
    L6:
        return true;
    L8:
        e = move-exception;
        j.b("CML_TAG_ContainerUtils", "get debug status error: e:" + e);
        return false;
    }

    static {
        a = new LinkedHashMap();
    }

    @JvmStatic
    public static final ChameleonConfig b(String r13) {
        Intrinsics.checkNotNullParameter(r13, "session");
        Pair r14 = (Pair) ((LinkedHashMap) a).get(r13);
        if (r14 == null) goto L7;
        ChameleonConfig r15 = (ChameleonConfig) r14.getFirst();
        if (r15 == null) goto L7;
        return r15;
    L7:
        return new ChameleonConfig(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    @JvmStatic
    public static final List<AbsChameleonPlugin> c(String r1) {
        Intrinsics.checkNotNullParameter(r1, "session");
        Pair r2 = (Pair) ((LinkedHashMap) a).get(r1);
        if (r2 == null) goto L7;
        List<AbsChameleonPlugin> r3 = (List) r2.getSecond();
        if (r3 == null) goto L7;
        return r3;
    L7:
        return CollectionsKt.emptyList();
    }

    public static String d(String r7) {
        if (r7 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return BuildConfig.FLAVOR;
    L12:
        int r2 = StringsKt.indexOf$default(r7, "?", 0, false, 6, null);
        if (r2 <= (-1)) goto L16;
        r7 = r7.substring(0, r2);
    L16:
        if (r7.length() > 1024) goto L18;
        return r7;
    L18:
        return r7.substring(0, ChameleonContainerUtils.MAX_URL_LENGTH);
    L5:
        if (r7.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @JvmStatic
    public static final void e(String r2, ChameleonConfig r3, List<? extends AbsChameleonPlugin> r4) {
        Intrinsics.checkNotNullParameter(r2, "session");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "bizPlugins");
        a.put(r2, new Pair(r3, r4));
    }
}
