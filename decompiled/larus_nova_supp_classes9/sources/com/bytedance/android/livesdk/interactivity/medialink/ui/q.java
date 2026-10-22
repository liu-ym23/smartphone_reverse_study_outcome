package com.bytedance.android.livesdk.interactivity.medialink.ui;

import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.UILayout;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.WindowLayoutType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q {
    public final Map<c, View> a;
    public boolean b;
    public boolean c;
    public int d;
    public boolean e;
    public UILayout f;
    public WindowLayoutType g;

    public final void b() {
        Iterator r0 = ((LinkedHashMap) this.a).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        a((c) ((Map.Entry) r0.next()).getKey());
        goto L4
    }

    public q() {
        this.a = new LinkedHashMap();
        this.f = UILayout.Normal;
        this.g = WindowLayoutType.Normal;
    }

    public final void a(c r6) {
        Intrinsics.checkNotNullParameter(r6, "iComponent");
        View r0 = (View) ((LinkedHashMap) this.a).get(r6);
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r2 = true;
        if (this.b == false) goto L8;
        boolean r1 = r6.c();
    L10:
        if (r1 == true) goto L12;
    L35:
        boolean r3 = false;
    L37:
        if (r0.getVisibility() == 0) goto L40;
        r2 = false;
    L40:
        if (r2 == r3) goto L43;
        UtilityKotlinExtentionsKt.z(r0, r3);
        r6.h(r3);
        return;
    L43:
        return;
    L12:
        if (this.c == false) goto L14;
        boolean r4 = r6.d();
    L15:
        if (r4 == false) goto L35;
        if (this.b == true) goto L19;
        boolean r5 = r6.f();
    L20:
        if (r5 == false) goto L35;
        if (r6.i(this.d) == false) goto L35;
        if (this.e == true) goto L26;
        boolean r7 = r6.e();
    L27:
        if (r7 == false) goto L35;
        if (r6.a(this.f) == false) goto L35;
        if (r6.g(this.g) == false) goto L35;
        if (r6.b() == false) goto L35;
        r3 = true;
        goto L37
    L26:
        r7 = true;
        goto L27
    L19:
        r5 = true;
        goto L20
    L14:
        r4 = true;
        goto L15
    L8:
        r1 = true;
        goto L10
    }

    public final void c(p r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        View r0 = r3.c;
        Intrinsics.checkNotNullParameter(r3, "iComponent");
        this.a.put(r3, r0);
        r3.a = this;
        a(r3);
    }
}
