package com.obric.memorydata.personalcontext;

import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.personalcontext.storage.aa;
import com.obric.memorydata.personalcontext.storage.ab;
import com.obric.memorydata.personalcontext.storage.ac;
import com.obric.memorydata.personalcontext.storage.t;
import com.obric.memorydata.personalcontext.storage.u;
import com.obric.memorydata.personalcontext.storage.v;
import com.obric.memorydata.personalcontext.storage.w;
import com.obric.memorydata.personalcontext.storage.x;
import com.obric.memorydata.personalcontext.storage.y;
import com.obric.memorydata.personalcontext.storage.z;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0002\b\u0016\n\u0002\u0010 \n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0007R&\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00120\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00110)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u000fR\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00110)¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u000fR\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00110)¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u000fR\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00110)¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u000fR\u001d\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0014R\u001d\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0014R\u001d\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0014R\u000e\u00107\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00110\u0012¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u001d\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0005¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\u0014R\u001d\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0005¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\u0014R#\u0010S\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060T0)¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u000fR\u001d\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0005¢\u0006\b\n\u0000\u001a\u0004\bW\u0010\u0014R\u0017\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00110\r¢\u0006\b\n\u0000\u001a\u0004\bY\u0010\u000fR\u0017\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00110\u0012¢\u0006\b\n\u0000\u001a\u0004\b[\u0010NR\u0017\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00110\u0012¢\u0006\b\n\u0000\u001a\u0004\b]\u0010NR\u0017\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00110\r¢\u0006\b\n\u0000\u001a\u0004\b_\u0010\u000fR\u0019\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00110a¢\u0006\n\n\u0002\u0010d\u001a\u0004\bb\u0010cR\u0019\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00110a¢\u0006\n\n\u0002\u0010d\u001a\u0004\bf\u0010cR\u0017\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00110\u0012¢\u0006\b\n\u0000\u001a\u0004\bh\u0010NR)\u0010i\u001a\u001a\u0012\u0004\u0012\u00020\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020k\u0012\u0004\u0012\u00020k0T0j¢\u0006\b\n\u0000\u001a\u0004\bl\u0010\u0014R\u001d\u0010m\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020n0\u0005¢\u0006\b\n\u0000\u001a\u0004\bo\u0010\u0014R\u0017\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00110\u0012¢\u0006\b\n\u0000\u001a\u0004\bq\u0010N¨\u0006r"}, d2 = {"Lcom/obric/memorydata/personalcontext/PCFlavor;", "", "<init>", "()V", "entityTypeToStorageMap", "", "", "", "Lcom/obric/memorydata/personalcontext/storage/AbstractAppEntityStorage;", "getEntityStorageBy", "entityType", "isBackUp", "memoryEntityTypeList", "", "getMemoryEntityTypeList", "()Ljava/util/List;", "packageNameToSearchSupportedEntityTypeMap", "", "", "getPackageNameToSearchSupportedEntityTypeMap", "()Ljava/util/Map;", "DOMAIN_CONTACT", "DOMAIN_CALL_HISTORY", "DOMAIN_SMS", "DOMAIN_NOTE", "DOMAIN_PHOTO", "DOMAIN_ALBUM", "DOMAIN_ALARM", "DOMAIN_SCHEDULE", "DOMAIN_FILE", "DOMAIN_RECORDING", "DOMAIN_COUNTDOWN", "DOMAIN_AUDITORY_RECORDING", "DOMAIN_MEMORY_ORDER", "DOMAIN_MEMORY_MARK", "DOMAIN_MEMORY_SCHEDULE", "DOMAIN_ALL_MEMORY", "DOMAIN_USER_PROFILE", "DOMAIN_LIFE_LOG", "DOMAIN_SEARCH_ASSISTANT_MEMORY", "MEMORY_SUBDOMAIN_LIST", "", "getMEMORY_SUBDOMAIN_LIST", "APP_ENTITY_DOMAIN_LIST", "getAPP_ENTITY_DOMAIN_LIST", "ALL_PACKAGE_DOMAIN_LIST", "getALL_PACKAGE_DOMAIN_LIST", "supportDomainList", "getSupportDomainList", "domainToTask", "getDomainToTask", "TASK_TO_DOMAIN", "getTASK_TO_DOMAIN", "entityTypeToPackageNameMap", "getEntityTypeToPackageNameMap", "ACTION_SEARCH_SMS", "ACTION_SEARCH_CONTACT", "ACTION_SEARCH_CALL_HISTORY", "ACTION_SEARCH_PHOTO", "ACTION_SEARCH_ALBUM", "ACTION_SEARCH_NOTE", "ACTION_SEARCH_ALARM", "ACTION_SEARCH_RECORDING", "ACTION_SEARCH_FILE", "ACTION_SEARCH_SCHEDULE", "ACTION_SEARCH_COUNTDOWN", "ACTION_SEARCH_MEMORY", "ACTION_SEARCH_MEMORY_ORDER", "ACTION_SEARCH_MEMORY_SCHEDULE", "ACTION_SEARCH_MEMORY_MARK", "ACTION_SEARCH_REC_MEMORY", "ACTION_SEARCH_AUDITORY_RECORDING", "ACTION_SEARCH_ALL_MEMORY", "ACTION_SEARCH_COMMON_ADDRESS", "ACTION_SEARCH_LIFE_LOG", "ACTION_SEARCH_ASSISTANT_MEMORY", "multiDomainActionSet", "getMultiDomainActionSet", "()Ljava/util/Set;", "domainToActionMap", "getDomainToActionMap", "actionToDomainMap", "getActionToDomainMap", "domainPriority", "Lkotlin/Pair;", "getDomainPriority", "vectorCopilotToRawDbName", "getVectorCopilotToRawDbName", "preloadPackageSets", "getPreloadPackageSets", "defaultModelsInSearch", "getDefaultModelsInSearch", "defaultLoraInSearch", "getDefaultLoraInSearch", "aikernelPackageSets", "getAikernelPackageSets", "entitySearchDependentModels", "", "getEntitySearchDependentModels", "()[Ljava/lang/String;", "[Ljava/lang/String;", "entitySearchDependentLora", "getEntitySearchDependentLora", "IN_APP_SEARCH_FULL_RESULT_PACKAGES", "getIN_APP_SEARCH_FULL_RESULT_PACKAGES", "nonPersonalRawTableToVectorDbOptions", "", "Lcom/obric/dejavu/library/DbOptions;", "getNonPersonalRawTableToVectorDbOptions", "personalVectorDbOptionsBuilders", "Lcom/obric/memorydata/middleware/database/VectorDbOptionsBuilder;", "getPersonalVectorDbOptionsBuilders", "personalRawTableSet", "getPersonalRawTableSet", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f12255a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<Integer, Map<Boolean, com.obric.memorydata.personalcontext.storage.a>> f12256b = null;
    private static final List<Integer> c = null;
    private static final Map<String, Set<Integer>> d = null;
    private static final List<String> e = null;
    private static final List<String> f = null;
    private static final List<String> g = null;
    private static final List<String> h = null;
    private static final Map<String, String> i = null;
    private static final Map<String, String> j = null;
    private static final Map<String, String> k = null;
    private static final Set<String> l = null;
    private static final Map<String, String> m = null;
    private static final Map<String, String> n = null;
    private static final List<Pair<String, Integer>> o = null;
    private static final Map<String, String> p = null;
    private static final List<String> q = null;
    private static final Set<String> r = null;
    private static final Set<String> s = null;
    private static final List<String> t = null;
    private static final String[] u = null;
    private static final String[] v = null;
    private static final Set<String> w = null;
    private static final Map<String, Pair<com.obric.dejavu.library.d, com.obric.dejavu.library.d>> x = null;
    private static final Map<String, com.obric.memorydata.middleware.database.n> y = null;
    private static final Set<String> z = null;

    static {
        f12255a = new q();
        f12256b = MapsKt.mapOf(new Pair[]{TuplesKt.to(101, MapsKt.mapOf(TuplesKt.to(false, new t()))), TuplesKt.to(201, MapsKt.mapOf(TuplesKt.to(false, new com.obric.memorydata.personalcontext.storage.l()))), TuplesKt.to(202, MapsKt.mapOf(TuplesKt.to(false, new com.obric.memorydata.personalcontext.storage.j()))), TuplesKt.to(601, MapsKt.mapOf(TuplesKt.to(false, new v()))), TuplesKt.to(301, MapsKt.mapOf(TuplesKt.to(false, new w()))), TuplesKt.to(302, MapsKt.mapOf(TuplesKt.to(false, new com.obric.memorydata.personalcontext.storage.c()))), TuplesKt.to(303, MapsKt.mapOf(TuplesKt.to(false, new x()))), TuplesKt.to(701, MapsKt.mapOf(TuplesKt.to(false, new com.obric.memorydata.personalcontext.storage.b()))), TuplesKt.to(501, MapsKt.mapOf(TuplesKt.to(false, new y()))), TuplesKt.to(902, MapsKt.mapOf(TuplesKt.to(false, new com.obric.memorydata.personalcontext.storage.i()))), TuplesKt.to(401, MapsKt.mapOf(TuplesKt.to(false, new z()))), TuplesKt.to(Integer.valueOf(EntityType.FILE), MapsKt.mapOf(TuplesKt.to(false, new com.obric.memorydata.personalcontext.storage.o()))), TuplesKt.to(-308, MapsKt.mapOf(TuplesKt.to(false, new com.obric.memorydata.personalcontext.storage.p()))), TuplesKt.to(702, MapsKt.mapOf(TuplesKt.to(false, new com.obric.memorydata.personalcontext.storage.m()))), TuplesKt.to(502, MapsKt.mapOf(TuplesKt.to(false, new com.obric.memorydata.personalcontext.storage.f()))), TuplesKt.to(Integer.valueOf(NetError.ERR_INVALID_REDIRECT), MapsKt.mapOf(new Pair[]{TuplesKt.to(false, new com.obric.memorydata.personalcontext.storage.s()), TuplesKt.to(true, new com.obric.memorydata.personalcontext.storage.a.e())})), TuplesKt.to(-313, MapsKt.mapOf(TuplesKt.to(false, new com.obric.memorydata.personalcontext.storage.g()))), TuplesKt.to(-306, MapsKt.mapOf(new Pair[]{TuplesKt.to(false, new ab()), TuplesKt.to(true, new com.obric.memorydata.personalcontext.storage.a.b())})), TuplesKt.to(-314, MapsKt.mapOf(TuplesKt.to(true, new com.obric.memorydata.personalcontext.storage.a.c()))), TuplesKt.to(Integer.valueOf(NetError.ERR_CACHE_READ_FAILURE), MapsKt.mapOf(new Pair[]{TuplesKt.to(true, new com.obric.memorydata.personalcontext.storage.a.f()), TuplesKt.to(false, new aa())})), TuplesKt.to(Integer.valueOf(EntityType.LIFE_LOG), MapsKt.mapOf(TuplesKt.to(true, new com.obric.memorydata.personalcontext.storage.a.d()))), TuplesKt.to(Integer.valueOf(EntityType.USER_PROFILE), MapsKt.mapOf(TuplesKt.to(true, new com.obric.memorydata.personalcontext.storage.a.g()))), TuplesKt.to(Integer.valueOf(NetError.ERR_DISALLOWED_URL_SCHEME), MapsKt.mapOf(TuplesKt.to(false, new u()))), TuplesKt.to(-304, MapsKt.mapOf(TuplesKt.to(false, new ac()))), TuplesKt.to(402, MapsKt.mapOf(TuplesKt.to(false, new com.obric.memorydata.personalcontext.storage.q()))), TuplesKt.to(Integer.valueOf(EntityType.DOUBAO_ACCOUNT), MapsKt.mapOf(TuplesKt.to(false, new com.obric.memorydata.personalcontext.storage.n()))), TuplesKt.to(Integer.valueOf(EntityType.MEMORY_INFO_COMMON), MapsKt.mapOf(TuplesKt.to(false, new com.obric.memorydata.personalcontext.storage.r()))), TuplesKt.to(Integer.valueOf(EntityType.MEMORY_COMMON_TEXT), MapsKt.mapOf(TuplesKt.to(false, new com.obric.memorydata.personalcontext.storage.k()))), TuplesKt.to(Integer.valueOf(NetError.ERR_CACHE_OPERATION_NOT_SUPPORTED), MapsKt.mapOf(new Pair[]{TuplesKt.to(true, new com.obric.memorydata.personalcontext.storage.a.a()), TuplesKt.to(false, new com.obric.memorydata.personalcontext.storage.h())}))});
        c = CollectionsKt.mutableListOf(new Integer[]{10001, 10002, 10003, 10004, 10005, 10006, Integer.valueOf(EntityType.MEMORY_INFO_DOCUMENTS), Integer.valueOf(EntityType.MEMORY_INFO_ADDRESS), Integer.valueOf(EntityType.MEMORY_INFO_ANNIVERSARY), Integer.valueOf(EntityType.MEMORY_INFO_RELATIONSHIP), Integer.valueOf(EntityType.MEMORY_INFO_COMMON), Integer.valueOf(EntityType.MEMORY_COLLECT_CONTENT), Integer.valueOf(EntityType.MEMORY_COLLECT_STORE), Integer.valueOf(EntityType.MEMORY_EVENT_SCHEDULE), Integer.valueOf(EntityType.MEMORY_EVENT_TODO), Integer.valueOf(EntityType.MEMORY_COMMON_TEXT)});
        d = MapsKt.mapOf(new Pair[]{TuplesKt.to(AppInfo.AiRecordAssistant.getPackageName(), SetsKt.setOf(new Integer[]{501, 601, 202})), TuplesKt.to(AppInfo.OAssistant.getPackageName(), SetsKt.setOf(new Integer[]{701, 702}))});
        List<String> r0 = CollectionsKt.listOf(new String[]{"MemoryOrder", "MemoryMark", "MemorySchedule"});
        e = r0;
        List<String> r1 = CollectionsKt.listOf(new String[]{"Sms", com.tom_roush.pdfbox.pdmodel.a.d.i.H, "Photo", "Contact", "Album", "Alarm", "CallHistory", "Recording", "Schedule", "File", "Countdown", "AuditoryRecording", "UserProfile", "LifeLog", "SearchAssistantMemory"});
        f = r1;
        g = CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin"), "Memory");
        h = CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"));
        i = MapsKt.mapOf(new Pair[]{TuplesKt.to("Sms", "in_app_search_message"), TuplesKt.to(com.tom_roush.pdfbox.pdmodel.a.d.i.H, "in_app_search_note"), TuplesKt.to("Photo", "in_app_search_photo"), TuplesKt.to("Contact", "in_app_search_contact"), TuplesKt.to("Album", "in_app_search_album"), TuplesKt.to("Alarm", "in_app_search_alarm"), TuplesKt.to("CallHistory", "in_app_search_call_history"), TuplesKt.to("Memory", "memory_search"), TuplesKt.to("RecMemory", "recommend_memory_search"), TuplesKt.to("Recording", "in_app_search_recording"), TuplesKt.to("File", "in_app_search_file"), TuplesKt.to("Countdown", "in_app_search_countdown"), TuplesKt.to("Schedule", "in_app_search_schedule"), TuplesKt.to("AuditoryRecording", "in_app_search_auditory_recording"), TuplesKt.to("AllMemory", "in_app_search_all_memory"), TuplesKt.to("LifeLog", "in_app_search_lifelog")});
        j = MapsKt.mapOf(new Pair[]{TuplesKt.to("in_app_search_message", "Sms"), TuplesKt.to("in_app_search_note", com.tom_roush.pdfbox.pdmodel.a.d.i.H), TuplesKt.to("in_app_search_photo", "Photo"), TuplesKt.to("in_app_search_contact", "Contact"), TuplesKt.to("in_app_search_album", "Album"), TuplesKt.to("in_app_search_alarm", "Alarm"), TuplesKt.to("in_app_search_call_history", "CallHistory"), TuplesKt.to("memory_search", "Memory"), TuplesKt.to("in_app_search_recording", "Recording"), TuplesKt.to("recommend_memory_search", "RecMemory"), TuplesKt.to("in_app_search_file", "File"), TuplesKt.to("in_app_search_schedule", "Schedule"), TuplesKt.to("in_app_search_countdown", "Countdown"), TuplesKt.to("in_app_search_auditory_recording", "AuditoryRecording"), TuplesKt.to("in_app_search_all_memory", "AllMemory"), TuplesKt.to("in_app_search_lifelog", "LifeLog")});
        k = MapsKt.mapOf(new Pair[]{TuplesKt.to("Sms", AppInfo.Message.getPackageName()), TuplesKt.to(com.tom_roush.pdfbox.pdmodel.a.d.i.H, AppInfo.Note.getPackageName()), TuplesKt.to("Photo", AppInfo.Gallery.getPackageName()), TuplesKt.to("Contact", AppInfo.Contact.getPackageName()), TuplesKt.to("Album", AppInfo.Gallery.getPackageName()), TuplesKt.to("CallHistory", AppInfo.Contact.getPackageName()), TuplesKt.to("Alarm", AppInfo.Contact.getPackageName()), TuplesKt.to("Recording", AppInfo.Recorder.getPackageName()), TuplesKt.to("File", AppContext.INSTANCE.getPackageName()), TuplesKt.to("Schedule", AppInfo.Calendar.getPackageName()), TuplesKt.to("Countdown", AppInfo.Alarm.getPackageName()), TuplesKt.to("AuditoryRecording", AppInfo.Recorder.getPackageName()), TuplesKt.to("AllMemory", AppContext.INSTANCE.getPackageName()), TuplesKt.to("UserProfile", AppContext.INSTANCE.getPackageName()), TuplesKt.to("LifeLog", AppContext.INSTANCE.getPackageName())});
        l = SetsKt.setOf("SearchAssistantMemory");
        Map<String, String> r2 = MapsKt.mapOf(new Pair[]{TuplesKt.to("Contact", "SearchContact"), TuplesKt.to("CallHistory", "SearchCallHistory"), TuplesKt.to("Sms", "SearchSms"), TuplesKt.to(com.tom_roush.pdfbox.pdmodel.a.d.i.H, "SearchNote"), TuplesKt.to("Photo", "SearchPhoto"), TuplesKt.to("Album", "SearchAlbum"), TuplesKt.to("Alarm", "SearchAlarm"), TuplesKt.to("Recording", "SearchRecording"), TuplesKt.to("File", "SearchFile"), TuplesKt.to("Schedule", "SearchSchedule"), TuplesKt.to("Countdown", "SearchCountdown"), TuplesKt.to("Memory", "SearchMemory"), TuplesKt.to("MemoryOrder", "SearchMemoryOrder"), TuplesKt.to("MemorySchedule", "SearchMemorySchedule"), TuplesKt.to("MemoryMark", "SearchMemoryMark"), TuplesKt.to("RecMemory", "SearchRecMemory"), TuplesKt.to("AuditoryRecording", "SearchAuditoryRecording"), TuplesKt.to("AllMemory", "SearchAllMemory"), TuplesKt.to("UserProfile", "SearchCommonAddress"), TuplesKt.to("LifeLog", "SearchLifeLog"), TuplesKt.to("SearchAssistantMemory", "SearchAssistantMemory")});
        m = r2;
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r2.size()), Collection.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<String, String>> r3 = r2.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Map.Entry r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r4.add(TuplesKt.to(r14.getValue(), r14.getKey()));
        goto L4
    L6:
        n = MapsKt.toMap((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        o = CollectionsKt.listOf(new Pair[]{new Pair("Contact", 1), new Pair("Sms", 1), new Pair("Photo", 1), new Pair(com.tom_roush.pdfbox.pdmodel.a.d.i.H, 1), new Pair("CallHistory", 1), new Pair("Album", 1), new Pair("Alarm", 1), new Pair("Schedule", 1), new Pair("File", 1), new Pair("Recording", 1), new Pair("Countdown", 1), new Pair("Memory", 1), new Pair("AuditoryRecording", 1), new Pair("LifeLog", 1), new Pair("UserProfile", 1)});
        p = MapsKt.mapOf(new Pair[]{TuplesKt.to("ContactEntityTextVectorCopilot", "RawContactEntity"), TuplesKt.to("ContactEntityImageVectorCopilot", "RawContactEntity"), TuplesKt.to("CallHistoryEntityTextVectorCopilot", "RawContactEntity"), TuplesKt.to("MessageEntityTextVectorCopilot", "RawMessageEntity"), TuplesKt.to("MessageEntityImageVectorCopilot", "RawMessageEntity"), TuplesKt.to("PhotoEntityTextVectorCopilot", "RawPhotoEntity"), TuplesKt.to("PhotoEntityImageVectorCopilot", "RawPhotoEntity"), TuplesKt.to("MetaLocationEntityTextVectorCopilot", "RawMetaLocationEntity"), TuplesKt.to("NoteEntityTextVectorCopilot", "RawNoteEntity"), TuplesKt.to("NoteEntityImageVectorCopilot", "RawNoteEntity"), TuplesKt.to("FileEntityTextVectorCopilot", "RawFileEntity"), TuplesKt.to("FileTextEntityTextVectorCopilot", "RawFileTextEntity"), TuplesKt.to("RecordingEntityTextVectorCopilot", "RawRecordingEntity"), TuplesKt.to("RecordingTextEntityTextVectorCopilot", "RawRecordingTextEntity"), TuplesKt.to("NoteRecordingEntityTextVectorCopilot", "RawNoteRecordingEntity"), TuplesKt.to("NoteRecordingTextEntityTextVectorCopilot", "RawNoteRecordingTextEntity"), TuplesKt.to("ScheduleEntityTextVectorCopilot", "RawScheduleEntity"), TuplesKt.to("CountdownEntityTextVectorCopilot", "RawCountdownEntity"), TuplesKt.to("AuditoryRecordingEntityTextVectorCopilot", "RawAuditoryRecordingEntity"), TuplesKt.to("AuditoryRecordingTextEntityTextVectorCopilot", "RawAuditoryRecordingTextEntity"), TuplesKt.to("UserProfileEntityTextVectorCopilot", "RawUserProfileEntity"), TuplesKt.to("LifeLogEntityTextVectorCopilot", "Lifelog"), TuplesKt.to("SemanticTextCopilot", "UnionSemanticMemory"), TuplesKt.to("AutoMemoryProTextVectorCopilot", "AutoMemoryPro")});
        q = CollectionsKt.mutableListOf(new String[]{com.obric.memorydata.database.entity.d.FAST_INDEX_TASK_NAME, com.obric.memorydata.database.entity.d.SLOW_INDEX_TASK_NAME, "build_entity_full_content", "search_app_entity", "personal_context_search", "time_extract", "bert_all_in_one", "in_app_search_contact", "in_app_search_call_history", "in_app_search_message", "in_app_search_photo", "in_app_search_note", "in_app_search_alarm", "in_app_search_album", "in_app_search_schedule", "in_app_search_file", "in_app_search_countdown", "memory_search", "recommend_memory_search", "personal_context_kg_retrieval", "in_app_search_lifelog"});
        r = SetsKt.setOf(new String[]{"memory_text_embedding_v2", "clip_text_embedding_v2_edge"});
        s = SetsKt.setOf("embedding");
        t = CollectionsKt.mutableListOf(new String[]{"on_screen_ner"});
        u = new String[]{"memory_text_embedding_v2", "clip_text_embedding_v2_edge"};
        v = new String[]{"embedding"};
        w = SetsKt.setOf(new String[]{AppInfo.Contact.getPackageName(), AppInfo.Message.getPackageName(), AppInfo.Note.getPackageName(), AppInfo.AiRecordAssistant.getPackageName(), AppInfo.Recorder.getPackageName(), AppInfo.Alarm.getPackageName(), AppInfo.Calendar.getPackageName(), "file", "schedule", "countdown", "UserProfile"});
        x = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("ElementRelationTemporaryDataVector", new Pair(new com.obric.dejavu.library.d("element_relation_temporary", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("element_relation_temporary_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("ElementPropertyTemporaryDataVector", new Pair(new com.obric.dejavu.library.d("element_property_temporary", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("element_property_temporary_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("ElementRelationData", new Pair(new com.obric.dejavu.library.d("element_relation", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("element_relation_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("ElementPropertyData", new Pair(new com.obric.dejavu.library.d("element_property", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("element_property_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("ElementSummary", new Pair(new com.obric.dejavu.library.d("element_summary", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("element_summary_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("ContactEntityTextVectorCopilot", new Pair(new com.obric.dejavu.library.d("contact_entity_text_vector_copilot", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("contact_entity_text_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("ContactEntityImageVectorCopilot", new Pair(new com.obric.dejavu.library.d("contact_entity_image_vector_copilot", 512, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("contact_entity_image_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("CallHistoryEntityTextVectorCopilot", new Pair(new com.obric.dejavu.library.d("call_history_entity_text_vector_copilot", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("call_history_entity_text_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("NoteEntityTextVectorCopilot", new Pair(new com.obric.dejavu.library.d("note_entity_text_vector_copilot", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("note_entity_text_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("NoteEntityImageVectorCopilot", new Pair(new com.obric.dejavu.library.d("note_entity_image_vector_copilot", 512, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("note_entity_image_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("MessageEntityTextVectorCopilot", new Pair(new com.obric.dejavu.library.d("message_entity_text_vector_copilot", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("message_entity_text_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("MessageEntityImageVectorCopilot", new Pair(new com.obric.dejavu.library.d("message_entity_image_vector_copilot", 512, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("message_entity_image_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("PhotoEntityTextVectorCopilot", new Pair(new com.obric.dejavu.library.d("photo_entity_text_vector_copilot", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("photo_entity_text_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("PhotoEntityImageVectorCopilot", new Pair(new com.obric.dejavu.library.d("photo_entity_image_vector_copilot", 512, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("photo_entity_image_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("MetaLocationEntityTextVectorCopilot", new Pair(new com.obric.dejavu.library.d("meta_location_entity_text_vector_copilot", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("meta_location_entity_text_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("VideoFrameEntityTextVectorCopilot", new Pair(new com.obric.dejavu.library.d("video_frame_entity_text_vector_copilot", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("video_frame_entity_text_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("VideoFrameEntityImageVectorCopilot", new Pair(new com.obric.dejavu.library.d("video_frame_entity_image_vector_copilot", 512, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("video_frame_entity_image_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("AlarmEntityTextVectorCopilot", new Pair(new com.obric.dejavu.library.d("alarm_entity_text_vector_copilot", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("alarm_entity_text_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("MemoryEntityTextVectorCopilot", new Pair(new com.obric.dejavu.library.d("memory_entity_text_vector_copilot", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("memory_entity_text_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("MemoryLocationEntityTextVectorCopilot", new Pair(new com.obric.dejavu.library.d("memory_location_entity_text_vector_copilot", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("memory_location_entity_text_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("FileEntityTextVectorCopilot", new Pair(new com.obric.dejavu.library.d("file_entity_text_vector_copilot", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("file_entity_text_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("FileTextEntityTextVectorCopilot", new Pair(new com.obric.dejavu.library.d("file_text_entity_text_vector_copilot", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("file_text_entity_text_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("RecordingEntityTextVectorCopilot", new Pair(new com.obric.dejavu.library.d("recording_entity_text_vector_copilot", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("recording_entity_text_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("RecordingTextEntityTextVectorCopilot", new Pair(new com.obric.dejavu.library.d("recording_text_entity_text_vector_copilot", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("recording_text_entity_text_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("AuditoryRecordingEntityTextVectorCopilot", new Pair(new com.obric.dejavu.library.d("auditory_recording_entity_text_vector_copilot", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("auditory_recording_entity_text_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("AuditoryRecordingTextEntityTextVectorCopilot", new Pair(new com.obric.dejavu.library.d("auditory_recording_text_entity_text_vector_copilot", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("auditory_recording_text_entity_text_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("NoteRecordingEntityTextVectorCopilot", new Pair(new com.obric.dejavu.library.d("note_recording_entity_text_vector_copilot", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("note_recording_entity_text_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("NoteRecordingTextEntityTextVectorCopilot", new Pair(new com.obric.dejavu.library.d("note_recording_text_entity_text_vector_copilot", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("note_recording_text_entity_text_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("ScheduleEntityTextVectorCopilot", new Pair(new com.obric.dejavu.library.d("schedule_entity_text_vector_copilot", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("schedule_entity_text_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("CountdownEntityTextVectorCopilot", new Pair(new com.obric.dejavu.library.d("countdown_entity_text_vector_copilot", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("countdown_entity_text_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("CommonPhotoEntityTextVectorCopilot", new Pair(new com.obric.dejavu.library.d("common_photo_entity_text_vector_copilot", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("common_photo_entity_text_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("CommonPhotoEntityImageVectorCopilot", new Pair(new com.obric.dejavu.library.d("common_photo_entity_image_vector_copilot", 512, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("common_photo_entity_image_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("CommonVideoFrameEntityTextVectorCopilot", new Pair(new com.obric.dejavu.library.d("common_video_frame_entity_text_vector_copilot", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("common_video_frame_entity_text_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null))), TuplesKt.to("CommonVideoFrameEntityImageVectorCopilot", new Pair(new com.obric.dejavu.library.d("common_video_frame_entity_image_vector_copilot", 512, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null), new com.obric.dejavu.library.d("common_video_frame_entity_image_vector_copilot_vlm", 768, true, false, 0, null, com.obric.memorydata.personalcontext.vectordb.e.f12410a.a(), 56, null)))});
        y = MapsKt.mapOf(new Pair[]{TuplesKt.to("ShortMemoryTextVectorCopilot", new com.obric.memorydata.middleware.database.n().a("short_memory_entity_text_vector_copilot").a(768).b(true).a(com.obric.memorydata.personalcontext.vectordb.e.f12410a.a()).a(true)), TuplesKt.to("EpisodicTopicMemoryTextVectorCopilot", new com.obric.memorydata.middleware.database.n().a("episodic_topic_memory_text_vector_copilot").a(768).b(true).a(com.obric.memorydata.personalcontext.vectordb.e.f12410a.a()).a(true)), TuplesKt.to("UserProfileEntityTextVectorCopilot", new com.obric.memorydata.middleware.database.n().a("user_profile_entity_text_vector_copilot").a(768).b(true).a(com.obric.memorydata.personalcontext.vectordb.e.f12410a.a()).a(true)), TuplesKt.to("LifeLogEntityTextVectorCopilot", new com.obric.memorydata.middleware.database.n().a("life_log_entity_text_vector_copilot").a(768).b(true).a(com.obric.memorydata.personalcontext.vectordb.e.f12410a.a()).a(true)), TuplesKt.to("SemanticTextCopilot", new com.obric.memorydata.middleware.database.n().a("semantic_text_copilot").a(768).b(true).a(com.obric.memorydata.personalcontext.vectordb.e.f12410a.a()).a(true)), TuplesKt.to("AutoMemoryProTextVectorCopilot", new com.obric.memorydata.middleware.database.n().a("auto_memory_pro_text_vector_copilot").a(768).b(true).a(com.obric.memorydata.personalcontext.vectordb.e.f12410a.a()).a(true))});
        z = SetsKt.setOf(new String[]{"ShortMemoryTextVectorCopilot", "EpisodicTopicMemoryTextVectorCopilot", "UserProfileEntityTextVectorCopilot", "LifeLogEntityTextVectorCopilot", "SemanticTextCopilot", "AutoMemoryProTextVectorCopilot"});
    }

    private q() {
    }

    public static /* synthetic */ com.obric.memorydata.personalcontext.storage.a a(q r0, int r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return r0.a(r1, r2);
    }

    public final com.obric.memorydata.personalcontext.storage.a a(int r2, boolean r3) {
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(f12256b.get(Integer.valueOf(r2)), Map.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return null;
    L7:
        return (com.obric.memorydata.personalcontext.storage.a) ZeusTransformUtils.preCheckCast(r1.get(Boolean.valueOf(r3)), com.obric.memorydata.personalcontext.storage.a.class, "com.obric.memorydata.plugin");
    }

    public final List<Integer> a() {
        return c;
    }

    public final Map<String, Set<Integer>> b() {
        return d;
    }

    public final List<String> c() {
        return e;
    }

    public final List<String> d() {
        return g;
    }

    public final List<String> e() {
        return h;
    }

    public final Map<String, String> f() {
        return i;
    }

    public final Map<String, String> g() {
        return j;
    }

    public final Map<String, String> h() {
        return k;
    }

    public final Set<String> i() {
        return l;
    }

    public final Map<String, String> j() {
        return m;
    }

    public final Map<String, String> k() {
        return n;
    }

    public final List<Pair<String, Integer>> l() {
        return o;
    }

    public final Map<String, String> m() {
        return p;
    }

    public final List<String> n() {
        return q;
    }

    public final Set<String> o() {
        return r;
    }

    public final Set<String> p() {
        return s;
    }

    public final List<String> q() {
        return t;
    }

    public final String[] r() {
        return u;
    }

    public final String[] s() {
        return v;
    }

    public final Set<String> t() {
        return w;
    }

    public final Map<String, Pair<com.obric.dejavu.library.d, com.obric.dejavu.library.d>> u() {
        return x;
    }

    public final Map<String, com.obric.memorydata.middleware.database.n> v() {
        return y;
    }

    public final Set<String> w() {
        return z;
    }
}
