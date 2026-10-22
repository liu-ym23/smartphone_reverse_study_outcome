package com.ss.android.lark.compose.chatsetting.common.ui.widget;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.vector.ImageVector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final ImageVector a;
    public final Brush b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "SettingIcon(icon=" + this.a + ", backgroundBrush=" + this.b + ')';
    }

    public a(ImageVector r2, Brush r3) {
        Intrinsics.checkNotNullParameter(r2, "icon");
        Intrinsics.checkNotNullParameter(r3, "backgroundBrush");
        this.a = r2;
        this.b = r3;
    }
}
