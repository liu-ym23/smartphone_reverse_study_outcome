package com.ss.android.lark.keyboard.editor.input;

import android.content.Context;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import com.ss.android.lark.keyboard.widget.DragShrinkLayout;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class t implements DragShrinkLayout.a {
    public final /* synthetic */ RichTextInputExpandPlugin a;

    @Override // com.ss.android.lark.keyboard.widget.DragShrinkLayout.a
    public final void e() {
    }

    @Override // com.ss.android.lark.keyboard.widget.DragShrinkLayout.a
    public final void f() {
    }

    @Override // com.ss.android.lark.keyboard.widget.DragShrinkLayout.a
    public final void a() {
        com.ss.android.lark.keyboard.ime.a r0 = this.a.V().z();
        if (r0.B() == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        com.ss.android.lark.c.c(this.a.Q().n());
        return;
    L12:
        return;
    L5:
        if (r0.y() == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.ss.android.lark.keyboard.widget.DragShrinkLayout.a
    public final void c() {
        int r0 = xob.a.a;
        Context r1 = this.a.X().getContext();
        Intrinsics.checkNotNullParameter(r1, "context");
        boolean r3 = false;
        xob.a.b(new Pair[]{new Pair("click", "full_screen_slide"), new Pair("target", "none"), new Pair("slide_direction", "down"), new Pair("keyboard_status", xob.a.a(r1))});
        com.ss.android.lark.keyboard.ime.a r2 = this.a.V().z();
        if (r2.B() == false) goto L5;
    L6:
        r3 = true;
    L7:
        if (r3 == false) goto L10;
        com.ss.android.lark.c.c(this.a.Q().n());
        return;
    L10:
        return;
    L5:
        if (r2.y() == false) goto L7;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.widget.DragShrinkLayout.a
    public final void d() {
        this.a.Q().c(InputSupportType.Text, false);
    }

    public t(RichTextInputExpandPlugin r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.keyboard.widget.DragShrinkLayout.a
    public final void b(float r1, float r2) {
        float r3 = ((r1 - r2) / r1) * 0.7f;
        RichTextInputExpandPlugin.z0(this.a, r3);
    }
}
