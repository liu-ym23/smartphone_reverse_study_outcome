package com.obric.memorydata.memory.inapprule;

import android.security.obric.guard.ObricSecurityGuardStub;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crypto.utils.CryptoConst;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.ca;
import com.tom_roush.pdfbox.pdmodel.a.d.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0014\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000bJ\u0014\u0010\u0012\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/memory/inapprule/InAppRuleCodec;", "", "<init>", "()V", "canonical", "", EventBody.KEY_VALUE, "hash", "digest", "rows", "", "Lcom/obric/memorydata/database/entity/InAppL1RuleEntity;", "version", "row", "decode", "Lorg/json/JSONObject;", "validate", "", "catalog", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10149a = null;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.inapprule.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class C0497a<T> implements Comparator {
        public C0497a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(((ca) ZeusTransformUtils.preCheckCast(r2, ca.class, "com.obric.memorydata.plugin")).b(), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(((ca) ZeusTransformUtils.preCheckCast(r3, ca.class, "com.obric.memorydata.plugin")).b(), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f10149a = new a();
    }

    private a() {
    }

    private static final CharSequence a(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r3)}, 1));
        Intrinsics.checkNotNullExpressionValue(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final CharSequence a(Object r3, int r4) {
        return (CharSequence) ZeusTransformUtils.preCheckCast(f10149a.a(((JSONArray) ZeusTransformUtils.preCheckCast(r3, JSONArray.class, "com.obric.memorydata.plugin")).get(r4)), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final CharSequence a(Object r4, String r5) {
        StringBuilder r0 = new StringBuilder();
        a r1 = f10149a;
        return (CharSequence) ZeusTransformUtils.preCheckCast(r0.append(r1.a(r5)).append(':').append(r1.a(((JSONObject) ZeusTransformUtils.preCheckCast(r4, JSONObject.class, "com.obric.memorydata.plugin")).get(r5))).toString(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final Comparable c(ca r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (Comparable) ZeusTransformUtils.preCheckCast(r2.a(), Comparable.class, "com.obric.memorydata.plugin");
    }

    private static final Comparable d(ca r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (Comparable) ZeusTransformUtils.preCheckCast(r2.b(), Comparable.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$-nGAVKZ5LpN7vKKw-gK55c7s5Yg, reason: not valid java name */
    public static /* synthetic */ Comparable m701lambda$nGAVKZ5LpN7vKKwgK55c7s5Yg(ca r0) {
        return d(r0);
    }

    /* JADX INFO: renamed from: lambda$2_2hfj-fpKwN6E3JpjSelL0BrZ0, reason: not valid java name */
    public static /* synthetic */ CharSequence m702lambda$2_2hfjfpKwN6E3JpjSelL0BrZ0(Object r0, int r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Comparable lambda$V7hi8W7fdrE1j3uIMk8CwydvSJ4(ca r0) {
        return c(r0);
    }

    public static /* synthetic */ CharSequence lambda$W9JGhfdLRhqeqrOrQl0VQQLqV9o(Object r0, String r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ CharSequence lambda$yvgb8UNy_vojGsobfPjsAfcwcnw(byte r0) {
        return a(r0);
    }

    public final ca a(JSONObject r13) {
        Intrinsics.checkNotNullParameter(r13, EventBody.KEY_VALUE);
        String r2 = r13.getString(ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
        String r3 = r13.getString("ruleId");
        Intrinsics.checkNotNullExpressionValue(r3, "getString(...)");
        int r4 = r13.getInt("engineVersion");
        String r5 = r13.getString("ruleVersion");
        Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
        long r6 = r13.getLong("minAppVersionCode");
        long r8 = r13.getLong("maxAppVersionCode");
        String r10 = r13.getString("ruleJson");
        Intrinsics.checkNotNullExpressionValue(r10, "getString(...)");
        ca r0 = new ca(r2, r3, r4, r5, r6, r8, r10, a(r13.getJSONArray("business")));
        b(r0);
        if (Intrinsics.areEqual(a(r0), r0.d()) == false) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("INVALID_CATALOG".toString());
    }

    public final String a(ca r6) {
        Intrinsics.checkNotNullParameter(r6, "row");
        JSONObject r0 = new JSONObject(r6.g());
        r0.remove("templateVersion");
        JSONObject r1 = new JSONObject();
        r1.put(ObricMemoryConstants.KEY_PACKAGE_NAME, r6.a());
        r1.put("ruleId", r6.b());
        r1.put("engineVersion", r6.c());
        r1.put("minAppVersionCode", r6.e());
        r1.put("maxAppVersionCode", r6.f());
        r1.put("rule", r0);
        r1.put("business", new JSONArray(r6.h()));
        Unit r7 = Unit.INSTANCE;
        return a(a(r1));
    }

    public final String a(final Object r12) {
        if (r12 != null) goto L4;
    L26:
        return "null";
    L4:
        if (Intrinsics.areEqual(r12, JSONObject.NULL) == true) goto L26;
        if (ZeusTransformUtils.instanceOf(r12, JSONObject.class) == false) goto L11;
        Iterator<String> r11 = ((JSONObject) ZeusTransformUtils.preCheckCast(r12, JSONObject.class, "com.obric.memorydata.plugin")).keys();
        Intrinsics.checkNotNullExpressionValue(r11, "keys(...)");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(SequencesKt.toList(SequencesKt.asSequence(r11)), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast("{", CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast("}", CharSequence.class, "com.obric.memorydata.plugin");
        int r6 = 0;
        CharSequence r7 = null;
        Function1 r8 = new $$Lambda$a$W9JGhfdLRhqeqrOrQl0VQQLqV9o(r12);
    L28:
        return CollectionsKt.joinToString$default(r2, r3, r4, r5, r6, r7, r8, 24, null);
    L11:
        if (ZeusTransformUtils.instanceOf(r12, JSONArray.class) == false) goto L14;
        r2 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, ((JSONArray) ZeusTransformUtils.preCheckCast(r12, JSONArray.class, "com.obric.memorydata.plugin")).length()), Iterable.class, "com.obric.memorydata.plugin");
        r3 = (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin");
        r4 = (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.memorydata.plugin");
        r5 = (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.memorydata.plugin");
        r6 = 0;
        r7 = null;
        r8 = new $$Lambda$a$2_2hfjfpKwN6E3JpjSelL0BrZ0(r12);
        goto L28
    L14:
        if (ZeusTransformUtils.instanceOf(r12, String.class) == false) goto L17;
        String r0 = JSONObject.quote((String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r0, "quote(...)");
        return StringsKt.replace$default(r0, "\\/", "/", false, 4, null);
    L17:
        if (ZeusTransformUtils.instanceOf(r12, Boolean.class) == true) goto L30;
        if (ZeusTransformUtils.instanceOf(r12, Integer.class) == true) goto L30;
        if (ZeusTransformUtils.instanceOf(r12, Long.class) == true) goto L30;
        throw new IllegalArgumentException("INVALID_CATALOG");
    L30:
        return r12.toString();
    }

    public final String a(String r11) {
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        MessageDigest r10 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);
        byte[] r12 = r11.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r12, "getBytes(...)");
        byte[] r1 = r10.digest(r12);
        Intrinsics.checkNotNullExpressionValue(r1, "digest(...)");
        return ArraysKt.joinToString$default(r1, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$a$yvgb8UNy_vojGsobfPjsAfcwcnw.INSTANCE, 30, null);
    }

    public final String a(List<ca> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "rows");
        JSONArray r0 = new JSONArray();
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin"), ComparisonsKt.compareBy(new Function1[]{$$Lambda$a$V7hi8W7fdrE1j3uIMk8CwydvSJ4.INSTANCE, $$Lambda$a$nGAVKZ5LpN7vKKwgK55c7s5Yg.INSTANCE})), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        ca r2 = (ca) ZeusTransformUtils.preCheckCast(r8.next(), ca.class, "com.obric.memorydata.plugin");
        r0.put(new JSONArray().put(r2.a()).put(r2.b()).put(r2.d()));
        goto L4
    L6:
        Unit r9 = Unit.INSTANCE;
        return a(a(r0));
    }

    public final String b(List<ca> r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "rows");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L47;
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        b((ca) ZeusTransformUtils.preCheckCast(r0.next(), ca.class, "com.obric.memorydata.plugin"));
        goto L6
    L8:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r13.iterator();
    L10:
        if (r16.hasNext() == false) goto L12;
        r1.add(f10149a.a(new JSONObject(((ca) ZeusTransformUtils.preCheckCast(r16.next(), ca.class, "com.obric.memorydata.plugin")).g()).getJSONObject("defaults")));
        goto L10
    L12:
        List r17 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r17.size() != 1) goto L15;
        boolean r2 = true;
    L16:
        if (r2 == false) goto L45;
        JSONArray r3 = new JSONArray();
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L19:
        if (r6.hasNext() == false) goto L24;
        Object r7 = r6.next();
        ca r8 = (ca) ZeusTransformUtils.preCheckCast(r7, ca.class, "com.obric.memorydata.plugin");
        Triple r9 = new Triple(r8.a(), Long.valueOf(r8.e()), Long.valueOf(r8.f()));
        Object r10 = r5.get(r9);
        if (r10 != null) goto L23;
        r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r5.put(r9, r10);
    L23:
        ((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin")).add(r7);
        goto L19
    L24:
        Iterator r11 = r5.entrySet().iterator();
    L26:
        if (r11.hasNext() == false) goto L32;
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Triple r18 = (Triple) ZeusTransformUtils.preCheckCast(r12.getKey(), Triple.class, "com.obric.memorydata.plugin");
        List r19 = (List) ZeusTransformUtils.preCheckCast(r12.getValue(), List.class, "com.obric.memorydata.plugin");
        JSONObject r20 = new JSONObject();
        r20.put(ObricMemoryConstants.KEY_PACKAGE_NAME, r18.getFirst());
        r20.put("appConstraint", new JSONObject().put("minVersionCode", ((Number) ZeusTransformUtils.preCheckCast(r18.getSecond(), Number.class, "com.obric.memorydata.plugin")).longValue()).put("maxVersionCode", ((Number) ZeusTransformUtils.preCheckCast(r18.getThird(), Number.class, "com.obric.memorydata.plugin")).longValue()));
        JSONArray r21 = new JSONArray();
        Iterator r22 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new C0497a(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L29:
        if (r22.hasNext() == false) goto L31;
        r21.put(new JSONObject(((ca) ZeusTransformUtils.preCheckCast(r22.next(), ca.class, "com.obric.memorydata.plugin")).g()).getJSONObject("rule"));
        goto L29
    L31:
        Unit r23 = Unit.INSTANCE;
        r20.put("rules", r21);
        r3.put(r20);
        goto L26
    L32:
        JSONObject r24 = new JSONObject().put("engineVersion", 1);
        Iterator r110 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r110.hasNext() == false) goto L43;
        long r25 = new JSONObject(((ca) ZeusTransformUtils.preCheckCast(r110.next(), ca.class, "com.obric.memorydata.plugin")).g()).getLong("templateVersion");
    L36:
        if (r110.hasNext() == false) goto L40;
        long r26 = new JSONObject(((ca) ZeusTransformUtils.preCheckCast(r110.next(), ca.class, "com.obric.memorydata.plugin")).g()).getLong("templateVersion");
        if (r25 >= r26) goto L36;
        r25 = r26;
        goto L36
    L40:
        String r111 = r24.put("templateVersion", r25).put("defaults", new JSONObject((String) ZeusTransformUtils.preCheckCast(CollectionsKt.single(r17), String.class, "com.obric.memorydata.plugin"))).put("apps", r3).toString();
        Intrinsics.checkNotNullExpressionValue(r111, "toString(...)");
        return r111;
    L43:
        throw new NoSuchElementException();
    L45:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L15:
        r2 = false;
        goto L16
    L47:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final void b(ca r11) {
        Intrinsics.checkNotNullParameter(r11, "row");
        boolean r0 = true;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11.a(), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L5;
    L9:
        boolean r10 = false;
    L11:
        if (r10 == false) goto L126;
        if (r11.e() >= (-1)) goto L15;
    L17:
        boolean r12 = false;
    L18:
        if (r12 == false) goto L124;
        if (r11.e() >= 0) goto L22;
    L27:
        boolean r13 = true;
    L28:
        if (r13 == false) goto L122;
        JSONObject r14 = new JSONObject(r11.g());
        if (r14.getLong("templateVersion") <= 0) goto L32;
        boolean r4 = true;
    L33:
        if (r4 == false) goto L120;
        JSONObject r5 = r14.getJSONObject("defaults");
        if (r5.getLong("dedupWindowMs") >= 0) goto L37;
    L39:
        boolean r6 = false;
    L40:
        if (r6 == false) goto L118;
        JSONObject r15 = r14.getJSONObject("rule");
        if (Intrinsics.areEqual(r15.getString(OaidModel.KEY_ID), r11.b()) == false) goto L116;
        JSONArray r7 = r15.getJSONObject("scope").getJSONArray("activityNames");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r7.length()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r8.iterator();
    L45:
        if (r16.hasNext() == false) goto L47;
        r9.add(r7.getString(((IntIterator) ZeusTransformUtils.preCheckCast(r16, IntIterator.class, "com.obric.memorydata.plugin")).nextInt()));
        goto L45
    L47:
        List r17 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L50;
    L69:
        boolean r18 = false;
    L70:
        if (r18 == false) goto L114;
        JSONArray r19 = new JSONArray(r11.h());
        Iterable r110 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r19.length()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r111 = r110.iterator();
    L73:
        if (r111.hasNext() == false) goto L75;
        r20.add(r19.getString(((IntIterator) ZeusTransformUtils.preCheckCast(r111, IntIterator.class, "com.obric.memorydata.plugin")).nextInt()));
        goto L73
    L75:
        List r112 = (List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r112, CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r112, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"))) == false) goto L112;
        Iterable r113 = (Iterable) ZeusTransformUtils.preCheckCast(r112, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r113, Collection.class) == true) goto L80;
    L82:
        Iterator r114 = r113.iterator();
    L84:
        if (r114.hasNext() == false) goto L81;
        String r21 = (String) ZeusTransformUtils.preCheckCast(r114.next(), String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r21, "auto_memory") == false) goto L88;
    L91:
        boolean r22 = true;
    L92:
        if (r22 == true) goto L84;
        boolean r115 = false;
    L94:
        if (r115 == false) goto L110;
        if (r15.has(f.f) == true) goto L98;
    L104:
        r0 = false;
    L105:
        if (r0 == false) goto L108;
        return;
    L108:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L98:
        if (r15.has("object") == false) goto L104;
        if (r15.has("emit") == true) goto L105;
        if (r15.has(ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CONFIRM) == false) goto L104;
    L110:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L88:
        if (Intrinsics.areEqual(r21, "screen_memory") == true) goto L91;
        r22 = false;
    L81:
        r115 = true;
        goto L94
    L80:
        if (((Collection) ZeusTransformUtils.preCheckCast(r113, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L82;
    L112:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L114:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L50:
        if (CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin")).size() != r17.size()) goto L69;
        Iterable r23 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r23, Collection.class) == true) goto L54;
    L56:
        Iterator r24 = r23.iterator();
    L58:
        if (r24.hasNext() == false) goto L55;
        String r25 = (String) ZeusTransformUtils.preCheckCast(r24.next(), String.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r25);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r25, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L62;
    L64:
        boolean r26 = false;
    L65:
        if (r26 == true) goto L58;
        boolean r27 = false;
    L67:
        if (r27 == false) goto L69;
        r18 = true;
        goto L70
    L62:
        if (Intrinsics.areEqual(r25, "*") == true) goto L64;
        r26 = true;
    L55:
        r27 = true;
        goto L67
    L54:
        if (((Collection) ZeusTransformUtils.preCheckCast(r23, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L56;
    L116:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L118:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L37:
        if (r5.getJSONObject("limits").getInt("maxNodes") <= 0) goto L39;
        r6 = true;
        goto L40
    L120:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L32:
        r4 = false;
        goto L33
    L122:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L22:
        if (r11.f() < 0) goto L27;
        if (r11.e() <= r11.f()) goto L27;
        r13 = false;
        goto L28
    L124:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L15:
        if (r11.f() < (-1)) goto L17;
        r12 = true;
        goto L18
    L126:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11.b(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L9;
        if (r11.c() != 1) goto L9;
        r10 = true;
        goto L11
    }
}
