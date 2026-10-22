package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new;

import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftPanelMonitorService;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class h {

    public static final class a extends h {
        public final int a;
        public final boolean b;

        public a(int r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b extends h {
        public final int a;
        public final int b;
        public final k c;

        public b(int r1, int r2, k r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c extends h {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }
    }

    public static final class d extends h {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }
    }

    public static final class e extends h {
        public final GiftPanelMonitorService.b a;

        public e(GiftPanelMonitorService.b r1) {
            this.a = r1;
        }
    }

    public static final class f extends h {
        public final List<w1> a;

        /* JADX WARN: Multi-variable type inference failed */
        public f(List<? extends w1> r2) {
            Intrinsics.checkNotNullParameter(r2, "giftPages");
            this.a = r2;
        }
    }

    public static final class g extends h {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.new.h$h, reason: collision with other inner class name */
    public static final class C0045h extends h {
        public final boolean a;
        public final int b;
        public final IntRange c;

        public C0045h(boolean r2, int r3, IntRange r4) {
            Intrinsics.checkNotNullParameter(r4, "currentRange");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class i extends h {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }
    }

    public h() {
    }

    public final String toString() {
        if ((this instanceof i) == false) goto L6;
        return "TouchDown";
    L6:
        if ((this instanceof g) == false) goto L9;
        return "OpenRecharge";
    L9:
        if ((this instanceof d) == false) goto L12;
        return "CreatePanel";
    L12:
        if ((this instanceof c) == false) goto L15;
        return "ClosePanel";
    L15:
        if ((this instanceof f) == false) goto L18;
        return "EnterRoom";
    L18:
        if ((this instanceof e) == false) goto L21;
        return "DefaultSelect{" + ((e) this).a + '}';
    L21:
        if ((this instanceof C0045h) == false) goto L24;
        StringBuilder r0 = new StringBuilder("ScrollList{firstDragging=");
        C0045h r2 = (C0045h) this;
        r0.append(r2.a);
        r0.append(", tab=");
        r0.append(r2.b);
        r0.append(", range=");
        r0.append(r2.c);
        r0.append('}');
        return r0.toString();
    L24:
        if ((this instanceof a) == false) goto L27;
        return "ChangeTab{" + ((a) this).a + '}';
    L27:
        if ((this instanceof b) == false) goto L31;
        StringBuilder r1 = new StringBuilder("ClickIcon{");
        b r3 = (b) this;
        r1.append(r3.b);
        r1.append('-');
        r1.append(r3.a);
        r1.append('}');
        return r1.toString();
    L31:
        throw new NoWhenBranchMatchedException();
    }
}
