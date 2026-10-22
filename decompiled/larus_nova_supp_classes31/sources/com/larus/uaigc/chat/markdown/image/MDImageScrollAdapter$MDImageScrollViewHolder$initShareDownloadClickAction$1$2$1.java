package com.larus.uaigc.chat.markdown.image;

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
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.image.MDImageScrollAdapter$MDImageScrollViewHolder$initShareDownloadClickAction$1$2$1", f = "MDImageScrollAdapter.kt", i = {}, l = {392}, m = "invokeSuspend", n = {}, s = {})
final class MDImageScrollAdapter$MDImageScrollViewHolder$initShareDownloadClickAction$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ fz9.d $imageData;
    int label;
    final /* synthetic */ MDImageScrollAdapter.MDImageScrollViewHolder this$0;

    public MDImageScrollAdapter$MDImageScrollViewHolder$initShareDownloadClickAction$1$2$1(MDImageScrollAdapter.MDImageScrollViewHolder r1, fz9.d r2, Continuation<? super MDImageScrollAdapter$MDImageScrollViewHolder$initShareDownloadClickAction$1$2$1> r3) {
        this.this$0 = r1;
        this.$imageData = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MDImageScrollAdapter$MDImageScrollViewHolder$initShareDownloadClickAction$1$2$1(this.this$0, this.$imageData, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L43:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        ImageOperatorComponent r3 = (ImageOperatorComponent) this.this$0.j.getValue();
        ImageInfo r4 = this.$imageData.f;
        JSONObject r5 = new JSONObject();
        MDImageScrollAdapter.MDImageScrollViewHolder r12 = this.this$0;
        fz9.c r2 = r12.m;
        int r6 = 0;
        if (r2 == null) goto L13;
        Integer r7 = r2.getIndex();
        if (r7 == null) goto L13;
        int r8 = r7.intValue();
    L14:
        r5.putOpt("position", Boxing.boxInt(r8 + 1));
        fz9.c r9 = r12.m;
        if (r9 == null) goto L17;
        String r10 = r9.getTaskId();
    L18:
        r5.putOpt("creation_task_id", r10);
        ICreationMetadataService.Companion r13 = ICreationMetadataService.a;
        fz9.c r14 = r12.m;
        if (r14 == null) goto L21;
        Message r15 = r14.getMessage();
    L22:
        fz9.c r16 = r12.m;
        if (r16 == null) goto L25;
        String r17 = r16.getTaskId();
    L26:
        fz9.c r18 = r12.m;
        if (r18 == null) goto L31;
        Integer r19 = r18.getIndex();
        if (r19 == null) goto L31;
        r6 = r19.intValue();
    L31:
        UserCreationFromIM r110 = r13.I(r15, r17, String.valueOf(r6));
        if (r110 == null) goto L34;
        String r111 = r110.getCreationId();
    L35:
        r5.putOpt("creation_id", r111);
        Unit r112 = Unit.INSTANCE;
        Message r113 = this.$imageData.d;
        if (r113 == null) goto L38;
        String r20 = r113.getMessageId();
    L39:
        Integer r21 = this.$imageData.k;
        this.label = 1;
        if (r3.e(r4, r5, r20, r21, this) != r0) goto L43;
        return r0;
    L38:
        r20 = null;
        goto L39
    L34:
        r111 = null;
        goto L35
    L25:
        r17 = null;
        goto L26
    L21:
        r15 = null;
        goto L22
    L17:
        r10 = null;
    L13:
        r8 = 0;
        goto L14
    }
}
