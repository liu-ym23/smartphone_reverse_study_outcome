package com.bytedance.iesgurd.sync;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/iesgurd/sync/SyncCleanModel;", "", "specifiedClean", "", "Lcom/bytedance/iesgurd/sync/SyncCleanPolicy;", "(Ljava/util/List;)V", "getSpecifiedClean", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
public final class SyncCleanModel {

    @SerializedName("specified_clean")
    private final List<SyncCleanPolicy> specifiedClean;

    public SyncCleanModel(List<SyncCleanPolicy> r5) {
        this.specifiedClean = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SyncCleanModel copy$default(SyncCleanModel r5, List r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = r5.specifiedClean;
    L6:
        return r5.copy(r10);
    }

    public final List<SyncCleanPolicy> component1() {
        return this.specifiedClean;
    }

    public final SyncCleanModel copy(List<SyncCleanPolicy> r5) {
        return new SyncCleanModel(r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof SyncCleanModel) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.specifiedClean, ((SyncCleanModel) r5).specifiedClean) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final List<SyncCleanPolicy> getSpecifiedClean() {
        return this.specifiedClean;
    }

    public int hashCode() {
        List<SyncCleanPolicy> r5 = this.specifiedClean;
        if (r5 != null) goto L5;
        return 0;
    L5:
        return r5.hashCode();
    }

    public String toString() {
        return "SyncCleanModel(specifiedClean=" + this.specifiedClean + ")";
    }
}
