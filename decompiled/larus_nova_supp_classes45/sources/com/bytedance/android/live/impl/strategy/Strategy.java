package com.bytedance.android.live.impl.strategy;

import com.bytedance.android.live.strategy.api.CombbineFactorInfo;
import com.bytedance.android.live.strategy.api.CombinCharacterInfo;
import com.bytedance.android.live.strategy.api.CombineInfo;
import com.bytedance.android.livesdk.jsbridge.methods.draft.m;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u0000 ?2\u00020\u0001:\u0001@BO\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001a\u0012\u001c\b\u0002\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001a\u0018\u00010\u001c¢\u0006\u0004\b=\u0010>J\u0006\u0010\u0002\u001a\u00020\u0000J$\u0010\b\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u00060\u0003J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\t\u001a\u00020\u0007J\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\rJ\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\u0010\u001a\u00020\u0007J\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0012j\b\u0012\u0004\u0012\u00020\u0007`\u00132\u0006\u0010\u0010\u001a\u00020\u0007J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\nJ\u0006\u0010\u0017\u001a\u00020\u0016J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001aHÆ\u0003J\u001d\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001a\u0018\u00010\u001cHÆ\u0003JQ\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001a2\u001c\b\u0002\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001a\u0018\u00010\u001cHÆ\u0001J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\t\u0010%\u001a\u00020$HÖ\u0001J\u0013\u0010)\u001a\u00020(2\b\u0010'\u001a\u0004\u0018\u00010&HÖ\u0003R4\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n0\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R>\u00100\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0012j\b\u0012\u0004\u0012\u00020\u0007`\u00130\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010+\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00103\u001a\u0004\b4\u00105R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00103\u001a\u0004\b6\u00105R\"\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u00107\u001a\u0004\b8\u00109R.\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001a\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010:\u001a\u0004\b;\u0010<¨\u0006A"}, d2 = {"Lcom/bytedance/android/live/impl/strategy/Strategy;", "Ljava/io/Serializable;", "deepCopy", "Lkotlin/Pair;", "", "", "", "", "getIntervalData", "faName", "", "Lcom/bytedance/android/live/strategy/api/CombineInfo;", "getCombineInfosByFaName", "", "filterFaList", "filterUsefulCombineInfoByFactors", "chName", "getFactorsByChName", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getFactorsByChNameV3", "getChList", "", "clearCache", "component1", "component2", "Ljava/util/concurrent/CopyOnWriteArrayList;", "component3", "Ljava/util/concurrent/ConcurrentHashMap;", "component4", "id", "strategyHash", "combineStrategys", "abInfos", "copy", "toString", "", "hashCode", "", "other", "", "equals", "factorsCacheMapByChName", "Ljava/util/Map;", "getFactorsCacheMapByChName", "()Ljava/util/Map;", "setFactorsCacheMapByChName", "(Ljava/util/Map;)V", "factorsCacheMapByChNameV3", "getFactorsCacheMapByChNameV3", "setFactorsCacheMapByChNameV3", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "getStrategyHash", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getCombineStrategys", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/ConcurrentHashMap;", "getAbInfos", "()Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/concurrent/CopyOnWriteArrayList;Ljava/util/concurrent/ConcurrentHashMap;)V", "Companion", "a", "livestrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Strategy implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("ab_info")
    private final ConcurrentHashMap<String, CopyOnWriteArrayList<CombineInfo>> abInfos;

    @SerializedName("combine")
    private final CopyOnWriteArrayList<CombineInfo> combineStrategys;
    private Map<String, List<String>> factorsCacheMapByChName;
    private Map<String, HashSet<String>> factorsCacheMapByChNameV3;

    @SerializedName("id")
    private final String id;

    @SerializedName("strategy_hash")
    private final String strategyHash;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public Strategy() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Strategy copy$default(Strategy r0, String r1, String r2, CopyOnWriteArrayList r3, ConcurrentHashMap r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.id;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.strategyHash;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.combineStrategys;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.abInfos;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.strategyHash;
    }

    public final CopyOnWriteArrayList<CombineInfo> component3() {
        return this.combineStrategys;
    }

    public final ConcurrentHashMap<String, CopyOnWriteArrayList<CombineInfo>> component4() {
        return this.abInfos;
    }

    public final Strategy copy(String r2, String r3, CopyOnWriteArrayList<CombineInfo> r4, ConcurrentHashMap<String, CopyOnWriteArrayList<CombineInfo>> r5) {
        return new Strategy(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof Strategy) == false) goto L14;
        Strategy r4 = (Strategy) r3;
        if (Intrinsics.areEqual(this.id, r4.id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.strategyHash, r4.strategyHash) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.combineStrategys, r4.combineStrategys) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.abInfos, r4.abInfos) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final synchronized Pair<List<Long>, Map<String, Long>> getIntervalData() {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L39
        LinkedHashMap r1 = new LinkedHashMap();     // Catch: Throwable -> L39
        CopyOnWriteArrayList<CombineInfo> r2 = this.combineStrategys;     // Catch: Throwable -> L39
        if (r2 == null) goto L36;
        Iterator<T> r3 = r2.iterator();     // Catch: Throwable -> L39
    L7:
        if (r3.hasNext() == false) goto L36;
        CombineInfo r4 = (CombineInfo) r3.next();     // Catch: Throwable -> L39
        if (r4 == null) goto L7;
        CopyOnWriteArrayList r5 = r4.getChList();     // Catch: Throwable -> L39
        if (r5 == null) goto L7;
        Iterator r6 = r5.iterator();     // Catch: Throwable -> L39
    L14:
        if (r6.hasNext() == false) goto L7;
        CombinCharacterInfo r7 = (CombinCharacterInfo) r6.next();     // Catch: Throwable -> L39
        String r8 = null;
        if (r7 == null) goto L18;
        Long r9 = Long.valueOf(r7.getCheckInterval());     // Catch: Throwable -> L39
    L19:
        if (r7 == null) goto L21;
        r8 = r7.getChName();     // Catch: Throwable -> L39
    L21:
        if (r9 == null) goto L14;
        if (r8 == null) goto L14;
        if (r9.longValue() <= 0) goto L14;
        if (r1.containsKey(r8) == true) goto L27;
        r0.add(r9);     // Catch: Throwable -> L39
        r1.put(r8, r9);     // Catch: Throwable -> L39
        goto L14
    L27:
        Long r11 = (Long) r1.get(r8);     // Catch: Throwable -> L39
        if (r11 == null) goto L29;
        if (r9.longValue() <= r11.longValue()) goto L33;
        long r12 = r11.longValue();     // Catch: Throwable -> L39
    L34:
        r1.put(r8, Long.valueOf(r12));     // Catch: Throwable -> L39
        goto L14
    L33:
        r12 = r9.longValue();     // Catch: Throwable -> L39
        goto L34
    L29:
        r0.add(r9);     // Catch: Throwable -> L39
        r1.put(r8, r9);     // Catch: Throwable -> L39
        goto L14
    L18:
        r9 = null;
    L36:
        Pair<List<Long>, Map<String, Long>> r13 = new Pair(r0, r1);     // Catch: Throwable -> L39
        monitor-exit(this);
        return r13;
    L39:
        th = move-exception;
        throw th;
    }

    public int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.strategyHash;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        CopyOnWriteArrayList<CombineInfo> r7 = this.combineStrategys;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        ConcurrentHashMap<String, CopyOnWriteArrayList<CombineInfo>> r11 = this.abInfos;
        if (r11 == null) goto L18;
        r1 = r11.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "Strategy(id=" + this.id + ", strategyHash=" + this.strategyHash + ", combineStrategys=" + this.combineStrategys + ", abInfos=" + this.abInfos + ")";
    }

    public final void clearCache() {
        this.factorsCacheMapByChName.clear();
    }

    public final Strategy deepCopy() {
        return (Strategy) GsonProtectorUtils.fromJson(new Gson(), m.a(this), Strategy.class);
    }

    public final List<String> getChList() {
        ArrayList r0 = new ArrayList();
        CopyOnWriteArrayList<CombineInfo> r1 = this.combineStrategys;
        if (r1 == null) goto L18;
        Iterator<T> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L18;
        CombineInfo r3 = (CombineInfo) r2.next();
        if (r3 == null) goto L6;
        CopyOnWriteArrayList r4 = r3.getChList();
        if (r4 == null) goto L6;
        Iterator r5 = r4.iterator();
    L13:
        if (r5.hasNext() == false) goto L6;
        String r6 = ((CombinCharacterInfo) r5.next()).getChName();
        if (r6 == null) goto L13;
        r0.add(r6);
    L18:
        return CollectionsKt.distinct(r0);
    }

    public final ConcurrentHashMap<String, CopyOnWriteArrayList<CombineInfo>> getAbInfos() {
        return this.abInfos;
    }

    public final CopyOnWriteArrayList<CombineInfo> getCombineStrategys() {
        return this.combineStrategys;
    }

    public final Map<String, List<String>> getFactorsCacheMapByChName() {
        return this.factorsCacheMapByChName;
    }

    public final Map<String, HashSet<String>> getFactorsCacheMapByChNameV3() {
        return this.factorsCacheMapByChNameV3;
    }

    public final String getId() {
        return this.id;
    }

    public final String getStrategyHash() {
        return this.strategyHash;
    }

    public final Strategy filterUsefulCombineInfoByFactors(Set<String> r12) {
        Intrinsics.checkNotNullParameter(r12, "filterFaList");
        CopyOnWriteArrayList<CombineInfo> r1 = this.combineStrategys;     // Catch: Exception -> L79
        if (r1 == null) goto L29;
        Iterator<T> r2 = r1.iterator();     // Catch: Exception -> L79
    L7:
        if (r2.hasNext() == false) goto L29;
        CombineInfo r5 = (CombineInfo) r2.next();     // Catch: Exception -> L79
        CopyOnWriteArrayList r6 = r5.getFaList();     // Catch: Exception -> L79
        if (r6 == null) goto L17;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));     // Catch: Exception -> L79
        Iterator r8 = r6.iterator();     // Catch: Exception -> L79
    L12:
        if (r8.hasNext() == false) goto L14;
        r7.add(((CombbineFactorInfo) r8.next()).getFaName());     // Catch: Exception -> L79
        goto L12
    L14:
        Set r9 = CollectionsKt.toSet(r7);     // Catch: Exception -> L79
        if (r9 == null) goto L17;
        Set r11 = CollectionsKt.intersect(r9, r12);     // Catch: Exception -> L79
    L18:
        Set r13 = r11;     // Catch: Exception -> L79
        if (r13 != null) goto L21;
    L24:
        boolean r14 = true;
    L25:
        if (r14 == false) goto L7;
        CopyOnWriteArrayList<CombineInfo> r15 = this.combineStrategys;     // Catch: Exception -> L79
        if (r15 == null) goto L7;
        r15.remove(r5);     // Catch: Exception -> L79
        goto L7
    L21:
        if (r13.isEmpty() == true) goto L24;
        r14 = false;
    L17:
        r11 = null;
    L29:
        ConcurrentHashMap<String, CopyOnWriteArrayList<CombineInfo>> r3 = this.abInfos;     // Catch: Exception -> L79
        if (r3 == null) goto L78;
        Set<Map.Entry<String, CopyOnWriteArrayList<CombineInfo>>> r4 = r3.entrySet();     // Catch: Exception -> L79
        if (r4 == null) goto L78;
        Iterator<T> r16 = r4.iterator();     // Catch: Exception -> L79
    L34:
        if (r16.hasNext() == false) goto L78;
        Map.Entry r17 = (Map.Entry) r16.next();     // Catch: Exception -> L79
        if (r17 == null) goto L64;
        CopyOnWriteArrayList r18 = (CopyOnWriteArrayList) r17.getValue();     // Catch: Exception -> L79
        if (r18 == null) goto L64;
        Iterator r19 = r18.iterator();     // Catch: Exception -> L79
    L42:
        if (r19.hasNext() == false) goto L64;
        CombineInfo r21 = (CombineInfo) r19.next();     // Catch: Exception -> L79
        CopyOnWriteArrayList r22 = r21.getFaList();     // Catch: Exception -> L79
        if (r22 == null) goto L52;
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));     // Catch: Exception -> L79
        Iterator r24 = r22.iterator();     // Catch: Exception -> L79
    L47:
        if (r24.hasNext() == false) goto L49;
        r23.add(((CombbineFactorInfo) r24.next()).getFaName());     // Catch: Exception -> L79
        goto L47
    L49:
        Set r25 = CollectionsKt.toSet(r23);     // Catch: Exception -> L79
        if (r25 == null) goto L52;
        Set r26 = CollectionsKt.intersect(r25, r12);     // Catch: Exception -> L79
    L53:
        Set r27 = r26;     // Catch: Exception -> L79
        if (r27 != null) goto L56;
    L59:
        boolean r28 = true;
    L60:
        if (r28 == false) goto L42;
        CopyOnWriteArrayList r29 = (CopyOnWriteArrayList) r17.getValue();     // Catch: Exception -> L79
        if (r29 == null) goto L42;
        r29.remove(r21);     // Catch: Exception -> L79
        goto L42
    L56:
        if (r27.isEmpty() == true) goto L59;
        r28 = false;
    L52:
        r26 = null;
    L64:
        if (r17 == null) goto L66;
        CopyOnWriteArrayList r31 = (CopyOnWriteArrayList) r17.getValue();     // Catch: Exception -> L79
    L67:
        if (r31 != null) goto L69;
    L72:
        boolean r32 = true;
    L73:
        if (r32 == false) goto L34;
        ConcurrentHashMap<String, CopyOnWriteArrayList<CombineInfo>> r33 = this.abInfos;     // Catch: Exception -> L79
        if (r33 == null) goto L34;
        CopyOnWriteArrayList<CombineInfo> r34 = r33.remove(r17.getKey());     // Catch: Exception -> L79
        goto L34
    L69:
        if (r31.isEmpty() == true) goto L72;
        r32 = false;
        goto L73
    L66:
        r31 = null;
    L78:
        return this;
    L79:
        return null;
    }

    public final synchronized List<CombineInfo> getCombineInfosByFaName(String r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r7, "faName");     // Catch: Throwable -> L30
        CopyOnWriteArrayList<CombineInfo> r0 = this.combineStrategys;     // Catch: Throwable -> L30
        if (r0 == null) goto L27;
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L30
        Iterator<T> r2 = r0.iterator();     // Catch: Throwable -> L30
    L7:
        if (r2.hasNext() == false) goto L28;
        Object r3 = r2.next();     // Catch: Throwable -> L30
        CombineInfo r4 = (CombineInfo) r3;     // Catch: Throwable -> L30
        boolean r5 = false;
        if (r4 == null) goto L25;
        CopyOnWriteArrayList r6 = r4.getFaList();     // Catch: Throwable -> L30
        if (r6 == null) goto L25;
        if (r6.isEmpty() == true) goto L25;
        Iterator r8 = r6.iterator();     // Catch: Throwable -> L30
    L17:
        if (r8.hasNext() == false) goto L25;
        CombbineFactorInfo r9 = (CombbineFactorInfo) r8.next();     // Catch: Throwable -> L30
        if (r9 == null) goto L21;
        String r11 = r9.getFaName();     // Catch: Throwable -> L30
    L23:
        if (Intrinsics.areEqual(r11, r7) == false) goto L17;
        r5 = true;
        goto L25
    L21:
        r11 = null;
    L25:
        if (r5 == false) goto L7;
        r1.add(r3);     // Catch: Throwable -> L30
    L28:
        monitor-exit(this);
        return r1;
    L27:
        r1 = new ArrayList();     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }

    public final synchronized List<String> getFactorsByChName(String r8) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r8, "chName");     // Catch: Throwable -> L50
        if (this.factorsCacheMapByChName.containsKey(r8) == true) goto L45;
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L50
        CopyOnWriteArrayList<CombineInfo> r1 = this.combineStrategys;     // Catch: Throwable -> L50
        if (r1 == null) goto L44;
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L50
        Iterator<T> r3 = r1.iterator();     // Catch: Throwable -> L50
    L9:
        if (r3.hasNext() == false) goto L29;
        Object r4 = r3.next();     // Catch: Throwable -> L50
        CombineInfo r5 = (CombineInfo) r4;     // Catch: Throwable -> L50
        boolean r6 = false;
        if (r5 == null) goto L27;
        CopyOnWriteArrayList r7 = r5.getChList();     // Catch: Throwable -> L50
        if (r7 == null) goto L27;
        if (r7.isEmpty() == true) goto L27;
        Iterator r9 = r7.iterator();     // Catch: Throwable -> L50
    L19:
        if (r9.hasNext() == false) goto L27;
        CombinCharacterInfo r11 = (CombinCharacterInfo) r9.next();     // Catch: Throwable -> L50
        if (r11 == null) goto L23;
        String r12 = r11.getChName();     // Catch: Throwable -> L50
    L25:
        if (Intrinsics.areEqual(r12, r8) == false) goto L19;
        r6 = true;
        goto L27
    L23:
        r12 = null;
    L27:
        if (r6 == false) goto L9;
        r2.add(r4);     // Catch: Throwable -> L50
        goto L9
    L29:
        Iterator r13 = r2.iterator();     // Catch: Throwable -> L50
    L31:
        if (r13.hasNext() == false) goto L44;
        CombineInfo r14 = (CombineInfo) r13.next();     // Catch: Throwable -> L50
        if (r14 == null) goto L31;
        CopyOnWriteArrayList r15 = r14.getFaList();     // Catch: Throwable -> L50
        if (r15 == null) goto L31;
        Iterator r16 = r15.iterator();     // Catch: Throwable -> L50
    L38:
        if (r16.hasNext() == false) goto L31;
        CombbineFactorInfo r17 = (CombbineFactorInfo) r16.next();     // Catch: Throwable -> L50
        if (r17 == null) goto L38;
        String r18 = r17.getFaName();     // Catch: Throwable -> L50
        if (r18 == null) goto L38;
        r0.add(r18);     // Catch: Throwable -> L50
    L44:
        this.factorsCacheMapByChName.put(r8, CollectionsKt.distinct(r0));     // Catch: Throwable -> L50
    L45:
        List<String> r19 = this.factorsCacheMapByChName.get(r8);     // Catch: Throwable -> L50
        if (r19 != null) goto L48;
        r19 = new ArrayList();     // Catch: Throwable -> L50
    L48:
        monitor-exit(this);
        return r19;
    L50:
        th = move-exception;
        throw th;
    }

    public final synchronized HashSet<String> getFactorsByChNameV3(String r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r7, "chName");     // Catch: Throwable -> L42
        HashSet<String> r0 = this.factorsCacheMapByChNameV3.get(r7);     // Catch: Throwable -> L42
        if (r0 != null) goto L40;
        HashSet<String> r1 = new HashSet();     // Catch: Throwable -> L42
        CopyOnWriteArrayList<CombineInfo> r2 = this.combineStrategys;     // Catch: Throwable -> L42
        if (r2 == null) goto L37;
        Iterator<CombineInfo> r3 = r2.iterator();     // Catch: Throwable -> L42
    L9:
        if (r3.hasNext() == false) goto L37;
        CombineInfo r4 = r3.next();     // Catch: Throwable -> L42
        if (r4 == null) goto L13;
        CopyOnWriteArrayList r5 = r4.getChList();     // Catch: Throwable -> L42
    L14:
        if (r5 == null) goto L9;
        Iterator r6 = r5.iterator();     // Catch: Throwable -> L42
    L17:
        if (r6.hasNext() == false) goto L25;
        CombinCharacterInfo r8 = (CombinCharacterInfo) r6.next();     // Catch: Throwable -> L42
        if (r8 == null) goto L21;
        String r9 = r8.getChName();     // Catch: Throwable -> L42
    L23:
        if (Intrinsics.areEqual(r9, r7) == false) goto L17;
        boolean r11 = true;
    L26:
        if (r11 == false) goto L9;
        CopyOnWriteArrayList r12 = r4.getFaList();     // Catch: Throwable -> L42
        if (r12 == null) goto L9;
        Iterator r13 = r12.iterator();     // Catch: Throwable -> L42
    L31:
        if (r13.hasNext() == false) goto L9;
        CombbineFactorInfo r14 = (CombbineFactorInfo) r13.next();     // Catch: Throwable -> L42
        if (r14 == null) goto L31;
        String r15 = r14.getFaName();     // Catch: Throwable -> L42
        if (r15 == null) goto L31;
        r1.add(r15);     // Catch: Throwable -> L42
        goto L31
    L21:
        r9 = null;
        goto L23
    L25:
        r11 = false;
        goto L26
    L13:
        r5 = null;
    L37:
        this.factorsCacheMapByChNameV3.put(r7, r1);     // Catch: Throwable -> L42
        monitor-exit(this);
        return r1;
    L40:
        monitor-exit(this);
        return r0;
    L42:
        th = move-exception;
        throw th;
    }

    public final void setFactorsCacheMapByChName(Map<String, List<String>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.factorsCacheMapByChName = r2;
    }

    public final void setFactorsCacheMapByChNameV3(Map<String, HashSet<String>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.factorsCacheMapByChNameV3 = r2;
    }

    public Strategy(String r1, String r2, CopyOnWriteArrayList<CombineInfo> r3, ConcurrentHashMap<String, CopyOnWriteArrayList<CombineInfo>> r4) {
        this.id = r1;
        this.strategyHash = r2;
        this.combineStrategys = r3;
        this.abInfos = r4;
        this.factorsCacheMapByChName = new LinkedHashMap();
        this.factorsCacheMapByChNameV3 = new LinkedHashMap();
    }

    public /* synthetic */ Strategy(String r1, String r2, CopyOnWriteArrayList r3, ConcurrentHashMap r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = "";
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = "-1";
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = new CopyOnWriteArrayList();
    L12:
        if ((r5 & 8) == 0) goto L14;
        r4 = new ConcurrentHashMap();
    L14:
        this(r1, r2, r3, r4);
    }
}
