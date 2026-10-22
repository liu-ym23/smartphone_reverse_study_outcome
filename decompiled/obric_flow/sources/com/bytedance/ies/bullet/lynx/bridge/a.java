package com.bytedance.ies.bullet.lynx.bridge;

import com.bytedance.ies.bullet.core.kit.bridge.IBridgeScope$BridgeNotFoundException;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ies.bullet.core.kit.bridge.c f5601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Callback f5603c;
    public final long d;
    public final int e;
    public final LynxView f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ LynxBridgeModule f5604h;

    public a(LynxBridgeModule r5, com.bytedance.ies.bullet.core.kit.bridge.c r10, String r11, Callback r12, long r13, int r14, LynxView r15) {
        Intrinsics.checkNotNullParameter(r10, "perfData");
        Intrinsics.checkNotNullParameter(r11, "func");
        Intrinsics.checkNotNullParameter(r12, "callback");
        this.f5604h = r5;
        this.f5601a = r10;
        this.f5602b = r11;
        this.f5603c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = "lynx bridge rejected";
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r18) {
        Throwable r5 = (Throwable) r18;
        Intrinsics.checkNotNullParameter(r5, "t");
        if ((r5 instanceof IBridgeScope$BridgeNotFoundException) == false) goto L12;
        com.bytedance.ies.bullet.core.kit.bridge.c r10 = this.f5601a;
        r10.getClass();
        r10.e = System.currentTimeMillis();
        JavaOnlyMap r11 = new JavaOnlyMap();
        r11.putInt("code", -2);
        String r12 = r5.getMessage();
        if (r12 != null) goto L7;
        r12 = "";
    L7:
        r11.putString("message", r12);
        this.f5603c.invoke(new Object[]{r11});
        r10.f = System.currentTimeMillis();
        r10.g = System.currentTimeMillis();
        LynxBridgeModule r13 = this.f5604h;
        String r14 = this.f5602b;
        LynxBridgeModule.access$onReady(r13, r10, r14);
        LynxView r15 = this.f;
        if (r15 == null) goto L10;
        com.bytedance.android.monitorV2.lynx.d r16 = com.bytedance.android.monitorV2.lynx.d.f3638a;
        x4.f r17 = new x4.f();
        r17.d = r14;
        r17.f22969b = 4;
        r17.f22970c = "bridge method not found";
        Unit r19 = Unit.INSTANCE;
        r16.getClass();
        com.bytedance.android.monitorV2.lynx.d.h(r15, r17);
    L10:
        long r110 = this.d;
        int r111 = this.e;
        LynxBridgeModule.access$doMonitorLog(this.f5604h, this.f5602b, this.g, r110, "xbridge", r111, false, 4, "bridge method not found," + r5);
    L12:
        return Unit.INSTANCE;
    }
}
