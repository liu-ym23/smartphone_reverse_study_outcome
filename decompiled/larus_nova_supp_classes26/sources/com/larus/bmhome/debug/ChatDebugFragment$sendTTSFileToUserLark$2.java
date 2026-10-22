package com.larus.bmhome.debug;

import com.larus.bmhome.share.panel.ShareType;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.debug.ChatDebugFragment$sendTTSFileToUserLark$2", f = "ChatDebugFragment.kt", i = {}, l = {515}, m = "invokeSuspend", n = {}, s = {})
final class ChatDebugFragment$sendTTSFileToUserLark$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BizResponse<String>>, Object> {
    final /* synthetic */ File $file;
    final /* synthetic */ String $userName;
    int label;

    public ChatDebugFragment$sendTTSFileToUserLark$2(File r1, String r2, Continuation<? super ChatDebugFragment$sendTTSFileToUserLark$2> r3) {
        this.$file = r1;
        this.$userName = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatDebugFragment$sendTTSFileToUserLark$2(this.$file, this.$userName, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super BizResponse<String>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        return r11;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        ChatDebugFragment.UploadTTSApi r12 = (ChatDebugFragment.UploadTTSApi) FlowHttpConnection.c(FlowHttpConnection.a, "Audio", ChatDebugFragment.UploadTTSApi.class, null, null, null, 28);
        okhttp3.k.b r2 = okhttp3.k.b.b(ShareType.FILE, this.$file.getName(), RequestBody.create(MediaType.parse("audio/x-wav"), this.$file));
        String r3 = this.$userName;
        this.label = 1;
        r11 = r12.uploadFileAndSendToUser(r2, r3, this);
        if (r11 != r0) goto L11;
        return r0;
    }
}
