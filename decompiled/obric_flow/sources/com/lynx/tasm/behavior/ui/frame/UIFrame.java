package com.lynx.tasm.behavior.ui.frame;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.RestrictTo;
import cn.a;
import cn.b;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.g0;
import com.lynx.tasm.x;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class UIFrame extends LynxUI<a> {
    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        return new a(this.mContext);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeRemoved() {
        super.onNodeRemoved();
        a r5 = getView();
        if (r5 == null) goto L6;
        r5.f1220a.S();
        return;
    }

    @c0(name = "data")
    public void setData(ReadableMap r5) {
        if ((r5 instanceof JavaOnlyMap) == true) goto L6;
        LynxLog.b(4, "UIFrame", "prop date is not a JavaOnlyMap");
        return;
    L6:
        a r10 = getView();
        if (r10 != null) goto L9;
        return;
    L9:
        g0 r11 = new g0(TemplateData.c((JavaOnlyMap) r5));
        r10.f1220a.p(r11);
    }

    @c0(name = "src")
    public void setSrc(String r5) {
        a r10 = getView();
        if (r10 != null) goto L5;
        return;
    L5:
        r10.setUrl(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updateExtraData(Object r12) {
        if ((r12 instanceof TemplateBundle) == false) goto L12;
        a r5 = getView();
        if (r5 == null) goto L13;
        a r10 = getView();
        if (r10 == null) goto L10;
        r10.setAttachLynxPageUICallback(new b(this));
    L10:
        String r11 = r5.f1221b;
        x r13 = new x(r11, null, (TemplateBundle) r12, null, null, null, 0);
        r5.f1220a.V(r13);
        return;
    L13:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updateLayout(int r5, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r110, int r111, int r112, int r113, int r20, Rect r21) {
        super.updateLayout(r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r20, r21);
        a r22 = getView();
        if (r22 == null) goto L6;
        r22.f1220a.h(r11, r12, true);
        return;
    }
}
