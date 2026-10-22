package com.larus.sheet.biz.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemTextToggle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusPageSheetPermissionSettingsBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ItemTextToggle b;
    public final NovaTitleBarEx c;

    public final View getRoot() {
        return this.a;
    }

    public LarusPageSheetPermissionSettingsBinding(ConstraintLayout r1, ItemTextToggle r2, NovaTitleBarEx r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
