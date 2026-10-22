package com.larus.uaigc.createpage.utils;

import android.graphics.Bitmap;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.io.BufferedOutputStream;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.BitmapHelperKt$saveBitMapToFile$4", f = "BitmapHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BitmapHelperKt$saveBitMapToFile$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ String $filePath;
    final /* synthetic */ int $quality;
    int label;

    public BitmapHelperKt$saveBitMapToFile$4(String r1, Bitmap r2, int r3, Continuation<? super BitmapHelperKt$saveBitMapToFile$4> r4) {
        this.$filePath = r1;
        this.$bitmap = r2;
        this.$quality = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BitmapHelperKt$saveBitMapToFile$4(this.$filePath, this.$bitmap, this.$quality, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r4);
        BufferedOutputStream r5 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(this.$filePath));     // Catch: Exception -> L7
        this.$bitmap.compress(Bitmap.CompressFormat.JPEG, this.$quality, r5);     // Catch: Exception -> L7
        r5.flush();     // Catch: Exception -> L7
        r5.close();     // Catch: Exception -> L7
        return Boxing.boxBoolean(true);
    L7:
        e = move-exception;
        FLogger.a.e("saveBitMapToFile", "errorMsg: " + e.getMessage(), e);
        return Boxing.boxBoolean(false);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
