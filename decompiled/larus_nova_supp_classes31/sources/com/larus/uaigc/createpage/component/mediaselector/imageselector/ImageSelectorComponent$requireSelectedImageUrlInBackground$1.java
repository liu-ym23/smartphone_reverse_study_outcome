package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.chat.resp.FileUrlData;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent$requireSelectedImageUrlInBackground$1", f = "ImageSelectorComponent.kt", i = {0}, l = {2390}, m = "invokeSuspend", n = {"tosKey"}, s = {"L$0"})
public final class ImageSelectorComponent$requireSelectedImageUrlInBackground$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ImageSelectorComponent this$0;

    public ImageSelectorComponent$requireSelectedImageUrlInBackground$1(ImageSelectorComponent r1, Continuation<? super ImageSelectorComponent$requireSelectedImageUrlInBackground$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ImageSelectorComponent$requireSelectedImageUrlInBackground$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r3 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        String r2 = (String) this.L$0;
        ResultKt.throwOnFailure(r6);
    L39:
        com.larus.network.http.y r7 = (com.larus.network.http.a) r6;
        if ((r7 instanceof com.larus.network.http.y) == false) goto L80;
        com.larus.network.http.y r8 = r7;
        FileUrlRespData r4 = (FileUrlRespData) ((com.larus.network.http.a) r8).b;
        if (r4 == null) goto L48;
        List r5 = r4.getFileUrlList();
        if (r5 == null) goto L48;
        FileUrlData r9 = (FileUrlData) CollectionsKt.firstOrNull(r5);
        if (r9 == null) goto L48;
        String r10 = r9.getMainUrl();
    L50:
        if (com.larus.utils.o0.d(r10) == false) goto L80;
        if ((this.this$0.D20().getValue() instanceof ry9.j.c) == false) goto L80;
        ry9.i r11 = ((ry9.j) this.this$0.D20().getValue()).a();
        if ((r11 instanceof ry9.i.a) == false) goto L56;
        ry9.i.a r12 = (ry9.i.a) r11;
    L57:
        if (r12 == null) goto L61;
        MediaAttachment r13 = r12.a;
        if (r13 == null) goto L61;
        String r14 = r13.getUri();
    L63:
        if (Intrinsics.areEqual(r14, r2) == false) goto L80;
        ry9.i r15 = ((ry9.j) this.this$0.D20().getValue()).a();
        if ((r15 instanceof ry9.i.a) == false) goto L67;
        ry9.i.a r16 = (ry9.i.a) r15;
    L68:
        if (r16 == null) goto L80;
        MediaAttachment r17 = r16.a;
        if (r17 == null) goto L80;
        FileUrlRespData r18 = (FileUrlRespData) ((com.larus.network.http.a) r8).b;
        if (r18 == null) goto L78;
        List r19 = r18.getFileUrlList();
        if (r19 == null) goto L78;
        FileUrlData r20 = (FileUrlData) CollectionsKt.firstOrNull(r19);
        if (r20 == null) goto L78;
        r3 = r20.getMainUrl();
    L78:
        r17.setUrl(r3);
        goto L80
    L67:
        r16 = null;
    L61:
        r14 = null;
        goto L63
    L56:
        r12 = null;
    L48:
        r10 = null;
    L80:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        if ((this.this$0.D20().getValue() instanceof ry9.j.c) == false) goto L80;
        ry9.i r21 = ((ry9.j) this.this$0.D20().getValue()).a();
        if ((r21 instanceof ry9.i.a) == false) goto L13;
        ry9.i.a r22 = (ry9.i.a) r21;
    L14:
        if (r22 == null) goto L16;
        MediaAttachment r23 = r22.a;
    L17:
        if (r23 == null) goto L19;
        String r24 = r23.getUri();
    L21:
        if (com.larus.utils.o0.d(r24) == false) goto L80;
        if (r23 == null) goto L24;
        String r25 = r23.getUrl();
    L25:
        if (r25 != null) goto L27;
    L30:
        boolean r26 = true;
    L31:
        if (r26 == false) goto L80;
        if (r24 != null) goto L34;
        String r27 = "";
    L35:
        List r28 = CollectionsKt.listOf(r27);
        UploadDataType r29 = UploadDataType.IMAGE;
        this.L$0 = r24;
        this.label = 1;
        r6 = com.larus.uaigc.api.o.b(r28, r29, this);
        if (r6 != r0) goto L38;
        return r0;
    L38:
        r2 = r24;
        goto L39
    L34:
        r27 = r24;
        goto L35
    L27:
        if (r25.length() == 0) goto L30;
        r26 = false;
        goto L31
    L24:
        r25 = null;
        goto L25
    L19:
        r24 = null;
        goto L21
    L16:
        r23 = null;
        goto L17
    L13:
        r22 = null;
        goto L14
    }
}
