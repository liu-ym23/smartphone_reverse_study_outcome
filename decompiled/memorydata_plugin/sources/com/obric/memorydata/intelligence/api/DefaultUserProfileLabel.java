package com.obric.memorydata.intelligence.api;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005H\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005H\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005H\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nH\u0016J\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00052\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0012H\u0016¨\u0006\""}, d2 = {"Lcom/obric/memorydata/intelligence/api/DefaultUserProfileLabel;", "Lcom/obric/memorydata/intelligence/api/IUserProfileLabel;", "<init>", "()V", "queryHomeGps", "", "", "queryCompanyGps", "queryGpsOf", "profileLabel", "Lcom/obric/memorydata/intelligence/api/ProfileLabel;", "queryHomeGpsFenceList", "Lcom/obric/memorydata/intelligence/api/UserProfileGpsPoint;", "queryHomeCellId", "", "queryCompanyCellId", "queryCellIdOf", "queryHomeBssid", "", "queryCompanyBssid", "queryBssidOf", "querySleepMoment", "queryWakeupMoment", "queryMomentOf", "queryCommuteType", "queryArriveHomeMoment", "queryLeaveHomeMoment", "queryArriveCompanyMoment", "queryLeaveCompanyMoment", "queryLabelStringValueOfMaxConfidence", "getLabelBeanList", "Lcom/obric/memorydata/intelligence/api/UserProfileLabelQueryBean;", "uriValue", "jsonKey", "intelligence_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultUserProfileLabel implements IUserProfileLabel {
    public static final DefaultUserProfileLabel INSTANCE = null;

    static {
        INSTANCE = new DefaultUserProfileLabel();
    }

    private DefaultUserProfileLabel() {
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<UserProfileLabelQueryBean> getLabelBeanList(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "uriValue");
        Intrinsics.checkNotNullParameter(r2, "jsonKey");
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public String queryArriveCompanyMoment() {
        return "";
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public String queryArriveHomeMoment() {
        return "";
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<String> queryBssidOf(ProfileLabel r1) {
        Intrinsics.checkNotNullParameter(r1, "profileLabel");
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<Long> queryCellIdOf(ProfileLabel r1) {
        Intrinsics.checkNotNullParameter(r1, "profileLabel");
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public String queryCommuteType() {
        return "";
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<String> queryCompanyBssid() {
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<Long> queryCompanyCellId() {
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<Double> queryCompanyGps() {
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<Double> queryGpsOf(ProfileLabel r1) {
        Intrinsics.checkNotNullParameter(r1, "profileLabel");
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public UserProfileGpsPoint queryGpsPointOf(ProfileLabel r1) {
        return IUserProfileLabel.a.a(this, r1);
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<String> queryHomeBssid() {
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<Long> queryHomeCellId() {
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<Double> queryHomeGps() {
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<UserProfileGpsPoint> queryHomeGpsFenceList() {
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public String queryLabelStringValueOfMaxConfidence(ProfileLabel r1) {
        Intrinsics.checkNotNullParameter(r1, "profileLabel");
        return "";
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public String queryLeaveCompanyMoment() {
        return "";
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public String queryLeaveHomeMoment() {
        return "";
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public String queryMomentOf(ProfileLabel r1) {
        Intrinsics.checkNotNullParameter(r1, "profileLabel");
        return "";
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public String querySleepMoment() {
        return "";
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public String queryWakeupMoment() {
        return "";
    }
}
