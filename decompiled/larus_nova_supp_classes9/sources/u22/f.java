package u22;

import com.bytedance.android.livesdk.event.d0;
import com.bytedance.android.livesdk.t4;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public static final HashMap<String, List<String>> a = null;

    static {
        a = (HashMap) t4.a.getValue();
    }

    public static int a(d0 r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        if (c(r7) == false) goto L6;
        return 8;
    L6:
        if (f(r7) == false) goto L9;
        return 4;
    L9:
        if (d(r7) == false) goto L12;
        return 9;
    L12:
        if (e(r7) == false) goto L15;
        return 10;
    L15:
        if (b(r7) == false) goto L17;
        return 11;
    L17:
        Intrinsics.checkNotNullParameter(r7, "event");
        Object r1 = r7.c.get("request_source");
        Object r4 = null;
        if ((r1 instanceof String) == true) goto L20;
        r1 = null;
    L20:
        String r2 = (String) r1;
        boolean r3 = true;
        if (r2 != null) goto L23;
    L24:
        Object r5 = r7.c.get("request_source");
        if ((r5 instanceof String) == true) goto L27;
        r5 = null;
    L27:
        String r6 = (String) r5;
        if (r6 != null) goto L30;
    L31:
        Object r8 = r7.c.get("request_source");
        if ((r8 instanceof String) == true) goto L34;
        r8 = null;
    L34:
        String r9 = (String) r8;
        if (r9 != null) goto L37;
    L38:
        Object r10 = r7.c.get("request_source");
        if ((r10 instanceof String) == true) goto L41;
        r10 = null;
    L41:
        String r11 = (String) r10;
        if (r11 != null) goto L44;
    L46:
        boolean r13 = false;
    L47:
        if (r13 == false) goto L49;
        return 13;
    L49:
        Intrinsics.checkNotNullParameter(r7, "event");
        Object r14 = r7.c.get("input_comment_type");
        if ((r14 instanceof Integer) == true) goto L52;
        r14 = null;
    L52:
        Integer r15 = (Integer) r14;
        if (r15 != null) goto L56;
    L58:
        boolean r16 = false;
    L59:
        if (r16 == false) goto L61;
        return 15;
    L61:
        Intrinsics.checkNotNullParameter(r7, "event");
        Object r17 = r7.c.get("input_comment_type");
        if ((r17 instanceof Integer) == false) goto L65;
        r4 = r17;
    L65:
        Integer r18 = (Integer) r4;
        if (r18 != null) goto L69;
    L71:
        r3 = false;
    L72:
        if (r3 == true) goto L83;
        return 0;
    L83:
        return 14;
    L69:
        if (r18.intValue() != 14) goto L71;
    L56:
        if (r15.intValue() != 15) goto L58;
        r16 = true;
        goto L59
    L44:
        if (r11.equals("anchor_custom_topic_btn") != true) goto L46;
    L45:
        r13 = true;
        goto L47
    L37:
        if (r9.equals("comment_topic_btn") == true) goto L45;
    L30:
        if (r6.equals("anchor_custom_topic") == true) goto L45;
    L23:
        if (r2.equals("comment_topic") == true) goto L45;
        goto L24
    }

    public static boolean b(d0 r1) {
        Intrinsics.checkNotNullParameter(r1, "event");
        Object r2 = r1.c.get("input_comment_type");
        if ((r2 instanceof Integer) == true) goto L5;
        r2 = null;
    L5:
        Integer r3 = (Integer) r2;
        if (r3 != null) goto L9;
    L11:
        return false;
    L9:
        if (r3.intValue() != 11) goto L11;
        return true;
    }

    public static boolean c(d0 r1) {
        Intrinsics.checkNotNullParameter(r1, "event");
        Object r2 = r1.c.get("is_from_comment_operate_copy");
        if ((r2 instanceof Boolean) == true) goto L5;
        r2 = null;
    L5:
        Boolean r3 = (Boolean) r2;
        if (r3 != null) goto L10;
        return false;
    L10:
        return r3.booleanValue();
    }

    public static boolean d(d0 r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        Object r0 = r8.c.get("request_source");
        Object r3 = null;
        if ((r0 instanceof String) == true) goto L5;
        r0 = null;
    L5:
        String r1 = (String) r0;
        if (r1 != null) goto L8;
        return false;
    L8:
        Iterator<Map.Entry<String, List<String>>> r4 = a.entrySet().iterator();
    L10:
        if (r4.hasNext() == false) goto L17;
        Map.Entry<String, List<String>> r5 = r4.next();
        if (Intrinsics.areEqual("9", r5.getKey()) == false) goto L10;
        if (r5.getValue().contains(r1) == false) goto L10;
        return true;
    L17:
        Object r9 = r8.c.get("request_source");
        if ((r9 instanceof String) == false) goto L21;
        r3 = r9;
    L21:
        String r6 = (String) r3;
        if (r6 != null) goto L24;
        return false;
    L24:
        return r6.equals("lottery");
    }

    public static boolean e(d0 r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        Object r0 = r8.c.get("request_source");
        Object r3 = null;
        if ((r0 instanceof String) == true) goto L5;
        r0 = null;
    L5:
        String r1 = (String) r0;
        if (r1 != null) goto L8;
        return false;
    L8:
        Iterator<Map.Entry<String, List<String>>> r4 = a.entrySet().iterator();
    L10:
        if (r4.hasNext() == false) goto L17;
        Map.Entry<String, List<String>> r5 = r4.next();
        if (Intrinsics.areEqual("10", r5.getKey()) == false) goto L10;
        if (r5.getValue().contains(r1) == false) goto L10;
        return true;
    L17:
        Object r9 = r8.c.get("request_source");
        if ((r9 instanceof String) == false) goto L21;
        r3 = r9;
    L21:
        String r6 = (String) r3;
        if (r6 != null) goto L24;
        return false;
    L24:
        return r6.equals("super_lottery");
    }

    public static boolean f(d0 r1) {
        Intrinsics.checkNotNullParameter(r1, "event");
        Object r2 = r1.c.get("from_voice_panel");
        if ((r2 instanceof Boolean) == true) goto L5;
        r2 = null;
    L5:
        Boolean r3 = (Boolean) r2;
        if (r3 != null) goto L10;
        return false;
    L10:
        return r3.booleanValue();
    }
}
