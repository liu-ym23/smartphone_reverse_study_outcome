package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmMarkedSpeakerType;
import com.ss.android.lark.pb.videochat.GetSpeakerInfoResponse;
import com.ss.android.lark.pb.videochat.Image;
import com.ss.android.lark.pb.videochat.LarkSpeakerInfo;
import com.ss.android.lark.pb.videochat.SpeakerInfo;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.MmRecordingSpeakerRepo$opt$2$1$syncAllSpeakerMappings$3$1", f = "MmRecordingSpeakerRepo.kt", i = {0, 0, 0}, l = {213}, m = "invokeSuspend", n = {"newMarkedSpeakerMap", "changed", "newNoMappingClusterIds"}, s = {"L$0", "L$1", "L$2"})
final class MmRecordingSpeakerRepo$opt$2$1$syncAllSpeakerMappings$3$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $missingSpeakerUserIds;
    final /* synthetic */ GetSpeakerInfoResponse $response;
    final /* synthetic */ MmSpeakerMappingSyncSource $source;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ MmRecordingSpeakerRepo$opt$2.AnonymousClass1 this$0;
    final /* synthetic */ MmRecordingSpeakerRepo this$1;

    public MmRecordingSpeakerRepo$opt$2$1$syncAllSpeakerMappings$3$1(MmRecordingSpeakerRepo$opt$2.AnonymousClass1 r1, GetSpeakerInfoResponse r2, List<String> r3, MmRecordingSpeakerRepo r4, MmSpeakerMappingSyncSource r5, Continuation<? super MmRecordingSpeakerRepo$opt$2$1$syncAllSpeakerMappings$3$1> r6) {
        this.this$0 = r1;
        this.$response = r2;
        this.$missingSpeakerUserIds = r3;
        this.this$1 = r4;
        this.$source = r5;
        super(1, r6);
    }

    public final Continuation<Unit> create(Continuation<?> r9) {
        return new MmRecordingSpeakerRepo$opt$2$1$syncAllSpeakerMappings$3$1(this.this$0, this.$response, this.$missingSpeakerUserIds, this.this$1, this.$source, r9);
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
        Set r3 = (Set) this.L$2;
        Ref.BooleanRef r4 = (Ref.BooleanRef) this.L$1;
        LinkedHashMap r5 = (LinkedHashMap) this.L$0;
        ResultKt.throwOnFailure(r20);
    L58:
        lvb.a.e(this.this$1.l, "[syncAllSpeakerMappings] success, source=" + this.$source + ", changed=" + r4.element + ", noMappingClusterIds=" + r3 + ", newMarkedSpeakerMap=" + r5);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r20);
        f r6 = (f) this.this$0.m();
        LinkedHashMap r7 = new LinkedHashMap(r6.b);
        Ref.BooleanRef r8 = new Ref.BooleanRef();
        Iterator<Map.Entry<String, SpeakerInfo>> r9 = this.$response.mspeaker_info_map.entrySet().iterator();
    L10:
        if (r9.hasNext() == false) goto L26;
        Map.Entry<String, SpeakerInfo> r10 = r9.next();
        String r11 = r10.getKey();
        SpeakerInfo r12 = r10.getValue();
        int r13 = c.g;
        Intrinsics.checkNotNull(r12);
        Intrinsics.checkNotNullParameter(r12, "speakerInfo");
        String r14 = r12.mid;
        if (r14 != null) goto L14;
        String r15 = "";
    L15:
        String r16 = r12.mname;
        if (r16 != null) goto L18;
        String r17 = "";
    L19:
        String r18 = r12.mavatar;
        if (r18 != null) goto L22;
        String r19 = "";
    L23:
        c r110 = new c(r15, r17, null, r19, null, MmMarkedSpeakerType.TEMPORARY, 20);
        if (Intrinsics.areEqual(r7.put(r11, r110), r110) == true) goto L10;
        r8.element = true;
        goto L10
    L22:
        r19 = r18;
        goto L23
    L18:
        r17 = r16;
        goto L19
    L14:
        r15 = r14;
        goto L15
    L26:
        Iterator<Map.Entry<String, LarkSpeakerInfo>> r21 = this.$response.mlark_speaker_info_map.entrySet().iterator();
    L28:
        if (r21.hasNext() == false) goto L48;
        Map.Entry<String, LarkSpeakerInfo> r22 = r21.next();
        String r23 = r22.getKey();
        LarkSpeakerInfo r24 = r22.getValue();
        int r111 = c.g;
        Intrinsics.checkNotNull(r24);
        Intrinsics.checkNotNullParameter(r24, "larkSpeakerInfo");
        String r112 = r24.mid;
        if (r112 != null) goto L32;
        String r113 = "";
    L33:
        String r114 = r24.mname;
        if (r114 != null) goto L36;
        String r115 = "";
    L37:
        String r116 = r24.mdepartment;
        if (r116 != null) goto L40;
        String r117 = "";
    L41:
        Image r25 = r24.mavatar;
        if (r25 == null) goto L44;
        d r118 = new d(r25.mkey, r25.mfs_unit);
    L45:
        c r26 = new c(r113, r115, r117, null, r118, MmMarkedSpeakerType.LARK_USER, 8);
        if (Intrinsics.areEqual(r7.put(r23, r26), r26) == true) goto L28;
        r8.element = true;
        goto L28
    L44:
        r118 = null;
        goto L45
    L40:
        r117 = r116;
        goto L41
    L36:
        r115 = r114;
        goto L37
    L32:
        r113 = r112;
        goto L33
    L48:
        Set r27 = SetsKt.plus(r6.c, this.$missingSpeakerUserIds);
        ArrayList r28 = new ArrayList();
        Iterator r29 = r27.iterator();
    L50:
        if (r29.hasNext() == false) goto L54;
        Object r30 = r29.next();
        if (r7.containsKey((String) r30) == true) goto L50;
        r28.add(r30);
        goto L50
    L54:
        Set r31 = CollectionsKt.toSet(r28);
        MmRecordingSpeakerRepo r32 = this.this$1;
        f r33 = f.a(r6, false, r7, r31, 1);
        this.L$0 = r7;
        this.L$1 = r8;
        this.L$2 = r31;
        this.label = 1;
        if (r32.b(r33, this) != r1) goto L57;
        return r1;
    L57:
        r5 = r7;
        r4 = r8;
        r3 = r31;
        goto L58
    }
}
