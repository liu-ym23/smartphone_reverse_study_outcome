package com.ss.android.lark.chameleonv2.lkapi.webview;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$Internal$WebviewState;", "Lcom/bytedance/ee/util/io/NonProguard;", "visibilityState", "Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$VisibilityState;", "status", "Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$Status;", "<init>", "(Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$VisibilityState;Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$Status;)V", "getVisibilityState", "()Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$VisibilityState;", "getStatus", "()Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$Status;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IWebview$Internal$WebviewState implements NonProguard {
    private final IWebview$Status status;
    private final IWebview$VisibilityState visibilityState;

    public static /* synthetic */ IWebview$Internal$WebviewState copy$default(IWebview$Internal$WebviewState r0, IWebview$VisibilityState r1, IWebview$Status r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.visibilityState;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.status;
    L9:
        return r0.copy(r1, r2);
    }

    public final IWebview$VisibilityState component1() {
        return this.visibilityState;
    }

    public final IWebview$Status component2() {
        return this.status;
    }

    public final IWebview$Internal$WebviewState copy(IWebview$VisibilityState r2, IWebview$Status r3) {
        Intrinsics.checkNotNullParameter(r2, "visibilityState");
        Intrinsics.checkNotNullParameter(r3, "status");
        return new IWebview$Internal$WebviewState(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IWebview$Internal$WebviewState) == true) goto L8;
        return false;
    L8:
        IWebview$Internal$WebviewState r6 = (IWebview$Internal$WebviewState) r5;
        if (this.visibilityState == r6.visibilityState) goto L12;
        return false;
    L12:
        if (this.status == r6.status) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.visibilityState.hashCode() * 31) + this.status.hashCode();
    }

    public String toString() {
        return "WebviewState(visibilityState=" + this.visibilityState + ", status=" + this.status + ')';
    }

    public final IWebview$Status getStatus() {
        return this.status;
    }

    public final IWebview$VisibilityState getVisibilityState() {
        return this.visibilityState;
    }

    public IWebview$Internal$WebviewState(IWebview$VisibilityState r2, IWebview$Status r3) {
        Intrinsics.checkNotNullParameter(r2, "visibilityState");
        Intrinsics.checkNotNullParameter(r3, "status");
        this.visibilityState = r2;
        this.status = r3;
    }
}
