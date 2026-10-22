package com.bytedance.android.live.effect;

import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s implements com.bytedance.android.live.core.log.c {
    public final /* synthetic */ String[] a;

    public s(String[] r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.core.log.c
    public final String generate() {
        return "effect extra list:" + Arrays.toString(this.a);
    }
}
