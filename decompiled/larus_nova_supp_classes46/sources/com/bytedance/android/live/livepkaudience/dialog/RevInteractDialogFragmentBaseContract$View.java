package com.bytedance.android.live.livepkaudience.dialog;

import android.view.ViewGroup;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.livepkaudience.dialog.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class RevInteractDialogFragmentBaseContract$View<T extends b0> extends BaseFragment implements com.bytedance.android.livesdk.common.d {
    public k0 d;
    public final String e;
    public T f;

    public abstract float S90();

    public abstract String T90();

    public ViewGroup U90() {
        return null;
    }

    public RevInteractDialogFragmentBaseContract$View() {
        this.e = getClass().getName();
    }
}
