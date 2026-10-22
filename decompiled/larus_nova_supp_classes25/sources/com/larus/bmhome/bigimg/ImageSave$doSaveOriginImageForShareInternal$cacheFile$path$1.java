package com.larus.bmhome.bigimg;

import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bigimg.ImageSave$doSaveOriginImageForShareInternal$cacheFile$path$1", f = "ImageSave.kt", i = {}, l = {369}, m = "invokeSuspend", n = {}, s = {})
final class ImageSave$doSaveOriginImageForShareInternal$cacheFile$path$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Map<String, String> $exifMap;
    final /* synthetic */ ImageRequest $imageRequest;
    final /* synthetic */ boolean $isAIGC;
    int label;

    public ImageSave$doSaveOriginImageForShareInternal$cacheFile$path$1(ImageRequest r1, Map<String, String> r2, boolean r3, Continuation<? super ImageSave$doSaveOriginImageForShareInternal$cacheFile$path$1> r4) {
        this.$imageRequest = r1;
        this.$exifMap = r2;
        this.$isAIGC = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ImageSave$doSaveOriginImageForShareInternal$cacheFile$path$1(this.$imageRequest, this.$exifMap, this.$isAIGC, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L11:
        return r9;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        ImageSave r2 = ImageSave.a;
        ImageRequest r10 = this.$imageRequest;
        Map<String, String> r3 = this.$exifMap;
        Boolean r4 = Boxing.boxBoolean(true);
        boolean r5 = this.$isAIGC;
        this.label = 1;
        r9 = ImageSave.i(r2, r10, r3, r4, r5, this, 8);
        if (r9 != r0) goto L11;
        return r0;
    }
}
