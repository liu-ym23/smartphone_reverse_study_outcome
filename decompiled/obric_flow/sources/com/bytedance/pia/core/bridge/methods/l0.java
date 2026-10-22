package com.bytedance.pia.core.bridge.methods;

import com.bytedance.pia.core.plugins.PreloadPlugin;
import com.bytedance.pia.core.tracing.EventName;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class l0 implements fh.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7000b;

    public /* synthetic */ l0(Object r5, int r10) {
        this.f6999a = r10;
        this.f7000b = r5;
    }

    @Override // fh.a
    public final void accept(Object r10) {
        switch(this.f6999a) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        nh.d r5 = ((PreloadPlugin) this.f7000b).f20236b;
        com.google.common.reflect.w r11 = r5.f20247r;
        EventName r12 = EventName.f7098l;
        ((dh.b) r10).getClass();
        r11.getClass();
        com.bytedance.pia.core.tracing.d r13 = new com.bytedance.pia.core.tracing.d(r11, r12, 0);
        r13.d.put("url", null);
        r13.a();
        EventName r14 = EventName.f7099m;
        com.google.common.reflect.w r15 = r5.f20247r;
        r15.getClass();
        com.bytedance.pia.core.tracing.d r16 = new com.bytedance.pia.core.tracing.d(r15, r14, 0);
        r16.d.put("url", null);
        r16.a();
        return;
    L6:
        gh.c r17 = (gh.c) this.f7000b;
        r17.getClass();
        int r18 = 22;
        com.bytedance.pia.core.utils.m.b(new a2.b(r18, r17, (JsonObject) r10));
        return;
    L8:
        ((hh.a) this.f7000b).a((JsonObject) r10);
        return;
    L10:
        p0 r19 = new p0((JsonObject) r10);
        ((gh.b) this.f7000b).accept(r19);
    }
}
