package com.ss.android.lark.keyboard.editor.input;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a0 extends FrameLayout {
    public final View a;
    public final View b;
    public final View c;
    public final View d;

    public static final class a {
    }

    static {
    }

    public final View getReEditBtnCancel() {
        return this.c;
    }

    public final View getReEditBtnConfirm() {
        return this.d;
    }

    public final View getReEditBtnGroup() {
        return this.b;
    }

    public final View getSendBtn() {
        return this.a;
    }

    public a0(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        setId(2131364828);
        View r0 = com.ss.android.lark.keyboard.utils.h.b(r5);
        this.a = r0;
        View r6 = LayoutInflater.from(r5).inflate(2131561739, this, false);
        this.b = r6;
        this.c = r6.findViewById(2131364673);
        this.d = r6.findViewById(2131364689);
        addView(r0);
        addView(r6);
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r1;
        r2.gravity = 17;
        r0.setLayoutParams(r2);
        ViewGroup.LayoutParams r3 = r6.getLayoutParams();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r4 = (FrameLayout.LayoutParams) r3;
        r4.gravity = 17;
        r6.setLayoutParams(r4);
        a(1);
    }

    public final void a(int r6) {
        if (r6 <= 2) goto L5;
    L21:
        Log.w("RichTextSendBtnCompat", "changeMode: invalid mode");
        return;
    L5:
        if (r6 < 1) goto L21;
        int r1 = 0;
        if (r6 != 1) goto L10;
        boolean r7 = true;
    L11:
        View r2 = this.a;
        if (r7 == false) goto L14;
        int r4 = 0;
    L15:
        r2.setVisibility(r4);
        View r3 = this.b;
        if ((!r7) == true) goto L19;
        r1 = 8;
    L19:
        r3.setVisibility(r1);
        return;
    L14:
        r4 = 8;
        goto L15
    L10:
        r7 = false;
        goto L11
    }
}
