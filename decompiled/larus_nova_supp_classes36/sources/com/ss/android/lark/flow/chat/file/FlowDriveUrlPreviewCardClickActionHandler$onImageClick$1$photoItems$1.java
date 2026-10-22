package com.ss.android.lark.flow.chat.file;

import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.flow.chat.message.image.FlowMediaPreviewUtils;
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
import kotlinx.coroutines.CoroutineScope;
import kza.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/widget/photopicker/entity/PhotoItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.file.FlowDriveUrlPreviewCardClickActionHandler$onImageClick$1$photoItems$1", f = "FlowDriveUrlPreviewCardClickActionHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FlowDriveUrlPreviewCardClickActionHandler$onImageClick$1$photoItems$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<PhotoItem>>, Object> {
    final /* synthetic */ String $messageId;
    final /* synthetic */ IMessageListViewModel $viewModel;
    int label;
    final /* synthetic */ a this$0;

    public FlowDriveUrlPreviewCardClickActionHandler$onImageClick$1$photoItems$1(a r1, String r2, IMessageListViewModel r3, Continuation<? super FlowDriveUrlPreviewCardClickActionHandler$onImageClick$1$photoItems$1> r4) {
        this.this$0 = r1;
        this.$messageId = r2;
        this.$viewModel = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new FlowDriveUrlPreviewCardClickActionHandler$onImageClick$1$photoItems$1(this.this$0, this.$messageId, this.$viewModel, r5);
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
        return FlowMediaPreviewUtils.b(this.this$0.getContext(), this.$messageId, null, this.$viewModel, (d) this.this$0.e.getValue());
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
