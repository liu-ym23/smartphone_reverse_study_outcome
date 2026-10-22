package com.ss.android.lark.chameleonv2.lkapi.webview;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\fJ*\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$Ipc$RouterStateChangeEvent;", "T", "Ljava/io/Serializable;", "Lcom/bytedance/ee/util/io/NonProguard;", "path", BuildConfig.FLAVOR, "params", "<init>", "(Ljava/lang/String;Ljava/io/Serializable;)V", "getPath", "()Ljava/lang/String;", "getParams", "()Ljava/io/Serializable;", "Ljava/io/Serializable;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/io/Serializable;)Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$Ipc$RouterStateChangeEvent;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IWebview$Ipc$RouterStateChangeEvent<T extends Serializable> implements NonProguard {
    private final T params;
    private final String path;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IWebview$Ipc$RouterStateChangeEvent copy$default(IWebview$Ipc$RouterStateChangeEvent r0, String r1, Serializable r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.path;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.params;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.path;
    }

    public final T component2() {
        return this.params;
    }

    public final IWebview$Ipc$RouterStateChangeEvent<T> copy(String r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "path");
        return new IWebview$Ipc$RouterStateChangeEvent(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IWebview$Ipc$RouterStateChangeEvent) == true) goto L8;
        return false;
    L8:
        IWebview$Ipc$RouterStateChangeEvent r6 = (IWebview$Ipc$RouterStateChangeEvent) r5;
        if (Intrinsics.areEqual(this.path, r6.path) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.params, r6.params) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.path.hashCode() * 31;
        T r1 = this.params;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "RouterStateChangeEvent(path=" + this.path + ", params=" + this.params + ')';
    }

    public final T getParams() {
        return this.params;
    }

    public final String getPath() {
        return this.path;
    }

    public IWebview$Ipc$RouterStateChangeEvent(String r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "path");
        this.path = r2;
        this.params = r3;
    }
}
