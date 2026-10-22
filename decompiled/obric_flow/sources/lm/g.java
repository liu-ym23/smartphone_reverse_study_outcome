package lm;

import android.graphics.Picture;
import android.graphics.Rect;
import com.bytedance.apm.util.h;
import com.lynx.base.log.LynxLog;
import com.lynx.component.svg.UISvg;
import com.lynx.tasm.ui.image.v;
import com.lynx.tasm.utils.j;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f19687c;
    public final /* synthetic */ Object d;

    public /* synthetic */ g(Object r5, String r10, int r11, boolean r12) {
        this.f19685a = r11;
        this.d = r5;
        this.f19686b = r10;
        this.f19687c = r12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f19685a) {
            case 0: goto L28;
            default: goto L4;
        };
    L4:
        v6.g r5 = (v6.g) this.d;
        if (r5.f22542p != null) goto L7;
        r5.f22542p = new HashMap();
    L7:
        long r10 = System.currentTimeMillis();
        HashMap r11 = r5.f22542p;
        h r12 = new h(Long.valueOf(r10), Long.valueOf(r5.s.h()));
        String r13 = this.f19686b;
        r11.put(r13, r12);
        if (r5.f22543q != null) goto L10;
        r5.f22543q = new HashMap();
    L10:
        HashMap r14 = r5.f22543q;
        Long r15 = Long.valueOf(r10);
        v6.e r16 = (v6.e) r5.s.f21695a;
        r16.b();
        r14.put(r13, new h(r15, Long.valueOf(r16.f22528b + r16.d)));
        if (r5.f22544r != null) goto L13;
        r5.f22544r = new HashMap();
    L13:
        HashMap r17 = r5.f22544r;
        Long r18 = Long.valueOf(r10);
        v6.e r19 = (v6.e) r5.s.f21695a;
        r19.b();
        r17.put(r13, new h(r18, Long.valueOf(r19.f22529c + r19.e)));
        if (this.f19687c == false) goto L30;
        v6.c r110 = v6.b.f22516a;
        if (r110.f22523k != null) goto L18;
        r110.f22523k = new HashMap();
    L18:
        r110.f22523k.put(r13, new HashMap());
        return;
    L30:
        return;
    L28:
    L25:
        e = move-exception;
        LynxLog.b(4, "lynx_UISvg", "setDrawable: the content: " + ((UISvg) this.d).f9725b + ", the error message: " + e.getMessage());
        return;
    L22:
        if (((UISvg) this.d).f9727h == null) goto L31;
        Picture r20 = ((UISvg) this.d).f9727h.renderPicture(this.f19686b, new Rect(0, 0, ((UISvg) this.d).getWidth(), ((UISvg) this.d).getHeight()));     // Catch: Exception -> L25
        LynxLog.b(2, "lynx_UISvg", "setServalSVGDrawable, width is " + ((UISvg) this.d).getWidth() + " height is " + ((UISvg) this.d).getHeight() + " ui-svg hashCode:" + ((UISvg) this.d));     // Catch: Exception -> L25
        j.a().post(new v(15, this, new b(r20)));     // Catch: Exception -> L25
        return;
    }
}
