package zj0;

import com.bytedance.android.livesdkapi.model.SeiAppData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class c {
    public final String a;

    public static final class a extends c {
        public final int b;
        public final int c;
        public final String d;

        public /* synthetic */ a() {
            throw null;
        }

        public final String toString() {
            return "FollowServer(scene=" + this.b + ",uiLayout=" + this.c + ",reqFrom=" + this.a + ')';
        }

        public a(int r2, int r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "reqFrom");
            super(r4);
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }
    }

    public static final class b extends c {
        public final int b;
        public final int c;

        public final String toString() {
            return "Init(scene=" + this.b + ",uiLayout=" + this.c + ')';
        }

        public b(int r2, int r3) {
            super("Init");
            this.b = r2;
            this.c = r3;
        }
    }

    /* JADX INFO: renamed from: zj0.c$c, reason: collision with other inner class name */
    public static final class C0300c extends c {
        public final int b;
        public final int c;

        public final String toString() {
            return "InitOnFastMode(scene=" + this.b + ",uiLayout=" + this.c + ')';
        }

        public C0300c(int r2, int r3) {
            super("Init");
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class d extends c {
        public final int b;
        public final int c;

        public final String toString() {
            return "OrientationChange(scene=" + this.b + ",uiLayout=" + this.c + ')';
        }

        public d(int r2, int r3) {
            super("OrientationChange");
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class e extends c {
        public final SeiAppData b;
        public final int c;

        public final String toString() {
            return "SeiUpdate(ver=" + this.b.getVersion() + ",style=" + this.b.getStyle() + ",uiLayout=" + this.c + ')';
        }

        public e(SeiAppData r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "sei");
            super("SeiUpdate");
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class f extends c {
        public final int b;
        public final int c;

        public final String toString() {
            return "VoiceChatSwitchLayoutFailed(scene=" + this.b + ", uiLayout=" + this.c + ", reqFrom=" + this.a + ')';
        }

        public f(int r2) {
            super("switchLayoutFailed");
            this.b = 5;
            this.c = r2;
        }
    }

    public c(String r1) {
        this.a = r1;
    }
}
