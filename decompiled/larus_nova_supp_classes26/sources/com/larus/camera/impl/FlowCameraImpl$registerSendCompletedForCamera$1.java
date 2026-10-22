package com.larus.camera.impl;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.larus.camera.impl.starter.StarterViewModel;
import com.larus.utils.lifecycle.SafeLifecycleObserver;
import jx8.n;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/larus/camera/impl/FlowCameraImpl$registerSendCompletedForCamera$1", "Lcom/larus/utils/lifecycle/SafeLifecycleObserver;", "onCreate", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowCameraImpl$registerSendCompletedForCamera$1 extends SafeLifecycleObserver {
    public final /* synthetic */ Fragment a;
    public final /* synthetic */ Function0<Unit> b;

    public final void onCreate(LifecycleOwner r5) {
        Intrinsics.checkNotNullParameter(r5, "owner");
        final StarterViewModel r6 = (StarterViewModel) new ViewModelProvider(this.a).get(StarterViewModel.class);
        MutableLiveData<Integer> r0 = r6.getSendCompletedLiveEvent();
        Fragment r1 = this.a;
        final Function0<Unit> r2 = this.b;
        r0.removeObservers(r1);
        r0.observe(r1, new FlowCameraImpl$c(new n(r6, r2)));
    }

    public FlowCameraImpl$registerSendCompletedForCamera$1(Fragment r1, Function0<Unit> r2) {
        this.a = r1;
        this.b = r2;
    }
}
