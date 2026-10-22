package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
abstract class PickerFragment<S> extends Fragment {
    protected final LinkedHashSet<h<S>> onSelectionChangedListeners;

    PickerFragment() {
        this.onSelectionChangedListeners = new LinkedHashSet();
    }

    boolean addOnSelectionChangedListener(h<S> r1) {
        return this.onSelectionChangedListeners.add(r1);
    }

    void clearOnSelectionChangedListeners() {
        this.onSelectionChangedListeners.clear();
    }

    abstract DateSelector<S> getDateSelector();

    boolean removeOnSelectionChangedListener(h<S> r1) {
        return this.onSelectionChangedListeners.remove(r1);
    }
}
