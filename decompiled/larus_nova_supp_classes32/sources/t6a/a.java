package t6a;

import android.graphics.Rect;
import android.view.animation.Animation;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class a {
    public final s6a.a a;

    public abstract Animation b(LynxUI r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, Rect r18, float r19);

    public final boolean c() {
        s6a.a r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.b <= 0) goto L7;
        return true;
    }

    public a() {
        this.a = new s6a.a();
    }

    public final Animation a(LynxUI r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, int r21, Rect r22, float r23) {
        if (c() == true) goto L6;
        return null;
    L6:
        Animation r1 = b(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23);
        if (r1 == null) goto L9;
        r1.setDuration(this.a.b);
        r1.setStartOffset(this.a.c);
        r1.setInterpolator(s6a.b.a(this.a));
    L9:
        return r1;
    }
}
