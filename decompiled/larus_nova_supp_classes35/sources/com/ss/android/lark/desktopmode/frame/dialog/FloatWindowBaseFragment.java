package com.ss.android.lark.desktopmode.frame.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.desktopmode.app.DesktopCompatFragment;
import java.util.Stack;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class FloatWindowBaseFragment extends DesktopCompatFragment {
    public View d;

    public FloatWindowBaseFragment() {
        new Stack();
    }

    public final void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        getChildFragmentManager();
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.d = r2.inflate(2131561162, r3, false);
        getActivity();
        return this.d;
    }
}
