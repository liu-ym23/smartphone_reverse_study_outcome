package com.bytedance.sdk.xbridge.cn.platform.lynx;

import com.lynx.react.bridge.JavaOnlyMap;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends com.bytedance.sdk.xbridge.cn.protocol.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ym.g f7380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f7381b;

    public k() {
        this.f7380a = new ym.g();
        this.f7381b = "";
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.d
    public final com.bytedance.sdk.xbridge.cn.protocol.g a() {
        return this.f7380a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.d
    public final Object b(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "message");
        String r11 = this.f7381b;
        if (Intrinsics.areEqual(r11, "webcast") == false) goto L5;
        boolean r12 = true;
    L7:
        if (r12 == false) goto L10;
        HashMap r13 = new HashMap();
        r13.put("__msg_type", "callback");
        r13.put("eventId", 0);
        r13.put("__callback_id", "0");
        r13.put("code", Integer.valueOf(r5));
        JavaOnlyMap r14 = new JavaOnlyMap();
        r14.put("msg", r10);
        Unit r15 = Unit.INSTANCE;
        r13.put("data", r14);
        return new JavaOnlyMap(r13);
    L10:
        HashMap r16 = new HashMap();
        r16.put("code", Integer.valueOf(r5));
        r16.put("msg", r10);
        return new JavaOnlyMap(r16);
    L5:
        r12 = Intrinsics.areEqual(r11, "host");
        goto L7
    }
}
