package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/standaloneinterpretation/MmStandaloneAIInterpretationUpdateResult;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo$opt$2$1$switchFromBidirectionalLanguage$2", f = "MmStandaloneAIInterpretationRepo.kt", i = {0}, l = {168, 170, 174}, m = "invokeSuspend", n = {"previousTarget"}, s = {"L$0"})
public final class MmStandaloneAIInterpretationRepo$opt$2$1$switchFromBidirectionalLanguage$2 extends SuspendLambda implements Function1<Continuation<? super g>, Object> {
    final /* synthetic */ String $meetingId;
    final /* synthetic */ c $spokenLanguage;
    final /* synthetic */ c $targetLanguage;
    Object L$0;
    int label;
    final /* synthetic */ MmStandaloneAIInterpretationRepo$opt$2.AnonymousClass1 this$0;
    final /* synthetic */ MmStandaloneAIInterpretationRepo this$1;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo$opt$2$1$switchFromBidirectionalLanguage$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/standaloneinterpretation/MmStandaloneAIInterpretationUpdateResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo$opt$2$1$switchFromBidirectionalLanguage$2$1", f = "MmStandaloneAIInterpretationRepo.kt", i = {0, 1, 2, 3, 4}, l = {179, 184, 194, 195, 199}, m = "invokeSuspend", n = {"targetDeferred", "sourceAccepted", "targetResult", "targetResult", "targetResult"}, s = {"L$0", "I$0", "L$0", "L$0", "L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super g>, Object> {
        final /* synthetic */ String $meetingId;
        final /* synthetic */ h $previousSpokenLanguage;
        final /* synthetic */ c $previousTarget;
        final /* synthetic */ c $spokenLanguage;
        final /* synthetic */ c $targetLanguage;
        int I$0;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmStandaloneAIInterpretationRepo this$0;
        final /* synthetic */ MmStandaloneAIInterpretationRepo$opt$2.AnonymousClass1 this$1;

        public AnonymousClass1(MmStandaloneAIInterpretationRepo r1, c r2, c r3, String r4, c r5, h r6, MmStandaloneAIInterpretationRepo$opt$2.AnonymousClass1 r7, Continuation<? super AnonymousClass1> r8) {
            this.this$0 = r1;
            this.$spokenLanguage = r2;
            this.$targetLanguage = r3;
            this.$meetingId = r4;
            this.$previousTarget = r5;
            this.$previousSpokenLanguage = r6;
            this.this$1 = r7;
            super(2, r8);
        }

        public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
            AnonymousClass1 r9 = new AnonymousClass1(this.this$0, this.$spokenLanguage, this.$targetLanguage, this.$meetingId, this.$previousTarget, this.$previousSpokenLanguage, this.this$1, r12);
            r9.L$0 = r11;
            return r9;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super g> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r20) {
            Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            boolean r5 = true;
            if (r0 == 0) goto L16;
            if (r0 == 1) goto L15;
            if (r0 == 2) goto L14;
            if (r0 == 3) goto L13;
            if (r0 == 4) goto L12;
            if (r0 != 5) goto L11;
            g r1 = (g) this.L$0;
            ResultKt.throwOnFailure(r20);
            return r1;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            g r2 = (g) this.L$0;
            ResultKt.throwOnFailure(r20);
        L92:
            if (r2 != null) goto L94;
            return null;
        L94:
            if (r2.a() == false) goto L96;
            return null;
        L96:
            return r2;
        L13:
            g r3 = (g) this.L$0;
            ResultKt.throwOnFailure(r20);
            g r10 = r3;
            Object r4 = r20;
        L84:
            boolean r6 = ((Boolean) r4).booleanValue();
            MmStandaloneAIInterpretationRepo r8 = this.this$0;
            b r9 = (b) this.this$1.m();
            if (r6 == false) goto L87;
            String r11 = "update_failed";
        L88:
            b r12 = b.b(r9, null, r11, 511);
            this.L$0 = r10;
            this.label = 4;
            if (r8.b(r12, this) != r7) goto L91;
            return r7;
        L91:
            r2 = r10;
            goto L92
        L87:
            r11 = "rollback_failed";
            goto L88
        L14:
            int r13 = this.I$0;
            ResultKt.throwOnFailure(r20);
            Object r14 = r20;
        L32:
            Pair r15 = (Pair) r14;
            g r16 = (g) r15.component1();
            g r17 = (g) r15.component2();
            if (r16 != null) goto L35;
        L37:
            boolean r18 = false;
        L38:
            if (r18 == false) goto L40;
            r10 = r17;
        L42:
            if (this.this$0.j.g().a() == true) goto L44;
            return null;
        L44:
            if (r13 == 0) goto L63;
            if (r10 != null) goto L47;
        L49:
            boolean r19 = false;
        L50:
            if (r19 == false) goto L63;
            MmStandaloneAIInterpretationRepo r21 = this.this$0;
            c r22 = r10.h;
            if (r22 != null) goto L55;
            r22 = this.$targetLanguage;
        L55:
            this.L$0 = r10;
            this.label = 5;
            r21.getClass();
            Object r23 = r21.e.b(new MmStandaloneAIInterpretationRepo$dispatchAcceptedEntity$2(r21, true, r10, r22, null), this);
            if (r23 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L59;
            r23 = Unit.INSTANCE;
        L59:
            if (r23 != r7) goto L62;
            return r7;
        L62:
            return r10;
        L47:
            if (r10.a() != true) goto L49;
            r19 = true;
        L63:
            String r24 = this.this$0.l;
            StringBuilder r25 = new StringBuilder("[switchFromBidirectionalLanguage] failed, sourceAccepted=");
            if (r13 != 0) goto L67;
            r5 = false;
        L67:
            r25.append(r5);
            r25.append(", targetStatus=");
            if (r10 == null) goto L70;
            Integer r26 = Boxing.boxInt(r10.b);
        L71:
            r25.append(r26);
            lvb.a.b(r24, r25.toString());
            if (r17 != null) goto L74;
        L80:
            c r27 = this.$targetLanguage;
        L81:
            c r28 = r27;
            MmStandaloneAIInterpretationRepo r29 = this.this$0;
            String r30 = this.$meetingId;
            c r31 = this.$previousTarget;
            h r32 = this.$previousSpokenLanguage;
            this.L$0 = r10;
            this.label = 3;
            r4 = MmStandaloneAIInterpretationRepo.p(r29, r30, r28, r31, r32, this);
            if (r4 != r7) goto L84;
            return r7;
        L74:
            if (r17.a() == true) goto L77;
            r17 = null;
        L77:
            if (r17 == null) goto L80;
            r27 = r17.h;
            if (r27 != null) goto L81;
        L70:
            r26 = null;
            goto L71
        L40:
            r10 = r16;
            goto L42
        L35:
            if (r16.a() != true) goto L37;
            r18 = true;
            goto L38
        L15:
            Deferred r33 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(r20);
            Object r34 = r20;
        L26:
            if (((Boolean) r34).booleanValue() != true) goto L28;
            Deferred r35 = r33;
            r13 = 1;
        L29:
            this.L$0 = null;
            this.I$0 = r13;
            this.label = 2;
            r14 = r35.await(this);
            if (r14 != r7) goto L32;
            return r7;
        L28:
            r35 = r33;
            r13 = 0;
            goto L29
        L16:
            ResultKt.throwOnFailure(r20);
            r33 = BuildersKt.async$default((CoroutineScope) this.L$0, null, null, new MmStandaloneAIInterpretationRepo$opt$2$1$switchFromBidirectionalLanguage$2$1$targetDeferred$1(this.this$0, this.$meetingId, this.$previousTarget, this.$targetLanguage, null), 3, null);
            MmStandaloneAIInterpretationRootRepo r36 = this.this$0.j.h();
            if (r36 == null) goto L28;
            MmRecordingLanguageRepo r37 = r36.l();
            if (r37 == null) goto L28;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.a r38 = r37.l();
            if (r38 == null) goto L28;
            c r110 = this.$spokenLanguage;
            h r111 = new h(r110.a, r110.b);
            MmStandaloneAIInterpretationRepo$opt$2$1$switchFromBidirectionalLanguage$2$1$sourceAccepted$1 r112 = new MmStandaloneAIInterpretationRepo$opt$2$1$switchFromBidirectionalLanguage$2$1$sourceAccepted$1(r33, this.this$0, null);
            this.L$0 = r33;
            this.label = 1;
            r34 = r38.X(r111, r112, this);
            if (r34 != r7) goto L26;
            return r7;
        }
    }

