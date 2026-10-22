package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.MmSpeakerMappingSyncSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.helper.MmSubtitleSmoothType;
import com.ss.android.lark.pb.minutes.v1.RecordingSubtitleData;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo$opt$2$1$entityToViewModel$1", f = "MmRecordingSubtitleRepo.kt", i = {}, l = {1175}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingSubtitleRepo$opt$2$1$entityToViewModel$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ RecordingSubtitleData $data;
    final /* synthetic */ String $smoothContent;
    final /* synthetic */ MmSubtitleSmoothType $smoothType;
    int label;
    final /* synthetic */ MmRecordingSubtitleRepo$opt$2.AnonymousClass1 this$0;
    final /* synthetic */ MmRecordingSubtitleRepo this$1;

    public MmRecordingSubtitleRepo$opt$2$1$entityToViewModel$1(MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r1, RecordingSubtitleData r2, MmSubtitleSmoothType r3, String r4, MmRecordingSubtitleRepo r5, Continuation<? super MmRecordingSubtitleRepo$opt$2$1$entityToViewModel$1> r6) {
        this.this$0 = r1;
        this.$data = r2;
        this.$smoothType = r3;
        this.$smoothContent = r4;
        this.this$1 = r5;
        super(1, r6);
    }

    public final Continuation<Unit> create(Continuation<?> r9) {
        return new MmRecordingSubtitleRepo$opt$2$1$entityToViewModel$1(this.this$0, this.$data, this.$smoothType, this.$smoothContent, this.this$1, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r20);
    L74:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r20);
        List r5 = CollectionsKt.toMutableList(((d) this.this$0.m()).a);
        int r3 = r5.size();
        Long r4 = this.$data.seg_id;
        if (r4 == null) goto L11;
        long r8 = r4.longValue();
    L12:
        int r6 = j.a(r5, r8);
        rvb.f r11 = (rvb.f) this.this$0.q.getValue();
        RecordingSubtitleData r12 = this.$data;
        MmSubtitleSmoothType r15 = this.$smoothType;
        String r10 = this.$smoothContent;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r5, "currentList");
        Intrinsics.checkNotNullParameter(r12, "data");
        Long r13 = r12.seg_id;
        if (r13 == null) goto L15;
        long r14 = r13.longValue();
    L16:
        int r7 = j.a(r5, r14);
        boolean r9 = false;
        if (r7 >= 0) goto L19;
        int r16 = -(r7 + 1);
        if (r14 != 0) goto L28;
    L65:
        this.this$1.k.h().l().A0(MmSpeakerMappingSyncSource.SUBTITLE_PUSH);
        if (r9 == false) goto L71;
        int r17 = j.a(r5, r8);
        h r18 = (h) CollectionsKt.getOrNull(r5, r17);
        String r19 = this.this$1.m;
        StringBuilder r110 = new StringBuilder("[entityToViewModel] changed, segId=");
        r110.append(r8);
        r110.append(", sliceId=");
        r110.append(this.$data.slice_id);
        r110.append(", isFinal=");
        r110.append(this.$data.is_seg_final);
        r110.append(", smoothType=");
        r110.append(this.$smoothType);
        r110.append(", oldIndex=");
        r110.append(r6);
        r110.append(", newIndex=");
        r110.append(r17);
        r110.append(", oldCount=");
        r110.append(r3);
        r110.append(", newCount=");
        r110.append(r5.size());
        r110.append(", item=");
        this.this$0.getClass();
        r110.append(MmRecordingSubtitleRepo$opt$2.AnonymousClass1.f1(r18));
        r110.append(", list=");
        r110.append(MmRecordingSubtitleRepo$opt$2.AnonymousClass1.V0(this.this$0, r5));
        lvb.a.e(r19, r110.toString());
        MmRecordingSubtitleRepo r21 = this.this$1;
        d r22 = d.a((d) this.this$0.m(), r5, 0, false, null, false, false, false, 126);
        this.label = 1;
        if (r21.b(r22, this) != r1) goto L74;
        return r1;
    L71:
        if (this.$data.is_seg_final.booleanValue() == false) goto L74;
        lvb.a.e(this.this$1.m, "[entityToViewModel] unchanged final, segId=" + r8 + ", sliceId=" + this.$data.slice_id + ", smoothType=" + this.$smoothType + ", oldIndex=" + r6 + ", count=" + r3);
        goto L74
    L28:
        if (Intrinsics.areEqual(r11.b.o(), "source") == false) goto L44;
        RecordingSubtitleData.Subtitle r111 = r12.source;
        if (r111 == null) goto L39;
        String r112 = r111.content;
        if (r112 == null) goto L39;
        if (r112.length() <= 0) goto L36;
        boolean r113 = true;
    L37:
        if (r113 != true) goto L39;
        boolean r114 = true;
    L40:
        if (r114 == false) goto L42;
    L53:
        boolean r115 = true;
    L55:
        if (r115 == false) goto L65;
        if (r12.sound_type == RecordingSubtitleData.SoundType.NOISE) goto L65;
        h r23 = r11.b(r12, true, null, r15, r10);
        if (r16 >= 0) goto L61;
    L63:
        r5.add(r23);
    L64:
        r9 = true;
        goto L65
    L61:
        if (r16 > r5.size()) goto L63;
        ListProtector.add(r5, r16, r23);
        goto L64
    L42:
        if (r11.a(r12) == true) goto L53;
    L54:
        r115 = false;
        goto L55
    L36:
        r113 = false;
    L39:
        r114 = false;
        goto L40
    L44:
        RecordingSubtitleData.Subtitle r116 = r12.target;
        if (r116 == null) goto L54;
        String r117 = r116.content;
        if (r117 == null) goto L54;
        if (r117.length() <= 0) goto L51;
        boolean r118 = true;
    L52:
        if (r118 != true) goto L54;
    L51:
        r118 = false;
        goto L52
    L19:
        if (r12.sound_type != RecordingSubtitleData.SoundType.NOISE) goto L21;
        ListProtector.remove(r5, r7);
        goto L64
    L21:
        h r119 = (h) ListProtector.get(r5, r7);
        h r120 = r11.b(r12, true, r119, r15, r10);
        if (Intrinsics.areEqual(r119, r120) == true) goto L65;
        ListProtector.set(r5, r7, r120);
        goto L64
    L15:
        r14 = 0;
        goto L16
    L11:
        r8 = 0;
        goto L12
    }
}
