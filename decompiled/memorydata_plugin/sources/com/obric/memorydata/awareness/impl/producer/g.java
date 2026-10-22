package com.obric.memorydata.awareness.impl.producer;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.obric.memorydata.database.dao.UserProfileDao;
import com.obric.memorydata.database.entity.je;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.intelligence.api.ProfileLabel;
import com.obric.memorydata.intelligence.api.UserProfileLabel;
import com.obric.memorydata.intelligence.api.UserProfileLabelQueryBean;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J2\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00122\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0019H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u001b\u001a\u00020\u0014H\u0002J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u001dH\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0017\u001a\u00020\u0012H\u0002J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u001dH\u0002J\u0012\u0010 \u001a\u0004\u0018\u00010\u00062\u0006\u0010!\u001a\u00020\u0006H\u0002J\b\u0010\"\u001a\u00020\u0012H\u0002J\n\u0010#\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010$\u001a\u00020\u0012H\u0002J\b\u0010%\u001a\u00020\u0012H\u0002J\n\u0010&\u001a\u0004\u0018\u00010\u0012H\u0002J\n\u0010'\u001a\u0004\u0018\u00010\u0012H\u0002J\n\u0010(\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010)\u001a\u00020\u0012H\u0002J\b\u0010*\u001a\u00020\u0012H\u0002J\b\u0010+\u001a\u00020\u0012H\u0002J\b\u0010,\u001a\u00020\u0012H\u0002J\u001e\u0010-\u001a\u00020\u00142\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060/2\u0006\u00100\u001a\u00020\u000fH\u0016R$\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u00062"}, d2 = {"Lcom/obric/memorydata/awareness/impl/producer/UserProfileFeatureProducer;", "Lcom/obric/memorydata/awareness/impl/producer/AbstractFeatureProducer;", "<init>", "()V", "features", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getFeatures", "()Ljava/util/HashSet;", "needCacheFeatures", "", "getNeedCacheFeatures", "()Ljava/util/Set;", "hasDefineFeature", "", "featureName", "getFeature", "", "restorePersistedFeatures", "", "queryFeature", "setFeature", EventBody.KEY_VALUE, WsConstants.KEY_EXTRA, "", "queryHomeGpsFenceListFeature", "deleteHomeGpsFenceListFeature", "persistHomeGpsFenceListFeature", "Lorg/json/JSONObject;", "normalizeHomeGpsFenceListValue", "isValidHomeGpsFenceListValue", "queryRawUserProfileValue", "uriKey", "workingPeriodQuery", "bedTimePeriodQuery", "unWorkingPeriodQuery", "upcoming30DaySpecialDayQuery", "lunchBreakPeriodQuery", "lunchPeriodQuery", "dinnerPeriodQuery", "sleepMomentQuery", "fromHomeToCompanyPeriodQuery", "fromCompanyToHomePeriodQuery", "wakeupMomentQuery", "collectFeatures", "featureNames", "", "collect", "Companion", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g extends com.obric.memorydata.awareness.impl.producer.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f8750b = null;
    private final HashSet<String> c;
    private final Set<String> d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/awareness/impl/producer/UserProfileFeatureProducer$Companion;", "", "<init>", "()V", "TAG", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8750b = new a(null);
    }

    public g() {
        this.c = SetsKt.hashSetOf(new String[]{"upcoming_30_special_day", "sleep_moment", "first_bright_time_period", "location_company_gps", "location_home_gps", "HOME_GPS_FENCE_LIST", "from_company_to_home_period", "from_home_to_company_period", "wakeup_moment", "working_time_period", "un_working_time_period", "lunch_break_period", "bed_time_period", "lunch_period", "dinner_period", "home_bssid", "company_bssid", "first_unlock_time", "commute_cluster_result", "commute_main_har_state_result"});
        this.d = SetsKt.emptySet();
        e();
    }

    private final Object a(String r7) {
        switch(r7.hashCode()) {
            case -1971359340: goto L99;
            case -1842218431: goto L94;
            case -1554067001: goto L89;
            case -1289712546: goto L84;
            case -1247285067: goto L79;
            case -906728257: goto L74;
            case -718300524: goto L69;
            case -573915175: goto L64;
            case -267511963: goto L59;
            case -108707736: goto L54;
            case -44965120: goto L49;
            case 456959442: goto L46;
            case 860531830: goto L41;
            case 1223206620: goto L36;
            case 1223620477: goto L31;
            case 1366069403: goto L26;
            case 1554016246: goto L21;
            case 1674955677: goto L16;
            case 1689041335: goto L11;
            case 1819804206: goto L6;
            default: goto L103;
        };
    L103:
        return null;
    L6:
        if (r7.equals("dinner_period") == false) goto L103;
        return n();
    L11:
        if (r7.equals("upcoming_30_special_day") == false) goto L103;
        return k();
    L16:
        if (r7.equals("first_bright_time_period") == false) goto L103;
        return r();
    L21:
        if (r7.equals("lunch_break_period") == false) goto L103;
        return l();
    L26:
        if (r7.equals("company_bssid") == false) goto L103;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UserProfileFeature", "query company bssid", false, 4, null);
        return UserProfileLabel.INSTANCE.queryCompanyBssid();
    L31:
        if (r7.equals("home_bssid") == false) goto L103;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UserProfileFeature", "query home bssid", false, 4, null);
        return UserProfileLabel.INSTANCE.queryHomeBssid();
    L36:
        if (r7.equals("from_home_to_company_period") == false) goto L103;
        return p();
    L41:
        if (r7.equals("lunch_period") == false) goto L103;
        return m();
    L46:
        if (r7.equals("commute_main_har_state_result") == false) goto L103;
    L92:
        return b(r7);
    L49:
        if (r7.equals("wakeup_moment") == false) goto L103;
        return r();
    L54:
        if (r7.equals("sleep_moment") == false) goto L103;
        return o();
    L59:
        if (r7.equals("working_time_period") == false) goto L103;
        return h();
    L64:
        if (r7.equals("first_unlock_time") == false) goto L103;
        return Long.valueOf(IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getLong("day_first_unlock_time", 0));
    L69:
        if (r7.equals("location_home_gps") == false) goto L103;
        return UserProfileLabel.INSTANCE.queryHomeGps();
    L74:
        if (r7.equals("un_working_time_period") == false) goto L103;
        return j();
    L79:
        if (r7.equals("bed_time_period") == false) goto L103;
        return i();
    L84:
        if (r7.equals("location_company_gps") == false) goto L103;
        return UserProfileLabel.INSTANCE.queryCompanyGps();
    L89:
        if (r7.equals("commute_cluster_result") == true) goto L92;
    L94:
        if (r7.equals("HOME_GPS_FENCE_LIST") == false) goto L103;
        return f();
    L99:
        if (r7.equals("from_company_to_home_period") == false) goto L103;
        return q();
    }

    private final JSONObject a(Object r10) {
        Object r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L17
        g r9 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (ZeusTransformUtils.instanceOf(r10, JSONObject.class) == false) goto L7;
        JSONObject r3 = new JSONObject(((JSONObject) ZeusTransformUtils.preCheckCast(r10, JSONObject.class, "com.obric.memorydata.plugin")).toString());     // Catch: Throwable -> L17
    L10:
        if (r3 != null) goto L12;
    L14:
        r3 = null;
    L15:
        Object r11 = Result.m1421constructorimpl(r3);     // Catch: Throwable -> L17
    L19:
        Throwable r12 = Result.m1424exceptionOrNullimpl(r11);
        if (r12 == null) goto L23;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UserProfileFeature", "normalize HOME_GPS_FENCE_LIST error: " + r12.getMessage(), null, 4, null);
    L23:
        if (Result.m1427isFailureimpl(r11) == true) goto L27;
        r1 = r11;
    L27:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r1, JSONObject.class, "com.obric.memorydata.plugin");
    L12:
        if (r9.b(r3) == false) goto L14;
    L7:
        if (ZeusTransformUtils.instanceOf(r10, String.class) == false) goto L9;
        r3 = new JSONObject((String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L17
        goto L10
    L9:
        r3 = null;
    L17:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    private final boolean a(JSONObject r13) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        g r12 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        String r2 = ProfileLabel.HOME_GPS_FENCE_LIST.toString();     // Catch: Throwable -> L12
        String r5 = r13.toString();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullExpressionValue(r5, "toString(...)");     // Catch: Throwable -> L12
        long r6 = System.currentTimeMillis();     // Catch: Throwable -> L12
        UserProfileDao r14 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao();     // Catch: Throwable -> L12
        je r15 = r14.queryOneRecordBy(r2);     // Catch: Throwable -> L12
        if (r15 != null) goto L6;
        r14.insert(new je(r2, r5, r6, 0, 8, null));     // Catch: Throwable -> L12
    L10:
        Object r16 = Result.m1421constructorimpl(true);     // Catch: Throwable -> L12
    L14:
        Throwable r17 = Result.m1424exceptionOrNullimpl(r16);
        if (r17 == null) goto L18;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UserProfileFeature", "persist HOME_GPS_FENCE_LIST error: " + r17.getMessage(), null, 4, null);
    L18:
        if (Result.m1427isFailureimpl(r16) == false) goto L21;
        r16 = false;
    L21:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r16, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L6:
        if (Intrinsics.areEqual(r15.b(), r5) == false) goto L8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UserProfileFeature", "skip persist HOME_GPS_FENCE_LIST unchanged", false, 4, null);     // Catch: Throwable -> L12
        goto L10
    L8:
        r14.update(new je(r15.a(), r5, r6, r15.d()));     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    private final String b(String r1) {
        je r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao().queryOneRecordBy(r1);     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        String r2 = r0.b();     // Catch: Throwable -> L8
        if (r2 == null) goto L6;
        return r2;
    L6:
        return "";
    L8:
        return null;
    }

    private final boolean b(JSONObject r5) {
        JSONArray r4 = r5.optJSONArray("HOME_GPS_FENCE_LIST");
        if (r4 != null) goto L5;
        return false;
    L5:
        int r0 = r4.length();
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L17;
        JSONObject r2 = r4.optJSONObject(r1);
        if (r2 == null) goto L9;
        JSONArray r3 = r2.optJSONArray(EventBody.KEY_VALUE);
        if (r3 == null) goto L12;
        if (r3.length() != 2) goto L15;
        r1 = r1 + 1;
        goto L6
    L15:
        return false;
    L12:
        return false;
    L9:
        return false;
    L17:
        return true;
    }

    private final void e() {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(c(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        a(r1, a(r1));
        goto L4
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UserProfileFeature", "restore persisted features completed, total=" + c().size(), false, 4, null);
    }

    private final Object f() {
        String r0 = b(ProfileLabel.HOME_GPS_FENCE_LIST.toString());
        if (r0 != null) goto L5;
        return null;
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L27;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
        g r9 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        Object r10 = Result.m1421constructorimpl(new JSONObject(r0));     // Catch: Throwable -> L14
    L16:
        Throwable r1 = Result.m1424exceptionOrNullimpl(r10);
        if (r1 == null) goto L20;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UserProfileFeature", "parse HOME_GPS_FENCE_LIST error: " + r1.getMessage(), null, 4, null);
    L20:
        if (Result.m1427isFailureimpl(r10) == false) goto L23;
        return null;
    L23:
        return r10;
    L14:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L16
    L27:
        return null;
    L7:
        r2 = false;
        goto L8
    }

    private final void g() {
        String r1 = ProfileLabel.HOME_GPS_FENCE_LIST.toString();
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao().deleteByUriKey(r1);
    }

    private final Object h() {
        je r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao().queryOneRecordBy(ProfileLabel.WORKING_TIME_PERIOD.toString());     // Catch: Exception -> L22
        UserProfileLabel r1 = UserProfileLabel.INSTANCE;     // Catch: Exception -> L22
        String r2 = "";
        if (r0 == null) goto L8;
        String r3 = r0.b();     // Catch: Exception -> L22
        if (r3 == null) goto L8;
    L9:
        if (r0 == null) goto L14;
        String r4 = r0.a();     // Catch: Exception -> L22
        if (r4 == null) goto L14;
        r2 = r4;
    L14:
        List<UserProfileLabelQueryBean> r5 = r1.getLabelBeanList(r3, r2);     // Catch: Exception -> L22
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L21;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(((UserProfileLabelQueryBean) ZeusTransformUtils.preCheckCast(r5.get(0), UserProfileLabelQueryBean.class, "com.obric.memorydata.plugin")).getValue(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L21;
        return ((UserProfileLabelQueryBean) ZeusTransformUtils.preCheckCast(r5.get(0), UserProfileLabelQueryBean.class, "com.obric.memorydata.plugin")).getValue();
    L21:
        return CollectionsKt.emptyList();
    L8:
        r3 = "";
        goto L9
    L23:
        return CollectionsKt.emptyList();
    }

    private final Object i() {
        je r1 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao().queryOneRecordBy(ProfileLabel.BED_TIME_PERIOD.toString());     // Catch: Exception -> L21
        UserProfileLabel r2 = UserProfileLabel.INSTANCE;     // Catch: Exception -> L21
        String r3 = "";
        if (r1 == null) goto L8;
        String r4 = r1.b();     // Catch: Exception -> L21
        if (r4 == null) goto L8;
    L9:
        if (r1 == null) goto L14;
        String r5 = r1.a();     // Catch: Exception -> L21
        if (r5 == null) goto L14;
        r3 = r5;
    L14:
        List<UserProfileLabelQueryBean> r6 = r2.getLabelBeanList(r4, r3);     // Catch: Exception -> L21
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L20;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(((UserProfileLabelQueryBean) ZeusTransformUtils.preCheckCast(r6.get(0), UserProfileLabelQueryBean.class, "com.obric.memorydata.plugin")).getValue(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L20;
        return ((UserProfileLabelQueryBean) ZeusTransformUtils.preCheckCast(r6.get(0), UserProfileLabelQueryBean.class, "com.obric.memorydata.plugin")).getValue();
    L8:
        r4 = "";
    L20:
        return null;
    }

    private final Object j() {
        je r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao().queryOneRecordBy(ProfileLabel.UN_WORKING_TIME_PERIOD.toString());     // Catch: Exception -> L22
        UserProfileLabel r1 = UserProfileLabel.INSTANCE;     // Catch: Exception -> L22
        String r2 = "";
        if (r0 == null) goto L8;
        String r3 = r0.b();     // Catch: Exception -> L22
        if (r3 == null) goto L8;
    L9:
        if (r0 == null) goto L14;
        String r4 = r0.a();     // Catch: Exception -> L22
        if (r4 == null) goto L14;
        r2 = r4;
    L14:
        List<UserProfileLabelQueryBean> r5 = r1.getLabelBeanList(r3, r2);     // Catch: Exception -> L22
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L21;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(((UserProfileLabelQueryBean) ZeusTransformUtils.preCheckCast(r5.get(0), UserProfileLabelQueryBean.class, "com.obric.memorydata.plugin")).getValue(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L21;
        return ((UserProfileLabelQueryBean) ZeusTransformUtils.preCheckCast(r5.get(0), UserProfileLabelQueryBean.class, "com.obric.memorydata.plugin")).getValue();
    L21:
        return CollectionsKt.emptyList();
    L8:
        r3 = "";
        goto L9
    L23:
        return CollectionsKt.emptyList();
    }

    private final Object k() {
        je r1 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao().queryOneRecordBy(ProfileLabel.UPCOMING_30_SPECIAL_DAY.toString());     // Catch: Exception -> L13
        if (r1 == null) goto L5;
        String r0 = r1.b();     // Catch: Exception -> L13
    L6:
        if (r0 == null) goto L12;
        JsonElement r2 = JsonParser.parseString(r1.b());     // Catch: Exception -> L13
        if (r2 == null) goto L10;
        return r2;
    L10:
        return CollectionsKt.emptyList();
    L12:
        return CollectionsKt.emptyList();
    L5:
        r0 = null;
        goto L6
    L14:
        return CollectionsKt.emptyList();
    }

    private final Object l() {
        je r1 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao().queryOneRecordBy(ProfileLabel.LUNCH_BREAK_PERIOD.toString());     // Catch: Exception -> L21
        UserProfileLabel r2 = UserProfileLabel.INSTANCE;     // Catch: Exception -> L21
        String r3 = "";
        if (r1 == null) goto L8;
        String r4 = r1.b();     // Catch: Exception -> L21
        if (r4 == null) goto L8;
    L9:
        if (r1 == null) goto L14;
        String r5 = r1.a();     // Catch: Exception -> L21
        if (r5 == null) goto L14;
        r3 = r5;
    L14:
        List<UserProfileLabelQueryBean> r6 = r2.getLabelBeanList(r4, r3);     // Catch: Exception -> L21
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L20;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(((UserProfileLabelQueryBean) ZeusTransformUtils.preCheckCast(r6.get(0), UserProfileLabelQueryBean.class, "com.obric.memorydata.plugin")).getValue(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L20;
        return ((UserProfileLabelQueryBean) ZeusTransformUtils.preCheckCast(r6.get(0), UserProfileLabelQueryBean.class, "com.obric.memorydata.plugin")).getValue();
    L8:
        r4 = "";
    L20:
        return null;
    }

    private final Object m() {
        je r1 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao().queryOneRecordBy(ProfileLabel.LUNCH_PERIOD.toString());     // Catch: Exception -> L21
        UserProfileLabel r2 = UserProfileLabel.INSTANCE;     // Catch: Exception -> L21
        String r3 = "";
        if (r1 == null) goto L8;
        String r4 = r1.b();     // Catch: Exception -> L21
        if (r4 == null) goto L8;
    L9:
        if (r1 == null) goto L14;
        String r5 = r1.a();     // Catch: Exception -> L21
        if (r5 == null) goto L14;
        r3 = r5;
    L14:
        List<UserProfileLabelQueryBean> r6 = r2.getLabelBeanList(r4, r3);     // Catch: Exception -> L21
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L20;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(((UserProfileLabelQueryBean) ZeusTransformUtils.preCheckCast(r6.get(0), UserProfileLabelQueryBean.class, "com.obric.memorydata.plugin")).getValue(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L20;
        return ((UserProfileLabelQueryBean) ZeusTransformUtils.preCheckCast(r6.get(0), UserProfileLabelQueryBean.class, "com.obric.memorydata.plugin")).getValue();
    L8:
        r4 = "";
    L20:
        return null;
    }

    private final Object n() {
        je r1 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao().queryOneRecordBy(ProfileLabel.DINNER_PERIOD.toString());     // Catch: Exception -> L21
        UserProfileLabel r2 = UserProfileLabel.INSTANCE;     // Catch: Exception -> L21
        String r3 = "";
        if (r1 == null) goto L8;
        String r4 = r1.b();     // Catch: Exception -> L21
        if (r4 == null) goto L8;
    L9:
        if (r1 == null) goto L14;
        String r5 = r1.a();     // Catch: Exception -> L21
        if (r5 == null) goto L14;
        r3 = r5;
    L14:
        List<UserProfileLabelQueryBean> r6 = r2.getLabelBeanList(r4, r3);     // Catch: Exception -> L21
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L20;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(((UserProfileLabelQueryBean) ZeusTransformUtils.preCheckCast(r6.get(0), UserProfileLabelQueryBean.class, "com.obric.memorydata.plugin")).getValue(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L20;
        return ((UserProfileLabelQueryBean) ZeusTransformUtils.preCheckCast(r6.get(0), UserProfileLabelQueryBean.class, "com.obric.memorydata.plugin")).getValue();
    L8:
        r4 = "";
    L20:
        return null;
    }

    private final Object o() {
        je r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao().queryOneRecordBy(ProfileLabel.SLEEP_MOMENT.toString());     // Catch: Exception -> L22
        UserProfileLabel r1 = UserProfileLabel.INSTANCE;     // Catch: Exception -> L22
        String r2 = "";
        if (r0 == null) goto L8;
        String r3 = r0.b();     // Catch: Exception -> L22
        if (r3 == null) goto L8;
    L9:
        if (r0 == null) goto L14;
        String r4 = r0.a();     // Catch: Exception -> L22
        if (r4 == null) goto L14;
        r2 = r4;
    L14:
        List<UserProfileLabelQueryBean> r5 = r1.getLabelBeanList(r3, r2);     // Catch: Exception -> L22
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L21;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(((UserProfileLabelQueryBean) ZeusTransformUtils.preCheckCast(r5.get(0), UserProfileLabelQueryBean.class, "com.obric.memorydata.plugin")).getValue(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L21;
        return ((UserProfileLabelQueryBean) ZeusTransformUtils.preCheckCast(r5.get(0), UserProfileLabelQueryBean.class, "com.obric.memorydata.plugin")).getValue();
    L21:
        return CollectionsKt.emptyList();
    L8:
        r3 = "";
        goto L9
    L23:
        return CollectionsKt.emptyList();
    }

    private final Object p() {
        je r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao().queryOneRecordBy(ProfileLabel.FROM_HOME_TO_COMPANY_PERIOD.toString());     // Catch: Exception -> L22
        UserProfileLabel r1 = UserProfileLabel.INSTANCE;     // Catch: Exception -> L22
        String r2 = "";
        if (r0 == null) goto L8;
        String r3 = r0.b();     // Catch: Exception -> L22
        if (r3 == null) goto L8;
    L9:
        if (r0 == null) goto L14;
        String r4 = r0.a();     // Catch: Exception -> L22
        if (r4 == null) goto L14;
        r2 = r4;
    L14:
        List<UserProfileLabelQueryBean> r5 = r1.getLabelBeanList(r3, r2);     // Catch: Exception -> L22
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L21;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(((UserProfileLabelQueryBean) ZeusTransformUtils.preCheckCast(r5.get(0), UserProfileLabelQueryBean.class, "com.obric.memorydata.plugin")).getValue(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L21;
        return ((UserProfileLabelQueryBean) ZeusTransformUtils.preCheckCast(r5.get(0), UserProfileLabelQueryBean.class, "com.obric.memorydata.plugin")).getValue();
    L21:
        return CollectionsKt.emptyList();
    L8:
        r3 = "";
        goto L9
    L23:
        return CollectionsKt.emptyList();
    }

    private final Object q() {
        je r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao().queryOneRecordBy(ProfileLabel.FROM_COMPANY_TO_HOME_PERIOD.toString());     // Catch: Exception -> L22
        UserProfileLabel r1 = UserProfileLabel.INSTANCE;     // Catch: Exception -> L22
        String r2 = "";
        if (r0 == null) goto L8;
        String r3 = r0.b();     // Catch: Exception -> L22
        if (r3 == null) goto L8;
    L9:
        if (r0 == null) goto L14;
        String r4 = r0.a();     // Catch: Exception -> L22
        if (r4 == null) goto L14;
        r2 = r4;
    L14:
        List<UserProfileLabelQueryBean> r5 = r1.getLabelBeanList(r3, r2);     // Catch: Exception -> L22
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L21;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(((UserProfileLabelQueryBean) ZeusTransformUtils.preCheckCast(r5.get(0), UserProfileLabelQueryBean.class, "com.obric.memorydata.plugin")).getValue(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L21;
        return ((UserProfileLabelQueryBean) ZeusTransformUtils.preCheckCast(r5.get(0), UserProfileLabelQueryBean.class, "com.obric.memorydata.plugin")).getValue();
    L21:
        return CollectionsKt.emptyList();
    L8:
        r3 = "";
        goto L9
    L23:
        return CollectionsKt.emptyList();
    }

    private final Object r() {
        je r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao().queryOneRecordBy(ProfileLabel.WAKEUP_MOMENT.toString());     // Catch: Exception -> L22
        UserProfileLabel r1 = UserProfileLabel.INSTANCE;     // Catch: Exception -> L22
        String r2 = "";
        if (r0 == null) goto L8;
        String r3 = r0.b();     // Catch: Exception -> L22
        if (r3 == null) goto L8;
    L9:
        if (r0 == null) goto L14;
        String r4 = r0.a();     // Catch: Exception -> L22
        if (r4 == null) goto L14;
        r2 = r4;
    L14:
        List<UserProfileLabelQueryBean> r5 = r1.getLabelBeanList(r3, r2);     // Catch: Exception -> L22
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L21;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(((UserProfileLabelQueryBean) ZeusTransformUtils.preCheckCast(r5.get(0), UserProfileLabelQueryBean.class, "com.obric.memorydata.plugin")).getValue(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L21;
        return ((UserProfileLabelQueryBean) ZeusTransformUtils.preCheckCast(r5.get(0), UserProfileLabelQueryBean.class, "com.obric.memorydata.plugin")).getValue();
    L21:
        return CollectionsKt.emptyList();
    L8:
        r3 = "";
        goto L9
    L23:
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.awareness.impl.producer.a
    public /* synthetic */ Set b() {
        return (Set) ZeusTransformUtils.preCheckCast(c(), Set.class, "com.obric.memorydata.plugin");
    }

    public HashSet<String> c() {
        return this.c;
    }

    @Override // com.obric.memorydata.awareness.impl.producer.a, com.obric.memorydata.awareness.api.b
    public void collectFeatures(List<String> r1, boolean r2) {
        Intrinsics.checkNotNullParameter((List) ZeusTransformUtils.wrapperContextForParams(r1, List.class, "com.obric.memorydata.plugin"), "featureNames");
    }

    public Set<String> d() {
        return this.d;
    }

    @Override // com.obric.memorydata.awareness.impl.producer.a, com.obric.memorydata.awareness.api.b
    public Object getFeature(String r2) {
        Intrinsics.checkNotNullParameter(r2, "featureName");
        if (d().contains(r2) == false) goto L8;
        Object r0 = super.getFeature(r2);
        if (r0 == null) goto L8;
        return r0;
    L8:
        return a(r2);
    }

    @Override // com.obric.memorydata.awareness.impl.producer.a, com.obric.memorydata.awareness.api.b
    public boolean hasDefineFeature(String r2) {
        Intrinsics.checkNotNullParameter(r2, "featureName");
        return c().contains(r2);
    }

    @Override // com.obric.memorydata.awareness.impl.producer.a, com.obric.memorydata.awareness.api.b
    public void setFeature(String r10, Object r11, Map<String, ? extends Object> r12) {
        Map<String, ? extends Object> r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "featureName");
        if (Intrinsics.areEqual(r10, "HOME_GPS_FENCE_LIST") == false) goto L20;
        if (r11 != null) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UserProfileFeature", "clear HOME_GPS_FENCE_LIST feature", false, 4, null);
        g();
        super.setFeature(r10, null, r13);
        return;
    L7:
        JSONObject r2 = a(r11);
        if (r2 != null) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UserProfileFeature", "set HOME_GPS_FENCE_LIST ignored: invalid value type or schema=" + r11.getClass().getName(), null, 4, null);
        return;
    L11:
        JSONArray r14 = r2.optJSONArray("HOME_GPS_FENCE_LIST");
        if (r14 == null) goto L14;
        int r15 = r14.length();
    L16:
        if (a(r2) == true) goto L18;
        return;
    L18:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UserProfileFeature", "set HOME_GPS_FENCE_LIST accepted, count=" + r15, false, 4, null);
        super.setFeature(r10, r2, r13);
        return;
    L14:
        r15 = 0;
        goto L16
    L20:
        super.setFeature(r10, r11, r13);
    }
}
