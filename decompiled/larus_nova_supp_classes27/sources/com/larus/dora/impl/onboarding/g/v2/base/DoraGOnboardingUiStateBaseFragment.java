package com.larus.dora.impl.onboarding.g.v2.base;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
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
import b69.w;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.CustomBarCountAudioVisualizer;
import com.larus.common_ui.widget.CircleSimpleDraweeView;
import com.larus.dora.impl.databinding.LarusDoraGOnboardingBottomBtnLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraGOnboardingFragmentV2Binding;
import com.larus.dora.impl.onboarding.DoraOnboardingDevice;
import com.larus.dora.impl.onboarding.ext.AnimViewType;
import com.larus.dora.impl.onboarding.g.v2.DoraGOnboardingFragmentUiStatePhoto;
import com.larus.dora.impl.onboarding.g.v2.DoraGOnboardingTopicView;
import com.larus.dora.impl.onboarding.g.v2.config.DoraGOnboardingEnvAuthFragment;
import com.larus.dora.impl.onboarding.g.v2.config.DoraGOnboardingKeepAliveFragmentV2;
import com.larus.dora.impl.onboarding.g.v2.config.DoraGOnboardingWiFiSettingsFragment;
import com.larus.dora.impl.onboarding.g.v2.r;
import com.larus.dora.impl.onboarding.g.v2.s;
import com.larus.dora.impl.onboarding.g.v2.t;
import com.larus.dora.impl.onboarding.g.v2.v;
import com.larus.dora.impl.onboarding.g.v2.viewmodel.ActionEvent;
import com.larus.dora.impl.onboarding.g.v2.viewmodel.AvatarUiState;
import com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2;
import com.larus.dora.impl.onboarding.g.v2.viewmodel.a0;
import com.larus.dora.impl.onboarding.m0;
import com.larus.dora.impl.settings.DoraGOnboardingConfig;
import com.larus.dora.impl.settings.DoraGOnboardingQueryTopics;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.impl.view.DoraMovieView;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.dora.impl.view.DoraTextViewWithAnim;
import com.larus.dora.impl.view.DoraUrlSpanTextView;
import com.larus.platform.service.o2;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.lynx.lottieadapter.LottieAdapterView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0013\b&\u0018\u0000 N2\u00020\u0001:\u0001NB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%H\u0004J\u001a\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020)H\u0004J\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0005H\u0004J\u0006\u0010+\u001a\u00020\u001eJ\u0006\u0010,\u001a\u00020\u001eJ\u000e\u0010-\u001a\u00020\u001eH\u0086@¢\u0006\u0002\u0010.J\u0006\u0010/\u001a\u00020\u001eJ\u0018\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000202H\u0016J\u0010\u00104\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020)H\u0016J\u0010\u00105\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020)H\u0016J\u0010\u00106\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020)H\u0016J\u001a\u00107\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020)2\b\b\u0002\u00108\u001a\u00020)H\u0002J\u0010\u00109\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020)H\u0002J\u000e\u0010:\u001a\u00020\u001e2\u0006\u0010;\u001a\u00020<J\u0006\u0010=\u001a\u00020\u001eJ\u0006\u0010>\u001a\u00020\u001eJ\u0006\u0010?\u001a\u00020\u001eJ\u001c\u0010@\u001a\u00020\u001e2\b\u0010A\u001a\u0004\u0018\u00010\r2\b\u0010B\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010C\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020<H\u0002J\f\u0010E\u001a\u00020<*\u00020\rH\u0002J\b\u0010F\u001a\u00020\u001eH\u0016J\b\u0010G\u001a\u00020\u001eH\u0016J\b\u0010H\u001a\u00020\u001eH\u0016J\b\u0010I\u001a\u00020\u001eH\u0016J\b\u0010J\u001a\u00020)H\u0016J\b\u0010K\u001a\u00020)H\u0016J\b\u0010L\u001a\u00020)H\u0016J\b\u0010M\u001a\u00020<H\u0016J\b\u0010!\u001a\u00020\rH&R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006O"}, d2 = {"Lcom/larus/dora/impl/onboarding/g/v2/base/DoraGOnboardingUiStateBaseFragment;", "Lcom/larus/dora/impl/onboarding/g/v2/base/DoraGOnboardingBaseFragmentV2;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraGOnboardingFragmentV2Binding;", "getBinding", "()Lcom/larus/dora/impl/databinding/LarusDoraGOnboardingFragmentV2Binding;", "setBinding", "(Lcom/larus/dora/impl/databinding/LarusDoraGOnboardingFragmentV2Binding;)V", "mainHandler", "Landroid/os/Handler;", "<set-?>", "Lcom/larus/dora/impl/onboarding/g/v2/DoraGOnboardingFragmentBaseUiState;", "mUiState", "getMUiState", "()Lcom/larus/dora/impl/onboarding/g/v2/DoraGOnboardingFragmentBaseUiState;", "setMUiState", "(Lcom/larus/dora/impl/onboarding/g/v2/DoraGOnboardingFragmentBaseUiState;)V", "mUiState$delegate", "Lkotlin/properties/ReadWriteProperty;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "updateUiState", "uiState", "Lcom/larus/dora/impl/onboarding/g/v2/viewmodel/WakeupQueryUiState;", "renderAvatarBubble", "state", "Lcom/larus/dora/impl/onboarding/g/v2/viewmodel/AvatarUiState;", "applyAvatarNormal", "b", "withAnim", "", "applyAvatarLittle", "gotoNext", "gotoDone", "gotoReply", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gotoFirst", "onKeyState", "event", "", "pos", "onWearState", "onLinkState", "onCallState", "checkWearState", "isNeedDelay", "checkLinkState", "showHangupDueCallEnterToast", "text", "", "showCallSkipGuideDialog", "tryCancelCallSkipGuideDialog", "jumpConfig", "onUiStateChanged", "oldUiState", "newUiState", "onClick", "action", "toBuryPointType", "onStart", "onStop", "onDestroyView", "onSkipButtonClicked", "autoLogEnterPage", "autoLogExitPage", "autoLogShipButton", "getCurrentPageName", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DoraGOnboardingUiStateBaseFragment extends DoraGOnboardingBaseFragmentV2 {
    public static final /* synthetic */ KProperty<Object>[] v = null;
    public LarusDoraGOnboardingFragmentV2Binding s;
    public final Handler t;
    public final g u;

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
        public final /* synthetic */ DoraGOnboardingUiStateBaseFragment a;

        public c(DoraGOnboardingUiStateBaseFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r4, Continuation r5) {
            a0 r6 = (a0) r4;
            StringBuilder r7 = new StringBuilder("ui state: ");
            r7.append(this.a.ma0());
            r7.append(", ");
            com.larus.dora.impl.onboarding.g.v2.f r0 = this.a.ma0();
            if (r0 == null) goto L5;
            Boolean r1 = Boxing.boxBoolean(r0.f());
        L6:
            r7.append(r1);
            g49.d.d("DoraGOnboardingUiStateBaseFragment", r7.toString());
            com.larus.dora.impl.onboarding.g.v2.f r8 = this.a.ma0();
            if (r8 == null) goto L11;
            boolean r2 = true;
            if (r8.f() != true) goto L11;
        L12:
            if (r2 == false) goto L64;
            DoraGOnboardingUiStateBaseFragment r9 = this.a;
            LarusDoraGOnboardingFragmentV2Binding r3 = r9.s;
            if (r3 == null) goto L64;
            r9.t.removeCallbacksAndMessages(null);
            if ((r6 instanceof a0.d) == false) goto L19;
            e1.x(r3.c);
            e1.x(r3.b);
            DoraGOnboardingUiStateBaseFragment.ja0(r9, r3);
            AppCompatTextView r10 = r3.w;
            Intrinsics.checkNotNull(r10);
            e1.x(r10);
            r10.setText(r9.fa0(2131902819));
            AppCompatTextView r11 = r3.v;
            Intrinsics.checkNotNull(r11);
            e1.x(r11);
            r11.setText(r9.fa0(2131902820));
            e1.o(r3.s);
            e1.o(r3.u);
            e1.o(r3.t);
            e1.o(r3.q);
            e1.o(r3.e);
            goto L64
        L19:
            if ((r6 instanceof a0.e) == false) goto L44;
            Intrinsics.checkNotNullParameter(r3, "b");
            w.k(r3.b, AnimViewType.AVATAR);
            RelativeLayout r12 = r3.l;
            AnimViewType r13 = AnimViewType.BUBBLE;
            w.k(r12, r13);
            w.k(r3.m, r13);
            w.k(r3.j, AnimViewType.BUBBLE_BACKGROUND);
            e1.o(r3.w);
            e1.o(r3.v);
            AppCompatTextView r14 = r3.s;
            r14.setText(r9.fa0(2131902776));
            Intrinsics.checkNotNull(r14);
            w.a(r14);
            DoraGOnboardingTopicView r15 = r3.u;
            if ((r9.ma0() instanceof s) == false) goto L32;
            DoraSetting.a.getClass();
            DoraGOnboardingConfig r16 = DoraSetting.c();
            if (r16 == null) goto L32;
            DoraGOnboardingQueryTopics r17 = r16.getQueryTopic();
            if (r17 == null) goto L32;
            List<String> r18 = r17.getAiLiveScene();
            if (r18 == null) goto L32;
            List<String> r20 = CollectionsKt.filterNotNull(r18);
            if (r20 == null) goto L32;
            r15.setTopicList(r20);
        L32:
            if ((r9.ma0() instanceof com.larus.dora.impl.onboarding.g.v2.m) == false) goto L42;
            DoraSetting.a.getClass();
            DoraGOnboardingConfig r21 = DoraSetting.c();
            if (r21 == null) goto L42;
            DoraGOnboardingQueryTopics r22 = r21.getQueryTopic();
            if (r22 == null) goto L42;
            List<String> r23 = r22.getAiLiveScene();
            if (r23 == null) goto L42;
            List<String> r24 = CollectionsKt.filterNotNull(r23);
            if (r24 == null) goto L42;
            r15.setTopicList(r24);
        L42:
            Intrinsics.checkNotNull(r15);
            w.a(r15);
            e1.x(r3.t);
            goto L64
        L44:
            if ((r6 instanceof a0.b) == true) goto L64;
            if ((r6 instanceof a0.c) == false) goto L49;
            e1.o(r3.q);
            e1.o(r3.e);
            e1.x(r3.c);
            e1.x(r3.b);
            DoraGOnboardingUiStateBaseFragment.ja0(r9, r3);
            e1.o(r3.s);
            e1.o(r3.u);
            e1.o(r3.t);
            AppCompatTextView r25 = r3.w;
            int r26 = j0.a;
            r25.setText(j0.d(2131902817));
            Intrinsics.checkNotNull(r25);
            w.a(r25);
            e1.o(r3.v);
            goto L64
        L49:
            if ((r6 instanceof a0.a) == false) goto L62;
            a0.a r27 = (a0.a) r6;
            if (r27.getType() != 0) goto L53;
        L56:
            e1.x(r3.c);
            e1.x(r3.b);
            AppCompatTextView r28 = r3.w;
            Intrinsics.checkNotNull(r28);
            e1.x(r28);
            if ((r9.ma0() instanceof s) == false) goto L59;
            CharSequence r30 = r9.fa0(2131902814);
        L60:
            r28.setText(r30);
            e1.o(r3.q);
            e1.o(r3.f);
            e1.o(r3.g);
            goto L64
        L59:
            r30 = r9.ia0();
            goto L60
        L53:
            if (r27.b == null) goto L56;
            e1.o(r3.c);
            e1.o(r3.b);
            e1.o(r3.w);
            e1.o(r3.v);
            LinearLayout r31 = r3.e;
            e1.o(r3.n);
            Intrinsics.checkNotNull(r31);
            e1.x(r31);
            AppCompatTextView r32 = r3.f;
            Intrinsics.checkNotNull(r32);
            e1.x(r32);
            r32.setText(r9.ia0());
            e1.o(r3.g);
            FrameLayout r33 = r3.q;
            Intrinsics.checkNotNull(r33);
            w.o(r33);
            r3.p.setImageBitmap(r27.b);
            goto L64
        L62:
            throw new NoWhenBranchMatchedException();
        L64:
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
        public final /* synthetic */ DoraGOnboardingUiStateBaseFragment a;

        public d(DoraGOnboardingUiStateBaseFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            byte[] r4 = (byte[]) r2;
            com.larus.dora.impl.onboarding.g.v2.f r5 = this.a.ma0();
            if (r5 == null) goto L7;
            boolean r0 = true;
            if (r5.f() != true) goto L7;
        L8:
            if (r0 == false) goto L15;
            LarusDoraGOnboardingFragmentV2Binding r6 = this.a.s;
            if (r6 == null) goto L15;
            CustomBarCountAudioVisualizer r7 = r6.i;
            if (r7 == null) goto L15;
            r7.post(new o(r7, r4));
        L15:
            return Unit.INSTANCE;
        L7:
            r0 = false;
            goto L8
        }
    }

    public static final class e<T> implements FlowCollector {
        public final /* synthetic */ DoraGOnboardingUiStateBaseFragment a;

        public e(DoraGOnboardingUiStateBaseFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            AvatarUiState r7 = (AvatarUiState) r5;
            com.larus.dora.impl.onboarding.g.v2.f r8 = this.a.ma0();
            if (r8 != null) goto L5;
        L7:
            boolean r9 = false;
        L8:
            if (r9 == false) goto L23;
            DoraGOnboardingUiStateBaseFragment r10 = this.a;
            r10.getClass();
            Intrinsics.checkNotNullParameter(r7, "state");
            LarusDoraGOnboardingFragmentV2Binding r2 = r10.s;
            if (r2 == null) goto L23;
            int r11 = b.a[r7.ordinal()];
            if (r11 != 1) goto L15;
            e1.q(r2.m);
            e1.q(r2.l);
            e1.q(r2.j);
            r2.i.c(false);
            goto L23
        L15:
            if (r11 != 2) goto L17;
            DoraGOnboardingUiStateBaseFragment.ja0(r10, r2);
            r2.m.playAnimation();
            e1.q(r2.l);
            e1.x(r2.m);
            e1.x(r2.j);
            r2.i.c(false);
            goto L23
        L17:
            if (r11 != 3) goto L23;
            e1.q(r2.m);
            e1.x(r2.l);
            e1.x(r2.j);
            r2.i.c(true);
        L23:
            return Unit.INSTANCE;
        L5:
            if (r8.f() != true) goto L7;
            r9 = true;
            goto L8
        }
    }

    public static final class f<T> implements FlowCollector {
        public final /* synthetic */ DoraGOnboardingUiStateBaseFragment a;

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

        public f(DoraGOnboardingUiStateBaseFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r9, Continuation r10) {
            com.larus.dora.impl.onboarding.g.v2.viewmodel.a r11 = (com.larus.dora.impl.onboarding.g.v2.viewmodel.a) r9;
            if ((r11 instanceof com.larus.dora.impl.onboarding.g.v2.viewmodel.a.C0088a) == false) goto L5;
            com.larus.dora.impl.onboarding.g.v2.viewmodel.a.C0088a r12 = (com.larus.dora.impl.onboarding.g.v2.viewmodel.a.C0088a) r11;
        L6:
            if (r12 == null) goto L8;
            ActionEvent r13 = r12.a;
        L9:
            if (r13 != null) goto L11;
            int r14 = -1;
        L13:
            if (r14 != 1) goto L15;
            String r15 = this.a.fa0(2131902786);
            if ((this.a.ma0() instanceof com.larus.dora.impl.onboarding.g.v2.m) == false) goto L28;
            r15 = this.a.fa0(2131902784);
        L28:
            DoraGOnboardingUiStateBaseFragment r16 = this.a;
            r16.getClass();
            Intrinsics.checkNotNullParameter(r15, "text");
            t19.s r0 = t19.s.a;
            Context r17 = r16.getContext();
            r0.getClass();
            t19.s.c(r17, r15);
        L30:
            return Unit.INSTANCE;
        L15:
            if (r14 != 2) goto L30;
            DoraGOnboardingUiStateBaseFragment r18 = this.a;
            boolean r1 = ((Boolean) r18.ga0().getDeviceCallStateFlow().getValue()).booleanValue();
            Job r2 = r18.q;
            if (r2 == null) goto L20;
            Job.DefaultImpls.cancel$default(r2, null, 1, null);
        L20:
            if (r1 == true) goto L22;
        L24:
            r18.ea0();
            r18.la0(r18.da0(), true);
            r18.ka0(r18.ca0());
            goto L30
        L22:
            if ((r18.ma0() instanceof r) == false) goto L24;
            r18.q = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r18), null, null, new DoraGOnboardingUiStateBaseFragment$showCallSkipGuideDialog$1(r18, null), 3, null);
            goto L30
        L11:
            r14 = a.a[r13.ordinal()];
            goto L13
        L8:
            r13 = null;
            goto L9
        L5:
            r12 = null;
            goto L6
        }
    }

    public static final class g extends ObservableProperty<com.larus.dora.impl.onboarding.g.v2.f> {
        public final /* synthetic */ DoraGOnboardingUiStateBaseFragment a;

        public g(DoraGOnboardingUiStateBaseFragment r1) {
            this.a = r1;
            super(null);
        }

        public final void afterChange(KProperty<?> r5, com.larus.dora.impl.onboarding.g.v2.f r6, com.larus.dora.impl.onboarding.g.v2.f r7) {
            Intrinsics.checkNotNullParameter(r5, "property");
            com.larus.dora.impl.onboarding.g.v2.f r8 = r7;
            com.larus.dora.impl.onboarding.g.v2.f r9 = r6;
            DoraGOnboardingUiStateBaseFragment r10 = this.a;
            KProperty<Object>[] r0 = DoraGOnboardingUiStateBaseFragment.v;
            r10.getClass();
            if (r9 == null) goto L5;
            int r11 = m0.a;
            m0.c(DoraGOnboardingUiStateBaseFragment.qa0(r9), SystemClock.elapsedRealtime() - r9.d);
        L5:
            if (r8 == null) goto L9;
            int r12 = m0.a;
            m0.b(DoraGOnboardingUiStateBaseFragment.qa0(r8));
            return;
        }
    }

    static {
        v = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(DoraGOnboardingUiStateBaseFragment.class, "mUiState", "getMUiState()Lcom/larus/dora/impl/onboarding/g/v2/DoraGOnboardingFragmentBaseUiState;", 0))};
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

    public abstract v ra0();

    public final com.larus.dora.impl.onboarding.g.v2.f ma0() {
        return (com.larus.dora.impl.onboarding.g.v2.f) this.u.getValue(this, v[0]);
    }

    public DoraGOnboardingUiStateBaseFragment() {
        this.t = new Handler(Looper.getMainLooper());
        Delegates r0 = Delegates.INSTANCE;
        this.u = new g(this);
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingBaseFragmentV2, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void aa0() {
        super.aa0();
        oa0("click_skip");
        na0();
    }

    public final void na0() {
        DoraOnboardingDevice r0 = ga0().getDoraOnboardingDevice();
        if (r0 == null) goto L5;
        String r1 = r0.b;
    L7:
        if (r1 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L16;
        return;
    L16:
        if (ga0().isEnvAuth() == true) goto L20;
        DoraGOnboardingEnvAuthFragment r4 = new DoraGOnboardingEnvAuthFragment();
        r4.setArguments(com.larus.utils.f.c(new Pair[]{TuplesKt.to("mac", r1)}));
        Z90(r4);
        return;
    L20:
        if (ca0() == true) goto L22;
    L24:
        boolean r5 = false;
    L25:
        if (r5 == false) goto L29;
        DoraGOnboardingWiFiSettingsFragment r6 = new DoraGOnboardingWiFiSettingsFragment();
        r6.setArguments(com.larus.utils.f.c(new Pair[]{TuplesKt.to("mac", r1)}));
        Z90(r6);
        return;
    L29:
        if (ca0() == false) goto L32;
        DoraGOnboardingKeepAliveFragmentV2 r7 = new DoraGOnboardingKeepAliveFragmentV2();
        r7.setArguments(com.larus.utils.f.c(new Pair[]{TuplesKt.to("mac", r1)}));
        Z90(r7);
        return;
    L32:
        W90(r1);
        return;
    L22:
        if (ga0().hasConfigWiFi() == true) goto L24;
        r5 = true;
        goto L25
    L9:
        if (r1.length() == 0) goto L12;
        r3 = false;
        goto L13
    L5:
        r1 = null;
        goto L7
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.t.removeCallbacksAndMessages(null);
        com.larus.dora.impl.onboarding.d.c(null);
        this.s = null;
    }

    public final void onStart() {
        super.onStart();
        ga0().onStart();
    }

    public final void onStop() {
        super.onStop();
        ga0().onStop();
    }

    public static String qa0(com.larus.dora.impl.onboarding.g.v2.f r1) {
        if ((r1 instanceof v) == false) goto L6;
        return "introduction_page";
    L6:
        if ((r1 instanceof t) == false) goto L9;
        return "teaching";
    L9:
        if ((r1 instanceof DoraGOnboardingFragmentUiStatePhoto) == false) goto L12;
        return "press_side_button_shutter";
    L12:
        if ((r1 instanceof r) == false) goto L15;
        return "longpress_side_button";
    L15:
        if ((r1 instanceof s) == false) goto L18;
        return "video_wakeup_guidance";
    L18:
        if ((r1 instanceof com.larus.dora.impl.onboarding.g.v2.m) == false) goto L30;
        DoraGOnboardingViewModelV2 r2 = r1.c;
        if (r2 == null) goto L24;
        i1<a0> r3 = r2.getWakeupQueryUiStateFlow();
        if (r3 == null) goto L24;
        a0 r4 = (a0) r3.getValue();
    L26:
        if (Intrinsics.areEqual(r4, a0.d.a) == false) goto L28;
        return "first_conversation_guidance";
    L28:
        return "voice_wakeup_guidance";
    L24:
        r4 = null;
        goto L26
    L30:
        if ((r1 instanceof com.larus.dora.impl.onboarding.g.v2.l) == false) goto L33;
        return "media_control";
    L33:
        if ((r1 instanceof com.larus.dora.impl.onboarding.g.v2.i) == false) goto L35;
        return "complete_guidance";
    L35:
        return "";
    }

    @Override // e69.a
    public final void S30(boolean r3) {
        if (r3 == true) goto L8;
        Job r4 = this.q;
        if (r4 == null) goto L6;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L6:
        ea0();
        la0(da0(), true);
        ka0(ca0());
        return;
    }

    @Override // e69.a
    public final void bO(boolean r2) {
        com.larus.dora.impl.onboarding.g.v2.f r0 = ma0();
        if (r0 == null) goto L5;
        r0.h(r2);
    L5:
        la0(da0(), true);
        ka0(ca0());
    }

    @Override // e69.a
    public final void jL(boolean r2) {
        ka0(ca0());
        la0(da0(), false);
    }

    public final void ka0(boolean r10) {
        Job r0 = this.o;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        if (r10 == true) goto L7;
        this.o = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraGOnboardingUiStateBaseFragment$checkLinkState$1(this, null), 3, null);
        return;
    L7:
        ea0();
    }

    public final void oa0(String r3) {
        com.larus.dora.impl.onboarding.g.v2.f r0 = ma0();
        if (r0 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r3, "click_try_later") == true) goto L7;
    L12:
        int r1 = m0.a;
        m0.a(r3, qa0(r0));
        return;
    L7:
        if ((ma0() instanceof v) == false) goto L10;
        r3 = "start_new_ai_experience";
    L10:
        if ((ma0() instanceof com.larus.dora.impl.onboarding.g.v2.i) == false) goto L12;
        r3 = "click_complete_guidance";
        goto L12
    }

    public final void pa0(com.larus.dora.impl.onboarding.g.v2.f r4) {
        this.u.setValue(this, v[0], r4);
    }

    public static void ja0(DoraGOnboardingUiStateBaseFragment r4, LarusDoraGOnboardingFragmentV2Binding r5) {
        Intrinsics.checkNotNullParameter(r5, "b");
        boolean r0 = true;
        w.l(r5.b, true, 2);
        ImageView r6 = r5.j;
        if (r6.getVisibility() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        boolean r3 = true;
    L9:
        w.l(r6, r3, 2);
        RelativeLayout r7 = r5.l;
        if (r7.getVisibility() != 0) goto L12;
        boolean r8 = true;
    L13:
        if (r8 == false) goto L15;
        boolean r9 = true;
    L16:
        w.l(r7, r9, 2);
        LottieAdapterView r10 = r5.m;
        if (r10.getVisibility() != 0) goto L19;
        boolean r11 = true;
    L20:
        if (r11 == true) goto L23;
        r0 = false;
    L23:
        w.l(r10, r0, 2);
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
    public final void Ir(int r2, int r3) {
        com.larus.dora.impl.onboarding.g.v2.f r0 = ma0();
        if (r0 == null) goto L6;
        r0.e(r2, r3);
        return;
    }

    public final void la0(boolean r10, boolean r11) {
        Job r0 = this.p;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        if (r10 == true) goto L7;
        this.p = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraGOnboardingUiStateBaseFragment$checkWearState$1(r11, this, null), 3, null);
        return;
    L7:
        ea0();
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingBaseFragmentV2, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super.onViewCreated(r14, r15);
        LarusDoraGOnboardingFragmentV2Binding r16 = this.s;
        if (r16 == null) goto L6;
        v r17 = ra0();
        r17.b();
        pa0(r17);
        LarusDoraGOnboardingBottomBtnLayoutBinding r18 = r16.d;
        e1.d(r18.d, new k(this));
        e1.d(r18.b, new l(this));
        Lifecycle.State r110 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGOnboardingUiStateBaseFragment$onViewCreated$lambda$15$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r110, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGOnboardingUiStateBaseFragment$onViewCreated$lambda$15$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r110, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGOnboardingUiStateBaseFragment$onViewCreated$lambda$15$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r110, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGOnboardingUiStateBaseFragment$onViewCreated$lambda$15$$inlined$launchAndRepeatWithViewLifecycle$default$4(this, r110, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGOnboardingUiStateBaseFragment$onViewCreated$lambda$15$$inlined$launchAndRepeatWithViewLifecycle$default$5(this, r110, null, this), 3, null);
        return;
    }

    public final View onCreateView(LayoutInflater r32, ViewGroup r33, Bundle r34) {
        Intrinsics.checkNotNullParameter(r32, "inflater");
        ConstraintLayout r0 = r32.inflate(2131562197, r33, false);
        ConstraintLayout r1 = r0;
        int r3 = 2131369852;
        CircleSimpleDraweeView r28 = (CircleSimpleDraweeView) ViewBindings.findChildViewById(r0, 2131369852);
        if (r28 == null) goto L59;
        r3 = 2131369853;
        View r6 = ViewBindings.findChildViewById(r0, 2131369853);
        if (r6 == null) goto L59;
        r3 = 2131369858;
        View r4 = ViewBindings.findChildViewById(r0, 2131369858);
        if (r4 == null) goto L59;
        LarusDoraGOnboardingBottomBtnLayoutBinding r7 = LarusDoraGOnboardingBottomBtnLayoutBinding.a(r4);
        r3 = 2131369860;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131369860);
        if (r8 == null) goto L59;
        r3 = 2131369861;
        DoraTextViewWithAnim r9 = (DoraTextViewWithAnim) ViewBindings.findChildViewById(r0, 2131369861);
        if (r9 == null) goto L59;
        r3 = 2131369862;
        DoraTextView r10 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131369862);
        if (r10 == null) goto L59;
        r3 = 2131369863;
        View r11 = ViewBindings.findChildViewById(r0, 2131369863);
        if (r11 == null) goto L59;
        r3 = 2131369864;
        CustomBarCountAudioVisualizer r15 = (CustomBarCountAudioVisualizer) ViewBindings.findChildViewById(r0, 2131369864);
        if (r15 == null) goto L59;
        r3 = 2131369865;
        ImageView r13 = (ImageView) ViewBindings.findChildViewById(r0, 2131369865);
        if (r13 == null) goto L59;
        r3 = 2131369866;
        View r14 = ViewBindings.findChildViewById(r0, 2131369866);
        if (r14 == null) goto L59;
        r3 = 2131369867;
        RelativeLayout r16 = (RelativeLayout) ViewBindings.findChildViewById(r0, 2131369867);
        if (r16 == null) goto L59;
        r3 = 2131369868;
        LottieAdapterView r12 = ViewBindings.findChildViewById(r0, 2131369868);
        if (r12 == null) goto L59;
        r3 = 2131369869;
        LottieAdapterView r5 = ViewBindings.findChildViewById(r0, 2131369869);
        if (r5 == null) goto L59;
        r3 = 2131369893;
        ImageView r18 = (ImageView) ViewBindings.findChildViewById(r0, 2131369893);
        if (r18 == null) goto L59;
        r3 = 2131369913;
        DoraMovieView r17 = (DoraMovieView) ViewBindings.findChildViewById(r0, 2131369913);
        if (r17 == null) goto L59;
        r3 = 2131369916;
        ImageView r20 = (ImageView) ViewBindings.findChildViewById(r0, 2131369916);
        if (r20 == null) goto L59;
        r3 = 2131369917;
        FrameLayout r21 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131369917);
        if (r21 == null) goto L59;
        r3 = 2131369918;
        View r22 = ViewBindings.findChildViewById(r0, 2131369918);
        if (r22 == null) goto L59;
        r3 = 2131369920;
        DoraTextView r23 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131369920);
        if (r23 == null) goto L59;
        r3 = 2131369921;
        View r24 = ViewBindings.findChildViewById(r0, 2131369921);
        if (r24 == null) goto L59;
        r3 = 2131369922;
        DoraGOnboardingTopicView r25 = (DoraGOnboardingTopicView) ViewBindings.findChildViewById(r0, 2131369922);
        if (r25 == null) goto L59;
        r3 = 2131369946;
        DoraUrlSpanTextView r2 = (DoraUrlSpanTextView) ViewBindings.findChildViewById(r0, 2131369946);
        if (r2 == null) goto L59;
        r3 = 2131369947;
        DoraTextView r27 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131369947);
        if (r27 == null) goto L59;
        LarusDoraGOnboardingFragmentV2Binding r26 = new LarusDoraGOnboardingFragmentV2Binding(r1, r28, r6, r7, r8, r9, r10, r11, r15, r13, r14, r16, r12, r5, r18, r17, r20, r21, r22, r23, r24, r25, r2, r27);
        Context r30 = r1.getContext();
        Intrinsics.checkNotNullParameter(r30, "<this>");
        Resources r31 = r30.getResources();
        DisplayMetrics r35 = WindowDisplayMetricsOverride.apply(r31, r31.getDisplayMetrics());
        if (r35 == null) goto L51;
        int r36 = r35.widthPixels;
    L52:
        int r37 = Math.min(r36, ((Number) i5.Y1.getValue()).intValue());
        int r38 = (int) (r37 * 2.3333333f);
        ViewGroup.LayoutParams r40 = r17.getLayoutParams();
        if (r40 == null) goto L57;
        r40.width = r37;
        r40.height = r38;
        r17.setLayoutParams(r40);
        CircleSimpleDraweeView.f(r28, UriProtector.parse("res://" + AppHost.a.getApplication().getPackageName() + '/' + o2.a.c()), null, null, 0, 0, 62);
        int r41 = j0.a;
        r2.setUrlSpannedText(j0.d(2131903799));
        r15.setMaxSampleData(0.8d);
        r15.setColor(ColorProtector.parseColor("#00B2FF"));
        r5.setAnimation(2131820620);
        r12.setAnimation(2131820619);
        this.s = r26;
        return r1;
    L57:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L51:
        r36 = 0;
    L59:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r3)));
    }
}
