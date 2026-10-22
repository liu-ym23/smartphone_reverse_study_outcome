package com.ss.android.lark.flow.chat.message.image;

import android.content.Context;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/widget/photopicker/entity/PhotoItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.image.FlowChatImageClickListener$onImageClick$1$photoItems$1", f = "FlowChatImageClickListener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FlowChatImageClickListener$onImageClick$1$photoItems$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<PhotoItem>>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $clickedMsgId;
    int label;
    final /* synthetic */ FlowChatImageClickListener this$0;

    public FlowChatImageClickListener$onImageClick$1$photoItems$1(FlowChatImageClickListener r1, Ref.ObjectRef<String> r2, Continuation<? super FlowChatImageClickListener$onImageClick$1$photoItems$1> r3) {
        this.this$0 = r1;
        this.$clickedMsgId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FlowChatImageClickListener$onImageClick$1$photoItems$1(this.this$0, this.$clickedMsgId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<PhotoItem>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r5);
        int r6 = FlowMediaPreviewUtils.a;
        Context r7 = this.this$0.getContext();
        String r0 = (String) this.$clickedMsgId.element;
        FlowChatImageClickListener r1 = this.this$0;
        return FlowMediaPreviewUtils.b(r7, r0, null, r1.c, (kza.d) r1.f.getValue());
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
