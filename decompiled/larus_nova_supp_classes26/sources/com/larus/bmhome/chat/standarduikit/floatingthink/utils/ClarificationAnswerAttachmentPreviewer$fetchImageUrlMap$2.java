package com.larus.bmhome.chat.standarduikit.floatingthink.utils;

import com.larus.bmhome.chat.api.ChatApi;
import com.larus.bmhome.chat.resp.FileUrlData;
import com.larus.bmhome.chat.resp.FileUrlRespData;
import com.larus.network.http.a;
import com.larus.platform.model.upload.UploadDataType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.floatingthink.utils.ClarificationAnswerAttachmentPreviewer$fetchImageUrlMap$2", f = "ClarificationAnswerAttachmentPreviewer.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
final class ClarificationAnswerAttachmentPreviewer$fetchImageUrlMap$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends String>>, Object> {
    final /* synthetic */ List<String> $tokens;
    private /* synthetic */ Object L$0;
    int label;

    public ClarificationAnswerAttachmentPreviewer$fetchImageUrlMap$2(List<String> r1, Continuation<? super ClarificationAnswerAttachmentPreviewer$fetchImageUrlMap$2> r2) {
        this.$tokens = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ClarificationAnswerAttachmentPreviewer$fetchImageUrlMap$2 r0 = new ClarificationAnswerAttachmentPreviewer$fetchImageUrlMap$2(this.$tokens, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Map<String, String>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L61
    L13:
        FileUrlRespData r10 = (FileUrlRespData) ((a) r9).b;     // Catch: Throwable -> L61
        if (r10 == null) goto L16;
        List r11 = r10.getFileUrlList();     // Catch: Throwable -> L61
    L17:
        if (r11 != null) goto L19;
        r11 = CollectionsKt.emptyList();     // Catch: Throwable -> L61
    L19:
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L61
        Iterator r12 = r11.iterator();     // Catch: Throwable -> L61
    L21:
        if (r12.hasNext() == false) goto L59;
        FileUrlData r3 = (FileUrlData) r12.next();     // Catch: Throwable -> L61
        String r4 = r3.getUri();     // Catch: Throwable -> L61
        if (r4 == null) goto L56;
        boolean r6 = false;
        if (r4.length() <= 0) goto L27;
        boolean r5 = true;
    L28:
        if (r5 == true) goto L31;
        r4 = null;
    L31:
        if (r4 == null) goto L56;
        String r7 = r3.getMainUrl();     // Catch: Throwable -> L61
        if (r7 != null) goto L36;
    L43:
        String r8 = r3.getBackUrl();     // Catch: Throwable -> L61
        if (r8 != null) goto L46;
        r7 = null;
    L53:
        if (r7 == null) goto L56;
    L55:
        Pair r13 = TuplesKt.to(r4, r7);     // Catch: Throwable -> L61
    L57:
        if (r13 == null) goto L21;
        r2.add(r13);     // Catch: Throwable -> L61
        goto L21
    L46:
        if (r8.length() <= 0) goto L48;
        r6 = true;
    L48:
        if (r6 == true) goto L51;
        r8 = null;
    L51:
        r7 = r8;
        goto L53
    L36:
        if (r7.length() <= 0) goto L38;
        boolean r14 = true;
    L39:
        if (r14 == true) goto L42;
        r7 = null;
    L42:
        if (r7 != null) goto L55;
    L38:
        r14 = false;
        goto L39
    L27:
        r5 = false;
    L56:
        r13 = null;
        goto L57
    L59:
        Object r15 = Result.constructor-impl(MapsKt.toMap(r2));     // Catch: Throwable -> L61
    L63:
        Map r16 = MapsKt.emptyMap();
        if (Result.isFailure-impl(r15) == true) goto L66;
        return r15;
    L66:
        return r16;
    L16:
        r11 = null;
        goto L17
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
        CoroutineScope r17 = (CoroutineScope) this.L$0;
        List<String> r18 = this.$tokens;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L61
        Lazy r20 = ChatApi.a;     // Catch: Throwable -> L61
        ChatApi r21 = ChatApi.a.a();     // Catch: Throwable -> L61
        String r22 = UploadDataType.IMAGE.getType();     // Catch: Throwable -> L61
        this.label = 1;     // Catch: Throwable -> L61
        r21.getClass();     // Catch: Throwable -> L61
        r9 = ChatApi.e(r18, r22, this);     // Catch: Throwable -> L61
        if (r9 != r0) goto L13;
        return r0;
    L61:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L63
    }
}
