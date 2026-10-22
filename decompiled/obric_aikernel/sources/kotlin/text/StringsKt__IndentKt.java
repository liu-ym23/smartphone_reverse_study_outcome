package kotlin.text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nIndent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Indent.kt\nkotlin/text/StringsKt__IndentKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,123:1\n113#1,2:125\n115#1,4:140\n120#1,2:153\n113#1,2:162\n115#1,4:177\n120#1,2:184\n1#2:124\n1#2:150\n1#2:181\n1#2:205\n1569#3,11:127\n1864#3,2:138\n1866#3:151\n1580#3:152\n766#3:155\n857#3,2:156\n1549#3:158\n1620#3,3:159\n1569#3,11:164\n1864#3,2:175\n1866#3:182\n1580#3:183\n1569#3,11:192\n1864#3,2:203\n1866#3:206\n1580#3:207\n151#4,6:144\n151#4,6:186\n*S KotlinDebug\n*F\n+ 1 Indent.kt\nkotlin/text/StringsKt__IndentKt\n*L\n38#1:125,2\n38#1:140,4\n38#1:153,2\n78#1:162,2\n78#1:177,4\n78#1:184,2\n38#1:150\n78#1:181\n114#1:205\n38#1:127,11\n38#1:138,2\n38#1:151\n38#1:152\n74#1:155\n74#1:156,2\n75#1:158\n75#1:159,3\n78#1:164,11\n78#1:175,2\n78#1:182\n78#1:183\n114#1:192,11\n114#1:203,2\n114#1:206\n114#1:207\n39#1:144,6\n101#1:186,6\n*E\n"})
class StringsKt__IndentKt extends StringsKt__AppendableKt {
    public StringsKt__IndentKt() {
    }

