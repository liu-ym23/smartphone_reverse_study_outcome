package ut8;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import lw8.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j {
    /* JADX WARN: Multi-variable type inference failed */
    public static int b(TextView r4) {
        int r1 = 0;
        if (r4.getCompoundDrawables()[0] == null) goto L5;
        int r0 = r4.getCompoundDrawables()[0].getIntrinsicWidth() + r4.getCompoundDrawablePadding();
    L6:
        int r2 = r0 + r4.getPaddingLeft();
        if ((r4 instanceof CustomMarkdownTextView) == false) goto L16;
        l r5 = ((CustomMarkdownTextView) r4).getMarkdownContent();
        if (r5 == null) goto L16;
        SpannableStringBuilder r6 = r5.e();
        lw8.e[] r7 = (lw8.e[]) r6.getSpans(0, r6.length(), lw8.e.class);
        if (r7 == null) goto L16;
        if (r7.length <= 0) goto L16;
        r1 = r7[0].a();
    L16:
        return r2 + r1;
    L5:
        r0 = 0;
        goto L6
    }

    public static int c(TextView r2) {
        if (r2.getCompoundDrawables()[1] == null) goto L5;
        int r0 = r2.getCompoundDrawables()[1].getIntrinsicHeight() + r2.getCompoundDrawablePadding();
    L7:
        return r0 + r2.getPaddingTop();
    L5:
        r0 = 0;
        goto L7
    }

    public static int a(TextView r1, int r2, int r3) {
        int r4 = r2 - b(r1);
        int r5 = r3 - c(r1);
        Layout r6 = r1.getLayout();
        if (r6 != null) goto L11;
    L8:
        return -1;
    L11:
        int r7 = r6.getOffsetForHorizontal(r6.getLineForVertical(r5), r4);     // Catch: Exception -> L10
        if (((int) r6.getPrimaryHorizontal(r7)) <= r4) goto L13;
        return r6.getOffsetToLeftOf(r7);
    L13:
        return r7;
    }
}
