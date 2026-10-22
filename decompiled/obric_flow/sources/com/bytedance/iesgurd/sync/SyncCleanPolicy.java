package com.bytedance.iesgurd.sync;

import androidx.annotation.Keep;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/iesgurd/sync/SyncCleanPolicy;", "", LynxMonitorService.KEY_CHANNEL, "", "cleanType", "", "versions", "", "", "(Ljava/lang/String;ILjava/util/List;)V", "getChannel", "()Ljava/lang/String;", "getCleanType", "()I", "getVersions", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
public final class SyncCleanPolicy {

    @SerializedName("c")
    private final String channel;

    @SerializedName("clean_type")
    private final int cleanType;

    @SerializedName("version")
    private final List<Long> versions;

    public SyncCleanPolicy(String r5, int r10, List<Long> r11) {
        this.channel = r5;
        this.cleanType = r10;
        this.versions = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SyncCleanPolicy copy$default(SyncCleanPolicy r5, String r10, int r11, List r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.channel;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.cleanType;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r5.versions;
    L12:
        return r5.copy(r10, r11, r12);
    }

    public final String component1() {
        return this.channel;
    }

    public final int component2() {
        return this.cleanType;
    }

    public final List<Long> component3() {
        return this.versions;
    }

    public final SyncCleanPolicy copy(String r5, int r10, List<Long> r11) {
        return new SyncCleanPolicy(r5, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof SyncCleanPolicy) == false) goto L12;
        SyncCleanPolicy r10 = (SyncCleanPolicy) r5;
        if (Intrinsics.areEqual(this.channel, r10.channel) == true) goto L8;
        return false;
    L8:
        if (this.cleanType == r10.cleanType) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.versions, r10.versions) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final int getCleanType() {
        return this.cleanType;
    }

    public final List<Long> getVersions() {
        return this.versions;
    }

    public int hashCode() {
        String r5 = this.channel;
        int r10 = 0;
        if (r5 == null) goto L5;
        int r11 = r5.hashCode();
    L6:
        int r12 = ((r11 * 31) + this.cleanType) * 31;
        List<Long> r13 = this.versions;
        if (r13 == null) goto L10;
        r10 = r13.hashCode();
    L10:
        return r12 + r10;
    L5:
        r11 = 0;
        goto L6
    }

    public String toString() {
        return "SyncCleanPolicy(channel=" + this.channel + ", cleanType=" + this.cleanType + ", versions=" + this.versions + ")";
    }
}
