package com.obric.memorydata.intelligence.api;

import com.bytedance.crash.entity.EventBody;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB\u001f\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\fJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J>\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0014¨\u0006 "}, d2 = {"Lcom/obric/memorydata/intelligence/api/UserProfileLabelQueryBean;", "", EventBody.KEY_VALUE, "", "", "confidence", "", "radiusM", "isOfficialHome", "", "<init>", "(Ljava/util/List;DLjava/lang/Double;Z)V", "(Ljava/util/List;D)V", "getValue", "()Ljava/util/List;", "getConfidence", "()D", "getRadiusM", "()Ljava/lang/Double;", "Ljava/lang/Double;", "()Z", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;DLjava/lang/Double;Z)Lcom/obric/memorydata/intelligence/api/UserProfileLabelQueryBean;", "equals", "other", "hashCode", "", "toString", "intelligence_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UserProfileLabelQueryBean {
    private final double confidence;

    @SerializedName("is_official_home")
    private final boolean isOfficialHome;

    @SerializedName("radius_m")
    private final Double radiusM;
    private final List<String> value;

    public UserProfileLabelQueryBean() {
        this(null, 0.0d, null, false, 15, null);
    }

    public UserProfileLabelQueryBean(List<String> r7, double r8) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, EventBody.KEY_VALUE);
        this(r1, r8, null, false);
    }

    public UserProfileLabelQueryBean(List<String> r3, double r4, Double r6, boolean r7) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, EventBody.KEY_VALUE);
        this.value = r5;
        this.confidence = r4;
        this.radiusM = r6;
        this.isOfficialHome = r7;
    }

    public /* synthetic */ UserProfileLabelQueryBean(List r4, double r5, Double r7, boolean r8, int r9, DefaultConstructorMarker r10) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r9 & 1) == 0) goto L6;
        r6 = CollectionsKt.emptyList();
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = 0.0d;
    L8:
        double r0 = r5;
        if ((r9 & 4) == 0) goto L11;
        r7 = null;
    L11:
        Double r11 = r7;
        if ((r9 & 8) == 0) goto L14;
        r8 = false;
    L14:
        List r12 = r6;
        this(r12, r0, r11, r8);
    }

    public static /* synthetic */ UserProfileLabelQueryBean copy$default(UserProfileLabelQueryBean r3, List r4, double r5, Double r7, boolean r8, int r9, Object r10) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r9 & 1) == 0) goto L6;
        r6 = r3.value;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.confidence;
    L8:
        double r0 = r5;
        if ((r9 & 4) == 0) goto L11;
        r7 = r3.radiusM;
    L11:
        Double r11 = r7;
        if ((r9 & 8) == 0) goto L14;
        r8 = r3.isOfficialHome;
    L14:
        List<String> r12 = r6;
        return r3.copy(r12, r0, r11, r8);
    }

    public final List<String> component1() {
        return this.value;
    }

    public final double component2() {
        return this.confidence;
    }

    public final Double component3() {
        return this.radiusM;
    }

    public final boolean component4() {
        return this.isOfficialHome;
    }

    public final UserProfileLabelQueryBean copy(List<String> r7, double r8, Double r10, boolean r11) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, EventBody.KEY_VALUE);
        return new UserProfileLabelQueryBean(r1, r8, r10, r11);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, UserProfileLabelQueryBean.class) == true) goto L8;
        return false;
    L8:
        UserProfileLabelQueryBean r10 = (UserProfileLabelQueryBean) ZeusTransformUtils.preCheckCast(r9, UserProfileLabelQueryBean.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.value, r10.value) == true) goto L12;
        return false;
    L12:
        if (Double.compare(this.confidence, r10.confidence) == 0) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.radiusM, r10.radiusM) == true) goto L18;
        return false;
    L18:
        if (this.isOfficialHome == r10.isOfficialHome) goto L20;
        return false;
    L20:
        return true;
    }

    public final double getConfidence() {
        return this.confidence;
    }

    public final Double getRadiusM() {
        return this.radiusM;
    }

    public final List<String> getValue() {
        return this.value;
    }

    public int hashCode() {
        int r0 = ((this.value.hashCode() * 31) + Double.hashCode(this.confidence)) * 31;
        Double r1 = this.radiusM;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + Boolean.hashCode(this.isOfficialHome);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final boolean isOfficialHome() {
        return this.isOfficialHome;
    }

    public String toString() {
        return "UserProfileLabelQueryBean(value=" + this.value + ", confidence=" + this.confidence + ", radiusM=" + this.radiusM + ", isOfficialHome=" + this.isOfficialHome + ')';
    }
}
