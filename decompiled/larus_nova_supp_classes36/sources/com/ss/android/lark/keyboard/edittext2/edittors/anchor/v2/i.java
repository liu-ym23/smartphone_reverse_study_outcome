package com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i extends CharacterStyle implements com.ss.android.lark.keyboard.edittext2.widget.f {
    public final Context a;
    public final boolean b;
    public final String c;
    public final int d;

    public final Context getContext() {
        return this.a;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        if (r2 == null) goto L5;
        r2.setColor(this.d);
        return;
    }

    public i(Context r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "content");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        if (r2 == null) goto L5;
        int r5 = UIUtils.getColor(r2, 2131106616);
    L6:
        this.d = r5;
        return;
    L5:
        r5 = UIHelper.getColor(2131106616);
        goto L6
    }
}
