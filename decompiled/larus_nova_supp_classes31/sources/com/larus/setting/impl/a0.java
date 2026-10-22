package com.larus.setting.impl;

import com.larus.setting.impl.databinding.LarusBottomSheetDataPermissonBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a0 implements com.larus.common_ui.dialog.p0 {
    public final /* synthetic */ LarusBottomSheetDataPermissonBinding a;
    public final /* synthetic */ DataPermissionBottomSheet b;

    public final void confirm() {
        this.a.f.getToggleView().setChecked(false);
        DataPermissionBottomSheet r0 = this.b;
        int r2 = DataPermissionBottomSheet.m;
        r0.T90().toggleAllowTrainingEnabled(false);
        tx9.c0.b("off", "click_button");
    }

    public a0(LarusBottomSheetDataPermissonBinding r1, DataPermissionBottomSheet r2) {
        this.a = r1;
        this.b = r2;
    }
}
