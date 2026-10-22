package com.bytedance.android.accessibilityLib_Core.processor;

import android.content.Context;
import android.view.View;
import com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig;
import com.bytedance.android.accessibilityLib_Core.engine.AccessibilityConfigEngine;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public ViewAccessibilityDelegateProcessor.a a;

    public static final class a {
    }

    static {
    }

    public c() {
    }

    public final void a(ViewAccessibilityDelegateProcessor.a r10) {
        View r0 = r10.a();
        IBaseConfig r11 = null;
        if (r0 == null) goto L5;
        Object r1 = r0.getTag(2130706435);
    L6:
        if (r1 == null) goto L8;
        return;
    L8:
        StringBuilder r12 = new StringBuilder("{");
        r12.append("layoutId=" + r10.b);
        String r13 = r12.toString() + ",";
        StringBuilder r14 = new StringBuilder();
        r14.append(r13);
        View r15 = r10.a();
        int r16 = r10.b;
        if (r15 != null) goto L11;
        ViewAccessibilityDelegateProcessor.a r17 = null;
    L20:
        if (r17 == null) goto L33;
        Iterator<IBaseConfig> r18 = AccessibilityConfigEngine.d.iterator();
    L23:
        if (r18.hasNext() == false) goto L27;
        IBaseConfig r19 = r18.next();
        if (AccessibilityConfigEngine.b(r19, r17) == false) goto L23;
        r11 = r19;
    L27:
        if (r11 == null) goto L29;
        boolean r20 = true;
    L30:
        if (r20 == false) goto L32;
        String r21 = "已标注";
    L34:
        r14.append(r21);
        String r22 = r14.toString() + "}";
        View r23 = r10.a();
        if (r23 == null) goto L38;
        r23.setTag(2130706435, r22);
    L38:
        if (("ViewTagBuildProcessor>>>> for view = " + r10.a() + ", tag = " + r22) == null) goto L44;
        Context r24 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
        return;
    L44:
        return;
    L32:
        r21 = "未标注";
        goto L34
    L29:
        r20 = false;
        goto L30
    L33:
        r21 = "";
        goto L34
    L11:
        if (this.a != null) goto L13;
        this.a = new ViewAccessibilityDelegateProcessor.a(new WeakReference(r15), r16);
    L13:
        ViewAccessibilityDelegateProcessor.a r25 = this.a;
        if (r25 == null) goto L16;
        r25.a = new WeakReference(r15);
    L16:
        r17 = this.a;
        if (r17 == null) goto L20;
        r17.b = r16;
        goto L20
    L5:
        r1 = null;
        goto L6
    }
}
