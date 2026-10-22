package org.jsoup.select;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.jsoup.nodes.Element;

/* JADX INFO: loaded from: classes7.dex */
public abstract class b extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ArrayList<c> f18303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f18304b;

    public static final class a extends b {
        a(Collection<c> r3) {
            super((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
        }

        a(c... r1) {
            this(Arrays.asList(r1));
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r6, Element r7) {
            int r0 = this.f18304b - 1;
        L3:
            if (r0 < 0) goto L9;
            if (((c) ZeusTransformUtils.preCheckCast(this.f18303a.get(r0), c.class, "com.obric.memorydata.plugin")).a(r6, r7) == false) goto L6;
            r0 = r0 - 1;
            goto L3
        L6:
            return false;
        L9:
            return true;
        }

        public String toString() {
            return org.jsoup.a.b.a(this.f18303a, "");
        }
    }

    /* JADX INFO: renamed from: org.jsoup.select.b$b, reason: collision with other inner class name */
    public static final class C0900b extends b {
        C0900b() {
        }

        C0900b(Collection<c> r3) {
            Collection<? extends c> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            if (this.f18304b <= 1) goto L5;
            this.f18303a.add(new a(r4));
        L6:
            b();
            return;
        L5:
            this.f18303a.addAll(r4);
            goto L6
        }

        C0900b(c... r1) {
            this(Arrays.asList(r1));
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r6, Element r7) {
            int r1 = 0;
        L4:
            if (r1 >= this.f18304b) goto L10;
            if (((c) ZeusTransformUtils.preCheckCast(this.f18303a.get(r1), c.class, "com.obric.memorydata.plugin")).a(r6, r7) == true) goto L7;
            r1 = r1 + 1;
            goto L4
        L7:
            return true;
        L10:
            return false;
        }

        public void b(c r2) {
            this.f18303a.add(r2);
            b();
        }

        public String toString() {
            return org.jsoup.a.b.a(this.f18303a, ", ");
        }
    }

    b() {
        this.f18304b = 0;
        this.f18303a = new ArrayList();
    }

    b(Collection<c> r3) {
        Collection<? extends c> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        this();
        this.f18303a.addAll(r4);
        b();
    }

    c a() {
        int r0 = this.f18304b;
        if (r0 > 0) goto L7;
        return null;
    L7:
        return (c) ZeusTransformUtils.preCheckCast(this.f18303a.get(r0 - 1), c.class, "com.obric.memorydata.plugin");
    }

    void a(c r2) {
        this.f18303a.set(this.f18304b - 1, r2);
    }

    void b() {
        this.f18304b = this.f18303a.size();
    }
}
