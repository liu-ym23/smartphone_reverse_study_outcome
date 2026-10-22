package com.bytedance.android.live.room.report;

import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final a a = null;

    public static final class a {
        public a() {
        }

        public static String a(String r3, String r4) {
            if (Intrinsics.areEqual(r3, "guest_link") == false) goto L6;
            return "guest_link";
        L6:
            if (Intrinsics.areEqual(r3, "anchor_profile") == false) goto L9;
            return "data_card_anchor";
        L9:
            if (Intrinsics.areEqual(r4, "data_card_pk_anchor") == false) goto L12;
            return "data_card_pk_anchor";
        L12:
            if (Intrinsics.areEqual(r4, "data_card_linked_anchor") == false) goto L15;
            return "data_card_linked_anchor";
        L15:
            if (Intrinsics.areEqual(r3, "live_barrage") == false) goto L19;
            return "data_card_barrage";
        L19:
            if (Intrinsics.areEqual(r3, NewProfileInfoViewModel.PAGE_NAME) == false) goto L23;
            return "data_card_audience";
        L23:
            if (Intrinsics.areEqual(r4, "data_card_hourly_rank") == false) goto L26;
            return "data_card_hourly_rank";
        L26:
            if (Intrinsics.areEqual(r4, "data_card_linked_audience_mutiaudience") == false) goto L29;
            return "data_card_linked_audience_mutiaudience";
        L29:
            if (Intrinsics.areEqual(r4, "data_card_linked_audience") == false) goto L32;
            return "data_card_linked_audience";
        L32:
            if (Intrinsics.areEqual(r4, "user_gift") == false) goto L35;
            return "data_card_sendgiftinfo";
        L35:
            if (Intrinsics.areEqual(r3, "top_single_room_rank") == false) goto L39;
            return "data_card_contribution_list";
        L39:
            if (Intrinsics.areEqual(r3, "single_room_rank") == false) goto L43;
            return "data_card_audience_list";
        L43:
            if (Intrinsics.areEqual(r4, "data_card_vip_list") == false) goto L46;
            return "data_card_vip_list";
        L46:
            if (Intrinsics.areEqual(r4, "data_card_incomeinfo") == false) goto L48;
        L54:
            return "data_card_incomeinfo";
        L48:
            if (Intrinsics.areEqual(r4, "null") == true) goto L54;
            if (r4 == null) goto L54;
            if (Intrinsics.areEqual(r4, "data_card_sendgiftinfo") == true) goto L54;
            return "data_card_anchor";
        }

        public final String getType(String r5, String r6, boolean r7) {
            if (r7 == false) goto L6;
            return "report_message";
        L6:
            if (r5 != null) goto L8;
        L9:
            if (r6 != null) goto L11;
            return "report_user";
        L11:
            if (StringsKt.contains$default(r6, "anchor", false, 2, null) != true) goto L17;
            return "report_anchor";
        L17:
            return "report_user";
        L8:
            if (StringsKt.contains$default(r5, "anchor", false, 2, null) != true) goto L9;
            return "report_anchor";
        }
    }

    static {
        a = new a();
    }
}
