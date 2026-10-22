package com.larus.bmhome.chat.doclink;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.LineBackgroundSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.ReplacementSpan;
import android.text.style.URLSpan;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.markdown.richtext.MessageMarkdownLinkSource;
import com.larus.bmhome.chat.model.ChatDraftItem;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class MessageDocPreviewInlineRenderer {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/doclink/MessageDocPreviewInlineRenderer$Style;", "", "<init>", "(Ljava/lang/String;I)V", "UPSTREAM", "DOWNSTREAM", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum Style extends Enum<Style> {
        public static final Style DOWNSTREAM = null;
        public static final Style UPSTREAM = null;
        public static final /* synthetic */ Style[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Style> getEntries() {
            return b;
        }

        static {
            Style r0 = new Style("UPSTREAM", 0);
            UPSTREAM = r0;
            Style r1 = new Style("DOWNSTREAM", 1);
            DOWNSTREAM = r1;
            Style[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static Style[] values() {
            return (Style[]) a.clone();
        }

        public static Style valueOf(String r1) {
            return (Style) r27.a.a(Style.class, r1);
        }

        public Style(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a extends MetricAffectingSpan {
        public a() {
        }

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r3) {
            Intrinsics.checkNotNullParameter(r3, "textPaint");
            Typeface r0 = r3.getTypeface();
            if (r0 == null) goto L5;
            int r1 = r0.getStyle();
        L6:
            r3.setTypeface(Typeface.create(r0, r1 | 1));
            return;
        L5:
            r1 = 0;
            goto L6
        }

        @Override // android.text.style.MetricAffectingSpan
        public final void updateMeasureState(TextPaint r3) {
            Intrinsics.checkNotNullParameter(r3, "textPaint");
            Typeface r0 = r3.getTypeface();
            if (r0 == null) goto L5;
            int r1 = r0.getStyle();
        L6:
            r3.setTypeface(Typeface.create(r0, r1 | 1));
            return;
        L5:
            r1 = 0;
            goto L6
        }
    }

    public static final class b extends ImageSpan {
        public final int a;

        public b(d r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "drawable");
            super(r2);
            this.a = r3;
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public final int getSize(Paint r2, CharSequence r3, int r4, int r5, Paint.FontMetricsInt r6) {
            Intrinsics.checkNotNullParameter(r2, "paint");
            Rect r7 = getDrawable().getBounds();
            if (r6 == null) goto L6;
            Paint.FontMetricsInt r8 = r2.getFontMetricsInt();
            int r9 = r8.descent;
            int r10 = r8.ascent;
            int r11 = r10 + ((r9 - r10) / 2);
            int r12 = (r7.bottom - r7.top) / 2;
            int r13 = r11 - r12;
            r6.ascent = r13;
            r6.top = r13;
            int r14 = r11 + r12;
            r6.bottom = r14;
            r6.descent = r14;
        L6:
            return r7.width() + this.a;
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
            Intrinsics.checkNotNullParameter(r1, "canvas");
            Intrinsics.checkNotNullParameter(r2, ChatDraftItem.TYPE_TEXT);
            Intrinsics.checkNotNullParameter(r9, "paint");
            Paint.FontMetricsInt r10 = r9.getFontMetricsInt();
            int r11 = ((((r10.descent + r7) + r7) + r10.ascent) / 2) - (getDrawable().getBounds().height() / 2);
            r1.save();
            r1.translate(r5, r11);
            getDrawable().draw(r1);
            r1.restore();
        }
    }

    public static final class c {
        public final com.larus.bmhome.chat.markdown.richtext.g a;
        public final com.larus.bmhome.chat.doclink.h b;
        public final String c;
        public final boolean d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            com.larus.bmhome.chat.doclink.h r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (((r0 + r2) * 31) + this.c.hashCode()) * 31;
            if (this.d == false) goto L9;
            int r4 = 1231;
        L11:
            return r3 + r4;
        L9:
            r4 = 1237;
            goto L11
        L5:
            r2 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "InlineReplacement(link=" + this.a + ", preview=" + this.b + ", replacementText=" + this.c + ", showIcon=" + this.d + ')';
        }

        public c(com.larus.bmhome.chat.markdown.richtext.g r2, com.larus.bmhome.chat.doclink.h r3, String r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "link");
            Intrinsics.checkNotNullParameter(r4, "replacementText");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class d extends Drawable {
        public Drawable a;

        @Override // android.graphics.drawable.Drawable
        public final int getOpacity() {
            return -3;
        }

        public d(Drawable r2) {
            Intrinsics.checkNotNullParameter(r2, "current");
            this.a = r2;
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas r2) {
            Intrinsics.checkNotNullParameter(r2, "canvas");
            this.a.draw(r2);
        }

        @Override // android.graphics.drawable.Drawable
        public final void onBoundsChange(Rect r2) {
            Intrinsics.checkNotNullParameter(r2, "bounds");
            this.a.setBounds(r2);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int r2) {
            this.a.setAlpha(r2);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter r2) {
            this.a.setColorFilter(r2);
        }

        public final void update(Drawable r2) {
            Intrinsics.checkNotNullParameter(r2, "drawable");
            this.a = r2;
            r2.setBounds(getBounds());
            invalidateSelf();
        }
    }

    public static final class e {
        public final CharSequence a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof e) == true) goto L8;
            return false;
        L8:
            e r6 = (e) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b;
        }

        public final String toString() {
            return "Result(text=" + this.a + ", replacementCount=" + this.b + ')';
        }

        public e(CharSequence r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, ChatDraftItem.TYPE_TEXT);
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class f implements LineBackgroundSpan {
        public final int a;
        public final int b;
        public final float c;
        public final float d;
        public final RectF e;

        public f(int r1, int r2, float r3, float r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = new RectF();
        }

        @Override // android.text.style.LineBackgroundSpan
        public final void drawBackground(Canvas r1, Paint r2, int r3, int r4, int r5, int r6, int r7, CharSequence r8, int r9, int r10, int r11) {
            Intrinsics.checkNotNullParameter(r1, "canvas");
            Intrinsics.checkNotNullParameter(r2, "paint");
            Intrinsics.checkNotNullParameter(r8, ChatDraftItem.TYPE_TEXT);
            int r12 = Math.max(r9, this.a);
            int r13 = Math.min(r10, this.b);
            if (r12 < r13) goto L6;
            return;
        L6:
            if ((r2 instanceof TextPaint) == false) goto L8;
            TextPaint r14 = (TextPaint) r2;
        L9:
            if (r14 != null) goto L11;
            r14 = new TextPaint(r2);
        L11:
            float r15 = r14.measureText(r8.subSequence(r9, r12).toString());
            float r16 = r14.measureText(r8.subSequence(r12, r13).toString());
            RectF r17 = this.e;
            float r18 = r3 + r15;
            float r19 = this.d;
            r17.set(r18 - r19, r5, (r18 + r16) + r19, r7);
            int r20 = r2.getColor();
            Paint.Style r21 = r2.getStyle();
            r2.setColor(251684607);
            r2.setStyle(Paint.Style.FILL);
            RectF r22 = this.e;
            float r23 = this.c;
            r1.drawRoundRect(r22, r23, r23, r2);
            r2.setColor(r20);
            r2.setStyle(r21);
            return;
        L8:
            r14 = null;
            goto L9
        }
    }

    public /* synthetic */ class g {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Style.values().length];
            r0[Style.UPSTREAM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Style.DOWNSTREAM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class h<T> implements Comparator {
        public h() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((c) r1).a.a), Integer.valueOf(((c) r2).a.a));
        }
    }

    static {
    }

    public static boolean a(char r5) {
        if ('a' <= r5) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L10;
    L25:
        boolean r1 = true;
    L26:
        if (r1 == false) goto L28;
        return true;
    L28:
        if (StringsKt.contains$default(".-~!@#$%^&*+?:_/=<>%", r5, false, 2, null) == true) goto L33;
        return false;
    L33:
        return true;
    L10:
        if ('A' <= r5) goto L12;
    L14:
        boolean r2 = false;
    L15:
        if (r2 == true) goto L25;
        if ('0' <= r5) goto L19;
    L21:
        boolean r3 = false;
    L22:
        if (r3 == true) goto L25;
        r1 = false;
        goto L26
    L19:
        if (r5 >= ':') goto L21;
        r3 = true;
        goto L22
    L12:
        if (r5 >= '[') goto L14;
        r2 = true;
        goto L15
    L5:
        if (r5 >= '{') goto L7;
        r0 = true;
        goto L8
    }

    public static String c(String r5) {
        StringBuilder r0 = new StringBuilder(r5.length());
        int r1 = 0;
    L4:
        if (r1 >= r5.length()) goto L14;
        char r2 = r5.charAt(r1);
        if (r2 != '\\') goto L12;
        int r3 = r1 + 1;
        if (r3 >= r5.length()) goto L12;
        if (a(r5.charAt(r3)) == false) goto L12;
        r0.append(r5.charAt(r3));
        r1 = r1 + 2;
    L12:
        r0.append(r2);
        r1 = r1 + 1;
        goto L4
    L14:
        return r0.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v14, types: [com.larus.bmhome.chat.doclink.i, java.lang.Object] */
    public static e b(final TextView r26, CharSequence r27, com.larus.bmhome.chat.markdown.richtext.i r28, Map r29, Set r30, final Style r31, Function2 r32) {
        com.larus.bmhome.chat.markdown.richtext.i r1 = r28;
        Map r2 = r29;
        Intrinsics.checkNotNullParameter(r26, "textView");
        Intrinsics.checkNotNullParameter(r27, "sourceText");
        Intrinsics.checkNotNullParameter(r1, "parseResult");
        Intrinsics.checkNotNullParameter(r2, "previewsByUrl");
        Intrinsics.checkNotNullParameter(r30, "previewUrls");
        Intrinsics.checkNotNullParameter(r31, "style");
        Intrinsics.checkNotNullParameter(r32, "createClickableSpan");
        String r4 = r27.toString();
        String r15 = null;
        if (Intrinsics.areEqual(r4, r1.a) == false) goto L5;
        Integer r16 = 0;
        int r5 = 1;
    L12:
        List<com.larus.bmhome.chat.markdown.richtext.g> r9 = r1.b;
        ArrayList r14 = new ArrayList();
        Iterator<T> r18 = r9.iterator();
        int r19 = 0;
    L14:
        if (r18.hasNext() == false) goto L150;
        com.larus.bmhome.chat.markdown.richtext.g r10 = (com.larus.bmhome.chat.markdown.richtext.g) r18.next();
        if (com.larus.bmhome.chat.markdown.richtext.o.a(r10) == false) goto L18;
        ArrayList r25 = r14;
    L145:
        c r13 = null;
    L146:
        ArrayList r3 = r25;
        if (r13 == null) goto L149;
        r3.add(r13);
    L149:
        r5 = 1;
        r15 = null;
        r2 = r29;
        r14 = r3;
        r1 = r28;
        goto L14
    L18:
        if (r16 == null) goto L21;
        com.larus.bmhome.chat.markdown.richtext.g r11 = com.larus.bmhome.chat.markdown.richtext.g.a(r10, r10.a + r16.intValue(), r10.b + r16.intValue(), r15, 12);
        com.larus.bmhome.chat.markdown.richtext.g r17 = r10;
        r25 = r14;
    L45:
        String r12 = l.a(r17.c);
        com.larus.bmhome.chat.doclink.h r110 = (com.larus.bmhome.chat.doclink.h) r2.get(r12);
        if (r110 == null) goto L50;
        String r111 = r110.b;
        if (r111 == null) goto L50;
        String r112 = StringsKt.trim(r111).toString();
    L51:
        if (r112 != null) goto L54;
        r112 = "";
    L54:
        if (((StringsKt.isBlank(r112) ? 1 : 0) ^ r5) != 0) goto L56;
    L58:
        boolean r113 = false;
    L59:
        if (r113 == true) goto L61;
    L118:
        String r6 = r17.c;
        if (r110 == null) goto L123;
        String r7 = r110.c;
        if (r7 == null) goto L123;
        String r114 = StringsKt.trim(r7).toString();
    L124:
        if (r114 != null) goto L126;
    L129:
        boolean r8 = true;
    L130:
        if (r8 == false) goto L133;
        r114 = null;
    L133:
        if (r114 == null) goto L136;
        r6 = r114;
    L136:
        com.larus.bmhome.chat.markdown.richtext.g r20 = com.larus.bmhome.chat.markdown.richtext.g.a(r11, 0, 0, r6, 11);
        if (r113 == false) goto L140;
        String r21 = "￼".concat(r112);
    L144:
        r13 = new c(r20, r110, r21, r113);
        goto L146
    L140:
        if (r17.d != MessageMarkdownLinkSource.MARKDOWN_LINK) goto L145;
        if (r30.contains(r12) == false) goto L145;
        r21 = r17.c;
        goto L144
    L126:
        if (StringsKt.isBlank(r114) == true) goto L129;
        r8 = false;
    L123:
        r114 = null;
        goto L124
    L61:
        if (r11.d != MessageMarkdownLinkSource.PLAIN_URL) goto L118;
        if (r110 == null) goto L118;
        if (r11.a < 0) goto L118;
        if (r11.b > r4.length()) goto L118;
        int r22 = r11.a;
        int r115 = r11.b;
        if (r22 >= r115) goto L118;
        String r23 = r4.substring(r22, r115);
        List r24 = CollectionsKt.listOfNotNull(new String[]{r110.m, r110.c});
        ArrayList r116 = new ArrayList();
        Iterator r33 = r24.iterator();
    L72:
        if (r33.hasNext() == false) goto L74;
        String r210 = StringsKt.trim((String) r33.next()).toString();
        Iterator r211 = r33;
        String r34 = l.a(r210);
        CollectionsKt.addAll(r116, CollectionsKt.listOf(new String[]{r210, r34, StringsKt.removePrefix(StringsKt.removePrefix(r34, "https://"), "http://")}));
        r33 = r211;
        goto L72
    L74:
        ArrayList r35 = new ArrayList();
        Iterator r36 = r116.iterator();
    L76:
        if (r36.hasNext() == false) goto L80;
        Object r37 = r36.next();
        if ((!StringsKt.isBlank((String) r37)) == false) goto L76;
        r35.add(r37);
        goto L76
    L80:
        Iterator r38 = CollectionsKt.distinct(r35).iterator();
    L82:
        if (r38.hasNext() == false) goto L118;
        String r39 = (String) r38.next();
        Iterator r212 = r38;
        if (StringsKt.isBlank(r39) == true) goto L107;
        int r40 = 0;
        int r117 = 0;
    L88:
        if (r117 >= r23.length()) goto L105;
        if (r40 >= r39.length()) goto L105;
        char r41 = r23.charAt(r117);
        char r42 = r39.charAt(r40);
        if (r41 != r42) goto L95;
        r117 = r117 + 1;
    L103:
        r40 = r40 + 1;
        goto L88
    L95:
        if (r41 != '\\') goto L107;
        int r43 = r117 + 1;
        if (r43 >= r23.length()) goto L107;
        if (r23.charAt(r43) != r42) goto L107;
        if (a(r42) == false) goto L107;
        r117 = r117 + 2;
    L105:
        if (r40 != r39.length()) goto L107;
        Integer r44 = Integer.valueOf(r117);
    L108:
        if (r44 == null) goto L117;
        int r45 = r44.intValue();
        if (1 <= r45) goto L112;
    L114:
        boolean r46 = false;
    L115:
        if (r46 == false) goto L117;
        r11 = com.larus.bmhome.chat.markdown.richtext.g.a(r11, 0, r11.a + r45, null, 13);
        goto L118
    L112:
        if (r45 > r23.length()) goto L114;
        r46 = true;
    L117:
        r38 = r212;
    L107:
        r44 = null;
        goto L108
    L56:
        if (Intrinsics.areEqual(l.a(r112), r12) == true) goto L58;
        r113 = true;
    L50:
        r112 = null;
        goto L51
    L21:
        if (r10.a >= 0) goto L23;
    L41:
        r17 = r10;
        r25 = r14;
        IntRange r47 = null;
    L42:
        if (r47 == null) goto L145;
        r19 = r47.getLast() + r5;
        r11 = com.larus.bmhome.chat.markdown.richtext.g.a(r17, r47.getFirst(), r47.getLast() + r5, null, 12);
        goto L45
    L23:
        if (r10.b > r1.a.length()) goto L41;
        int r118 = r10.a;
        int r119 = r10.b;
        if (r118 >= r119) goto L41;
        String r120 = r1.a.substring(r118, r119);
        String[] r121 = new String[4];
        r121[0] = r120;
        r121[r5] = c(r120);
        String r122 = r10.c;
        r121[2] = r122;
        r121[3] = c(r122);
        List r123 = CollectionsKt.listOf(r121);
        ArrayList r124 = new ArrayList();
        Iterator r125 = r123.iterator();
    L29:
        if (r125.hasNext() == false) goto L34;
        Object r126 = r125.next();
        if ((!StringsKt.isBlank((String) r126)) == false) goto L29;
        r124.add(r126);
        goto L29
    L34:
        Iterator r213 = CollectionsKt.distinct(r124).iterator();
    L36:
        if (r213.hasNext() == false) goto L41;
        String r214 = (String) r213.next();
        r17 = r10;
        r25 = r14;
        int r48 = StringsKt.indexOf$default(r4, r214, r19, false, 4, null);
        if (r48 >= 0) goto L39;
        r10 = r17;
        r14 = r25;
        goto L36
    L39:
        r47 = RangesKt.until(r48, r214.length() + r48);
        goto L42
    L150:
        int r127 = 12;
        ArrayList r49 = new ArrayList();
        Iterator r50 = r14.iterator();
    L152:
        if (r50.hasNext() == false) goto L163;
        Object r51 = r50.next();
        c r52 = (c) r51;
        com.larus.bmhome.chat.markdown.richtext.g r53 = r52.a;
        if (r53.a >= 0) goto L156;
    L160:
        boolean r128 = false;
    L161:
        if (r128 == false) goto L152;
        r49.add(r51);
        goto L152
    L156:
        if (r53.b > r4.length()) goto L160;
        com.larus.bmhome.chat.markdown.richtext.g r54 = r52.a;
        if (r54.a >= r54.b) goto L160;
        r128 = true;
        goto L161
    L163:
        List r55 = CollectionsKt.take(CollectionsKt.sortedWith(r49, new h()), 3);
        if (r55.isEmpty() == true) goto L166;
        SpannableStringBuilder r56 = new SpannableStringBuilder(r27);
        Iterator r0 = CollectionsKt.asReversed(r55).iterator();
    L169:
        if (r0.hasNext() == false) goto L180;
        c r57 = (c) r0.next();
        com.larus.bmhome.chat.markdown.richtext.g r58 = r57.a;
        int r59 = r58.a;
        int r60 = r58.b;
        Object[] r61 = r56.getSpans(r59, r60, ClickableSpan.class);
        int r62 = r61.length;
        int r129 = 0;
    L171:
        if (r129 >= r62) goto L173;
        r56.removeSpan(r61[r129]);
        r129 = r129 + 1;
        goto L171
    L173:
        Object[] r63 = r56.getSpans(r59, r60, URLSpan.class);
        int r64 = r63.length;
        int r130 = 0;
    L174:
        if (r130 >= r64) goto L176;
        r56.removeSpan(r63[r130]);
        r130 = r130 + 1;
        goto L174
    L176:
        com.larus.bmhome.chat.markdown.richtext.g r65 = r57.a;
        Object[] r66 = r56.getSpans(r65.a, r65.b, ReplacementSpan.class);
        int r67 = r66.length;
        int r131 = 0;
    L177:
        if (r131 >= r67) goto L179;
        r56.removeSpan(r66[r131]);
        r131 = r131 + 1;
        goto L177
    L179:
        com.larus.bmhome.chat.markdown.richtext.g r68 = r57.a;
        r56.replace(r68.a, r68.b, r57.c);
        goto L169
    L180:
        Iterator r69 = r55.iterator();
        int r132 = 0;
    L182:
        if (r69.hasNext() == false) goto L237;
        c r70 = (c) r69.next();
        int r71 = r70.a.a + r132;
        int r133 = r71 + r70.c.length();
        int r72 = r70.c.length();
        com.larus.bmhome.chat.markdown.richtext.g r73 = r70.a;
        int r134 = r132 + (r72 - (r73.b - r73.a));
        r56.setSpan(r32.invoke(com.larus.bmhome.chat.markdown.richtext.g.a(r73, r71, r133, null, r127), Boolean.valueOf(!r70.d)), r71, r133, 33);
        if (r70.d == false) goto L234;
        com.larus.bmhome.chat.doclink.h r74 = r70.b;
        if (r31 != Style.DOWNSTREAM) goto L188;
        int r75 = c7.b(3);
    L189:
        int r76 = r75;
        final Context r77 = r26.getContext();
        Intrinsics.checkNotNull(r77);
        Drawable r78 = ContextCompat.getDrawable(r77, 2131242369);
        if (r78 == null) goto L202;
        Drawable r79 = r78.mutate();
        if (r79 == null) goto L202;
        int r80 = g.a[r31.ordinal()];
        if (r80 != 1) goto L196;
        int r81 = v19.c.a(2130972312, r77, R.color.white);
    L201:
        DrawableCompat.setTint(r79, r81);
        Drawable r135 = r79;
    L204:
        if (r74 == null) goto L210;
        int r136 = k.a;
        Intrinsics.checkNotNullParameter(r77, "context");
        Intrinsics.checkNotNullParameter(r74, "preview");
        IMessageDocPreviewService r137 = k.a();
        if (r137 == null) goto L208;
        Drawable r138 = r137.b(r77, r74);
    L209:
        if (r138 == null) goto L210;
    L213:
        final int r139 = c7.b(18);
        Iterator r140 = r69;
        Drawable r141 = DrawableCompat.wrap(r138.mutate());
        if (r31 != Style.UPSTREAM) goto L216;
        DrawableCompat.setTint(r141, v19.c.a(2130972312, r77, R.color.white));
    L216:
        final d r82 = new d(r141);
        r82.setBounds(0, 0, r139, r139);
        if (r74 == null) goto L222;
        int r83 = k.a;
        int r142 = r76;
        r134 = r134;
        r55 = r55;
        ?? r84 = new i(r26, r77, r31, r139, r82);
        Intrinsics.checkNotNullParameter(r77, "context");
        Intrinsics.checkNotNullParameter(r74, "preview");
        Intrinsics.checkNotNullParameter(r84, "callback");
        IMessageDocPreviewService r85 = k.a();
        if (r85 == 0) goto L221;
        r85.a(r77, r74, r135, r84);
    L224:
        if (r82 == null) goto L235;
        r56.setSpan(new b(r82, r142), r71, r71 + 1, 33);
        int r86 = g.a[r31.ordinal()];
        if (r86 != 1) goto L229;
        r56.setSpan(new ForegroundColorSpan(v19.c.a(2130972312, r26.getContext(), R.color.white)), r71, r133, 33);
        r56.setSpan(new a(), r71, r133, 33);
        goto L235
    L229:
        if (r86 != 2) goto L232;
        r56.setSpan(new f(r71, r133, c7.b(7), c7.b(4)), r71, r133, 33);
        r56.setSpan(new ForegroundColorSpan(-16750849), r71, r133, 33);
        goto L235
    L232:
        throw new NoWhenBranchMatchedException();
    L235:
        r69 = r140;
        r132 = r134;
        r55 = r55;
        r127 = 12;
        goto L182
    L221:
        r84.invoke(r135);
        goto L224
    L222:
        r142 = r76;
        d r143 = r82;
    L223:
        r82 = r143;
        goto L224
    L208:
        r138 = null;
    L210:
        if (r135 != null) goto L212;
        r142 = r76;
        r140 = r69;
        r143 = null;
        goto L223
    L212:
        r138 = r135;
        goto L213
    L196:
        if (r80 != 2) goto L199;
        r81 = -16750849;
        goto L201
    L199:
        throw new NoWhenBranchMatchedException();
    L202:
        r135 = null;
        goto L204
    L188:
        r75 = c7.b(2);
        goto L189
    L234:
        r55 = r55;
        r140 = r69;
        r134 = r134;
        goto L235
    L237:
        return new e(r56, r55.size());
    L166:
        return new e(r27, 0);
    L5:
        r5 = 1;
        Integer r87 = Integer.valueOf(StringsKt.indexOf$default(r4, r1.a, 0, false, 6, null));
        if (r87.intValue() < 0) goto L8;
        boolean r144 = true;
    L9:
        if (r144 == false) goto L11;
        r16 = r87;
        goto L12
    L11:
        r16 = null;
        goto L12
    L8:
        r144 = false;
        goto L9
    }
}
