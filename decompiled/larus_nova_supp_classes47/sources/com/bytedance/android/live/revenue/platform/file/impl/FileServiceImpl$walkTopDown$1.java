package com.bytedance.android.live.revenue.platform.file.impl;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Ljava/io/File;", "invoke"}, k = 3, mv = {1, 5, 1})
final class FileServiceImpl$walkTopDown$1 extends Lambda implements Function1<File, String> {
    public static final FileServiceImpl$walkTopDown$1 INSTANCE = null;

    static {
        INSTANCE = new FileServiceImpl$walkTopDown$1();
    }

    public FileServiceImpl$walkTopDown$1() {
        super(1);
    }

    public final String invoke(File r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return r2.getPath();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((File) r1);
    }
}