    private static final Function1<String, String> getIndentFunction$StringsKt__IndentKt(final String r10) {
        if (r10.length() != 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L9;
        return StringsKt__IndentKt$getIndentFunction$1.INSTANCE;
    L9:
        return new StringsKt__IndentKt$getIndentFunction$2(r10);
    L5:
        r11 = false;
        goto L6
    }

    private static final int indentWidth$StringsKt__IndentKt(String r10) {
        int r11 = r10.length();
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L9;
        if ((!CharsKt.isWhitespace(r10.charAt(r12))) == true) goto L10;
        r12 = r12 + 1;
    L10:
        if (r12 == (-1)) goto L12;
        return r12;
    L12:
        return r10.length();
    L9:
        r12 = -1;
        goto L10
    }

    public static final String prependIndent(String r10, final String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "indent");
        return SequencesKt.joinToString$default(SequencesKt.map(StringsKt__StringsKt.lineSequence(r10), new AnonymousClass1(r11)), "\n", null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ String prependIndent$default(String r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = "    ";
    L6:
        return prependIndent(r10, r11);
    }

    private static final String reindent$StringsKt__IndentKt(List<String> r11, int r12, Function1<? super String, String> r13, Function1<? super String, String> r14) {
        int r10 = CollectionsKt.getLastIndex(r11);
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r11.iterator();
        int r17 = 0;
    L4:
        if (r16.hasNext() == false) goto L23;
        Object r18 = r16.next();
        int r19 = r17 + 1;
        if (r17 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        String r20 = (String) r18;
        if (r17 == 0) goto L12;
        if (r17 == r10) goto L12;
    L14:
        String r21 = r14.invoke(r20);
        if (r21 == null) goto L20;
        String r22 = r13.invoke(r21);
        if (r22 == null) goto L20;
        r20 = r22;
    L20:
        if (r20 == null) goto L22;
        r15.add(r20);
    L22:
        r17 = r19;
    L12:
        if (StringsKt.isBlank(r20) == false) goto L14;
        r20 = null;
        goto L20
    L23:
        String r110 = ((StringBuilder) CollectionsKt.joinTo$default(r15, new StringBuilder(r12), "\n", null, null, 0, null, null, 124, null)).toString();
        Intrinsics.checkNotNullExpressionValue(r110, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return r110;
    }

    public static final String replaceIndent(String r14, String r15) {
        Intrinsics.checkNotNullParameter(r14, "<this>");
        Intrinsics.checkNotNullParameter(r15, "newIndent");
        List<String> r10 = StringsKt__StringsKt.lines(r14);
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        if ((!StringsKt.isBlank((String) r13)) == false) goto L4;
        r11.add(r13);
        goto L4
    L8:
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r17 = r11.iterator();
    L10:
        if (r17.hasNext() == false) goto L12;
        r16.add(Integer.valueOf(indentWidth$StringsKt__IndentKt((String) r17.next())));
        goto L10
    L12:
        Integer r18 = (Integer) CollectionsKt.minOrNull(r16);
        int r19 = 0;
        if (r18 == null) goto L15;
        int r20 = r18.intValue();
    L16:
        int r110 = r14.length() + (r15.length() * r10.size());
        Function1<String, String> r111 = getIndentFunction$StringsKt__IndentKt(r15);
        int r21 = CollectionsKt.getLastIndex(r10);
        ArrayList r22 = new ArrayList();
        Iterator<T> r23 = r10.iterator();
    L18:
        if (r23.hasNext() == false) goto L37;
        Object r24 = r23.next();
        int r25 = r19 + 1;
        if (r19 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        String r26 = (String) r24;
        if (r19 == 0) goto L26;
        if (r19 == r21) goto L26;
    L28:
        String r27 = StringsKt.drop(r26, r20);
        if (r27 == null) goto L34;
        String r28 = r111.invoke(r27);
        if (r28 == null) goto L34;
        r26 = r28;
    L34:
        if (r26 == null) goto L36;
        r22.add(r26);
    L36:
        r19 = r25;
    L26:
        if (StringsKt.isBlank(r26) == false) goto L28;
        r26 = null;
        goto L34
    L37:
        String r112 = ((StringBuilder) CollectionsKt.joinTo$default(r22, new StringBuilder(r110), "\n", null, null, 0, null, null, 124, null)).toString();
        Intrinsics.checkNotNullExpressionValue(r112, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return r112;
    L15:
        r20 = 0;
        goto L16
    }

    public static /* synthetic */ String replaceIndent$default(String r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = "";
    L6:
        return replaceIndent(r10, r11);
    }

    public static final String replaceIndentByMargin(String r21, String r22, String r23) {
        Intrinsics.checkNotNullParameter(r21, "<this>");
        Intrinsics.checkNotNullParameter(r22, "newIndent");
        Intrinsics.checkNotNullParameter(r23, "marginPrefix");
        if ((!StringsKt.isBlank(r23)) == false) goto L40;
        List<String> r10 = StringsKt__StringsKt.lines(r21);
        int r11 = r21.length() + (r22.length() * r10.size());
        Function1<String, String> r12 = getIndentFunction$StringsKt__IndentKt(r22);
        int r13 = CollectionsKt.getLastIndex(r10);
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r10.iterator();
        int r16 = 0;
    L6:
        if (r15.hasNext() == false) goto L37;
        Object r17 = r15.next();
        int r18 = r16 + 1;
        if (r16 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        String r19 = (String) r17;
        String r110 = null;
        if (r16 == 0) goto L14;
        if (r16 == r13) goto L14;
    L16:
        int r20 = r19.length();
        int r24 = 0;
    L18:
        if (r24 >= r20) goto L23;
        if ((!CharsKt.isWhitespace(r19.charAt(r24))) == true) goto L21;
        r24 = r24 + 1;
        goto L18
    L21:
        int r25 = r24;
    L24:
        if (r25 == (-1)) goto L29;
        int r111 = r25;
        if (StringsKt.startsWith$default(r19, r23, r25, false, 4, null) == false) goto L29;
        int r26 = r111 + r23.length();
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type java.lang.String");
        r110 = r19.substring(r26);
        Intrinsics.checkNotNullExpressionValue(r110, "this as java.lang.String).substring(startIndex)");
    L29:
        if (r110 == null) goto L34;
        String r27 = r12.invoke(r110);
        if (r27 == null) goto L34;
        r19 = r27;
    L34:
        if (r19 == null) goto L36;
        r14.add(r19);
    L36:
        r16 = r18;
        goto L6
    L23:
        r25 = -1;
    L14:
        if (StringsKt.isBlank(r19) == false) goto L16;
        r19 = null;
        goto L34
    L37:
        String r28 = ((StringBuilder) CollectionsKt.joinTo$default(r14, new StringBuilder(r11), "\n", null, null, 0, null, null, 124, null)).toString();
        Intrinsics.checkNotNullExpressionValue(r28, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return r28;
    L40:
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    public static /* synthetic */ String replaceIndentByMargin$default(String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = "";
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = "|";
    L9:
        return replaceIndentByMargin(r10, r11, r12);
    }

    @IntrinsicConstEvaluation
    public static String trimIndent(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return replaceIndent(r10, "");
    }

    @IntrinsicConstEvaluation
    public static final String trimMargin(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "marginPrefix");
        return replaceIndentByMargin(r10, "", r11);
    }

    public static /* synthetic */ String trimMargin$default(String r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = "|";
    L6:
        return trimMargin(r10, r11);
    }
}
