package com.larus.bmhome.chat.layout.holder.menu.item;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.home.impl.sdk.k1;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.menu.item.SaveSearchImageMenuHandler$handleAction$2", f = "SaveMenuItem.kt", i = {}, l = {549}, m = "invokeSuspend", n = {}, s = {})
public final class SaveSearchImageMenuHandler$handleAction$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $creationId;
    final /* synthetic */ String $creationTaskId;
    final /* synthetic */ ef8.b $menuContext;
    int label;

    public SaveSearchImageMenuHandler$handleAction$2(String r1, String r2, ef8.b r3, Continuation<? super SaveSearchImageMenuHandler$handleAction$2> r4) {
        this.$creationId = r1;
        this.$creationTaskId = r2;
        this.$menuContext = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new SaveSearchImageMenuHandler$handleAction$2(this.$creationId, this.$creationTaskId, this.$menuContext, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        IFlowSdkDepend r7 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r7 == null) goto L14;
        r7.w();
        k1 r8 = k1.a;
        String r2 = this.$creationId;
        String r3 = this.$creationTaskId;
        String r4 = this.$menuContext.a.getMessageId();
        this.label = 1;
        if (r8.h1(r2, r3, r4, this) != r0) goto L14;
        return r0;
    }
}
