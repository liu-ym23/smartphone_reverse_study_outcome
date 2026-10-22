package com.bytedance.android.live.broadcastgame.opengame.message;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/message/PreUploadCheckBean;", "", "eTags", "", "", "(Ljava/util/List;)V", "getETags", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreUploadCheckBean {

    @SerializedName("etags")
    private final List<String> eTags;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PreUploadCheckBean copy$default(PreUploadCheckBean r0, List r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.eTags;
    L6:
        return r0.copy(r1);
    }

    public final List<String> component1() {
        return this.eTags;
    }

    public final PreUploadCheckBean copy(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "eTags");
        return new PreUploadCheckBean(r2);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof PreUploadCheckBean) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.eTags, ((PreUploadCheckBean) r2).eTags) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        List<String> r0 = this.eTags;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "PreUploadCheckBean(eTags=" + this.eTags + ")";
    }

    public final List<String> getETags() {
        return this.eTags;
    }

    public PreUploadCheckBean(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "eTags");
        this.eTags = r2;
    }
}
