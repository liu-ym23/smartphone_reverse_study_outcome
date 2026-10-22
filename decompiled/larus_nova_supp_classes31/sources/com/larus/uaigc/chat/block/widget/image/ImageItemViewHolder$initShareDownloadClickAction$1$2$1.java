package com.larus.uaigc.chat.block.widget.image;

import com.larus.im.bean.message.CreationGenDetail;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.ImageData;
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
@DebugMetadata(c = "com.larus.uaigc.chat.block.widget.image.ImageItemViewHolder$initShareDownloadClickAction$1$2$1", f = "ImageItemViewHolder.kt", i = {}, l = {366}, m = "invokeSuspend", n = {}, s = {})
final class ImageItemViewHolder$initShareDownloadClickAction$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ cz9.h $imageData;
    int label;
    final /* synthetic */ ImageItemViewHolder this$0;

    public ImageItemViewHolder$initShareDownloadClickAction$1$2$1(cz9.h r1, ImageItemViewHolder r2, Continuation<? super ImageItemViewHolder$initShareDownloadClickAction$1$2$1> r3) {
        this.$imageData = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ImageItemViewHolder$initShareDownloadClickAction$1$2$1(this.$imageData, this.this$0, r4);
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
    L46:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        CreationItem r11 = this.$imageData.d;
        Integer r2 = null;
        if (r11 == null) goto L13;
        ImageData r3 = r11.image;
        if (r3 == null) goto L13;
        ImageInfo r4 = bz9.a.j(r3, r11.genDetail);
    L14:
        ImageOperatorComponent r5 = (ImageOperatorComponent) this.this$0.l.getValue();
        JSONObject r6 = new JSONObject();
        cz9.h r12 = this.$imageData;
        ImageItemViewHolder r7 = this.this$0;
        r6.putOpt("position", Boxing.boxInt(r12.f + 1));
        cz9.h r8 = r7.q;
        if (r8 == null) goto L19;
        CreationItem r9 = r8.d;
        if (r9 == null) goto L19;
        String r13 = r9.id;
    L20:
        r6.putOpt("creation_task_id", r13);
        ICreationMetadataService.Companion r14 = ICreationMetadataService.a;
        cz9.h r15 = r7.q;
        if (r15 == null) goto L23;
        Message r16 = r15.e;
    L24:
        if (r15 == null) goto L28;
        CreationItem r17 = r15.d;
        if (r17 == null) goto L28;
        String r18 = r17.id;
    L29:
        UserCreationFromIM r19 = r14.I(r16, r18, String.valueOf(r12.f));
        if (r19 == null) goto L32;
        String r110 = r19.getCreationId();
    L33:
        r6.putOpt("creation_id", r110);
        Unit r111 = Unit.INSTANCE;
        Message r112 = this.$imageData.e;
        if (r112 == null) goto L36;
        String r20 = r112.getMessageId();
    L37:
        CreationItem r113 = this.$imageData.d;
        if (r113 == null) goto L42;
        CreationGenDetail r114 = r113.genDetail;
        if (r114 == null) goto L42;
        r2 = r114.taskType;
    L42:
        this.label = 1;
        if (r5.e(r4, r6, r20, r2, this) != r0) goto L46;
        return r0;
    L36:
        r20 = null;
        goto L37
    L32:
        r110 = null;
    L28:
        r18 = null;
        goto L29
    L23:
        r16 = null;
    L19:
        r13 = null;
    L13:
        r4 = null;
        goto L14
    }
}
