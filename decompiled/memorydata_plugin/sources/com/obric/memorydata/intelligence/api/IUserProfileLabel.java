package com.obric.memorydata.intelligence.api;

import com.bytedance.news.common.service.manager.IService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0003H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003H&J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0003H&J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003H&J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003H&J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\u0014\u001a\u00020\u0011H&J\b\u0010\u0015\u001a\u00020\u0011H&J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\u0017\u001a\u00020\u0011H&J\b\u0010\u0018\u001a\u00020\u0011H&J\b\u0010\u0019\u001a\u00020\u0011H&J\b\u0010\u001a\u001a\u00020\u0011H&J\b\u0010\u001b\u001a\u00020\u0011H&J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bH&J\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0011H&¨\u0006!"}, d2 = {"Lcom/obric/memorydata/intelligence/api/IUserProfileLabel;", "Lcom/bytedance/news/common/service/manager/IService;", "queryHomeGps", "", "", "queryCompanyGps", "queryGpsOf", "profileLabel", "Lcom/obric/memorydata/intelligence/api/ProfileLabel;", "queryGpsPointOf", "Lcom/obric/memorydata/intelligence/api/UserProfileGpsPoint;", "queryHomeGpsFenceList", "queryHomeCellId", "", "queryCompanyCellId", "queryCellIdOf", "queryHomeBssid", "", "queryCompanyBssid", "queryBssidOf", "querySleepMoment", "queryWakeupMoment", "queryMomentOf", "queryCommuteType", "queryArriveHomeMoment", "queryLeaveHomeMoment", "queryArriveCompanyMoment", "queryLeaveCompanyMoment", "queryLabelStringValueOfMaxConfidence", "getLabelBeanList", "Lcom/obric/memorydata/intelligence/api/UserProfileLabelQueryBean;", "uriValue", "jsonKey", "intelligence_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IUserProfileLabel extends IService {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static UserProfileGpsPoint a(IUserProfileLabel r2, ProfileLabel r3) {
            IUserProfileLabel r4 = (IUserProfileLabel) ZeusTransformUtils.wrapperContextForParams(r2, IUserProfileLabel.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "profileLabel");
            return null;
        }
    }

    List<UserProfileLabelQueryBean> getLabelBeanList(String r1, String r2);

    String queryArriveCompanyMoment();

    String queryArriveHomeMoment();

    List<String> queryBssidOf(ProfileLabel r1);

    List<Long> queryCellIdOf(ProfileLabel r1);

    String queryCommuteType();

    List<String> queryCompanyBssid();

    List<Long> queryCompanyCellId();

    List<Double> queryCompanyGps();

    List<Double> queryGpsOf(ProfileLabel r1);

    UserProfileGpsPoint queryGpsPointOf(ProfileLabel r1);

    List<String> queryHomeBssid();

    List<Long> queryHomeCellId();

    List<Double> queryHomeGps();

    List<UserProfileGpsPoint> queryHomeGpsFenceList();

    String queryLabelStringValueOfMaxConfidence(ProfileLabel r1);

    String queryLeaveCompanyMoment();

    String queryLeaveHomeMoment();

    String queryMomentOf(ProfileLabel r1);

    String querySleepMoment();

    String queryWakeupMoment();
}
