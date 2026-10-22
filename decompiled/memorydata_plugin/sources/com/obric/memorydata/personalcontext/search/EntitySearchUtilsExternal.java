package com.obric.memorydata.personalcontext.search;

import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.search.IAppSearchCallback;
import com.obric.memorydata.database.model.EntitySearchRecordInfo;
import com.obric.memorydata.personalcontext.search.entity.CallMode;
import com.obric.memorydata.personalcontext.search.entity.SearchRequest;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JN\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0086@¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/EntitySearchUtilsExternal;", "", "<init>", "()V", "sendInAppSearchRequest", "", Ext.KEY_REQUEST, "Lcom/obric/memorydata/personalcontext/search/entity/SearchRequest;", "taskIds", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "callback", "Lcom/obric/capabilitykit/search/IAppSearchCallback;", "entitySearchRecordInfo", "Lcom/obric/memorydata/database/model/EntitySearchRecordInfo;", "callMode", "Lcom/obric/memorydata/personalcontext/search/entity/CallMode;", "businessName", "(Lcom/obric/memorydata/personalcontext/search/entity/SearchRequest;Ljava/util/concurrent/CopyOnWriteArrayList;Lcom/obric/capabilitykit/search/IAppSearchCallback;Lcom/obric/memorydata/database/model/EntitySearchRecordInfo;Lcom/obric/memorydata/personalcontext/search/entity/CallMode;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EntitySearchUtilsExternal {
    public static final EntitySearchUtilsExternal INSTANCE = null;

    static {
        INSTANCE = new EntitySearchUtilsExternal();
    }

    private EntitySearchUtilsExternal() {
    }

    public static /* synthetic */ Object sendInAppSearchRequest$default(EntitySearchUtilsExternal r10, SearchRequest r11, CopyOnWriteArrayList r12, IAppSearchCallback r13, EntitySearchRecordInfo r14, CallMode r15, String r16, Continuation r17, int r18, Object r19) {
        IAppSearchCallback r5 = (IAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r13, IAppSearchCallback.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r17, Continuation.class, "com.obric.memorydata.plugin");
        if ((r18 & 8) == 0) goto L5;
        EntitySearchRecordInfo r6 = null;
    L7:
        if ((r18 & 16) == 0) goto L9;
        CallMode r7 = CallMode.UNKNOWN;
    L11:
        if ((r18 & 32) == 0) goto L13;
        String r8 = null;
    L15:
        return r10.sendInAppSearchRequest(r11, r12, r5, r6, r7, r8, r9);
    L13:
        r8 = r16;
        goto L15
    L9:
        r7 = r15;
        goto L11
    L5:
        r6 = r14;
        goto L7
    }

    public final Object sendInAppSearchRequest(SearchRequest r12, CopyOnWriteArrayList<String> r13, IAppSearchCallback r14, EntitySearchRecordInfo r15, CallMode r16, String r17, Continuation<? super Unit> r18) {
        IAppSearchCallback r5 = (IAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r14, IAppSearchCallback.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r18, Continuation.class, "com.obric.memorydata.plugin");
        Object r0 = g.INSTANCE.sendInAppSearchRequest(r12, r13, r5, r15, r16, r17, null, r10);
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r0;
    L6:
        return Unit.INSTANCE;
    }
}
