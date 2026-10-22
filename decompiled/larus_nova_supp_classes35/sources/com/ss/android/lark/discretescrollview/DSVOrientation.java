package com.ss.android.lark.discretescrollview;

import android.graphics.Point;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract enum DSVOrientation extends Enum<DSVOrientation> {
    private static final /* synthetic */ DSVOrientation[] $VALUES = null;
    public static final DSVOrientation HORIZONTAL = null;
    public static final DSVOrientation VERTICAL = null;

    public interface a {
        int a(int r1, int r2);

        void b(Direction r1, int r2, Point r3);

        int c(int r1);

        float d(Point r1, float r2, float r3);

        int e(int r1);

        void f(int r1, com.ss.android.lark.discretescrollview.a r2);

        boolean g(Point r1, int r2, int r3, int r4, int r5);

        int h(int r1, int r2);

        boolean i();

        void j(Point r1, int r2, Point r3);

        int k(int r1, int r2);

        boolean l();

        boolean m(DiscreteScrollLayoutManager r1);
    }

    public static class b implements a {
        public b() {
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final int a(int r1, int r2) {
            return r1;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final int c(int r1) {
            return 0;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final int e(int r1) {
            return r1;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final int h(int r1, int r2) {
            return r1;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final boolean i() {
            return true;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final int k(int r1, int r2) {
            return r1;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final boolean l() {
            return false;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final boolean m(DiscreteScrollLayoutManager r8) {
            View r0 = r8.B.a.getChildAt(0);
            com.ss.android.lark.discretescrollview.a r2 = r8.B;
            View r3 = r2.a.getChildAt(r2.a() - 1);
            int r4 = -r8.f;
            int r5 = r8.getWidth() + r8.f;
            if (r8.getDecoratedLeft(r0) > r4) goto L5;
        L7:
            boolean r1 = false;
        L9:
            if (r8.getDecoratedRight(r3) < r5) goto L11;
        L13:
            boolean r9 = false;
        L14:
            if (r1 == true) goto L16;
            if (r9 == true) goto L16;
            return false;
        L16:
            return true;
        L11:
            if (r8.getPosition(r3) >= (r8.getItemCount() - 1)) goto L13;
            r9 = true;
            goto L14
        L5:
            if (r8.getPosition(r0) <= 0) goto L7;
            r1 = true;
            goto L9
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final void f(int r1, com.ss.android.lark.discretescrollview.a r2) {
            r2.a.offsetChildrenHorizontal(r1);
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final void b(Direction r2, int r3, Point r4) {
            r4.set(r4.x + r2.applyTo(r3), r4.y);
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final float d(Point r1, float r2, float r3) {
            return r2 - r1.x;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final void j(Point r2, int r3, Point r4) {
            r4.set(r2.x - r3, r2.y);
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final boolean g(Point r1, int r2, int r3, int r4, int r5) {
            int r6 = r1.x;
            int r7 = r6 - r2;
            int r8 = r6 + r2;
            if (r7 < (r4 + r5)) goto L5;
        L7:
            return false;
        L5:
            if (r8 <= (-r5)) goto L7;
            return true;
        }
    }

    public static class c implements a {
        public c() {
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final int a(int r1, int r2) {
            return r2;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final int c(int r1) {
            return r1;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final int e(int r1) {
            return 0;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final int h(int r1, int r2) {
            return r2;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final boolean i() {
            return false;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final int k(int r1, int r2) {
            return r2;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final boolean l() {
            return true;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final boolean m(DiscreteScrollLayoutManager r8) {
            View r0 = r8.B.a.getChildAt(0);
            com.ss.android.lark.discretescrollview.a r2 = r8.B;
            View r3 = r2.a.getChildAt(r2.a() - 1);
            int r4 = -r8.f;
            int r5 = r8.getHeight() + r8.f;
            if (r8.getDecoratedTop(r0) > r4) goto L5;
        L7:
            boolean r1 = false;
        L9:
            if (r8.getDecoratedBottom(r3) < r5) goto L11;
        L13:
            boolean r9 = false;
        L14:
            if (r1 == true) goto L16;
            if (r9 == true) goto L16;
            return false;
        L16:
            return true;
        L11:
            if (r8.getPosition(r3) >= (r8.getItemCount() - 1)) goto L13;
            r9 = true;
            goto L14
        L5:
            if (r8.getPosition(r0) <= 0) goto L7;
            r1 = true;
            goto L9
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final void f(int r1, com.ss.android.lark.discretescrollview.a r2) {
            r2.a.offsetChildrenVertical(r1);
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final void b(Direction r2, int r3, Point r4) {
            int r0 = r4.y + r2.applyTo(r3);
            r4.set(r4.x, r0);
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final float d(Point r1, float r2, float r3) {
            return r3 - r1.y;
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final void j(Point r2, int r3, Point r4) {
            int r0 = r2.y - r3;
            r4.set(r2.x, r0);
        }

        @Override // com.ss.android.lark.discretescrollview.DSVOrientation.a
        public final boolean g(Point r1, int r2, int r3, int r4, int r5) {
            int r6 = r1.y;
            int r7 = r6 - r3;
            int r8 = r6 + r3;
            if (r7 < (r4 + r5)) goto L5;
        L7:
            return false;
        L5:
            if (r8 <= (-r5)) goto L7;
            return true;
        }
    }

    public abstract a createHelper();

    static {
        final String r1 = "HORIZONTAL";
        final int r2 = 0;
        DSVOrientation r0 = new AnonymousClass1(r1, r2);
        HORIZONTAL = r0;
        final String r3 = "VERTICAL";
        final int r4 = 1;
        DSVOrientation r5 = new AnonymousClass2(r3, r4);
        VERTICAL = r5;
        $VALUES = new DSVOrientation[]{r0, r5};
    }

    public static DSVOrientation[] values() {
        return (DSVOrientation[]) $VALUES.clone();
    }

    public static DSVOrientation valueOf(String r1) {
        return (DSVOrientation) r27.a.a(DSVOrientation.class, r1);
    }

    private DSVOrientation(String r1, int r2) {
        super(r1, r2);
    }

    public /* synthetic */ DSVOrientation(String r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }
}
