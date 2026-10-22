package com.larus.chat.gallery.impl.preview.input;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.io.InputStream;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.input.PreviewCameraParamProvider$materializeLocalVideo$2", f = "PreviewCameraParamProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PreviewCameraParamProvider$materializeLocalVideo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Uri $uri;
    private /* synthetic */ Object L$0;
    int label;

    public PreviewCameraParamProvider$materializeLocalVideo$2(Uri r1, Continuation<? super PreviewCameraParamProvider$materializeLocalVideo$2> r2) {
        this.$uri = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        PreviewCameraParamProvider$materializeLocalVideo$2 r0 = new PreviewCameraParamProvider$materializeLocalVideo$2(this.$uri, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L52;
        ResultKt.throwOnFailure(r8);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        AppHost.Companion r10 = AppHost.a;
        String r1 = com.larus.utils.r.j(r10.getApplication(), this.$uri);
        Object r2 = null;
        if (r1 != null) goto L7;
    L12:
        Uri r3 = this.$uri;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L40
        PolarisFileWrapper r5 = new PolarisFileWrapper(r10.getApplication().getCacheDir(), "preview_camera_" + UUID.randomUUID() + ".mp4");     // Catch: Throwable -> L40
        InputStream r11 = ContentResolverWrapper.openInputStream(r10.getApplication().getContentResolver(), r3);     // Catch: Throwable -> L40
        if (r11 != null) goto L54;
    L37:
        String r12 = null;
    L38:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L40
    L42:
        Throwable r0 = Result.exceptionOrNull-impl(r13);
        if (r0 == null) goto L46;
        FLogger.a.e("PreviewCameraParamProvider", "materializeLocalVideo failed", r0);
    L46:
        if (Result.isFailure-impl(r13) == true) goto L50;
        r2 = r13;
    L50:
        return (String) r2;
    L54:
        PolarisFileOutputStreamWrapper r6 = new PolarisFileOutputStreamWrapper(r5);     // Catch: Throwable -> L32
        boolean r7 = false;
        ByteStreamsKt.copyTo$default(r11, r6, 0, 2, null);     // Catch: Throwable -> L27
        CloseableKt.closeFinally(r6, null);     // Catch: Throwable -> L32
        CloseableKt.closeFinally(r11, null);     // Catch: Throwable -> L40
        r12 = r5.getAbsolutePath();     // Catch: Throwable -> L40
        if (r5.isFile() == true) goto L23;
    L25:
        if (r7 == false) goto L37;
    L23:
        if (r5.length() <= 0) goto L25;
        r7 = true;
        goto L25
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);     // Catch: Throwable -> L32
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);     // Catch: Throwable -> L40
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L42
    L7:
        if (new PolarisFileWrapper(r1).isFile() == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L12;
        return r1;
    L52:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
