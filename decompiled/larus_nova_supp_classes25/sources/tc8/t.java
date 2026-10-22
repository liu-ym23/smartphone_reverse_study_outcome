package tc8;

import com.larus.bmhome.chat.bubble.floating.BubbleBannerSource;
import com.larus.reach.api.ReachButtonType;
import com.larus.reach.api.ReachPosition;
import com.larus.reach.api.ReachRequestSource;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ns9.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class t {
    public static final boolean a(ns9.t r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.a.f == ReachRequestSource.CLIENT_BRIDGE) goto L5;
    L7:
        return false;
    L5:
        if (r2.b.b() != ReachPosition.BOTTOM) goto L7;
        return true;
    }

    public static final sc8.b b(ns9.t r23) {
        Intrinsics.checkNotNullParameter(r23, "<this>");
        w r1 = r23.b;
        if ((r1 instanceof w) == false) goto L5;
        w r2 = r1;
    L6:
        Map r3 = r23.e.b;
        LinkedHashMap r4 = new LinkedHashMap();
        Iterator r5 = r3.entrySet().iterator();
    L8:
        if (r5.hasNext() == false) goto L12;
        Map.Entry r6 = (Map.Entry) r5.next();
        if ((!Intrinsics.areEqual((String) r6.getKey(), "popup_scene")) == false) goto L8;
        r4.put(r6.getKey(), r6.getValue());
        goto L8
    L12:
        String r7 = r23.a.c;
        if ((!StringsKt.isBlank(r7)) == false) goto L15;
        String r9 = r7;
    L16:
        String r10 = r23.a.h;
        if (r2 == null) goto L21;
        Map r8 = r2.b;
        if (r8 == null) goto L21;
        String r11 = (String) r8.get("conversation_id");
    L23:
        if (r11 != null) goto L25;
        String r12 = "";
    L26:
        if (r2 == null) goto L30;
        Map r13 = r2.b;
        if (r13 == null) goto L30;
        String r14 = (String) r13.get("query_message_id");
    L31:
        if (r14 != null) goto L33;
        String r15 = "";
    L34:
        ns9.f r16 = r23.d;
        String r17 = r16.b;
        if (r17 != null) goto L37;
        String r18 = "";
    L38:
        String r19 = r16.d;
        String r110 = r16.c;
        Iterator r20 = r16.f.iterator();
    L40:
        if (r20.hasNext() == false) goto L47;
        Object r21 = r20.next();
        if (((ns9.d) r21).getType() != ReachButtonType.NORMAL) goto L44;
        boolean r22 = true;
    L45:
        if (r22 == false) goto L40;
    L48:
        ns9.d r24 = (ns9.d) r21;
        if (r24 == null) goto L51;
        String r111 = r24.c;
    L52:
        Long r25 = r23.c.b;
        if (r25 == null) goto L55;
        long r26 = ((r25.longValue() + 1000) - 1) / 1000;
    L56:
        long r112 = r26;
        int r27 = r23.c.a;
        BubbleBannerSource r28 = BubbleBannerSource.CMD;
        String r29 = (String) r23.e.a.get("request_info");
        String r30 = (String) r23.e.a.get("tracking_info");
        String r0 = (String) r23.e.b.get("popup_scene");
        if ((!r4.isEmpty()) == false) goto L59;
        LinkedHashMap r31 = r4;
    L60:
        pc8.c r32 = new pc8.c(r29, r30, r0, r31);
        if ((!r4.isEmpty()) == false) goto L63;
        LinkedHashMap r210 = r4;
    L65:
        return new sc8.b(r9, r10, r12, r15, r18, r19, r110, r111, r112, r27, r28, r32, r210);
    L63:
        r210 = null;
        goto L65
    L59:
        r31 = null;
        goto L60
    L55:
        r26 = 0;
        goto L56
    L51:
        r111 = null;
        goto L52
    L44:
        r22 = false;
        goto L45
    L47:
        r21 = null;
        goto L48
    L37:
        r18 = r17;
        goto L38
    L33:
        r15 = r14;
    L30:
        r14 = null;
        goto L31
    L25:
        r12 = r11;
    L21:
        r11 = null;
        goto L23
    L15:
        r9 = null;
        goto L16
    L5:
        r2 = null;
        goto L6
    }
}
