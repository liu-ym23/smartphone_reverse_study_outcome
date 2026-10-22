package com.larus.bmhome.double_post.fragment;

import com.larus.bmhome.video.Content;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.double_post.fragment.AwemeDoublePostViewModel$prefetchData$1", f = "AwemeDoublePostViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AwemeDoublePostViewModel$prefetchData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Content> $pendingData;
    int label;
    final /* synthetic */ AwemeDoublePostViewModel this$0;

    public AwemeDoublePostViewModel$prefetchData$1(AwemeDoublePostViewModel r1, List<Content> r2, Continuation<? super AwemeDoublePostViewModel$prefetchData$1> r3) {
        this.this$0 = r1;
        this.$pendingData = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AwemeDoublePostViewModel$prefetchData$1(this.this$0, this.$pendingData, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L39;
        ResultKt.throwOnFailure(r6);
        Function0 r7 = AwemeDoublePostViewModel.access$getFunctionGetItemIdList$p(this.this$0);
        if (r7 == null) goto L21;
        List r8 = (List) r7.invoke();
        if (r8 == null) goto L21;
        List r9 = r8;
        if ((r9 instanceof Collection) == true) goto L11;
    L13:
        Iterator r10 = r9.iterator();
    L15:
        if (r10.hasNext() == false) goto L12;
        if (o0.d((String) r10.next()) == false) goto L15;
        boolean r11 = true;
    L19:
        if (r11 != true) goto L21;
        boolean r12 = true;
    L22:
        if (r12 == true) goto L24;
        List<Content> r13 = this.$pendingData;
        if (r13 != null) goto L28;
    L31:
        boolean r14 = true;
    L33:
        if (r14 == true) goto L35;
        FLogger.a.i("AwemeDoublePostViewModel", "prefetchData: pendingData size = " + this.$pendingData.size());
        AwemeDoublePostViewModel.access$get_awemeContentList$p(this.this$0).setValue(new v(0, this.$pendingData));
        AwemeDoublePostViewModel.access$setHasMore$p(this.this$0, true);
    L37:
        return Unit.INSTANCE;
    L35:
        FLogger.a.i("AwemeDoublePostViewModel", "prefetchData...");
        AwemeDoublePostViewModel.access$get_awemeContentList$p(this.this$0).postValue(new v(-1, null));
        goto L37
    L28:
        if (r13.isEmpty() == true) goto L31;
        r14 = false;
        goto L33
    L24:
        return Unit.INSTANCE;
    L12:
        r11 = false;
        goto L19
    L11:
        if (r9.isEmpty() == false) goto L13;
    L21:
        r12 = false;
        goto L22
    L39:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
