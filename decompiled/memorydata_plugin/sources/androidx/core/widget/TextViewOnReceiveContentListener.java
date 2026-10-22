package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class TextViewOnReceiveContentListener implements OnReceiveContentListener {
    private static final String LOG_TAG = "ReceiveContent";

    private static final class Api16Impl {
        private Api16Impl() {
        }

        static CharSequence coerce(Context r2, ClipData.Item r3, int r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            if ((r4 & 1) == 0) goto L9;
            CharSequence r6 = r3.coerceToText(r5);
            if (ZeusTransformUtils.instanceOf(r6, Spanned.class) == true) goto L7;
            return r6;
        L7:
            return r6.toString();
        L9:
            return r3.coerceToStyledText(r5);
        }
    }

    private static final class ApiImpl {
        private ApiImpl() {
        }

        static CharSequence coerce(Context r2, ClipData.Item r3, int r4) {
            CharSequence r5 = r3.coerceToText((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
            if ((r4 & 1) != 0) goto L5;
            return r5;
        L5:
            if (ZeusTransformUtils.instanceOf(r5, Spanned.class) == true) goto L7;
            return r5;
        L7:
            return r5.toString();
        }
    }

    public TextViewOnReceiveContentListener() {
    }

    private static CharSequence coerceToText(Context r2, ClipData.Item r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return Api16Impl.coerce(r5, r3, r4);
    L7:
        return ApiImpl.coerce(r5, r3, r4);
    }

    private static void replaceSelection(Editable r4, CharSequence r5) {
        Editable r6 = (Editable) ZeusTransformUtils.wrapperContextForParams(r4, Editable.class, "com.obric.memorydata.plugin");
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = Selection.getSelectionStart(r6);
        int r1 = Selection.getSelectionEnd(r6);
        int r2 = Math.max(0, Math.min(r0, r1));
        int r3 = Math.max(0, Math.max(r0, r1));
        Selection.setSelection(r6, r3);
        r6.replace(r2, r3, r7);
    }

    @Override // androidx.core.view.OnReceiveContentListener
    public ContentInfoCompat onReceiveContent(View r7, ContentInfoCompat r8) {
        if (Log.isLoggable(LOG_TAG, 3) == false) goto L6;
        Log.d(LOG_TAG, "onReceive: " + r8);
    L6:
        if (r8.getSource() != 2) goto L8;
        return r8;
    L8:
        ClipData r6 = r8.getClip();
        int r9 = r8.getFlags();
        TextView r10 = (TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.memorydata.plugin");
        Editable r0 = (Editable) ZeusTransformUtils.preCheckCast(r10.getText(), Editable.class, "com.obric.memorydata.plugin");
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        int r1 = 0;
        boolean r2 = false;
    L10:
        if (r1 >= r6.getItemCount()) goto L17;
        CharSequence r3 = coerceToText(r11, r6.getItemAt(r1), r9);
        if (r3 == null) goto L16;
        if (r2 == true) goto L15;
        replaceSelection(r0, r3);
        r2 = true;
        goto L16
    L15:
        r0.insert(Selection.getSelectionEnd(r0), "\n");
        r0.insert(Selection.getSelectionEnd(r0), r3);
    L16:
        r1 = r1 + 1;
        goto L10
    L17:
        return null;
    }
}
