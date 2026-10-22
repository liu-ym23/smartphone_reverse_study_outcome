package com.bytedance.android.alog;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class a implements FilenameFilter {
    public final /* synthetic */ Pattern a;
    public final /* synthetic */ Alog b;

    public a(Alog r1, Pattern r2) {
        this.b = r1;
        this.a = r2;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r1, String r2) {
        return this.a.matcher(r2).find();
    }
}
