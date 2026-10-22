package com.bytedance.android.live.profit.vote.model;

import io.reactivex.subjects.Subject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class b {

    public static final class a extends b {
        public final com.bytedance.android.live.profit.vote.b a;

        public final String toString() {
            return "CountDown(" + this.a + ')';
        }

        @Override // com.bytedance.android.live.profit.vote.model.b
        public final com.bytedance.android.live.profit.vote.b a() {
            return this.a;
        }

        public a(com.bytedance.android.live.profit.vote.b r2) {
            Intrinsics.checkNotNullParameter(r2, "vote");
            this.a = r2;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.vote.model.b$b, reason: collision with other inner class name */
    public static final class C0056b extends b {
        public final com.bytedance.android.live.profit.vote.b a;

        public final String toString() {
            return "Finished(" + this.a + ')';
        }

        @Override // com.bytedance.android.live.profit.vote.model.b
        public final com.bytedance.android.live.profit.vote.b a() {
            return this.a;
        }

        public C0056b(com.bytedance.android.live.profit.vote.model.c r2) {
            Intrinsics.checkNotNullParameter(r2, "vote");
            this.a = r2;
        }
    }

    public static final class c extends b {
        public static final c a = null;

        public final String toString() {
            return "Gone";
        }

        static {
            a = new c();
        }

        public c() {
        }
    }

    public static final class d extends b {
        public final com.bytedance.android.live.profit.vote.b a;
        public final Subject<Long> b;

        public final String toString() {
            return "Normal(" + this.a + ')';
        }

        @Override // com.bytedance.android.live.profit.vote.model.b
        public final com.bytedance.android.live.profit.vote.b a() {
            return this.a;
        }

        public d(com.bytedance.android.live.profit.vote.model.c r2, Subject r3) {
            Intrinsics.checkNotNullParameter(r2, "vote");
            Intrinsics.checkNotNullParameter(r3, "timer");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class e extends b {
        public final com.bytedance.android.live.profit.vote.b a;

        public final String toString() {
            return "TimeOut(" + this.a + ')';
        }

        @Override // com.bytedance.android.live.profit.vote.model.b
        public final com.bytedance.android.live.profit.vote.b a() {
            return this.a;
        }

        public e(com.bytedance.android.live.profit.vote.b r2) {
            Intrinsics.checkNotNullParameter(r2, "vote");
            this.a = r2;
        }
    }

    public b() {
    }

    public com.bytedance.android.live.profit.vote.b a() {
        return null;
    }
}
