package com.obric.memorydata.personalcontext.search;

import androidx.core.app.NotificationCompat;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.personalcontext.q;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001MB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020\u000504¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0017\u00107\u001a\b\u0012\u0004\u0012\u00020\u000504¢\u0006\b\n\u0000\u001a\u0004\b8\u00106R\u001d\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\"¢\u0006\b\n\u0000\u001a\u0004\b:\u0010$R\u001d\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\"¢\u0006\b\n\u0000\u001a\u0004\b<\u0010$R\u001d\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\"¢\u0006\b\n\u0000\u001a\u0004\b>\u0010$R#\u0010?\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001f0@04¢\u0006\b\n\u0000\u001a\u0004\bA\u00106R\u000e\u0010B\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010F\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0014\u0010I\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010HR\u0014\u0010K\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bL\u0010H¨\u0006N"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/EntitySearchConstant;", "", "<init>", "()V", "KEY_SEARCH_PARAMS", "", "KEY_USER_RAW_QUERY", "KEY_SEARCH_TYPE", "KEY_INPUT_TYPE", "KEY_SEARCH_CONTROL_PARAMS", "KEY_MEMORY_SCENE", "KEY_SEARCH_RESULTS", "KEY_REPORT_PARAMS", "KEY_QU_RESULTS", "KEY_EXTRA_DATA", "KEY_ENTITY_SWITCH_STATUS", "KEY_ORIGIN_QUERY", "KEY_SCHDULE_TIME_DESCRIPTION", "KEY_PACKAGE_TOTAL_TIME_COST_LOG", "KEY_CODE", "KEY_ENTITY_MERGE_STRATEGY", "KEY_IS_OPTIMIZED_SEARCH", "KEY_ENTITY_OPT_SEARCH_TASK_ID_KEY", "KEY_IS_EVALUATING", "KEY_QUERY_PARAMS", "KEY_MEMORY_DOMAIN", "KEY_QUERY", "KEY_DOMAIN", "KEY_QU_REQUEST", "KEY_QU_RESPONSE", "GLOBAL_ASSISTANT_SEARCH_ENTITY_COUNT", "", "ENTITY_COUNT_PER_PAGE", "packageNameToTaskNameMap", "", "getPackageNameToTaskNameMap", "()Ljava/util/Map;", "DOMAIN_ALL", "DOMAIN_CONTACT", "DOMAIN_CALL_HISTORY", "DOMAIN_MEMORY", "DOMAIN_REC_MEMORY", "DOMAIN_AUTO_MEMORY_PRO", "SEARCH_ACTION_PREFIX", "EXTRA_KEY_HAS_PHOTO_HIGH_SEMANTIC", "EXTRA_KEY_GLOBAL_SEARCH_SUMMARY", "EXTRA_KEY_REFERENCE_CONTENT", "EXTRA_KEY_SEARCH_ENTITY_COUNT", "EXTRA_KEY_PHONE_TIMESTAMP", "EVALUATION_KEY_CHANGE_DATE_TIMESTAMP", "KEY_EVALUATION_PERSONAL_CONTEXT_SEARCH_CONTROL_PARAMS", "supportDomainList", "", "getSupportDomainList", "()Ljava/util/List;", "MEMORY_SUBDOMAIN_LIST", "getMEMORY_SUBDOMAIN_LIST", "domainToTask", "getDomainToTask", "TASK_TO_DOMAIN", "getTASK_TO_DOMAIN", "entityTypeToPackageNameMap", "getEntityTypeToPackageNameMap", "domainPriority", "Lkotlin/Pair;", "getDomainPriority", "FIELD_SUFFIX_PASSAGE", "FIELD_SUFFIX_COMMON_PHOTO_FILE", "FIELD_SUFFIX_COMMON_PHOTO_CAPTION", "FIELD_SUFFIX_FILE_FULL_CONTENT", "INTERACTION_TYPE_VOICE", "getINTERACTION_TYPE_VOICE", "()Ljava/lang/String;", "INTERACTION_TYPE_TEXT", "getINTERACTION_TYPE_TEXT", "MEMORY_SCENCE_USER_PREFERENCE", "getMEMORY_SCENCE_USER_PREFERENCE", "SearchControlParams", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f12308a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, String> f12309b = null;
    private static final List<String> c = null;
    private static final List<String> d = null;
    private static final Map<String, String> e = null;
    private static final Map<String, String> f = null;
    private static final Map<String, String> g = null;
    private static final List<Pair<String, Integer>> h = null;
    private static final String i = null;
    private static final String j = null;
    private static final String k = null;

    static {
        f12308a = new d();
        f12309b = MapsKt.mapOf(new Pair[]{TuplesKt.to(AppInfo.Gallery.getPackageName(), "in_app_search_photo"), TuplesKt.to(AppInfo.Contact.getPackageName(), "in_app_search_contact"), TuplesKt.to(AppInfo.Message.getPackageName(), "in_app_search_message"), TuplesKt.to(AppInfo.Note.getPackageName(), "in_app_search_note"), TuplesKt.to(AppInfo.AiRecordAssistant.getPackageName(), "in_app_search_recording"), TuplesKt.to(AppInfo.Recorder.getPackageName(), "in_app_search_recording"), TuplesKt.to(NotificationCompat.CATEGORY_ALARM, "in_app_search_alarm"), TuplesKt.to("album", "in_app_search_album"), TuplesKt.to("callhistory", "in_app_search_call_history"), TuplesKt.to("file", "in_app_search_file"), TuplesKt.to("schedule", "in_app_search_schedule"), TuplesKt.to("countdown", "in_app_search_countdown")});
        c = q.f12255a.e();
        d = q.f12255a.c();
        e = q.f12255a.f();
        f = q.f12255a.g();
        g = q.f12255a.h();
        h = q.f12255a.l();
        i = "VOICE";
        j = "TEXT";
        k = "UserPreference";
    }

    private d() {
    }

    public final Map<String, String> a() {
        return f12309b;
    }

    public final List<String> b() {
        return c;
    }

    public final List<String> c() {
        return d;
    }

    public final Map<String, String> d() {
        return e;
    }

    public final Map<String, String> e() {
        return f;
    }

    public final Map<String, String> f() {
        return g;
    }

    public final List<Pair<String, Integer>> g() {
        return h;
    }

    public final String h() {
        return i;
    }
}
