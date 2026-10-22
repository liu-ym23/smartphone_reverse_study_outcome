package com.lynx.tasm.behavior.ui.accessibility;

import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public final ArrayList<JavaOnlyMap> a;
    public final Set<String> b;

    public static String b(int r1) {
        if (r1 != 0) goto L4;
        return "insert";
    L4:
        if (r1 != 1) goto L6;
        return "remove";
    L6:
        if (r1 != 2) goto L8;
        return "detach";
    L8:
        if (r1 != 3) goto L10;
        return LynxTemplateRender.RENDER_PHASE_UPDATE;
    L10:
        if (r1 == 4) goto L13;
        return NameKeys.UnloadStrategy_No_Strategy;
    L13:
        return "style_update";
    }

    public a() {
        this.a = new ArrayList();
        this.b = new HashSet();
    }

    public final void a(int r4, LynxBaseUI r5, String r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (b(r4).isEmpty() == true) goto L14;
        JavaOnlyMap r0 = new JavaOnlyMap();
        r0.putInt("target", r5.getSign());
        r0.putString("action", b(r4));
        r0.putString("a11y-id", r5.getAccessibilityId());
        if (r4 == 4) goto L8;
    L11:
        this.a.add(r0);
        return;
    L8:
        if (((HashSet) this.b).contains(r6) == true) goto L10;
        return;
    L10:
        r0.putString("style", r6);
        goto L11
    }
}
