package com.ss.android.lark.forwardv2.impl.view;

import android.app.Activity;
import androidx.fragment.app.FragmentManager;
import com.ss.android.lark.picker.base.widget.BasePicker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class x implements BasePicker.IViewDependency {
    public final /* synthetic */ d0 a;

    public Activity getActivity() {
        return this.a.a;
    }

    public final FragmentManager getFragmentManager() {
        return this.a.c.getFragmentManager();
    }

    public x(d0 r1) {
        this.a = r1;
    }
}
