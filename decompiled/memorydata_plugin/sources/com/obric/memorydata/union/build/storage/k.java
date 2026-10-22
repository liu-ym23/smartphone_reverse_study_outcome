package com.obric.memorydata.union.build.storage;

import com.obric.memorydata.database.dao.SemanticDeleteLifecycle;
import com.obric.memorydata.database.dao.SemanticDeleteResult;
import com.obric.memorydata.database.dao.SemanticRetractionReason;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0005J\u0014\u0010\r\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/union/build/storage/SemanticConfirmationManager;", "", "<init>", "()V", "MAX_QUERY_LIMIT", "", "queryFormalList", "", "payload", "queryPendingConfirmation", "limit", "orderBy", "countPendingConfirmation", "queryConflicts", "entityIds", "", "confirmC3", "Lcom/obric/memorydata/union/build/storage/SemanticConfirmationResult;", "deleteSemantic", "entityId", "expectedChangeSeq", "", "parseConfirmRequest", "Lcom/obric/memorydata/union/build/storage/SemanticConfirmRequest;", "failure", "code", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f13128a = null;

    static {
        f13128a = new k();
    }

    private k() {
    }

    private final SemanticConfirmationResult a(String r8) {
        return new SemanticConfirmationResult(false, r8, null, null, 12, null);
    }

    public final SemanticConfirmationResult a(String r4, long r5) {
        Intrinsics.checkNotNullParameter(r4, "entityId");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L22;
        if (r5 < 0) goto L22;
        boolean r1 = false;
        SemanticDeleteResult r6 = SemanticDeleteLifecycle.INSTANCE.deleteExpected(MapsKt.mapOf(TuplesKt.to(r4, Long.valueOf(r5))), SemanticRetractionReason.USER_DELETE, false);     // Catch: IllegalStateException -> L19
        if (r6.getDeleted() <= 0) goto L11;
        EntityManager.INSTANCE.launchIndexTask();     // Catch: IllegalStateException -> L19
    L11:
        if (r6.getDeleted() != 1) goto L14;
        r1 = true;
    L14:
        if (r6.getDeleted() != 1) goto L16;
        String r0 = "OK";
    L17:
        return new SemanticConfirmationResult(r1, r0, r4, r6.getChangeSeq());
    L16:
        r0 = "TARGET_NOT_FOUND";
    L20:
        return a("SEMANTIC_VERSION_CHANGED");
    L22:
        return a("INVALID_DELETE");
    }
}
