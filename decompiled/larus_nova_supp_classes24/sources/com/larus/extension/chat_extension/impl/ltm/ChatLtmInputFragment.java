package com.larus.extension.chat_extension.impl.ltm;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.ixigua.lib.track.TrackParams;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.bmhome.utils.x1;
import com.larus.extension.chat_extension.impl.databinding.LarusLayoutChatLtmInputBinding;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0011\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010#\u001a\u00020!H\u0002J\b\u0010$\u001a\u00020!H\u0002J\b\u0010%\u001a\u00020!H\u0002J\f\u0010(\u001a\u00020!*\u00020)H\u0002J\b\u0010*\u001a\u00020!H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/larus/extension/chat_extension/impl/ltm/ChatLtmInputFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/ixigua/lib/track/ITrackNode;", "<init>", "()V", "handler", "Landroid/os/Handler;", "viewModel", "Lcom/larus/extension/chat_extension/impl/ltm/ChatLtmViewModel;", "getViewModel", "()Lcom/larus/extension/chat_extension/impl/ltm/ChatLtmViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "behaviorCallback", "com/larus/extension/chat_extension/impl/ltm/ChatLtmInputFragment$behaviorCallback$1", "Lcom/larus/extension/chat_extension/impl/ltm/ChatLtmInputFragment$behaviorCallback$1;", "binding", "Lcom/larus/extension/chat_extension/impl/databinding/LarusLayoutChatLtmInputBinding;", "imeManager", "Lcom/larus/bmhome/utils/ImeManager;", "getTheme", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupButton", "setupInput", "setupObserver", "delayedLoading", "Ljava/lang/Runnable;", "normalListener", "Landroidx/appcompat/widget/AppCompatTextView;", "closeInput", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ChatLtmInputFragment extends BottomSheetDialogFragment implements by7.e {
    public static final /* synthetic */ int k = 0;
    public final Handler d;
    public final Lazy e;
    public BottomSheetBehavior<View> f;
    public final b g;
    public LarusLayoutChatLtmInputBinding h;
    public x1 i;
    public final m j;

    public static final class a {
    }

    public static final class b extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ ChatLtmInputFragment a;

        public final void onSlide(View r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "bottomSheet");
        }

        public b(ChatLtmInputFragment r1) {
            this.a = r1;
        }

        public final void onStateChanged(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "bottomSheet");
            if (r3 != 1) goto L8;
            BottomSheetBehavior<View> r4 = this.a.f;
            if (r4 == null) goto L9;
            r4.setState(4);
            return;
        L9:
            return;
        }
    }

    static {
    }

    public final void fillTrackParams(TrackParams r1) {
    }

    public final int getTheme() {
        return 2131952483;
    }

    public final ChatLtmViewModel U90() {
        return (ChatLtmViewModel) this.e.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.extension.chat_extension.impl.ltm.m] */
    public ChatLtmInputFragment() {
        this.d = new Handler(Looper.getMainLooper());
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ChatLtmViewModel.class), new ChatLtmInputFragment$special$$inlined$activityViewModels$default$1(this), new ChatLtmInputFragment$special$$inlined$activityViewModels$default$2(this));
        this.g = new b(this);
        this.j = new m(this);
    }

    public final void T90() {
        dismissAllowingStateLoss();     // Catch: Exception -> L4
    L8:
        x1 r0 = this.i;
        if (r0 == null) goto L14;
        Set r1 = x1.d;
        r0.a(false);
        return;
    L14:
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L8;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L8
    }

    public final by7.e parentTrackNode() {
        return by7.i.c(this);
    }

    public final by7.e referrerTrackNode() {
        return by7.e.a.a(this);
    }

    public static final void S90(final ChatLtmInputFragment r1, final AppCompatTextView r2) {
        r1.getClass();
        r2.setAlpha(1.0f);
        r2.setOnClickListener(new n(r1, r2));
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        Dialog r10 = getDialog();
        if (r10 == null) goto L5;
        r10.setOnShowListener(new l(this));
    L5:
        LarusLayoutChatLtmInputBinding r11 = this.h;
        if (r11 == null) goto L8;
        r11.e.setHint(getString(2131905499));
        q r12 = new q(this, r11);
        r11.e.addTextChangedListener(r12);
        r11.e.requestFocus();
        r11.e.postDelayed(new o(this), 200);
    L8:
        LarusLayoutChatLtmInputBinding r13 = this.h;
        if (r13 == null) goto L11;
        r13.c.setVisibility(4);
        e1.o(r13.f);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ChatLtmInputFragment$setupObserver$1$1(this, r13, null), 3, null);
    L11:
        LarusLayoutChatLtmInputBinding r14 = this.h;
        if (r14 == null) goto L15;
        r14.g.setAlpha(0.3f);
        r14.g.setOnClickListener(null);
        r14.b.setOnClickListener(new p(this));
        return;
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        ConstraintLayout r12 = r9.inflate(2131562778, r10, false);
        int r13 = 2131362251;
        if (ViewBindings.findChildViewById(r12, 2131362251) == null) goto L24;
        r13 = 2131365114;
        AppCompatTextView r2 = ViewBindings.findChildViewById(r12, 2131365114);
        if (r2 == null) goto L24;
        r13 = 2131371828;
        if (ViewBindings.findChildViewById(r12, 2131371828) == null) goto L24;
        r13 = 2131371831;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131371831);
        if (r3 == null) goto L24;
        r13 = 2131371832;
        AppCompatTextView r4 = ViewBindings.findChildViewById(r12, 2131371832);
        if (r4 == null) goto L24;
        r13 = 2131375324;
        AppCompatEditText r14 = ViewBindings.findChildViewById(r12, 2131375324);
        if (r14 == null) goto L24;
        r13 = 2131383286;
        ProgressBar r6 = (ProgressBar) ViewBindings.findChildViewById(r12, 2131383286);
        if (r6 == null) goto L24;
        r13 = 2131385084;
        AppCompatTextView r7 = ViewBindings.findChildViewById(r12, 2131385084);
        if (r7 == null) goto L24;
        this.h = new LarusLayoutChatLtmInputBinding(r12, r2, r3, r4, r14, r6, r7);
        this.i = new x1(r14);
        LarusLayoutChatLtmInputBinding r15 = this.h;
        if (r15 != null) goto L25;
        return null;
    L25:
        return r15.a;
    L24:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}
