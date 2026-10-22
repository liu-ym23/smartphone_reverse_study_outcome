package com.ss.android.lark.chameleonv2.lkapi.manifest;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B'\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0016\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J<\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\nHÖ\u0001R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$Ipc$ManifestUpdateDetail;", "T", "Ljava/io/Serializable;", "Lcom/bytedance/ee/util/io/NonProguard;", Keys.API_RETURN_KEY_DATA, "moduleType", "Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$Ipc$ModuleType;", "needVerifyUserId", BuildConfig.FLAVOR, "userId", BuildConfig.FLAVOR, "<init>", "(Ljava/io/Serializable;Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$Ipc$ModuleType;ZLjava/lang/String;)V", "getData", "()Ljava/io/Serializable;", "Ljava/io/Serializable;", "getModuleType", "()Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$Ipc$ModuleType;", "getNeedVerifyUserId", "()Z", "getUserId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/io/Serializable;Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$Ipc$ModuleType;ZLjava/lang/String;)Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$Ipc$ManifestUpdateDetail;", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IManifest$Ipc$ManifestUpdateDetail<T extends Serializable> implements NonProguard {
    private final T data;
    private final IManifest$Ipc$ModuleType moduleType;
    private final boolean needVerifyUserId;
    private final String userId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IManifest$Ipc$ManifestUpdateDetail copy$default(IManifest$Ipc$ManifestUpdateDetail r0, Serializable r1, IManifest$Ipc$ModuleType r2, boolean r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.data;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.moduleType;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.needVerifyUserId;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.userId;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final T component1() {
        return this.data;
    }

    public final IManifest$Ipc$ModuleType component2() {
        return this.moduleType;
    }

    public final boolean component3() {
        return this.needVerifyUserId;
    }

    public final String component4() {
        return this.userId;
    }

    public final IManifest$Ipc$ManifestUpdateDetail<T> copy(T r2, IManifest$Ipc$ModuleType r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, Keys.API_RETURN_KEY_DATA);
        Intrinsics.checkNotNullParameter(r3, "moduleType");
        Intrinsics.checkNotNullParameter(r5, "userId");
        return new IManifest$Ipc$ManifestUpdateDetail(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IManifest$Ipc$ManifestUpdateDetail) == true) goto L8;
        return false;
    L8:
        IManifest$Ipc$ManifestUpdateDetail r6 = (IManifest$Ipc$ManifestUpdateDetail) r5;
        if (Intrinsics.areEqual(this.data, r6.data) == true) goto L12;
        return false;
    L12:
        if (this.moduleType == r6.moduleType) goto L15;
        return false;
    L15:
        if (this.needVerifyUserId == r6.needVerifyUserId) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.userId, r6.userId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.data.hashCode() * 31) + this.moduleType.hashCode()) * 31;
        if (this.needVerifyUserId == false) goto L5;
        int r1 = 1231;
    L7:
        return ((r0 + r1) * 31) + this.userId.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public String toString() {
        return "ManifestUpdateDetail(data=" + this.data + ", moduleType=" + this.moduleType + ", needVerifyUserId=" + this.needVerifyUserId + ", userId=" + this.userId + ')';
    }

    public final T getData() {
        return this.data;
    }

    public final IManifest$Ipc$ModuleType getModuleType() {
        return this.moduleType;
    }

    public final boolean getNeedVerifyUserId() {
        return this.needVerifyUserId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public IManifest$Ipc$ManifestUpdateDetail(T r2, IManifest$Ipc$ModuleType r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, Keys.API_RETURN_KEY_DATA);
        Intrinsics.checkNotNullParameter(r3, "moduleType");
        Intrinsics.checkNotNullParameter(r5, "userId");
        this.data = r2;
        this.moduleType = r3;
        this.needVerifyUserId = r4;
        this.userId = r5;
    }
}
