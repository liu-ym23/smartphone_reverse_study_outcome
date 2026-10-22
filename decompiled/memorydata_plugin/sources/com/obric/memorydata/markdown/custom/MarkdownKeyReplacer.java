package com.obric.memorydata.markdown.custom;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.utils.az;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004*+,-B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JP\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0012JP\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0012J*\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00100\u00192\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J:\u0010\u001c\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J:\u0010\u001d\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0002J \u0010!\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001aH\u0002J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&H\u0002J\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00102\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/obric/memorydata/markdown/custom/MarkdownKeyReplacer;", "", "<init>", "()V", "KEY_LOCATION", "", "KEY_ADDRESS", "KEY_PHONE", "KEY_URL", "KEY_IDENTIFIER", "TAG", "replace", "Lcom/obric/memorydata/markdown/custom/MarkdownKeyReplacer$ReplaceResult;", "markdown", "keyInfoMap", "", "", "matchCase", "", "wholeWords", "spaceMode", "Lcom/obric/memorydata/markdown/custom/MarkdownKeyReplacer$SpaceMode;", "ignoreSpaces", "replaceWithAhoCorasick", "normalizeWithPositionMap", "Lkotlin/Pair;", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "replaceExact", "replaceExactAC", "formatReplacement", "keyType", "matchedValue", "isWholeWord", CommonConsts.APM_INNER_EVENT_COST_START, "end", "isWordChar", "c", "", "selectNonOverlappingMatches", "Lcom/obric/memorydata/markdown/custom/MarkdownKeyReplacer$Match;", "matches", "SpaceMode", "ReplaceResult", "Match", "AhoCorasickAutomaton", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MarkdownKeyReplacer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MarkdownKeyReplacer f9975a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/markdown/custom/MarkdownKeyReplacer$SpaceMode;", "", "<init>", "(Ljava/lang/String;I)V", "PRESERVE_MARKDOWN", "PRESERVE_LIST", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum SpaceMode extends Enum<SpaceMode> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ SpaceMode[] $VALUES = null;
        public static final SpaceMode PRESERVE_LIST = null;
        public static final SpaceMode PRESERVE_MARKDOWN = null;

        private static final /* synthetic */ SpaceMode[] $values() {
            return new SpaceMode[]{PRESERVE_MARKDOWN, PRESERVE_LIST};
        }

        static {
            PRESERVE_MARKDOWN = new SpaceMode("PRESERVE_MARKDOWN", 0);
            PRESERVE_LIST = new SpaceMode("PRESERVE_LIST", 1);
            SpaceMode[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private SpaceMode(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<SpaceMode> getEntries() {
            return $ENTRIES;
        }

        public static SpaceMode valueOf(String r2) {
            return (SpaceMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(SpaceMode.class, r2), SpaceMode.class, "com.obric.memorydata.plugin");
        }

        public static SpaceMode[] values() {
            return (SpaceMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SpaceMode[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001b\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\u0005HÆ\u0003J/\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001a\b\u0002\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR#\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/markdown/custom/MarkdownKeyReplacer$ReplaceResult;", "", "markdown", "", "updatedKeyInfoMap", "", "", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "getMarkdown", "()Ljava/lang/String;", "getUpdatedKeyInfoMap", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, List<String>> f9977b;

        public a(String r3, Map<String, ? extends List<String>> r4) {
            Map<String, List<String>> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "markdown");
            Intrinsics.checkNotNullParameter(r5, "updatedKeyInfoMap");
            this.f9976a = r3;
            this.f9977b = r5;
        }

        public final String a() {
            return this.f9976a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9976a, r6.f9976a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9977b, r6.f9977b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f9976a.hashCode() * 31) + this.f9977b.hashCode();
        }

        public String toString() {
            return "ReplaceResult(markdown=" + this.f9976a + ", updatedKeyInfoMap=" + this.f9977b + ')';
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9978a = null;

        static {
            int[] r0 = new int[SpaceMode.values().length];
            r0[SpaceMode.PRESERVE_MARKDOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[SpaceMode.PRESERVE_LIST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f9978a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class c<T> implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((String) ZeusTransformUtils.preCheckCast(((Triple) ZeusTransformUtils.preCheckCast(r3, Triple.class, "com.obric.memorydata.plugin")).getThird(), String.class, "com.obric.memorydata.plugin")).length()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((String) ZeusTransformUtils.preCheckCast(((Triple) ZeusTransformUtils.preCheckCast(r2, Triple.class, "com.obric.memorydata.plugin")).getThird(), String.class, "com.obric.memorydata.plugin")).length()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class d<T> implements Comparator {
        public d() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((String) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r3, Pair.class, "com.obric.memorydata.plugin")).getFirst(), String.class, "com.obric.memorydata.plugin")).length()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((String) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r2, Pair.class, "com.obric.memorydata.plugin")).getFirst(), String.class, "com.obric.memorydata.plugin")).length()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f9975a = new MarkdownKeyReplacer();
    }

    private MarkdownKeyReplacer() {
    }

    public static /* synthetic */ a a(MarkdownKeyReplacer r7, String r8, Map r9, boolean r10, boolean r11, SpaceMode r12, boolean r13, int r14, Object r15) {
        Map<String, ? extends List<String>> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        if ((r14 & 4) == 0) goto L5;
        boolean r3 = true;
    L7:
        if ((r14 & 8) == 0) goto L9;
        boolean r4 = true;
    L11:
        if ((r14 & 16) == 0) goto L13;
        r12 = SpaceMode.PRESERVE_MARKDOWN;
    L13:
        SpaceMode r5 = r12;
        if ((r14 & 32) == 0) goto L16;
        boolean r6 = true;
    L18:
        return r7.a(r8, r2, r3, r4, r5, r6);
    L16:
        r6 = r13;
        goto L18
    L9:
        r4 = r11;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }

    private static final CharSequence a(boolean r4, Map r5, SpaceMode r6, Map r7, MatchResult r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        MatchResult r11 = (MatchResult) ZeusTransformUtils.wrapperContextForParams(r8, MatchResult.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "matchResult");
        String r12 = r11.getValue();
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin");
        String r1 = new Regex("\\s").replace(r0, "");
        if (r4 == true) goto L6;
        r1 = r1.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r1, "toLowerCase(...)");
    L6:
        Pair r13 = (Pair) ZeusTransformUtils.preCheckCast(r9.get(r1), Pair.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L11;
        Object r14 = ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin");
    L10:
        return (CharSequence) r14;
    L11:
        String r15 = (String) ZeusTransformUtils.preCheckCast(r13.component1(), String.class, "com.obric.memorydata.plugin");
        String r16 = (String) ZeusTransformUtils.preCheckCast(r13.component2(), String.class, "com.obric.memorydata.plugin");
        int r17 = b.f9978a[r6.ordinal()];
        if (r17 != 1) goto L14;
    L18:
        List r18 = (List) ZeusTransformUtils.preCheckCast(r10.get(r15), List.class, "com.obric.memorydata.plugin");
        if (r18 != null) goto L22;
        r18 = CollectionsKt.emptyList();
    L22:
        if (r18.contains(r12) == true) goto L26;
        List r19 = (List) ZeusTransformUtils.preCheckCast(r10.get(r15), List.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L26;
        r19.add(r12);
    L26:
        r14 = ZeusTransformUtils.preCheckCast(f9975a.a(r15, r12), CharSequence.class, "com.obric.memorydata.plugin");
        goto L10
    L14:
        if (r17 != 2) goto L17;
        r12 = r16;
        goto L18
    L17:
        throw new NoWhenBranchMatchedException();
    }

    private static final CharSequence a(boolean r2, Map r3, MatchResult r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        MatchResult r6 = (MatchResult) ZeusTransformUtils.wrapperContextForParams(r4, MatchResult.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "matchResult");
        String r7 = r6.getValue();
        if (r2 == false) goto L5;
        String r8 = r7;
    L6:
        String r9 = (String) ZeusTransformUtils.preCheckCast(r5.get(r8), String.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L11;
        Object r10 = ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
    L10:
        return (CharSequence) r10;
    L11:
        r10 = ZeusTransformUtils.preCheckCast(f9975a.a(r9, r7), CharSequence.class, "com.obric.memorydata.plugin");
        goto L10
    L5:
        r8 = r7.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r8, "toLowerCase(...)");
        goto L6
    }

    private static final CharSequence a(boolean r2, Pair r3) {
        Intrinsics.checkNotNullParameter(r3, "<destruct>");
        String r4 = Regex.Companion.escape((String) ZeusTransformUtils.preCheckCast(r3.component1(), String.class, "com.obric.memorydata.plugin"));
        if (r2 == false) goto L5;
        Object r5 = ZeusTransformUtils.preCheckCast("(?<!\\w)" + r4 + "(?!\\w)", CharSequence.class, "com.obric.memorydata.plugin");
    L7:
        return (CharSequence) r5;
    L5:
        r5 = ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        goto L7
    }

    private static final CharSequence a(boolean r12, Triple r13) {
        Intrinsics.checkNotNullParameter(r13, "<destruct>");
        String r0 = (String) ZeusTransformUtils.preCheckCast(r13.component1(), String.class, "com.obric.memorydata.plugin");
        CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r13.component3(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r14.length()), Collection.class, "com.obric.memorydata.plugin");
        int r2 = 0;
    L4:
        if (r2 >= r14.length()) goto L6;
        r1.add(Regex.Companion.escape(String.valueOf(r14.charAt(r2))));
        r2 = r2 + 1;
        goto L4
    L6:
        String r15 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\\s*", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
        if (r12 == false) goto L9;
        Object r16 = ZeusTransformUtils.preCheckCast("(?<!\\w)" + r15 + "(?!\\w)", CharSequence.class, "com.obric.memorydata.plugin");
    L11:
        return (CharSequence) r16;
    L9:
        r16 = ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin");
        goto L11
    }

    private final String a(String r5, String r6) {
        String r4 = az.b(r6);
        switch(r5.hashCode()) {
            case -1618432855: goto L19;
            case -1147692044: goto L14;
            case 106642798: goto L10;
            case 1901043637: goto L6;
            default: goto L25;
        };
    L25:
        return r4;
    L6:
        if (r5.equals("location") == false) goto L26;
        StringBuilder r7 = new StringBuilder();
    L17:
        StringBuilder r8 = r7.append('[').append(r6).append("](map:");
    L24:
        return r8.append(r4).append(')').toString();
    L26:
        return r4;
    L10:
        if (r5.equals(MemoryKeyInfoEntity.KEY_PHONE) == false) goto L27;
        StringBuilder r9 = new StringBuilder().append('[').append(r6);
        String r10 = "](phone:";
    L22:
        r8 = r9.append(r10);
        goto L24
    L27:
        return r4;
    L14:
        if (r5.equals(MemoryKeyInfoEntity.KEY_ADDRESS) == false) goto L28;
        r7 = new StringBuilder();
        goto L17
    L28:
        return r4;
    L19:
        if (r5.equals(MemoryKeyInfoEntity.KEY_IDENTIFIER) == false) goto L29;
        r9 = new StringBuilder().append('[').append(r6);
        r10 = "](identifier:";
        goto L22
    L29:
        return r4;
    }

    private final String a(String r11, Map<String, ? extends List<String>> r12, final boolean r13, final boolean r14) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r10.entrySet().iterator();
    L4:
        if (r16.hasNext() == false) goto L23;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r16.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin");
        List r3 = (List) ZeusTransformUtils.preCheckCast(r1.getValue(), List.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r2, "url") == false) goto L8;
        List r4 = CollectionsKt.emptyList();
    L22:
        CollectionsKt.addAll(r15, (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"));
        goto L4
    L8:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
    L10:
        if (r7.hasNext() == false) goto L17;
        Object r8 = r7.next();
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L14;
        boolean r9 = true;
    L15:
        if (r9 == false) goto L10;
        r6.add(r8);
        goto L10
    L14:
        r9 = false;
        goto L15
    L17:
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r19 = r17.iterator();
    L19:
        if (r19.hasNext() == false) goto L21;
        r18.add(TuplesKt.to((String) ZeusTransformUtils.preCheckCast(r19.next(), String.class, "com.obric.memorydata.plugin"), r2));
        goto L19
    L21:
        r4 = (List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.memorydata.plugin");
        goto L22
    L23:
        List r110 = (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin");
        if (r110.isEmpty() == false) goto L26;
        return r11;
    L26:
        List r111 = CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r110, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new d(), Comparator.class, "com.obric.memorydata.plugin"));
        String r112 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r111, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, new $$Lambda$MarkdownKeyReplacer$fVW6wfF56kBiDPArZKwoBzagPCE(r14), 30, null);
        if (r13 == true) goto L29;
        Set r113 = SetsKt.setOf(RegexOption.IGNORE_CASE);
    L30:
        Regex r20 = new Regex(r112, r113);
        final Map r114 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r115 = r111.iterator();
    L32:
        if (r115.hasNext() == false) goto L39;
        Pair r116 = (Pair) ZeusTransformUtils.preCheckCast(r115.next(), Pair.class, "com.obric.memorydata.plugin");
        String r21 = (String) ZeusTransformUtils.preCheckCast(r116.component1(), String.class, "com.obric.memorydata.plugin");
        String r117 = (String) ZeusTransformUtils.preCheckCast(r116.component2(), String.class, "com.obric.memorydata.plugin");
        if (r13 == true) goto L37;
        r21 = r21.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r21, "toLowerCase(...)");
    L37:
        r114.put(r21, r117);
        goto L32
    L39:
        return r20.replace((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$MarkdownKeyReplacer$ZpRxVOxGAab2rsKIpZVRHyTgJEI(r13, r114));
    L29:
        r113 = SetsKt.emptySet();
        goto L30
    }

    public static /* synthetic */ CharSequence lambda$RO8IH_qv1476yrg2l1Um_qeXyak(boolean r0, Triple r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ CharSequence lambda$ZpRxVOxGAab2rsKIpZVRHyTgJEI(boolean r0, Map r1, MatchResult r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ CharSequence lambda$fVW6wfF56kBiDPArZKwoBzagPCE(boolean r0, Pair r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ CharSequence lambda$zJl0_5JlfLxabGf1ifrJ7OLaj2I(boolean r0, Map r1, SpaceMode r2, Map r3, MatchResult r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public final a a(String r21, Map<String, ? extends List<String>> r22, final boolean r23, final boolean r24, final SpaceMode r25, boolean r26) {
        Map<String, ? extends List<String>> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r21, "markdown");
        Intrinsics.checkNotNullParameter(r4, "keyInfoMap");
        Intrinsics.checkNotNullParameter(r25, "spaceMode");
        RunLog.INSTANCE.debug("MarkdownKeyReplacer", "before replace, markdown: " + r21 + ", keyInfoMap: " + r4);
        if (r26 == false) goto L5;
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<String, ? extends List<String>>> r7 = r4.entrySet().iterator();
    L8:
        if (r7.hasNext() == false) goto L27;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9.getKey(), String.class, "com.obric.memorydata.plugin");
        List r11 = (List) ZeusTransformUtils.preCheckCast(r9.getValue(), List.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r10, "url") == false) goto L12;
        List r12 = CollectionsKt.emptyList();
        Iterator<Map.Entry<String, ? extends List<String>>> r20 = r7;
    L26:
        CollectionsKt.addAll(r6, (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin"));
        r7 = r20;
        goto L8
    L12:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r13.iterator();
    L14:
        if (r15.hasNext() == false) goto L21;
        Object r16 = r15.next();
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L18;
        boolean r17 = true;
    L19:
        if (r17 == false) goto L14;
        r14.add(r16);
        goto L14
    L18:
        r17 = false;
        goto L19
    L21:
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r27 = r18.iterator();
    L23:
        if (r27.hasNext() == false) goto L25;
        String r110 = (String) ZeusTransformUtils.preCheckCast(r27.next(), String.class, "com.obric.memorydata.plugin");
        r19.add(new Triple(r110, r10, StringsKt.replace$default(r110, " ", "", false, 4, null)));
        r7 = r7;
        goto L23
    L25:
        r20 = r7;
        r12 = (List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin");
        goto L26
    L27:
        List r8 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
        if (r8.isEmpty() == true) goto L30;
        List r28 = CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new c(), Comparator.class, "com.obric.memorydata.plugin"));
        String r2 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r28, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, new $$Lambda$MarkdownKeyReplacer$RO8IH_qv1476yrg2l1Um_qeXyak(r24), 30, null);
        if (r23 == true) goto L34;
        Set r29 = SetsKt.setOf(RegexOption.IGNORE_CASE);
    L35:
        Regex r30 = new Regex(r2, r29);
        final Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r31 = r28.iterator();
    L37:
        if (r31.hasNext() == false) goto L45;
        Triple r32 = (Triple) ZeusTransformUtils.preCheckCast(r31.next(), Triple.class, "com.obric.memorydata.plugin");
        String r111 = (String) ZeusTransformUtils.preCheckCast(r32.component1(), String.class, "com.obric.memorydata.plugin");
        String r112 = (String) ZeusTransformUtils.preCheckCast(r32.component2(), String.class, "com.obric.memorydata.plugin");
        String r33 = (String) ZeusTransformUtils.preCheckCast(r32.component3(), String.class, "com.obric.memorydata.plugin");
        if (r23 == true) goto L43;
        r33 = r33.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r33, "toLowerCase(...)");
    L43:
        if (r3.containsKey(r33) == true) goto L37;
        r3.put(r33, TuplesKt.to(r112, r111));
        goto L37
    L45:
        final Map r34 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4.keySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L47:
        if (r5.hasNext() == false) goto L49;
        r34.put((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
        goto L47
    L49:
        String r0 = r30.replace((CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$MarkdownKeyReplacer$zJl0_5JlfLxabGf1ifrJ7OLaj2I(r23, r3, r25, r34));
        RunLog.INSTANCE.debug("MarkdownKeyReplacer", "after replace, resultMarkdown: " + r0 + ", updatedMap: " + r34);
        return new a(r0, r34);
    L34:
        r29 = SetsKt.emptySet();
        goto L35
    L30:
        return new a(r21, r4);
    L5:
        return new a(a(r21, r4, r23, r24), r4);
    }
}
