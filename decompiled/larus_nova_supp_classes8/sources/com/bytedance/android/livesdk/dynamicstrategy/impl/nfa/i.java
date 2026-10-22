package com.bytedance.android.livesdk.dynamicstrategy.impl.nfa;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.log.j0;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i implements h, f.a {
    public final HashMap<String, HashMap<String, g>> a;
    public final HashMap<String, List<String>> b;
    public final HashMap<String, HashMap<String, g>> c;
    public final HashMap<String, g> d;
    public final l e;
    public final HashSet<String> f;
    public final String g;

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.h
    public final void prepare() {
        if (((ku1.a) ku1.g.a.getValue()).a() == true) goto L5;
        return;
    L5:
        f r0 = f.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        ArrayList r1 = (ArrayList) f.a;
        if (r1.isEmpty() == false) goto L8;
        j0.l().addSendLogFilter(f.class, r0);
    L8:
        r1.add(this);
        int r2 = b.a;
        String r3 = "Room(" + this.g + ") NfaManager Prepared";
        Intrinsics.checkNotNullParameter(r3, "info");
        ALogger.i("StrategyCepNfa", r3);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.h
    public final void release() {
        Iterator<T> r0 = this.a.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((HashMap) r0.next()).clear();
        goto L4
    L6:
        this.a.clear();
        this.b.clear();
        this.f.clear();
        l r1 = this.e;
        r1.a.clear();
        Disposable r2 = r1.c;
        if (r2 == null) goto L9;
        r2.dispose();
    L9:
        r1.c = null;
        int r3 = b.a;
        b.d("Room(" + r1.d + ") NfaTimerManager release");
        this.d.clear();
        f.b.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        ArrayList r4 = (ArrayList) f.a;
        r4.remove(this);
        if (r4.isEmpty() == false) goto L12;
        j0.l().removeSendLogFilter(f.class);
    L12:
        String r5 = "Room(" + this.g + ") NfaManager release";
        Intrinsics.checkNotNullParameter(r5, "info");
        ALogger.i("StrategyCepNfa", r5);
    }

    public i(String r2) {
        Intrinsics.checkNotNullParameter(r2, "roomId");
        this.g = r2;
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new l(r2);
        this.f = new HashSet();
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.h
    public final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "nfaName");
        List<String> r0 = this.b.get(r4);
        if (r0 == null) goto L10;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        String r2 = (String) r1.next();
        HashMap<String, g> r3 = this.a.get(r2);
        if (r3 == null) goto L6;
        g r5 = r3.remove(r4);
    L10:
        this.b.remove(r4);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.h
    public final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "nfaName");
        g r3 = this.d.get(r2);
        if (r3 == null) goto L6;
        e(r3);
        return;
    }

    public final void e(g r5) {
        Iterator<T> r0 = r5.g().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        String r1 = (String) r0.next();
        HashMap<String, g> r2 = this.a.get(r1);
        if (r2 != null) goto L8;
        r2 = new HashMap();
        this.a.put(r1, r2);
    L8:
        r2.put(r5.e(), r5);
        goto L4
    L9:
        List<String> r3 = r5.g();
        if ((!r3.isEmpty()) == true) goto L13;
        r3 = null;
    L13:
        if (r3 == null) goto L19;
        this.b.put(r5.e(), r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.f.a
    public final void a(String r6, Map<String, Object> r7) {
        Intrinsics.checkNotNullParameter(r6, "eventKey");
        Intrinsics.checkNotNullParameter(r7, "eventParams");
        if (this.f.contains(r6) == true) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        HashSet r1 = new HashSet();
        HashMap<String, g> r2 = this.a.get(r6);
        if (r2 == null) goto L11;
        Iterator<Map.Entry<String, g>> r3 = r2.entrySet().iterator();
    L9:
        if (r3.hasNext() == false) goto L11;
        Map.Entry<String, g> r4 = r3.next();
        mu1.b.a(r4.getValue(), r6, r7);
        r1.add(r4.getKey());
        r0.add(r4.getValue());
    L11:
        HashMap<String, g> r5 = this.c.get(r6);
        if (r5 == null) goto L20;
        Iterator<Map.Entry<String, g>> r8 = r5.entrySet().iterator();
    L15:
        if (r8.hasNext() == false) goto L20;
        Map.Entry<String, g> r9 = r8.next();
        if (r1.contains(r9.getKey()) == true) goto L15;
        mu1.b.a(r9.getValue(), r6, r7);
        r0.add(r9.getValue());
    L20:
        Iterator r10 = r0.iterator();
    L22:
        if (r10.hasNext() == false) goto L24;
        g r11 = (g) r10.next();
        b(r11.e());
        e(r11);
        goto L22
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.h
    public final g c(e r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "nfa");
        Intrinsics.checkNotNullParameter(r9, "source");
        if (((ku1.a) ku1.g.a.getValue()).a() == true) goto L6;
        return null;
    L6:
        g r0 = this.d.get(r8.h);
        if (r0 == null) goto L9;
        int r6 = b.a;
        String r10 = "Room(" + this.g + ") NfaManager Add Nfa:" + r8.h + ", From:" + r9 + ", exist same nfa";
        Intrinsics.checkNotNullParameter(r10, "info");
        ALogger.i("StrategyCepNfa", r10);
        return r0;
    L9:
        int r1 = b.a;
        String r11 = "Room(" + this.g + ") NfaManager Add Nfa:" + r8.h + ", From:" + r9 + ", add success";
        Intrinsics.checkNotNullParameter(r11, "info");
        ALogger.i("StrategyCepNfa", r11);
        this.d.put(r8.h, r8);
        r8.b = this.e;
        r8.c = this;
        Iterator<T> r12 = r8.i().iterator();
    L11:
        if (r12.hasNext() == false) goto L13;
        this.f.add((String) r12.next());
        goto L11
    L13:
        Iterator<T> r13 = r8.h().iterator();
    L15:
        if (r13.hasNext() == false) goto L25;
        String r2 = (String) r13.next();
        HashMap<String, g> r3 = this.c.get(r2);
        if (r3 != null) goto L19;
        r3 = new HashMap();
        this.c.put(r2, r3);
    L19:
        r3.put(r8.h, r8);
        goto L15
    L25:
        return r8;
    }
}
