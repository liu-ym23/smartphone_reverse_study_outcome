package com.obric.aiproactive.ui.progress;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a>\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0000\u001a$\u0010\u0012\u001a\u00020\u0013*\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002\u001a\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0000\u001a,\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"MAX_CONTEXT_SOURCE_NAMES_IN_SUMMARY", "", "GENERIC_CONTEXT_GROUP_TITLES", "", "", "CONTEXT_SOURCE_DISPLAY_ORDER", "", "buildAgentRunDisplayGroups", "", "Lcom/obric/aiproactive/ui/progress/AgentRunUiGroup;", "stageId", "stageType", "items", "Lcom/obric/aiproactive/api/AiProactiveAgentRunDisplayItemDto;", "state", "Lcom/obric/aiproactive/ui/progress/AgentRunUiState;", "listStyle", "Lcom/obric/aiproactive/ui/progress/AgentRunSecondaryListStyle;", "toGroupedUiItem", "Lcom/obric/aiproactive/ui/progress/AgentRunUiItem;", OaidModel.KEY_ID, "groupKey", "fallbackAgentRunContextGroupTitle", "buildAgentRunContextSourceSummaryGroups", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f6803a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, Integer> f6804b = null;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            p r2 = (p) ZeusTransformUtils.preCheckCast(r3, p.class, "com.obric.memorydata.plugin");
            Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(c.a().get(r2.a()), Integer.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L5;
            Object r6 = ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin");
        L6:
            Comparable r7 = (Comparable) r6;
            p r8 = (p) ZeusTransformUtils.preCheckCast(r4, p.class, "com.obric.memorydata.plugin");
            Integer r9 = (Integer) ZeusTransformUtils.preCheckCast(c.a().get(r8.a()), Integer.class, "com.obric.memorydata.plugin");
            if (r9 == null) goto L9;
            Object r10 = ZeusTransformUtils.preCheckCast(r9, Comparable.class, "com.obric.memorydata.plugin");
        L11:
            return ComparisonsKt.compareValues(r7, (Comparable) r10);
        L9:
            r10 = ZeusTransformUtils.preCheckCast(Integer.MAX_VALUE, Comparable.class, "com.obric.memorydata.plugin");
            goto L11
        L5:
            r6 = ZeusTransformUtils.preCheckCast(Integer.MAX_VALUE, Comparable.class, "com.obric.memorydata.plugin");
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f6805a;

        public b(Comparator r3) {
            this.f6805a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r1 = this.f6805a.compare(r2, r3);
            if (r1 == 0) goto L6;
            return r1;
        L6:
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((p) ZeusTransformUtils.preCheckCast(r2, p.class, "com.obric.memorydata.plugin")).c()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((p) ZeusTransformUtils.preCheckCast(r3, p.class, "com.obric.memorydata.plugin")).c()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.progress.c$c, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J(\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"com/obric/aiproactive/ui/progress/AgentRunDisplayGroupingKt$buildAgentRunDisplayGroups$Bucket", "", "title", "", "items", "", "Lcom/obric/aiproactive/ui/progress/AgentRunUiItem;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "getItems", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/obric/aiproactive/ui/progress/AgentRunDisplayGroupingKt$buildAgentRunDisplayGroups$Bucket;", "equals", "", "other", "hashCode", "", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0314c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<l> f6807b;

        public C0314c(String r3, List<l> r4) {
            List<l> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "title");
            Intrinsics.checkNotNullParameter(r5, "items");
            this.f6806a = r3;
            this.f6807b = r5;
        }

        public final String a() {
            return this.f6806a;
        }

        public final List<l> b() {
            return this.f6807b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0314c.class) == true) goto L8;
            return false;
        L8:
            C0314c r6 = (C0314c) ZeusTransformUtils.preCheckCast(r5, C0314c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6806a, r6.f6806a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f6807b, r6.f6807b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f6806a.hashCode() * 31) + this.f6807b.hashCode();
        }

        public String toString() {
            return "Bucket(title=" + this.f6806a + ", items=" + this.f6807b + ')';
        }
    }

    static {
        f6803a = SetsKt.setOf(new String[]{"本轮信息", "详情"});
        f6804b = MapsKt.mapOf(new Pair[]{TuplesKt.to("current_state", 0), TuplesKt.to("recent_activity", 1), TuplesKt.to("user_profile", 2), TuplesKt.to("preference", 3), TuplesKt.to("task", 4)});
    }

    private static final l a(com.obric.aiproactive.api.f r15, String r16, AgentRunUiState r17, String r18) {
        String r5 = m.a(r18, r15.c(), r15.d());
        return new l(r16, r5, m.b(r18, r5, r15.d()), r15.e(), r17, false, r15.f(), r15.g(), 32, null);
    }

    private static final p a(int r5, com.obric.aiproactive.api.f r6) {
        Intrinsics.checkNotNullParameter(r6, "item");
        String r0 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6.a(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6.b(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r7) == false) goto L5;
        r7 = a(r0);
    L5:
        String r1 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin");
        boolean r4 = true;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
    L10:
        r4 = false;
    L12:
        if (r4 == true) goto L15;
        r7 = null;
    L15:
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L18;
        return null;
    L18:
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r2) == false) goto L22;
        r2 = "title:" + r8;
    L22:
        return new p((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"), r8, r5);
    L8:
        if (f6803a.contains(r1) == true) goto L10;
        goto L10
    }

    public static final String a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "groupKey");
        switch(r1.hashCode()) {
            case -1708972469: goto L22;
            case -1459831589: goto L18;
            case -1271606157: goto L14;
            case 3552645: goto L10;
            case 1216225589: goto L6;
            default: goto L25;
        };
    L25:
        return "";
    L6:
        if (r1.equals("user_profile") == false) goto L25;
        return "用户画像";
    L10:
        if (r1.equals("task") == false) goto L25;
        return "关注事项";
    L14:
        if (r1.equals("recent_activity") == false) goto L25;
        return "最近行为";
    L18:
        if (r1.equals("preference") == false) goto L25;
        return "主动偏好";
    L22:
        if (r1.equals("current_state") == false) goto L25;
        return "当前状态";
    }

    public static final List<k> a(String r29, String r30, List<com.obric.aiproactive.api.f> r31, AgentRunUiState r32, AgentRunSecondaryListStyle r33) {
        String r1 = r30;
        String r13 = "com.obric.memorydata.plugin";
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r31, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r29, "stageId");
        Intrinsics.checkNotNullParameter(r1, "stageType");
        Intrinsics.checkNotNullParameter(r2, "items");
        Intrinsics.checkNotNullParameter(r32, "state");
        Intrinsics.checkNotNullParameter(r33, "listStyle");
        if (r2.isEmpty() == true) goto L5;
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        char r12 = 0;
        int r14 = 0;
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L9;
    L11:
        Iterator r4 = r3.iterator();
    L13:
        if (r4.hasNext() == false) goto L10;
        com.obric.aiproactive.api.f r5 = (com.obric.aiproactive.api.f) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.aiproactive.api.f.class, "com.obric.memorydata.plugin");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5.a(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L17;
    L20:
        boolean r6 = true;
    L21:
        if (r6 == false) goto L13;
        boolean r7 = true;
    L23:
        String r10 = "";
        if (r7 == true) goto L34;
        String r8 = r29 + "-details";
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r9.iterator();
    L27:
        if (r15.hasNext() == false) goto L33;
        Object r16 = r15.next();
        int r17 = r14 + 1;
        if (r14 >= 0) goto L31;
        CollectionsKt.throwIndexOverflow();
    L31:
        r11.add(a((com.obric.aiproactive.api.f) ZeusTransformUtils.preCheckCast(r16, com.obric.aiproactive.api.f.class, "com.obric.memorydata.plugin"), r29 + '-' + r14, r32, "details"));
        r14 = r17;
        goto L27
    L33:
        return CollectionsKt.listOf(new k(r8, "", (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"), r33));
    L34:
        LinkedHashMap r18 = new LinkedHashMap();
        HashSet r19 = new HashSet();
        Iterator r110 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r20 = 0;
    L36:
        if (r110.hasNext() == false) goto L76;
        Object r21 = r110.next();
        int r111 = r20 + 1;
        if (r20 >= 0) goto L40;
        CollectionsKt.throwIndexOverflow();
    L40:
        com.obric.aiproactive.api.f r22 = (com.obric.aiproactive.api.f) ZeusTransformUtils.preCheckCast(r21, com.obric.aiproactive.api.f.class, r13);
        CharSequence r23 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r22.a(), CharSequence.class, r13)).toString(), CharSequence.class, r13);
        boolean r24 = StringsKt.isBlank(r23);
        CharSequence r25 = r23;
        if (r24 == false) goto L46;
        CharSequence r26 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r22.b(), CharSequence.class, r13)).toString(), CharSequence.class, r13);
        boolean r27 = StringsKt.isBlank(r26);
        CharSequence r28 = r26;
        if (r27 == false) goto L45;
        r28 = "other";
    L45:
        r25 = (String) ZeusTransformUtils.preCheckCast(r28, String.class, r13);
    L46:
        String r34 = (String) ZeusTransformUtils.preCheckCast(r25, String.class, r13);
        CharSequence r35 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r22.b(), CharSequence.class, r13)).toString(), CharSequence.class, r13);
        boolean r36 = StringsKt.isBlank(r35);
        CharSequence r37 = r35;
        if (r36 == false) goto L49;
        r37 = a(r34);
    L49:
        String r38 = (String) ZeusTransformUtils.preCheckCast(r37, String.class, r13);
        if (Intrinsics.areEqual(r1, "conclusion") == false) goto L52;
    L55:
        char r39 = 1;
    L56:
        if (r39 == 0) goto L59;
        r38 = null;
    L59:
        if (r38 != null) goto L61;
        r38 = r10;
    L61:
        String r40 = m.a(r34, r22.c(), r22.d());
        String r41 = m.b(r34, r40, r22.d());
        StringBuilder r42 = new StringBuilder().append(r34).append(r12).append(r40).append(r12).append(r41).append(r12).append(r22.f()).append(r12);
        com.obric.aiproactive.api.d r112 = r22.g();
        if (r112 == null) goto L64;
        String r113 = r112.a();
    L65:
        if (r113 != null) goto L68;
        r113 = r10;
    L68:
        if (r19.add(r42.append(r113).toString()) == false) goto L74;
        Map r43 = (Map) ZeusTransformUtils.preCheckCast(r18, Map.class, r13);
        Object r114 = r43.get(r34);
        if (r114 != null) goto L73;
        r114 = new C0314c(r38, (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, r13));
        r43.put(r34, r114);
    L73:
        char r210 = 0;
        ((Collection) ZeusTransformUtils.preCheckCast(((C0314c) ZeusTransformUtils.preCheckCast(r114, C0314c.class, r13)).b(), Collection.class, r13)).add(new l(r29 + '-' + r20, r40, r41, r22.e(), r32, false, r22.f(), r22.g(), 32, null));
    L75:
        r1 = r30;
        r13 = r13;
        r20 = r111;
        r10 = r10;
        r19 = r19;
        r12 = r210;
        r18 = r18;
        goto L36
    L74:
        r19 = r19;
        r210 = r12;
        goto L75
    L64:
        r113 = null;
        goto L65
    L52:
        if (Intrinsics.areEqual(r1, "result") == true) goto L55;
        r39 = r12;
        goto L56
    L76:
        String r115 = r13;
        Map r44 = (Map) ZeusTransformUtils.preCheckCast(r18, Map.class, r115);
        Collection r45 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r44.size()), Collection.class, r115);
        Iterator r46 = r44.entrySet().iterator();
    L78:
        if (r46.hasNext() == false) goto L81;
        Map.Entry r47 = (Map.Entry) ZeusTransformUtils.preCheckCast(r46.next(), Map.Entry.class, r115);
        String r48 = (String) ZeusTransformUtils.preCheckCast(r47.getKey(), String.class, r115);
        C0314c r49 = (C0314c) ZeusTransformUtils.preCheckCast(r47.getValue(), C0314c.class, r115);
        r45.add(new k(r29 + '-' + r48, r49.a(), r49.b(), r33));
        goto L78
    L81:
        return (List) ZeusTransformUtils.preCheckCast(r45, List.class, r115);
    L17:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5.b(), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L20;
        r6 = false;
    L10:
        r7 = false;
        goto L23
    L9:
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L11;
    L5:
        return CollectionsKt.emptyList();
    }

    public static final List<k> a(String r20, List<com.obric.aiproactive.api.f> r21, AgentRunUiState r22) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r20, "stageId");
        Intrinsics.checkNotNullParameter(r1, "items");
        Intrinsics.checkNotNullParameter(r22, "state");
        List r3 = SequencesKt.toList(SequencesKt.map(SequencesKt.sortedWith(SequencesKt.distinctBy(SequencesKt.mapIndexedNotNull(SequencesKt.filter(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")), $$Lambda$c$V_nDkv0A75I98fPjdOnx3I9Vrc.INSTANCE), $$Lambda$c$Ju5wViVBDs0PEqV1YAbB2HRkOo.INSTANCE), (Function1) ZeusTransformUtils.preCheckCast(AgentRunDisplayGroupingKt$buildAgentRunContextSourceSummaryGroups$sourceNames$3.INSTANCE, Function1.class, "com.obric.memorydata.plugin")), (Comparator) ZeusTransformUtils.preCheckCast(new b((Comparator) ZeusTransformUtils.preCheckCast(new a(), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin")), (Function1) ZeusTransformUtils.preCheckCast(AgentRunDisplayGroupingKt$buildAgentRunContextSourceSummaryGroups$sourceNames$6.INSTANCE, Function1.class, "com.obric.memorydata.plugin")));
        if (r3.isEmpty() == true) goto L5;
        List r4 = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"), 3);
        StringBuilder r5 = new StringBuilder();
        r5.append("参考了");
        r5.append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("、", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null));
        if (r3.size() <= r4.size()) goto L9;
        r5.append("等 ");
        r5.append(r3.size());
        r5.append(" 类信息");
    L9:
        String r6 = r5.toString();
        Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
        String r7 = r20 + "-context-sources";
        String r8 = r20 + "-context-source-summary";
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r0.hasNext() == true) goto L12;
        Comparable r2 = null;
    L19:
        Long r9 = (Long) ZeusTransformUtils.preCheckCast(r2, Long.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L22;
        long r10 = r9.longValue();
    L24:
        return CollectionsKt.listOf(new k(r7, "", CollectionsKt.listOf(new l(r8, r6, "", r10, r22, false, null, null, 224, null)), null, 8, null));
    L22:
        r10 = 0;
        goto L24
    L12:
        Comparable r11 = (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((com.obric.aiproactive.api.f) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.aiproactive.api.f.class, "com.obric.memorydata.plugin")).e()), Comparable.class, "com.obric.memorydata.plugin");
    L14:
        if (r0.hasNext() == false) goto L18;
        Comparable r12 = (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((com.obric.aiproactive.api.f) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.aiproactive.api.f.class, "com.obric.memorydata.plugin")).e()), Comparable.class, "com.obric.memorydata.plugin");
        if (r11.compareTo(r12) >= 0) goto L14;
        r11 = r12;
        goto L14
    L18:
        r2 = r11;
        goto L19
    L5:
        return CollectionsKt.emptyList();
    }

    public static final /* synthetic */ Map a() {
        return f6804b;
    }

    private static final boolean a(com.obric.aiproactive.api.f r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4.c(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L5;
        return true;
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4.d(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L7;
        return true;
    L7:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4.f(), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L13;
        return false;
    L13:
        return true;
    }

    /* JADX INFO: renamed from: lambda$Ju5wViVBDs0PEqV1YAbB2HRkO-o, reason: not valid java name */
    public static /* synthetic */ p m336lambda$Ju5wViVBDs0PEqV1YAbB2HRkOo(int r0, com.obric.aiproactive.api.f r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$V_nDkv0-A75I98fPjdOnx3I9Vrc, reason: not valid java name */
    public static /* synthetic */ boolean m337lambda$V_nDkv0A75I98fPjdOnx3I9Vrc(com.obric.aiproactive.api.f r0) {
        return a(r0);
    }
}
