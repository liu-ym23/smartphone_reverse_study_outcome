package com.obric.miniapp.view;

import android.app.Dialog;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class b0 implements Function0 {
    public final /* synthetic */ MiniAppFragment a;

    public /* synthetic */ b0(MiniAppFragment r1) {
        this.a = r1;
    }

    public final Object invoke() {
        MiniAppFragment r0 = this.a;
        int r1 = MiniAppFragment.R;
        DialogFragment r2 = r0.getParentFragment();
        if ((r2 instanceof DialogFragment) == false) goto L5;
        DialogFragment r3 = r2;
    L6:
        if (r3 == null) goto L13;
        Dialog r4 = r3.getDialog();
        if (r4 == null) goto L13;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L13;
        return r5;
    L13:
        FragmentActivity r6 = r0.getActivity();
        if (r6 != null) goto L16;
        return null;
    L16:
        return r6.getWindow();
    L5:
        r3 = null;
        goto L6
    }
}
