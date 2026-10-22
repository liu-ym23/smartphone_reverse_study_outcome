package androidx.core.text.method;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.core.os.BuildCompat;

/* JADX INFO: loaded from: classes.dex */
public class LinkMovementMethodCompat extends LinkMovementMethod {
    private static LinkMovementMethodCompat sInstance;

    private LinkMovementMethodCompat() {
    }

    @NonNull
    public static LinkMovementMethodCompat getInstance() {
        if (sInstance != null) goto L6;
        sInstance = new LinkMovementMethodCompat();
    L6:
        return sInstance;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public boolean onTouchEvent(@Nullable TextView r5, @Nullable Spannable r10, @Nullable MotionEvent r11) {
        if (BuildCompat.isAtLeastV() == true) goto L19;
        int r12 = r11.getAction();
        if (r12 == 1) goto L7;
        if (r12 != 0) goto L19;
    L7:
        int r13 = (int) r11.getX();
        int r14 = (int) r11.getY();
        int r15 = r13 - r5.getTotalPaddingLeft();
        int r16 = r14 - r5.getTotalPaddingTop();
        int r17 = r5.getScrollX() + r15;
        int r18 = r5.getScrollY() + r16;
        Layout r19 = r5.getLayout();
        if (r18 >= 0) goto L10;
    L16:
        Selection.removeSelection(r10);
        return Touch.onTouchEvent(r5, r10, r11);
    L10:
        if (r18 > r19.getHeight()) goto L16;
        int r20 = r19.getLineForVertical(r18);
        float r21 = r17;
        if (r21 < r19.getLineLeft(r20)) goto L16;
        if (r21 > r19.getLineRight(r20)) goto L16;
    L19:
        return super.onTouchEvent(r5, r10, r11);
    }
}
