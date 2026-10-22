package com.larus.bmhome.chat.standarduikit.localfileblock.remote;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.localfileblock.remote.PcRemoteFileRepository$download$2", f = "PcRemoteFileRepository.kt", i = {}, l = {308}, m = "invokeSuspend", n = {}, s = {})
public final class PcRemoteFileRepository$download$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $destination;
    final /* synthetic */ String $url;
    Object L$0;
    Object L$1;
    int label;

    public static final class a implements Function1<Throwable, Unit> {
        public final /* synthetic */ Object a;
        public final /* synthetic */ DownloadTask b;

        public a(Object r1, DownloadTask r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object invoke(Object r3) {
            Throwable r4 = (Throwable) r3;
            Object r5 = this.a;
            DownloadTask r0 = this.b;
            monitor-enter(r5);
            Downloader.getInstance(AppHost.a.getApplication()).cancel(r0.getDownloadId());     // Catch: Throwable -> L8
            monitor-exit(r5);
            return Unit.INSTANCE;
        L8:
            th = move-exception;
            throw th;
        }
    }

    public static final class b extends AbsDownloadListener {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ i<Unit> b;
        public final /* synthetic */ File c;

        public final void onCanceled(DownloadInfo r5) {
            if (this.a.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            if (this.b.isActive() == false) goto L10;
            i<Unit> r6 = this.b;
            Result.Companion r0 = Result.Companion;
            r6.resumeWith(Result.constructor-impl(ResultKt.createFailure(new PcRemoteFileException(PcRemoteFileError.DOWNLOAD_FAILED, null, 2, null))));
            return;
        }

        public final void onSuccessed(DownloadInfo r5) {
            if (this.a.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            if (this.b.isActive() == true) goto L8;
            return;
        L8:
            if (r5 == null) goto L10;
            String r6 = r5.getTargetFilePath();
        L12:
            if (Intrinsics.areEqual(r6, this.c.getAbsolutePath()) == true) goto L14;
            i<Unit> r7 = this.b;
            Result.Companion r1 = Result.Companion;
            r7.resumeWith(Result.constructor-impl(ResultKt.createFailure(new PcRemoteFileException(PcRemoteFileError.DOWNLOAD_FAILED, null, 2, null))));
            return;
        L14:
            i<Unit> r8 = this.b;
            Result.Companion r0 = Result.Companion;
            r8.resumeWith(Result.constructor-impl(Unit.INSTANCE));
            return;
        L10:
            r6 = null;
            goto L12
        }

        public final void onFailed(DownloadInfo r4, BaseException r5) {
            if (this.a.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            if (this.b.isActive() == false) goto L17;
            FLogger r6 = FLogger.a;
            StringBuilder r0 = new StringBuilder("stage=download_failed code=");
            Integer r1 = null;
            if (r5 == null) goto L10;
            Integer r2 = Integer.valueOf(r5.getErrorCode());
        L11:
            r0.append(r2);
            r6.e("PcRemoteFilePreview", r0.toString());
            i<Unit> r7 = this.b;
            Result.Companion r3 = Result.Companion;
            PcRemoteFileError r8 = PcRemoteFileError.DOWNLOAD_FAILED;
            if (r5 == null) goto L14;
            r1 = Integer.valueOf(r5.getErrorCode());
        L14:
            r7.resumeWith(Result.constructor-impl(ResultKt.createFailure(new PcRemoteFileException(r8, r1))));
            return;
        L10:
            r2 = null;
            goto L11
        }

        public b(AtomicBoolean r1, j r2, File r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public PcRemoteFileRepository$download$2(File r1, String r2, Continuation<? super PcRemoteFileRepository$download$2> r3) {
        this.$destination = r1;
        this.$url = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PcRemoteFileRepository$download$2(this.$destination, this.$url, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        String r2 = (String) this.L$1;
        File r3 = (File) this.L$0;
        ResultKt.throwOnFailure(r10);
    L27:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        File r11 = this.$destination;
        String r4 = this.$url;
        this.L$0 = r11;
        this.L$1 = r4;
        this.label = 1;
        j r5 = new j(IntrinsicsKt.intercepted(this), 1);
        r5.C();
        AtomicBoolean r6 = new AtomicBoolean(false);
        Object r7 = new Object();
        DownloadTask r8 = Downloader.with(AppHost.a.getApplication());
        File r9 = r11.getParentFile();
        if (r9 == null) goto L11;
        String r12 = r9.getName();
    L12:
        if (r12 != null) goto L14;
        r12 = "";
    L14:
        DownloadTask r13 = r8.taskKey(r12).autoSetHashCodeForSameTask(true).url(r4).savePath(r11.getParent()).name(r11.getName()).subThreadListener(new b(r6, r5, r11));
        r5.i(new a(r7, r13));
        monitor-enter(r7);
    L28:
        th = move-exception;
        throw th;
    L17:
        if (r5.isActive() == false) goto L19;
        r13.asyncDownload(null);     // Catch: Throwable -> L28
    L19:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(r7);
        Object r15 = r5.B();
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L24;
        DebugProbesKt.probeCoroutineSuspended(this);
    L24:
        if (r15 != r0) goto L27;
        return r0;
    L11:
        r12 = null;
        goto L12
    }
}
