package com.obric.miniapp.calendar.proxy.function;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000e\u001a\u00020\u0003H\u0016J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/obric/miniapp/calendar/proxy/function/AppletVersionInfo;", "", "packageName", "", "appId", "versionCode", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getPackageName", "()Ljava/lang/String;", "getAppId", "getVersionCode", "()J", "toString", "component1", "component2", "component3", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletVersionInfo {
    private final String appId;
    private final String packageName;
    private final long versionCode;

    public static /* synthetic */ AppletVersionInfo copy$default(AppletVersionInfo r0, String r1, String r2, long r3, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.packageName;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.appId;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.versionCode;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.packageName;
    }

    public final String component2() {
        return this.appId;
    }

    public final long component3() {
        return this.versionCode;
    }

    public final AppletVersionInfo copy(String r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "packageName");
        Intrinsics.checkNotNullParameter(r3, "appId");
        return new AppletVersionInfo(r2, r3, r4);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof AppletVersionInfo) == true) goto L8;
        return false;
    L8:
        AppletVersionInfo r9 = (AppletVersionInfo) r8;
        if (Intrinsics.areEqual(this.packageName, r9.packageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appId, r9.appId) == true) goto L15;
        return false;
    L15:
        if (this.versionCode == r9.versionCode) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.packageName.hashCode() * 31) + this.appId.hashCode()) * 31;
        long r1 = this.versionCode;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public String toString() {
        return "AppletVersionInfo(packageName='" + this.packageName + "', appId='" + this.appId + "', versionCode=" + this.versionCode + ')';
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final long getVersionCode() {
        return this.versionCode;
    }

    public AppletVersionInfo(String r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "packageName");
        Intrinsics.checkNotNullParameter(r3, "appId");
        this.packageName = r2;
        this.appId = r3;
        this.versionCode = r4;
    }
}
