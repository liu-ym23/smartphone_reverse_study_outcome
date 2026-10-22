package com.obric.memorydata.awareness.impl.a;

import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006J\u001b\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0018H\u0000¢\u0006\u0002\b\u0019J\u000e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0006JB\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000e2\u0006\u0010\u001f\u001a\u00020\u000bJ\u0015\u0010 \u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0006H\u0000¢\u0006\u0002\b!J\u0017\u0010\"\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0000¢\u0006\u0002\b#J\u001d\u0010$\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u0006H\u0000¢\u0006\u0002\b&J(\u0010'\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000eH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000RP\u0010\b\u001aB\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000b0\u000b \n* \u0012\f\u0012\n \n*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/memorydata/awareness/impl/policy/FeatureEventPolicyRegistry;", "", "<init>", "()V", "builtInPolicies", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/memorydata/awareness/impl/policy/FeatureEventPolicy;", "alreadySetFeatures", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "packagePolicies", "", "Lcom/obric/memorydata/awareness/impl/policy/PackageFeatureEventPolicyRegistration;", "register", "", "feature", "policy", "unregister", "replacePackagePolicies", "Lcom/obric/memorydata/awareness/impl/policy/PackageFeatureEventPolicyReplacement;", "registrations", "", "replacePackagePolicies$awareness_obricRelease", "markFeatureSet", "evaluateIfNeeded", "oldValue", "newValue", "extras", "hasBaseline", "policyFor", "policyFor$awareness_obricRelease", "packageOwnerFor", "packageOwnerFor$awareness_obricRelease", "shouldEvaluate", "mode", "shouldEvaluate$awareness_obricRelease", "resolveMode", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f8622a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, b> f8623b = null;
    private static final ConcurrentHashMap.KeySetView<String, Boolean> c = null;
    private static volatile Map<String, f> d;

    static {
        f8622a = new d();
        f8623b = new ConcurrentHashMap();
        c = ConcurrentHashMap.newKeySet();
        d = MapsKt.emptyMap();
    }

    private d() {
    }

    private static final Comparable a(f r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (Comparable) ZeusTransformUtils.preCheckCast(r2.b(), Comparable.class, "com.obric.memorydata.plugin");
    }

    private final String a(String r8, Map<String, ? extends Object> r9) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        String r10 = null;
        if (r7 == null) goto L5;
        Object r11 = r7.get("feature_event_mode");
    L7:
        if (ZeusTransformUtils.instanceOf(r11, String.class) == false) goto L10;
        r10 = (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.memorydata.plugin");
    L10:
        if (r10 != null) goto L12;
        return "auto";
    L12:
        int r1 = r10.hashCode();
        if (r1 == (-227719526)) goto L26;
        if (r1 == 3005871) goto L23;
        if (r1 == 97618667) goto L20;
    L27:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "Awareness", "unknown feature event mode, feature=" + r8 + " mode=" + r10, null, 4, null);
        return "auto";
    L20:
        if (r10.equals("force") == false) goto L27;
        return r10;
    L23:
        if (r10.equals("auto") == false) goto L27;
        return r10;
    L26:
        if (r10.equals("state_only") == false) goto L27;
        return r10;
    L5:
        r11 = null;
        goto L7
    }

    private static final Comparable b(f r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (Comparable) ZeusTransformUtils.preCheckCast(r2.a(), Comparable.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$C0T0vVGMpR3NnIL-Xgk9GaBZfbs, reason: not valid java name */
    public static /* synthetic */ Comparable m507lambda$C0T0vVGMpR3NnILXgk9GaBZfbs(f r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$WtrhhCABWM-fHg4ImojhzZMzogY, reason: not valid java name */
    public static /* synthetic */ Comparable m508lambda$WtrhhCABWMfHg4ImojhzZMzogY(f r0) {
        return a(r0);
    }

    public final g a(Collection<f> r14) {
        Collection r13 = (Collection) ZeusTransformUtils.wrapperContextForParams(r14, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "registrations");
        Set<String> r15 = d.keySet();
        LinkedHashMap r1 = new LinkedHashMap();
        List r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r16.iterator();
    L3:
        boolean r5 = true;
        if (r17.hasNext() == false) goto L14;
        f r7 = (f) ZeusTransformUtils.preCheckCast(r17.next(), f.class, "com.obric.memorydata.plugin");
        String r8 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r7.a(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L9;
        r5 = false;
    L9:
        if (r5 == false) goto L11;
        f r4 = null;
    L12:
        if (r4 == null) goto L3;
        r3.add(r4);
        goto L3
    L11:
        r4 = f.a(r7, r8, null, null, 6, null);
        goto L12
    L14:
        Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), ComparisonsKt.compareBy(new Function1[]{$$Lambda$d$WtrhhCABWMfHg4ImojhzZMzogY.INSTANCE, $$Lambda$d$C0T0vVGMpR3NnILXgk9GaBZfbs.INSTANCE})), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r18.hasNext() == false) goto L20;
        f r6 = (f) ZeusTransformUtils.preCheckCast(r18.next(), f.class, "com.obric.memorydata.plugin");
        f r9 = (f) ZeusTransformUtils.preCheckCast(r1.putIfAbsent(r6.a(), r6), f.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L16;
        r2.add(new e(r6.a(), r9.b(), r6.b()));
        goto L16
    L20:
        d = MapsKt.toMap((Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.memorydata.plugin"));
        return new g(r15, r2);
    }

    public final void a(String r3, b r4) {
        b r2 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "feature");
        Intrinsics.checkNotNullParameter(r2, "policy");
        ((Map) ZeusTransformUtils.preCheckCast(f8623b, Map.class, "com.obric.memorydata.plugin")).put(r3, r2);
    }

    public final void a(String r3, Object r4, Object r5, Map<String, ? extends Object> r6, boolean r7) {
        Map<String, ? extends Object> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "feature");
        if (a(r7, a(r3, r8)) == true) goto L5;
        return;
    L5:
        b(r3).a(r3, r4, r5, r8);
    }

    public final boolean a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "feature");
        return !c.add(r1);
    }

    public final boolean a(boolean r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        if (Intrinsics.areEqual(r2, "state_only") == false) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r2, "force") == false) goto L10;
        return true;
    L10:
        return r1;
    }

    public final b b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "feature");
        f r2 = (f) ZeusTransformUtils.preCheckCast(d.get(r3), f.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        b r4 = r2.c();
        if (r4 == null) goto L6;
        return r4;
    L6:
        b r5 = (b) ZeusTransformUtils.preCheckCast(f8623b.get(r3), b.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L9;
        return r5;
    L9:
        return (b) ZeusTransformUtils.preCheckCast(h.f8630a, b.class, "com.obric.memorydata.plugin");
    }
}
