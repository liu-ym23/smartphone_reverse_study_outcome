package com.larus.camera.impl.utils;

import android.app.Application;
import android.os.Build;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.utils.VideoUtils$saveVideoInternal$1", f = "VideoUtils.kt", i = {}, l = {148}, m = "invokeSuspend", n = {}, s = {})
public final class VideoUtils$saveVideoInternal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $callback;
    final /* synthetic */ String $path;
    int label;

    /* JADX INFO: renamed from: com.larus.camera.impl.utils.VideoUtils$saveVideoInternal$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.utils.VideoUtils$saveVideoInternal$1$1", f = "VideoUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<String, Unit> $callback;
        final /* synthetic */ String $path;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super String, Unit> r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.$callback = r1;
            this.$path = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$callback, this.$path, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.$callback.invoke(this.$path);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VideoUtils$saveVideoInternal$1(String r1, Function1<? super String, Unit> r2, Continuation<? super VideoUtils$saveVideoInternal$1> r3) {
        this.$path = r1;
        this.$callback = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new VideoUtils$saveVideoInternal$1(this.$path, this.$callback, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L66:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        PolarisFileInputStreamWrapper r4 = null;
        if (Build.VERSION.SDK_INT > 28) goto L61;
        int r13 = VideoUtils.a;
        Application r14 = AppHost.a.getApplication();
        String r3 = this.$path;
        if (r3 != null) goto L13;
    L16:
        boolean r7 = true;
    L17:
        if (r7 == true) goto L62;
        PolarisFileWrapper r8 = new PolarisFileWrapper(r3);
        String r5 = com.larus.utils.r.h() + File.separator + System.currentTimeMillis() + ".mp4";
        PolarisFileWrapper r9 = new PolarisFileWrapper(r5);
        PolarisFileInputStreamWrapper r10 = new PolarisFileInputStreamWrapper(r8);     // Catch: Throwable -> L37 Exception -> L39
        BufferedOutputStream r11 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r9));     // Catch: Throwable -> L32 Exception -> L35
    L67:
        byte[] r15 = new byte[1024];     // Catch: Exception -> L30 Throwable -> L50
    L24:
        int r16 = r10.read(r15);     // Catch: Exception -> L30 Throwable -> L50
        if (r16 <= 0) goto L27;
        r11.write(r15, 0, r16);     // Catch: Exception -> L30 Throwable -> L50
        goto L24
    L27:
        com.larus.utils.r.u(r14, r5, false);     // Catch: Exception -> L30 Throwable -> L50
        r10.close();     // Catch: IOException -> L44
    L47:
        r11.close();     // Catch: IOException -> L44
    L30:
        e = e;
    L41:
        FLogger.a.e("VideoUriUtils", "saveVideoToAlbumBeforeQ failed", e);     // Catch: Throwable -> L50
        if (r10 == null) goto L46;
        r10.close();     // Catch: IOException -> L44
    L46:
        if (r11 == null) goto L62;
    L50:
        th = th;
    L34:
        r4 = r10;
    L52:
        if (r4 != null) goto L69;
    L56:
        if (r11 == null) goto L60;
        r11.close();     // Catch: IOException -> L54
    L54:
        e = move-exception;
        FLogger.a.e("VideoUriUtils", "finally close stream failed", e);
    L60:
        throw th;
    L69:
        r4.close();     // Catch: IOException -> L54
    L35:
        e = e;
        r11 = null;
    L32:
        th = th;
        r11 = null;
        goto L34
    L44:
        e = move-exception;
        FLogger.a.e("VideoUriUtils", "finally close stream failed", e);
    L39:
        e = e;
        r11 = null;
        r10 = null;
    L37:
        th = th;
        r11 = null;
    L62:
        MainCoroutineDispatcher r17 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(this.$callback, this.$path, null);
        this.label = 1;
        if (BuildersKt.withContext(r17, r2, this) != r0) goto L66;
        return r0;
    L13:
        if (r3.length() == 0) goto L16;
        r7 = false;
        goto L17
    L61:
        char r18 = com.larus.utils.r.a;
        com.larus.utils.r.u(AppHost.a.getApplication(), this.$path, false);
        goto L62
    }
}
