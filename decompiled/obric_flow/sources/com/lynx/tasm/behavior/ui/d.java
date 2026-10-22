package com.lynx.tasm.behavior.ui;

import android.graphics.Rect;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f10445a;

    public d(f r5) {
        this.f10445a = r5;
    }

    @Override // java.util.Comparator
    public final int compare(Object r5, Object r10) {
        Rect r11 = ((e) r5).f10451c;
        Rect r12 = ((e) r10).f10451c;
        int r13 = this.f10445a.f10455a;
        if (r13 != 0) goto L5;
        int r14 = r11.top - r12.top;
    L6:
        int r15 = r11.left - r12.left;
        if (r14 != 0) goto L9;
        return r15;
    L9:
        return r14;
    L5:
        r14 = (r11.top / r13) - (r12.top / r13);
        goto L6
    }
}
