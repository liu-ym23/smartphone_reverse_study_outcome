package com.google.android.material.badge;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.internal.ParcelableSparseArray;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f3781a = false;

    static {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        boolean r0 = true;
    L6:
        f3781a = r0;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static SparseArray<a> a(Context r6, ParcelableSparseArray r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        SparseArray<a> r0 = new SparseArray(r7.size());
        int r2 = 0;
    L4:
        if (r2 >= r7.size()) goto L10;
        int r3 = r7.keyAt(r2);
        BadgeState.State r4 = (BadgeState.State) ZeusTransformUtils.preCheckCast(r7.valueAt(r2), BadgeState.State.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L9;
        r0.put(r3, a.a(r8, r4));
        r2 = r2 + 1;
        goto L4
    L9:
        throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
    L10:
        return r0;
    }

    public static ParcelableSparseArray a(SparseArray<a> r6) {
        ParcelableSparseArray r0 = new ParcelableSparseArray();
        int r1 = 0;
    L4:
        if (r1 >= r6.size()) goto L10;
        int r2 = r6.keyAt(r1);
        a r3 = (a) ZeusTransformUtils.preCheckCast(r6.valueAt(r1), a.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        r0.put(r2, r3.a());
        r1 = r1 + 1;
        goto L4
    L9:
        throw new IllegalArgumentException("badgeDrawable cannot be null");
    L10:
        return r0;
    }

    public static void a(Rect r2, float r3, float r4, float r5, float r6) {
        r2.set((int) (r3 - r5), (int) (r4 - r6), (int) (r3 + r5), (int) (r4 + r6));
    }

    public static void a(a r1, View r2) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (f3781a == false) goto L7;
    L10:
        r1.b().setForeground(null);
        return;
    L7:
        if (r1.b() != null) goto L10;
        r2.getOverlay().remove(r1);
    }

    public static void a(a r0, View r1, FrameLayout r2) {
        b(r0, r1, r2);
        if (r0.b() == null) goto L6;
        r0.b().setForeground(r0);
        return;
    L6:
        if (f3781a == true) goto L10;
        r1.getOverlay().add(r0);
        return;
    L10:
        throw new IllegalArgumentException("Trying to reference null customBadgeParent");
    }

    public static void b(a r1, View r2, FrameLayout r3) {
        Rect r0 = new Rect();
        r2.getDrawingRect(r0);
        r1.setBounds(r0);
        r1.a(r2, r3);
    }
}
