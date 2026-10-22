package com.larus.camera.impl.ui.component.result.edu;

import com.google.android.material.tabs.TabLayout;
import com.larus.camera.impl.entity.EduResultMode;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f implements TabLayout.OnTabSelectedListener {
    public final /* synthetic */ CameraResultViewModel a;
    public final /* synthetic */ EduResultTabView b;

    public final void onTabReselected(TabLayout.Tab r2) {
        Intrinsics.checkNotNullParameter(r2, "tab");
    }

    public final void onTabUnselected(TabLayout.Tab r2) {
        Intrinsics.checkNotNullParameter(r2, "tab");
    }

    public final void onTabSelected(TabLayout.Tab r8) {
        Intrinsics.checkNotNullParameter(r8, "tab");
        Object r9 = r8.getTag();
        if ((r9 instanceof EduResultMode) == false) goto L5;
        EduResultMode r10 = (EduResultMode) r9;
    L6:
        if (r10 != null) goto L8;
        return;
    L8:
        this.a.selectEduResultMode(r10);
        if (this.b.e == true) goto L16;
        CameraResultViewModel r1 = this.a;
        String r2 = EduResultTabView.b(r10);
        if (r10 != this.b.a.d) goto L13;
        boolean r11 = true;
    L14:
        CameraResultViewModel.clickCameraButtonForEduMode$default(r1, r2, null, Boolean.valueOf(r11), 2, null);
        return;
    L13:
        r11 = false;
        goto L14
    L16:
        return;
    L5:
        r10 = null;
        goto L6
    }

    public f(CameraResultViewModel r1, EduResultTabView r2) {
        this.a = r1;
        this.b = r2;
    }
}
