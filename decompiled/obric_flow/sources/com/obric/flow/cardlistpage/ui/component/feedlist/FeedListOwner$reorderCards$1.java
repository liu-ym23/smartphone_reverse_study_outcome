package com.obric.flow.cardlistpage.ui.component.feedlist;

import com.obric.flow.cardlistpage.base.BaseCardModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.ui.component.feedlist.FeedListOwner", f = "FeedListOwner.kt", i = {0, 0}, l = {102}, m = "reorderCards", n = {"this", "reorderedCards"}, s = {"L$0", "L$1"})
final class FeedListOwner$reorderCards$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ u this$0;

    public FeedListOwner$reorderCards$1(u r5, Continuation<? super FeedListOwner$reorderCards$1> r10) {
        this.this$0 = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        u r11 = this.this$0;
        r11.getClass();
        int r5 = this.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r5 - Integer.MIN_VALUE;
    L6:
        Object r12 = this.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = this.label;
        if (r14 != 0) goto L9;
        ResultKt.throwOnFailure(r12);
        new ArrayList(CollectionsKt.h(null));
        throw null;
    L9:
        if (r14 != 1) goto L25;
        Iterator r15 = (Iterator) this.L$2;
        List r16 = (List) this.L$1;
        u r17 = (u) this.L$0;
        ResultKt.throwOnFailure(r12);
    L12:
        if (r15.hasNext() == false) goto L23;
        BaseCardModel r18 = (BaseCardModel) r15.next();
        mn.i r19 = r17.f11621c;
        this.L$0 = r17;
        this.L$1 = r16;
        this.L$2 = r15;
        this.label = 1;
        com.obric.flow.cardlistpage.domain.repository.b r20 = (com.obric.flow.cardlistpage.domain.repository.b) r19.f20153a;
        if (r20 == null) goto L19;
        Object r21 = r20.f(r18, this);
        if (r21 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        r21 = Unit.INSTANCE;
    L20:
        if (r21 != r13) goto L12;
        return r13;
    L19:
        r21 = Unit.INSTANCE;
        goto L20
    L23:
        return r16;
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        FeedListOwner$reorderCards$1 this = new FeedListOwner$reorderCards$1(r11, this);
        goto L6
    }
}
