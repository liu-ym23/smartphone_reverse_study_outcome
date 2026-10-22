package com.obric.memorydata.memory;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/InAppSignalSequenceTracker;", "", "<init>", "()V", "MAX_SESSIONS", "", "newestSequenceBySession", "com/obric/memorydata/memory/InAppSignalSequenceTracker$newestSequenceBySession$1", "Lcom/obric/memorydata/memory/InAppSignalSequenceTracker$newestSequenceBySession$1;", "shouldKeep", "", "event", "Lorg/json/JSONObject;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f10336a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final InAppSignalSequenceTracker$newestSequenceBySession$1 f10337b = null;

    static {
        f10336a = new p();
        f10337b = new InAppSignalSequenceTracker$newestSequenceBySession$1();
    }

    private p() {
    }

    public final synchronized boolean a(JSONObject r8) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r8, "event");     // Catch: Throwable -> L26
        String r0 = r8.optString(ObricMemoryConstants.KEY_SESSION_ID);     // Catch: Throwable -> L26
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L26
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L6;
    L24:
        monitor-exit(this);
        return true;
    L6:
        if (r8.has("sequence") == false) goto L24;
        long r5 = r8.optLong("sequence", Long.MIN_VALUE);     // Catch: Throwable -> L26
        if (r5 != Long.MIN_VALUE) goto L13;
        monitor-exit(this);
        return true;
    L13:
        InAppSignalSequenceTracker$newestSequenceBySession$1 r9 = f10337b;     // Catch: Throwable -> L26
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(r9.get(r0), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        if (r1 != null) goto L17;
    L21:
        Long r2 = Long.valueOf(r5);     // Catch: Throwable -> L26
        ((Map) ZeusTransformUtils.preCheckCast(r9, Map.class, "com.obric.memorydata.plugin")).put(r0, r2);     // Catch: Throwable -> L26
        monitor-exit(this);
        return true;
    L17:
        if (r5 > r1.longValue()) goto L21;
        monitor-exit(this);
        return false;
    L26:
        th = move-exception;
        throw th;
    }
}
