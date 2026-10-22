package com.bytedance.ai.bridge.method.net.download;

import com.bytedance.retrofit2.Call;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class e implements Function0 {
    public final /* synthetic */ a.b a;
    public final /* synthetic */ Call b;

    public /* synthetic */ e(a.b r1, Call r10) {
        this.a = r1;
        this.b = r10;
    }

    public final Object invoke() {
        final a.b r0 = this.a;
        final Call r1 = this.b;
        return Boolean.valueOf(((Boolean) r0.l.a(new i(r0, r1))).booleanValue());
    }
}
