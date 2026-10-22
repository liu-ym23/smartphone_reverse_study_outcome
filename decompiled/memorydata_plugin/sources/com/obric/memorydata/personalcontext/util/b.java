package com.obric.memorydata.personalcontext.util;

import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0018\u0010\u0012\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0018\u0010\u0013\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0018\u0010\u0014\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/personalcontext/util/CommunityNameExtractor;", "", "<init>", "()V", "CORE_COMMUNITY_SUFFIX", "", "", "ADDRESS_LEVEL_KEYWORDS", "BUILDING_KEYWORDS", "EXCLUDE_KEYWORDS", "NORMALIZING_SUFFIX", "TRAD_TO_SIMP", "", "", "CORE_SUFFIX_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "Ljava/util/regex/Pattern;", "BUILDING_PATTERN", "TRAILING_NUM_PATTERN", "SPECIAL_CHAR_PATTERN", "extract", "rawAddress", "_internalExtract", "preprocessAddress", MemoryKeyInfoEntity.KEY_ADDRESS, "matchCoreSuffix", "extractByStructure", "fallbackMatch", "cleanResult", "candidate", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12361a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f12362b = null;
    private static final List<String> c = null;
    private static final List<String> d = null;
    private static final List<String> e = null;
    private static final List<String> f = null;
    private static final Map<Character, Character> g = null;
    private static final Pattern h = null;
    private static final Pattern i = null;
    private static final Pattern j = null;
    private static final Pattern k = null;

    static {
        f12361a = new b();
        List<String> r0 = CollectionsKt.listOf(new String[]{"小区", "花园", "苑", "园", "公寓", "公馆", "华庭", "家园", "雅居", "别墅", "新村", "社区", "郡", "邸", "府", "阁", "轩", "坊", "里", "邨", "湾", "城", "庄园", "半岛", "广场", "中心", "领地", "公馆", "壹号院", "号院", "大厦"});
        f12362b = r0;
        c = CollectionsKt.listOf(new String[]{"省", "市", "区", "县", "镇", "乡", "街道", "路", "巷", "弄", "道", "大街", "大道", "中路", "北路", "南路", "东路", "西路", "环路", "高速", "快速路"});
        List<String> r1 = CollectionsKt.listOf(new String[]{"栋", "楼", "单元", "号", "室", "层", "幢", "梯", "户", "排", "组", "座", "阁"});
        d = r1;
        e = CollectionsKt.listOf(new String[]{"科技园", "产业园", "工业园", "商务区", "办公区", "写字楼", "商场", "超市", "医院", "学校", "公园", "景区", "地铁站", "高铁站", "机场", "码头"});
        f = CollectionsKt.listOf(new String[]{"小区", "家园", "新村", "社区"});
        g = MapsKt.mapOf(new Pair[]{TuplesKt.to((char) 22290, (char) 22253), TuplesKt.to((char) 26847, (char) 26635), TuplesKt.to((char) 37032, (char) 26449), TuplesKt.to((char) 35023, (char) 37324), TuplesKt.to((char) 34399, (char) 21495), TuplesKt.to((char) 23652, (char) 23618), TuplesKt.to((char) 23460, (char) 23460)});
        h = Pattern.compile("([^\\d\\p{Punct}\\s]{2,10})(" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$b$ADMEUaxxxCh23oJol5mygxG8oow.INSTANCE, 30, null) + ')', 2);
        i = Pattern.compile("\\d+(" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$b$A7mOn8N5pMSYBce42LJ_dxSmCs4.INSTANCE, 30, null) + ')', 2);
        j = Pattern.compile("\\d+$");
        k = Pattern.compile("[\\p{Punct}&&[^|]\\s]");
    }

    private b() {
    }

    private final String b(String r7) {
        String r8 = c(r7);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return "";
    L5:
        String r0 = d(r8);
        boolean r4 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
        String r1 = e(r8);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == true) goto L18;
        String r9 = f(r8);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L23;
        r4 = false;
    L23:
        if (r4 == true) goto L25;
        return "";
    L25:
        return g(r9);
    L18:
        return g(r1);
    L15:
        r5 = false;
        goto L16
    L11:
        return g(r0);
    L8:
        r3 = false;
        goto L9
    }

    private final String c(String r11) {
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r10.length()), Collection.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L4:
        if (r1 >= r10.length()) goto L6;
        char r2 = r10.charAt(r1);
        r12.add(Character.valueOf(((Character) ZeusTransformUtils.preCheckCast(g.getOrDefault(Character.valueOf(r2), Character.valueOf(r2)), Character.class, "com.obric.memorydata.plugin")).charValue()));
        r1 = r1 + 1;
        goto L4
    L6:
        String r13 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
        String r14 = k.matcher((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).replaceAll("");
        Intrinsics.checkNotNullExpressionValue(r14, "replaceAll(...)");
        String r15 = r14.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r15, "toLowerCase(...)");
        return r15;
    }

    private final String d(String r11) {
        Matcher r10 = h.matcher((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"));
        List r12 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    L4:
        if (r10.find() == false) goto L6;
        String r0 = r10.group();
        Intrinsics.checkNotNullExpressionValue(r0, "group(...)");
        r12.add(r0);
        goto L4
    L6:
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r13.hasNext() == true) goto L9;
        Object r14 = null;
    L19:
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14, String.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L23;
        return "";
    L23:
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(c, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r2 = -1;
    L25:
        if (r16.hasNext() == false) goto L29;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin");
        int r4 = StringsKt.lastIndexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin"), r3, 0, false, 6, null);
        if (r4 == (-1)) goto L25;
        r2 = Math.max(r2, r4 + r3.length());
        goto L25
    L29:
        if (r2 == (-1)) goto L40;
        String r17 = r15.substring(r2);
        Intrinsics.checkNotNullExpressionValue(r17, "substring(...)");
        return r17;
    L40:
        return r15;
    L9:
        Object r18 = r13.next();
        if (r13.hasNext() == true) goto L12;
    L11:
        r14 = r18;
        goto L19
    L12:
        int r1 = ((String) ZeusTransformUtils.preCheckCast(r18, String.class, "com.obric.memorydata.plugin")).length();
    L13:
        Object r5 = r13.next();
        int r6 = ((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin")).length();
        if (r1 >= r6) goto L17;
        r18 = r5;
        r1 = r6;
    L17:
        if (r13.hasNext() == true) goto L13;
        goto L11
    }

    private final String e(String r12) {
        String r11 = i.matcher((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).replaceAll("");
        Intrinsics.checkNotNullExpressionValue(r11, "replaceAll(...)");
        String r13 = j.matcher((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).replaceAll("");
        Intrinsics.checkNotNullExpressionValue(r13, "replaceAll(...)");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(c, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r3 = -1;
    L4:
        if (r0.hasNext() == false) goto L8;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        int r5 = StringsKt.lastIndexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"), r4, 0, false, 6, null);
        if (r5 == (-1)) goto L4;
        r3 = Math.max(r3, r5 + r4.length());
        goto L4
    L8:
        if (r3 == (-1)) goto L10;
        r13 = r13.substring(r3);
        Intrinsics.checkNotNullExpressionValue(r13, "substring(...)");
    L10:
        CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin");
        Pattern r1 = k;
        Intrinsics.checkNotNullExpressionValue(r1, "SPECIAL_CHAR_PATTERN");
        String r15 = new Regex(r1).replace(r14, "");
        int r2 = r15.length();
        boolean r6 = false;
        if (2 <= r2) goto L13;
    L15:
        if (r6 == true) goto L17;
        return "";
    L17:
        return r15;
    L13:
        if (r2 >= 13) goto L15;
        r6 = true;
        goto L15
    }

    private final String f(String r13) {
        Matcher r12 = Pattern.compile("([^\\d\\p{Punct}\\s]{2,8})(" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{"号院", "公馆", "郡", "邸", "坊"}), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$b$SeCvDKcYVyJRUT1PG_aGpBDX_A.INSTANCE, 30, null) + ')').matcher((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"));
        if (r12.find() == false) goto L5;
        String r14 = r12.group();
        Intrinsics.checkNotNullExpressionValue(r14, "group(...)");
        return r14;
    L5:
        return "";
    }

    private final String g(String r10) {
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(e, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L3:
        String r2 = r10;
    L4:
        boolean r4 = false;
        if (r9.hasNext() == false) goto L9;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        String r6 = r11.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r6, "toLowerCase(...)");
        if (StringsKt.contains$default(r5, (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L4;
        String r3 = r11.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r3, "toLowerCase(...)");
        r10 = StringsKt.replace$default(r2, r3, "", false, 4, null);
        goto L3
    L9:
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(f, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r12.hasNext() == false) goto L15;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin");
        if (StringsKt.endsWith$default(r2, r13, false, 2, null) == false) goto L11;
        r2 = StringsKt.removeSuffix(r2, (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"));
        goto L11
    L15:
        int r14 = r2.length();
        if (2 <= r14) goto L18;
    L20:
        if (r4 == true) goto L32;
        return "";
    L32:
        return StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L18:
        if (r14 >= 13) goto L20;
        r4 = true;
        goto L20
    }

    private static final CharSequence h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        String r3 = Pattern.quote(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "quote(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final CharSequence i(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        String r3 = Pattern.quote(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "quote(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final CharSequence j(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(f12361a.b(r2), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final CharSequence k(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        String r3 = Pattern.quote(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "quote(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ CharSequence lambda$A7mOn8N5pMSYBce42LJ_dxSmCs4(String r0) {
        return i(r0);
    }

    public static /* synthetic */ CharSequence lambda$ADMEUaxxxCh23oJol5mygxG8oow(String r0) {
        return h(r0);
    }

    /* JADX INFO: renamed from: lambda$SeCvDKcY-VyJRUT1PG_aGpBDX_A, reason: not valid java name */
    public static /* synthetic */ CharSequence m1101lambda$SeCvDKcYVyJRUT1PG_aGpBDX_A(String r0) {
        return k(r0);
    }

    /* JADX INFO: renamed from: lambda$csQEXeyb95S6-Fg7HPKkDRgbNGc, reason: not valid java name */
    public static /* synthetic */ CharSequence m1102lambda$csQEXeyb95S6Fg7HPKkDRgbNGc(String r0) {
        return j(r0);
    }

    public final String a(String r14) {
        Intrinsics.checkNotNullParameter(r14, "rawAddress");
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L7;
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"|"}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$b$csQEXeyb95S6Fg7HPKkDRgbNGc.INSTANCE, 30, null);
    L7:
        return b(r14);
    }
}
