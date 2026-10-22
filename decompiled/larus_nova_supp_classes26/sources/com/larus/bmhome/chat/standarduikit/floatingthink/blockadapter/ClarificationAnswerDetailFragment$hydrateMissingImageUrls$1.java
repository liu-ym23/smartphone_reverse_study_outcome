package com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter;

import com.larus.bmhome.chat.standarduikit.floatingthink.utils.ClarificationAnswerAttachmentPreviewer;
import com.larus.bmhome.view.resourcebar.bean.Mode;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.im.bean.message.UplinkFileEntity;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import v19.i5;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.ClarificationAnswerDetailFragment$hydrateMissingImageUrls$1", f = "ClarificationAnswerDetailFragment.kt", i = {}, l = {279}, m = "invokeSuspend", n = {}, s = {})
final class ClarificationAnswerDetailFragment$hydrateMissingImageUrls$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<UplinkFileEntity> $entities;
    final /* synthetic */ List<ClarificationAnswerDetailFragment.d> $items;
    int label;
    final /* synthetic */ ClarificationAnswerDetailFragment this$0;

    public ClarificationAnswerDetailFragment$hydrateMissingImageUrls$1(List<UplinkFileEntity> r1, ClarificationAnswerDetailFragment r2, List<ClarificationAnswerDetailFragment.d> r3, Continuation<? super ClarificationAnswerDetailFragment$hydrateMissingImageUrls$1> r4) {
        this.$entities = r1;
        this.this$0 = r2;
        this.$items = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ClarificationAnswerDetailFragment$hydrateMissingImageUrls$1(this.$entities, this.this$0, this.$items, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.b, java.lang.Object] */
    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L11:
        final List r16 = (List) r15;
        if (Intrinsics.areEqual(r16, this.$entities) == true) goto L33;
        ClarificationAnswerDetailFragment.ClarificationAnswerDetailAdapter r2 = this.this$0.i;
        List<ClarificationAnswerDetailFragment.d> r3 = this.$items;
        final Ref.IntRef r4 = new Ref.IntRef();
        List<ClarificationAnswerDetailFragment.d> r5 = r3;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r7 = r5.iterator();
    L15:
        if (r7.hasNext() == false) goto L31;
        ClarificationAnswerDetailFragment.d r8 = (ClarificationAnswerDetailFragment.d) r7.next();
        ?? r9 = new b(r16, r4);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "entityProvider");
        List<ClarificationAnswerDetailFragment.a> r10 = r8.d;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r12 = r10.iterator();
    L18:
        if (r12.hasNext() == false) goto L30;
        ClarificationAnswerDetailFragment.a r13 = (ClarificationAnswerDetailFragment.a) r12.next();
        UplinkFileEntity r14 = (UplinkFileEntity) r9.invoke();
        if (r14 != null) goto L22;
        r14 = r13.a;
    L22:
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "newEntity");
        Mode r17 = Mode.SHOW;
        if (n1.d(r14) == false) goto L25;
    L28:
        int r18 = i5.w0();
    L29:
        ResourceItemBean r19 = com.larus.bmhome.chat.c.a(r14, r17, r18, 0, 60);
        Intrinsics.checkNotNullParameter(r14, "entity");
        Intrinsics.checkNotNullParameter(r19, "resourceItem");
        r11.add(new ClarificationAnswerDetailFragment.a(r14, r19));
        goto L18
    L25:
        if (n1.e(r14) == true) goto L28;
        r18 = i5.y();
        goto L29
    L30:
        String r20 = r8.a;
        String r21 = r8.b;
        String r22 = r8.c;
        Intrinsics.checkNotNullParameter(r20, "questionId");
        Intrinsics.checkNotNullParameter(r21, "questionTitle");
        Intrinsics.checkNotNullParameter(r22, "answerText");
        Intrinsics.checkNotNullParameter(r11, "attachments");
        r6.add(new ClarificationAnswerDetailFragment.d(r20, r21, r22, r11));
        goto L15
    L31:
        r2.submitList(r6);
    L33:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        ClarificationAnswerAttachmentPreviewer r110 = ClarificationAnswerAttachmentPreviewer.a;
        List<UplinkFileEntity> r23 = this.$entities;
        this.label = 1;
        r15 = r110.d(r23, this);
        if (r15 != r0) goto L11;
        return r0;
    }
}
