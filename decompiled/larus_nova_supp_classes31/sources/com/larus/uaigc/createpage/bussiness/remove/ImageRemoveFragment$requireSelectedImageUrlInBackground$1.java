package com.larus.uaigc.createpage.bussiness.remove;

import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.chat.resp.FileUrlData;
import com.larus.bmhome.chat.resp.FileUrlRespData;
import com.larus.network.http.y;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.utils.o0;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.bussiness.remove.ImageRemoveFragment$requireSelectedImageUrlInBackground$1", f = "ImageRemoveFragment.kt", i = {}, l = {373}, m = "invokeSuspend", n = {}, s = {})
final class ImageRemoveFragment$requireSelectedImageUrlInBackground$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $tosKey;
    int label;
    final /* synthetic */ ImageRemoveFragment this$0;

    public ImageRemoveFragment$requireSelectedImageUrlInBackground$1(String r1, ImageRemoveFragment r2, Continuation<? super ImageRemoveFragment$requireSelectedImageUrlInBackground$1> r3) {
        this.$tosKey = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ImageRemoveFragment$requireSelectedImageUrlInBackground$1(this.$tosKey, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r3 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L24:
        y r6 = (com.larus.network.http.a) r5;
        if ((r6 instanceof y) == false) goto L53;
        y r7 = r6;
        FileUrlRespData r2 = (FileUrlRespData) ((com.larus.network.http.a) r7).b;
        if (r2 == null) goto L33;
        List r4 = r2.getFileUrlList();
        if (r4 == null) goto L33;
        FileUrlData r8 = (FileUrlData) CollectionsKt.firstOrNull(r4);
        if (r8 == null) goto L33;
        String r9 = r8.getMainUrl();
    L35:
        if (o0.d(r9) == false) goto L53;
        MediaAttachment r10 = this.this$0.i;
        if (r10 == null) goto L39;
        String r11 = r10.getUri();
    L41:
        if (Intrinsics.areEqual(r11, this.$tosKey) == false) goto L53;
        MediaAttachment r12 = this.this$0.i;
        if (r12 == null) goto L53;
        FileUrlRespData r13 = (FileUrlRespData) ((com.larus.network.http.a) r7).b;
        if (r13 == null) goto L51;
        List r14 = r13.getFileUrlList();
        if (r14 == null) goto L51;
        FileUrlData r15 = (FileUrlData) CollectionsKt.firstOrNull(r14);
        if (r15 == null) goto L51;
        r3 = r15.getMainUrl();
    L51:
        r12.setUrl(r3);
        goto L53
    L39:
        r11 = null;
    L33:
        r9 = null;
    L53:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        if (o0.d(this.$tosKey) == false) goto L53;
        MediaAttachment r16 = this.this$0.i;
        if (r16 == null) goto L13;
        String r17 = r16.getUrl();
    L14:
        if (r17 != null) goto L16;
    L19:
        boolean r18 = true;
    L20:
        if (r18 == false) goto L53;
        List r19 = CollectionsKt.listOf(this.$tosKey);
        UploadDataType r20 = UploadDataType.IMAGE;
        this.label = 1;
        r5 = com.larus.uaigc.api.o.b(r19, r20, this);
        if (r5 != r0) goto L24;
        return r0;
    L16:
        if (r17.length() == 0) goto L19;
        r18 = false;
        goto L20
    L13:
        r17 = null;
        goto L14
    }
}
