package com.bytedance.android.live.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.j0;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class CustomFontTextView extends LiveTextView {
    public static final /* synthetic */ int d = 0;
    public Disposable c;

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.TextView*/.onAttachedToWindow();
        j0 r0 = LiveTextView.a;     // Catch: Throwable -> L7
        if (r0 == null) goto L12;
        this.c = r0.get().subscribe(new c(this), new d());     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        ALogger.e("font_text_view", th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.TextView*/.onDetachedFromWindow();
        Disposable r0 = this.c;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public CustomFontTextView(Context r1) {
        super(r1);
    }

    public CustomFontTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public CustomFontTextView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
