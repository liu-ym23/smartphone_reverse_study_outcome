package com.obric.memorydata.memory;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.livecard.api.impl.IslandImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/InAppSignalEventProcessor;", "", "<init>", "()V", "packageBlacklist", "", "", "allowedEventsBySystemHost", "", "process", "Lcom/obric/memorydata/memory/InAppSignalProcessedBatch;", "json", "flushRequestId", "shouldKeep", "", "event", "Lorg/json/JSONObject;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f10146a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f10147b = null;
    private static final Map<String, Set<String>> c = null;

    static {
        f10146a = new i();
        f10147b = SetsKt.setOf("com.android.launcher3");
        c = MapsKt.mapOf(TuplesKt.to(IslandImpl.LIVE_CARD_HOST, SetsKt.setOf("Toast_Shown")));
    }

    private i() {
    }

    private final boolean a(JSONObject r5) {
        JSONObject r4 = r5.optJSONObject("app");
        String r0 = null;
        if (r4 == null) goto L5;
        String r1 = r4.optString(ObricMemoryConstants.KEY_PACKAGE_NAME);
    L6:
        String r2 = "";
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        if (f10147b.contains(r1) == false) goto L13;
        return false;
    L13:
        if (r4 == null) goto L15;
        r0 = r4.optString("processName");
    L15:
        if (r0 == null) goto L18;
        r2 = r0;
    L18:
        Map<String, Set<String>> r6 = c;
        Set r3 = (Set) ZeusTransformUtils.preCheckCast(r6.get(r2), Set.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L25;
        r3 = (Set) ZeusTransformUtils.preCheckCast(r6.get(r1), Set.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L25;
        return true;
    L25:
        return r3.contains(r5.optString("eventType"));
    L5:
        r1 = null;
        goto L6
    }

    public final n a(String r18, String r19) {
        Intrinsics.checkNotNullParameter(r18, "json");
        Intrinsics.checkNotNullParameter(r19, "flushRequestId");
        Object r4 = null;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L29
        i r6 = (i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        JSONArray r7 = new JSONArray(r18);     // Catch: Throwable -> L29
        JSONArray r0 = new JSONArray();     // Catch: Throwable -> L29
        LinkedHashSet r8 = new LinkedHashSet();     // Catch: Throwable -> L29
        int r9 = r7.length();     // Catch: Throwable -> L29
        int r10 = 0;
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r10 >= r9) goto L27;
        JSONObject r11 = r7.optJSONObject(r10);     // Catch: Throwable -> L29
        if (r11 != null) goto L9;
    L7:
        r14 = r14 + 1;     // Catch: Throwable -> L29
    L26:
        r10 = r10 + 1;     // Catch: Throwable -> L29
        goto L4
    L9:
        if (r6.a(r11) == false) goto L7;
        if (p.f10336a.a(r11) == true) goto L14;
        r15 = r15 + 1;     // Catch: Throwable -> L29
        goto L26
    L14:
        m.f10299a.a(r11);     // Catch: Throwable -> L29
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L17;
    L19:
        String r12 = r11.optString("eventType");     // Catch: Throwable -> L29
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L23;
        r12 = null;
    L23:
        if (r12 == null) goto L25;
        r8.add(r12);     // Catch: Throwable -> L29
    L25:
        r0.put(r11);     // Catch: Throwable -> L29
        goto L26
    L17:
        if (r11.has(ObricMemoryConstants.KEY_IN_APP_SIGNAL_REQUEST_ID) == true) goto L19;
        r11.put(ObricMemoryConstants.KEY_IN_APP_SIGNAL_REQUEST_ID, r19);     // Catch: Throwable -> L29
        goto L19
    L27:
        String r13 = r0.toString();     // Catch: Throwable -> L29
        Intrinsics.checkNotNullExpressionValue(r13, "toString(...)");     // Catch: Throwable -> L29
        Object r1 = Result.m1421constructorimpl(new n(r13, r7.length(), r0.length(), r14, r15, (Set) ZeusTransformUtils.preCheckCast(r8, Set.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L29
    L32:
        if (Result.m1427isFailureimpl(r1) == true) goto L36;
        r4 = r1;
    L36:
        return (n) ZeusTransformUtils.preCheckCast(r4, n.class, "com.obric.memorydata.plugin");
    L29:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L32
    }
}
