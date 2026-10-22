package k1a;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal;
import com.larus.ui.arch.component.internal.attach.Attachable;
import com.larus.ui.arch.component.internal.control.ComponentStateController;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class a implements Function1 {
    public final /* synthetic */ Fragment a;
    public final /* synthetic */ ComponentFeature b;

    public /* synthetic */ a(Fragment r1, ComponentFeature r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        LifecycleOwner r0 = this.a;
        ComponentFeature r1 = this.b;
        Attachable r5 = (Attachable) r4;
        Intrinsics.checkNotNullParameter(r5, "$this$internalAttach");
        ComponentStateController r6 = r5.getComponentStateController$component_release(r0);
        if (r6 == null) goto L24;
        Intrinsics.checkNotNullParameter(r1, "component");
        if (r6.d().getCurrentState().compareTo(Lifecycle.State.DESTROYED) <= 0) goto L24;
        if (r6.d().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L11;
        r1.w2();
    L11:
        if (r6.d().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L17;
        if (((BaseComponentFeatureInternal) r1).d == true) goto L17;
        ((BaseComponentFeatureInternal) r1).a.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        r1.onStop();
    L17:
        if (r6.d().getCurrentState().isAtLeast(Lifecycle.State.CREATED) == true) goto L19;
    L22:
        ((ArrayList) r6.d).remove(r1);
        goto L24
    L19:
        if (((BaseComponentFeatureInternal) r1).d == true) goto L22;
        ((BaseComponentFeatureInternal) r1).a.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        r1.getViewModelStore().clear();
        r1.onDestroy();
    L24:
        return Unit.INSTANCE;
    }
}
