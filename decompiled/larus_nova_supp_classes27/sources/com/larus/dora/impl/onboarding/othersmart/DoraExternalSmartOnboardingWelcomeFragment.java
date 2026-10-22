package com.larus.dora.impl.onboarding.othersmart;

import android.bluetooth.BluetoothAdapter;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.controller.BaseControllerListener;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.dora.impl.databinding.LarusDoraExternalSmartOnboardingV2WelcomeBinding;
import com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedWakeupFragment;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u000e\u0010\u0013\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0002J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/dora/impl/onboarding/othersmart/DoraExternalSmartOnboardingWelcomeFragment;", "Lcom/larus/dora/impl/onboarding/othersmart/DoraExternalOnboardingBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraExternalSmartOnboardingV2WelcomeBinding;", "wearStateTaskRunning", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "playBackgroundMusicIfNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onResume", "onPause", "onStop", "startWearStateTask", "stopWearStateTask", "onSkipButtonClicked", "getCurrentPageName", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraExternalSmartOnboardingWelcomeFragment extends DoraExternalOnboardingBaseFragment {
    public static final /* synthetic */ int q = 0;
    public LarusDoraExternalSmartOnboardingV2WelcomeBinding o;
    public boolean p;

    public static final class a {
    }

    public static final class b extends BaseControllerListener<Object> {
        public final /* synthetic */ VideoPlayView a;

        public b(VideoPlayView r1) {
            this.a = r1;
        }

        public final void onFailure(String r11, Throwable r12) {
            VideoPlayView r0 = this.a;
            VideoPlayView.p(r0, null, null, null, null, null, BitmapFactory.decodeResource(r0.getContext().getResources(), 2131242874), null, null, 223);
            this.a.M();
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            this.a.M();
        }
    }

    public static final class c<T> implements FlowCollector {
        public final /* synthetic */ DoraExternalSmartOnboardingWelcomeFragment a;

        public c(DoraExternalSmartOnboardingWelcomeFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            if ((((com.larus.dora.impl.onboarding.othersmart.a) r1) instanceof com.larus.dora.impl.onboarding.othersmart.a.C0089a) == false) goto L8;
            DoraExternalSmartOnboardingWelcomeFragment r3 = this.a;
            if (r3.o == null) goto L8;
            r3.ca0().enterOnboardingMode(true);
        L8:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final String k() {
        return "introduction_page";
    }

    @Override // com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void aa0() {
        DoraSetting.a.getClass();
        if (DoraSetting.m() == false) goto L5;
        Z90(new DoraHStreamlinedWakeupFragment());
    L6:
        ca0().stopBackgroundMusic();
        return;
    L5:
        ea0();
        goto L6
    }

    public final void onPause() {
        super.onPause();
        this.p = false;
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void onResume() {
        super.onResume();
        this.p = true;
        BluetoothAdapter r0 = BluetoothAdapter.getDefaultAdapter();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new DoraExternalSmartOnboardingWelcomeFragment$startWearStateTask$1(this, r0, null), 2, null);
    }

    public DoraExternalSmartOnboardingWelcomeFragment() {
    }

    public final void onStop() {
        super.onStop();
    }

    @Override // com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        TextView r9 = this.h;
        if (r9 == null) goto L5;
        e1.x(r9);
        r9.setText(2131903805);
        e1.d(r9, new m0(this));
    L5:
        Lifecycle.State r10 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraExternalSmartOnboardingWelcomeFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r10, null, this), 3, null);
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        ConstraintLayout r6 = r3.inflate(2131562177, r4, false);
        int r7 = 2131369859;
        if (((TextView) ViewBindings.findChildViewById(r6, 2131369859)) == null) goto L16;
        ConstraintLayout r8 = r6;
        VideoPlayView r0 = (VideoPlayView) ViewBindings.findChildViewById(r6, 2131369951);
        if (r0 != null) goto L7;
        r7 = 2131369951;
        goto L16
    L7:
        if (((TextView) ViewBindings.findChildViewById(r6, 2131369952)) != null) goto L9;
        r7 = 2131369952;
        goto L16
    L9:
        if (((DoraTextView) ViewBindings.findChildViewById(r6, 2131369953)) == null) goto L12;
        final LarusDoraExternalSmartOnboardingV2WelcomeBinding r9 = new LarusDoraExternalSmartOnboardingV2WelcomeBinding(r8, r0);
        r0.post(new l0(this, r9));
        this.o = r9;
        return r8;
    L12:
        r7 = 2131369953;
    L16:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
