package z0b;

import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleonv2.lkapi.biz.profile.BizProfile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public final List<a> a;
    public final List<a> b;

    public c() {
        a1b.a r1 = new a1b.a();
        com.ss.android.lark.chameleonv2.lkapi.appconfig.a r2 = new com.ss.android.lark.chameleonv2.lkapi.appconfig.a();
        c1b.a r3 = new c1b.a();
        e1b.a r4 = new e1b.a();
        g1b.a r5 = new g1b.a();
        com.ss.android.lark.chameleonv2.lkapi.net.a r6 = new com.ss.android.lark.chameleonv2.lkapi.net.a();
        i1b.a r7 = new i1b.a();
        j1b.b r8 = new j1b.b();
        k1b.a r9 = new k1b.a();
        m1b.a r10 = new m1b.a();
        l1b.a r11 = new l1b.a();
        n1b.a r12 = new n1b.a();
        com.ss.android.lark.chameleonv2.lkapi.transport.c r13 = new com.ss.android.lark.chameleonv2.lkapi.transport.c();
        p1b.a r14 = new p1b.a();
        s1b.a r15 = new s1b.a();
        r1b.a r16 = new r1b.a();
        BizProfile r17 = new BizProfile();
        this.a = CollectionsKt.arrayListOf(new a[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, new b1b.a(), r16});
        this.b = CollectionsKt.arrayListOf(new a[]{r15, r17});
    }

    public final ArrayList<AbsChameleonHandler<?>> a() {
        ArrayList<AbsChameleonHandler<?>> r0 = new ArrayList();
        Iterator<a> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.addAll(r1.next().c());
        goto L4
    L6:
        Iterator<a> r2 = this.b.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r0.addAll(r2.next().c());
        goto L8
    L10:
        return r0;
    }
}
