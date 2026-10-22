package com.larus.bmhome.notification.util;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.resp.Notice;
import com.larus.bmhome.notification.NotifyTabFragment;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import tx9.p2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(Notice r5, String r6, NotifyTabFragment r7) {
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r6, "modeName");
        if (r5.getNoticeType() != (-3)) goto L5;
        return;
    L5:
        Boolean r0 = r5.getAuditPass();
        if (r0 != null) goto L9;
        String r1 = null;
    L12:
        int r2 = p2.a;
        String r3 = r5.getNoticeTypeStr();
        if (r5.getHasRead() == false) goto L15;
        String r8 = "read";
    L16:
        JSONObject r4 = new JSONObject();
        Intrinsics.checkNotNullParameter(r4, "params");
        r4.put("current_page", "notify");     // Catch: JSONException -> L26
        if (r6 == null) goto L20;
        r4.put("mode_name", r6);     // Catch: JSONException -> L26
    L20:
        if (r1 == null) goto L22;
        r4.put("notice_audit_type", r1);     // Catch: JSONException -> L26
    L22:
        r4.put("notice_status", r8);     // Catch: JSONException -> L26
        if (r3 == null) goto L28;
        r4.put("notice_type", r3);     // Catch: JSONException -> L26
    L28:
        TrackParams r9 = new TrackParams().merge(r4);
        by7.a r10 = new by7.a("notify_element_show");
        r10.b = r7;
        r10.a.merge(r9);
        r10.b();
        return;
    L26:
        e = move-exception;
        FLogger.a.e("NotifyEventHelper", "error in NotifyEventHelper notifyElementShow " + e.getLocalizedMessage());
        goto L28
    L15:
        r8 = "unread";
        goto L16
    L9:
        if (r0.booleanValue() == false) goto L11;
        r1 = "approved";
        goto L12
    L11:
        r1 = "unapproved";
        goto L12
    }

    public static void a(String r2, String r3, Long r4, Integer r5, Integer r6, String r7) {
        int r0 = p2.a;
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.put("stage", r2);     // Catch: Exception -> L12
        r1.put("cache_enable", r3);     // Catch: Exception -> L12
        if (r4 == null) goto L6;
        r1.put("wait_interval", r4.longValue());     // Catch: Exception -> L12
    L6:
        if (r5 == null) goto L8;
        r1.put("cell_model_count", r5.intValue());     // Catch: Exception -> L12
    L8:
        if (r6 == null) goto L10;
        r1.put("notice_unread_count", r6.intValue());     // Catch: Exception -> L12
    L10:
        r1.put("has_valid_cache", r7);     // Catch: Exception -> L12
    L14:
        TrackParams r8 = new TrackParams().merge(r1);
        by7.a r9 = new by7.a("rd_notice_list_cache");
        r9.a.merge(r8);
        r9.b();
        return;
    L12:
        e = move-exception;
        FLogger.a.e("NotifyEventHelper", "error in NotifyEventHelper mobNoticeListCache " + e.getLocalizedMessage());
        goto L14
    }
}
