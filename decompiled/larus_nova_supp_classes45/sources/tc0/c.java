package tc0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.z0;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkMatchType;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.model.e0;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.livesdk.chatroom.model.v;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.k;
import com.bytedance.android.livesdk.link.model.bridge.u1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.link.model.l6;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import tf0.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c extends ge1.a<Boolean> implements i {
    public static c R;
    public static final Map<String, c> S = null;
    public com.bytedance.android.livesdk.message.linker.b A;
    public int B;
    public boolean C;
    public boolean D;
    public boolean E;
    public String F;
    public String G;
    public String H;
    public Boolean I;
    public int J;
    public int K;
    public LinkMatchType L;
    public String M;
    public boolean N;
    public l6 O;
    public n0 P;
    public long Q;
    public int d;
    public String e;
    public String f;
    public boolean g;
    public int h;
    public int i;
    public int j;
    public String k;
    public v l;
    public String m;
    public v1 n;
    public Map<Long, ? extends g2> o;
    public Map.Entry<Long, ? extends g2> p;
    public g2 q;
    public u1 r;
    public e0 s;
    public final HashMap<String, Long> t;
    public int u;
    public int v;
    public String w;
    public String x;
    public String y;
    public String z;

    public final void k() {
        this.h = 0;
        this.i = 0;
        this.d = 0;
        ((ge1.a) this).b = Boolean.FALSE;
        this.f = null;
        this.j = 0;
        this.v = 0;
        this.k = "";
        this.m = "";
        this.n = null;
        this.r = null;
        this.z = "";
        this.K = LinkApplyType.NORMAL.getValue();
        this.L = LinkMatchType.NONE;
        this.M = "";
        this.N = false;
        this.P = null;
        this.Q = 0;
        this.H = "";
        this.O = null;
        this.D = false;
        ALogger.i("ttlive_link", "LinkInRoomDataHolder reset");
    }

    static {
        S = new ConcurrentHashMap();
    }

    public static c h() {
        if (R != null) goto L6;
        R = new c();
    L6:
        return R;
    }

    public final String f() {
        com.bytedance.android.livesdk.message.linker.b r0 = this.A;
        if (r0 == null) goto L9;
        if (r0.isUseBackup() == false) goto L9;
        return this.A.getLinkmicIdStr();
    L9:
        return this.e;
    }

    public c() {
        this.z = "";
        this.F = "";
        this.H = "";
        Boolean r0 = Boolean.FALSE;
        this.I = r0;
        this.J = 0;
        this.L = LinkMatchType.NONE;
        this.N = false;
        this.P = null;
        this.Q = 0;
        ((ge1.a) this).b = r0;
        this.t = new HashMap();
    }

    public final long getChannelId() {
        Room r0 = m.i().getCurrentRoom();
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getId();
    }

    public final String getInteractId() {
        return this.f;
    }

    public final String getRtcInfo() {
        return this.k;
    }

    public final int getScene() {
        return this.B;
    }

    public final String u() {
        return this.e;
    }

    public static c i(String r3) {
        if (r3 == null) goto L21;
        if (r3.isEmpty() == true) goto L21;
        Map<String, c> r0 = S;
        c r1 = (c) ((ConcurrentHashMap) r0).get(r3);
        if (r1 == null) goto L9;
    L19:
        return r1;
    L9:
        monitor-enter(c.class);
        r1 = (c) ((ConcurrentHashMap) r0).get(r3);     // Catch: Throwable -> L17
        if (r1 != null) goto L13;
        r1 = new c();     // Catch: Throwable -> L17
        ((ConcurrentHashMap) r0).put(r3, r1);     // Catch: Throwable -> L17
    L13:
        monitor-exit(c.class);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    L21:
        return h();
    }

    public final void D0(com.bytedance.android.livesdk.message.linker.b r1) {
        this.A = r1;
    }

    public final void R0(int r1) {
        this.u = r1;
    }

    public final void a(String r1) {
        this.k = r1;
    }

    public final void b(int r1) {
        this.j = r1;
    }

    public final void c1(String r1) {
        this.e = r1;
    }

    public final Map.Entry<Long, ? extends g2> g(String r7) {
        int r0 = e.a;
        Map<Long, ? extends g2> r1 = this.o;
        if (r1 == null) goto L39;
        Set<Map.Entry<Long, ? extends g2>> r2 = r1.entrySet();
        if (r2 == null) goto L40;
        Iterator<T> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L41;
        Map.Entry<Long, ? extends g2> r4 = (Map.Entry) r3.next();
        g2 r5 = r4.getValue();
        if (r5 == null) goto L8;
        List r6 = r5.getLinkedUsers();
        if (r6 == null) goto L8;
        Iterator r8 = r6.iterator();
    L15:
        if (r8.hasNext() == false) goto L23;
        Object r9 = r8.next();
        IBaseUser r11 = ((k) r9).getUser();
        if (r11 == null) goto L19;
        String r12 = r11.getUserId();
    L21:
        if (Intrinsics.areEqual(r12, r7) == false) goto L15;
    L25:
        if (((k) r9) == null) goto L8;
        return r4;
    L19:
        r12 = null;
        goto L21
    L23:
        r9 = null;
        goto L25
    L41:
        return null;
    L40:
        return null;
    L39:
        return null;
    }

    public final void j(Boolean r1) {
        d(r1);
        if (r1 == null) goto L6;
        r1.booleanValue();
        return;
    }

    public final void l(Map<Long, ? extends g2> r1) {
        this.o = r1;
        if (r1 == null) goto L8;
        Map.Entry<Long, ? extends g2> r2 = z0.a(r1);
        this.p = r2;
        if (r2 == null) goto L9;
        this.q = r2.getValue();
        return;
    L9:
        return;
    }

    public final void setInteractId(String r1) {
        this.f = r1;
    }

    public final void setScene(int r1) {
        this.B = r1;
    }
}
