package com.obric.memorydata.personalcontext.search.global;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.search.InAppSearchEntityParam;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.fj;
import com.obric.memorydata.database.entity.ge;
import com.obric.memorydata.database.entity.hh;
import com.obric.memorydata.database.index.s;
import com.obric.memorydata.database.model.EntitySearchRecordInfo;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.personalcontext.log.EvaluationResult;
import com.obric.memorydata.personalcontext.q;
import com.obric.memorydata.personalcontext.search.entity.SearchResultEntry;
import com.obric.memorydata.personalcontext.search.entity.SearchType;
import com.obric.memorydata.personalcontext.search.kg.KnowledgeGraphResponse;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantIntentSearchResponse;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchEntityResult;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchKgResult;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchMemoryResult;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchResponse;
import com.obric.memorydata.sdk.entity.global.ProactiveRecommendationSearchResult;
import com.obric.memorydata.sdk.entity.search.GlobalIntentSearchModel;
import com.obric.memorydata.sdk.entity.search.GlobalQUResult;
import com.obric.memorydata.sdk.entity.search.RewriteQuery;
import com.obric.memorydata.sdk.entity.search.SearchDomainQuery;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.utils.at;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0011\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J\u0016\u0010 \u001a\u00020\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002J\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\"2\u0006\u0010&\u001a\u00020\u0005H\u0002J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0002J\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005H\u0002J&\u0010-\u001a\u00020\u00052\b\u0010.\u001a\u0004\u0018\u00010\u00052\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000500H\u0002Jj\u00101\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00052\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00050\"2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00052\b\u00103\u001a\u0004\u0018\u00010\u00052\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u00052\b\b\u0002\u00108\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0005Jj\u0010:\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00052\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00050\"2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00052\b\u00103\u001a\u0004\u0018\u00010\u00052\u0006\u00104\u001a\u0002052\u0006\u0010;\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u00052\b\b\u0002\u00108\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0005J\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\"2\u0006\u0010>\u001a\u00020?H\u0002J\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\"2\b\u0010B\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\bCJ&\u0010D\u001a\u00020E2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00010\"2\u0006\u0010>\u001a\u00020?2\u0006\u0010G\u001a\u00020HH\u0002J\u000e\u0010I\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005J(\u0010J\u001a\u00020E2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00050\"2\u0006\u00106\u001a\u00020\u00172\b\u0010K\u001a\u0004\u0018\u00010?H\u0002JB\u0010L\u001a\u00020\u00172\u0006\u0010M\u001a\u00020\u00052\u0006\u0010N\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\u00052\b\b\u0002\u0010Q\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u000205J \u0010S\u001a\u00020\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u0005J \u0010T\u001a\u00020\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u0005J;\u0010U\u001a\u00020E2\b\u0010V\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010W\u001a\u0002052\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00050Y2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00050Y¢\u0006\u0002\u0010[J,\u0010\\\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010]\u001a\u00020H2\b\b\u0002\u0010\u0015\u001a\u00020\u0005J;\u0010^\u001a\u00020E2\b\u0010V\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010W\u001a\u0002052\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00050Y2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00050Y¢\u0006\u0002\u0010[J\u0018\u0010_\u001a\u00020E2\u0006\u0010`\u001a\u00020\u00172\u0006\u0010a\u001a\u00020\u0017H\u0002J\u0018\u0010b\u001a\u00020E2\u0006\u0010`\u001a\u00020\u00122\u0006\u0010a\u001a\u00020\u0012H\u0002J\b\u0010c\u001a\u000205H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006d"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/global/EntityGlobalSearch;", "", "<init>", "()V", "TAG", "", "PRELOAD_SCENE", "SEARCH_CONTENT_TYPE", "SEARCH_CONTENT_DOMAIN", "NEED_CONTENT", "MEMORY_REACT_AGENT", "queryTimeMapProvider", "Lcom/obric/memorydata/personalcontext/search/global/QueryTimeMapProvider;", "getQueryTimeMapProvider", "()Lcom/obric/memorydata/personalcontext/search/global/QueryTimeMapProvider;", "queryTimeMapProvider$delegate", "Lkotlin/Lazy;", "globalDeepSearchForAppIntent", "Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantIntentSearchResponse;", "quResult", "queryId", "meta", "globalDeepSearchForTest", "Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchResponse;", "data", "Landroid/os/Bundle;", "callingPackage", "executeKgSearchTask", ChatMessage.TYPE_QUERY, "convertToTime", "", OaidModel.KEY_TIME, "buildSearchContentDomain", "queryRewriteList", "", "Lcom/obric/memorydata/sdk/entity/search/RewriteQuery;", "expandRewriteQueries", "splitSearchDomains", "domain", "removePunctuation", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "calcCharMatchRate", "", "a", "b", "findBestMatchTime", "referenceQuery", "queryTimeMap", "", "executeReActPackageSearch", "queryList", "searchType", "needContent", "", ChatMessage.TYPE_RESPONSE, "businessName", ObricMemoryConstants.KEY_PACKAGE_NAME, "searchContentDomain", "executeReActPackageSearchInternal", "globalResponse", "loadReActReferenceEntities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "referenceItem", "Lorg/json/JSONObject;", "parseInAppSearchParams", "Lcom/obric/capabilitykit/entity/search/InAppSearchEntityParam;", "json", "parseInAppSearchParams$personal_context_obricRelease", "setRelevantTextContent", "", "entity", "entityType", "", "executeReActSearchForProactiveUserProfile", "handleSearchInfoIfInEvaluateMode", "packageResponse", "commonGlobalSearch", "originQuery", "searchParams", "inputType", "taskName", "memoryScene", "obtainDetailedResults", "cloudSearch", "cloudSearchForDoubao", "preloadModel", "callPkg", "loadLora", "excludeModelList", "", "excludeLoraList", "(Ljava/lang/String;Z[Ljava/lang/String;[Ljava/lang/String;)V", "globalSearchForAppIntent", "limitCount", "cancelModel", "fillResponse", "oldResponse", "newResponse", "fillGlobalAssistantForAppIntentResponse", "isKnowledgeGraphEnable", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f12331a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f12332b = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/obric/memorydata/personalcontext/search/global/EntityGlobalSearch$parseInAppSearchParams$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/obric/capabilitykit/entity/search/InAppSearchEntityParam;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends InAppSearchEntityParam>> {
        a() {
        }
    }

    static {
        f12331a = new f();
        f12332b = LazyKt.lazy($$Lambda$f$osPVfQ8awSVZG3YfSTMpI3U6hQ.INSTANCE);
    }

    private f() {
    }

    private final double a(String r5, String r6) {
        boolean r1 = true;
        int r2 = 0;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L15;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L10;
        boolean r7 = true;
    L11:
        if (r7 == false) goto L15;
        return 1.0d;
    L10:
        r7 = false;
    L15:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L17;
        boolean r8 = true;
    L18:
        if (r8 == false) goto L20;
        return 0.0d;
    L20:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L23;
        r1 = false;
    L23:
        if (r1 == false) goto L26;
        return 0.0d;
    L26:
        if (r5.length() < r6.length()) goto L28;
        String r9 = r5;
    L30:
        if (r5.length() < r6.length()) goto L32;
        r5 = r6;
    L32:
        List<Character> r10 = StringsKt.toMutableList((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"));
        int r11 = r9.length();
        int r0 = 0;
    L33:
        if (r2 >= r11) goto L39;
        int r3 = r10.indexOf(Character.valueOf(r9.charAt(r2)));
        if (r3 < 0) goto L37;
        r0 = r0 + 1;
        r10.remove(r3);
    L37:
        r2 = r2 + 1;
        goto L33
    L39:
        return ((double) r0) / ((double) r9.length());
    L28:
        r9 = r6;
        goto L30
    L17:
        r8 = false;
        goto L18
    L5:
        r4 = false;
        goto L6
    }

    private final g a() {
        return (g) ZeusTransformUtils.preCheckCast(f12332b.getValue(), g.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ GlobalAssistantSearchResponse a(f r9, String r10, String r11, String r12, String r13, String r14, String r15, boolean r16, int r17, Object r18) {
        if ((r17 & 32) == 0) goto L5;
        String r7 = "";
    L7:
        if ((r17 & 64) == 0) goto L9;
        boolean r8 = false;
    L11:
        return r9.a(r10, r11, r12, r13, r14, r7, r8);
    L9:
        r8 = r16;
        goto L11
    L5:
        r7 = r15;
        goto L7
    }

    public static /* synthetic */ GlobalAssistantSearchResponse a(f r13, String r14, List r15, String r16, String r17, boolean r18, GlobalAssistantSearchResponse r19, String r20, String r21, String r22, String r23, int r24, Object r25) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        if ((r24 & 4) == 0) goto L5;
        String r5 = "";
    L7:
        if ((r24 & 128) == 0) goto L9;
        String r10 = "memory_react_agent";
    L11:
        if ((r24 & 256) == 0) goto L13;
        String r11 = "";
    L15:
        if ((r24 & 512) == 0) goto L17;
        String r12 = null;
    L19:
        return r13.a(r14, r4, r5, r17, r18, r19, r20, r10, r11, r12);
    L17:
        r12 = r23;
        goto L19
    L13:
        r11 = r22;
        goto L15
    L9:
        r10 = r21;
        goto L11
    L5:
        r5 = r16;
        goto L7
    }

    private final String a(String r12, Map<String, String> r13) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        return "";
    L12:
        if (r14.isEmpty() == true) goto L44;
        String r15 = f(r12);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L17;
        boolean r2 = true;
    L18:
        if (r2 == false) goto L20;
        return "";
    L20:
        double r5 = 0.0d;
        Iterator r16 = r14.entrySet().iterator();
        String r3 = "";
    L22:
        if (r16.hasNext() == false) goto L32;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r16.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.getKey(), String.class, "com.obric.memorydata.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r7.getValue(), String.class, "com.obric.memorydata.plugin");
        String r10 = f(r8);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L26;
        boolean r11 = true;
    L27:
        if (r11 == true) goto L22;
        double r17 = a(r15, r10);
        if (r17 <= r5) goto L22;
        r3 = r9;
        r5 = r17;
        goto L22
    L26:
        r11 = false;
        goto L27
    L32:
        if (r5 >= 0.7d) goto L34;
        return "";
    L34:
        return r3;
    L17:
        r2 = false;
        goto L18
    L44:
        return "";
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    private final String a(List<RewriteQuery> r11) {
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L7;
        RewriteQuery r1 = (RewriteQuery) ZeusTransformUtils.preCheckCast(r13.next(), RewriteQuery.class, "com.obric.memorydata.plugin");
        CollectionsKt.addAll(r12, (Iterable) ZeusTransformUtils.preCheckCast(f12331a.e(r1.getDomain()), Iterable.class, "com.obric.memorydata.plugin"));
        goto L4
    L7:
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    }

    public static final /* synthetic */ List a(f r2, List r3) {
        return r2.b((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    private final List<AppEntity> a(JSONObject r15) {
        String r0 = r15.optString("type");
        Intrinsics.checkNotNullExpressionValue(r0, "optString(...)");
        Integer r1 = StringsKt.toIntOrNull(r0);
        if (r1 == null) goto L29;
        int r2 = r1.intValue();
        String r3 = r15.optString("entityId");
        String r4 = r15.optString(ObricMemoryConstants.KEY_PACKAGE_NAME);
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r5 = s.a().getRawDaoByEntityType(r2);
        if (r5 == null) goto L7;
        Intrinsics.checkNotNull(r3);
        Intrinsics.checkNotNull(r4);
        List<? extends Object> r6 = r5.queryByEntityId(r3, r4);
        JSONArray r7 = r15.optJSONArray("inAppSearchParams");
        if (r7 == null) goto L11;
        String r8 = r7.toString();
    L12:
        List<InAppSearchEntityParam> r9 = a(r8);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L20;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r14.iterator();
    L16:
        if (r17.hasNext() == false) goto L19;
        com.obric.memorydata.database.entity.d r10 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r17.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        r16.add(new SearchResultEntry(r10.getType(), r10.getId(), r9, 0, 8, null));
        goto L16
    L19:
        return com.obric.memorydata.personalcontext.search.g.loadAppEntitiesBySearchResultEntries$default(com.obric.memorydata.personalcontext.search.g.INSTANCE, (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin"), null, 2, null);
    L20:
        a(r6, r15, r2);
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r110 = r18.iterator();
    L22:
        if (r110.hasNext() == false) goto L27;
        AppEntity r11 = com.obric.memorydata.personalcontext.poison.g.f12254a.a((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r110.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"), r5);
        if (r11 == null) goto L22;
        r19.add(r11);
        goto L22
    L27:
        return (List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin");
    L11:
        r8 = null;
        goto L12
    L7:
        return CollectionsKt.emptyList();
    L29:
        return CollectionsKt.emptyList();
    }

    public static final /* synthetic */ void a(f r0, GlobalAssistantIntentSearchResponse r1, GlobalAssistantIntentSearchResponse r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(f r0, GlobalAssistantSearchResponse r1, GlobalAssistantSearchResponse r2) {
        r0.a(r1, r2);
    }

    private final void a(GlobalAssistantIntentSearchResponse r1, GlobalAssistantIntentSearchResponse r2) {
        r1.setCode(r2.getCode());
        r1.setMessage(r2.getMessage());
        r1.setSearchResponse(r2.getSearchResponse());
        r1.setGlobalSearchResponse(r2.getGlobalSearchResponse());
    }

    private final void a(GlobalAssistantSearchResponse r1, GlobalAssistantSearchResponse r2) {
        r1.setCode(r2.getCode());
        r1.setMessage(r2.getMessage());
        r1.setEntityResult(r2.getEntityResult());
        r1.setKgResult(r2.getKgResult());
        r1.setDomainResult(r2.getDomainResult());
        r1.setMemoryResult(r2.getMemoryResult());
        r1.setProactiveRecommendationResult(r2.getProactiveRecommendationResult());
        r1.setExtra(r2.getExtra());
    }

    private final void a(List<String> r7, GlobalAssistantSearchResponse r8, JSONObject r9) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        if (com.obric.memorydata.personalcontext.log.a.f12229a.b() == true) goto L7;
        if (r9 == null) goto L7;
        String r10 = r9.optString("summary");
        String r11 = r9.optString("reference_content");
        Intrinsics.checkNotNull(r10);
        r8.addExtra("globalSearchSummary", r10);
        Intrinsics.checkNotNull(r11);
        r8.addExtra("referenceContent", r11);
        return;
    L7:
        RunLog.INSTANCE.debug("EntityGlobalSearch", "handleSearchInfoIfInEvaluateMode");
        EvaluationResult r12 = com.obric.memorydata.personalcontext.log.a.f12229a.a();
        if (r12 == null) goto L22;
        r12.setType("searchGlobal");
        GlobalAssistantSearchEntityResult r3 = r8.getEntityResult();
        if (r3 == null) goto L20;
        List<AppEntity> r4 = r3.getEntityList();
        if (r4 == null) goto L20;
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin");
        GlobalAssistantSearchMemoryResult r13 = r8.getMemoryResult();
        if (r13 == null) goto L18;
        List<MemoryEntity> r14 = r13.getEntityList();
        if (r14 == null) goto L18;
    L19:
        List<? extends AppEntity> r0 = CollectionsKt.plus(r5, (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"));
    L21:
        r12.addResultEntitiesList(r0);
    L18:
        r14 = CollectionsKt.emptyList();
    L20:
        r0 = null;
    L22:
        com.obric.memorydata.personalcontext.log.a.f12229a.a(true);
        if (com.obric.memorydata.personalcontext.log.a.f12229a.c() == false) goto L25;
    L31:
        if (r9 == null) goto L35;
        String r15 = r9.optString("summary");
        Intrinsics.checkNotNullExpressionValue(r15, "optString(...)");
        r8.addExtra("globalSearchSummary", r15);
        return;
    L35:
        return;
    L25:
        if (com.obric.memorydata.personalcontext.log.a.f12229a.f() == true) goto L31;
        if (com.obric.memorydata.personalcontext.log.a.f12229a.e() == true) goto L31;
        if (com.obric.memorydata.personalcontext.log.a.f12229a.d() == true) goto L31;
        r8.setCode(0);
        r8.setMessage("evaluate data sets");
        r8.setEntityResult(new GlobalAssistantSearchEntityResult(CollectionsKt.emptyList(), 0, 2, null));
        r8.setKgResult(new GlobalAssistantSearchKgResult(CollectionsKt.emptyList()));
    }

    private final void a(List<? extends Object> r11, JSONObject r12, int r13) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        if (r13 == 501) goto L7;
        if (r13 == 502) goto L7;
        if (r13 == 801) goto L7;
        return;
    L7:
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r14.hasNext() == false) goto L54;
        Object r3 = r14.next();
        List<String> r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r12.has(Params.CONTENT) == false) goto L15;
        JSONArray r5 = r12.getJSONArray(Params.CONTENT);
        int r6 = 0;
        int r7 = r5.length();
    L13:
        if (r6 >= r7) goto L15;
        String r8 = r5.getString(r6);
        Intrinsics.checkNotNullExpressionValue(r8, "getString(...)");
        r4.add(r8);
        r6 = r6 + 1;
    L15:
        com.obric.memorydata.database.entity.e r9 = null;
        if (r13 != 501) goto L17;
        if (ZeusTransformUtils.instanceOf(r3, hh.class) == false) goto L33;
        r9 = (hh) ZeusTransformUtils.preCheckCast(r3, hh.class, "com.obric.memorydata.plugin");
    L33:
        if (r9 == null) goto L9;
        r9.a(r4);
        goto L9
    L17:
        if (r13 != 502) goto L18;
        if (ZeusTransformUtils.instanceOf(r3, fj.class) == false) goto L28;
        r9 = (fj) ZeusTransformUtils.preCheckCast(r3, fj.class, "com.obric.memorydata.plugin");
    L28:
        if (r9 == null) goto L9;
        r9.a(r4);
        goto L9
    L18:
        if (r13 != 801) goto L9;
        if (ZeusTransformUtils.instanceOf(r3, ge.class) == false) goto L23;
        r9 = (ge) ZeusTransformUtils.preCheckCast(r3, ge.class, "com.obric.memorydata.plugin");
    L23:
        if (r9 == null) goto L9;
        r9.a(r4);
        goto L9
    }

    private final List<RewriteQuery> b(List<RewriteQuery> r12) {
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r11.iterator();
    L4:
        if (r14.hasNext() == false) goto L15;
        RewriteQuery r1 = (RewriteQuery) ZeusTransformUtils.preCheckCast(r14.next(), RewriteQuery.class, "com.obric.memorydata.plugin");
        List<String> r2 = f12331a.e(r1.getDomain());
        if (r2.isEmpty() == false) goto L8;
        List r3 = CollectionsKt.listOf(r1);
    L13:
        CollectionsKt.addAll(r13, (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"));
        goto L4
    L8:
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r4.iterator();
    L10:
        if (r10.hasNext() == false) goto L12;
        r9.add(RewriteQuery.copy$default(r1, (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin"), null, null, null, 14, null));
        goto L10
    L12:
        r3 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
        goto L13
    L15:
        return (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin");
    }

    private final boolean b() {
        return true;
    }

    private static final g c() {
        if (AppContext.INSTANCE.isDebug() == true) goto L10;
        k r0 = new k();
    L9:
        return (g) ZeusTransformUtils.preCheckCast(r0, g.class, "com.obric.memorydata.plugin");
    L10:
        Object r1 = ZeusTransformUtils.forName("com.obric.memorydata.personalcontext.search.global.DebugQueryTimeMapProvider", "com.obric.memorydata.plugin").newInstance();     // Catch: Exception -> L6
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.memorydata.personalcontext.search.global.QueryTimeMapProvider");     // Catch: Exception -> L6
        return (g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.memorydata.plugin");
    L6:
        r0 = new k();
        goto L9
    }

    private final String c(String r10) {
        JSONObject r9 = new JSONObject();
        r9.put("inputQuery", r10);
        boolean r11 = true;
        String r12 = ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("personal_context_kg_retrieval").setInputParam(r9), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setForegroundCallerPkg(AppInfo.OAssistant.getPackageName()), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute().getOutput().toString();
        Intrinsics.checkNotNullExpressionValue(r12, "toString(...)");
        Object r13 = u.a().fromJson(r12, KnowledgeGraphResponse.class);     // Catch: Exception -> L5
    L7:
        KnowledgeGraphResponse r14 = (KnowledgeGraphResponse) ZeusTransformUtils.preCheckCast(r13, KnowledgeGraphResponse.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L18;
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(r14.getRelation_spo(), Collection.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L12;
    L15:
        if (r11 == false) goto L17;
        return "";
    L17:
        return u.a(r14.getRelation_spo());
    L12:
        if (r0.isEmpty() == true) goto L15;
        r11 = false;
        goto L15
    L18:
        return "";
    L5:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GsonExt", "convert content: " + r12 + " toObj error : " + e, null, 4, null);
        r13 = null;
        goto L7
    }

    private final long d(String r3) {
        DateTimeFormatter r2 = DateTimeFormatter.ofPattern("yyyy/M/d HH:mm");
        return LocalDateTime.parse((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"), r2).toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }

    private final List<String> e(String r8) {
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{",", "，", ";", "；", "|"}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r7.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r9.add(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString());
        goto L4
    L6:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r11.iterator();
    L8:
        if (r13.hasNext() == false) goto L16;
        Object r1 = r13.next();
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L8;
        r12.add(r1);
        goto L8
    L12:
        r2 = false;
        goto L13
    L16:
        return CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    }

    private final String f(String r2) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        return new Regex("[\\p{P}\\p{S}]").replace(r1, "");
    }

    /* JADX INFO: renamed from: lambda$osPVfQ8awSVZG3YfSTM-pI3U6hQ, reason: not valid java name */
    public static /* synthetic */ g m1096lambda$osPVfQ8awSVZG3YfSTMpI3U6hQ() {
        return c();
    }

    public final GlobalAssistantIntentSearchResponse a(String r76, String r77, int r78, String r79) {
        Intrinsics.checkNotNullParameter(r77, "queryId");
        Intrinsics.checkNotNullParameter(r79, "meta");
        GlobalAssistantIntentSearchResponse r11 = new GlobalAssistantIntentSearchResponse(0, "success", null, null);
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L7;
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        boolean r4 = false;
        int r5 = 4;
        Object r6 = null;
        String r2 = "EntityGlobalSearch";
        String r3 = "user not agree privacy";
    L5:
        IRunLog.a.a(r1, r2, r3, r4, r5, r6);
        return r11;
    L7:
        kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new EntityGlobalSearch$globalSearchForAppIntent$1(r76, r11, System.currentTimeMillis(), r77, new EntitySearchRecordInfo(null, "com.obric.assistant", "global_search", 0, null, 0, 0, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, false, null, -7, null), r78, r79, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
        r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r3 = "QueryId: " + r77 + " cloud search return " + r11.getCode() + ' ' + r11.getMessage();
        r4 = false;
        r5 = 4;
        r6 = null;
        r2 = "EntityGlobalSearch";
        goto L5
    }

    public final GlobalAssistantIntentSearchResponse a(String r41, String r42, String r43) {
        Intrinsics.checkNotNullParameter(r42, "queryId");
        Intrinsics.checkNotNullParameter(r43, "meta");
        GlobalIntentSearchModel r4 = null;
        Object r5 = null;
        GlobalAssistantIntentSearchResponse r15 = new GlobalAssistantIntentSearchResponse(0, "success", null, null);
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityGlobalSearch", "globalDeepSearchForAppIntent: privacy not agree", false, 4, null);
        return r15;
    L6:
        if (r41 != null) goto L37;
    L12:
        if (r4 != null) goto L15;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityGlobalSearch", "toObj<GlobalIntentSearchModel> fail", null, 4, null);
        r15.setCode(1003);
        r15.setMessage("QueryUnderStanding: " + r41);
        return r15;
    L15:
        List<RewriteQuery> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r4.getSearchAppEntity(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L17:
        if (r2.hasNext() == false) goto L19;
        SearchDomainQuery r6 = (SearchDomainQuery) ZeusTransformUtils.preCheckCast(r2.next(), SearchDomainQuery.class, "com.obric.memorydata.plugin");
        r0.add(new RewriteQuery(r6.getDomain(), r6.getQuery(), "app_entity", null, 8, null));
        goto L17
    L19:
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r4.getSearchAppEntityContent(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L21:
        if (r3.hasNext() == false) goto L23;
        SearchDomainQuery r7 = (SearchDomainQuery) ZeusTransformUtils.preCheckCast(r3.next(), SearchDomainQuery.class, "com.obric.memorydata.plugin");
        r0.add(new RewriteQuery(r7.getDomain(), r7.getQuery(), "app_entity_content", null, 8, null));
        goto L21
    L23:
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r4.getSearchMemoryEntity(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L25:
        if (r8.hasNext() == false) goto L27;
        SearchDomainQuery r9 = (SearchDomainQuery) ZeusTransformUtils.preCheckCast(r8.next(), SearchDomainQuery.class, "com.obric.memorydata.plugin");
        r0.add(new RewriteQuery(r9.getDomain(), r9.getQuery(), "memory_entity", null, 8, null));
        goto L25
    L27:
        List<RewriteQuery> r1 = b(r0);
        GlobalQUResult r10 = new GlobalQUResult(r4.getOriginQuery(), r1, null, 4, null);
        GlobalAssistantSearchResponse r13 = new GlobalAssistantSearchResponse(0, "success", null, null, null, null, null, null, 252, null);
        List r11 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List<RewriteQuery> r12 = r10.getQuery_rewrite();
        if (r12 == null) goto L35;
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L31:
        if (r14.hasNext() == false) goto L35;
        RewriteQuery r16 = (RewriteQuery) ZeusTransformUtils.preCheckCast(r14.next(), RewriteQuery.class, "com.obric.memorydata.plugin");
        if (r11.contains(r16.getQuery()) == true) goto L31;
        r11.add(r16.getQuery());
    L35:
        a(this, r42, r11, r4.getOriginQuery(), null, false, r13, "memory_react_agent", null, r43, a(r1), 128, null);
        r15.setGlobalSearchResponse(r13);
        RunLog.INSTANCE.debug("EntityGlobalSearch", "QueryId: " + r42 + " cloud search return " + r15.getCode() + ' ' + r15.getMessage());
        return r15;
    L37:
        r5 = u.a().fromJson(r41, GlobalIntentSearchModel.class);     // Catch: Exception -> L9
    L11:
        r4 = (GlobalIntentSearchModel) ZeusTransformUtils.preCheckCast(r5, GlobalIntentSearchModel.class, "com.obric.memorydata.plugin");
    L9:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GsonExt", "convert content: " + r41 + " toObj error : " + e, null, 4, null);
        goto L11
    }

    public final GlobalAssistantSearchResponse a(String r78, String r79, String r80, String r81, String r82, String r83, boolean r84) {
        Intrinsics.checkNotNullParameter(r78, "originQuery");
        Intrinsics.checkNotNullParameter(r79, "searchParams");
        Intrinsics.checkNotNullParameter(r80, "queryId");
        Intrinsics.checkNotNullParameter(r81, "inputType");
        Intrinsics.checkNotNullParameter(r82, "taskName");
        Intrinsics.checkNotNullParameter(r83, "memoryScene");
        GlobalAssistantSearchResponse r75 = new GlobalAssistantSearchResponse(0, "success", null, null, null, null, null, null, 252, null);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityGlobalSearch", "QueryId: " + r80 + " , start common global assistant search.", false, 4, null);
        RunLog.INSTANCE.debug("EntityGlobalSearch", "searchParams: " + r79);
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L7;
        IRunLog r77 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r710 = "EntityGlobalSearch";
        String r711 = "user not agree privacy";
        boolean r85 = false;
        int r86 = 4;
        Object r87 = null;
    L5:
        IRunLog.a.a(r77, r710, r711, r85, r86, r87);
        return r75;
    L7:
        kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new EntityGlobalSearch$commonGlobalSearch$1(r78, System.currentTimeMillis(), r80, r79, r81, r83, r82, new EntitySearchRecordInfo(null, AppInfo.OAssistant.getPackageName(), r82, 0, null, 0, 0, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, false, null, -7, null), r84, r75, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
        com.obric.memorydata.database.util.b.f9624a.a(r82, r75.getCode());
        r77 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r710 = "EntityGlobalSearch";
        r711 = "QueryId: " + r80 + " common global search return " + r75.getCode() + ' ' + r75.getMessage();
        r85 = false;
        r86 = 4;
        r87 = null;
        goto L5
    }

    public final GlobalAssistantSearchResponse a(String r14, List<String> r15, String r16, String r17, boolean r18, GlobalAssistantSearchResponse r19, String r20, String r21, String r22, String r23) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "queryId");
        Intrinsics.checkNotNullParameter(r4, "queryList");
        Intrinsics.checkNotNullParameter(r19, ChatMessage.TYPE_RESPONSE);
        Intrinsics.checkNotNullParameter(r20, "businessName");
        Intrinsics.checkNotNullParameter(r21, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r22, "meta");
        return (GlobalAssistantSearchResponse) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new EntityGlobalSearch$executeReActPackageSearch$1(r14, r4, r16, r17, r18, r19, r20, r22, r23, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), GlobalAssistantSearchResponse.class, "com.obric.memorydata.plugin");
    }

    public final List<InAppSearchEntityParam> a(String r7) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
    L8:
        boolean r8 = true;
    L9:
        if (r8 == true) goto L11;
        List<InAppSearchEntityParam> r9 = (List) ZeusTransformUtils.preCheckCast(EntityExtKt.getEntityGson().fromJson(r7, new a().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L16
        if (r9 != null) goto L20;
        return CollectionsKt.emptyList();
    L20:
        return r9;
    L16:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityGlobalSearch", "invalid ReAct inAppSearchParams, fallback to legacy reference", null, 4, null);
        return CollectionsKt.emptyList();
    L11:
        return CollectionsKt.emptyList();
    L5:
        if (StringsKt.isBlank(r6) == true) goto L8;
        r8 = false;
        goto L9
    }

    public final void a(String r20, boolean r21, String[] r22, String[] r23) {
        Intrinsics.checkNotNullParameter(r22, "excludeModelList");
        Intrinsics.checkNotNullParameter(r23, "excludeLoraList");
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L18;
        if (r21 == true) goto L6;
    L8:
        long r10 = System.currentTimeMillis();
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(q.f12255a.d(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r0.hasNext() == false) goto L13;
        kotlinx.coroutines.i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new EntityGlobalSearch$preloadModel$1$1((String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin"), r20, r21, r22, r23, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        goto L10
    L13:
        if (b() == false) goto L15;
        kotlinx.coroutines.i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new EntityGlobalSearch$preloadModel$2(r20, r21, r22, r23, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    L15:
        RunLog.INSTANCE.debug("EntityGlobalSearch", "preload cost: " + (System.currentTimeMillis() - r10) + "ms");
        return;
    L6:
        if (DeviceInfoState.INSTANCE.isSupportVLM() == true) goto L8;
        return;
    }

    public final GlobalAssistantSearchResponse b(String r84, String r85, String r86) {
        Intrinsics.checkNotNullParameter(r85, "queryId");
        Intrinsics.checkNotNullParameter(r86, "inputType");
        GlobalAssistantSearchResponse r21 = new GlobalAssistantSearchResponse(0, "success", null, null, null, null, null, null, 252, null);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityGlobalSearch", "QueryId: " + r85 + " , start cloud global assistant search.", false, 4, null);
        RunLog.INSTANCE.debug("EntityGlobalSearch", "quResult: " + r84);
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityGlobalSearch", "user not agree privacy", false, 4, null);
        return r21;
    L6:
        kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new EntityGlobalSearch$cloudSearch$1(r84, r21, System.currentTimeMillis(), r85, new EntitySearchRecordInfo(null, AppInfo.OAssistant.getPackageName(), "global_search", 0, null, 0, 0, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, false, null, -7, null), r86, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
        RunLog.INSTANCE.debug("EntityGlobalSearch", "QueryId: " + r85 + " cloud search return " + r21.getCode() + ' ' + r21.getMessage());
        return r21;
    }

    public final GlobalAssistantSearchResponse b(String r25, List<String> r26, String r27, String r28, boolean r29, GlobalAssistantSearchResponse r30, String r31, String r32, String r33, String r34) {
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r25, "queryId");
        Intrinsics.checkNotNullParameter(r9, "queryList");
        Intrinsics.checkNotNullParameter(r30, "globalResponse");
        Intrinsics.checkNotNullParameter(r31, "businessName");
        Intrinsics.checkNotNullParameter(r32, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r33, "meta");
        String r12 = c(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, null, 63, null));
        JSONObject r13 = new JSONObject();
        r13.put("search_type", SearchType.COMMON_GLOBAL_SEARCH.getValue());
        String r14 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r9), String.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L5;
        r14 = "";
    L5:
        r13.put("origin_query", r14);
        r13.put("input_type", "TEXT");
        r13.put("entity_switch_status", com.obric.memorydata.personalcontext.search.g.INSTANCE.getEntitySwitchStatus());
        r13.put("embedding_type", com.obric.memorydata.personalcontext.util.c.f12363a.c());
        TaskRequest.Builder r0 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(r32).setForegroundCallerPkg(AppInfo.OAssistant.getPackageName()), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
        JSONObject r15 = new JSONObject();
        List r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r16.hasNext() == false) goto L12;
        List<String> r17 = r9;
        Iterator r35 = r16;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin");
        if (r6.contains(r10) == true) goto L11;
        r6.add(r10);
    L11:
        r16 = r35;
        r9 = r17;
        goto L7
    L12:
        List<String> r18 = r9;
        r15.put("query_id", r25);
        r15.put("device_id", AppContext.INSTANCE.getServerDeviceId());
        r15.put(ChatMessage.TYPE_QUERY, u.a(r6));
        r15.put("search_control_params", r13);
        r15.put("meta", r33);
        if (r27 == null) goto L16;
        r15.put("reference_query", r27);
    L16:
        if (r28 != null) goto L18;
    L20:
        boolean r11 = false;
    L21:
        if (r11 == false) goto L23;
        r15.put("search_content_type", r28);
    L23:
        if (r34 == null) goto L27;
        boolean r19 = true;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r34, CharSequence.class, "com.obric.memorydata.plugin"))) != true) goto L28;
        boolean r3 = true;
    L29:
        if (r3 == false) goto L31;
        r15.put("search_content_domain", r34);
    L31:
        r15.put("need_content", r29);
        if (com.obric.memorydata.personalcontext.log.a.f12229a.b() == false) goto L40;
        f r4 = f12331a;
        String r2 = r4.a(r27, r4.a().a());
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L36;
        boolean r7 = r19;
    L37:
        if (r7 == false) goto L40;
        r15.put("query_time", r4.d(r2));
        goto L40
    L36:
        r7 = false;
    L40:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L42;
        boolean r5 = r19;
    L43:
        if (r5 == false) goto L45;
        r15.put("spo_result", r12);
    L45:
        TaskResult r1 = ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r0.setInputParam(r15), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setPriority(10), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute();
        ArrayList r8 = new ArrayList();
        RunLog.INSTANCE.debug("EntityGlobalSearch", "packageResult: " + r1);
        JSONObject r20 = r1.getOutput().optJSONObject(ChatMessage.TYPE_RESPONSE);
        if (r20 == null) goto L60;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityGlobalSearch", "response parse", false, 4, null);
        j.f12337a.a(r20, r30);
        JSONArray r21 = r20.optJSONArray("reference");
        String r22 = r20.optString("summary");
        Intrinsics.checkNotNullExpressionValue(r22, "optString(...)");
        String r110 = r20.optString("reference_content");
        Intrinsics.checkNotNullExpressionValue(r110, "optString(...)");
        JSONObject r111 = r20.optJSONObject("pref_cost");
        if (r111 == null) goto L50;
        r111.put("type", "agent");
    L50:
        com.obric.memorydata.database.util.b.f9624a.a(r111, r31, r33);
        if (r111 == null) goto L53;
        String r23 = r111.toString();
        Intrinsics.checkNotNullExpressionValue(r23, "toString(...)");
        r30.addExtra("perf_cost", r23);
    L53:
        RunLog.INSTANCE.debug("EntityGlobalSearch", "answer: " + r22 + " reference: " + r21 + " referenceContent: " + r110);
        if (r21 == null) goto L60;
        if (r21.length() <= 0) goto L60;
        int r24 = r21.length();
        int r36 = 0;
    L58:
        if (r36 >= r24) goto L60;
        JSONObject r37 = r21.optJSONObject(r36);
        RunLog.INSTANCE.debug("EntityGlobalSearch", "referenceItem: " + r37);
        f r112 = f12331a;
        Intrinsics.checkNotNull(r37);
        r8.addAll((Collection) ZeusTransformUtils.preCheckCast(r112.a(r37), Collection.class, "com.obric.memorydata.plugin"));
        r36 = r36 + 1;
    L60:
        Iterable r38 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        HashSet r39 = new HashSet();
        ArrayList r40 = new ArrayList();
        Iterator r41 = r38.iterator();
    L62:
        if (r41.hasNext() == false) goto L66;
        Object r42 = r41.next();
        AppEntity r43 = (AppEntity) ZeusTransformUtils.preCheckCast(r42, AppEntity.class, "com.obric.memorydata.plugin");
        if (r39.add(new Triple(r43.getId(), Integer.valueOf(r43.getType()), r43.get_packageName())) == false) goto L62;
        r40.add(r42);
        goto L62
    L66:
        List r44 = (List) ZeusTransformUtils.preCheckCast(r40, List.class, "com.obric.memorydata.plugin");
        Iterable r45 = (Iterable) ZeusTransformUtils.preCheckCast(r44, Iterable.class, "com.obric.memorydata.plugin");
        Collection r46 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r47 = r45.iterator();
    L68:
        if (r47.hasNext() == false) goto L77;
        Object r48 = r47.next();
        AppEntity r49 = (AppEntity) ZeusTransformUtils.preCheckCast(r48, AppEntity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r49, MemoryEntity.class) == false) goto L72;
    L74:
        boolean r50 = false;
    L75:
        if (r50 == false) goto L68;
        r46.add(r48);
        goto L68
    L72:
        if (ZeusTransformUtils.instanceOf(r49, ProactiveMemoryEntity.class) == true) goto L74;
        r50 = r19;
        goto L75
    L77:
        List r51 = (List) ZeusTransformUtils.preCheckCast(r46, List.class, "com.obric.memorydata.plugin");
        Iterable r52 = (Iterable) ZeusTransformUtils.preCheckCast(r44, Iterable.class, "com.obric.memorydata.plugin");
        Collection r53 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r54 = r52.iterator();
    L79:
        if (r54.hasNext() == false) goto L83;
        Object r55 = r54.next();
        if (ZeusTransformUtils.instanceOf(r55, MemoryEntity.class) == false) goto L79;
        r53.add(r55);
        goto L79
    L83:
        List r56 = (List) ZeusTransformUtils.preCheckCast(r53, List.class, "com.obric.memorydata.plugin");
        Iterator r57 = ((Iterable) ZeusTransformUtils.preCheckCast(r56, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L85:
        if (r57.hasNext() == false) goto L87;
        MemoryEntity r58 = (MemoryEntity) ZeusTransformUtils.preCheckCast(r57.next(), MemoryEntity.class, "com.obric.memorydata.plugin");
        r58.setSourceLink("");
        r58.setSourceLinkType("");
        goto L85
    L87:
        r30.setEntityResult(new GlobalAssistantSearchEntityResult(r51, 0, 2, null));
        r30.setMemoryResult(new GlobalAssistantSearchMemoryResult(r56));
        Iterable r59 = (Iterable) ZeusTransformUtils.preCheckCast(r44, Iterable.class, "com.obric.memorydata.plugin");
        Collection r60 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r61 = r59.iterator();
    L89:
        if (r61.hasNext() == false) goto L93;
        Object r62 = r61.next();
        if (ZeusTransformUtils.instanceOf(r62, ProactiveMemoryEntity.class) == false) goto L89;
        r60.add(r62);
        goto L89
    L93:
        r30.setProactiveRecommendationResult(new ProactiveRecommendationSearchResult(CollectionsKt.emptyList(), (List) ZeusTransformUtils.preCheckCast(r60, List.class, "com.obric.memorydata.plugin")));
        a(r18, r30, r20);
        return r30;
    L42:
        r5 = false;
    L28:
        r3 = false;
        goto L29
    L27:
        r19 = true;
        goto L28
    L18:
        if (at.a(r28) != true) goto L20;
        r11 = true;
        goto L21
    }

    public final String b(String r8) {
        Intrinsics.checkNotNullParameter(r8, ChatMessage.TYPE_QUERY);
        TaskRequest.Builder r0 = new TaskRequest.Builder("memory_agent_for_userprofile");
        JSONObject r1 = new JSONObject();
        r1.put(ChatMessage.TYPE_QUERY, u.a(CollectionsKt.listOf(r8)));
        TaskResult r7 = ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r0.setInputParam(r1), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute();
        RunLog.INSTANCE.debug("EntityGlobalSearch", "packageResult: " + r7);
        if (r7.getCode() == 0) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityGlobalSearch", "memory_agent_for_userprofile failed. code: " + r7.getCode() + ", msg: " + r7.getMsg(), false, 4, null);
        return "";
    L6:
        JSONObject r9 = r7.getOutput();
        JSONObject r10 = r9.optJSONObject(ChatMessage.TYPE_RESPONSE);
        if (r10 == null) goto L9;
        com.obric.memorydata.database.util.b.a(com.obric.memorydata.database.util.b.f9624a, r10.optJSONObject("pref_cost"), "memory_agent_for_userprofile", null, 4, null);
    L9:
        String r11 = r9.optString("fc_result");
        Intrinsics.checkNotNullExpressionValue(r11, "optString(...)");
        return r11;
    }

    public final void b(String r20, boolean r21, String[] r22, String[] r23) {
        Intrinsics.checkNotNullParameter(r22, "excludeModelList");
        Intrinsics.checkNotNullParameter(r23, "excludeLoraList");
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L18;
        if (r21 == true) goto L6;
    L8:
        long r10 = System.currentTimeMillis();
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(q.f12255a.d(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r0.hasNext() == false) goto L13;
        kotlinx.coroutines.i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new EntityGlobalSearch$cancelModel$1$1((String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin"), r20, r21, r22, r23, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        goto L10
    L13:
        if (b() == false) goto L15;
        kotlinx.coroutines.i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new EntityGlobalSearch$cancelModel$2(r20, r21, r22, r23, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    L15:
        RunLog.INSTANCE.debug("EntityGlobalSearch", "cancel preload cost: " + (System.currentTimeMillis() - r10) + "ms");
        return;
    L6:
        if (DeviceInfoState.INSTANCE.isSupportVLM() == true) goto L8;
        return;
    }

    public final GlobalAssistantSearchResponse c(String r76, String r77, String r78) {
        Intrinsics.checkNotNullParameter(r77, "queryId");
        Intrinsics.checkNotNullParameter(r78, "inputType");
        GlobalAssistantSearchResponse r9 = new GlobalAssistantSearchResponse(0, "success", null, null, null, null, null, null, 252, null);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityGlobalSearch", "QueryId: " + r77 + " , start cloud global assistant search.", false, 4, null);
        RunLog.INSTANCE.debug("EntityGlobalSearch", "quResult: " + r76);
        long r3 = System.currentTimeMillis();
        EntitySearchRecordInfo r7 = new EntitySearchRecordInfo(null, AppInfo.OAssistant.getPackageName(), "doubao_global_search", 0, null, 0, 0, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, false, null, -7, null);
        if (r76 != null) goto L43;
        GlobalQUResult r5 = null;
    L11:
        if (r5 != null) goto L15;
        r9.setCode(1003);
        StringBuilder r2 = new StringBuilder();
    L13:
        r9.setMessage(r2.append("QueryUnderStanding: ").append(r76).toString());
        return r9;
    L15:
        List<RewriteQuery> r6 = r5.getQuery_rewrite();
        if (r6 == null) goto L31;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L19:
        if (r10.hasNext() == false) goto L30;
        Object r15 = r10.next();
        RewriteQuery r4 = (RewriteQuery) ZeusTransformUtils.preCheckCast(r15, RewriteQuery.class, "com.obric.memorydata.plugin");
        Iterator r21 = r10;
        if (com.obric.memorydata.personalcontext.search.d.f12308a.b().contains(r4.getDomain()) == false) goto L23;
    L26:
        boolean r11 = true;
    L27:
        if (r11 == false) goto L29;
        r14.add(r15);
    L29:
        r10 = r21;
        goto L19
    L23:
        if (Intrinsics.areEqual(r4.getDomain(), "All") == true) goto L26;
        r11 = false;
        goto L27
    L30:
        List<RewriteQuery> r12 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin");
    L32:
        r5.setQuery_rewrite(r12);
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(r5.getQuery_rewrite(), Collection.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L35;
    L38:
        boolean r16 = true;
    L39:
        if (r16 == false) goto L41;
        r9.setCode(1003);
        r2 = new StringBuilder();
        goto L13
    L41:
        RunLog.INSTANCE.debug("EntityGlobalSearch", "raw query: " + r5.getOrigin_query());
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new EntityGlobalSearch$cloudSearchForDoubao$2(r0, r3, r5, r77, r7, r78, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
        a(r9, (GlobalAssistantSearchResponse) ZeusTransformUtils.preCheckCast(r0.element, GlobalAssistantSearchResponse.class, "com.obric.memorydata.plugin"));
        RunLog.INSTANCE.debug("EntityGlobalSearch", "cloud global assistant search response: " + u.a(r9));
        RunLog.INSTANCE.debug("EntityGlobalSearch", "QueryId: " + r77 + " cloud search return " + r9.getCode() + ' ' + r9.getMessage());
        return r9;
    L35:
        if (r13.isEmpty() == true) goto L38;
        r16 = false;
        goto L39
    L31:
        r12 = null;
        goto L32
    L43:
        Object r1 = u.a().fromJson(r76, GlobalQUResult.class);     // Catch: Exception -> L6
    L8:
        r5 = (GlobalQUResult) ZeusTransformUtils.preCheckCast(r1, GlobalQUResult.class, "com.obric.memorydata.plugin");
    L6:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GsonExt", "convert content: " + r76 + " toObj error : " + e, null, 4, null);
        r1 = null;
        goto L8
    }
}
