package com.larus.community.impl.template;

import com.larus.community.impl.databinding.LarusCommunityTemplateCreationFragmentLayoutBinding;
import com.larus.community.impl.widget.CreationLoadingAndRetryView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "pageState", "Lcom/larus/community/impl/view/PageState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.template.TemplateCreationFragment$initView$1$7", f = "TemplateCreationFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TemplateCreationFragment$initView$1$7 extends SuspendLambda implements Function2<r29.k, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TemplateCreationFragment this$0;

    public TemplateCreationFragment$initView$1$7(TemplateCreationFragment r1, Continuation<? super TemplateCreationFragment$initView$1$7> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        TemplateCreationFragment$initView$1$7 r0 = new TemplateCreationFragment$initView$1$7(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((r29.k) r1, (Continuation) r2);
    }

    public final Object invoke(r29.k r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r2);
        r29.k r3 = (r29.k) this.L$0;
        LarusCommunityTemplateCreationFragmentLayoutBinding r0 = this.this$0.e;
        if (r0 == null) goto L10;
        CreationLoadingAndRetryView r1 = r0.c;
        if (r1 == null) goto L10;
        r1.R5(r3);
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
