package com.bytedance.ai.bridge.method.system;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.res.Resources;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.util.DisplayMetrics;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.system.setting.AbsGetSystemSettingMethodIDL;
import com.bytedance.ai.utils.g;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import d3.a0;
import e3.e;
import f3.h;
import f4.o;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/GetSystemSettingMethod;", "Lcom/bytedance/ai/bridge/system/setting/AbsGetSystemSettingMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/system/setting/AbsGetSystemSettingMethodIDL$GetSystemSettingResultModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/system/setting/AbsGetSystemSettingMethodIDL$EmptyMessageModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetSystemSettingMethod extends AbsGetSystemSettingMethodIDL {
    public final boolean b;

    public static final class a {
    }

    static {
    }

    public GetSystemSettingMethod() {
        this.b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.b;
    }

    public static com.bytedance.ai.bridge.core.a b(e3.d r10, AbsGetSystemSettingMethodIDL.a r11) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        g r12 = g.a;
        StringBuilder r0 = new StringBuilder("call start, appletId=");
        a0 r1 = r10.getContainerContext();
        WifiManager r13 = null;
        if (r1 == null) goto L5;
        String r14 = r1.getAppletId();
    L6:
        r0.append(r14);
        r12.i("AISDK_JSB_GetSystemSettingMethod", r0.toString());
        Context r15 = e.b(r10);
        if (r15 != null) goto L10;
        StringBuilder r16 = new StringBuilder("call failed, errNo=");
        f3.a r17 = f3.a.f;
        r16.append(r17.a);
        r16.append(", msg=context is null");
        r12.e("AISDK_JSB_GetSystemSettingMethod", r16.toString());
        return new com.bytedance.ai.bridge.core.a.b(0, "context is null", null, r17, 21);
    L10:
        r12.i("AISDK_JSB_GetSystemSettingMethod", "call success");
        Intrinsics.checkNotNullParameter(AbsGetSystemSettingMethodIDL.b.class, "<this>");
        BaseModel r18 = k3.c.a(AbsGetSystemSettingMethodIDL.b.class);
        AbsGetSystemSettingMethodIDL.b r19 = (AbsGetSystemSettingMethodIDL.b) r18;
        o.a.getClass();
        Intrinsics.checkNotNullParameter(r15, "context");
        boolean r20 = false;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L23
        if (Build.VERSION.SDK_INT < 23) goto L17;
        BluetoothManager r22 = (BluetoothManager) r15.getSystemService(BluetoothManager.class);     // Catch: Throwable -> L23
        if (r22 == null) goto L16;
        BluetoothAdapter r23 = r22.getAdapter();     // Catch: Throwable -> L23
    L18:
        if (r23 == null) goto L20;
        boolean r24 = r23.isEnabled();     // Catch: Throwable -> L23
    L21:
        Object r25 = Result.constructor-impl(Boolean.valueOf(r24));     // Catch: Throwable -> L23
    L25:
        Boolean r26 = Boolean.FALSE;
        if (Result.isFailure-impl(r25) == false) goto L28;
        r25 = r26;
    L28:
        r19.setBluetoothEnabled(Boolean.valueOf(((Boolean) r25).booleanValue()));
        o.a.getClass();
        Intrinsics.checkNotNullParameter(r15, "context");
        Object r27 = r15.getSystemService(com.bytedance.android.ec.core.event.a.KEY_LOCATION);     // Catch: Throwable -> L47
        if ((r27 instanceof LocationManager) == false) goto L32;
        LocationManager r28 = (LocationManager) r27;     // Catch: Throwable -> L47
    L33:
        if (r28 != null) goto L36;
    L43:
        boolean r29 = false;
    L45:
        Object r30 = Result.constructor-impl(Boolean.valueOf(r29));     // Catch: Throwable -> L47
    L49:
        Boolean r31 = Boolean.FALSE;
        if (Result.isFailure-impl(r30) == false) goto L52;
        r30 = r31;
    L52:
        r19.setLocationEnabled(Boolean.valueOf(((Boolean) r30).booleanValue()));
        o.a.getClass();
        Intrinsics.checkNotNullParameter(r15, "context");
        Object r32 = r15.getApplicationContext().getSystemService("wifi");     // Catch: Throwable -> L61
        if ((r32 instanceof WifiManager) == false) goto L56;
        r13 = (WifiManager) r32;     // Catch: Throwable -> L61
    L56:
        if (r13 == null) goto L59;
        r20 = r13.isWifiEnabled();     // Catch: Throwable -> L61
    L59:
        Object r33 = Result.constructor-impl(Boolean.valueOf(r20));     // Catch: Throwable -> L61
    L63:
        Boolean r34 = Boolean.FALSE;
        if (Result.isFailure-impl(r33) == false) goto L66;
        r33 = r34;
    L66:
        r19.setWifiEnabled(Boolean.valueOf(((Boolean) r33).booleanValue()));
        o.a.getClass();
        Intrinsics.checkNotNullParameter(r15, "context");
        int r35 = r15.getResources().getConfiguration().orientation;
        if (r35 != 1) goto L69;
    L73:
        String r36 = "portrait";
    L74:
        r19.setDeviceOrientation(r36);
        return new com.bytedance.ai.bridge.core.a.c(r18);
    L69:
        if (r35 == 2) goto L72;
        Resources r37 = r15.getResources();
        DisplayMetrics r38 = WindowDisplayMetricsOverride.apply(r37, r37.getDisplayMetrics());
        if (r38.widthPixels <= r38.heightPixels) goto L73;
    L72:
        r36 = "landscape";
    L61:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r33 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L63
    L36:
        if (Build.VERSION.SDK_INT < 28) goto L39;
        r29 = r28.isLocationEnabled();     // Catch: Throwable -> L47
        goto L45
    L39:
        if (r28.isProviderEnabled("gps") == false) goto L41;
    L44:
        r29 = true;
        goto L45
    L41:
        if (r28.isProviderEnabled("network") == false) goto L43;
    L32:
        r28 = null;
    L47:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L49
    L20:
        r24 = false;
        goto L21
    L16:
        r23 = null;
        goto L18
    L17:
        r23 = BluetoothAdapter.getDefaultAdapter();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L5:
        r14 = null;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final /* bridge */ /* synthetic */ com.bytedance.ai.bridge.core.a handleSync(e3.d r1, ParamModel r10) {
        return b(r1, (AbsGetSystemSettingMethodIDL.a) r10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, h r12) {
        AbsGetSystemSettingMethodIDL.a r13 = (AbsGetSystemSettingMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        com.bytedance.ai.bridge.core.b.a(b(r10, r13), r12);
    }
}
