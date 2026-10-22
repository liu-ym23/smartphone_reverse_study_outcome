package com.bytedance.android.live.effect.api;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y implements com.bytedance.android.live.core.log.c {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ boolean b;

    public y(boolean r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.live.core.log.c
    public final String generate() {
        StringBuilder r0 = new StringBuilder("set value for commodity no filter mode: ");
        if (this.a == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        r0.append(r1);
        return r0.toString();
    L5:
        if (this.b == false) goto L7;
        r1 = true;
        goto L8
    }
}
