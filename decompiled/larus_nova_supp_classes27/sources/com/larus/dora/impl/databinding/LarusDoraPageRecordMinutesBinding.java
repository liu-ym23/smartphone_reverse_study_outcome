package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemTextToggle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraPageRecordMinutesBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final View b;
    public final ItemTextToggle c;
    public final NovaTitleBarEx d;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraPageRecordMinutesBinding(ConstraintLayout r1, View r2, ItemTextToggle r3, NovaTitleBarEx r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
