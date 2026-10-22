package yc0;

import android.net.Uri;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.utils.x;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.c;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vm2.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final MultiLinkEventModule a = null;

    static {
        a = MultiLinkEventModule.MULTI_LINK_GIFT;
    }

    public static void b(b r10) {
        Intrinsics.checkNotNullParameter(r10, "param");
        if (((Boolean) d.X7.getValue(null, d.a[462(0x1ce, float:6.47E-43)])).booleanValue() == true) goto L5;
        return;
    L5:
        JSONObject r3 = new JSONObject();
        x.a(r3, "result", "failed");
        c(r3, r10);
        c r0 = r10.e;
        if (r0 == null) goto L10;
        String r1 = r0.a;
        if (r1 == null) goto L10;
        x.a(r3, "event_session_id", r1);
    L10:
        h2 r11 = r10.b;
        if (r11 == null) goto L13;
        a(r3, r11);
    L13:
        nd0.c.p(nd0.c.a, LinkMonitorData.PlayFlymicAnimationEvent, r3, a, 0, null, false, null, 120);
    }

    public static void d(b r10) {
        Intrinsics.checkNotNullParameter(r10, "param");
        if (((Boolean) d.X7.getValue(null, d.a[462(0x1ce, float:6.47E-43)])).booleanValue() == true) goto L5;
        return;
    L5:
        JSONObject r3 = new JSONObject();
        x.a(r3, "result", "success");
        c(r3, r10);
        x.a(r3, "duration", Long.valueOf(r10.d));
        x.a(r3, "time_cost", Long.valueOf(r10.d));
        c r0 = r10.e;
        if (r0 == null) goto L10;
        String r1 = r0.a;
        if (r1 == null) goto L10;
        x.a(r3, "event_session_id", r1);
    L10:
        h2 r11 = r10.b;
        if (r11 == null) goto L13;
        a(r3, r11);
    L13:
        nd0.c.p(nd0.c.a, LinkMonitorData.PlayFlymicAnimationEvent, r3, a, 0, null, false, null, 120);
    }

    public static void a(JSONObject r9, h2 r10) {
        x.a(r9, "gift_name", r10.getName());
        x.a(r9, "gift_id", Long.valueOf(r10.getId()));
        x.a(r9, "gift_type", Integer.valueOf(r10.getType()));
        x.a(r9, "asset_ids", CollectionsKt.joinToString$default(r10.getAssetIds(), ",", null, null, 0, null, null, 62, null));
    }

    public static void c(JSONObject r6, b r7) {
        x.a(r6, "reason", r7.a);
        x.a(r6, "flymic_type", r7.c);
        String r0 = gh0.a.c();
        c r2 = r7.e;
        if (r2 == null) goto L83;
        boolean r3 = Intrinsics.areEqual(r0, r2.b);
        boolean r1 = r2.c.contains(r0);
        if (r3 == false) goto L7;
        String r4 = "pay_master";
    L10:
        x.a(r6, "gift_role", r4);
        if (r2.c.isEmpty() == false) goto L13;
        int r5 = 1;
    L14:
        x.a(r6, "receiver_count", Integer.valueOf(r5));
        boolean r8 = false;
        if (r7.c.length() != 0) goto L17;
        boolean r9 = true;
    L18:
        if (r9 == false) goto L84;
        String r10 = r2.j;
        if (r10 != null) goto L22;
    L25:
        boolean r11 = true;
    L26:
        boolean r12 = !r11;
        String r13 = r2.l;
        if (r13 != null) goto L29;
    L32:
        boolean r14 = true;
    L33:
        boolean r15 = !r14;
        String r16 = r2.h;
        if (r16 != null) goto L36;
    L37:
        r8 = true;
    L38:
        boolean r17 = !r8;
        if (r12 == false) goto L74;
        if (r15 == true) goto L42;
        if (r17 == false) goto L74;
    L42:
        String r18 = r2.j;
        Intrinsics.checkNotNull(r18);
        Intrinsics.checkNotNullParameter(r18, "baseUriString");
        Uri r19 = UriProtector.parse(r18);
        Intrinsics.checkNotNullParameter(r19, "baseUri");
        LinkedHashMap r20 = new LinkedHashMap();
        if (r19.isHierarchical() == false) goto L48;
        Iterator r21 = UriProtector.getQueryParameterNames(r19).iterator();
    L46:
        if (r21.hasNext() == false) goto L48;
        String r22 = (String) r21.next();
        String r23 = UriProtector.getQueryParameter(r19, r22);
        Intrinsics.checkNotNull(r23);
        r20.put(r22, r23);
    L48:
        Intrinsics.checkNotNullParameter("url", "key");
        Object r24 = r20.get("url");
        if ((r24 instanceof u6) == false) goto L52;
        u6 r25 = (u6) r24;
    L59:
        String r26 = r25.a("engine_type");
        if (r26 == null) goto L73;
        int r27 = r26.hashCode();
        if (r27 == 113636) goto L71;
        if (r27 != 2997605) goto L73;
        if (r26.equals("amaz") == false) goto L73;
        String r28 = "lynx-amaz";
    L80:
        x.a(r6, "flymic_type", r28);
        return;
    L71:
        if (r26.equals("sar") == false) goto L73;
        r28 = "lynx-sar";
    L73:
        r28 = PbRequest.SwitchType.OTHER;
        goto L80
    L52:
        if ((r24 instanceof String) == false) goto L57;
        Uri r29 = UriProtector.parse((String) r24);
        if (r29.isHierarchical() == false) goto L56;
        r25 = new u6(r29);
    L58:
        r20.put("url", r25);
        goto L59
    L56:
        r25 = new u6(Uri.EMPTY);
        goto L58
    L57:
        r25 = new u6(Uri.EMPTY);
    L74:
        if (r17 == true) goto L77;
        r28 = "filament";
        goto L80
    L77:
        if (r2.d != 2) goto L79;
        r28 = "normal-big";
        goto L80
    L79:
        r28 = "normal";
        goto L80
    L36:
        if (r16.length() != 0) goto L38;
    L29:
        if (r13.length() == 0) goto L32;
        r14 = false;
        goto L33
    L22:
        if (r10.length() == 0) goto L25;
        r11 = false;
        goto L26
    L84:
        return;
    L17:
        r9 = false;
        goto L18
    L13:
        r5 = r2.c.size();
        goto L14
    L7:
        if (r1 == false) goto L9;
        r4 = "receiver";
        goto L10
    L9:
        r4 = "audience";
        goto L10
    }
}
