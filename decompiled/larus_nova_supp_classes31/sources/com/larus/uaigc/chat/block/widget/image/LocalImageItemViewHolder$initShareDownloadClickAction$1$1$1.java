package com.larus.uaigc.chat.block.widget.image;

import com.larus.im.bean.message.CreationGenDetail;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.ImageInfo;
import com.larus.uaigc.chat.markdown.image.component.ImageOperatorComponent;
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
@DebugMetadata(c = "com.larus.uaigc.chat.block.widget.image.LocalImageItemViewHolder$initShareDownloadClickAction$1$1$1", f = "LocalImageItemViewHolder.kt", i = {}, l = {233}, m = "invokeSuspend", n = {}, s = {})
final class LocalImageItemViewHolder$initShareDownloadClickAction$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ cz9.m $imageData;
    final /* synthetic */ ImageInfo $imageInfo;
    int label;
    final /* synthetic */ LocalImageItemViewHolder this$0;

    public LocalImageItemViewHolder$initShareDownloadClickAction$1$1$1(LocalImageItemViewHolder r1, ImageInfo r2, cz9.m r3, Continuation<? super LocalImageItemViewHolder$initShareDownloadClickAction$1$1$1> r4) {
        this.this$0 = r1;
        this.$imageInfo = r2;
        this.$imageData = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new LocalImageItemViewHolder$initShareDownloadClickAction$1$1$1(this.this$0, this.$imageInfo, this.$imageData, r5);
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
    L28:
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
        cz9.m r12 = r2.q;
        if (r12 == null) goto L13;
        CreationItem r13 = r12.d;
        if (r13 == null) goto L13;
        String r14 = r13.id;
    L14:
        r5.putOpt("creation_task_id", r14);
        Unit r15 = Unit.INSTANCE;
        Message r16 = this.$imageData.e;
        if (r16 == null) goto L17;
        String r6 = r16.getMessageId();
    L18:
        CreationItem r17 = this.$imageData.d;
        if (r17 == null) goto L23;
        CreationGenDetail r18 = r17.genDetail;
        if (r18 == null) goto L23;
        Integer r7 = r18.taskType;
    L24:
        this.label = 1;
        if (ez9.b.a(r3, r4, r5, r6, r7, this) != r0) goto L28;
        return r0;
    L23:
        r7 = null;
        goto L24
    L17:
        r6 = null;
    L13:
        r14 = null;
        goto L14
    }
}
