package com.obric.memorydata.intelligence.datalearning.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.memorydata.database.entity.je;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.intelligence.api.IUserProfileLabel;
import com.obric.memorydata.intelligence.api.ProfileLabel;
import com.obric.memorydata.intelligence.api.UserProfileGpsPoint;
import com.obric.memorydata.intelligence.api.UserProfileLabelQueryBean;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.ab;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0000H\u0007J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\bH\u0016J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u0014\u001a\u0004\u0018\u00010\u000f*\u00020\u0011H\u0002J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\bH\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\bH\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020\u0005H\u0016J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0016J\u001a\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0002J\u001c\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\r2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/memorydata/intelligence/datalearning/service/UserProfileLabelQuery;", "Lcom/obric/memorydata/intelligence/api/IUserProfileLabel;", "<init>", "()V", "TAG", "", "getInst", "queryHomeGps", "", "", "queryCompanyGps", "queryGpsOf", "profileLabel", "Lcom/obric/memorydata/intelligence/api/ProfileLabel;", "queryGpsPointOf", "Lcom/obric/memorydata/intelligence/api/UserProfileGpsPoint;", "queryGpsLabelOf", "Lcom/obric/memorydata/intelligence/api/UserProfileLabelQueryBean;", "queryHomeGpsFenceList", "queryGpsPointsOf", "toGpsPointOrNull", "queryHomeCellId", "", "queryCompanyCellId", "queryCellIdOf", "queryHomeBssid", "queryCompanyBssid", "queryBssidOf", "querySleepMoment", "queryWakeupMoment", "queryMomentOf", "queryCommuteType", "queryArriveHomeMoment", "queryLeaveHomeMoment", "queryArriveCompanyMoment", "queryLeaveCompanyMoment", "queryLabelStringValueOfMaxConfidence", "getLabelBeanList", "uriValue", "jsonKey", "parseValue", "Lcom/google/gson/JsonElement;", "assembleMidUriVal", AnnotatedPrivateKey.LABEL, "values", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UserProfileLabelQuery implements IUserProfileLabel {
    public static final UserProfileLabelQuery INSTANCE = null;
    private static final String TAG = "UserProfileLabelQuery";

    static {
        INSTANCE = new UserProfileLabelQuery();
    }

    private UserProfileLabelQuery() {
    }

    @JvmStatic
    public static final UserProfileLabelQuery getInst() {
        return INSTANCE;
    }

    public static /* synthetic */ Unit lambda$I7cClyCAjgQ5uXFGjEqPb9pY3I4(Ref.ObjectRef r0, List r1) {
        return queryLabelStringValueOfMaxConfidence$lambda$9(r0, r1);
    }

    public static /* synthetic */ Double lambda$IWkZh44DjgTl8dVLJ3tLUZ99_8o(UserProfileLabelQueryBean r0) {
        return queryLabelStringValueOfMaxConfidence$lambda$9$lambda$7(r0);
    }

    /* JADX INFO: renamed from: lambda$Pi5Iiz8EwBmX1S-pfIi34GBP014, reason: not valid java name */
    public static /* synthetic */ void m674lambda$Pi5Iiz8EwBmX1SpfIi34GBP014(Function1 r0, Object r1) {
        queryBssidOf$lambda$6(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$UmoMJeOnrGpJxk5uAUn-vSxqxjY, reason: not valid java name */
    public static /* synthetic */ Double m675lambda$UmoMJeOnrGpJxk5uAUnvSxqxjY(Function1 r0, Object r1) {
        return queryLabelStringValueOfMaxConfidence$lambda$9$lambda$8(r0, r1);
    }

    public static /* synthetic */ void lambda$f38VexEb5tIpdelSB8eArsd0ymE(Function1 r0, Object r1) {
        queryCellIdOf$lambda$4(r0, r1);
    }

    public static /* synthetic */ Unit lambda$rLiLnQSGGUXTLGsEBaKraoxP0Co(ArrayList r0, UserProfileLabelQueryBean r1) {
        return queryCellIdOf$lambda$3(r0, r1);
    }

    public static /* synthetic */ Unit lambda$tYRbq9RPKWcBQVdMvuBZTgLARB0(ArrayList r0, UserProfileLabelQueryBean r1) {
        return queryBssidOf$lambda$5(r0, r1);
    }

    private final JsonElement parseValue(String r4, String r5) {
        boolean r1 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        return null;
    L8:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L11;
        r1 = false;
    L11:
        if (r1 == false) goto L14;
        return null;
    L14:
        return ab.a(r4).get(r5);
    L5:
        r3 = false;
        goto L6
    }

    private static final Unit queryBssidOf$lambda$5(ArrayList r2, UserProfileLabelQueryBean r3) {
        r2.addAll((Collection) ZeusTransformUtils.preCheckCast(r3.getValue(), Collection.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private static final void queryBssidOf$lambda$6(Function1 r2, Object r3) {
        ((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3);
    }

    private static final Unit queryCellIdOf$lambda$3(ArrayList r4, UserProfileLabelQueryBean r5) {
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5.getValue(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        r4.add(Long.valueOf(Long.parseLong((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin"))));
        goto L4
    L7:
        return Unit.INSTANCE;
    }

    private static final void queryCellIdOf$lambda$4(Function1 r2, Object r3) {
        ((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3);
    }

    private final UserProfileLabelQueryBean queryGpsLabelOf(ProfileLabel r8) {
        je r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao().queryOneRecordBy(r8.toString());
        Object r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(getLabelBeanList(r0.b(), r8.toString()), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r7.hasNext() == false) goto L18;
        r1 = r7.next();
        if (r7.hasNext() == false) goto L18;
        double r2 = ((UserProfileLabelQueryBean) ZeusTransformUtils.preCheckCast(r1, UserProfileLabelQueryBean.class, "com.obric.memorydata.plugin")).getConfidence();
    L12:
        Object r9 = r7.next();
        double r4 = ((UserProfileLabelQueryBean) ZeusTransformUtils.preCheckCast(r9, UserProfileLabelQueryBean.class, "com.obric.memorydata.plugin")).getConfidence();
        if (Double.compare(r2, r4) >= 0) goto L16;
        r1 = r9;
        r2 = r4;
    L16:
        if (r7.hasNext() == true) goto L12;
    L18:
        return (UserProfileLabelQueryBean) ZeusTransformUtils.preCheckCast(r1, UserProfileLabelQueryBean.class, "com.obric.memorydata.plugin");
    }

    private final List<UserProfileGpsPoint> queryGpsPointsOf(ProfileLabel r7) {
        if (AppContext.INSTANCE.isLogin() == true) goto L6;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "queryGpsPointsOf " + r7 + " without a logged-in user!", null, 4, null);
        return CollectionsKt.emptyList();
    L6:
        je r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao().queryOneRecordBy(r7.toString());
        if (r0 == null) goto L9;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(getLabelBeanList(r0.b(), r7.toString()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r6.iterator();
    L12:
        if (r9.hasNext() == false) goto L17;
        UserProfileGpsPoint r1 = INSTANCE.toGpsPointOrNull((UserProfileLabelQueryBean) ZeusTransformUtils.preCheckCast(r9.next(), UserProfileLabelQueryBean.class, "com.obric.memorydata.plugin"));
        if (r1 == null) goto L12;
        r8.add(r1);
        goto L12
    L17:
        return (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
    L9:
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Type inference failed for: r4v9, types: [T, java.lang.Object] */
    private static final Unit queryLabelStringValueOfMaxConfidence$lambda$9(Ref.ObjectRef r3, List r4) {
        Stream r5 = ((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin")).stream();
        final $$Lambda$UserProfileLabelQuery$IWkZh44DjgTl8dVLJ3tLUZ99_8o r0 = $$Lambda$UserProfileLabelQuery$IWkZh44DjgTl8dVLJ3tLUZ99_8o.INSTANCE;
        r3.element = ((UserProfileLabelQueryBean) ZeusTransformUtils.preCheckCast(r5.max(Comparator.comparing(new $$Lambda$UserProfileLabelQuery$UmoMJeOnrGpJxk5uAUnvSxqxjY(r0))).get(), UserProfileLabelQueryBean.class, "com.obric.memorydata.plugin")).getValue().get(0);
        return Unit.INSTANCE;
    }

    private static final Double queryLabelStringValueOfMaxConfidence$lambda$9$lambda$7(UserProfileLabelQueryBean r2) {
        return Double.valueOf(r2.getConfidence());
    }

    private static final Double queryLabelStringValueOfMaxConfidence$lambda$9$lambda$8(Function1 r2, Object r3) {
        return (Double) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), Double.class, "com.obric.memorydata.plugin");
    }

    private final UserProfileGpsPoint toGpsPointOrNull(UserProfileLabelQueryBean r13) {
        if (r13.getValue().size() == 2) goto L5;
        return null;
    L5:
        Double r12 = StringsKt.toDoubleOrNull((String) ZeusTransformUtils.preCheckCast(r13.getValue().get(0), String.class, "com.obric.memorydata.plugin"));
        if (r12 == null) goto L11;
        double r4 = r12.doubleValue();
        Double r14 = StringsKt.toDoubleOrNull((String) ZeusTransformUtils.preCheckCast(r13.getValue().get(1), String.class, "com.obric.memorydata.plugin"));
        if (r14 == null) goto L11;
        return new UserProfileGpsPoint(r4, r14.doubleValue(), r13.getConfidence(), r13.getRadiusM(), r13.isOfficialHome());
    L11:
        return null;
    }

    public final String assembleMidUriVal(ProfileLabel r5, List<String> r6) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, AnnotatedPrivateKey.LABEL);
        Intrinsics.checkNotNullParameter(r4, "values");
        JsonObject r7 = new JsonObject();
        JsonArray r1 = new JsonArray();
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r1.add((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        r7.add(r5.toString(), (JsonElement) ZeusTransformUtils.preCheckCast(r1, JsonElement.class, "com.obric.memorydata.plugin"));
        String r9 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r9, "toString(...)");
        return r9;
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<UserProfileLabelQueryBean> getLabelBeanList(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uriValue");
        Intrinsics.checkNotNullParameter(r3, "jsonKey");
        JsonElement r1 = parseValue(r2, r3);
        if (r1 == null) goto L6;
        return ab.a(r1, UserProfileLabelQueryBean.class);
    L6:
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public String queryArriveCompanyMoment() {
        return queryLabelStringValueOfMaxConfidence(ProfileLabel.ARRIVE_COMPANY_TIME);
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public String queryArriveHomeMoment() {
        return queryLabelStringValueOfMaxConfidence(ProfileLabel.ARRIVE_HOME_TIME);
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<String> queryBssidOf(ProfileLabel r3) {
        Intrinsics.checkNotNullParameter(r3, "profileLabel");
        je r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao().queryOneRecordBy(r3.toString());
        if (r0 == null) goto L5;
        List<UserProfileLabelQueryBean> r2 = getLabelBeanList(r0.b(), r3.toString());
        if (r2.isEmpty() == true) goto L9;
        final ArrayList r4 = new ArrayList();
        Stream<UserProfileLabelQueryBean> r5 = r2.stream();
        final Function1 r1 = new $$Lambda$UserProfileLabelQuery$tYRbq9RPKWcBQVdMvuBZTgLARB0(r4);
        r5.forEach(new $$Lambda$UserProfileLabelQuery$Pi5Iiz8EwBmX1SpfIi34GBP014(r1));
        return (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
    L9:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<Long> queryCellIdOf(ProfileLabel r3) {
        Intrinsics.checkNotNullParameter(r3, "profileLabel");
        je r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao().queryOneRecordBy(r3.toString());
        if (r0 == null) goto L5;
        List<UserProfileLabelQueryBean> r2 = getLabelBeanList(r0.b(), r3.toString());
        if (r2.isEmpty() == true) goto L9;
        final ArrayList r4 = new ArrayList();
        Stream<UserProfileLabelQueryBean> r5 = r2.stream();
        final Function1 r1 = new $$Lambda$UserProfileLabelQuery$rLiLnQSGGUXTLGsEBaKraoxP0Co(r4);
        r5.forEach(new $$Lambda$UserProfileLabelQuery$f38VexEb5tIpdelSB8eArsd0ymE(r1));
        return (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
    L9:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public String queryCommuteType() {
        return queryLabelStringValueOfMaxConfidence(ProfileLabel.COMMUTE_TYPE);
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<String> queryCompanyBssid() {
        return queryBssidOf(ProfileLabel.COMPANY_BSS_ID);
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<Long> queryCompanyCellId() {
        return queryCellIdOf(ProfileLabel.COMPANY_CELL_ID);
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<Double> queryCompanyGps() {
        return queryGpsOf(ProfileLabel.COMPANY_GPS);
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<Double> queryGpsOf(ProfileLabel r4) {
        Intrinsics.checkNotNullParameter(r4, "profileLabel");
        UserProfileGpsPoint r3 = queryGpsPointOf(r4);
        if (r3 != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return CollectionsKt.listOf(new Double[]{Double.valueOf(r3.getLongitude()), Double.valueOf(r3.getLatitude())});
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public UserProfileGpsPoint queryGpsPointOf(ProfileLabel r2) {
        Intrinsics.checkNotNullParameter(r2, "profileLabel");
        UserProfileLabelQueryBean r3 = queryGpsLabelOf(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return toGpsPointOrNull(r3);
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<String> queryHomeBssid() {
        return queryBssidOf(ProfileLabel.HOME_BSS_ID);
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<Long> queryHomeCellId() {
        return queryCellIdOf(ProfileLabel.HOME_CELL_ID);
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<Double> queryHomeGps() {
        return queryGpsOf(ProfileLabel.HOME_GPS);
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public List<UserProfileGpsPoint> queryHomeGpsFenceList() {
        return queryGpsPointsOf(ProfileLabel.HOME_GPS_FENCE_LIST);
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public String queryLabelStringValueOfMaxConfidence(ProfileLabel r3) {
        Intrinsics.checkNotNullParameter(r3, "profileLabel");
        je r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao().queryOneRecordBy(r3.toString());
        if (r0 != null) goto L5;
        return "";
    L5:
        final List<UserProfileLabelQueryBean> r2 = getLabelBeanList(r0.b(), r3.toString());
        if (r2.isEmpty() == false) goto L8;
        return "";
    L8:
        final Ref.ObjectRef r4 = new Ref.ObjectRef();
        r4.element = "";
        y.a(null, new $$Lambda$UserProfileLabelQuery$I7cClyCAjgQ5uXFGjEqPb9pY3I4(r4, r2), 1, null);
        return (String) ZeusTransformUtils.preCheckCast(r4.element, String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public String queryLeaveCompanyMoment() {
        return queryLabelStringValueOfMaxConfidence(ProfileLabel.LEAVE_COMPANY_TIME);
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public String queryLeaveHomeMoment() {
        return queryLabelStringValueOfMaxConfidence(ProfileLabel.LEAVE_HOME_TIME);
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public String queryMomentOf(ProfileLabel r2) {
        Intrinsics.checkNotNullParameter(r2, "profileLabel");
        return queryLabelStringValueOfMaxConfidence(r2);
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public String querySleepMoment() {
        return queryMomentOf(ProfileLabel.SLEEP_MOMENT);
    }

    @Override // com.obric.memorydata.intelligence.api.IUserProfileLabel
    public String queryWakeupMoment() {
        return queryMomentOf(ProfileLabel.WAKEUP_MOMENT);
    }
}
