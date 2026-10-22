package com.bytedance.crash.dumper;

import java.io.File;
import java.io.FilenameFilter;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class h implements FilenameFilter {
    public final /* synthetic */ JSONObject a;

    public h(JSONObject r1) {
        this.a = r1;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r2, String r3) {
        if (r3.contains("evil_trace") == false) goto L10;
        this.a.put("has_evil_trace_file", String.valueOf(true));     // Catch: Throwable -> L7
        return false;
    L10:
        return false;
    L11:
        return false;
    }
}
