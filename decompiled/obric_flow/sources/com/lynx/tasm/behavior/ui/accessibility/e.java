package com.lynx.tasm.behavior.ui.accessibility;

import android.graphics.Rect;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxBaseUI f10416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LynxNodeProvider f10417b;

    public e(LynxNodeProvider r5, LynxBaseUI r10) {
        this.f10417b = r5;
        this.f10416a = r10;
    }

    @Override // java.util.Comparator
    public final int compare(Object r5, Object r10) {
        Rect r11 = ((f) r5).f10419b;
        Rect r12 = ((f) r10).f10419b;
        boolean r13 = this.f10416a.isAccessibilityDirectionVertical();
        LynxNodeProvider r14 = this.f10417b;
        if (r13 == false) goto L11;
        int r15 = r11.left - r12.left;
        int r16 = r14.e;
        if (r16 != 0) goto L7;
        int r17 = r11.top - r12.top;
    L8:
        if (r17 != 0) goto L10;
        return r15;
    L10:
        return r17;
    L7:
        r17 = (r11.top / r16) - (r12.top / r16);
        goto L8
    L11:
        int r18 = r14.d;
        if (r18 != 0) goto L14;
        int r19 = r11.left - r12.left;
    L15:
        int r20 = r11.top - r12.top;
        if (r19 != 0) goto L18;
        return r20;
    L18:
        return r19;
    L14:
        r19 = (r11.left / r18) - (r12.left / r18);
        goto L15
    }
}
