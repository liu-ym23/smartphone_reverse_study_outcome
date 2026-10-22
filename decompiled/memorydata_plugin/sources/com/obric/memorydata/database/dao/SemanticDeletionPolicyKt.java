package com.obric.memorydata.database.dao;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\u001a$\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a0\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0000¨\u0006\u000e"}, d2 = {"semanticRetractionReason", "", "confidence", "", "requestedReason", "forceSystemRetraction", "", "canCleanupSemanticRetraction", InfoRequestQPSOptTraceLogger.REASON, "changeSeq", "", "retractedAt", "minConsumerCursor", "userDeleteCutoff", "database_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SemanticDeletionPolicyKt {
    public static final boolean canCleanupSemanticRetraction(String r1, long r2, long r4, long r6, long r8) {
        Intrinsics.checkNotNullParameter(r1, InfoRequestQPSOptTraceLogger.REASON);
        if (r2 <= r6) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(r1, SemanticRetractionReason.USER_DELETE) == true) goto L7;
    L8:
        return true;
    L7:
        if (r4 >= r8) goto L9;
        goto L8
    }

    public static final String semanticRetractionReason(float r4, String r5, boolean r6) {
        boolean r0 = true;
        if (r5 != null) goto L5;
    L7:
        r5 = null;
    L9:
        if (r5 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == false) goto L27;
        if (r5 != null) goto L25;
        if (r6 == true) goto L19;
        return null;
    L19:
        if (r4 == 4.0f) goto L22;
        r0 = false;
    L22:
        if (r0 == false) goto L29;
        return SemanticRetractionReason.SYSTEM_DELETE;
    L29:
        return null;
    L25:
        return r5;
    L27:
        throw new IllegalArgumentException("unsupported semantic retraction reason".toString());
    L11:
        if (SemanticRetractionReason.INSTANCE.getAll().contains(r5) == true) goto L14;
        r3 = false;
        goto L15
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L7;
        goto L7
    }
}
