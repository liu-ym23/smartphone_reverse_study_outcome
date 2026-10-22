package ufb;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.floating.enums.SidePattern;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements wfb.d {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public final Rect g;
    public final Rect h;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SidePattern.values().length];
            r0[SidePattern.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L37:
            r0[SidePattern.RESULT_LEFT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L55:
            r0[SidePattern.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L41:
            r0[SidePattern.RESULT_RIGHT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L45:
            r0[SidePattern.TOP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L22
        L31:
            r0[SidePattern.RESULT_TOP.ordinal()] = 6;     // Catch: NoSuchFieldError -> L23
        L47:
            r0[SidePattern.BOTTOM.ordinal()] = 7;     // Catch: NoSuchFieldError -> L24
        L49:
            r0[SidePattern.RESULT_BOTTOM.ordinal()] = 8;     // Catch: NoSuchFieldError -> L25
        L39:
            r0[SidePattern.DEFAULT.ordinal()] = 9;     // Catch: NoSuchFieldError -> L26
        L43:
            r0[SidePattern.AUTO_HORIZONTAL.ordinal()] = 10;     // Catch: NoSuchFieldError -> L27
        L33:
            r0[SidePattern.RESULT_HORIZONTAL.ordinal()] = 11;     // Catch: NoSuchFieldError -> L28
        L35:
            r0[SidePattern.AUTO_VERTICAL.ordinal()] = 12;     // Catch: NoSuchFieldError -> L29
        L53:
            r0[SidePattern.RESULT_VERTICAL.ordinal()] = 13;     // Catch: NoSuchFieldError -> L30
        L16:
            a = r0;
        }
    }

    public d() {
        this.g = new Rect();
        this.h = new Rect();
    }

    public final float b(View r3) {
        return (this.b + r3.getWidth()) + r3.getTranslationX();
    }

    @Override // wfb.d
    public final Animator a(View r6, ViewGroup r7, SidePattern r8) {
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "parentView");
        Intrinsics.checkNotNullParameter(r8, "sidePattern");
        r6.getGlobalVisibleRect(this.g);
        r7.getGlobalVisibleRect(this.h);
        Rect r9 = this.g;
        int r0 = r9.left;
        this.a = r0;
        Rect r1 = this.h;
        int r2 = r1.right - r9.right;
        this.b = r2;
        this.c = r9.top - r1.top;
        this.d = r1.bottom - r9.bottom;
        this.e = Math.min(r0, r2);
        this.f = Math.min(this.c, this.d);
        int r10 = a.a[r8.ordinal()];
        String r11 = "translationY";
        switch(r10) {
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L19;
            case 9: goto L14;
            case 10: goto L14;
            case 11: goto L14;
            case 12: goto L9;
            case 13: goto L9;
            default: goto L5;
        };
    L9:
        int r12 = this.c;
        int r3 = this.d;
        if (r12 >= r3) goto L13;
        float r13 = -(r12 + r6.getHeight());
        float r4 = r6.getTranslationY();
    L12:
        float r14 = r13 + r4;
    L31:
        if (Intrinsics.areEqual(r11, "translationX") == false) goto L33;
        float r5 = r6.getTranslationX();
    L34:
        Triple r15 = new Triple(r11, Float.valueOf(r14), Float.valueOf(r5));
        return ObjectAnimator.ofFloat(r6, (String) r15.component1(), new float[]{((Number) r15.component2()).floatValue(), ((Number) r15.component3()).floatValue()}).setDuration(500);
    L33:
        r5 = r6.getTranslationY();
        goto L34
    L13:
        r13 = r3 + r6.getHeight();
        r4 = r6.getTranslationY();
        goto L12
    L14:
        int r16 = this.a;
        if (r16 >= this.b) goto L18;
        float r17 = -(r16 + r6.getWidth());
        float r18 = r6.getTranslationX();
    L17:
        r14 = r17 + r18;
    L25:
        r11 = "translationX";
        goto L31
    L18:
        r14 = b(r6);
        goto L25
    L19:
        r14 = b(r6);
        goto L31
    L20:
        r13 = -(this.c + r6.getHeight());
        r4 = r6.getTranslationY();
        goto L12
    L21:
        r14 = b(r6);
        goto L25
    L22:
        r17 = -(this.a + r6.getWidth());
        r18 = r6.getTranslationX();
        goto L17
    L5:
        if (this.e > this.f) goto L26;
        int r19 = this.a;
        if (r19 < this.b) goto L23;
        r14 = b(r6);
        goto L25
    L23:
        r17 = -(r19 + r6.getWidth());
        r18 = r6.getTranslationX();
        goto L17
    L26:
        int r20 = this.c;
        int r21 = this.d;
        if (r20 >= r21) goto L29;
        r13 = -(r20 + r6.getHeight());
        r4 = r6.getTranslationY();
        goto L12
    L29:
        r13 = r21 + r6.getHeight();
        r4 = r6.getTranslationY();
        goto L12
    }
}
