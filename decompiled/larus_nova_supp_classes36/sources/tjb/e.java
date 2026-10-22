package tjb;

import android.text.Layout;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ AppCompatTextView a;
    public final /* synthetic */ int b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        Layout r0 = this.a.getLayout();
        if (r0 != null) goto L7;
        return true;
    L7:
        if (r0.getLineCount() <= this.b) goto L9;
        this.a.setTextSize(2, 14.0f);
    L9:
        this.a.setMaxLines(this.b);
        return false;
    }

    public e(AppCompatTextView r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
