package com.bytedance.android.live.broadcast.rts;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final Map<String, Object> g;
    public final Function0<Unit> h;
    public final Function2<? super String, ? super Map<String, String>, Unit> i;

    public d(String r2, String r3, String r4, String r5, String r6, String r7, Map<String, Object> r8, Function0<Unit> r9, Function2<? super String, ? super Map<String, String>, Unit> r11) {
        Intrinsics.checkNotNullParameter(r2, "anchorId");
        Intrinsics.checkNotNullParameter(r3, "roomId");
        Intrinsics.checkNotNullParameter(r5, "source");
        Intrinsics.checkNotNullParameter(r6, "webcastSDKVersion");
        Intrinsics.checkNotNullParameter(r9, "closePanel");
        Intrinsics.checkNotNullParameter(r11, "trackEvent");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r11;
    }
}
