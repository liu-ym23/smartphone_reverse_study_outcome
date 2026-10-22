package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/standaloneinterpretation/MmStandaloneAIInterpretationUpdateResult;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo$opt$2$1$switchTargetLanguage$2", f = "MmStandaloneAIInterpretationRepo.kt", i = {0, 0, 2}, l = {107, 119, 125}, m = "invokeSuspend", n = {"entity", "activeLanguage", "activeLanguage"}, s = {"L$0", "L$1", "L$0"})
public final class MmStandaloneAIInterpretationRepo$opt$2$1$switchTargetLanguage$2 extends SuspendLambda implements Function1<Continuation<? super g>, Object> {
    final /* synthetic */ c $language;
    final /* synthetic */ String $meetingId;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MmStandaloneAIInterpretationRepo$opt$2.AnonymousClass1 this$0;
    final /* synthetic */ MmStandaloneAIInterpretationRepo this$1;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo$opt$2$1$switchTargetLanguage$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/standaloneinterpretation/MmStandaloneAIInterpretationUpdateResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo$opt$2$1$switchTargetLanguage$2$1", f = "MmStandaloneAIInterpretationRepo.kt", i = {0}, l = {140, 140}, m = "invokeSuspend", n = {"enableDeferred"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends g, ? extends g>>, Object> {
        final /* synthetic */ c $activeLanguage;
        final /* synthetic */ c $language;
        final /* synthetic */ String $meetingId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmStandaloneAIInterpretationRepo this$0;

        public AnonymousClass1(MmStandaloneAIInterpretationRepo r1, String r2, c r3, c r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$meetingId = r2;
            this.$activeLanguage = r3;
            this.$language = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            AnonymousClass1 r6 = new AnonymousClass1(this.this$0, this.$meetingId, this.$activeLanguage, this.$language, r9);
            r6.L$0 = r8;
            return r6;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Pair<g, g>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            Object r2 = this.L$0;
            ResultKt.throwOnFailure(r13);
        L19:
            return TuplesKt.to(r2, r13);
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            Deferred r3 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(r13);
        L14:
            this.L$0 = r13;
            this.label = 2;
            Object r4 = r3.await(this);
            if (r4 != r0) goto L17;
            return r0;
        L17:
            r2 = r13;
            r13 = r4;
            goto L19
        L10:
            ResultKt.throwOnFailure(r13);
            CoroutineScope r14 = (CoroutineScope) this.L$0;
            Deferred r5 = BuildersKt.async$default(r14, null, null, new MmStandaloneAIInterpretationRepo$opt$2$1$switchTargetLanguage$2$1$closeDeferred$1(this.this$0, this.$meetingId, this.$activeLanguage, null), 3, null);
            Deferred r15 = BuildersKt.async$default(r14, null, null, new MmStandaloneAIInterpretationRepo$opt$2$1$switchTargetLanguage$2$1$enableDeferred$1(this.this$0, this.$meetingId, this.$language, null), 3, null);
            this.L$0 = r15;
            this.label = 1;
            Object r6 = r5.await(this);
            if (r6 != r0) goto L13;
            return r0;
        L13:
            r3 = r15;
            r13 = r6;
            goto L14
        }
    }

    public MmStandaloneAIInterpretationRepo$opt$2$1$switchTargetLanguage$2(MmStandaloneAIInterpretationRepo$opt$2.AnonymousClass1 r1, MmStandaloneAIInterpretationRepo r2, c r3, String r4, Continuation<? super MmStandaloneAIInterpretationRepo$opt$2$1$switchTargetLanguage$2> r5) {
        this.this$0 = r1;
        this.this$1 = r2;
        this.$language = r3;
        this.$meetingId = r4;
        super(1, r5);
    }

    public final Continuation<Unit> create(Continuation<?> r8) {
        return new MmStandaloneAIInterpretationRepo$opt$2$1$switchTargetLanguage$2(this.this$0, this.this$1, this.$language, this.$meetingId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super g> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        Integer r5 = null;
        boolean r6 = true;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        c r2 = (c) this.L$0;
        ResultKt.throwOnFailure(r14);
    L37:
        Pair r15 = (Pair) r14;
        g r3 = (g) r15.component1();
        g r16 = (g) r15.component2();
        if (r3 != null) goto L40;
    L42:
        r6 = false;
    L43:
        if (r6 == true) goto L49;
        String r17 = this.this$1.l;
        StringBuilder r4 = new StringBuilder("[switchTargetLanguage] close current failed, current=");
        r4.append(r2.a);
        r4.append(", target=");
        r4.append(this.$language.a);
        r4.append(", status=");
        if (r3 == null) goto L47;
        r5 = Boxing.boxInt(r3.b);
    L47:
        r4.append(r5);
        lvb.a.b(r17, r4.toString());
        return r3;
    L49:
        return r16;
    L40:
        if (r3.a() != true) goto L42;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r14);
    L53:
        return r14;
    L11:
        c r7 = (c) this.L$1;
        b r8 = (b) this.L$0;
        ResultKt.throwOnFailure(r14);
    L27:
        MmStandaloneAIInterpretationRepo r9 = this.this$1;
        MmStandaloneAIInterpretationRepo.Companion r10 = MmStandaloneAIInterpretationRepo.t;
        r9.getClass();
        return new g(MmStandaloneAIInterpretationRepo.y(r7), 1, r8.b, r8.c, r8.d, r8.e, null, this.$language);
    L12:
        ResultKt.throwOnFailure(r14);
        r8 = (b) this.this$0.m();
        c r18 = r8.i;
        String r11 = this.this$1.l;
        StringBuilder r12 = new StringBuilder("[switchTargetLanguage] current=");
        if (r18 == null) goto L15;
        String r13 = r18.a;
    L16:
        r12.append(r13);
        r12.append(", target=");
        r12.append(this.$language.a);
        r12.append(", enabled=");
        r12.append(r8.a);
        lvb.a.e(r11, r12.toString());
        if (r8.a == false) goto L30;
        if (r18 == null) goto L20;
        String r19 = r18.a;
    L22:
        if (Intrinsics.areEqual(r19, this.$language.a) == false) goto L30;
        MmStandaloneAIInterpretationRepo r20 = this.this$1;
        b r21 = b.b(r8, this.$language, null, 447);
        this.L$0 = r8;
        this.L$1 = r18;
        this.label = 1;
        if (r20.b(r21, this) != r0) goto L26;
        return r0;
    L26:
        r7 = r18;
        goto L27
    L20:
        r19 = null;
    L30:
        if (r8.a == false) goto L50;
        if (r18 == null) goto L50;
        AnonymousClass1 r22 = new AnonymousClass1(this.this$1, this.$meetingId, r18, this.$language, null);
        this.L$0 = r18;
        this.label = 3;
        Object r23 = CoroutineScopeKt.coroutineScope(r22, this);
        if (r23 != r0) goto L36;
        return r0;
    L36:
        r2 = r18;
        r14 = r23;
    L50:
        MmStandaloneAIInterpretationRepo r110 = this.this$1;
        String r24 = this.$meetingId;
        c r25 = this.$language;
        this.label = 2;
        r14 = MmStandaloneAIInterpretationRepo.r(r110, r24, true, r25, this);
        if (r14 != r0) goto L53;
        return r0;
    L15:
        r13 = null;
        goto L16
    }
}
