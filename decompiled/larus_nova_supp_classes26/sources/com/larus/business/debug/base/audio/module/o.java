package com.larus.business.debug.base.audio.module;

import java.io.File;
import java.io.FileFilter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class o implements FileFilter {
    public /* synthetic */ o() {
    }

    @Override // java.io.FileFilter
    public final boolean accept(File r2) {
        Intrinsics.checkNotNullParameter(r2, "pathname");
        return r2.isFile();
    }
}
