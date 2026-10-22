package com.larus.uaigc.chat.block.widget.image;

import com.larus.im.bean.message.CreationGenDetail;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.uaigc.chat.markdown.image.component.ImageOperatorComponent;
import com.larus.uaigc.service.ICreationMetadataService;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.widget.image.LocalImageItemViewHolder$initShareDownloadClickAction$1$2$1", f = "LocalImageItemViewHolder.kt", i = {}, l = {246}, m = "invokeSuspend", n = {}, s = {})
final class LocalImageItemViewHolder$initShareDownloadClickAction$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ cz9.m $imageData;
    final /* synthetic */ ImageInfo $imageInfo;
    int label;
    final /* synthetic */ LocalImageItemViewHolder this$0;

    public LocalImageItemViewHolder$initShareDownloadClickAction$1$2$1(LocalImageItemViewHolder r1, ImageInfo r2, cz9.m r3, Continuation<? super LocalImageItemViewHolder$initShareDownloadClickAction$1$2$1> r4) {
        this.this$0 = r1;
        this.$imageInfo = r2;
        this.$imageData = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new LocalImageItemViewHolder$initShareDownloadClickAction$1$2$1(this.this$0, this.$imageInfo, this.$imageData, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L40:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        ImageOperatorComponent r3 = (ImageOperatorComponent) this.this$0.l.getValue();
        ImageInfo r4 = this.$imageInfo;
        JSONObject r5 = new JSONObject();
        cz9.m r11 = this.$imageData;
        LocalImageItemViewHolder r2 = this.this$0;
        r5.putOpt("position", Boxing.boxInt(r11.f + 1));
        cz9.m r6 = r2.q;
        Integer r7 = null;
        if (r6 == null) goto L13;
        CreationItem r8 = r6.d;
        if (r8 == null) goto L13;
        String r9 = r8.id;
    L14:
        r5.putOpt("creation_task_id", r9);
        ICreationMetadataService.Companion r12 = ICreationMetadataService.a;
        cz9.m r13 = r2.q;
        if (r13 == null) goto L17;
        Message r14 = r13.e;
    L18:
        if (r13 == null) goto L22;
        CreationItem r15 = r13.d;
        if (r15 == null) goto L22;
        String r16 = r15.id;
    L23:
        UserCreationFromIM r17 = r12.I(r14, r16, String.valueOf(r11.f));
        if (r17 == null) goto L26;
        String r18 = r17.getCreationId();
    L27:
        r5.putOpt("creation_id", r18);
        Unit r19 = Unit.INSTANCE;
        Message r110 = this.$imageData.e;
        if (r110 == null) goto L30;
        String r20 = r110.getMessageId();
    L31:
        CreationItem r111 = this.$imageData.d;
        if (r111 == null) goto L36;
        CreationGenDetail r112 = r111.genDetail;
        if (r112 == null) goto L36;
        r7 = r112.taskType;
    L36:
        this.label = 1;
        if (r3.e(r4, r5, r20, r7, this) != r0) goto L40;
        return r0;
    L30:
        r20 = null;
        goto L31
    L26:
        r18 = null;
    L22:
        r16 = null;
        goto L23
    L17:
        r14 = null;
    L13:
        r9 = null;
        goto L14
    }
}
