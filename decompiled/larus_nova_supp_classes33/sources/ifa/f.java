package ifa;

import com.larus.im.bean.message.block.Block;
import com.obric.cae.libs.useraware.ApWakeEvent;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class f {
    public final int a;
    public final Block b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public int g;

    public static final class a {
    }

    public static final class b extends f {
        public b(Block r3) {
            Intrinsics.checkNotNullParameter(r3, "block");
            super(2, r3, 124);
        }
    }

    public static final class c extends f {
        public final List<String> h;
        public final boolean i;
        public final List<ifa.a> j;

        public c(Block r3, List<String> r4, boolean r5, List<ifa.a> r6) {
            Intrinsics.checkNotNullParameter(r3, "block");
            Intrinsics.checkNotNullParameter(r4, "additionTips");
            Intrinsics.checkNotNullParameter(r6, "attachments");
            super(0, r3, 124);
            this.h = r4;
            this.i = r5;
            this.j = r6;
        }
    }

    public static final class d extends f {
        public final ifa.b h;

        public d(Block r3, ifa.b r4) {
            Intrinsics.checkNotNullParameter(r3, "block");
            Intrinsics.checkNotNullParameter(r4, "fileResult");
            super(6, r3, ApWakeEvent.WALKING_START);
            this.h = r4;
        }
    }

    public static final class e extends f {
        public final List<ifa.c> h;
        public final List<ifa.c> i;

        /* JADX WARN: Multi-variable type inference failed */
        public e(Block r3, List<? extends ifa.c> r4, List<? extends ifa.c> r5) {
            Intrinsics.checkNotNullParameter(r3, "block");
            Intrinsics.checkNotNullParameter(r4, "mediaItems");
            Intrinsics.checkNotNullParameter(r5, "previewMediaItems");
            super(7, r3, ApWakeEvent.WALKING_START);
            this.h = r4;
            this.i = r5;
        }
    }

    /* JADX INFO: renamed from: ifa.f$f, reason: collision with other inner class name */
    public static final class C0060f extends f {
        public C0060f(Block r3) {
            Intrinsics.checkNotNullParameter(r3, "block");
            super(4, r3, 124);
        }
    }

    public static final class g extends f {
        public g(Block r3) {
            Intrinsics.checkNotNullParameter(r3, "block");
            super(8, r3, 124);
        }
    }

    public static final class h extends f {
        public h(Block r3) {
            Intrinsics.checkNotNullParameter(r3, "block");
            super(3, r3, 124);
        }
    }

    public static final class i extends f {
        public i(Block r3) {
            Intrinsics.checkNotNullParameter(r3, "block");
            super(5, r3, 124);
        }
    }

    public static final class j extends f {
        public j(Block r3) {
            Intrinsics.checkNotNullParameter(r3, "block");
            super(1, r3, 124);
        }
    }

    static {
    }

    public f(int r2, Block r3, int r4) {
        if ((r4 & 4) == 0) goto L5;
        boolean r5 = true;
    L6:
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = 0;
        return;
    L5:
        r5 = false;
        goto L6
    }
}
