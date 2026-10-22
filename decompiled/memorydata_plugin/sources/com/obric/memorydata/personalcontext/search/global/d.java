package com.obric.memorydata.personalcontext.search.global;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import androidx.core.app.NotificationCompat;
import androidx.media.MediaBrowserServiceCompat;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.app.VideoFrame;
import com.obric.capabilitykit.entity.enums.AssetTypeEnum;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.search.InAppSearchEntityParam;
import com.obric.capabilitykit.entity.search.SearchScoreParam;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.index.EntityIndexEngine;
import com.obric.memorydata.database.index.s;
import com.obric.memorydata.database.model.EntitySearchRecordInfo;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.middleware.impl.image.ImageUploadEntity;
import com.obric.memorydata.middleware.impl.image.ImageXBizType;
import com.obric.memorydata.model.BaseResponse;
import com.obric.memorydata.personalcontext.index.EntityVideoExtractHelper;
import com.obric.memorydata.personalcontext.log.EvaluationResult;
import com.obric.memorydata.personalcontext.search.entity.SearchResultEntry;
import com.obric.memorydata.personalcontext.search.entity.SearchType;
import com.obric.memorydata.personalcontext.search.kg.KGSourceEntity;
import com.obric.memorydata.personalcontext.search.kg.KGSourceIndex;
import com.obric.memorydata.personalcontext.search.kg.KnowledgeGraphResponse;
import com.obric.memorydata.personalcontext.util.EmbeddingState;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchEntityResult;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchKgResult;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchMemoryResult;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchResponse;
import com.obric.memorydata.sdk.entity.global.ProactiveRecommendationSearchResult;
import com.obric.memorydata.sdk.entity.search.AssistantQuResult;
import com.obric.memorydata.sdk.entity.search.QuAction;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 :2\u00020\u0001:\u0001:BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0013J(\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u0015H\u0002J(\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001b0\u00160\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u0015H\u0002J\"\u0010\u001d\u001a\u00020\u001e2\u0018\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\u0015H\u0002J \u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0012H\u0002J2\u0010%\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u00032\u0018\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\u00152\u0006\u0010$\u001a\u00020\u0012H\u0002J\b\u0010&\u001a\u00020\u0003H\u0002J0\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\u0018\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\u00152\u0006\u0010*\u001a\u00020\"H\u0002J\u0018\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\u0017H\u0002J\u0016\u0010.\u001a\u00020\u001e2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00170\u0015H\u0002J(\u00100\u001a\u00020\u001e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00152\b\u00101\u001a\u0004\u0018\u0001022\u0006\u0010$\u001a\u00020\u0012H\u0002J\u0018\u00103\u001a\b\u0012\u0004\u0012\u00020\u00180\u00152\b\u00104\u001a\u0004\u0018\u000105H\u0002J&\u00106\u001a\u00020\u001e2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00180(2\u000e\u00108\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/global/CommonGlobalSearchSession;", "", "originQuery", "", "startTime", "", "queryId", "searchParams", "inputType", "memoryScene", "taskName", "entitySearchRecordInfo", "Lcom/obric/memorydata/database/model/EntitySearchRecordInfo;", "obtainDetailedResults", "", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/database/model/EntitySearchRecordInfo;Z)V", "executeSearch", "Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadActualMemoryEntityBySearchResultEntries", "", "Lkotlin/Pair;", "Lcom/obric/memorydata/personalcontext/search/entity/SearchResultEntry;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "searchResultEntries", "loadMemoryEntityBySearchResultEntries", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "searchResultEntry", "addSearchScoreForAppEntityResult", "", "appEntityPairList", "handleGlobalAssistantError", "code", "", "message", ChatMessage.TYPE_RESPONSE, "uploadImageIfNeed", "getSearchType", "collectImageUploadEntities", "", "Lcom/obric/memorydata/middleware/impl/image/ImageUploadEntity;", "limit", "isPhotoSearchWithHighScore", "appEntity", "searchEntry", "printSearchResultEntry", "searchResults", "handleSearchInfoIfInEvaluateMode", "kgResponse", "Lcom/obric/memorydata/personalcontext/search/kg/KnowledgeGraphResponse;", "getKGEntityFromSourceData", "index", "Lcom/obric/memorydata/personalcontext/search/kg/KGSourceIndex;", "fillAppEntitiesByKGIndexSource", "kgEntityList", "kgSourceEntityList", "Lcom/obric/memorydata/personalcontext/search/kg/KGSourceEntity;", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12328a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12329b;
    private final long c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final EntitySearchRecordInfo i;
    private final boolean j;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/global/CommonGlobalSearchSession$Companion;", "", "<init>", "()V", "TAG", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12330a = null;

        static {
            int[] r0 = new int[AssetTypeEnum.values().length];
            r0[AssetTypeEnum.PHOTO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[AssetTypeEnum.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f12330a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends TypeToken<List<? extends SearchResultEntry>> {
        public c() {
        }
    }

    static {
        f12328a = new a(null);
    }

    public d(String r2, long r3, String r5, String r6, String r7, String r8, String r9, EntitySearchRecordInfo r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r2, "originQuery");
        Intrinsics.checkNotNullParameter(r5, "queryId");
        Intrinsics.checkNotNullParameter(r6, "searchParams");
        Intrinsics.checkNotNullParameter(r7, "inputType");
        Intrinsics.checkNotNullParameter(r8, "memoryScene");
        Intrinsics.checkNotNullParameter(r9, "taskName");
        this.f12329b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
    }

    private static final CharSequence a(SearchResultEntry r3) {
        Intrinsics.checkNotNullParameter(r3, "entry");
        return (CharSequence) ZeusTransformUtils.preCheckCast("type: " + r3.getType() + ", id: " + r3.getId(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final String a() {
        if (Intrinsics.areEqual(this.h, "personal_context_search") == false) goto L5;
        SearchType r1 = SearchType.PERSONAL_CONTEXT_SEARCH;
    L7:
        return r1.getValue();
    L5:
        r1 = SearchType.COMMON_GLOBAL_SEARCH;
        goto L7
    }

    private final List<AppEntity> a(KGSourceIndex r4) {
        List<AppEntity> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L5;
        a(r0, r4.getRelation());
    L5:
        return r0;
    }

    private final List<Pair<SearchResultEntry, AppEntity>> a(List<SearchResultEntry> r6) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List<Pair<SearchResultEntry, AppEntity>> r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L15;
        SearchResultEntry r1 = (SearchResultEntry) ZeusTransformUtils.preCheckCast(r8.next(), SearchResultEntry.class, "com.obric.memorydata.plugin");
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r2 = s.a().getRawDaoByEntityType(r1.getType());
        if (r2 == null) goto L4;
        com.obric.memorydata.database.entity.d r3 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r2.queryById(r1.getId()), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L4;
        if (ZeusTransformUtils.instanceOf(r3, EpisodicMemoryEntity.class) == false) goto L4;
        AppEntity r4 = com.obric.memorydata.personalcontext.poison.g.f12254a.a(r3, r2);
        if (r4 == null) goto L4;
        r7.add(TuplesKt.to(r1, r4));
        goto L4
    L15:
        return r7;
    }

    private final List<ImageUploadEntity> a(List<? extends Pair<SearchResultEntry, ? extends AppEntity>> r32, int r33) {
        d r0 = this;
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r32, List.class, "com.obric.memorydata.plugin");
        List<ImageUploadEntity> r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        boolean r4 = Intrinsics.areEqual(new JSONObject(r0.e).optString("domain"), "Photo");     // Catch: JSONException -> L150
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r6 = 0;
    L6:
        if (r2.hasNext() == false) goto L149;
        Pair r7 = (Pair) ZeusTransformUtils.preCheckCast(r2.next(), Pair.class, "com.obric.memorydata.plugin");
        SearchResultEntry r8 = (SearchResultEntry) ZeusTransformUtils.preCheckCast(r7.component1(), SearchResultEntry.class, "com.obric.memorydata.plugin");
        AppEntity r9 = (AppEntity) ZeusTransformUtils.preCheckCast(r7.component2(), AppEntity.class, "com.obric.memorydata.plugin");
        if (r9.getType() != 301) goto L14;
        if (r6 >= r33) goto L14;
        if (r4 == false) goto L13;
    L15:
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.PhotoEntity");
        PhotoEntity r10 = (PhotoEntity) ZeusTransformUtils.preCheckCast(r9, PhotoEntity.class, "com.obric.memorydata.plugin");
        int r11 = b.f12330a[r10.getAssetType().ordinal()];
        if (r11 != 1) goto L18;
        Iterator r19 = r2;
        int r12 = r10.getType();
        String r5 = r10.getId();
        String r13 = r10.getFile().getContentUrl().toString();
        Intrinsics.checkNotNullExpressionValue(r13, "toString(...)");
        ImageUploadEntity r14 = new ImageUploadEntity(r12, r5, r13, r9.get_packageName(), true, null, 32, null);
    L145:
        r3.add(r14);
    L146:
        r6 = r6 + 1;
    L148:
        r0 = this;
        r2 = r19;
        goto L6
    L18:
        if (r11 != 2) goto L143;
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r8.getInAppSearchParams(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r15.iterator();
    L21:
        if (r17.hasNext() == false) goto L31;
        Object r18 = r17.next();
        InAppSearchEntityParam r20 = (InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r18, InAppSearchEntityParam.class, "com.obric.memorydata.plugin");
        if (r20.isSemantic() == true) goto L25;
    L27:
        boolean r21 = false;
    L28:
        if (r21 == false) goto L21;
        r16.add(r18);
        goto L21
    L25:
        if (Intrinsics.areEqual(r20.getField(), "PhotoEntity_VideoFrame_file") == false) goto L27;
        r21 = true;
        goto L28
    L31:
        Iterator r22 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r22.hasNext() == true) goto L34;
        r19 = r2;
        Object r110 = null;
    L50:
        InAppSearchEntityParam r23 = (InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r110, InAppSearchEntityParam.class, "com.obric.memorydata.plugin");
        if (r23 == null) goto L55;
        String r24 = r23.getFieldArrayUniqueKey();
        if (r24 == null) goto L55;
        long r25 = Long.parseLong(r24);
    L57:
        if (r25 >= 0) goto L77;
        Iterator r26 = ((Iterable) ZeusTransformUtils.preCheckCast(r8.getInAppSearchParams(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L60:
        if (r26.hasNext() == false) goto L69;
        Object r111 = r26.next();
        InAppSearchEntityParam r112 = (InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r111, InAppSearchEntityParam.class, "com.obric.memorydata.plugin");
        if (r112.isSemantic() == false) goto L64;
    L66:
        boolean r113 = false;
    L67:
        if (r113 == false) goto L60;
    L70:
        InAppSearchEntityParam r27 = (InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r111, InAppSearchEntityParam.class, "com.obric.memorydata.plugin");
        if (r27 == null) goto L77;
        String r28 = r27.getFieldArrayUniqueKey();
        if (r28 == null) goto L75;
        r25 = Long.parseLong(r28);
        goto L77
    L75:
        r25 = -1;
        goto L77
    L64:
        if (Intrinsics.areEqual(r112.getField(), "PhotoEntity_VideoFrame_MetaTag_tagName") == false) goto L66;
        r113 = true;
        goto L67
    L69:
        r111 = null;
    L77:
        if (r25 >= 0) goto L116;
        Iterable r29 = (Iterable) ZeusTransformUtils.preCheckCast(r8.getInAppSearchParams(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r30 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r31 = r29.iterator();
    L80:
        if (r31.hasNext() == false) goto L89;
        Object r114 = r31.next();
        InAppSearchEntityParam r115 = (InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r114, InAppSearchEntityParam.class, "com.obric.memorydata.plugin");
        if (r115.isSemantic() == true) goto L84;
    L86:
        boolean r116 = false;
    L87:
        if (r116 == false) goto L80;
        r30.add(r114);
        goto L80
    L84:
        if (Intrinsics.areEqual(r115.getField(), "PhotoEntity_VideoFrame_caption") == false) goto L86;
        r116 = true;
        goto L87
    L89:
        Iterator r34 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r30, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r34.hasNext() == true) goto L92;
        long r210 = r25;
        Object r35 = null;
    L108:
        InAppSearchEntityParam r36 = (InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r35, InAppSearchEntityParam.class, "com.obric.memorydata.plugin");
        if (r36 == null) goto L117;
        String r37 = r36.getFieldArrayUniqueKey();
        if (r37 == null) goto L113;
        long r117 = Long.parseLong(r37);
    L114:
        long r38 = r117;
    L119:
        if (r38 < 0) goto L148;
        List<VideoFrame> r39 = r10.getSearchFrames();
        if (r39 == null) goto L133;
        Iterator r40 = ((Iterable) ZeusTransformUtils.preCheckCast(r39, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L124:
        if (r40.hasNext() == false) goto L131;
        Object r41 = r40.next();
        if (((VideoFrame) ZeusTransformUtils.preCheckCast(r41, VideoFrame.class, "com.obric.memorydata.plugin")).getFrameTime() != r38) goto L128;
        boolean r118 = true;
    L129:
        if (r118 == false) goto L124;
    L132:
        VideoFrame r42 = (VideoFrame) ZeusTransformUtils.preCheckCast(r41, VideoFrame.class, "com.obric.memorydata.plugin");
    L134:
        if (r42 == null) goto L148;
        EntityVideoExtractHelper r43 = EntityVideoExtractHelper.INSTANCE;
        String r44 = r9.get_packageName();
        Uri r45 = Uri.parse(r10.getFile().getContentUrl().toString());
        Intrinsics.checkNotNullExpressionValue(r45, "parse(...)");
        Uri r46 = r43.extractFrame(r44, r45, r42.getFrameTime());
        if (r46 == null) goto L146;
        String r47 = r46.getLastPathSegment();
        if (r47 == null) goto L146;
        URI r48 = new URI("file", null, new File(new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), Environment.DIRECTORY_PICTURES) + "/ImageIndexTemp", r47).getAbsolutePath(), null);
        int r211 = r10.getType();
        String r212 = r10.getId();
        String r49 = r48.toString();
        Intrinsics.checkNotNullExpressionValue(r49, "toString(...)");
        r14 = new ImageUploadEntity(r211, r212, r49, BuildConfig.LIBRARY_PACKAGE_NAME, true, null, 32, null);
        goto L145
    L128:
        r118 = false;
        goto L129
    L131:
        r41 = null;
        goto L132
    L133:
        r42 = null;
        goto L134
    L113:
        r117 = -1;
    L117:
        r38 = r210;
        goto L119
    L92:
        r35 = r34.next();
        if (r34.hasNext() == true) goto L95;
        r210 = r25;
        goto L108
    L95:
        SearchScoreParam r119 = ((InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r35, InAppSearchEntityParam.class, "com.obric.memorydata.plugin")).getScore();
        if (r119 == null) goto L98;
        double r120 = r119.getValue();
    L99:
        Object r121 = r34.next();
        SearchScoreParam r122 = ((InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r121, InAppSearchEntityParam.class, "com.obric.memorydata.plugin")).getScore();
        if (r122 == null) goto L102;
        long r213 = r25;
        double r50 = r122.getValue();
        r210 = r213;
    L104:
        if (Double.compare(r120, r50) >= 0) goto L107;
        r120 = r50;
        r35 = r121;
    L107:
        if (r34.hasNext() == false) goto L108;
        r25 = r210;
        goto L99
    L102:
        r210 = r25;
        r50 = 0.0d;
        goto L104
    L98:
        r120 = 0.0d;
        goto L99
    L116:
        r210 = r25;
    L55:
        r25 = -1;
        goto L57
    L34:
        r110 = r22.next();
        if (r22.hasNext() == true) goto L37;
        r19 = r2;
        goto L50
    L37:
        SearchScoreParam r123 = ((InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r110, InAppSearchEntityParam.class, "com.obric.memorydata.plugin")).getScore();
        if (r123 == null) goto L40;
        double r124 = r123.getValue();
    L41:
        Object r125 = r22.next();
        r19 = r2;
        SearchScoreParam r51 = ((InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r125, InAppSearchEntityParam.class, "com.obric.memorydata.plugin")).getScore();
        if (r51 == null) goto L44;
        double r52 = r51.getValue();
    L46:
        if (Double.compare(r124, r52) >= 0) goto L49;
        r124 = r52;
        r110 = r125;
    L49:
        if (r22.hasNext() == false) goto L50;
        r2 = r19;
        goto L41
    L44:
        r52 = 0.0d;
        goto L46
    L40:
        r124 = 0.0d;
        goto L41
    L143:
        throw new NoWhenBranchMatchedException();
    L13:
        if (r0.a(r9, r8) == true) goto L15;
    L14:
        r19 = r2;
        goto L148
    L149:
        return r3;
    L150:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CommonGlobalSearchSession", "parse searchParams failed, searchParams: " + this.e, null, 4, null);
        return r3;
    }

    private final void a(int r7, String r8, GlobalAssistantSearchResponse r9) {
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CommonGlobalSearchSession", r8, null, 4, null);
    }

    private static final void a(String r2, List r3) {
        List<ImageUploadEntity> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.impl.image.a.f11712a.a(r2, r4, ImageXBizType.DOUBAO);
    }

    private final void a(final String r4, List<? extends Pair<SearchResultEntry, ? extends AppEntity>> r5, GlobalAssistantSearchResponse r6) {
        List<? extends Pair<SearchResultEntry, ? extends AppEntity>> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.h, "common_global_search") == true) goto L5;
        return;
    L5:
        final List<ImageUploadEntity> r3 = a(r7, 4);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L9;
        r6.addExtra("hasPhotoHighSemantic", true);
        ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$d$z_0goJcJ8Zc4RwJaZvQAda1fVYk(r4, r3));
        return;
    }

    private final void a(List<SearchResultEntry> r25, KnowledgeGraphResponse r26, GlobalAssistantSearchResponse r27) {
        List<SearchResultEntry> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.memorydata.plugin");
        if (com.obric.memorydata.personalcontext.log.a.f12229a.b() == true) goto L5;
        return;
    L5:
        RunLog.INSTANCE.debug("CommonGlobalSearchSession", "handleSearchInfo InEvaluateMode");
        String r4 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getString("personal_context_search_control_params");
        long r11 = 1000;
        long r9 = System.currentTimeMillis() / r11;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == true) goto L17;
        String r6 = new JSONObject(r4).optString("changeDateTimeStamp", "");
        Intrinsics.checkNotNull(r6);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L17;
        Long r7 = StringsKt.toLongOrNull(r6);
        if (r7 == null) goto L17;
        r9 = r7.longValue() / r11;
    L17:
        EvaluationResult r8 = com.obric.memorydata.personalcontext.log.a.f12229a.a();
        if (r8 == null) goto L56;
        r8.setType("searchGlobal");
        GlobalAssistantSearchEntityResult r10 = r27.getEntityResult();
        if (r10 == null) goto L34;
        List<AppEntity> r12 = r10.getEntityList();
        if (r12 == null) goto L34;
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r13.iterator();
    L25:
        if (r15.hasNext() == false) goto L33;
        Object r16 = r15.next();
        if ((((AppEntity) ZeusTransformUtils.preCheckCast(r16, AppEntity.class, "com.obric.memorydata.plugin")).getCreateTime() / r11) > r9) goto L29;
        boolean r17 = true;
    L30:
        if (r17 == false) goto L25;
        r14.add(r16);
        goto L25
    L29:
        r17 = false;
        goto L30
    L33:
        List r18 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin");
    L35:
        GlobalAssistantSearchMemoryResult r19 = r27.getMemoryResult();
        if (r19 == null) goto L50;
        List<MemoryEntity> r20 = r19.getEntityList();
        if (r20 == null) goto L50;
        Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast(r20, Iterable.class, "com.obric.memorydata.plugin");
        Collection r110 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r22 = r21.iterator();
    L41:
        if (r22.hasNext() == false) goto L49;
        Object r111 = r22.next();
        if ((((MemoryEntity) ZeusTransformUtils.preCheckCast(r111, MemoryEntity.class, "com.obric.memorydata.plugin")).getCreateTime() / r11) > r9) goto L45;
        boolean r23 = true;
    L46:
        if (r23 == false) goto L41;
        r110.add(r111);
        goto L41
    L45:
        r23 = false;
        goto L46
    L49:
        List r24 = (List) ZeusTransformUtils.preCheckCast(r110, List.class, "com.obric.memorydata.plugin");
    L51:
        r8.addResultEntitiesList(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r24, Iterable.class, "com.obric.memorydata.plugin")));
        if (r26 == null) goto L54;
        KGSourceIndex r3 = r26.getSourceIndex();
    L55:
        r8.addKGResultEntityList(a(r3));
        r8.addQueryTimeCost(this.i);
        r8.addResultList(r2);
        r8.setQuResult(new AssistantQuResult(CollectionsKt.listOf(new QuAction(0, '\n' + this.e, null, 0, 8, null))));
        goto L56
    L54:
        r3 = null;
    L50:
        r24 = CollectionsKt.emptyList();
    L34:
        r18 = CollectionsKt.emptyList();
    L56:
        com.obric.memorydata.personalcontext.log.a.f12229a.a(true);
        if (com.obric.memorydata.personalcontext.log.a.f12229a.c() == false) goto L59;
    L63:
        r27.addExtra("phoneTimestamp", Long.valueOf(r9));
        return;
    L59:
        if (com.obric.memorydata.personalcontext.log.a.f12229a.f() == true) goto L63;
        if (com.obric.memorydata.personalcontext.log.a.f12229a.e() == true) goto L63;
        r27.setCode(0);
        r27.setMessage("evaluate data sets");
        r27.setEntityResult(new GlobalAssistantSearchEntityResult(CollectionsKt.emptyList(), 0, 2, null));
        r27.setKgResult(new GlobalAssistantSearchKgResult(CollectionsKt.emptyList()));
        r27.setMemoryResult(new GlobalAssistantSearchMemoryResult(CollectionsKt.emptyList()));
        return;
    L8:
        r5 = false;
        goto L9
    }

    private final void a(List<AppEntity> r6, List<KGSourceEntity> r7) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        EntityIndexEngine r9 = s.a();
        if (r8 == null) goto L14;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r10.hasNext() == false) goto L24;
        KGSourceEntity r1 = (KGSourceEntity) ZeusTransformUtils.preCheckCast(r10.next(), KGSourceEntity.class, "com.obric.memorydata.plugin");
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r2 = r9.getRawDaoByEntityType(r1.getEntityType());
        if (r2 == null) goto L6;
        com.obric.memorydata.database.entity.d r3 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r2.queryById(r1.getId()), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        AppEntity r4 = com.obric.memorydata.personalcontext.poison.g.f12254a.a(r3, r2);
        if (r4 == null) goto L6;
        r5.add(r4);
        goto L6
    L24:
        return;
    }

    private final boolean a(AppEntity r10, SearchResultEntry r11) {
        if (ZeusTransformUtils.instanceOf(r10, PhotoEntity.class) == true) goto L6;
        return false;
    L6:
        if (com.obric.memorydata.personalcontext.util.c.f12363a.b() != EmbeddingState.USE_VLM) goto L8;
        boolean r9 = true;
    L10:
        if (r9 == false) goto L12;
        Double r12 = com.obric.memorydata.personalcontext.search.c.f12306a.a().getSecond();
    L13:
        double r3 = ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).doubleValue();
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r11.getInAppSearchParams(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, Collection.class) == true) goto L16;
    L18:
        Iterator r14 = r13.iterator();
    L20:
        if (r14.hasNext() == false) goto L59;
        InAppSearchEntityParam r15 = (InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r14.next(), InAppSearchEntityParam.class, "com.obric.memorydata.plugin");
        int r5 = b.f12330a[((PhotoEntity) ZeusTransformUtils.preCheckCast(r10, PhotoEntity.class, "com.obric.memorydata.plugin")).getAssetType().ordinal()];
        if (r5 == 1) goto L39;
        if (r5 == 2) goto L27;
    L25:
        boolean r16 = false;
    L50:
        if (r16 == false) goto L20;
        return true;
    L27:
        if (r15.isSemantic() == false) goto L25;
        if (Intrinsics.areEqual(r15.getField(), "PhotoEntity_VideoFrame_file") == false) goto L25;
        SearchScoreParam r17 = r15.getScore();
        if (r17 != null) goto L33;
    L35:
        boolean r18 = false;
    L36:
        if (r18 == false) goto L25;
    L49:
        r16 = true;
        goto L50
    L33:
        if (r17.getValue() <= 0.39d) goto L35;
        r18 = true;
        goto L36
    L39:
        if (r15.isSemantic() == false) goto L25;
        if (Intrinsics.areEqual(r15.getField(), "PhotoEntity_file") == false) goto L25;
        SearchScoreParam r19 = r15.getScore();
        if (r19 != null) goto L45;
    L47:
        boolean r110 = false;
    L48:
        if (r110 == false) goto L25;
    L45:
        if (r19.getValue() <= r3) goto L47;
        r110 = true;
        goto L48
    L59:
        return false;
    L16:
        if (((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L18;
        return false;
    L12:
        r12 = com.obric.memorydata.personalcontext.search.c.f12306a.a().getFirst();
        goto L13
    L8:
        r9 = false;
        goto L10
    }

    private final void b(List<? extends Pair<SearchResultEntry, ? extends AppEntity>> r12) {
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r11.hasNext() == false) goto L47;
        Pair r13 = (Pair) ZeusTransformUtils.preCheckCast(r11.next(), Pair.class, "com.obric.memorydata.plugin");
        SearchResultEntry r1 = (SearchResultEntry) ZeusTransformUtils.preCheckCast(r13.component1(), SearchResultEntry.class, "com.obric.memorydata.plugin");
        AppEntity r14 = (AppEntity) ZeusTransformUtils.preCheckCast(r13.component2(), AppEntity.class, "com.obric.memorydata.plugin");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1.getInAppSearchParams(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        Object r5 = r4.next();
        if (((InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r5, InAppSearchEntityParam.class, "com.obric.memorydata.plugin")).isSemantic() == false) goto L7;
        r3.add(r5);
        goto L7
    L11:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        double r7 = 0.0d;
        if (r6.hasNext() == true) goto L14;
        Object r8 = null;
    L31:
        InAppSearchEntityParam r9 = (InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r8, InAppSearchEntityParam.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L36;
        SearchScoreParam r10 = r9.getScore();
        if (r10 == null) goto L36;
        r7 = r10.getValue();
    L36:
        CharSequence r15 = (CharSequence) ZeusTransformUtils.preCheckCast(r14.getExtraData(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L39;
    L42:
        boolean r16 = true;
    L44:
        if (r16 == true) goto L45;
        JSONObject r17 = new JSONObject(r14.getExtraData());
        r17.put("searchScore", r7);
        r17.toString();
        goto L4
    L45:
        JSONObject r18 = new JSONObject();
        r18.put("searchScore", r7);
        r14.setExtraData(r18.toString());
        goto L4
    L39:
        if (r15.length() == 0) goto L42;
        r16 = false;
        goto L44
    L14:
        Object r19 = r6.next();
        if (r6.hasNext() == true) goto L17;
    L16:
        r8 = r19;
        goto L31
    L17:
        SearchScoreParam r20 = ((InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r19, InAppSearchEntityParam.class, "com.obric.memorydata.plugin")).getScore();
        if (r20 == null) goto L20;
        double r21 = r20.getValue();
    L21:
        Object r22 = r6.next();
        SearchScoreParam r23 = ((InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r22, InAppSearchEntityParam.class, "com.obric.memorydata.plugin")).getScore();
        if (r23 == null) goto L24;
        double r24 = r23.getValue();
    L26:
        if (Double.compare(r21, r24) >= 0) goto L29;
        r19 = r22;
        r21 = r24;
    L29:
        if (r6.hasNext() == true) goto L21;
    L24:
        r24 = 0.0d;
        goto L26
    L20:
        r21 = 0.0d;
        goto L21
    }

    private final void c(List<SearchResultEntry> r12) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        if (AppContext.INSTANCE.isDebug() == false) goto L5;
        RunLog.INSTANCE.debug("CommonGlobalSearchSession", "search result entry: " + r11);
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CommonGlobalSearchSession", "search result entry: " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("; ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$d$AyIirzgqisqnyWtW93RdGM9Zcbw.INSTANCE, 30, null), false, 4, null);
    }

    public static /* synthetic */ CharSequence lambda$AyIirzgqisqnyWtW93RdGM9Zcbw(SearchResultEntry r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$z_0goJcJ8Zc4RwJaZvQAda1fVYk(String r0, List r1) {
        a(r0, r1);
    }

    public final Object a(Continuation<? super GlobalAssistantSearchResponse> r26) {
        d r0 = this;
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r26, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, CommonGlobalSearchSession$executeSearch$1.class) == false) goto L7;
        CommonGlobalSearchSession$executeSearch$1 r4 = (CommonGlobalSearchSession$executeSearch$1) ZeusTransformUtils.preCheckCast(r2, CommonGlobalSearchSession$executeSearch$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        CommonGlobalSearchSession$executeSearch$1 r9 = r4;
        Object r3 = r9.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r9.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        r0 = (d) ZeusTransformUtils.preCheckCast(r9.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
    L17:
        Object r24 = r3;
        d r7 = r0;
        if (((BaseResponse) ZeusTransformUtils.preCheckCast(r24, BaseResponse.class, "com.obric.memorydata.plugin")).getCode() == 0) goto L115;
        String r1 = "error: model is not ready: " + r7.h;
        GlobalAssistantSearchResponse r8 = new GlobalAssistantSearchResponse(1005, r1, null, null, null, null, null, null, 252, null);
        int r10 = 1005;
    L20:
        r7.a(r10, r1, r8);
        return r8;
    L115:
        JSONObject r11 = new JSONObject(r7.e);     // Catch: Exception -> L24
    L26:
        if (r11 == null) goto L28;
        JSONObject r12 = r11.optJSONObject("search_control_params");
    L29:
        JSONObject r13 = new JSONObject();
        r13.put("search_type", r7.a());
        r13.put("origin_query", r7.f12329b);
        r13.put("input_type", r7.f);
        r13.put("entity_switch_status", com.obric.memorydata.personalcontext.search.g.INSTANCE.getEntitySwitchStatus());
        r13.put("embedding_type", com.obric.memorydata.personalcontext.util.c.f12363a.c());
        if (r12 == null) goto L36;
        Iterator<String> r14 = r12.keys();
        if (r14 == null) goto L36;
    L34:
        if (r14.hasNext() == false) goto L36;
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin");
        r13.put(r15, r12.get(r15));
    L36:
        long r16 = System.currentTimeMillis();
        EntitySearchRecordInfo r17 = r7.i;
        if (r17 == null) goto L39;
        r17.setStageSearchParamPrepareCost(r16 - r7.c);
    L39:
        TaskRequest.Builder r18 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(r7.h).setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setForegroundCallerPkg(AppInfo.OAssistant.getPackageName()), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
        JSONObject r19 = new JSONObject();
        r19.put("search_params", r7.e);
        r19.put("search_control_params", r13);
        r19.put("memory_scene", r7.g);
        TaskResult r20 = ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r18.setInputParam(r19), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setPriority(10), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTimeout((com.obric.memorydata.task.impl.g) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.task.impl.f(10), com.obric.memorydata.task.impl.g.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute();
        long r21 = System.currentTimeMillis();
        EntitySearchRecordInfo r22 = r7.i;
        if (r22 == null) goto L43;
        r22.setTaskExecuteCost(r21 - r16);
    L43:
        if (r20.getCode() == 0) goto L45;
        r1 = "error: task execute failed: " + r7.h + ", code: " + r20.getCode();
        r8 = new GlobalAssistantSearchResponse(1004, r1, null, null, null, null, null, null, 252, null);
        r10 = 1004;
        goto L20
    L45:
        int r23 = r20.getOutput().optInt("code");
        String r25 = r20.getOutput().optString(NotificationCompat.CATEGORY_MESSAGE);
        if (r23 == 0) goto L49;
        String r27 = "error: search failed: " + r7.h + ", code: " + r23 + ", msg: " + r25;
        GlobalAssistantSearchResponse r28 = new GlobalAssistantSearchResponse(r23, r27, null, null, null, null, null, null, 252, null);
        r7.a(r23, r27, r28);
        return r28;
    L49:
        String r29 = r20.getOutput().optString(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS);
        int r110 = r20.getOutput().optInt("recall_total_count", 0);
        String r111 = r20.getOutput().optString("entry_descriptions");
        JSONObject r30 = r20.getOutput().optJSONObject("cost");
        EntitySearchRecordInfo r112 = r7.i;
        if (r112 == null) goto L55;
        if (r30 == null) goto L53;
        double r113 = r30.optDouble("kg_search_cost");
    L54:
        r112.setKgQueryCost(r113);
        goto L55
    L53:
        r113 = 0.0d;
    L55:
        EntitySearchRecordInfo r31 = r7.i;
        if (r31 == null) goto L61;
        if (r30 == null) goto L59;
        double r114 = r30.optDouble("global_search_cost");
    L60:
        r31.setStageTaskExecuteCost(r114);
        goto L61
    L59:
        r114 = 0.0d;
    L61:
        Intrinsics.checkNotNull(r29);
        List<SearchResultEntry> r32 = (List) ZeusTransformUtils.preCheckCast(u.a().fromJson(r29, new c().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L64 JsonSyntaxException -> L66
    L69:
        if (r32 != null) goto L71;
        r32 = CollectionsKt.emptyList();
    L71:
        List<SearchResultEntry> r33 = r32;
        String r34 = r20.getOutput().optString("kg_result");
        Intrinsics.checkNotNull(r34);
        Object r35 = u.a().fromJson(r34, KnowledgeGraphResponse.class);     // Catch: Exception -> L74
    L76:
        KnowledgeGraphResponse r36 = (KnowledgeGraphResponse) ZeusTransformUtils.preCheckCast(r35, KnowledgeGraphResponse.class, "com.obric.memorydata.plugin");
        r7.c(r33);
        GlobalAssistantSearchResponse r37 = new GlobalAssistantSearchResponse(0, "success", null, null, null, null, null, null, 252, null);
        if (r33.isEmpty() == false) goto L81;
        r37.setEntityResult(new GlobalAssistantSearchEntityResult(CollectionsKt.emptyList(), r110));
        r7.a(r33, r36, r37);
        return r37;
    L81:
        if (r7.j == false) goto L83;
        r37.addExtra(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS, r29);
    L83:
        List<? extends Pair<SearchResultEntry, ? extends AppEntity>> r38 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r39 = ((Iterable) ZeusTransformUtils.preCheckCast(r33, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L85:
        if (r39.hasNext() == false) goto L91;
        SearchResultEntry r40 = (SearchResultEntry) ZeusTransformUtils.preCheckCast(r39.next(), SearchResultEntry.class, "com.obric.memorydata.plugin");
        if ((-306) != r40.getType()) goto L89;
        List<Pair<SearchResultEntry, AppEntity>> r41 = r7.a(CollectionsKt.listOf(r40));
    L90:
        r38.addAll((Collection) ZeusTransformUtils.preCheckCast(r41, Collection.class, "com.obric.memorydata.plugin"));
        goto L85
    L89:
        r41 = com.obric.memorydata.personalcontext.search.g.INSTANCE.loadAppEntityPairBySearchResultEntries(CollectionsKt.listOf(r40), r111);
        goto L90
    L91:
        r7.b(r38);
        Iterable r42 = (Iterable) ZeusTransformUtils.preCheckCast(r38, Iterable.class, "com.obric.memorydata.plugin");
        Collection r43 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r42, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r44 = r42.iterator();
    L93:
        if (r44.hasNext() == false) goto L95;
        r43.add((AppEntity) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r44.next(), Pair.class, "com.obric.memorydata.plugin")).getSecond(), AppEntity.class, "com.obric.memorydata.plugin"));
        goto L93
    L95:
        List r45 = (List) ZeusTransformUtils.preCheckCast(r43, List.class, "com.obric.memorydata.plugin");
        if (r45.isEmpty() == false) goto L98;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CommonGlobalSearchSession", "CommonGlobalSearchSession: Fail to load app entities by search result entries: " + r33, null, 4, null);
    L99:
        r37.setEntityResult(new GlobalAssistantSearchEntityResult(r45, r110));
        if (r36 == null) goto L102;
        List<String> r46 = r36.getRelation_spo();
    L103:
        if (r46 != null) goto L105;
        r46 = CollectionsKt.emptyList();
    L105:
        r37.setKgResult(new GlobalAssistantSearchKgResult(r46));
        r37.setProactiveRecommendationResult(new ProactiveRecommendationSearchResult(CollectionsKt.emptyList(), CollectionsKt.emptyList()));
        r37.setMemoryResult(new GlobalAssistantSearchMemoryResult(CollectionsKt.emptyList()));
        r7.a(r33, r36, r37);
        long r47 = System.currentTimeMillis();
        EntitySearchRecordInfo r48 = r7.i;
        if (r48 == null) goto L108;
        r48.setStageResultHandleCost(r47 - r21);
    L108:
        EntitySearchRecordInfo r49 = r7.i;
        if (r49 == null) goto L111;
        r49.setQueryTotalCost(r47 - r7.c);
    L111:
        com.obric.memorydata.database.util.b.f9624a.a(r7.i);
        return r37;
    L102:
        r46 = null;
        goto L103
    L98:
        r7.a(r7.d, r38, r37);
    L74:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GsonExt", "convert content: " + r34 + " toObj error : " + e, null, 4, null);
        r35 = null;
        goto L76
    L66:
        e = e;
        IRunLog r115 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r50 = new StringBuilder();
    L68:
        IRunLog.a.b(r115, "GsonExt", r50.append("toListObj error : ").append(e).toString(), null, 4, null);
        r32 = null;
    L64:
        e = e;
        r115 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r50 = new StringBuilder();
        goto L68
    L28:
        r12 = null;
    L24:
        r11 = null;
        goto L26
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r3);
        com.obric.memorydata.aikernelcore.h r51 = com.obric.memorydata.aikernelcore.h.f8481a;
        String r52 = r0.h;
        r9.L$0 = r0;
        r9.label = 1;
        r3 = com.obric.memorydata.aikernelcore.h.a(r51, r52, false, null, r9, 6, null);
        if (r3 != r5) goto L17;
        return r5;
    L7:
        r4 = new CommonGlobalSearchSession$executeSearch$1(r0, r2);
        goto L8
    }
}
