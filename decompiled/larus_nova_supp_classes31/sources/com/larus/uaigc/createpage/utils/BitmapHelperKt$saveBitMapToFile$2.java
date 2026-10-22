package com.larus.uaigc.createpage.utils;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
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
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.BitmapHelperKt$saveBitMapToFile$2", f = "BitmapHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BitmapHelperKt$saveBitMapToFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $fileName;
    int label;

    public BitmapHelperKt$saveBitMapToFile$2(Context r1, String r2, Bitmap r3, Continuation<? super BitmapHelperKt$saveBitMapToFile$2> r4) {
        this.$context = r1;
        this.$fileName = r2;
        this.$bitmap = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BitmapHelperKt$saveBitMapToFile$2(this.$context, this.$fileName, this.$bitmap, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super File> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r5);
        Context r6 = this.$context;
        if (r6 != null) goto L7;
        r6 = AppHost.a.getApplication();
    L7:
        File r0 = r6.getCacheDir();
        if (r0.exists() == false) goto L10;
    L12:
        PolarisFileWrapper r7 = new PolarisFileWrapper(r0, this.$fileName);
        BufferedOutputStream r1 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r7));     // Catch: Exception -> L15
        this.$bitmap.compress(Bitmap.CompressFormat.JPEG, 100, r1);     // Catch: Exception -> L15
        r1.flush();     // Catch: Exception -> L15
        r1.close();     // Catch: Exception -> L15
        return r7;
    L15:
        e = move-exception;
        FLogger.a.e("saveBitMapToFile", "errorMsg: " + e.getMessage(), e);
        return null;
    L10:
        if (r0.mkdirs() == true) goto L12;
        r0 = r6.getFilesDir();
        goto L12
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
