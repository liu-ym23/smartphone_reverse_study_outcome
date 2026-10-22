package com.obric.memorydata.personalcontext.impl;

import com.obric.memorydata.database.model.CommonTextSearchDocument;
import com.obric.memorydata.middleware.api.bridge.IInvertedIndexDbBridgeAPI;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.database.QueryType;
import com.obric.memorydata.middleware.database.f;
import com.obric.memorydata.personalcontext.bridge.d;
import com.obric.memorydata.utils.GsonUtil;
import com.obric.search.api.query.impl.FullTextSearchQuery;
import com.obric.search.api.search.impl.FullTextSearchSpec;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0000H\u0007J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J<\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/InvertedIndexDbBridgeImpl;", "Lcom/obric/memorydata/middleware/api/bridge/IInvertedIndexDbBridgeAPI;", "<init>", "()V", "TAG", "", "getInst", "putDocuments", "", "dbName", "documentJson", "", "Lorg/json/JSONObject;", "removeDocuments", "search", "", "schemaName", "queryJson", "limit", "targetIds", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InvertedIndexDbBridgeImpl implements IInvertedIndexDbBridgeAPI {
    public static final InvertedIndexDbBridgeImpl INSTANCE = null;
    private static final String TAG = "InvertedIndexDbBridgeImpl";

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12186a = null;

        static {
            int[] r0 = new int[QueryType.values().length];
            r0[QueryType.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[QueryType.SYNONYM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[QueryType.SAME_PINYIN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f12186a = r0;
        }
    }

    static {
        INSTANCE = new InvertedIndexDbBridgeImpl();
    }

    private InvertedIndexDbBridgeImpl() {
    }

    @JvmStatic
    public static final InvertedIndexDbBridgeImpl getInst() {
        return INSTANCE;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IInvertedIndexDbBridgeAPI
    public boolean putDocuments(String r11, List<? extends JSONObject> r12) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "dbName");
        Intrinsics.checkNotNullParameter(r10, "documentJson");
        RunLog.INSTANCE.debug(TAG, "putDocuments, dbName: " + r11 + ", documentJson: " + r10);
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L13;
        JSONObject r1 = (JSONObject) ZeusTransformUtils.preCheckCast(r15.next(), JSONObject.class, "com.obric.memorydata.plugin");
        GsonUtil r3 = GsonUtil.INSTANCE;
        String r2 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        Object r4 = r3.getGSON().fromJson(r2, CommonTextSearchDocument.class);     // Catch: Exception -> L8
    L10:
        CommonTextSearchDocument r5 = (CommonTextSearchDocument) ZeusTransformUtils.preCheckCast(r4, CommonTextSearchDocument.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L4;
        r14.add(r5);
    L8:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), GsonUtil.TAG, "json error ：" + e, null, 4, null);
        r4 = null;
        goto L10
    L13:
        List<? extends com.obric.search.api.b.a.a> r16 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin");
        if (r16.isEmpty() == false) goto L17;
        return false;
    L17:
        boolean r17 = d.f12043a.b(r11).a(r16);
        RunLog.INSTANCE.debug(TAG, "putDocuments success: " + r17);
        return r17;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IInvertedIndexDbBridgeAPI
    public boolean removeDocuments(String r11, List<? extends JSONObject> r12) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "dbName");
        Intrinsics.checkNotNullParameter(r10, "documentJson");
        RunLog.INSTANCE.debug(TAG, "removeDocuments, dbName: " + r11 + ", documentJson: " + r10);
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L13;
        JSONObject r1 = (JSONObject) ZeusTransformUtils.preCheckCast(r15.next(), JSONObject.class, "com.obric.memorydata.plugin");
        GsonUtil r3 = GsonUtil.INSTANCE;
        String r2 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        Object r4 = r3.getGSON().fromJson(r2, CommonTextSearchDocument.class);     // Catch: Exception -> L8
    L10:
        CommonTextSearchDocument r5 = (CommonTextSearchDocument) ZeusTransformUtils.preCheckCast(r4, CommonTextSearchDocument.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L4;
        r14.add(r5);
    L8:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), GsonUtil.TAG, "json error ：" + e, null, 4, null);
        r4 = null;
        goto L10
    L13:
        List r6 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin");
        if (r6.isEmpty() == false) goto L17;
        return false;
    L17:
        boolean r16 = d.f12043a.b(r11).a((com.obric.search.api.e.b.a) ZeusTransformUtils.preCheckCast(new com.obric.search.api.e.a.a(((CommonTextSearchDocument) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r6), CommonTextSearchDocument.class, "com.obric.memorydata.plugin")).getSchemaName(), r6, false, 4, null), com.obric.search.api.e.b.a.class, "com.obric.memorydata.plugin"));
        RunLog.INSTANCE.debug(TAG, "removeDocuments success: " + r16);
        return r16;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IInvertedIndexDbBridgeAPI
    public List<Long> search(String r20, String r21, JSONObject r22, long r23, List<Long> r25) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r20, "dbName");
        Intrinsics.checkNotNullParameter(r21, "schemaName");
        Intrinsics.checkNotNullParameter(r22, "queryJson");
        Intrinsics.checkNotNullParameter(r12, "targetIds");
        GsonUtil r0 = GsonUtil.INSTANCE;
        String r4 = r22.toString();
        Intrinsics.checkNotNullExpressionValue(r4, "toString(...)");
        Object r1 = r0.getGSON().fromJson(r4, f.class);     // Catch: Exception -> L5
    L7:
        f r2 = (f) ZeusTransformUtils.preCheckCast(r1, f.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L10;
    L36:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "search query is invalid: " + r22, null, 4, null);
        return CollectionsKt.emptyList();
    L10:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2.a(), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == true) goto L36;
        QueryType r6 = QueryType.Companion.a(r2.d());
        if (r6 != null) goto L18;
        int r7 = -1;
    L20:
        if (r7 == 1) goto L27;
        if (r7 != 2) goto L23;
        FullTextSearchQuery r8 = FullTextSearchQuery.f14939a.b(r2.a(), r2.e());
    L28:
        FullTextSearchQuery r9 = r8;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r2.b(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L32;
        r9.a(r2.b(), false);
    L32:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r2.c(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L34;
        r9.a(r2.c(), true);
    L34:
        List<Long> r3 = d.f12043a.b(r20).a((com.obric.search.api.search.a.a) ZeusTransformUtils.preCheckCast(new FullTextSearchSpec(r21, r9, FullTextSearchSpec.RankMethod.BM25, r23, 0, r12, 16, null), com.obric.search.api.search.a.a.class, "com.obric.memorydata.plugin"));
        RunLog.INSTANCE.debug(TAG, "search " + r22 + " return result: " + r3);
        return r3;
    L23:
        if (r7 == 3) goto L25;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "unknown query type: " + r2.d(), null, 4, null);
        goto L27
    L25:
        r8 = FullTextSearchQuery.f14939a.c(r2.a(), new Regex("^[a-zA-Z]+$").matches((CharSequence) ZeusTransformUtils.preCheckCast(r2.a(), CharSequence.class, "com.obric.memorydata.plugin")));
    L27:
        r8 = FullTextSearchQuery.a.a(FullTextSearchQuery.f14939a, r2.a(), false, 2, null);
        goto L28
    L18:
        r7 = a.f12186a[r6.ordinal()];
        goto L20
    L12:
        r5 = false;
    L5:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), GsonUtil.TAG, "json error ：" + e, null, 4, null);
        r1 = null;
        goto L7
    }
}
