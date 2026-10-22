package d62;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;
import ylc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements d62.a {
    public final Map<Long, a> a;
    public final CopyOnWriteArrayList<ylc.c> b;
    public final long c;

    public static final class a implements ylc.b {
        public final Map<String, com.ss.ugc.live.sdk.message.wrsc.data.a> a;
        public final HashMap<String, Set<ylc.c>> b;
        public final long c;

        public final long getRoomId() {
            return this.c;
        }

        public a(long r1) {
            this.c = r1;
            this.a = new LinkedHashMap();
            this.b = new HashMap();
        }

        public final com.ss.ugc.live.sdk.message.wrsc.data.a b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "key");
            return (com.ss.ugc.live.sdk.message.wrsc.data.a) ((LinkedHashMap) this.a).get(r2);
        }

        public final void f(ylc.c r3) {
            Intrinsics.checkNotNullParameter(r3, "listener");
            Iterator<Map.Entry<String, Set<ylc.c>>> r0 = this.b.entrySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().getValue().remove(r3);
            goto L4
        }

        public final void a(String r3, ylc.c r4) {
            Intrinsics.checkNotNullParameter(r3, "key");
            Intrinsics.checkNotNullParameter(r4, "listener");
            Set<ylc.c> r0 = this.b.get(r3);
            if (r0 != null) goto L5;
            r0 = new CopyOnWriteArraySet();
            this.b.put(r3, r0);
        L5:
            r0.add(r4);
        }
    }

    public b(long r1) {
        this.c = r1;
        this.a = new LinkedHashMap();
        this.b = new CopyOnWriteArrayList();
    }

    public final a b(long r4) {
        Map<Long, a> r0 = this.a;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        a r2 = (a) r1.get(Long.valueOf(r4));
        if (r2 != null) goto L6;
        a r3 = new a(this.c);
        this.a.put(Long.valueOf(r4), r3);
        return r3;
    L6:
        return r2;
    }

    @Override // d62.a
    public final void a(f r18, vlc.c r19) {
        b r0 = this;
        f r1 = r18;
        vlc.c r2 = r19;
        String r3 = "message";
        Intrinsics.checkNotNullParameter(r1, "message");
        Intrinsics.checkNotNullParameter(r2, "logger");
        long r4 = r1.b;
        Map r6 = r1.h;
        if (r4 > 0) goto L5;
        return;
    L5:
        Iterator r7 = r6.entrySet().iterator();
    L7:
        if (r7.hasNext() == false) goto L33;
        Map.Entry r8 = (Map.Entry) r7.next();
        String r9 = (String) r8.getKey();
        com.ss.ugc.live.sdk.message.wrsc.data.a r10 = (com.ss.ugc.live.sdk.message.wrsc.data.a) r8.getValue();
        int r11 = zlc.a.a;
        Intrinsics.checkNotNullParameter(r1, r3);
        Intrinsics.checkNotNullParameter(r10, "roomDataSync");
        r10.getClass();
        a r13 = r0.b(r4);
        com.ss.ugc.live.sdk.message.wrsc.data.a r14 = r13.b(r9);
        if (r14 != null) goto L11;
        Intrinsics.checkNotNullParameter(r9, "syncKey");
        Intrinsics.checkNotNullParameter(r10, "syncData");
        r13.a.put(r9, r10);
        com.ss.ugc.live.sdk.msg.utils.a.c(r2, "channel[" + r4 + "], wrds key: " + r9 + " init, update version: " + r10.a);
        String r15 = r3;
    L14:
        boolean r5 = true;
    L16:
        if (r5 == false) goto L31;
        r0 = this;
        Iterator<ylc.c> r16 = r0.b.iterator();
    L19:
        if (r16.hasNext() == false) goto L21;
        r16.next().a(r10);
        goto L19
    L21:
        a r17 = (a) ((LinkedHashMap) r0.a).get(Long.valueOf(r4));
        if (r17 == null) goto L32;
        HashMap<String, Set<ylc.c>> r20 = r17.b;
        if (r20 == null) goto L32;
        Set<ylc.c> r21 = r20.get(r9);
        if (r21 == null) goto L32;
        Iterator<T> r23 = r21.iterator();
    L29:
        if (r23.hasNext() == false) goto L32;
        ((ylc.c) r23.next()).a(r10);
    L32:
        r1 = r18;
        r3 = r15;
        goto L7
    L31:
        r0 = this;
        goto L32
    L11:
        long r24 = r14.a;
        r15 = r3;
        long r25 = r10.a;
        if (r25 <= r24) goto L15;
        Intrinsics.checkNotNullParameter(r9, "syncKey");
        Intrinsics.checkNotNullParameter(r10, "syncData");
        r13.a.put(r9, r10);
        r2 = r19;
        com.ss.ugc.live.sdk.msg.utils.a.c(r2, "channel[" + r4 + "], wrds key: " + r9 + " update, previous version: " + r24 + ", update version: " + r25);
        goto L14
    L15:
        r2 = r19;
        com.ss.ugc.live.sdk.msg.utils.a.c(r2, "channel[" + r4 + "], wrds key: " + r9 + " no need update, previous version: " + r24 + ", update version: " + r25);
        r5 = false;
        goto L16
    }
}
