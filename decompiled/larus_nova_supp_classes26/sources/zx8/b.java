package zx8;

import com.bytedance.keva.Keva;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oq9.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final Keva a = null;
    public static final Lazy b = null;
    public static final List<String> c = null;
    public static final List<String> d = null;
    public static boolean e;
    public static final int f = 0;
    public static final int g = 0;
    public static boolean h;
    public static boolean i;
    public static boolean j;
    public static boolean k;

    static {
        Keva r0 = Keva.getRepo("CAMERA_VE");
        a = r0;
        Lazy r1 = LazyKt.lazy(new a());
        b = r1;
        c = CollectionsKt.listOf("CAPTURE_MODE_PHOTO");
        d = CollectionsKt.listOf(new String[]{"realtime_call", "doc", "slides", "inject_input_camera_result_preview"});
        e = ((f) r1.getValue()).a;
        f = ((f) r1.getValue()).b;
        g = ((f) r1.getValue()).d;
        k = r0.getBoolean("key_permission_out_side_camera", false);
        FLogger.a.i("CameraRecordConfigManager", "init hasPermissionAudio:" + k);
    }

    public static boolean b() {
        FLogger.a.i("CameraRecordConfigManager", "isSupportRecord, settings:" + h + ", mode:" + i + ", scene:" + j);
        if (h == true) goto L5;
    L9:
        return false;
    L5:
        if (i == false) goto L9;
        if (j == false) goto L9;
        return true;
    }

    public static void a(boolean r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "captureMode");
        Intrinsics.checkNotNullParameter(r5, "captureScene");
        FLogger.a.i("CameraRecordConfigManager", "initConfig, support:" + r3 + ", captureMode:" + r4 + ", captureScene:" + r5);
        h = r3;
        i = c.contains(r4);
        j = d.contains(r5) ^ true;
    }
}
