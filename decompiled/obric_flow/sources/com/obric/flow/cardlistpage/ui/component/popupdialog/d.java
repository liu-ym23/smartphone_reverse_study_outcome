package com.obric.flow.cardlistpage.ui.component.popupdialog;

import android.os.Bundle;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f11726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f11727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f11728c;

    public d(a r5, View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r5, "anchorDescriptor");
        this.f11726a = r5;
        this.f11727b = r10;
        this.f11728c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r10 = (d) r5;
        a r11 = r10.f11726a;
        if (Intrinsics.areEqual(this.f11726a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f11727b, r10.f11727b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f11728c, r10.f11728c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f11726a.hashCode() * 31;
        int r10 = 0;
        View r11 = this.f11727b;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r5 + r12) * 31;
        Bundle r14 = this.f11728c;
        if (r14 == null) goto L11;
        r10 = r14.hashCode();
    L11:
        return r13 + r10;
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public final String toString() {
        return "ExternalLongClickPopupDescriptor(anchorDescriptor=" + this.f11726a + ", contentView=" + this.f11727b + ", bundle=" + this.f11728c + ")";
    }
}
