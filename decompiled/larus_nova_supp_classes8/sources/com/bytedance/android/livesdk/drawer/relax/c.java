package com.bytedance.android.livesdk.drawer.relax;

import android.content.Context;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public final ArrayList<com.bytedance.android.livesdk.feed.feed.e> a;
    public final d b;
    public final j0 c;
    public final Context d;
    public final f e;
    public final Map<String, Object> f;

    public final Context getContext() {
        return this.d;
    }

    public c(ArrayList<com.bytedance.android.livesdk.feed.feed.e> r2, d r3, j0 r4, Context r5, f r6, Map<String, Object> r7) {
        Intrinsics.checkNotNullParameter(r2, "tabList");
        Intrinsics.checkNotNullParameter(r3, "businessContext");
        Intrinsics.checkNotNullParameter(r4, "settings");
        Intrinsics.checkNotNullParameter(r7, "trackContext");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
