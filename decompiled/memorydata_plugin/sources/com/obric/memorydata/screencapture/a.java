package com.obric.memorydata.screencapture;

import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;
import com.obric.memorydata.screencapture.accessibility.e;
import com.obric.memorydata.sdk.screencapture.ScreenData;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/screencapture/CaptureCurrentResultMapper;", "", "<init>", "()V", "toScreenData", "Lcom/obric/memorydata/sdk/screencapture/ScreenData;", "screenshot", "targetPackage", "", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12765a = null;

    static {
        f12765a = new a();
    }

    private a() {
    }

    public final ScreenData a(Object r9, String r10) {
        Intrinsics.checkNotNullParameter(r10, "targetPackage");
        ScreenData r8 = new ScreenData(null, null, null, false, null, 31, null);
        if (ZeusTransformUtils.instanceOf(r9, Bitmap.class) == false) goto L6;
        r8.setScreenshot((Bitmap) ZeusTransformUtils.preCheckCast(r9, Bitmap.class, "com.obric.memorydata.plugin"));
    L11:
        return r8;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, HardwareBuffer.class) == false) goto L9;
        r8.setHardwareBuffer((HardwareBuffer) ZeusTransformUtils.preCheckCast(r9, HardwareBuffer.class, "com.obric.memorydata.plugin"));
        goto L11
    L9:
        if (ZeusTransformUtils.instanceOf(r9, e.b.class) == false) goto L13;
        r8.setHeifScreenshotPath(((e.b) ZeusTransformUtils.preCheckCast(r9, e.b.class, "com.obric.memorydata.plugin")).a());
        r8.setVertical(((e.b) ZeusTransformUtils.preCheckCast(r9, e.b.class, "com.obric.memorydata.plugin")).b());
        goto L11
    L13:
        if (r9 != null) goto L17;
        throw new IllegalStateException(("captureCurrent empty screenshot result for " + r10).toString());
    L17:
        throw new IllegalStateException(("captureCurrent unsupported screenshot result " + r9.getClass().getName() + " for " + r10).toString());
    }
}
