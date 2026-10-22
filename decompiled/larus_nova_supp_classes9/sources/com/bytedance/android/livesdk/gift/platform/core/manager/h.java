package com.bytedance.android.livesdk.gift.platform.core.manager;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftListRepo;
import com.bytedance.android.livesdk.gift.platform.core.d0;
import com.bytedance.android.livesdk.gift.platform.core.utils.z;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h {
    public final ConcurrentHashMap<Long, Integer> a;
    public final ConcurrentHashMap<Long, List<g>> b;
    public boolean c;
    public final boolean d;
    public final a e;

    public class a extends ca0.w {
        public final /* synthetic */ h a;

        public final void a() {
            this.a.c = false;
        }

        public a(h r1) {
            this.a = r1;
        }

        public final void b(List<? extends w1> r2) {
            h r3 = this.a;
            r3.c = false;
            r3.a();
        }
    }

    public interface b {
        void a(long r1);

        void b(h1 r1);
    }

    public final void a() {
        if (this.c == false) goto L5;
        return;
    L5:
        Iterator<Map.Entry<Long, Integer>> r1 = this.a.entrySet().iterator();
    L6:
        Integer r4 = null;
        if (r1.hasNext() == false) goto L21;
        Map.Entry<Long, Integer> r2 = r1.next();
        if (r2.getValue().intValue() < ((Number) com.bytedance.android.livesdk.gift.platform.core.h.d.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[2])).intValue()) goto L19;
        Iterator<g> r3 = b(r2.getKey().longValue()).iterator();
    L12:
        if (r3.hasNext() == false) goto L18;
        g r5 = r3.next();
        h1 r6 = GiftManagerKt.j(r5.a, r4);
        if (r6 != null) goto L16;
        r5.c.a(r5.a);
        boolean r7 = d0.a;
        boolean r8 = this.d;
        long r9 = r5.a;
        long r10 = r5.b;
        String r13 = z.a("ttlive_gift_find_more_error");
        JSONObject r15 = new JSONObject();
        JSONObject r11 = new JSONObject();
        JSONObject r14 = new JSONObject();
        Intrinsics.checkNotNullParameter(r14, "extra");
        Intrinsics.checkNotNullParameter(r11, "metric");
        EventModule r16 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r16, "eventModule");
        String r17 = r16.getValue();
        Intrinsics.checkNotNullParameter(r15, "map");
        Boolean r18 = Boolean.valueOf(r8);
        Intrinsics.checkNotNullParameter("is_anchor", "key");
        Intrinsics.checkNotNullParameter(r18, "value");
        r15.put("is_anchor", r18);
        Intrinsics.checkNotNullParameter(r11, "map");
        Long r19 = Long.valueOf(r9);
        Intrinsics.checkNotNullParameter("gift_id", "key");
        Intrinsics.checkNotNullParameter(r19, "value");
        r11.put("gift_id", r19);
        Long r20 = Long.valueOf(r10);
        Intrinsics.checkNotNullParameter("room_id", "key");
        Intrinsics.checkNotNullParameter(r20, "value");
        r11.put("room_id", r20);
        cy0.e.a.getClass();
        cy0.j r21 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r23 = com.bytedance.android.scope.m.b(r21).b(n97.a.class);
        Intrinsics.checkNotNull(r23);
        ((com.bytedance.live.kmp.core.c) r23).g(r13, r17, "bussiness_api_call", r15, r11, r14);
    L17:
        r1 = r1;
        r3 = r3;
        r4 = null;
        goto L12
    L16:
        r5.c.b(r6);
        goto L17
    L18:
        Iterator<Map.Entry<Long, Integer>> r110 = r1;
        this.b.remove(r2.getKey());
        this.a.remove(r2.getKey());
    L20:
        r1 = r110;
        goto L6
    L19:
        r110 = r1;
        goto L20
    L21:
        Iterator<Map.Entry<Long, List<g>>> r24 = this.b.entrySet().iterator();
    L23:
        if (r24.hasNext() == false) goto L30;
        Iterator<g> r25 = r24.next().getValue().iterator();
    L26:
        if (r25.hasNext() == false) goto L23;
        g r26 = r25.next();
        h1 r27 = GiftManagerKt.j(r26.a, null);
        if (r27 == null) goto L26;
        r26.c.b(r27);
        r25.remove();
        goto L26
    L30:
        Iterator<Map.Entry<Long, Integer>> r28 = this.a.entrySet().iterator();
    L32:
        if (r28.hasNext() == false) goto L89;
        Map.Entry<Long, Integer> r29 = r28.next();
        int r30 = r29.getValue().intValue();
        if (r30 >= ((Number) com.bytedance.android.livesdk.gift.platform.core.h.d.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[2])).intValue()) goto L32;
        long r111 = r29.getKey().longValue();
        r29.setValue(Integer.valueOf(r30 + 1));
        com.bytedance.android.live.revenue.core.util.j.a r31 = com.bytedance.android.live.revenue.core.util.j.C0;
        yz0.k r33 = com.bytedance.android.live.revenue.core.util.f.d(r31.a(), yz0.k.class);
        if (r33 == null) goto L32;
        IRoom r34 = r33.getRoom();
        String r35 = BuildConfig.FLAVOR;
        if (r34 != null) goto L40;
    L42:
        String r112 = BuildConfig.FLAVOR;
    L43:
        long r36 = 0;
        if (b(r111) != null) goto L46;
    L48:
        long r113 = 0;
    L49:
        a r37 = this.e;
        boolean r114 = this.d;
        h1 r38 = GiftManagerKt.a;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L68;
        GiftManagerKt.z.getClass();
        yz0.k r39 = com.bytedance.android.live.revenue.core.util.f.d(r31.a(), yz0.k.class);
        if (r39 == null) goto L54;
        IRoom r40 = r39.getRoom();
    L55:
        if (r40 != null) goto L57;
    L59:
        String r115 = r35;
        if (r40 == null) goto L63;
        r36 = r40.getId();
    L63:
        if (r36 != r111) goto L66;
        if (r40 == null) goto L66;
        int r116 = (int) r40.getRoomLayout();
    L67:
        GiftListRepo.h(r37, r111, 4, r114, r115, r113, r116, null);
    L69:
        this.c = true;
        return;
    L66:
        r116 = 0;
        goto L67
    L57:
        if (r40.getOwner() == null) goto L59;
        IBaseUser r41 = r40.getOwner();
        Intrinsics.checkNotNull(r41);
        r35 = com.bytedance.android.live.base.model.user.o.a(r41);
        goto L59
    L54:
        r40 = null;
        goto L55
    L68:
        GiftManagerKt.z.getClass();
        GiftManagerKt.K(r37, r111, r111, 1, 4, r114, r112, r112, null, r113);
        goto L69
    L46:
        if (b(r111).isEmpty() == true) goto L48;
        r113 = ((g) ListProtector.get(b(r111), 0)).a;
        goto L49
    L40:
        if (r34.getOwner() == null) goto L42;
        r112 = r34.getOwner().getCastSecUid();
        goto L43
    }

    public h(boolean r2) {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.e = new a(this);
        this.d = r2;
    }

    public final List<g> b(long r2) {
        return this.b.get(Long.valueOf(r2));
    }
}
