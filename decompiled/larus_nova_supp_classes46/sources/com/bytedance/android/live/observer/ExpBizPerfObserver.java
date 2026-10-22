package com.bytedance.android.live.observer;

import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.live.room.api.experience.log.ExpOptLog;
import com.bytedance.android.live.room.api.experience.perf.LivePerfBizLevel;
import com.bytedance.android.live.room.api.experience.perf.LivePerfBizType;
import com.bytedance.android.live.room.api.experience.utils.PlatformExpUtils;
import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import l61.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class ExpBizPerfObserver {
    public boolean a;
    public final Lazy b;
    public k61.a c;
    public final b d;
    public final g61.a e;

    public final String a() {
        return (String) this.b.getValue();
    }

    public final void c() {
        this.a = false;
        SimpleAlogArgsBuilder r0 = new SimpleAlogArgsBuilder();
        r0.d(a());
        r0.c(this.d.getDesc() + "回调了性能「正常」");
        ExpOptLog.d(r0.b());
        ExpOptLog r1 = ExpOptLog.c;
        b r2 = this.d;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "scene");
        ExpOptLog.b.add(r2);
        Keva r3 = o61.a.a;
        o61.a.d(this.d);
        o61.a.j.remove(this.d.getKey());
        g61.a r4 = this.e;
        if (r4 == null) goto L6;
        r4.a();
        return;
    }

    public final void b(k61.a r8) {
        Intrinsics.checkNotNullParameter(r8, "info");
        if (com.bytedance.android.live.room.api.experience.utils.a.a.a() == true) goto L5;
        LivePerfBizType r0 = r8.getType();
        k61.a r1 = this.c;
        LivePerfBizLevel r2 = null;
        if (r1 == null) goto L19;
        LivePerfBizType r3 = r1.getType();
    L20:
        boolean r4 = false;
        if (r0 != r3) goto L27;
        LivePerfBizLevel r5 = r8.d;
        k61.a r6 = this.c;
        if (r6 == null) goto L25;
        r2 = r6.d;
    L25:
        if (r5 != r2) goto L27;
        boolean r7 = true;
    L29:
        if (r8.c != LivePerfBizType.Normal) goto L31;
        r4 = true;
    L31:
        boolean r9 = o61.a.d;
        boolean r10 = PlatformExpUtils.c().b().containsKey(this.d.getKey());
        if (PlatformExpUtils.b() == true) goto L34;
    L42:
        if (r9 == true) goto L44;
        if (r4 == true) goto L44;
    L71:
        SimpleAlogArgsBuilder r11 = new SimpleAlogArgsBuilder();
        r11.d(a());
        r11.c("不分发给[" + this.d.getDesc() + "],isDegradeEnable:" + r9 + " isNormal:" + r4 + " isDuplicates:" + r7 + " isInList:" + r10);
        ExpOptLog.d(r11.b());
        return;
    L44:
        if (r7 == true) goto L71;
        if (r10 == false) goto L71;
        this.c = r8;
        if (this.d.getType() != r8.getType()) goto L68;
        if (this.d.getLevel().compareTo(r8.d) > 0) goto L63;
        if (this.a == true) goto L61;
        this.a = true;
        if (this.d.getType() != LivePerfBizType.Degrade) goto L58;
        SimpleAlogArgsBuilder r12 = new SimpleAlogArgsBuilder();
        r12.d(a());
        r12.c(this.d.getDesc() + " 回调了性能「降级」");
        ExpOptLog.d(r12.b());
        ExpOptLog r13 = ExpOptLog.c;
        b r14 = this.d;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "scene");
        ExpOptLog.b.add(r14);
        b r15 = this.d;
        Intrinsics.checkNotNullParameter(r15, "scene");
        o61.a.i.add(r15);
        o61.a.k.a(o61.a.b());
        o61.a.j.add(this.d.getKey());
        g61.a r16 = this.e;
        if (r16 == null) goto L78;
        r16.b();
        return;
    L78:
        return;
    L58:
        SimpleAlogArgsBuilder r17 = new SimpleAlogArgsBuilder();
        r17.d(a());
        r17.c(this.d.getDesc() + " 回调了性能「增强」");
        ExpOptLog.d(r17.b());
        ExpOptLog r18 = ExpOptLog.c;
        b r19 = this.d;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r19, "scene");
        ExpOptLog.b.add(r19);
        g61.a r20 = this.e;
        if (r20 == null) goto L80;
        r20.c();
        return;
    L80:
        return;
    L61:
        SimpleAlogArgsBuilder r21 = new SimpleAlogArgsBuilder();
        r21.d(a());
        r21.c(this.d.getDesc() + '-' + this.d.getType().name() + " 已经激活，不处理");
        ExpOptLog.d(r21.b());
        return;
    L63:
        if (this.d.getLevel().compareTo(r8.d) > 0) goto L65;
        return;
    L65:
        if (this.a == false) goto L84;
        c();
        return;
    L84:
        return;
    L68:
        if (this.a == false) goto L86;
        c();
        return;
    L86:
        return;
    L34:
        if (this.d.getLevel().compareTo(r8.d) <= 0) goto L36;
        r9 = this.a;
        goto L42
    L36:
        if (this.d.getLevel() != LivePerfBizLevel.P0) goto L39;
        r9 = ((Boolean) o61.a.f.a).booleanValue();
        goto L42
    L39:
        if (this.d.getLevel() != LivePerfBizLevel.P1) goto L42;
        r9 = ((Boolean) o61.a.h.a).booleanValue();
    L27:
        r7 = false;
        goto L29
    L19:
        r3 = null;
        goto L20
    L5:
        if (r8.a == true) goto L7;
        return;
    L7:
        if (this.d.getType() == r8.getType()) goto L9;
        return;
    L9:
        if (this.d.getType() == LivePerfBizType.Degrade) goto L11;
        return;
    L11:
        if (this.d.getLevel().compareTo(r8.d) > 0) goto L76;
        SimpleAlogArgsBuilder r22 = new SimpleAlogArgsBuilder();
        r22.d(a());
        r22.c("强制降级流程");
        ExpOptLog.d(r22.b());
        g61.a r23 = this.e;
        if (r23 == null) goto L77;
        r23.b();
        return;
    L77:
        return;
    }

    public ExpBizPerfObserver(b r2, g61.a r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        this.d = r2;
        this.e = r3;
        this.b = LazyKt.lazy(ExpBizPerfObserver$tag$2.INSTANCE);
    }
}
