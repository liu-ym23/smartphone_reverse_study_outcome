package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentListener;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class TextViewOnReceiveContentListener implements OnReceiveContentListener {
    private static final String LOG_TAG = "ReceiveContent";

    public TextViewOnReceiveContentListener() {
    }

    private static CharSequence coerceToText(@NonNull Context r5, @NonNull ClipData.Item r10, int r11) {
        if ((r11 & 1) == 0) goto L9;
        CharSequence r12 = r10.coerceToText(r5);
        if ((r12 instanceof Spanned) == true) goto L7;
        return r12;
    L7:
        return r12.toString();
    L9:
        return r10.coerceToStyledText(r5);
    }

    private static void replaceSelection(@NonNull Editable r5, @NonNull CharSequence r10) {
        int r11 = Selection.getSelectionStart(r5);
        int r12 = Selection.getSelectionEnd(r5);
        int r13 = Math.max(0, Math.min(r11, r12));
        int r14 = Math.max(0, Math.max(r11, r12));
        Selection.setSelection(r5, r14);
        r5.replace(r13, r14, r10);
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
        Editable r5 = (Editable) r14.getText();
        Context r15 = r14.getContext();
        int r16 = 0;
        boolean r17 = false;
    L10:
        if (r16 >= r12.getItemCount()) goto L17;
        CharSequence r18 = coerceToText(r15, r12.getItemAt(r16), r13);
        if (r18 == null) goto L16;
        if (r17 == true) goto L15;
        replaceSelection(r5, r18);
        r17 = true;
        goto L16
    L15:
        r5.insert(Selection.getSelectionEnd(r5), "\n");
        r5.insert(Selection.getSelectionEnd(r5), r18);
    L16:
        r16 = r16 + 1;
        goto L10
    L17:
        return null;
    }
}
