package com.ss.android.lark.conditional.access.display;

import com.bytedance.lark.pb.security.v1.CustomDisplayConfig;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/conditional/access/display/CustomDisplayModel;", BuildConfig.FLAVOR, "config", "Lcom/bytedance/lark/pb/security/v1/CustomDisplayConfig;", "lastUpdateTime", BuildConfig.FLAVOR, "<init>", "(Lcom/bytedance/lark/pb/security/v1/CustomDisplayConfig;J)V", "()V", "getConfig", "()Lcom/bytedance/lark/pb/security/v1/CustomDisplayConfig;", "setConfig", "(Lcom/bytedance/lark/pb/security/v1/CustomDisplayConfig;)V", "getLastUpdateTime", "()J", "setLastUpdateTime", "(J)V", "configString", BuildConfig.FLAVOR, "getConfigString", "()Ljava/lang/String;", "setConfigString", "(Ljava/lang/String;)V", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomDisplayModel {
    private transient CustomDisplayConfig config;
    private String configString;
    private long lastUpdateTime;

    public CustomDisplayModel() {
        this(null, 0);
    }

    public final CustomDisplayConfig getConfig() {
        return this.config;
    }

    public final String getConfigString() {
        return this.configString;
    }

    public final long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public final void setConfig(CustomDisplayConfig r1) {
        this.config = r1;
    }

    public final void setConfigString(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.configString = r2;
    }

    public final void setLastUpdateTime(long r1) {
        this.lastUpdateTime = r1;
    }

    public CustomDisplayModel(CustomDisplayConfig r1, long r2) {
        this.config = r1;
        this.lastUpdateTime = r2;
        this.configString = BuildConfig.FLAVOR;
    }

    public /* synthetic */ CustomDisplayModel(CustomDisplayConfig r1, long r2, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r2 = 0;
    L8:
        this(r1, r2);
    }
}
