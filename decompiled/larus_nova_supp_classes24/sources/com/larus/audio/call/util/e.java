package com.larus.audio.call.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e implements com.larus.audio.call.j {
    public static final e a = null;
    public static final com.larus.audio.call.j b = null;

    public e() {
    }

    static {
        a = new e();
        b = com.larus.audio.call.f.c().l();
    }

    @Override // com.larus.audio.call.j
    public final void d(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        b.d("FlowAVKit_" + r4, r5);
    }

    @Override // com.larus.audio.call.j
    public final void e(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        b.e("FlowAVKit_" + r4, r5);
    }

    @Override // com.larus.audio.call.j
    public final void i(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        b.i("FlowAVKit_" + r4, r5);
    }

    @Override // com.larus.audio.call.j
    public final void v(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        b.v("FlowAVKit_" + r4, r5);
    }

    @Override // com.larus.audio.call.j
    public final void w(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        b.w("FlowAVKit_" + r4, r5);
    }

    @Override // com.larus.audio.call.j
    public final void e(String r4, String r5, Throwable r6) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        b.e("FlowAVKit_" + r4, r5, r6);
    }

    @Override // com.larus.audio.call.j
    public final void w(String r4, String r5, Throwable r6) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        b.w("FlowAVKit_" + r4, r5, r6);
    }
}
