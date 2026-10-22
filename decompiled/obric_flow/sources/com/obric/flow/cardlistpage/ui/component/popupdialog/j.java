package com.obric.flow.cardlistpage.ui.component.popupdialog;

import android.os.Bundle;
import android.view.View;
import com.obric.flow.cardlistpage.mvi.MviLogLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f11735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f11736b;

    public j(View r5, Bundle r10) {
        this.f11735a = r5;
        this.f11736b = r10;
    }

    @Override // com.obric.flow.cardlistpage.mvi.f
    public final String a() {
        return toString();
    }

    @Override // com.obric.flow.cardlistpage.mvi.f
    public final MviLogLevel b() {
        return MviLogLevel.INFO;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r10 = (j) r5;
        View r11 = r10.f11735a;
        if (Intrinsics.areEqual(this.f11735a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f11736b, r10.f11736b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = 0;
        View r10 = this.f11735a;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        Bundle r13 = this.f11736b;
        if (r13 == null) goto L11;
        r5 = r13.hashCode();
    L11:
        return r12 + r5;
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    public final String toString() {
        return "OnExternalLongClickMenuClick(contentView=" + this.f11735a + ", bundle=" + this.f11736b + ")";
    }
}
