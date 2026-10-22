package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.dora.impl.dynamic.widget.HistoryDeviceNavigationBar;
import com.larus.dora.impl.dynamic.widget.NestedDynamicPageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraPageDynamicListBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final HistoryDeviceNavigationBar b;
    public final NestedDynamicPageView c;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraPageDynamicListBinding(ConstraintLayout r1, HistoryDeviceNavigationBar r2, NestedDynamicPageView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
