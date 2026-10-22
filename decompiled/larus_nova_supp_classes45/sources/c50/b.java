package c50;

import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public static String b(DataCenter r4) {
        if (r4 != null) goto L6;
        return "";
    L6:
        return a(((Long) r4.get("data_room_id", -1L)).longValue(), ((Integer) r4.get("data_fragment_hashcode", -1)).intValue());
    }

    public static String a(long r4, int r6) {
        if (r4 < 0) goto L8;
        if (r6 < 0) goto L8;
        return "" + r4 + ":" + r6;
    L8:
        return "";
    }
}
