package androidx.core.view;

import android.app.Activity;
import android.os.Build;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
public final class DragAndDropPermissionsCompat {
    private final DragAndDropPermissions mDragAndDropPermissions;

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static void release(DragAndDropPermissions r10) {
            r10.release();
        }

        @DoNotInline
        static DragAndDropPermissions requestDragAndDropPermissions(Activity r10, DragEvent r11) {
            return r10.requestDragAndDropPermissions(r11);
        }
    }

    private DragAndDropPermissionsCompat(DragAndDropPermissions r10) {
        this.mDragAndDropPermissions = r10;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static DragAndDropPermissionsCompat request(@NonNull Activity r10, @NonNull DragEvent r11) {
        if (Build.VERSION.SDK_INT < 24) goto L8;
        DragAndDropPermissions r12 = Api24Impl.requestDragAndDropPermissions(r10, r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return new DragAndDropPermissionsCompat(r12);
    L8:
        return null;
    }

    public void release() {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api24Impl.release(this.mDragAndDropPermissions);
        return;
    }
}
