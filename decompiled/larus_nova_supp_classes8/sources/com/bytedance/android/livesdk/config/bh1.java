package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/config/bh1;", "", "", "permissionEnable", "Z", "a", "()Z", "setPermissionEnable", "(Z)V", "", "permissionScheme", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "permissionUrl", "c", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class bh1 {

    @SerializedName("permission_enable")
    private boolean permissionEnable;

    @SerializedName("permission_schema")
    private final String permissionScheme;

    @SerializedName("permission_url")
    private final String permissionUrl;

    public bh1() {
        this.permissionEnable = true;
    }

    public final boolean a() {
        return this.permissionEnable;
    }

    public final String b() {
        return this.permissionScheme;
    }

    public final String c() {
        return this.permissionUrl;
    }
}
