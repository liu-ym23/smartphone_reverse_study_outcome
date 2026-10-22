package com.bytedance.ies.bullet.lynx.impl;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements com.bytedance.ies.bullet.core.kit.bridge.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f5651c;

    public /* synthetic */ b(int r5, String r10, Object r11) {
        this.f5649a = r5;
        this.f5650b = r10;
        this.f5651c = r11;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.f
    public final String getName() {
        switch(this.f5649a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f5650b;
    L7:
        return this.f5650b;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.f
    public final Object getParams() {
        switch(this.f5649a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return (JSONObject) this.f5651c;
    L7:
        return this.f5651c;
    }
}
