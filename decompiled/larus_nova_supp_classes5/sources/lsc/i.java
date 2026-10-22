package lsc;

import android.os.Looper;
import android.text.Spanned;
import android.widget.TextView;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.noties.markwon.core.CoreProps;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import vvc.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class i extends f {
    public final TextView.BufferType a;
    public final e b;
    public final ysc.a c;
    public final o d;
    public final List<j> e;

    public final uvc.b a(String r3, boolean r4) {
        Iterator<j> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        r3 = r0.next().b(r3);
        goto L4
    L7:
        if (this.c == null) goto L15;
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) == ThreadMethodProxy.currentThread()) goto L11;
        this.c.a();
        return this.b.a(r3);
    L11:
        return this.c.b(r3, r4);
    L15:
        return this.b.a(r3);
    }

    public final y.b b(uvc.b r5, TextView r6, s r7) {
        Iterator<j> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().l(r6, r5);
        goto L4
    L6:
        p r1 = this.d.a();
        if (r7 == null) goto L9;
        CoreProps.j.c(r1.b, new HashMap());
    L9:
        r5.a(r1);
        Iterator<j> r2 = this.e.iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        r2.next().a(r6, r5, r1);
        goto L11
    L13:
        if (r7 == null) goto L16;
        r7.a((HashMap) CoreProps.j.a(r1.b));
    L16:
        return r1.c.h();
    }

    public final y.b c(uvc.b r5, CharSequence r6, s r7) {
        Iterator<j> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().i(r6, r5);
        goto L4
    L6:
        p r1 = this.d.a();
        CoreProps.j.c(r1.b, new HashMap());
        r5.a(r1);
        Iterator<j> r2 = this.e.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r2.next().d(r6, r5, r1);
        goto L8
    L10:
        r7.a((HashMap) CoreProps.j.a(r1.b));
        return r1.c.h();
    }

    public final void d(TextView r17, Spanned r18, v r19) {
        long r3 = System.currentTimeMillis();
        Iterator<j> r5 = this.e.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().f(r17, r18);
        goto L4
    L6:
        long r6 = System.currentTimeMillis();
        r17.setText(r18, this.a);
        long r7 = System.currentTimeMillis();
        Iterator<j> r2 = this.e.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r2.next().G4(r17);
        goto L8
    L10:
        long r1 = System.currentTimeMillis();
        if (r19 == null) goto L16;
        r19.a(r6 - r3, r7 - r6, r1 - r7);
        return;
    }

    public i(TextView.BufferType r1, e r2, n r3, List r4, ysc.a r5) {
        this.a = r1;
        this.b = r2;
        this.d = r3;
        this.e = r4;
        this.c = r5;
    }
}
