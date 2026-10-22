package t7a;

import android.view.MotionEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.event.LynxTouchEvent;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c extends a {
    public boolean g;
    public boolean h;
    public boolean i;
    public final HashMap<String, Object> j;

    @Override // t7a.a
    public final void m() {
        this.b = 0;
        this.g = false;
        this.h = false;
        this.i = false;
    }

    @Override // t7a.a
    public final void d() {
        super.d();
        p(null);
    }

    @Override // t7a.a
    public final void e() {
        super.e();
        p(null);
    }

    public final void p(LynxTouchEvent r2) {
        if (h() == true) goto L5;
        return;
    L5:
        if (this.i == false) goto L7;
        return;
    L7:
        if (this.g == false) goto L13;
        this.i = true;
        n("onEnd", o(0.0f, 0.0f));
        return;
    }

    public final HashMap<String, Object> o(float r4, float r5) {
        this.j.put("scrollX", Integer.valueOf(l(this.f.getMemberScrollX())));
        this.j.put("scrollY", Integer.valueOf(l(this.f.getMemberScrollY())));
        this.j.put("deltaX", Integer.valueOf(l(r4)));
        this.j.put("deltaY", Integer.valueOf(l(r5)));
        this.j.put("isAtStart", Boolean.valueOf(this.f.isAtBorder(true)));
        this.j.put("isAtEnd", Boolean.valueOf(this.f.isAtBorder(false)));
        return this.j;
    }

    public c(int r1, LynxContext r2, s7a.a r3, p7a.a r4) {
        super(r1, r2, r3, r4);
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = new HashMap();
    }

    @Override // t7a.a
    public final void k(MotionEvent r5, LynxTouchEvent r6, float r7, float r8, boolean r9, r7a.a r10) {
        p7a.a r11 = this.f;
        if (r11 == null) goto L6;
        r11.onInvalidate();
    L6:
        if (r5 == null) goto L14;
        if (r5.getActionMasked() != 0) goto L10;
    L11:
        this.b = 6;
        return;
    L10:
        if (r5.getActionMasked() == 2) goto L11;
    L14:
        if (r5 != null) goto L16;
    L24:
        int r12 = this.b;
        if (r12 < 3) goto L31;
        if (r12 > 5) goto L31;
        p(null);
        return;
    L31:
        if (r7 == Float.MIN_VALUE) goto L33;
    L36:
        if (r12 == 0) goto L44;
        if (r12 == 6) goto L44;
        if (j() == false) goto L61;
        n("onUpdate", o(r7, r8));
        return;
    L61:
        return;
    L44:
        b();
        a();
        if (g() == false) goto L51;
        if (this.g == true) goto L51;
        this.g = true;
        n("onBegin", o(0.0f, 0.0f));
    L51:
        if (i() == true) goto L53;
        return;
    L53:
        if (this.h == false) goto L55;
        return;
    L55:
        if (this.g == false) goto L64;
        this.h = true;
        n("onStart", o(0.0f, 0.0f));
        return;
    L64:
        return;
    L33:
        if (r8 != Float.MIN_VALUE) goto L36;
        e();
        p(null);
        return;
    L16:
        if (r5.getActionMasked() != 1) goto L24;
        b();
        if (g() == true) goto L20;
        return;
    L20:
        if (this.g == true) goto L60;
        this.g = true;
        n("onBegin", o(0.0f, 0.0f));
        return;
    }
}
