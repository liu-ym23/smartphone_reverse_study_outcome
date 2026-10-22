package com.obric.aiproactive.ui.preference;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0080\b\u0018\u00002\u00020\u0001B;\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0007J\u0016\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u0014J\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007J\u0006\u0010\u001b\u001a\u00020\u0007J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÂ\u0003J\u0015\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tHÂ\u0003J?\u0010 \u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tHÆ\u0001J\u0013\u0010!\u001a\u00020\u00172\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0014HÖ\u0001J\t\u0010$\u001a\u00020\u0007HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/aiproactive/ui/preference/GuidedPreferenceInterviewState;", "", "pages", "", "Lcom/obric/aiproactive/ui/preference/GuidedPreferencePage;", "selectedOptionIds", "", "", "inputByOptionId", "", "<init>", "(Ljava/util/List;Ljava/util/Set;Ljava/util/Map;)V", "getPages", "()Ljava/util/List;", "select", "optionId", "toggleSelection", "updateInput", "input", "pageIndex", "", "selectedOptionNumbersParam", "hasSelectedCustomAnswer", "", "(I)Ljava/lang/Boolean;", "isSelected", "inputFor", "interviewOptionsParam", "customAnswerFlagsJson", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<o> f6774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<String> f6775b;
    private final Map<String, String> c;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6776a = null;

        static {
            int[] r0 = new int[GuidedPreferenceSelectionMode.values().length];
            r0[GuidedPreferenceSelectionMode.SINGLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[GuidedPreferenceSelectionMode.MULTIPLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f6776a = r0;
        }
    }

    public j(List<o> r3, Set<String> r4, Map<String, String> r5) {
        List<o> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Set<String> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "pages");
        Intrinsics.checkNotNullParameter(r7, "selectedOptionIds");
        Intrinsics.checkNotNullParameter(r8, "inputByOptionId");
        this.f6774a = r6;
        this.f6775b = r7;
        this.c = r8;
    }

    public /* synthetic */ j(List r2, Set r3, Map r4, int r5, DefaultConstructorMarker r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = SetsKt.emptySet();
    L6:
        if ((r5 & 4) == 0) goto L8;
        r9 = MapsKt.emptyMap();
    L8:
        this(r7, r8, r9);
    }

    public static /* synthetic */ j a(j r1, List r2, Set r3, Map r4, int r5, Object r6) {
        List<o> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Set<String> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Map<String, String> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = r1.f6774a;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r8 = r1.f6775b;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r9 = r1.c;
    L12:
        return r1.a(r7, r8, r9);
    }

    private static final CharSequence a(Pair r4) {
        Intrinsics.checkNotNullParameter(r4, "<destruct>");
        return (CharSequence) ZeusTransformUtils.preCheckCast(Typography.quote + ((Number) ZeusTransformUtils.preCheckCast(r4.component1(), Number.class, "com.obric.memorydata.plugin")).intValue() + "\":\"" + ((String) ZeusTransformUtils.preCheckCast(r4.component2(), String.class, "com.obric.memorydata.plugin")) + Typography.quote, CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final String b(int r13) {
        o r0 = (o) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(this.f6774a, r13), o.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return "{}";
    L6:
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0.d(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r3 = 0;
        Iterator r4 = r1.iterator();
    L8:
        if (r4.hasNext() == false) goto L29;
        Object r5 = r4.next();
        int r6 = r3 + 1;
        if (r3 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        m r7 = (m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.memorydata.plugin");
        if (r13 != 2) goto L15;
        boolean r8 = r7.f();
    L16:
        if (r8 == true) goto L18;
    L24:
        Pair r9 = null;
    L25:
        if (r9 == null) goto L27;
        r2.add(r9);
    L27:
        r3 = r6;
        goto L8
    L18:
        if (this.f6775b.contains(r7.a()) == false) goto L24;
        Integer r10 = Integer.valueOf(r6);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(d(r7.a()), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L22;
        String r11 = "yes";
    L23:
        r9 = TuplesKt.to(r10, r11);
        goto L25
    L22:
        r11 = "no";
        goto L23
    L15:
        r8 = r7.g();
        goto L16
    L29:
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("{", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("}", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, $$Lambda$j$VWzgO67CwNACiHMj_wohM4TwpNE.INSTANCE, 24, null);
    }

    public static /* synthetic */ CharSequence lambda$VWzgO67CwNACiHMj_wohM4TwpNE(Pair r0) {
        return a(r0);
    }

    public final j a(String r9) {
        Intrinsics.checkNotNullParameter(r9, "optionId");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f6774a, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L18;
        Object r1 = r0.next();
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(((o) ZeusTransformUtils.preCheckCast(r1, o.class, "com.obric.memorydata.plugin")).d(), Iterable.class, "com.obric.memorydata.plugin");
        boolean r6 = false;
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L8;
    L10:
        Iterator r5 = r4.iterator();
    L12:
        if (r5.hasNext() == false) goto L16;
        if (Intrinsics.areEqual(((m) ZeusTransformUtils.preCheckCast(r5.next(), m.class, "com.obric.memorydata.plugin")).a(), r9) == false) goto L12;
        r6 = true;
    L16:
        if (r6 == false) goto L4;
    L19:
        o r2 = (o) ZeusTransformUtils.preCheckCast(r1, o.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L22;
        return this;
    L22:
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2.d(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r3.iterator();
    L24:
        if (r8.hasNext() == false) goto L26;
        r7.add(((m) ZeusTransformUtils.preCheckCast(r8.next(), m.class, "com.obric.memorydata.plugin")).a());
        goto L24
    L26:
        Set r10 = (Set) ZeusTransformUtils.preCheckCast(r7, Set.class, "com.obric.memorydata.plugin");
        int r11 = a.f6776a[r2.c().ordinal()];
        if (r11 != 1) goto L29;
        Set<String> r12 = SetsKt.minus(this.f6775b, (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin"));
    L35:
        return a(this, null, SetsKt.plus(r12, r9), null, 5, null);
    L29:
        if (r11 != 2) goto L32;
        r12 = this.f6775b;
        goto L35
    L32:
        throw new NoWhenBranchMatchedException();
    L8:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L10;
    L18:
        r1 = null;
        goto L19
    }

    public final j a(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "optionId");
        Intrinsics.checkNotNullParameter(r9, "input");
        return a(this, null, null, MapsKt.plus(this.c, TuplesKt.to(r8, r9)), 3, null);
    }

    public final j a(List<o> r2, Set<String> r3, Map<String, String> r4) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "pages");
        Intrinsics.checkNotNullParameter(r5, "selectedOptionIds");
        Intrinsics.checkNotNullParameter(r6, "inputByOptionId");
        return new j(r1, r5, r6);
    }

    public final String a(int r14) {
        o r15 = (o) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(this.f6774a, r14), o.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L5;
        return null;
    L5:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r15.d(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r16.iterator();
        boolean r3 = false;
        int r4 = 0;
    L7:
        if (r17.hasNext() == false) goto L18;
        Object r5 = r17.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        m r7 = (m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.memorydata.plugin");
        Integer r8 = Integer.valueOf(r6);
        ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).intValue();
        if (this.f6775b.contains(r7.a()) == true) goto L15;
        r8 = null;
    L15:
        if (r8 == null) goto L17;
        r2.add(r8);
    L17:
        r4 = r6;
        goto L7
    L18:
        String r13 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L21;
        r3 = true;
    L21:
        if (r3 == true) goto L23;
        return null;
    L23:
        return r13;
    }

    public final List<o> a() {
        return this.f6774a;
    }

    public final j b(String r9) {
        Intrinsics.checkNotNullParameter(r9, "optionId");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f6774a, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L18;
        Object r1 = r0.next();
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(((o) ZeusTransformUtils.preCheckCast(r1, o.class, "com.obric.memorydata.plugin")).d(), Iterable.class, "com.obric.memorydata.plugin");
        boolean r6 = false;
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L8;
    L10:
        Iterator r5 = r4.iterator();
    L12:
        if (r5.hasNext() == false) goto L16;
        if (Intrinsics.areEqual(((m) ZeusTransformUtils.preCheckCast(r5.next(), m.class, "com.obric.memorydata.plugin")).a(), r9) == false) goto L12;
        r6 = true;
    L16:
        if (r6 == false) goto L4;
    L19:
        o r2 = (o) ZeusTransformUtils.preCheckCast(r1, o.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L22;
        return this;
    L22:
        int r3 = a.f6776a[r2.c().ordinal()];
        if (r3 == 1) goto L34;
        if (r3 != 2) goto L32;
        if (this.f6775b.contains(r9) == false) goto L29;
        Set r10 = SetsKt.minus(this.f6775b, r9);
    L46:
        return a(this, null, r10, null, 5, null);
    L29:
        r10 = SetsKt.plus(this.f6775b, r9);
        goto L46
    L32:
        throw new NoWhenBranchMatchedException();
    L34:
        if (this.f6775b.contains(r9) == false) goto L37;
        return a(this, null, SetsKt.minus(this.f6775b, r9), null, 5, null);
    L37:
        return a(r9);
    L8:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L10;
    L18:
        r1 = null;
        goto L19
    }

    public final String b() {
        StringBuilder r0 = new StringBuilder();
        r0.append('{');
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.getIndices((Collection) ZeusTransformUtils.preCheckCast(this.f6774a, Collection.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        int r2 = ((IntIterator) ZeusTransformUtils.preCheckCast(r1, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();
        if (r2 <= 0) goto L8;
        r0.append(',');
    L8:
        int r4 = r2 + 1;
        r0.append("\"question_");
        r0.append(r4);
        r0.append("_answer\":\"");
        String r5 = a(r2);
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        r0.append(r5);
        r0.append("\",\"question_");
        r0.append(r4);
        r0.append("_custom_answer\":");
        r0.append(b(r2));
        goto L4
    L12:
        r0.append('}');
        String r6 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
        return r6;
    }

    public final boolean c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "optionId");
        return this.f6775b.contains(r2);
    }

    public final String d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "optionId");
        String r1 = (String) ZeusTransformUtils.preCheckCast(this.c.get(r2), String.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        return "";
    L6:
        return r1;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, j.class) == true) goto L8;
        return false;
    L8:
        j r6 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f6774a, r6.f6774a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6775b, r6.f6775b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f6774a.hashCode() * 31) + this.f6775b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "GuidedPreferenceInterviewState(pages=" + this.f6774a + ", selectedOptionIds=" + this.f6775b + ", inputByOptionId=" + this.c + ')';
    }
}
