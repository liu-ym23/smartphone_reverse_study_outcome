package com.ss.android.lark.filedetail.impl.folder.manage.service;

import com.google.gson.annotations.SerializedName;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/service/ExtractPackageConfig;", BuildConfig.FLAVOR, "maxExtractSize", BuildConfig.FLAVOR, "supportedFormat", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "timeOut", BuildConfig.FLAVOR, "<init>", "(JLjava/util/List;I)V", "getMaxExtractSize", "()J", "getSupportedFormat", "()Ljava/util/List;", "getTimeOut", "()I", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtractPackageConfig {

    @SerializedName("size_upper_limit")
    private final long maxExtractSize;

    @SerializedName("format")
    private final List<String> supportedFormat;

    @SerializedName("timeoutS")
    private final int timeOut;

    public ExtractPackageConfig() {
        this(0, null, 0, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExtractPackageConfig copy$default(ExtractPackageConfig r0, long r1, List r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.maxExtractSize;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r0.supportedFormat;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r0.timeOut;
    L12:
        return r0.copy(r1, r3, r4);
    }

    public final long component1() {
        return this.maxExtractSize;
    }

    public final List<String> component2() {
        return this.supportedFormat;
    }

    public final int component3() {
        return this.timeOut;
    }

    public final ExtractPackageConfig copy(long r2, List<String> r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "supportedFormat");
        return new ExtractPackageConfig(r2, r4, r5);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ExtractPackageConfig) == true) goto L8;
        return false;
    L8:
        ExtractPackageConfig r9 = (ExtractPackageConfig) r8;
        if (this.maxExtractSize == r9.maxExtractSize) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.supportedFormat, r9.supportedFormat) == true) goto L15;
        return false;
    L15:
        if (this.timeOut == r9.timeOut) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        long r0 = this.maxExtractSize;
        return (((((int) (r0 ^ (r0 >>> 32))) * 31) + this.supportedFormat.hashCode()) * 31) + this.timeOut;
    }

    public String toString() {
        return "ExtractPackageConfig(maxExtractSize=" + this.maxExtractSize + ", supportedFormat=" + this.supportedFormat + ", timeOut=" + this.timeOut + ')';
    }

    public final long getMaxExtractSize() {
        return this.maxExtractSize;
    }

    public final List<String> getSupportedFormat() {
        return this.supportedFormat;
    }

    public final int getTimeOut() {
        return this.timeOut;
    }

    public ExtractPackageConfig(long r2, List<String> r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "supportedFormat");
        this.maxExtractSize = r2;
        this.supportedFormat = r4;
        this.timeOut = r5;
    }

    public /* synthetic */ ExtractPackageConfig(long r1, List r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = 1073741824;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = CollectionsKt.mutableListOf(new String[]{"zip", "rar"});
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = 30;
    L11:
        this(r1, r3, r4);
    }
}
