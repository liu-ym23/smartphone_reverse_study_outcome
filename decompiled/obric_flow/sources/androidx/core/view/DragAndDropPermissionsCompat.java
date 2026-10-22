package androidx.core.view;

import android.app.Activity;
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
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static void release(DragAndDropPermissions r5) {
            r5.release();
        }

        @DoNotInline
        public static DragAndDropPermissions requestDragAndDropPermissions(Activity r5, DragEvent r10) {
            return r5.requestDragAndDropPermissions(r10);
        }
    }

    private DragAndDropPermissionsCompat(DragAndDropPermissions r5) {
        this.mDragAndDropPermissions = r5;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static DragAndDropPermissionsCompat request(@NonNull Activity r5, @NonNull DragEvent r10) {
        DragAndDropPermissions r11 = Api24Impl.requestDragAndDropPermissions(r5, r10);
        if (r11 != null) goto L5;
        return null;
    L5:
        return new DragAndDropPermissionsCompat(r11);
    }

    public void release() {
        Api24Impl.release(this.mDragAndDropPermissions);
    }
}
