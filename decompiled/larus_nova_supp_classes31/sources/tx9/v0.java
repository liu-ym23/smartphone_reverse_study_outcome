package tx9;

import android.os.SystemClock;
import com.ixigua.lib.track.TrackParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class v0 {
    public static final ConcurrentHashMap<String, c> a = null;

    public static final class a {
        public final String a;
        public final String b;
        public final String c;
        public final c d;
        public final long e;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r9.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.c;
            if (r5 == null) goto L10;
            r2 = r5.hashCode();
        L10:
            int r6 = (((r4 + r2) * 31) + this.d.hashCode()) * 31;
            long r7 = this.e;
            return r6 + ((int) (r7 ^ (r7 >>> 32)));
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "DirectSendTraceContext(localMessageId=" + this.a + ", conversationId=" + this.b + ", botId=" + this.c + ", traceExt=" + this.d + ", startTime=" + this.e + ')';
        }

        public a(String r2, String r3, String r4, c r5, long r6) {
            Intrinsics.checkNotNullParameter(r2, "localMessageId");
            Intrinsics.checkNotNullParameter(r5, "traceExt");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class b {
        public final String a;
        public final String b;
        public final List<String> c;
        public final List<String> d;
        public final long e;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r9.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (((((r0 + r2) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
            long r4 = this.e;
            return r3 + ((int) (r4 ^ (r4 >>> 32)));
        L5:
            r2 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "MessageTransferTraceContext(transferType=" + this.a + ", conversationId=" + this.b + ", messageIds=" + this.c + ", targetConversationIds=" + this.d + ", startTime=" + this.e + ')';
        }

        public b(String r2, String r3, List<String> r4, List<String> r5, long r6) {
            Intrinsics.checkNotNullParameter(r2, "transferType");
            Intrinsics.checkNotNullParameter(r4, "messageIds");
            Intrinsics.checkNotNullParameter(r5, "targetConversationIds");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class c {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final int e;
        public final String f;
        public final String g;
        public final String h;
        public final String i;
        public final String j;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
            return false;
        L38:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f.hashCode()) * 31;
            String r1 = this.g;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.h;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.i;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.j;
            if (r11 == null) goto L19;
            r2 = r11.hashCode();
        L19:
            return r10 + r2;
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "SendTraceExt(enterMethod=" + this.a + ", scene=" + this.b + ", currentPage=" + this.c + ", chatType=" + this.d + ", isLarkMsg=" + this.e + ", forwardMessageIdList=" + this.f + ", forwardChatId=" + this.g + ", larkFirstScene=" + this.h + ", larkSecondScene=" + this.i + ", currentModule=" + this.j + ')';
        }

        public final String a() {
            return this.d;
        }

        public final String b() {
            return this.c;
        }

        public final String c() {
            return this.a;
        }

        public final String d() {
            return this.b;
        }

        public /* synthetic */ c(String r10, int r11, String r12, String r13) {
            this("message_forward", r10, r11, r12, r13, null, null, null);
        }

        public c(String r4, String r5, int r6, String r7, String r8, String r9, String r10, String r11) {
            Intrinsics.checkNotNullParameter(r4, "enterMethod");
            Intrinsics.checkNotNullParameter("message_forward", "scene");
            Intrinsics.checkNotNullParameter("chat", "currentPage");
            Intrinsics.checkNotNullParameter(r5, "chatType");
            Intrinsics.checkNotNullParameter(r7, "forwardMessageIdList");
            this.a = r4;
            this.b = "message_forward";
            this.c = "chat";
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
        }
    }

    public v0() {
    }

    static {
        a = new ConcurrentHashMap();
    }

    public static JSONObject b(b r3) {
        JSONObject r0 = new JSONObject();
        r0.put("transfer_type", r3.a);
        String r1 = r3.b;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.put("conversation_id", r1);
        List<String> r4 = r3.c;
        JSONArray r2 = new JSONArray();
        Iterator<T> r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        r2.put((String) r5.next());
        goto L7
    L9:
        r0.put("message_id", r2);
        return r0;
    }

    public static void c(String r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if ((!StringsKt.isBlank(r1)) == true) goto L7;
        r1 = null;
    L7:
        if (r1 == null) goto L11;
        c r2 = a.remove(r1);
        return;
    }

    public static String e(String r2) {
        if (Intrinsics.areEqual(r2, "group") == true) goto L7;
        Intrinsics.areEqual(r2, "private");
        return "private";
    L7:
        return "group";
    }

    public static void h(b r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        by7.a r0 = new by7.a("flow_message_transfer_click");
        TrackParams r3 = new TrackParams().merge(b(r2));
        r0.a.merge(r3);
        r0.b();
    }

    public static String k(String r1) {
        if (r1 != null) goto L4;
    L6:
        return null;
    L4:
        if ((!StringsKt.isBlank(r1)) == false) goto L6;
        return r1;
    }

    public static void a(JSONObject r2, c r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        if (r3 != null) goto L5;
        return;
    L5:
        r2.put("enter_method", r3.a);
        r2.put("scene", r3.b);
        r2.put("current_page", r3.c);
        r2.put("is_lark_msg", r3.e);
        r2.put("forward_message_id_list", r3.f);
        Object r0 = r3.h;
        if (r0 == null) goto L8;
        r2.put("lark_first_scene", r0);
    L8:
        Object r1 = r3.i;
        if (r1 == null) goto L11;
        r2.put("lark_second_scene", r1);
    L11:
        Object r4 = r3.j;
        if (r4 == null) goto L14;
        r2.put("current_module", r4);
    L14:
        String r5 = r3.g;
        if (r5 != null) goto L17;
        return;
    L17:
        if ((!StringsKt.isBlank(r5)) == true) goto L20;
        r5 = null;
    L20:
        if (r5 == null) goto L24;
        r2.put("forward_chat_id", r5);
        return;
    }

    public static b d(String r7, String r8, List r9, List r10) {
        Intrinsics.checkNotNullParameter(r7, "transferType");
        Intrinsics.checkNotNullParameter(r9, "messageIds");
        Intrinsics.checkNotNullParameter(r10, "targetConversationIds");
        String r0 = "to_doubao";
        if (Intrinsics.areEqual(r7, "to_doubao") == false) goto L5;
    L4:
        r7 = r0;
    L8:
        String r1 = r7;
        ArrayList r11 = new ArrayList();
        Iterator r12 = r9.iterator();
    L10:
        if (r12.hasNext() == false) goto L14;
        Object r2 = r12.next();
        if ((!StringsKt.isBlank((String) r2)) == false) goto L10;
        r11.add(r2);
        goto L10
    L14:
        List r3 = CollectionsKt.distinct(r11);
        ArrayList r13 = new ArrayList();
        Iterator r14 = r10.iterator();
    L16:
        if (r14.hasNext() == false) goto L21;
        Object r15 = r14.next();
        if ((!StringsKt.isBlank((String) r15)) == false) goto L16;
        r13.add(r15);
        goto L16
    L21:
        return new b(r1, r8, r3, CollectionsKt.distinct(r13), SystemClock.elapsedRealtime());
    L5:
        r0 = "to_chat";
        if (Intrinsics.areEqual(r7, "to_chat") == false) goto L8;
        goto L8
    }

    public static void f(a r160, boolean r161, String r162, String r163) {
        Intrinsics.checkNotNullParameter(r160, "context");
        JSONObject r1 = new JSONObject();
        a(r1, r160.d);
        if (r161 == false) goto L5;
        long r2 = 1;
    L6:
        long r28 = r2;
        if (r162 != null) goto L9;
    L13:
        String r3 = r160.a;
    L14:
        String r13 = r3;
        String r6 = r160.b;
        String r4 = r160.c;
        long r10 = SystemClock.elapsedRealtime() - r160.e;
        c r0 = r160.d;
        String r5 = r0.b;
        String r7 = r0.c;
        String r8 = r0.d;
        l3.d(r4, r8, null, null, r6, r7, Long.valueOf(r10), r8, null, null, null, r13, "card", null, null, null, null, null, null, null, r163, r5, null, null, null, null, Long.valueOf(r28), "card", null, null, null, null, null, null, null, null, null, r1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r0.a, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1023360281, -1073742849, -1, -1, Integer.MAX_VALUE);
        return;
    L9:
        if ((!StringsKt.isBlank(r162)) == false) goto L11;
        r3 = r162;
    L12:
        if (r3 != null) goto L14;
    L11:
        r3 = null;
        goto L12
    L5:
        r2 = 0;
        goto L6
    }

    public static void g(String r2, Integer r3, Long r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        JSONObject r6 = new JSONObject();
        r6.put("from", "doubao_to_lark");
        r6.put("intercept_reason", r2);
        if (r3 == null) goto L11;
        r6.put("select_count", r3.intValue());
    L11:
        if (r4 == null) goto L13;
        r6.put("select_size", r4.longValue());
    L13:
        by7.a r7 = new by7.a("im_msg_merge_forward_limit_intercept");
        r7.a.merge(new TrackParams().merge(r6));
        r7.b();
    }

    public static void i(b r16, boolean r17, List r18, String r19, String r20) {
        Intrinsics.checkNotNullParameter(r16, "context");
        if (r18 == null) goto L13;
        ArrayList r2 = new ArrayList();
        Iterator r1 = r18.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Object r3 = r1.next();
        if ((!StringsKt.isBlank((String) r3)) == false) goto L6;
        r2.add(r3);
        goto L6
    L10:
        List<String> r4 = CollectionsKt.distinct(r2);
        if (r4 == null) goto L13;
    L14:
        JSONObject r5 = b(r16);
        r5.put("status", !r17 ? 1 : 0);
        JSONArray r6 = new JSONArray();
        Iterator<T> r7 = r4.iterator();
    L16:
        if (r7.hasNext() == false) goto L18;
        r6.put((String) r7.next());
        goto L16
    L18:
        r5.put("target_conversation_id", r6);
        r5.put("duration", SystemClock.elapsedRealtime() - r16.e);
        if (r17 == true) goto L40;
        Object r0 = null;
        if (r19 != null) goto L23;
    L28:
        if (r20 == null) goto L38;
        String r10 = StringsKt.replace$default(r20, '\n', ' ', false, 4, null);
        if (r10 == null) goto L38;
        String r8 = StringsKt.replace$default(r10, '\r', ' ', false, 4, null);
        if (r8 == null) goto L38;
        String r9 = StringsKt.take(r8, 200);
        if (r9 == null) goto L38;
        if ((!StringsKt.isBlank(r9)) == false) goto L38;
        r0 = r9;
    L38:
        if (r0 == null) goto L40;
        r5.put("error_msg", r0);
        goto L40
    L23:
        if ((!StringsKt.isBlank(r19)) == false) goto L25;
        Object r11 = r19;
    L26:
        if (r11 == null) goto L28;
        r5.put("error_code", r11);
        goto L28
    L25:
        r11 = null;
    L40:
        by7.a r12 = new by7.a("flow_message_transfer_result");
        r12.a.merge(new TrackParams().merge(r5));
        r12.b();
        return;
    L13:
        r4 = r16.d;
        goto L14
    }

    public static /* synthetic */ void j(b r2, boolean r3, List r4, String r5, String r6, int r7) {
        if ((r7 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r7 & 8) == 0) goto L9;
        r5 = null;
    L9:
        if ((r7 & 16) == 0) goto L11;
        r6 = null;
    L11:
        i(r2, r3, r4, r5, r6);
    }
}
