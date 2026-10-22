package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.util.Pair;
import androidx.fragment.app.d;
import com.bytedance.ai.model.widgets.h;
import com.google.android.material.internal.ViewUtils;
import java.text.SimpleDateFormat;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface DateSelector<S> extends Parcelable {
    static /* synthetic */ void a(EditText r5) {
        lambda$showKeyboardWithAutoHideBehavior$1(r5);
    }

    static /* synthetic */ void b(EditText[] r5, View r10, boolean r11) {
        lambda$showKeyboardWithAutoHideBehavior$0(r5, r10, r11);
    }

    private static /* synthetic */ void lambda$showKeyboardWithAutoHideBehavior$0(EditText[] r5, View r10, boolean r11) {
        int r12 = r5.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (r5[r13].hasFocus() == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return;
    L8:
        ViewUtils.hideKeyboard(r10, false);
    }

    private static /* synthetic */ void lambda$showKeyboardWithAutoHideBehavior$1(View r5) {
        ViewUtils.requestFocusAndShowKeyboard(r5, false);
    }

    static void showKeyboardWithAutoHideBehavior(@NonNull EditText... r5) {
        if (r5.length != 0) goto L5;
        return;
    L5:
        h r10 = new h(r5, 3);
        int r11 = r5.length;
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L8;
        r5[r12].setOnFocusChangeListener(r10);
        r12 = r12 + 1;
        goto L6
    L8:
        EditText r13 = r5[0];
        r13.postDelayed(new d(r13, 16), 100);
    }

    @StyleRes
    int getDefaultThemeResId(Context r5);

    @StringRes
    int getDefaultTitleResId();

    @Nullable
    String getError();

    @NonNull
    Collection<Long> getSelectedDays();

    @NonNull
    Collection<Pair<Long, Long>> getSelectedRanges();

    @Nullable
    S getSelection();

    @NonNull
    String getSelectionContentDescription(@NonNull Context r5);

    @NonNull
    String getSelectionDisplayString(Context r5);

    boolean isSelectionComplete();

    @NonNull
    View onCreateTextInputView(@NonNull LayoutInflater r5, @Nullable ViewGroup r10, @Nullable Bundle r11, @NonNull CalendarConstraints r12, @NonNull OnSelectionChangedListener<S> r13);

    void select(long r5);

    void setSelection(@NonNull S r5);

    void setTextInputFormat(@Nullable SimpleDateFormat r5);
}
