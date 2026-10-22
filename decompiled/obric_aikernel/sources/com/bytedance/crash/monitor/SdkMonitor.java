package com.bytedance.crash.monitor;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.crash.util.Stack;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class SdkMonitor extends CrashListener {
    private String[] mPackageNames;
    private String[] mSoList;

    public SdkMonitor(@NonNull String r10, @NonNull String r11, long r12, String[] r13, String[] r14) {
        super(r10, r11, r12);
        this.mPackageNames = r13;
        this.mSoList = r14;
    }

    public JSONArray acceptJavaStack(StackTraceElement[] r10) {
        String[] r11 = this.mPackageNames;
        if (r11 == null) goto L8;
        if (r10 != null) goto L7;
        return null;
    L7:
        return Stack.getMatchLines(r10, r11);
    L8:
        return null;
    }

    public boolean acceptSoLit(String r10) {
        if (this.mSoList != null) goto L5;
    L14:
        return false;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L14;
        String[] r11 = this.mSoList;
        int r12 = r11.length;
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L14;
        if (r10.contains(r11[r13]) == true) goto L11;
        r13 = r13 + 1;
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

    public void setPackageName(String[] r10) {
        this.mPackageNames = r10;
    }

    public void setSoList(String[] r10) {
        this.mSoList = r10;
    }
}
