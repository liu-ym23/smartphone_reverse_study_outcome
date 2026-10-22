package com.ss.android.lark.chat.chatwindow.chat;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.h;
import com.ss.android.lark.chat.utils.p;
import com.ss.android.lark.utils.UIHelper;
import h18.e;
import y6b.g;
import y9c.d;
import zdc.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class WallpaperAdaptionTimeLineDecoration extends RecyclerView.ItemDecoration {
    public final boolean a;
    public final boolean b;
    public final Integer c;
    public b d;
    public final c<y6b.c<?>> e;
    public final a f;
    public final boolean g;

    public interface a {
        m2b.a a();
    }

    public static class b {
        public static final int A = 0;
        public static final int B = 0;
        public static final int C = 0;
        public static final int D = 0;
        public static final int E = 0;
        public static final int F = 0;
        public static final int G = 0;
        public static final int H = 0;
        public static final int I = 0;
        public static final int J = 0;
        public static final int K = 0;
        public static final int L = 0;
        public static final int M = 0;
        public static final int N = 0;
        public static final int O = 0;
        public static final int v = 0;
        public static final int w = 0;
        public static final int x = 0;
        public static final int y = 0;
        public static final int z = 0;
        public final Context a;
        public String b;
        public String c;
        public boolean d;
        public boolean e;
        public long f;
        public final String g;
        public g h;
        public int i;
        public final int j;
        public final TextPaint k;
        public final float l;
        public final float m;
        public final float n;
        public final int o;
        public final int p;
        public final int q;
        public final int r;
        public final int s;
        public final Rect t;
        public final SparseArray<Drawable> u;

        static {
            v = UIHelper.dp2px(1.0f);
            UIHelper.dp2px(0.5f);
            w = UIHelper.dp2px(0.6f);
            x = UIHelper.dp2px(4.0f);
            y = UIHelper.dp2px(6.0f);
            z = UIHelper.dp2px(8.0f);
            A = UIHelper.dp2px(9.0f);
            int r0 = UIHelper.dp2px(10.0f);
            int r1 = UIHelper.dp2px(15.0f);
            int r2 = UIHelper.dp2px(19.3f);
            int r3 = UIHelper.dp2px(20.0f);
            B = r0;
            C = r0;
            D = r0;
            E = r2;
            F = r1;
            G = r1;
            H = r0;
            I = r0;
            J = UIHelper.dp2px(14.0f);
            K = r3;
            L = 2131106622;
            M = 2131106616;
            N = 2131106622;
            O = 2131106616;
        }

        public final Drawable c(int r3) {
            Drawable r0 = this.u.get(r3);
            if (r0 != null) goto L6;
            Drawable r1 = d.e(this.a, r3);
            this.u.put(r3, r1);
            return r1;
        L6:
            return r0;
        }

        public final int d(boolean r7) {
            boolean r0 = this.d;
            if (r0 == true) goto L5;
        L8:
            if (r0 == false) goto L11;
            if (r7 == true) goto L11;
            int r8 = (C + ((int) (0 + (this.m + w)))) + 0;
        L13:
            if (this.e == false) goto L16;
            r8 = r8 + (B + ((int) (0 + (this.m + w))));
        L16:
            if (this.f != 0) goto L18;
            return r8;
        L18:
            return r8 + (((E + 0) + K) + H);
        L11:
            r8 = 0;
            goto L13
        L5:
            if (this.e == false) goto L8;
            if (r7 == true) goto L8;
            this.k.setTextSize(this.m);
            r8 = ((D + 0) + (J + A)) + 0;
            goto L16
        }

        public b(Context r5, int r6) {
            this.h = null;
            this.l = 14.0f;
            this.m = 14.0f;
            this.n = 20.0f;
            this.u = new SparseArray();
            this.a = r5;
            this.j = r6;
            TextPaint r7 = new TextPaint(1);
            this.k = r7;
            Resources r2 = d.getResources(r5);
            r7.density = WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()).density;
            r7.setTypeface(e.b(r5, 0));
            this.g = d.i(r5, 2131892018);
            this.o = d.c(r5, L);
            this.p = d.c(r5, M);
            this.q = d.c(r5, N);
            this.r = d.c(r5, O);
            this.s = p.c(r5);
            int r8 = (int) 14.0f;
            this.l = zz7.b.h(r5, r8);
            this.m = zz7.b.h(r5, r8);
            this.n = zz7.b.h(r5, (int) 20.0f);
            this.t = new Rect();
        }

        public final RectF b(Rect r4, int r5, int r6) {
            int r0 = r4.width();
            int r7 = r4.height();
            int r1 = z;
            int r8 = r5 - r1;
            int r2 = ((r1 * 2) + r0) + r8;
            int r3 = x;
            int r9 = (r6 - r3) - r7;
            return new RectF(new Rect(r8, r9, r2, ((r7 + r9) + (r3 * 2)) + UIUtils.dp2px(this.a, 1.0f)));
        }

        public final void a(Canvas r18, Paint r19, String r20, Drawable r21, Drawable r22) {
            this.t.setEmpty();
            Rect r6 = this.t;
            r19.getTextBounds(r20, 0, r20.length(), r6);
            int r7 = F;
            int r8 = this.i;
            int r9 = r6.height();
            int r10 = v;
            int r11 = r8 + ((r9 - r10) / 2);
            int r12 = (this.j + r6.width()) / 2;
            int r13 = I;
            int r14 = z;
            int r15 = (r12 + r13) + r14;
            int r16 = this.i + ((r6.height() - r10) / 2);
            int r17 = ((((this.j - r6.width()) / 2) - r7) - r13) - r14;
            int r110 = ((((this.j - r6.width()) / 2) - G) - r13) - r14;
            int r111 = (this.j - r6.width()) / 2;
            int r112 = this.i + r6.height();
            if (r21 == null) goto L5;
            r21.setBounds(r7, r11, r17 + r7, r11 + r10);
            r21.draw(r18);
        L5:
            if (r22 == null) goto L7;
            r22.setBounds(r15, r16, r110 + r15, r10 + r16);
            r22.draw(r18);
        L7:
            RectF r2 = b(r6, r111, r112);
            Paint r4 = new Paint();
            r4.setColor(d.c(this.a, 2131106576));
            float r5 = y;
            r18.drawRoundRect(r2, r5, r5, r4);
            r18.drawText(r20, r111, r112, r19);
            this.i += r6.height() + w;
        }
    }

    public final b h(ViewGroup r6, g r7) {
        b r0 = this.d;
        if (r0 != null) goto L5;
    L6:
        this.d = new b(r6.getContext(), r6.getMeasuredWidth());
    L7:
        b r8 = this.d;
        if (r8.h == r7) goto L15;
        if (r7 == null) goto L15;
        r8.d = r7.b;
        r8.e = r7.c;
        long r1 = r7.a;
        r8.f = r1;
        r8.b = r7.d;
        if (r1 == 0) goto L14;
        r8.c = r7.e;
    L14:
        r8.h = r7;
    L15:
        return r8;
    L5:
        if (r0.j == r6.getMeasuredWidth()) goto L7;
        goto L6
    }

    public WallpaperAdaptionTimeLineDecoration(com.ss.android.lark.chat.chatwindow.chat.a r2, v4b.e r3, h r4) {
        this.c = null;
        this.e = r2;
        this.f = r4;
        if (r3 == null) goto L6;
        this.a = r3.a;
        this.b = r3.b;
        this.c = r3.c;
        this.g = r3.d;
        return;
    }

    public final void onDrawOver(Canvas r17, RecyclerView r18, RecyclerView.State r19) {
        int r9 = r18.getChildCount();
        int r10 = 0;
        int r11 = 0;
    L3:
        if (r11 >= r9) goto L70;
        View r1 = r18.getChildAt(r11);
        int r2 = r18.getChildAdapterPosition(r1);
        if (r2 == (-1)) goto L69;
        if (r2 >= this.e.getItemCount()) goto L69;
        g r3 = ((y6b.c) this.e.getItem(r2)).S2;
        if (r3 == null) goto L69;
        int r4 = (int) (r1.getTranslationY() + 0.5f);
        r17.save();
        float r5 = r1.getTop();
        b r12 = h(r18, r3);
        r17.translate(0.0f, (r5 + r4) - r12.d(this.a));
        if (this.g == false) goto L18;
        a r6 = this.f;
        if (r6 == null) goto L18;
        m2b.a r7 = r6.a();
        if (r7 == null) goto L18;
        boolean r13 = r7.A8();
    L19:
        boolean r8 = this.a;
        boolean r14 = this.b;
        Integer r15 = this.c;
        r12.i = r10;
        boolean r16 = r12.d;
        if (r16 == true) goto L22;
    L30:
        if (r16 == false) goto L36;
        if (r8 == true) goto L36;
        TextPaint r20 = r12.k;
        if (TextUtils.isEmpty(r12.b) == true) goto L36;
        r20.setColor(r12.o);
        r20.setTextSize(r12.m);
        r12.i += b.C;
        int r110 = 76;
        r12.a(r17, r20, r12.b, r12.c(2131232633), r12.c(2131232631));
    L38:
        if (r12.e == false) goto L55;
        if (r14 == false) goto L50;
        TextPaint r21 = r12.k;
        if (TextUtils.isEmpty(r12.g) == true) goto L55;
        if (r15 == null) goto L45;
        int r22 = r15.intValue();
    L46:
        r21.setColor(r22);
        r21.setTextSize(r12.m);
        if (r13 == false) goto L49;
        r21.setAlpha(r110);
    L49:
        r12.i += b.B;
        r12.a(r17, r21, r12.g, null, null);
        goto L55
    L45:
        r22 = r12.p;
        goto L46
    L50:
        TextPaint r23 = r12.k;
        if (TextUtils.isEmpty(r12.g) == true) goto L55;
        r23.setColor(r12.p);
        r23.setTextSize(r12.m);
        r12.i += b.B;
        r12.a(r17, r23, r12.g, r12.c(2131232628), r12.c(2131232627));
    L55:
        if (r12.f == 0) goto L67;
        TextPaint r24 = r12.k;
        if (TextUtils.isEmpty(r12.c) == true) goto L67;
        if (r15 == null) goto L61;
        int r25 = r15.intValue();
    L62:
        r24.setColor(r25);
        r24.setTextSize(r12.l);
        if (r13 == false) goto L65;
        r24.setAlpha(r110);
    L65:
        int r26 = r12.i;
        int r27 = b.E;
        r12.i = r26 + r27;
        r12.t.setEmpty();
        Rect r28 = r12.t;
        String r29 = r12.c;
        r24.getTextBounds(r29, 0, r29.length(), r28);
        int r30 = (r12.j - r28.width()) / 2;
        int r31 = (r12.i + r28.height()) + ((r27 - r28.height()) / 2);
        RectF r32 = r12.b(r28, r30, r31);
        Paint r33 = new Paint();
        r33.setColor(d.c(r12.a, 2131106576));
        float r111 = b.y;
        r17.drawRoundRect(r32, r111, r111, r33);
        r17.drawText(r12.c, r30, r31, r24);
        r12.i = (int) (r12.i + r12.n);
        goto L67
    L61:
        r25 = r12.s;
    L67:
        r17.restore();
    L36:
        r110 = 76;
        goto L38
    L22:
        if (r12.e == false) goto L30;
        if (r8 == true) goto L30;
        if (r14 == true) goto L30;
        TextPaint r34 = r12.k;
        if (TextUtils.isEmpty(r12.b) == true) goto L29;
        r34.setColor(r12.q);
        r34.setTextSize(r12.m);
        r12.i += b.D;
        r12.t.setEmpty();
        Rect r35 = r12.t;
        String r36 = r12.b;
        r34.getTextBounds(r36, r10, r36.length(), r35);
        int r37 = b.F;
        int r38 = r12.i + r35.height();
        RectF r112 = r12.b(r35, r37, r38);
        Paint r39 = new Paint();
        r39.setColor(d.c(r12.a, 2131106576));
        float r113 = b.y;
        r17.drawRoundRect(r112, r113, r113, r39);
        r17.drawText(r12.b, r37, r38, r34);
        r34.setColor(r12.r);
        r12.t.setEmpty();
        Rect r40 = r12.t;
        String r41 = r12.g;
        r34.getTextBounds(r41, 0, r41.length(), r40);
        int r42 = (r12.j - b.G) - r40.width();
        int r43 = r12.i + r40.height();
        r17.drawRoundRect(r12.b(r40, r42, r43), r113, r113, r39);
        r17.drawText(r12.g, r42, r43, r34);
        int r44 = r12.i + (r35.height() + b.A);
        r12.i = r44;
        int r45 = r12.j;
        int r46 = b.v;
        Drawable r47 = r12.c(2131232626);
        r47.setBounds(0, r44, r45 + 0, r46 + r44);
        r47.draw(r17);
    L29:
        r110 = 76;
    L18:
        r13 = false;
    L69:
        r11 = r11 + 1;
        r10 = 0;
        goto L3
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        int r6 = r4.getChildAdapterPosition(r3);
        if (r6 != (-1)) goto L5;
    L10:
        r2.set(0, 0, 0, 0);
        return;
    L5:
        if (r6 >= this.e.getItemCount()) goto L10;
        g r7 = ((y6b.c) this.e.getItem(r6)).S2;
        if (r7 == null) goto L10;
        r2.set(0, h(r4, r7).d(this.a), 0, 0);
    }
}
