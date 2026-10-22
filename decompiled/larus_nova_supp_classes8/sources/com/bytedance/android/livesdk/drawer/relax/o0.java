package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.follow.PlaceHolder;
import com.bytedance.android.live.base.model.follow.ScheduledLiveItem;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.salamander.anniex.d3;
import com.bytedance.salamander.anniex.r3;
import com.bytedance.salamander.anniex.s3;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o0 {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static Long a(FeedItem r2) {
            Intrinsics.checkNotNullParameter(r2, "feedItem");
            int r0 = com.bytedance.rts.foundation.d.a;
            return Long.valueOf(r2.type);
        }

        public static Long b(PlaceHolder r2) {
            int r0 = com.bytedance.rts.foundation.d.a;
            if (r2 == null) goto L7;
            return Long.valueOf(r2.getType());
        L7:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.follow.PlaceHolder");
        }

        public static String c(Room r2) {
            if (r2 == null) goto L5;
            String r3 = String.valueOf(r2.id);
            if (r3 == null) goto L5;
            return r3;
        L5:
            return "";
        }

        public static boolean f(FeedItem r4) {
            Intrinsics.checkNotNullParameter(r4, "item");
            ScheduledLiveItem r5 = r4.scheduledLive;
            if (r5 == null) goto L9;
            Room r6 = r5.getRoom();
            if (r6 == null) goto L9;
            if (r6.getStatus() != 2) goto L9;
            return true;
        L9:
            return false;
        }

        public static boolean g(String r2) {
            if (r2 != null) goto L4;
        L8:
            return false;
        L4:
            if ((!Intrinsics.areEqual(r2, "")) == false) goto L8;
            if (com.bytedance.rts.foundation.r.g(r2, "homepage_follow") == false) goto L8;
            return true;
        }

        public static boolean h(FeedItem r1) {
            Intrinsics.checkNotNullParameter(r1, "item");
            if (r1.type == 11) goto L5;
            return true;
        L5:
            return false;
        }

        public static String e(e r1, String r2) {
            Intrinsics.checkNotNullParameter(r2, "key");
            int r0 = o0.a;
            String r3 = null;
            if (r1 == null) goto L7;
            Function0<? extends r3> r4 = r1.d;
            if (r4 == null) goto L7;
            r3 r5 = (r3) r4.invoke();
        L8:
            if (r5 == null) goto L14;
            s3 r6 = r5.b;
            if (r6 == null) goto L14;
            d3 r7 = r6.b;
            if (r7 == null) goto L14;
            r3 = r7.a;
        L14:
            if (r3 != null) goto L17;
            r3 = "";
        L17:
            return r3 + ':' + r2;
        L7:
            r5 = null;
            goto L8
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static String d(String r25, String r26, ArrayList r27, Boolean r28) {
            StringBuilder r3 = new StringBuilder();
            if (r25 != null) goto L5;
            String r5 = "";
        L6:
            r3.append(r5);
            r3.append('_');
            if (r26 != null) goto L9;
            String r6 = "";
        L10:
            r3.append(r6);
            String r4 = r3.toString();
            boolean r8 = false;
            if ((!Intrinsics.areEqual(r4, "live_merge_live_cover")) == false) goto L41;
            int r7 = o0.a;
            Intrinsics.checkNotNullParameter(r4, "enterSource");
            Object r9 = null;
            if (r27 == null) goto L22;
            Iterator r10 = r27.iterator();
        L16:
            if (r10.hasNext() == false) goto L20;
            Object r11 = r10.next();
            if (Intrinsics.areEqual(r4, (String) r11) == false) goto L16;
        L21:
            String r12 = (String) r11;
        L23:
            if (r12 != null) goto L25;
        L28:
            if (r27 == null) goto L43;
            Intrinsics.checkNotNullParameter(r27, "<this>");
            Intrinsics.checkNotNullParameter(r27, "<this>");
            CollectionsKt.reverse(r27);
            Iterator r2 = r27.iterator();
        L31:
            if (r2.hasNext() == false) goto L40;
            Object r13 = r2.next();
            String r14 = (String) r13;
            if ((!Intrinsics.areEqual(r14, "")) == false) goto L37;
            int r15 = c03.c.a;
            if (c03.c.a(r4, StringsKt.replaceFirst$default(r14, "*", ".*", false, 4, null)) == (-1)) goto L37;
            boolean r16 = true;
        L38:
            if (r16 == false) goto L31;
            r9 = r13;
        L37:
            r16 = false;
        L40:
            r9 = (String) r9;
        L43:
            if (com.bytedance.rts.foundation.j.f(com.bytedance.rts.foundation.j.k(new String[]{"search_ecommerce_others_photo", "search_ecommerce_live_cell", "search_result_live_live_goods", "general_search_live_cell", "general_search_others_photo", "search_result_live_live_cell", "search_result_live_others_photo", "ad_feedslive_search_others_photo", "general_search_live_cover", "general_search_poi_card_head", "general_search_video_head", "search_result_others_photo", "ad_link_search_live_goods", "ecom_search_except_search_order_center_shop_live_cell", "ad_link_search_live_cell", "search_result_poi_card_head"}), r4) == false) goto L45;
            return "drawer_hot_drawer_cover";
        L45:
            if (r9 == null) goto L57;
            if (Intrinsics.areEqual(r9, "") == true) goto L57;
            if (r25 == null) goto L57;
            if (Intrinsics.areEqual(r25, "") == true) goto L57;
            if (r26 == null) goto L57;
            if (Intrinsics.areEqual(r26, "") == true) goto L57;
            return r9;
        L57:
            if (com.bytedance.rts.foundation.j.f(com.bytedance.rts.foundation.j.k(new String[]{"live_merge_live_cover", "live_merge_drawer_cover", "discover_page_drawer_cover"}), r4) == true) goto L75;
            if (r28 == null) goto L61;
            r8 = r28.booleanValue();
        L61:
            if (r8 == true) goto L63;
            return r4;
        L63:
            if (Intrinsics.areEqual(r4, "drawer_game_drawer_cover") == false) goto L77;
            return "vs_config_drawer_live_cover";
        L77:
            return r4;
        L75:
            return "drawer_hot_drawer_cover";
        L25:
            if (Intrinsics.areEqual(r12, "") == true) goto L28;
            r9 = r12;
            goto L43
        L20:
            r11 = null;
            goto L21
        L22:
            r12 = null;
            goto L23
        L41:
            r9 = "";
            goto L43
        L9:
            r6 = r26;
            goto L10
        L5:
            r5 = r25;
            goto L6
        }
    }

    static {
    }
}
