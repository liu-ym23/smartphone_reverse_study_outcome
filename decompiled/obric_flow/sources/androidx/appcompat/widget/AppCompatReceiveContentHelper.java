package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
final class AppCompatReceiveContentHelper {
    private static final String LOG_TAG = "ReceiveContent";

    @RequiresApi(24)
    public static final class OnDropApi24Impl {
        private OnDropApi24Impl() {
        }

        @DoNotInline
        public static boolean onDropForTextView(@NonNull DragEvent r5, @NonNull TextView r10, @NonNull Activity r11) {
            r11.requestDragAndDropPermissions(r5);
            int r12 = r10.getOffsetForPosition(r5.getX(), r5.getY());
            r10.beginBatchEdit();
            Selection.setSelection((Spannable) r10.getText(), r12);     // Catch: Throwable -> L6
            ViewCompat.performReceiveContent(r10, new ContentInfoCompat.Builder(r5.getClipData(), 3).build());     // Catch: Throwable -> L6
            r10.endBatchEdit();
            return true;
        L6:
            th = move-exception;
            r10.endBatchEdit();
            throw th;
        }

        @DoNotInline
        public static boolean onDropForView(@NonNull DragEvent r5, @NonNull View r10, @NonNull Activity r11) {
            r11.requestDragAndDropPermissions(r5);
            ViewCompat.performReceiveContent(r10, new ContentInfoCompat.Builder(r5.getClipData(), 3).build());
            return true;
        }
    }

    private AppCompatReceiveContentHelper() {
    }

    public static boolean maybeHandleDragEventViaPerformReceiveContent(@NonNull View r5, @NonNull DragEvent r10) {
        return false;
    }

    public static boolean maybeHandleMenuActionViaPerformReceiveContent(@NonNull TextView r5, int r10) {
        return false;
    }

    @Nullable
    public static Activity tryGetActivity(@NonNull View r5) {
        Context r10 = r5.getContext();
    L4:
        if ((r10 instanceof ContextWrapper) == false) goto L10;
        if ((r10 instanceof Activity) == true) goto L8;
        r10 = ((ContextWrapper) r10).getBaseContext();
        goto L4
    L8:
        return (Activity) r10;
    L10:
        return null;
    }
}
