package com.google.android.material.timepicker;

import com.google.android.material.button.MaterialButtonToggleGroup;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements MaterialButtonToggleGroup.OnButtonCheckedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8614b;

    public /* synthetic */ c(Object r5, int r10) {
        this.f8613a = r10;
        this.f8614b = r5;
    }

    @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
    public final void onButtonChecked(MaterialButtonToggleGroup r5, int r10, boolean r11) {
        int r12 = this.f8613a;
        Object r13 = this.f8614b;
        switch(r12) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        TimePickerView.e((TimePickerView) r13, r5, r10, r11);
        return;
    L6:
        TimePickerTextInputPresenter.a((TimePickerTextInputPresenter) r13, r5, r10, r11);
    }
}
