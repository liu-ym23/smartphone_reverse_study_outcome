package com.ss.android.lark.forwardv3;

import android.app.Activity;
import androidx.fragment.app.FragmentManager;
import com.ss.android.lark.picker.base.widget.BasePicker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class q implements BasePicker.IViewDependency {
    public final /* synthetic */ ForwardNewFragment a;

    public Activity getActivity() {
        return this.a.getActivity();
    }

    public final FragmentManager getFragmentManager() {
        return this.a.getChildFragmentManager();
    }

    public q(ForwardNewFragment r1) {
        this.a = r1;
    }
}
