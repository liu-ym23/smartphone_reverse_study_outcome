package com.ss.android.lark.inline.ai.ui.imageviewer;

import android.view.View;
import androidx.appcompat.widget.AppCompatCheckBox;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ ImageViewerFragment<Object> a;

    public b(ImageViewerFragment<Object> r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        AppCompatCheckBox r2 = this.a.i;
        if (r2 == null) goto L6;
        r2.performClick();
        return;
    }
}
