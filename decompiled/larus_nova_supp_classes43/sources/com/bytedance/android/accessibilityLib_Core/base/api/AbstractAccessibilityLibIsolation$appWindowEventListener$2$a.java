package com.bytedance.android.accessibilityLib_Core.base.api;

import android.content.Context;
import android.view.View;
import android.view.Window;
import com.bytedance.android.accessibilityLib_Core.helper.AppWindows;
import com.bytedance.android.accessibilityLib_Core.processor.TraverseFromType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AbstractAccessibilityLibIsolation$appWindowEventListener$2$a implements AppWindows.a {
    public final /* synthetic */ AbstractAccessibilityLibIsolation.appWindowEventListener.2 a;

    @Override // com.bytedance.android.accessibilityLib_Core.helper.AppWindows.a
    public final void a() {
    }

    public AbstractAccessibilityLibIsolation$appWindowEventListener$2$a(AbstractAccessibilityLibIsolation.appWindowEventListener.2 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.accessibilityLib_Core.helper.AppWindows.a
    public final void c(View r10, String r11) {
        if (("onPageOut " + r11 + ", rootView=" + r10) == null) goto L5;
        Context r12 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L5:
        AbstractAccessibilityLibIsolation.e(this.a.this$0, r10);
    }

    @Override // com.bytedance.android.accessibilityLib_Core.helper.AppWindows.a
    public final void b(Window r1, View r10, String r11) {
        if (this.a.this$0.f() == true) goto L6;
        return;
    L6:
        if ("onPageIn ".concat(r11) == null) goto L8;
        Context r12 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L8:
        AbstractAccessibilityLibIsolation.d(this.a.this$0, r10, TraverseFromType.ActivityCreated_PageIn);
    }
}
