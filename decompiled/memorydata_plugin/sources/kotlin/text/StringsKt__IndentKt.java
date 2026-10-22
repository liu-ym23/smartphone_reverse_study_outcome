package kotlin.text;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u001a!\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0002\b\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0002\b\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001aJ\u0010\t\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u0082\b¢\u0006\u0002\b\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u001a\u001e\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u001a\f\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0016\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002H\u0007¨\u0006\u0015"}, d2 = {"getIndentFunction", "Lkotlin/Function1;", "", "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__IndentKt extends StringsKt__AppendableKt {
    public StringsKt__IndentKt() {
    }

    private static final Function1<String, String> getIndentFunction$StringsKt__IndentKt(final String r2) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        Object r3 = ZeusTransformUtils.preCheckCast(StringsKt__IndentKt$getIndentFunction$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
    L10:
        return (Function1) r3;
    L8:
        r3 = ZeusTransformUtils.preCheckCast(new StringsKt__IndentKt$getIndentFunction$2(r2), Function1.class, "com.obric.memorydata.plugin");
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    private static final int indentWidth$StringsKt__IndentKt(String r5) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        int r1 = r0.length();
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L9;
        if ((!CharsKt.isWhitespace(r0.charAt(r2))) == true) goto L10;
        r2 = r2 + 1;
    L10:
        if (r2 == (-1)) goto L12;
        return r2;
    L12:
        return r5.length();
    L9:
        r2 = -1;
        goto L10
    }

    public static final String prependIndent(String r11, final String r12) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r12, "indent");
        return SequencesKt.joinToString$default(SequencesKt.map(StringsKt.lineSequence((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")), (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r12), Function1.class, "com.obric.memorydata.plugin")), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ String prependIndent$default(String r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = "    ";
    L6:
        return StringsKt.prependIndent(r0, r1);
    }

    private static final String reindent$StringsKt__IndentKt(List<String> r12, int r13, Function1<? super String, String> r14, Function1<? super String, String> r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Function1 r17 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
        Function1 r18 = (Function1) ZeusTransformUtils.wrapperContextForParams(r15, Function1.class, "com.obric.memorydata.plugin");
        int r0 = CollectionsKt.getLastIndex(r16);
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r110 = r19.iterator();
        int r4 = 0;
    L4:
        if (r110.hasNext() == false) goto L27;
        Object r5 = r110.next();
        int r6 = r4 + 1;
        if (r4 < 0) goto L8;
    L12:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
        if (r4 == 0) goto L16;
        if (r4 == r0) goto L16;
    L18:
        String r8 = (String) ZeusTransformUtils.preCheckCast(r18.invoke(r7), String.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L24;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r17.invoke(r8), String.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L24;
        r7 = r9;
    L24:
        if (r7 == null) goto L26;
        r2.add(r7);
    L26:
        r4 = r6;
    L16:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L18;
        r7 = null;
        goto L24
    L8:
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0) == false) goto L11;
        CollectionsKt.throwIndexOverflow();
        goto L12
    L11:
        throw new ArithmeticException("Index overflow has happened.");
    L27:
        String r111 = ((StringBuilder) ZeusTransformUtils.preCheckCast(CollectionsKt.joinTo$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (Appendable) ZeusTransformUtils.preCheckCast(new StringBuilder(r13), Appendable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 124, null), StringBuilder.class, "com.obric.memorydata.plugin")).toString();
        Intrinsics.checkNotNullExpressionValue(r111, "toString(...)");
        return r111;
    }

    public static final String replaceIndent(String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Intrinsics.checkNotNullParameter(r13, "newIndent");
        List<String> r0 = StringsKt.lines((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"));
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r5 = r4.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L4;
        r3.add(r5);
        goto L4
    L8:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r6.iterator();
    L10:
        if (r8.hasNext() == false) goto L12;
        r7.add(Integer.valueOf(indentWidth$StringsKt__IndentKt((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin"))));
        goto L10
    L12:
        Integer r9 = (Integer) ZeusTransformUtils.preCheckCast(CollectionsKt.minOrNull((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Integer.class, "com.obric.memorydata.plugin");
        int r10 = 0;
        if (r9 == null) goto L15;
        int r11 = r9.intValue();
    L16:
        int r14 = r12.length() + (r13.length() * r0.size());
        Function1<String, String> r15 = getIndentFunction$StringsKt__IndentKt(r13);
        int r16 = CollectionsKt.getLastIndex(r0);
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r1.iterator();
    L18:
        if (r18.hasNext() == false) goto L37;
        Object r19 = r18.next();
        int r20 = r10 + 1;
        if (r10 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        String r21 = (String) ZeusTransformUtils.preCheckCast(r19, String.class, "com.obric.memorydata.plugin");
        if (r10 == 0) goto L26;
        if (r10 == r16) goto L26;
    L28:
        String r22 = StringsKt.drop(r21, r11);
        if (r22 == null) goto L34;
        String r23 = (String) ZeusTransformUtils.preCheckCast(r15.invoke(r22), String.class, "com.obric.memorydata.plugin");
        if (r23 == null) goto L34;
        r21 = r23;
    L34:
        if (r21 == null) goto L36;
        r17.add(r21);
    L36:
        r10 = r20;
    L26:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L28;
        r21 = null;
        goto L34
    L37:
        String r110 = ((StringBuilder) ZeusTransformUtils.preCheckCast(CollectionsKt.joinTo$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (Appendable) ZeusTransformUtils.preCheckCast(new StringBuilder(r14), Appendable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 124, null), StringBuilder.class, "com.obric.memorydata.plugin")).toString();
        Intrinsics.checkNotNullExpressionValue(r110, "toString(...)");
        return r110;
    L15:
        r11 = 0;
        goto L16
    }

    public static /* synthetic */ String replaceIndent$default(String r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = "";
    L6:
        return StringsKt.replaceIndent(r0, r1);
    }

    public static final String replaceIndentByMargin(String r19, String r20, String r21) {
        Intrinsics.checkNotNullParameter(r19, "<this>");
        Intrinsics.checkNotNullParameter(r20, "newIndent");
        Intrinsics.checkNotNullParameter(r21, "marginPrefix");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L40;
        List<String> r1 = StringsKt.lines((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.memorydata.plugin"));
        int r8 = r19.length() + (r20.length() * r1.size());
        Function1<String, String> r9 = getIndentFunction$StringsKt__IndentKt(r20);
        int r10 = CollectionsKt.getLastIndex(r1);
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r0.iterator();
        int r2 = 0;
    L6:
        if (r12.hasNext() == false) goto L37;
        Object r3 = r12.next();
        int r14 = r2 + 1;
        if (r2 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        String r15 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
        if (r2 == 0) goto L14;
        if (r2 == r10) goto L14;
    L16:
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin");
        int r5 = r4.length();
        int r6 = 0;
    L18:
        if (r6 >= r5) goto L23;
        if ((!CharsKt.isWhitespace(r4.charAt(r6))) == true) goto L21;
        r6 = r6 + 1;
        goto L18
    L21:
        int r7 = r6;
    L24:
        if (r7 != (-1)) goto L26;
    L25:
        String r13 = null;
    L29:
        if (r13 == null) goto L34;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r9.invoke(r13), String.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L34;
        r15 = r16;
    L34:
        if (r15 == null) goto L36;
        r11.add(r15);
    L36:
        r2 = r14;
        goto L6
    L26:
        int r18 = r7;
        if (StringsKt.startsWith$default(r15, r21, r7, false, 4, null) == false) goto L25;
        int r17 = r18 + r21.length();
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type java.lang.String");
        r13 = r15.substring(r17);
        Intrinsics.checkNotNullExpressionValue(r13, "substring(...)");
        goto L29
    L23:
        r7 = -1;
    L14:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L16;
        r15 = null;
        goto L34
    L37:
        String r22 = ((StringBuilder) ZeusTransformUtils.preCheckCast(CollectionsKt.joinTo$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (Appendable) ZeusTransformUtils.preCheckCast(new StringBuilder(r8), Appendable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 124, null), StringBuilder.class, "com.obric.memorydata.plugin")).toString();
        Intrinsics.checkNotNullExpressionValue(r22, "toString(...)");
        return r22;
    L40:
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    public static /* synthetic */ String replaceIndentByMargin$default(String r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = "";
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = "|";
    L9:
        return StringsKt.replaceIndentByMargin(r0, r1, r2);
    }

    public static final String trimIndent(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return StringsKt.replaceIndent(r1, "");
    }

    public static final String trimMargin(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "marginPrefix");
        return StringsKt.replaceIndentByMargin(r1, "", r2);
    }

    public static /* synthetic */ String trimMargin$default(String r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = "|";
    L6:
        return StringsKt.trimMargin(r0, r1);
    }
}
