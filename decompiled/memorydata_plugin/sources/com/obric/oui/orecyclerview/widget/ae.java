package com.obric.oui.orecyclerview.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
interface ae {

    public static class a implements ae {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SparseArray<s> f14133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f14134b;

        /* JADX INFO: renamed from: com.obric.oui.orecyclerview.widget.ae$a$a, reason: collision with other inner class name */
        class C0758a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final s f14135a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f14136b;
            private SparseIntArray c;
            private SparseIntArray d;

            C0758a(a r2, s r3) {
                this.f14136b = r2;
                this.c = new SparseIntArray(1);
                this.d = new SparseIntArray(1);
                this.f14135a = r3;
            }

            @Override // com.obric.oui.orecyclerview.widget.ae.c
            public int a(int r3) {
                int r0 = this.c.indexOfKey(r3);
                if (r0 > (-1)) goto L5;
                int r1 = this.f14136b.b(this.f14135a);
                this.c.put(r3, r1);
                this.d.put(r1, r3);
                return r1;
            L5:
                return this.c.valueAt(r0);
            }

            @Override // com.obric.oui.orecyclerview.widget.ae.c
            public int b(int r4) {
                int r0 = this.d.indexOfKey(r4);
                if (r0 < 0) goto L7;
                return this.d.valueAt(r0);
            L7:
                throw new IllegalStateException("requested global type " + r4 + " does not belong to the adapter:" + this.f14135a.f14230a);
            }
        }

        public a() {
            this.f14133a = new SparseArray();
            this.f14134b = 0;
        }

        @Override // com.obric.oui.orecyclerview.widget.ae
        public c a(s r2) {
            return new C0758a(this, r2);
        }

        @Override // com.obric.oui.orecyclerview.widget.ae
        public s a(int r3) {
            s r2 = (s) ZeusTransformUtils.preCheckCast(this.f14133a.get(r3), s.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L6;
            return r2;
        L6:
            throw new IllegalArgumentException("Cannot find the wrapper for global view type " + r3);
        }

        int b(s r3) {
            int r0 = this.f14134b;
            this.f14134b = r0 + 1;
            this.f14133a.put(r0, r3);
            return r0;
        }
    }

    public static class b implements ae {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SparseArray<List<s>> f14137a;

        class a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final s f14138a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f14139b;

            a(b r1, s r2) {
                this.f14139b = r1;
                this.f14138a = r2;
            }

            @Override // com.obric.oui.orecyclerview.widget.ae.c
            public int a(int r4) {
                List<s> r0 = (List) ZeusTransformUtils.preCheckCast(this.f14139b.f14137a.get(r4), List.class, "com.obric.memorydata.plugin");
                if (r0 != null) goto L6;
                r0 = new ArrayList();
                this.f14139b.f14137a.put(r4, r0);
            L6:
                if (r0.contains(this.f14138a) == true) goto L8;
                r0.add(this.f14138a);
            L8:
                return r4;
            }

            @Override // com.obric.oui.orecyclerview.widget.ae.c
            public int b(int r1) {
                return r1;
            }
        }

        public b() {
            this.f14137a = new SparseArray();
        }

        @Override // com.obric.oui.orecyclerview.widget.ae
        public c a(s r2) {
            return new a(this, r2);
        }

        @Override // com.obric.oui.orecyclerview.widget.ae
        public s a(int r3) {
            List r2 = (List) ZeusTransformUtils.preCheckCast(this.f14137a.get(r3), List.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L9;
            if (r2.isEmpty() == true) goto L9;
            return (s) ZeusTransformUtils.preCheckCast(r2.get(0), s.class, "com.obric.memorydata.plugin");
        L9:
            throw new IllegalArgumentException("Cannot find the wrapper for global view type " + r3);
        }
    }

    public interface c {
        int a(int r1);

        int b(int r1);
    }

    c a(s r1);

    s a(int r1);
}
