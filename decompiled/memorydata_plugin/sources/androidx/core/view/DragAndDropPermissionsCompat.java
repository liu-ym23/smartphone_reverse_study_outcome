package androidx.core.view;

import android.app.Activity;
import android.os.Build;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class DragAndDropPermissionsCompat {
    private final DragAndDropPermissions mDragAndDropPermissions;

    static class Api24Impl {
        private Api24Impl() {
        }

        static void release(DragAndDropPermissions r0) {
            r0.release();
        }

        static DragAndDropPermissions requestDragAndDropPermissions(Activity r2, DragEvent r3) {
            return ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin")).requestDragAndDropPermissions(r3);
        }
    }

    private DragAndDropPermissionsCompat(DragAndDropPermissions r1) {
        this.mDragAndDropPermissions = r1;
    }

    public static DragAndDropPermissionsCompat request(Activity r2, DragEvent r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 24) goto L8;
        DragAndDropPermissions r5 = Api24Impl.requestDragAndDropPermissions(r4, r3);
        if (r5 != null) goto L7;
        return null;
    L7:
        return new DragAndDropPermissionsCompat(r5);
    L8:
        return null;
    }

    public void release() {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api24Impl.release(this.mDragAndDropPermissions);
        return;
    }
}
