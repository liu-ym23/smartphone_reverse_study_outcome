package com.larus.bmhome.clarification;

import android.net.Uri;
import com.larus.bmhome.chat.api.ChatApi;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.clarification.ClarificationAttachmentManager$deleteRemoteResourceIfNeeded$1", f = "ClarificationAttachmentManager.kt", i = {}, l = {725, 732}, m = "invokeSuspend", n = {}, s = {})
public final class ClarificationAttachmentManager$deleteRemoteResourceIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ String $key;
    private /* synthetic */ Object L$0;
    int label;

    public ClarificationAttachmentManager$deleteRemoteResourceIfNeeded$1(String r1, UplinkFileEntity r2, Continuation<? super ClarificationAttachmentManager$deleteRemoteResourceIfNeeded$1> r3) {
        this.$key = r1;
        this.$entity = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ClarificationAttachmentManager$deleteRemoteResourceIfNeeded$1 r0 = new ClarificationAttachmentManager$deleteRemoteResourceIfNeeded$1(this.$key, this.$entity, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L38
    L36:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L38
    L40:
        String r2 = this.$key;
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L44;
        FLogger.a.e("ClarificationAttachMgr", "[deleteRemoteResource] failed, key:" + r2, r9);
    L44:
        return Unit.INSTANCE;
    L11:
        ResultKt.throwOnFailure(r7);
        CoroutineScope r10 = (CoroutineScope) this.L$0;
        String r11 = this.$key;
        UplinkFileEntity r3 = this.$entity;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L38
        ResourceCenter r5 = ResourceCenter.a;     // Catch: Throwable -> L38
        r5.getClass();     // Catch: Throwable -> L38
        String r6 = "";
        if (ResourceCenter.d(r11) == false) goto L23;
        String r12 = yc9.l1.g(r3);     // Catch: Throwable -> L38
        if (r12 == null) goto L19;
        r6 = r12;
    L19:
        List<String> r13 = CollectionsKt.listOf(r6);     // Catch: Throwable -> L38
        this.label = 1;     // Catch: Throwable -> L38
        r7 = r5.b(r13, this);     // Catch: Throwable -> L38
        if (r7 != r0) goto L36;
        return r0;
    L23:
        if (n1.d(r3) == false) goto L25;
        String r14 = "image";
    L26:
        Lazy r15 = ChatApi.a;     // Catch: Throwable -> L38
        ChatApi r16 = ChatApi.a.a();     // Catch: Throwable -> L38
        Uri r17 = r3.getUri();     // Catch: Throwable -> L38
        if (r17 == null) goto L29;
        String r18 = r17.toString();     // Catch: Throwable -> L38
    L30:
        if (r18 == null) goto L33;
        r6 = r18;
    L33:
        List r19 = CollectionsKt.listOf(TuplesKt.to(r6, r14));     // Catch: Throwable -> L38
        this.label = 2;     // Catch: Throwable -> L38
        r16.getClass();     // Catch: Throwable -> L38
        r7 = ChatApi.a(r19, this);     // Catch: Throwable -> L38
        if (r7 != r0) goto L36;
        return r0;
    L29:
        r18 = null;
        goto L30
    L25:
        r14 = ShareType.FILE;
    L38:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L40
    }
}
