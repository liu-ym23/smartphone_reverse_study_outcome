package com.ss.android.lark.framework.assembly.rust;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006 "}, d2 = {"Lcom/ss/android/lark/framework/assembly/rust/HttpProxyConfig;", "", "serverAddress", "", "port", "", "userName", "password", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getServerAddress", "()Ljava/lang/String;", "setServerAddress", "(Ljava/lang/String;)V", "getPort", "()I", "setPort", "(I)V", "getUserName", "setUserName", "getPassword", "setPassword", "component1", "component2", "component3", "component4", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "toString", "rust-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class HttpProxyConfig {
    private String password;
    private int port;
    private String serverAddress;
    private String userName;

    public static /* synthetic */ HttpProxyConfig copy$default(HttpProxyConfig r0, String r1, int r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.serverAddress;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.port;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.userName;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.password;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.serverAddress;
    }

    public final int component2() {
        return this.port;
    }

    public final String component3() {
        return this.userName;
    }

    public final String component4() {
        return this.password;
    }

    public final HttpProxyConfig copy(String r2, int r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "serverAddress");
        return new HttpProxyConfig(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof HttpProxyConfig) == true) goto L8;
        return false;
    L8:
        HttpProxyConfig r6 = (HttpProxyConfig) r5;
        if (Intrinsics.areEqual(this.serverAddress, r6.serverAddress) == true) goto L12;
        return false;
    L12:
        if (this.port == r6.port) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.userName, r6.userName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.password, r6.password) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.serverAddress.hashCode() * 31) + this.port) * 31;
        String r1 = this.userName;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.password;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "HttpProxyConfig(serverAddress=" + this.serverAddress + ", port=" + this.port + ", userName=" + this.userName + ", password=" + this.password + ')';
    }

    public final String getPassword() {
        return this.password;
    }

    public final int getPort() {
        return this.port;
    }

    public final String getServerAddress() {
        return this.serverAddress;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final void setPassword(String r1) {
        this.password = r1;
    }

    public final void setPort(int r1) {
        this.port = r1;
    }

    public final void setServerAddress(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.serverAddress = r2;
    }

    public final void setUserName(String r1) {
        this.userName = r1;
    }

    public HttpProxyConfig(String r2, int r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "serverAddress");
        this.serverAddress = r2;
        this.port = r3;
        this.userName = r4;
        this.password = r5;
    }
}
