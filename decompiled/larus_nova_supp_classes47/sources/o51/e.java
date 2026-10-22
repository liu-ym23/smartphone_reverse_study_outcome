package o51;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.livesdk.link.model.IAnchorUpdateLayoutContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class e {
    public final o51.f a;
    public final String b;
    public final IAnchorUpdateLayoutContent.AnchorLayoutRange c;
    public final IAnchorUpdateLayoutContent.UpdateAnchorLayoutType d;

    public static final class a extends e {
        public a(o51.f r4) {
            Intrinsics.checkNotNullParameter(r4, "index");
            super(r4, "common", IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom, IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown);
        }

        @Override // o51.e
        public final boolean a(e r2) {
            Intrinsics.checkNotNullParameter(r2, "uiLayout");
            if ((r2 instanceof a) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.a.c != r2.a.c) goto L7;
            return true;
        }
    }

    public static final class b {
    }

    public static final class c extends e {
        public final String e;
        public final String f;

        @Override // o51.e
        public final boolean a(e r3) {
            Intrinsics.checkNotNullParameter(r3, "uiLayout");
            if ((r3 instanceof c) == true) goto L5;
        L9:
            return false;
        L5:
            if (Intrinsics.areEqual(((c) r3).e, this.e) == false) goto L9;
            if (r3.c != this.c) goto L9;
            return true;
        }

        public c(String r3, String r4, IAnchorUpdateLayoutContent.AnchorLayoutRange r5, IAnchorUpdateLayoutContent.UpdateAnchorLayoutType r6) {
            Intrinsics.checkNotNullParameter(r3, "enlargeUID");
            Intrinsics.checkNotNullParameter(r4, "enlargeLinkerID");
            Intrinsics.checkNotNullParameter(r5, "layoutRange");
            Intrinsics.checkNotNullParameter(r6, "updateType");
            super(o51.f.b.e, "focus", r5, r6);
            this.e = r3;
            this.f = r4;
        }
    }

    public static final class d extends e {
        public final String e;
        public final String f;

        @Override // o51.e
        public final boolean a(e r3) {
            Intrinsics.checkNotNullParameter(r3, "uiLayout");
            if ((r3 instanceof d) == true) goto L5;
        L9:
            return false;
        L5:
            if (Intrinsics.areEqual(((d) r3).e, this.e) == false) goto L9;
            if (r3.c != this.c) goto L9;
            return true;
        }

        public d(String r3, String r4, IAnchorUpdateLayoutContent.AnchorLayoutRange r5, IAnchorUpdateLayoutContent.UpdateAnchorLayoutType r6) {
            Intrinsics.checkNotNullParameter(r3, "fullUID");
            Intrinsics.checkNotNullParameter(r4, "fullLinkerID");
            Intrinsics.checkNotNullParameter(r5, "layoutRange");
            Intrinsics.checkNotNullParameter(r6, "updateType");
            super(o51.f.c.e, "full", r5, r6);
            this.e = r3;
            this.f = r4;
        }
    }

    /* JADX INFO: renamed from: o51.e$e, reason: collision with other inner class name */
    public static final class C0283e extends e {
        public final boolean e;
        public final String f;
        public final String g;

        @Override // o51.e
        public final boolean a(e r2) {
            Intrinsics.checkNotNullParameter(r2, "uiLayout");
            if ((r2 instanceof C0283e) == true) goto L5;
        L9:
            return false;
        L5:
            if (this.e != ((C0283e) r2).e) goto L9;
            String r3 = this.f;
            if (Intrinsics.areEqual(r3, r3) == false) goto L9;
            return true;
        }

        public C0283e(boolean r5, String r6, String r7) {
            Intrinsics.checkNotNullParameter(r6, "fullUID");
            Intrinsics.checkNotNullParameter(r7, "fullLinkerID");
            if (r5 == false) goto L5;
            o51.f r0 = o51.f.d.e;
        L6:
            if (r5 == false) goto L8;
            String r1 = "full_record";
        L9:
            super(r0, r1, IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom, IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown);
            this.e = r5;
            this.f = r6;
            this.g = r7;
            return;
        L8:
            r1 = "full_record_normal";
            goto L9
        L5:
            r0 = o51.f.e.e;
            goto L6
        }
    }

    public static final class f extends e {
        public static final f e = null;

        static {
            e = new f();
        }

        public f() {
            super(o51.f.j.e, DataType.Normal, IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom, IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown);
        }

        @Override // o51.e
        public final boolean a(e r2) {
            Intrinsics.checkNotNullParameter(r2, "uiLayout");
            return r2 instanceof f;
        }
    }

    public static final class g extends e {
        public static final g e = null;

        static {
            e = new g();
        }

        public g() {
            super(o51.f.k.e, "pk", IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom, IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown);
        }

        @Override // o51.e
        public final boolean a(e r2) {
            Intrinsics.checkNotNullParameter(r2, "uiLayout");
            return r2 instanceof g;
        }
    }

    public static final class h extends e {
        public final boolean e;
        public final long f;

        public h(boolean r5) {
            if (r5 == false) goto L4;
            o51.f r0 = o51.f.m.e;
        L5:
            if (r5 == false) goto L7;
            String r1 = "pkGameFull";
        L8:
            super(r0, r1, IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom, IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown);
            this.e = r5;
            this.f = 0;
            return;
        L7:
            r1 = "pkGame";
            goto L8
        L4:
            r0 = o51.f.l.e;
            goto L5
        }

        @Override // o51.e
        public final boolean a(e r3) {
            Intrinsics.checkNotNullParameter(r3, "uiLayout");
            if ((r3 instanceof h) == false) goto L9;
            h r4 = (h) r3;
            if (r4.e != this.e) goto L9;
            long r0 = r4.f;
            if (r0 != r0) goto L9;
            return true;
        L9:
            return false;
        }
    }

    public static final class i extends e {
        public final boolean e;
        public final boolean f;
        public final String g;
        public final String h;

        @Override // o51.e
        public final boolean a(e r3) {
            Intrinsics.checkNotNullParameter(r3, "uiLayout");
            if ((r3 instanceof i) == false) goto L9;
            i r4 = (i) r3;
            if (r4.e != this.e) goto L9;
            if (r4.f != this.f) goto L9;
            return true;
        L9:
            return false;
        }

        public i(boolean r5, boolean r6, String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, "selfUID");
            Intrinsics.checkNotNullParameter(r8, "guestUID");
            super(o51.f.n.e, "pkWithAudience", IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom, IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown);
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }
    }

    static {
    }

    public abstract boolean a(e r1);

    public e(o51.f r1, String r2, IAnchorUpdateLayoutContent.AnchorLayoutRange r3, IAnchorUpdateLayoutContent.UpdateAnchorLayoutType r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
