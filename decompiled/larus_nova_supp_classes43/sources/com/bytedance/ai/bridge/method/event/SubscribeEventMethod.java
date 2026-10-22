package com.bytedance.ai.bridge.method.event;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.view.View;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.event.AbsSubscribeEventMethodIDL;
import com.bytedance.ai.bridge.method.device.BatteryInfoChangeEventPublisher$ensureMonitoring$1$changeReceiver$1;
import com.bytedance.ai.utils.g;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import d3.a0;
import e3.d;
import f2.k;
import f3.h;
import f4.t;
import f4.w;
import k3.c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import l3.e;
import t3.e0;
import v3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/bridge/method/event/SubscribeEventMethod;", "Lcom/bytedance/ai/bridge/event/AbsSubscribeEventMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/event/AbsSubscribeEventMethodIDL$SubscribeEventParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/event/AbsSubscribeEventMethodIDL$EmptyMessageModel;", "shouldSkipThemeChangeSubscription", "", "eventName", "", "launchRelatedEventService", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubscribeEventMethod extends AbsSubscribeEventMethodIDL {

    public static final class a {
    }

    static {
    }

    public SubscribeEventMethod() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [android.content.BroadcastReceiver, com.bytedance.ai.bridge.method.device.BatteryInfoChangeEventPublisher$ensureMonitoring$1$changeReceiver$1, java.lang.Object] */
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r11, ParamModel r12, h r13) {
        AbsSubscribeEventMethodIDL.b r14 = (AbsSubscribeEventMethodIDL.b) r12;
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        if (Intrinsics.areEqual(r14.getEventName(), "onThemeChange") == true) goto L5;
        boolean r10 = false;
    L24:
        if (r10 == false) goto L26;
        g.a.i("SubscribeEventMethod", "skip onThemeChange subscription because theme is forced");
        Intrinsics.checkNotNullParameter(AbsSubscribeEventMethodIDL.a.class, "<this>");
        r13.b((ResultModel) c.a(AbsSubscribeEventMethodIDL.a.class), "");
        return;
    L26:
        Lazy r0 = l3.d.a;
        e3.g r15 = r11.getJsEventDelegate();
        a0 r16 = r11.getContainerContext();
        if (r16 == null) goto L29;
        String r17 = r16.getContainerId();
    L30:
        a0 r18 = r11.getContainerContext();
        if (r18 == null) goto L33;
        String r19 = r18.getAppletId();
    L34:
        long r20 = r14.getTimestamp();
        a0 r21 = r11.getContainerContext();
        if (r21 == null) goto L37;
        String r22 = r21.getTag();
    L38:
        l3.d.e(new e(r15, r17, r19, r20, r22), r14.getEventName());
        String r110 = r14.getEventName();
        switch(r110.hashCode()) {
            case -2116854609: goto L108;
            case -1771389009: goto L101;
            case -1697607502: goto L98;
            case -1411253139: goto L92;
            case -1272114076: goto L56;
            case 403290560: goto L52;
            case 1015003481: goto L49;
            case 1559973925: goto L46;
            case 1982168521: goto L42;
            default: goto L117;
        };
    L117:
        Intrinsics.checkNotNullParameter(AbsSubscribeEventMethodIDL.a.class, "<this>");
        r13.b((ResultModel) c.a(AbsSubscribeEventMethodIDL.a.class), "");
        return;
    L42:
        if (r110.equals("doubao.onNetworkStatusChange") == false) goto L117;
        Object r111 = com.bytedance.ai.bridge.method.net.d.a;
        com.bytedance.ai.bridge.method.net.d.b();
        goto L117
    L46:
        if (r110.equals("doubao.onBluetoothDeviceFound") == false) goto L117;
    L110:
        Context r112 = e3.e.b(r11);
        if (r112 == null) goto L117;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L114
        e0.a.getClass();     // Catch: Throwable -> L114
        e0.d(r11, r112);     // Catch: Throwable -> L114
        Object r113 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L114
    L116:
        Result.box-impl(r113);
    L114:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r113 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L116
    L49:
        if (r110.equals("doubao.onBluetoothAdapterStateChange") == true) goto L110;
    L52:
        if (r110.equals("doubao.onUserCaptureScreen") == false) goto L117;
        w3.d.a.getClass();
        w3.d.c();
        goto L117
    L56:
        if (r110.equals("doubao.onBatteryInfoChange") == false) goto L117;
        Object r115 = t3.d.a;
        Context r116 = k.a().getApplicationContext();
        Object r117 = t3.d.a;
        monitor-enter(r117);
    L88:
        th = move-exception;
        throw th;
    L61:
        if (t3.d.c == null) goto L64;
        monitor-exit(r117);
        goto L117
    L64:
        ?? r23 = new BatteryInfoChangeEventPublisher$ensureMonitoring$1$changeReceiver$1();     // Catch: Throwable -> L88
        IntentFilter r24 = new IntentFilter("android.os.action.POWER_SAVE_MODE_CHANGED");     // Catch: RuntimeException -> L71 Throwable -> L88
        r24.addAction("miui.intent.action.POWER_SAVE_MODE_CHANGED");     // Catch: RuntimeException -> L71 Throwable -> L88
        if (Build.VERSION.SDK_INT < 34) goto L68;
        t3.d.a(r116, r23, r24);     // Catch: RuntimeException -> L71 Throwable -> L88
    L69:
        t3.d.b = r116;     // Catch: RuntimeException -> L71 Throwable -> L88
        t3.d.c = r23;     // Catch: RuntimeException -> L71 Throwable -> L88
        t3.e.b.getClass();     // Catch: RuntimeException -> L71 Throwable -> L88
        t3.d.d = t3.e.a.a(r116);     // Catch: RuntimeException -> L71 Throwable -> L88
    L85:
        Unit r118 = Unit.INSTANCE;     // Catch: Throwable -> L88
        monitor-exit(r117);
        goto L117
    L68:
        t3.d.b(r116, r23, r24);     // Catch: RuntimeException -> L71 Throwable -> L88
    L71:
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L82
        ReceiverRegisterLancet.loge(r23, false);     // Catch: Throwable -> L82
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L125;
        r116.unregisterReceiver(r23);     // Catch: Throwable -> L82
    L80:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L82
    L84:
        t3.d.b = null;     // Catch: Throwable -> L88
        t3.d.c = null;     // Catch: Throwable -> L88
        t3.d.d = null;     // Catch: Throwable -> L88
        goto L85
    L125:
    L77:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r23.toString());     // Catch: Throwable -> L82
        e.printStackTrace();     // Catch: Throwable -> L82
        goto L80
    L74:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r23, r116) == false) goto L80;
        r116.unregisterReceiver(r23);     // Catch: Exception -> L77 Throwable -> L82
    L82:
        th = move-exception;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L88
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L88
        goto L84
    L92:
        if (r110.equals("doubao.onWifiConnected") == false) goto L117;
        Context r119 = e3.e.b(r11);
        if (r119 == null) goto L117;
        b.f(r119);
        goto L117
    L98:
        if (r110.equals("doubao.onBLECharacteristicValueChange") == true) goto L110;
    L101:
        if (r110.equals("doubao.onUserScreenRecord") == false) goto L117;
        w r120 = w.a;
        final Activity r121 = e3.e.a(r11);
        r120.getClass();
        if (Build.VERSION.SDK_INT < 35) goto L117;
        p2.c.d(new t(r121));
        goto L117
    L108:
        if (r110.equals("doubao.onBLEConnectionStateChange") == true) goto L110;
    L37:
        r22 = null;
        goto L38
    L33:
        r19 = null;
        goto L34
    L29:
        r17 = null;
        goto L30
    L5:
        View r27 = r11.getEngineView();
        if (r27 == null) goto L8;
        Context r28 = r27.getContext();
    L9:
        r10 = t2.a.b(r28);
        g r29 = g.a;
        StringBuilder r30 = new StringBuilder("check onThemeChange subscription, appletId=");
        a0 r31 = r11.getContainerContext();
        if (r31 == null) goto L12;
        String r32 = r31.getAppletId();
    L13:
        r30.append(r32);
        r30.append(", hasEngineView=");
        if (r27 == null) goto L16;
        boolean r33 = true;
    L17:
        r30.append(r33);
        r30.append(", contextType=");
        if (r27 == null) goto L22;
        Context r34 = r27.getContext();
        if (r34 == null) goto L22;
        String r35 = r34.getClass().getName();
    L23:
        r30.append(r35);
        r30.append(", isForcedTheme=");
        r30.append(r10);
        r29.i("SubscribeEventMethod", r30.toString());
    L22:
        r35 = null;
        goto L23
    L16:
        r33 = false;
        goto L17
    L12:
        r32 = null;
        goto L13
    L8:
        r28 = null;
        goto L9
    }
}
