package com.ss.android.lark.keyboard.plugin.tool.aa;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.keyboard2.d;
import com.ss.android.lark.keyboard.keyboard2.h;
import com.ss.android.lark.keyboard.keyboard2.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class AaStyleKBPlugin extends nob.a implements lob.a, TextWatcher {
    public Context c;
    public View d;
    public int e;
    public boolean f;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final int a() {
        return 2131255990;
    }

    @Override // lob.a, android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final KeyboardMenuItemKey g() {
        return null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void y(boolean r1) {
    }

    public static void C() {
        AaStyleKBPlugin$clearAllSubPlugin$1 r0 = AaStyleKBPlugin$clearAllSubPlugin$1.INSTANCE;
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void u() {
        this.c = n().l().getContext();
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void v() {
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.o
    public final void A(boolean r4) {
        if (r4 == true) goto L9;
        d r5 = n().H();
        boolean r2 = r5 instanceof h;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.keyboard.keyboard2.IOverlayKeyboardMenu");
        ((h) r5).a(null);
        View r6 = this.d;
        if (r6 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r6 = null;
    L7:
        r6.setSelected(false);
        throw null;
    L9:
        d r7 = n().H();
        boolean r3 = r7 instanceof h;
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.ss.android.lark.keyboard.keyboard2.IOverlayKeyboardMenu");
        h r8 = (h) r7;
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void G(EditText r4) {
        Intrinsics.checkNotNullParameter(r4, "editText");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if ((r4 instanceof FunctionEditText) == false) goto L5;
        String r0 = ((com.ss.android.lark.keyboard.edittext2.compat.a) ((FunctionEditText) r4).q(com.ss.android.lark.keyboard.edittext2.compat.a.c)).b;
    L7:
        if (Intrinsics.areEqual(r0, "") == false) goto L10;
        return;
    L10:
        if (r4.hashCode() != this.e) goto L14;
        this.e = r4.hashCode();
        return;
    L14:
        throw null;
    L5:
        r0 = "";
        goto L7
    }

    @Override // lob.a, android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
        throw null;
    }

    @Override // lob.a
    public final void j(EditText r2) {
        Intrinsics.checkNotNullParameter(r2, "editText");
        G(r2);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void w(final boolean r4) {
        this.f = r4;
        View r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r0 = null;
    L5:
        r0.setEnabled(this.f);
        new AaStyleKBPlugin$onEnableChange$1(r4);
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void x(i r2) {
        Intrinsics.checkNotNullParameter(r2, "iconHolder");
        Intrinsics.checkNotNullParameter(r2, "iconHolder");
        this.d = r2.a;
    }

    @Override // lob.a
    public final boolean z(int r1, KeyEvent r2) {
        n().z().y();
        return false;
    }

    @Override // lob.a
    public final void r(Editable r1, int r2, int r3) {
        throw null;
    }

    @Override // lob.a, android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        throw null;
    }
}
