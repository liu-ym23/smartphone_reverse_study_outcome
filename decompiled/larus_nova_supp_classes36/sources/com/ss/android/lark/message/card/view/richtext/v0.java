package com.ss.android.lark.message.card.view.richtext;

import android.content.Context;
import android.view.View;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.android.VirtualYogaLayout;
import com.facebook.yoga.android.YogaLayout;
import java.lang.reflect.Field;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class v0 {
    public final Context a;
    public YogaLayout b;
    public VirtualYogaLayout c;
    public HashMap<View, YogaNode> d;

    public v0(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    public final void a(View r5) {
        Intrinsics.checkNotNullParameter(r5, "child");
        boolean r0 = r5 instanceof YogaLayout;
        if (r0 == false) goto L12;
        if (this.c == null) goto L12;
        YogaLayout r1 = new YogaLayout(this.a);
        VirtualYogaLayout r2 = this.c;
        if (r2 == null) goto L9;
        YogaNode r3 = r2.getYogaNode();
    L10:
        r1.addView(r2, r3);
        this.c = null;
        this.b = r1;
    L18:
        VirtualYogaLayout r4 = this.b;
        if (r4 != null) goto L22;
        r4 = this.c;
    L22:
        if (r4 == null) goto L25;
        r4.addView(r5);
        return;
    L25:
        return;
    L9:
        r3 = null;
    L12:
        if (this.b != null) goto L18;
        if (this.c != null) goto L18;
        if (r0 == false) goto L17;
        this.b = new YogaLayout(this.a);
        goto L18
    L17:
        this.c = new VirtualYogaLayout(this.a);
        goto L18
    }

    public final YogaNode b(View r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        YogaLayout r0 = this.b;
        if (r0 == null) goto L6;
        return r0.getYogaNodeForView(r6);
    L6:
        if (this.d != null) goto L22;
        VirtualYogaLayout r1 = this.c;
        if (r1 == null) goto L22;
        String r2 = "mYogaNodes";
        Class<?> r3 = r1.getClass();
    L11:
        if (r3 == Object.class) goto L15;
        Field r4 = r3.getDeclaredField(r2);     // Catch: Exception -> L14
    L16:
        r4.setAccessible(true);
        Object r5 = r4.get(r1);     // Catch: Exception -> L19
    L21:
        this.d = (HashMap) r5;
    L19:
        e = move-exception;
        e.printStackTrace();
        r5 = null;
    L14:
        r3 = r3.getSuperclass();
        goto L11
    L15:
        r4 = null;
    L22:
        HashMap<View, YogaNode> r7 = this.d;
        if (r7 == null) goto L26;
        return r7.get(r6);
    L26:
        return null;
    }
}
