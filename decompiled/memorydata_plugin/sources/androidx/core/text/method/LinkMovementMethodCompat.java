package androidx.core.text.method;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.core.os.BuildCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class LinkMovementMethodCompat extends LinkMovementMethod {
    private static LinkMovementMethodCompat sInstance;

    private LinkMovementMethodCompat() {
    }

    public static LinkMovementMethodCompat getInstance() {
        if (sInstance != null) goto L6;
        sInstance = new LinkMovementMethodCompat();
    L6:
        return sInstance;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView r6, Spannable r7, MotionEvent r8) {
        Spannable r9 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r7, Spannable.class, "com.obric.memorydata.plugin");
        if (BuildCompat.isAtLeastV() == true) goto L22;
        int r0 = r8.getAction();
        boolean r1 = true;
        if (r0 == 1) goto L7;
        if (r0 != 0) goto L22;
    L7:
        int r2 = (int) r8.getX();
        int r3 = (int) r8.getY();
        int r4 = r2 - r6.getTotalPaddingLeft();
        int r5 = r3 - r6.getTotalPaddingTop();
        int r10 = r4 + r6.getScrollX();
        int r11 = r5 + r6.getScrollY();
        Layout r12 = r6.getLayout();
        if (r11 >= 0) goto L10;
    L18:
        if (r1 == false) goto L22;
        Selection.removeSelection(r9);
        return Touch.onTouchEvent(r6, r9, r8);
    L10:
        if (r11 > r12.getHeight()) goto L18;
        int r13 = r12.getLineForVertical(r11);
        float r14 = r10;
        if (r14 < r12.getLineLeft(r13)) goto L18;
        if (r14 > r12.getLineRight(r13)) goto L18;
        r1 = false;
    L22:
        return super.onTouchEvent(r6, r9, r8);
    }
}
