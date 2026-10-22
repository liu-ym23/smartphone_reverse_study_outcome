package com.obric.assistant.interaction.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.obric.oui.status.OPageStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricLoadingUiBinding implements ViewBinding {
    public final OPageStatus loadingStatus;
    private final FrameLayout rootView;

    public /* bridge */ /* synthetic */ View getRoot() {
        return m1getRoot();
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public FrameLayout m1getRoot() {
        return this.rootView;
    }

    public static ObricLoadingUiBinding bind(View r2) {
        OPageStatus r1 = ViewBindings.findChildViewById(r2, 2131379078);
        if (r1 == null) goto L7;
        return new ObricLoadingUiBinding((FrameLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(2131379078)));
    }

    public static ObricLoadingUiBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    private ObricLoadingUiBinding(FrameLayout r1, OPageStatus r2) {
        this.rootView = r1;
        this.loadingStatus = r2;
    }

    public static ObricLoadingUiBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(2131564034, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }
}
