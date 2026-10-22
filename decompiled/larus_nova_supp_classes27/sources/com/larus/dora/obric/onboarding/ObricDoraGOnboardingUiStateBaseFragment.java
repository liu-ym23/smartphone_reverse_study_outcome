package com.larus.dora.obric.onboarding;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.CustomBarCountAudioVisualizer;
import com.larus.common_ui.widget.CircleSimpleDraweeView;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.databinding.ObricDoraGOnboardingBottomBtnLayoutBinding;
import com.larus.dora.impl.databinding.ObricDoraGOnboardingFragmentV2Binding;
import com.larus.dora.impl.onboarding.DoraOnboardingDevice;
import com.larus.dora.impl.onboarding.ext.AnimViewType;
import com.larus.dora.impl.onboarding.g.v2.DoraGOnboardingTopicView;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.dora.impl.view.DoraTextViewWithAnim;
import com.larus.dora.impl.view.DoraUrlSpanTextView;
import com.larus.dora.obric.view.ObricFloatingTitleBar;
import com.larus.platform.service.o2;
import com.lynx.lottieadapter.LottieAdapterView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OButtonGroup;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b%\b&\u0018\u0000 c2\u00020\u0001:\u0001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020%2\u0006\u0010+\u001a\u00020,H\u0004J\b\u0010-\u001a\u00020%H\u0002J\u001a\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u00020\u00052\b\b\u0002\u00100\u001a\u00020\rH\u0004J\u0010\u00101\u001a\u00020%2\u0006\u0010/\u001a\u00020\u0005H\u0004J\u0006\u00102\u001a\u00020%J\u0006\u00103\u001a\u00020%J\u0006\u00104\u001a\u00020%J\u0006\u00105\u001a\u00020%J\u0006\u0010\f\u001a\u00020\rJ\b\u00106\u001a\u00020%H\u0002J\b\u00107\u001a\u00020%H\u0002J\u0006\u00108\u001a\u00020%J\u0006\u00109\u001a\u00020%J\u000e\u0010:\u001a\u00020%H\u0086@¢\u0006\u0002\u0010;J\u0006\u0010<\u001a\u00020%J\u0018\u0010=\u001a\u00020%2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?H\u0016J\u0010\u0010A\u001a\u00020%2\u0006\u0010+\u001a\u00020\rH\u0016J\u0010\u0010B\u001a\u00020%2\u0006\u0010+\u001a\u00020\rH\u0016J\u0010\u0010C\u001a\u00020%2\u0006\u0010+\u001a\u00020\rH\u0016J\u001a\u0010D\u001a\u00020%2\u0006\u0010+\u001a\u00020\r2\b\b\u0002\u0010E\u001a\u00020\rH\u0002J\b\u0010F\u001a\u00020%H\u0002J\b\u0010G\u001a\u00020%H\u0002J\u0010\u0010H\u001a\u00020%2\u0006\u0010+\u001a\u00020\rH\u0002J\u000e\u0010I\u001a\u00020%2\u0006\u0010J\u001a\u00020\u0011J\u0006\u0010K\u001a\u00020%J\u0006\u0010L\u001a\u00020%J\u0006\u0010M\u001a\u00020%J\u0006\u0010N\u001a\u00020%J\u001c\u0010O\u001a\u00020%2\b\u0010P\u001a\u0004\u0018\u00010\u00142\b\u0010Q\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010R\u001a\u00020%2\u0006\u0010S\u001a\u00020\u0011H\u0004J\u0014\u0010T\u001a\u00020%2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0011H\u0004J\u0012\u0010U\u001a\u00020%2\b\u0010Q\u001a\u0004\u0018\u00010\u0014H\u0002J\f\u0010V\u001a\u00020\u0011*\u00020\u0014H\u0002J\u0010\u0010W\u001a\u0004\u0018\u00010\u0011*\u0004\u0018\u00010\u0014H\u0002J\u000e\u0010X\u001a\u00020\u0011*\u0004\u0018\u00010\u0014H\u0002J\b\u0010Y\u001a\u00020%H\u0016J\b\u0010Z\u001a\u00020%H\u0002J\b\u0010[\u001a\u00020%H\u0016J\b\u0010\\\u001a\u00020%H\u0016J\b\u0010]\u001a\u00020%H\u0016J\b\u0010^\u001a\u00020%H\u0016J\b\u0010_\u001a\u00020\rH\u0016J\b\u0010`\u001a\u00020\rH\u0016J\b\u0010a\u001a\u00020\rH\u0016J\b\u0010b\u001a\u00020\u0011H\u0016J\b\u0010(\u001a\u00020\u0014H&R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u00148F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006d"}, d2 = {"Lcom/larus/dora/obric/onboarding/ObricDoraGOnboardingUiStateBaseFragment;", "Lcom/larus/dora/obric/onboarding/ObricDoraGOnboardingBaseFragmentV2;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/ObricDoraGOnboardingFragmentV2Binding;", "getBinding", "()Lcom/larus/dora/impl/databinding/ObricDoraGOnboardingFragmentV2Binding;", "setBinding", "(Lcom/larus/dora/impl/databinding/ObricDoraGOnboardingFragmentV2Binding;)V", "mainHandler", "Landroid/os/Handler;", "isVideoQueryLlmCallStarted", "", "obricWearDialog", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "currentObricOnboardingPage", "", "pendingObricOnboardingLeaveType", "<set-?>", "Lcom/larus/dora/obric/onboarding/ObricDoraGOnboardingFragmentBaseUiState;", "currentUiState", "getCurrentUiState", "()Lcom/larus/dora/obric/onboarding/ObricDoraGOnboardingFragmentBaseUiState;", "setCurrentUiState", "(Lcom/larus/dora/obric/onboarding/ObricDoraGOnboardingFragmentBaseUiState;)V", "currentUiState$delegate", "Lkotlin/properties/ReadWriteProperty;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "updateUiState", "uiState", "Lcom/larus/dora/obric/onboarding/WakeupQueryUiState;", "renderAvatarBubble", "state", "Lcom/larus/dora/obric/onboarding/AvatarUiState;", "hideNonObricOnboardingViews", "applyAvatarNormal", "b", "withAnim", "applyAvatarLittle", "gotoNext", "gotoPrevious", "gotoDiary", "resetVideoQueryLlmCallStarted", "onVideoQueryLlmCallStarted", "gotoNextFromVideoQueryQueryEnd", "gotoNextFromVideoQueryUserAction", "gotoDone", "gotoReply", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gotoFirst", "onKeyState", "event", "", "pos", "onWearState", "onLinkState", "onCallState", "checkWearState", "isNeedDelay", "showObricWearDialog", "dismissObricWearDialog", "checkLinkState", "showHangupDueCallEnterToast", "text", "showCallSkipGuideDialog", "tryCancelCallSkipGuideDialog", "jumpConfig", "jumpDeviceHome", "onUiStateChanged", "oldUiState", "newUiState", "markNextObricOnboardingLeaveType", "leaveType", "reportCurrentObricOnboardingPageLeave", "syncObricOnboardingPage", "toBuryPointType", "toObricOnboardingPage", "debugName", "onResume", "refreshObricWearState", "onStart", "onStop", "onDestroyView", "onSkipButtonClicked", "autoLogEnterPage", "autoLogExitPage", "autoLogShipButton", "getCurrentPageName", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ObricDoraGOnboardingUiStateBaseFragment extends ObricDoraGOnboardingBaseFragmentV2 {
    public static final /* synthetic */ KProperty<Object>[] y = null;
    public ObricDoraGOnboardingFragmentV2Binding r;
    public final Handler s;
    public boolean t;
    public com.obric.oui.dialog.v2.alert.c u;
    public String v;
    public String w;
    public final h x;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AvatarUiState.values().length];
            r0[AvatarUiState.WAITING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[AvatarUiState.THINKING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[AvatarUiState.SPEAKING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class c<T> implements FlowCollector {
        public final /* synthetic */ ObricDoraGOnboardingUiStateBaseFragment a;

        public c(ObricDoraGOnboardingUiStateBaseFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r4, Continuation r5) {
            c2 r6 = (c2) r4;
            StringBuilder r7 = new StringBuilder("ui state: ");
            r7.append(this.a.pa0());
            r7.append(", ");
            p r0 = this.a.pa0();
            if (r0 == null) goto L5;
            Boolean r1 = Boxing.boxBoolean(r0.d());
        L6:
            r7.append(r1);
            g49.d.d("ObricDoraGOnboardingUiStateBaseFragment", r7.toString());
            p r8 = this.a.pa0();
            if (r8 == null) goto L11;
            boolean r2 = true;
            if (r8.d() != true) goto L11;
        L12:
            if (r2 == false) goto L39;
            ObricDoraGOnboardingUiStateBaseFragment r9 = this.a;
            ObricDoraGOnboardingFragmentV2Binding r3 = r9.r;
            if (r3 == null) goto L37;
            r9.s.removeCallbacksAndMessages(null);
            if ((r6 instanceof c2.d) == false) goto L19;
            com.larus.utils.e1.x(r3.c);
            com.larus.utils.e1.x(r3.b);
            ObricDoraGOnboardingUiStateBaseFragment.ka0(r9, r3);
            AppCompatTextView r10 = r3.v;
            Intrinsics.checkNotNull(r10);
            com.larus.utils.e1.x(r10);
            r10.setText(r9.fa0(2131902819));
            AppCompatTextView r11 = r3.u;
            Intrinsics.checkNotNull(r11);
            com.larus.utils.e1.x(r11);
            r11.setText(r9.fa0(2131902820));
            com.larus.utils.e1.o(r3.r);
            com.larus.utils.e1.o(r3.t);
            com.larus.utils.e1.o(r3.s);
            com.larus.utils.e1.o(r3.p);
            com.larus.utils.e1.o(r3.e);
            goto L37
        L19:
            if ((r6 instanceof c2.e) == false) goto L22;
            Intrinsics.checkNotNullParameter(r3, "b");
            b69.w.k(r3.b, AnimViewType.AVATAR);
            RelativeLayout r12 = r3.l;
            AnimViewType r13 = AnimViewType.BUBBLE;
            b69.w.k(r12, r13);
            b69.w.k(r3.m, r13);
            b69.w.k(r3.j, AnimViewType.BUBBLE_BACKGROUND);
            com.larus.utils.e1.o(r3.v);
            com.larus.utils.e1.o(r3.u);
            AppCompatTextView r14 = r3.r;
            r14.setText(r9.fa0(2131902776));
            Intrinsics.checkNotNull(r14);
            b69.w.a(r14);
            DoraGOnboardingTopicView r15 = r3.t;
            r9.pa0();
            r9.pa0();
            Intrinsics.checkNotNull(r15);
            b69.w.a(r15);
            com.larus.utils.e1.x(r3.s);
            goto L37
        L22:
            if ((r6 instanceof c2.b) == true) goto L37;
            if ((r6 instanceof c2.c) == false) goto L27;
            com.larus.utils.e1.o(r3.p);
            com.larus.utils.e1.o(r3.e);
            com.larus.utils.e1.x(r3.c);
            com.larus.utils.e1.x(r3.b);
            ObricDoraGOnboardingUiStateBaseFragment.ka0(r9, r3);
            com.larus.utils.e1.o(r3.r);
            com.larus.utils.e1.o(r3.t);
            com.larus.utils.e1.o(r3.s);
            AppCompatTextView r16 = r3.v;
            int r17 = com.larus.utils.j0.a;
            r16.setText(com.larus.utils.j0.d(2131902817));
            Intrinsics.checkNotNull(r16);
            b69.w.a(r16);
            com.larus.utils.e1.o(r3.u);
            goto L37
        L27:
            if ((r6 instanceof c2.a) == false) goto L36;
            c2.a r18 = (c2.a) r6;
            if (r18.getType() != 0) goto L31;
        L34:
            com.larus.utils.e1.x(r3.c);
            com.larus.utils.e1.x(r3.b);
            AppCompatTextView r20 = r3.v;
            Intrinsics.checkNotNull(r20);
            com.larus.utils.e1.x(r20);
            r9.pa0();
            r20.setText(r9.ja0());
            com.larus.utils.e1.o(r3.p);
            com.larus.utils.e1.o(r3.f);
            com.larus.utils.e1.o(r3.g);
            goto L37
        L31:
            if (r18.b == null) goto L34;
            com.larus.utils.e1.o(r3.c);
            com.larus.utils.e1.o(r3.b);
            com.larus.utils.e1.o(r3.v);
            com.larus.utils.e1.o(r3.u);
            LinearLayout r21 = r3.e;
            com.larus.utils.e1.o(r3.n);
            Intrinsics.checkNotNull(r21);
            com.larus.utils.e1.x(r21);
            AppCompatTextView r22 = r3.f;
            Intrinsics.checkNotNull(r22);
            com.larus.utils.e1.x(r22);
            r22.setText(r9.ja0());
            com.larus.utils.e1.o(r3.g);
            FrameLayout r23 = r3.p;
            Intrinsics.checkNotNull(r23);
            b69.w.o(r23);
            r3.o.setImageBitmap(r18.b);
            goto L37
        L36:
            throw new NoWhenBranchMatchedException();
        L37:
            r9.sa0();
        L39:
            return Unit.INSTANCE;
        L11:
            r2 = false;
            goto L12
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class d<T> implements FlowCollector {
        public final /* synthetic */ ObricDoraGOnboardingUiStateBaseFragment a;

        public d(ObricDoraGOnboardingUiStateBaseFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            byte[] r4 = (byte[]) r2;
            p r5 = this.a.pa0();
            if (r5 == null) goto L7;
            boolean r0 = true;
            if (r5.d() != true) goto L7;
        L8:
            if (r0 == false) goto L15;
            ObricDoraGOnboardingFragmentV2Binding r6 = this.a.r;
            if (r6 == null) goto L15;
            CustomBarCountAudioVisualizer r7 = r6.i;
            if (r7 == null) goto L15;
            r7.post(new k0(r7, r4));
        L15:
            return Unit.INSTANCE;
        L7:
            r0 = false;
            goto L8
        }
    }

    public static final class e<T> implements FlowCollector {
        public final /* synthetic */ ObricDoraGOnboardingUiStateBaseFragment a;

        public e(ObricDoraGOnboardingUiStateBaseFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            AvatarUiState r7 = (AvatarUiState) r5;
            p r8 = this.a.pa0();
            if (r8 != null) goto L5;
        L7:
            boolean r9 = false;
        L8:
            if (r9 == false) goto L24;
            ObricDoraGOnboardingUiStateBaseFragment r10 = this.a;
            r10.getClass();
            Intrinsics.checkNotNullParameter(r7, "state");
            ObricDoraGOnboardingFragmentV2Binding r2 = r10.r;
            if (r2 == null) goto L24;
            int r11 = b.a[r7.ordinal()];
            if (r11 != 1) goto L15;
            com.larus.utils.e1.q(r2.m);
            com.larus.utils.e1.q(r2.l);
            com.larus.utils.e1.q(r2.j);
            r2.i.c(false);
        L22:
            r10.sa0();
            goto L24
        L15:
            if (r11 != 2) goto L17;
            ObricDoraGOnboardingUiStateBaseFragment.ka0(r10, r2);
            r2.m.playAnimation();
            com.larus.utils.e1.q(r2.l);
            com.larus.utils.e1.x(r2.m);
            com.larus.utils.e1.x(r2.j);
            r2.i.c(false);
            goto L22
        L17:
            if (r11 != 3) goto L22;
            com.larus.utils.e1.q(r2.m);
            com.larus.utils.e1.x(r2.l);
            com.larus.utils.e1.x(r2.j);
            r2.i.c(true);
        L24:
            return Unit.INSTANCE;
        L5:
            if (r8.d() != true) goto L7;
            r9 = true;
            goto L8
        }
    }

    public static final class f<T> implements FlowCollector {
        public final /* synthetic */ ObricDoraGOnboardingUiStateBaseFragment a;

        public f(ObricDoraGOnboardingUiStateBaseFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            Unit r4 = (Unit) r2;
            t r5 = null;
            ObricDoraGOnboardingWelcomeStateFragment r6 = null;
            if ((this.a.pa0() instanceof x) == false) goto L14;
            g49.d.d("ObricDoraGOnboardingUiStateBaseFragment", "llm call started in video query state, stop auto scroll");
            ObricDoraGOnboardingUiStateBaseFragment r7 = this.a;
            r7.t = true;
            if ((r7 instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L7;
            r6 = (ObricDoraGOnboardingWelcomeStateFragment) r7;
        L7:
            if (r6 == null) goto L23;
            g49.d.d("ObricDoraGOnboardingWelcomeStateFragment", "stop video query auto scroll for voice wakeup");
            ObricDoraGOnboardingWelcomeStateFragment.b r8 = r6.R;
            if (r8 == null) goto L23;
            ObricDoraGOnboardingTopicView r9 = r8.d;
            if (r9 == null) goto L23;
            r9.setAutoScrollEnabled(false);
        L23:
            return Unit.INSTANCE;
        L14:
            if ((this.a.pa0() instanceof t) == false) goto L23;
            g49.d.d("ObricDoraGOnboardingUiStateBaseFragment", "llm call started in long press wakeup state");
            p r10 = this.a.pa0();
            if ((r10 instanceof t) == false) goto L18;
            r5 = (t) r10;
        L18:
            if (r5 == null) goto L23;
            ObricDoraGOnboardingViewModelV2 r11 = r5.c;
            if (r11 == null) goto L23;
            r11.stopTTS("long press wakeup llm call started");
            goto L23
        }
    }

    public static final class g<T> implements FlowCollector {
        public final /* synthetic */ ObricDoraGOnboardingUiStateBaseFragment a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ActionEvent.values().length];
                r0[ActionEvent.TOAST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[ActionEvent.DIALOG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public g(ObricDoraGOnboardingUiStateBaseFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            com.larus.dora.obric.onboarding.a r4 = (com.larus.dora.obric.onboarding.a) r2;
            ActionEvent r0 = null;
            if ((r4 instanceof com.larus.dora.obric.onboarding.a.C0108a) == false) goto L5;
            com.larus.dora.obric.onboarding.a.C0108a r5 = (com.larus.dora.obric.onboarding.a.C0108a) r4;
        L6:
            if (r5 == null) goto L8;
            r0 = r5.a;
        L8:
            if (r0 != null) goto L10;
            int r6 = -1;
        L12:
            if (r6 != 1) goto L14;
            String r7 = this.a.fa0(2131902786);
            this.a.pa0();
            ObricDoraGOnboardingUiStateBaseFragment r8 = this.a;
            r8.getClass();
            Intrinsics.checkNotNullParameter(r7, "text");
            t19.s r1 = t19.s.a;
            Context r9 = r8.getContext();
            r1.getClass();
            t19.s.c(r9, r7);
        L22:
            return Unit.INSTANCE;
        L14:
            if (r6 != 2) goto L22;
            ObricDoraGOnboardingUiStateBaseFragment r10 = this.a;
            if (((Boolean) r10.ga0().getDeviceCallStateFlow().getValue()).booleanValue() == false) goto L19;
            r10.pa0();
        L19:
            r10.ea0();
            r10.ma0(r10.da0(), true);
            r10.la0(r10.ca0());
            goto L22
        L10:
            r6 = a.a[r0.ordinal()];
            goto L12
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class h extends ObservableProperty<p> {
        public final /* synthetic */ ObricDoraGOnboardingUiStateBaseFragment a;

        public h(ObricDoraGOnboardingUiStateBaseFragment r1) {
            this.a = r1;
            super(null);
        }

        public final void afterChange(KProperty<?> r8, p r9, p r10) {
            Intrinsics.checkNotNullParameter(r8, "property");
            p r11 = r10;
            p r12 = r9;
            StringBuilder r13 = new StringBuilder("currentUiState changed, old=");
            ObricDoraGOnboardingUiStateBaseFragment r0 = this.a;
            KProperty<Object>[] r1 = ObricDoraGOnboardingUiStateBaseFragment.y;
            r0.getClass();
            r13.append(ObricDoraGOnboardingUiStateBaseFragment.na0(r12));
            r13.append(", new=");
            this.a.getClass();
            r13.append(ObricDoraGOnboardingUiStateBaseFragment.na0(r11));
            g49.d.d("ObricDoraGOnboardingUiStateBaseFragment", r13.toString());
            ObricDoraGOnboardingUiStateBaseFragment r14 = this.a;
            r14.getClass();
            g49.d.d("ObricDoraGOnboardingUiStateBaseFragment", "onUiStateChanged, old=" + ObricDoraGOnboardingUiStateBaseFragment.na0(r12) + ", new=" + ObricDoraGOnboardingUiStateBaseFragment.na0(r11));
            if (r12 == null) goto L5;
            int r2 = com.larus.dora.impl.onboarding.m0.a;
            com.larus.dora.impl.onboarding.m0.c(ObricDoraGOnboardingUiStateBaseFragment.wa0(r12), SystemClock.elapsedRealtime() - r12.d);
        L5:
            ObricDoraGOnboardingWelcomeStateFragment r3 = null;
            if ((r11 instanceof y) == false) goto L9;
            String r15 = "onboarding_intro";
        L30:
            String r4 = r14.w;
            r14.w = null;
            boolean r5 = true;
            if (Intrinsics.areEqual(r14.v, r15) == true) goto L42;
            r14.ua0(r4);
            r14.v = r15;
            if (r15 == null) goto L42;
            int r6 = b2.a;
            Intrinsics.checkNotNullParameter(r15, "currentPage");
            if (r15.length() != 0) goto L38;
            boolean r7 = true;
        L39:
            if (r7 == true) goto L42;
            g49.d.d("ObricDoraOnboardingTracker", "enterPage: currentPage=".concat(r15));
            DoraBuryPointManager.a.L("enter_page", MapsKt.mapOf(TuplesKt.to("current_page", r15)));
            goto L42
        L38:
            r7 = false;
        L42:
            int r16 = 8;
            if (r11 != null) goto L55;
            r14.ga0().setWelcomeMusicAllowed(false, "obric ui state cleared");
            if ((r14 instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L47;
            r3 = (ObricDoraGOnboardingWelcomeStateFragment) r14;
        L47:
            if (r3 == null) goto L54;
            ObricFloatingTitleBar r17 = r3.z;
            if (r17 == null) goto L51;
            r17.c.getStartButtonGroup().setVisibility(8);
        L51:
            ObricFloatingTitleBar r18 = r3.z;
            if (r18 == null) goto L54;
            r18.c.Q(false);
        L54:
            r14.sa0();
            return;
        L55:
            boolean r20 = r11 instanceof y;
            r14.ga0().setWelcomeMusicAllowed(r20, "obric ui state=".concat(ObricDoraGOnboardingUiStateBaseFragment.na0(r11)));
            int r21 = com.larus.dora.impl.onboarding.m0.a;
            com.larus.dora.impl.onboarding.m0.b(ObricDoraGOnboardingUiStateBaseFragment.wa0(r11));
            if ((r14 instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L58;
            r3 = (ObricDoraGOnboardingWelcomeStateFragment) r14;
        L58:
            if (r3 != null) goto L60;
        L85:
            if (r20 == true) goto L89;
            r14.sa0();
            return;
        L89:
            return;
        L60:
            if ((r11 instanceof q) == false) goto L62;
        L69:
            boolean r22 = true;
        L70:
            ObricFloatingTitleBar r23 = r3.z;
            if (r23 == null) goto L77;
            OButtonGroup r24 = r23.c.getStartButtonGroup();
            if (r22 == false) goto L75;
            r16 = 0;
        L75:
            r24.setVisibility(r16);
        L77:
            if ((r11 instanceof r) == false) goto L79;
        L81:
            r5 = false;
        L82:
            ObricFloatingTitleBar r25 = r3.z;
            if (r25 == null) goto L85;
            r25.c.Q(r5);
            goto L85
        L79:
            if ((r11 instanceof s) == true) goto L81;
        L62:
            if ((r11 instanceof t) == true) goto L69;
            if ((r11 instanceof u) == true) goto L69;
            if ((r11 instanceof v) == true) goto L69;
            r22 = false;
            goto L70
        L9:
            if ((r11 instanceof x) == false) goto L12;
            r15 = "voice_wakeup";
            goto L30
        L12:
            if ((r11 instanceof q) == false) goto L15;
            r15 = "interrupt_tutorial";
            goto L30
        L15:
            if ((r11 instanceof t) == false) goto L18;
            r15 = "gesture_tutorial";
            goto L30
        L18:
            if ((r11 instanceof u) == false) goto L21;
            r15 = "slide_volume";
            goto L30
        L21:
            if ((r11 instanceof v) == false) goto L24;
            r15 = "tap_capture";
            goto L30
        L24:
            if ((r11 instanceof r) == false) goto L27;
            r15 = "diary_auth";
            goto L30
        L27:
            if ((r11 instanceof s) == false) goto L29;
            r15 = "onboarding_complete";
            goto L30
        L29:
            r15 = null;
            goto L30
        }
    }

    static {
        y = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(ObricDoraGOnboardingUiStateBaseFragment.class, "currentUiState", "getCurrentUiState()Lcom/larus/dora/obric/onboarding/ObricDoraGOnboardingFragmentBaseUiState;", 0))};
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final boolean S90() {
        return false;
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final boolean T90() {
        return false;
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final boolean U90() {
        return false;
    }

    public final String k() {
        return "dora_g_onboarding_v2";
    }

    public abstract p xa0();

    public final void oa0() {
        com.obric.oui.dialog.v2.alert.c r0 = this.u;
        if (r0 == null) goto L21;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r0);
        goto L21
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r2 == null) goto L18;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r1.getLooper()) goto L9;
        r1.post(DialogLancet.createDismissRunnable(r0));
    L21:
        this.u = null;
    }

    public void onDestroyView() {
        Job r0 = this.p;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        oa0();
        super.onDestroyView();
        this.s.removeCallbacksAndMessages(null);
        com.larus.dora.impl.onboarding.d.c(null);
        this.r = null;
    }

    public final p pa0() {
        return (p) this.x.getValue(this, y[0]);
    }

    public final void sa0() {
        ObricDoraGOnboardingFragmentV2Binding r0 = this.r;
        if (r0 == null) goto L6;
        com.larus.utils.e1.o(r0.e);
        com.larus.utils.e1.o(r0.p);
        com.larus.utils.e1.o(r0.v);
        com.larus.utils.e1.o(r0.u);
        com.larus.utils.e1.o(r0.c);
        com.larus.utils.e1.o(r0.k);
        com.larus.utils.e1.o(r0.h);
        com.larus.utils.e1.o(r0.r);
        com.larus.utils.e1.o(r0.t);
        com.larus.utils.e1.o(r0.s);
        com.larus.utils.e1.o(r0.b);
        com.larus.utils.e1.o(r0.j);
        com.larus.utils.e1.o(r0.l);
        com.larus.utils.e1.o(r0.m);
        return;
    }

    public ObricDoraGOnboardingUiStateBaseFragment() {
        this.s = new Handler(Looper.getMainLooper());
        Delegates r0 = Delegates.INSTANCE;
        this.x = new h(this);
    }

    @Override // com.larus.dora.obric.onboarding.ObricDoraGOnboardingBaseFragmentV2, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void aa0() {
        super.aa0();
        ta0();
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void onResume() {
        super.onResume();
        ga0().fetchWearState();
        ma0(da0(), true);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new ObricDoraGOnboardingUiStateBaseFragment$refreshObricWearState$1(this, null), 2, null);
    }

    public final void onStart() {
        super.onStart();
        ga0().onStart();
    }

    public final void onStop() {
        super.onStop();
        ga0().onStop();
    }

    public final void qa0() {
        p r0 = pa0();
        ObricDoraGOnboardingWelcomeStateFragment r2 = null;
        if ((r0 instanceof y) == false) goto L10;
        if ((this instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L7;
        r2 = (ObricDoraGOnboardingWelcomeStateFragment) this;
    L7:
        if (r2 == null) goto L44;
        r2.fb0();
    L44:
        r r1 = new r(this, this.r, ga0());
        r1.b();
        va0(r1);
        return;
    L10:
        if ((r0 instanceof x) == false) goto L17;
        ga0().stopTTS("exit to diary");
        if ((this instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L14;
        r2 = (ObricDoraGOnboardingWelcomeStateFragment) this;
    L14:
        if (r2 == null) goto L44;
        r2.Na0();
        goto L44
    L17:
        if ((r0 instanceof q) == false) goto L24;
        ga0().stopTTS("exit to diary");
        if ((this instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L21;
        r2 = (ObricDoraGOnboardingWelcomeStateFragment) this;
    L21:
        if (r2 == null) goto L44;
        r2.Ha0();
        goto L44
    L24:
        if ((r0 instanceof t) == false) goto L31;
        ga0().stopTTS("exit to diary");
        if ((this instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L28;
        r2 = (ObricDoraGOnboardingWelcomeStateFragment) this;
    L28:
        if (r2 == null) goto L44;
        r2.Ja0();
        goto L44
    L31:
        if ((r0 instanceof u) == false) goto L38;
        ga0().stopTTS("exit to diary");
        if ((this instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L35;
        r2 = (ObricDoraGOnboardingWelcomeStateFragment) this;
    L35:
        if (r2 == null) goto L44;
        r2.Ka0();
        goto L44
    L38:
        if ((r0 instanceof v) == false) goto L44;
        ga0().stopTTS("exit to diary");
        if ((this instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L42;
        r2 = (ObricDoraGOnboardingWelcomeStateFragment) this;
    L42:
        if (r2 == null) goto L44;
        r2.La0();
        goto L44
    }

    public final void ra0() {
        p r0 = pa0();
        if (r0 == null) goto L5;
        p r1 = r0.e();
    L6:
        g49.d.d("ObricDoraGOnboardingUiStateBaseFragment", "gotoNext, old=" + na0(r0) + ", next=" + na0(r1));
        if (r1 == null) goto L9;
        r1.b();
    L9:
        va0(r1);
        g49.d.d("ObricDoraGOnboardingUiStateBaseFragment", "gotoNext done, current=".concat(na0(pa0())));
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void ta0() {
        DoraOnboardingDevice r0 = ga0().getDoraOnboardingDevice();
        if (r0 == null) goto L5;
        String r1 = r0.b;
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        return;
    L14:
        ua0(null);
        ga0().exitOnboarding();
        ObricDoraGOnboardingBaseFragmentV2.ha0(r1);
        return;
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public static String na0(p r0) {
        if (r0 != null) goto L6;
        return "null";
    L6:
        return r0.getClass().getSimpleName();
    }

    public static String wa0(p r1) {
        if ((r1 instanceof y) == false) goto L6;
        return "introduction_page";
    L6:
        if ((r1 instanceof x) == false) goto L9;
    L10:
        return "first_conversation_guidance";
    L9:
        if ((r1 instanceof q) == true) goto L10;
        if ((r1 instanceof t) == false) goto L15;
        return "voice_wakeup_guidance";
    L15:
        if ((r1 instanceof v) == false) goto L18;
        return "press_side_button_shutter";
    L18:
        if ((r1 instanceof u) == false) goto L21;
        return "media_control";
    L21:
        if ((r1 instanceof s) == false) goto L23;
        return "complete_guidance";
    L23:
        return "";
    }

    @Override // e69.a
    public final void S30(boolean r2) {
        if (r2 == true) goto L5;
        ea0();
        ma0(da0(), true);
        la0(ca0());
        return;
    }

    @Override // e69.a
    public final void bO(boolean r2) {
        pa0();
        ma0(da0(), true);
        la0(ca0());
    }

    @Override // e69.a
    public final void jL(boolean r2) {
        la0(ca0());
        ma0(da0(), false);
    }

    public final void la0(boolean r10) {
        Job r0 = this.o;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        if (r10 == true) goto L7;
        this.o = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricDoraGOnboardingUiStateBaseFragment$checkLinkState$1(this, null), 3, null);
        return;
    L7:
        ea0();
    }

    public final void ua0(String r7) {
        String r0 = this.v;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r7 != null) goto L7;
        r7 = this.w;
    L7:
        this.w = null;
        this.v = null;
        int r2 = b2.a;
        Intrinsics.checkNotNullParameter(r0, "currentPage");
        boolean r3 = true;
        if (r0.length() != 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L30;
        StringBuilder r5 = new StringBuilder("leaveOnboardingPage: currentPage=");
        r5.append(r0);
        r5.append(", leaveType=");
        if (r7 != null) goto L16;
        String r6 = "";
    L17:
        r5.append(r6);
        g49.d.d("ObricDoraOnboardingTracker", r5.toString());
        Map r1 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("current_page", r0)});
        if (r7 != null) goto L20;
    L28:
        DoraBuryPointManager.a.L("leave_onboarding_page", r1);
        return;
    L20:
        if (r7.length() > 0) goto L23;
        r3 = false;
    L23:
        if (r3 == true) goto L26;
        r7 = null;
    L26:
        if (r7 == null) goto L28;
        r1.put("leave_type", r7);
        goto L28
    L16:
        r6 = r7;
        goto L17
    L30:
        return;
    L10:
        r4 = false;
        goto L11
    }

    public final void va0(p r4) {
        this.x.setValue(this, y[0], r4);
    }

    public static void ka0(ObricDoraGOnboardingUiStateBaseFragment r4, ObricDoraGOnboardingFragmentV2Binding r5) {
        Intrinsics.checkNotNullParameter(r5, "b");
        boolean r0 = true;
        b69.w.l(r5.b, true, 2);
        ImageView r6 = r5.j;
        if (r6.getVisibility() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        boolean r3 = true;
    L9:
        b69.w.l(r6, r3, 2);
        RelativeLayout r7 = r5.l;
        if (r7.getVisibility() != 0) goto L12;
        boolean r8 = true;
    L13:
        if (r8 == false) goto L15;
        boolean r9 = true;
    L16:
        b69.w.l(r7, r9, 2);
        LottieAdapterView r10 = r5.m;
        if (r10.getVisibility() != 0) goto L19;
        boolean r11 = true;
    L20:
        if (r11 == true) goto L23;
        r0 = false;
    L23:
        b69.w.l(r10, r0, 2);
        return;
    L19:
        r11 = false;
        goto L20
    L15:
        r9 = false;
        goto L16
    L12:
        r8 = false;
        goto L13
    L8:
        r3 = false;
        goto L9
    L5:
        r2 = false;
        goto L6
    }

    @Override // e69.a
    public final void Ir(int r3, int r4) {
        g49.d.d("ObricDoraGOnboardingUiStateBaseFragment", "onKeyState, event=" + r3 + ", pos=" + r4 + ", current=" + na0(pa0()));
        p r0 = pa0();
        if (r0 == null) goto L6;
        r0.c(r3, r4);
        return;
    }

    public final void ma0(boolean r10, boolean r11) {
        Job r0 = this.p;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        if (r10 == true) goto L7;
        this.p = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricDoraGOnboardingUiStateBaseFragment$checkWearState$1(r11, this, null), 3, null);
        return;
    L7:
        oa0();
    }

    @Override // com.larus.dora.obric.onboarding.ObricDoraGOnboardingBaseFragmentV2, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        ObricDoraGOnboardingFragmentV2Binding r10 = this.r;
        if (r10 == null) goto L6;
        sa0();
        p r11 = xa0();
        r11.b();
        va0(r11);
        ObricDoraGOnboardingBottomBtnLayoutBinding r12 = r10.d;
        com.larus.utils.e1.d(r12.d, new f0(this));
        com.larus.utils.e1.d(r12.b, new g0(this));
        Lifecycle.State r13 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ObricDoraGOnboardingUiStateBaseFragment$onViewCreated$lambda$15$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r13, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ObricDoraGOnboardingUiStateBaseFragment$onViewCreated$lambda$15$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r13, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ObricDoraGOnboardingUiStateBaseFragment$onViewCreated$lambda$15$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r13, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ObricDoraGOnboardingUiStateBaseFragment$onViewCreated$lambda$15$$inlined$launchAndRepeatWithViewLifecycle$default$4(this, r13, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ObricDoraGOnboardingUiStateBaseFragment$onViewCreated$lambda$15$$inlined$launchAndRepeatWithViewLifecycle$default$5(this, r13, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ObricDoraGOnboardingUiStateBaseFragment$onViewCreated$lambda$15$$inlined$launchAndRepeatWithViewLifecycle$default$6(this, r13, null, this), 3, null);
        return;
    }

    public final View onCreateView(LayoutInflater r44, ViewGroup r45, Bundle r46) {
        Intrinsics.checkNotNullParameter(r44, "inflater");
        ConstraintLayout r0 = r44.inflate(2131563988, r45, false);
        int r1 = 2131367844;
        if (((LinearLayout) ViewBindings.findChildViewById(r0, 2131367844)) == null) goto L160;
        r1 = 2131368926;
        if (((ObricFloatingTitleBar) ViewBindings.findChildViewById(r0, 2131368926)) == null) goto L160;
        ConstraintLayout r2 = r0;
        int r3 = 2131369852;
        CircleSimpleDraweeView r42 = (CircleSimpleDraweeView) ViewBindings.findChildViewById(r0, 2131369852);
        if (r42 == null) goto L162;
        r3 = 2131369853;
        View r7 = ViewBindings.findChildViewById(r0, 2131369853);
        if (r7 == null) goto L162;
        r3 = 2131369858;
        View r4 = ViewBindings.findChildViewById(r0, 2131369858);
        if (r4 == null) goto L162;
        int r5 = 2131369592;
        OButton r10 = ViewBindings.findChildViewById(r4, 2131369592);
        if (r10 == null) goto L158;
        LinearLayout r11 = (LinearLayout) r4;
        r5 = 2131369594;
        OButton r12 = ViewBindings.findChildViewById(r4, 2131369594);
        if (r12 == null) goto L158;
        r5 = 2131369597;
        View r13 = ViewBindings.findChildViewById(r4, 2131369597);
        if (r13 == null) goto L158;
        r5 = 2131369598;
        View r14 = ViewBindings.findChildViewById(r4, 2131369598);
        if (r14 == null) goto L158;
        ObricDoraGOnboardingBottomBtnLayoutBinding r6 = new ObricDoraGOnboardingBottomBtnLayoutBinding(r11, r10, r11, r12, r13, r14);
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131369860);
        if (r9 == null) goto L156;
        DoraTextViewWithAnim r15 = (DoraTextViewWithAnim) ViewBindings.findChildViewById(r0, 2131369861);
        if (r15 == null) goto L155;
        DoraTextView r16 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131369862);
        if (r16 == null) goto L154;
        View r17 = ViewBindings.findChildViewById(r0, 2131369863);
        if (r17 == null) goto L153;
        CustomBarCountAudioVisualizer r18 = (CustomBarCountAudioVisualizer) ViewBindings.findChildViewById(r0, 2131369864);
        if (r18 == null) goto L152;
        ImageView r110 = (ImageView) ViewBindings.findChildViewById(r0, 2131369865);
        if (r110 == null) goto L151;
        View r111 = ViewBindings.findChildViewById(r0, 2131369866);
        if (r111 == null) goto L150;
        RelativeLayout r112 = (RelativeLayout) ViewBindings.findChildViewById(r0, 2131369867);
        if (r112 == null) goto L149;
        LottieAdapterView r113 = ViewBindings.findChildViewById(r0, 2131369868);
        if (r113 == null) goto L148;
        LottieAdapterView r8 = ViewBindings.findChildViewById(r0, 2131369869);
        if (r8 == null) goto L147;
        ImageView r114 = (ImageView) ViewBindings.findChildViewById(r0, 2131369893);
        if (r114 == null) goto L146;
        ImageView r20 = (ImageView) ViewBindings.findChildViewById(r0, 2131369916);
        if (r20 == null) goto L145;
        FrameLayout r21 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131369917);
        if (r21 == null) goto L144;
        View r22 = ViewBindings.findChildViewById(r0, 2131369918);
        if (r22 == null) goto L143;
        DoraTextView r23 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131369920);
        if (r23 == null) goto L142;
        View r24 = ViewBindings.findChildViewById(r0, 2131369921);
        if (r24 == null) goto L141;
        DoraGOnboardingTopicView r25 = (DoraGOnboardingTopicView) ViewBindings.findChildViewById(r0, 2131369922);
        if (r25 == null) goto L140;
        DoraUrlSpanTextView r26 = (DoraUrlSpanTextView) ViewBindings.findChildViewById(r0, 2131369946);
        if (r26 == null) goto L139;
        DoraTextView r27 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131369947);
        if (r27 != null) goto L59;
        r3 = 2131369947;
        goto L162
    L59:
        if (((BottomFadeImageView) ViewBindings.findChildViewById(r0, 2131376574)) != null) goto L61;
        r3 = 2131376574;
        goto L162
    L61:
        if (((BottomFadeImageView) ViewBindings.findChildViewById(r0, 2131376575)) != null) goto L63;
        r3 = 2131376575;
        goto L162
    L63:
        if (ViewBindings.findChildViewById(r0, 2131381167) != null) goto L65;
        r3 = 2131381167;
        goto L162
    L65:
        if (((LinearLayout) ViewBindings.findChildViewById(r0, 2131381168)) != null) goto L67;
        r3 = 2131381168;
        goto L162
    L67:
        if (ViewBindings.findChildViewById(r0, 2131381169) == null) goto L133;
        FrameLayout r28 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131381170);
        if (r28 != null) goto L71;
        r3 = 2131381170;
        goto L162
    L71:
        if (((DoraTextViewWithAnim) ViewBindings.findChildViewById(r0, 2131381171)) == null) goto L131;
        FrameLayout r210 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131381172);
        if (r210 != null) goto L75;
        r3 = 2131381172;
        goto L162
    L75:
        if (ViewBindings.findChildViewById(r0, 2131381173) != null) goto L77;
        r3 = 2131381173;
        goto L162
    L77:
        if (((DoraTextViewWithAnim) ViewBindings.findChildViewById(r0, 2131381174)) == null) goto L128;
        FrameLayout r30 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131381175);
        if (r30 == null) goto L127;
        FrameLayout r31 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131381192);
        if (r31 == null) goto L126;
        FrameLayout r32 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131381193);
        if (r32 != null) goto L85;
        r3 = 2131381193;
        goto L162
    L85:
        if (((LinearLayout) ViewBindings.findChildViewById(r0, 2131381204)) == null) goto L124;
        FrameLayout r33 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131381205);
        if (r33 == null) goto L123;
        FrameLayout r34 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131381206);
        if (r34 == null) goto L122;
        FrameLayout r35 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131381208);
        if (r35 == null) goto L121;
        FrameLayout r36 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131381209);
        if (r36 != null) goto L95;
        r3 = 2131381209;
        goto L162
    L95:
        if (((DoraTextViewWithAnim) ViewBindings.findChildViewById(r0, 2131381231)) == null) goto L119;
        FrameLayout r37 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131381233);
        if (r37 == null) goto L118;
        FrameLayout r38 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131381234);
        if (r38 != null) goto L101;
        r3 = 2131381234;
        goto L162
    L101:
        if (((ObricDoraGOnboardingTopicView) ViewBindings.findChildViewById(r0, 2131381238)) == null) goto L116;
        FrameLayout r310 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131381245);
        if (r310 == null) goto L115;
        FrameLayout r40 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131381276);
        if (r40 != null) goto L107;
        r3 = 2131381276;
        goto L162
    L107:
        if (((DoraTextViewWithAnim) ViewBindings.findChildViewById(r0, 2131391606)) == null) goto L113;
        FrameLayout r41 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131392324);
        if (r41 == null) goto L112;
        ObricDoraGOnboardingFragmentV2Binding r43 = new ObricDoraGOnboardingFragmentV2Binding(r2, r42, r7, r6, r9, r15, r16, r17, r18, r110, r111, r112, r113, r8, r114, r20, r21, r22, r23, r24, r25, r26, r27, r28, r210, r30, r31, r32, r33, r34, r35, r36, r37, r38, r310, r40, r41);
        CircleSimpleDraweeView.f(r42, UriProtector.parse("res://" + AppHost.a.getApplication().getPackageName() + '/' + o2.a.c()), null, null, 0, 0, 62);
        int r47 = com.larus.utils.j0.a;
        r26.setUrlSpannedText(com.larus.utils.j0.d(2131903799));
        r18.setMaxSampleData(0.8d);
        r18.setColor(ColorProtector.parseColor("#00B2FF"));
        r8.setAnimation(2131820620);
        r113.setAnimation(2131820619);
        this.r = r43;
        return r2;
    L112:
        r3 = 2131392324;
        goto L162
    L113:
        r3 = 2131391606;
        goto L162
    L115:
        r3 = 2131381245;
        goto L162
    L116:
        r3 = 2131381238;
        goto L162
    L118:
        r3 = 2131381233;
        goto L162
    L119:
        r3 = 2131381231;
        goto L162
    L121:
        r3 = 2131381208;
        goto L162
    L122:
        r3 = 2131381206;
        goto L162
    L123:
        r3 = 2131381205;
        goto L162
    L124:
        r3 = 2131381204;
        goto L162
    L126:
        r3 = 2131381192;
        goto L162
    L127:
        r3 = 2131381175;
        goto L162
    L128:
        r3 = 2131381174;
        goto L162
    L131:
        r3 = 2131381171;
        goto L162
    L133:
        r3 = 2131381169;
        goto L162
    L139:
        r3 = 2131369946;
        goto L162
    L140:
        r3 = 2131369922;
        goto L162
    L141:
        r3 = 2131369921;
        goto L162
    L142:
        r3 = 2131369920;
        goto L162
    L143:
        r3 = 2131369918;
        goto L162
    L144:
        r3 = 2131369917;
        goto L162
    L145:
        r3 = 2131369916;
        goto L162
    L146:
        r3 = 2131369893;
        goto L162
    L147:
        r3 = 2131369869;
        goto L162
    L148:
        r3 = 2131369868;
        goto L162
    L149:
        r3 = 2131369867;
        goto L162
    L150:
        r3 = 2131369866;
        goto L162
    L151:
        r3 = 2131369865;
        goto L162
    L152:
        r3 = 2131369864;
        goto L162
    L153:
        r3 = 2131369863;
        goto L162
    L154:
        r3 = 2131369862;
        goto L162
    L155:
        r3 = 2131369861;
        goto L162
    L156:
        r3 = 2131369860;
    L158:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r5)));
    L162:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r3)));
    L160:
        r3 = r1;
        goto L162
    }
}
