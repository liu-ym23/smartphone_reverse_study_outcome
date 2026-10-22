package com.ss.android.lark.chameleonv2.lkapi.log;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/log/ILog$Internal$LogRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "level", BuildConfig.FLAVOR, "logModule", BuildConfig.FLAVOR, "message", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getLevel", "()I", "getLogModule", "()Ljava/lang/String;", "getMessage", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ILog$Internal$LogRequest implements NonProguard {
    private final int level;
    private final String logModule;
    private final String message;

    public static /* synthetic */ ILog$Internal$LogRequest copy$default(ILog$Internal$LogRequest r0, int r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.level;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.logModule;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.message;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.level;
    }

    public final String component2() {
        return this.logModule;
    }

    public final String component3() {
        return this.message;
    }

    public final ILog$Internal$LogRequest copy(int r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        return new ILog$Internal$LogRequest(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ILog$Internal$LogRequest) == true) goto L8;
        return false;
    L8:
        ILog$Internal$LogRequest r6 = (ILog$Internal$LogRequest) r5;
        if (this.level == r6.level) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.logModule, r6.logModule) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.message, r6.message) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.level * 31;
        String r1 = this.logModule;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.message.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "LogRequest(level=" + this.level + ", logModule=" + this.logModule + ", message=" + this.message + ')';
    }

    public final int getLevel() {
        return this.level;
    }

    public final String getLogModule() {
        return this.logModule;
    }

    public final String getMessage() {
        return this.message;
    }

    public ILog$Internal$LogRequest(int r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        this.level = r2;
        this.logModule = r3;
        this.message = r4;
    }
}
