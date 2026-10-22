package com.obric.oui.orecyclerview.widget;

import androidx.collection.LongSparseArray;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
interface ab {

    public static class a implements ab {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f14118a;

        /* JADX INFO: renamed from: com.obric.oui.orecyclerview.widget.ab$a$a, reason: collision with other inner class name */
        class C0757a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f14119a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final LongSparseArray<Long> f14120b;

            C0757a(a r1) {
                this.f14119a = r1;
                this.f14120b = new LongSparseArray();
            }

            @Override // com.obric.oui.orecyclerview.widget.ab.d
            public long a(long r4) {
                Long r0 = (Long) ZeusTransformUtils.preCheckCast(this.f14120b.get(r4), Long.class, "com.obric.memorydata.plugin");
                if (r0 != null) goto L6;
                r0 = Long.valueOf(this.f14119a.b());
                this.f14120b.put(r4, r0);
            L6:
                return r0.longValue();
            }
        }

        public a() {
            this.f14118a = 0;
        }

        @Override // com.obric.oui.orecyclerview.widget.ab
        public d a() {
            return new C0757a(this);
        }

        long b() {
            long r0 = this.f14118a;
            this.f14118a = 1 + r0;
            return r0;
        }
    }

    public static class b implements ab {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f14121a;

        public b() {
            this.f14121a = new AnonymousClass1(this);
        }

        @Override // com.obric.oui.orecyclerview.widget.ab
        public d a() {
            return this.f14121a;
        }
    }

    public static class c implements ab {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f14123a;

        public c() {
            this.f14123a = new AnonymousClass1(this);
        }

        @Override // com.obric.oui.orecyclerview.widget.ab
        public d a() {
            return this.f14123a;
        }
    }

    public interface d {
        long a(long r1);
    }

    d a();
}
