package com.ss.android.lark.filedetail.util;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sfb.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@AppConfig(key = "download_path_config")
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/filedetail/util/DownloadPathConfig;", BuildConfig.FLAVOR, "fixPathDevices", BuildConfig.FLAVOR, "Lcom/ss/android/lark/filedetail/util/DeviceProp;", "<init>", "(Ljava/util/List;)V", "getFixPathDevices", "()Ljava/util/List;", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DownloadPathConfig {

    @SerializedName("fix_path_devices")
    private final List<a> fixPathDevices;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof DownloadPathConfig) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.fixPathDevices, ((DownloadPathConfig) r4).fixPathDevices) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        List<a> r0 = this.fixPathDevices;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "DownloadPathConfig(fixPathDevices=" + this.fixPathDevices + ')';
    }

    public DownloadPathConfig() {
        this.fixPathDevices = null;
    }

    public final List<a> a() {
        return this.fixPathDevices;
    }
}
