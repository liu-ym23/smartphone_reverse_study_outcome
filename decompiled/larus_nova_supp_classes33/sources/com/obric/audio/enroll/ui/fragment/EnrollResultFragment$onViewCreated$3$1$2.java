package com.obric.audio.enroll.ui.fragment;

import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.SpeechFingerPrintEnrollService;
import com.mammon.audiosdk.structures.SpeechFingerprintEnrollRequest;
import com.obric.assistant.spi.audio.ObricEnrollInteropDelegate;
import com.obric.assistant.spi.audio.ObricWakeupTruthUploadDelegate;
import com.obric.audio.enroll.IVoiceEnrollService;
import com.obric.audio.enroll.IVoiceEnrollService$a;
import com.obric.audio.enroll.VoiceEnrollServiceImpl;
import com.obric.audio.enroll.model.EnrollState;
import com.obric.audio.enroll.sami.SamiEnrollEngine;
import com.obric.audio.enroll.ui.VoicePrintEnrollActivity;
import com.obric.audio.enroll.vm.EnrollViewModel;
import com.obric.audio.impl.databinding.SvaEnrollResultFragmentBinding;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.z0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.ui.fragment.EnrollResultFragment$onViewCreated$3$1$2", f = "EnrollResultFragment.kt", i = {2, 3, 3}, l = {212, 215, 229, 247, 248, 337}, m = "invokeSuspend", n = {"originalVoiceWakeupSwitch", "originalVoiceWakeupSwitch", "originalHelpImproveVoiceWakeupSwitch"}, s = {"Z$0", "Z$0", "Z$1"})
final class EnrollResultFragment$onViewCreated$3$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Job $job;
    final /* synthetic */ long $startTime;
    boolean Z$0;
    boolean Z$1;
    int label;
    final /* synthetic */ EnrollResultFragment this$0;

    /* JADX INFO: renamed from: com.obric.audio.enroll.ui.fragment.EnrollResultFragment$onViewCreated$3$1$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.audio.enroll.ui.fragment.EnrollResultFragment$onViewCreated$3$1$2$1", f = "EnrollResultFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ EnrollResultFragment this$0;

        public AnonymousClass1(EnrollResultFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L12;
            ResultKt.throwOnFailure(r2);
            SvaEnrollResultFragmentBinding r3 = this.this$0.e;
            if (r3 == null) goto L9;
            LottieAnimationView r4 = r3.e;
            if (r4 == null) goto L9;
            r4.cancelAnimation();
            return Unit.INSTANCE;
        L9:
            return null;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.audio.enroll.ui.fragment.EnrollResultFragment$onViewCreated$3$1$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.audio.enroll.ui.fragment.EnrollResultFragment$onViewCreated$3$1$2$2", f = "EnrollResultFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $originalHelpImproveVoiceWakeupSwitch;
        final /* synthetic */ boolean $originalVoiceWakeupSwitch;
        int label;
        final /* synthetic */ EnrollResultFragment this$0;

        public AnonymousClass2(EnrollResultFragment r1, boolean r2, boolean r3, Continuation<? super AnonymousClass2> r4) {
            this.this$0 = r1;
            this.$originalHelpImproveVoiceWakeupSwitch = r2;
            this.$originalVoiceWakeupSwitch = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass2(this.this$0, this.$originalHelpImproveVoiceWakeupSwitch, this.$originalVoiceWakeupSwitch, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L109;
            ResultKt.throwOnFailure(r7);
            SvaEnrollResultFragmentBinding r8 = this.this$0.e;
            if (r8 == null) goto L11;
            OCardListItem r9 = r8.j;
            if (r9 == null) goto L11;
            OSwitch r10 = r9.getEndSwitch();
            if (r10 == null) goto L11;
            final EnrollResultFragment r0 = this.this$0;
            r10.setOnCheckedChangeListener(new n(r0));
        L11:
            SvaEnrollResultFragmentBinding r11 = this.this$0.e;
            if (r11 == null) goto L18;
            OCardListItem r12 = r11.j;
            if (r12 == null) goto L18;
            OSwitch r13 = r12.getEndSwitch();
            if (r13 == null) goto L18;
            r13.setChecked(true);
        L18:
            EnrollViewModel r14 = this.this$0.f;
            EnrollViewModel r2 = null;
            if (r14 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r14 = null;
        L21:
            r14.setVoiceWakeupSwitch(true);
            SvaEnrollResultFragmentBinding r15 = this.this$0.e;
            if (r15 == null) goto L36;
            OCardListItem r4 = r15.c;
            if (r4 == null) goto L36;
            if (this.$originalHelpImproveVoiceWakeupSwitch == false) goto L31;
            OCardListItem r16 = r15.j;
            if (r16 == null) goto L30;
            OCardListItem.h(r16, 0);
        L30:
            int r17 = 8;
        L35:
            r4.setVisibility(r17);
            goto L36
        L31:
            OCardListItem r18 = r15.j;
            if (r18 == null) goto L34;
            OCardListItem.h(r18, 1);
        L34:
            r17 = 0;
        L36:
            SvaEnrollResultFragmentBinding r19 = this.this$0.e;
            if (r19 == null) goto L43;
            OCardListItem r20 = r19.c;
            if (r20 == null) goto L43;
            OSwitch r21 = r20.getEndSwitch();
            if (r21 == null) goto L43;
            final EnrollResultFragment r5 = this.this$0;
            r21.setOnCheckedChangeListener(new o(r5));
        L43:
            SvaEnrollResultFragmentBinding r22 = this.this$0.e;
            if (r22 == null) goto L50;
            OCardListItem r23 = r22.c;
            if (r23 == null) goto L50;
            OSwitch r24 = r23.getEndSwitch();
            if (r24 == null) goto L50;
            r24.setChecked(true);
        L50:
            EnrollViewModel r25 = this.this$0.f;
            if (r25 != null) goto L53;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r25 = null;
        L53:
            r25.setHelpImproveVoiceWakeupSwitch(true);
            EnrollViewModel r26 = this.this$0.f;
            if (r26 != null) goto L57;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r26 = null;
        L57:
            if (r26.getEnrollDeviceType() == VoicePrintEnrollActivity.Companion.EnrollDeviceType.DEFAULT) goto L73;
            SvaEnrollResultFragmentBinding r27 = this.this$0.e;
            if (r27 == null) goto L63;
            OCardListItem r28 = r27.j;
            if (r28 == null) goto L63;
            r28.m(false);
        L63:
            ImageView r29 = new ImageView(this.this$0.getContext());
            r29.setImageResource(2131248322);
            SvaEnrollResultFragmentBinding r6 = this.this$0.e;
            if (r6 == null) goto L68;
            OCardListItem r30 = r6.j;
            if (r30 == null) goto L68;
            r30.setCustomStartView(r29);
        L68:
            SvaEnrollResultFragmentBinding r31 = this.this$0.e;
            if (r31 == null) goto L73;
            OCardListItem r32 = r31.j;
            if (r32 == null) goto L73;
            r32.n(true);
        L73:
            EnrollViewModel r33 = this.this$0.f;
            if (r33 != null) goto L76;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L77:
            String r34 = r2.getStartFrom();
            if (Intrinsics.areEqual(r34, EnrollViewModel.VOICE_WAKEUP) == false) goto L87;
            SvaEnrollResultFragmentBinding r35 = this.this$0.e;
            if (r35 == null) goto L107;
            OCardListItem r36 = r35.j;
            if (r36 == null) goto L107;
            OSwitch r37 = r36.getEndSwitch();
            if (r37 == null) goto L107;
            r37.setEnabled(false);
            r37.setAlpha(0.3f);
        L107:
            return Unit.INSTANCE;
        L87:
            if (Intrinsics.areEqual(r34, EnrollViewModel.NOISE_REDUCTION) == false) goto L107;
            ObricEnrollInteropDelegate.b.h();
            SvaEnrollResultFragmentBinding r38 = this.this$0.e;
            if (r38 == null) goto L97;
            OCardListItem r39 = r38.j;
            if (r39 == null) goto L97;
            OSwitch r40 = r39.getEndSwitch();
            if (r40 == null) goto L97;
            boolean r1 = this.$originalVoiceWakeupSwitch;
            r40.setChecked(true);
            if (r1 == false) goto L97;
            r40.setEnabled(false);
            r40.setAlpha(0.3f);
        L97:
            SvaEnrollResultFragmentBinding r41 = this.this$0.e;
            if (r41 == null) goto L107;
            OCardListItem r42 = r41.c;
            if (r42 == null) goto L107;
            OSwitch r43 = r42.getEndSwitch();
            if (r43 == null) goto L107;
            boolean r3 = this.$originalHelpImproveVoiceWakeupSwitch;
            r43.setChecked(true);
            if (r3 == false) goto L107;
            r43.setEnabled(false);
            r43.setAlpha(0.3f);
            goto L107
        L76:
            r2 = r33;
            goto L77
        L109:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public EnrollResultFragment$onViewCreated$3$1$2(EnrollResultFragment r1, long r2, Job r4, Continuation<? super EnrollResultFragment$onViewCreated$3$1$2> r5) {
        this.this$0 = r1;
        this.$startTime = r2;
        this.$job = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new EnrollResultFragment$onViewCreated$3$1$2(this.this$0, this.$startTime, this.$job, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(this.label) {
            case 0: goto L11;
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        ResultKt.throwOnFailure(r19);
    L143:
        return Unit.INSTANCE;
    L7:
        boolean r0 = this.Z$1;
        boolean r2 = this.Z$0;
        ResultKt.throwOnFailure(r19);
    L129:
        MainCoroutineDispatcher r3 = Dispatchers.getMain();
        AnonymousClass2 r5 = new AnonymousClass2(this.this$0, r0, r2, null);
        this.label = 5;
        if (BuildersKt.withContext(r3, r5, this) != r4) goto L143;
        return r4;
    L8:
        boolean r1 = this.Z$0;
        ResultKt.throwOnFailure(r19);
        Object r6 = r19;
    L99:
        boolean r7 = ((Boolean) r6).booleanValue();
    L100:
        boolean r17 = r7;
        r2 = r1;
        r0 = r17;
        EnrollViewModel r8 = this.this$0.f;
        if (r8 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r8 = null;
    L108:
        String r9 = r8.getEnrollDeviceSn();
        EnrollViewModel r10 = this.this$0.f;
        if (r10 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r10 = null;
    L112:
        if (r10.getEnrollDeviceType() != VoicePrintEnrollActivity.Companion.EnrollDeviceType.DEFAULT) goto L114;
        VoiceEnrollServiceImpl.k.getClass();
        VoiceEnrollServiceImpl.b.c();
        VoiceEnrollServiceImpl.b.b("default enroll success");
        ObricWakeupTruthUploadDelegate r11 = ObricWakeupTruthUploadDelegate.b;
        nia.a.a.getClass();
        r11.f(nia.a.g(), "default enroll success");
        ObricEnrollInteropDelegate.b.o();
    L123:
        EnrollViewModel r12 = this.this$0.f;
        if (r12 != null) goto L126;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r12 = null;
    L126:
        z0<EnrollState> r13 = r12.getEnrollState();
        EnrollState r14 = EnrollState.ENROLLED_SUCCESS;
        this.Z$0 = r2;
        this.Z$1 = r0;
        this.label = 4;
        if (r13.emit(r14, this) != r4) goto L129;
        return r4;
    L114:
        if ((true ^ StringsKt.isBlank(r9)) == false) goto L121;
        IVoiceEnrollService.a.getClass();
        IVoiceEnrollService r15 = IVoiceEnrollService$a.a();
        if (r15 == null) goto L121;
        EnrollViewModel r16 = this.this$0.f;
        if (r16 != null) goto L120;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r16 = null;
    L120:
        r15.g(r9, r16.getEnrollDeviceName());
    L121:
        SamiEnrollEngine.a.getClass();
        SamiEnrollEngine.u();
        goto L123
    L9:
        ResultKt.throwOnFailure(r19);
    L80:
        EnrollResultFragment r18 = this.this$0;
        if (r18.g != 0) goto L132;
        EnrollViewModel r20 = r18.f;
        if (r20 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r20 = null;
    L85:
        r20.setEnrollSuccess(true);
        EnrollViewModel r21 = this.this$0.f;
        if (r21 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r21 = null;
    L88:
        r21.setAlreadyEnroll(true);
        ObricWakeupTruthUploadDelegate.b.a();
        EnrollViewModel r22 = this.this$0.f;
        if (r22 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r22 = null;
    L91:
        r1 = r22.getVoiceWakeupSwitch();
        VoicePrintEnrollActivity r23 = this.this$0.getActivity();
        if ((r23 instanceof VoicePrintEnrollActivity) == false) goto L94;
        VoicePrintEnrollActivity r24 = r23;
    L95:
        if (r24 == null) goto L101;
        this.Z$0 = r1;
        this.label = 3;
        r6 = r24.A1(this);
        if (r6 != r4) goto L99;
        return r4;
    L101:
        EnrollViewModel r25 = this.this$0.f;
        if (r25 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r25 = null;
    L104:
        r7 = r25.getHelpImproveVoiceWakeupSwitch();
        goto L100
    L94:
        r24 = null;
        goto L95
    L132:
        EnrollViewModel r26 = null;
        EnrollViewModel r27 = r18.f;
        if (r27 != null) goto L135;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r27 = null;
    L135:
        r27.setAlreadyEnroll(true);
        EnrollViewModel r28 = this.this$0.f;
        if (r28 != null) goto L138;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L139:
        z0<EnrollState> r29 = r26.getEnrollState();
        EnrollState r30 = EnrollState.ENROLLED_FAILED;
        this.label = 6;
        if (r29.emit(r30, this) != r4) goto L143;
        return r4;
    L138:
        r26 = r28;
        goto L139
    L10:
        ResultKt.throwOnFailure(r19);
    L77:
        Job.DefaultImpls.cancel$default(this.$job, null, 1, null);
        MainCoroutineDispatcher r31 = Dispatchers.getMain();
        AnonymousClass1 r32 = new AnonymousClass1(this.this$0, null);
        this.label = 2;
        if (BuildersKt.withContext(r31, r32, this) != r4) goto L80;
        return r4;
    L11:
        ResultKt.throwOnFailure(r19);
        String r33 = UUID.randomUUID().toString();
        FLogger r34 = FLogger.a;
        StringBuilder r35 = new StringBuilder("checkAndEnrollASRSID taskId=");
        r35.append(r33);
        r35.append(" deviceType=");
        EnrollViewModel r110 = this.this$0.f;
        if (r110 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r110 = null;
    L14:
        r35.append(r110.getEnrollDeviceType());
        r34.i("EnrollResultFragment", r35.toString());
        EnrollResultFragment r36 = this.this$0;
        SamiEnrollEngine.a.getClass();
        Intrinsics.checkNotNullParameter(r33, "taskId");
        boolean r111 = SamiEnrollEngine.l;
        Intrinsics.checkNotNullParameter(r33, "taskId");
        r34.i("SamiEnrollEngine", "checkAndEnrollASRSID taskId=" + r33 + " bypassEnrollSid=0 bypassOnlineRegister=" + (r111 ? 1 : 0));
        SpeechFingerprintEnrollRequest r112 = new SpeechFingerprintEnrollRequest();
        r112.taskId = r33;
        boolean r37 = false;
        r112.bypassEnrollSid = 0;
        r112.bypassOnlineRegister = r111 ? 1 : 0;
        SamiEnrollEngine.e.lock();
        SpeechFingerPrintEnrollService r113 = SamiEnrollEngine.d;     // Catch: Throwable -> L144
        if (r113 == null) goto L18;
        int r114 = r113.checkAndEnrollASRSID(r112);     // Catch: Throwable -> L144
    L19:
        r34.i("SamiEnrollEngine", "checkAndEnrollASRSID ret=" + r114 + " taskId=" + r33);     // Catch: Throwable -> L144
        if (r114 == 0) goto L23;
    L52:
        SamiEnrollEngine.e.unlock();
        r36.g = r114;
        FLogger.a.i("EnrollResultFragment", "final enrollState " + this.this$0.g);
        int r38 = sia.d.a;
        int r39 = this.this$0.g;
        if (r39 != 0) goto L55;
        boolean r40 = true;
    L56:
        if (r40 == false) goto L58;
        ObricEnrollInteropDelegate.b.e(11, "");
    L64:
        FragmentActivity r41 = this.this$0.getActivity();
        if (r41 != null) goto L67;
    L69:
        if (r37 == true) goto L71;
        long r42 = System.currentTimeMillis() - this.$startTime;
        if (r42 >= 1500) goto L77;
        this.label = 1;
        if (DelayKt.delay(1500 - r42, this) != r4) goto L77;
        return r4;
    L71:
        return Unit.INSTANCE;
    L67:
        if (r41.isFinishing() != true) goto L69;
        r37 = true;
        goto L69
    L58:
        JSONObject r43 = new JSONObject();
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L61
        Result.constructor-impl(r43.put("code", r39));     // Catch: Throwable -> L61
    L63:
        ObricEnrollInteropDelegate.b.e(12, r43.toString());
    L61:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L63
    L55:
        r40 = false;
        goto L56
    L23:
        if (SamiEnrollEngine.l == false) goto L52;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L26
        nia.a.a.getClass();     // Catch: Throwable -> L26
        Object r47 = Result.constructor-impl(nia.a.g());     // Catch: Throwable -> L26
    L29:
        if (Result.isFailure-impl(r47) == false) goto L31;
        r47 = null;
    L31:
        String r48 = (String) r47;     // Catch: Throwable -> L144
        if (r48 != null) goto L34;
        String r115 = "";
    L147:
        nia.a.a.getClass();     // Catch: Throwable -> L37
        Object r49 = Result.constructor-impl(nia.a.d());     // Catch: Throwable -> L37
    L40:
        if (Result.isFailure-impl(r49) == false) goto L42;
        r49 = null;
    L42:
        String r50 = (String) r49;     // Catch: Throwable -> L144
        if (r50 != null) goto L46;
        r50 = "";
    L46:
        if ((!StringsKt.isBlank(r115)) == false) goto L51;
        pia.d.a(r115);     // Catch: Throwable -> L144
        pia.d.q(r50);     // Catch: Throwable -> L144
        Intrinsics.checkNotNullParameter(r115, "uid");     // Catch: Throwable -> L144
        if (StringsKt.isBlank(r115) == true) goto L52;
        pia.d.i().erase("default_voice_print_cloud_desired_op_".concat(r115));     // Catch: Throwable -> L144
        pia.d.i().erase("default_voice_print_cloud_actual_op_".concat(r115));     // Catch: Throwable -> L144
        pia.d.l(r115);     // Catch: Throwable -> L144
        goto L52
    L51:
        FLogger.a.w("SamiEnrollEngine", "checkAndEnrollASRSID uid blank, skip addEnrolledUid taskId=" + r33);     // Catch: Throwable -> L144
    L37:
        th = move-exception;
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L144
        r49 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L144
        goto L40
    L34:
        r115 = r48;
    L26:
        th = move-exception;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L144
        r47 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L144
        goto L29
    L18:
        r114 = Integer.MIN_VALUE;
    L144:
        th = move-exception;
        SamiEnrollEngine.e.unlock();
        throw th;
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
