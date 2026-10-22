package com.obric.aikernel.middleware.api.appcontext.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.p1;

/* JADX INFO: loaded from: classes2.dex */
public final class ChargingStateListener extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ChargingStateListener f4508a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f4509b = null;

    static {
        f4508a = new ChargingStateListener();
        f4509b = LazyKt.lazy(ChargingStateListener$_isChargingState$2.INSTANCE);
    }

    private ChargingStateListener() {
    }

    public static final /* synthetic */ boolean a(ChargingStateListener r10) {
        return r10.f();
    }

    private final g1<Boolean> c() {
        return (g1) f4509b.getValue();
    }

    private final boolean f() {
        IntentFilter r10 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Intent r11 = AppContext.INSTANCE.getContext().registerReceiver(null, r10);
        int r12 = -1;
        if (r11 == null) goto L6;
        r12 = r11.getIntExtra("status", -1);
    L6:
        if (r12 != 2) goto L8;
    L11:
        return true;
    L8:
        if (r12 == 5) goto L11;
        return false;
    }

    public final p1<Boolean> b() {
        return c();
    }

    public final void d(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        AIKLog.INSTANCE.d("ChargingStateListener", CommonConsts.APM_INNER_EVENT_COST_INIT);
        Context r11 = AppContext.INSTANCE.getContext();
        IntentFilter r12 = new IntentFilter();
        r12.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        r12.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        Unit r13 = Unit.INSTANCE;
        r11.registerReceiver(this, r12);
    }

    public final boolean e() {
        return c().getValue().booleanValue();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        if (r11 == null) goto L4;
        String r12 = r11.getAction();
    L5:
        if (r12 == null) goto L21;
        int r13 = r12.hashCode();
        if (r13 == (-1886648615)) goto L16;
        if (r13 == 1019184907) goto L12;
        return;
    L12:
        if (r12.equals("android.intent.action.ACTION_POWER_CONNECTED") == false) goto L23;
        AIKLog.INSTANCE.d("ChargingStateListener", "onReceive: ACTION_POWER_CONNECTED");
        g1<Boolean> r14 = c();
        Boolean r15 = Boolean.TRUE;
    L19:
        r14.setValue(r15);
        return;
    L23:
        return;
    L16:
        if (r12.equals("android.intent.action.ACTION_POWER_DISCONNECTED") == false) goto L24;
        AIKLog.INSTANCE.d("ChargingStateListener", "onReceive: ACTION_POWER_DISCONNECTED");
        r14 = c();
        r15 = Boolean.FALSE;
        goto L19
    L24:
        return;
    L21:
        return;
    L4:
        r12 = null;
        goto L5
    }
}
