package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmAudioSaveType;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/aiinterpretation/MmAIInterpretationUpdateResult;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.MmAIInterpretationRepo$opt$2$1$updateSetting$3", f = "MmAIInterpretationRepo.kt", i = {0, 1, 2}, l = {112, 120, 128, 134}, m = "invokeSuspend", n = {"updateResult", "updateResult", "updateResult"}, s = {"L$2", "L$0", "L$0"})
public final class MmAIInterpretationRepo$opt$2$1$updateSetting$3 extends SuspendLambda implements Function1<Continuation<? super p>, Object> {
    final /* synthetic */ boolean $emitStoppedEvent;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ g $language;
    final /* synthetic */ Object $result;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    boolean Z$1;
    int label;
    final /* synthetic */ MmAIInterpretationRepo this$0;
    final /* synthetic */ MmAIInterpretationRepo$opt$2.AnonymousClass1 this$1;

    public MmAIInterpretationRepo$opt$2$1$updateSetting$3(Object r1, MmAIInterpretationRepo r2, boolean r3, g r4, MmAIInterpretationRepo$opt$2.AnonymousClass1 r5, boolean r6, Continuation<? super MmAIInterpretationRepo$opt$2$1$updateSetting$3> r7) {
        this.$result = r1;
        this.this$0 = r2;
        this.$enabled = r3;
        this.$language = r4;
        this.this$1 = r5;
        this.$emitStoppedEvent = r6;
        super(1, r7);
    }

    public final Continuation<Unit> create(Continuation<?> r10) {
        return new MmAIInterpretationRepo$opt$2$1$updateSetting$3(this.$result, this.this$0, this.$enabled, this.$language, this.this$1, this.$emitStoppedEvent, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super p> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r22) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L13;
        if (r2 == 1) goto L12;
        if (r2 == 2) goto L11;
        if (r2 == 3) goto L11;
        if (r2 != 4) goto L10;
        ResultKt.throwOnFailure(r22);
        return null;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        p r3 = (p) this.L$0;
        ResultKt.throwOnFailure(r22);
        return r3;
    L12:
        boolean r4 = this.Z$1;
        boolean r5 = this.Z$0;
        p r6 = (p) this.L$2;
        g r8 = (g) this.L$1;
        MmAIInterpretationRepo r9 = (MmAIInterpretationRepo) this.L$0;
        ResultKt.throwOnFailure(r22);
    L31:
        b r10 = r9.k;
        MmAudioSaveType r11 = r9.o;
        if (r5 == true) goto L35;
        r8 = null;
    L35:
        int r12 = b.o;
        r10.d(r5, r11, r8, true);
        if (r5 == true) goto L52;
        if (r4 == false) goto L52;
        b r7 = r9.k;
        r7.getClass();
        lvb.a.e("MmAIInterpretationAudioController", "[onAIInterpretationStopped]");
        r7.j = false;
        i.a r13 = i.a.a;
        this.L$0 = r6;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 2;
        if (r9.k(r13, this) != r1) goto L41;
        return r1;
    L41:
        p r14 = r6;
    L53:
        return r14;
    L52:
        return r6;
    L13:
        ResultKt.throwOnFailure(r22);
        Object r15 = this.$result;
        r9 = this.this$0;
        boolean r16 = this.$enabled;
        g r17 = this.$language;
        MmAIInterpretationRepo$opt$2.AnonymousClass1 r18 = this.this$1;
        boolean r19 = this.$emitStoppedEvent;
        Throwable r110 = Result.exceptionOrNull-impl(r15);
        if (r110 != null) goto L47;
        r14 = (p) r15;
        if (r14.a() == false) goto L43;
        lvb.a.e(r9.n, "[updateSetting] success, enabled=" + r16 + ", status=" + r14.b + ", channel=" + r14.a + ", language=" + r17.a);
        if (r16 == false) goto L20;
        MmAIInterpretationRepo.l(r9, r17);
    L20:
        r9.p = null;
        d r20 = (d) r18.m();
        if (r16 == false) goto L23;
        g r111 = r17;
    L24:
        if (r16 == false) goto L26;
        g r21 = r17;
    L27:
        d r112 = d.a(r20, r16, null, r111, r21, false, false, null, 98);
        this.L$0 = r9;
        this.L$1 = r17;
        this.L$2 = r14;
        this.Z$0 = r16;
        this.Z$1 = r19;
        this.label = 1;
        if (r9.b(r112, this) != r1) goto L30;
        return r1;
    L30:
        r6 = r14;
        r4 = r19;
        r5 = r16;
        r8 = r17;
        goto L31
    L26:
        r21 = null;
        goto L27
    L23:
        r111 = ((d) r18.m()).c;
        goto L24
    L43:
        lvb.a.b(r9.n, "[updateSetting] business failed, status=" + r14.b + ", channel=" + r14.a + ", language=" + r17.a);
        d r23 = d.a((d) r18.m(), false, null, null, null, false, false, "update_failed", 47);
        this.L$0 = r14;
        this.label = 3;
        if (r9.b(r23, this) != r1) goto L53;
        return r1;
    L47:
        lvb.a.b(r9.n, "[updateSetting] failed: " + r110);
        d r24 = d.a((d) r18.m(), false, null, null, null, false, false, "update_failed", 47);
        this.label = 4;
        if (r9.b(r24, this) != r1) goto L54;
        return r1;
    L54:
        return null;
    }
}
