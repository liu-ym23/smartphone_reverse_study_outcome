package com.bytedance.android.live.profit.fansclub;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.message.model.f7;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class c {

    public static final class a extends c {
        public final f7.b a;
        public final int b;

        public a(f7.b r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static class b extends c {
        public final IBaseUser a;
        public final Long b;

        public /* synthetic */ b() {
            throw null;
        }

        public b(IBaseUser r2, Long r3) {
            Intrinsics.checkNotNullParameter(r2, "user");
            this.a = r2;
            this.b = r3;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.fansclub.c$c, reason: collision with other inner class name */
    public static final class C0019c extends b {
        public C0019c(IBaseUser r2, Long r3) {
            Intrinsics.checkNotNullParameter(r2, "user");
            super(r2, r3);
        }
    }

    public static final class d extends b {
        public d(IBaseUser r2, Long r3) {
            Intrinsics.checkNotNullParameter(r2, "user");
            super(r2, r3);
        }
    }

    public static final class e extends b {
        public e(IBaseUser r2) {
            Intrinsics.checkNotNullParameter(r2, "user");
            super(r2, null);
        }
    }

    public static final class f extends b {
        public f(IBaseUser r2) {
            Intrinsics.checkNotNullParameter(r2, "user");
            super(r2, null);
        }
    }

    public static final class g extends b {
        public g(IBaseUser r2) {
            Intrinsics.checkNotNullParameter(r2, "user");
            super(r2, null);
        }
    }

    public static final class h extends b {
        public h(IBaseUser r2) {
            Intrinsics.checkNotNullParameter(r2, "user");
            super(r2, null);
        }
    }

    public c() {
    }
}
