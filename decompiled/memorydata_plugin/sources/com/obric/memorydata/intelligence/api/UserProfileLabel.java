package com.obric.memorydata.intelligence.api;

import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0096\u0001J\t\u0010\n\u001a\u00020\bH\u0096\u0001J\t\u0010\u000b\u001a\u00020\bH\u0096\u0001J\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u0011\u001a\u00020\bH\u0096\u0001J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u0096\u0001J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005H\u0096\u0001J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0005H\u0096\u0001J\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u0096\u0001J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005H\u0096\u0001J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u0005H\u0096\u0001J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u0005H\u0096\u0001J\u0011\u0010\u001d\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u001e\u001a\u00020\bH\u0096\u0001J\t\u0010\u001f\u001a\u00020\bH\u0096\u0001J\u0011\u0010 \u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\t\u0010!\u001a\u00020\bH\u0096\u0001J\t\u0010\"\u001a\u00020\bH\u0096\u0001¨\u0006#"}, d2 = {"Lcom/obric/memorydata/intelligence/api/UserProfileLabel;", "Lcom/obric/memorydata/intelligence/api/IUserProfileLabel;", "<init>", "()V", "getLabelBeanList", "", "Lcom/obric/memorydata/intelligence/api/UserProfileLabelQueryBean;", "uriValue", "", "jsonKey", "queryArriveCompanyMoment", "queryArriveHomeMoment", "queryBssidOf", "profileLabel", "Lcom/obric/memorydata/intelligence/api/ProfileLabel;", "queryCellIdOf", "", "queryCommuteType", "queryCompanyBssid", "queryCompanyCellId", "queryCompanyGps", "", "queryGpsOf", "queryGpsPointOf", "Lcom/obric/memorydata/intelligence/api/UserProfileGpsPoint;", "queryHomeBssid", "queryHomeCellId", "queryHomeGps", "queryHomeGpsFenceList", "queryLabelStringValueOfMaxConfidence", "queryLeaveCompanyMoment", "queryLeaveHomeMoment", "queryMomentOf", "querySleepMoment", "queryWakeupMoment", "intelligence_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UserProfileLabel implements IUserProfileLabel {
    public static final UserProfileLabel INSTANCE = null;
    private final /* synthetic */ IUserProfileLabel $$delegate_0;

    static {
        INSTANCE = new UserProfileLabel();
    }

    private UserProfileLabel() {
        IUserProfileLabel r0 = (IUserProfileLabel) ZeusTransformUtils.preCheckCast(ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IUserProfileLabel.class)), IUserProfileLabel.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = (IUserProfileLabel) ZeusTransformUtils.preCheckCast(DefaultUserProfileLabel.INSTANCE, IUserProfileLabel.class, "com.obric.memorydata.plugin");
    L5:
        this.$$delegate_0 = r0;
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<UserProfileLabelQueryBean> getLabelBeanList(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uriValue");
        Intrinsics.checkNotNullParameter(r3, "jsonKey");
        return this.$$delegate_0.getLabelBeanList(r2, r3);
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public String queryArriveCompanyMoment() {
        return this.$$delegate_0.queryArriveCompanyMoment();
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public String queryArriveHomeMoment() {
        return this.$$delegate_0.queryArriveHomeMoment();
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<String> queryBssidOf(ProfileLabel r2) {
        Intrinsics.checkNotNullParameter(r2, "profileLabel");
        return this.$$delegate_0.queryBssidOf(r2);
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<Long> queryCellIdOf(ProfileLabel r2) {
        Intrinsics.checkNotNullParameter(r2, "profileLabel");
        return this.$$delegate_0.queryCellIdOf(r2);
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public String queryCommuteType() {
        return this.$$delegate_0.queryCommuteType();
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<String> queryCompanyBssid() {
        return this.$$delegate_0.queryCompanyBssid();
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<Long> queryCompanyCellId() {
        return this.$$delegate_0.queryCompanyCellId();
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<Double> queryCompanyGps() {
        return this.$$delegate_0.queryCompanyGps();
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<Double> queryGpsOf(ProfileLabel r2) {
        Intrinsics.checkNotNullParameter(r2, "profileLabel");
        return this.$$delegate_0.queryGpsOf(r2);
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public UserProfileGpsPoint queryGpsPointOf(ProfileLabel r2) {
        Intrinsics.checkNotNullParameter(r2, "profileLabel");
        return this.$$delegate_0.queryGpsPointOf(r2);
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<String> queryHomeBssid() {
        return this.$$delegate_0.queryHomeBssid();
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<Long> queryHomeCellId() {
        return this.$$delegate_0.queryHomeCellId();
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<Double> queryHomeGps() {
        return this.$$delegate_0.queryHomeGps();
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<UserProfileGpsPoint> queryHomeGpsFenceList() {
        return this.$$delegate_0.queryHomeGpsFenceList();
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public String queryLabelStringValueOfMaxConfidence(ProfileLabel r2) {
        Intrinsics.checkNotNullParameter(r2, "profileLabel");
        return this.$$delegate_0.queryLabelStringValueOfMaxConfidence(r2);
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public String queryLeaveCompanyMoment() {
        return this.$$delegate_0.queryLeaveCompanyMoment();
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public String queryLeaveHomeMoment() {
        return this.$$delegate_0.queryLeaveHomeMoment();
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public String queryMomentOf(ProfileLabel r2) {
        Intrinsics.checkNotNullParameter(r2, "profileLabel");
        return this.$$delegate_0.queryMomentOf(r2);
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public String querySleepMoment() {
        return this.$$delegate_0.querySleepMoment();
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public String queryWakeupMoment() {
        return this.$$delegate_0.queryWakeupMoment();
    }
}
