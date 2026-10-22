package com.tencent.wcdb;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public final class CursorJoiner implements Iterable<Result>, Iterator<Result> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f15817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f f15818b;
    private boolean c;
    private Result d;
    private int[] e;
    private int[] f;
    private String[] g;

    /* JADX INFO: renamed from: com.tencent.wcdb.CursorJoiner$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f15819a = null;

        static {
            int[] r0 = new int[Result.values().length];
            f15819a = r0;
            r0[Result.BOTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f15819a[Result.LEFT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f15819a[Result.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final enum Result extends Enum<Result> {
        private static final /* synthetic */ Result[] $VALUES = null;
        public static final Result BOTH = null;
        public static final Result LEFT = null;
        public static final Result RIGHT = null;

        static {
            Result r0 = new Result("RIGHT", 0);
            RIGHT = r0;
            Result r1 = new Result("LEFT", 1);
            LEFT = r1;
            Result r3 = new Result("BOTH", 2);
            BOTH = r3;
            $VALUES = new Result[]{r0, r1, r3};
        }

        private Result(String r1, int r2) {
            super(r1, r2);
        }

        public static Result valueOf(String r2) {
            return (Result) ZeusTransformUtils.preCheckCast(Enum.valueOf(Result.class, r2), Result.class, "com.obric.memorydata.plugin");
        }

        public static Result[] values() {
            return (Result[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Result[].class, "com.obric.memorydata.plugin");
        }
    }

    private static int a(String... r6) {
        if ((r6.length % 2) != 0) goto L25;
        int r1 = 0;
    L6:
        if (r1 >= r6.length) goto L23;
        if (r6[r1] == null) goto L10;
        int r2 = r1 + 1;
        if (r6[r2] == null) goto L15;
        int r3 = r6[r1].compareTo(r6[r2]);
        if (r3 == 0) goto L22;
        if (r3 >= 0) goto L21;
        return -1;
    L21:
        return 1;
    L22:
        r1 = r1 + 2;
        goto L6
    L15:
        return 1;
    L10:
        if (r6[r1 + 1] == null) goto L22;
        return -1;
    L23:
        return 0;
    L25:
        throw new IllegalArgumentException("you must specify an even number of values");
    }

    private static void a(String[] r3, f r4, int[] r5, int r6) {
        f r7 = (f) ZeusTransformUtils.wrapperContextForParams(r4, f.class, "com.obric.memorydata.plugin");
        int r0 = 0;
    L4:
        if (r0 >= r5.length) goto L6;
        r3[(r0 * 2) + r6] = r7.getString(r5[r0]);
        r0 = r0 + 1;
        goto L4
    }

    private void b() {
        if (this.c == false) goto L17;
        int r0 = AnonymousClass1.f15819a[this.d.ordinal()];
        if (r0 != 1) goto L7;
        this.f15817a.moveToNext();
    L13:
        f r1 = this.f15818b;
    L14:
        r1.moveToNext();
    L15:
        this.c = false;
        return;
    L7:
        if (r0 != 2) goto L9;
        r1 = this.f15817a;
        goto L14
    L9:
        if (r0 == 3) goto L13;
    }

    public Result a() {
        if (hasNext() == false) goto L20;
        b();
        boolean r0 = !this.f15817a.isAfterLast();
        boolean r2 = !this.f15818b.isAfterLast();
        if (r0 == false) goto L13;
        if (r2 == false) goto L13;
        a(this.g, this.f15817a, this.e, 0);
        a(this.g, this.f15818b, this.f, 1);
        int r1 = a(this.g);
        if (r1 == (-1)) goto L14;
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L17;
    L15:
        Result r3 = Result.RIGHT;
    L16:
        this.d = r3;
    L17:
        this.c = true;
        return this.d;
    L12:
        r3 = Result.BOTH;
    L14:
        r3 = Result.LEFT;
    L13:
        if (r0 == false) goto L15;
    L20:
        throw new IllegalStateException("you must only call next() when hasNext() is true");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.c == false) goto L31;
        int r0 = AnonymousClass1.f15819a[this.d.ordinal()];
        if (r0 == 1) goto L25;
        if (r0 == 2) goto L19;
        if (r0 != 3) goto L17;
        if (this.f15817a.isAfterLast() == false) goto L15;
        if (this.f15818b.isLast() == false) goto L15;
        return false;
    L15:
        return true;
    L17:
        throw new IllegalStateException("bad value for mCompareResult, " + this.d);
    L19:
        if (this.f15817a.isLast() == false) goto L23;
        if (this.f15818b.isAfterLast() == false) goto L23;
        return false;
    L23:
        return true;
    L25:
        if (this.f15817a.isLast() == false) goto L29;
        if (this.f15818b.isLast() == false) goto L29;
        return false;
    L29:
        return true;
    L31:
        if (this.f15817a.isAfterLast() == false) goto L35;
        if (this.f15818b.isAfterLast() == false) goto L35;
        return false;
    L35:
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<Result> iterator() {
        return this;
    }

    @Override // java.util.Iterator
    public /* synthetic */ Result next() {
        return a();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("not implemented");
    }
}
