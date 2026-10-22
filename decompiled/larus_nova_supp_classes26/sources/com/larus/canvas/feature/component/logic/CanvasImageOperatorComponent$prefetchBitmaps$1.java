package com.larus.canvas.feature.component.logic;

import com.facebook.datasource.DataSource;
import com.larus.canvas.service.bean.CanvasBlock;
import com.larus.canvas.service.bean.CanvasGenerateData;
import com.larus.canvas.service.bean.CanvasImageBlock;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.ImageObj;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.service.z2;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.CanvasImageOperatorComponent$prefetchBitmaps$1", f = "CanvasImageOperatorComponent.kt", i = {}, l = {376, 381}, m = "invokeSuspend", n = {}, s = {})
final class CanvasImageOperatorComponent$prefetchBitmaps$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ky8.f $curPageInfo;
    int label;
    final /* synthetic */ CanvasImageOperatorComponent this$0;

    public CanvasImageOperatorComponent$prefetchBitmaps$1(ky8.f r1, CanvasImageOperatorComponent r2, Continuation<? super CanvasImageOperatorComponent$prefetchBitmaps$1> r3) {
        this.$curPageInfo = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CanvasImageOperatorComponent$prefetchBitmaps$1(this.$curPageInfo, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r11);
    L44:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
    L19:
        DataSource r12 = (DataSource) r11;
    L20:
        hq9.v1 r13 = z2.a.getCreationShareSettings().a();
        if (r13 != null) goto L23;
    L25:
        boolean r14 = false;
    L26:
        if (r14 == false) goto L44;
        List<CanvasBlock> r15 = this.$curPageInfo.b;
        if (r15 == null) goto L36;
        CanvasBlock r16 = (CanvasBlock) CollectionsKt.firstOrNull(r15);
        if (r16 == null) goto L36;
        CanvasImageBlock r17 = r16.content;
        if (r17 == null) goto L36;
        CanvasGenerateData r18 = r17.generateData;
        if (r18 == null) goto L36;
        List<ImageObj> r19 = r18.refImages;
    L37:
        if (r19 == null) goto L44;
        if (r19.size() != 1) goto L44;
        String r3 = ((ImageObj) CollectionsKt.first(r19)).url;
        this.label = 2;
        if (ImageLoaderKt.C(r3, "creation_share", null, null, this, 60) != r0) goto L44;
        return r0;
    L36:
        r19 = null;
        goto L37
    L23:
        if (r13.c() != true) goto L25;
        r14 = true;
        goto L26
    L10:
        ResultKt.throwOnFailure(r11);
        ImageData r110 = this.$curPageInfo.h();
        if (r110 == null) goto L20;
        ImageObj r111 = r110.imageOriRaw;
        if (r111 == null) goto L20;
        String r4 = r111.url;
        if (r4 == null) goto L20;
        CanvasImageOperatorComponent r112 = this.this$0;
        ky8.f r2 = this.$curPageInfo;
        r112.r.put(r2.a, Boxing.boxBoolean(true));
        this.label = 1;
        r11 = ImageLoaderKt.C(r4, "creation_share", null, null, this, 60);
        if (r11 != r0) goto L19;
        return r0;
    }
}
