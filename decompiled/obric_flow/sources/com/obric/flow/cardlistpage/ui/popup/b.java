package com.obric.flow.cardlistpage.ui.popup;

import android.animation.AnimatorSet;
import android.view.View;
import androidx.core.view.GravityCompat;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OPopoverLayout f11809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Lambda f11811c;
    public Lambda d;
    public AnimatorSet e;
    public AnimatorSet f;
    public AnimatorSet g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11812h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f11813i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f11814j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f11815k;

    public b(OPopoverLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "contentView");
        this.f11809a = r5;
        this.f11811c = PopupView$dismissListener$1.INSTANCE;
        this.d = PopupView$showListener$1.INSTANCE;
    }

    public final int a() {
        int r5 = this.f11812h;
        boolean r10 = false;
        if ((r5 & GravityCompat.START) != 8388611) goto L5;
        boolean r11 = true;
    L7:
        if ((r5 & GravityCompat.END) != 8388613) goto L9;
        r10 = true;
    L9:
        if (r11 == false) goto L11;
        r5 = (r5 & (-8388612)) | 3;
    L11:
        if (r10 == true) goto L13;
        return r5;
    L13:
        return (r5 & (-8388614)) | 5;
    L5:
        r11 = false;
        goto L7
    }
}
