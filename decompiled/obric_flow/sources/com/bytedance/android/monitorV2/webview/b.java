package com.bytedance.android.monitorV2.webview;

import ai.j0;
import java.util.Arrays;
import org.json.JSONObject;
import zm.z;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String[] f3747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String[] f3748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3749c;
    public String d;
    public String e;
    public z f;
    public JSONObject g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f3750h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f3751i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f3752j;

    public b() {
        this.f3749c = true;
        this.d = "";
        this.g = new JSONObject();
        this.f3750h = "";
        this.f3751i = "";
        this.f3752j = "";
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("Config{mWebViewClasses=");
        r5.append(Arrays.toString(this.f3747a));
        r5.append(", mWebViewObjKeys=");
        r5.append(Arrays.toString(this.f3748b));
        r5.append(", mIsNeedMonitor='");
        r5.append(this.f3749c);
        r5.append("', mIsNeedInjectBrowser='true', sourceMonitor='null', mBid='");
        return j0.q(r5, this.d, "', virtualAid='null'}");
    }
}
