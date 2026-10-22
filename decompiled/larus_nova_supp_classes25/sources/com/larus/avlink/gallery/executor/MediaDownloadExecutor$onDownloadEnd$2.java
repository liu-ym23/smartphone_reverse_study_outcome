package com.larus.avlink.gallery.executor;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.avlink.n1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.larus.network.bean.BizResponse;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import z98.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaDownloadExecutor$onDownloadEnd$2", f = "MediaDownloadExecutor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MediaDownloadExecutor$onDownloadEnd$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    final /* synthetic */ String $safeHost;
    int label;
    final /* synthetic */ MediaDownloadExecutor this$0;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/avlink/gallery/executor/MediaDownloadExecutor$onDownloadEnd$2$type$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/larus/network/bean/BizResponse;", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class a extends TypeToken<BizResponse<Object>> {
        public a() {
        }
    }

    public MediaDownloadExecutor$onDownloadEnd$2(String r1, String r2, MediaDownloadExecutor r3, Continuation<? super MediaDownloadExecutor$onDownloadEnd$2> r4) {
        this.$safeHost = r1;
        this.$id = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MediaDownloadExecutor$onDownloadEnd$2(this.$safeHost, this.$id, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L33;
        ResultKt.throwOnFailure(r7);
        String r8 = "http://" + this.$safeHost + "/album/download_callback";     // Catch: Exception -> L28
        Request r9 = new Request.Builder().url(r8).post(RequestBody.create(MediaType.parse("application/json"), new Gson().toJson(new j(AccountService.a.getUserId(), this.$id, 8)))).build();     // Catch: Exception -> L28
        Type r2 = new a().getType();     // Catch: Exception -> L28
        IDoraService r3 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Exception -> L28
        Object r4 = null;
        if (r3 == null) goto L10;
        IDoraService.j r5 = r3.S();     // Catch: Exception -> L28
        if (r5 == null) goto L10;
        Intrinsics.checkNotNull(r9);     // Catch: Exception -> L28
        Intrinsics.checkNotNull(r2);     // Catch: Exception -> L28
        Result r10 = Result.box-impl(r5.b(r9, r2));     // Catch: Exception -> L28
    L11:
        MediaDownloadExecutor.a(this.this$0);     // Catch: Exception -> L28
        if (r10 != null) goto L14;
    L22:
        if (r10 != null) goto L24;
    L26:
        FLogger.a.w("MediaDownloadExecutor", "mediaId:" + this.$id + " downloadCallback unexpected result");     // Catch: Exception -> L28
    L31:
        return Unit.INSTANCE;
    L24:
        if (Result.isFailure-impl(r10.unbox-impl()) == false) goto L26;
        FLogger.a.e("MediaDownloadExecutor", "mediaId:" + this.$id + " downloadCallback error: " + Result.exceptionOrNull-impl(r10.unbox-impl()));     // Catch: Exception -> L28
        goto L31
    L14:
        if (Result.isSuccess-impl(r10.unbox-impl()) == false) goto L22;
        FLogger r6 = FLogger.a;     // Catch: Exception -> L28
        StringBuilder r11 = new StringBuilder("mediaId:");     // Catch: Exception -> L28
        r11.append(this.$id);     // Catch: Exception -> L28
        r11.append(" downloadCallback success: ");     // Catch: Exception -> L28
        Object r12 = r10.unbox-impl();     // Catch: Exception -> L28
        if (Result.isFailure-impl(r12) == false) goto L18;
        r12 = null;
    L18:
        BizResponse r13 = (BizResponse) r12;     // Catch: Exception -> L28
        if (r13 == null) goto L21;
        r4 = r13.getData();     // Catch: Exception -> L28
    L21:
        r11.append(r4);     // Catch: Exception -> L28
        r6.i("MediaDownloadExecutor", r11.toString());     // Catch: Exception -> L28
    L10:
        r10 = null;
    L28:
        e = move-exception;
        n1.b("MediaDownloadExecutor", "mediaId:" + this.$id + " downloadCallback exception: " + e.getMessage());
        goto L31
    L33:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
