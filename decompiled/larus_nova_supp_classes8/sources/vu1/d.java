package vu1;

import com.bytedance.android.livesdk.end.LiveEndPageData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import ju1.l;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements a {
    public final ConcurrentHashMap<String, c> a;
    public final ConcurrentHashMap<String, e> b;
    public final ConcurrentHashMap<String, f> c;
    public a.InterfaceC0425a d;

    @Override // vu1.a
    public final Iterator<f> a() {
        return this.c.values().iterator();
    }

    @Override // vu1.a
    public final Iterator<e> b() {
        return this.b.values().iterator();
    }

    @Override // vu1.a
    public final Iterator<c> d() {
        return this.a.values().iterator();
    }

    public d() {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
    }

    @Override // vu1.a
    public final ju1.c<Object> c(String r2) {
        Intrinsics.checkNotNullParameter(r2, LiveEndPageData.TAG_NAME);
        c r3 = this.a.get(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.a;
    }

    @Override // vu1.a
    public final List<ju1.h> e(String r5) {
        Intrinsics.checkNotNullParameter(r5, LiveEndPageData.TAG_NAME);
        ConcurrentHashMap<String, f> r0 = this.c;
        ArrayList r1 = new ArrayList();
        Iterator<Map.Entry<String, f>> r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L15;
        Map.Entry<String, f> r3 = r2.next();
        if (r3.getValue().a.e().contains(r5) == false) goto L9;
        ju1.h r4 = r3.getValue().a;
    L12:
        if (r4 == null) goto L4;
        r1.add(r4);
        goto L4
    L9:
        if (r3.getValue().a.c().contains(r5) == false) goto L11;
        r4 = r3.getValue().a;
        goto L12
    L11:
        r4 = null;
        goto L12
    L15:
        return CollectionsKt.toList(r1);
    }

    @Override // vu1.a
    public final List<l> f(String r3) {
        Intrinsics.checkNotNullParameter(r3, LiveEndPageData.TAG_NAME);
        ConcurrentHashMap<String, e> r4 = this.b;
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<String, e>> r5 = r4.entrySet().iterator();
        if (r5.hasNext() == false) goto L5;
        r5.next().getValue().getClass();
        throw null;
    L5:
        return CollectionsKt.toList(r0);
    }

    @Override // vu1.a
    public final void g(h r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.d = r2;
    }
}
