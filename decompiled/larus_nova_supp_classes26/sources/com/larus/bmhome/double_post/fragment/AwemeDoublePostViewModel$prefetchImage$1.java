package com.larus.bmhome.double_post.fragment;

import com.larus.bmhome.double_post.view.AwemeRecommendContentView;
import com.larus.bmhome.video.Content;
import com.larus.im.bean.message.ImageObj;
import com.larus.image.loader.ImageLoaderKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.double_post.fragment.AwemeDoublePostViewModel$prefetchImage$1", f = "AwemeDoublePostViewModel.kt", i = {}, l = {182}, m = "invokeSuspend", n = {}, s = {})
public final class AwemeDoublePostViewModel$prefetchImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Content> $data;
    Object L$0;
    int label;

    public AwemeDoublePostViewModel$prefetchImage$1(List<Content> r1, Continuation<? super AwemeDoublePostViewModel$prefetchImage$1> r2) {
        this.$data = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AwemeDoublePostViewModel$prefetchImage$1(this.$data, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Iterator r2 = (Iterator) this.L$0;
        ResultKt.throwOnFailure(r12);
    L10:
        if (r2.hasNext() == false) goto L19;
        Content r13 = (Content) r2.next();
        int r3 = AwemeRecommendContentView.f;
        ImageObj r4 = AwemeRecommendContentView.a.b(r13.getCover());
        if (r4 == null) goto L14;
        String r5 = r4.url;
    L15:
        String r6 = AwemeRecommendContentView.a.a(r13);
        this.L$0 = r2;
        this.label = 1;
        if (ImageLoaderKt.A(r5, r6, null, null, null, this, 60) != r0) goto L10;
        return r0;
    L14:
        r5 = null;
        goto L15
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        r2 = this.$data.iterator();
        goto L10
    }
}
