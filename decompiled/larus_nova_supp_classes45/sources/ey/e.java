package ey;

import com.bytedance.android.livesdk.link.model.bridge.d1;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.m0;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.q5;
import com.bytedance.android.livesdk.link.model.v;
import com.bytedance.android.livesdk.link.model.v4;
import d11.r;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class e {
    public final int a;
    public final String b;

    public static final class a extends e {
        public final d11.b c;

        public a(d11.b r3) {
            Intrinsics.checkNotNullParameter(r3, "applyParams");
            super(7, "ApplyRequestEvent");
            this.c = r3;
        }
    }

    public static final class b extends e {
        public final h1 c;
        public final d11.c d;

        public b(i6 r3, d11.c r4) {
            super(3, "CancelEvent");
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class c extends e {
        public final h1 c;

        public c(i6 r3) {
            Intrinsics.checkNotNullParameter(r3, "closeMessage");
            super(12, "CloseEvent");
            this.c = r3;
        }
    }

    public static final class d {
    }

    /* JADX INFO: renamed from: ey.e$e, reason: collision with other inner class name */
    public static final class C0228e extends e {
        public final h1 c;

        public C0228e(i6 r3) {
            Intrinsics.checkNotNullParameter(r3, "inviteMessage");
            super(2, "InviteMessageEvent");
            this.c = r3;
        }
    }

    public static final class f extends e {
        public final d11.d c;
        public final m0 d;

        public f(d11.d r3, v4 r4) {
            Intrinsics.checkNotNullParameter(r3, "params");
            Intrinsics.checkNotNullParameter(r4, "inviteResult");
            super(1, "InviteRequestEvent");
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class g extends e {
        public final com.bytedance.android.livesdk.link.model.bridge.f c;

        public g(fy.f r2, com.bytedance.android.livesdk.link.model.bridge.f r3) {
            Intrinsics.checkNotNullParameter(r2, "params");
            Intrinsics.checkNotNullParameter(r3, "JoinChannelResult");
            super(14, "JoinChannelResultEvent");
            this.c = r3;
        }
    }

    public static final class h extends e {
        public h() {
            this(0);
        }

        public h(int r2) {
            super(13, "LeaveEvent");
        }
    }

    public static final class i extends e {
        public final h1 c;

        public i(i6 r3) {
            Intrinsics.checkNotNullParameter(r3, "permitMessage");
            super(9, "PermitMessageEvent");
            this.c = r3;
        }
    }

    public static final class j extends e {
        public final d11.f c;
        public final com.bytedance.android.livesdk.link.model.bridge.m d;

        public j(d11.f r3, v r4) {
            Intrinsics.checkNotNullParameter(r3, "permitParams");
            super(8, "PermitResultEvent");
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class k extends e {
        public final h1 c;

        public k(i6 r3) {
            Intrinsics.checkNotNullParameter(r3, "replyMessage");
            super(6, "ReplyMessageEvent");
            this.c = r3;
        }
    }

    public static final class l extends e {
        public final d11.g c;
        public final d1 d;

        public l(d11.g r3, q5 r4) {
            Intrinsics.checkNotNullParameter(r3, "replyParams");
            super(5, "ReplyResultEvent");
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class m extends e {
        public final h1 c;

        public m(i6 r3) {
            super(11, "SwitchSceneEvent");
            this.c = r3;
        }
    }

    public static final class n extends e {
        public final r c;

        public n(r r3) {
            Intrinsics.checkNotNullParameter(r3, "timeOutParams");
            super(10, "TimeOutEvent");
            this.c = r3;
        }
    }

    static {
    }

    public final String toString() {
        return this.b + "(eventType=" + this.a + ", name='" + this.b + "')";
    }

    public e(int r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
