package com.larus.bmhome.music.save_video;

import android.content.Context;
import android.os.Build;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.save_video.MusicVideoSaver$saveVideo$2", f = "MusicVideoSaver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MusicVideoSaver$saveVideo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $resultPath;
    int label;

    public MusicVideoSaver$saveVideo$2(Context r1, String r2, Continuation<? super MusicVideoSaver$saveVideo$2> r3) {
        this.$context = r1;
        this.$resultPath = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MusicVideoSaver$saveVideo$2(this.$context, this.$resultPath, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L56;
        ResultKt.throwOnFailure(r10);
        if (Build.VERSION.SDK_INT > 28) goto L50;
        MusicVideoSaver r11 = MusicVideoSaver.a;
        Context r12 = this.$context;
        String r0 = this.$resultPath;
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r0, "videoFile");
        PolarisFileWrapper r4 = new PolarisFileWrapper(r0);
        String r1 = com.larus.utils.r.h() + File.separator + System.currentTimeMillis() + ".mp4";
        PolarisFileWrapper r5 = new PolarisFileWrapper(r1);
        PolarisFileInputStreamWrapper r6 = null;
        PolarisFileInputStreamWrapper r7 = new PolarisFileInputStreamWrapper(r4);     // Catch: Throwable -> L26 Exception -> L28
    L67:
        BufferedOutputStream r8 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r5));     // Catch: Throwable -> L21 Exception -> L24
    L62:
        byte[] r9 = new byte[1024];     // Catch: Exception -> L19 Throwable -> L39
    L11:
        int r13 = r7.read(r9);     // Catch: Exception -> L19 Throwable -> L39
        if (r13 <= 0) goto L14;
        r8.write(r9, 0, r13);     // Catch: Exception -> L19 Throwable -> L39
        goto L11
    L14:
        PolarisFileInputStreamWrapper r14 = com.larus.utils.r.u(r12, r1, false);     // Catch: Exception -> L19 Throwable -> L39
        r7.close();     // Catch: IOException -> L17
        r6 = r14;
    L36:
        r8.close();     // Catch: IOException -> L33
    L51:
        if (r6 == null) goto L53;
        r6.toString();
    L53:
        MusicVideoSaver r15 = MusicVideoSaver.a;
        MusicVideoSaver.g("Move video to gallery");
        return Unit.INSTANCE;
    L33:
        IOException e = e;
    L38:
        FLogger.a.e("save_music_video", "finally close stream failed", e);
    L17:
        e = e;
        r6 = r14;
    L19:
        e = e;
    L30:
        FLogger.a.e("save_music_video", "saveVideoToAlbumBeforeQ failed", e);     // Catch: Throwable -> L39
        if (r7 != null) goto L57;
    L35:
        if (r8 == null) goto L51;
    L57:
        r7.close();     // Catch: IOException -> L33
    L24:
        e = e;
        r8 = null;
    L21:
        th = th;
        r4 = null;
    L23:
        r6 = r7;
    L41:
        if (r6 != null) goto L64;
    L45:
        if (r4 == null) goto L49;
        r4.close();     // Catch: IOException -> L43
    L43:
        e = move-exception;
        FLogger.a.e("save_music_video", "finally close stream failed", e);
    L49:
        throw th;
    L64:
        r6.close();     // Catch: IOException -> L43
    L39:
        th = th;
    L28:
        e = e;
        r8 = null;
        r7 = null;
    L26:
        th = th;
        r4 = null;
        goto L41
    L50:
        char r16 = com.larus.utils.r.a;
        r6 = com.larus.utils.r.u(this.$context, this.$resultPath, false);
        goto L51
    L56:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
