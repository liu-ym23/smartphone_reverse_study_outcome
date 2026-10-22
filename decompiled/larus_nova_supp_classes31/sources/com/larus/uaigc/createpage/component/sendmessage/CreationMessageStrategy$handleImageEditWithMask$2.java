package com.larus.uaigc.createpage.component.sendmessage;

import com.larus.im.bean.message.Message;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import com.larus.uaigc.service.ICreationResourceAccessService;
import com.tencent.open.log.TraceLevel;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.sendmessage.CreationMessageStrategy$handleImageEditWithMask$2", f = "CreationMessageStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CreationMessageStrategy$handleImageEditWithMask$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CreationSendMessageConfig $config;
    final /* synthetic */ ImageEditDataWithMask $imageEditDataWithMask;
    final /* synthetic */ Message $imageMsg;
    final /* synthetic */ String $sendImgPath;
    final /* synthetic */ String $sendUploadIdentifier;
    final /* synthetic */ Message $textMsg;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CreationMessageStrategy this$0;

    public CreationMessageStrategy$handleImageEditWithMask$2(ImageEditDataWithMask r1, String r2, String r3, CreationMessageStrategy r4, Message r5, CreationSendMessageConfig r6, Message r7, Continuation<? super CreationMessageStrategy$handleImageEditWithMask$2> r8) {
        this.$imageEditDataWithMask = r1;
        this.$sendImgPath = r2;
        this.$sendUploadIdentifier = r3;
        this.this$0 = r4;
        this.$imageMsg = r5;
        this.$config = r6;
        this.$textMsg = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        CreationMessageStrategy$handleImageEditWithMask$2 r9 = new CreationMessageStrategy$handleImageEditWithMask$2(this.$imageEditDataWithMask, this.$sendImgPath, this.$sendUploadIdentifier, this.this$0, this.$imageMsg, this.$config, this.$textMsg, r12);
        r9.L$0 = r11;
        return r9;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r31) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r31);
        CoroutineScope r1 = (CoroutineScope) this.L$0;
        final Deferred r13 = BuildersKt.async$default(r1, null, null, new CreationMessageStrategy$handleImageEditWithMask$2$uploadMaskJob$1(this.$imageEditDataWithMask, this.this$0, null), 3, null);
        String r2 = this.$imageEditDataWithMask.getOriImgUri();
        if (r2 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
        final Deferred r11 = BuildersKt.async$default(r1, null, null, new CreationMessageStrategy$handleImageEditWithMask$2$uploadOriginalJob$1(this.$imageEditDataWithMask, this.this$0, null), 3, null);
    L14:
        ICreationResourceAccessService.Companion r4 = ICreationResourceAccessService.a;
        int r5 = com.larus.uaigc.service.p0.x;
        CountDownLatch r6 = new CountDownLatch(1);
        String r20 = StringsKt.substringAfterLast$default(this.$sendImgPath, '.', null, 2, null);
        com.larus.bmhome.resource.access.d0 r27 = com.larus.uaigc.service.g.a;
        final String r7 = this.$sendImgPath;
        String r8 = this.$sendUploadIdentifier;
        final CreationMessageStrategy r9 = this.this$0;
        final Message r10 = this.$imageMsg;
        Function1 r15 = new k(r9, r10);
        final ImageEditDataWithMask r12 = this.$imageEditDataWithMask;
        final CreationSendMessageConfig r14 = this.$config;
        final Message r16 = this.$textMsg;
        r4.b(com.larus.uaigc.service.p0.a.c(r7, r8, null, null, true, r6, r20, "ai_beautify", "send_image_edit", r15, new l(r7, r11, r12, r13, r14, r9, r10, r16), new m(r9, r10, r16, r14), null, r27, null, 1818680));
        return Unit.INSTANCE;
    L13:
        r11 = null;
        goto L14
    L7:
        if (r2.length() == 0) goto L10;
        r3 = false;
        goto L11
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
