package com.google.android.material.badge;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.internal.ParcelableSparseArray;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f3015a = false;

    static {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        boolean r10 = true;
    L6:
        f3015a = r10;
        return;
    L5:
        r10 = false;
        goto L6
    }

    public static void a(@NonNull a r10, @NonNull View r11, @Nullable FrameLayout r12) {
        e(r10, r11, r12);
        if (r10.g() == null) goto L6;
        r10.g().setForeground(r10);
        return;
    L6:
        if (f3015a == true) goto L10;
        r11.getOverlay().add(r10);
        return;
    L10:
        throw new IllegalArgumentException("Trying to reference null customBadgeParent");
    }

    @NonNull
    public static SparseArray<a> b(Context r10, @NonNull ParcelableSparseArray r11) {
        SparseArray<a> r12 = new SparseArray(r11.size());
        int r13 = 0;
    L4:
        if (r13 >= r11.size()) goto L10;
        int r14 = r11.keyAt(r13);
        BadgeState.State r15 = (BadgeState.State) r11.valueAt(r13);
        if (r15 == null) goto L9;
        r12.put(r14, a.c(r10, r15));
        r13 = r13 + 1;
        goto L4
    L9:
        throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
    L10:
        return r12;
    }

    @NonNull
    public static ParcelableSparseArray c(@NonNull SparseArray<a> r10) {
        ParcelableSparseArray r11 = new ParcelableSparseArray();
        int r12 = 0;
    L4:
        if (r12 >= r10.size()) goto L10;
        int r13 = r10.keyAt(r12);
        a r14 = r10.valueAt(r12);
        if (r14 == null) goto L9;
        r11.put(r13, r14.k());
        r12 = r12 + 1;
        goto L4
    L9:
        throw new IllegalArgumentException("badgeDrawable cannot be null");
    L10:
        return r11;
    }

    public static void d(@Nullable a r10, @NonNull View r11) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (f3015a == false) goto L7;
    L10:
        r10.g().setForeground(null);
        return;
    L7:
        if (r10.g() != null) goto L10;
        r11.getOverlay().remove(r10);
    }

    public static void e(@NonNull a r10, @NonNull View r11, @Nullable FrameLayout r12) {
        Rect r13 = new Rect();
        r11.getDrawingRect(r13);
        r10.setBounds(r13);
        r10.A(r11, r12);
    }

    public static void f(@NonNull Rect r10, float r11, float r12, float r13, float r14) {
        r10.set((int) (r11 - r13), (int) (r12 - r14), (int) (r11 + r13), (int) (r12 + r14));
    }
}
