package com.larus.camera.impl.ui.viewmodel;

import com.larus.camera.impl.utils.CameraData;
import com.larus.platform.model.camera.ICameraEventExt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class o {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new n());
    }

    public static int b() {
        return ((Number) a.getValue()).intValue();
    }

    public static boolean a(boolean r3, CameraData r4) {
        if (r3 == false) goto L40;
        if (r4 != null) goto L7;
        return false;
    L7:
        if (b() != MultiCaptureScene.DEFAULT.getScene()) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(r4.getCaptureMode(), "CAPTURE_MODE_PHOTO") == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(r4.getScene(), "common_bottom_menu") == true) goto L19;
        if (Intrinsics.areEqual(r4.getScene(), "common_input") == true) goto L19;
        if (Intrinsics.areEqual(r4.getScene(), "send_photo_preview") == true) goto L19;
        return false;
    L19:
        if (b() != MultiCaptureScene.ALL_BOT.getScene()) goto L21;
        return true;
    L21:
        ICameraEventExt r5 = r4.getEventExt();
        if (r5 == null) goto L42;
        String r6 = r5.getConversationId();
        if (r6 == null) goto L47;
        Integer r7 = r4.getEventExt().getBotConversationType();
        if (com.larus.bmhome.utils.i.g(r6) == true) goto L37;
        if (r7 == null) goto L34;
        if (r7.intValue() == 3) goto L37;
    L34:
        if (b() != MultiCaptureScene.OTHER_BOT.getScene()) goto L43;
    L38:
        return true;
    L43:
        return false;
    L37:
        if (b() == MultiCaptureScene.MAIN_BOT.getScene()) goto L38;
        return false;
    L47:
        return false;
    L42:
        return false;
    L40:
        return false;
    }
}
