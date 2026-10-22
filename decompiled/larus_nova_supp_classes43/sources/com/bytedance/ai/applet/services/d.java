package com.bytedance.ai.applet.services;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public final String a;
    public final String b;
    public final int c;
    public final int d;

    public d(String r10, String r11, String r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "snapshotId");
        Intrinsics.checkNotNullParameter(r11, "mimeType");
        Intrinsics.checkNotNullParameter(r12, "imageBase64");
        this.a = r11;
        this.b = r12;
        this.c = r13;
        this.d = r14;
    }
}