    public MmStandaloneAIInterpretationRepo$opt$2$1$switchFromBidirectionalLanguage$2(MmStandaloneAIInterpretationRepo$opt$2.AnonymousClass1 r1, MmStandaloneAIInterpretationRepo r2, String r3, c r4, c r5, Continuation<? super MmStandaloneAIInterpretationRepo$opt$2$1$switchFromBidirectionalLanguage$2> r6) {
        this.this$0 = r1;
        this.this$1 = r2;
        this.$meetingId = r3;
        this.$spokenLanguage = r4;
        this.$targetLanguage = r5;
        super(1, r6);
    }

    public final Continuation<Unit> create(Continuation<?> r9) {
        return new MmStandaloneAIInterpretationRepo$opt$2$1$switchFromBidirectionalLanguage$2(this.this$0, this.this$1, this.$meetingId, this.$spokenLanguage, this.$targetLanguage, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super g> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        ResultKt.throwOnFailure(r17);
        return r17;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r17);
    L33:
        return null;
    L11:
        c r3 = (c) this.L$0;
        ResultKt.throwOnFailure(r17);
        c r12 = r3;
        Object r4 = r17;
    L28:
        h r13 = (h) r4;
        if (r13 != null) goto L35;
        MmStandaloneAIInterpretationRepo$opt$2.AnonymousClass1 r5 = this.this$0;
        MmStandaloneAIInterpretationRepo r6 = this.this$1;
        lvb.a.b(r6.l, "[switchFromBidirectionalLanguage] cannot resolve source language for rollback");
        b r7 = b.b((b) r5.m(), null, "update_failed", 511);
        this.L$0 = null;
        this.label = 2;
        if (r6.b(r7, this) != r1) goto L33;
        return r1;
    L35:
        if (this.this$1.j.g().a() == true) goto L37;
        return null;
    L37:
        AnonymousClass1 r8 = new AnonymousClass1(this.this$1, this.$spokenLanguage, this.$targetLanguage, this.$meetingId, r12, r13, this.this$0, null);
        this.L$0 = null;
        this.label = 3;
        Object r9 = CoroutineScopeKt.coroutineScope(r8, this);
        if (r9 != r1) goto L42;
        return r1;
    L42:
        return r9;
    L12:
        ResultKt.throwOnFailure(r17);
        b r10 = (b) this.this$0.m();
        c r11 = r10.i;
        if (r11 != null) goto L15;
    L41:
        return null;
    L15:
        if (r10.a == true) goto L18;
        r11 = null;
    L18:
        if (r11 == null) goto L41;
        if (SetsKt.setOf(new String[]{"zhen", "zh_cn_en_us"}).contains(r11.a) == true) goto L24;
        lvb.a.h(this.this$1.l, "[switchFromBidirectionalLanguage] skip stale selection, current=" + r11.a);
        return null;
    L24:
        MmStandaloneAIInterpretationRepo r14 = this.this$1;
        String r15 = this.$meetingId;
        this.L$0 = r11;
        this.label = 1;
        r4 = MmStandaloneAIInterpretationRepo.o(r14, r15, r10, this);
        if (r4 != r1) goto L27;
        return r1;
    L27:
        r12 = r11;
        goto L28
    }
}
