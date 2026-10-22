package com.bytedance.live.artist.render;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class RenderRequest {
    public final TreeSet<RenderEntity> a;
    public transient float b;
    public final Function1<RenderEntity, Unit> c;
    public final Function1<RenderEntity, Unit> d;

    public static final class a implements Comparator {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r4, Object r5) {
            RenderEntity r6 = (RenderEntity) r4;
            RenderEntity r7 = (RenderEntity) r5;
            int r0 = r6.f;
            int r1 = r7.f;
            if (r0 != r1) goto L9;
            if ((r6.g - r7.g) <= 0) goto L7;
            return 1;
        L7:
            return -1;
        L9:
            return r0 - r1;
        }
    }

    public RenderRequest() {
        this.a = new TreeSet(a.a);
        this.c = RenderRequest$renderStartAction$1.INSTANCE;
        this.d = RenderRequest$renderEndAction$1.INSTANCE;
    }

    public final void a(Function1<? super RenderEntity, Unit> r3) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r3.invoke(r0.next());
        goto L4
    }
}
