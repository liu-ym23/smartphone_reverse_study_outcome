package com.larus.voice_setting.voice.utils;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.aivoice.core.data.NameKeys;
import java.io.File;
import java.io.InputStream;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.utils.CommonExtKt$copyAssetsToStorage$2", f = "CommonExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CommonExtKt$copyAssetsToStorage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $assetName;
    final /* synthetic */ Context $context;
    final /* synthetic */ File $targetFile;
    int label;

    public CommonExtKt$copyAssetsToStorage$2(File r1, Context r2, String r3, Continuation<? super CommonExtKt$copyAssetsToStorage$2> r4) {
        this.$targetFile = r1;
        this.$context = r2;
        this.$assetName = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CommonExtKt$copyAssetsToStorage$2(this.$targetFile, this.$context, this.$assetName, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r6);
        PolarisFileWrapper r7 = new PolarisFileWrapper(this.$targetFile.getParentFile(), String.valueOf(UUID.randomUUID()));
        File r0 = r7.getParentFile();
        if (r0 == null) goto L7;
        Boxing.boxBoolean(r0.mkdirs());
    L7:
        InputStream r1 = this.$context.getAssets().open(this.$assetName);
        PolarisFileOutputStreamWrapper r2 = new PolarisFileOutputStreamWrapper(r7);     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L16
        ByteStreamsKt.copyTo$default(r1, r2, 0, 2, null);     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r2, null);     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r1, null);
        File r3 = this.$targetFile.getParentFile();
        if (r3 == null) goto L15;
        Boxing.boxBoolean(r3.mkdirs());
    L15:
        return Boxing.boxBoolean(r7.renameTo(this.$targetFile));
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);
        throw th;
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
