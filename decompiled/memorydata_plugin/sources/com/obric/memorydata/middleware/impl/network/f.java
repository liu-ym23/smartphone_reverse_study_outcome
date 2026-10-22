package com.obric.memorydata.middleware.impl.network;

import android.security.obric.guard.ObricSecurityGuardStub;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0010\t\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0003/01B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u000eJ\u0016\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u000eJ\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001a\u001a\u00020\t2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u00172\u0006\u0010 \u001a\u00020\u0015¢\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0015J\u0010\u0010$\u001a\u0004\u0018\u00010\t2\u0006\u0010#\u001a\u00020\tJ\u000e\u0010%\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\tJ\u000e\u0010&\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0015J\u000e\u0010'\u001a\u00020(2\u0006\u0010\u001a\u001a\u00020\tJ\u0016\u0010)\u001a\u00020(2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u000eJ\u000e\u0010*\u001a\u00020(2\u0006\u0010\u001a\u001a\u00020\tJ\u0010\u0010+\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0015H\u0002J\u001c\u0010,\u001a\u00020(2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00190.H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00130\fX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0014\u001a \u0012\u0004\u0012\u00020\t\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/memorydata/middleware/impl/network/SseTaskBindingRegistry;", "", "maxCancelledTaskIds", "", "<init>", "(I)V", "lock", "cancelledTaskIds", "Ljava/util/LinkedHashSet;", "", "Lkotlin/collections/LinkedHashSet;", "activeInvocationsByTaskId", "", "", "", "timedOutInvocations", "", "Lkotlin/Pair;", "bindingByStreamId", "Lcom/obric/memorydata/middleware/impl/network/SseTaskBindingRegistry$StreamBinding;", "pendingCallsByTaskId", "Lcom/obric/memorydata/middleware/impl/network/SseTaskBindingRegistry$RegistrationToken;", "Lkotlin/Function0;", "", "beginInvocation", "", "taskId", "invocationId", "endInvocation", "registerPendingCallWithToken", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "unregisterPendingCall", "token", "(Lcom/obric/memorydata/middleware/impl/network/SseTaskBindingRegistry$RegistrationToken;)Lkotlin/Unit;", "bind", "streamId", "unbind", "isTaskCancelled", "isRegistrationCancelled", "cancelTask", "Lcom/obric/memorydata/middleware/impl/network/SseTaskBindingRegistry$CancellationTargets;", "timeoutInvocation", "timeoutTask", "isTimedOutLocked", "cancelMatchingLocked", "matches", "Lkotlin/Function1;", "RegistrationToken", "CancellationTargets", "StreamBinding", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f11772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f11773b;
    private final LinkedHashSet<String> c;
    private final Map<String, List<Long>> d;
    private final Set<Pair<String, Long>> e;
    private final Map<String, c> f;
    private final Map<String, Map<b, Function0<Unit>>> g;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0003¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0003HÆ\u0003J/\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/middleware/impl/network/SseTaskBindingRegistry$CancellationTargets;", "", "streamIds", "", "", "pendingCalls", "Lkotlin/Function0;", "", "<init>", "(Ljava/util/Set;Ljava/util/Set;)V", "getStreamIds", "()Ljava/util/Set;", "getPendingCalls", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set<String> f11774a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set<Function0<Unit>> f11775b;

        public a(Set<String> r3, Set<? extends Function0<Unit>> r4) {
            Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
            Set<Function0<Unit>> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "streamIds");
            Intrinsics.checkNotNullParameter(r6, "pendingCalls");
            this.f11774a = r5;
            this.f11775b = r6;
        }

        public final Set<String> a() {
            return this.f11774a;
        }

        public final Set<Function0<Unit>> b() {
            return this.f11775b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11774a, r6.f11774a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11775b, r6.f11775b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f11774a.hashCode() * 31) + this.f11775b.hashCode();
        }

        public String toString() {
            return "CancellationTargets(streamIds=" + this.f11774a + ", pendingCalls=" + this.f11775b + ')';
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/middleware/impl/network/SseTaskBindingRegistry$RegistrationToken;", "", "taskId", "", "invocationId", "", "<init>", "(Ljava/lang/String;Ljava/lang/Long;)V", "getTaskId", "()Ljava/lang/String;", "getInvocationId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "cancelled", "", "getCancelled$middleware_impl_obricRelease", "()Z", "setCancelled$middleware_impl_obricRelease", "(Z)V", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Long f11777b;
        private volatile boolean c;

        public b(String r2, Long r3) {
            Intrinsics.checkNotNullParameter(r2, "taskId");
            this.f11776a = r2;
            this.f11777b = r3;
        }

        public final String a() {
            return this.f11776a;
        }

        public final void a(boolean r1) {
            this.c = r1;
        }

        public final Long b() {
            return this.f11777b;
        }

        public final boolean c() {
            return this.c;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/middleware/impl/network/SseTaskBindingRegistry$StreamBinding;", "", "taskId", "", "invocationId", "", "<init>", "(Ljava/lang/String;Ljava/lang/Long;)V", "getTaskId", "()Ljava/lang/String;", "getInvocationId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Long;)Lcom/obric/memorydata/middleware/impl/network/SseTaskBindingRegistry$StreamBinding;", "equals", "", "other", "hashCode", "", "toString", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11778a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Long f11779b;

        public c(String r2, Long r3) {
            Intrinsics.checkNotNullParameter(r2, "taskId");
            this.f11778a = r2;
            this.f11779b = r3;
        }

        public final String a() {
            return this.f11778a;
        }

        public final Long b() {
            return this.f11779b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11778a, r6.f11778a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11779b, r6.f11779b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.f11778a.hashCode() * 31;
            Long r1 = this.f11779b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "StreamBinding(taskId=" + this.f11778a + ", invocationId=" + this.f11779b + ')';
        }
    }

    public f() {
        this(0, 1, null);
    }

    public f(int r4) {
        this.f11772a = r4;
        this.f11773b = new Object();
        this.c = new LinkedHashSet();
        this.d = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.e = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        this.f = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.g = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        if (r4 <= 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r3 = false;
        goto L6
    }

    public /* synthetic */ f(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 256;
    L5:
        this(r1);
    }

    private final a a(Function1<? super c, Boolean> r12) {
        Function1 r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin");
        Map<String, c> r0 = this.f;
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator<Map.Entry<String, c>> r1 = r0.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((Boolean) ZeusTransformUtils.preCheckCast(r13.invoke(r3.getValue()), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L4;
        r2.put(r3.getKey(), r3.getValue());
        goto L4
    L8:
        Set r4 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin")).keySet(), Iterable.class, "com.obric.memorydata.plugin"));
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        Map<String, c> r6 = this.f;
        Iterator r7 = r5.iterator();
    L10:
        if (r7.hasNext() == false) goto L12;
        r6.remove((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin"));
        goto L10
    L12:
        Set r8 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(this.g.values(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r9.hasNext() == false) goto L27;
        Map r10 = (Map) ZeusTransformUtils.preCheckCast(r9.next(), Map.class, "com.obric.memorydata.plugin");
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10.keySet(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r11.iterator();
    L17:
        if (r15.hasNext() == false) goto L21;
        Object r16 = r15.next();
        b r17 = (b) ZeusTransformUtils.preCheckCast(r16, b.class, "com.obric.memorydata.plugin");
        if (((Boolean) ZeusTransformUtils.preCheckCast(r13.invoke(new c(r17.a(), r17.b())), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L17;
        r14.add(r16);
        goto L17
    L21:
        Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L23:
        if (r18.hasNext() == false) goto L14;
        b r19 = (b) ZeusTransformUtils.preCheckCast(r18.next(), b.class, "com.obric.memorydata.plugin");
        r19.a(true);
        Function0 r20 = (Function0) ZeusTransformUtils.preCheckCast(r10.remove(r19), Function0.class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L23;
        r8.add(r20);
        goto L23
    L27:
        Set<Map.Entry<String, Map<b, Function0<Unit>>>> r110 = this.g.entrySet();
        final $$Lambda$f$5dKVp0hAq3S_42zO3jV7mNeTmQ r111 = $$Lambda$f$5dKVp0hAq3S_42zO3jV7mNeTmQ.INSTANCE;
        r110.removeIf(new $$Lambda$f$5g2rsdHesMDAnLzLUkOyqZVCfUQ(r111));
        return new a(r4, r8);
    }

    private static final boolean a(String r2, long r3, c r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        if (Intrinsics.areEqual(r5.a(), r2) == false) goto L10;
        Long r4 = r5.b();
        if (r4 == null) goto L10;
        if (r4.longValue() != r3) goto L10;
        return true;
    L10:
        return false;
    }

    private static final boolean a(String r1, c r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return Intrinsics.areEqual(r2.a(), r1);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "it");
        return ((Map) ZeusTransformUtils.preCheckCast(r3.getValue(), Map.class, "com.obric.memorydata.plugin")).isEmpty();
    }

    private static final boolean a(Function1 r2, Object r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private static final boolean b(String r1, c r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return Intrinsics.areEqual(r2.a(), r1);
    }

    private final boolean c(b r2) {
        if (r2.b() != null) goto L5;
    L7:
        return false;
    L5:
        if (this.e.contains(TuplesKt.to(r2.a(), r2.b())) == false) goto L7;
        return true;
    }

    /* JADX INFO: renamed from: lambda$5dKVp0hAq3S_42zO3-jV7mNeTmQ, reason: not valid java name */
    public static /* synthetic */ boolean m1026lambda$5dKVp0hAq3S_42zO3jV7mNeTmQ(Map.Entry r0) {
        return a(r0);
    }

    public static /* synthetic */ boolean lambda$5g2rsdHesMDAnLzLUkOyqZVCfUQ(Function1 r0, Object r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$QOKYgUez6Dr1UVKh-05fFz1_ros, reason: not valid java name */
    public static /* synthetic */ boolean m1027lambda$QOKYgUez6Dr1UVKh05fFz1_ros(String r0, c r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$eq-Hwp_CNMdDmwpGvrbSL_ElkgQ, reason: not valid java name */
    public static /* synthetic */ boolean m1028lambda$eqHwp_CNMdDmwpGvrbSL_ElkgQ(String r0, long r1, c r3) {
        return a(r0, r1, r3);
    }

    public static /* synthetic */ boolean lambda$irk6VoSfDds4XXWRucv0yKpYSuc(String r0, c r1) {
        return b(r0, r1);
    }

    public final b a(String r6, Function0<Unit> r7) {
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "taskId");
        Intrinsics.checkNotNullParameter(r8, ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL);
        Object r0 = this.f11773b;
        monitor-enter(r0);
    L24:
        th = move-exception;
        throw th;
    L6:
        if (this.c.contains(r6) == false) goto L9;
        monitor-exit(r0);
        return null;
    L9:
        List r1 = (List) ZeusTransformUtils.preCheckCast(this.d.get(r6), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (r1 == null) goto L12;
        Long r2 = (Long) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(r1), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
    L13:
        if (r2 != null) goto L15;
    L18:
        b r3 = new b(r6, r2);     // Catch: Throwable -> L24
        Map<String, Map<b, Function0<Unit>>> r5 = this.g;     // Catch: Throwable -> L24
        Map<b, Function0<Unit>> r4 = r5.get(r6);     // Catch: Throwable -> L24
        if (r4 != null) goto L21;
        r4 = new LinkedHashMap();     // Catch: Throwable -> L24
        r5.put(r6, r4);     // Catch: Throwable -> L24
    L21:
        ((Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.memorydata.plugin")).put(r3, r8);     // Catch: Throwable -> L24
        monitor-exit(r0);
        return r3;
    L15:
        if (this.e.contains(TuplesKt.to(r6, r2)) == false) goto L18;
        monitor-exit(r0);
        return null;
    L12:
        r2 = null;
        goto L13
    }

    public final String a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "streamId");
        Object r0 = this.f11773b;
        monitor-enter(r0);
        c r2 = (c) ZeusTransformUtils.preCheckCast(this.f.remove(r3), c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r2 == null) goto L8;
        String r4 = r2.a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);
        return r4;
    L8:
        r4 = null;
    L11:
        th = move-exception;
        throw th;
    }

    public final Unit a(b r5) {
        Intrinsics.checkNotNullParameter(r5, "token");
        Object r0 = this.f11773b;
        monitor-enter(r0);
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(this.g.get(r5.a()), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r1 == null) goto L11;
        r1.remove(r5);     // Catch: Throwable -> L14
        if (r1.isEmpty() == false) goto L9;
        this.g.remove(r5.a());     // Catch: Throwable -> L14
    L9:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);
        return r4;
    L11:
        r4 = null;
    L14:
        th = move-exception;
        throw th;
    }

    public final boolean a(String r5, long r6) {
        Intrinsics.checkNotNullParameter(r5, "taskId");
        Object r0 = this.f11773b;
        monitor-enter(r0);
        Map<String, List<Long>> r4 = this.d;     // Catch: Throwable -> L10
        List<Long> r1 = r4.get(r5);     // Catch: Throwable -> L10
        if (r1 != null) goto L7;
        r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        r4.put(r5, r1);     // Catch: Throwable -> L10
    L7:
        boolean r7 = ((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin")).add(Long.valueOf(r6));     // Catch: Throwable -> L10
        monitor-exit(r0);
        return r7;
    L10:
        th = move-exception;
        throw th;
    }

    public final boolean a(String r6, b r7) {
        Intrinsics.checkNotNullParameter(r6, "streamId");
        Intrinsics.checkNotNullParameter(r7, "token");
        Object r0 = this.f11773b;
        monitor-enter(r0);
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(this.g.get(r7.a()), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        if (r1 != null) goto L10;
        monitor-exit(r0);
        return false;
    L10:
        if (r7.c() == false) goto L12;
    L25:
        monitor-exit(r0);
        return false;
    L12:
        if (this.c.contains(r7.a()) == true) goto L25;
        if (c(r7) == true) goto L25;
        if (r1.remove(r7) == null) goto L25;
        if (r1.isEmpty() == false) goto L21;
        this.g.remove(r7.a());     // Catch: Throwable -> L27
    L21:
        this.f.put(r6, new c(r7.a(), r7.b()));     // Catch: Throwable -> L27
        monitor-exit(r0);
        return true;
    L27:
        th = move-exception;
        throw th;
    }

    public final boolean b(b r2) {
        Intrinsics.checkNotNullParameter(r2, "token");
        if (r2.c() == true) goto L14;
        Object r0 = this.f11773b;
        monitor-enter(r0);
        boolean r1 = c(r2);     // Catch: Throwable -> L11
        monitor-exit(r0);
        if (r1 == true) goto L14;
        return false;
    L11:
        th = move-exception;
        throw th;
    L14:
        return true;
    }

    public final boolean b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Object r0 = this.f11773b;
        monitor-enter(r0);
        boolean r1 = this.c.contains(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean b(String r5, long r6) {
        Intrinsics.checkNotNullParameter(r5, "taskId");
        Object r0 = this.f11773b;
        monitor-enter(r0);
        List r1 = (List) ZeusTransformUtils.preCheckCast(this.d.get(r5), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        r1.remove(Long.valueOf(r6));     // Catch: Throwable -> L12
        if (r1.isEmpty() == false) goto L9;
        this.d.remove(r5);     // Catch: Throwable -> L12
    L9:
        boolean r4 = this.e.remove(TuplesKt.to(r5, Long.valueOf(r6)));     // Catch: Throwable -> L12
        monitor-exit(r0);
        return r4;
    L12:
        th = move-exception;
        throw th;
    }

    public final a c(final String r4) {
        Intrinsics.checkNotNullParameter(r4, "taskId");
        Object r0 = this.f11773b;
        monitor-enter(r0);
        this.c.remove(r4);     // Catch: Throwable -> L11
        this.c.add(r4);     // Catch: Throwable -> L11
    L6:
        if (this.c.size() <= this.f11772a) goto L8;
        Iterator<String> r1 = this.c.iterator();     // Catch: Throwable -> L11
        Intrinsics.checkNotNullExpressionValue(r1, "iterator(...)");     // Catch: Throwable -> L11
        r1.next();     // Catch: Throwable -> L11
        r1.remove();     // Catch: Throwable -> L11
        goto L6
    L8:
        a r3 = a(new $$Lambda$f$QOKYgUez6Dr1UVKh05fFz1_ros(r4));     // Catch: Throwable -> L11
        monitor-exit(r0);
        return r3;
    L11:
        th = move-exception;
        throw th;
    }

    public final a c(final String r6, final long r7) {
        Intrinsics.checkNotNullParameter(r6, "taskId");
        Object r0 = this.f11773b;
        monitor-enter(r0);
        List r1 = (List) ZeusTransformUtils.preCheckCast(this.d.get(r6), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        boolean r2 = true;
        if (r1 != null) goto L7;
    L9:
        r2 = false;
    L10:
        if (r2 == false) goto L12;
        this.e.add(TuplesKt.to(r6, Long.valueOf(r7)));     // Catch: Throwable -> L15
    L12:
        a r5 = a(new $$Lambda$f$eqHwp_CNMdDmwpGvrbSL_ElkgQ(r6, r7));     // Catch: Throwable -> L15
        monitor-exit(r0);
        return r5;
    L7:
        if (r1.contains(Long.valueOf(r7)) != true) goto L9;
    L15:
        th = move-exception;
        throw th;
    }

    public final a d(final String r6) {
        Intrinsics.checkNotNullParameter(r6, "taskId");
        Object r0 = this.f11773b;
        monitor-enter(r0);
        List r1 = (List) ZeusTransformUtils.preCheckCast(this.d.get(r6), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r1 != null) goto L7;
        r1 = CollectionsKt.emptyList();     // Catch: Throwable -> L14
    L7:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L14
    L9:
        if (r2.hasNext() == false) goto L11;
        long r3 = ((Number) ZeusTransformUtils.preCheckCast(r2.next(), Number.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L14
        this.e.add(TuplesKt.to(r6, Long.valueOf(r3)));     // Catch: Throwable -> L14
        goto L9
    L11:
        a r5 = a(new $$Lambda$f$irk6VoSfDds4XXWRucv0yKpYSuc(r6));     // Catch: Throwable -> L14
        monitor-exit(r0);
        return r5;
    L14:
        th = move-exception;
        throw th;
    }
}
