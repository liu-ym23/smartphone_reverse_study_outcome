package o4a;

import com.lynx.animax.ability.BaseAbility;
import com.lynx.animax.ability.Event;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import t4a.d;
import t4a.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ BaseAbility a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Map c;

    public /* synthetic */ a(BaseAbility r1, int r2, Map r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseAbility r0 = this.a;
        int r1 = this.b;
        Map r2 = this.c;
        if (((CopyOnWriteArrayList) r0.a).isEmpty() == false) goto L6;
        return;
    L6:
        switch(BaseAbility.a.a[Event.values()[r1].ordinal()]) {
            case 1: goto L61;
            case 2: goto L57;
            case 3: goto L53;
            case 4: goto L49;
            case 5: goto L45;
            case 6: goto L41;
            case 7: goto L37;
            case 8: goto L33;
            case 9: goto L23;
            case 10: goto L19;
            case 11: goto L12;
            case 12: goto L8;
            default: goto L81;
        };
    L8:
        t4a.a r3 = new t4a.a(r2);
        Iterator r4 = ((CopyOnWriteArrayList) r0.a).iterator();
    L10:
        if (r4.hasNext() == false) goto L82;
        ((f) r4.next()).k(r3);
        goto L10
    L82:
        return;
    L12:
        t4a.c r5 = new t4a.c(r2);
        if (r0.f == false) goto L18;
        Iterator r6 = ((CopyOnWriteArrayList) r0.a).iterator();
    L16:
        if (r6.hasNext() == false) goto L83;
        ((f) r6.next()).o(r5);
        goto L16
    L83:
        return;
    L18:
        r0.g = r5;
        return;
    L19:
        d r7 = new d(r2);
        Iterator r8 = ((CopyOnWriteArrayList) r0.a).iterator();
    L21:
        if (r8.hasNext() == false) goto L84;
        ((f) r8.next()).n(r7);
        goto L21
    L84:
        return;
    L23:
        t4a.c r9 = new t4a.c(r2);
        Iterator r10 = ((CopyOnWriteArrayList) r0.a).iterator();
    L25:
        if (r10.hasNext() == false) goto L27;
        ((f) r10.next()).e(r9);
        goto L25
    L27:
        WeakReference<q4a.b> r11 = r0.b;
        if (r11 == null) goto L30;
        q4a.b r12 = r11.get();
    L31:
        if (r12 == null) goto L78;
        r12.e();
        return;
    L78:
        return;
    L30:
        r12 = null;
        goto L31
    L33:
        t4a.b r13 = new t4a.b(r2);
        Iterator r14 = ((CopyOnWriteArrayList) r0.a).iterator();
    L35:
        if (r14.hasNext() == false) goto L85;
        ((f) r14.next()).g(r13);
        goto L35
    L85:
        return;
    L37:
        t4a.c r15 = new t4a.c(r2);
        Iterator r16 = ((CopyOnWriteArrayList) r0.a).iterator();
    L39:
        if (r16.hasNext() == false) goto L86;
        ((f) r16.next()).a(r15);
        goto L39
    L86:
        return;
    L41:
        t4a.a r17 = new t4a.a(r2);
        Iterator r18 = ((CopyOnWriteArrayList) r0.a).iterator();
    L43:
        if (r18.hasNext() == false) goto L87;
        ((f) r18.next()).i(r17);
        goto L43
    L87:
        return;
    L45:
        t4a.c r19 = new t4a.c(r2);
        Iterator r20 = ((CopyOnWriteArrayList) r0.a).iterator();
    L47:
        if (r20.hasNext() == false) goto L88;
        ((f) r20.next()).c(r19);
        goto L47
    L88:
        return;
    L49:
        t4a.c r21 = new t4a.c(r2);
        Iterator r22 = ((CopyOnWriteArrayList) r0.a).iterator();
    L51:
        if (r22.hasNext() == false) goto L89;
        ((f) r22.next()).b(r21);
        goto L51
    L89:
        return;
    L53:
        t4a.c r23 = new t4a.c(r2);
        Iterator r24 = ((CopyOnWriteArrayList) r0.a).iterator();
    L55:
        if (r24.hasNext() == false) goto L90;
        ((f) r24.next()).d(r23);
        goto L55
    L90:
        return;
    L57:
        t4a.c r25 = new t4a.c(r2);
        Iterator r26 = ((CopyOnWriteArrayList) r0.a).iterator();
    L59:
        if (r26.hasNext() == false) goto L91;
        ((f) r26.next()).j(r25);
        goto L59
    L91:
        return;
    L61:
        t4a.c r27 = new t4a.c(r2);
        Iterator r28 = ((CopyOnWriteArrayList) r0.a).iterator();
    L63:
        if (r28.hasNext() == false) goto L92;
        ((f) r28.next()).l(r27);
        goto L63
    L92:
        return;
    }
}
