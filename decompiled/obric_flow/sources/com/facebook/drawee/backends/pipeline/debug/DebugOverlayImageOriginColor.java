package com.facebook.drawee.backends.pipeline.debug;

import android.util.SparseIntArray;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DebugOverlayImageOriginColor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseIntArray f7744a = null;

    static {
        SparseIntArray r5 = new SparseIntArray(7);
        f7744a = r5;
        r5.append(1, -7829368);
        r5.append(2, SupportMenu.CATEGORY_MASK);
        r5.append(3, InputDeviceCompat.SOURCE_ANY);
        r5.append(4, InputDeviceCompat.SOURCE_ANY);
        r5.append(5, -16711936);
        r5.append(6, -16711936);
        r5.append(7, -16711936);
    }
}
