package com.larus.common_ui.widget.concat_adapter;

import androidx.collection.LongSparseArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface c {

    public static class a implements c {
        public long a;

        /* JADX INFO: renamed from: com.larus.common_ui.widget.concat_adapter.c$a$a, reason: collision with other inner class name */
        public class C0017a implements d {
            public final LongSparseArray<Long> a;
            public final /* synthetic */ a b;

            public C0017a(a r1) {
                this.b = r1;
                this.a = new LongSparseArray();
            }

            @Override // com.larus.common_ui.widget.concat_adapter.c.d
            public final long localToGlobal(long r6) {
                Long r0 = (Long) this.a.get(r6);
                if (r0 != null) goto L6;
                a r1 = this.b;
                long r2 = r1.a;
                r1.a = 1 + r2;
                r0 = Long.valueOf(r2);
                this.a.put(r6, r0);
            L6:
                return r0.longValue();
            }
        }

        @Override // com.larus.common_ui.widget.concat_adapter.c
        public final d createStableIdLookup() {
            return new C0017a(this);
        }

        public a() {
            this.a = 0;
        }
    }

    public static class b implements c {
        public final a a;

        public class a implements d {
            @Override // com.larus.common_ui.widget.concat_adapter.c.d
            public final long localToGlobal(long r1) {
                return -1;
            }

            public a() {
            }
        }

        public b() {
            this.a = new a();
        }

        @Override // com.larus.common_ui.widget.concat_adapter.c
        public final d createStableIdLookup() {
            return this.a;
        }
    }

    /* JADX INFO: renamed from: com.larus.common_ui.widget.concat_adapter.c$c, reason: collision with other inner class name */
    public static class C0018c implements c {
        public final a a;

        /* JADX INFO: renamed from: com.larus.common_ui.widget.concat_adapter.c$c$a */
        public class a implements d {
            @Override // com.larus.common_ui.widget.concat_adapter.c.d
            public final long localToGlobal(long r1) {
                return r1;
            }

            public a() {
            }
        }

        public C0018c() {
            this.a = new a();
        }

        @Override // com.larus.common_ui.widget.concat_adapter.c
        public final d createStableIdLookup() {
            return this.a;
        }
    }

    public interface d {
        long localToGlobal(long r1);
    }

    d createStableIdLookup();
}
