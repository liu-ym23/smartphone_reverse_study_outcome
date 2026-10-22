package z6a;

import android.os.Build;
import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o extends CharacterStyle {
    public final com.lynx.tasm.behavior.ui.g a;

    public o(com.lynx.tasm.behavior.ui.g r1) {
        this.a = r1;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r5) {
        float r0 = this.a.d;
        if (Build.VERSION.SDK_INT > 23) goto L5;
        r0 = Math.min(Math.max(0.0f, r0), 25.0f);
    L5:
        com.lynx.tasm.behavior.ui.g r1 = this.a;
        r5.setShadowLayer(r0, r1.b, r1.c, r1.a);
    }
}
