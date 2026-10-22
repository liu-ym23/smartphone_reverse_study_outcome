package ko8;

import android.os.SystemClock;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final ConcurrentHashMap<String, a> a = null;
    public static final ConcurrentHashMap<String, String> b = null;

    public static final class a {
        public final long a;
        public final String b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "TraceRecord(startTime=" + this.a + ", sendType=" + this.b + ')';
        }

        public a(long r2, String r4) {
            Intrinsics.checkNotNullParameter(r4, "sendType");
            this.a = r2;
            this.b = r4;
        }
    }

    static {
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
    }

    public static void a(String r5, String r6) {
        boolean r0 = true;
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L23;
        if (r6 != null) goto L12;
    L15:
        if (r0 == false) goto L18;
        return;
    L18:
        if (a.containsKey(r5) == true) goto L21;
        FLogger.a.i("CreationSendMessageTrace", "bind skipped, traceId not started, traceId=" + r5 + ", localMessageId=" + r6);
        return;
    L21:
        b.put(r6, r5);
        FLogger.a.i("CreationSendMessageTrace", "bind traceId=" + r5 + ", localMessageId=" + r6);
        return;
    L12:
        if (r6.length() == 0) goto L15;
        r0 = false;
        goto L15
    L23:
        return;
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static void b(String r1, List r2) {
        Intrinsics.checkNotNullParameter(r2, "localMessageIds");
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        a(r1, (String) r3.next());
        goto L4
    }

    public static void d(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "sendType");
        if (r4 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        a.put(r4, new a(SystemClock.elapsedRealtime(), r5));
        FLogger.a.i("CreationSendMessageTrace", "start traceId=" + r4 + ", sendType=" + r5);
        return;
    L5:
        if (r4.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    public static void c(String r9, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "sendFuncChannel");
        boolean r0 = true;
        if (r9 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return;
    L11:
        ConcurrentHashMap<String, String> r3 = b;
        String r4 = r3.remove(r9);
        if (r4 != null) goto L15;
        return;
    L15:
        if (r4.length() != 0) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == true) goto L49;
        a r6 = a.remove(r4);
        if (r6 == null) goto L50;
        Iterator<T> r7 = r3.entrySet().iterator();
    L25:
        if (r7.hasNext() == false) goto L29;
        Map.Entry r8 = (Map.Entry) r7.next();
        if (Intrinsics.areEqual(r8.getValue(), r4) == false) goto L25;
        b.remove(r8.getKey());
        goto L25
    L29:
        long r12 = SystemClock.elapsedRealtime() - r6.a;
        if (0 <= r12) goto L32;
    L34:
        r0 = false;
    L36:
        if (r0 == true) goto L38;
        FLogger.a.e("CreationSendMessageTrace", "invalid duration=" + r12 + ", traceId=" + r4);
        return;
    L38:
        JSONObject r1 = new JSONObject();
        r1.put("trace_id", r4);
        r1.put("duration", r12);
        r1.put("send_type", r6.b);
        if (r9 != null) goto L41;
        r9 = "";
    L41:
        r1.put(MusicAppletPage.KEY_MESSAGE_ID, r9);
        r1.put("content_type", r10);
        r1.put("send_func_channel", r11);
        FLogger.a.i("CreationSendMessageTrace", "report creation_send_message_cost, params=" + r1);
        o.a.reportEvent("creation_send_message_cost", r1);
        return;
    L32:
        if (r12 >= 600001) goto L34;
    L50:
        return;
    L49:
        return;
    L17:
        r5 = false;
        goto L18
    L5:
        if (r9.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
