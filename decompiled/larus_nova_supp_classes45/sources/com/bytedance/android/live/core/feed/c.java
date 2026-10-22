package com.bytedance.android.live.core.feed;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.ListUtils;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.config.ae1;
import com.bytedance.android.livesdk.config.feed.LiveFeedDynamic;
import com.bytedance.android.livesdk.config.feed.LiveFeedDynamicConfig;
import com.bytedance.android.livesdk.log.u;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final LiveFeedDynamic a(String r18, String r19, LiveFeedType r21) {
        Intrinsics.checkNotNullParameter(r21, "liveFeedType");
        if (Intrinsics.areEqual("drawer_game", r18) == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L10;
        String r4 = (String) LiveConfigSettingKeys.LIVE_FEED_UNKNOWN_DRAW.getValue();
        if (r4 != null) goto L14;
        r4 = "https://webcast-open.douyin.com/webcast/openapi/feed/?channel_id=999999";
    L14:
        String r8 = r4;
        int r5 = b.a[r21.ordinal()];
        if (r5 == 1) goto L23;
        if (r5 != 2) goto L18;
        List r6 = ((LiveFeedDynamicConfig) LiveConfigSettingKeys.LIVE_FEED_DYNAMIC_CONFIG_V2.getValue()).getDynamicInnerFlow();
    L24:
        if (r6 == null) goto L85;
        if (ListUtils.isEmpty(r6) == true) goto L85;
        String r7 = r18 + '-' + r19;
        Iterator r9 = r6.iterator();
    L30:
        if (r9.hasNext() == false) goto L58;
        LiveFeedDynamic r11 = (LiveFeedDynamic) r9.next();
        String r15 = r11.getEnterSource();
        if (r15 == null) goto L30;
        if (TextUtils.equals(r15, r7) == true) goto L59;
        String r12 = StringsKt.replace$default(r15, "*", "", false, 4, null);
        if (TextUtils.isEmpty(r12) == true) goto L59;
        if (StringsKt.startsWith$default(r15, "*", false, 2, null) == false) goto L46;
        if (StringsKt.endsWith$default(r7, r12, false, 2, null) == true) goto L59;
    L46:
        if (StringsKt.endsWith$default(r15, "*", false, 2, null) == false) goto L51;
        if (StringsKt.startsWith$default(r7, r12, false, 2, null) == true) goto L59;
    L51:
        if (StringsKt.startsWith$default(r15, "*", false, 2, null) == false) goto L30;
        if (StringsKt.endsWith$default(r15, "*", false, 2, null) == false) goto L30;
        if (StringsKt.contains$default(r7, r12, false, 2, null) == false) goto L30;
    L59:
        if (r11 == null) goto L80;
        if (Intrinsics.areEqual(r11.getLiveFeedUrl(), r8) == true) goto L80;
        if (r21 == LiveFeedType.DRAWER) goto L67;
        b(r18, r19, r21, r11.getLiveFeedUrl(), !StringsKt.contains$default(r11.getLiveFeedUrl(), "channel_id=999999", false, 2, null));
    L67:
        String r0 = r11.getLiveFeedUrl();
        if (r0 != null) goto L70;
    L73:
        boolean r13 = true;
    L74:
        if (r13 == true) goto L77;
        StringsKt.substringBefore$default(StringsKt.substringAfter$default(r0, "channel_id=", null, 2, null), '&', null, 2, null);
    L77:
        ae1.a.getClass();
        return r11;
    L70:
        if (r0.length() == 0) goto L73;
        r13 = false;
    L80:
        if (r21 == LiveFeedType.DRAWER) goto L83;
        b(r18, r19, r21, r8, false);
    L83:
        return new LiveFeedDynamic(null, r8, false, 5, null);
    L58:
        r11 = null;
    L85:
        if (r21 == LiveFeedType.DRAWER) goto L88;
        b(r18, r19, r21, r8, false);
    L88:
        return new LiveFeedDynamic(null, r8, false, 5, null);
    L18:
        if (r5 != 3) goto L21;
        r6 = ((LiveFeedDynamicConfig) LiveConfigSettingKeys.LIVE_FEED_DYNAMIC_CONFIG_V2.getValue()).getDynamicDrawer();
        goto L24
    L21:
        throw new NoWhenBranchMatchedException();
    L23:
        r6 = ((LiveFeedDynamicConfig) LiveConfigSettingKeys.LIVE_FEED_DYNAMIC_CONFIG_V2.getValue()).getDynamicOutFlow();
        goto L24
    L10:
        return new LiveFeedDynamic(null, null, false, 3, null);
    L5:
        if (Intrinsics.areEqual("drawer_cover", r19) == false) goto L7;
        r3 = true;
        goto L8
    }

    public static void b(String r2, String r3, LiveFeedType r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "type");
        Pair[] r0 = new Pair[5];
        r0[0] = TuplesKt.to("enter_from_merge", r2);
        r0[1] = TuplesKt.to("enter_method", r3);
        if (r6 == false) goto L5;
        String r7 = "success";
    L6:
        r0[2] = TuplesKt.to("result", r7);
        r0[3] = TuplesKt.to("feed_type", r4.lowerName());
        r0[4] = TuplesKt.to("live_feed_url", r5);
        Map r8 = MapsKt.mapOf(r0);
        u.l().sendLog("livesdk_live_feed_result", r8, new Object[0]);
        return;
    L5:
        r7 = "error";
        goto L6
    }
}
