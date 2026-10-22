package com.bytedance.android.live.broadcastgame.opengame.service;

import android.text.TextUtils;
import com.bytedance.android.live.broadcastgame.opengame.message.m0;
import com.bytedance.android.live.broadcastgame.opengame.message.r;
import com.bytedance.android.live.broadcastgame.opengame.panel.PanelType;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.runtime.j;
import com.bytedance.android.live.broadcastgame.opengame.runtime.p;
import com.bytedance.android.live.broadcastgame.opengame.t;
import com.bytedance.android.live.broadcastgame.opengame.view.PayFlowView;
import com.bytedance.android.live.broadcastgame.opengame.view.RewardMsgContainer;
import com.bytedance.android.live.broadcastgame.opengame.view.c0;
import com.bytedance.android.live.broadcastgame.opengame.view.m;
import com.bytedance.android.live.broadcastgame.opengame.view.u;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.common.utility.Logger;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/service/CommercialService;", "Ly10/a;", "", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/p;", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;", "pluginContext", "<init>", "(Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;)V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommercialService implements y10.a, p {
    public PanelType a;
    public u b;
    public PayFlowView c;
    public Function0<Unit> d;
    public Function0<Unit> e;
    public Function1<? super Boolean, Unit> f;
    public c0 g;
    public RewardMsgContainer h;
    public Function1<? super RewardMsgContainer, Unit> i;
    public final PluginContext j;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ CommercialService a;

        public a(CommercialService r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            r r7 = (r) r6;
            CommercialService r0 = this.a;
            if (r0.a() == true) goto L6;
            return;
        L6:
            if (r0.c != null) goto L10;
            Function0<Unit> r1 = r0.e;
            if (r1 == null) goto L10;
            Unit r2 = (Unit) r1.invoke();
        L10:
            u r3 = r0.b;
            if (r3 == null) goto L17;
            Intrinsics.checkNotNullParameter(r7, "msg");
            if (r3.a.size() < 1000) goto L15;
            r3.a.pop();
        L15:
            r3.a.add(new m(System.currentTimeMillis(), r7));
        L17:
            if (v.a() == true) goto L19;
        L23:
            PayFlowView r8 = r0.c;
            if (r8 != null) goto L26;
            return;
        L26:
            if (r8.T5() == false) goto L28;
            return;
        L28:
            if (v.a() == false) goto L30;
            Logger.d("PayFlowView", "新流水来了，没有老流水，直接从队列获取展示");
        L30:
            PayFlowView r9 = r0.c;
            if (r9 == null) goto L36;
            r9.e = r0.f;
            r9.S5();
            return;
        L36:
            return;
        L19:
            if (r0.c != null) goto L23;
            throw new RuntimeException("payFlowView is null");
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ CommercialService a;

        public c(CommercialService r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            m0 r7 = (m0) r6;
            CommercialService r0 = this.a;
            if (r0.b() == false) goto L27;
            String r1 = r0.j.m.i;
            if (TextUtils.equals(r7.b, r1) == true) goto L9;
            Logger.d("OpenReward", "appId 不匹配，curAppId=" + r1 + ", rewardAppId=" + r7.b);
            return;
        L9:
            if (r0.h != null) goto L13;
            Function1<? super RewardMsgContainer, Unit> r2 = r0.i;
            if (r2 == null) goto L13;
            r0.g = new c0();
            RewardMsgContainer r3 = new RewardMsgContainer(r0.j);
            c0 r4 = r0.g;
            Intrinsics.checkNotNull(r4);
            Intrinsics.checkNotNullParameter(r4, "queue");
            r3.a = r4;
            t r5 = r0.j.m;
            Intrinsics.checkNotNullParameter(r5, "info");
            r3.b = r5;
            Unit r8 = Unit.INSTANCE;
            r0.h = r3;
            Intrinsics.checkNotNull(r3);
            Unit r9 = (Unit) r2.invoke(r3);
        L13:
            c0 r11 = r0.g;
            if (r11 == null) goto L16;
            Intrinsics.checkNotNullParameter(r7, "reward");
            r11.a.add(r7);
            r11.b.add(r7);
        L16:
            RewardMsgContainer r12 = r0.h;
            if (r12 != null) goto L19;
        L20:
            RewardMsgContainer r13 = r0.h;
            if (r13 == null) goto L26;
            r13.c();
            return;
        L26:
            return;
        L19:
            if (r12.d() != true) goto L20;
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void fail(String r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    @Override // y10.a
    public final void g() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void hide() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void l(Map<String, String> r1) {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void launch() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void start() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void stop() {
    }

    public final boolean a() {
        PluginContext r0 = this.j;
        if (r0.o == true) goto L5;
        return false;
    L5:
        com.bytedance.android.live.broadcastgame.opengame.runtime.g r1 = ((BootInfoService) r0.o(BootInfoService.class)).c();
        if (r1 == null) goto L20;
        j r2 = r1.b;
        if (r2 == null) goto L20;
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0064a> r3 = r2.a;
        if (r3 == null) goto L20;
        Iterator<T> r4 = r3.iterator();
    L13:
        if (r4.hasNext() == false) goto L20;
        com.bytedance.android.live.broadcastgame.opengame.network.a.C0064a r5 = (com.bytedance.android.live.broadcastgame.opengame.network.a.C0064a) r4.next();
        if (Intrinsics.areEqual(r5.c(), "payDiamonds") == true) goto L16;
        if (Intrinsics.areEqual(r5.c(), "payDiamondsV3") == false) goto L13;
    L16:
        boolean r6 = true;
    L22:
        if (r6 == true) goto L24;
        com.bytedance.android.live.broadcastgame.api.model.u r7 = this.j.m.e();
        if (r7 == null) goto L32;
        com.bytedance.android.live.broadcastgame.api.model.r r8 = r7.c();
        if (r8 == null) goto L32;
        Integer r9 = Integer.valueOf(r8.g());
    L33:
        if (r9 != null) goto L36;
    L37:
        if (r9 == null) goto L43;
        if (r9.intValue() != 2) goto L43;
    L47:
        if (v.a() == false) goto L49;
        Logger.d("PayFlowView", "payEnabled is true, businessType = " + r9);
    L49:
        return true;
    L43:
        if (v.a() == false) goto L45;
        Logger.d("PayFlowView", "payEnabled is false");
    L45:
        return false;
    L36:
        if (r9.intValue() == 1) goto L47;
    L32:
        r9 = null;
        goto L33
    L24:
        if (v.a() == false) goto L26;
        Logger.d("PayFlowView", "payEnabled is true, bootconfig");
    L26:
        return true;
    L20:
        r6 = false;
        goto L22
    }

    public final boolean b() {
        PluginContext r0 = this.j;
        if (r0.o == false) goto L5;
        return false;
    L5:
        com.bytedance.android.live.broadcastgame.opengame.runtime.g r1 = ((BootInfoService) r0.o(BootInfoService.class)).c();
        if (r1 == null) goto L17;
        j r2 = r1.b;
        if (r2 == null) goto L17;
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0064a> r3 = r2.a;
        if (r3 == null) goto L17;
        Iterator<T> r4 = r3.iterator();
    L13:
        if (r4.hasNext() == false) goto L17;
        if (Intrinsics.areEqual(((com.bytedance.android.live.broadcastgame.opengame.network.a.C0064a) r4.next()).c(), "propRewardMsgNotifyCenter") == false) goto L13;
        boolean r5 = true;
    L19:
        if (r5 == true) goto L21;
        Object r6 = this.j.m.k.get("business_type");
        Integer r7 = null;
        if ((r6 instanceof Integer) == true) goto L27;
        r6 = null;
    L27:
        Integer r8 = (Integer) r6;
        if (r8 == null) goto L30;
        int r9 = r8.intValue();
    L32:
        if (r9 != 2) goto L43;
        if (v.a() == false) goto L41;
        StringBuilder r11 = new StringBuilder("rewardEnabled is true, businessType = ");
        com.bytedance.android.live.broadcastgame.api.model.u r12 = this.j.m.e();
        if (r12 == null) goto L40;
        com.bytedance.android.live.broadcastgame.api.model.r r13 = r12.c();
        if (r13 == null) goto L40;
        r7 = Integer.valueOf(r13.g());
    L40:
        r11.append(r7);
        Logger.d("PayFlowView", r11.toString());
    L41:
        return true;
    L43:
        if (v.a() == false) goto L45;
        Logger.d("PayFlowView", "rewardEnabled is false");
    L45:
        return false;
    L30:
        r9 = 0;
        goto L32
    L21:
        if (v.a() == false) goto L23;
        Logger.d("PayFlowView", "rewardEnabled is true, bootconfig");
    L23:
        return true;
    L17:
        r5 = false;
        goto L19
    }

    public CommercialService(PluginContext r6) {
        Intrinsics.checkNotNullParameter(r6, "pluginContext");
        i20.a r0 = new i20.a();
        this.j = r6;
        this.a = PanelType.PANEL_TYPE_X_SCREEN_LOW;
        com.bytedance.android.live.broadcastgame.opengame.message.c0 r1 = r6.l;
        if (r1 == null) goto L9;
        Observable r2 = r1.a(r.class);
        if (r2 == null) goto L9;
        Disposable r3 = r2.subscribe(new a(this), b.a);
        if (r3 == null) goto L9;
        Intrinsics.checkNotNullParameter(r3, "$this$autoDispose");
        r0.a(r3);
    L9:
        com.bytedance.android.live.broadcastgame.opengame.message.c0 r7 = r6.l;
        if (r7 == null) goto L17;
        Observable r8 = r7.a(m0.class);
        if (r8 == null) goto L18;
        Disposable r9 = r8.subscribe(new c(this), d.a);
        if (r9 == null) goto L19;
        Intrinsics.checkNotNullParameter(r9, "$this$autoDispose");
        r0.a(r9);
        return;
    L19:
        return;
    L18:
        return;
    }
}
