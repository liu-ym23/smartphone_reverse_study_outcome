package com.bytedance.ai.bridge.method.system.location;

import com.bytedance.ai.event.MessageIndication;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import r4.m;
import r4.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements m {
    public final /* synthetic */ LocationUpdateManager a;

    public g(LocationUpdateManager r1) {
        this.a = r1;
    }

    @Override // r4.m
    public final void a(n r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_RESULT);
        LocationUpdateManager r0 = this.a;
        Object r1 = r0.c;
        monitor-enter(r1);
    L42:
        th = move-exception;
        throw th;
    L5:
        if (r0.d != LocationUpdateManager.UpdateState.STARTED) goto L9;
        if (r0.f == true) goto L9;
        boolean r11 = true;
    L10:
        monitor-exit(r1);
        if (r11 == false) goto L48;
        e3.d r12 = r0.a.get();
        if (r12 == null) goto L47;
        JsonObject r13 = new JsonObject();
        Double r14 = r10.a;
        if (r14 == null) goto L18;
        r13.addProperty("latitude", Double.valueOf(r14.doubleValue()));
    L18:
        Double r15 = r10.b;
        if (r15 == null) goto L21;
        r13.addProperty("longitude", Double.valueOf(r15.doubleValue()));
    L21:
        Float r16 = r10.c;
        if (r16 == null) goto L24;
        r13.addProperty("speed", Float.valueOf(r16.floatValue()));
    L24:
        Float r17 = r10.d;
        if (r17 == null) goto L27;
        r13.addProperty("accuracy", Float.valueOf(r17.floatValue()));
    L27:
        Double r18 = r10.e;
        if (r18 == null) goto L30;
        r13.addProperty("altitude", Double.valueOf(r18.doubleValue()));
    L30:
        Float r19 = r10.f;
        float r20 = 0.0f;
        if (r19 == null) goto L33;
        float r21 = r19.floatValue();
    L34:
        r13.addProperty("verticalAccuracy", Float.valueOf(r21));
        Float r22 = r10.g;
        if (r22 == null) goto L37;
        r20 = r22.floatValue();
    L37:
        r13.addProperty("horizontalAccuracy", Float.valueOf(r20));
        String r23 = r10.h;
        if (r23 == null) goto L40;
        r13.addProperty("city", r23);
    L40:
        Unit r24 = Unit.INSTANCE;
        r12.a("doubao.onLocationChange", r13);
        return;
    L33:
        r21 = 0.0f;
        goto L34
    L47:
        return;
    L48:
        return;
    L9:
        r11 = false;
        goto L10
    }

    @Override // r4.m
    public final void b(String r10) {
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        LocationUpdateManager r0 = this.a;
        Object r1 = r0.c;
        monitor-enter(r1);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (r0.d != LocationUpdateManager.UpdateState.STARTED) goto L9;
        if (r0.f == true) goto L9;
        boolean r11 = true;
    L10:
        monitor-exit(r1);
        if (r11 == false) goto L23;
        e3.d r12 = r0.a.get();
        if (r12 == null) goto L22;
        int r13 = LocationAuthorization.a;
        r12.a("doubao.onLocationChangeError", LocationAuthorization.b(r10, 0));
        return;
    L22:
        return;
    L23:
        return;
    L9:
        r11 = false;
        goto L10
    }
}
