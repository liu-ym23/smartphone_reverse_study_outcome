package com.google.android.material.internal;

import android.widget.Checkable;
import com.google.android.material.internal.g;

/* JADX INFO: loaded from: classes2.dex */
public interface g<T extends g<T>> extends Checkable {

    public interface a<C> {
        void a(C r1, boolean r2);
    }

    int getId();

    void setInternalOnCheckedChangeListener(a<T> r1);
}
