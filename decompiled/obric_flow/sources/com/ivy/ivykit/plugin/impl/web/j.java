package com.ivy.ivykit.plugin.impl.web;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends rl.a {
    public final String f;
    public final Bitmap g;

    public j(String r10, String r11, ol.d r12, ol.c r13, ol.e r14, ol.g r15, ol.f r16, Bitmap r17) {
        Intrinsics.checkNotNullParameter(r10, "bizId");
        Intrinsics.checkNotNullParameter(r11, "schema");
        super(r12, r13, r14, r15, r16);
        this.f = r10;
        this.g = r17;
    }
}
