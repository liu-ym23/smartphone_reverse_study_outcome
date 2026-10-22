package com.bytedance.android.live.process;

import com.bytedance.android.live.room.api.experience.perf.LivePerfBizLevel;
import com.bytedance.android.live.room.api.experience.perf.LivePerfBizType;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class BasicPerfProcess {
    public static final Lazy a = null;

    public static final class a implements e {
        public static final n61.b.a a = null;
        public static final a b = null;

        public a() {
        }

        static {
            b = new a();
            a = n61.b.a.a;
        }

        @Override // com.bytedance.android.live.process.BasicPerfProcess.e
        public n61.b getType() {
            return a;
        }

        @Override // com.bytedance.android.live.process.BasicPerfProcess.e
        public final k61.a a(int r3) {
            if (r3 == 11) goto L8;
            if (r3 == 12) goto L8;
            return null;
        L8:
            return new k61.a(LivePerfBizType.Degrade, LivePerfBizLevel.P0);
        }
    }

    public static final class b implements e {
        public static final n61.b.b a = null;
        public static final b b = null;

        public b() {
        }

        static {
            b = new b();
            a = n61.b.b.a;
        }

        @Override // com.bytedance.android.live.process.BasicPerfProcess.e
        public n61.b getType() {
            return a;
        }

        @Override // com.bytedance.android.live.process.BasicPerfProcess.e
        public final k61.a a(int r3) {
            if (r3 == 2) goto L12;
            if (r3 == 3) goto L15;
            if (r3 == 4) goto L14;
            return null;
        L14:
            return new k61.a(LivePerfBizType.Degrade, LivePerfBizLevel.P2);
        L15:
            return new k61.a(LivePerfBizType.Degrade, LivePerfBizLevel.P1);
        L12:
            return new k61.a(LivePerfBizType.Degrade, LivePerfBizLevel.P0);
        }
    }

    public static final class c implements e {
        public static final n61.b.b a = null;
        public static final c b = null;

        public c() {
        }

        @Override // com.bytedance.android.live.process.BasicPerfProcess.e
        public final k61.a a(int r1) {
            return null;
        }

        static {
            b = new c();
            a = n61.b.b.a;
        }

        @Override // com.bytedance.android.live.process.BasicPerfProcess.e
        public n61.b getType() {
            return a;
        }
    }

    public static final class d implements e {
        public static final n61.b.b a = null;
        public static final d b = null;

        public d() {
        }

        static {
            b = new d();
            a = n61.b.b.a;
        }

        @Override // com.bytedance.android.live.process.BasicPerfProcess.e
        public n61.b getType() {
            return a;
        }

        @Override // com.bytedance.android.live.process.BasicPerfProcess.e
        public final k61.a a(int r3) {
            if (r3 == 0) goto L5;
            return null;
        L5:
            return new k61.a(LivePerfBizType.Normal, LivePerfBizLevel.Default);
        }
    }

    public interface e {
        k61.a a(int r1);

        n61.b getType();
    }

    static {
        a = LazyKt.lazy(BasicPerfProcess$bizPerfMapping$2.INSTANCE);
    }
}
