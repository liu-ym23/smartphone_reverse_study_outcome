package com.larus.agents.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemTextToggle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class LarusFragmentWorkExperienceListBinding implements ViewBinding {
    public final LinearLayout a;
    public final TextView b;
    public final ItemTextToggle c;
    public final RecyclerView d;
    public final ProgressBar e;
    public final NovaTitleBarEx f;

    public final View getRoot() {
        return this.a;
    }

    public LarusFragmentWorkExperienceListBinding(LinearLayout r1, TextView r2, ItemTextToggle r3, RecyclerView r4, ProgressBar r5, NovaTitleBarEx r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
