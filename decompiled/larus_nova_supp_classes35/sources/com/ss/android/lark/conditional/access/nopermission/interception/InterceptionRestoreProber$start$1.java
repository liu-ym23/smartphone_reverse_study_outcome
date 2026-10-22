package com.ss.android.lark.conditional.access.nopermission.interception;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Bundle;
import com.ss.android.lark.chameleon.api.PreloadConfig;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.conditional.access.nopermission.interception.InterceptionRestoreProber$start$1", f = "InterceptionRestoreProber.kt", i = {0, 1, 1, 1}, l = {92, 128}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "offlineStreak", "startedAt"}, s = {"L$0", "L$0", "I$0", "J$0"})
final class InterceptionRestoreProber$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ c $restored;
    int I$0;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;

    public InterceptionRestoreProber$start$1(c r1, Continuation<? super InterceptionRestoreProber$start$1> r2) {
        this.$restored = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        InterceptionRestoreProber$start$1 r0 = new InterceptionRestoreProber$start$1(this.$restored, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x0298 -> B:106:0x0299). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r26) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        long r8 = this.J$0;
        int r3 = this.I$0;
        CoroutineScope r10 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r26);
        InterceptionRestoreProber$start$1 r12 = this;
        int r11 = r3;
        Object r4 = r0;
    L14:
        boolean r1 = CoroutineScopeKt.isActive(r10);
        String r14 = BuildConfig.FLAVOR;
        if (r1 == true) goto L17;
    L107:
        String r22 = BuildConfig.FLAVOR;
    L108:
        b r5 = b.a;
        b.b = null;
        b.c = r22;
        return Unit.INSTANCE;
    L17:
        if ((System.currentTimeMillis() - r8) < PreloadConfig.DEFAULT_TIMEOUT) goto L110;
        ScsLogger.d("SecurityPolicy_InterceptionRestoreProber", "probe: max duration reached, abort (storage kept)");
        goto L107
    L110:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L24
        String r7 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d();     // Catch: Throwable -> L24
        if (r7 != null) goto L22;
        r7 = BuildConfig.FLAVOR;
    L22:
        Object r9 = Result.constructor-impl(r7);     // Catch: Throwable -> L24
    L27:
        if (Result.isFailure-impl(r9) == false) goto L29;
        r9 = BuildConfig.FLAVOR;
    L29:
        String r13 = (String) r9;
        if (Intrinsics.areEqual(r13, b.c) == true) goto L32;
        int r15 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_InterceptionRestoreProber", "probe: foreground user changed (was=" + b.c + ", now=" + r13 + "), abort without replay/clear");
        goto L107
    L32:
        b.a.getClass();
        Application r16 = com.larksuite.framework.utils.b.a;
        if (r16 != null) goto L35;
        ScsLogger.d("SecurityPolicy_InterceptionRestoreProber", "isOnline: appContext null → offline");
    L47:
        r22 = BuildConfig.FLAVOR;
        boolean r17 = false;
    L94:
        if (r17 == false) goto L96;
        ScsLogger.d("SecurityPolicy_InterceptionRestoreProber", "probe tick: online, abort and clear storage");
        a.a.getClass();
        a.a();
        goto L108
    L96:
        int r18 = r11 + 1;
        ScsLogger.d("SecurityPolicy_InterceptionRestoreProber", "probe tick: offline, streak=" + r18);
        if (r18 < 3) goto L102;
        b r19 = b.a;
        c r20 = r12.$restored;
        r19.getClass();
        ScsLogger.d("SecurityPolicy_InterceptionRestoreProber", "replay: traceId=" + r20.b.getTraceId());
        Bundle r21 = new Bundle();
        r21.putParcelable("param_action", r20.b);
        int r23 = g8b.b.a;
        if (g8b.b.a.a().c(r20.a, r21) == false) goto L101;
        ScsLogger.d("SecurityPolicy_InterceptionRestoreProber", "probe: replay accepted, finish");
        goto L108
    L101:
        ScsLogger.d("SecurityPolicy_InterceptionRestoreProber", "probe: replay rejected (main page not ready), keep probing");
    L102:
        r12.L$0 = r10;
        r12.I$0 = r18;
        r12.J$0 = r8;
        r12.label = 2;
        if (DelayKt.delay(1000, r12) != r4) goto L105;
        return r4;
    L105:
        r11 = r18;
        goto L14
    L35:
        Object r24 = r16.getSystemService("connectivity");
        if ((r24 instanceof ConnectivityManager) == false) goto L38;
        ConnectivityManager r25 = (ConnectivityManager) r24;
    L39:
        if (r25 != null) goto L41;
        ScsLogger.d("SecurityPolicy_InterceptionRestoreProber", "isOnline: ConnectivityManager null → offline");
        goto L47
    L41:
        Network[] r27 = r25.getAllNetworks();
        if (r27.length != 0) goto L44;
        boolean r28 = true;
    L45:
        if (r28 == false) goto L48;
        ScsLogger.d("SecurityPolicy_InterceptionRestoreProber", "isOnline: no networks → offline");
        goto L47
    L48:
        StringBuilder r29 = new StringBuilder();
        int r110 = r27.length;
        int r30 = 0;
        Network r111 = null;
    L49:
        if (r30 >= r110) goto L85;
        Network r31 = r27[r30];
        NetworkCapabilities r32 = r25.getNetworkCapabilities(r31);
        if (r32 != null) goto L53;
        ConnectivityManager r210 = r25;
        Network[] r211 = r27;
        String r212 = r14;
        int r213 = r110;
    L84:
        r30 = r30 + 1;
        r25 = r210;
        r14 = r212;
        r27 = r211;
        r110 = r213;
        goto L49
    L53:
        r210 = r25;
        StringBuilder r33 = new StringBuilder();
        if (r32.hasTransport(1) == false) goto L57;
        r33.append("WIFI ");
    L57:
        if (r32.hasTransport(0) == false) goto L60;
        r33.append("CELLULAR ");
    L60:
        if (r32.hasTransport(4) == false) goto L63;
        r33.append("VPN ");
    L63:
        if (r32.hasTransport(2) == false) goto L66;
        r33.append("BT ");
    L66:
        if (r32.hasTransport(3) == false) goto L69;
        r33.append("ETH ");
    L69:
        if (r33.length() != 0) goto L71;
        boolean r34 = true;
    L72:
        if (r34 == false) goto L74;
        r33.append("UNKNOWN");
    L74:
        String r35 = StringsKt.trim(r33.toString()).toString();
        boolean r36 = r32.hasCapability(12);
        r211 = r27;
        r213 = r110;
        if (Build.VERSION.SDK_INT < 23) goto L77;
        boolean r37 = r32.hasCapability(16);
    L78:
        boolean r38 = r32.hasTransport(4);
        r212 = r14;
        r29.append("[" + r31 + ": " + r35 + " internet=" + r36 + " validated=" + r37 + " isVpn=" + r38 + "] ");
        if (r38 == true) goto L84;
        if (r36 == false) goto L84;
        if (r37 == false) goto L84;
        if (r111 != null) goto L84;
        r111 = r31;
        goto L84
    L77:
        r37 = true;
        goto L78
    L71:
        r34 = false;
        goto L72
    L85:
        r22 = r14;
        if (r111 == null) goto L88;
        r17 = true;
    L89:
        int r39 = ScsLogger.a;
        StringBuilder r40 = new StringBuilder("isOnline: ");
        r40.append(StringsKt.trim(r29.toString()).toString());
        r40.append(" → ");
        if (r17 == false) goto L92;
        String r41 = "online";
    L93:
        r40.append(r41);
        ScsLogger.d("SecurityPolicy_InterceptionRestoreProber", r40.toString());
        goto L94
    L92:
        r41 = "offline";
        goto L93
    L88:
        r17 = false;
        goto L89
    L44:
        r28 = false;
        goto L45
    L38:
        r25 = null;
    L24:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        CoroutineScope r42 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r26);
    L13:
        r8 = System.currentTimeMillis();
        r12 = this;
        r10 = r42;
        r11 = 0;
        r4 = r0;
        goto L14
    L10:
        ResultKt.throwOnFailure(r26);
        r42 = (CoroutineScope) this.L$0;
        this.L$0 = r42;
        this.label = 1;
        if (DelayKt.delay(1000, this) != r0) goto L13;
        return r0;
    }
}
