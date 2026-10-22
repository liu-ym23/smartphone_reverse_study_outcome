package com.bytedance.android.live.liveinteract.revenue.linkroomfight.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c$a$a, reason: collision with other inner class name */
        public static final class C0090a extends a {
        }

        public static final class b extends a {
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c$a$c, reason: collision with other inner class name */
        public static final class C0091c extends a {
        }

        public static final class d extends a {
        }

        public static final class e extends a {
        }

        public static final class f extends a {
        }

        public static final class g extends a {
        }

        public static final class h extends a {
        }

        public static final class i extends a {
        }

        public static final class j extends a {
        }

        public static final class k extends a {
        }

        public final String toString() {
            return null;
        }
    }

    public static abstract class b {
        public final com.bytedance.android.live.liveinteract.multiscene.a a;
        public final String b;

        public static final class a extends b {
            public a(com.bytedance.android.live.liveinteract.multiscene.a r2) {
                Intrinsics.checkNotNullParameter(r2, "teamFightInfo");
                super(r2, "Fighting");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c$b$b, reason: collision with other inner class name */
        public static final class C0092b extends b {
            public C0092b(com.bytedance.android.live.liveinteract.multiscene.a r2) {
                Intrinsics.checkNotNullParameter(r2, "teamFightInfo");
                super(r2, "Finished");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c$b$c, reason: collision with other inner class name */
        public static final class C0093c extends b {
            public static final C0093c c = null;

            static {
                c = new C0093c();
            }

            public C0093c() {
                super((com.bytedance.android.live.liveinteract.multiscene.a) vh7.f.c(com.bytedance.android.live.liveinteract.multiscene.a.class), "None");
            }
        }

        public static final class d extends b {
            public d(com.bytedance.android.live.liveinteract.multiscene.a r2) {
                Intrinsics.checkNotNullParameter(r2, "teamFightInfo");
                super(r2, "PunishFinish");
            }
        }

        public static final class e extends b {
            public e(com.bytedance.android.live.liveinteract.multiscene.a r2) {
                Intrinsics.checkNotNullParameter(r2, "teamFightInfo");
                super(r2, "Punishing");
            }
        }

        public static final class f extends b {
            public f() {
                throw null;
            }
        }

        public final boolean a() {
            if ((this instanceof a) == false) goto L5;
        L12:
            return true;
        L5:
            if ((this instanceof f) == true) goto L12;
            if ((this instanceof e) == true) goto L12;
            if ((this instanceof d) == true) goto L12;
            return false;
        }

        public final String toString() {
            return this.b;
        }

        public b(com.bytedance.android.live.liveinteract.multiscene.a r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }
}
