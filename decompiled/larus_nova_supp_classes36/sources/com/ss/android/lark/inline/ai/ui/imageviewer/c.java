package com.ss.android.lark.inline.ai.ui.imageviewer;

import android.view.View;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ ImageViewerFragment<Object> a;

    public c(ImageViewerFragment<Object> r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        ImageViewerFragment<Object> r5 = this.a;
        int r0 = r5.o;
        if (r0 >= 0) goto L5;
    L29:
        Log.e("ImageViewerFragment", "mSelected click but mCurrentIndex is invalid! mCurrentIndex = " + this.a.o + ", urls.size = " + this.a.m.size());
        return;
    L5:
        if (r0 >= r5.m.size()) goto L29;
        ImageViewerFragment<Object> r6 = this.a;
        Object r7 = ListProtector.get(r6.m, r6.o);
        if (this.a.n.indexOf(r7) < 0) goto L18;
        this.a.n.remove(r7);
        AppCompatCheckBox r1 = this.a.i;
        if (r1 == null) goto L12;
        r1.setChecked(false);
    L12:
        AppCompatCheckBox r2 = this.a.i;
        if (r2 == null) goto L15;
        r2.setText(null);
    L15:
        ylb.a<Object> r3 = this.a.p;
        if (r3 == null) goto L27;
        r3.a(r7, false);
    L27:
        this.a.T90();
        return;
    L18:
        this.a.n.add(r7);
        AppCompatCheckBox r8 = this.a.i;
        if (r8 == null) goto L21;
        r8.setChecked(true);
    L21:
        ImageViewerFragment<Object> r9 = this.a;
        AppCompatCheckBox r10 = r9.i;
        if (r10 == null) goto L24;
        r10.setText(String.valueOf(r9.n.size()));
    L24:
        ylb.a<Object> r11 = this.a.p;
        if (r11 == null) goto L27;
        r11.a(r7, true);
        goto L27
    }
}
