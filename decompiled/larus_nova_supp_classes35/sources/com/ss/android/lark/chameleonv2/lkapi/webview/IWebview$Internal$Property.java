package com.ss.android.lark.chameleonv2.lkapi.webview;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$Internal$Property;", "Lcom/bytedance/ee/util/io/NonProguard;", "visibilityState", "Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$VisibilityState;", "<init>", "(Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$VisibilityState;)V", "getVisibilityState", "()Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$VisibilityState;", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IWebview$Internal$Property implements NonProguard {
    private final IWebview$VisibilityState visibilityState;

    public static /* synthetic */ IWebview$Internal$Property copy$default(IWebview$Internal$Property r0, IWebview$VisibilityState r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.visibilityState;
    L6:
        return r0.copy(r1);
    }

    public final IWebview$VisibilityState component1() {
        return this.visibilityState;
    }

    public final IWebview$Internal$Property copy(IWebview$VisibilityState r2) {
        Intrinsics.checkNotNullParameter(r2, "visibilityState");
        return new IWebview$Internal$Property(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof IWebview$Internal$Property) == true) goto L9;
        return false;
    L9:
        if (this.visibilityState == ((IWebview$Internal$Property) r4).visibilityState) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.visibilityState.hashCode();
    }

    public String toString() {
        return "Property(visibilityState=" + this.visibilityState + ')';
    }

    public final IWebview$VisibilityState getVisibilityState() {
        return this.visibilityState;
    }

    public IWebview$Internal$Property(IWebview$VisibilityState r2) {
        Intrinsics.checkNotNullParameter(r2, "visibilityState");
        this.visibilityState = r2;
    }
}
