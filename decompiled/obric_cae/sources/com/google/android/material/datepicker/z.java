package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class z<S> extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<y<S>> f4748a;

    public z() {
        this.f4748a = new LinkedHashSet();
    }

    public boolean a(r.c r8) {
        return this.f4748a.add(r8);
    }
}
