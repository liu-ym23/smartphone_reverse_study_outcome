package com.larus.doc.impl.chat.component;

import com.larus.doc.sdk.api.IDocSdkBaseService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import n39.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.chat.component.PageTaskInfoComponent$selectCurrentTextOrParagraph$1$1", f = "PageTaskInfoComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PageTaskInfoComponent$selectCurrentTextOrParagraph$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public PageTaskInfoComponent$selectCurrentTextOrParagraph$1$1(Continuation<? super PageTaskInfoComponent$selectCurrentTextOrParagraph$1$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new PageTaskInfoComponent$selectCurrentTextOrParagraph$1$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r2);
        IDocSdkBaseService r3 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r3 == null) goto L7;
        l r4 = r3.getPartialRewriteService();
    L8:
        if (r4 == null) goto L11;
        r4.enterStreamEditMode(new f());
    L11:
        return Unit.INSTANCE;
    L7:
        r4 = null;
        goto L8
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
