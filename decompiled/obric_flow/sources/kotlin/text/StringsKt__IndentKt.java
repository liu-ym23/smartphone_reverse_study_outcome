package kotlin.text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u001a!\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0002\b\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0002\b\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001aJ\u0010\t\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u0082\b¢\u0006\u0002\b\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u001a\u001e\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u001a\f\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0016\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002H\u0007¨\u0006\u0015"}, d2 = {"getIndentFunction", "Lkotlin/Function1;", "", "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/StringsKt")
@SourceDebugExtension({"SMAP\nIndent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Indent.kt\nkotlin/text/StringsKt__IndentKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,123:1\n113#1,2:125\n115#1,4:140\n120#1,2:153\n113#1,2:162\n115#1,4:177\n120#1,2:184\n1#2:124\n1#2:150\n1#2:181\n1#2:205\n1577#3,11:127\n1872#3,2:138\n1874#3:151\n1588#3:152\n774#3:155\n865#3,2:156\n1557#3:158\n1628#3,3:159\n1577#3,11:164\n1872#3,2:175\n1874#3:182\n1588#3:183\n1577#3,11:192\n1872#3,2:203\n1874#3:206\n1588#3:207\n158#4,6:144\n158#4,6:186\n*S KotlinDebug\n*F\n+ 1 Indent.kt\nkotlin/text/StringsKt__IndentKt\n*L\n38#1:125,2\n38#1:140,4\n38#1:153,2\n78#1:162,2\n78#1:177,4\n78#1:184,2\n38#1:150\n78#1:181\n114#1:205\n38#1:127,11\n38#1:138,2\n38#1:151\n38#1:152\n74#1:155\n74#1:156,2\n75#1:158\n75#1:159,3\n78#1:164,11\n78#1:175,2\n78#1:182\n78#1:183\n114#1:192,11\n114#1:203,2\n114#1:206\n114#1:207\n39#1:144,6\n101#1:186,6\n*E\n"})
class StringsKt__IndentKt extends StringsKt__AppendableKt {
    public StringsKt__IndentKt() {
    }

    private static final Function1<String, String> getIndentFunction$StringsKt__IndentKt(final String r5) {
        if (r5.length() != 0) goto L6;
        return StringsKt__IndentKt$getIndentFunction$1.INSTANCE;
    L6:
        return new StringsKt__IndentKt$getIndentFunction$2(r5);
    }

    private static final int indentWidth$StringsKt__IndentKt(String r5) {
        int r10 = r5.length();
        int r11 = 0;
    L4:
        if (r11 >= r10) goto L9;
        if (CharsKt__CharJVMKt.isWhitespace(r5.charAt(r11)) == false) goto L10;
        r11 = r11 + 1;
    L10:
        if (r11 == (-1)) goto L12;
        return r11;
    L12:
        return r5.length();
    L9:
        r11 = -1;
        goto L10
    }

