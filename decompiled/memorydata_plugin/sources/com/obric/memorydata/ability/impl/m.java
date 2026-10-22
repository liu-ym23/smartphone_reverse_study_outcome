package com.obric.memorydata.ability.impl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u001c\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0002J\b\u0010\u001b\u001a\u00020\u0012H\u0002J\u0018\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010\"\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/memorydata/ability/impl/NetworkStatusAbility;", "Lcom/obric/memorydata/ability/impl/IMetaAbility;", "Landroid/net/ConnectivityManager$NetworkCallback;", "<init>", "()V", "abilityContext", "Lcom/obric/memorydata/ability/IAbilityContext;", "connectivityManager", "Landroid/net/ConnectivityManager;", "subscriberCount", "", "isRegisterNetworkCallback", "", "lastNetworkStatus", "Lkotlin/Pair;", "transportTypeList", "", "onCreate", "", "iAbilityContext", "onDestroy", "getNetworkStatus", "network", "Landroid/net/Network;", "onAvailable", "onLost", "registerNetworkCallback", "unregisterNetworkCallback", "onSubscribe", "key", "", TrackerImpl.PARAMS, "Lcom/obric/memorydata/ability/AbilityParams;", "onUnsubscribe", "onQuery", "Companion", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m extends ConnectivityManager.NetworkCallback implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8400a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.memorydata.ability.j f8401b;
    private ConnectivityManager c;
    private int d;
    private boolean e;
    private Pair<Integer, Integer> f;
    private final List<Integer> g;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/ability/impl/NetworkStatusAbility$Companion;", "", "<init>", "()V", "TAG", "", "AVAILABLE_EVENT_TYPE", "", "LOST_EVENT_TYPE", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8400a = new a(null);
    }

    public m() {
        this.g = CollectionsKt.listOf(new Integer[]{0, 1, 2, 3, 4, 5, 6, 8});
    }

    private final Pair<Integer, Integer> a(Network r15) {
        ConnectivityManager r0 = this.c;
        int r1 = 0;
        if (r0 == null) goto L33;
        NetworkCapabilities r16 = r0.getNetworkCapabilities(r15);
        RunLog.INSTANCE.debug("NetworkStatusAbility", "networkCapabilities " + r16);
        if (r16 == null) goto L16;
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r5 = 0;
        int r6 = 0;
    L8:
        if (r4.hasNext() == false) goto L17;
        Object r7 = r4.next();
        int r8 = r5 + 1;
        if (r5 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        if (r16.hasTransport(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).intValue()) == false) goto L15;
        r6 = r6 | (1 << r5);
    L15:
        r5 = r8;
    L17:
        Network[] r17 = r0.getAllNetworks();
        Intrinsics.checkNotNull(r17);
        int r9 = r17.length;
        int r10 = 0;
        int r11 = 0;
    L18:
        if (r10 >= r9) goto L32;
        NetworkCapabilities r12 = r0.getNetworkCapabilities(r17[r10]);
        if (r12 == null) goto L31;
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r14 = 0;
    L23:
        if (r13.hasNext() == false) goto L31;
        Object r18 = r13.next();
        int r19 = r14 + 1;
        if (r14 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        if (r12.hasTransport(((Number) ZeusTransformUtils.preCheckCast(r18, Number.class, "com.obric.memorydata.plugin")).intValue()) == false) goto L30;
        r11 = r11 | (1 << r14);
    L30:
        r14 = r19;
    L31:
        r10 = r10 + 1;
        goto L18
    L32:
        r1 = r11;
    L35:
        return new Pair(Integer.valueOf(r1), Integer.valueOf(r6));
    L16:
        r6 = 0;
        goto L17
    L33:
        r6 = 0;
        goto L35
    }

    private final void b() {
        if (this.e == false) goto L5;
        return;
    L5:
        ConnectivityManager r0 = this.c;
        if (r0 == null) goto L8;
        this.e = true;
        r0.registerDefaultNetworkCallback((ConnectivityManager.NetworkCallback) ZeusTransformUtils.preCheckCast(this, ConnectivityManager.NetworkCallback.class, "com.obric.memorydata.plugin"));
        return;
    L8:
        m r6 = (m) ZeusTransformUtils.preCheckCast(this, m.class, "com.obric.memorydata.plugin");
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "NetworkStatusAbility", "connectivityManager is null.", null, 4, null);
    }

    private final void c() {
        if (this.e == true) goto L5;
        return;
    L5:
        ConnectivityManager r0 = this.c;
        if (r0 == null) goto L8;
        this.e = false;
        r0.unregisterNetworkCallback((ConnectivityManager.NetworkCallback) ZeusTransformUtils.preCheckCast(this, ConnectivityManager.NetworkCallback.class, "com.obric.memorydata.plugin"));
        return;
    L8:
        m r6 = (m) ZeusTransformUtils.preCheckCast(this, m.class, "com.obric.memorydata.plugin");
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "NetworkStatusAbility", "connectivityManager is null.", null, 4, null);
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a() {
        this.c = null;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a(com.obric.memorydata.ability.j r3) {
        com.obric.memorydata.ability.j r4 = (com.obric.memorydata.ability.j) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.ability.j.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "iAbilityContext");
        this.f8401b = r4;
        Object r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity");
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.c = (ConnectivityManager) ZeusTransformUtils.preCheckCast(r5, ConnectivityManager.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(com.obric.memorydata.ability.f r1) {
        return i.a.a(this, r1);
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(String r2, com.obric.memorydata.ability.f r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        int r4 = this.d + 1;
        this.d = r4;
        if (r4 != 1) goto L5;
        b();
    L5:
        return true;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean b(String r2, com.obric.memorydata.ability.f r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        int r4 = this.d - 1;
        this.d = r4;
        if (r4 != 0) goto L7;
        c();
        return true;
    L7:
        return true;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean c(String r6, com.obric.memorydata.ability.f r7) {
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r7, TrackerImpl.PARAMS);
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L6;
        RunLog.INSTANCE.debug("NetworkStatusAbility", "onQuery before user agree privacy");
        return false;
    L6:
        Pair<Integer, Integer> r8 = this.f;
        com.obric.memorydata.ability.j r1 = null;
        if (r8 != null) goto L14;
        ConnectivityManager r2 = this.c;
        if (r2 == null) goto L11;
        Network r3 = r2.getActiveNetwork();
    L12:
        if (r3 == null) goto L14;
        r8 = a(r3);
        goto L14
    L11:
        r3 = null;
    L14:
        com.obric.memorydata.ability.j r5 = this.f8401b;
        if (r8 == null) goto L20;
        if (r5 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("abilityContext");
    L19:
        com.obric.memorydata.ability.data.m r9 = new com.obric.memorydata.ability.data.m(0, ((Number) ZeusTransformUtils.preCheckCast(r8.getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r8.getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue());
    L24:
        r1.a(r6, (com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
        return true;
    L18:
        r1 = r5;
        goto L19
    L20:
        if (r5 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("abilityContext");
    L23:
        r9 = new com.obric.memorydata.ability.data.m(0, 0, 0);
        goto L24
    L22:
        r1 = r5;
        goto L23
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network r6) {
        Intrinsics.checkNotNullParameter(r6, "network");
        super.onAvailable(r6);
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L6;
        RunLog.INSTANCE.debug("NetworkStatusAbility", "onAvailable before user agree privacy, ignore network callback");
        return;
    L6:
        Pair<Integer, Integer> r0 = a(r6);
        RunLog.INSTANCE.debug("NetworkStatusAbility", "NetworkCallback onAvailable " + r6 + " called networkStatus " + r0);
        this.f = r0;
        com.obric.memorydata.ability.j r5 = this.f8401b;
        if (r5 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("abilityContext");
        r5 = null;
    L9:
        r5.a((com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.ability.data.m(0, ((Number) ZeusTransformUtils.preCheckCast(r0.getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r0.getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue()), com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network r6) {
        Intrinsics.checkNotNullParameter(r6, "network");
        super.onLost(r6);
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L6;
        RunLog.INSTANCE.debug("NetworkStatusAbility", "onLost before user agree privacy, ignore network callback");
        return;
    L6:
        Pair<Integer, Integer> r0 = a(r6);
        RunLog.INSTANCE.debug("NetworkStatusAbility", "NetworkCallback onLost " + r6 + " called networkStatus " + r0);
        this.f = r0;
        com.obric.memorydata.ability.j r5 = this.f8401b;
        if (r5 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("abilityContext");
        r5 = null;
    L9:
        r5.a((com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.ability.data.m(1, ((Number) ZeusTransformUtils.preCheckCast(r0.getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r0.getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue()), com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
    }
}
