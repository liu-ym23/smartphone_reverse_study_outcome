package com.obric.memorydata.awareness.impl.producer;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\b&\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0004J \u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J \u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J2\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000bH\u0016J2\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000bH\u0002J0\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000b2\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000bH\u0002J8\u0010\u001f\u001a\u00020 2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000b2\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000bH\u0002J\u001c\u0010#\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010$\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\u001e\u0010%\u001a\u00020\u00162\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060'2\u0006\u0010(\u001a\u00020 H\u0016R \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR(\u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eX¤\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eX¤\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010¨\u0006*"}, d2 = {"Lcom/obric/memorydata/awareness/impl/producer/AbstractFeatureProducer;", "Lcom/obric/memorydata/awareness/api/IFeatureProducer;", "<init>", "()V", "featureCached", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "getFeatureCached", "()Ljava/util/concurrent/ConcurrentHashMap;", "featureExtraCached", "", "featureLocks", "features", "", "getFeatures", "()Ljava/util/Set;", "needCacheFeatures", "getNeedCacheFeatures", "getFeature", "featureName", "restoreFeature", "", EventBody.KEY_VALUE, "getFeatureExtra", "getFeatureValueAndExtra", "setFeature", WsConstants.KEY_EXTRA, "setFeatureLocked", "sanitizeFeatureExtras", "extras", "deepEqualsMap", "", "a", "b", "deepEqualsAny", "hasDefineFeature", "collectFeatures", "featureNames", "", "collect", "Companion", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class a implements com.obric.memorydata.awareness.api.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0446a f8743a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, Object> f8744b;
    private final ConcurrentHashMap<String, Map<String, Object>> c;
    private final ConcurrentHashMap<String, Object> d;

    /* JADX INFO: renamed from: com.obric.memorydata.awareness.impl.producer.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/awareness/impl/producer/AbstractFeatureProducer$Companion;", "", "<init>", "()V", "FEATURE_VALUE", "", "FEATURE_EXTRAS", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0446a {
        private C0446a() {
        }

        public /* synthetic */ C0446a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8743a = new C0446a(null);
    }

    public a() {
        this.f8744b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
    }

    private static final Object a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return new Object();
    }

    private static final Object a(Function1 r2, Object r3) {
        return ((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3);
    }

    private final Map<String, Object> a(Map<String, ? extends Object> r6) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L19;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r7 = r5.entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L10;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if ((!Intrinsics.areEqual((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), "feature_event_mode")) == false) goto L6;
        r1.put(r2.getKey(), r2.getValue());
        goto L6
    L10:
        Map<String, Object> r8 = (Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.memorydata.plugin");
        if ((!r8.isEmpty()) == true) goto L13;
        return null;
    L13:
        return r8;
    L19:
        return null;
    }

    private final void a(String r17, Object r18, Map<String, ? extends Object> r19) {
        Map<String, ? extends Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.memorydata.plugin");
        boolean r6 = com.obric.memorydata.awareness.impl.a.d.f8622a.a(r17);
        Object r2 = this.f8744b.get(r17);
        Map<String, ? extends Object> r7 = (Map) ZeusTransformUtils.preCheckCast(this.c.get(r17), Map.class, "com.obric.memorydata.plugin");
        Map<String, ? extends Object> r8 = a(r5);
        if (a(r2, r18) == false) goto L7;
        if (a(r7, r8) == false) goto L7;
        return;
    L7:
        if (com.obric.memorydata.awareness.impl.b.f8632a.a().contains(r17) == false) goto L9;
        IRunLog r10 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r9 = new StringBuilder().append("setFeature name: ").append(r17);
    L10:
        IRunLog.a.a(r10, "Awareness", r9.toString(), false, 4, null);
        ConcurrentHashMap<String, Object> r11 = this.f8744b;
        if (r18 != null) goto L13;
        r11.remove(r17);
    L14:
        ConcurrentHashMap<String, Map<String, Object>> r0 = this.c;
        if (r8 != null) goto L17;
        r0.remove(r17);
    L18:
        AwarenessManager.INSTANCE.onFeatureChanged(r17, r2, r18, r5);
        com.obric.memorydata.awareness.impl.b.a.f8634a.a(r17, r2, r18, r8);
        com.obric.memorydata.awareness.impl.a.d.f8622a.a(r17, r2, r18, r5, r6);
        return;
    L17:
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).put(r17, r8);
        goto L18
    L13:
        ((Map) ZeusTransformUtils.preCheckCast(r11, Map.class, "com.obric.memorydata.plugin")).put(r17, r18);
        goto L14
    L9:
        r10 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r9 = new StringBuilder().append("setFeature name: ").append(r17).append(" value: ").append(r18).append(" extra: ").append(r5);
        goto L10
    }

    private final boolean a(Object r13, Object r14) {
        if (r13 != r14) goto L6;
        return true;
    L6:
        if (r13 == null) goto L137;
        if (r14 == null) goto L137;
        if (ZeusTransformUtils.instanceOf(r13, JSONObject.class) == false) goto L27;
        if (ZeusTransformUtils.instanceOf(r14, JSONObject.class) == false) goto L27;
        if (((JSONObject) ZeusTransformUtils.preCheckCast(r13, JSONObject.class, "com.obric.memorydata.plugin")).length() == ((JSONObject) ZeusTransformUtils.preCheckCast(r14, JSONObject.class, "com.obric.memorydata.plugin")).length()) goto L16;
        return false;
    L16:
        Iterator<String> r0 = ((JSONObject) ZeusTransformUtils.preCheckCast(r13, JSONObject.class, "com.obric.memorydata.plugin")).keys();
    L18:
        if (r0.hasNext() == false) goto L25;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        if (((JSONObject) ZeusTransformUtils.preCheckCast(r14, JSONObject.class, "com.obric.memorydata.plugin")).has(r1) == false) goto L21;
        if (a(((JSONObject) ZeusTransformUtils.preCheckCast(r13, JSONObject.class, "com.obric.memorydata.plugin")).opt(r1), ((JSONObject) ZeusTransformUtils.preCheckCast(r14, JSONObject.class, "com.obric.memorydata.plugin")).opt(r1)) == true) goto L18;
        return false;
    L21:
        return false;
    L25:
        return true;
    L27:
        if (ZeusTransformUtils.instanceOf(r13, JSONArray.class) == false) goto L41;
        if (ZeusTransformUtils.instanceOf(r14, JSONArray.class) == false) goto L41;
        if (((JSONArray) ZeusTransformUtils.preCheckCast(r13, JSONArray.class, "com.obric.memorydata.plugin")).length() == ((JSONArray) ZeusTransformUtils.preCheckCast(r14, JSONArray.class, "com.obric.memorydata.plugin")).length()) goto L33;
        return false;
    L33:
        int r2 = ((JSONArray) ZeusTransformUtils.preCheckCast(r13, JSONArray.class, "com.obric.memorydata.plugin")).length();
        int r3 = 0;
    L34:
        if (r3 >= r2) goto L39;
        if (a(((JSONArray) ZeusTransformUtils.preCheckCast(r13, JSONArray.class, "com.obric.memorydata.plugin")).opt(r3), ((JSONArray) ZeusTransformUtils.preCheckCast(r14, JSONArray.class, "com.obric.memorydata.plugin")).opt(r3)) == false) goto L37;
        r3 = r3 + 1;
        goto L34
    L37:
        return false;
    L39:
        return true;
    L41:
        if (ZeusTransformUtils.instanceOf(r13, Map.class) == false) goto L47;
        if (ZeusTransformUtils.instanceOf(r14, Map.class) == false) goto L47;
        return a((Map) ZeusTransformUtils.preCheckCast(r13, Map.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.preCheckCast(r14, Map.class, "com.obric.memorydata.plugin"));
    L47:
        if (ZeusTransformUtils.instanceOf(r13, List.class) == false) goto L61;
        if (ZeusTransformUtils.instanceOf(r14, List.class) == false) goto L61;
        if (((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin")).size() == ((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin")).size()) goto L53;
        return false;
    L53:
        int r4 = ((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).size();
        int r5 = 0;
    L54:
        if (r5 >= r4) goto L59;
        if (a(((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin")).get(r5), ((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin")).get(r5)) == false) goto L57;
        r5 = r5 + 1;
        goto L54
    L57:
        return false;
    L59:
        return true;
    L61:
        if (ZeusTransformUtils.instanceOf(r13, Set.class) == false) goto L82;
        if (ZeusTransformUtils.instanceOf(r14, Set.class) == false) goto L82;
        if (((Set) ZeusTransformUtils.preCheckCast(r13, Set.class, "com.obric.memorydata.plugin")).size() == ((Set) ZeusTransformUtils.preCheckCast(r14, Set.class, "com.obric.memorydata.plugin")).size()) goto L67;
        return false;
    L67:
        List r15 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin"));
        Iterator r16 = ((Set) ZeusTransformUtils.preCheckCast(r13, Set.class, "com.obric.memorydata.plugin")).iterator();
    L69:
        if (r16.hasNext() == false) goto L80;
        Object r6 = r16.next();
        int r7 = ((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).size();
        int r8 = 0;
    L71:
        if (r8 >= r7) goto L76;
        if (a(r6, r15.get(r8)) == true) goto L74;
        r8 = r8 + 1;
        goto L71
    L74:
        r15.remove(r8);
        boolean r9 = true;
    L77:
        if (r9 == true) goto L69;
        return false;
    L76:
        r9 = false;
        goto L77
    L80:
        return r15.isEmpty();
    L82:
        if ((r13 instanceof Object[]) == false) goto L88;
        if ((r14 instanceof Object[]) == false) goto L88;
        return ArraysKt.contentDeepEquals((Object[]) ZeusTransformUtils.preCheckCast(r13, Object[].class, "com.obric.memorydata.plugin"), (Object[]) ZeusTransformUtils.preCheckCast(r14, Object[].class, "com.obric.memorydata.plugin"));
    L88:
        if ((r13 instanceof int[]) == false) goto L94;
        if ((r14 instanceof int[]) == false) goto L94;
        return Arrays.equals((int[]) ZeusTransformUtils.preCheckCast(r13, int[].class, "com.obric.memorydata.plugin"), (int[]) ZeusTransformUtils.preCheckCast(r14, int[].class, "com.obric.memorydata.plugin"));
    L94:
        if ((r13 instanceof long[]) == false) goto L100;
        if ((r14 instanceof long[]) == false) goto L100;
        return Arrays.equals((long[]) ZeusTransformUtils.preCheckCast(r13, long[].class, "com.obric.memorydata.plugin"), (long[]) ZeusTransformUtils.preCheckCast(r14, long[].class, "com.obric.memorydata.plugin"));
    L100:
        if ((r13 instanceof short[]) == false) goto L106;
        if ((r14 instanceof short[]) == false) goto L106;
        return Arrays.equals((short[]) ZeusTransformUtils.preCheckCast(r13, short[].class, "com.obric.memorydata.plugin"), (short[]) ZeusTransformUtils.preCheckCast(r14, short[].class, "com.obric.memorydata.plugin"));
    L106:
        if ((r13 instanceof byte[]) == false) goto L112;
        if ((r14 instanceof byte[]) == false) goto L112;
        return Arrays.equals((byte[]) ZeusTransformUtils.preCheckCast(r13, byte[].class, "com.obric.memorydata.plugin"), (byte[]) ZeusTransformUtils.preCheckCast(r14, byte[].class, "com.obric.memorydata.plugin"));
    L112:
        if ((r13 instanceof char[]) == false) goto L118;
        if ((r14 instanceof char[]) == false) goto L118;
        return Arrays.equals((char[]) ZeusTransformUtils.preCheckCast(r13, char[].class, "com.obric.memorydata.plugin"), (char[]) ZeusTransformUtils.preCheckCast(r14, char[].class, "com.obric.memorydata.plugin"));
    L118:
        if ((r13 instanceof double[]) == false) goto L124;
        if ((r14 instanceof double[]) == false) goto L124;
        return Arrays.equals((double[]) ZeusTransformUtils.preCheckCast(r13, double[].class, "com.obric.memorydata.plugin"), (double[]) ZeusTransformUtils.preCheckCast(r14, double[].class, "com.obric.memorydata.plugin"));
    L124:
        if ((r13 instanceof float[]) == false) goto L130;
        if ((r14 instanceof float[]) == false) goto L130;
        return Arrays.equals((float[]) ZeusTransformUtils.preCheckCast(r13, float[].class, "com.obric.memorydata.plugin"), (float[]) ZeusTransformUtils.preCheckCast(r14, float[].class, "com.obric.memorydata.plugin"));
    L130:
        if ((r13 instanceof boolean[]) == false) goto L136;
        if ((r14 instanceof boolean[]) == false) goto L136;
        return Arrays.equals((boolean[]) ZeusTransformUtils.preCheckCast(r13, boolean[].class, "com.obric.memorydata.plugin"), (boolean[]) ZeusTransformUtils.preCheckCast(r14, boolean[].class, "com.obric.memorydata.plugin"));
    L136:
        return Intrinsics.areEqual(r13, r14);
    L137:
        return false;
    }

    private final boolean a(Map<String, ? extends Object> r7, Map<String, ? extends Object> r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        if (r9 != r10) goto L6;
        return true;
    L6:
        if (r9 == null) goto L22;
        if (r10 == null) goto L22;
        if (r9.size() == r10.size()) goto L12;
        return false;
    L12:
        Iterator r11 = r9.entrySet().iterator();
    L14:
        if (r11.hasNext() == false) goto L21;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin");
        Object r5 = r3.getValue();
        if (r10.containsKey(r4) == false) goto L17;
        if (a(r5, r10.get(r4)) == true) goto L14;
        return false;
    L17:
        return false;
    L21:
        return true;
    L22:
        return false;
    }

    private static final Object b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return new Object();
    }

    private static final Object b(Function1 r2, Object r3) {
        return ((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3);
    }

    public static /* synthetic */ Object lambda$8OcUObBe0m0HrMTPAbkCsZnaraE(Function1 r0, Object r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ Object lambda$E6HSP9YSgN6UjhF1q7mmGZAy1Fk(Function1 r0, Object r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Object lambda$dJ6e0B0liKobz661IyNH8Sd4hes(String r0) {
        return b(r0);
    }

    public static /* synthetic */ Object lambda$lfIwkhNB26naAKK_nlDUO6lDumQ(String r0) {
        return a(r0);
    }

    public final ConcurrentHashMap<String, Object> a() {
        return this.f8744b;
    }

    public final void a(String r4, Object r5) {
        Intrinsics.checkNotNullParameter(r4, "featureName");
        ConcurrentHashMap<String, Object> r0 = this.d;
        final $$Lambda$a$lfIwkhNB26naAKK_nlDUO6lDumQ r1 = $$Lambda$a$lfIwkhNB26naAKK_nlDUO6lDumQ.INSTANCE;
        Object r2 = r0.computeIfAbsent(r4, new $$Lambda$a$E6HSP9YSgN6UjhF1q7mmGZAy1Fk(r1));
        Intrinsics.checkNotNullExpressionValue(r2, "computeIfAbsent(...)");
        monitor-enter(r2);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (com.obric.memorydata.awareness.impl.a.d.f8622a.a(r4) == false) goto L8;
        monitor-exit(r2);
        return;
    L8:
        if (r5 != null) goto L10;
        this.f8744b.remove(r4);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r2);
        return;
    L10:
        ((Map) ZeusTransformUtils.preCheckCast(this.f8744b, Map.class, "com.obric.memorydata.plugin")).put(r4, r5);     // Catch: Throwable -> L13
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L13
        goto L11
    }

    public abstract Set<String> b();

    @Override // com.obric.memorydata.awareness.api.b
    public void collectFeatures(List<String> r1, boolean r2) {
        Intrinsics.checkNotNullParameter((List) ZeusTransformUtils.wrapperContextForParams(r1, List.class, "com.obric.memorydata.plugin"), "featureNames");
    }

    @Override // com.obric.memorydata.awareness.api.b
    public Object getFeature(String r2) {
        Intrinsics.checkNotNullParameter(r2, "featureName");
        return this.f8744b.get(r2);
    }

    @Override // com.obric.memorydata.awareness.api.b
    public Map<String, Object> getFeatureExtra(String r2) {
        Intrinsics.checkNotNullParameter(r2, "featureName");
        return (Map) ZeusTransformUtils.preCheckCast(this.c.get(r2), Map.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.awareness.api.b
    public Map<String, Object> getFeatureValueAndExtra(String r4) {
        Intrinsics.checkNotNullParameter(r4, "featureName");
        Object r0 = getFeature(r4);
        Map<String, Object> r3 = getFeatureExtra(r4);
        if (r0 != null) goto L6;
        if (r3 != null) goto L6;
        return null;
    L6:
        Map<String, Object> r5 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        r5.put("feature_value", r0);
        r5.put("feature_extras", r3);
        return r5;
    }

    @Override // com.obric.memorydata.awareness.api.b
    public boolean hasDefineFeature(String r2) {
        Intrinsics.checkNotNullParameter(r2, "featureName");
        return b().contains(r2);
    }

    @Override // com.obric.memorydata.awareness.api.b
    public void setFeature(String r4, Object r5, Map<String, ? extends Object> r6) {
        Map<String, ? extends Object> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "featureName");
        ConcurrentHashMap<String, Object> r0 = this.d;
        final $$Lambda$a$dJ6e0B0liKobz661IyNH8Sd4hes r1 = $$Lambda$a$dJ6e0B0liKobz661IyNH8Sd4hes.INSTANCE;
        Object r2 = r0.computeIfAbsent(r4, new $$Lambda$a$8OcUObBe0m0HrMTPAbkCsZnaraE(r1));
        Intrinsics.checkNotNullExpressionValue(r2, "computeIfAbsent(...)");
        monitor-enter(r2);
        a(r4, r5, r7);     // Catch: Throwable -> L7
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r2);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
