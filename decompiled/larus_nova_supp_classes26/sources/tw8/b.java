package tw8;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ReplacementSpan;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.bmhome.share.panel.ShareType;
import io.noties.markwon.core.spans.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import usc.d;
import usc.e;
import usc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b extends ReplacementSpan implements e {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final int f;
    public final int g;
    public int h;
    public final com.larus.business.markdown.api.depend.a i;
    public Map<String, ? extends Object> j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public boolean n;
    public TextView o;
    public Spanned p;
    public f q;
    public Size r;

    public static final class a {
    }

    static {
    }

    public b() {
        throw null;
    }

    public final void j() {
        this.n = true;
    }

    public final boolean o() {
        if (Intrinsics.areEqual(this.a, "mixed_media_card") == true) goto L9;
        if (Intrinsics.areEqual(this.a, "creation") == true) goto L9;
        if (Intrinsics.areEqual(this.a, "vlm_mixed_media_card") == true) goto L9;
    L11:
        return false;
    L9:
        if (this.k == false) goto L11;
        return true;
    }

    public final String getDataType() {
        return this.a;
    }

    public final String h() {
        return this.b;
    }

    public final String i() {
        return this.e;
    }

    public final String k() {
        return this.c;
    }

    public final String l() {
        return this.d;
    }

    public final void a(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        r2.getText();
    }

    public final void c(TextView r4) {
        Intrinsics.checkNotNullParameter(r4, "textView");
        f r5 = this.q;
        if (r5 == null) goto L12;
        View r6 = r5.asView();
        if (r6 == null) goto L12;
        ViewParent r1 = r6.getParent();
        if ((r1 instanceof ViewGroup) == false) goto L9;
        ViewGroup r2 = (ViewGroup) r1;
    L10:
        if (r2 == null) goto L12;
        r2.removeView(r6);
        goto L12
    L9:
        r2 = null;
    L12:
        this.o = null;
    }

    public final void f(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        f r3 = this.q;
        if (r3 == null) goto L6;
        r3.f();
        return;
    }

    public final int n(Spanned r3) {
        if (o() == false) goto L13;
        int r4 = this.h;
        TextView r0 = this.o;
        int r1 = 0;
        if (r0 == null) goto L7;
        int r2 = r0.getPaddingStart();
    L8:
        int r5 = r4 + r2;
        TextView r6 = this.o;
        if (r6 == null) goto L17;
        r1 = r6.getPaddingEnd();
    L17:
        return r5 + r1;
    L7:
        r2 = 0;
        goto L8
    L13:
        if (this.k == false) goto L16;
        return this.h;
    L16:
        return this.h - gw8.e.a(r3, this.f);
    }

    public final void d(TextView r22, Spanned r23) {
        Intrinsics.checkNotNullParameter(r22, "textView");
        Intrinsics.checkNotNullParameter(r23, ShareType.TEXT);
        this.o = r22;
        this.p = r23;
        Object r0 = r22.getTag(2131388543);
        Object r9 = null;
        ViewGroup r10 = null;
        if ((r0 instanceof Integer) == false) goto L5;
        Integer r1 = (Integer) r0;
    L7:
        if (r1 == null) goto L29;
        int r2 = r1.intValue();
        Object r3 = r22.getTag(2131388544);
        if ((r3 instanceof Integer) == false) goto L11;
        Integer r4 = (Integer) r3;
    L12:
        if (r4 == null) goto L29;
        int r5 = r4.intValue();
        Object r6 = r22.getTag(2131388542);
        if ((r6 instanceof Integer) == false) goto L16;
        Integer r7 = (Integer) r6;
    L17:
        if (r7 == null) goto L29;
        int r8 = r7.intValue();
        Object r11 = r22.getTag(2131388541);
        if ((r11 instanceof Integer) == false) goto L21;
        Integer r12 = (Integer) r11;
    L22:
        if (r12 == null) goto L29;
        int r13 = r12.intValue();
        if (Intrinsics.areEqual(this.e, "data-block-full") == false) goto L27;
        this.h += r2 + r8;
        r22.setPadding(0, 0, 0, 0);
        goto L29
    L27:
        if (r22.getPaddingStart() != 0) goto L29;
        r22.setPadding(r2, r5, r8, r13);
        goto L29
    L21:
        r12 = null;
        goto L22
    L16:
        r7 = null;
        goto L17
    L11:
        r4 = null;
    L29:
        String r14 = this.a;
        Intrinsics.checkNotNullParameter(r14, "dataType");
        if (Intrinsics.areEqual(r14, "lynx") == false) goto L32;
    L35:
        boolean r15 = true;
    L37:
        if (r15 == false) goto L39;
    L44:
        boolean r16 = true;
    L46:
        if (r16 == false) goto L123;
        ViewParent r17 = r22.getParent();
        if ((r17 instanceof FrameLayout) == false) goto L50;
        FrameLayout r18 = (FrameLayout) r17;
    L52:
        if ((r22 instanceof ow8.a) == false) goto L122;
        if (r18 == null) goto L122;
        if (Intrinsics.areEqual(this.a, "search_reference") == false) goto L65;
        int r19 = StringsKt.indexOf$default(this.c, "_", 0, false, 6, null);
        if (r19 != (-1)) goto L60;
        String r20 = this.c;
    L66:
        String r110 = r20;
        int r21 = d.a;
        int r24 = this.f;
        int r25 = this.g;
        String r26 = this.a;
        String r27 = this.b;
        String r111 = this.e;
        Object r112 = r18.getTag(2131379631);
        if (TypeIntrinsics.isMutableList(r112) == true) goto L69;
        r112 = null;
    L69:
        List r113 = (List) r112;
        if (r113 == null) goto L95;
        Iterator r114 = r113.iterator();
    L73:
        if (r114.hasNext() == false) goto L91;
        Object r115 = r114.next();
        usc.b r28 = (usc.b) r115;
        if (r28.a == r24) goto L77;
    L87:
        boolean r29 = false;
    L88:
        if (r29 == false) goto L73;
    L92:
        usc.b r30 = (usc.b) r115;
        if (r30 == null) goto L95;
        f r116 = r30.g;
    L97:
        if (r116 == null) goto L112;
        Size r31 = r116.d(r22, r23, this, n(r23), this.j);
        this.r = r31;
        r31.getWidth();
        this.r.getHeight();
        r22.getText();
        this.q = r116;
        View r32 = r116.asView();
        ViewGroup.LayoutParams r33 = r32.getLayoutParams();
        if (r33.width == this.r.getWidth()) goto L101;
    L102:
        ViewGroup.LayoutParams r34 = r32.getLayoutParams();
        if (r34 == null) goto L111;
        r34.width = this.r.getWidth();
        r34.height = -2;
        r32.setLayoutParams(r34);
    L105:
        ViewParent r35 = r32.getParent();
        if ((r35 instanceof ViewGroup) == false) goto L108;
        r10 = (ViewGroup) r35;
    L108:
        if (r10 == null) goto L121;
        r10.removeView(r32);
    L121:
        r18.addView(r32);
        return;
    L111:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L101:
        if (r33.height == this.r.getHeight()) goto L105;
    L112:
        f r117 = this.i.b(r18, r22, r23, this, this.j);
        Size r36 = r117.d(r22, r23, this, n(r23), this.j);
        this.r = r36;
        r36.getWidth();
        this.r.getHeight();
        r22.getText();
        r32 = r117.asView();
        r32.setLayoutParams(new FrameLayout.LayoutParams(this.r.getWidth(), -2));
        r32.setVisibility(4);
        this.q = r117;
        int r37 = d.a;
        int r38 = this.f;
        int r39 = this.g;
        String r40 = this.a;
        String r41 = this.b;
        String r42 = this.e;
        Object r43 = r18.getTag(2131379631);
        if (TypeIntrinsics.isMutableList(r43) == false) goto L116;
        r9 = r43;
    L116:
        List r44 = (List) r9;
        if (r44 != null) goto L120;
        r44 = new ArrayList();
    L120:
        r44.add(new usc.b(r38, r39, r40, r41, r110, r42, r117));
        r18.setTag(2131379631, r44);
        goto L121
    L77:
        if (r28.b != r25) goto L87;
        if (Intrinsics.areEqual(r28.c, r26) == false) goto L87;
        if (Intrinsics.areEqual(r28.d, r27) == false) goto L87;
        if (Intrinsics.areEqual(r28.e, r110) == false) goto L87;
        if (Intrinsics.areEqual(r28.f, r111) == false) goto L87;
        r29 = true;
        goto L88
    L91:
        r115 = null;
    L95:
        r116 = null;
        goto L97
    L60:
        StringBuilder r45 = new StringBuilder();
        String r46 = this.c;
        int r47 = r19 + 1;
        if (r46 == null) goto L64;
        r45.append(r46.substring(0, r47));
        r45.append(this.f);
        r20 = r45.toString();
        goto L66
    L64:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L65:
        r20 = this.c;
    L122:
        this.q = null;
        return;
    L50:
        r18 = null;
        goto L52
    L123:
        ViewParent r48 = r22.getParent();
        if ((r48 instanceof FrameLayout) == false) goto L126;
        FrameLayout r118 = (FrameLayout) r48;
    L128:
        if ((r22 instanceof ow8.a) == false) goto L171;
        if (r118 == null) goto L171;
        int r49 = this.f;
        int r50 = this.g;
        String r51 = this.a;
        String r52 = this.b;
        String r53 = this.c;
        Object r119 = r118.getTag(2131379632);
        if (TypeIntrinsics.isMutableList(r119) == true) goto L134;
        r119 = null;
    L134:
        List r120 = (List) r119;
        if (r120 == null) goto L158;
        Iterator r121 = r120.iterator();
    L138:
        if (r121.hasNext() == false) goto L154;
        Object r122 = r121.next();
        usc.b r54 = (usc.b) r122;
        if (r54.a == r49) goto L142;
    L150:
        boolean r55 = false;
    L151:
        if (r55 == false) goto L138;
    L155:
        usc.b r123 = (usc.b) r122;
        if (r123 == null) goto L158;
        r120.remove(r123);
        r118.setTag(2131379632, r120);
        f r56 = r123.g;
    L159:
        if (r56 == null) goto L169;
        Size r57 = r56.d(r22, r23, this, n(r23), this.j);
        this.r = r57;
        r57.getWidth();
        this.r.getHeight();
        r22.getText();
        this.q = r56;
        View r58 = r56.asView();
        ViewGroup.LayoutParams r59 = r58.getLayoutParams();
        if (r59.width == this.r.getWidth()) goto L163;
    L164:
        ViewGroup.LayoutParams r60 = r58.getLayoutParams();
        if (r60 == null) goto L168;
        r60.width = this.r.getWidth();
        r60.height = this.r.getHeight();
        r58.setLayoutParams(r60);
    L170:
        r118.addView(r58);
        return;
    L168:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L163:
        if (r59.height == this.r.getHeight()) goto L170;
    L169:
        f r61 = this.i.b(r118, r22, r23, this, this.j);
        Size r62 = r61.d(r22, r23, this, n(r23), this.j);
        this.r = r62;
        r62.getWidth();
        this.r.getHeight();
        r22.getText();
        r58 = r61.asView();
        r58.setLayoutParams(new FrameLayout.LayoutParams(this.r.getWidth(), this.r.getHeight()));
        r58.setVisibility(4);
        this.q = r61;
        goto L170
    L142:
        if (r54.b != r50) goto L150;
        if (Intrinsics.areEqual(r54.c, r51) == false) goto L150;
        if (Intrinsics.areEqual(r54.d, r52) == false) goto L150;
        if (Intrinsics.areEqual(r54.e, r53) == false) goto L150;
        r55 = true;
        goto L151
    L154:
        r122 = null;
    L158:
        r56 = null;
    L171:
        this.q = null;
        return;
    L126:
        r118 = null;
        goto L128
    L39:
        if (Intrinsics.areEqual(this.a, "applet") == true) goto L44;
        if (Intrinsics.areEqual(this.a, "search_reference") == true) goto L44;
        r16 = false;
        goto L46
    L32:
        if (Intrinsics.areEqual(r14, "lynx_ruyi") == true) goto L35;
        r15 = false;
        goto L37
    L5:
        r1 = null;
        goto L7
    }

    public final void g(TextView r3, Spanned r4) {
        Intrinsics.checkNotNullParameter(r3, "textView");
        Intrinsics.checkNotNullParameter(r4, ShareType.TEXT);
        f r5 = this.q;
        if (r5 != null) goto L5;
        return;
    L5:
        Size r6 = r5.c(r3, this, this.j);
        if (r6 != null) goto L8;
        return;
    L8:
        this.r = r6;
        View r7 = r5.asView();
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if (r8 != null) goto L12;
        return;
    L12:
        if (r8.width == this.r.getWidth()) goto L14;
    L15:
        ViewGroup.LayoutParams r9 = r7.getLayoutParams();
        if (r9 == null) goto L20;
        r9.width = this.r.getWidth();
        r9.height = this.r.getHeight();
        r7.setLayoutParams(r9);
        return;
    L20:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L14:
        if (r8.height != this.r.getHeight()) goto L15;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        Intrinsics.checkNotNullParameter(r1, "paint");
        int r6 = 0;
        if (r2 != null) goto L5;
    L7:
        boolean r7 = false;
    L8:
        if (r7 == false) goto L10;
        int r8 = this.r.getHeight();
    L15:
        if (this.l == false) goto L19;
        f r9 = this.q;
        if (r9 == null) goto L19;
        r9.e();
    L19:
        if (r5 == null) goto L21;
        int r10 = -r8;
        r5.ascent = r10;
        r5.descent = 0;
        r5.top = r10;
        r5.bottom = 0;
    L21:
        this.r.getWidth();
        int r11 = this.h;
        Spanned r12 = this.p;
        if (r12 == null) goto L25;
        r6 = gw8.e.a(r12, this.f);
    L25:
        return Math.min(r11 - r6, this.r.getWidth());
    L10:
        TextView r13 = this.o;
        if (r13 == null) goto L13;
        r8 = (int) ((this.r.getHeight() - r13.getLineSpacingExtra()) / r13.getLineSpacingMultiplier());
        goto L15
    L13:
        r8 = this.r.getHeight();
        goto L15
    L5:
        if (r2.length() != r4) goto L7;
        r7 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r13, final CharSequence r14, final int r15, int r16, float r17, int r18, int r19, int r20, Paint r21) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        Intrinsics.checkNotNullParameter(r21, "paint");
        TextView r4 = this.o;
        if (r4 != null) goto L5;
        return;
    L5:
        f r5 = this.q;
        if (r5 != null) goto L8;
        return;
    L8:
        final View r6 = r5.asView();
        if ((r14 instanceof SpannableString) == false) goto L11;
        SpannableString r7 = (SpannableString) r14;
    L12:
        if (r7 == null) goto L17;
        o[] r8 = (o[]) r7.getSpans(r15, r16, o.class);
        if (r8 == null) goto L17;
        o r9 = (o) ArraysKt.firstOrNull(r8);
    L18:
        if (r9 == null) goto L20;
        float r10 = r9.getAlpha();
    L21:
        r6.setAlpha(r10 / 255);
        final Ref.IntRef r11 = new Ref.IntRef();
        r11.element = (r18 + r4.getTop()) + r4.getPaddingTop();
        if (o() == false) goto L25;
        int r12 = r4.getLeft();
    L29:
        r5.a();
        Integer r1 = r5.b(this.r, r4, r13, r21);
        if (r1 == null) goto L32;
        r12 = r12 + r1.intValue();
    L32:
        ViewGroup.LayoutParams r2 = r6.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L35;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
    L37:
        if ((r6 instanceof nw8.a) == false) goto L39;
        ((nw8.a) r6).k(Integer.valueOf(r12), Integer.valueOf(r11.element), null, null);
        return;
    L39:
        if (r3 == null) goto L50;
        if (r3.topMargin == r11.element) goto L43;
    L44:
        ViewGroup.LayoutParams r22 = r6.getLayoutParams();
        if (r22 == null) goto L48;
        ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) r22;
        r23.topMargin = r11.element;
        r23.leftMargin = r12;
        r6.setLayoutParams(r23);
        r6.setVisibility(4);
        r6.post(new tw8.a(this, r11, r14, r15, r6));
        return;
    L48:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L43:
        if (r3.leftMargin != r12) goto L44;
    L50:
        if (r6.getVisibility() == 0) goto L53;
        r6.setVisibility(0);
        return;
    L53:
        return;
    L35:
        r3 = null;
        goto L37
    L25:
        if (this.k == false) goto L28;
        int r24 = r4.getLeft();
        int r110 = r4.getPaddingLeft();
    L27:
        r12 = r24 + r110;
        goto L29
    L28:
        r24 = ((int) r17) + r4.getLeft();
        r110 = r4.getPaddingLeft();
        goto L27
    L20:
        r10 = 255.0f;
    L17:
        r9 = null;
        goto L18
    L11:
        r7 = null;
        goto L12
    }

    public b(String r2, String r3, String r4, String r5, String r6, int r7, int r8, int r9, com.larus.business.markdown.api.depend.a r10, Map r11, boolean r12, boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r2, "dataType");
        Intrinsics.checkNotNullParameter(r3, "dataValue");
        Intrinsics.checkNotNullParameter(r4, "dataValueId");
        Intrinsics.checkNotNullParameter(r6, "dataTag");
        Intrinsics.checkNotNullParameter(r10, "dataHandler");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
        this.m = r14;
        this.n = false;
        this.r = new Size(0, 0);
        new Rect();
    }
}
