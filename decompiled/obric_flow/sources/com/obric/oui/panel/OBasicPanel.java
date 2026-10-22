package com.obric.oui.panel;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/panel/OBasicPanel;", "Lcom/obric/oui/panel/OBasicPanelFragment;", "<init>", "()V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OBasicPanel extends OBasicPanelFragment {
    public OBasicPanel() {
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r5, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        return null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        Dialog r5 = getDialog();
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.isShowing() != true) goto L12;
        Dialog r10 = getDialog();
        if (r10 == null) goto L14;
        r10.cancel();
        return;
    L14:
        return;
    }
}
