package com.bytedance.android.live.incentive.exchange;

import android.content.Context;
import com.bytedance.android.live.recharge.model.ExchangeType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l {
    public final Context a;
    public final ExchangeType b;
    public final long c;
    public final zv0.e d;
    public final py.k e;
    public final Map<String, String> f;

    public final String toString() {
        return "{ diamond = " + this.c + ", type = " + this.b + " }";
    }

    public final Context getContext() {
        return this.a;
    }

    public final ExchangeType getType() {
        return this.b;
    }

    public /* synthetic */ l(Context r11, ExchangeType r12, long r13, zv0.e r14, py.k r15) {
        this(r11, r12, r13, r14, r15, null, null);
    }

    public l(Context r1, ExchangeType r2, long r3, zv0.e r5, py.k r6, Map<String, String> r7, Long r8) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r5, "listener");
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
