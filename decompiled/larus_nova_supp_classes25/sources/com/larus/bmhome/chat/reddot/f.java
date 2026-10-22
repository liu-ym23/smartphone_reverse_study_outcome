package com.larus.bmhome.chat.reddot;

import com.larus.bmhome.chat.model.ConversationListModel;
import com.larus.platform.api.m4;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import ic8.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public static final f a = null;
    public static final Lazy b = null;
    public static int c;
    public static final i d = null;
    public static final ConcurrentHashMap<String, Integer> e = null;
    public static final CopyOnWriteArraySet<j> f = null;
    public static volatile boolean g;
    public static final c h = null;

    public static final class a implements com.larus.platform.api.b {
        public a() {
        }

        public final void a(com.larus.platform.api.c r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            f.a(f.a);
        }

        public final void b(com.larus.platform.api.c r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            f.a(f.a);
        }
    }

    public static final class b implements m4 {
        public b() {
        }

        public final void S1() {
            f.a(f.a);
        }

        public final void b1() {
            f.a(f.a);
        }
    }

    public static final class c implements wh8.b {
        public c() {
        }

        @Override // wh8.b
        public final void IJ(int r1) {
        }

        @Override // wh8.b
        public final void Yo(List<wh8.a> r8) {
            Intrinsics.checkNotNullParameter(r8, "list");
            f r0 = f.a;
            ArrayList r1 = new ArrayList(r8);
            ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
            Iterator r2 = r1.iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            r9.add(wh8.a.a((wh8.a) r2.next(), null, null, 4095));
            goto L4
        L6:
            ArrayList r3 = new ArrayList();
            Iterator r10 = r9.iterator();
        L8:
            if (r10.hasNext() == false) goto L12;
            Object r4 = r10.next();
            if (n.q(((wh8.a) r4).a) == true) goto L8;
            r3.add(r4);
            goto L8
        L12:
            int r11 = f.b(null);
            f.c = 0;
            f.e.clear();
            Iterator r5 = r3.iterator();
        L14:
            if (r5.hasNext() == false) goto L33;
            wh8.a r6 = (wh8.a) r5.next();
            wc9.e r7 = r6.a;
            if (r7 == null) goto L14;
            f r12 = f.a;
            if (((Boolean) f.b.getValue()).booleanValue() == false) goto L20;
        L22:
            Integer r13 = r7.l;
            if (r13 == null) goto L25;
            int r14 = r13.intValue();
        L26:
            Integer r15 = r7.m;
            if (r15 == null) goto L29;
            int r16 = r15.intValue();
        L30:
            int r17 = r14 - r16;
        L31:
            if (r17 <= 0) goto L14;
            f.e.put(r7.a, Integer.valueOf(r17));
            f.c += r17;
            goto L14
        L29:
            r16 = 0;
            goto L30
        L25:
            r14 = 0;
            goto L26
        L20:
            if (r6.c != null) goto L22;
            r17 = 0;
            goto L31
        L33:
            int r18 = f.b(null);
            FLogger r19 = FLogger.a;
            r19.d("ConversationRedDotManager", "redDotCount=" + f.c + ", mixedFeedRedDotCount=" + f.d.b(f.c) + ", totalRedDotCount=" + r18 + ", cvsRedDotCountMap=" + f.e);
            if (r18 == r11) goto L50;
            r19.i("ConversationRedDotManager", "totalRedDotCount = " + r11 + " -> " + r18);
            f.c(f.f);
            return;
        }

        @Override // wh8.b
        public final void R70(List r1, List r2) {
            wh8.b.a.a(r1, r2);
        }
    }

    public f() {
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.bmhome.chat.reddot.c] */
    static {
        a = new f();
        b = LazyKt.lazy(new com.larus.bmhome.chat.reddot.b());
        d = new i(new com.larus.bmhome.chat.reddot.c());
        e = new ConcurrentHashMap();
        f = new CopyOnWriteArraySet();
        h = new c();
        AccountService r0 = AccountService.a;
        r0.E(new a());
        r0.H(new b());
        LarkSocialExp r1 = LarkSocialExp.a;
        Function2 r2 = new d();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "listener");
        LarkSocialExp.d.add(r2);
        FLogger.a.i("ConversationRedDotManager", "init");
    }

    public static final void a(f r0) {
        r0.getClass();
        d.a();
        g = false;
        c = 0;
        e.clear();
        f.clear();
    }

    public static int b(String r8) {
        if (r8 == null) goto L7;
        Integer r9 = e.get(r8);
        if (r9 == null) goto L7;
        int r10 = r9.intValue();
    L8:
        long r0 = RangesKt.coerceAtLeast(c - r10, 0);
        LarkSocialExp.a.getClass();
        if (LarkSocialExp.e() == false) goto L12;
        r0 = d.b(r0);
    L12:
        return (int) RangesKt.coerceIn(r0, 0, 2147483647L);
    L7:
        r10 = 0;
        goto L8
    }

    public static void c(Set r4) {
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L15;
        j r0 = (j) r5.next();
        LarkSocialExp.a.getClass();
        boolean r3 = true;
        if (LarkSocialExp.e() == false) goto L11;
        d.getClass();
        if ((!i.d()) == true) goto L11;
        r3 = false;
    L11:
        if (r3 == false) goto L13;
        String r1 = r0.b();
    L14:
        r0.a(RangesKt.coerceAtLeast(b(r1), 0));
        goto L4
    L13:
        r1 = null;
        goto L14
    }

    public static void d(com.larus.bmhome.chat.reddot.a r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        if (g == true) goto L7;
        g = true;
        ConversationListModel r0 = ConversationListModel.a;
        c r1 = h;
        r0.f(r1);
        r0.e(r1, false);
        LarkSocialExp.a.getClass();
        if (LarkSocialExp.e() == false) goto L7;
        d.e();
    L7:
        f.add(r3);
        c(SetsKt.setOf(r3));
    }

    public static void e(j r1) {
        Intrinsics.checkNotNullParameter(r1, "observer");
        f.remove(r1);
    }
}
