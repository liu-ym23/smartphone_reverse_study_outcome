package com.ss.android.lark.image.entity;

import android.graphics.drawable.GradientDrawable;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends GradientDrawable {
    public int a;

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(getIntrinsicWidth()), Integer.valueOf(getIntrinsicHeight()), Integer.valueOf(this.a)});
    }

    public a() {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Objects.equals(Integer.valueOf(getIntrinsicWidth()), Integer.valueOf(r6.getIntrinsicWidth())) == true) goto L11;
    L15:
        return false;
    L11:
        if (Objects.equals(Integer.valueOf(getIntrinsicHeight()), Integer.valueOf(r6.getIntrinsicHeight())) == false) goto L15;
        if (Objects.equals(Integer.valueOf(this.a), Integer.valueOf(r6.a)) == false) goto L15;
        return true;
    }

    @Override // android.graphics.drawable.GradientDrawable
    public final void setColor(int r1) {
        super.setColor(r1);
        this.a = r1;
    }
}
