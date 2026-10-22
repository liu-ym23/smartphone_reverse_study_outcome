package com.bytedance.android.monitorV2.settings;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u000e\u001a\u0004\b\u0006\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/monitorV2/settings/c;", "", "<init>", "()V", "", "", "a", "[Ljava/lang/String;", "b", "()[Ljava/lang/String;", "setUrlBlockList", "([Ljava/lang/String;)V", "urlBlockList", "", "J", "()J", "setStayDuration", "(J)V", "stayDuration", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f3720c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("url_blocklist")
    private String[] f3721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("stay_duration")
    private long f3722b;

    static {
        f3720c = new c();
    }

    public c() {
        this.f3721a = new String[0];
        this.f3722b = 2000;
    }

    public final long a() {
        return this.f3722b;
    }

    public final String[] b() {
        return this.f3721a;
    }
}
