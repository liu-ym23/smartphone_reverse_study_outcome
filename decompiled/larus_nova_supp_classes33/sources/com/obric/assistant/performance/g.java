package com.obric.assistant.performance;

import java.io.File;
import java.io.FileFilter;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class g implements FileFilter {
    public /* synthetic */ g() {
    }

    @Override // java.io.FileFilter
    public final boolean accept(File r5) {
        int r0 = ObricMemoryUploadServiceImpl.e;
        if (r5.isFile() == true) goto L5;
        return false;
    L5:
        if (StringsKt.endsWith$default(r5.getName(), ".zip", false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    }
}
