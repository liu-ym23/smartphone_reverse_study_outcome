package com.ss.android.lark.chameleonv2.lkapi.storage;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0001\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003JY\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0003\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!¨\u00061"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/storage/IStorage$Internal$CreateStorageRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "expireSeconds", BuildConfig.FLAVOR, "partition", BuildConfig.FLAVOR, "spaceTypeX", "storageFileTypeX", "userId", "valueMaxKb", "valueMaxPolicyX", "valueTotalMaxKb", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)V", "getExpireSeconds", "()I", "getPartition", "()Ljava/lang/String;", "getSpaceTypeX", "getStorageFileTypeX", "getUserId", "getValueMaxKb", "getValueMaxPolicyX", "getValueTotalMaxKb", "storageFileType", "Lcom/ss/android/lark/chameleonv2/lkapi/storage/IStorage$Internal$StorageFileType;", "getStorageFileType", "()Lcom/ss/android/lark/chameleonv2/lkapi/storage/IStorage$Internal$StorageFileType;", "spaceType", "getSpaceType", "valueMaxPolicy", "Lcom/ss/android/lark/chameleonv2/lkapi/storage/IStorage$Internal$ValueMaxPolicy;", "getValueMaxPolicy", "()Lcom/ss/android/lark/chameleonv2/lkapi/storage/IStorage$Internal$ValueMaxPolicy;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IStorage$Internal$CreateStorageRequest implements NonProguard {
    private final int expireSeconds;
    private final String partition;
    private final String spaceTypeX;
    private final String storageFileTypeX;
    private final String userId;
    private final int valueMaxKb;
    private final String valueMaxPolicyX;
    private final int valueTotalMaxKb;

    public static /* synthetic */ IStorage$Internal$CreateStorageRequest copy$default(IStorage$Internal$CreateStorageRequest r9, int r10, String r11, String r12, String r13, String r14, int r15, String r16, int r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        int r2 = r9.expireSeconds;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.partition;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.spaceTypeX;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.storageFileTypeX;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.userId;
    L23:
        if ((r18 & 32) == 0) goto L25;
        int r7 = r9.valueMaxKb;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = r9.valueMaxPolicyX;
    L31:
        if ((r18 & 128) == 0) goto L33;
        int r1 = r9.valueTotalMaxKb;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final int component1() {
        return this.expireSeconds;
    }

    public final String component2() {
        return this.partition;
    }

    public final String component3() {
        return this.spaceTypeX;
    }

    public final String component4() {
        return this.storageFileTypeX;
    }

    public final String component5() {
        return this.userId;
    }

    public final int component6() {
        return this.valueMaxKb;
    }

    public final String component7() {
        return this.valueMaxPolicyX;
    }

    public final int component8() {
        return this.valueTotalMaxKb;
    }

    public final IStorage$Internal$CreateStorageRequest copy(int r11, String r12, @JSONField(name = "spaceType") String r13, @JSONField(name = "storageFileType") String r14, String r15, int r16, @JSONField(name = "valueMaxPolicy") String r17, int r18) {
        Intrinsics.checkNotNullParameter(r12, "partition");
        Intrinsics.checkNotNullParameter(r13, "spaceTypeX");
        Intrinsics.checkNotNullParameter(r14, "storageFileTypeX");
        Intrinsics.checkNotNullParameter(r15, "userId");
        Intrinsics.checkNotNullParameter(r17, "valueMaxPolicyX");
        return new IStorage$Internal$CreateStorageRequest(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IStorage$Internal$CreateStorageRequest) == true) goto L8;
        return false;
    L8:
        IStorage$Internal$CreateStorageRequest r6 = (IStorage$Internal$CreateStorageRequest) r5;
        if (this.expireSeconds == r6.expireSeconds) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.partition, r6.partition) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.spaceTypeX, r6.spaceTypeX) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.storageFileTypeX, r6.storageFileTypeX) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.userId, r6.userId) == true) goto L24;
        return false;
    L24:
        if (this.valueMaxKb == r6.valueMaxKb) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.valueMaxPolicyX, r6.valueMaxPolicyX) == true) goto L30;
        return false;
    L30:
        if (this.valueTotalMaxKb == r6.valueTotalMaxKb) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        return (((((((((((((this.expireSeconds * 31) + this.partition.hashCode()) * 31) + this.spaceTypeX.hashCode()) * 31) + this.storageFileTypeX.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.valueMaxKb) * 31) + this.valueMaxPolicyX.hashCode()) * 31) + this.valueTotalMaxKb;
    }

    public String toString() {
        return "CreateStorageRequest(expireSeconds=" + this.expireSeconds + ", partition=" + this.partition + ", spaceTypeX=" + this.spaceTypeX + ", storageFileTypeX=" + this.storageFileTypeX + ", userId=" + this.userId + ", valueMaxKb=" + this.valueMaxKb + ", valueMaxPolicyX=" + this.valueMaxPolicyX + ", valueTotalMaxKb=" + this.valueTotalMaxKb + ')';
    }

    public final IStorage$Internal$StorageFileType getSpaceType() {
        IStorage$Internal$StorageFileType.a r0 = IStorage$Internal$StorageFileType.Companion;
        String r1 = this.spaceTypeX;
        r0.getClass();
        return IStorage$Internal$StorageFileType.a.a(r1);
    }

    public final IStorage$Internal$StorageFileType getStorageFileType() {
        IStorage$Internal$StorageFileType.a r0 = IStorage$Internal$StorageFileType.Companion;
        String r1 = this.storageFileTypeX;
        r0.getClass();
        return IStorage$Internal$StorageFileType.a.a(r1);
    }

    public final IStorage$Internal$ValueMaxPolicy getValueMaxPolicy() {
        IStorage$Internal$ValueMaxPolicy.a r0 = IStorage$Internal$ValueMaxPolicy.Companion;
        String r1 = this.valueMaxPolicyX;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "value");
        IStorage$Internal$ValueMaxPolicy[] r2 = IStorage$Internal$ValueMaxPolicy.values();
        int r3 = r2.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L8;
        IStorage$Internal$ValueMaxPolicy r5 = r2[r4];
        if (Intrinsics.areEqual(r5.getValue(), r1) == true) goto L9;
        r4 = r4 + 1;
    L9:
        if (r5 == null) goto L12;
        return r5;
    L12:
        return IStorage$Internal$ValueMaxPolicy.Noeviction;
    L8:
        r5 = null;
        goto L9
    }

    public final int getExpireSeconds() {
        return this.expireSeconds;
    }

    public final String getPartition() {
        return this.partition;
    }

    public final String getSpaceTypeX() {
        return this.spaceTypeX;
    }

    public final String getStorageFileTypeX() {
        return this.storageFileTypeX;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final int getValueMaxKb() {
        return this.valueMaxKb;
    }

    public final String getValueMaxPolicyX() {
        return this.valueMaxPolicyX;
    }

    public final int getValueTotalMaxKb() {
        return this.valueTotalMaxKb;
    }

    public IStorage$Internal$CreateStorageRequest(int r2, String r3, @JSONField(name = "spaceType") String r4, @JSONField(name = "storageFileType") String r5, String r6, int r7, @JSONField(name = "valueMaxPolicy") String r8, int r9) {
        Intrinsics.checkNotNullParameter(r3, "partition");
        Intrinsics.checkNotNullParameter(r4, "spaceTypeX");
        Intrinsics.checkNotNullParameter(r5, "storageFileTypeX");
        Intrinsics.checkNotNullParameter(r6, "userId");
        Intrinsics.checkNotNullParameter(r8, "valueMaxPolicyX");
        this.expireSeconds = r2;
        this.partition = r3;
        this.spaceTypeX = r4;
        this.storageFileTypeX = r5;
        this.userId = r6;
        this.valueMaxKb = r7;
        this.valueMaxPolicyX = r8;
        this.valueTotalMaxKb = r9;
    }
}
