package vt8;

import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.larus.business.markdown.impl.markwon.MarkwonContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f implements d {
    public static final List<String> c = null;
    public final CustomMarkdownTextView a;
    public final List<b> b;

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final int b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "start=" + this.a + ",end=" + this.b + ",value=" + this.c;
        }

        public b(int r2, int r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "value");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    @Override // vt8.d
    public final int b() {
        return 4;
    }

    static {
        c = CollectionsKt.mutableListOf(new String[]{"。", "\\? ", "？", "\\! ", "！", "- ", "\\. ", "\\.{6}", "\\.{3}", "·{6}", "·{3}", "…{2}", "…{1}", "\n"});
    }

    public f(CustomMarkdownTextView r1) {
        this.a = r1;
        this.b = new ArrayList();
    }

    @Override // vt8.d
    public final Pair<Integer, Integer> a(String r14, int r15) {
        Intrinsics.checkNotNullParameter(r14, "txt");
        Object r0 = null;
        int r1 = 0;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        ((ArrayList) this.b).clear();     // Catch: Throwable -> L9
        Iterator r3 = Regex.findAll$default(new Regex(CollectionsKt.joinToString$default(c, "|", null, null, 0, null, null, 62, null)), r14, 0, 2, null).iterator();     // Catch: Throwable -> L9
    L5:
        if (r3.hasNext() == false) goto L7;
        MatchResult r4 = (MatchResult) r3.next();     // Catch: Throwable -> L9
        ((ArrayList) this.b).add(new b(r4.getRange().getFirst(), r4.getRange().getLast(), r4.getValue()));     // Catch: Throwable -> L9
        goto L5
    L7:
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L18;
        com.larus.business.markdown.api.depend.d r7 = IMarkdownLoggerKt.a();
        if (r7 == null) goto L17;
        r7.e("SentenceSelectionStrategy", "parseMarks failed:" + r6);
        r5 = Unit.INSTANCE;
        goto L18
    L17:
        r5 = null;
    L18:
        Unit r8 = (Unit) r5;
        Ref.IntRef r9 = new Ref.IntRef();
        Ref.IntRef r10 = new Ref.IntRef();
        r10.element = r14.length();
    L34:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Object r16 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r12 = Result.exceptionOrNull-impl(r16);
        if (r12 != null) goto L38;
        r0 = r16;
    L41:
        Pair<b, b> r17 = (Pair) r0;
    L42:
        if (r17 == null) goto L51;
        b r13 = (b) r17.getFirst();
        if (r13 == null) goto L46;
        r1 = Integer.valueOf(r13.b + 1).intValue();
    L46:
        r9.element = r1;
        b r18 = (b) r17.getSecond();
        if (r18 == null) goto L49;
        int r19 = Integer.valueOf(r18.b + 1).intValue();
    L50:
        r10.element = r19;
        goto L51
    L49:
        r19 = r14.length();
    L51:
        Pair<Integer, Integer> r110 = TuplesKt.to(Integer.valueOf(RangesKt.coerceAtMost(r9.element, r10.element)), Integer.valueOf(RangesKt.coerceAtLeast(r9.element, r10.element)));
        Pair<Integer, Integer> r111 = c.d(r14, r110);
        if (r111 != null) goto L55;
        return r110;
    L55:
        return r111;
    L38:
        com.larus.business.markdown.api.depend.d r112 = IMarkdownLoggerKt.a();
        if (r112 == null) goto L41;
        r112.e("SentenceSelectionStrategy", "getMarkPair failed:" + r12);
        goto L41
    L20:
        if (((ArrayList) this.b).isEmpty() == false) goto L22;
        r17 = new Pair(null, null);     // Catch: Throwable -> L34
        goto L42
    L22:
        Iterator r20 = ((ArrayList) this.b).iterator();     // Catch: Throwable -> L34
        int r21 = 0;
    L24:
        if (r20.hasNext() == false) goto L32;
        Object r22 = r20.next();     // Catch: Throwable -> L34
        int r23 = r21 + 1;     // Catch: Throwable -> L34
        if (r21 >= 0) goto L29;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L34
    L29:
        if (((b) r22).b >= r15) goto L30;
        r21 = r23;
        goto L24
    L30:
        r17 = c(r14, r21);     // Catch: Throwable -> L34
        goto L42
    L32:
        r17 = new Pair(CollectionsKt.last(this.b), null);     // Catch: Throwable -> L34
    L9:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final Pair<b, b> c(String r14, int r15) {
        int r1 = r15 - 1;
        b r0 = (b) CollectionsKt.getOrNull(this.b, r1);
        b r2 = (b) CollectionsKt.getOrNull(this.b, r15);
        boolean r3 = false;
        if (r0 == null) goto L5;
        int r5 = r0.b + 1;
    L6:
        if (r2 == null) goto L8;
        int r6 = r2.b + 1;
    L10:
        if (StringsKt.trim(StringsKt.replace$default(r14.substring(r5, r6), "\n", "", false, 4, null)).toString().length() != 0) goto L12;
        boolean r7 = true;
    L13:
        CustomMarkdownTextView r8 = this.a;
        if (r8 == null) goto L21;
        MarkwonContent r9 = r8.getMarkwonContent();
        if (r9 == null) goto L21;
        if (((io.noties.markwon.ext.onetex.c[]) r9.a.getSpans(r5, r6, io.noties.markwon.ext.onetex.c.class)).length != 0) goto L20;
        r3 = true;
    L20:
        r3 = !r3;
    L21:
        if (r15 <= 0) goto L26;
        if (r7 == false) goto L26;
        if (r3 == true) goto L26;
        return c(r14, r1);
    L26:
        return TuplesKt.to(r0, r2);
    L12:
        r7 = false;
        goto L13
    L8:
        r6 = r14.length();
        goto L10
    L5:
        r5 = 0;
        goto L6
    }
}
