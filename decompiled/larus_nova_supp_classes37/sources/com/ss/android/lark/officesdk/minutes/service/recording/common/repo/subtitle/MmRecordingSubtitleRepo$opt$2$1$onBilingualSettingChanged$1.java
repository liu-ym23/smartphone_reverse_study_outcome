package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

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
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo$opt$2$1$onBilingualSettingChanged$1", f = "MmRecordingSubtitleRepo.kt", i = {}, l = {420}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingSubtitleRepo$opt$2$1$onBilingualSettingChanged$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isBilingual;
    int label;
    final /* synthetic */ MmRecordingSubtitleRepo$opt$2.AnonymousClass1 this$0;
    final /* synthetic */ MmRecordingSubtitleRepo this$1;

    public MmRecordingSubtitleRepo$opt$2$1$onBilingualSettingChanged$1(MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r1, MmRecordingSubtitleRepo r2, boolean r3, Continuation<? super MmRecordingSubtitleRepo$opt$2$1$onBilingualSettingChanged$1> r4) {
        this.this$0 = r1;
        this.this$1 = r2;
        this.$isBilingual = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new MmRecordingSubtitleRepo$opt$2$1$onBilingualSettingChanged$1(this.this$0, this.this$1, this.$isBilingual, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r3 = true;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r19);
    L48:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r19);
        d r4 = (d) this.this$0.m();
        String r5 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.f) this.this$1.k.l().l().b().getValue()).c.a;
        String r6 = this.this$1.k.o();
        MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r7 = this.this$0;
        boolean r8 = this.$isBilingual;
        r7.getClass();
        boolean r9 = false;
        if (r8 == true) goto L11;
    L18:
        boolean r15 = false;
    L20:
        if (r4.e == r15) goto L22;
        if (r15 == true) goto L25;
        lvb.a.e(this.this$1.m, "[onBilingualSettingChanged] disable bilingual, clear source smooth cache");
        this.this$0.c1().a();
    L25:
        this.this$0.g.a(r15);
        MmRecordingSubtitleRepo r10 = this.this$1;
        List<h> r11 = r4.a;
        MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r14 = this.this$0;
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r16 = r11.iterator();
    L27:
        if (r16.hasNext() == false) goto L44;
        h r12 = (h) r16.next();
        rvb.d r17 = r14.g;
        r17.getClass();
        Intrinsics.checkNotNullParameter(r12, "model");
        Intrinsics.checkNotNullParameter(r5, "sourceLang");
        Intrinsics.checkNotNullParameter(r6, "targetLang");
        if (r15 == true) goto L32;
        r12.o = r9;
        r12.n = r9;
    L39:
        String r18 = r5;
    L43:
        ArrayList r20 = r13;
        r20.add(h.a(r12, null, null, null, false, r15, 28671));
        r13 = r20;
        r14 = r14;
        r5 = r18;
        r3 = true;
        r9 = false;
        goto L27
    L32:
        if (rvb.e.a(r5, r6) == false) goto L35;
        rvb.e.b(r12, r12.e, r12.f);
        goto L39
    L35:
        if (r17.c == false) goto L39;
        if (r12.o == true) goto L39;
        String r110 = r12.e;
        String r111 = r12.f;
        r12.o = r3;
        float r21 = j.b(StringsKt.take(r110, r17.j), StringsKt.take(r111, r17.j));
        r18 = r5;
        lvb.a.a(r17.b, "tryProcessBilingualSimilarity, similarity=" + r21 + ", sourceContent=" + r110 + ", targetContent=" + r111);
        if (r21 <= r17.i) goto L43;
        r12.n = true;
        goto L43
    L44:
        d r22 = d.a(r4, r13, 0, false, null, r15, false, false, 110);
        this.label = 1;
        if (r10.b(r22, this) != r1) goto L48;
        return r1;
    L22:
        return Unit.INSTANCE;
    L11:
        if (r6.length() <= 0) goto L13;
        boolean r23 = true;
    L14:
        if (r23 == false) goto L18;
        if (Intrinsics.areEqual(r6, "source") == true) goto L18;
        r15 = true;
        goto L20
    L13:
        r23 = false;
        goto L14
    }
}
