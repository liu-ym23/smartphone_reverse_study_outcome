package j4a;

import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j {
    static {
    }

    public static void a(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        r2.putExtra("android.intent.extras.CAMERA_FACING", 0);
        r2.putExtra("android.intent.extras.LENS_FACING_BACK", 1);
        r2.putExtra("default_camera", "0");
        r2.putExtra("default_mode", "com.huawei.camera2.mode.photo.PhotoMode");
        r2.putExtra("camerafacing", "back");
        r2.putExtra("previous_mode", "back");
    }

    public static void b(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        r2.putExtra("android.intent.extras.CAMERA_FACING", 1);
        r2.putExtra("android.intent.extras.LENS_FACING_FRONT", 1);
        r2.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
        r2.putExtra("default_camera", "1");
        r2.putExtra("default_mode", "com.huawei.camera2.mode.photo.PhotoMode");
        r2.putExtra("camerafacing", "front");
        r2.putExtra("previous_mode", "front");
    }
}
