package com.ss.android.lark.newemoji.emojioptions;

import android.view.View;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements View.OnLayoutChangeListener {
    public final /* synthetic */ OptionsSelectPopupMenu<Object> a;

    public d(OptionsSelectPopupMenu<Object> r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        Log.i("OptionsPopupMenu", String.valueOf(this.a.k));
        OptionsSelectPopupMenu<Object> r10 = this.a;
        if (r10.i == true) goto L5;
    L7:
        OptionsSelectPopupMenu<Object> r11 = this.a;
        r11.k = r11.w.getDefaultDisplay().getOrientation();
        return;
    L5:
        if (r10.k == r10.w.getDefaultDisplay().getOrientation()) goto L7;
        this.a.d(false);
        goto L7
    }
}
