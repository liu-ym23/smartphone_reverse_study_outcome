package com.obric.memorydata.database.index;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005J\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\u0014\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00070\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/database/index/IndexDashboardCoverageV1Policy;", "", "<init>", "()V", "POLICY_VERSION", "", "supportedEntityTypes", "", "getSupportedEntityTypes", "()Ljava/util/Set;", "excludedEntityTypes", "getExcludedEntityTypes", "isSupported", "", "entityType", "classify", "Lcom/obric/memorydata/database/index/IndexDashboardCoverageV1Policy$PendingClassification;", "columnContent", "", "buildType", "INVALIDATE_VALUE", "KW", "CT", "MFC", "ICS", "LAZY_INDEX_TASK", "requiredTokensByEntityType", "", "runtimeOnlyTokens", "PendingClassification", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IndexDashboardCoverageV1Policy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IndexDashboardCoverageV1Policy f9304a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<Integer> f9305b = null;
    private static final Set<Integer> c = null;
    private static final Map<Integer, Set<String>> d = null;
    private static final Set<String> e = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/database/index/IndexDashboardCoverageV1Policy$PendingClassification;", "", "<init>", "(Ljava/lang/String;I)V", "REQUIRED", "DEFERRED", "IGNORED", "UNKNOWN", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum PendingClassification extends Enum<PendingClassification> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ PendingClassification[] $VALUES = null;
        public static final PendingClassification DEFERRED = null;
        public static final PendingClassification IGNORED = null;
        public static final PendingClassification REQUIRED = null;
        public static final PendingClassification UNKNOWN = null;

        private static final /* synthetic */ PendingClassification[] $values() {
            return new PendingClassification[]{REQUIRED, DEFERRED, IGNORED, UNKNOWN};
        }

        static {
            REQUIRED = new PendingClassification("REQUIRED", 0);
            DEFERRED = new PendingClassification("DEFERRED", 1);
            IGNORED = new PendingClassification("IGNORED", 2);
            UNKNOWN = new PendingClassification("UNKNOWN", 3);
            PendingClassification[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private PendingClassification(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<PendingClassification> getEntries() {
            return $ENTRIES;
        }

        public static PendingClassification valueOf(String r2) {
            return (PendingClassification) ZeusTransformUtils.preCheckCast(Enum.valueOf(PendingClassification.class, r2), PendingClassification.class, "com.obric.memorydata.plugin");
        }

        public static PendingClassification[] values() {
            return (PendingClassification[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PendingClassification[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f9304a = new IndexDashboardCoverageV1Policy();
        Integer r2 = Integer.valueOf(NetError.ERR_CACHE_OPERATION_NOT_SUPPORTED);
        Integer r4 = Integer.valueOf(NetError.ERR_CACHE_READ_FAILURE);
        Integer r10 = Integer.valueOf(NetError.ERR_UNSAFE_PORT);
        Integer r12 = Integer.valueOf(NetError.ERR_UNSAFE_REDIRECT);
        Integer r14 = Integer.valueOf(NetError.ERR_TOO_MANY_REDIRECTS);
        f9305b = SetsKt.setOf(new Integer[]{r2, r4, -314, -313, r10, r12, r14, -309, -308, -307, -306, -305, -304, Integer.valueOf(NetError.ERR_INVALID_REDIRECT), Integer.valueOf(NetError.ERR_UNKNOWN_URL_SCHEME), Integer.valueOf(NetError.ERR_DISALLOWED_URL_SCHEME), 101, 201, 202, 301, 302, 303, 401, 402, 501, 502, 601, 701, 702, Integer.valueOf(EntityType.FILE), Integer.valueOf(EntityType.LIFE_LOG), Integer.valueOf(EntityType.USER_PROFILE)});
        c = SetsKt.setOf(new Integer[]{902, Integer.valueOf(EntityType.DOUBAO_ACCOUNT)});
        d = MapsKt.mapOf(new Pair[]{TuplesKt.to(101, SetsKt.setOf(new String[]{"insert_keyword_task", "insert_content_time_task", "meta_full_content", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "fullContent"})), TuplesKt.to(201, SetsKt.setOf(new String[]{"insert_keyword_task", "meta_full_content", "telephonesValues", "credentialValues", "emailsValues", "addressesValues", "anniversariesValues", "relationShipsValues", "fullContent"})), TuplesKt.to(202, SetsKt.setOf(new String[]{"insert_keyword_task", "insert_content_time_task", "meta_full_content", "transcript", "fullContent", "transcriptTitle"})), TuplesKt.to(301, SetsKt.setOf(new String[]{"insert_keyword_task", "insert_content_time_task", "meta_full_content", "file", "caption", "ocr", LocationMonitorConst.TAG, "location"})), TuplesKt.to(302, SetsKt.setOf("insert_keyword_task")), TuplesKt.to(303, SetsKt.setOf("insert_keyword_task")), TuplesKt.to(401, SetsKt.setOf(new String[]{"insert_keyword_task", "meta_full_content", "fullContent"})), TuplesKt.to(402, SetsKt.setOf("parse_ics_protocol_task")), TuplesKt.to(501, SetsKt.setOf(new String[]{"insert_keyword_task", "insert_content_time_task", "meta_full_content", "summary"})), TuplesKt.to(502, SetsKt.setOf(new String[]{"insert_keyword_task", "meta_full_content", "summary"})), TuplesKt.to(601, SetsKt.setOf(new String[]{"insert_keyword_task", "insert_content_time_task", "meta_full_content", "title", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "fullContent"})), TuplesKt.to(701, SetsKt.setOf(new String[]{"insert_keyword_task", "meta_full_content", "fullContent"})), TuplesKt.to(702, SetsKt.setOf(new String[]{"insert_keyword_task", "meta_full_content", "fullContent"})), TuplesKt.to(Integer.valueOf(EntityType.FILE), SetsKt.setOf(new String[]{"insert_keyword_task", "meta_full_content", "fullContent"})), TuplesKt.to(Integer.valueOf(EntityType.LIFE_LOG), SetsKt.setOf(new String[]{"meta_full_content", "fullContent"})), TuplesKt.to(Integer.valueOf(EntityType.USER_PROFILE), SetsKt.setOf("fullContent")), TuplesKt.to(Integer.valueOf(NetError.ERR_DISALLOWED_URL_SCHEME), SetsKt.setOf(new String[]{"insert_keyword_task", "fullAddress"})), TuplesKt.to(Integer.valueOf(NetError.ERR_UNKNOWN_URL_SCHEME), SetsKt.setOf("insert_keyword_task")), TuplesKt.to(Integer.valueOf(NetError.ERR_INVALID_REDIRECT), SetsKt.setOf(new String[]{"insert_keyword_task", "insert_content_time_task", "meta_full_content", "fullContent", "semantic1", "semantic2", "keywordAndSemantic1", "keywordAndSemantic2", MemoryListActivity.JUMP_FROM_DETAIL})), TuplesKt.to(-304, SetsKt.setOf(new String[]{"insert_keyword_task", "meta_full_content", "caption", "ocr", LocationMonitorConst.TAG, "photoEntityDbId"})), TuplesKt.to(-305, SetsKt.setOf(new String[]{"insert_keyword_task", "location"})), TuplesKt.to(-306, SetsKt.setOf(new String[]{"insert_content_time_task", "meta_full_content", Params.CONTENT, "fullContent"})), TuplesKt.to(-307, SetsKt.setOf(new String[]{"insert_keyword_task", "summary"})), TuplesKt.to(-308, SetsKt.setOf(Params.CONTENT)), TuplesKt.to(-309, SetsKt.setOf(Params.CONTENT)), TuplesKt.to(r14, SetsKt.setOf(Params.CONTENT)), TuplesKt.to(r12, SetsKt.setOf(new String[]{"insert_keyword_task", "file", "caption", "ocr"})), TuplesKt.to(r10, SetsKt.setOf(new String[]{"insert_keyword_task", "caption", "ocr", "photoEntityDbId"})), TuplesKt.to(-313, SetsKt.setOf(Params.CONTENT)), TuplesKt.to(-314, SetsKt.setOf("summary")), TuplesKt.to(r4, SetsKt.setOf(new String[]{"insert_keyword_task", "meta_full_content", "keyPhrase", "embeddingContent"})), TuplesKt.to(r2, SetsKt.setOf(new String[]{"meta_full_content", "fullContent"}))});
        e = SetsKt.setOf(new String[]{"vlm_embedding_update_text_task", "vlm_embedding_update_image_task"});
    }

    private IndexDashboardCoverageV1Policy() {
    }

    public final PendingClassification a(int r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "columnContent");
        Intrinsics.checkNotNullParameter(r4, "buildType");
        if (c.contains(Integer.valueOf(r2)) == false) goto L7;
        return PendingClassification.IGNORED;
    L7:
        if (f9305b.contains(Integer.valueOf(r2)) == true) goto L11;
        return PendingClassification.UNKNOWN;
    L11:
        if (Intrinsics.areEqual(r3, "lazy_index_task") == true) goto L32;
        if (Intrinsics.areEqual(r4, "lazy_index_task") == true) goto L32;
        if (Intrinsics.areEqual(r3, com.obric.memorydata.database.entity.d.INVALIDATE_VALUE) == true) goto L30;
        if (Intrinsics.areEqual(r4, com.obric.memorydata.database.entity.d.INVALIDATE_VALUE) == true) goto L30;
        Set<String> r1 = e;
        if (r1.contains(r3) == true) goto L30;
        if (r1.contains(r4) == true) goto L30;
        if (((Set) ZeusTransformUtils.preCheckCast(MapsKt.getValue(d, Integer.valueOf(r2)), Set.class, "com.obric.memorydata.plugin")).contains(r3) == false) goto L28;
        return PendingClassification.REQUIRED;
    L28:
        return PendingClassification.UNKNOWN;
    L30:
        return PendingClassification.IGNORED;
    L32:
        return PendingClassification.DEFERRED;
    }

    public final Set<Integer> a() {
        return f9305b;
    }

    public final boolean a(int r1) {
        return f9305b.contains(Integer.valueOf(r1));
    }

    public final Set<Integer> b() {
        return c;
    }
}
