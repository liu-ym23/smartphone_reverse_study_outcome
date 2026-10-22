package com.google.android.material.chip;

import android.view.View;
import android.widget.CompoundButton;
import com.obric.oui.lisitem.OListItemCircleImgSwitch;
import com.obric.oui.lisitem.OListItemSwitch;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f8520b;

    public /* synthetic */ a(int r5, View r10) {
        this.f8519a = r5;
        this.f8520b = r10;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r5, boolean r10) {
        View r11 = this.f8520b;
        switch(this.f8519a) {
            case 0: goto L14;
            case 1: goto L9;
            default: goto L4;
        };
    L4:
        int r12 = OListItemSwitch.E;
        OListItemSwitch r13 = (OListItemSwitch) r11;
        Intrinsics.checkNotNullParameter(r13, "this$0");
        CompoundButton.OnCheckedChangeListener r14 = r13.D;
        if (r14 == null) goto L16;
        r14.onCheckedChanged(r5, r10);
        return;
    L16:
        return;
    L9:
        int r15 = OListItemCircleImgSwitch.D;
        OListItemCircleImgSwitch r16 = (OListItemCircleImgSwitch) r11;
        Intrinsics.checkNotNullParameter(r16, "this$0");
        CompoundButton.OnCheckedChangeListener r17 = r16.C;
        if (r17 == null) goto L17;
        r17.onCheckedChanged(r5, r10);
        return;
    L17:
        return;
    L14:
        Chip.a((Chip) r11, r5, r10);
    }
}
