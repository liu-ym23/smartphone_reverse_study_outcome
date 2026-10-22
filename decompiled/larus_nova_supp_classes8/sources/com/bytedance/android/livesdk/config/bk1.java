package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/config/bk1;", "", "", "enable", "Z", "a", "()Z", "setEnable", "(Z)V", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class bk1 {
    public static final String d = null;
    public final String a;
    public final String b;
    public final String c;

    @SerializedName("enable")
    private boolean enable;

    public static final class a {
    }

    static {
        boolean r0 = tb1.c.a;
        d = "lf1-webcastcdn-tos.douyinstatic.com";
    }

    public bk1() {
        this.enable = true;
        StringBuilder r0 = new StringBuilder("https://");
        String r2 = d;
        r0.append(r2);
        r0.append("/obj/live-android/anchor_leave_tip.webp");
        this.a = r0.toString();
        this.b = "https://" + r2 + "/obj/live-android/link_toolbar_icon_matching_38px.webp";
        this.c = "https://" + r2 + "/obj/live-android/link_toolbar_icon_waiting_38px.webp";
    }

    public final boolean a() {
        return this.enable;
    }
}
