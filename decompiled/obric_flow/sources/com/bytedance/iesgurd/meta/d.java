package com.bytedance.iesgurd.meta;

import java.io.File;
import java.io.FilenameFilter;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f6648a = null;

    static {
        f6648a = new d();
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r5, String r10) {
        return !StringsKt.k(r10, "--pending-delete");
    }
}
