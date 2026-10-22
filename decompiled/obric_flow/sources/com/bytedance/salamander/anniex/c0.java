package com.bytedance.salamander.anniex;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ValidationAction f7250b;

    public c0(String r5, int r10, ValidationAction r11) {
        Intrinsics.checkNotNullParameter(r5, "field");
        Intrinsics.checkNotNullParameter(r11, "action");
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f7249a = r10;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        this.f7250b = r11;
    }
}
