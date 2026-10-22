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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentListener;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class TextViewOnReceiveContentListener implements OnReceiveContentListener {
    private static final String LOG_TAG = "ReceiveContent";

    @RequiresApi(16)
    private static final class Api16Impl {
        private Api16Impl() {
        }

        static CharSequence coerce(@NonNull Context r10, @NonNull ClipData.Item r11, int r12) {
            if ((r12 & 1) == 0) goto L9;
            CharSequence r13 = r11.coerceToText(r10);
            if ((r13 instanceof Spanned) == true) goto L7;
            return r13;
        L7:
            return r13.toString();
        L9:
            return r11.coerceToStyledText(r10);
        }
    }

    private static final class ApiImpl {
        private ApiImpl() {
        }

        static CharSequence coerce(@NonNull Context r10, @NonNull ClipData.Item r11, int r12) {
            CharSequence r13 = r11.coerceToText(r10);
            if ((r12 & 1) != 0) goto L5;
            return r13;
        L5:
            if ((r13 instanceof Spanned) == true) goto L7;
            return r13;
        L7:
            return r13.toString();
        }
    }

    public TextViewOnReceiveContentListener() {
    }

    private static CharSequence coerceToText(@NonNull Context r10, @NonNull ClipData.Item r11, int r12) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return Api16Impl.coerce(r10, r11, r12);
    L7:
        return ApiImpl.coerce(r10, r11, r12);
    }

    private static void replaceSelection(@NonNull Editable r10, @NonNull CharSequence r11) {
        int r12 = Selection.getSelectionStart(r10);
        int r13 = Selection.getSelectionEnd(r10);
        int r14 = Math.max(0, Math.min(r12, r13));
        int r15 = Math.max(0, Math.max(r12, r13));
        Selection.setSelection(r10, r15);
        r10.replace(r14, r15, r11);
    }

    @Override // androidx.core.view.OnReceiveContentListener
    @Nullable
    public ContentInfoCompat onReceiveContent(@NonNull View r10, @NonNull ContentInfoCompat r11) {
        if (Log.isLoggable(LOG_TAG, 3) == false) goto L6;
        Log.d(LOG_TAG, "onReceive: " + r11);
    L6:
        if (r11.getSource() != 2) goto L8;
        return r11;
    L8:
        ClipData r12 = r11.getClip();
        int r13 = r11.getFlags();
        TextView r14 = (TextView) r10;
        Editable r15 = (Editable) r14.getText();
        Context r16 = r14.getContext();
        int r17 = 0;
        boolean r18 = false;
    L10:
        if (r17 >= r12.getItemCount()) goto L17;
        CharSequence r19 = coerceToText(r16, r12.getItemAt(r17), r13);
        if (r19 == null) goto L16;
        if (r18 == true) goto L15;
        replaceSelection(r15, r19);
        r18 = true;
        goto L16
    L15:
        r15.insert(Selection.getSelectionEnd(r15), "\n");
        r15.insert(Selection.getSelectionEnd(r15), r19);
    L16:
        r17 = r17 + 1;
        goto L10
    L17:
        return null;
    }
}
