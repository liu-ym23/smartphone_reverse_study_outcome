package com.ss.android.lark.keyboard.keyboard2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.larksuite.framework.utils.UIUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j extends BasicKeyboard implements c {
    public static final a x = null;
    public final mob.a v;
    public View w;

    public static final class a implements c.a<j> {
        public a() {
        }
    }

    static {
        x = new a();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void d() {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void j() {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void setKeyboard(com.ss.android.lark.keyboard.b r2) {
        Intrinsics.checkNotNullParameter(r2, "_");
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.BasicKeyboard
    public final View T() {
        View r0 = this.w;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        return null;
    L6:
        return r0;
    }

    public j(Context r2, KeyboardImeWrapper r3, KeyboardMenu r4, mob.a r5, k r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "imeWrapper");
        Intrinsics.checkNotNullParameter(r4, "keyboardMenu");
        Intrinsics.checkNotNullParameter(r5, "keyboardEditor");
        Intrinsics.checkNotNullParameter(r6, "keyboardContext");
        super(r2, r3, r4, r6);
        this.v = r5;
        R(b.K1, r5);
        R(x, this);
        r5.setKeyboard(this);
        ViewGroup r7 = this.f.g;
        r7.removeAllViews();
        Intrinsics.checkNotNull(r7);
        View r8 = r5.b(r7);
        this.w = r8;
        View r9 = null;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        r8 = null;
    L5:
        r7.addView(r8);
        ViewGroup r10 = this.f.i;
        r10.removeAllViews();
        Intrinsics.checkNotNull(r10);
        r10.addView(r5.t(r10));
        View r11 = this.w;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
    L9:
        r5.onViewCreated(r9);
        int r12 = UIUtils.getColor(r2, 2131100549);
        int r13 = UIUtils.dp2px(r2, 12.0f);
        ViewGroup r14 = this.f.f;
        Intrinsics.checkNotNull(r14);
        r14.setPadding(r13, r14.getPaddingTop(), r13, r14.getPaddingBottom());
        r14.setBackgroundColor(r12);
        z().setAnimationEnable(false);
        return;
    L8:
        r9 = r11;
        goto L9
    }
}
