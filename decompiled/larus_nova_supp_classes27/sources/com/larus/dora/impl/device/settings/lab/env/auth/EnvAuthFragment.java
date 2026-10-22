package com.larus.dora.impl.device.settings.lab.env.auth;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.dora.impl.databinding.LarusDoraGEnvObserveAuthBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/env/auth/EnvAuthFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraGEnvObserveAuthBinding;", "viewModel", "Lcom/larus/dora/impl/device/settings/lab/env/auth/EnvAuthViewModel;", "getViewModel", "()Lcom/larus/dora/impl/device/settings/lab/env/auth/EnvAuthViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "getCurrentPageName", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnvAuthFragment extends DoraBaseFragment {
    public static final /* synthetic */ int h = 0;
    public LarusDoraGEnvObserveAuthBinding f;
    public final Lazy g;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ EnvAuthFragment a;

        public b(EnvAuthFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            c r5 = (c) r3;
            if (Intrinsics.areEqual(r5, c.b.a) == true) goto L26;
            if ((r5 instanceof c.a) == false) goto L24;
            if (((c.a) r5).a == true) goto L9;
            s r6 = s.a;
            Context r7 = this.a.getContext();
            String r0 = this.a.getString(2131903992);
            r6.getClass();
            s.c(r7, r0);
            return Unit.INSTANCE;
        L9:
            Bundle r8 = this.a.getArguments();
            if (r8 == null) goto L14;
            boolean r9 = true;
            if (r8.getBoolean("dora_env_auth_finish_after_success") != true) goto L14;
        L15:
            if (r9 == false) goto L20;
            FragmentActivity r10 = this.a.getActivity();
            if (r10 == null) goto L28;
            r10.finish();
        L28:
            return Unit.INSTANCE;
        L20:
            i r11 = SmartRouter.buildRoute(this.a.getContext(), "//flow/dora/env_observe");
            Bundle r12 = this.a.getArguments();
            r11.c.putExtras(r12);
            r11.d();
            FragmentActivity r13 = this.a.getActivity();
            if (r13 == null) goto L26;
            r13.finish();
        L14:
            r9 = false;
            goto L15
        L24:
            throw new NoWhenBranchMatchedException();
        L26:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final String k() {
        return "env_auth";
    }

    public EnvAuthFragment() {
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(EnvAuthViewModel.class), new EnvAuthFragment$special$$inlined$activityViewModels$default$1(this), new EnvAuthFragment$special$$inlined$activityViewModels$default$2(this));
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r7, r8);
        LarusDoraGEnvObserveAuthBinding r9 = this.f;
        if (r9 == null) goto L10;
        e1.x(r9.b);
        e1.o(r9.e.c);
        AppCompatTextView r10 = r9.d;
        if (r10 == null) goto L7;
        e1.d(r10, new com.larus.dora.impl.device.settings.lab.env.auth.a(this));
    L7:
        AppCompatTextView r11 = r9.c;
        if (r11 == null) goto L10;
        e1.d(r11, new com.larus.dora.impl.device.settings.lab.env.auth.b(this));
    L10:
        Lifecycle.State r12 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new EnvAuthFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r12, null, this), 3, null);
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        LarusDoraGEnvObserveAuthBinding r4 = LarusDoraGEnvObserveAuthBinding.a(r1, r2);
        this.f = r4;
        return r4.a;
    }
}
