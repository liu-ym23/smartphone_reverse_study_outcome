package com.bytedance.android.live.revlink.impl.pk.feedview.machine;

import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class e {
    public final String a;

    public static final class a extends e {
        public final com.bytedance.android.live.revlink.impl.pk.feedview.machine.c b;

        public a(com.bytedance.android.live.revlink.impl.pk.feedview.machine.c r2) {
            Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
            super("BattleOpen");
            this.b = r2;
        }
    }

    public static final class b extends e {
        public final p b;

        public b(p r2) {
            Intrinsics.checkNotNullParameter(r2, "linkInfo");
            super("PenalTimeUpToLink");
            this.b = r2;
        }
    }

    public static final class c extends e {
        public final p b;

        public c(p r2) {
            Intrinsics.checkNotNullParameter(r2, "linkInfo");
            super("PkStandardEndToLink");
            this.b = r2;
        }
    }

    public static final class d extends e {
        public final com.bytedance.android.live.revlink.impl.pk.feedview.machine.b b;

        public d(com.bytedance.android.live.revlink.impl.pk.feedview.machine.b r2) {
            Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
            super("PkStandardEndToPenal");
            this.b = r2;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.feedview.machine.e$e, reason: collision with other inner class name */
    public static final class C0169e extends e {
        public final p b;

        public C0169e(p r2) {
            Intrinsics.checkNotNullParameter(r2, "linkInfo");
            super("PkTimeOutToLink");
            this.b = r2;
        }
    }

    public static final class f extends e {
        public final x b;

        public f(x r2) {
            Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
            super("PkTimeOutToPenal");
            this.b = r2;
        }
    }

    public static final class g extends e {
        public final p b;

        public g(p r2) {
            Intrinsics.checkNotNullParameter(r2, "linkInfo");
            super("QueryFailedBackToLink");
            this.b = r2;
        }
    }

    public static final class h extends e {
        public final p b;
        public final o c;

        public h(p r2, o r3) {
            Intrinsics.checkNotNullParameter(r2, "linkInfo");
            Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
            super("QueryReturnLink");
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class i extends e {
        public final r b;

        public i(r r2) {
            Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
            super("QueryReturnPenal");
            this.b = r2;
        }
    }

    public static final class j extends e {
        public final u b;

        public j(u r2) {
            Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
            super("QueryReturnPk");
            this.b = r2;
        }
    }

    public static final class k extends e {
        public final p b;

        public k(p r2) {
            Intrinsics.checkNotNullParameter(r2, "linkInfo");
            super("ResetToLinkPrepareReBattle");
            this.b = r2;
        }
    }

    public static final class l extends e {
        public final p b;

        public l(p r2) {
            Intrinsics.checkNotNullParameter(r2, "linkInfo");
            super("SecKillToLink");
            this.b = r2;
        }
    }

    public static final class m extends e {
        public final z b;

        public m(z r2) {
            Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
            super("SecKillToPenal");
            this.b = r2;
        }
    }

    public e(String r1) {
        this.a = r1;
    }
}
