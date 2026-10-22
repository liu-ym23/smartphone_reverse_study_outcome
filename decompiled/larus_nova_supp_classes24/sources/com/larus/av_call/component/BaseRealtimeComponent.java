package com.larus.av_call.component;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.av_call.service.DefaultRealtimeCallService;
import g88.h;
import g88.i;
import g88.j;
import g88.k;
import h88.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import t1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/larus/av_call/component/BaseRealtimeComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/ui/arch/context/external/VAbility;", "<init>", "()V", "argumentData", "Lcom/larus/av_call/model/BaseRealtimeArgumentData;", "getArgumentData", "()Lcom/larus/av_call/model/BaseRealtimeArgumentData;", "argumentData$delegate", "Lkotlin/Lazy;", "runtimeData", "Lcom/larus/av_call/model/BaseRealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/av_call/model/BaseRealtimeRuntimeData;", "runtimeData$delegate", "callService", "Lcom/larus/av_call/service/DefaultRealtimeCallService;", "getCallService", "()Lcom/larus/av_call/service/DefaultRealtimeCallService;", "callService$delegate", "callParam", "Lcom/larus/audio/call/RealtimeCallParam;", "getCallParam", "()Lcom/larus/audio/call/RealtimeCallParam;", "callParam$delegate", "onVContextReady", "", "onResume", "onDestroy", "av-call_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class BaseRealtimeComponent extends RealtimeComponent implements a {
    public static final /* synthetic */ int r = 0;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void A0() {
        h88.a r0 = (h88.a) this.n.getValue();
        b r1 = (b) this.o.getValue();
        DefaultRealtimeCallService r2 = (DefaultRealtimeCallService) this.p.getValue();
    }

    public final void onDestroy() {
        RealtimeCallParam r0 = (RealtimeCallParam) this.q.getValue();
        RealtimeCallParam.k r1 = r0.p;
        r1.j = ((b) this.o.getValue()).o;
        ((DefaultRealtimeCallService) this.p.getValue()).e(r0);
        throw null;
    }

    public final void onResume() {
        ((DefaultRealtimeCallService) this.p.getValue()).d((RealtimeCallParam) this.q.getValue());
        throw null;
    }

    public BaseRealtimeComponent() {
        this.n = LazyKt.lazy(new h(this));
        this.o = LazyKt.lazy(new i(this));
        this.p = LazyKt.lazy(new j(this));
        this.q = LazyKt.lazy(new k(this));
    }
}
