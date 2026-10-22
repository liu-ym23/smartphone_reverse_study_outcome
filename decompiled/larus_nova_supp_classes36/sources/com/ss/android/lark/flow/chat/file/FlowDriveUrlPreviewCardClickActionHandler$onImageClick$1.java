package com.ss.android.lark.flow.chat.file;

import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryItemType;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryType;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.preview.entity.component.property.DocImageProperty;
import com.ss.android.lark.flow.chat.message.image.FlowMediaPreviewUtils;
import com.ss.android.lark.flow.chat.message.image.model.FlowMediaMessageType;
import com.ss.android.lark.flow.chat.message.image.model.FlowPhotoItem;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kza.d;
import kza.l;
import kza.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.file.FlowDriveUrlPreviewCardClickActionHandler$onImageClick$1", f = "FlowDriveUrlPreviewCardClickActionHandler.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
final class FlowDriveUrlPreviewCardClickActionHandler$onImageClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DocImageProperty $docImageProperty;
    final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b $featureEnv;
    final /* synthetic */ String $messageId;
    final /* synthetic */ IMessageListViewModel $viewModel;
    int label;
    final /* synthetic */ a this$0;

    public FlowDriveUrlPreviewCardClickActionHandler$onImageClick$1(DocImageProperty r1, String r2, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r3, IMessageListViewModel r4, a r5, Continuation<? super FlowDriveUrlPreviewCardClickActionHandler$onImageClick$1> r6) {
        this.$docImageProperty = r1;
        this.$messageId = r2;
        this.$featureEnv = r3;
        this.$viewModel = r4;
        this.this$0 = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new FlowDriveUrlPreviewCardClickActionHandler$onImageClick$1(this.$docImageProperty, this.$messageId, this.$featureEnv, this.$viewModel, this.this$0, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L11:
        List r2 = (List) r13;
        l r14 = new l(null, null, new ogb.a(this.$docImageProperty, 2), null, false, null, 239);
        GalleryType r4 = GalleryType.Image;
        String r3 = this.$messageId;
        if (r3 != null) goto L14;
        r3 = "";
    L14:
        m r5 = new m(r4, r14, null, r3, GalleryItemType.Lark, 0, null, 96);
        FlowPhotoItem r15 = new FlowPhotoItem(FlowMediaMessageType.Lark, r5);
        int r6 = FlowMediaPreviewUtils.a(r2, r15);
        if (r6 > (-1)) goto L17;
        Log.i("FlowDriveUrlPreviewCard", "onImageClick, currentPosition is -1, add selectItem to photoItems");
        r2.clear();
        r2.add(r15);
        int r7 = 0;
    L18:
        FlowMediaPreviewUtils.c(this.$featureEnv.getContext(), this.$featureEnv.getFragment(), r2, this.$featureEnv.a(), r7, this.$viewModel, (d) this.this$0.e.getValue(), (pgb.a) this.this$0.f.getValue());
        return Unit.INSTANCE;
    L17:
        r7 = r6;
        goto L18
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        CoroutineDispatcher r16 = Dispatchers.getIO();
        FlowDriveUrlPreviewCardClickActionHandler$onImageClick$1$photoItems$1 r8 = new FlowDriveUrlPreviewCardClickActionHandler$onImageClick$1$photoItems$1(this.this$0, this.$messageId, this.$viewModel, null);
        this.label = 1;
        r13 = BuildersKt.withContext(r16, r8, this);
        if (r13 != r0) goto L11;
        return r0;
    }
}
