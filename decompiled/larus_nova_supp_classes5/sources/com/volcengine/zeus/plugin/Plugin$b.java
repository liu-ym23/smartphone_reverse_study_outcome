package com.volcengine.zeus.plugin;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class Plugin$b implements FileFilter {
    public Plugin$b() {
    }

    @Override // java.io.FileFilter
    public final boolean accept(File r2) {
        if (r2 != null) goto L4;
    L6:
        return false;
    L4:
        if (r2.getName().matches("^version-(\\d+)$") == false) goto L6;
        return true;
    }
}
