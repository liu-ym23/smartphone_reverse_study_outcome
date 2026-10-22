package com.larus.bmhome.bigimg;

import android.content.Context;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.service.DownloadWatermarkService;
import com.larus.platform.service.watermark.DownloadWatermarkScene;
import com.larus.platform.service.watermark.WatermarkPerfLogger;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bigimg.ImageSave$saveBitmapWithFilePath$1", f = "ImageSave.kt", i = {0}, l = {223}, m = "invokeSuspend", n = {"perf"}, s = {"L$0"})
public final class ImageSave$saveBitmapWithFilePath$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Boolean, String, Unit> $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $filePath;
    final /* synthetic */ String $saveDir;
    Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ImageSave$saveBitmapWithFilePath$1(String r1, Function2<? super Boolean, ? super String, Unit> r2, Context r3, String r4, Continuation<? super ImageSave$saveBitmapWithFilePath$1> r5) {
        this.$filePath = r1;
        this.$callback = r2;
        this.$context = r3;
        this.$saveDir = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ImageSave$saveBitmapWithFilePath$1(this.$filePath, this.$callback, this.$context, this.$saveDir, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        WatermarkPerfLogger.a r2 = (WatermarkPerfLogger.a) this.L$0;
        ResultKt.throwOnFailure(r8);
        final WatermarkPerfLogger.a r3 = r2;
    L16:
        final String r4 = (String) r8;
        r3.a("watermark");
        ImageSave.a.getClass();
        ExecutorService r9 = (ExecutorService) ImageSave.b.getValue();
        final Function2<Boolean, String, Unit> r5 = this.$callback;
        final Context r6 = this.$context;
        final String r7 = this.$saveDir;
        r9.execute(new r1(r4, r5, r3, r6, r7));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        int r10 = WatermarkPerfLogger.a;
        DownloadWatermarkService.a.getClass();
        if (DownloadWatermarkService.d() == false) goto L11;
        WatermarkPerfLogger.Version r11 = WatermarkPerfLogger.Version.ENTERPRISE;
    L12:
        WatermarkPerfLogger.a r12 = WatermarkPerfLogger.a("image_save_with_filepath", r11, DownloadWatermarkScene.CI_GEN_IMAGE_DOWNLOAD);
        WatermarkPerfLogger.Path.a r13 = WatermarkPerfLogger.Path.Companion;
        String r14 = this.$filePath;
        r13.getClass();
        r12.c(WatermarkPerfLogger.Path.a.a(r14));
        ImageSave r15 = ImageSave.a;
        String r16 = this.$filePath;
        this.L$0 = r12;
        this.label = 1;
        Object r17 = ImageSave.a(r15, r16, this);
        if (r17 != r0) goto L15;
        return r0;
    L15:
        r3 = r12;
        r8 = r17;
        goto L16
    L11:
        r11 = WatermarkPerfLogger.Version.PERSONAL;
        goto L12
    }
}
