package m9;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.obric.cae.R;

/* JADX INFO: loaded from: classes.dex */
public final class i extends android.support.v4.media.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f9313d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f9314e = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9315c;

    static {
        f9313d = new int[]{1};
        f9314e = new int[]{1, 0};
    }

    public i() {
        this.f9315c = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v4.media.a
    public final com.google.android.material.carousel.b p(b r28, View r29) {
        CarouselLayoutManager r8 = (CarouselLayoutManager) r28;
        float r10 = r8.f2327o;
        if (r8.M0() == false) goto L5;
        r10 = r8.f2326n;
    L5:
        RecyclerView.p r11 = (RecyclerView.p) r29.getLayoutParams();
        float r12 = ((ViewGroup.MarginLayoutParams) r11).topMargin + ((ViewGroup.MarginLayoutParams) r11).bottomMargin;
        float r13 = r29.getMeasuredHeight();
        if (r8.M0() == false) goto L8;
        r12 = ((ViewGroup.MarginLayoutParams) r11).leftMargin + ((ViewGroup.MarginLayoutParams) r11).rightMargin;
        r13 = r29.getMeasuredWidth();
    L8:
        float r14 = r12;
        float r15 = r29.getContext().getResources().getDimension(R.dimen.m3_carousel_small_item_size_min) + r14;
        float r16 = r29.getContext().getResources().getDimension(R.dimen.m3_carousel_small_item_size_max) + r14;
        float r17 = Math.min(r13 + r14, r10);
        float r18 = t2.b.o((r13 / 3.0f) + r14, r29.getContext().getResources().getDimension(R.dimen.m3_carousel_small_item_size_min) + r14, r29.getContext().getResources().getDimension(R.dimen.m3_carousel_small_item_size_max) + r14);
        float r19 = (r17 + r18) / 2.0f;
        int[] r20 = f9313d;
        boolean r110 = false;
        if (r10 >= (r15 * 2.0f)) goto L11;
        r20 = new int[]{0};
    L11:
        int[] r21 = f9314e;
        if (r8.C != 1) goto L21;
        int r22 = r20.length;
        int[] r23 = new int[r22];
        int r24 = 0;
    L15:
        if (r24 >= r22) goto L17;
        r23[r24] = r20[r24] * 2;
        r24 = r24 + 1;
        goto L15
    L17:
        int[] r25 = new int[2];
        int r26 = 0;
    L18:
        if (r26 >= 2) goto L20;
        r25[r26] = r21[r26] * 2;
        r26 = r26 + 1;
        goto L18
    L20:
        int[] r27 = r25;
        int[] r30 = r23;
    L22:
        int r31 = r27.length;
        int r32 = Integer.MIN_VALUE;
        int r33 = Integer.MIN_VALUE;
        int r34 = 0;
    L23:
        if (r34 >= r31) goto L28;
        int r35 = r27[r34];
        if (r35 <= r33) goto L27;
        r33 = r35;
    L27:
        r34 = r34 + 1;
        goto L23
    L28:
        float r36 = r10 - (r33 * r19);
        int r37 = r30.length;
        int r38 = 0;
    L29:
        if (r38 >= r37) goto L34;
        int r39 = r30[r38];
        if (r39 <= r32) goto L33;
        r32 = r39;
    L33:
        r38 = r38 + 1;
        goto L29
    L34:
        int r40 = (int) Math.max(1.0d, Math.floor((r36 - (r32 * r16)) / r17));
        int r41 = (int) Math.ceil(r10 / r17);
        int r42 = (r41 - r40) + 1;
        int[] r43 = new int[r42];
        int r44 = 0;
    L35:
        if (r44 >= r42) goto L37;
        r43[r44] = r41 - r44;
        r44 = r44 + 1;
        goto L35
    L37:
        a r45 = a.a(r10, r18, r15, r16, r30, r19, r27, r17, r43);
        this.f9315c = (r45.f9302c + r45.f9303d) + r45.f9306g;
        int r46 = ((RecyclerView.o) r28).A();
        int r47 = r45.f9302c;
        int r48 = r45.f9303d;
        int r49 = r45.f9306g;
        int r50 = ((r47 + r48) + r49) - r46;
        if (r50 <= 0) goto L42;
        if (r47 > 0) goto L41;
        if (r48 <= 1) goto L42;
    L41:
        r110 = true;
    L42:
        if (r50 <= 0) goto L50;
        int r51 = r45.f9302c;
        if (r51 <= 0) goto L46;
        r45.f9302c = r51 - 1;
    L49:
        r50 = r50 - 1;
        goto L42
    L46:
        int r52 = r45.f9303d;
        if (r52 <= 1) goto L49;
        r45.f9303d = r52 - 1;
        goto L49
    L50:
        if (r110 == false) goto L52;
        r45 = a.a(r10, r18, r15, r16, new int[]{r45.f9302c}, r19, new int[]{r45.f9303d}, r17, new int[]{r49});
    L52:
        Context r53 = r29.getContext();
        if (r8.C != 1) goto L68;
        float r54 = Math.min(r53.getResources().getDimension(R.dimen.m3_carousel_gone_size) + r14, r45.f9305f);
        float r55 = r54 / 2.0f;
        float r56 = 0.0f - r55;
        float r57 = com.google.android.material.carousel.a.b(0.0f, r45.f9301b, r45.f9302c);
        float r58 = com.google.android.material.carousel.a.c(0.0f, com.google.android.material.carousel.a.a(r57, r45.f9301b, (int) Math.floor(r45.f9302c / 2.0f)), r45.f9301b, r45.f9302c);
        float r111 = com.google.android.material.carousel.a.b(r58, r45.f9304e, r45.f9303d);
        float r59 = com.google.android.material.carousel.a.c(r58, com.google.android.material.carousel.a.a(r111, r45.f9304e, (int) Math.floor(r45.f9303d / 2.0f)), r45.f9304e, r45.f9303d);
        float r60 = r45.f9305f;
        int r61 = r45.f9306g;
        float r112 = com.google.android.material.carousel.a.b(r59, r60, r61);
        float r62 = com.google.android.material.carousel.a.c(r59, com.google.android.material.carousel.a.a(r112, r45.f9305f, r61), r45.f9305f, r61);
        float r113 = com.google.android.material.carousel.a.b(r62, r45.f9304e, r45.f9303d);
        float r63 = com.google.android.material.carousel.a.b(com.google.android.material.carousel.a.c(r62, com.google.android.material.carousel.a.a(r113, r45.f9304e, (int) Math.ceil(r45.f9303d / 2.0f)), r45.f9304e, r45.f9303d), r45.f9301b, r45.f9302c);
        float r64 = r55 + r10;
        float r114 = android.support.v4.media.a.h(r54, r45.f9305f, r14);
        float r115 = android.support.v4.media.a.h(r45.f9301b, r45.f9305f, r14);
        float r116 = android.support.v4.media.a.h(r45.f9304e, r45.f9305f, r14);
        com.google.android.material.carousel.b.a r117 = new com.google.android.material.carousel.b.a(r45.f9305f, r10);
        r117.a(r56, r114, r54, false, true);
        int r65 = r45.f9302c;
        if (r65 <= 0) goto L58;
        r117.c(r57, r115, r45.f9301b, (int) Math.floor(r65 / 2.0f), false);
    L58:
        int r66 = r45.f9303d;
        if (r66 <= 0) goto L61;
        r117.c(r111, r116, r45.f9304e, (int) Math.floor(r66 / 2.0f), false);
    L61:
        r117.c(r112, 0.0f, r45.f9305f, r45.f9306g, true);
        int r67 = r45.f9303d;
        if (r67 <= 0) goto L64;
        r117.c(r113, r116, r45.f9304e, (int) Math.ceil(r67 / 2.0f), false);
    L64:
        int r68 = r45.f9302c;
        if (r68 <= 0) goto L67;
        r117.c(r63, r115, r45.f9301b, (int) Math.ceil(r68 / 2.0f), false);
    L67:
        r117.a(r64, r114, r54, false, true);
        return r117.d();
    L68:
        float r69 = Math.min(r53.getResources().getDimension(R.dimen.m3_carousel_gone_size) + r14, r45.f9305f);
        float r70 = r69 / 2.0f;
        float r118 = 0.0f - r70;
        float r71 = r45.f9305f;
        int r72 = r45.f9306g;
        float r73 = com.google.android.material.carousel.a.b(0.0f, r71, r72);
        float r74 = com.google.android.material.carousel.a.c(0.0f, com.google.android.material.carousel.a.a(r73, r45.f9305f, r72), r45.f9305f, r72);
        float r75 = com.google.android.material.carousel.a.b(r74, r45.f9304e, r45.f9303d);
        float r76 = com.google.android.material.carousel.a.b(com.google.android.material.carousel.a.c(r74, r75, r45.f9304e, r45.f9303d), r45.f9301b, r45.f9302c);
        float r77 = r70 + r10;
        float r78 = android.support.v4.media.a.h(r69, r45.f9305f, r14);
        float r119 = android.support.v4.media.a.h(r45.f9301b, r45.f9305f, r14);
        float r79 = android.support.v4.media.a.h(r45.f9304e, r45.f9305f, r14);
        com.google.android.material.carousel.b.a r120 = new com.google.android.material.carousel.b.a(r45.f9305f, r10);
        r120.a(r118, r78, r69, false, true);
        r120.c(r73, 0.0f, r45.f9305f, r45.f9306g, true);
        if (r45.f9303d <= 0) goto L71;
        r120.a(r75, r79, r45.f9304e, false, false);
    L71:
        int r121 = r45.f9302c;
        if (r121 <= 0) goto L74;
        r120.c(r76, r119, r45.f9301b, r121, false);
    L74:
        r120.a(r77, r78, r69, false, true);
        return r120.d();
    L21:
        r30 = r20;
        r27 = r21;
        goto L22
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v4.media.a
    public final boolean y(b r8, int r10) {
        if (r10 >= this.f9315c) goto L7;
        if (((RecyclerView.o) r8).A() < this.f9315c) goto L7;
    L10:
        return true;
    L7:
        if (r10 >= this.f9315c) goto L9;
    L11:
        return false;
    L9:
        if (((RecyclerView.o) r8).A() >= this.f9315c) goto L11;
        goto L10
    }
}
