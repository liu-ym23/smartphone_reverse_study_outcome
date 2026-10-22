package ub0;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a {
    public final long a;

    /* JADX INFO: renamed from: ub0.a$a, reason: collision with other inner class name */
    public static final class C0284a extends a {
        public C0284a(long r1) {
            super(r1);
        }
    }

    public static final class b extends a {
        public final List<com.bytedance.component.lyric.model.b> b;
        public final int c;
        public final long d;

        public /* synthetic */ b(long r8, List r11, int r12) {
            this(r8, r11, r12, 0);
        }

        public b(long r2, List<com.bytedance.component.lyric.model.b> r4, int r5, long r6) {
            Intrinsics.checkNotNullParameter(r4, "lineInfoList");
            super(r2);
            this.b = r4;
            this.c = r5;
            this.d = r6;
        }
    }

    public final List<com.bytedance.component.lyric.model.b> a() {
        if ((this instanceof b) == true) goto L7;
        return null;
    L7:
        return ((b) this).b;
    }

    public final String toString() {
        return "LyricsChangeEvent(mId=" + this.a + ')';
    }

    public a(long r1) {
        this.a = r1;
    }

    public final boolean b(a r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if ((r6 instanceof b) == true) goto L5;
    L17:
        return false;
    L5:
        if ((this instanceof b) == false) goto L17;
        if (r6.a != this.a) goto L17;
        b r7 = (b) r6;
        b r1 = (b) this;
        if (r7.c != r1.c) goto L17;
        if ((!r7.b.isEmpty()) == false) goto L17;
        if ((!r1.b.isEmpty()) == false) goto L17;
        if (r7.b.size() != r1.b.size()) goto L17;
        return true;
    }
}
