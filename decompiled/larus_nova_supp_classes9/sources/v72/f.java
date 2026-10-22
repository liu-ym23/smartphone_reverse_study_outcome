package v72;

import com.bytedance.android.live.base.model.message.h3;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.interactivity.enteranim.utils.j;
import com.bytedance.android.livesdk.message.model.pg;
import ec2.l1;
import ec2.m1;
import ec2.x;
import ec2.y0;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public static final int g = 0;
    public static final int h = 0;
    public final HashMap<Long, LinkedList<k32.d>> a;
    public final HashMap<String, k32.a> b;
    public final j<k32.a> c;
    public final e d;
    public boolean e;
    public final b f;

    public static final class a {
    }

    public final class b {
        public final String a;
        public final String b;
        public final String c;
        public final j<k32.a> d;
        public final /* synthetic */ f e;

        private final String getType(k32.a r2) {
            if ((r2 instanceof y72.a) == false) goto L6;
            return "GameCPUserDownloadMessage";
        L6:
            if ((r2 instanceof k32.d) == false) goto L9;
            return "NotifyEffectMessage";
        L9:
            if ((r2 instanceof k32.b) == false) goto L12;
            return "LiveEcomMessage";
        L12:
            if ((r2 instanceof k32.c) == false) goto L14;
            return "OpenAssetMessage";
        L14:
            return "MemberMessage";
        }

        public final void b(String r7) {
            Intrinsics.checkNotNullParameter(r7, "tag");
            Iterator<Map.Entry<Long, Deque<k32.a>>> r0 = this.d.a.entrySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L9;
            Map.Entry<Long, Deque<k32.a>> r1 = r0.next();
            long r2 = r1.getKey().longValue();
            Deque<k32.a> r3 = r1.getValue();
            StringBuilder r4 = new StringBuilder("Priority: ");
            r4.append(r2);
            r4.append(", curSize: ");
            f r5 = this.e;
            int r6 = f.g;
            r4.append(r5.b());
            ALogger.i(r7, r4.toString());
            Iterator<k32.a> r8 = r3.iterator();
        L7:
            if (r8.hasNext() == false) goto L4;
            k32.a r9 = r8.next();
            ALogger.i(r7, "UserId: " + r9.a + ", Type:" + getType(r9) + ", EnqueueTime: " + r9.n);
            goto L7
        }

        public b(f r2, j<k32.a> r3) {
            Intrinsics.checkNotNullParameter(r3, "queueManager");
            this.e = r2;
            this.d = r3;
            this.a = "LiveEnterAnimEnqueue";
            this.b = "LiveEnterAnimPoll";
            this.c = "LiveEnterAnimDrop";
        }

        public static void a(b r3, k32.a r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "msg");
            Intrinsics.checkNotNullParameter(r5, "reason");
            ALogger.i(r3.c, "Reason: " + r5 + ", MsgId: " + r4.a + ", Type:" + r3.getType(r4));
        }
    }

    static {
        g = ((Integer) m1.a.getValue()).intValue();
        h = ((Integer) y0.a.getValue()).intValue();
    }

    public final int b() {
        Iterator<Map.Entry<Long, Deque<k32.a>>> r0 = this.c.a.entrySet().iterator();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        r2 = r2 + r0.next().getValue().size();
        goto L4
    L6:
        Deque<k32.a> r3 = this.c.a.get(100000L);
        if (r3 == null) goto L9;
        int r4 = r3.size();
    L10:
        int r5 = r2 - r4;
        Deque<k32.a> r6 = this.c.a.get(90000L);
        if (r6 == null) goto L14;
        r1 = r6.size();
    L14:
        return r5 - r1;
    L9:
        r4 = 0;
        goto L10
    }

    public f(boolean r5) {
        this.a = new HashMap();
        this.b = new HashMap();
        j<k32.a> r0 = new j();
        this.c = r0;
        boolean r1 = w72.a.a;
        w72.b r2 = w72.a.b;
        w72.b r3 = w72.a.c;
        if (((Boolean) l1.a.getValue()).booleanValue() == true) goto L5;
    L7:
        b r4 = null;
    L8:
        this.f = r4;
        if (r5 == true) goto L12;
        r2 = r3;
    L12:
        this.d = new e(r2);
        return;
    L5:
        if (v.a() == false) goto L7;
        r4 = new b(this, r0);
        goto L8
    }

    public static String a(k32.a r3) {
        if ((r3 instanceof y72.a) == false) goto L6;
        return "TTLIVESDK_ENTER_ANIM_GAME_DOWNLOAD";
    L6:
        if ((r3 instanceof k32.b) == false) goto L9;
        return "TTLIVESDK_ENTER_ANIM_ECOM";
    L9:
        if ((r3 instanceof k32.d) == false) goto L39;
        int r0 = com.bytedance.android.livesdk.interactivity.common.enterAnim.f.a;
        k32.d r4 = (k32.d) r3;
        Intrinsics.checkNotNullParameter(r4, "userInfo");
        if (r4.a() == true) goto L13;
        h3 r5 = r4.t;
        if (r5 == null) goto L39;
        pg.c r6 = r5.M();
        if (r6 == null) goto L39;
        if (Intrinsics.areEqual(r6.c(), Boolean.TRUE) == false) goto L39;
        return r6.getScene();
    L13:
        if (((Boolean) x.a.getValue()).booleanValue() == false) goto L39;
        h3 r7 = r4.t;
        if (r7 == null) goto L28;
        com.bytedance.android.live.base.model.message.d r8 = r7.I0();
        if (r8 == null) goto L28;
        List r9 = r8.b();
        if (r9 == null) goto L28;
        Iterator r10 = r9.iterator();
    L22:
        if (r10.hasNext() == false) goto L26;
        Object r1 = r10.next();
        if (((com.bytedance.android.live.base.model.message.f) r1).a() == false) goto L22;
    L27:
        com.bytedance.android.live.base.model.message.f r2 = (com.bytedance.android.live.base.model.message.f) r1;
    L29:
        if (r2 == null) goto L39;
        return r2.b();
    L26:
        r1 = null;
    L28:
        r2 = null;
    L39:
        return null;
    }
}
