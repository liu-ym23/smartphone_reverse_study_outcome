package com.larus.av_call.component;

import android.view.View;
import androidx.core.content.ContextCompat;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.av_call.databinding.LarusFragmentInstantCallBaseBinding;
import com.larus.av_call.service.DefaultRealtimeCallService;
import com.larus.image.loader.ImageLoaderKt;
import g88.l;
import g88.m;
import g88.n;
import h88.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/larus/av_call/component/BaseRealtimeContentComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/ui/arch/context/external/VAbility;", "viewBinding", "Lcom/larus/av_call/databinding/LarusFragmentInstantCallBaseBinding;", "<init>", "(Lcom/larus/av_call/databinding/LarusFragmentInstantCallBaseBinding;)V", "argumentData", "Lcom/larus/av_call/model/BaseRealtimeArgumentData;", "getArgumentData", "()Lcom/larus/av_call/model/BaseRealtimeArgumentData;", "argumentData$delegate", "Lkotlin/Lazy;", "runtimeData", "Lcom/larus/av_call/model/BaseRealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/av_call/model/BaseRealtimeRuntimeData;", "runtimeData$delegate", "callService", "Lcom/larus/av_call/service/DefaultRealtimeCallService;", "getCallService", "()Lcom/larus/av_call/service/DefaultRealtimeCallService;", "callService$delegate", "onVContextReady", "", "onViewCreated", "view", "Landroid/view/View;", "Companion", "av-call_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class BaseRealtimeContentComponent extends RealtimeComponent implements t1a.a {
    public static final /* synthetic */ int r = 0;
    public final LarusFragmentInstantCallBaseBinding n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public void A0() {
        h88.a r0 = (h88.a) this.o.getValue();
        b r1 = (b) this.p.getValue();
        DefaultRealtimeCallService r2 = (DefaultRealtimeCallService) this.q.getValue();
    }

    public BaseRealtimeContentComponent(LarusFragmentInstantCallBaseBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "viewBinding");
        this.n = r2;
        this.o = LazyKt.lazy(new l(this));
        this.p = LazyKt.lazy(new m(this));
        this.q = LazyKt.lazy(new n(this));
    }

    @Override // com.larus.av_call.component.RealtimeComponent
    public void onViewCreated(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        this.n.c.inflate();
        ImageLoaderKt.u(this.n.a.findViewById(2131367804), ((h88.a) this.o.getValue()).e, "realtime_call_bot_avatar");
        this.n.a.findViewById(2131367806).setBackgroundColor(ContextCompat.getColor(getContext(), c.b(2130972364, getContext(), 2131103343)));
    }
}
