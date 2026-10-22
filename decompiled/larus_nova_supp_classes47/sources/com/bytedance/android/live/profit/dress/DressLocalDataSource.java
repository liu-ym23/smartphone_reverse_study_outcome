package com.bytedance.android.live.profit.dress;

import com.bytedance.android.livedress.impl.PbDecodeService;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class DressLocalDataSource {
    public final Map<String, p> a;
    public final Map<String, d> b;
    public final Map<Integer, Map<String, d>> c;
    public final Map<byte[], String> d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ DressLocalDataSource a;

        public a(DressLocalDataSource r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            List r12 = (List) r10;
            DressLocalDataSource r0 = this.a;
            r0.getClass();
            com.bytedance.live.kmp.util.c r1 = com.bytedance.live.kmp.util.c.a;
            long r2 = System.currentTimeMillis();
            String r3 = (String) r0.f.getValue();
            if (r3 != null) goto L5;
        L8:
            boolean r4 = true;
        L9:
            if (r4 == true) goto L60;
            String r5 = (String) r0.h.getValue();
            if (r5 != null) goto L13;
        L16:
            boolean r6 = true;
        L17:
            if (r6 == true) goto L61;
            Iterator r13 = r12.iterator();
        L21:
            if (r13.hasNext() == false) goto L44;
            p r7 = (p) r13.next();
            String r8 = r7.getDecoded().getDressId();
            if (r8.length() != 0) goto L25;
            boolean r9 = true;
        L26:
            if (r9 == true) goto L21;
            byte[] r14 = r7.getPbBytes();
            if (r14 == null) goto L21;
            if (((LinkedHashMap) r0.d).get(r14) != null) goto L32;
            PbDecodeService r15 = PbDecodeService.b;
            String r16 = (String) r0.f.getValue();
            Intrinsics.checkNotNull(r16);
            String r17 = (String) r0.h.getValue();
            Intrinsics.checkNotNull(r17);
            r15.getClass();
            com.bytedance.android.livedress.impl.a r18 = PbDecodeService.a(r14, r16, r17);
            if (r18.a == false) goto L21;
            String r19 = r18.b;
            if (r19 != null) goto L38;
        L41:
            boolean r20 = true;
        L42:
            if (r20 == true) goto L21;
            r0.d.put(r14, r18.b);
            goto L21
        L38:
            if (r19.length() == 0) goto L41;
            r20 = false;
            goto L42
        L32:
            jy0.b.a("DressRepository", "preParsePbData. 已解析 return dressId: ".concat(r8));
            goto L21
        L25:
            r9 = false;
            goto L26
        L44:
            StringBuilder r110 = new StringBuilder("preParsePbData cost: ");
            com.bytedance.live.kmp.util.c r22 = com.bytedance.live.kmp.util.c.a;
            r110.append(System.currentTimeMillis() - r2);
            jy0.b.a("DressRepository", r110.toString());
            return;
        L61:
            return;
        L13:
            if (r5.length() == 0) goto L16;
            r6 = false;
            goto L17
        L60:
            return;
        L5:
            if (r3.length() == 0) goto L8;
            r4 = false;
            goto L9
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r4) {
            jy0.b.c("DressRepository", "Error in preParsePbData: " + ((Throwable) r4).getMessage(), null, 4);
        }
    }

    public DressLocalDataSource() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = LazyKt.lazy(DressLocalDataSource$dressList$2.INSTANCE);
        this.f = LazyKt.lazy(DressLocalDataSource$dressConfigIDL$2.INSTANCE);
        this.g = LazyKt.lazy(DressLocalDataSource$dressConfigIDLVersion$2.INSTANCE);
        this.h = LazyKt.lazy(DressLocalDataSource$definitionName$2.INSTANCE);
    }

    public final void a(List<? extends p> r9) {
        Intrinsics.checkNotNullParameter(r9, "list");
        ArrayList r0 = new ArrayList();
        Iterator<? extends p> r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L26;
        p r1 = r10.next();
        o r2 = r1.getDecoded();
        String r3 = r2.getDressId();
        int r4 = r2.getDressType();
        if (r3.length() <= 0) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L4;
        this.a.put(r3, r1);
        d r6 = c.a(r2);
        if (((List) this.e.getValue()) == null) goto L19;
        List r7 = (List) this.e.getValue();
        Intrinsics.checkNotNull(r7);
        if (r7.contains(r3) == false) goto L19;
        if (r2.getDressType() != 1) goto L17;
    L18:
        r0.add(r1);
        goto L19
    L17:
        if (r2.getDressType() == 2) goto L18;
    L19:
        this.b.put(r3, r6);
        if (this.c.containsKey(Integer.valueOf(r4)) == true) goto L22;
        this.c.put(Integer.valueOf(r4), new LinkedHashMap());
    L22:
        Map<Integer, Map<String, d>> r8 = this.c;
        LinkedHashMap r12 = (LinkedHashMap) r8;
        Map r13 = (Map) r12.get(Integer.valueOf(r4));
        if (r13 == null) goto L4;
        d r14 = (d) r13.put(r3, r6);
        goto L4
    L8:
        r5 = false;
        goto L9
    L26:
        if (r0.size() <= 0) goto L36;
        int r15 = com.bytedance.revenue.platform.api.core.rx.q.a;
        Single r16 = Single.just(r0);
        int r17 = com.bytedance.revenue.platform.api.core.rx.p.a;
        r16.subscribeOn(Schedulers.io()).subscribe(new a(this), b.a);
        return;
    }
}
