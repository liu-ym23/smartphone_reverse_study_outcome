package com.ss.android.lark.keyboard.utils;

import com.bytedance.lark.pb.basic.v1.ResourceFile;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g {
    public final ResourceFile.FileType a;
    public final String b;
    public final f c;

    public final String toString() {
        return "FlowResourceUploadInfo(fileType=" + this.a + ", compressPath='" + this.b + "', imageInfo=" + this.c + ')';
    }

    public g(ResourceFile.FileType r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "fileType");
        Intrinsics.checkNotNullParameter(r3, "compressPath");
        this.a = r2;
        this.b = r3;
        this.c = null;
    }
}
