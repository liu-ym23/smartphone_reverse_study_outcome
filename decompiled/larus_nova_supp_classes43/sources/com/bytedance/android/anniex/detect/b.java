package com.bytedance.android.anniex.detect;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final SnapshotPipeline a;
    public final DetectionPipeline b;

    public b(SnapshotPipeline r10, DetectionPipeline r11) {
        Intrinsics.checkNotNullParameter(r10, "snapShotPipeline");
        Intrinsics.checkNotNullParameter(r11, "detectPipeline");
        this.a = r10;
        this.b = r11;
    }
}
