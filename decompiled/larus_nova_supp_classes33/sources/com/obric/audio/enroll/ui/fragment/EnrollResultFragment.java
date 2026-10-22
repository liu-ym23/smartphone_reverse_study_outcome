package com.obric.audio.enroll.ui.fragment;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.home.api.main.HomeService;
import com.larus.utils.logger.FLogger;
import com.obric.audio.enroll.base.BaseFragment;
import com.obric.audio.enroll.model.EnrollState;
import com.obric.audio.enroll.trace.VoiceEnrollTrace;
import com.obric.audio.enroll.vm.EnrollViewModel;
import com.obric.audio.impl.databinding.SvaEnrollResultFragmentBinding;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0017J\b\u0010\"\u001a\u00020\u0017H\u0003J\b\u0010#\u001a\u00020\u0017H\u0002J\n\u0010$\u001a\u0004\u0018\u00010%H\u0002J\n\u0010&\u001a\u0004\u0018\u00010%H\u0002J\u0018\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020\u0017H\u0002J\u0010\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u0010H\u0002J\b\u0010.\u001a\u00020\u0017H\u0002J\b\u0010/\u001a\u00020\u0017H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/obric/audio/enroll/ui/fragment/EnrollResultFragment;", "Lcom/obric/audio/enroll/base/BaseFragment;", "<init>", "()V", "_realBinding", "Lcom/obric/audio/impl/databinding/SvaEnrollResultFragmentBinding;", "binding", "getBinding", "()Lcom/obric/audio/impl/databinding/SvaEnrollResultFragmentBinding;", "viewModel", "Lcom/obric/audio/enroll/vm/EnrollViewModel;", "enrollCode", "", "timer", "Landroid/os/CountDownTimer;", "isObricOS", "", "()Z", "setObricOS", "(Z)V", "progress", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "showHintDialog", "setupHelpImproveVoiceWakeupPrivacyLink", "buildHelpImproveVoiceWakeupSectionSubtitle", "Landroid/text/SpannableStringBuilder;", "buildHintDialogMessage", "buildVoicePrintPrivacyMessage", "message", "", "policyText", "openVoicePrintPrivacyPage", "enableFinishButton", "enable", "updateFinishButtonText", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnrollResultFragment extends BaseFragment {
    public static final /* synthetic */ int i = 0;
    public SvaEnrollResultFragmentBinding e;
    public EnrollViewModel f;
    public int g;
    public final boolean h;

    public static final class a {
    }

    public static final class b extends ClickableSpan {
        public final /* synthetic */ EnrollResultFragment a;

        public b(EnrollResultFragment r1) {
            this.a = r1;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r5) {
            Intrinsics.checkNotNullParameter(r5, "widget");
            EnrollResultFragment r6 = this.a;
            int r0 = EnrollResultFragment.i;
            Context r1 = r6.getContext();
            if (r1 == null) goto L6;
            Intent r2 = new Intent();
            r2.setComponent(new ComponentName(r1, HomeService.a.F()));
            r2.putExtra("open_link", "https://os.obriccloud.com/agreement/enhance_wakeup");
            r6.startActivity(r2);
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r3) {
            Intrinsics.checkNotNullParameter(r3, "ds");
            super.updateDrawState(r3);
            r3.setColor(ContextCompat.getColor(this.a.requireContext(), 2131104390));
            r3.setUnderlineText(false);
        }
    }

    /* JADX INFO: renamed from: com.obric.audio.enroll.ui.fragment.EnrollResultFragment$onViewCreated$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.audio.enroll.ui.fragment.EnrollResultFragment$onViewCreated$3", f = "EnrollResultFragment.kt", i = {}, l = {167}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ EnrollResultFragment this$0;

        /* JADX INFO: renamed from: com.obric.audio.enroll.ui.fragment.EnrollResultFragment$onViewCreated$3$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ EnrollResultFragment a;

            /* JADX INFO: renamed from: com.obric.audio.enroll.ui.fragment.EnrollResultFragment$onViewCreated$3$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0030a {
                public static final /* synthetic */ int[] a = null;

                static {
                    int[] r0 = new int[EnrollState.values().length];
                    r0[EnrollState.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
                L15:
                    r0[EnrollState.ENROLLING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
                L23:
                    r0[EnrollState.ENROLLED_SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
                L17:
                    r0[EnrollState.ENROLLED_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
                L19:
                    r0[EnrollState.ENROLLED_INTERRUPT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
                L8:
                    a = r0;
                }
            }

            public a(EnrollResultFragment r1) {
                this.a = r1;
            }

            public final Object emit(Object r19, Continuation r20) {
                EnrollState r1 = (EnrollState) r19;
                FLogger.a.i("EnrollResultFragment", "enrollState: " + r1);
                int r2 = C0030a.a[r1.ordinal()];
                Vibrator r7 = null;
                if (r2 != 2) goto L5;
                long r10 = System.currentTimeMillis();
                SvaEnrollResultFragmentBinding r3 = this.a.e;
                Intrinsics.checkNotNull(r3);
                r3.e.cancelAnimation();
                SvaEnrollResultFragmentBinding r4 = this.a.e;
                Intrinsics.checkNotNull(r4);
                r4.e.setAnimation(2131820657);
                SvaEnrollResultFragmentBinding r5 = this.a.e;
                Intrinsics.checkNotNull(r5);
                LottieAnimationView r6 = r5.e;
                final EnrollResultFragment r8 = this.a;
                r6.addAnimatorUpdateListener(new m(r8));
                SvaEnrollResultFragmentBinding r9 = this.a.e;
                Intrinsics.checkNotNull(r9);
                r9.e.setRepeatCount(-1);
                SvaEnrollResultFragmentBinding r11 = this.a.e;
                Intrinsics.checkNotNull(r11);
                r11.e.playAnimation();
                SvaEnrollResultFragmentBinding r12 = this.a.e;
                Intrinsics.checkNotNull(r12);
                r12.f.setVisibility(4);
                SvaEnrollResultFragmentBinding r13 = this.a.e;
                Intrinsics.checkNotNull(r13);
                r13.i.setVisibility(0);
                Job r14 = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new EnrollResultFragment$onViewCreated$3$1$job$1(this.a, null), 3, null);
                SvaEnrollResultFragmentBinding r15 = this.a.e;
                Intrinsics.checkNotNull(r15);
                OButton r16 = r15.b;
                StringCompanionObject r17 = StringCompanionObject.INSTANCE;
                r16.setText(String.format(this.a.getResources().getText(2131914206).toString(), Arrays.copyOf(new Object[]{Boxing.boxInt(3)}, 1)));
                BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new EnrollResultFragment$onViewCreated$3$1$2(this.a, r10, r14, null), 3, null);
            L55:
                return Unit.INSTANCE;
            L5:
                if (r2 == 3) goto L30;
                if (r2 == 4) goto L9;
                if (r2 != 5) goto L55;
            L9:
                CoroutineScope r18 = VoiceEnrollTrace.a;
                String r21 = VoiceEnrollTrace.b;
                EnrollViewModel r22 = this.a.f;
                if (r22 != null) goto L12;
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                r22 = null;
            L12:
                VoiceEnrollTrace.c(EnrollViewModel.FAILED_PAGE, r21, r22.enterFrom());
                VoiceEnrollTrace.b = EnrollViewModel.FAILED_PAGE;
                SvaEnrollResultFragmentBinding r23 = this.a.e;
                Intrinsics.checkNotNull(r23);
                r23.e.cancelAnimation();
                SvaEnrollResultFragmentBinding r24 = this.a.e;
                Intrinsics.checkNotNull(r24);
                r24.e.setAnimation(2131820656);
                SvaEnrollResultFragmentBinding r25 = this.a.e;
                Intrinsics.checkNotNull(r25);
                r25.e.setRepeatCount(0);
                SvaEnrollResultFragmentBinding r26 = this.a.e;
                Intrinsics.checkNotNull(r26);
                r26.e.playAnimation();
                SvaEnrollResultFragmentBinding r27 = this.a.e;
                Intrinsics.checkNotNull(r27);
                r27.g.setText(this.a.getResources().getString(2131914223));
                SvaEnrollResultFragmentBinding r28 = this.a.e;
                Intrinsics.checkNotNull(r28);
                r28.f.setVisibility(0);
                SvaEnrollResultFragmentBinding r29 = this.a.e;
                Intrinsics.checkNotNull(r29);
                r29.i.setVisibility(0);
                SvaEnrollResultFragmentBinding r30 = this.a.e;
                Intrinsics.checkNotNull(r30);
                OButton r31 = r30.b;
                EnrollResultFragment r32 = this.a;
                r31.setVisibility(0);
                r31.setBackground(r31.getResources().getDrawable(2131248326));
                StringBuilder r33 = new StringBuilder("");
                EnrollViewModel r34 = r32.f;
                if (r34 != null) goto L16;
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                r34 = null;
            L16:
                if (r34.isInterruptEnhancedVoiceEnroll() == false) goto L18;
                CharSequence r35 = r31.getResources().getText(2131914210);
            L19:
                r33.append(r35);
                r31.setText(r33.toString());
                r31.setTextColor(r31.getResources().getColor(2131106561));
                EnrollResultFragment r36 = this.a;
                if (r36.h == true) goto L27;
                EnrollViewModel r37 = r36.f;
                if (r37 != null) goto L25;
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                r37 = null;
            L25:
                if (Intrinsics.areEqual(r37.getStartFrom(), EnrollViewModel.DOUBAO_GUIDE) == false) goto L27;
                int r38 = this.a.getResources().getDimensionPixelSize(v19.c.b(2130971208, null, 2131166786));
                SvaEnrollResultFragmentBinding r39 = this.a.e;
                Intrinsics.checkNotNull(r39);
                r39.b.setRadius(r38);
            L27:
                SvaEnrollResultFragmentBinding r40 = this.a.e;
                Intrinsics.checkNotNull(r40);
                r40.b.setEnabled(true);
                Context r41 = this.a.getContext();
                if (r41 == null) goto L55;
                ria.a.a(r41);
                goto L55
            L18:
                r35 = r31.getResources().getText(2131914198);
                goto L19
            L30:
                CoroutineScope r42 = VoiceEnrollTrace.a;
                String r43 = VoiceEnrollTrace.b;
                EnrollViewModel r44 = this.a.f;
                if (r44 != null) goto L33;
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                r44 = null;
            L33:
                VoiceEnrollTrace.c(EnrollViewModel.SUCCESS_PAGE, r43, r44.enterFrom());
                VoiceEnrollTrace.b = EnrollViewModel.SUCCESS_PAGE;
                SvaEnrollResultFragmentBinding r45 = this.a.e;
                Intrinsics.checkNotNull(r45);
                r45.e.cancelAnimation();
                SvaEnrollResultFragmentBinding r46 = this.a.e;
                Intrinsics.checkNotNull(r46);
                r46.e.setAnimation(2131820658);
                SvaEnrollResultFragmentBinding r47 = this.a.e;
                Intrinsics.checkNotNull(r47);
                r47.e.playAnimation();
                SvaEnrollResultFragmentBinding r48 = this.a.e;
                Intrinsics.checkNotNull(r48);
                r48.e.setRepeatCount(0);
                SvaEnrollResultFragmentBinding r49 = this.a.e;
                Intrinsics.checkNotNull(r49);
                r49.g.setText(this.a.getResources().getString(2131914226));
                SvaEnrollResultFragmentBinding r50 = this.a.e;
                Intrinsics.checkNotNull(r50);
                r50.f.setVisibility(4);
                SvaEnrollResultFragmentBinding r51 = this.a.e;
                Intrinsics.checkNotNull(r51);
                r51.d.setVisibility(8);
                SvaEnrollResultFragmentBinding r52 = this.a.e;
                Intrinsics.checkNotNull(r52);
                r52.h.setVisibility(0);
                SvaEnrollResultFragmentBinding r53 = this.a.e;
                Intrinsics.checkNotNull(r53);
                r53.i.setVisibility(8);
                SvaEnrollResultFragmentBinding r54 = this.a.e;
                Intrinsics.checkNotNull(r54);
                OButton r55 = r54.b;
                EnrollResultFragment r56 = this.a;
                r55.setVisibility(0);
                r55.setBackground(r55.getContext().getDrawable(2131248321));
                r55.setTextColor(r55.getResources().getColor(2131106568));
                EnrollResultFragment.T90(r56);
                EnrollResultFragment r57 = this.a;
                if (r57.h == true) goto L41;
                EnrollViewModel r58 = r57.f;
                if (r58 != null) goto L39;
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                r58 = null;
            L39:
                if (Intrinsics.areEqual(r58.getStartFrom(), EnrollViewModel.DOUBAO_GUIDE) == false) goto L41;
                int r59 = this.a.getResources().getDimensionPixelSize(v19.c.b(2130971208, null, 2131166786));
                SvaEnrollResultFragmentBinding r60 = this.a.e;
                Intrinsics.checkNotNull(r60);
                r60.b.setBackgroundResource(2131244295);
                SvaEnrollResultFragmentBinding r61 = this.a.e;
                Intrinsics.checkNotNull(r61);
                r61.b.setRadius(r59);
                SvaEnrollResultFragmentBinding r62 = this.a.e;
                Intrinsics.checkNotNull(r62);
                r62.b.setTextColor(ContextCompat.getColor(this.a.requireContext(), 2131102529));
            L41:
                SvaEnrollResultFragmentBinding r63 = this.a.e;
                Intrinsics.checkNotNull(r63);
                r63.b.setEnabled(true);
                Context r64 = this.a.getContext();
                if (r64 == null) goto L55;
                int r65 = ria.a.a;
                Intrinsics.checkNotNullParameter(r64, "context");
                VibrationEffect r66 = VibrationEffect.createPredefined(5);
                Object r67 = r64.getSystemService("vibrator");
                if ((r67 instanceof Vibrator) == false) goto L46;
                Vibrator r68 = (Vibrator) r67;
            L47:
                if (r68 == null) goto L55;
                if (r68.hasVibrator() == false) goto L51;
                r7 = r68;
            L51:
                if (r7 == null) goto L55;
                r7.vibrate(r66);
                goto L55
            L46:
                r68 = null;
                goto L47
            }
        }

        public AnonymousClass3(EnrollResultFragment r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L15:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            EnrollViewModel r6 = this.this$0.f;
            if (r6 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r6 = null;
        L11:
            z0<EnrollState> r7 = r6.getEnrollState();
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r7.collect(r2, this) != r0) goto L15;
            return r0;
        }
    }

    static {
    }

    public EnrollResultFragment() {
        this.h = t9a.b.a().b();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        FLogger.a.i("EnrollResultFragment", "onDestroyView ..");
        this.e = null;
    }

    public static final void T90(EnrollResultFragment r4) {
        EnrollViewModel r0 = r4.f;
        EnrollViewModel r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        int r3 = 2131914206;
        if (Intrinsics.areEqual(r0.getStartFrom(), EnrollViewModel.NOISE_REDUCTION) == false) goto L8;
        SvaEnrollResultFragmentBinding r2 = r4.e;
        Intrinsics.checkNotNull(r2);
        r2.b.setText(r4.getResources().getString(2131914206));
        return;
    L8:
        EnrollViewModel r5 = r4.f;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r5 = null;
    L12:
        if (r5.getVoiceWakeupSwitch() == true) goto L19;
        EnrollViewModel r6 = r4.f;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L18:
        if (r1.getHelpImproveVoiceWakeupSwitch() == true) goto L19;
    L20:
        SvaEnrollResultFragmentBinding r7 = r4.e;
        Intrinsics.checkNotNull(r7);
        r7.b.setText(r4.getResources().getString(r3));
        return;
    L16:
        r1 = r6;
    L19:
        r3 = 2131914195;
        goto L20
    }

    @Override // com.obric.audio.enroll.base.BaseFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        this.f = (EnrollViewModel) new ViewModelProvider(requireActivity()).get(EnrollViewModel.class);
    }

    public final SpannableStringBuilder U90(String r8, String r9) {
        SpannableStringBuilder r0 = new SpannableStringBuilder(r8);
        int r10 = StringsKt.indexOf$default(r8, r9, 0, false, 6, null);
        if (r10 == (-1)) goto L5;
        int r11 = r9.length() + r10;
        r0.setSpan(new b(this), r10, r11, 33);
    L5:
        return r0;
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        SvaEnrollResultFragmentBinding r8 = this.e;
        Intrinsics.checkNotNull(r8);
        r8.b.setOnClickListener(new h(this));
        SvaEnrollResultFragmentBinding r9 = this.e;
        Intrinsics.checkNotNull(r9);
        OCardListItem r10 = r9.c;
        Context r11 = getContext();
        EnrollViewModel r0 = null;
        if (r11 != null) goto L5;
        SpannableStringBuilder r12 = null;
    L6:
        r10.setSubTitle(r12);
        r10.q(true);
        r10.getSubTitleView().setMovementMethod(LinkMovementMethod.getInstance());
        if (this.h == true) goto L13;
        EnrollViewModel r13 = this.f;
        if (r13 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r13 = null;
    L12:
        if (Intrinsics.areEqual(r13.getStartFrom(), EnrollViewModel.DOUBAO_GUIDE) == false) goto L13;
    L14:
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new AnonymousClass3(this, null));
        EnrollViewModel r14 = this.f;
        if (r14 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r14 = null;
    L18:
        if (r14.getEnrollState().getValue() == EnrollState.ENROLLED_INTERRUPT) goto L25;
        FLogger.a.i("EnrollResultFragment", "set enrollState=ENROLLING");
        EnrollViewModel r15 = this.f;
        if (r15 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L23:
        r0.getEnrollState().setValue(EnrollState.ENROLLING);
        return;
    L22:
        r0 = r15;
        goto L23
    L25:
        return;
    L13:
        SvaEnrollResultFragmentBinding r16 = this.e;
        Intrinsics.checkNotNull(r16);
        OFloatingTitleBar.i(r16.i, 2131244127, new i(this));
        goto L14
    L5:
        String r2 = r11.getString(2131912514);
        r12 = U90(r11.getString(2131912513, new Object[]{r2}), r2);
        goto L6
    }

    public final View onCreateView(LayoutInflater r12, ViewGroup r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r12, "inflater");
        FLogger.a.i("EnrollResultFragment", "onCreateView ..");
        View r15 = r12.inflate(2131564913, r13, false);
        int r16 = 2131364993;
        if (ViewBindings.findChildViewById(r15, 2131364993) == null) goto L35;
        r16 = 2131372570;
        OButton r2 = (OButton) ViewBindings.findChildViewById(r15, 2131372570);
        if (r2 == null) goto L35;
        r16 = 2131374115;
        if (ViewBindings.findChildViewById(r15, 2131374115) == null) goto L35;
        r16 = 2131374141;
        if (ViewBindings.findChildViewById(r15, 2131374141) == null) goto L35;
        r16 = 2131374329;
        OCardListItem r3 = ViewBindings.findChildViewById(r15, 2131374329);
        if (r3 == null) goto L35;
        r16 = 2131376856;
        OButton r4 = (OButton) ViewBindings.findChildViewById(r15, 2131376856);
        if (r4 == null) goto L35;
        r16 = 2131381800;
        LottieAnimationView r5 = ViewBindings.findChildViewById(r15, 2131381800);
        if (r5 == null) goto L35;
        r16 = 2131381810;
        AppCompatTextView r6 = ViewBindings.findChildViewById(r15, 2131381810);
        if (r6 == null) goto L35;
        r16 = 2131381811;
        AppCompatTextView r7 = ViewBindings.findChildViewById(r15, 2131381811);
        if (r7 == null) goto L35;
        r16 = 2131384448;
        if (ViewBindings.findChildViewById(r15, 2131384448) == null) goto L35;
        r16 = 2131384449;
        if (((LinearLayout) ViewBindings.findChildViewById(r15, 2131384449)) == null) goto L35;
        r16 = 2131387955;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r15, 2131387955);
        if (r8 == null) goto L35;
        r16 = 2131388807;
        OFloatingTitleBar r9 = ViewBindings.findChildViewById(r15, 2131388807);
        if (r9 == null) goto L35;
        r16 = 2131392724;
        if (((LinearLayout) ViewBindings.findChildViewById(r15, 2131392724)) == null) goto L35;
        r16 = 2131392772;
        OCardListItem r10 = ViewBindings.findChildViewById(r15, 2131392772);
        if (r10 == null) goto L35;
        this.e = new SvaEnrollResultFragmentBinding((LinearLayout) r15, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        getLifecycle().addObserver(new AnonymousClass1());
        SvaEnrollResultFragmentBinding r17 = this.e;
        Intrinsics.checkNotNull(r17);
        return r17.a;
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r16)));
    }
}
