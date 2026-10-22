package vtb;

import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.biz.im.api.bundle.ChatType;
import com.ss.android.lark.biz.im.api.bundle.SourceType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import idb.f;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public static final Map<String, a> a = null;

    public static class a {
        public final Map<String, C0200a> A;
        public Long B;
        public String C;
        public int D;
        public boolean E;
        public final SourceType F;
        public ChatType G;
        public final Long a;
        public Long b;
        public Long c;
        public Long d;
        public Long e;
        public Long f;
        public Long g;
        public Long h;
        public Long i;
        public Long j;
        public Long k;
        public Long l;
        public boolean m;
        public boolean n;
        public String o;
        public String p;
        public long q;
        public List<Long> r;
        public long s;
        public long t;
        public long u;
        public boolean v;
        public long w;
        public long x;
        public String y;
        public final Map<Integer, Long> z;

        /* JADX INFO: renamed from: vtb.c$a$a, reason: collision with other inner class name */
        public static class C0200a {
            public Integer getType() {
                return null;
            }
        }

        public final Map<String, Object> a() {
            HashMap r0 = new HashMap();
            r0.put("source_type", Integer.valueOf(this.F.index));
            r0.put("chat_type", Integer.valueOf(this.G.index));
            r0.put("is_external", Integer.valueOf(this.E ? 1 : 0));
            int r3 = 1;
            if (this.G != ChatType.MEETING) goto L5;
            int r1 = 1;
        L6:
            r0.put("is_meeting", Integer.valueOf(r1));
            if (this.G == ChatType.EDU_CHAT) goto L10;
            r3 = 0;
        L10:
            r0.put("is_edu", Integer.valueOf(r3));
            Map<String, a> r2 = c.a;
            if (f.a().isCurrentEnable("openplatform.universal_card.enter_chat_monitor") == false) goto L17;
            Iterator r4 = ((HashMap) this.A).values().iterator();
            if (r4.hasNext() == true) goto L15;
            r0.put("rendered_card_size", 0);
            goto L17
        L15:
            ((C0200a) r4.next()).getClass();
            throw null;
        L17:
            return r0;
        L5:
            r1 = 0;
            goto L6
        }

        public final Map<String, Object> b() {
            HashMap r0 = new HashMap();
            r0.put("chatter_count", Integer.valueOf(this.D));
            String r1 = this.p;
            String r2 = "";
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            r0.put("feed_id", r1);
            List<Long> r3 = this.r;
            if (r3 == null) goto L8;
            r2 = Arrays.toString(r3.toArray());
        L8:
            r0.put("net_costs", r2);
            return r0;
        }

        public final String toString() {
            return "PerfLoadChat{startTime=" + this.a + ", endTime=" + this.b + ", duration=" + this.B + ", key='" + this.C + "', sourceType='" + this.F.value + "', chatType='" + this.G.value + "', loading='0', renderTime='" + this.v + '\'' + this.w + '\'' + this.x + "'}";
        }

        public a(SourceType r6) {
            this.a = 0L;
            this.b = 0L;
            this.c = 0L;
            this.d = 0L;
            this.e = 0L;
            this.f = 0L;
            this.g = 0L;
            this.h = 0L;
            this.i = 0L;
            this.j = 0L;
            this.k = 0L;
            this.l = 0L;
            this.m = false;
            this.n = false;
            this.q = 0;
            this.r = null;
            this.s = 0;
            this.t = 0;
            this.u = 0;
            this.v = false;
            this.w = 0;
            this.x = 0;
            this.z = new HashMap();
            this.A = new HashMap();
            this.B = 0L;
            this.C = null;
            this.D = 0;
            this.E = false;
            this.F = SourceType.FEED;
            this.G = ChatType.GROUP;
            this.a = Long.valueOf(System.currentTimeMillis());
            this.F = r6;
        }
    }

    static {
        a = new ConcurrentHashMap();
    }

    public static void a(String r12, SourceType r13) {
        if (r13 == null) goto L6;
        a r0 = new a(r13);
        r0.C = r12;
        ((ConcurrentHashMap) a).put(r12, r0);
        r0.y = AppreciableKit.getInstance().start(Biz.Messenger, Scene.Chat, Event.enter_chat, "chatWindow", false, null, null, null, null);
        Log.d("PerfEnterChatMonitor", "start: " + r12 + "/" + r13);
        int r14 = vtb.a.a;
        PerfLog.start("open_chat", "");
        PerfLog.start("first_window", "");
        return;
    }
}
