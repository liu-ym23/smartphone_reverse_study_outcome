package gg0;

import android.os.Bundle;
import com.bytedance.android.live.liveinteract.linkbase.api.SeatItemId;
import com.bytedance.android.live.liveinteract.utils.t0;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import tf0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class b<T extends tf0.e> {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public abstract boolean b(T r1, T r2);

    public boolean a(T r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "oldItem");
        Intrinsics.checkNotNullParameter(r3, "newItem");
        if (c(SeatItemId.USER_INFO, r2, r3) == true) goto L5;
    L17:
        return false;
    L5:
        if (c(SeatItemId.GIFT_ICON, r2, r3) == false) goto L17;
        if (c(SeatItemId.TAG_LABEL_INFO, r2, r3) == false) goto L17;
        if (c(SeatItemId.EMPTY_INFO, r2, r3) == false) goto L17;
        if (c(SeatItemId.SEAT_WIDGET, r2, r3) == false) goto L17;
        if (c(SeatItemId.RANDOM_EMOJI, r2, r3) == false) goto L17;
        if (r2.j != r3.j) goto L17;
        return true;
    }

    public static boolean c(SeatItemId r1, tf0.e r2, tf0.e r3) {
        HashMap<String, tf0.d> r4 = r2.i;
        HashMap<String, tf0.d> r5 = r3.i;
        tf0.d r6 = r4.get(r1.name());
        tf0.d r7 = r5.get(r1.name());
        if (r6 != null) goto L7;
        if (r7 != null) goto L7;
        return true;
    L7:
        if (vm2.d.N0() == false) goto L15;
        if (r6 != null) goto L10;
    L12:
        return false;
    L10:
        if (r6.e(r7) != true) goto L12;
        return true;
    L15:
        return Intrinsics.areEqual(r6, r7);
    }

    public Bundle d(T r3, T r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "oldItem");
        Intrinsics.checkNotNullParameter(r4, "newItem");
        Bundle r7 = new Bundle();
        if (c(SeatItemId.USER_INFO, r3, r4) == true) goto L6;
        r7.putBoolean("payload_key_dynamic_data_update_for_user_info", true);
    L6:
        if (c(SeatItemId.GIFT_ICON, r3, r4) == true) goto L9;
        r7.putBoolean("payload_key_dynamic_data_update_for_gift_icon_info", true);
    L9:
        if (c(SeatItemId.TAG_LABEL_INFO, r3, r4) == true) goto L12;
        r7.putBoolean("payload_key_dynamic_data_update_for_tag_label_info", true);
    L12:
        if (c(SeatItemId.EMPTY_INFO, r3, r4) == true) goto L15;
        r7.putBoolean("payload_key_dynamic_data_update_for_empty_info", true);
    L15:
        if (c(SeatItemId.SEAT_WIDGET, r3, r4) == true) goto L18;
        r7.putBoolean("payload_key_dynamic_data_update_for_seat_widget_info", true);
    L18:
        if (c(SeatItemId.RANDOM_EMOJI, r3, r4) == true) goto L20;
        r7.putBoolean("payload_key_dynamic_data_update_for_seat_random_emoji_info", true);
    L20:
        boolean r8 = r3.j;
        boolean r1 = r4.j;
        if (r8 == r1) goto L24;
        r7.putBoolean("payload_key_is_visible", r1);
    L24:
        if (r3.d == r4.d) goto L26;
        int r9 = t0.a;
        t0.a("ItemDiffer", "show_from update, old=" + r3.d + ", new=" + r4.d);
        r7.putBoolean("payload_key_update_for_show_from", true);
    L26:
        return r7;
    }
}
