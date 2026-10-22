package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.utils.logger.FLogger;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatSender$uploadImageAfterAddMsg$1", f = "ChatSender.kt", i = {}, l = {841}, m = "invokeSuspend", n = {}, s = {})
public final class ChatSender$uploadImageAfterAddMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ResourceUploadError, Unit> $failedCallback;
    final /* synthetic */ String $fileExtension;
    final /* synthetic */ String $filePath;
    final /* synthetic */ mr9.c $instantUploadPolicy;
    final /* synthetic */ CountDownLatch $latch;
    final /* synthetic */ boolean $limitUploaderCount;
    final /* synthetic */ String $originPath;
    final /* synthetic */ Boolean $originPathIsUri;
    final /* synthetic */ Function1<mr9.k, Unit> $processCallback;
    final /* synthetic */ FlowResourceScene $resourceScene;
    final /* synthetic */ Function1<mr9.l, Unit> $successCallback;
    final /* synthetic */ UploadDataType $type;
    final /* synthetic */ String $uploadSourceScene;
    final /* synthetic */ String $uploaderIdentifier;
    int label;

    public ChatSender$uploadImageAfterAddMsg$1(String r1, FlowResourceScene r2, String r3, UploadDataType r4, Function1<? super mr9.l, Unit> r5, Function1<? super mr9.k, Unit> r6, Function1<? super ResourceUploadError, Unit> r7, String r8, boolean r9, CountDownLatch r10, String r11, Boolean r12, mr9.c r13, String r14, Continuation<? super ChatSender$uploadImageAfterAddMsg$1> r15) {
        this.$uploaderIdentifier = r1;
        this.$resourceScene = r2;
        this.$filePath = r3;
        this.$type = r4;
        this.$successCallback = r5;
        this.$processCallback = r6;
        this.$failedCallback = r7;
        this.$fileExtension = r8;
        this.$limitUploaderCount = r9;
        this.$latch = r10;
        this.$originPath = r11;
        this.$originPathIsUri = r12;
        this.$instantUploadPolicy = r13;
        this.$uploadSourceScene = r14;
        super(2, r15);
    }

    public final Continuation<Unit> create(Object r19, Continuation<?> r20) {
        return new ChatSender$uploadImageAfterAddMsg$1(this.$uploaderIdentifier, this.$resourceScene, this.$filePath, this.$type, this.$successCallback, this.$processCallback, this.$failedCallback, this.$fileExtension, this.$limitUploaderCount, this.$latch, this.$originPath, this.$originPathIsUri, this.$instantUploadPolicy, this.$uploadSourceScene, r20);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r27) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r27);
    L26:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r27);
        String r3 = this.$uploaderIdentifier;
        if (r3 != null) goto L11;
    L18:
        r3 = UUID.randomUUID().toString();
    L19:
        String r15 = r3;
        FlowResourceScene r4 = this.$resourceScene;
        if (r4 == null) goto L22;
        ResourceCenter.a.getClass();
        ResourceCenter.k(r15, r4);
    L22:
        mr9.j r5 = new mr9.j(this.$filePath, "bot_chat", this.$type, this.$successCallback, this.$processCallback, this.$failedCallback, false, null, null, this.$fileExtension, r15, this.$limitUploaderCount, this.$latch, null, this.$originPath, this.$originPathIsUri, this.$instantUploadPolicy, this.$uploadSourceScene, null, null, 1590208);
        FLogger.a.i("ChatSender", "[uploadImageAfterAddMsg] route to facade bridge, path=" + this.$filePath + ", type=" + this.$type);
        int r6 = com.larus.bmhome.upload.sdk.i.a;
        this.label = 1;
        if (com.larus.bmhome.upload.sdk.i.a(r5, "chat_sender_upload_image_after_add_msg", this) != r1) goto L26;
        return r1;
    L11:
        if (r3.length() <= 0) goto L13;
        boolean r7 = true;
    L14:
        if (r7 == true) goto L17;
        r3 = null;
    L17:
        if (r3 != null) goto L19;
    L13:
        r7 = false;
        goto L14
    }
}
