package com.larus.dora.impl.dynamic;

import com.larus.dora.impl.databinding.LarusDoraPageDynamicListBinding;
import com.larus.dora.impl.dynamic.widget.NestedDynamicPageView;
import com.larus.dora.impl.dynamic.widget.NewcomerGuideWidget;
import com.larus.platform.model.NewcomerGuideItem;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.DoraDynamicFragment$registerWakeupListener$1$onVUIPlayState$1", f = "DoraDynamicFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraDynamicFragment$registerWakeupListener$1$onVUIPlayState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraDynamicFragment this$0;

    public DoraDynamicFragment$registerWakeupListener$1$onVUIPlayState$1(DoraDynamicFragment r1, Continuation<? super DoraDynamicFragment$registerWakeupListener$1$onVUIPlayState$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraDynamicFragment$registerWakeupListener$1$onVUIPlayState$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r12);
        DoraDynamicFragment r13 = this.this$0;
        int r0 = DoraDynamicFragment.C;
        List r14 = (List) r13.ba0().getNewcomerGuideConfigFlow().getValue();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r15 = r14.iterator();
    L6:
        if (r15.hasNext() == false) goto L8;
        r1.add(NewcomerGuideItem.copy$default((NewcomerGuideItem) r15.next(), null, null, null, null, null, false, 31, null));
        goto L6
    L8:
        this.this$0.ba0().updateNewcomerGuideConfig(r1);
        LarusDoraPageDynamicListBinding r16 = this.this$0.f;
        if (r16 == null) goto L16;
        NestedDynamicPageView r17 = r16.c;
        if (r17 == null) goto L16;
        NewcomerGuideWidget r18 = r17.getNewcomerGuideWidget();
        if (r18 == null) goto L16;
        r18.setThinkingMode(false);
    L16:
        return Unit.INSTANCE;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
