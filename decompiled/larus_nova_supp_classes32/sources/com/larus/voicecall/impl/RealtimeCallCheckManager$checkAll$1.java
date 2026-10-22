package com.larus.voicecall.impl;

import android.app.Application;
import android.os.Build;
import androidx.fragment.app.Fragment;
import com.bytedance.keva.Keva;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.common.apphost.AppHost;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.g1;
import com.larus.platform.model.TriggerLoginScene;
import com.larus.platform.model.downgrade.FlowDowngradeToastConfig;
import com.larus.platform.service.i2;
import com.larus.platform.service.i3;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.RealtimeCallCheckManager$checkAll$1", f = "RealtimeCallCheckManager.kt", i = {}, l = {75, 81}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCallCheckManager$checkAll$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Integer, Unit> $callback;
    final /* synthetic */ boolean $isOpenVlm;
    int label;
    final /* synthetic */ l this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public RealtimeCallCheckManager$checkAll$1(l r1, boolean r2, Function1<? super Integer, Unit> r3, Continuation<? super RealtimeCallCheckManager$checkAll$1> r4) {
        this.this$0 = r1;
        this.$isOpenVlm = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new RealtimeCallCheckManager$checkAll$1(this.this$0, this.$isOpenVlm, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r23) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ResultKt.throwOnFailure(r23);
        Object r3 = r23;
    L95:
        this.$callback.invoke(Boxing.boxInt(((Number) r3).intValue()));
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r23);
        Object r4 = r23;
    L69:
        int r5 = ((Number) r4).intValue();
        if (r5 == 0) goto L73;
        this.$callback.invoke(Boxing.boxInt(r5));
        return Unit.INSTANCE;
    L73:
        l r6 = this.this$0;
        this.label = 2;
        Pair<Boolean, Boolean> r7 = l.i;
        r6.getClass();
        kotlinx.coroutines.j r8 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r8.C();
        if (l.a.b(r6.a.requireContext()) == false) goto L77;
        Result.Companion r9 = Result.Companion;
        r8.resumeWith(Result.constructor-impl(Boxing.boxInt(0)));
    L90:
        r3 = r8.B();
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L93;
        DebugProbesKt.probeCoroutineSuspended(this);
    L93:
        if (r3 != r1) goto L95;
        return r1;
    L77:
        if (i2.b.d("android.permission.RECORD_AUDIO") == true) goto L86;
        ArrayList r10 = CollectionsKt.arrayListOf(new String[]{"android.permission.RECORD_AUDIO"});
        if (Build.VERSION.SDK_INT < 31) goto L85;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.z() == false) goto L85;
        if (RealtimeCallUtil.y() == true) goto L85;
        r10.add("android.permission.BLUETOOTH_CONNECT");
    L85:
        Fragment r11 = r6.a;
        m r12 = new m(r8, r6);
        JSONObject r13 = new JSONObject();
        r13.put("enter_method", "call");
        Unit r14 = Unit.INSTANCE;
        g1.a.a(r11, r10, r12, null, r13, 8);
        goto L90
    L86:
        IRealtimeCallTracer r15 = r6.b;
        if (r15 == null) goto L89;
        r15.g0(r6.c, r6.d, r6.e, r6.f);
    L89:
        Result.Companion r16 = Result.Companion;
        r8.resumeWith(Result.constructor-impl(Boxing.boxInt(2)));
        goto L90
    L10:
        ResultKt.throwOnFailure(r23);
        l r17 = this.this$0;
        boolean r18 = this.$isOpenVlm;
        Pair<Boolean, Boolean> r19 = l.i;
        r17.getClass();
        r17.g = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        if (i3.a.i() == true) goto L15;
        FLogger.a.i("RealtimeCallCheckManager_checkTourist", "is not tourist");
        CompletableDeferred<Integer> r20 = r17.g;
        if (r20 == null) goto L66;
        r20.complete(0);
    L66:
        CompletableDeferred<Integer> r21 = this.this$0.g;
        Intrinsics.checkNotNull(r21);
        this.label = 1;
        r4 = r21.await(this);
        if (r4 != r1) goto L69;
        return r1;
    L15:
        IFlowSdkDepend r22 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        Keva r110 = com.larus.voicecall.impl.utils.s.a;
        if (r22 == null) goto L20;
        r22.getAccountService();
        if (com.larus.home.impl.sdk.d.a.M() != true) goto L20;
        boolean r24 = true;
    L22:
        if (r24 == true) goto L24;
        FLogger.a.i("RealtimeCallCheckManager_checkTourist", "canSkipCheckTourist is false");
        l.i = TuplesKt.to(Boolean.TRUE, Boolean.valueOf(r18));
        i3.j(TriggerLoginScene.TRIGGER_LOGIN_CLICK_CALL, null, null, 6);
        goto L66
    L24:
        Keva r25 = com.larus.voicecall.impl.utils.s.a;
        if (r25 == null) goto L27;
        int r111 = r25.getInt("real_time_call_tourist_count", 0);
    L28:
        AppHost.Companion r112 = AppHost.a;
        if (r112.isDebug() == false) goto L31;
    L32:
        Keva r113 = com.larus.voicecall.impl.utils.s.b;
        if (r113 == null) goto L35;
        int r26 = r113.getInt("login_degrade_call_count", 1);
    L36:
        FLogger r114 = FLogger.a;
        r114.i("TouristCallLimit", "touristCallCount: " + r111 + ", touristCallLimit: " + r26);
        if (r111 < r26) goto L39;
        boolean r27 = true;
    L40:
        if (r27 == false) goto L56;
        FlowDowngradeToastConfig r28 = z2.a.getFlowDowngradeToastConfig();
        if (r28 == null) goto L44;
        String r29 = r28.getTrafficDegradationCallDisableCn();
    L45:
        r114.i("RealtimeCallCheckManager_checkTourist", "limited by tourist real-time call count");
        r114.i("RealtimeCallCheckManager_checkTourist", "is form settings: " + o0.d(r29));
        t19.s r115 = t19.s.a;
        Application r116 = r112.getApplication();
        if (r29 != null) goto L48;
    L51:
        boolean r30 = true;
    L52:
        if (r30 == false) goto L54;
        String r31 = r112.getApplication().getString(2131910598);
    L55:
        String r117 = r31;
        Intrinsics.checkNotNull(r117);
        t19.s.j(r115, r116, r117, null, false, 28);
        l.i = TuplesKt.to(Boolean.TRUE, Boolean.valueOf(r18));
        i3.j(TriggerLoginScene.TRIGGER_LOGIN_CLICK_CALL, null, null, 6);
        goto L66
    L54:
        r31 = r29.toString();
        goto L55
    L48:
        if (r29.length() == 0) goto L51;
        r30 = false;
        goto L52
    L44:
        r29 = null;
        goto L45
    L56:
        r114.i("RealtimeCallCheckManager_checkTourist", "allow tourist real-time call");
        if (r25 == null) goto L59;
        int r32 = r25.getInt("real_time_call_tourist_count", 0);
    L60:
        r114.i("TouristCallLimit", "storeTouristCallCount, currentCount: " + r32);
        if (r25 == null) goto L63;
        r25.storeInt("real_time_call_tourist_count", r32 + 1);
    L63:
        CompletableDeferred<Integer> r33 = r17.g;
        if (r33 == null) goto L66;
        r33.complete(0);
        goto L66
    L59:
        r32 = 0;
        goto L60
    L39:
        r27 = false;
    L35:
        r26 = 1;
        goto L36
    L31:
        if (r112.isTestChannel() == false) goto L35;
    L27:
        r111 = 0;
    L20:
        r24 = false;
        goto L22
    }
}
