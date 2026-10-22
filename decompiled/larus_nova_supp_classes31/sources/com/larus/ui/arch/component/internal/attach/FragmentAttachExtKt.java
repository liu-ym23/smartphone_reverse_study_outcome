package com.larus.ui.arch.component.internal.attach;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.ui.arch.component.external.api.receiver.Container;
import com.larus.ui.arch.component.internal.control.ComponentStateController;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.ui.arch.modulizer.di.IComponentRegistry;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class FragmentAttachExtKt {
    public static final void a(final Fragment r4, final Attachable r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "attachable");
        int r0 = y1a.a.a;
        y1a.a.a("attach", "create stateController ".concat(r4.getClass().getSimpleName()));
        final ComponentStateController r1 = new ComponentStateController(r4, r4.requireActivity());
        r1.b(r4.getView());
        FragmentManager.FragmentLifecycleCallbacks r2 = new FragmentAttachExtKt$createStateController$lifecycleCallbacks$1(r4, r1, r5);
        r4.getParentFragmentManager().registerFragmentLifecycleCallbacks(r2, false);
        r5.putComponentStateController$component_release(r4, r1);
    }

    public static final Container b(Fragment r2, ContainerFilter r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "containerFilter");
        int r0 = y1a.a.a;
        y1a.a.a("attach", "Fragment internalAttach container on ".concat(r2.getClass().getSimpleName()));
        Attachable.a r1 = Attachable.Companion;
        FragmentActivity r4 = r2.requireActivity();
        r1.getClass();
        Attachable r5 = Attachable.a.a(r4);
        if (r5.getComponentStateController$component_release(r2) != null) goto L5;
        a(r2, r5);
    L5:
        IComponentRegistry.a.getClass();
        return IComponentRegistry.a.a(r2, r3, r5);
    }

    public static final void c(Fragment r2, Function1<? super Attachable, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "init");
        int r0 = y1a.a.a;
        y1a.a.a("attach", "Fragment internalAttach container on ".concat(r2.getClass().getSimpleName()));
        Attachable.a r1 = Attachable.Companion;
        FragmentActivity r4 = r2.requireActivity();
        r1.getClass();
        Attachable r5 = Attachable.a.a(r4);
        if (r5.getComponentStateController$component_release(r2) != null) goto L5;
        a(r2, r5);
    L5:
        r3.invoke(r5);
    }
}
