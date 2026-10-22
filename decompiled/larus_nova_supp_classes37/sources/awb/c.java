package awb;

import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.widget.TextView;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.textselection.MmSelectableSummaryTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public final TextView a;
    public final d b;
    public final Handler c;
    public String d;
    public long e;
    public final b f;

    public final void a(boolean r4) {
        if ((this.a.getText() instanceof Spannable) == true) goto L8;
        TextView r0 = this.a;
        CharSequence r2 = this.a.getText();
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        r0.setText(new SpannableString(r2));
    L8:
        if (r4 == true) goto L10;
    L18:
        this.a.setTextIsSelectable(false);
        this.a.setCustomSelectionActionModeCallback(null);
        this.c.removeCallbacks(this.f);
        return;
    L10:
        if (this.b.a == false) goto L18;
        this.a.setTextIsSelectable(true);     // Catch: Exception -> L13
    L14:
        Integer r5 = this.b.c;
        if (r5 == null) goto L17;
        int r6 = r5.intValue();
        this.a.setHighlightColor(r6);
    L17:
        this.a.setCustomSelectionActionModeCallback(new a(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(MmSelectableSummaryTextView r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        Intrinsics.checkNotNullParameter(r3, "config");
        this.a = r2;
        this.b = r3;
        this.c = new Handler(Looper.getMainLooper());
        this.f = new b(this);
    }
}
