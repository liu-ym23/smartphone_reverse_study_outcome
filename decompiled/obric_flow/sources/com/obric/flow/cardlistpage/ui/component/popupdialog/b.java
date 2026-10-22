package com.obric.flow.cardlistpage.ui.component.popupdialog;

import ai.j0;
import cn.nubia.neopush.commons.Constant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11720c;

    public b(String r5, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "cardId");
        Intrinsics.checkNotNullParameter(r11, Constant.TITLE);
        this.f11718a = r5;
        this.f11719b = r10;
        this.f11720c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r10 = (b) r5;
        String r11 = r10.f11718a;
        if (Intrinsics.areEqual(this.f11718a, r11) == true) goto L12;
        return false;
    L12:
        if (this.f11719b == r10.f11719b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f11720c, r10.f11720c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f11718a.hashCode() * 31;
        int r10 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f11719b, r5, 31);
        return this.f11720c.hashCode() + r10;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("CardDescriptor(cardId=");
        r5.append(this.f11718a);
        r5.append(", widgetId=");
        r5.append(this.f11719b);
        r5.append(", title=");
        return j0.q(r5, this.f11720c, ")");
    }
}
