package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import android.os.SystemClock;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.event.SubtitleSource;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo$opt$2$1$syncAndFetchSubtitles$1$requestLanguageRevision$1", f = "MmRecordingSubtitleRepo.kt", i = {}, l = {673}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingSubtitleRepo$opt$2$1$syncAndFetchSubtitles$1$requestLanguageRevision$1 extends SuspendLambda implements Function1<Continuation<? super Long>, Object> {
    final /* synthetic */ Ref.BooleanRef $skipHistoryRefresh;
    final /* synthetic */ SubtitleSource $source;
    final /* synthetic */ String $translateLanguage;
    int label;
    final /* synthetic */ MmRecordingSubtitleRepo this$0;
    final /* synthetic */ MmRecordingSubtitleRepo$opt$2.AnonymousClass1 this$1;

    public MmRecordingSubtitleRepo$opt$2$1$syncAndFetchSubtitles$1$requestLanguageRevision$1(Ref.BooleanRef r1, MmRecordingSubtitleRepo r2, MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r3, SubtitleSource r4, String r5, Continuation<? super MmRecordingSubtitleRepo$opt$2$1$syncAndFetchSubtitles$1$requestLanguageRevision$1> r6) {
        this.$skipHistoryRefresh = r1;
        this.this$0 = r2;
        this.this$1 = r3;
        this.$source = r4;
        this.$translateLanguage = r5;
        super(1, r6);
    }

    public final Continuation<Unit> create(Continuation<?> r9) {
        return new MmRecordingSubtitleRepo$opt$2$1$syncAndFetchSubtitles$1$requestLanguageRevision$1(this.$skipHistoryRefresh, this.this$0, this.this$1, this.$source, this.$translateLanguage, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Long> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r22) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r22);
    L99:
        return Boxing.boxLong(this.this$1.c.get());
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r22);
        Ref.BooleanRef r3 = this.$skipHistoryRefresh;
        iub.k r4 = this.this$0.j.f;
        if (r4 == null) goto L11;
        MmRecordingSource r5 = r4.a;
    L12:
        String r6 = this.this$1.b;
        SubtitleSource r7 = this.$source;
        Intrinsics.checkNotNullParameter(r6, "previousLanguage");
        Intrinsics.checkNotNullParameter(r7, "source");
        if (r5 == MmRecordingSource.DOUBAO_STANDALONE_AI_INTERPRETATION) goto L15;
    L24:
        boolean r8 = false;
    L25:
        r3.element = r8;
        boolean r9 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.f) this.this$0.k.l().l().b().getValue()).e;
        MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r10 = this.this$1;
        String r11 = this.$translateLanguage;
        r10.getClass();
        if (r9 == true) goto L28;
    L35:
        boolean r12 = false;
    L36:
        this.this$1.g.a(r12);
        d r13 = (d) this.this$1.m();
        if (this.$translateLanguage.length() <= 0) goto L39;
        boolean r14 = true;
    L40:
        if (r14 == false) goto L75;
        if (Intrinsics.areEqual(this.$translateLanguage, this.this$1.b) == true) goto L75;
        String r15 = this.this$1.b;
        if (r15.length() <= 0) goto L46;
        boolean r16 = true;
    L47:
        if (r16 == false) goto L49;
        long r17 = this.this$1.c.incrementAndGet();
    L50:
        String r18 = this.$translateLanguage;
        SubtitleSource r19 = this.$source;
        Intrinsics.checkNotNullParameter(r15, "previousLanguage");
        Intrinsics.checkNotNullParameter(r18, "nextLanguage");
        Intrinsics.checkNotNullParameter(r19, "source");
        if (r15.length() <= 0) goto L53;
        boolean r20 = true;
    L54:
        if (r20 == true) goto L56;
    L67:
        boolean r21 = false;
    L68:
        long r110 = 0;
        this.this$1.d.set(0);
        String r23 = this.this$0.m;
        StringBuilder r24 = new StringBuilder("[syncAndFetchSubtitles] language changed, clear smooth cache and slice cache, old=");
        r24.append(r15);
        r24.append(", new=");
        r24.append(this.$translateLanguage);
        r24.append(", revision=");
        r24.append(r17);
        r24.append(", filterWindowMs=");
        if (r21 == false) goto L71;
        r110 = 3000;
    L71:
        r24.append(r110);
        lvb.a.e(r23, r24.toString());
        ((rvb.a) this.this$1.n.getValue()).a();
        this.this$1.c1().a();
        this.this$1.r.evictAll();
        this.this$1.b = this.$translateLanguage;
        if (r21 == false) goto L75;
        this.this$1.d.set(SystemClock.elapsedRealtime() + 3000);
        goto L75
    L56:
        if (r18.length() <= 0) goto L58;
        boolean r25 = true;
    L59:
        if (r25 == false) goto L67;
        if (Intrinsics.areEqual(r18, "source") == true) goto L67;
        if (Intrinsics.areEqual(r15, r18) == true) goto L67;
        if (r19 != SubtitleSource.LANGUAGE_CHANGE) goto L67;
        r21 = true;
        goto L68
    L58:
        r25 = false;
        goto L59
    L53:
        r20 = false;
        goto L54
    L49:
        r17 = this.this$1.c.get();
        goto L50
    L46:
        r16 = false;
    L75:
        if (r13.e == r12) goto L77;
        d r111 = d.a(r13, null, 0, false, null, r12, false, false, 111);
    L79:
        if (Intrinsics.areEqual(this.$translateLanguage, "source") == false) goto L94;
        if ((!r111.a.isEmpty()) == false) goto L94;
        MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r26 = this.this$1;
        List<h> r27 = r111.a;
        r26.getClass();
        List<h> r28 = r27;
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r28, 10));
        Iterator<T> r29 = r28.iterator();
    L84:
        if (r29.hasNext() == false) goto L92;
        h r113 = (h) r29.next();
        String r30 = r113.e;
        if (r30.length() != 0) goto L88;
        boolean r31 = true;
    L89:
        if (r31 == false) goto L91;
        r30 = r113.f;
    L91:
        String r114 = r30;
        r112.add(h.a(r113, r114, r114, null, false, false, 4047));
        goto L84
    L88:
        r31 = false;
        goto L89
    L92:
        r111 = d.a(r111, r112, 0, false, null, false, false, false, 126);
    L94:
        if (Intrinsics.areEqual(r111, r13) == true) goto L99;
        MmRecordingSubtitleRepo r32 = this.this$0;
        this.label = 1;
        if (r32.b(r111, this) != r1) goto L99;
        return r1;
    L77:
        r111 = r13;
        goto L79
    L39:
        r14 = false;
        goto L40
    L28:
        if (r11.length() <= 0) goto L30;
        boolean r33 = true;
    L31:
        if (r33 == false) goto L35;
        if (Intrinsics.areEqual(r11, "source") == true) goto L35;
        r12 = true;
        goto L36
    L30:
        r33 = false;
        goto L31
    L15:
        if (r6.length() <= 0) goto L17;
        boolean r34 = true;
    L18:
        if (r34 == false) goto L24;
        if (r7 != SubtitleSource.LANGUAGE_CHANGE) goto L22;
    L23:
        r8 = true;
        goto L25
    L22:
        if (r7 != SubtitleSource.BILINGUAL_SWITCH) goto L24;
    L17:
        r34 = false;
        goto L18
    L11:
        r5 = null;
        goto L12
    }
}
