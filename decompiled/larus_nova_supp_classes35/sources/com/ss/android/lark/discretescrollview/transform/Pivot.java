package com.ss.android.lark.discretescrollview.transform;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class Pivot {
    public final int a;
    public final int b;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Axis {
    }

    public static abstract enum X extends Enum<X> {
        public static final X CENTER = null;
        public static final X LEFT = null;
        public static final X RIGHT = null;
        public static final /* synthetic */ X[] a = null;

        public X() {
            throw null;
        }

        public abstract Pivot create();

        static {
            final String r1 = "LEFT";
            final int r2 = 0;
            X r0 = new AnonymousClass1(r1, r2);
            LEFT = r0;
            final String r3 = "CENTER";
            final int r4 = 1;
            X r5 = new AnonymousClass2(r3, r4);
            CENTER = r5;
            final String r6 = "RIGHT";
            final int r7 = 2;
            X r8 = new AnonymousClass3(r6, r7);
            RIGHT = r8;
            a = new X[]{r0, r5, r8};
        }

        public static X[] values() {
            return (X[]) a.clone();
        }

        public static X valueOf(String r1) {
            return (X) r27.a.a(X.class, r1);
        }

        public X(String r1, int r2, a r3) {
            super(r1, r2);
        }
    }

    public static abstract enum Y extends Enum<Y> {
        public static final Y BOTTOM = null;
        public static final Y CENTER = null;
        public static final Y TOP = null;
        public static final /* synthetic */ Y[] a = null;

        public Y() {
            throw null;
        }

        public abstract Pivot create();

        static {
            final String r1 = "TOP";
            final int r2 = 0;
            Y r0 = new AnonymousClass1(r1, r2);
            TOP = r0;
            final String r3 = "CENTER";
            final int r4 = 1;
            Y r5 = new AnonymousClass2(r3, r4);
            CENTER = r5;
            final String r6 = "BOTTOM";
            final int r7 = 2;
            Y r8 = new AnonymousClass3(r6, r7);
            BOTTOM = r8;
            a = new Y[]{r0, r5, r8};
        }

        public static Y[] values() {
            return (Y[]) a.clone();
        }

        public static Y valueOf(String r1) {
            return (Y) r27.a.a(Y.class, r1);
        }

        public Y(String r1, int r2, a r3) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ class a {
    }

    public final void a(View r6) {
        int r0 = this.a;
        if (r0 != 0) goto L12;
        int r1 = this.b;
        if (r1 == (-2)) goto L9;
        if (r1 == (-1)) goto L8;
        r6.setPivotX(r1);
        return;
    L8:
        r6.setPivotX(r6.getWidth() * 0.5f);
        return;
    L9:
        r6.setPivotX(r6.getWidth());
        return;
    L12:
        if (r0 != 1) goto L22;
        int r2 = this.b;
        if (r2 == (-2)) goto L18;
        if (r2 == (-1)) goto L17;
        r6.setPivotY(r2);
        return;
    L17:
        r6.setPivotY(r6.getHeight() * 0.5f);
        return;
    L18:
        r6.setPivotY(r6.getHeight());
        return;
    }

    public Pivot(int r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
