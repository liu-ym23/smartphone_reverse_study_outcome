package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\"\u0010\u0000\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00050\u0001H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/speaker/MmMarkedSpeaker;", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.MmRecordingSpeakerRepo$opt$2$1$syncAllSpeakerMappings$2", f = "MmRecordingSpeakerRepo.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingSpeakerRepo$opt$2$1$syncAllSpeakerMappings$2 extends SuspendLambda implements Function1<Continuation<? super Pair<? extends Map<String, ? extends c>, ? extends Set<? extends String>>>, Object> {
    final /* synthetic */ MmSpeakerMappingSyncSource $source;
    int label;
    final /* synthetic */ MmRecordingSpeakerRepo this$0;
    final /* synthetic */ MmRecordingSpeakerRepo$opt$2.AnonymousClass1 this$1;

    public MmRecordingSpeakerRepo$opt$2$1$syncAllSpeakerMappings$2(MmSpeakerMappingSyncSource r1, MmRecordingSpeakerRepo r2, MmRecordingSpeakerRepo$opt$2.AnonymousClass1 r3, Continuation<? super MmRecordingSpeakerRepo$opt$2$1$syncAllSpeakerMappings$2> r4) {
        this.$source = r1;
        this.this$0 = r2;
        this.this$1 = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new MmRecordingSpeakerRepo$opt$2$1$syncAllSpeakerMappings$2(this.$source, this.this$0, this.this$1, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Pair<? extends Map<String, c>, ? extends Set<String>>> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L15:
        f r9 = (f) this.this$1.m();
        return new Pair(r9.b, r9.c);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        MmSpeakerMappingSyncSource r10 = this.$source;
        if (r10 != MmSpeakerMappingSyncSource.SPEAKER_INFO_CHANGE_PUSH) goto L11;
    L12:
        MmRecordingSpeakerRepo r11 = this.this$0;
        f r2 = f.a((f) this.this$1.m(), false, null, SetsKt.emptySet(), 3);
        this.label = 1;
        if (r11.b(r2, this) != r0) goto L15;
        return r0;
    L11:
        if (r10 != MmSpeakerMappingSyncSource.MANUAL_MARK) goto L15;
        goto L12
    }
}
