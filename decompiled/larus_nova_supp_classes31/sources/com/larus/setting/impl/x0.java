package com.larus.setting.impl;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.keva.Keva;
import com.larus.setting.impl.databinding.LarusPageSettingFontAndThemeBinding;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class x0 implements com.larus.common_ui.dialog.p0 {
    public final /* synthetic */ FontAndThemeSettingFragment a;
    public final /* synthetic */ boolean b;

    public final void confirm() {
        Lazy r0 = we8.e.a;
        int r1 = this.a.h;
        ((Keva) we8.e.a.getValue()).storeInt("font_size_level", r1);
        if (this.b == false) goto L5;
        Lazy r2 = we8.j.a;
        we8.j.a(this.a.f);
    L5:
        String r3 = this.a.getCurrentPage();
        FontAndThemeSettingFragment r4 = this.a;
        int r5 = r4.f;
        if (r5 != (-1)) goto L8;
        String r6 = "with_system";
    L15:
        tx9.f1.b(r3, r6, we8.f.a(r4.h));
        final FontAndThemeSettingFragment r7 = this.a;
        LarusPageSettingFontAndThemeBinding r8 = r7.d;
        if (r8 == null) goto L21;
        ConstraintLayout r9 = r8.a;
        if (r9 == null) goto L22;
        r9.postDelayed(new w0(r7), 300);
        return;
    L22:
        return;
    L21:
        return;
    L8:
        if (r5 != 1) goto L10;
    L13:
        r6 = "light_mode";
        goto L15
    L10:
        if (r5 != 2) goto L13;
        r6 = "dark_mode";
        goto L15
    }

    public x0(FontAndThemeSettingFragment r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
