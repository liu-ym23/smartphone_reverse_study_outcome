package com.bytedance.android.live.effect.api;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v implements com.bytedance.android.live.core.log.c {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ boolean b;

    public v(boolean r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.live.core.log.c
    public final String generate() {
        return "notify commodity no filter status, hasCommodity: " + this.a + ", isNoFilterEnable: " + this.b;
    }
}
