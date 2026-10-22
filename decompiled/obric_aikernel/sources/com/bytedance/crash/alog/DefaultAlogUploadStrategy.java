package com.bytedance.crash.alog;

import android.text.TextUtils;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.util.App;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DefaultAlogUploadStrategy implements IAlogUploadStrategy {
    private String mProcessName;

    public DefaultAlogUploadStrategy() {
    }

    public DefaultAlogUploadStrategy(String r10) {
        this.mProcessName = r10;
    }

    @Override // com.bytedance.crash.alog.IAlogUploadStrategy
    public List<String> getUploadAlogFiles(String r22, long r23) {
        ArrayList r10 = new ArrayList();
        if (TextUtils.isEmpty(r22) == false) goto L65;
        return r10;
    L65:
        File[] r11 = new File(r22).listFiles();     // Catch: Exception -> L62
        if (r11 != null) goto L9;
        return r10;
    L9:
        if (this.mProcessName != null) goto L12;
        this.mProcessName = App.getProcessName();     // Catch: Exception -> L62
    L12:
        if (this.mProcessName.contains(":") == true) goto L14;
        boolean r12 = true;
    L16:
        if (this.mProcessName.contains(":") == false) goto L18;
        String r13 = this.mProcessName.replace(":", "-");     // Catch: Exception -> L62
    L19:
        int r14 = r11.length;     // Catch: Exception -> L62
        File r15 = null;
        File r16 = null;
        int r17 = 0;
        long r18 = 0;
        long r19 = 0;
    L20:
        if (r17 >= r14) goto L53;
        File r110 = r11[r17];     // Catch: Exception -> L62
        String r20 = r110.getName();     // Catch: Exception -> L62
        if (r20.endsWith(".hot") == false) goto L52;
        if (r12 == true) goto L26;
    L27:
        if (r12 == true) goto L32;
        if (r110.getName().contains("-") == false) goto L52;
    L32:
        if (r20.contains(r13) == false) goto L52;
        String[] r21 = r20.split("_");     // Catch: Exception -> L62
        long r111 = -1;
        if (r21.length < 4) goto L38;
        r111 = Long.parseLong(r21[3]);     // Catch: Exception -> L62
    L42:
        if (r23 <= 0) goto L47;
        if (r111 > r23) goto L52;
    L47:
        if (r18 >= r111) goto L50;
        r15 = r16;
        r19 = r18;
        r16 = r110;
        r18 = r111;
        goto L52
    L50:
        if (r19 >= r111) goto L52;
        r15 = r110;
        r19 = r111;
        goto L52
    L38:
        if (r21.length <= 1) goto L42;
        r111 = Long.parseLong(r21[0]);     // Catch: Exception -> L62
        goto L42
    L26:
        if (r110.getName().contains("-") == false) goto L27;
    L52:
        r17 = r17 + 1;     // Catch: Exception -> L62
        goto L20
    L53:
        if (r15 != null) goto L55;
    L57:
        if (r16 != null) goto L59;
    L64:
        return r10;
    L59:
        if (r16.length() <= 0) goto L64;
        r10.add(r16.getAbsolutePath());     // Catch: Exception -> L62
        goto L64
    L55:
        if (r15.length() <= 0) goto L57;
        r10.add(r15.getAbsolutePath());     // Catch: Exception -> L62
        goto L57
    L18:
        r13 = this.mProcessName;     // Catch: Exception -> L62
        goto L19
    L14:
        r12 = false;
    L62:
        e = move-exception;
        NpthMonitor.reportInnerException(e);
        goto L64
    }
}
