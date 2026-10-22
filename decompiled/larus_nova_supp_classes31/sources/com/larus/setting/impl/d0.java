package com.larus.setting.impl;

import com.larus.setting.impl.databinding.LarusBottomSheetDataPermissonBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d0 implements com.larus.common_ui.dialog.p0 {
    public final /* synthetic */ LarusBottomSheetDataPermissonBinding a;

    public final void confirm() {
        this.a.f.getToggleView().setChecked(true);
        bt9.a.a(false, true);
    }

    public d0(LarusBottomSheetDataPermissonBinding r1) {
        this.a = r1;
    }
}
