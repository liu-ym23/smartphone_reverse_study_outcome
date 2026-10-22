package com.obric.aikernel.res.downloader.obric;

import android.os.SystemClock;
import android.security.obric.guard.ObricSecurityGuardStub;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonObject;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.downloader.j;
import com.obric.aikernel.res.downloader.n;
import com.obric.download.base.DownloadInfo;
import com.obric.download.base.DownloadTask;
import com.obric.download.base.DownloadTaskBuilder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\r\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u0010\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u0013\u001a\u00020\u0014H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0011\u0010\u0017\u001a\u00020\u0016H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u0018\u001a\u00020\u0016H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0011\u0010\u001b\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u001c\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u001d\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/obric/aikernel/res/downloader/obric/ObricDownloadTask;", "Lcom/obric/aikernel/res/downloader/IDownloadTask;", "file", "Lcom/obric/aikernel/res/downloader/DownloadTask$FileInfo;", "config", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;", "(Lcom/obric/aikernel/res/downloader/DownloadTask$FileInfo;Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;)V", "downloadTask", "Lcom/obric/download/base/DownloadTask;", "info", "Lcom/obric/download/base/DownloadInfo;", "outdatedMills", "", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finish", "getCachedDownloadInfo", "getDownloadInfo", "getDownloadInfos", "Lcom/google/gson/JsonObject;", "getId", "", "getProgress", "getStatus", "isDownloaded", "", "pause", "resume", CommonConsts.APM_INNER_EVENT_COST_START, "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j.b f6032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PackageResourceManager.PresmConfig f6033b;
    private final DownloadTask c;
    private volatile DownloadInfo d;
    private volatile long e;

    public b(j.b r6, PackageResourceManager.PresmConfig r7) {
        Intrinsics.checkNotNullParameter(r6, "file");
        Intrinsics.checkNotNullParameter(r7, "config");
        this.f6032a = r6;
        this.f6033b = r7;
        this.c = new DownloadTaskBuilder(r6.c()).name(r6.a()).savePath("/data/download_server" + StringsKt.removePrefix(r6.d(), (CharSequence) ZeusTransformUtils.preCheckCast(r7.getRootDir(), CharSequence.class, "com.obric.memorydata.plugin"))).onlyWifi(r6.g()).md5(r6.b()).segmentNum(2).retryCount(r6.h()).priorityDownload(false).build();
    }

    public static final /* synthetic */ DownloadTask a(b r0) {
        return r0.c;
    }

    public static final /* synthetic */ Object a(b r2, Continuation r3) {
        return r2.j((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ j.b b(b r0) {
        return r0.f6032a;
    }

    private final Object i(Continuation<? super DownloadInfo> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return a.f6030a.a((Function1) ZeusTransformUtils.preCheckCast(new ObricDownloadTask$getDownloadInfo$2(this), Function1.class, "com.obric.memorydata.plugin"), r5);
    }

    private final Object j(Continuation<? super DownloadInfo> r11) {
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, ObricDownloadTask$getCachedDownloadInfo$1.class) == false) goto L7;
        ObricDownloadTask$getCachedDownloadInfo$1 r1 = (ObricDownloadTask$getCachedDownloadInfo$1) ZeusTransformUtils.preCheckCast(r12, ObricDownloadTask$getCachedDownloadInfo$1.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r13 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        final b this = (b) ZeusTransformUtils.preCheckCast(r1.L$1, b.class, "com.obric.memorydata.plugin");
        b r0 = (b) ZeusTransformUtils.preCheckCast(r1.L$0, b.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);
    L22:
        this.d = (DownloadInfo) ZeusTransformUtils.preCheckCast(r13, DownloadInfo.class, "com.obric.memorydata.plugin");
        r0.e = SystemClock.elapsedRealtime() + 5000;
        this = r0;
    L24:
        return this.d;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        if (this.d != null) goto L17;
    L18:
        a r14 = a.f6030a;
        Function1 r2 = (Function1) ZeusTransformUtils.preCheckCast(new ObricDownloadTask$getCachedDownloadInfo$2(this), Function1.class, "com.obric.memorydata.plugin");
        r1.L$0 = this;
        r1.L$1 = this;
        r1.label = 1;
        r13 = r14.a(r2, r1);
        if (r13 != r3) goto L21;
        return r3;
    L21:
        r0 = this;
        goto L22
    L17:
        if (SystemClock.elapsedRealtime() <= this.e) goto L24;
    L7:
        r1 = new ObricDownloadTask$getCachedDownloadInfo$1(this, r12);
        goto L8
    }

    @Override // com.obric.aikernel.res.downloader.n
    public int a() {
        return this.c.getId();
    }

    @Override // com.obric.aikernel.res.downloader.n
    public Object a(Continuation<? super Unit> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return a.f6030a.a((Function1) ZeusTransformUtils.preCheckCast(new ObricDownloadTask$start$2(this), Function1.class, "com.obric.memorydata.plugin"), r5);
    }

    @Override // com.obric.aikernel.res.downloader.n
    public Object b(Continuation<? super Unit> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        Object r3 = a.f6030a.a((Function1) ZeusTransformUtils.preCheckCast(new ObricDownloadTask$resume$2(this), Function1.class, "com.obric.memorydata.plugin"), r5);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.obric.aikernel.res.downloader.n
    public boolean b() {
        return new File(this.c.getSavePath(), this.c.getName()).exists();
    }

    @Override // com.obric.aikernel.res.downloader.n
    public Object c(Continuation<? super Unit> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        Object r3 = a.f6030a.a((Function1) ZeusTransformUtils.preCheckCast(new ObricDownloadTask$pause$2(this), Function1.class, "com.obric.memorydata.plugin"), r5);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.obric.aikernel.res.downloader.n
    public Object d(Continuation<? super Unit> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        Object r3 = a.f6030a.a((Function1) ZeusTransformUtils.preCheckCast(new ObricDownloadTask$cancel$2(this), Function1.class, "com.obric.memorydata.plugin"), r5);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.obric.aikernel.res.downloader.n
    public Object e(Continuation<? super Unit> r6) {
        Object r5 = com.obric.aikernel.res.task.a.f6099a.a(this.f6032a.a() + '@' + this.f6032a.b(), (Function1) ZeusTransformUtils.preCheckCast(new ObricDownloadTask$finish$2(this, null), Function1.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin"));
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.obric.aikernel.res.downloader.n
    public Object f(Continuation<? super Integer> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, ObricDownloadTask$getStatus$1.class) == false) goto L7;
        ObricDownloadTask$getStatus$1 r0 = (ObricDownloadTask$getStatus$1) ZeusTransformUtils.preCheckCast(r7, ObricDownloadTask$getStatus$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L17:
        DownloadInfo r5 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r8, DownloadInfo.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L20;
        int r9 = r5.getStatus();
    L22:
        return Boxing.boxInt(r9);
    L20:
        r9 = 0;
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        r0.label = 1;
        r8 = i(r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new ObricDownloadTask$getStatus$1(this, r7);
        goto L8
    }

    @Override // com.obric.aikernel.res.downloader.n
    public Object g(Continuation<? super Integer> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, ObricDownloadTask$getProgress$1.class) == false) goto L7;
        ObricDownloadTask$getProgress$1 r0 = (ObricDownloadTask$getProgress$1) ZeusTransformUtils.preCheckCast(r7, ObricDownloadTask$getProgress$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L17:
        DownloadInfo r5 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r8, DownloadInfo.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L20;
        int r9 = (int) r5.getProgress();
    L22:
        return Boxing.boxInt(r9);
    L20:
        r9 = 0;
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        r0.label = 1;
        r8 = i(r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new ObricDownloadTask$getProgress$1(this, r7);
        goto L8
    }

    @Override // com.obric.aikernel.res.downloader.n
    public Object h(Continuation<? super JsonObject> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, ObricDownloadTask$getDownloadInfos$1.class) == false) goto L7;
        ObricDownloadTask$getDownloadInfos$1 r0 = (ObricDownloadTask$getDownloadInfos$1) ZeusTransformUtils.preCheckCast(r7, ObricDownloadTask$getDownloadInfos$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        b this = (b) ZeusTransformUtils.preCheckCast(r0.L$0, b.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r8);
    L17:
        DownloadInfo r9 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r8, DownloadInfo.class, "com.obric.memorydata.plugin");
        JsonObject r1 = new JsonObject();
        r1.addProperty(ActivityLifecycle.NAME, this.c.getName());
        if (r9 == null) goto L20;
        Object r5 = Boxing.boxDouble(r9.getSpeed());
    L21:
        r1.addProperty("speed", (Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin"));
        if (r9 != null) goto L24;
    L26:
        r4 = false;
    L27:
        r1.addProperty("downloading", Boxing.boxBoolean(r4));
        return r1;
    L24:
        if (r9.getStatus() != 4) goto L26;
    L20:
        r5 = Boxing.boxInt(-1);
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        r0.L$0 = this;
        r0.label = 1;
        r8 = i(r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new ObricDownloadTask$getDownloadInfos$1(this, r7);
        goto L8
    }
}
