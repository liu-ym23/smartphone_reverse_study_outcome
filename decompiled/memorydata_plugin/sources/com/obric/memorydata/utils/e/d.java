package com.obric.memorydata.utils.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;
import com.bytedance.crash.Ensure;
import com.bytedance.cypressencoder.CypressEncoder;
import com.obric.memorydata.constants.OsTeaTrackerEventId;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\u0005J\u001a\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0003J,\u0010\u0011\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\bJ\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\bH\u0002J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J*\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\bJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/memorydata/utils/screen/ScreenshotUtils;", "", "<init>", "()V", "SCREENSHOT_DIR_NAME", "", "TAG", "DEFAULT_COMPRESSION_QUALITY", "", "DEFAULT_RESOLUTION_QUALITY", "IMAGE_NAME_PREFIX", "IMAGE_NAME_SUFFIX", "getImageDir", "saveBitmapToDownloadsFolder", "bitmap", "Landroid/graphics/Bitmap;", "fileName", "saveBitmapToFile", "resolutionQuality", "compressionQuality", "scaleBitmap", "getFileNameByImageId", "imageId", "", "encoderIsValid", "", "encoder", "Lcom/bytedance/cypressencoder/CypressEncoder;", "saveHardwareBufferToFile", "buffer", "Landroid/hardware/HardwareBuffer;", "getFilePathByImageId", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f13218a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CypressEncoder f13219b = null;

    static {
        f13218a = new d();
        f13219b = (CypressEncoder) ZeusTransformUtils.preCheckCast(y.a(null, $$Lambda$d$rPACJ2iG440cvXPFkQXf5ZqxY1Y.INSTANCE, 1, null), CypressEncoder.class, "com.obric.memorydata.plugin");
    }

    private d() {
    }

    private final Bitmap a(Bitmap r7, int r8) {
        int r6 = r7.getWidth();
        int r0 = r7.getHeight();
        double r2 = ((double) RangesKt.coerceIn(r8, 1, 100)) / 100.0d;
        Bitmap r9 = Bitmap.createScaledBitmap(r7, (int) (((double) r6) * r2), (int) (((double) r0) * r2), true);
        Intrinsics.checkNotNullExpressionValue(r9, "createScaledBitmap(...)");
        return r9;
    }

    private static final CypressEncoder c() {
        return CypressEncoder.a();
    }

    public static /* synthetic */ CypressEncoder lambda$rPACJ2iG440cvXPFkQXf5ZqxY1Y() {
        return c();
    }

    public final String a() {
        String r2 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "Screenshots").getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(r2, "getAbsolutePath(...)");
        return r2;
    }

    public final String a(long r2) {
        return "screenshot_" + r2 + ".jpeg";
    }

    public final String a(Bitmap r8, String r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "fileName");
        if (r8 != null) goto L6;
        RunLog.INSTANCE.debug("ScreenshotUtils", "Bitmap is null, cannot save to file.");
        return "";
    L6:
        Bitmap r7 = a(r8, r10);
        File r2 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "Screenshots");
        if (r2.exists() == true) goto L9;
        r2.mkdirs();
    L9:
        File r12 = new File(r2, r9);
        Closeable r13 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r12), Closeable.class, "com.obric.memorydata.plugin");     // Catch: IOException -> L20
        FileOutputStream r3 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r13, FileOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        r7.compress(Bitmap.CompressFormat.JPEG, RangesKt.coerceIn(r11, 0, 100), (OutputStream) ZeusTransformUtils.preCheckCast(r3, OutputStream.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
        String r14 = r12.getAbsolutePath();     // Catch: Throwable -> L15
        Intrinsics.checkNotNullExpressionValue(r14, "getAbsolutePath(...)");     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r13, null);     // Catch: IOException -> L20
        return r14;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);     // Catch: IOException -> L20
        throw th;     // Catch: IOException -> L20
    L20:
        e = move-exception;
        RunLog.INSTANCE.error("ScreenshotUtils", "Error saving screenshot to file", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return "";
    }

    public final String a(HardwareBuffer r12, String r13, int r14, int r15) {
        Intrinsics.checkNotNullParameter(r12, "buffer");
        Intrinsics.checkNotNullParameter(r13, "fileName");
        File r1 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "Screenshots");
        if (r1.exists() == true) goto L5;
        r1.mkdirs();
    L5:
        String r11 = new File(r1, r13).getAbsolutePath();
        double r2 = ((double) r14) / 100.0d;
        int r6 = (int) (((double) r12.getWidth()) * r2);
        int r7 = (int) (((double) r12.getHeight()) * r2);
        RunLog.INSTANCE.debug("ScreenshotUtils", "width: " + r6 + " height: " + r7);
        CypressEncoder r3 = f13219b;
        if (r3 == null) goto L8;
        int r16 = r3.a(r12, r11, "heif", r6, r7, RangesKt.coerceIn(r15, 1, 50), false, false);
    L9:
        Tracker r17 = Tracker.INSTANCE;
        String r18 = OsTeaTrackerEventId.SCREENSHOT_TO_FILE_EVENT.getValue();
        JSONObject r19 = new JSONObject();
        r19.put("style", "heif");
        r19.put("errorCode", r16);
        Unit r4 = Unit.INSTANCE;
        r17.reportEvent(r18, r19);
        if (r16 != 0) goto L13;
        Intrinsics.checkNotNull(r11);
        return r11;
    L13:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenshotUtils", "encodeHardwareBuffer failed, ret=" + r16, null, 4, null);
        return "";
    L8:
        r16 = -1;
        goto L9
    }

    public final boolean b() {
        CypressEncoder r1 = f13219b;
        if (r1 != null) goto L5;
        Ensure.ensureNotReachHere("encoder can not be null");
    L5:
        if (r1 == null) goto L7;
        return true;
    L7:
        return false;
    }
}
