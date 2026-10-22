package com.bytedance.android.live.room.report;

import android.text.TextUtils;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.room.api.report.ReportObject;
import com.bytedance.android.livesdk.config.nl;
import com.bytedance.android.livesdk.config.oc;
import com.bytedance.android.livesdk.config.ui1;
import com.bytedance.android.livesdk.config.yj;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import zg1.r2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    static {
    }

    public static ReportObject a(g r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Map<String, String> r0 = ReportTracer.a;
        ReportTracer.b(ReportTracer.EventName.get_report_object);
        boolean r1 = false;
        if (r2.a(r4.e) == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L11;
        ReportObject r5 = ReportObject.DHXT_Link_OR_PK;
    L43:
        ReportTracer.d(ReportTracer.EventName.report_object, r5.name());
        return r5;
    L11:
        if (r4.h == true) goto L13;
    L17:
        boolean r3 = false;
    L18:
        if (r3 == false) goto L20;
        r5 = ReportObject.DH_Anchor;
        goto L43
    L20:
        ReportObject r6 = r4.i;
        if (r6 == null) goto L24;
        r5 = r6;
        goto L43
    L24:
        if (TextUtils.isEmpty((CharSequence) nl.a.getValue()) == false) goto L26;
    L32:
        boolean r7 = false;
    L33:
        if (r7 == false) goto L36;
        r5 = ReportObject.Comment;
        goto L43
    L36:
        if (TextUtils.equals("room_channel_link", r4.d) == true) goto L38;
    L40:
        if (r1 == false) goto L42;
        r5 = ReportObject.ChannelLink;
        goto L43
    L42:
        r5 = ReportObject.User;
        goto L43
    L38:
        if (TextUtils.isEmpty((CharSequence) yj.a.getValue()) == true) goto L40;
        r1 = true;
        goto L40
    L26:
        if (r4.g == null) goto L32;
        if (TextUtils.equals(NewProfileInfoViewModel.PAGE_NAME, r4.d) == false) goto L30;
    L31:
        r7 = true;
        goto L33
    L30:
        if (TextUtils.equals("live_barrage", r4.d) == false) goto L32;
    L13:
        if (TextUtils.isEmpty((CharSequence) oc.a.getValue()) == true) goto L17;
        if (((Boolean) ui1.a.getValue()).booleanValue() == false) goto L17;
        r3 = true;
        goto L18
    L5:
        if (TextUtils.isEmpty((CharSequence) oc.a.getValue()) == true) goto L7;
        r2 = true;
        goto L8
    }
}
