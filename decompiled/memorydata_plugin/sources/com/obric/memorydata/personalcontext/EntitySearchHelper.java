package com.obric.memorydata.personalcontext;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IEntitySearchHelper;
import com.obric.memorydata.personalcontext.search.entity.SearchAction;
import com.obric.memorydata.personalcontext.search.entity.SearchParamsAssistant;
import com.obric.memorydata.personalcontext.search.entity.SearchRequest;
import com.obric.memorydata.personalcontext.search.entity.SearchType;
import com.obric.memorydata.sdk.entity.search.AssistantQuResult;
import com.obric.memorydata.sdk.entity.search.ParamItem;
import com.obric.memorydata.sdk.entity.search.QuAction;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\u0000H\u0007¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/personalcontext/EntitySearchHelper;", "Lcom/obric/memorydata/personalcontext/api/IEntitySearchHelper;", "<init>", "()V", "search", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "searchType", "", "quResult", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInst", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EntitySearchHelper implements IEntitySearchHelper {
    public static final EntitySearchHelper INSTANCE = null;

    static {
        INSTANCE = new EntitySearchHelper();
    }

    private EntitySearchHelper() {
    }

    @JvmStatic
    public static final EntitySearchHelper getInst() {
        return INSTANCE;
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntitySearchHelper
    public Object search(String r13, String r14, Continuation<? super List<? extends AppEntity>> r15) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        Object r12 = u.a().fromJson(r14, AssistantQuResult.class);     // Catch: Exception -> L5
    L7:
        AssistantQuResult r16 = (AssistantQuResult) ZeusTransformUtils.preCheckCast(r12, AssistantQuResult.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L24;
        List<QuAction> r17 = r16.getActions();
        if (r17 == null) goto L24;
        com.obric.memorydata.personalcontext.search.g r1 = com.obric.memorydata.personalcontext.search.g.INSTANCE;
        SearchType r18 = SearchType.Companion.a(r13);
        if (r18 != null) goto L14;
        r18 = SearchType.ASSISTANT;
    L14:
        SearchType r3 = r18;
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin");
        Collection r110 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r111 = r19.iterator();
    L16:
        if (r111.hasNext() == false) goto L22;
        QuAction r112 = (QuAction) ZeusTransformUtils.preCheckCast(r111.next(), QuAction.class, "com.obric.memorydata.plugin");
        String r2 = r112.getActionName();
        Map<String, ParamItem> r4 = r112.getInputParams();
        if (r4 != null) goto L20;
        r4 = MapsKt.emptyMap();
    L20:
        r110.add(new SearchAction(r2, r4, r112.getActionId()));
        goto L16
    L22:
        return com.obric.memorydata.personalcontext.search.g.sendSearchRequest$default(r1, new SearchRequest(r3, new SearchParamsAssistant((List) ZeusTransformUtils.preCheckCast(r110, List.class, "com.obric.memorydata.plugin")), null, 4, null), null, null, null, null, null, false, r9, WebSocketProtocol.PAYLOAD_SHORT, null);
    L24:
        return CollectionsKt.emptyList();
    L5:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GsonExt", "convert content: " + r14 + " toObj error : " + e, null, 4, null);
        r12 = null;
        goto L7
    }
}
