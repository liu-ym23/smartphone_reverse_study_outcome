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
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
final class AppCompatReceiveContentHelper {
    private static final String LOG_TAG = "ReceiveContent";

    private static final class OnDropApi24Impl {
        private OnDropApi24Impl() {
        }

        static boolean onDropForTextView(DragEvent r3, TextView r4, Activity r5) {
            ((Activity) ZeusTransformUtils.wrapperContextForParams(r5, Activity.class, "com.obric.memorydata.plugin")).requestDragAndDropPermissions(r3);
            int r6 = r4.getOffsetForPosition(r3.getX(), r3.getY());
            r4.beginBatchEdit();
            Selection.setSelection((Spannable) ZeusTransformUtils.preCheckCast(r4.getText(), Spannable.class, "com.obric.memorydata.plugin"), r6);     // Catch: Throwable -> L6
            ViewCompat.performReceiveContent(r4, new ContentInfoCompat.Builder(r3.getClipData(), 3).build());     // Catch: Throwable -> L6
            r4.endBatchEdit();
            return true;
        L6:
            th = move-exception;
            r4.endBatchEdit();
            throw th;
        }

        static boolean onDropForView(DragEvent r2, View r3, Activity r4) {
            ((Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin")).requestDragAndDropPermissions(r2);
            ViewCompat.performReceiveContent(r3, new ContentInfoCompat.Builder(r2.getClipData(), 3).build());
            return true;
        }
    }

    private AppCompatReceiveContentHelper() {
    }

    static boolean maybeHandleDragEventViaPerformReceiveContent(View r5, DragEvent r6) {
        if (Build.VERSION.SDK_INT < 31) goto L5;
    L26:
        return false;
    L5:
        if (Build.VERSION.SDK_INT < 24) goto L26;
        if (r6.getLocalState() != null) goto L26;
        if (ViewCompat.getOnReceiveContentMimeTypes(r5) == null) goto L26;
        Activity r0 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(tryGetActivity(r5), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L16;
        Log.i(LOG_TAG, "Can't handle drop: no activity: view=" + r5);
        return false;
    L16:
        if (r6.getAction() != 1) goto L20;
        return !ZeusTransformUtils.instanceOf(r5, TextView.class);
    L20:
        if (r6.getAction() != 3) goto L26;
        if (ZeusTransformUtils.instanceOf(r5, TextView.class) == false) goto L25;
        return OnDropApi24Impl.onDropForTextView(r6, (TextView) ZeusTransformUtils.preCheckCast(r5, TextView.class, "com.obric.memorydata.plugin"), r0);
    L25:
        return OnDropApi24Impl.onDropForView(r6, r5, r0);
    }

    static boolean maybeHandleMenuActionViaPerformReceiveContent(TextView r5, int r6) {
        int r1 = 0;
        if (Build.VERSION.SDK_INT < 31) goto L5;
    L25:
        return false;
    L5:
        if (ViewCompat.getOnReceiveContentMimeTypes(r5) == null) goto L25;
        if (r6 != 16908322) goto L9;
    L11:
        ClipboardManager r2 = (ClipboardManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("clipboard"), ClipboardManager.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L14;
        ClipData r3 = null;
    L16:
        if (r3 != null) goto L18;
    L24:
        return true;
    L18:
        if (r3.getItemCount() <= 0) goto L24;
        ContentInfoCompat.Builder r4 = new ContentInfoCompat.Builder(r3, 1);
        if (r6 == 16908322) goto L23;
        r1 = 1;
    L23:
        ViewCompat.performReceiveContent(r5, r4.setFlags(r1).build());
        goto L24
    L14:
        r3 = r2.getPrimaryClip();
        goto L16
    L9:
        if (r6 == 16908337) goto L11;
        goto L11
    }

    static Activity tryGetActivity(View r2) {
        Context r3 = r2.getContext();
    L3:
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ContextWrapper.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r4, Activity.class) == true) goto L8;
        r3 = ((ContextWrapper) ZeusTransformUtils.preCheckCast(r4, ContextWrapper.class, "com.obric.memorydata.plugin")).getBaseContext();
        goto L3
    L8:
        return (Activity) ZeusTransformUtils.preCheckCast(r4, Activity.class, "com.obric.memorydata.plugin");
    L10:
        return null;
    }
}
