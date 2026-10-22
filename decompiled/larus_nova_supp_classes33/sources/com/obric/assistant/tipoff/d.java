package com.obric.assistant.tipoff;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.larus.common_ui.widget.MaxHeightScrollView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d implements View.OnLayoutChangeListener {
    public final /* synthetic */ BaseObricTipOffDialogFragment.a a;
    public final /* synthetic */ View b;
    public final /* synthetic */ BaseObricTipOffDialogFragment c;
    public final /* synthetic */ MaxHeightScrollView d;
    public final /* synthetic */ View e;
    public final /* synthetic */ int f;

    public d(BaseObricTipOffDialogFragment.a r1, View r2, BaseObricTipOffDialogFragment r3, MaxHeightScrollView r4, View r5, int r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        this.a.a = false;
        if (ViewCompat.isAttachedToWindow(this.b) == false) goto L6;
        BaseObricTipOffDialogFragment r10 = this.c;
        View r11 = this.b;
        MaxHeightScrollView r12 = this.d;
        View r13 = this.e;
        int r14 = this.f;
        BaseObricTipOffDialogFragment.a r15 = this.a;
        int r16 = BaseObricTipOffDialogFragment.d;
        r10.getClass();
        BaseObricTipOffDialogFragment.Z90(r11, r12, r13, r14, r15);
        return;
    }
}
