package com.larus.chat.gallery.impl.preview.input;

import com.larus.bmhome.view.AttachmentInfo;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/view/AttachmentInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.input.CreationRecordSendStrategy$resolveImageAttachment$2", f = "CreationRecordSendStrategy.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
final class CreationRecordSendStrategy$resolveImageAttachment$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AttachmentInfo>, Object> {
    final /* synthetic */ String $imageUrl;
    int label;

    public CreationRecordSendStrategy$resolveImageAttachment$2(String r1, Continuation<? super CreationRecordSendStrategy$resolveImageAttachment$2> r2) {
        this.$imageUrl = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationRecordSendStrategy$resolveImageAttachment$2(this.$imageUrl, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super AttachmentInfo> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r27) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r4 = true;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r27);
        Object r3 = r27;
    L11:
        com.larus.uaigc.api.s r5 = (com.larus.uaigc.api.s) ((com.larus.network.http.a) r3).b;
        if (r5 == null) goto L16;
        List r6 = r5.a();
        if (r6 == null) goto L16;
        com.larus.uaigc.api.q r7 = (com.larus.uaigc.api.q) CollectionsKt.firstOrNull(r6);
    L17:
        if (r7 == null) goto L19;
        String r8 = r7.c();
    L20:
        if (r8 != null) goto L22;
        r8 = "";
    L22:
        String r9 = r8;
        if (r7 == null) goto L33;
        com.larus.uaigc.api.p r10 = r7.b();
        if (r10 == null) goto L33;
        com.larus.uaigc.api.n r11 = r10.a();
        if (r11 == null) goto L33;
        com.larus.uaigc.api.m r12 = r11.a();
        if (r12 == null) goto L33;
        Long r13 = r12.b();
        if (r13 == null) goto L33;
        int r14 = (int) r13.longValue();
    L34:
        if (r7 == null) goto L44;
        com.larus.uaigc.api.p r15 = r7.b();
        if (r15 == null) goto L44;
        com.larus.uaigc.api.n r16 = r15.a();
        if (r16 == null) goto L44;
        com.larus.uaigc.api.m r17 = r16.a();
        if (r17 == null) goto L44;
        Long r18 = r17.a();
        if (r18 == null) goto L44;
        int r19 = (int) r18.longValue();
    L45:
        FLogger r20 = FLogger.a;
        StringBuilder r21 = new StringBuilder("resolveImageAttachment: resolved=");
        if (r9.length() <= 0) goto L48;
        boolean r22 = true;
    L49:
        r21.append(r22);
        r21.append(", width=");
        r21.append(r14);
        r21.append(", height=");
        r21.append(r19);
        r20.i("CreationRecordSendStrategy", r21.toString());
        if (r9.length() == 0) goto L53;
        r4 = false;
    L53:
        if (r4 == false) goto L57;
        r20.e("CreationRecordSendStrategy", "resolveImageAttachment: failed to resolve tosKey, abort");
        return null;
    L57:
        return new AttachmentInfo(true, r9, Boxing.boxInt(r19), Boxing.boxInt(r14), "", null, "creation_record_gallery", null, null, null, null, this.$imageUrl, null, null, null, null, null, 128928, null);
    L48:
        r22 = false;
    L44:
        r19 = 0;
    L33:
        r14 = 0;
        goto L34
    L19:
        r8 = null;
    L16:
        r7 = null;
        goto L17
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r27);
        FLogger.a.i("CreationRecordSendStrategy", "resolveImageAttachment: resolving resource uri");
        List r23 = CollectionsKt.listOf(this.$imageUrl);
        this.label = 1;
        r3 = com.larus.uaigc.api.o.a(r23, true, this);
        if (r3 != r1) goto L11;
        return r1;
    }
}
