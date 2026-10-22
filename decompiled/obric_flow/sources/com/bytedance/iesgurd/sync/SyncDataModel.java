package com.bytedance.iesgurd.sync;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/iesgurd/sync/SyncDataModel;", "", "checkUpdateInfo", "Lcom/bytedance/iesgurd/sync/SyncUpdateModel;", "cleanInfo", "", "", "Lcom/bytedance/iesgurd/sync/SyncCleanModel;", "(Lcom/bytedance/iesgurd/sync/SyncUpdateModel;Ljava/util/Map;)V", "getCheckUpdateInfo", "()Lcom/bytedance/iesgurd/sync/SyncUpdateModel;", "getCleanInfo", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
public final class SyncDataModel {

    @SerializedName("check_update_info")
    private final SyncUpdateModel checkUpdateInfo;

    @SerializedName("clean_info")
    private final Map<String, SyncCleanModel> cleanInfo;

    public SyncDataModel(SyncUpdateModel r5, Map<String, SyncCleanModel> r10) {
        this.checkUpdateInfo = r5;
        this.cleanInfo = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SyncDataModel copy$default(SyncDataModel r5, SyncUpdateModel r10, Map r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.checkUpdateInfo;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.cleanInfo;
    L9:
        return r5.copy(r10, r11);
    }

    public final SyncUpdateModel component1() {
        return this.checkUpdateInfo;
    }

    public final Map<String, SyncCleanModel> component2() {
        return this.cleanInfo;
    }

    public final SyncDataModel copy(SyncUpdateModel r5, Map<String, SyncCleanModel> r10) {
        return new SyncDataModel(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof SyncDataModel) == false) goto L10;
        SyncDataModel r10 = (SyncDataModel) r5;
        if (Intrinsics.areEqual(this.checkUpdateInfo, r10.checkUpdateInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.cleanInfo, r10.cleanInfo) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final SyncUpdateModel getCheckUpdateInfo() {
        return this.checkUpdateInfo;
    }

    public final Map<String, SyncCleanModel> getCleanInfo() {
        return this.cleanInfo;
    }

    public int hashCode() {
        SyncUpdateModel r5 = this.checkUpdateInfo;
        int r10 = 0;
        if (r5 == null) goto L5;
        int r11 = r5.hashCode();
    L6:
        int r12 = r11 * 31;
        Map<String, SyncCleanModel> r13 = this.cleanInfo;
        if (r13 == null) goto L10;
        r10 = r13.hashCode();
    L10:
        return r12 + r10;
    L5:
        r11 = 0;
        goto L6
    }

    public String toString() {
        return "SyncDataModel(checkUpdateInfo=" + this.checkUpdateInfo + ", cleanInfo=" + this.cleanInfo + ")";
    }
}
