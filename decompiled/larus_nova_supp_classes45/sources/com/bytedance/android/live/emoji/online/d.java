package com.bytedance.android.live.emoji.online;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements FilenameFilter {
    public final /* synthetic */ List a;

    public d(List r1) {
        this.a = r1;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r1, String r2) {
        return this.a.contains(r2);
    }
}
