package com.bytedance.ies.xelement.viewpager;

import com.bytedance.ies.xelement.viewpager.viewpager.BaseLynxViewPager$$PropsSetter;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class LynxViewPager$$PropsSetter extends BaseLynxViewPager$$PropsSetter {
    public LynxViewPager$$PropsSetter() {
    }

    @Override // com.bytedance.ies.xelement.viewpager.viewpager.BaseLynxViewPager$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void a(LynxBaseUI r5, String r10, y0 r11) {
        LynxViewPager r12 = (LynxViewPager) r5;
        r10.getClass();
        if (r10.equals("viewpager-dynamic") == true) goto L6;
        super.a(r5, r10, r11);
        return;
    L6:
        r12.setViewPagerDynamic(r11.e(r10, false));
    }
}
