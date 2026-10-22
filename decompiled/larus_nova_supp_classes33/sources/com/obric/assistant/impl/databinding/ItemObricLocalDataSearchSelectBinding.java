package com.obric.assistant.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ItemObricLocalDataSearchSelectBinding implements ViewBinding {
    public final OCardListItem a;

    public final View getRoot() {
        return this.a;
    }

    public ItemObricLocalDataSearchSelectBinding(OCardListItem r1) {
        this.a = r1;
    }

    public static ItemObricLocalDataSearchSelectBinding a(LayoutInflater r2, ViewGroup r3) {
        OCardListItem r4 = r2.inflate(2131561639, r3, false);
        if (r4 == null) goto L7;
        return new ItemObricLocalDataSearchSelectBinding(r4);
    L7:
        throw new NullPointerException("rootView");
    }
}
