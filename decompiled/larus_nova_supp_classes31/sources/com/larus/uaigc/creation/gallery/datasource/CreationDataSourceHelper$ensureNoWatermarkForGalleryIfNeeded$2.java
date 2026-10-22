package com.larus.uaigc.creation.gallery.datasource;

import com.larus.bmhome.chat.layout.holder.image.bean.ImageContentData;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.gallery.datasource.CreationDataSourceHelper$ensureNoWatermarkForGalleryIfNeeded$2", f = "CreationDataSourceHelper.kt", i = {}, l = {134, 139}, m = "invokeSuspend", n = {}, s = {})
public final class CreationDataSourceHelper$ensureNoWatermarkForGalleryIfNeeded$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    final /* synthetic */ Message $message;
    int label;

    public CreationDataSourceHelper$ensureNoWatermarkForGalleryIfNeeded$2(Message r1, Continuation<? super CreationDataSourceHelper$ensureNoWatermarkForGalleryIfNeeded$2> r2) {
        this.$message = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationDataSourceHelper$ensureNoWatermarkForGalleryIfNeeded$2(this.$message, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<Object> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r5);
    L22:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
        return r5;
    L10:
        ResultKt.throwOnFailure(r5);
        if (this.$message.getContentType() != 6) goto L15;
        CreationNoWatermarkManager r6 = CreationNoWatermarkManager.a;
        ImageContentData r2 = IAIChatUgcAIGCService.a.d0(this.$message);
        this.label = 1;
        Object r7 = r6.p(r2, "creation_gallery_display_image_explain", this);
        if (r7 != r0) goto L24;
        return r0;
    L24:
        return r7;
    L15:
        CreationNoWatermarkManager r8 = CreationNoWatermarkManager.a;
        List r3 = CollectionsKt.listOf(this.$message);
        this.label = 2;
        r8.getClass();
        Object r9 = r8.o(CreationNoWatermarkManager.j(r3), "creation_gallery_display", this);
        if (r9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        r9 = Unit.INSTANCE;
    L19:
        if (r9 != r0) goto L22;
        return r0;
    }
}
