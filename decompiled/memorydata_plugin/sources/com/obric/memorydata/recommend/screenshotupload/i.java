package com.obric.memorydata.recommend.screenshotupload;

import android.app.ActivityManager;
import com.obric.memorydata.memory.api.MemoryService;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.recommend.screenshotupload.data.ScreenshotData;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/ScreenshotUploadManager;", "", "<init>", "()V", "TAG", "", "screenshotPipelineManager", "Lcom/obric/memorydata/recommend/screenshotupload/ScreenshotPipelineManager;", "startProcessScreenshotData", "", "screenshotData", "Lcom/obric/memorydata/recommend/screenshotupload/data/ScreenshotData;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f12559a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final h f12560b = null;

    static {
        f12559a = new i();
        f12560b = new h(CollectionsKt.listOf(new c[]{new com.obric.memorydata.recommend.screenshotupload.b.c(), new com.obric.memorydata.recommend.screenshotupload.b.d(), new com.obric.memorydata.recommend.screenshotupload.b.a(), new com.obric.memorydata.recommend.screenshotupload.b.b()}));
    }

    private i() {
    }

    public final void a(ScreenshotData r7) {
        Intrinsics.checkNotNullParameter(r7, "screenshotData");
        if (com.obric.memorydata.recommend.c.a.f12500a.a() == false) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenshotUploadManager", "OAuto 正在运行，不处理", false, 4, null);
        return;
    L7:
        if (ActivityManager.isUserAMonkey() == false) goto L11;
        RunLog.INSTANCE.debug("ScreenshotUploadManager", "自动化测试不处理");
        return;
    L11:
        if (b.f12542a.a(r7.getInputData().getPackageName()) == false) goto L13;
        r7.getOutputData().setInAppSignalFlushRequestId(MemoryService.INSTANCE.requestInAppSignalFlush(r7.getInputData().getTimestamp()));
    L13:
        RunLog.INSTANCE.debug("ScreenshotUploadManager", "startProcessScreenshotData, data: " + u.a(r7));
        RunLog.INSTANCE.info("ScreenshotUploadManager", "startProcessScreenshotData", true);
        f12560b.a(r7);
    }
}
