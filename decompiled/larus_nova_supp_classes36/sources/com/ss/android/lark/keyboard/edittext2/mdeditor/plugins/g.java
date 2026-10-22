package com.ss.android.lark.keyboard.edittext2.mdeditor.plugins;

import android.text.Editable;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.ss.android.lark.coremd.impl.parse.j;
import com.ss.android.lark.coremdbiz.facade.plugins.LarkLinkPlugin;
import com.ss.android.lark.keyboard.edittext2.span.k;
import kotlin.jvm.internal.Intrinsics;
import v7b.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g extends LarkLinkPlugin {

    public static final class a extends CharacterStyle implements com.ss.android.lark.keyboard.edittext2.widget.f, com.ss.android.lark.keyboard.edittext2.span.f {
        public final int a;

        public a(int r1) {
            this.a = r1;
        }

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r2) {
            if (r2 == null) goto L5;
            r2.setColor(this.a);
            return;
        }

        @Override // com.ss.android.lark.keyboard.edittext2.span.k
        public final k.a e(int r1, int r2, Editable r3) {
            return com.ss.android.lark.keyboard.edittext2.span.f.a.a(this, r1, r2, r3);
        }
    }

    public g() {
    }

    public final void c(j.a r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        r3.a(n.class, new h());
    }
}
