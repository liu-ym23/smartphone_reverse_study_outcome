package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.event.SubtitleSource;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingPullSubtitlesResponse;
import com.ss.android.lark.pb.minutes.v1.RecordingSubtitleData;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo$opt$2$1$handleFetchSubtitlesResponse$1", f = "MmRecordingSubtitleRepo.kt", i = {}, l = {927, 940, 961, 972, 985, 996}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingSubtitleRepo$opt$2$1$handleFetchSubtitlesResponse$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isForward;
    final /* synthetic */ long $requestLanguageRevision;
    final /* synthetic */ String $requestTranslateLanguage;
    final /* synthetic */ MinutesRecordingPullSubtitlesResponse $response;
    final /* synthetic */ SubtitleSource $source;
    final /* synthetic */ Long $targetSeqId;
    int label;
    final /* synthetic */ MmRecordingSubtitleRepo$opt$2.AnonymousClass1 this$0;
    final /* synthetic */ MmRecordingSubtitleRepo this$1;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(((RecordingSubtitleData) r1).seg_id, ((RecordingSubtitleData) r2).seg_id);
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((h) r3).a), Long.valueOf(((h) r4).a));
        }
    }

    public static final class c<T> implements Comparator {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((h) r3).a), Long.valueOf(((h) r4).a));
        }
    }

    public MmRecordingSubtitleRepo$opt$2$1$handleFetchSubtitlesResponse$1(MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r1, long r2, MmRecordingSubtitleRepo r4, String r5, SubtitleSource r6, MinutesRecordingPullSubtitlesResponse r7, Long r8, boolean r9, Continuation<? super MmRecordingSubtitleRepo$opt$2$1$handleFetchSubtitlesResponse$1> r10) {
        this.this$0 = r1;
        this.$requestLanguageRevision = r2;
        this.this$1 = r4;
        this.$requestTranslateLanguage = r5;
        this.$source = r6;
        this.$response = r7;
        this.$targetSeqId = r8;
        this.$isForward = r9;
        super(1, r10);
    }

    public final Continuation<Unit> create(Continuation<?> r13) {
        return new MmRecordingSubtitleRepo$opt$2$1$handleFetchSubtitlesResponse$1(this.this$0, this.$requestLanguageRevision, this.this$1, this.$requestTranslateLanguage, this.$source, this.$response, this.$targetSeqId, this.$isForward, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r22) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(this.label) {
            case 0: goto L9;
            case 1: goto L8;
            case 2: goto L7;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        ResultKt.throwOnFailure(r22);
    L154:
        return Unit.INSTANCE;
    L7:
        ResultKt.throwOnFailure(r22);
    L90:
        return Unit.INSTANCE;
    L8:
        ResultKt.throwOnFailure(r22);
    L74:
        return Unit.INSTANCE;
    L9:
        ResultKt.throwOnFailure(r22);
        long r2 = this.this$0.c.get();
        if (this.$requestLanguageRevision == r2) goto L12;
        boolean r4 = true;
    L14:
        if (r4 == false) goto L17;
        lvb.a.h(this.this$1.m, "[handleFetchSubtitlesResponse] drop stale request, language=" + this.$requestTranslateLanguage + ", requestRevision=" + this.$requestLanguageRevision + ", currentRevision=" + r2 + ", source=" + this.$source);
        return Unit.INSTANCE;
    L17:
        String r3 = this.$requestTranslateLanguage;
        if ((!StringsKt.isBlank(r3)) == true) goto L21;
        r3 = null;
    L21:
        if (r3 != null) goto L23;
        r3 = this.this$1.k.o();
    L23:
        List<RecordingSubtitleData> r5 = this.$response.subtitles;
        if (r5 != null) goto L26;
        r5 = CollectionsKt.emptyList();
    L26:
        MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r6 = this.this$0;
        ArrayList r8 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L28:
        if (r7.hasNext() == false) goto L37;
        Object r9 = r7.next();
        RecordingSubtitleData r11 = (RecordingSubtitleData) r9;
        if (Intrinsics.areEqual(r3, "source") == false) goto L34;
        Intrinsics.checkNotNull(r11);
        if (r6.e1(r11) == false) goto L34;
        boolean r10 = true;
    L35:
        if (r10 == true) goto L28;
        r8.add(r9);
    L34:
        r10 = false;
        goto L35
    L37:
        List<RecordingSubtitleData> r12 = this.$response.subtitles;
        if (r12 != null) goto L40;
    L42:
        boolean r13 = false;
    L43:
        if (r13 == false) goto L48;
        if (r8.isEmpty() == false) goto L48;
        lvb.a.h(this.this$1.m, "[handleFetchSubtitlesResponse] drop all source-incompatible subtitles, current=" + r3 + ", source=" + this.$source);
    L48:
        if (Intrinsics.areEqual(r3, "source") == true) goto L53;
        MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r14 = this.this$0;
        Iterator r15 = r8.iterator();
    L51:
        if (r15.hasNext() == false) goto L53;
        RecordingSubtitleData r16 = (RecordingSubtitleData) r15.next();
        Intrinsics.checkNotNull(r16);
        r14.X0(r16);
    L53:
        List r17 = CollectionsKt.sortedWith(r8, new a());
        MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r18 = this.this$0;
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r20 = r17.iterator();
    L55:
        if (r20.hasNext() == false) goto L57;
        RecordingSubtitleData r110 = (RecordingSubtitleData) r20.next();
        rvb.f r111 = (rvb.f) r18.q.getValue();
        Intrinsics.checkNotNull(r110);
        r19.add(r111.b(r110, false, null, null, null));
        goto L55
    L57:
        d r112 = (d) this.this$0.m();
        String r21 = this.this$1.m;
        StringBuilder r23 = new StringBuilder("[handleFetchSubtitlesResponse] accept, source=");
        r23.append(this.$source);
        r23.append(", targetSeqId=");
        r23.append(this.$targetSeqId);
        r23.append(", isForward=");
        r23.append(this.$isForward);
        r23.append(", language=");
        r23.append(this.$requestTranslateLanguage);
        r23.append(", revision=");
        r23.append(this.$requestLanguageRevision);
        r23.append(", responseCount=");
        List<RecordingSubtitleData> r24 = this.$response.subtitles;
        if (r24 == null) goto L60;
        int r25 = r24.size();
    L61:
        r23.append(r25);
        r23.append(", acceptedCount=");
        r23.append(r8.size());
        r23.append(", newCount=");
        r23.append(r19.size());
        r23.append(", current=");
        r23.append(MmRecordingSubtitleRepo$opt$2.AnonymousClass1.V0(this.this$0, r112.a));
        r23.append(", new=");
        r23.append(MmRecordingSubtitleRepo$opt$2.AnonymousClass1.V0(this.this$0, r19));
        r23.append(", hasMore=");
        r23.append(this.$response.has_more);
        r23.append(", nextSeqId=");
        r23.append(this.$response.next_target_seg_id);
        lvb.a.e(r21, r23.toString());
        long r26 = 0;
        if (this.$targetSeqId != null) goto L76;
        MmRecordingSubtitleRepo r27 = this.this$1;
        Long r28 = this.$response.next_target_seg_id;
        if (r28 == null) goto L66;
        r26 = r28.longValue();
    L66:
        Boolean r29 = this.$response.has_more;
        if (r29 == null) goto L69;
        boolean r113 = r29.booleanValue();
    L70:
        d r30 = d.a(r112, r19, r26, r113, null, false, false, false, 120);
        this.label = 1;
        if (r27.b(r30, this) != r1) goto L74;
        return r1;
    L69:
        r113 = false;
        goto L70
    L76:
        if (r19.isEmpty() == true) goto L78;
        List r114 = CollectionsKt.toMutableList(r112.a);
        if (this.$isForward == false) goto L124;
        if ((!r114.isEmpty()) == true) goto L96;
    L107:
        r114.addAll(0, r19);
        HashSet r31 = new HashSet();
        ArrayList r32 = new ArrayList();
        Iterator r33 = r114.iterator();
    L109:
        if (r33.hasNext() == false) goto L113;
        Object r34 = r33.next();
        if (r31.add(Boxing.boxLong(((h) r34).a)) == false) goto L109;
        r32.add(r34);
        goto L109
    L113:
        List r35 = CollectionsKt.sortedWith(r32, new b());
        MmRecordingSubtitleRepo r36 = this.this$1;
        d r37 = (d) this.this$0.m();
        Long r38 = this.$response.next_target_seg_id;
        if (r38 == null) goto L116;
        r26 = r38.longValue();
    L116:
        long r115 = r26;
        Boolean r39 = this.$response.has_more;
        if (r39 == null) goto L119;
        boolean r116 = r39.booleanValue();
    L120:
        d r40 = d.a(r37, r35, r115, r116, null, false, false, false, 120);
        this.label = 4;
        if (r36.b(r40, this) != r1) goto L154;
        return r1;
    L119:
        r116 = false;
        goto L120
    L96:
        if (((h) CollectionsKt.last(r19)).a >= ((h) CollectionsKt.first(r114)).a) goto L107;
        r114.addAll(0, r19);
        MmRecordingSubtitleRepo r41 = this.this$1;
        d r117 = (d) this.this$0.m();
        Long r42 = this.$response.next_target_seg_id;
        if (r42 == null) goto L100;
        r26 = r42.longValue();
    L100:
        long r118 = r26;
        Boolean r43 = this.$response.has_more;
        if (r43 == null) goto L103;
        boolean r119 = r43.booleanValue();
    L104:
        d r44 = d.a(r117, r114, r118, r119, null, false, false, false, 120);
        this.label = 3;
        if (r41.b(r44, this) != r1) goto L154;
        return r1;
    L103:
        r119 = false;
        goto L104
    L124:
        if ((!r114.isEmpty()) == true) goto L126;
    L137:
        r114.addAll(r19);
        HashSet r45 = new HashSet();
        ArrayList r46 = new ArrayList();
        Iterator r47 = r114.iterator();
    L139:
        if (r47.hasNext() == false) goto L143;
        Object r48 = r47.next();
        if (r45.add(Boxing.boxLong(((h) r48).a)) == false) goto L139;
        r46.add(r48);
        goto L139
    L143:
        List r49 = CollectionsKt.sortedWith(r46, new c());
        MmRecordingSubtitleRepo r50 = this.this$1;
        d r51 = (d) this.this$0.m();
        Long r52 = this.$response.next_target_seg_id;
        if (r52 == null) goto L146;
        r26 = r52.longValue();
    L146:
        long r120 = r26;
        Boolean r53 = this.$response.has_more;
        if (r53 == null) goto L149;
        boolean r121 = r53.booleanValue();
    L150:
        d r54 = d.a(r51, r49, r120, r121, null, false, false, false, 120);
        this.label = 6;
        if (r50.b(r54, this) != r1) goto L154;
        return r1;
    L149:
        r121 = false;
        goto L150
    L126:
        if (((h) CollectionsKt.first(r19)).a <= ((h) CollectionsKt.last(r114)).a) goto L137;
        r114.addAll(r19);
        MmRecordingSubtitleRepo r55 = this.this$1;
        d r122 = (d) this.this$0.m();
        Long r56 = this.$response.next_target_seg_id;
        if (r56 == null) goto L130;
        r26 = r56.longValue();
    L130:
        long r123 = r26;
        Boolean r57 = this.$response.has_more;
        if (r57 == null) goto L133;
        boolean r124 = r57.booleanValue();
    L134:
        d r58 = d.a(r122, r114, r123, r124, null, false, false, false, 120);
        this.label = 5;
        if (r55.b(r58, this) != r1) goto L154;
        return r1;
    L133:
        r124 = false;
        goto L134
    L78:
        if (this.$isForward == true) goto L90;
        MmRecordingSubtitleRepo r59 = this.this$1;
        Long r60 = this.$response.next_target_seg_id;
        if (r60 == null) goto L82;
        r26 = r60.longValue();
    L82:
        long r125 = r26;
        Boolean r61 = this.$response.has_more;
        if (r61 == null) goto L85;
        boolean r126 = r61.booleanValue();
    L86:
        d r62 = d.a(r112, null, r125, r126, null, false, false, false, 121);
        this.label = 2;
        if (r59.b(r62, this) != r1) goto L90;
        return r1;
    L85:
        r126 = false;
        goto L86
    L60:
        r25 = 0;
        goto L61
    L40:
        if ((!r12.isEmpty()) != true) goto L42;
        r13 = true;
        goto L43
    L12:
        r4 = false;
        goto L14
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
