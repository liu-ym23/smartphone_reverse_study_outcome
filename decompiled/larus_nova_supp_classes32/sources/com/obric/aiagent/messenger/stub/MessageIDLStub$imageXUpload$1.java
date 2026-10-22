package com.obric.aiagent.messenger.stub;

import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.upload.ResourceUploader;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.upload.UploadDataType;
import com.obric.aiagent.assistant.idl.IImageXUploadCallbackIDL;
import com.obric.aivoice.core.data.NameKeys;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.MessageIDLStub$imageXUpload$1", f = "MessageIDLStub.kt", i = {}, l = {626}, m = "invokeSuspend", n = {}, s = {})
public final class MessageIDLStub$imageXUpload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IImageXUploadCallbackIDL $callback;
    final /* synthetic */ String $uri;
    int label;
    final /* synthetic */ MessageIDLStub this$0;

    public MessageIDLStub$imageXUpload$1(IImageXUploadCallbackIDL r1, MessageIDLStub r2, String r3, Continuation<? super MessageIDLStub$imageXUpload$1> r4) {
        this.$callback = r1;
        this.this$0 = r2;
        this.$uri = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MessageIDLStub$imageXUpload$1(this.$callback, this.this$0, this.$uri, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r30) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r30);
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r30);
        final Ref.ObjectRef r3 = new Ref.ObjectRef();
        r3.element = this.$callback;
        long r4 = UUID.randomUUID().toString().hashCode() & Integer.MAX_VALUE;
        AppHost.Companion r7 = AppHost.a;
        final PolarisFileWrapper r6 = new PolarisFileWrapper(r7.getApplication().getFilesDir(), r4 + ".jpg");
        if (MessageIDLStub.access$saveFileProviderUriToFile(this.this$0, r7.getApplication(), UriProtector.parse(this.$uri), r6) == false) goto L14;
        ResourceUploader r5 = ResourceUploader.a;
        mr9.j r8 = new mr9.j(r6.getPath(), "bot_chat", UploadDataType.IMAGE, new x0(r3, r6), new y0(), new z0(r3, r6), false, null, null, null, null, true, new CountDownLatch(1), null, null, null, null, null, null, null, 2083776);
        this.label = 1;
        if (r5.j(r8, this) != r1) goto L14;
        return r1;
    }
}
