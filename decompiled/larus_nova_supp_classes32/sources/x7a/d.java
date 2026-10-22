package x7a;

import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d implements i.a {
    public final WeakReference<f> a;
    public final Stack<h> b;
    public HashMap<String, Object> c;
    public final i d;

    public class a implements w6a.h.c {
        public final /* synthetic */ LynxView a;
        public final /* synthetic */ d b;

        @Override // w6a.h.c
        public final void a() {
            f r0 = this.b.b();
            if (r0 == null) goto L5;
            r0.d(this.a);
        L5:
            this.a.destroy();
        }

        public a(d r1, LynxView r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public final f b() {
        WeakReference<f> r0 = this.a;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.get();
    }

    public final void c(LynxView r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        w6a.h r0 = w6a.h.a.a;
        a r1 = new a(this, r6);
        r0.getClass();
        AtomicInteger r2 = new AtomicInteger(0);
        Iterator<LynxUI> r3 = r0.b.keySet().iterator();
    L6:
        if (r3.hasNext() == false) goto L11;
        LynxUI r4 = r3.next();
        if (r4.getLynxContext().getUIBody().getBodyView() != r6) goto L6;
        r2.incrementAndGet();
        r4.execExitAnim(new w6a.g(r2, r1));
        goto L6
    L11:
        if (r2.get() != 0) goto L14;
        r1.a();
    L14:
        if (this.b.isEmpty() == true) goto L29;
        h r7 = this.b.peek();
        LynxView r5 = this.d.get(r7);
        if (r5 != null) goto L18;
        return;
    L18:
        if (r5.getParent() != null) goto L22;
        f r8 = b();
        if (r8 == null) goto L31;
        String r9 = r7.a;
        r8.a(r5);
        r5.addLynxViewClient(new e(r5));
        return;
    L31:
        return;
    L22:
        w6a.h.a.a.b(r5);
        r5.onEnterForeground();
        return;
    }

    public d(f r2, int r3) {
        this.b = new Stack();
        this.a = new WeakReference(r2);
        this.d = new i(r3, this);
    }

    public static void a(d r2, LynxView r3) {
        r2.getClass();
        if (r3 == null) goto L18;
        Iterator<LynxUI> r4 = w6a.h.a.a.e.keySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        LynxUI r0 = r4.next();
        if (r0.getLynxContext().getUIBody().getBodyView() != r3) goto L7;
        r0.execPauseAnim();
        goto L7
    L11:
        r3.onEnterBackground();
        return;
    }
}
