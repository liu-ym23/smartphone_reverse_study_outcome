package com.ss.android.lark.discretescrollview;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
abstract enum Direction extends Enum<Direction> {
    public static final Direction END = null;
    public static final Direction START = null;
    public static final /* synthetic */ Direction[] a = null;

    public Direction() {
        throw null;
    }

    public abstract int applyTo(int r1);

    public abstract Direction reverse();

    public abstract boolean sameAs(int r1);

    static {
        final String r1 = "START";
        final int r2 = 0;
        Direction r0 = new AnonymousClass1(r1, r2);
        START = r0;
        final String r3 = "END";
        final int r4 = 1;
        Direction r5 = new AnonymousClass2(r3, r4);
        END = r5;
        a = new Direction[]{r0, r5};
    }

    public static Direction[] values() {
        return (Direction[]) a.clone();
    }

    public static Direction fromDelta(int r0) {
        if (r0 <= 0) goto L5;
        return END;
    L5:
        return START;
    }

    public static Direction valueOf(String r1) {
        return (Direction) r27.a.a(Direction.class, r1);
    }

    public Direction(String r1, int r2, AnonymousClass1 r3) {
        super(r1, r2);
    }
}
