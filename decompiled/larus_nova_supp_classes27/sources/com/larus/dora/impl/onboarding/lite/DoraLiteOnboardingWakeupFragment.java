package com.larus.dora.impl.onboarding.lite;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.common.baidunavi.api.bean.consts.BaiduNaviStatus;
import com.larus.common_ui.view.CustomBarCountAudioVisualizer;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.databinding.LarusDoraOnboardingMusicPanelBinding;
import com.larus.dora.impl.databinding.LarusDoraOnboardingV2WakeupBinding;
import com.larus.dora.impl.onboarding.DoraOnboardingNestedScrollView;
import com.larus.dora.impl.onboarding.ext.AnimViewType;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.dora.impl.settings.f1;
import com.larus.dora.impl.view.DoraUrlSpanTextView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import com.lynx.lottieadapter.LottieAdapterView;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020\nH\u0016J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\nH\u0002J\u0018\u0010%\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingWakeupFragment;", "Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraOnboardingV2WakeupBinding;", "currentUiState", "Lcom/larus/dora/impl/onboarding/lite/WakeupQueryUiState;", "enterPageTracedMap", "", "", "", "mainHandler", "Landroid/os/Handler;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupAvatar", "onDestroyView", "onSkipButtonClicked", "updateUiState", "uiState", "gotoNextStep", "autoLogEnterPage", "", "autoLogExitPage", "getCurrentPageName", "reportPageShow", "page", "reportPageStay", "nextPage", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraLiteOnboardingWakeupFragment extends DoraLiteOnboardingBaseFragment {
    public static final /* synthetic */ int s = 0;
    public LarusDoraOnboardingV2WakeupBinding o;
    public y0 p;
    public final Map<String, Long> q;
    public final Handler r;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ DoraLiteOnboardingWakeupFragment a;

        public a(DoraLiteOnboardingWakeupFragment r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r13v8, types: [android.view.View, com.larus.dora.impl.view.DoraUrlSpanTextView, java.lang.Object] */
        public final Object emit(Object r13, Continuation r14) {
            y0 r15 = (y0) r13;
            final DoraLiteOnboardingWakeupFragment r16 = this.a;
            final LarusDoraOnboardingV2WakeupBinding r0 = r16.o;
            if (r0 == null) goto L125;
            r16.r.removeCallbacksAndMessages(null);
            String r1 = r15.a;
            boolean r4 = true;
            if (r1.length() <= 0) goto L7;
            boolean r3 = true;
        L8:
            if (r3 == false) goto L21;
            Map<String, Long> r5 = r16.q;
            if (r5.isEmpty() == true) goto L18;
            Iterator r6 = ((LinkedHashMap) r5).entrySet().iterator();
        L14:
            if (r6.hasNext() == false) goto L18;
            if (Intrinsics.areEqual(((Map.Entry) r6.next()).getKey(), r1) == false) goto L14;
            boolean r7 = false;
        L19:
            if (r7 == false) goto L21;
            r16.q.put(r1, Long.valueOf(SystemClock.elapsedRealtime()));
            int r8 = com.larus.dora.impl.onboarding.m0.a;
            com.larus.dora.impl.onboarding.m0.g(r1, r16.g, null);
        L18:
            r7 = true;
        L21:
            r16.fa0(r16.p.a, r15.a);
            boolean r2 = !Intrinsics.areEqual(r16.p, r15);
            r16.p = r15;
            DoraOnboardingNestedScrollView r9 = r0.a;
            boolean r10 = r15 instanceof y0.g;
            if (r10 == false) goto L24;
        L29:
            boolean r11 = true;
        L30:
            r9.setScrollEnabled(r11);
            if (r2 == false) goto L33;
            r0.a.post(new i0(r0));
        L33:
            long r12 = DoraObricDeviceHomeViewModel.SCAN_TIMEOUT_MS;
            if (r10 == false) goto L42;
            b69.w.l(r0.b, false, 2);
            b69.w.l(r0.f, false, 2);
            b69.w.l(r0.h, false, 2);
            b69.w.l(r0.j, false, 2);
            e1.x(r0.o);
            r0.o.setText(f69.b.a(r15));
            e1.x(r0.n);
            e1.o(r0.l);
            e1.o(r0.m);
            b69.w.i(r0.k);
            TextView r17 = r16.h;
            if (r17 == null) goto L38;
            r17.setText(2131902345);
            e1.d(r17, new j0(r16));
        L38:
            Handler r18 = r16.r;
            if (((y0.g) r15).b == false) goto L41;
            r12 = 3000;
        L41:
            r18.postDelayed(new r0(r16), r12);
            goto L125
        L42:
            y0.e r20 = y0.e.b;
            if (Intrinsics.areEqual(r15, r20) == false) goto L45;
        L103:
            b69.w.k(r0.b, AnimViewType.AVATAR);
            RelativeLayout r21 = r0.h;
            AnimViewType r22 = AnimViewType.BUBBLE;
            b69.w.k(r21, r22);
            b69.w.k(r0.j, r22);
            b69.w.k(r0.f, AnimViewType.BUBBLE_BACKGROUND);
            e1.o(r0.o);
            e1.o(r0.n);
            if (Intrinsics.areEqual(r15, r20) == false) goto L106;
            b69.w.m(r0.k);
        L107:
            AppCompatTextView r23 = r0.l;
            r23.setText(f69.b.a(r15));
            Intrinsics.checkNotNull(r23);
            b69.w.a(r23);
            b69.w.a(r0.m);
            if (r2 == false) goto L113;
            TextView r24 = r16.h;
            if (r24 == null) goto L113;
            e1.o(r24);
        L113:
            if (Intrinsics.areEqual(r15, r20) == false) goto L116;
            r16.r.postDelayed(new s0(r16), 3000);
            goto L125
        L116:
            if ((r15 instanceof y0.d) == false) goto L125;
            TextView r25 = r16.h;
            if (r25 == null) goto L120;
            r25.setText(2131902345);
            e1.d(r25, new k0(r16));
        L120:
            Handler r26 = r16.r;
            if (((y0.d) r15).b == false) goto L123;
            r12 = 3000;
        L123:
            r26.postDelayed(new t0(r16), r12);
            goto L125
        L106:
            b69.w.i(r0.k);
            goto L107
        L45:
            if ((r15 instanceof y0.d) == true) goto L103;
            if ((r15 instanceof y0.b) == false) goto L72;
            b69.w.l(r0.b, false, 3);
            ImageView r27 = r0.f;
            if (r27.getVisibility() != 0) goto L52;
            boolean r28 = true;
        L53:
            b69.w.l(r27, r28, 2);
            RelativeLayout r30 = r0.h;
            if (r30.getVisibility() != 0) goto L56;
            boolean r31 = true;
        L57:
            b69.w.l(r30, r31, 2);
            LottieAdapterView r32 = r0.j;
            if (r32.getVisibility() == 0) goto L61;
            r4 = false;
        L61:
            b69.w.l(r32, r4, 2);
            e1.o(r0.m);
            e1.o(r0.l);
            e1.o(r0.o);
            e1.o(r0.n);
            b69.w.n(r0.k, ((y0.b) r15).b);
            TextView r110 = r16.h;
            if (r110 == null) goto L64;
            r110.setText(2131902338);
            e1.d(r110, new l0(r16));
        L64:
            if (r2 == false) goto L69;
            TextView r111 = r16.h;
            if (r111 == null) goto L68;
            e1.o(r111);
        L68:
            r16.r.postDelayed(new u0(r16), 2000);
            goto L125
        L69:
            TextView r112 = r16.h;
            if (r112 == null) goto L125;
            e1.x(r112);
            goto L125
        L56:
            r31 = false;
            goto L57
        L52:
            r28 = false;
            goto L53
        L72:
            y0.c r33 = y0.c.b;
            if (Intrinsics.areEqual(r15, r33) == false) goto L75;
        L84:
            b69.w.l(r0.b, false, 3);
            ImageView r34 = r0.f;
            if (r34.getVisibility() != 0) goto L87;
            boolean r35 = true;
        L88:
            b69.w.l(r34, r35, 2);
            RelativeLayout r36 = r0.h;
            if (r36.getVisibility() != 0) goto L91;
            boolean r37 = true;
        L92:
            b69.w.l(r36, r37, 2);
            LottieAdapterView r38 = r0.j;
            if (r38.getVisibility() == 0) goto L96;
            r4 = false;
        L96:
            b69.w.l(r38, r4, 2);
            e1.o(r0.m);
            e1.o(r0.l);
            if (Intrinsics.areEqual(r15, r33) == false) goto L99;
            b69.w.b(r0.k);
        L100:
            AppCompatTextView r40 = r0.o;
            r40.setText(f69.b.a(r15));
            Intrinsics.checkNotNull(r40);
            b69.w.a(r40);
            ?? r113 = r0.n;
            int r41 = com.larus.utils.j0.a;
            r113.setUrlSpannedText(com.larus.utils.j0.d(2131903762));
            Intrinsics.checkNotNull(r113);
            b69.w.a(r113);
            TextView r114 = r16.h;
            if (r114 == null) goto L125;
            r114.setText(2131902338);
            e1.x(r114);
            e1.d(r114, new m0(r16));
            goto L125
        L99:
            b69.w.i(r0.k);
            goto L100
        L91:
            r37 = false;
            goto L92
        L87:
            r35 = false;
            goto L88
        L75:
            if (Intrinsics.areEqual(r15, y0.a.b) == true) goto L84;
            if (Intrinsics.areEqual(r15, y0.f.b) == false) goto L83;
            b69.w.k(r0.b, AnimViewType.AVATAR);
            RelativeLayout r42 = r0.h;
            AnimViewType r43 = AnimViewType.BUBBLE;
            b69.w.k(r42, r43);
            b69.w.k(r0.j, r43);
            b69.w.k(r0.f, AnimViewType.BUBBLE_BACKGROUND);
            e1.o(r0.o);
            e1.o(r0.n);
            b69.w.i(r0.k);
            b69.w.a(r0.m);
            AppCompatTextView r44 = r0.l;
            r44.setText(f69.b.a(r15));
            Intrinsics.checkNotNull(r44);
            b69.w.a(r44);
            TextView r115 = r16.h;
            if (r115 == null) goto L125;
            r115.setText(2131902338);
            e1.x(r115);
            e1.d(r115, new n0(r16));
            goto L125
        L83:
            throw new NoWhenBranchMatchedException();
        L24:
            if (Intrinsics.areEqual(r15, y0.c.b) == true) goto L29;
            if (Intrinsics.areEqual(r15, y0.a.b) == true) goto L29;
            r11 = false;
            goto L30
        L7:
            r3 = false;
        L125:
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ DoraLiteOnboardingWakeupFragment a;

        public b(DoraLiteOnboardingWakeupFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            byte[] r4 = (byte[]) r2;
            LarusDoraOnboardingV2WakeupBinding r5 = this.a.o;
            if (r5 == null) goto L8;
            CustomBarCountAudioVisualizer r6 = r5.e;
            if (r6 == null) goto L8;
            r6.post(new o0(r6, r4));
        L8:
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements FlowCollector {
        public final /* synthetic */ DoraLiteOnboardingWakeupFragment a;

        public /* synthetic */ class a {
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

        public c(DoraLiteOnboardingWakeupFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            int r3 = a.a[((AvatarUiState) r1).ordinal()];
            if (r3 != 1) goto L5;
            LarusDoraOnboardingV2WakeupBinding r4 = this.a.o;
            if (r4 == null) goto L20;
            e1.q(r4.j);
            e1.q(r4.h);
            e1.q(r4.f);
        L20:
            return Unit.INSTANCE;
        L5:
            if (r3 != 2) goto L7;
            LarusDoraOnboardingV2WakeupBinding r5 = this.a.o;
            if (r5 == null) goto L20;
            r5.j.playAnimation();
            e1.q(r5.h);
            e1.x(r5.j);
            e1.x(r5.f);
            goto L20
        L7:
            if (r3 != 3) goto L12;
            LarusDoraOnboardingV2WakeupBinding r6 = this.a.o;
            if (r6 == null) goto L20;
            e1.q(r6.j);
            e1.x(r6.h);
            e1.x(r6.f);
            goto L20
        L12:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class d<T> implements FlowCollector {
        public final /* synthetic */ DoraLiteOnboardingWakeupFragment a;

        public d(DoraLiteOnboardingWakeupFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            boolean r4 = ((Boolean) r2).booleanValue();
            if (Intrinsics.areEqual(this.a.p, y0.f.b) == false) goto L21;
            LarusDoraOnboardingV2WakeupBinding r5 = this.a.o;
            if (r5 == null) goto L21;
            AppCompatTextView r6 = r5.l;
            if (r6 == null) goto L21;
            if (r4 == false) goto L14;
            CharSequence r7 = (String) CollectionsKt.getOrNull(f69.b.b(), 1);
            if (r7 != null) goto L19;
            r7 = (String) CollectionsKt.getOrNull(f1.b, 1);
            if (r7 != null) goto L19;
        L18:
            r7 = "";
        L19:
            r6.setText(r7);
            goto L21
        L14:
            r7 = (String) CollectionsKt.getOrNull(f69.b.b(), 3);
            if (r7 != null) goto L19;
            r7 = (String) CollectionsKt.getOrNull(f1.b, 3);
            if (r7 != null) goto L19;
        L21:
            return Unit.INSTANCE;
        }
    }

    public static final class e<T> implements FlowCollector {
        public final /* synthetic */ DoraLiteOnboardingWakeupFragment a;

        public e(DoraLiteOnboardingWakeupFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            boolean r3 = ((Boolean) r1).booleanValue();
            LarusDoraOnboardingV2WakeupBinding r4 = this.a.o;
            if (r4 == null) goto L13;
            LarusDoraOnboardingMusicPanelBinding r5 = r4.k;
            if (r5 == null) goto L13;
            ImageView r6 = r5.e;
            if (r6 == null) goto L13;
            if (r3 == false) goto L10;
            int r7 = 2131240614;
        L11:
            r6.setImageResource(r7);
            goto L13
        L10:
            r7 = 2131240615;
        L13:
            return Unit.INSTANCE;
        }
    }

    public final String k() {
        return this.p.a;
    }

    public DoraLiteOnboardingWakeupFragment() {
        this.p = new y0.g(false);
        this.q = new LinkedHashMap();
        this.r = new Handler(Looper.getMainLooper());
    }

    @Override // com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingBaseFragment, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void aa0() {
        da0();
        ca0().stopTTS("onSkipButtonClicked");
    }

    public final void ea0() {
        ca0().getDoraOnboardingDevice();
        ca0().stopTTS("gotoNextStep");
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L7;
        SessionService r1 = r0.d();
        if (r1 == null) goto L7;
        r1.q(BaiduNaviStatus.WRONG_AK_PARAM);
    L7:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraLiteOnboardingWakeupFragment$gotoNextStep$1(this, null), 3, null);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.r.removeCallbacksAndMessages(null);
        fa0(this.p.a, "");
        com.larus.dora.impl.onboarding.d.c(null);
    }

    public final void fa0(String r7, String r8) {
        boolean r1 = false;
        if (r7.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r7, r8) == false) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(r7, "voice_wakeup_guidance") == false) goto L12;
    L13:
        TextView r9 = this.h;
        if (r9 != null) goto L16;
    L21:
        Long r10 = (Long) ((LinkedHashMap) this.q).get(r7);
        if (r10 == null) goto L24;
        long r2 = r10.longValue();
    L25:
        long r4 = SystemClock.elapsedRealtime() - r2;
        int r11 = com.larus.dora.impl.onboarding.m0.a;
        com.larus.dora.impl.onboarding.m0.h(r7, r4, r1);
        return;
    L24:
        r2 = 0;
        goto L25
    L16:
        if (r9.getVisibility() != 0) goto L18;
        boolean r12 = true;
    L19:
        if (r12 != true) goto L21;
        r1 = true;
        goto L21
    L18:
        r12 = false;
        goto L19
    L12:
        if (Intrinsics.areEqual(r7, "first_conversation_guidance") == false) goto L21;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void onViewCreated(View r20, Bundle r21) {
        Intrinsics.checkNotNullParameter(r20, "view");
        super.onViewCreated(r20, r21);
        TextView r1 = this.h;
        if (r1 == null) goto L5;
        e1.o(r1);
    L5:
        boolean r2 = com.larus.dora.impl.onboarding.d.a;
        LarusDoraOnboardingV2WakeupBinding r3 = this.o;
        if (r3 == null) goto L8;
        CustomBarCountAudioVisualizer r4 = r3.e;
    L9:
        com.larus.dora.impl.onboarding.d.c(new WeakReference(r4));
        ca0().fetchAvatarUrl();
        Lifecycle.State r5 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraLiteOnboardingWakeupFragment$setupAvatar$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r5, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraLiteOnboardingWakeupFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r5, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraLiteOnboardingWakeupFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r5, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraLiteOnboardingWakeupFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r5, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraLiteOnboardingWakeupFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$4(this, r5, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraLiteOnboardingWakeupFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$5(this, r5, null, this), 3, null);
        ca0().enterVoiceOnlyMode();
        ca0().playOpeningRemarksTTS();
        return;
    L8:
        r4 = null;
        goto L9
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        LarusDoraOnboardingV2WakeupBinding r6 = LarusDoraOnboardingV2WakeupBinding.a(r3, r4);
        DoraUrlSpanTextView r7 = r6.n;
        int r8 = com.larus.utils.j0.a;
        r7.setUrlSpannedText(com.larus.utils.j0.d(2131903799));
        CustomBarCountAudioVisualizer r9 = r6.e;
        r9.setMaxSampleData(0.8d);
        r9.setColor(ColorProtector.parseColor("#00B2FF"));
        r6.j.setAnimation(2131820620);
        r6.i.setAnimation(2131820619);
        this.o = r6;
        return r6.a;
    }
}
