package com.bytedance.ies.xelement.text.text;

import android.graphics.Typeface;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.bytedance.android.anniex.base.service.e;
import com.bytedance.ies.xelement.text.inlinetext.LynxInlineTextShadowNode;
import com.bytedance.ies.xelement.text.inlinetruncation.LynxInlineTruncationShadowNode;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode;
import com.lynx.tasm.utils.c;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import k5.d;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import we.a;
import we.b;
import ym.k;
import zm.f0;
import zm.g0;
import zm.q;
import zm.t;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\r\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/xelement/text/text/LynxTextShadowNode;", "Lcom/lynx/tasm/behavior/shadow/text/TextShadowNode;", "Lzm/f0;", "<init>", "()V", "", "textMaxLine", "", "setTextMaxLine", "(Ljava/lang/String;)V", "ellipsizeMode", "setEllipsizeMode", "type", "setRichType", "x-element-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxTextShadowNode extends TextShadowNode implements f0 {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final Regex f6504d0 = null;
    public String Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f6505a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public SpannableStringBuilder f6506b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final Function1 f6507c0;

    static {
        f6504d0 = new Regex("^[\\s]+|[\\s]+$");
    }

    public LynxTextShadowNode() {
        this.Z = "none";
        this.f6507c0 = LynxTextShadowNode$adapterProvider$1.f6508a;
    }

    @Override // com.lynx.tasm.behavior.shadow.text.TextShadowNode
    public final long B(TextShadowNode r23, float r24, MeasureMode r25, float r26, MeasureMode r27) {
        if (this.f6506b0 == null) goto L6;
        this.L = new SpannableStringBuilder(this.f6506b0);
    L6:
        if (r25 != MeasureMode.f10339b) goto L8;
        float r5 = Float.MAX_VALUE;
    L9:
        int r10 = 0;
        this.W = 0;
        int r11 = j();
        int r12 = 0;
        int r13 = 0;
    L10:
        if (r12 >= r11) goto L15;
        if ((e(r12) instanceof LynxInlineTruncationShadowNode) == false) goto L14;
        r13 = r13 + 1;
    L14:
        r12 = r12 + 1;
        goto L10
    L15:
        if (r13 > 0) goto L17;
        boolean r14 = false;
    L143:
        if (r14 == false) goto L159;
        CharSequence r15 = this.L;
        if ((r15 instanceof SpannableStringBuilder) == true) goto L148;
        r15 = null;
    L148:
        if (r15 == null) goto L150;
        SpannableStringBuilder r16 = (SpannableStringBuilder) r15;
    L151:
        int r17 = j();
    L152:
        if (r10 >= r17) goto L159;
        ShadowNode r18 = e(r10);
        if ((r18 instanceof LynxInlineTruncationShadowNode) == false) goto L157;
        if (r16 == null) goto L157;
        r16.append(((LynxInlineTruncationShadowNode) r18).L);
    L157:
        r10 = r10 + 1;
        goto L152
    L150:
        r16 = null;
    L159:
        return super.B(r23, r24, r25, r26, r27);
    L17:
        LynxContext r19 = k();
        DecimalFormat r20 = t.f23539a;
        q r21 = this.f10357v;
        String r22 = r21.f23529u;
        if (TextUtils.isEmpty(r22) == true) goto L20;
        Typeface r28 = g0.c(r19, r22, r21.d());
    L21:
        TextPaint r29 = t.c(r21, r28);
        CharSequence r30 = this.L;
        int r110 = (int) r5;
        StaticLayout r31 = StaticLayout.Builder.obtain(r30, 0, r30.length(), r29, r110).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(r21.f23522m, 1.0f).setIncludePad(r21.f23528t).setEllipsize(TextUtils.TruncateAt.END).setEllipsizedWidth(r110).setTextDirection(r21.c()).build();
        if (this.f6505a0 > 0) goto L24;
    L25:
        int r111 = j();
        int r112 = 0;
    L26:
        if (r112 >= r111) goto L33;
        ShadowNode r113 = e(r112);
        if ((r113 instanceof LynxInlineTruncationShadowNode) == false) goto L32;
        if (((LynxInlineTruncationShadowNode) r113).Z == false) goto L32;
    L31:
        boolean r114 = true;
    L34:
        int r115 = RangesKt.coerceAtMost(r31.getLineCount(), this.f6505a0);
        if (r114 == false) goto L57;
        int r116 = j();
        int r117 = 0;
    L37:
        if (r117 >= r116) goto L57;
        ShadowNode r118 = e(r117);
        if ((r118 instanceof LynxInlineTruncationShadowNode) == false) goto L56;
        if (((LynxInlineTruncationShadowNode) r118).Z == false) goto L56;
        if (r115 >= (this.f6505a0 - 1)) goto L57;
        if ((L(r29) + r31.getLineWidth(r115 - 1)) <= r5) goto L55;
        CharSequence r32 = this.L;
        if ((r32 instanceof SpannableStringBuilder) == true) goto L50;
        r32 = null;
    L50:
        if (r32 == null) goto L52;
        SpannableStringBuilder r33 = (SpannableStringBuilder) r32;
    L53:
        if (r33 == null) goto L55;
        r33.append("\n");
        goto L55
    L52:
        r33 = null;
    L55:
        r114 = r114;
    L142:
        r14 = r114;
    L56:
        r117 = r117 + 1;
    L57:
        if (r114 == false) goto L55;
        int r119 = r115 - 1;
        float r120 = r31.getLineWidth(r119);
        int r121 = r31.getLineEnd(r119);
        int r122 = r31.getLineStart(r119);
        int r34 = r121 - 1;
        char r123 = this.L.charAt(r34);
        if (r123 != '\n') goto L66;
        if (r121 > 1) goto L62;
    L64:
        int r35 = 1;
    L65:
        r121 = r121 - r35;
        boolean r36 = true;
    L69:
        float r37 = L(r29) + r120;
        if (r37 > r5) goto L75;
        if (r36 == true) goto L75;
        if (r114 == true) goto L75;
        r114 = r114;
        r10 = 0;
    L75:
        int r38 = (int) ((r37 - r5) + 0.5f);
        if (r21.e == 0) goto L78;
    L82:
        CharSequence r39 = this.L;
        if (r39 == null) goto L141;
        Object[] r40 = ((Spanned) r39).getSpans(r121, r121, Object.class);
        int r41 = r21.e;
        if (r41 != 3) goto L87;
        SpannableStringBuilder r42 = new SpannableStringBuilder("\u200e…\u202c");
    L90:
        int r43 = r40.length;
        int r44 = 0;
    L91:
        if (r44 >= r43) goto L93;
        r42.setSpan(r40[r44], 0, r42.length(), 33);
        r44 = r44 + 1;
        r40 = r40;
        goto L91
    L93:
        int r45 = 0;
        r38 = r38 + ((int) Layout.getDesiredWidth(r42, r29));
        boolean r46 = true;
    L94:
        CharSequence r47 = this.L.subSequence(r122, r121);
        ArrayList r48 = CollectionsKt.arrayListOf(new Integer[]{Integer.valueOf(r45), Integer.valueOf(r45)});
        if (TextUtils.isEmpty(r47) == false) goto L97;
        r42 = r42;
        r114 = r114;
        int r49 = 1;
        r10 = 0;
    L131:
        SpannableStringBuilder r50 = new SpannableStringBuilder();
        if (r115 <= r49) goto L134;
        r50.append(this.L.subSequence(r10, r31.getLineEnd(r115 - 2)));
    L134:
        if (r46 == false) goto L136;
        r50.append(this.L.subSequence(r122, r121 - ((Number) r48.get(r10)).intValue()));
        this.W = this.L.length() - r50.length();
    L137:
        if (r42 == null) goto L139;
        r50.append(r42);
    L139:
        this.L = r50;
        goto L142
    L136:
        CharSequence r51 = this.L;
        CharSequence r52 = TextUtils.ellipsize(r51.subSequence(r122, r51.length()), r29, r120 - ((Number) r48.get(1)).floatValue(), TextUtils.TruncateAt.END);
        this.W = ((this.L.length() - r122) - r52.length()) + 1;
        r50.append(r52);
        goto L137
    L97:
        int r53 = r47.length();
        ArrayList r54 = new ArrayList();
        if (TextUtils.isEmpty(r47) == true) goto L105;
        if ((r47 instanceof Spanned) == false) goto L105;
        Spanned r124 = (Spanned) r47;
        b[] r55 = (b[]) r124.getSpans(0, r47.length(), b.class);
        int r56 = r55.length;
        int r125 = 0;
    L103:
        if (r125 >= r56) goto L105;
        b r210 = r55[r125];
        r54.add(CollectionsKt.listOf(new Integer[]{Integer.valueOf(r124.getSpanStart(null)), Integer.valueOf(r124.getSpanEnd(null))}));
        r125 = r125 + 1;
        r55 = r55;
        r56 = r56;
    L105:
        float r57 = 0.0f;
        int r58 = r53;
    L106:
        if (r58 <= 0) goto L126;
        if (r38 <= r57) goto L126;
        int r59 = r54.size() - 1;
        if (r59 < 0) goto L120;
    L111:
        int r126 = r59 - 1;
        List r60 = (List) r54.get(r59);
        if (((Number) r60.get(0)).intValue() > r58) goto L116;
        ArrayList r127 = r54;
        if (r58 <= ((Number) r60.get(1)).intValue()) goto L115;
    L117:
        if (r126 < 0) goto L121;
        r59 = r126;
        r54 = r127;
    L121:
        int r61 = 0;
    L122:
        if (r61 > 0) goto L125;
        r61 = 1;
    L125:
        r58 = r58 - r61;
        r57 = Layout.getDesiredWidth(r47.subSequence(r58, r47.length()), r29);
        r54 = r127;
        goto L106
    L115:
        r61 = ((Number) r60.get(1)).intValue() - ((Number) r60.get(0)).intValue();
        goto L122
    L116:
        r127 = r54;
        goto L117
    L120:
        r127 = r54;
    L126:
        if (r58 <= 0) goto L130;
        if (r38 <= r57) goto L130;
        r58 = r58 - 1;
        r57 = Layout.getDesiredWidth(r47.subSequence(r58, r47.length()), r29);
    L130:
        Integer r62 = Integer.valueOf(r47.length() - r58);
        r10 = 0;
        r48.set(0, r62);
        Integer r63 = Integer.valueOf((int) r57);
        r49 = 1;
        r48.set(1, r63);
        goto L131
    L87:
        if (r41 != 0) goto L89;
        r42 = new SpannableStringBuilder("…");
        goto L90
    L89:
        r42 = new SpannableStringBuilder("\u200f…\u202c");
        goto L90
    L141:
        throw new NullPointerException("null cannot be cast to non-null type android.text.Spanned");
    L78:
        if (r37 >= r5) goto L81;
        if (r36 == true) goto L82;
    L81:
        r46 = false;
        r42 = null;
        r45 = 0;
        goto L94
    L62:
        if (this.L.charAt(r121 - 2) != '\r') goto L64;
        r35 = 2;
        goto L65
    L66:
        if (r123 != '\r') goto L68;
        r36 = true;
        r121 = r34;
        goto L69
    L68:
        r36 = false;
    L32:
        r112 = r112 + 1;
        goto L26
    L33:
        r114 = false;
        goto L34
    L24:
        if (r31.getLineCount() > this.f6505a0) goto L31;
    L20:
        r28 = null;
        goto L21
    L8:
        r5 = r24;
        goto L9
    }

    @Override // com.lynx.tasm.behavior.shadow.text.TextShadowNode
    public final int I() {
        SpannableStringBuilder r5 = this.f6506b0;
        if (r5 == null) goto L6;
        Intrinsics.checkNotNull(r5);
        return r5.length();
    L6:
        return 0;
    }

    @Override // com.lynx.tasm.behavior.shadow.text.TextShadowNode
    public final boolean J() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.shadow.text.TextShadowNode
    public final void K() {
        super.K();
        CharSequence r5 = (SpannableStringBuilder) this.L;
        if (r5 != null) goto L6;
        r5 = "";
    L6:
        this.f6506b0 = new SpannableStringBuilder(r5);
    }

    public final float L(TextPaint r10) {
        int r5 = j();
        float r11 = 0.0f;
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L11;
        ShadowNode r13 = e(r12);
        if ((r13 instanceof LynxInlineTruncationShadowNode) == false) goto L9;
        CharSequence r14 = ((LynxInlineTruncationShadowNode) r13).L;
        if (r14 == null) goto L9;
        r11 = Layout.getDesiredWidth(r14, r10) + r11;
    L9:
        r12 = r12 + 1;
        goto L3
    L11:
        return (float) Math.ceil(r11 + 0.5f);
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode, com.lynx.tasm.behavior.shadow.ShadowNode
    public final void h(b0 r5) {
        super.h(r5);
        a r10 = e.k();
        Function1 r11 = this.f6507c0;
        Intrinsics.checkNotNull(r5);
        ((LynxTextShadowNode$adapterProvider$1) r11).getClass();
        Intrinsics.checkNotNullParameter(r5, ST.IMPLICIT_ARG_NAME);
        c r12 = new c(17);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r10.f22857a = r12;
    }

    @c0(name = "ellipsize-mode")
    public final void setEllipsizeMode(String r5) {
        Intrinsics.checkNotNullParameter(r5, "ellipsizeMode");
        if (Intrinsics.areEqual(r5, "tail") == false) goto L6;
        setTextOverflow(1);
    L8:
        n();
        return;
    L6:
        if (Intrinsics.areEqual(r5, "clip") == false) goto L8;
        setTextOverflow(0);
        goto L8
    }

    @c0(name = "richtype")
    public final void setRichType(String r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        this.Z = r5;
        if (Intrinsics.areEqual(r5, "bracket") == false) goto L9;
        q r10 = this.f10357v;
        if (k.b(r10.f23520k) == false) goto L7;
        float r11 = 40.0f;
    L8:
        setLineHeight(r11);
        goto L9
    L7:
        r11 = r10.f23520k;
    L9:
        n();
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    @c0(name = "text-maxline")
    public void setTextMaxLine(String r5) {
        Intrinsics.checkNotNullParameter(r5, "textMaxLine");
        super.setTextMaxLine(r5);
        this.f6505a0 = Integer.parseInt(r5);
        n();
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    public final void v(SpannableStringBuilder r5, String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "sb");
        if (r10 == null) goto L5;
        String r12 = d.d(0, f6504d0.replace(r10, ""));
    L7:
        if (Intrinsics.areEqual(this.Z, "bracket") == false) goto L10;
        Pattern r13 = we.c.f22858a;
        k();
        float r14 = this.f10357v.f23520k;
        r5.append(we.c.a(r12));
        return;
    L10:
        r5.append(r12);
        return;
    L5:
        r12 = null;
        goto L7
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    public final void w(SpannableStringBuilder r10, ArrayList r11) {
        int r5 = j();
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L8;
        ShadowNode r13 = e(r12);
        if ((r13 instanceof LynxInlineTextShadowNode) == false) goto L7;
        LynxInlineTextShadowNode r14 = (LynxInlineTextShadowNode) r13;
        String r15 = this.Z;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r14.O = r15;
    L7:
        r12 = r12 + 1;
        goto L3
    L8:
        super.w(r10, r11);
    }
}
