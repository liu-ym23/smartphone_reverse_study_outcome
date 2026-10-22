package com.ss.android.lark.keyboard.edittext2.mdeditor.plugins;

import android.text.Editable;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.ss.android.lark.coremd.impl.parse.j;
import com.ss.android.lark.keyboard.edittext2.span.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends com.ss.android.lark.coremdbiz.facade.plugins.g {

    public static final class a extends CharacterStyle implements com.ss.android.lark.keyboard.edittext2.span.f {
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

    public c() {
    }

    public final void c(j.a r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        r3.a(eab.b.class, new d());
    }
}
