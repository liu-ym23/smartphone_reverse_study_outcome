package com.bytedance.android.live.room.api.messagewindow.constraint;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class CardConstraint {
    public static final /* synthetic */ int h = 0;
    public Position a;
    public int b;
    public int c;
    public int d;
    public int e;
    public final int f;
    public final int g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/constraint/CardConstraint$Position;", "", "TopLeft", "TopRight", "BottomRight", "CenterRight", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Position extends Enum<Position> {
        public static final Position BottomRight = null;
        public static final Position CenterRight = null;
        public static final Position TopLeft = null;
        public static final Position TopRight = null;
        public static final /* synthetic */ Position[] a = null;

        static {
            Position r1 = new Position("TopLeft", 0);
            TopLeft = r1;
            Position r2 = new Position("TopRight", 1);
            TopRight = r2;
            Position r3 = new Position("BottomRight", 2);
            BottomRight = r3;
            Position r4 = new Position("CenterRight", 3);
            CenterRight = r4;
            a = new Position[]{r1, r2, r3, r4};
        }

        public static Position valueOf(String r1) {
            return (Position) r27.a.a(Position.class, r1);
        }

        public static Position[] values() {
            return (Position[]) a.clone();
        }

        public Position(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b {
        public Integer a;
        public Integer b;
        public Integer c;
        public Integer d;

        public b() {
        }
    }

    static {
    }

    public CardConstraint() {
        this(-2, -2);
    }

    public final int hashCode() {
        return (((((((((((this.f * 31) + this.g) * 31) + this.a.hashCode()) * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e;
    }

    public CardConstraint(CardConstraint r3) {
        Intrinsics.checkNotNullParameter(r3, "constraint");
        this(r3.f, r3.g);
        this.a = r3.a;
        this.b = r3.b;
        this.c = r3.c;
        this.d = r3.d;
        this.e = r3.e;
    }

    public final void a(Function1 r2) {
        Intrinsics.checkNotNullParameter(r2, "margin");
        b r0 = new b();
        r2.invoke(r0);
        Integer r3 = r0.a;
        if (r3 == null) goto L5;
        this.b = r3.intValue();
    L5:
        Integer r4 = r0.b;
        if (r4 == null) goto L8;
        this.c = r4.intValue();
    L8:
        Integer r5 = r0.c;
        if (r5 == null) goto L11;
        this.d = r5.intValue();
    L11:
        Integer r6 = r0.d;
        if (r6 == null) goto L15;
        this.e = r6.intValue();
        return;
    }

    public final void b(Position r2) {
        Intrinsics.checkNotNullParameter(r2, "position");
        this.a = r2;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if ((!Intrinsics.areEqual(CardConstraint.class, r2)) == false) goto L12;
        return false;
    L12:
        if (r5 == null) goto L36;
        CardConstraint r6 = (CardConstraint) r5;
        if (this.f == r6.f) goto L17;
        return false;
    L17:
        if (this.g == r6.g) goto L20;
        return false;
    L20:
        if (this.a == r6.a) goto L23;
        return false;
    L23:
        if (this.b == r6.b) goto L26;
        return false;
    L26:
        if (this.c == r6.c) goto L29;
        return false;
    L29:
        if (this.d == r6.d) goto L32;
        return false;
    L32:
        if (this.e == r6.e) goto L34;
        return false;
    L34:
        return true;
    L36:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.room.api.messagewindow.constraint.CardConstraint");
    L8:
        r2 = null;
        goto L10
    }

    public CardConstraint(int r1, int r2) {
        this.f = r1;
        this.g = r2;
        this.a = Position.BottomRight;
    }
}
