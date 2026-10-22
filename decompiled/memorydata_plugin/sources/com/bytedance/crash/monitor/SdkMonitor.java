package com.bytedance.crash.monitor;

import android.text.TextUtils;
import com.bytedance.crash.util.Stack;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class SdkMonitor extends CrashListener {
    private String[] mPackageNames;
    private String[] mSoList;

    public SdkMonitor(String r1, String r2, long r3, String[] r5, String[] r6) {
        super(r1, r2, r3);
        this.mPackageNames = r5;
        this.mSoList = r6;
    }

    public JSONArray acceptJavaStack(StackTraceElement[] r1) {
        String[] r0 = this.mPackageNames;
        if (r0 == null) goto L8;
        if (r1 != null) goto L7;
        return null;
    L7:
        return Stack.getMatchLines(r1, r0);
    L8:
        return null;
    }

    public boolean acceptSoLit(String r5) {
        if (this.mSoList != null) goto L5;
    L14:
        return false;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L14;
        String[] r4 = this.mSoList;
        int r0 = r4.length;
        int r2 = 0;
    L8:
        if (r2 >= r0) goto L14;
        if (r5.contains(r4[r2]) == true) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        return true;
    }

    public String[] getPackageName() {
        return this.mPackageNames;
    }

    public String[] getSoList() {
        return this.mSoList;
    }

    public void setPackageName(String[] r1) {
        this.mPackageNames = r1;
    }

    public void setSoList(String[] r1) {
        this.mSoList = r1;
    }
}
