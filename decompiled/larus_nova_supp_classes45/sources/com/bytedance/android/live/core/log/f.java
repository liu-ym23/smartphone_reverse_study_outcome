package com.bytedance.android.live.core.log;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class f implements c {
    public final /* synthetic */ g a;
    public final /* synthetic */ String b;
    public final /* synthetic */ JSONObject c;

    public /* synthetic */ f(g r1, String r2, JSONObject r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // com.bytedance.android.live.core.log.c
    public final String generate() {
        return this.a.g(this.b, this.c);
    }
}
