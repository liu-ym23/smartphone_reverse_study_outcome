package com.larus.dora.impl.nl;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.network.DoraNetworkApi;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.nl.DoraUserSettingsManager$syncUserSettings$1", f = "DoraUserSettingsManager.kt", i = {}, l = {346}, m = "invokeSuspend", n = {}, s = {})
final class DoraUserSettingsManager$syncUserSettings$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $where;
    final /* synthetic */ boolean $withAppList;
    int label;

    public DoraUserSettingsManager$syncUserSettings$1(boolean r1, String r2, Continuation<? super DoraUserSettingsManager$syncUserSettings$1> r3) {
        this.$withAppList = r1;
        this.$where = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraUserSettingsManager$syncUserSettings$1(this.$withAppList, this.$where, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
        Object r15 = ((Result) r14).unbox-impl();
    L11:
        boolean r2 = this.$withAppList;
        String r3 = this.$where;
        if (Result.isSuccess-impl(r15) == false) goto L47;
        com.larus.dora.impl.network.f0 r4 = (com.larus.dora.impl.network.f0) r15;
        g49.d.d("DoraUserSettingsManager", "syncUserSettings success, userSettings=" + r4);
        DoraUserSettingsManager r5 = DoraUserSettingsManager.a;
        String r6 = null;
        if (r2 == true) goto L17;
        r4 = com.larus.dora.impl.network.f0.a(DoraUserSettingsManager.c, null, r4.d(), 15);
    L17:
        DoraUserSettingsManager.c = r4;
        com.larus.dora.impl.util.x r7 = com.larus.dora.impl.util.x.a;
        DoraUserSettingsManager r8 = DoraUserSettingsManager.a;
        com.larus.dora.impl.network.f0 r9 = DoraUserSettingsManager.c;
        r7.getClass();
        com.larus.dora.impl.util.x.b(r9);
        List r10 = DoraUserSettingsManager.c.c();
        if (r10 == null) goto L27;
        List r11 = CollectionsKt.filterNotNull(r10);
        if (r11 == null) goto L27;
        if ((!r11.isEmpty()) == true) goto L25;
        r11 = null;
    L25:
        if (r11 == null) goto L27;
    L28:
        Type r12 = k.e;
        k.b.a.c(r11);
        NLServiceImpl r13 = DoraUserSettingsManager.t;
        com.larus.dora.impl.network.g0 r16 = DoraUserSettingsManager.c.d();
        if (r16 == null) goto L33;
        String r17 = r16.g();
        if (r17 == null) goto L33;
        int r18 = CastIntegerProtector.parseInt(r17);
    L34:
        r13.g(r18);
        BuildersKt.launch$default(DoraUserSettingsManager.b, null, null, new DoraUserSettingsManager.applyUserSettings.1(null), 3, null);
        com.larus.dora.impl.network.g0 r20 = DoraUserSettingsManager.c.d();
        if (r20 == null) goto L37;
        r6 = r20.g();
    L37:
        boolean r21 = Intrinsics.areEqual(r6, "1");
        com.larus.dora.impl.network.g0 r22 = DoraUserSettingsManager.c.d();
        if (r22 == null) goto L41;
        String r23 = r22.e();
        if (r23 == null) goto L41;
    L42:
        String r24 = r23.concat("s");
        DoraBuryPointManager r25 = DoraBuryPointManager.a;
        Pair[] r26 = new Pair[3];
        r26[0] = TuplesKt.to("where", r3);
        if (r21 == false) goto L45;
        String r27 = "on";
    L46:
        r26[1] = TuplesKt.to("notification_status", r27);
        r26[2] = TuplesKt.to("notification_frequency", r24);
        r25.L("dora_notification_settings_track", MapsKt.mapOf(r26));
        goto L47
    L45:
        r27 = "off";
    L41:
        r23 = "10";
    L33:
        r18 = 2;
    L27:
        r11 = DoraUserSettingsManager.u;
    L47:
        Throwable r110 = Result.exceptionOrNull-impl(r15);
        if (r110 == null) goto L51;
        g49.d.c("DoraUserSettingsManager", "syncUserSettings failed", r110);
    L51:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        DoraNetworkApi r111 = DoraNetworkApi.a;
        boolean r28 = this.$withAppList;
        this.label = 1;
        r15 = r111.v(r28, this);
        if (r15 != r0) goto L11;
        return r0;
    }
}
