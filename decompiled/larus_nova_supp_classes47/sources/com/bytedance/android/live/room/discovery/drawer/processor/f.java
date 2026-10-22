package com.bytedance.android.live.room.discovery.drawer.processor;

import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.live.datacontext.m;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements com.bytedance.android.live.room.discovery.drawer.processor.a {
    public final b a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final String identifier() {
        return "GlobalFrequencyProcessor";
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final boolean a() {
        if (this.a.b().a() == false) goto L22;
        com.bytedance.android.live.base.model.moreliveentrance.b r0 = this.a.b().m;
        if (r0 == null) goto L23;
        Integer r1 = Integer.valueOf(r0.a());
        if (r1.intValue() <= (-1)) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L24;
        int r3 = r1.intValue();
        Long r4 = (Long) ((Map) MoreLiveGlobalFrequencyHelper.a.getValue()).get(Integer.valueOf(r3));
        if (r4 == null) goto L25;
        long r5 = r4.longValue();
        if (r5 > 0) goto L19;
        return false;
    L19:
        if ((System.currentTimeMillis() - r5) >= ((Number) MoreLiveGlobalFrequencyHelper.b.getValue()).longValue()) goto L27;
        return true;
    L27:
        return false;
    L25:
        return false;
    L24:
        return false;
    L9:
        r2 = false;
        goto L10
    L23:
        return false;
    L22:
        return false;
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final boolean b() {
        com.bytedance.android.livesdk.sharedpref.e r0 = b6.m;
        Long r1 = (Long) r0.getValue();
        com.bytedance.android.livesdk.sharedpref.e r2 = b6.o;
        if (((Number) r2.getValue()).longValue() <= 0) goto L11;
        if (System.currentTimeMillis() >= ((Number) r2.getValue()).longValue()) goto L8;
        d.a("intercept 命中退场频率期间不展示");
        return true;
    L8:
        Long r3 = Long.valueOf(System.currentTimeMillis());
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r3);
        r2.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r2, 0L);
        d.a("intercept called, 退场失效，重置逻辑");
        return false;
    L11:
        if (r1.longValue() > 0) goto L13;
    L16:
        return false;
    L13:
        if ((System.currentTimeMillis() - r1.longValue()) <= 259200000) goto L16;
        Long r4 = Long.valueOf(System.currentTimeMillis() + ((long) 604800000));
        r2.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r2, r4);
        d.a("intercept 命中超过三天不点击了，退场7天");
        return true;
    }

    public f(b r2) {
        Intrinsics.checkNotNullParameter(r2, "chain");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final void c(MarqueeType r7) {
        Intrinsics.checkNotNullParameter(r7, "marqueeType");
        boolean r1 = true;
        if (r7 != MarqueeType.SHOW) goto L20;
        com.bytedance.android.livesdk.sharedpref.e r8 = b6.m;
        if (((Number) r8.getValue()).longValue() > 0) goto L7;
        com.bytedance.android.livesdk.sharedpref.f.d(r8, Long.valueOf(System.currentTimeMillis()));
    L7:
        com.bytedance.android.live.base.model.moreliveentrance.b r9 = this.a.b().m;
        if (this.a.b().a() == false) goto L29;
        if (r9 == null) goto L30;
        Integer r10 = Integer.valueOf(r9.a());
        if (r10.intValue() > (-1)) goto L14;
        r1 = false;
    L14:
        if (r1 == true) goto L17;
        r10 = null;
    L17:
        if (r10 == null) goto L31;
        int r12 = r10.intValue();
        Lazy r0 = MoreLiveGlobalFrequencyHelper.a;
        ((Map) r0.getValue()).put(Integer.valueOf(r12), Long.valueOf(System.currentTimeMillis()));
        com.bytedance.android.livesdk.sharedpref.e r13 = b6.n;
        Map r2 = (Map) r0.getValue();
        r13.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r13, r2);
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L20:
        if (r7 != MarqueeType.CLICK) goto L33;
        RoomContext r14 = this.a.b().q;
        if (r14 == null) goto L34;
        m r15 = r14.getMoreLiveShowMarqueeShown();
        if (r15 != null) goto L26;
        return;
    L26:
        if (((Boolean) r15.getValue()).booleanValue() != true) goto L36;
        com.bytedance.android.livesdk.sharedpref.e r16 = b6.m;
        Long r3 = Long.valueOf(System.currentTimeMillis());
        r16.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r16, r3);
        return;
    L36:
        return;
    L34:
        return;
    }
}
