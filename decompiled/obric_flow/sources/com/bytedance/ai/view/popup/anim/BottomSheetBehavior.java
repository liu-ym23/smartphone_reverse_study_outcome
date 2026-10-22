package com.bytedance.ai.view.popup.anim;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2885c;
    public boolean d;
    public boolean e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f2886h;

    public BottomSheetBehavior() {
        this.f2883a = true;
        this.e = true;
        this.g = 4;
        this.f2886h = new ArrayList();
    }

    public final void a(int r5) {
        if (r5 != (-1)) goto L9;
        if (this.f2885c == true) goto L13;
        this.f2885c = true;
        return;
    L13:
        return;
    L9:
        if (this.f2885c == false) goto L11;
    L14:
        this.f2885c = false;
        this.f2884b = Math.max(0, r5);
        return;
    L11:
        if (this.f2884b != r5) goto L14;
    }

    public final void b(boolean r5) {
        if (this.d == r5) goto L10;
        this.d = r5;
        if (r5 == false) goto L7;
        return;
    L7:
        if (this.g != 5) goto L12;
        c(4);
        return;
    L12:
        return;
    }

    public final void c(int r5) {
        if (r5 != this.g) goto L6;
        return;
    L6:
        if (r5 != 4) goto L8;
    L17:
        this.g = r5;
        return;
    L8:
        if (r5 == 3) goto L17;
        if (r5 == 6) goto L17;
        if (this.d == true) goto L14;
        return;
    L14:
        if (r5 == 5) goto L17;
    }
}
