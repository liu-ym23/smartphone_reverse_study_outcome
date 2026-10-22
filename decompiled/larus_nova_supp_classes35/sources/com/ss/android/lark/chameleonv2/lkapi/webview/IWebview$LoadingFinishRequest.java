package com.ss.android.lark.chameleonv2.lkapi.webview;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0006\u0010\u0013\u001a\u00020\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$LoadingFinishRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "status", BuildConfig.FLAVOR, "code", BuildConfig.FLAVOR, "showErrorPage", BuildConfig.FLAVOR, "errorMessage", "<init>", "(Ljava/lang/String;IZLjava/lang/String;)V", "getStatus", "()Ljava/lang/String;", "getCode", "()I", "getShowErrorPage", "()Z", "getErrorMessage", "toString", "getLogString", "component1", "component2", "component3", "component4", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IWebview$LoadingFinishRequest implements NonProguard {
    private final int code;
    private final String errorMessage;
    private final boolean showErrorPage;
    private final String status;

    public IWebview$LoadingFinishRequest() {
        this(null, 0, false, null, 15, null);
    }

    public static /* synthetic */ IWebview$LoadingFinishRequest copy$default(IWebview$LoadingFinishRequest r0, String r1, int r2, boolean r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.status;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.code;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.showErrorPage;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.errorMessage;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.status;
    }

    public final int component2() {
        return this.code;
    }

    public final boolean component3() {
        return this.showErrorPage;
    }

    public final String component4() {
        return this.errorMessage;
    }

    public final IWebview$LoadingFinishRequest copy(String r2, int r3, boolean r4, String r5) {
        return new IWebview$LoadingFinishRequest(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IWebview$LoadingFinishRequest) == true) goto L8;
        return false;
    L8:
        IWebview$LoadingFinishRequest r6 = (IWebview$LoadingFinishRequest) r5;
        if (Intrinsics.areEqual(this.status, r6.status) == true) goto L12;
        return false;
    L12:
        if (this.code == r6.code) goto L15;
        return false;
    L15:
        if (this.showErrorPage == r6.showErrorPage) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.errorMessage, r6.errorMessage) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.status;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.code) * 31;
        if (this.showErrorPage == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        String r6 = this.errorMessage;
        if (r6 == null) goto L15;
        r1 = r6.hashCode();
    L15:
        return r5 + r1;
    L9:
        r4 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "LoadingFinishParam(status=" + this.status + ", code=" + this.code + ", showErrorPage=" + this.showErrorPage + ", errorMessage=" + this.errorMessage + ')';
    }

    public final String getLogString() {
        return toString();
    }

    public final int getCode() {
        return this.code;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final boolean getShowErrorPage() {
        return this.showErrorPage;
    }

    public final String getStatus() {
        return this.status;
    }

    public IWebview$LoadingFinishRequest(String r1, int r2, boolean r3, String r4) {
        this.status = r1;
        this.code = r2;
        this.showErrorPage = r3;
        this.errorMessage = r4;
    }

    public /* synthetic */ IWebview$LoadingFinishRequest(String r3, int r4, boolean r5, String r6, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = false;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = null;
    L14:
        this(r3, r4, r5, r6);
    }
}
