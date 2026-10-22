package x91;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.DoubleLikeHolder;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.PVHolder;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.TicketHolder;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.UVHolder;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.g;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.i;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.j;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.k;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit.AnchorTabReloadMonitor;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit.AnchorTextInfoChangeMonitor;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit.DiggTemporaryDataMonitor;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit.DoubleLikeDataMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import s91.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final Map<Class<? extends o91.b.n>, Integer> a = null;
    public static final Map<Class<? extends o91.b.n>, Integer> b = null;
    public static final e c = null;
    public static final List<s91.e<f>> d = null;

    /* JADX INFO: renamed from: x91.a$a, reason: collision with other inner class name */
    public static final class C0345a implements s91.e<f> {
        public C0345a() {
        }

        @Override // s91.e
        public final s91.b a(int r1, int r2, DataCenter r3, DataContext r4, IRoom r5) {
            Intrinsics.checkNotNullParameter(r3, "dataCenter");
            if (a0.d(r3, false) == true) goto L7;
            return null;
        L7:
            return new AnchorTextInfoChangeMonitor(r4, r3, r5, r2);
        }
    }

    public static final class b implements s91.e<f> {
        public b() {
        }

        @Override // s91.e
        public final s91.b a(int r1, int r2, DataCenter r3, DataContext r4, IRoom r5) {
            Intrinsics.checkNotNullParameter(r3, "dataCenter");
            return new AnchorTabReloadMonitor(r4, r3, r5);
        }
    }

    public static final class c implements s91.e<f> {
        public c() {
        }

        @Override // s91.e
        public final s91.b a(int r8, int r9, DataCenter r10, DataContext r12, IRoom r13) {
            Intrinsics.checkNotNullParameter(r10, "dataCenter");
            if (a0.d(r10, false) == false) goto L5;
            return null;
        L5:
            if (r8 == 9) goto L7;
            return null;
        L7:
            if (r9 == 2) goto L9;
            return null;
        L9:
            return new DiggTemporaryDataMonitor(r8, r9, r12, r10, r13);
        }
    }

    public static final class d implements s91.e<f> {
        public d() {
        }

        @Override // s91.e
        public final s91.b a(int r8, int r9, DataCenter r10, DataContext r12, IRoom r13) {
            Intrinsics.checkNotNullParameter(r10, "dataCenter");
            if (r9 == 2) goto L5;
            return null;
        L5:
            return new DoubleLikeDataMonitor(r8, r9, r12, r10, r13);
        }
    }

    public static final class e {
        public e() {
        }
    }

    static {
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to(o91.b.j.class, 1), TuplesKt.to(o91.b.l.class, 2), TuplesKt.to(o91.b.k.class, 3), TuplesKt.to(o91.b.m.class, 8), TuplesKt.to(o91.b.f.class, 4), TuplesKt.to(o91.b.a.class, 10)});
        b = MapsKt.mapOf(new Pair[]{TuplesKt.to(o91.b.l.class, 2), TuplesKt.to(o91.b.k.class, 3), TuplesKt.to(o91.b.m.class, 8), TuplesKt.to(o91.b.f.class, 4), TuplesKt.to(o91.b.g.class, 5), TuplesKt.to(o91.b.h.class, 9), TuplesKt.to(o91.b.C0286b.class, 6), TuplesKt.to(o91.b.c.class, 7), TuplesKt.to(o91.b.a.class, 10), TuplesKt.to(o91.b.d.class, 11)});
        c = new e();
        d = CollectionsKt.listOf(new s91.e[]{new c(), new d(), new C0345a(), new b()});
    }

    @JvmStatic
    public static final int c(int r5, o91.b r6) {
        if (r6 != null) goto L10;
        ALogger.d("TabHelper", "tabLine:" + r5 + ",不合法轮播类型");
        if (v.a() == true) goto L8;
        return 0;
    L8:
        throw new IllegalArgumentException("tabLine:" + r5 + ",不合法轮播类型");
    L10:
        if (r5 != 1) goto L12;
        Integer r7 = a.get(r6.getClass());
    L16:
        if (r7 == null) goto L18;
    L22:
        ALogger.d("TabHelper", "the itemType of tabline:" + r5 + " is " + r7);
        return r7.intValue();
    L18:
        if (v.a() == true) goto L21;
        r7 = 0;
        goto L22
    L21:
        throw new IllegalArgumentException("tabLine:" + r5 + ",不合法轮播类型");
    L12:
        if (r5 == 2) goto L14;
        r7 = null;
        goto L16
    L14:
        r7 = b.get(r6.getClass());
        goto L16
    }

    @JvmStatic
    public static final List d(List r4, int r5, int r6, DataCenter r7) {
        Intrinsics.checkNotNullParameter(r4, "initDataLoaders");
        Intrinsics.checkNotNullParameter(r7, "dataCenter");
        boolean r8 = a0.d(r7, false);
        ArrayList r0 = new ArrayList();
        Iterator r9 = r4.iterator();
    L4:
        if (r9.hasNext() == false) goto L15;
        t91.e r1 = (t91.e) r9.next();
        u91.a r3 = null;
        if (r1.b(r8, r6, Integer.valueOf(r5)) == true) goto L9;
        r1 = null;
    L9:
        if (r1 == null) goto L13;
        u91.a r2 = r1.a(Integer.valueOf(r5));
        if (r2 == null) goto L13;
        r2.b = r8;
        r2.c = r6;
        r2.a = r5;
        r3 = r2;
    L13:
        if (r3 == null) goto L4;
        r0.add(r3);
        goto L4
    L15:
        return r0;
    }

    @JvmStatic
    public static final CommonTabHolder a(DataCenter r6, IRoom r7, int r8, int r9, ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r10, "tabParent");
        c.getClass();
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r10, "tabParent");
        boolean r2 = a0.d(r6, false);
        ALogger.d("TabHelper", "createHolder,the itemViewType is " + r9);
        switch(r9) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L7;
            default: goto L4;
        };
    L4:
        String r12 = "不符合预期的itemType：" + r9 + ", tabLine:" + r8;
        if (v.a() == true) goto L20;
        ALogger.e("TabHelper", r12);
        return new j(r7, r6, LayoutInflater.from(r10.getContext()).inflate(2131567912, r10, false));
    L20:
        throw new IllegalArgumentException(r12);
    L7:
        int r13 = com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.f.i;
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r10, "parent");
        int r0 = CommonTabHolder.g;
        return new com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.f(r7, r6, CommonTabHolder.a.a(r2, r8, r6, r10));
    L8:
        int r14 = com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.a.i;
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r10, "parent");
        int r1 = CommonTabHolder.g;
        return new com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.a(r7, r6, CommonTabHolder.a.a(r2, r8, r6, r10));
    L9:
        int r15 = DoubleLikeHolder.i;
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r10, "parent");
        int r3 = CommonTabHolder.g;
        return new DoubleLikeHolder(r7, r6, CommonTabHolder.a.a(r2, r8, r6, r10));
    L10:
        int r16 = UVHolder.j;
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r10, "parent");
        int r4 = CommonTabHolder.g;
        return new UVHolder(r7, r6, CommonTabHolder.a.a(r2, r8, r6, r10));
    L11:
        int r17 = com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.c.j;
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r10, "parent");
        return new com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.c(r7, r6, LayoutInflater.from(r10.getContext()).inflate(2131567910, r10, false));
    L12:
        int r18 = com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.d.i;
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r10, "parent");
        return new com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.d(r7, r6, LayoutInflater.from(r10.getContext()).inflate(2131567910, r10, false));
    L13:
        int r19 = i.p;
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r10, "parent");
        int r5 = CommonTabHolder.g;
        return new i(r7, r6, CommonTabHolder.a.a(r2, r8, r6, r10));
    L14:
        int r20 = g.n;
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r10, "parent");
        int r22 = CommonTabHolder.g;
        return new g(r7, r6, CommonTabHolder.a.a(r2, r8, r6, r10));
    L15:
        int r23 = PVHolder.k;
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r10, "parent");
        int r24 = CommonTabHolder.g;
        return new PVHolder(r7, r6, CommonTabHolder.a.a(r2, r8, r6, r10));
    L16:
        int r25 = TicketHolder.j;
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r10, "parent");
        int r26 = CommonTabHolder.g;
        return new TicketHolder(r7, r6, CommonTabHolder.a.a(r2, r8, r6, r10));
    L17:
        int r27 = k.k;
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r10, "parent");
        return new k(r7, r6, LayoutInflater.from(r10.getContext()).inflate(2131567911, r10, false));
    }

    @JvmStatic
    public static final List<s91.b<f>> b(int r8, int r9, Context r10, DataCenter r12, DataContext r13, IRoom r14) {
        Intrinsics.checkNotNullParameter(r12, "dataCenter");
        List<s91.e<f>> r15 = d;
        ArrayList r0 = new ArrayList();
        Iterator<T> r16 = r15.iterator();
    L4:
        if (r16.hasNext() == false) goto L8;
        s91.b r1 = ((s91.e) r16.next()).a(r8, r9, r12, r13, r14);
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }
}
