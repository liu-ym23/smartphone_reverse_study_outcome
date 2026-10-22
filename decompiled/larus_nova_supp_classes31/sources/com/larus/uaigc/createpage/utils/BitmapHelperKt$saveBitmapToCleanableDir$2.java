package com.larus.uaigc.createpage.utils;

import android.graphics.Bitmap;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.io.BufferedOutputStream;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.BitmapHelperKt$saveBitmapToCleanableDir$2", f = "BitmapHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BitmapHelperKt$saveBitmapToCleanableDir$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ String $fileName;
    int label;

    public BitmapHelperKt$saveBitmapToCleanableDir$2(String r1, Bitmap r2, Continuation<? super BitmapHelperKt$saveBitmapToCleanableDir$2> r3) {
        this.$fileName = r1;
        this.$bitmap = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BitmapHelperKt$saveBitmapToCleanableDir$2(this.$fileName, this.$bitmap, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super File> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r5);
        PolarisFileWrapper r0 = new PolarisFileWrapper(aa9.a.a.b("creation_attachment_cache", true), this.$fileName);
        BufferedOutputStream r6 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r0));     // Catch: Exception -> L7
        this.$bitmap.compress(Bitmap.CompressFormat.JPEG, 100, r6);     // Catch: Exception -> L7
        r6.flush();     // Catch: Exception -> L7
        r6.close();     // Catch: Exception -> L7
        return r0;
    L7:
        e = move-exception;
        FLogger.a.e("saveBitmapToCleanableDir", "errorMsg: " + e.getMessage(), e);
        return null;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
