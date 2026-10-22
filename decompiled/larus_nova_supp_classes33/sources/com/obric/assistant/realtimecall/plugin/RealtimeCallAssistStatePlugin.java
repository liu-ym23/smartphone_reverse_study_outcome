package com.obric.assistant.realtimecall.plugin;

import com.larus.audio.call.arch.c;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.mgr.f;
import com.larus.av_call.service.IRealtimeCallConfigDependency;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.audio.service.ObricRealtimeCallStateServiceDelegate;
import com.obric.assistant.state.api.multitask.ObricRealtimeCallStateProducerServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class RealtimeCallAssistStatePlugin extends com.larus.audio.call.arch.a<c> implements f.a {
    public final String f;
    public final Lazy g;

    public final void e3() {
        super.e3();
        FLogger r0 = FLogger.a;
        String r1 = this.f;
        StringBuilder r2 = new StringBuilder("onStart, ");
        r2.append(getContext().params().G);
        r2.append(", isScreenShareEnable: ");
        IRealtimeCallConfigDependency r3 = (IRealtimeCallConfigDependency) ServiceManager.get().getService(IRealtimeCallConfigDependency.class);
        if (r3 == null) goto L5;
        Boolean r4 = Boolean.valueOf(r3.g());
    L6:
        r2.append(r4);
        r2.append(", isVideoEnable: ");
        IRealtimeCallConfigDependency r5 = (IRealtimeCallConfigDependency) ServiceManager.get().getService(IRealtimeCallConfigDependency.class);
        if (r5 == null) goto L9;
        Boolean r6 = Boolean.valueOf(r5.e());
    L10:
        r2.append(r6);
        r2.append(", isRTC: ");
        IRealtimeCallConfigDependency r7 = (IRealtimeCallConfigDependency) ServiceManager.get().getService(IRealtimeCallConfigDependency.class);
        if (r7 == null) goto L13;
        Boolean r8 = Boolean.valueOf(r7.i());
    L14:
        r2.append(r8);
        r0.i(r1, r2.toString());
        getContext().a().M0(this);
        ((ObricRealtimeCallStateServiceDelegate) this.g.getValue()).start();
        ObricRealtimeCallStateProducerServiceDelegate.b.g(j3(), k3());
        CoroutineScope r9 = getContext().r();
        if (r9 == null) goto L18;
        BuildersKt.launch$default(r9, null, null, new RealtimeCallAssistStatePlugin$onStart$1(this, null), 3, null);
        return;
    L18:
        return;
    L13:
        r8 = null;
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public final void g3() {
        super.g3();
        FLogger.a.i(this.f, "onStop, " + getContext().params().G);
        getContext().a().V(this);
        ((ObricRealtimeCallStateServiceDelegate) this.g.getValue()).stop();
        ObricRealtimeCallStateProducerServiceDelegate.b.e(j3(), k3());
    }

    public final String j3() {
        String r0 = getContext().params().e;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final String k3() {
        return getContext().params().G;
    }

    public final String T2() {
        return this.f;
    }

    public RealtimeCallAssistStatePlugin(c r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = "RealtimeCallAssistStatePlugin";
        this.g = LazyKt.lazy(new a());
    }

    public final void Q(MajorState r5, MajorState r6) {
        Intrinsics.checkNotNullParameter(r5, "prev");
        Intrinsics.checkNotNullParameter(r6, "current");
        FLogger.a.i(this.f, "onStateChanged, prev=" + r5 + ", current=" + r6 + ", cvsId: " + getContext().params().G + ", " + getContext().params().l.c);
        ((ObricRealtimeCallStateServiceDelegate) this.g.getValue()).c(r5, r6);
        ObricRealtimeCallStateProducerServiceDelegate.b.b(j3(), k3(), r5.a, r6.a);
    }
}
