package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import com.google.android.material.internal.MaterialCheckable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@UiThread
public class CheckableGroup<T extends MaterialCheckable<T>> {
    private final Map<Integer, T> checkables;
    private final Set<Integer> checkedIds;
    private OnCheckedStateChangeListener onCheckedStateChangeListener;
    private boolean selectionRequired;
    private boolean singleSelection;

    public interface OnCheckedStateChangeListener {
        void onCheckedStateChanged(@NonNull Set<Integer> r5);
    }

    public CheckableGroup() {
        this.checkables = new HashMap();
        this.checkedIds = new HashSet();
    }

    public static /* synthetic */ boolean access$000(CheckableGroup r5, MaterialCheckable r10) {
        return r5.checkInternal(r10);
    }

    public static /* synthetic */ boolean access$100(CheckableGroup r5) {
        return r5.selectionRequired;
    }

    public static /* synthetic */ boolean access$200(CheckableGroup r5, MaterialCheckable r10, boolean r11) {
        return r5.uncheckInternal(r10, r11);
    }

    public static /* synthetic */ void access$300(CheckableGroup r5) {
        r5.onCheckedStateChanged();
    }

    private boolean checkInternal(@NonNull MaterialCheckable<T> r5) {
        int r10 = r5.getId();
        if (this.checkedIds.contains(Integer.valueOf(r10)) == false) goto L5;
        return false;
    L5:
        T r11 = this.checkables.get(Integer.valueOf(getSingleCheckedId()));
        if (r11 == null) goto L8;
        uncheckInternal(r11, false);
    L8:
        boolean r12 = this.checkedIds.add(Integer.valueOf(r10));
        if (r5.isChecked() == true) goto L11;
        r5.setChecked(true);
    L11:
        return r12;
    }

    private void onCheckedStateChanged() {
        OnCheckedStateChangeListener r5 = this.onCheckedStateChangeListener;
        if (r5 == null) goto L6;
        r5.onCheckedStateChanged(getCheckedIds());
        return;
    }

    private boolean uncheckInternal(@NonNull MaterialCheckable<T> r5, boolean r10) {
        int r11 = r5.getId();
        if (this.checkedIds.contains(Integer.valueOf(r11)) == true) goto L5;
        return false;
    L5:
        if (r10 == true) goto L7;
    L12:
        boolean r12 = this.checkedIds.remove(Integer.valueOf(r11));
        if (r5.isChecked() == false) goto L15;
        r5.setChecked(false);
    L15:
        return r12;
    L7:
        if (this.checkedIds.size() != 1) goto L12;
        if (this.checkedIds.contains(Integer.valueOf(r11)) == false) goto L12;
        r5.setChecked(true);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addCheckable(T r5) {
        this.checkables.put(Integer.valueOf(r5.getId()), r5);
        if (r5.isChecked() == false) goto L5;
        checkInternal(r5);
    L5:
        r5.setInternalOnCheckedChangeListener(new AnonymousClass1(this));
    }

    public void check(@IdRes int r5) {
        T r10 = this.checkables.get(Integer.valueOf(r5));
        if (r10 != null) goto L6;
        return;
    L6:
        if (checkInternal(r10) == false) goto L9;
        onCheckedStateChanged();
        return;
    }

    public void clearCheck() {
        boolean r5 = this.checkedIds.isEmpty();
        Iterator<T> r10 = this.checkables.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        uncheckInternal(r10.next(), false);
        goto L4
    L6:
        if (r5 == true) goto L10;
        onCheckedStateChanged();
        return;
    }

    @NonNull
    public Set<Integer> getCheckedIds() {
        return new HashSet(this.checkedIds);
    }

    @NonNull
    public List<Integer> getCheckedIdsSortedByChildOrder(@NonNull ViewGroup r5) {
        Set<Integer> r10 = getCheckedIds();
        ArrayList r11 = new ArrayList();
        int r12 = 0;
    L4:
        if (r12 >= r5.getChildCount()) goto L11;
        View r13 = r5.getChildAt(r12);
        if ((r13 instanceof MaterialCheckable) == false) goto L10;
        if (r10.contains(Integer.valueOf(r13.getId())) == false) goto L10;
        r11.add(Integer.valueOf(r13.getId()));
    L10:
        r12 = r12 + 1;
        goto L4
    L11:
        return r11;
    }

    @IdRes
    public int getSingleCheckedId() {
        if (this.singleSelection == true) goto L5;
    L7:
        return -1;
    L5:
        if (this.checkedIds.isEmpty() == true) goto L7;
        return this.checkedIds.iterator().next().intValue();
    }

    public boolean isSelectionRequired() {
        return this.selectionRequired;
    }

    public boolean isSingleSelection() {
        return this.singleSelection;
    }

    public void removeCheckable(T r5) {
        r5.setInternalOnCheckedChangeListener(null);
        this.checkables.remove(Integer.valueOf(r5.getId()));
        this.checkedIds.remove(Integer.valueOf(r5.getId()));
    }

    public void setOnCheckedStateChangeListener(@Nullable OnCheckedStateChangeListener r5) {
        this.onCheckedStateChangeListener = r5;
    }

    public void setSelectionRequired(boolean r5) {
        this.selectionRequired = r5;
    }

    public void setSingleSelection(boolean r5) {
        if (this.singleSelection == r5) goto L6;
        this.singleSelection = r5;
        clearCheck();
        return;
    }

    public void uncheck(@IdRes int r5) {
        T r10 = this.checkables.get(Integer.valueOf(r5));
        if (r10 != null) goto L6;
        return;
    L6:
        if (uncheckInternal(r10, this.selectionRequired) == false) goto L9;
        onCheckedStateChanged();
        return;
    }
}
