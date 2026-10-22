package com.larus.bmhome.chat.model;

import com.larus.bmhome.auth.ConvRecommendBotConf;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f1 {
    public static final Lazy a = null;
    public static boolean b;
    public static final String c = null;
    public static long d;

    static {
        a = LazyKt.lazy(new e1());
        c = "already_entered_cvs_list_page";
        d = -1;
    }

    public static boolean a() {
        com.larus.bmhome.chat.api.e0 r0 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r0 == null) goto L7;
        LaunchInfo r1 = r0.a;
        if (r1 == null) goto L7;
        ConvRecommendBotConf r2 = r1.J();
    L8:
        if (r2 == null) goto L12;
        boolean r3 = true;
        if (r2.c() != 1) goto L12;
    L13:
        FLogger.a.i("ConversationListModel-RecommendTagBot", "isPreRequireMode(" + r3 + "), config:" + r2);
        return r3;
    L12:
        r3 = false;
    L7:
        r2 = null;
        goto L8
    }

    public static void b(long r3) {
        FLogger.a.i("ConversationListModel-RecommendTagBot", "updateRequirePresetBotTS, ts(" + r3 + ')');
        d = r3;
    }
}
