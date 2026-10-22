package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraUnbindBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final View b;
    public final DoraTextView c;
    public final NovaTitleBarEx d;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraUnbindBinding(ConstraintLayout r1, View r2, DoraTextView r3, NovaTitleBarEx r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
