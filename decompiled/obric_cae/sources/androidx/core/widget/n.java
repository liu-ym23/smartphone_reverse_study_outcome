package androidx.core.widget;

import android.icu.text.DecimalFormatSymbols;
import android.text.PrecomputedText;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class n {
    public static String[] a(DecimalFormatSymbols r8) {
        return r8.getDigitStrings();
    }

    public static PrecomputedText.Params b(TextView r8) {
        return r8.getTextMetricsParams();
    }

    public static void c(TextView r8, int r10) {
        r8.setFirstBaselineToTopHeight(r10);
    }
}
