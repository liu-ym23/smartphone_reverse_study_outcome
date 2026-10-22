package com.obric.aikernel.res.downloader.obric;

import android.os.SystemClock;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.k;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.downloader.DownloadTask;
import com.obric.aikernel.res.downloader.j;
import com.obric.aikernel.res.task.NamedTaskScheduler;
import com.obric.download.base.DownloadInfo;
import java.io.File;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import w8.f;
import y8.a;

/* JADX INFO: loaded from: classes2.dex */
public final class ObricDownloadTask implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DownloadTask.b f4980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PackageResourceManager.PresmConfig f4981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.download.base.DownloadTask f4982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile DownloadInfo f4983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile long f4984e;

    public ObricDownloadTask(DownloadTask.b r10, PackageResourceManager.PresmConfig r11) {
        Intrinsics.checkNotNullParameter(r10, "file");
        Intrinsics.checkNotNullParameter(r11, "config");
        this.f4980a = r10;
        this.f4981b = r11;
        this.f4982c = new a(r10.j()).c(r10.c()).g("/data/download_server" + StringsKt.removePrefix(r10.f(), r11.getRootDir())).d(r10.d()).b(r10.b()).h(2).f(r10.e()).e(false).a();
    }

    public static final /* synthetic */ Object j(ObricDownloadTask r10, Continuation r11) {
        return r10.m(r11);
    }

    public static final /* synthetic */ com.obric.download.base.DownloadTask k(ObricDownloadTask r10) {
        return r10.f4982c;
    }

    public static final /* synthetic */ DownloadTask.b l(ObricDownloadTask r10) {
        return r10.f4980a;
    }

    private final Object m(Continuation<? super DownloadInfo> r10) {
        if ((r10 instanceof ObricDownloadTask$getCachedDownloadInfo$1) == false) goto L7;
        ObricDownloadTask$getCachedDownloadInfo$1 r11 = (ObricDownloadTask$getCachedDownloadInfo$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        final ObricDownloadTask this = (ObricDownloadTask) r11.L$1;
        ObricDownloadTask r16 = (ObricDownloadTask) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L22:
        this.f4983d = (DownloadInfo) r13;
        r16.f4984e = SystemClock.elapsedRealtime() + 5000;
        this = r16;
    L24:
        return this.f4983d;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        if (this.f4983d != null) goto L17;
    L18:
        ObricDownloadManager r17 = ObricDownloadManager.f4976a;
        Function1<f, DownloadInfo> r18 = new ObricDownloadTask$getCachedDownloadInfo$2(this);
        r11.L$0 = this;
        r11.L$1 = this;
        r11.label = 1;
        r13 = r17.c(r18, r11);
        if (r13 != r14) goto L21;
        return r14;
    L21:
        r16 = this;
        goto L22
    L17:
        if (SystemClock.elapsedRealtime() <= this.f4984e) goto L24;
    L7:
        r11 = new ObricDownloadTask$getCachedDownloadInfo$1(this, r10);
        goto L8
    }

    private final Object n(Continuation<? super DownloadInfo> r10) {
        return ObricDownloadManager.f4976a.c(new ObricDownloadTask$getDownloadInfo$2(this), r10);
    }

    @Override // com.obric.aikernel.res.downloader.j
    public Object a(Continuation<? super k> r10) {
        if ((r10 instanceof ObricDownloadTask$getDownloadInfos$1) == false) goto L7;
        ObricDownloadTask$getDownloadInfos$1 r11 = (ObricDownloadTask$getDownloadInfos$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        boolean r16 = true;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ObricDownloadTask this = (ObricDownloadTask) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L17:
        DownloadInfo r17 = (DownloadInfo) r13;
        k r18 = new k();
        r18.p(ActivityLifecycle.NAME, this.f4982c.getName());
        if (r17 == null) goto L20;
        Number r19 = Boxing.boxDouble(r17.getSpeed());
    L21:
        r18.o("speed", r19);
        if (r17 != null) goto L24;
    L26:
        r16 = false;
    L27:
        r18.n("downloading", Boxing.boxBoolean(r16));
        return r18;
    L24:
        if (r17.getStatus() != 4) goto L26;
    L20:
        r19 = Boxing.boxInt(-1);
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        r11.L$0 = this;
        r11.label = 1;
        r13 = n(r11);
        if (r13 != r14) goto L17;
        return r14;
    L7:
        r11 = new ObricDownloadTask$getDownloadInfos$1(this, r10);
        goto L8
    }

    @Override // com.obric.aikernel.res.downloader.j
    public boolean b() {
        return new File(this.f4982c.getSavePath(), this.f4982c.getName()).exists();
    }

    @Override // com.obric.aikernel.res.downloader.j
    public Object c(Continuation<? super Unit> r10) {
        return ObricDownloadManager.f4976a.c(new ObricDownloadTask$start$2(this), r10);
    }

    @Override // com.obric.aikernel.res.downloader.j
    public Object d(Continuation<? super Integer> r10) {
        if ((r10 instanceof ObricDownloadTask$getStatus$1) == false) goto L7;
        ObricDownloadTask$getStatus$1 r11 = (ObricDownloadTask$getStatus$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L17:
        DownloadInfo r16 = (DownloadInfo) r13;
        if (r16 == null) goto L20;
        int r17 = r16.getStatus();
    L22:
        return Boxing.boxInt(r17);
    L20:
        r17 = 0;
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        r11.label = 1;
        r13 = n(r11);
        if (r13 != r14) goto L17;
        return r14;
    L7:
        r11 = new ObricDownloadTask$getStatus$1(this, r10);
        goto L8
    }

    @Override // com.obric.aikernel.res.downloader.j
    public Object e(Continuation<? super Unit> r10) {
        Object r11 = ObricDownloadManager.f4976a.c(new ObricDownloadTask$cancel$2(this), r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.obric.aikernel.res.downloader.j
    public Object f(Continuation<? super Unit> r10) {
        Object r11 = NamedTaskScheduler.f5100a.a(this.f4980a.c() + '@' + this.f4980a.b(), new ObricDownloadTask$finish$2(this, null), r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.obric.aikernel.res.downloader.j
    public Object g(Continuation<? super Unit> r10) {
        Object r11 = ObricDownloadManager.f4976a.c(new ObricDownloadTask$pause$2(this), r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.obric.aikernel.res.downloader.j
    public int getId() {
        return this.f4982c.getId();
    }

    @Override // com.obric.aikernel.res.downloader.j
    public Object h(Continuation<? super Integer> r10) {
        if ((r10 instanceof ObricDownloadTask$getProgress$1) == false) goto L7;
        ObricDownloadTask$getProgress$1 r11 = (ObricDownloadTask$getProgress$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L17:
        DownloadInfo r16 = (DownloadInfo) r13;
        if (r16 == null) goto L20;
        int r17 = (int) r16.getProgress();
    L22:
        return Boxing.boxInt(r17);
    L20:
        r17 = 0;
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        r11.label = 1;
        r13 = n(r11);
        if (r13 != r14) goto L17;
        return r14;
    L7:
        r11 = new ObricDownloadTask$getProgress$1(this, r10);
        goto L8
    }

    @Override // com.obric.aikernel.res.downloader.j
    public Object i(Continuation<? super Unit> r10) {
        Object r11 = ObricDownloadManager.f4976a.c(new ObricDownloadTask$resume$2(this), r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }
}
