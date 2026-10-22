package com.larus.agents.impl.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.AppCompatEditText;
import com.larus.agents.impl.databinding.LarusFragmentWorkExperienceEditorBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class o implements View.OnLayoutChangeListener {
    public final /* synthetic */ LarusFragmentWorkExperienceEditorBinding a;

    public o(LarusFragmentWorkExperienceEditorBinding r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        AppCompatEditText r10 = this.a.e;
        ViewParent r11 = r10.getParent();
        if ((r11 instanceof ViewGroup) == false) goto L5;
        ViewGroup r12 = (ViewGroup) r11;
    L6:
        if (r12 == null) goto L13;
        int r13 = (r1.getHeight() - r10.getTop()) - r12.getPaddingBottom();
        if (r13 <= r10.getMinimumHeight()) goto L12;
        r10.setMinimumHeight(r13);
        return;
    L12:
        return;
    L13:
        return;
    L5:
        r12 = null;
        goto L6
    }
}