    public static String prependIndent(String r5, final String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "indent");
        return SequencesKt.c(SequencesKt.map(StringsKt__StringsKt.lineSequence(r5), new AnonymousClass1(r10)), "\n");
    }

    public static /* synthetic */ String prependIndent$default(String r5, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = "    ";
    L6:
        return prependIndent(r5, r10);
    }

    private static final String reindent$StringsKt__IndentKt(List<String> r10, int r11, Function1<? super String, String> r12, Function1<? super String, String> r13) {
        int r5 = CollectionsKt.getLastIndex(r10);
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r10.iterator();
        int r16 = 0;
    L4:
        if (r15.hasNext() == false) goto L28;
        Object r17 = r15.next();
        int r18 = r16 + 1;
        if (r16 < 0) goto L8;
    L12:
        String r19 = (String) r17;
        if (r16 == 0) goto L16;
        if (r16 == r5) goto L16;
    L18:
        String r20 = r13.invoke(r19);
        if (r20 == null) goto L24;
        String r21 = r12.invoke(r20);
        if (r21 == null) goto L24;
        r19 = r21;
    L24:
        if (r19 == null) goto L26;
        r14.add(r19);
    L26:
        r16 = r18;
    L16:
        if (StringsKt__StringsKt.isBlank(r19) == false) goto L18;
        r19 = null;
        goto L24
    L8:
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0) == false) goto L11;
        CollectionsKt.throwIndexOverflow();
        goto L12
    L11:
        throw new ArithmeticException("Index overflow has happened.");
    L28:
        return ((StringBuilder) CollectionsKt.p(r14, new StringBuilder(r11), "\n", null, null, null, 124)).toString();
    }

    public static final String replaceIndent(String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Intrinsics.checkNotNullParameter(r13, "newIndent");
        List<String> r5 = StringsKt__StringsKt.lines(r12);
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Object r14 = r11.next();
        if (StringsKt__StringsKt.isBlank((String) r14) == true) goto L4;
        r10.add(r14);
        goto L4
    L8:
        ArrayList r15 = new ArrayList(CollectionsKt.h(r10));
        Iterator r16 = r10.iterator();
    L10:
        if (r16.hasNext() == false) goto L12;
        r15.add(Integer.valueOf(indentWidth$StringsKt__IndentKt((String) r16.next())));
        goto L10
    L12:
        Integer r17 = (Integer) CollectionsKt.t(r15);
        int r18 = 0;
        if (r17 == null) goto L15;
        int r19 = r17.intValue();
    L16:
        int r20 = (r5.size() * r13.length()) + r12.length();
        Function1<String, String> r110 = getIndentFunction$StringsKt__IndentKt(r13);
        int r111 = CollectionsKt.getLastIndex(r5);
        ArrayList r21 = new ArrayList();
        Iterator<T> r22 = r5.iterator();
    L18:
        if (r22.hasNext() == false) goto L38;
        Object r23 = r22.next();
        int r24 = r18 + 1;
        if (r18 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        String r25 = (String) r23;
        if (r18 == 0) goto L26;
        if (r18 == r111) goto L26;
    L28:
        String r26 = StringsKt___StringsKt.drop(r25, r19);
        if (r26 == null) goto L34;
        String r27 = r110.invoke(r26);
        if (r27 == null) goto L34;
        r25 = r27;
    L34:
        if (r25 == null) goto L36;
        r21.add(r25);
    L36:
        r18 = r24;
    L26:
        if (StringsKt__StringsKt.isBlank(r25) == false) goto L28;
        r25 = null;
        goto L34
    L38:
        return ((StringBuilder) CollectionsKt.p(r21, new StringBuilder(r20), "\n", null, null, null, 124)).toString();
    L15:
        r19 = 0;
        goto L16
    }

    public static /* synthetic */ String replaceIndent$default(String r5, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = "";
    L6:
        return replaceIndent(r5, r10);
    }

    public static final String replaceIndentByMargin(String r18, String r19, String r20) {
        Intrinsics.checkNotNullParameter(r18, "<this>");
        Intrinsics.checkNotNullParameter(r19, "newIndent");
        Intrinsics.checkNotNullParameter(r20, "marginPrefix");
        if (StringsKt__StringsKt.isBlank(r20) == true) goto L40;
        List<String> r5 = StringsKt__StringsKt.lines(r18);
        int r10 = (r5.size() * r19.length()) + r18.length();
        Function1<String, String> r11 = getIndentFunction$StringsKt__IndentKt(r19);
        int r12 = CollectionsKt.getLastIndex(r5);
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r5.iterator();
        int r15 = 0;
    L6:
        if (r14.hasNext() == false) goto L38;
        Object r16 = r14.next();
        int r17 = r15 + 1;
        if (r15 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        String r110 = (String) r16;
        String r111 = null;
        if (r15 == 0) goto L14;
        if (r15 == r12) goto L14;
    L16:
        int r21 = r110.length();
        int r22 = 0;
    L18:
        if (r22 >= r21) goto L23;
        if (CharsKt__CharJVMKt.isWhitespace(r110.charAt(r22)) == false) goto L21;
        r22 = r22 + 1;
        goto L18
    L21:
        int r23 = r22;
    L24:
        if (r23 == (-1)) goto L29;
        int r112 = r23;
        if (StringsKt__StringsJVMKt.startsWith$default(r110, r20, r23, false, 4, null) == false) goto L29;
        int r24 = r20.length() + r112;
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type java.lang.String");
        r111 = r110.substring(r24);
    L29:
        if (r111 == null) goto L34;
        String r25 = r11.invoke(r111);
        if (r25 == null) goto L34;
        r110 = r25;
    L34:
        if (r110 == null) goto L36;
        r13.add(r110);
    L36:
        r15 = r17;
        goto L6
    L23:
        r23 = -1;
    L14:
        if (StringsKt__StringsKt.isBlank(r110) == false) goto L16;
        r110 = null;
        goto L34
    L38:
        return ((StringBuilder) CollectionsKt.p(r13, new StringBuilder(r10), "\n", null, null, null, 124)).toString();
    L40:
        throw new IllegalArgumentException("marginPrefix must be non-blank string.");
    }

    public static /* synthetic */ String replaceIndentByMargin$default(String r5, String r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = "";
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = "|";
    L9:
        return replaceIndentByMargin(r5, r10, r11);
    }

    @IntrinsicConstEvaluation
    public static String trimIndent(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return replaceIndent(r5, "");
    }

    @IntrinsicConstEvaluation
    public static final String trimMargin(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "marginPrefix");
        return replaceIndentByMargin(r5, "", r10);
    }

    public static /* synthetic */ String trimMargin$default(String r5, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = "|";
    L6:
        return trimMargin(r5, r10);
    }
}
