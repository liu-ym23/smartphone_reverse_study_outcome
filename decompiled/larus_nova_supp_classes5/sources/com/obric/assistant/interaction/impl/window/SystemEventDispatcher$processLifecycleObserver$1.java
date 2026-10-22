package com.obric.assistant.interaction.impl.window;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/assistant/interaction/impl/window/SystemEventDispatcher$processLifecycleObserver$1", "Landroidx/lifecycle/DefaultLifecycleObserver;", "onStop", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SystemEventDispatcher$processLifecycleObserver$1 implements DefaultLifecycleObserver {
    final /* synthetic */ SystemEventDispatcher this$0;

    public final /* synthetic */ void onCreate(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onCreate(this, r1);
    }

    public final /* synthetic */ void onDestroy(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onDestroy(this, r1);
    }

    public final /* synthetic */ void onPause(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onPause(this, r1);
    }

    public final /* synthetic */ void onResume(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onResume(this, r1);
    }

    public final /* synthetic */ void onStart(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onStart(this, r1);
    }

    public SystemEventDispatcher$processLifecycleObserver$1(SystemEventDispatcher r1) {
        this.this$0 = r1;
    }

    public void onStop(LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r3, "owner");
        FLogger.a.i("SystemEventDispatcher", "ProcessLifecycleOwner: onStop (App Background)");
        SystemEventDispatcher.access$getListener$p(this.this$0).onAppBackground();
    }
}
