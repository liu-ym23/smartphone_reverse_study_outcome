package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.larus.bmhome.chat.resp.FileUrlRespData;
import com.larus.platform.model.upload.UploadDataType;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/bmhome/chat/resp/FileUrlRespData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$requireSelectedImageUrlInBackground$1$resp$1", f = "MultiAttachmentSelectorComponent.kt", i = {}, l = {2363}, m = "invokeSuspend", n = {}, s = {})
public final class MultiAttachmentSelectorComponent$requireSelectedImageUrlInBackground$1$resp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends FileUrlRespData>>, Object> {
    final /* synthetic */ String $tosKey;
    int label;

    public MultiAttachmentSelectorComponent$requireSelectedImageUrlInBackground$1$resp$1(String r1, Continuation<? super MultiAttachmentSelectorComponent$requireSelectedImageUrlInBackground$1$resp$1> r2) {
        this.$tosKey = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MultiAttachmentSelectorComponent$requireSelectedImageUrlInBackground$1$resp$1(this.$tosKey, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<FileUrlRespData>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L14:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        String r5 = this.$tosKey;
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        List r6 = CollectionsKt.listOf(r5);
        UploadDataType r2 = UploadDataType.IMAGE;
        this.label = 1;
        r4 = com.larus.uaigc.api.o.b(r6, r2, this);
        if (r4 != r0) goto L14;
        return r0;
    }
}
