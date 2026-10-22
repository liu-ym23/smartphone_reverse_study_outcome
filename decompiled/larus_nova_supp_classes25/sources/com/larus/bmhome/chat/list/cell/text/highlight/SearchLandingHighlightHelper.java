package com.larus.bmhome.chat.list.cell.text.highlight;

import android.os.SystemClock;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.CodeBlockWithLineNumberScrollableSpan;
import com.larus.utils.logger.FLogger;
import io.noties.markwon.ext.tables.TableRowSpan2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import lw8.l;
import va8.p;
import va8.q0;
import va8.r0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class SearchLandingHighlightHelper {
    public static final SearchLandingHighlightHelper a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/text/highlight/SearchLandingHighlightHelper$RawMarkdownBlockKind;", "", "<init>", "(Ljava/lang/String;I)V", "CODE", "TABLE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum RawMarkdownBlockKind extends Enum<RawMarkdownBlockKind> {
        public static final RawMarkdownBlockKind CODE = null;
        public static final RawMarkdownBlockKind TABLE = null;
        public static final /* synthetic */ RawMarkdownBlockKind[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<RawMarkdownBlockKind> getEntries() {
            return b;
        }

        static {
            RawMarkdownBlockKind r0 = new RawMarkdownBlockKind("CODE", 0);
            CODE = r0;
            RawMarkdownBlockKind r1 = new RawMarkdownBlockKind("TABLE", 1);
            TABLE = r1;
            RawMarkdownBlockKind[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static RawMarkdownBlockKind[] values() {
            return (RawMarkdownBlockKind[]) a.clone();
        }

        public static RawMarkdownBlockKind valueOf(String r1) {
            return (RawMarkdownBlockKind) r27.a.a(RawMarkdownBlockKind.class, r1);
        }

        public RawMarkdownBlockKind(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final int a;
        public final int b;
        public final int c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.c;
        }

        public final String toString() {
            return "HighlightRange(start=" + this.a + ", end=" + this.b + ", color=" + this.c + ')';
        }

        public a(int r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b {
        public static final b f = null;
        public final Integer a;
        public final String b;
        public final String c;
        public final boolean d;
        public final IntRange e;

        public static final class a {
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            Integer r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((((r2 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            if (this.d == false) goto L9;
            int r4 = 1231;
        L10:
            int r5 = (r3 + r4) * 31;
            IntRange r6 = this.e;
            if (r6 == null) goto L15;
            r1 = r6.hashCode();
        L15:
            return r5 + r1;
        L9:
            r4 = 1237;
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "LandingTarget(textOffset=" + this.a + ", mode=" + this.b + ", detail=" + this.c + ", preferBlockLanding=" + this.d + ", matchedRange=" + this.e + ')';
        }

        static {
            f = new b(null, "block_top", "", false, 24);
        }

        public b(Integer r2, String r3, String r4, boolean r5, IntRange r6) {
            Intrinsics.checkNotNullParameter(r3, "mode");
            Intrinsics.checkNotNullParameter(r4, "detail");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }

        public /* synthetic */ b(Integer r7, String r8, String r9, boolean r10, int r11) {
            if ((r11 & 8) == 0) goto L5;
            boolean r4 = false;
        L6:
            this(r7, r8, r9, r4, null);
            return;
        L5:
            r4 = r10;
            goto L6
        }
    }

    public static final class c {
        public final String a;
        public final int b;

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
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b;
        }

        public final String toString() {
            return "MarkdownLine(text=" + this.a + ", startIndex=" + this.b + ')';
        }

        public c(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, ChatDraftItem.TYPE_TEXT);
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class d {
        public final int a;
        public final int b;
        public final String c;
        public final int d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
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
            return (((((this.a * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d;
        }

        public final String toString() {
            return "MatchedSpanRange(first=" + this.a + ", last=" + this.b + ", matched=" + this.c + ", matchedFirst=" + this.d + ')';
        }

        public d(int r2, int r3, String r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "matched");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RawMarkdownBlockKind.values().length];
            r0[RawMarkdownBlockKind.CODE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[RawMarkdownBlockKind.TABLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class f<T> implements Comparator {
        public final /* synthetic */ Spanned a;

        public f(Spanned r1) {
            this.a = r1;
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            Spanned r0 = this.a;
            Integer r4 = Integer.valueOf(r0.getSpanStart((usc.e) r2));
            Spanned r1 = this.a;
            return ComparisonsKt.compareValues(r4, Integer.valueOf(r1.getSpanStart((usc.e) r3)));
        }
    }

    static {
        a = new SearchLandingHighlightHelper();
    }

    public SearchLandingHighlightHelper() {
    }

    public static boolean c(TextView r8) {
        CharSequence r0 = r8.getText();
        if ((r0 instanceof Spannable) == true) goto L6;
        r8.setTag(2131385523, null);
        r8.setTag(2131385522, null);
        r8.setTag(2131385525, null);
        r8.setTag(2131385524, null);
        return false;
    L6:
        Object r1 = r8.getTag(2131385522);
        if ((r1 instanceof a) == false) goto L9;
        a r2 = (a) r1;
    L10:
        boolean r3 = o((Spannable) r0, r2);
        if (r3 == false) goto L13;
        r8.invalidate();
    L13:
        r8.setTag(2131385523, null);
        r8.setTag(2131385522, null);
        r8.setTag(2131385525, null);
        r8.setTag(2131385524, null);
        return r3;
    L9:
        r2 = null;
        goto L10
    }

    public static boolean d(View r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if ((r3 instanceof TextView) == false) goto L9;
        return c((TextView) r3);
    L9:
        if ((r3 instanceof ViewGroup) == false) goto L21;
        Iterator r4 = ViewGroupKt.getChildren((ViewGroup) r3).iterator();
    L12:
        if (r4.hasNext() == false) goto L22;
        View r1 = (View) r4.next();
        a.getClass();
        if (d(r1) == false) goto L12;
        return true;
    L22:
        return false;
    L21:
        return false;
    }

    public static String f(String r5) {
        String r6 = StringsKt.trimStart(r5).toString();
        if (StringsKt.startsWith$default(r6, "```", false, 2, null) == false) goto L6;
        return "```";
    L6:
        if (StringsKt.startsWith$default(r6, "~~~", false, 2, null) == false) goto L9;
        return "~~~";
    L9:
        return null;
    }

    public static boolean l(String r6) {
        String r7 = StringsKt.trim(r6).toString();
        if (StringsKt.contains$default(r7, '|', false, 2, null) == false) goto L27;
        int r2 = 0;
    L6:
        if (r2 >= r7.length()) goto L21;
        char r3 = r7.charAt(r2);
        if (r3 != '|') goto L10;
    L17:
        boolean r4 = true;
    L18:
        if (r4 == false) goto L19;
        r2 = r2 + 1;
        goto L6
    L19:
        boolean r8 = false;
    L22:
        if (r8 == false) goto L28;
        return true;
    L28:
        return false;
    L10:
        if (r3 == '-') goto L17;
        if (r3 == ':') goto L17;
        if (CharsKt.isWhitespace(r3) == true) goto L17;
        r4 = false;
        goto L18
    L21:
        r8 = true;
        goto L22
    L27:
        return false;
    }

    public static String n(String r12) {
        String r13 = StringsKt.replace$default(StringsKt.replace$default(r12, "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
        if (r13.length() > 32) goto L6;
        return r13;
    L6:
        return StringsKt.take(r13, 32) + "...";
    }

    public static boolean e(String r3, List r4) {
        if (r3.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L25;
        List r5 = r4;
        if ((r5 instanceof Collection) == true) goto L10;
    L12:
        Iterator r6 = r5.iterator();
    L14:
        if (r6.hasNext() == false) goto L18;
        if (StringsKt.contains(r3, (String) r6.next(), true) == false) goto L14;
        boolean r7 = true;
    L19:
        if (r7 == false) goto L26;
        return true;
    L26:
        return false;
    L18:
        r7 = false;
        goto L19
    L10:
        if (r5.isEmpty() == false) goto L12;
    L25:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    public static List g(String r4, String r5) {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 > (r4.length() - r5.length())) goto L9;
        int r2 = StringsKt.indexOf(r4, r5, r1, true);
        if (r2 < 0) goto L9;
        int r3 = r5.length() + r2;
        r0.add(RangesKt.until(r2, r3));
        r1 = r3;
    L9:
        return r0;
    }

    public static b h(TextView r30, q0 r31) {
        if ((r30 instanceof CustomMarkdownTextView) == false) goto L5;
        CustomMarkdownTextView r2 = (CustomMarkdownTextView) r30;
    L6:
        if (r2 == null) goto L8;
        int r0 = r0.a;
        List r4 = r0.a(r31.b);
        l r1 = r2.getMarkdownContent();
        if (r1 == null) goto L12;
        SpannableStringBuilder r3 = r1.e();
    L14:
        if ((r3 instanceof Spanned) == false) goto L16;
        Spanned r5 = r3;
    L17:
        String r6 = "markdown block target fallback targetMessageId=";
        if (r5 != null) goto L25;
        b r7 = j(r2, r31, r4, null);
        if (r7 == null) goto L22;
        return r7;
    L22:
        FLogger.a.d("search_landing", "markdown block target fallback targetMessageId=" + r31.a + ", reason=markdown_null");
        return b.f;
    L25:
        if (r5.length() != 0) goto L27;
        boolean r8 = true;
    L28:
        if (r8 == false) goto L34;
        b r9 = j(r2, r31, r4, null);
        if (r9 == null) goto L32;
        return r9;
    L32:
        FLogger.a.d("search_landing", "markdown block target fallback targetMessageId=" + r31.a + ", reason=markdown_empty");
        return b.f;
    L34:
        List r10 = ArraysKt.sortedWith(r5.getSpans(0, r5.length(), usc.e.class), new f(r5));
        Iterator r11 = r10.iterator();
    L35:
        String r13 = "";
        if (r11.hasNext() == false) goto L73;
        usc.e r12 = (usc.e) r11.next();
        int r15 = r5.getSpanStart(r12);
        int r14 = r5.getSpanEnd(r12);
        if (r15 < 0) goto L35;
        if (r14 <= r15) goto L35;
        Intrinsics.checkNotNull(r12);
        String r16 = r31.a;
        if (e(r12.h(), r4) == false) goto L44;
        String r17 = "dataValue";
    L69:
        if (r17 == null) goto L35;
        b r18 = new b(Integer.valueOf(r15), "custom_data_span", "dataType=" + n(r12.getDataType()) + ", span=" + r15 + '-' + r14 + ", dataValueId=" + n(r12.k()) + ", matchedSource=" + r17, true, 16);
        FLogger r19 = FLogger.a;
        StringBuilder r20 = new StringBuilder("markdown block target hit targetMessageId=");
        r20.append(r31.a);
        r20.append(", keyword=");
        r20.append(n(r31.b));
        r20.append(", ");
        r20.append(r18.c);
        r19.d("search_landing", r20.toString());
        return r18;
    L44:
        String r21 = r12.l();
        if (r21 != null) goto L48;
        r21 = "";
    L48:
        if (e(r21, r4) == false) goto L51;
        r17 = "dataExtra";
        goto L69
    L51:
        if (r12.k().length() <= 0) goto L53;
        boolean r22 = true;
    L54:
        if (r22 == false) goto L68;
        wc8.b r23 = wc8.b.a;
        String r24 = r23.c(r16, r12.k(), "search_landing");
        if (r24 != null) goto L59;
        r24 = "";
    L59:
        if (e(r24, r4) == false) goto L61;
        r17 = "cacheByMessage";
        goto L69
    L61:
        String r25 = r23.b(r12.k(), "search_landing");
        if (r25 == null) goto L66;
        r13 = r25;
    L66:
        if (e(r13, r4) == false) goto L68;
        r17 = "cache";
    L68:
        r17 = null;
        goto L69
    L53:
        r22 = false;
        goto L54
    L73:
        Object[] r26 = r5.getSpans(0, r5.length(), jw8.b.class);
        ArrayList r27 = new ArrayList();
        int r28 = r26.length;
        int r110 = 0;
    L74:
        if (r110 >= r28) goto L158;
        jw8.b r29 = (jw8.b) r26[r110];
        Integer r111 = Integer.valueOf(r5.getSpanStart(r29));
        if (r111.intValue() < 0) goto L78;
        boolean r112 = true;
    L79:
        if (r112 == true) goto L82;
        r111 = null;
    L82:
        if (r111 != null) goto L94;
        r111 = r29.getStartIndex();
        if (r111 != null) goto L87;
    L92:
        r111 = null;
    L93:
        if (r111 != null) goto L94;
        Object[] r113 = r26;
        int r210 = r28;
        String r211 = r13;
    L154:
        d r114 = null;
    L155:
        if (r114 == null) goto L157;
        r27.add(r114);
    L157:
        r110 = r110 + 1;
        r26 = r113;
        r28 = r210;
        r13 = r211;
        goto L74
    L87:
        if (r111.intValue() < 0) goto L89;
        boolean r115 = true;
    L90:
        if (r115 == false) goto L92;
    L89:
        r115 = false;
    L94:
        int r116 = r111.intValue();
        Integer r117 = Integer.valueOf(r5.getSpanEnd(r29));
        r113 = r26;
        if (r117.intValue() <= r116) goto L97;
        boolean r32 = true;
    L98:
        if (r32 == true) goto L101;
        r117 = null;
    L101:
        if (r117 != null) goto L113;
        Integer r33 = r29.getEndIndex();
        if (r33 != null) goto L106;
    L111:
        r117 = null;
    L112:
        if (r117 != null) goto L113;
        int r34 = r116 + 1;
    L115:
        String r35 = r29.getCode();
        if (r35 != null) goto L119;
        r35 = r13;
    L119:
        if (r35.length() != 0) goto L121;
        boolean r118 = true;
    L122:
        if (r118 == true) goto L300;
    L131:
        Iterator r119 = r4.iterator();
    L133:
        if (r119.hasNext() == false) goto L138;
        Object r120 = r119.next();
        r210 = r28;
        r211 = r13;
        if (StringsKt.contains(r35, (String) r120, true) == true) goto L139;
        r28 = r210;
        r13 = r211;
    L139:
        String r36 = (String) r120;
        if (r36 == null) goto L154;
        Integer r37 = Integer.valueOf(StringsKt.indexOf$default(r35, r36, 0, true, 2, null));
        if (r37.intValue() < 0) goto L145;
        boolean r121 = true;
    L146:
        if (r121 == true) goto L149;
        r37 = null;
    L149:
        if (r37 == null) goto L151;
        int r38 = r37.intValue() + r116;
    L152:
        r114 = new d(r116, r34 - 1, r36, r38);
        goto L155
    L151:
        r38 = r116;
        goto L152
    L145:
        r121 = false;
        goto L146
    L138:
        r210 = r28;
        r211 = r13;
        r120 = null;
        goto L139
    L300:
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L125
        Object r40 = Result.constructor-impl(r5.subSequence(r116, RangesKt.coerceAtMost(r34, r5.length())).toString());     // Catch: Throwable -> L125
    L128:
        if (Result.isFailure-impl(r40) == false) goto L130;
        r40 = r13;
    L130:
        r35 = (String) r40;
    L125:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r40 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L128
    L121:
        r118 = false;
        goto L122
    L106:
        if (r33.intValue() <= r116) goto L108;
        boolean r123 = true;
    L109:
        if (r123 == false) goto L111;
        r117 = r33;
        goto L112
    L108:
        r123 = false;
    L113:
        r34 = r117.intValue();
        goto L115
    L97:
        r32 = false;
        goto L98
    L78:
        r112 = false;
        goto L79
    L158:
        Iterator r41 = r27.iterator();
        if (r41.hasNext() == true) goto L161;
        Object r42 = null;
    L170:
        d r43 = (d) r42;
        if (r43 == null) goto L173;
        Integer r124 = Integer.valueOf(r43.a);
        StringBuilder r44 = new StringBuilder("span=");
        r44.append(r43.a);
        r44.append('-');
        r44.append(r43.b + 1);
        r44.append(", matched=");
        SearchLandingHighlightHelper r125 = a;
        String r126 = r43.c;
        r125.getClass();
        r44.append(n(r126));
        String r212 = r44.toString();
        int r127 = r43.d;
        b r45 = new b(r124, "custom_code_span", r212, true, new IntRange(r127, (r43.c.length() + r127) - 1));
        FLogger.a.d("search_landing", "markdown structural block target hit targetMessageId=" + r31.a + ", keyword=" + n(r31.b) + ", type=custom_code, " + r45.c);
        b r46 = r45;
        CustomMarkdownTextView r213 = r2;
        String r214 = "markdown block target fallback targetMessageId=";
        List r215 = r10;
    L292:
        if (r46 == null) goto L294;
        return r46;
    L294:
        b r47 = j(r213, r31, r4, r5.toString());
        if (r47 == null) goto L297;
        return r47;
    L297:
        int r48 = r5.getSpans(0, r5.length(), jw8.b.class).length;
        int r49 = r5.getSpans(0, r5.length(), CodeBlockWithLineNumberScrollableSpan.class).length;
        int r50 = r5.getSpans(0, r5.length(), TableRowSpan2.class).length;
        FLogger.a.d("search_landing", r214 + r31.a + ", keyword=" + n(r31.b) + ", reason=custom_span_miss, spanCount=" + r215.size() + ", customCodeSpanCount=" + r48 + ", codeSpanCount=" + r49 + ", tableSpanCount=" + r50 + ", markdownLength=" + r5.length());
        return b.f;
    L173:
        Object[] r51 = r5.getSpans(0, r5.length(), CodeBlockWithLineNumberScrollableSpan.class);
        ArrayList r52 = new ArrayList();
        int r53 = r51.length;
        int r128 = 0;
    L174:
        if (r128 >= r53) goto L206;
        Object r54 = r51[r128];
        Object[] r129 = r51;
        int r55 = r5.getSpanStart(r54);
        int r56 = r5.getSpanEnd(r54);
        if (r55 < 0) goto L201;
        if (r56 <= r55) goto L201;
        int r216 = r53;
        String r57 = r5.subSequence(r55, r56).toString();
        Iterator r217 = r4.iterator();
    L181:
        if (r217.hasNext() == false) goto L186;
        Object r218 = r217.next();
        List r219 = r10;
        String r220 = r6;
        if (StringsKt.contains(r57, (String) r218, true) == true) goto L187;
        r10 = r219;
        r6 = r220;
    L187:
        String r58 = (String) r218;
        if (r58 == null) goto L202;
        Integer r59 = Integer.valueOf(StringsKt.indexOf$default(r57, r58, 0, true, 2, null));
        if (r59.intValue() < 0) goto L193;
        boolean r130 = true;
    L194:
        if (r130 == true) goto L197;
        r59 = null;
    L197:
        if (r59 == null) goto L199;
        int r60 = r59.intValue() + r55;
    L200:
        d r131 = new d(r55, r56 - 1, r58, r60);
    L203:
        if (r131 == null) goto L205;
        r52.add(r131);
    L205:
        r128 = r128 + 1;
        r51 = r129;
        r53 = r216;
        r10 = r219;
        r6 = r220;
        goto L174
    L199:
        r60 = r55;
        goto L200
    L193:
        r130 = false;
    L202:
        r131 = null;
        goto L203
    L186:
        r220 = r6;
        r219 = r10;
        r218 = null;
    L201:
        r220 = r6;
        r216 = r53;
        r219 = r10;
        goto L202
    L206:
        r214 = r6;
        r215 = r10;
        Iterator r61 = r52.iterator();
        if (r61.hasNext() == true) goto L209;
        Object r62 = null;
    L218:
        d r63 = (d) r62;
        if (r63 == null) goto L221;
        Integer r221 = Integer.valueOf(r63.a);
        StringBuilder r64 = new StringBuilder("span=");
        r64.append(r63.a);
        r64.append('-');
        r64.append(r63.b + 1);
        r64.append(", matched=");
        SearchLandingHighlightHelper r65 = a;
        String r66 = r63.c;
        r65.getClass();
        r64.append(n(r66));
        String r222 = r64.toString();
        int r67 = r63.d;
        r46 = new b(r221, "code_block_span", r222, true, new IntRange(r67, (r63.c.length() + r67) - 1));
        FLogger.a.d("search_landing", "markdown structural block target hit targetMessageId=" + r31.a + ", keyword=" + n(r31.b) + ", type=code, " + r46.c);
        r213 = r2;
        goto L292
    L221:
        Object[] r68 = r5.getSpans(0, r5.length(), TableRowSpan2.class);
        ArrayList r69 = new ArrayList();
        int r70 = r68.length;
        int r71 = 0;
    L222:
        if (r71 >= r70) goto L232;
        TableRowSpan2 r72 = (TableRowSpan2) r68[r71];
        int r132 = r5.getSpanStart(r72);
        int r73 = r5.getSpanEnd(r72);
        if (r132 < 0) goto L228;
        if (r73 <= r132) goto L228;
        IntRange r74 = RangesKt.until(r132, r73);
    L229:
        if (r74 == null) goto L231;
        r69.add(r74);
    L231:
        r71 = r71 + 1;
    L228:
        r74 = null;
        goto L229
    L232:
        List r75 = CollectionsKt.sortedWith(r69, new com.larus.bmhome.chat.list.cell.text.highlight.c());
        Iterator r76 = r75.iterator();
        int r77 = 0;
    L234:
        if (r76.hasNext() == false) goto L250;
        IntRange r78 = (IntRange) r76.next();
        String r79 = r5.subSequence(r78.getFirst(), r78.getLast() + 1).toString();
        List r80 = r4;
        if ((r80 instanceof Collection) == true) goto L238;
    L240:
        Iterator r81 = r80.iterator();
    L242:
        if (r81.hasNext() == false) goto L246;
        if (StringsKt.contains(r79, (String) r81.next(), true) == false) goto L242;
        boolean r82 = true;
    L247:
        if (r82 == true) goto L248;
        r77 = r77 + 1;
        goto L234
    L248:
        int r83 = r77;
    L251:
        if (r83 < 0) goto L263;
        IntRange r84 = (IntRange) ListProtector.get(r75, r83);
        Iterator r85 = r4.iterator();
    L255:
        if (r85.hasNext() == false) goto L260;
        Object r86 = r85.next();
        Iterator r223 = r85;
        if (StringsKt.contains(r5.subSequence(r84.getFirst(), r84.getLast() + 1).toString(), (String) r86, true) == true) goto L258;
        r85 = r223;
        goto L255
    L258:
        Object r87 = r86;
    L261:
        String r88 = (String) r87;
        if (r88 == null) goto L263;
        int r89 = r84.getFirst();
        int r133 = r83 - 1;
    L266:
        if ((-1) >= r133) goto L271;
        IntRange r134 = (IntRange) ListProtector.get(r75, r133);
        r213 = r2;
        if ((r134.getLast() + 1) < r89) goto L272;
        r89 = r134.getFirst();
        r133 = r133 - 1;
        r2 = r213;
    L272:
        int r90 = r84.getLast();
        int r91 = r83 + 1;
        int r135 = r75.size();
    L273:
        if (r91 >= r135) goto L278;
        IntRange r136 = (IntRange) ListProtector.get(r75, r91);
        List r137 = r75;
        int r224 = r135;
        if (r136.getFirst() > (r90 + 1)) goto L278;
        r90 = r136.getLast();
        r91 = r91 + 1;
        r75 = r137;
        r135 = r224;
    L278:
        Integer r92 = Integer.valueOf(StringsKt.indexOf$default(r5.subSequence(r84.getFirst(), r84.getLast() + 1).toString(), r88, 0, true, 2, null));
        if (r92.intValue() < 0) goto L281;
        boolean r93 = true;
    L282:
        if (r93 == true) goto L285;
        r92 = null;
    L285:
        if (r92 == null) goto L287;
        int r94 = r84.getFirst() + r92.intValue();
    L288:
        d r95 = new d(r89, r90, r88, r94);
    L289:
        if (r95 == null) goto L291;
        Integer r225 = Integer.valueOf(r95.a);
        StringBuilder r96 = new StringBuilder("span=");
        r96.append(r95.a);
        r96.append('-');
        r96.append(r95.b + 1);
        r96.append(", matched=");
        SearchLandingHighlightHelper r97 = a;
        String r99 = r95.c;
        r97.getClass();
        r96.append(n(r99));
        String r226 = r96.toString();
        int r100 = r95.d;
        r46 = new b(r225, "table_span", r226, true, new IntRange(r100, (r95.c.length() + r100) - 1));
        FLogger.a.d("search_landing", "markdown structural block target hit targetMessageId=" + r31.a + ", keyword=" + n(r31.b) + ", type=table, " + r46.c);
        goto L292
    L291:
        r46 = null;
        goto L292
    L287:
        r94 = r84.getFirst();
        goto L288
    L281:
        r93 = false;
        goto L282
    L271:
        r213 = r2;
        goto L272
    L260:
        r87 = null;
    L263:
        r213 = r2;
        r95 = null;
    L246:
        r82 = false;
        goto L247
    L238:
        if (r80.isEmpty() == false) goto L240;
    L250:
        r83 = -1;
        goto L251
    L209:
        r62 = r61.next();
        if (r61.hasNext() == false) goto L218;
        int r101 = ((d) r62).d;
    L213:
        Object r102 = r61.next();
        int r103 = ((d) r102).d;
        if (r101 <= r103) goto L217;
        r62 = r102;
        r101 = r103;
    L217:
        if (r61.hasNext() == true) goto L213;
    L161:
        r42 = r41.next();
        if (r41.hasNext() == false) goto L170;
        int r104 = ((d) r42).d;
    L165:
        Object r105 = r41.next();
        int r138 = ((d) r105).d;
        if (r104 <= r138) goto L169;
        r42 = r105;
        r104 = r138;
    L169:
        if (r41.hasNext() == true) goto L165;
    L27:
        r8 = false;
        goto L28
    L16:
        r5 = null;
        goto L17
    L12:
        r3 = null;
        goto L14
    L8:
        return b.f;
    L5:
        r2 = null;
        goto L6
    }

    public static Integer i(List r5, int r6) {
        int r7 = RangesKt.coerceAtMost(r6, CollectionsKt.getLastIndex(r5));
        if (r7 < 0) goto L18;
        int r1 = 0;
        Integer r2 = null;
        String r3 = null;
    L5:
        String r4 = f(((c) ListProtector.get(r5, r1)).a);
        if (r4 == null) goto L13;
        if (r2 != null) goto L11;
        r2 = Integer.valueOf(r1);
        r3 = r4;
        goto L13
    L11:
        if (Intrinsics.areEqual(r4, r3) == false) goto L13;
        r2 = null;
        r3 = null;
    L13:
        if (r1 == r7) goto L16;
        r1 = r1 + 1;
        goto L5
    L16:
        return r2;
    L18:
        return null;
    }

    public static boolean k(List r6, int r7) {
        c r0 = (c) CollectionsKt.getOrNull(r6, r7);
        if (r0 == null) goto L31;
        String r1 = r0.a;
        if (r1 == null) goto L33;
        String r4 = null;
        if (StringsKt.contains$default(r1, '|', false, 2, null) == true) goto L10;
        return false;
    L10:
        c r2 = (c) CollectionsKt.getOrNull(r6, r7 - 1);
        if (r2 == null) goto L13;
        String r3 = r2.a;
    L14:
        String r5 = "";
        if (r3 != null) goto L17;
        r3 = "";
    L17:
        c r8 = (c) CollectionsKt.getOrNull(r6, r7 + 1);
        if (r8 == null) goto L20;
        r4 = r8.a;
    L20:
        if (r4 == null) goto L24;
        r5 = r4;
    L24:
        if (l(r3) == false) goto L26;
    L29:
        return true;
    L26:
        if (l(r5) == true) goto L29;
        if (l(r1) == true) goto L29;
        return false;
    L13:
        r3 = null;
        goto L14
    L33:
        return false;
    L31:
        return false;
    }

    public static void m(TextView r3, b r4) {
        r3.setTag(2131385525, Boolean.TRUE);
        Integer r0 = r4.a;
        if (r0 != null) goto L5;
    L10:
        r0 = null;
    L11:
        r3.setTag(2131385524, r0);
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("mark matched block target view=");
        r2.append(r3.getClass().getSimpleName());
        r2.append(", mode=");
        r2.append(r4.b);
        r2.append(", textOffset=");
        Integer r5 = r4.a;
        if (r5 == null) goto L14;
        int r6 = r5.intValue();
    L15:
        r2.append(r6);
        r2.append(", detail=");
        r2.append(r4.c);
        r1.d("search_landing", r2.toString());
        return;
    L14:
        r6 = -1;
        goto L15
    L5:
        if (r0.intValue() < 0) goto L7;
        boolean r7 = true;
    L8:
        if (r7 == false) goto L10;
    L7:
        r7 = false;
        goto L8
    }

    public static boolean o(Spannable r9, a r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r10.a >= 0) goto L8;
    L32:
        return false;
    L8:
        if (r10.b > r9.length()) goto L32;
        int r1 = r10.a;
        int r2 = r10.b;
        if (r1 >= r2) goto L32;
        BackgroundColorSpan[] r3 = (BackgroundColorSpan[]) r9.getSpans(r1, r2, BackgroundColorSpan.class);
        Intrinsics.checkNotNull(r3);
        ArrayList r4 = new ArrayList();
        int r5 = r3.length;
        int r6 = 0;
    L13:
        boolean r7 = true;
        if (r6 >= r5) goto L26;
        BackgroundColorSpan r8 = r3[r6];
        if (r9.getSpanStart(r8) == r10.a) goto L18;
    L22:
        r7 = false;
    L23:
        if (r7 == false) goto L25;
        r4.add(r8);
    L25:
        r6 = r6 + 1;
        goto L13
    L18:
        if (r9.getSpanEnd(r8) != r10.b) goto L22;
        if (r8.getBackgroundColor() != r10.c) goto L22;
    L26:
        Iterator r11 = r4.iterator();
    L28:
        if (r11.hasNext() == false) goto L31;
        r9.removeSpan((BackgroundColorSpan) r11.next());
        goto L28
    L31:
        return !r4.isEmpty();
    }

    public static b j(CustomMarkdownTextView r23, q0 r24, List r25, String r26) {
        String r1 = r23.getOriginText();
        boolean r3 = true;
        if (r1 != null) goto L5;
    L10:
        r1 = null;
    L11:
        if (r26 != null) goto L13;
    L21:
        CharSequence r5 = r23.getText();
        if (r5 == null) goto L31;
        String r6 = r5.toString();
        if (r6 == null) goto L31;
        if (r6.length() <= 0) goto L28;
        boolean r7 = true;
    L29:
        if (r7 == false) goto L31;
    L32:
        if (r1 != null) goto L34;
        final String r8 = r6;
    L35:
        if (r8 != null) goto L37;
    L40:
        boolean r9 = true;
    L42:
        if (r9 == false) goto L58;
        FLogger r10 = FLogger.a;
        StringBuilder r11 = new StringBuilder("raw markdown block target miss targetMessageId=");
        r11.append(r24.a);
        r11.append(", reason=source_empty, originEmpty=");
        if (r1 != null) goto L46;
    L49:
        boolean r0 = true;
    L50:
        r11.append(r0);
        r11.append(", renderedEmpty=");
        if (r6 != null) goto L53;
    L56:
        r11.append(r3);
        r10.d("search_landing", r11.toString());
        return null;
    L53:
        if (r6.length() == 0) goto L56;
        r3 = false;
        goto L56
    L46:
        if (r1.length() == 0) goto L49;
        r0 = false;
        goto L50
    L58:
        if (r1 == null) goto L60;
        String r12 = "origin";
    L61:
        Iterator r13 = SequencesKt.mapNotNull(CollectionsKt.asSequence(r25), new com.larus.bmhome.chat.list.cell.text.highlight.b(r8)).iterator();
        if (r13.hasNext() == true) goto L64;
        Object r14 = null;
    L73:
        Pair r15 = (Pair) r14;
        if (r15 != null) goto L77;
        FLogger.a.d("search_landing", "raw markdown block target miss targetMessageId=" + r24.a + ", reason=keyword_miss, source=" + r12 + ", sourceLength=" + r8.length());
        return null;
    L77:
        ArrayList r16 = new ArrayList();
        Iterator r17 = StringsKt.split$default(r8, new char[]{'\n'}, false, 0, 6, null).iterator();
        int r18 = 0;
    L79:
        if (r17.hasNext() == false) goto L81;
        String r19 = (String) r17.next();
        r16.add(new c(r19, r18));
        r18 = r18 + (r19.length() + 1);
        goto L79
    L81:
        ListIterator r20 = r16.listIterator(r16.size());
    L82:
        int r21 = -1;
        if (r20.hasPrevious() == false) goto L90;
        if (((c) r20.previous()).b > ((Number) r15.getFirst()).intValue()) goto L87;
        boolean r22 = true;
    L88:
        if (r22 == false) goto L82;
        int r27 = r20.nextIndex();
    L91:
        int r28 = RangesKt.coerceAtLeast(r27, 0);
        if (r1 != null) goto L94;
    L99:
        RawMarkdownBlockKind r29 = null;
    L100:
        if (r1 != null) goto L102;
    L113:
        int r30 = r28;
    L114:
        c r110 = (c) CollectionsKt.getOrNull(r16, r30);
        if (r110 == null) goto L117;
        String r111 = r110.a;
    L119:
        if (r111 != null) goto L122;
        r111 = "";
    L122:
        if (f(r111) == null) goto L146;
        Iterator r2 = new IntRange(r30 + 1, RangesKt.coerceAtMost(r28, CollectionsKt.getLastIndex(r16))).iterator();
    L125:
        if (r2.hasNext() == false) goto L140;
        Object r112 = r2.next();
        c r113 = (c) CollectionsKt.getOrNull(r16, ((Number) r112).intValue());
        if (r113 == null) goto L129;
        String r114 = r113.a;
    L130:
        if (r114 != null) goto L133;
        r114 = "";
    L133:
        if ((!StringsKt.isBlank(r114)) == false) goto L137;
        a.getClass();
        if (f(r114) != null) goto L137;
        boolean r115 = true;
    L138:
        if (r115 == false) goto L125;
    L141:
        Integer r116 = (Integer) r112;
        if (r116 == null) goto L144;
        int r4 = r116.intValue();
    L170:
        if (r1 == null) goto L200;
        c r31 = (c) CollectionsKt.getOrNull(r16, r4);
        if (r31 == null) goto L174;
        String r32 = r31.a;
    L175:
        if (r32 != null) goto L177;
        r32 = "";
    L177:
        CharSequence r117 = r23.getText();
        if (r117 == null) goto L180;
        String r118 = r117.toString();
    L181:
        if (r118 != null) goto L183;
        String r119 = "";
    L184:
        String r33 = StringsKt.trim(StringsKt.trim(StringsKt.trim(StringsKt.trimStart(StringsKt.trim(r32).toString(), new char[]{'#', '>', '-', '*', '+'})).toString(), new char[]{'|'})).toString();
        if (r33.length() < 2) goto L187;
        boolean r120 = true;
    L188:
        if (r120 == false) goto L190;
        String r121 = r33;
    L191:
        if (r121 == null) goto L199;
        Integer r34 = Integer.valueOf(StringsKt.indexOf$default(r119, r121, 0, true, 2, null));
        if (r34.intValue() < 0) goto L196;
        boolean r122 = true;
    L197:
        if (r122 == false) goto L199;
    L201:
        Integer r123 = r34;
    L203:
        if (r29 != null) goto L205;
        int r124 = -1;
    L206:
        if (r124 == 1) goto L210;
        if (r124 == 2) goto L209;
        String r125 = "raw_markdown_line";
    L211:
        String r126 = r125;
        StringBuilder r127 = new StringBuilder("source=");
        r127.append(r12);
        r127.append(", keywordLine=");
        r127.append(r28);
        r127.append(", blockStartLine=");
        r127.append(r30);
        r127.append(", visualAnchorLine=");
        r127.append(r4);
        r127.append(", renderedOffset=");
        if (r123 == null) goto L214;
        r21 = r123.intValue();
    L214:
        r127.append(r21);
        r127.append(", matched=");
        r127.append(n((String) r15.getSecond()));
        String r128 = r127.toString();
        if (r29 != RawMarkdownBlockKind.CODE) goto L217;
    L220:
        boolean r129 = true;
    L221:
        b r35 = new b(r123, r126, r128, r129, 16);
        FLogger.a.d("search_landing", "raw markdown block target hit targetMessageId=" + r24.a + ", keyword=" + n(r24.b) + ", " + r35.c);
        return r35;
    L217:
        if (r29 == RawMarkdownBlockKind.TABLE) goto L220;
        r129 = false;
        goto L221
    L209:
        r125 = "raw_table_block";
        goto L211
    L210:
        r125 = "raw_code_block";
        goto L211
    L205:
        r124 = e.a[r29.ordinal()];
        goto L206
    L196:
        r122 = false;
    L199:
        r123 = null;
        goto L203
    L190:
        r121 = null;
        goto L191
    L187:
        r120 = false;
        goto L188
    L183:
        r119 = r118;
        goto L184
    L180:
        r118 = null;
        goto L181
    L174:
        r32 = null;
        goto L175
    L200:
        r34 = (Integer) r15.getFirst();
        goto L201
    L144:
        r4 = r28;
    L137:
        r115 = false;
        goto L138
    L129:
        r114 = null;
        goto L130
    L140:
        r112 = null;
        goto L141
    L146:
        if (k(r16, r30) == false) goto L168;
        Iterator r36 = new IntRange(r30, RangesKt.coerceAtMost(r28, CollectionsKt.getLastIndex(r16))).iterator();
    L149:
        if (r36.hasNext() == false) goto L164;
        Object r130 = r36.next();
        c r131 = (c) CollectionsKt.getOrNull(r16, ((Number) r130).intValue());
        if (r131 == null) goto L153;
        String r132 = r131.a;
    L154:
        if (r132 != null) goto L157;
        r132 = "";
    L157:
        if ((!StringsKt.isBlank(r132)) == false) goto L161;
        a.getClass();
        if (l(r132) == true) goto L161;
        boolean r133 = true;
    L162:
        if (r133 == false) goto L149;
    L165:
        Integer r134 = (Integer) r130;
        if (r134 == null) goto L168;
        r4 = r134.intValue();
    L161:
        r133 = false;
        goto L162
    L153:
        r132 = null;
        goto L154
    L164:
        r130 = null;
    L168:
        r4 = r30;
        goto L170
    L117:
        r111 = null;
        goto L119
    L102:
        if (r29 != RawMarkdownBlockKind.CODE) goto L107;
        Integer r37 = i(r16, r28);
        if (r37 == null) goto L113;
        r30 = r37.intValue();
        goto L114
    L107:
        if (r29 != RawMarkdownBlockKind.TABLE) goto L113;
        r30 = r28;
    L109:
        if (r30 <= 0) goto L114;
        int r135 = r30 - 1;
        if (k(r16, r135) == false) goto L114;
        r30 = r135;
        goto L109
    L94:
        if (i(r16, r28) == null) goto L97;
        r29 = RawMarkdownBlockKind.CODE;
        goto L100
    L97:
        if (k(r16, r28) == false) goto L99;
        r29 = RawMarkdownBlockKind.TABLE;
        goto L100
    L87:
        r22 = false;
        goto L88
    L90:
        r27 = -1;
        goto L91
    L64:
        r14 = r13.next();
        if (r13.hasNext() == false) goto L73;
        int r136 = ((Number) ((Pair) r14).getFirst()).intValue();
    L68:
        Object r137 = r13.next();
        int r138 = ((Number) ((Pair) r137).getFirst()).intValue();
        if (r136 <= r138) goto L72;
        r14 = r137;
        r136 = r138;
    L72:
        if (r13.hasNext() == true) goto L68;
    L60:
        r12 = "rendered";
        goto L61
    L37:
        if (r8.length() == 0) goto L40;
        r9 = false;
        goto L42
    L34:
        r8 = r1;
        goto L35
    L28:
        r7 = false;
    L31:
        r6 = null;
        goto L32
    L13:
        if (r26.length() <= 0) goto L15;
        boolean r38 = true;
    L16:
        if (r38 == false) goto L18;
        r6 = r26;
    L19:
        if (r6 == null) goto L21;
    L18:
        r6 = null;
        goto L19
    L15:
        r38 = false;
        goto L16
    L5:
        if (r1.length() <= 0) goto L7;
        boolean r39 = true;
    L8:
        if (r39 == false) goto L10;
    L7:
        r39 = false;
        goto L8
    }

    public static /* synthetic */ boolean b(SearchLandingHighlightHelper r10, CustomMarkdownTextView r11, q0 r12, p r13, boolean r14, int r15) {
        if ((r15 & 8) == 0) goto L5;
        boolean r6 = false;
    L7:
        if ((r15 & 16) == 0) goto L9;
        boolean r7 = true;
    L11:
        if ((r15 & 32) == 0) goto L13;
        long r16 = SystemClock.elapsedRealtime();
    L15:
        return r10.a(r11, r12, r13, r6, r7, r16);
    L13:
        r16 = 0;
        goto L15
    L9:
        r7 = false;
        goto L11
    L5:
        r6 = r14;
        goto L7
    }

    public final boolean a(final TextView r24, final q0 r25, final p r26, boolean r27, boolean r28, long r29) {
        if (r24 != null) goto L5;
        return false;
    L5:
        if (r25 != null) goto L8;
        c(r24);
        return false;
    L8:
        CharSequence r5 = r24.getText();
        if (r5 != null) goto L11;
        return false;
    L11:
        FLogger r6 = FLogger.a;
        StringBuilder r8 = new StringBuilder("landing pipeline enter targetMessageId=");
        r8.append(r25.a);
        r8.append(", keyword=");
        r8.append(n(r25.b));
        r8.append(", textLength=");
        r8.append(r5.length());
        r8.append(", view=");
        r8.append(r24.getClass().getSimpleName());
        r8.append(", layoutReady=");
        if (r24.getLayout() == null) goto L14;
        boolean r12 = true;
    L15:
        r8.append(r12);
        r8.append(", allowBlockLandingOnMiss=");
        r8.append(r27);
        r8.append(", allowRetryBeforeDraw=");
        r8.append(r28);
        r8.append(", sinceOpenMs=");
        long r13 = r25.d;
        long r17 = -1;
        if (r13 <= 0) goto L18;
        long r14 = RangesKt.coerceAtLeast(r29 - r13, 0);
    L19:
        r8.append(r14);
        r6.d("search_landing", r8.toString());
        if (r27 == false) goto L22;
        m(r24, b.f);
    L22:
        String r7 = r5.toString();
        String r15 = r25.b;
        Intrinsics.checkNotNullParameter(r7, ChatDraftItem.TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r15, "keyword");
        if (r7.length() != 0) goto L25;
        boolean r16 = true;
    L26:
        Integer r19 = null;
        if (r16 == false) goto L29;
        List r9 = CollectionsKt.emptyList();
    L40:
        IntRange r10 = (IntRange) CollectionsKt.firstOrNull(r9);
        if (r10 != null) goto L64;
        FLogger r11 = FLogger.a;
        StringBuilder r18 = new StringBuilder("highlight miss targetMessageId=");
        r18.append(r25.a);
        r18.append(", keyword=");
        r18.append(n(r25.b));
        r18.append(", textLength=");
        r18.append(r5.length());
        r18.append(", view=");
        r18.append(r24.getClass().getSimpleName());
        r18.append(", allowBlockLandingOnMiss=");
        r18.append(r27);
        r18.append(", pipelineCostMs=");
        r18.append(SystemClock.elapsedRealtime() - r29);
        r18.append(", sinceOpenMs=");
        long r110 = SystemClock.elapsedRealtime();
        long r20 = r25.d;
        if (r20 <= 0) goto L45;
        long r21 = RangesKt.coerceAtLeast(r110 - r20, 0);
    L46:
        r18.append(r21);
        r11.d("search_landing", r18.toString());
        if (r5.length() != 0) goto L49;
        boolean r22 = true;
    L50:
        if (r22 == false) goto L60;
        if (r24.getLayout() != null) goto L60;
        if (r28 == false) goto L60;
        StringBuilder r0 = new StringBuilder("schedule retry targetMessageId=");
        r0.append(r25.a);
        r0.append(", keyword=");
        r0.append(n(r25.b));
        r0.append(", allowBlockLandingOnMiss=");
        r0.append(r27);
        r0.append(", pipelineCostMs=");
        r0.append(SystemClock.elapsedRealtime() - r29);
        r0.append(", sinceOpenMs=");
        long r23 = SystemClock.elapsedRealtime();
        long r30 = r25.d;
        if (r30 <= 0) goto L57;
        r17 = RangesKt.coerceAtLeast(r23 - r30, 0);
    L57:
        r0.append(r17);
        r11.d("search_landing", r0.toString());
        r24.getViewTreeObserver().addOnPreDrawListener(new com.larus.bmhome.chat.list.cell.text.highlight.d(r24, r25, r26, r27, r29));
        return false;
    L60:
        if (r27 == false) goto L62;
        m(r24, h(r24, r25));
    L62:
        return false;
    L49:
        r22 = false;
        goto L50
    L45:
        r21 = -1;
        goto L46
    L64:
        if (r27 == false) goto L66;
        b r4 = h(r24, r25);
    L67:
        if (r4 != null) goto L69;
    L79:
        r4 = null;
    L80:
        if (r4 == null) goto L83;
        a.getClass();
        m(r24, r4);
    L83:
        if (r4 == null) goto L85;
        FLogger.a.d("search_landing", "prefer markdown block landing targetMessageId=" + r25.a + ", keyword=" + n(r25.b) + ", range=" + r10.getFirst() + '-' + r10.getLast() + ", blockTargetMode=" + r4.b + ", blockTargetDetail=" + r4.c);
    L85:
        FLogger r1 = FLogger.a;
        StringBuilder r31 = new StringBuilder("highlight hit targetMessageId=");
        r31.append(r25.a);
        r31.append(", keyword=");
        r31.append(n(r25.b));
        r31.append(", range=");
        r31.append(r10.getFirst());
        r31.append('-');
        r31.append(r10.getLast());
        r31.append(", textLength=");
        r31.append(r5.length());
        r31.append(", view=");
        r31.append(r24.getClass().getSimpleName());
        r31.append(", pipelineCostMs=");
        r31.append(SystemClock.elapsedRealtime() - r29);
        r31.append(", sinceOpenMs=");
        long r32 = SystemClock.elapsedRealtime();
        long r33 = r25.d;
        if (r33 <= 0) goto L88;
        r17 = RangesKt.coerceAtLeast(r32 - r33, 0);
    L88:
        r31.append(r17);
        r1.d("search_landing", r31.toString());
        boolean r2 = r5 instanceof Spannable;
        if (r2 == false) goto L91;
        Spannable r3 = (Spannable) r5;
    L92:
        if (r3 != null) goto L94;
        r3 = new SpannableStringBuilder(r5);
    L94:
        boolean r34 = !r2;
        Object r35 = r24.getTag(2131385522);
        if ((r35 instanceof a) == false) goto L97;
        a r36 = (a) r35;
    L98:
        o(r3, r36);
        if ((r24 instanceof CustomMarkdownTextView) == false) goto L101;
        int r37 = ((CustomMarkdownTextView) r24).getSelectedColor();
    L110:
        r3.setSpan(new BackgroundColorSpan(r37), r10.getFirst(), r10.getLast() + 1, 33);
        final Object r38 = new Object();
        r24.setTag(2131385523, r38);
        r24.setTag(2131385522, new a(r10.getFirst(), r10.getLast() + 1, r37));
        if (r34 == false) goto L113;
        r24.setText(r3, TextView.BufferType.SPANNABLE);
    L115:
        if (r26 == null) goto L117;
        r26.Py(r25);
    L117:
        r24.postDelayed(new com.larus.bmhome.chat.list.cell.text.highlight.a(r24, r38, r26, r25), r25.c);
        return true;
    L113:
        r24.invalidate();
        goto L115
    L101:
        Integer r39 = Integer.valueOf(r24.getHighlightColor());
        if (r39.intValue() == 0) goto L104;
        boolean r40 = true;
    L105:
        if (r40 == false) goto L107;
        r19 = r39;
    L107:
        if (r19 == null) goto L109;
        r37 = r19.intValue();
        goto L110
    L109:
        r37 = ContextCompat.getColor(r24.getContext(), v19.c.b(2130972129, r24.getContext(), 2131103221));
        goto L110
    L104:
        r40 = false;
        goto L105
    L97:
        r36 = null;
        goto L98
    L91:
        r3 = null;
        goto L92
    L69:
        if (r4.d == false) goto L76;
        Intrinsics.checkNotNullParameter(r10, "range");
        IntRange r41 = r4.e;
        if (r41 != null) goto L73;
        boolean r42 = false;
    L74:
        if (r42 == false) goto L76;
        boolean r111 = true;
    L77:
        if (r111 == false) goto L79;
    L73:
        r42 = Intrinsics.areEqual(r41, r10);
    L76:
        r111 = false;
        goto L77
    L66:
        r4 = null;
        goto L67
    L29:
        Iterator r112 = r0.a(r15).iterator();
    L31:
        if (r112.hasNext() == false) goto L35;
        Object r210 = r112.next();
        a.getClass();
        if ((!((ArrayList) g(r7, (String) r210)).isEmpty()) == false) goto L31;
    L36:
        String r113 = (String) r210;
        if (r113 != null) goto L39;
        r9 = CollectionsKt.emptyList();
        goto L40
    L39:
        r9 = g(r7, r113);
        goto L40
    L35:
        r210 = null;
        goto L36
    L25:
        r16 = false;
        goto L26
    L18:
        r14 = -1;
        goto L19
    L14:
        r12 = false;
        goto L15
    }
}
