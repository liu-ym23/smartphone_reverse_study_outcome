package wb2;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.view.View;
import android.widget.TextView;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    static {
    }

    @JvmStatic
    public static final boolean a(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        boolean r1 = r10 instanceof TextView;
        CharSequence r2 = null;
        if (r1 == true) goto L5;
        View r3 = null;
    L6:
        TextView r4 = (TextView) r3;
        if (r4 == null) goto L9;
        CharSequence r5 = r4.getText();
    L11:
        if ((r5 instanceof Spannable) == true) goto L13;
        r5 = null;
    L13:
        Spannable r6 = (Spannable) r5;
        if (r6 == null) goto L24;
        TextView r7 = (TextView) r10;
        d[] r8 = (d[]) r6.getSpans(r7.getSelectionStart(), r7.getSelectionEnd(), d.class);
        int r9 = r8.length;
        int r11 = 0;
    L16:
        if (r11 >= r9) goto L24;
        d r13 = r8[r11];
        r13.getClass();
        Intrinsics.checkNotNullParameter(r10, "view");
        d.a r14 = r13.a;
        if (r14 == null) goto L20;
        boolean r15 = r14.d(r10, r13);
    L21:
        if (r15 == true) goto L22;
        r11 = r11 + 1;
        goto L16
    L22:
        return true;
    L20:
        r15 = false;
    L24:
        if (r1 == true) goto L26;
        View r16 = null;
    L27:
        TextView r17 = (TextView) r16;
        if (r17 == null) goto L30;
        CharSequence r18 = r17.getText();
    L32:
        if ((r18 instanceof SpannedString) == true) goto L34;
        r18 = null;
    L34:
        SpannedString r19 = (SpannedString) r18;
        if (r19 == null) goto L45;
        TextView r20 = (TextView) r10;
        d[] r21 = (d[]) r19.getSpans(r20.getSelectionStart(), r20.getSelectionEnd(), d.class);
        int r23 = r21.length;
        int r24 = 0;
    L37:
        if (r24 >= r23) goto L45;
        d r25 = r21[r24];
        r25.getClass();
        Intrinsics.checkNotNullParameter(r10, "view");
        d.a r26 = r25.a;
        if (r26 == null) goto L41;
        boolean r27 = r26.d(r10, r25);
    L42:
        if (r27 == true) goto L43;
        r24 = r24 + 1;
        goto L37
    L43:
        return true;
    L41:
        r27 = false;
    L45:
        if (r1 == true) goto L47;
        View r28 = null;
    L48:
        TextView r29 = (TextView) r28;
        if (r29 == null) goto L51;
        CharSequence r30 = r29.getText();
    L53:
        if ((r30 instanceof SpannableString) == false) goto L56;
        r2 = r30;
    L56:
        SpannableString r31 = (SpannableString) r2;
        if (r31 == null) goto L67;
        TextView r33 = (TextView) r10;
        d[] r34 = (d[]) r31.getSpans(r33.getSelectionStart(), r33.getSelectionEnd(), d.class);
        int r35 = r34.length;
        int r36 = 0;
    L59:
        if (r36 >= r35) goto L67;
        d r37 = r34[r36];
        r37.getClass();
        Intrinsics.checkNotNullParameter(r10, "view");
        d.a r38 = r37.a;
        if (r38 == null) goto L63;
        boolean r39 = r38.d(r10, r37);
    L64:
        if (r39 == true) goto L65;
        r36 = r36 + 1;
        goto L59
    L65:
        return true;
    L63:
        r39 = false;
    L67:
        return false;
    L51:
        r30 = null;
        goto L53
    L47:
        r28 = r10;
        goto L48
    L30:
        r18 = null;
        goto L32
    L26:
        r16 = r10;
        goto L27
    L9:
        r5 = null;
        goto L11
    L5:
        r3 = r10;
        goto L6
    }
}
