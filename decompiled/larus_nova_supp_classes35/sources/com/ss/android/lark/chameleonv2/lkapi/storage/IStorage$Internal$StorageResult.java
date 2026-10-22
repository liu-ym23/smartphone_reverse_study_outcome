package com.ss.android.lark.chameleonv2.lkapi.storage;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/storage/IStorage$Internal$StorageResult;", "Lcom/bytedance/ee/util/io/NonProguard;", "message", BuildConfig.FLAVOR, "status", "Lcom/ss/android/lark/chameleonv2/lkapi/storage/IStorage$Internal$StorageStatus;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/chameleonv2/lkapi/storage/IStorage$Internal$StorageStatus;)V", "getMessage", "()Ljava/lang/String;", "getStatus", "()Lcom/ss/android/lark/chameleonv2/lkapi/storage/IStorage$Internal$StorageStatus;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IStorage$Internal$StorageResult implements NonProguard {
    private final String message;
    private final IStorage$Internal$StorageStatus status;

    public static /* synthetic */ IStorage$Internal$StorageResult copy$default(IStorage$Internal$StorageResult r0, String r1, IStorage$Internal$StorageStatus r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.message;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.status;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.message;
    }

    public final IStorage$Internal$StorageStatus component2() {
        return this.status;
    }

    public final IStorage$Internal$StorageResult copy(String r2, IStorage$Internal$StorageStatus r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "status");
        return new IStorage$Internal$StorageResult(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IStorage$Internal$StorageResult) == true) goto L8;
        return false;
    L8:
        IStorage$Internal$StorageResult r6 = (IStorage$Internal$StorageResult) r5;
        if (Intrinsics.areEqual(this.message, r6.message) == true) goto L12;
        return false;
    L12:
        if (this.status == r6.status) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.message.hashCode() * 31) + this.status.hashCode();
    }

    public String toString() {
        return "StorageResult(message=" + this.message + ", status=" + this.status + ')';
    }

    public final String getMessage() {
        return this.message;
    }

    public final IStorage$Internal$StorageStatus getStatus() {
        return this.status;
    }

    public IStorage$Internal$StorageResult(String r2, IStorage$Internal$StorageStatus r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "status");
        this.message = r2;
        this.status = r3;
    }
}
