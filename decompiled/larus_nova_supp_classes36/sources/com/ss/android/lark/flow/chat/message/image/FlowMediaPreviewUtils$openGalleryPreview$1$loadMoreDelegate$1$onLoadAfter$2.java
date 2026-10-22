package com.ss.android.lark.flow.chat.message.image;

import android.content.Context;
import com.ss.android.lark.biz.im.api.ImageHistoryResponse;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
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
import kza.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/biz/officesdk/im/mediapreview/OpenFeishuGalleryPreviewItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.image.FlowMediaPreviewUtils$openGalleryPreview$1$loadMoreDelegate$1$onLoadAfter$2", f = "FlowMediaPreviewUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FlowMediaPreviewUtils$openGalleryPreview$1$loadMoreDelegate$1$onLoadAfter$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends m>>, Object> {
    final /* synthetic */ String $chatId;
    final /* synthetic */ Context $context;
    final /* synthetic */ m $curItem;
    final /* synthetic */ Chat $currentChat;
    final /* synthetic */ kza.d $openFeishuGalleryPreviewDependency;
    final /* synthetic */ int $pageSize;
    int label;

    public FlowMediaPreviewUtils$openGalleryPreview$1$loadMoreDelegate$1$onLoadAfter$2(Context r1, Chat r2, String r3, m r4, int r5, kza.d r6, Continuation<? super FlowMediaPreviewUtils$openGalleryPreview$1$loadMoreDelegate$1$onLoadAfter$2> r7) {
        this.$context = r1;
        this.$currentChat = r2;
        this.$chatId = r3;
        this.$curItem = r4;
        this.$pageSize = r5;
        this.$openFeishuGalleryPreviewDependency = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new FlowMediaPreviewUtils$openGalleryPreview$1$loadMoreDelegate$1$onLoadAfter$2(this.$context, this.$currentChat, this.$chatId, this.$curItem, this.$pageSize, this.$openFeishuGalleryPreviewDependency, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<m>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r8);
        int r9 = g.a;
        return g.a(this.$context, this.$currentChat, this.$chatId, this.$curItem.d, ImageHistoryResponse.Direction.AFTER, this.$pageSize, this.$openFeishuGalleryPreviewDependency);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
