package com.bytedance.android.anniex.lite.container;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a4.a f3249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v3.a f3250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AnnieXLiteContainer f3251c;

    public h(a4.a r5, v3.a r10, AnnieXLiteContainer r11) {
        Intrinsics.checkNotNullParameter(r5, "annieXContext");
        Intrinsics.checkNotNullParameter(r10, "originLifeCycle");
        Intrinsics.checkNotNullParameter(r11, "iContainer");
        this.f3249a = r5;
        this.f3250b = r10;
        this.f3251c = r11;
    }
}
