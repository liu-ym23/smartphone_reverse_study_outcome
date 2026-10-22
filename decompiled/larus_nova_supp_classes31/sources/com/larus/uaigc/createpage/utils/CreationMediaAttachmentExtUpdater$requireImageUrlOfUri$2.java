package com.larus.uaigc.createpage.utils;

import com.larus.bmhome.chat.resp.FileUrlData;
import com.larus.bmhome.chat.resp.FileUrlRespData;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.CreationMediaAttachmentExtUpdater$requireImageUrlOfUri$2", f = "CreationMediaAttachmentExtUpdater.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
public final class CreationMediaAttachmentExtUpdater$requireImageUrlOfUri$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $uri;
    private /* synthetic */ Object L$0;
    int label;

    public CreationMediaAttachmentExtUpdater$requireImageUrlOfUri$2(String r1, Continuation<? super CreationMediaAttachmentExtUpdater$requireImageUrlOfUri$2> r2) {
        this.$uri = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CreationMediaAttachmentExtUpdater$requireImageUrlOfUri$2 r0 = new CreationMediaAttachmentExtUpdater$requireImageUrlOfUri$2(this.$uri, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L7
    L21:
        FileUrlRespData r7 = (FileUrlRespData) ((com.larus.network.http.a) r6).b;     // Catch: Throwable -> L7
        if (r7 == null) goto L28;
        List r8 = r7.getFileUrlList();     // Catch: Throwable -> L7
        if (r8 == null) goto L28;
        FileUrlData r9 = (FileUrlData) CollectionsKt.firstOrNull(r8);     // Catch: Throwable -> L7
        if (r9 == null) goto L28;
        String r10 = r9.getMainUrl();     // Catch: Throwable -> L7
    L29:
        Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L7
    L32:
        Throwable r2 = Result.exceptionOrNull-impl(r11);
        if (r2 == null) goto L36;
        FLogger.a.e("CreationMediaAttachmentExtUpdater", "[requireImageUrlOfUri] require url failed", r2);
    L36:
        if (Result.isFailure-impl(r11) == false) goto L39;
        return null;
    L39:
        return r11;
    L28:
        r10 = null;
        goto L29
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r6);
        CoroutineScope r12 = (CoroutineScope) this.L$0;
        if (this.$uri.length() != 0) goto L14;
        boolean r13 = true;
    L15:
        if (r13 == false) goto L17;
        return null;
    L17:
        String r14 = this.$uri;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        List r15 = CollectionsKt.listOf(r14);     // Catch: Throwable -> L7
        UploadDataType r4 = UploadDataType.IMAGE;     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        r6 = com.larus.uaigc.api.o.b(r15, r4, this);     // Catch: Throwable -> L7
        if (r6 != r0) goto L21;
        return r0;
    L14:
        r13 = false;
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    }
}
