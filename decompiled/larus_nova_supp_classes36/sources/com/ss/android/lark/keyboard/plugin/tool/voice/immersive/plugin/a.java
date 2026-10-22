package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.plugin;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.keyboard2.i;
import com.ss.android.lark.keyboard.keyboard2.m;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import com.ss.android.lark.keyboard.statistics.PostInputPluginHitPoint;
import com.ss.android.lark.keyboard.statistics.TextInputPluginHitPoint;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends m {
    public final EditText c;
    public final boolean d;
    public View e;
    public boolean f;
    public boolean g;

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final int a() {
        return 2131253681;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void s() {
        if (this.f == true) goto L5;
        return;
    L5:
        if (this.g == false) goto L25;
        com.ss.android.lark.keyboard.keyboard2.b r0 = n().L();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.keyboard.plugin.input.base.ISendKeyboardEditor");
        if (((mob.a) r0).getInputType() != InputSupportType.Post) goto L10;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
        new PostInputPluginHitPoint("mention").c();
    L15:
        int r2 = this.c.getSelectionStart();
        Editable r3 = this.c.getEditableText();
        if (r2 >= 0) goto L18;
    L21:
        r3.append("@");
        return;
    L18:
        if (r2 >= r3.length()) goto L21;
        r3.insert(r2, "@");
        return;
    L14:
        new TextInputPluginHitPoint("mention").c();
        goto L15
    L10:
        r1 = false;
        goto L12
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final Integer q() {
        return 2131914264;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final KeyboardMenuItemKey g() {
        return KeyboardMenuItemKey.At;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void w(boolean r1) {
        this.f = r1;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void x(i r3) {
        Intrinsics.checkNotNullParameter(r3, "iconHolder");
        r3.a.setActivated(this.d);
        this.e = r3.a;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void y(boolean r1) {
        this.g = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(KeyboardFunctionEditText r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "targetEditText");
        this.c = r2;
        this.d = r3;
    }
}
