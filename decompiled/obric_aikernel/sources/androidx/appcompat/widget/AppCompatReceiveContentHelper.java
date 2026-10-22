package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
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
    private static final class OnDropApi24Impl {
        private OnDropApi24Impl() {
        }

        @DoNotInline
        static boolean onDropForTextView(@NonNull DragEvent r10, @NonNull TextView r11, @NonNull Activity r12) {
            r12.requestDragAndDropPermissions(r10);
            int r13 = r11.getOffsetForPosition(r10.getX(), r10.getY());
            r11.beginBatchEdit();
            Selection.setSelection((Spannable) r11.getText(), r13);     // Catch: Throwable -> L6
            ViewCompat.performReceiveContent(r11, new ContentInfoCompat.Builder(r10.getClipData(), 3).build());     // Catch: Throwable -> L6
            r11.endBatchEdit();
            return true;
        L6:
            th = move-exception;
            r11.endBatchEdit();
            throw th;
        }

        @DoNotInline
        static boolean onDropForView(@NonNull DragEvent r10, @NonNull View r11, @NonNull Activity r12) {
            r12.requestDragAndDropPermissions(r10);
            ViewCompat.performReceiveContent(r11, new ContentInfoCompat.Builder(r10.getClipData(), 3).build());
            return true;
        }
    }

    private AppCompatReceiveContentHelper() {
    }

    static boolean maybeHandleDragEventViaPerformReceiveContent(@NonNull View r10, @NonNull DragEvent r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 31) goto L5;
    L26:
        return false;
    L5:
        if (r12 < 24) goto L26;
        if (r11.getLocalState() != null) goto L26;
        if (ViewCompat.getOnReceiveContentMimeTypes(r10) == null) goto L26;
        Activity r13 = tryGetActivity(r10);
        if (r13 != null) goto L16;
        Log.i(LOG_TAG, "Can't handle drop: no activity: view=" + r10);
        return false;
    L16:
        if (r11.getAction() != 1) goto L20;
        return !(r10 instanceof TextView);
    L20:
        if (r11.getAction() != 3) goto L26;
        if ((r10 instanceof TextView) == false) goto L25;
        return OnDropApi24Impl.onDropForTextView(r11, (TextView) r10, r13);
    L25:
        return OnDropApi24Impl.onDropForView(r11, r10, r13);
    }

    static boolean maybeHandleMenuActionViaPerformReceiveContent(@NonNull TextView r10, int r11) {
        int r12 = 0;
        if (Build.VERSION.SDK_INT < 31) goto L5;
    L25:
        return false;
    L5:
        if (ViewCompat.getOnReceiveContentMimeTypes(r10) == null) goto L25;
        if (r11 != 16908322) goto L9;
    L11:
        ClipboardManager r13 = (ClipboardManager) r10.getContext().getSystemService("clipboard");
        if (r13 != null) goto L14;
        ClipData r14 = null;
    L16:
        if (r14 != null) goto L18;
    L24:
        return true;
    L18:
        if (r14.getItemCount() <= 0) goto L24;
        ContentInfoCompat.Builder r15 = new ContentInfoCompat.Builder(r14, 1);
        if (r11 == 16908322) goto L23;
        r12 = 1;
    L23:
        ViewCompat.performReceiveContent(r10, r15.setFlags(r12).build());
        goto L24
    L14:
        r14 = r13.getPrimaryClip();
        goto L16
    L9:
        if (r11 == 16908337) goto L11;
        goto L11
    }

    @Nullable
    static Activity tryGetActivity(@NonNull View r10) {
        Context r11 = r10.getContext();
    L4:
        if ((r11 instanceof ContextWrapper) == false) goto L10;
        if ((r11 instanceof Activity) == true) goto L8;
        r11 = ((ContextWrapper) r11).getBaseContext();
        goto L4
    L8:
        return (Activity) r11;
    L10:
        return null;
    }
}
