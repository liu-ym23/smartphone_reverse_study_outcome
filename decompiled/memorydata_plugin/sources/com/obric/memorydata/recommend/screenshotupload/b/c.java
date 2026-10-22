package com.obric.memorydata.recommend.screenshotupload.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.constants.OsTeaTrackerEventId;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.IRecommendSettings;
import com.obric.memorydata.middleware.impl.settings.AppSettingsManager;
import com.obric.memorydata.recommend.screenshotupload.data.ScreenshotData;
import com.obric.memorydata.recommend.screenshotupload.data.ScreenshotInputData;
import com.obric.memorydata.recommend.screenshotupload.data.ScreenshotOutputData;
import com.obric.memorydata.recommend.screenshotupload.f;
import com.obric.memorydata.recommend.useraction.recommend.TriggerUploadType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/pipeline/SaveScreenshotPipeline;", "Lcom/obric/memorydata/recommend/screenshotupload/Pipeline;", "Lcom/obric/memorydata/recommend/screenshotupload/data/ScreenshotData;", "<init>", "()V", ActivityLifecycle.NAME, "", "getName", "()Ljava/lang/String;", "process", "", "input", "Lcom/obric/memorydata/recommend/screenshotupload/RequestData;", "keepDebugCopy", "", Params.FILE_PATH, "reportSaveScreenshot", "imageType", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c extends com.obric.memorydata.recommend.screenshotupload.c<ScreenshotData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12550a = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/pipeline/SaveScreenshotPipeline$Companion;", "", "<init>", "()V", "TAG", "", "TYPE_JPEG", "TYPE_HEIF_SDK", "TYPE_HEIF_SYSTEM", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12550a = new a(null);
    }

    public c() {
    }

    private final void a(String r8) {
        if (AppContext.INSTANCE.isDebug() == true) goto L22;
        return;
    L22:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L16
        c r7 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        File r2 = new File(r8);     // Catch: Throwable -> L16
        File r9 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "in_app_collect_debug/screenshots");     // Catch: Throwable -> L16
        if (r9.exists() == false) goto L8;
    L11:
        boolean r0 = true;
    L12:
        if (r0 == false) goto L15;
        Object r10 = Result.m1421constructorimpl(FilesKt.copyTo$default(r2, new File(r9, r2.getName()), true, 0, 4, null));     // Catch: Throwable -> L16
    L18:
        Throwable r11 = Result.m1424exceptionOrNullimpl(r10);
        if (r11 == null) goto L23;
        RunLog.INSTANCE.error("SaveScreenshotPipeline", "keep screenshot debug copy failed path=" + r8, r11);
        return;
    L23:
        return;
    L15:
        throw new IllegalStateException("create screenshot debug archive failed".toString());     // Catch: Throwable -> L16
    L8:
        if (r9.mkdirs() == true) goto L11;
        r0 = false;
    L16:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    private final void a(String r9, String r10) {
        long r0 = new File(r10).length();     // Catch: Exception -> L5
    L7:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SaveScreenshotPipeline", "save screenshot type=" + r9 + " size=" + r0, false, 4, null);
        Tracker r8 = Tracker.INSTANCE;
        String r11 = OsTeaTrackerEventId.MEMORY_SAVE_SCREENSHOT_EVENT.getValue();
        JSONObject r2 = new JSONObject();
        r2.put("image_type", r9);
        r2.put("image_size", r0);
        Unit r12 = Unit.INSTANCE;
        r8.reportEvent(r11, r2);
        return;
    L5:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SaveScreenshotPipeline", "get screenshot file size failed: " + e.getMessage(), null, 4, null);
        r0 = -1;
        goto L7
    }

    @Override // com.obric.memorydata.recommend.screenshotupload.c
    public boolean a(f<ScreenshotData> r23) {
        Intrinsics.checkNotNullParameter(r23, "input");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SaveScreenshotPipeline", "SaveScreenshotPipeline Run", false, 4, null);
        long r5 = System.currentTimeMillis();
        ScreenshotInputData r3 = ((ScreenshotData) ZeusTransformUtils.preCheckCast(r23.a(), ScreenshotData.class, "com.obric.memorydata.plugin")).getInputData();
        IRecommendSettings r0 = AppSettingsManager.INSTANCE.getRecommendSettings();
        if (r3.getTriggerUploadType() != TriggerUploadType.AppOpen) goto L5;
        return true;
    L5:
        String r7 = r3.getHeifScreenshotPath();
        if (r7 != null) goto L8;
    L13:
        boolean r8 = false;
    L14:
        if (r8 == false) goto L18;
        ScreenshotOutputData r1 = ((ScreenshotData) ZeusTransformUtils.preCheckCast(r23.a(), ScreenshotData.class, "com.obric.memorydata.plugin")).getOutputData();
        String r2 = r3.getHeifScreenshotPath();
        Intrinsics.checkNotNull(r2);
        r1.setScreenshotPath(r2);
        String r4 = r3.getHeifScreenshotPath();
        Intrinsics.checkNotNull(r4);
        a(r4);
        String r6 = r3.getHeifScreenshotPath();
        Intrinsics.checkNotNull(r6);
        a("heif_system", r6);
        return true;
    L18:
        if (r3.getScreenshot() == null) goto L20;
    L23:
        String r13 = "jpeg";
        String r14 = "";
        if (r3.getHardwareBuffer() == null) goto L49;
        HardwareBuffer r9 = r3.getHardwareBuffer();
        if (r9 != null) goto L28;
    L30:
        boolean r10 = false;
    L31:
        if (r10 == true) goto L49;
        HardwareBuffer r11 = r3.getHardwareBuffer();
        Intrinsics.checkNotNull(r11);
        if (r11.getWidth() >= r11.getHeight()) goto L35;
        boolean r12 = true;
    L36:
        r3.setVertical(r12);
        if (Intrinsics.areEqual(r0.getImageStyle(), "heif") == true) goto L39;
    L66:
        Bitmap r15 = Bitmap.wrapHardwareBuffer(r11, null);     // Catch: Exception -> L45
        if (r15 == null) goto L47;
        r14 = com.obric.memorydata.utils.e.d.f13218a.a(r15, "screenshot_" + r5 + ".jpeg", 100, r0.getQualityCompressRation());     // Catch: Exception -> L45
    L47:
        r11.close();
        r3.setHardwareBuffer(null);
    L55:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L57;
        boolean r16 = true;
    L58:
        if (r16 == false) goto L61;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SaveScreenshotPipeline", "saveBitmapToFile failed", null, 4, null);
        return false;
    L61:
        ((ScreenshotData) ZeusTransformUtils.preCheckCast(r23.a(), ScreenshotData.class, "com.obric.memorydata.plugin")).getOutputData().setScreenshotPath(r14);
        a(r14);
        a(r13, r14);
        Bitmap r17 = r3.getScreenshot();
        if (r17 == null) goto L64;
        r17.recycle();
    L64:
        r3.setScreenshot(null);
        return true;
    L57:
        r16 = false;
    L45:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SaveScreenshotPipeline", "convert hardware buffer to bitmap failed: " + e.getMessage(), null, 4, null);
        goto L47
    L39:
        if (com.obric.memorydata.utils.e.d.f13218a.b() == false) goto L66;
        r14 = com.obric.memorydata.utils.e.d.f13218a.a(r11, "screenshot_" + r5 + ".heif", 100, r0.getHeifQuality());
        r13 = "heif_sdk";
        goto L47
    L35:
        r12 = false;
        goto L36
    L28:
        if (r9.isClosed() != true) goto L30;
        r10 = true;
    L49:
        if (r3.getScreenshot() == null) goto L55;
        r14 = com.obric.memorydata.utils.e.d.f13218a.a(r3.getScreenshot(), "screenshot_" + r5 + ".jpeg", 100, r0.getQualityCompressRation());
        Bitmap r18 = r3.getScreenshot();
        if (r18 == null) goto L53;
        r18.recycle();
    L53:
        r3.setScreenshot(null);
        goto L55
    L20:
        if (r3.getHardwareBuffer() != null) goto L23;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SaveScreenshotPipeline", "screenshot is null", null, 4, null);
        return false;
    L8:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L10;
        boolean r19 = true;
    L11:
        if (r19 != true) goto L13;
        r8 = true;
        goto L14
    L10:
        r19 = false;
        goto L11
    }
}
