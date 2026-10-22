package com.obric.audio.enroll.ui.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Message;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.fragment.app.FragmentTransaction;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.audio.ObricEnrollInteropDelegate;
import com.obric.audio.enroll.model.EnrollState;
import com.obric.audio.enroll.model.TipsCode;
import com.obric.audio.enroll.recorder.VoicePrintEnrollRecordingsMgr;
import com.obric.audio.enroll.trace.VoiceEnrollTrace;
import com.obric.audio.enroll.ui.VoicePrintEnrollActivity;
import com.obric.audio.enroll.vm.EnrollViewModel;
import com.obric.audio.impl.databinding.SvaEnrollingFragmentBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.ui.fragment.EnrollingFragment$observe$5", f = "EnrollingFragment.kt", i = {}, l = {472}, m = "invokeSuspend", n = {}, s = {})
final class EnrollingFragment$observe$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ EnrollingFragment this$0;

    /* JADX INFO: renamed from: com.obric.audio.enroll.ui.fragment.EnrollingFragment$observe$5$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {
        public final /* synthetic */ EnrollingFragment a;

        /* JADX INFO: renamed from: com.obric.audio.enroll.ui.fragment.EnrollingFragment$observe$5$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.audio.enroll.ui.fragment.EnrollingFragment$observe$5$1$1", f = "EnrollingFragment.kt", i = {}, l = {509, 517}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ EnrollingFragment this$0;

            public C00321(EnrollingFragment r1, Continuation<? super C00321> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00321(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r13) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                EnrollViewModel r4 = null;
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L10;
                if (r1 != 2) goto L9;
                ResultKt.throwOnFailure(r13);     // Catch: Exception -> L28
            L42:
                return Unit.INSTANCE;
            L9:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L10:
                ResultKt.throwOnFailure(r13);     // Catch: Exception -> L28
            L19:
                EnrollViewModel r14 = this.this$0.f;     // Catch: Exception -> L28
                if (r14 != null) goto L22;
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Exception -> L28
                r14 = null;
            L22:
                r14.getRecordingManager().k.g();     // Catch: Exception -> L28
                EnrollViewModel r15 = this.this$0.f;     // Catch: Exception -> L28
                if (r15 != null) goto L26;
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Exception -> L28
                r15 = null;
            L26:
                if (r15.getEnrollDeviceType() != VoicePrintEnrollActivity.Companion.EnrollDeviceType.DORA_BT) goto L30;
                com.obric.audio.enroll.b.a.set(null);     // Catch: Exception -> L28
                oia.a.b();     // Catch: Exception -> L28
            L30:
                EnrollViewModel r16 = this.this$0.f;     // Catch: Exception -> L28
                if (r16 != null) goto L33;
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Exception -> L28
                r16 = null;
            L33:
                r16.setInterruptEnhancedVoiceEnroll(true);     // Catch: Exception -> L28
                EnrollingFragment r17 = this.this$0;     // Catch: Exception -> L28
                r17.getClass();     // Catch: Exception -> L28
                BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new EnrollingFragment$navigateToResult$1(r17, null), 3, null);     // Catch: Exception -> L28
                EnrollViewModel r18 = this.this$0.f;     // Catch: Exception -> L28
                if (r18 != null) goto L36;
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Exception -> L28
            L37:
                z0<EnrollState> r19 = r4.getEnrollState();     // Catch: Exception -> L28
                EnrollState r2 = EnrollState.ENROLLED_INTERRUPT;     // Catch: Exception -> L28
                this.label = 2;     // Catch: Exception -> L28
                if (r19.emit(r2, this) != r0) goto L42;
                return r0;
            L36:
                r4 = r18;
                goto L37
            L12:
                ResultKt.throwOnFailure(r13);
                EnrollViewModel r110 = this.this$0.f;     // Catch: Exception -> L28
                if (r110 != null) goto L16;
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Exception -> L28
                r110 = null;
            L16:
                VoicePrintEnrollRecordingsMgr r111 = r110.getRecordingManager();     // Catch: Exception -> L28
                this.label = 1;     // Catch: Exception -> L28
                if (r111.d(this) != r0) goto L19;
                return r0;
            L28:
                e = move-exception;
                FLogger.a.e("EnrollingFragment", "Error BluetoothScoConnectFailed", e);
                goto L42
            }
        }

        public AnonymousClass1(EnrollingFragment r1) {
            this.a = r1;
        }

        public final Object a(qia.e r17, Continuation<? super Unit> r18) {
            if ((r18 instanceof EnrollingFragment$observe$5$1$emit$1) == false) goto L7;
            EnrollingFragment$observe$5$1$emit$1 r3 = (EnrollingFragment$observe$5$1$emit$1) r18;
            int r4 = r3.label;
            if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
            r3.label = r4 - Integer.MIN_VALUE;
        L8:
            Object r2 = r3.result;
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r6 = r3.label;
            if (r6 == 0) goto L22;
            if (r6 == 1) goto L21;
            if (r6 == 2) goto L20;
            if (r6 == 3) goto L19;
            if (r6 == 4) goto L18;
            if (r6 != 5) goto L17;
            ResultKt.throwOnFailure(r2);
        L144:
            return Unit.INSTANCE;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            ResultKt.throwOnFailure(r2);
        L133:
            return Unit.INSTANCE;
        L19:
            ResultKt.throwOnFailure(r2);
        L119:
            return Unit.INSTANCE;
        L20:
            ResultKt.throwOnFailure(r2);
        L110:
            return Unit.INSTANCE;
        L21:
            ResultKt.throwOnFailure(r2);
        L90:
            EnrollViewModel r0 = this.a.f;
            if (r0 != null) goto L94;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r0 = null;
        L94:
            if (Intrinsics.areEqual(r0.getStartFrom(), EnrollViewModel.SET_UP_WIZARD) == false) goto L111;
            pia.b r1 = pia.b.a;
            Intrinsics.checkNotNullParameter(EnrollViewModel.HAS_RECORD_PERMISSION, "key");
            if (pia.b.a().getBoolean(EnrollViewModel.HAS_RECORD_PERMISSION, false) == true) goto L102;
            final EnrollingFragment r7 = this.a;
            EnrollViewModel r8 = r7.f;
            if (r8 != null) goto L100;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            EnrollViewModel r9 = null;
        L101:
            r9.setRequestingRecordPermission(true);
            ObricEnrollInteropDelegate.b.k(r7.requireActivity(), new EnrollingFragment$requestRecordPermission$1(r7));
        L237:
            return Unit.INSTANCE;
        L100:
            r9 = r8;
            goto L101
        L102:
            EnrollViewModel r10 = this.a.f;
            if (r10 != null) goto L105;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            EnrollViewModel r11 = null;
        L106:
            VoicePrintEnrollRecordingsMgr r12 = r11.getRecordingManager();
            r3.label = 2;
            if (r12.b(r3) != r5) goto L110;
            return r5;
        L105:
            r11 = r10;
            goto L106
        L111:
            EnrollViewModel r13 = this.a.f;
            if (r13 != null) goto L114;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            EnrollViewModel r14 = null;
        L115:
            VoicePrintEnrollRecordingsMgr r15 = r14.getRecordingManager();
            r3.label = 3;
            if (r15.b(r3) != r5) goto L119;
            return r5;
        L114:
            r14 = r13;
            goto L115
        L22:
            ResultKt.throwOnFailure(r2);
            FLogger r16 = FLogger.a;
            r16.i("EnrollingFragment", "eventBus: " + r17);
            if ((r17 instanceof qia.o) == false) goto L83;
            EnrollingFragment r19 = this.a;
            qia.o r20 = (qia.o) r17;
            int r21 = r20.a;
            int r22 = EnrollingFragment.k;
            r19.getClass();
            r16.i("EnrollingFragment", "showRippleOnce " + r21);
            if (r21 != 4) goto L27;
            boolean r23 = true;
        L28:
            if (r23 == false) goto L30;
            final float r24 = 0.4f;
        L31:
            SvaEnrollingFragmentBinding r25 = r19.e;
            Intrinsics.checkNotNull(r25);
            final View r26 = r25.d;
            r26.setAlpha(r24);
            r26.setScaleX(0.0f);
            r26.setScaleY(0.0f);
            ValueAnimator r110 = new ValueAnimator();
            r110.setIntValues(new int[]{0, 1});
            long r111 = 2000;
            r110.setDuration(2000);
            r110.setInterpolator(new LinearInterpolator());
            r110.addUpdateListener(new w(r26, r24));
            ValueAnimator r27 = new ValueAnimator();
            r27.setIntValues(new int[]{0, 1});
            if (r23 == false) goto L34;
            r111 = 3000;
        L34:
            r27.setDuration(r111);
            r27.setInterpolator(new DecelerateInterpolator());
            r27.addUpdateListener(new x(r26));
            AnimatorSet r28 = new AnimatorSet();
            r28.addListener(new d0(r26, r26));
            r28.playTogether(new Animator[]{r110, r27});
            r28.start();
            r16.i("EnrollStageView", "start animator ripple");
            EnrollingFragment r29 = this.a;
            int r30 = r20.a;
            r29.getClass();
            ria.c r31 = ria.c.a;
            monitor-enter(r31);
            if (r30 >= 0) goto L238;
        L64:
            monitor-exit(r31);
        L65:
            EnrollingFragment r32 = this.a;
            int r33 = r20.a;
            r32.getClass();
            if (r33 < 0) goto L69;
            if (r33 >= 5) goto L69;
            boolean r34 = true;
        L70:
            if (r34 == false) goto L237;
            Context r35 = r32.requireContext();
            int r36 = ria.a.a;
            Intrinsics.checkNotNullParameter(r35, "context");
            VibrationEffect r37 = VibrationEffect.createPredefined(2);
            Object r38 = r35.getSystemService("vibrator");
            if ((r38 instanceof Vibrator) == false) goto L74;
            Vibrator r39 = (Vibrator) r38;
        L75:
            if (r39 == null) goto L237;
            if (r39.hasVibrator() == false) goto L79;
            Vibrator r40 = r39;
        L80:
            if (r40 == null) goto L237;
            r40.vibrate(r37);
            goto L237
        L79:
            r40 = null;
            goto L80
        L74:
            r39 = null;
        L69:
            r34 = false;
            goto L70
        L238:
            Map<Integer, Integer> r112 = ria.c.e;     // Catch: Throwable -> L61
            if (r30 >= r112.size()) goto L64;
            Map<Integer, Integer> r113 = ria.c.f;     // Catch: Throwable -> L61
            Integer r41 = (Integer) ((LinkedHashMap) r113).get(Integer.valueOf(r30));     // Catch: Throwable -> L61
            if (r41 == null) goto L43;
            int r42 = r41.intValue();     // Catch: Throwable -> L61
        L45:
            if (r42 >= 0) goto L50;
            r16.i("SoundPlayer", "soundId " + r30 + " not loaded");     // Catch: Throwable -> L61
            SoundPool r43 = ria.c.g;     // Catch: Throwable -> L61
            if (r43 != null) goto L49;
            Intrinsics.throwUninitializedPropertyAccessException("soundPool");     // Catch: Throwable -> L61
            r43 = null;
        L49:
            Context r114 = ria.c.b;     // Catch: Throwable -> L61
            Integer r115 = r112.get(Integer.valueOf(r30));     // Catch: Throwable -> L61
            Intrinsics.checkNotNull(r115);     // Catch: Throwable -> L61
            ria.c.c = r43.load(r114, r115.intValue(), 1);     // Catch: Throwable -> L61
            r113.put(Integer.valueOf(r30), Integer.valueOf(ria.c.c));     // Catch: Throwable -> L61
            ria.c.d = 1.0f;     // Catch: Throwable -> L61
            r16.e("SoundPlayer", "sound id to play = " + ria.c.c);     // Catch: Throwable -> L61
        L59:
            monitor-exit(r31);
            goto L65
        L50:
            Integer r44 = (Integer) ((LinkedHashMap) r113).get(Integer.valueOf(r30));     // Catch: Throwable -> L61
            if (r44 == null) goto L53;
            int r45 = r44.intValue();     // Catch: Throwable -> L61
        L54:
            ria.c.c = r45;     // Catch: Throwable -> L61
            r16.i("SoundPlayer", "sound id to play 2 = " + ria.c.c);     // Catch: Throwable -> L61
            if (ria.c.c != (-1)) goto L58;
            monitor-exit(r31);
            goto L65
        L58:
            Object r46 = ((LinkedHashMap) r113).get(Integer.valueOf(r30));     // Catch: Throwable -> L61
            Intrinsics.checkNotNull(r46);     // Catch: Throwable -> L61
            r31.a(((Number) r46).intValue(), 1.0f);     // Catch: Throwable -> L61
            goto L59
        L53:
            r45 = -1;
            goto L54
        L43:
            r42 = -1;
        L61:
            th = move-exception;
            throw th;
        L30:
            r24 = 0.2f;
            goto L31
        L27:
            r23 = false;
            goto L28
        L83:
            if ((r17 instanceof qia.l) == false) goto L121;
            EnrollViewModel r47 = this.a.f;
            if (r47 != null) goto L87;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r47 = null;
        L87:
            z0<Integer> r48 = r47.getEnrollIndex();
            Integer r49 = Boxing.boxInt(((qia.l) r17).a);
            r3.label = 1;
            if (r48.emit(r49, r3) != r5) goto L90;
            return r5;
        L121:
            if ((r17 instanceof qia.k) == false) goto L124;
            EnrollingFragment r50 = this.a;
            int r51 = EnrollingFragment.k;
            r50.getClass();
            BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new EnrollingFragment$navigateToResult$1(r50, null), 3, null);
            goto L237
        L124:
            if (Intrinsics.areEqual(r17, qia.n.a) == false) goto L135;
            EnrollViewModel r52 = this.a.f;
            if (r52 != null) goto L128;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            EnrollViewModel r53 = null;
        L129:
            VoicePrintEnrollRecordingsMgr r54 = r53.getRecordingManager();
            r3.label = 4;
            if (r54.d(r3) != r5) goto L133;
            return r5;
        L128:
            r53 = r52;
            goto L129
        L135:
            if (Intrinsics.areEqual(r17, qia.m.a) == false) goto L146;
            EnrollViewModel r55 = this.a.f;
            if (r55 != null) goto L139;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            EnrollViewModel r56 = null;
        L140:
            VoicePrintEnrollRecordingsMgr r57 = r56.getRecordingManager();
            r3.label = 5;
            if (r57.b(r3) != r5) goto L144;
            return r5;
        L139:
            r56 = r55;
            goto L140
        L146:
            if (Intrinsics.areEqual(r17, qia.c.a) == false) goto L148;
        L235:
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C00321(this.a, null), 3, null);
            goto L237
        L148:
            if (Intrinsics.areEqual(r17, qia.d.a) == true) goto L235;
            if ((r17 instanceof qia.q) == false) goto L156;
            r16.i("EnrollingFragment", "send tip event to channel with " + ((qia.q) r17).a);
            Handler r58 = this.a.i;
            if (r58 == null) goto L237;
            Message r59 = Message.obtain();
            r59.obj = r17;
            r59.what = 0;
            Boxing.boxBoolean(r58.sendMessage(r59));
            goto L237
        L156:
            if (Intrinsics.areEqual(r17, qia.i.a) == false) goto L163;
            EnrollViewModel r60 = this.a.f;
            if (r60 != null) goto L160;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            EnrollViewModel r61 = null;
        L161:
            r61.reportEvent(new qia.q(TipsCode.TIPS_CODE_VAD_END_AND_NOT_ENOUGH_SIZE));
            goto L237
        L160:
            r61 = r60;
            goto L161
        L163:
            if (Intrinsics.areEqual(r17, qia.b.a) == false) goto L184;
            if (this.a.g == true) goto L237;
            r16.i("EnrollingFragment", "playAnimation");
            SvaEnrollingFragmentBinding r62 = this.a.e;
            Intrinsics.checkNotNull(r62);
            r62.j.playAnimation();
            EnrollingFragment r63 = this.a;
            r63.g = true;
            EnrollViewModel r64 = r63.f;
            if (r64 != null) goto L169;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r64 = null;
        L169:
            EnrollViewModel r65 = this.a.f;
            if (r65 != null) goto L172;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            EnrollViewModel r66 = null;
        L173:
            int r67 = ((Number) r66.getEnrollIndex().getValue()).intValue();
            if (r67 == 4) goto L178;
            if (r67 == 3) goto L178;
            boolean r68 = false;
        L179:
            if (r68 == false) goto L181;
            qia.q r69 = new qia.q(TipsCode.TIPS_CODE_FASTER_SAY_it);
        L182:
            r64.reportEvent(r69);
            goto L237
        L181:
            r69 = new qia.q(TipsCode.TIPS_CODE_SAY_it);
        L178:
            r68 = true;
            goto L179
        L172:
            r66 = r65;
            goto L173
        L184:
            if (Intrinsics.areEqual(r17, qia.a.a) == false) goto L190;
            if (this.a.g == false) goto L188;
            r16.i("EnrollingFragment", "cancelAnimation");
            SvaEnrollingFragmentBinding r70 = this.a.e;
            Intrinsics.checkNotNull(r70);
            r70.j.setFrame(1);
            SvaEnrollingFragmentBinding r71 = this.a.e;
            Intrinsics.checkNotNull(r71);
            r71.j.cancelAnimation();
        L188:
            this.a.g = false;
            goto L237
        L190:
            if (Intrinsics.areEqual(r17, qia.p.a) == false) goto L208;
            EnrollViewModel r72 = this.a.f;
            if (r72 != null) goto L195;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r72 = null;
        L195:
            if (r72.isRequestingRecordPermission() == true) goto L237;
            CoroutineScope r73 = VoiceEnrollTrace.a;
            String r74 = VoiceEnrollTrace.b;
            EnrollViewModel r75 = this.a.f;
            if (r75 != null) goto L199;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r75 = null;
        L199:
            VoiceEnrollTrace.c(EnrollViewModel.TIME_OUT_PAGE, r74, r75.enterFrom());
            VoiceEnrollTrace.b = EnrollViewModel.TIME_OUT_PAGE;
            EnrollingFragment r76 = this.a;
            if (r76.getActivity() == null) goto L237;
            FragmentTransaction r77 = r76.getParentFragmentManager().beginTransaction().setCustomAnimations(2130772654, 2130772653, 2130772653, 2130772653);
            EnrollTimeoutFragment r78 = new EnrollTimeoutFragment();
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r77, r78, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L206;
            r77 = r77.replace(2131373275, r78);
        L206:
            r77.commit();
            goto L237
        L208:
            if (Intrinsics.areEqual(r17, qia.h.a) == false) goto L219;
            CoroutineScope r79 = VoiceEnrollTrace.a;
            String r80 = VoiceEnrollTrace.b;
            if (r80 != null) goto L213;
            r80 = EnrollViewModel.GUIDE_PAGE;
        L213:
            EnrollViewModel r81 = this.a.f;
            if (r81 != null) goto L216;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            EnrollViewModel r82 = null;
        L217:
            VoiceEnrollTrace.c(EnrollViewModel.PAGE_1, r80, r82.enterFrom());
            VoiceEnrollTrace.b = EnrollViewModel.PAGE_1;
            SvaEnrollingFragmentBinding r83 = this.a.e;
            Intrinsics.checkNotNull(r83);
            r83.c.setText(this.a.getString(2131914209, new Object[]{Boxing.boxInt(1), Boxing.boxInt(5)}));
            goto L237
        L216:
            r82 = r81;
            goto L217
        L219:
            if ((r17 instanceof qia.j) == false) goto L234;
            int r84 = ((qia.j) r17).a + 1;
            if (r84 > 5) goto L237;
            CoroutineScope r85 = VoiceEnrollTrace.a;
            EnrollViewModel r86 = this.a.f;
            if (r86 != null) goto L225;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r86 = null;
        L225:
            String r87 = r86.getCurrentPageName(r84);
            String r88 = VoiceEnrollTrace.b;
            EnrollViewModel r89 = this.a.f;
            if (r89 != null) goto L228;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r89 = null;
        L228:
            VoiceEnrollTrace.c(r87, r88, r89.enterFrom());
            EnrollViewModel r90 = this.a.f;
            if (r90 != null) goto L231;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            EnrollViewModel r91 = null;
        L232:
            VoiceEnrollTrace.b = r91.getCurrentPageName(r84);
            SvaEnrollingFragmentBinding r92 = this.a.e;
            Intrinsics.checkNotNull(r92);
            r92.c.setText(this.a.getString(2131914209, new Object[]{Boxing.boxInt(r84), Boxing.boxInt(5)}));
            goto L237
        L231:
            r91 = r90;
            goto L232
        L234:
            throw new NoWhenBranchMatchedException();
        L7:
            r3 = new EnrollingFragment$observe$5$1$emit$1(this, r18);
            goto L8
        }

        public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
            return a((qia.e) r1, r2);
        }
    }

    public EnrollingFragment$observe$5(EnrollingFragment r1, Continuation<? super EnrollingFragment$observe$5> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new EnrollingFragment$observe$5(this.this$0, r3);
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
        MutableSharedFlow<qia.e> r7 = r6.getEventBus();
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L15;
        return r0;
    }
}
