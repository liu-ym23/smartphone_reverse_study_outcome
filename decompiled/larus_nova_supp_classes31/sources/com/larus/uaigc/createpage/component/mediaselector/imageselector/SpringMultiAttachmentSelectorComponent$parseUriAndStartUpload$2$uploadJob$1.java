package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.bytedance.common.utility.NetworkUtils;
import com.larus.bmhome.upload.ResourceUploader;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.upload.UploadDataType;
import com.tencent.open.log.TraceLevel;
import java.util.UUID;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.SpringMultiAttachmentSelectorComponent$parseUriAndStartUpload$2$uploadJob$1", f = "SpringMultiAttachmentSelectorComponent.kt", i = {}, l = {366}, m = "invokeSuspend", n = {}, s = {})
final class SpringMultiAttachmentSelectorComponent$parseUriAndStartUpload$2$uploadJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $localResPath;
    final /* synthetic */ String $resourceKey;
    int label;
    final /* synthetic */ SpringMultiAttachmentSelectorComponent this$0;

    public SpringMultiAttachmentSelectorComponent$parseUriAndStartUpload$2$uploadJob$1(SpringMultiAttachmentSelectorComponent r1, String r2, String r3, Continuation<? super SpringMultiAttachmentSelectorComponent$parseUriAndStartUpload$2$uploadJob$1> r4) {
        this.this$0 = r1;
        this.$resourceKey = r2;
        this.$localResPath = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new SpringMultiAttachmentSelectorComponent$parseUriAndStartUpload$2$uploadJob$1(this.this$0, this.$resourceKey, this.$localResPath, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r29) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r29);
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r29);
        StringBuilder r3 = new StringBuilder();
        r3.append(UUID.randomUUID());
        r3.append('_');
        r3.append(System.currentTimeMillis());
        final String r4 = r3.toString();
        final SpringMultiAttachmentSelectorComponent r5 = this.this$0;
        final String r6 = this.$resourceKey;
        com.larus.utils.t0.e(new r4(r5, r6));
        this.this$0.t.put(this.$resourceKey, r4);
        final SpringMultiAttachmentSelectorComponent r7 = this.this$0;
        final String r8 = this.$localResPath;
        final String r9 = this.$resourceKey;
        Function1 r12 = new s4(r7, r9);
        Function1 r10 = new t4(r7, r4, r8, r9);
        Function1 r11 = new u4(r7, r9);
        this.label = 1;
        r7.getClass();
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == false) goto L14;
        Object r13 = ResourceUploader.a.j(new mr9.j(r8, "bot_chat", UploadDataType.IMAGE, r10, r11, r12, false, null, null, null, r4, true, new CountDownLatch(1), null, null, null, null, null, null, null, 2081728), this);
        if (r13 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        r13 = Unit.INSTANCE;
    L15:
        if (r13 != r1) goto L18;
        return r1;
    L14:
        com.larus.utils.t0.e(new h4(r7, r9, r8));
        r7.h3(false, "upload");
        r13 = Unit.INSTANCE;
        goto L15
    }
}
