package z6a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.LineBackgroundSpan;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l implements LineBackgroundSpan {
    public int a;
    public int b;
    public boolean c;
    public HashMap<Integer, int[]> d;
    public final com.lynx.tasm.behavior.ui.utils.e e;

    public l(int r2, int r3, com.lynx.tasm.behavior.ui.utils.e r4) {
        this.c = true;
        this.a = r2;
        this.b = r3;
        this.e = r4;
    }

    @Override // android.text.style.LineBackgroundSpan
    public final void drawBackground(Canvas r1, Paint r2, int r3, int r4, int r5, int r6, int r7, CharSequence r8, int r9, int r10, int r11) {
        if (this.e == null) goto L19;
        HashMap<Integer, int[]> r12 = this.d;
        if (r12 != null) goto L7;
        return;
    L7:
        if (this.c == true) goto L10;
        return;
    L10:
        if (r12.containsKey(Integer.valueOf(r11)) == false) goto L21;
        int[] r13 = this.d.get(Integer.valueOf(r11));
        if (r13 != null) goto L14;
        return;
    L14:
        if (r13.length != 2) goto L23;
        T r14 = this.e.b;
        if (((BackgroundDrawable) r14) == null) goto L24;
        ((BackgroundDrawable) r14).setBounds(Math.min(r13[0], r13[1]), r5, Math.max(r13[0], r13[1]), r7);
        ((BackgroundDrawable) this.e.b).draw(r1);
        return;
    L24:
        return;
    L23:
        return;
    L21:
        return;
    }
}
