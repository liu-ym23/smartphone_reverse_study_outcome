package com.bytedance.ies.bullet.lynx.bridge;

import android.os.SystemClock;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxView;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements sc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ies.bullet.core.kit.bridge.c f5605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Callback f5607c;
    public final long d;
    public final int e;
    public final LynxView f;
    public final /* synthetic */ LynxBridgeModule g;

    public c(LynxBridgeModule r5, com.bytedance.ies.bullet.core.kit.bridge.c r10, String r11, Callback r12, long r13, int r14, LynxView r15) {
        Intrinsics.checkNotNullParameter(r10, "perfData");
        Intrinsics.checkNotNullParameter(r11, "func");
        Intrinsics.checkNotNullParameter(r12, "callback");
        this.g = r5;
        this.f5605a = r10;
        this.f5606b = r11;
        this.f5607c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
    }

    @Override // sc.a
    public final void a(JSONObject r13) {
        Intrinsics.checkNotNullParameter(r13, "data");
        com.bytedance.ies.bullet.core.kit.bridge.c r5 = this.f5605a;
        r5.getClass();
        r5.e = System.currentTimeMillis();
        this.f5607c.invoke(new Object[]{com.lynx.tasm.utils.b.e(r13)});     // Catch: JSONException -> L5
    L7:
        r5.f = System.currentTimeMillis();
        r5.g = System.currentTimeMillis();
        LynxBridgeModule r14 = this.g;
        String r10 = this.f5606b;
        LynxBridgeModule.access$onReady(r14, r5, r10);
        LynxView r15 = this.f;
        if (r15 == null) goto L10;
        com.bytedance.android.monitorV2.lynx.d r11 = com.bytedance.android.monitorV2.lynx.d.f3638a;
        x4.g r12 = new x4.g();
        r12.f22971b = r10;
        r12.f22972c = SystemClock.elapsedRealtime() - this.d;
        Unit r16 = Unit.INSTANCE;
        r11.getClass();
        com.bytedance.android.monitorV2.lynx.d.i(r15, r12);
    L10:
        LynxBridgeModule.doMonitorLog$default(this.g, this.f5606b, "complete Lynx bridge  IBridgeMethod success", this.d, "bdlynxbridge", this.e, false, 0, null, 160, null);
        return;
    L5:
        e = move-exception;
        com.bytedance.ies.bullet.service.base.b.g("onComplete", "XLynxKit", e);
        goto L7
    }

    @Override // sc.a
    public final void onError(int r20, String r21) {
        Intrinsics.checkNotNullParameter(r21, "message");
        com.bytedance.ies.bullet.core.kit.bridge.c r5 = this.f5605a;
        r5.getClass();
        r5.e = System.currentTimeMillis();
        JavaOnlyMap r10 = new JavaOnlyMap();
        r10.putInt("code", r20);
        r10.putString("message", r21);
        this.f5607c.invoke(new Object[]{r10});
        r5.f = System.currentTimeMillis();
        r5.g = System.currentTimeMillis();
        LynxBridgeModule r11 = this.g;
        String r12 = this.f5606b;
        LynxBridgeModule.access$onReady(r11, r5, r12);
        LynxView r13 = this.f;
        if (r13 == null) goto L5;
        com.bytedance.android.monitorV2.lynx.d r14 = com.bytedance.android.monitorV2.lynx.d.f3638a;
        x4.f r15 = new x4.f();
        r15.d = r12;
        r15.f22969b = 4;
        r15.f22970c = r11.composeErrorMessage(r21, r20);
        Unit r16 = Unit.INSTANCE;
        r14.getClass();
        com.bytedance.android.monitorV2.lynx.d.h(r13, r15);
    L5:
        String r18 = r11.composeErrorMessage(r21, r20);
        long r17 = this.d;
        int r19 = this.e;
        LynxBridgeModule.access$doMonitorLog(this.g, this.f5606b, "complete lynx bridge  IBridgeMethod failed", r17, "bdlynxbridge", r19, false, 4, r18);
    }
}
