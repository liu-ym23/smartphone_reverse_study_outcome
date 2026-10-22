package com.larus.bmhome.chat.layout.holder.image;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.UserCreationFromIM;
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
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.image.ScrollImageViewHolder$doSaveImage$3", f = "ImageScrollAdapter.kt", i = {}, l = {613}, m = "invokeSuspend", n = {}, s = {})
final class ScrollImageViewHolder$doSaveImage$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ UserCreationFromIM $creationInfo;
    int label;
    final /* synthetic */ ScrollImageViewHolder this$0;

    public ScrollImageViewHolder$doSaveImage$3(UserCreationFromIM r1, ScrollImageViewHolder r2, Continuation<? super ScrollImageViewHolder$doSaveImage$3> r3) {
        this.$creationInfo = r1;
        this.this$0 = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new ScrollImageViewHolder$doSaveImage$3(this.$creationInfo, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L25:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        IFlowSdkDepend r8 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r8 == null) goto L25;
        r8.w();
        com.larus.home.impl.sdk.k1 r9 = com.larus.home.impl.sdk.k1.a;
        UserCreationFromIM r2 = this.$creationInfo;
        String r3 = null;
        if (r2 == null) goto L13;
        String r4 = r2.getCreationId();
    L14:
        ScrollImageViewHolder r5 = this.this$0;
        m0 r6 = r5.j;
        if (r6 == null) goto L17;
        String r10 = r6.e;
    L18:
        Message r11 = r5.k;
        if (r11 == null) goto L21;
        r3 = r11.getMessageId();
    L21:
        this.label = 1;
        if (r9.h1(r4, r10, r3, this) != r0) goto L25;
        return r0;
    L17:
        r10 = null;
        goto L18
    L13:
        r4 = null;
        goto L14
    }
}
