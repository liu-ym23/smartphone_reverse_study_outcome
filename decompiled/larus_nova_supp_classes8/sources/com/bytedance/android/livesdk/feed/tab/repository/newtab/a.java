package com.bytedance.android.livesdk.feed.tab.repository.newtab;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements xw1.b {
    public final String a;

    @Override // xw1.b
    public final String a() {
        return "new_extra_key_" + this.a;
    }

    @Override // xw1.b
    public final String b() {
        return "new_tab_key_" + this.a;
    }

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "entrace");
        this.a = r2;
    }
}
