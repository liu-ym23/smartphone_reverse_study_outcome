package com.larus.share.impl.panel;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.io.File;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.share.impl.panel.SharePanelAdapter$relocateNextTo$2", f = "SharePanelAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SharePanelAdapter$relocateNextTo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $originalLocalPath;
    final /* synthetic */ String $watermarkedPath;
    private /* synthetic */ Object L$0;
    int label;

    public SharePanelAdapter$relocateNextTo$2(String r1, String r2, Continuation<? super SharePanelAdapter$relocateNextTo$2> r3) {
        this.$originalLocalPath = r1;
        this.$watermarkedPath = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        SharePanelAdapter$relocateNextTo$2 r0 = new SharePanelAdapter$relocateNextTo$2(this.$originalLocalPath, this.$watermarkedPath, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L73;
        ResultKt.throwOnFailure(r9);
        CoroutineScope r10 = (CoroutineScope) this.L$0;
        String r11 = this.$originalLocalPath;
        boolean r0 = true;
        if (r11 != null) goto L7;
    L10:
        boolean r12 = true;
    L12:
        if (r12 == false) goto L14;
        return null;
    L14:
        File r13 = new PolarisFileWrapper(this.$watermarkedPath);
        if (r13.exists() == true) goto L17;
    L19:
        boolean r3 = false;
    L20:
        if (r3 == true) goto L23;
        r13 = null;
    L23:
        if (r13 != null) goto L25;
        return null;
    L25:
        File r4 = new PolarisFileWrapper(this.$originalLocalPath).getParentFile();
        if (r4 != null) goto L28;
        return null;
    L28:
        if (r4.canWrite() == true) goto L31;
        r4 = null;
    L31:
        if (r4 != null) goto L34;
        return null;
    L34:
        if (StringsKt.startsWith$default(r13.getCanonicalPath(), r4.getCanonicalPath() + File.separator, false, 2, null) == true) goto L36;
        String r5 = FilesKt.getExtension(r13);
        if (r5.length() == 0) goto L41;
        r0 = false;
    L41:
        if (r0 == false) goto L43;
        r5 = "jpg";
    L43:
        PolarisFileWrapper r1 = new PolarisFileWrapper(r4, "wm_" + UUID.randomUUID() + '.' + r5);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L65
        PolarisFileInputStreamWrapper r7 = new PolarisFileInputStreamWrapper(r13);     // Catch: Throwable -> L65
        PolarisFileOutputStreamWrapper r8 = new PolarisFileOutputStreamWrapper(r1);     // Catch: Throwable -> L60
        ByteStreamsKt.copyTo$default(r7, r8, 0, 2, null);     // Catch: Throwable -> L55
        CloseableKt.closeFinally(r8, null);     // Catch: Throwable -> L60
        CloseableKt.closeFinally(r7, null);     // Catch: Throwable -> L65
        Result.constructor-impl(Boxing.boxBoolean(r13.delete()));     // Catch: Throwable -> L51
    L53:
        Object r14 = Result.constructor-impl(r1.getAbsolutePath());     // Catch: Throwable -> L65
    L67:
        Throwable r2 = Result.exceptionOrNull-impl(r14);
        if (r2 == null) goto L85;
        FLogger.a.w("SharePanelAdapter", "relocateNextTo failed: " + r2);
        return null;
    L85:
        return r14;
    L51:
        th = move-exception;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L65
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L65
        goto L53
    L55:
        th = move-exception;
        throw th;     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: Throwable -> L60
        throw th;     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        throw th;     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);     // Catch: Throwable -> L65
        throw th;     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L67
    L36:
        return r13.getAbsolutePath();
    L17:
        if (r13.isFile() == false) goto L19;
        r3 = true;
        goto L20
    L7:
        if (r11.length() == 0) goto L10;
        r12 = false;
        goto L12
    L73:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
