package com.obric.memorydata.utils;

import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002)*B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eJ4\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eJ,\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eJ,\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J,\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J,\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J4\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020 0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eJ,\u0010!\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020 0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J4\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\t\u0018\u00010#2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u000eH\u0002J\u0018\u0010'\u001a\u00020$2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0002¨\u0006+"}, d2 = {"Lcom/obric/memorydata/utils/RichTextFormatter;", "", "<init>", "()V", "formatNonClickable", "", "textView", "Landroid/widget/TextView;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "styleMap", "", "Lcom/obric/memorydata/utils/TextStyle;", "placeholderConfig", "Lcom/obric/memorydata/utils/PlaceholderConfig;", "formatMixed", "styleConfigMap", "Lcom/obric/memorydata/utils/StyleConfig;", "applyStylesToBuilder", "Landroid/text/SpannableStringBuilder;", "builder", "applyMixedStylesToBuilder", "applyTextStyleToBuilder", "spanInfo", "Lcom/obric/memorydata/utils/RichTextFormatter$NonClickableSpanInfo;", "parseNonClickableText", "Landroid/text/SpannableString;", "parseMixedText", "applyTextStyle", "spannableString", "format", "linkMap", "Lcom/obric/memorydata/utils/LinkStyle;", "parseText", "findKeywordInText", "Lkotlin/Triple;", "", "keyword", "config", "findWholeWord", "word", "NonClickableSpanInfo", "ClickableSpanInfo", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ap f13173a = null;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/utils/RichTextFormatter$NonClickableSpanInfo;", "", "startIndex", "", "endIndex", "keyword", "", "textStyle", "Lcom/obric/memorydata/utils/TextStyle;", "<init>", "(IILjava/lang/String;Lcom/obric/memorydata/utils/TextStyle;)V", "getStartIndex", "()I", "getEndIndex", "getKeyword", "()Ljava/lang/String;", "getTextStyle", "()Lcom/obric/memorydata/utils/TextStyle;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f13174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f13175b;
        private final String c;
        private final av d;

        public a(int r2, int r3, String r4, av r5) {
            Intrinsics.checkNotNullParameter(r4, "keyword");
            Intrinsics.checkNotNullParameter(r5, "textStyle");
            this.f13174a = r2;
            this.f13175b = r3;
            this.c = r4;
            this.d = r5;
        }

        public final int a() {
            return this.f13174a;
        }

        public final int b() {
            return this.f13175b;
        }

        public final av c() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f13174a == r6.f13174a) goto L12;
            return false;
        L12:
            if (this.f13175b == r6.f13175b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.f13174a) * 31) + Integer.hashCode(this.f13175b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "NonClickableSpanInfo(startIndex=" + this.f13174a + ", endIndex=" + this.f13175b + ", keyword=" + this.c + ", textStyle=" + this.d + ')';
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13176a = null;

        static {
            int[] r0 = new int[PlaceholderMode.values().length];
            r0[PlaceholderMode.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f13176a = r0;
        }
    }

    static {
        f13173a = new ap();
    }

    private ap() {
    }

    private final int a(String r4, String r5) {
        MatchResult r3 = Regex.find$default(new Regex("\\b" + Regex.Companion.escape(r5) + "\\b", RegexOption.IGNORE_CASE), (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);
        if (r3 == null) goto L7;
        IntRange r6 = r3.getRange();
        if (r6 == null) goto L7;
        return r6.getFirst();
    L7:
        return -1;
    }

    private final SpannableString a(String r8, Map<String, av> r9, al r10) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        List r11 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r12 = r7.entrySet().iterator();
    L3:
        String r1 = r8;
    L5:
        if (r12.hasNext() == false) goto L9;
        Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r13.getKey(), String.class, "com.obric.memorydata.plugin");
        av r14 = (av) ZeusTransformUtils.preCheckCast(r13.getValue(), av.class, "com.obric.memorydata.plugin");
        Triple<Integer, Integer, String> r2 = f13173a.a(r1, r3, r10);
        if (r2 == null) goto L5;
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r2.component1(), Number.class, "com.obric.memorydata.plugin")).intValue();
        String r5 = (String) ZeusTransformUtils.preCheckCast(r2.component3(), String.class, "com.obric.memorydata.plugin");
        r11.add(new a(r4, r3.length() + r4, r3, r14));
        r8 = StringsKt.replaceFirst$default(r1, r5, r3, false, 4, null);
        goto L3
    L9:
        SpannableString r15 = new SpannableString((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"));
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r16.hasNext() == false) goto L13;
        a r17 = (a) ZeusTransformUtils.preCheckCast(r16.next(), a.class, "com.obric.memorydata.plugin");
        f13173a.a(r15, r17);
        goto L11
    L13:
        return r15;
    }

    private final Triple<Integer, Integer, String> a(String r11, String r12, al r13) {
        if (r13.b() == true) goto L7;
        r11 = r11.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r11, "toLowerCase(...)");
    L7:
        if (r13.b() == false) goto L9;
        String r3 = r12;
    L10:
        PlaceholderMode r0 = r13.a();
        if (b.f13176a[r0.ordinal()] == 1) goto L13;
        String r10 = r13.a(r3);
        String r14 = r13.a(r12);
        int r15 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), r10, 0, false, 6, null);
        if (r15 != (-1)) goto L21;
        return null;
    L21:
        return new Triple(Integer.valueOf(r15), Integer.valueOf(r15 + r10.length()), r14);
    L13:
        if (r13.c() == false) goto L15;
        int r16 = a(r11, r3);
    L16:
        if (r16 != (-1)) goto L23;
        return null;
    L23:
        return new Triple(Integer.valueOf(r16), Integer.valueOf(r16 + r12.length()), r12);
    L15:
        r16 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), r3, 0, false, 6, null);
        goto L16
    L9:
        String r1 = r12.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r1, "toLowerCase(...)");
        r3 = r1;
        goto L10
    }

    private final void a(SpannableString r6, a r7) {
        av r5 = r7.c();
        int r0 = r7.a();
        int r8 = r7.b();
        Integer r1 = r5.a();
        if (r1 == null) goto L5;
        r6.setSpan(new ForegroundColorSpan(((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).intValue()), r0, r8, 33);
    L5:
        Integer r2 = r5.f();
        if (r2 == null) goto L9;
        r6.setSpan(new BackgroundColorSpan(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).intValue()), r0, r8, 33);
    L9:
        if (r5.b() == false) goto L14;
        if (r5.c() == false) goto L14;
        StyleSpan r3 = new StyleSpan(3);
    L16:
        r6.setSpan(r3, r0, r8, 33);
    L21:
        if (r5.d() == false) goto L24;
        r6.setSpan(new UnderlineSpan(), r0, r8, 33);
    L24:
        if (r5.e() == false) goto L26;
        r6.setSpan(new StrikethroughSpan(), r0, r8, 33);
    L26:
        Float r4 = r5.g();
        if (r4 == null) goto L29;
        r6.setSpan(new RelativeSizeSpan(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).floatValue()), r0, r8, 33);
    L29:
        Integer r9 = r5.h();
        if (r9 == null) goto L33;
        r6.setSpan(new AbsoluteSizeSpan(((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).intValue()), r0, r8, 33);
        return;
    L33:
        return;
    L14:
        if (r5.b() == false) goto L18;
        r3 = new StyleSpan(1);
        goto L16
    L18:
        if (r5.c() == false) goto L21;
        r3 = new StyleSpan(2);
        goto L16
    }

    public final void a(TextView r3, String r4, Map<String, av> r5, al r6) {
        Map<String, av> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "textView");
        Intrinsics.checkNotNullParameter(r4, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r7, "styleMap");
        Intrinsics.checkNotNullParameter(r6, "placeholderConfig");
        r3.setText((CharSequence) ZeusTransformUtils.preCheckCast(a(r4, r7, r6), CharSequence.class, "com.obric.memorydata.plugin"));
    }
}
