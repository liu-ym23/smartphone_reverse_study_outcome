package com.ss.android.lark.keyboard.editor.input;

import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class SendPluginController {
    public final ViewGroup a;
    public final com.ss.android.lark.keyboard.b b;
    public final Map<mob.a, View> c;
    public final Map<Integer, uxa.a> d;
    public final Map<Integer, View> e;
    public int f;
    public com.ss.android.lark.keyboard.base.f g;
    public final Set<com.ss.android.lark.keyboard.base.j> h;
    public final Set<com.ss.android.lark.keyboard.base.h> i;

    public static final class a {
    }

    static {
    }

    public SendPluginController(ViewGroup r2, com.ss.android.lark.keyboard.b r3) {
        Intrinsics.checkNotNullParameter(r2, "btnRegionParent");
        Intrinsics.checkNotNullParameter(r3, "keyboard");
        this.a = r2;
        this.b = r3;
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new HashMap();
        this.h = new LinkedHashSet();
        this.i = new LinkedHashSet();
        r3.e().of(this).d(com.ss.android.lark.keyboard.event.n.class, new SendPluginController$1$1(this));
    }

    public final void a(int r1, mob.a r2) {
        if (r1 != 0) goto L4;
        Object r3 = ((HashMap) this.c).get(r2);
    L5:
        View r4 = (View) r3;
        if (r4 != null) goto L8;
        return;
    L8:
        this.a.removeAllViews();
        this.a.addView(r4);
        return;
    L4:
        Map<Integer, View> r5 = this.e;
        HashMap r6 = (HashMap) r5;
        r3 = r6.get(Integer.valueOf(r1));
        goto L5
    }
}
