package l82;

import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.j;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import nm1.e;
import nm1.h;
import pm1.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(boolean r1, Map r2) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r2 == null) goto L5;
        r0.putAll(r2);
    L5:
        if (r1 == false) goto L7;
        String r3 = "1";
    L8:
        r0.put("is_notice", r3);
        Unit r4 = Unit.INSTANCE;
        e("livesdk_vs_guest_book_skin_show", r0);
        return;
    L7:
        r3 = "0";
        goto L8
    }

    public static void e(String r9, Map r10) {
        e r0 = f.c();
        if (r0 == null) goto L7;
        ReplayDataContext r1 = r0.h(null);
        if (r1 == null) goto L7;
        j r2 = r1.getVsMsgBoardDataContext();
    L9:
        if ((r2 instanceof j) == true) goto L11;
        r2 = null;
    L11:
        if (r2 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.msgboard.a r3 = (com.bytedance.android.livesdk.chatroom.msgboard.a) r2.getValue();
    L15:
        if (r3 == null) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == false) goto L22;
        h r5 = f.f();
        if (r5 == null) goto L24;
        r5.g(null, r9, r10, new Object[0]);
        return;
    L24:
        return;
    L22:
        r.l().s(r9, MapsKt.toMap(r10), "live", BuildConfig.FLAVOR, "live_detail");
        return;
    L17:
        r4 = false;
        goto L18
    L13:
        r3 = null;
    L7:
        r2 = null;
        goto L9
    }

    public static void a(boolean r1, boolean r2, Map r3) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r3 == null) goto L5;
        r0.putAll(r3);
    L5:
        if (r2 == false) goto L7;
        String r4 = "1";
    L8:
        r0.put("is_notice", r4);
        if (r1 == false) goto L11;
        String r5 = "choose";
    L12:
        r0.put("click_type", r5);
        Unit r6 = Unit.INSTANCE;
        e("livesdk_vs_guest_book_skin_click", r0);
        return;
    L11:
        r5 = "cancel";
        goto L12
    L7:
        r4 = "0";
        goto L8
    }

    public static void d(boolean r3, boolean r4, boolean r5, Map r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r6 == null) goto L5;
        r0.putAll(r6);
    L5:
        String r7 = "1";
        if (r3 == false) goto L8;
        Object r8 = "1";
    L9:
        r0.put("pay_status", r8);
        if (r4 == false) goto L12;
        String r9 = "skin";
    L13:
        r0.put("vs_skin_type", r9);
        if (r5 == true) goto L17;
        r7 = "0";
    L17:
        r0.put("is_free", r7);
        Unit r10 = Unit.INSTANCE;
        e("livesdk_vs_guest_book_skin_item_show", r0);
        return;
    L12:
        r9 = "nameplate";
        goto L13
    L8:
        r8 = "0";
        goto L9
    }

    public static void c(String r3, boolean r4, boolean r5, boolean r6, Map r7) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r7 == null) goto L5;
        r0.putAll(r7);
    L5:
        String r8 = "1";
        if (r4 == false) goto L8;
        Object r9 = "1";
    L9:
        r0.put("pay_status", r9);
        if (r5 == false) goto L12;
        String r10 = "skin";
    L13:
        r0.put("vs_skin_type", r10);
        if (r6 == true) goto L17;
        r8 = "0";
    L17:
        r0.put("is_free", r8);
        r0.put("click_type", "choose");
        if (r5 == false) goto L22;
        if (r3 != null) goto L21;
        r3 = BuildConfig.FLAVOR;
    L21:
        r0.put("vs_skin_id", r3);
    L25:
        Unit r11 = Unit.INSTANCE;
        e("livesdk_vs_guest_book_skin_item_click", r0);
        return;
    L22:
        if (r3 != null) goto L24;
        r3 = BuildConfig.FLAVOR;
    L24:
        r0.put("vs_medal_id", r3);
        goto L25
    L12:
        r10 = "nameplate";
        goto L13
    L8:
        r9 = "0";
        goto L9
    }
}
