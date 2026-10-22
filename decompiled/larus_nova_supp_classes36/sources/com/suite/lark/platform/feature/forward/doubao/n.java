package com.suite.lark.platform.feature.forward.doubao;

import android.app.Activity;
import androidx.fragment.app.FragmentManager;
import com.ss.android.lark.picker.base.widget.BasePicker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n implements BasePicker.IViewDependency {
    public final /* synthetic */ DoubaoForwardFragment a;

    public Activity getActivity() {
        return this.a.getActivity();
    }

    public final FragmentManager getFragmentManager() {
        return this.a.getChildFragmentManager();
    }

    public n(DoubaoForwardFragment r1) {
        this.a = r1;
    }
}
