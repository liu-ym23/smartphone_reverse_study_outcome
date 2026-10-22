package kvb;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ8\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0019J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR \u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmUserGuideResponse;", "", "openFeature", "", "hasOwnerMM", "guideList", "", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;[Ljava/lang/String;)V", "getOpenFeature", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHasOwnerMM", "getGuideList", "()[Ljava/lang/String;", "[Ljava/lang/String;", "equals", "other", "hashCode", "", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;[Ljava/lang/String;)Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmUserGuideResponse;", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class a {

    @SerializedName("guide_list")
    private final String[] guideList;

    @SerializedName("has_owner_mm")
    private final Boolean hasOwnerMM;

    @SerializedName("open_feature")
    private final Boolean openFeature;

    public final String toString() {
        return "MmUserGuideResponse(openFeature=" + this.openFeature + ", hasOwnerMM=" + this.hasOwnerMM + ", guideList=" + Arrays.toString(this.guideList) + ')';
    }

    public final int hashCode() {
        Boolean r0 = this.openFeature;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.hasOwnerMM;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String[] r7 = this.guideList;
        if (r7 == null) goto L14;
        r1 = Arrays.hashCode(r7);
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public a() {
        this.openFeature = null;
        this.hasOwnerMM = null;
        this.guideList = null;
    }

    public final String[] a() {
        return this.guideList;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(a.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmUserGuideResponse");
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.openFeature, r6.openFeature) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.hasOwnerMM, r6.hasOwnerMM) == true) goto L18;
        return false;
    L18:
        String[] r1 = this.guideList;
        if (r1 == null) goto L27;
        String[] r7 = r6.guideList;
        if (r7 != null) goto L24;
        return false;
    L24:
        if (Arrays.equals(r1, r7) == true) goto L29;
        return false;
    L29:
        return true;
    L27:
        if (r6.guideList == null) goto L29;
        return false;
    L8:
        r2 = null;
        goto L10
    }
}
