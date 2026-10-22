package com.ss.android.lark.feed.shared.hitpoint;

import com.ss.android.lark.feed.app.entity.FeedFolder;
import com.ss.android.lark.feed.app.entity.FeedFolderCompat;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import s5c.d;
import z5c.p3;
import z5c.r;
import z5c.y3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "feedId");
        heb.a.a.getFeedDependency().getClass();     // Catch: Throwable -> L9
        FeedFolderCompat r0 = FeedFolderCompat.INSTANCE;     // Catch: Throwable -> L9
        FeedFolder r1 = r0.getMESSAGE_WITHOUT_DOUBAO();     // Catch: Throwable -> L9
        if (r1.isSameFolderWith(r0.getEXPIRED_FOLD()) == false) goto L6;
        String r2 = "expired_fold";
    L7:
        Statistics.sendEvent("feed_chat_click", new JSONObject().put("feed_id", r4).put("feed_type", r2));     // Catch: Throwable -> L9
        return;
    L6:
        r2 = r1.label().toLowerCase(Locale.ROOT);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Log.e("FeedHitPoint", th.getMessage());
    }

    @JvmStatic
    public static final void b(boolean r4) {
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L13
        if (r4 == false) goto L6;
        String r3 = "open";
    L7:
        JSONObject r5 = r2.put("click", r3);     // Catch: Throwable -> L13
        if (r4 == false) goto L10;
        String r6 = "feed_grouping_edit_view";
    L11:
        Statistics.sendEvent("feed_delayed_popup_click", r5.put("target", r6).put("click_type", "click"));     // Catch: Throwable -> L13
        return;
    L10:
        r6 = "feed_main_view";
        goto L11
    L6:
        r3 = "esc";
    L13:
        th = move-exception;
        Log.e("FeedHitPoint", th.getMessage());
    }

    @JvmStatic
    public static final void c(boolean r1) {
        if (r1 == false) goto L4;
        s5c.a r2 = r.X2;
    L5:
        s5c.a r0 = p3.c;
        r2.getClass();
        Statistics.sendEvent("feed_msg_guidance_click", d.b.b(r2, r0).plus(y3.p).toJson());
        return;
    L4:
        r2 = r.h;
        goto L5
    }
}
