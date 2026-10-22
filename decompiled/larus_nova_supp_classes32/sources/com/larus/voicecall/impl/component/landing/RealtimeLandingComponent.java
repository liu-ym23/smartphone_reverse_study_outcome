package com.larus.voicecall.impl.component.landing;

import android.view.View;
import com.larus.av_call.component.RealtimeComponent;
import com.larus.im.service.audio.z0;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import k3a.b;
import k3a.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pf9.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/voicecall/impl/component/landing/RealtimeLandingComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/voicecall/impl/component/landing/IRealtimeLandingAbility;", "<init>", "()V", "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "Lkotlin/Lazy;", "screenShareAbility", "Lcom/larus/voicecall/impl/component/vlm/IRealtimeScreenShareAbility;", "getScreenShareAbility", "()Lcom/larus/voicecall/impl/component/vlm/IRealtimeScreenShareAbility;", "screenShareAbility$delegate", "sceneAbility", "Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "getSceneAbility", "()Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "sceneAbility$delegate", "pendingScene", NameKeys.UnloadStrategy_No_Strategy, "onViewCreated", NameKeys.UnloadStrategy_No_Strategy, "view", "Landroid/view/View;", "onReceiveEvent", "event", "Lcom/larus/im/service/audio/MediaSessionListener$Event;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeLandingComponent extends RealtimeComponent {
    public static final /* synthetic */ int r = 0;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public String q;

    public static final class a {
    }

    static {
    }

    public RealtimeLandingComponent() {
        this.n = LazyKt.lazy(new k3a.a(this));
        this.o = LazyKt.lazy(new b(this));
        this.p = LazyKt.lazy(new c(this));
        this.q = NameKeys.UnloadStrategy_No_Strategy;
    }

    public final void D9(z0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if ((r2 instanceof o) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.q, "screen_share") == false) goto L11;
        this.q = NameKeys.UnloadStrategy_No_Strategy;
        com.larus.voicecall.impl.component.vlm.a r3 = (com.larus.voicecall.impl.component.vlm.a) this.o.getValue();
        if (r3 == null) goto L12;
        r3.P6("call_menu");
        return;
    L12:
        return;
    }

    public final void onViewCreated(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r3, "view");
        String r4 = ((e3a.a) this.n.getValue()).g1;
        if (Intrinsics.areEqual(r4, "screen_share") == false) goto L6;
        this.q = ((e3a.a) this.n.getValue()).g1;
        return;
    L6:
        if (Intrinsics.areEqual(r4, "scene") == true) goto L8;
        FLogger.a.i("RealtimeLandingComponent", "unknown landing feature scene: " + ((e3a.a) this.n.getValue()).g1);
        return;
    L8:
        if (((h88.a) ((e3a.a) this.n.getValue())).K == (-1)) goto L10;
        return;
    L10:
        if (((h88.a) ((e3a.a) this.n.getValue())).k0 == true) goto L18;
        com.larus.voicecall.impl.component.scene.a r5 = (com.larus.voicecall.impl.component.scene.a) this.p.getValue();
        if (r5 == null) goto L19;
        com.larus.voicecall.impl.component.scene.a.b.a(r5, false, 7);
        return;
    L19:
        return;
    }
}
