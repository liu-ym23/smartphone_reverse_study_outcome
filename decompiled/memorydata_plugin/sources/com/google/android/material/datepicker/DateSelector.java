package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Pair;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public interface DateSelector<S> extends Parcelable {
    int getDefaultThemeResId(Context r1);

    int getDefaultTitleResId();

    Collection<Long> getSelectedDays();

    Collection<Pair<Long, Long>> getSelectedRanges();

    S getSelection();

    String getSelectionDisplayString(Context r1);

    boolean isSelectionComplete();

    View onCreateTextInputView(LayoutInflater r1, ViewGroup r2, Bundle r3, CalendarConstraints r4, h<S> r5);

    void select(long r1);

    void setSelection(S r1);
}
