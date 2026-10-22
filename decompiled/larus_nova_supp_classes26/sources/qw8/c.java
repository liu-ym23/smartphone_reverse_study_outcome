package qw8;

import android.graphics.Canvas;
import android.graphics.Paint;
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
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import gw8.e;
import io.noties.markwon.core.spans.o;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import lw8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c extends ReplacementSpan implements jw8.b {
    public final Map<String, Object> a;
    public final String b;
    public final String c;
    public final Integer d;
    public final Integer e;
    public final int f;
    public final jw8.a g;
    public final boolean h;
    public TextView i;
    public Size j;
    public jw8.c k;

    public static final class a {
    }

    static {
    }

    @Override // jw8.b
    public final void m(Spanned r2, jw8.b r3) {
        Intrinsics.checkNotNullParameter(r2, ShareType.TEXT);
        Intrinsics.checkNotNullParameter(r3, "span");
    }

    @Override // jw8.b
    public final String getCode() {
        return this.b;
    }

    @Override // jw8.b
    public final Integer getEndIndex() {
        return this.e;
    }

    @Override // jw8.b
    public final String getLanguage() {
        return this.c;
    }

    @Override // jw8.b
    public final Integer getStartIndex() {
        return this.d;
    }

    @Override // jw8.b
    public final void a(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        n(r2.getText());
    }

    public final void f(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        jw8.c r3 = this.k;
        if (r3 == null) goto L6;
        r3.f();
        return;
    }

    public final void n(CharSequence r2) {
        Objects.toString(r2);
    }

    @Override // jw8.b
    public final void e(TextView r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "textView");
        if (r4 == false) goto L14;
        jw8.c r5 = this.k;
        if (r5 == null) goto L14;
        View r6 = r5.a(r3.getContext());
        if (r6 == null) goto L14;
        ViewParent r7 = r6.getParent();
        if ((r7 instanceof ViewGroup) == false) goto L11;
        ViewGroup r8 = (ViewGroup) r7;
    L12:
        if (r8 == null) goto L14;
        r8.removeView(r6);
        goto L14
    L11:
        r8 = null;
    L14:
        this.i = null;
        n(null);
    }

    @Override // jw8.b
    public final void b(TextView r11, Spanned r12, d r13) {
        Intrinsics.checkNotNullParameter(r11, "textView");
        Intrinsics.checkNotNullParameter(r12, ShareType.TEXT);
        this.i = r11;     // Catch: Exception -> L57
        ViewParent r0 = r11.getParent();     // Catch: Exception -> L57
        Map r2 = null;
        if ((r0 instanceof FrameLayout) == false) goto L6;
        FrameLayout r1 = (FrameLayout) r0;     // Catch: Exception -> L57
    L8:
        if ((r11 instanceof ow8.a) == false) goto L55;
        if (r1 == null) goto L55;
        Integer r3 = this.d;     // Catch: Exception -> L57
        if (r3 == null) goto L19;
        Object r4 = r11.getTag(2131379630);     // Catch: Exception -> L57
        if (TypeIntrinsics.isMutableMap(r4) == false) goto L17;
        Map r5 = (Map) r4;     // Catch: Exception -> L57
    L18:
        if (r5 == null) goto L19;
        jw8.c r6 = (jw8.c) r5.get(r3);     // Catch: Exception -> L57
    L21:
        if (r6 != null) goto L36;
        jw8.a r7 = this.g;     // Catch: Exception -> L57
        if (r7 == null) goto L26;
        jw8.c r14 = r7.a(r1, r11, r12, this, r13);     // Catch: Exception -> L57
        if (r14 == null) goto L26;
    L27:
        r6 = r14;
        Integer r15 = this.d;     // Catch: Exception -> L57
        if (r15 == null) goto L36;
        Object r8 = r11.getTag(2131379630);     // Catch: Exception -> L57
        if (TypeIntrinsics.isMutableMap(r8) == false) goto L33;
        r2 = (Map) r8;     // Catch: Exception -> L57
    L33:
        if (r2 != null) goto L35;
        r2 = new LinkedHashMap();     // Catch: Exception -> L57
    L35:
        r2.put(r15, r6);     // Catch: Exception -> L57
        r11.setTag(2131379630, r2);     // Catch: Exception -> L57
    L26:
        r14 = new com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal.a();     // Catch: Exception -> L57
    L36:
        jw8.c r16 = r6;
        Map<String, Object> r9 = this.a;     // Catch: Exception -> L57
        Integer r10 = this.d;     // Catch: Exception -> L57
        if (r10 != null) goto L39;
        int r17 = this.f;     // Catch: Exception -> L57
    L40:
        Size r18 = r16.b(r11, r12, this, r9, r17, this.h);     // Catch: Exception -> L57
        this.j = r18;     // Catch: Exception -> L57
        r18.getWidth();     // Catch: Exception -> L57
        this.j.getHeight();     // Catch: Exception -> L57
        n(r11.getText());     // Catch: Exception -> L57
        View r19 = r16.a(r11.getContext());     // Catch: Exception -> L57
        ViewGroup.LayoutParams r110 = r19.getLayoutParams();     // Catch: Exception -> L57
        if (r110 != null) goto L44;
        r19.setLayoutParams(new FrameLayout.LayoutParams(this.j.getWidth(), this.j.getHeight()));     // Catch: Exception -> L57
        r19.setVisibility(4);     // Catch: Exception -> L57
    L50:
        this.k = r16;     // Catch: Exception -> L57
        if (r19.getParent() != null) goto L63;
        r1.addView(r19);     // Catch: Exception -> L57
        return;
    L63:
        return;
    L44:
        if (r110.width == this.j.getWidth()) goto L46;
    L47:
        ViewGroup.LayoutParams r111 = r19.getLayoutParams();     // Catch: Exception -> L57
        if (r111 == null) goto L54;
        r111.width = this.j.getWidth();     // Catch: Exception -> L57
        r111.height = this.j.getHeight();     // Catch: Exception -> L57
        r19.setLayoutParams(r111);     // Catch: Exception -> L57
        goto L50
    L54:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");     // Catch: Exception -> L57
    L46:
        if (r110.height == this.j.getHeight()) goto L50;
    L39:
        r17 = this.f - e.a(r12, r10.intValue());     // Catch: Exception -> L57
        goto L40
    L17:
        r5 = null;
    L19:
        r6 = null;
    L55:
        this.k = null;     // Catch: Exception -> L57
        return;
    L6:
        r1 = null;
    L57:
        e = move-exception;
        com.larus.business.markdown.api.depend.d r112 = IMarkdownLoggerKt.a();
        if (r112 == null) goto L65;
        r112.e("CustomCodeSpan", "beforeAttach error:" + e);
        return;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r2, CharSequence r3, int r4, int r5, Paint.FontMetricsInt r6) {
        Intrinsics.checkNotNullParameter(r2, "paint");
        if (r3 != null) goto L5;
    L7:
        boolean r7 = false;
    L8:
        if (r7 == false) goto L10;
        int r8 = this.j.getHeight();
    L14:
        if (r6 == null) goto L16;
        int r9 = -r8;
        r6.ascent = r9;
        r6.descent = 0;
        r6.top = r9;
        r6.bottom = 0;
    L16:
        this.j.getWidth();
        n(r3);
        return this.j.getWidth();
    L10:
        TextView r10 = this.i;
        if (r10 == null) goto L13;
        r8 = (int) ((this.j.getHeight() - r10.getLineSpacingExtra()) / r10.getLineSpacingMultiplier());
        goto L14
    L13:
        r8 = this.j.getHeight();
        goto L14
    L5:
        if (r3.length() != r5) goto L7;
        r7 = true;
        goto L8
    }

    public c(Map<String, ? extends Object> r1, String r2, String r3, Integer r4, Integer r5, int r6, jw8.a r7, boolean r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.j = new Size(0, 0);
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r7, final CharSequence r8, final int r9, int r10, float r11, int r12, int r13, int r14, Paint r15) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        Intrinsics.checkNotNullParameter(r15, "paint");
        TextView r16 = this.i;
        if (r16 != null) goto L5;
        return;
    L5:
        jw8.c r17 = this.k;
        if (r17 != null) goto L8;
        return;
    L8:
        final View r18 = r17.a(r16.getContext());
        o r0 = null;
        if ((r8 instanceof SpannableString) == false) goto L11;
        SpannableString r19 = (SpannableString) r8;
    L12:
        if (r19 == null) goto L16;
        o[] r110 = (o[]) r19.getSpans(r9, r10, o.class);
        if (r110 == null) goto L16;
        r0 = (o) ArraysKt.firstOrNull(r110);
    L16:
        if (r0 == null) goto L18;
        float r111 = r0.getAlpha();
    L19:
        r18.setAlpha(r111 / 255);
        final int r2 = ((r12 + r16.getTop()) + r16.getPaddingTop()) + (((r14 - r12) - this.j.getHeight()) / 2);
        int r112 = (((int) r11) + r16.getLeft()) + r16.getPaddingLeft();
        ViewGroup.LayoutParams r20 = r18.getLayoutParams();
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r21 = (ViewGroup.MarginLayoutParams) r20;
        if (r21.topMargin == r2) goto L22;
    L28:
        ViewGroup.LayoutParams r22 = r18.getLayoutParams();
        if (r22 == null) goto L33;
        ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) r22;
        r23.topMargin = r2;
        r23.leftMargin = r112;
        r18.setLayoutParams(r23);
        r18.setVisibility(4);
        r18.post(new b(this, r2, r8, r9, r18));
        return;
    L33:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L22:
        if (r21.leftMargin != r112) goto L28;
        if (r18.getVisibility() == 0) goto L27;
        n(r8);
        r18.setVisibility(0);
        return;
    L27:
        n(r8);
        return;
    L18:
        r111 = 255.0f;
        goto L19
    L11:
        r19 = null;
        goto L12
    }
}
