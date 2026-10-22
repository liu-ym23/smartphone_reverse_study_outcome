package com.larus.settings.tutor;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/larus/settings/tutor/UploadALogConfigModel;", "", "enable", "", "times", "", "<init>", "(ZI)V", "getEnable", "()Z", "getTimes", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class UploadALogConfigModel {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("times")
    private final int times;

    /* JADX WARN: Multi-variable type inference failed */
    public UploadALogConfigModel() {
        boolean r2 = false;
        Object[] r3 = 0 == true ? 1 : 0;
        this(r2, r3, 3, null);
    }

    public static /* synthetic */ UploadALogConfigModel copy$default(UploadALogConfigModel r0, boolean r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.enable;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.times;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final int component2() {
        return this.times;
    }

    public final UploadALogConfigModel copy(boolean r2, int r3) {
        return new UploadALogConfigModel(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UploadALogConfigModel) == true) goto L8;
        return false;
    L8:
        UploadALogConfigModel r6 = (UploadALogConfigModel) r5;
        if (this.enable == r6.enable) goto L12;
        return false;
    L12:
        if (this.times == r6.times) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.enable == false) goto L5;
        int r0 = 1231;
    L7:
        return (r0 * 31) + this.times;
    L5:
        r0 = 1237;
        goto L7
    }

    public String toString() {
        return "UploadALogConfigModel(enable=" + this.enable + ", times=" + this.times + ')';
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final int getTimes() {
        return this.times;
    }

    public UploadALogConfigModel(boolean r1, int r2) {
        this.enable = r1;
        this.times = r2;
    }

    public /* synthetic */ UploadALogConfigModel(boolean r1, int r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = 5;
    L8:
        this(r1, r2);
    }
}
