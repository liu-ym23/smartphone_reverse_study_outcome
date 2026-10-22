package com.obric.capability.schedulekit.eca.v3;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.capabilitykit.common.UtilsKt;
import com.obric.capabilitykit.common.execution.eca.ECAJob;
import com.obric.capabilitykit.common.execution.eca.ECAScript;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/obric/capability/schedulekit/eca/v3/ECAScriptV3;", "Lcom/obric/capabilitykit/common/execution/eca/ECAScript;", "Lcom/obric/capability/schedulekit/eca/json/JsonBasedECAScriptPiece;", "()V", "mJson", "Lcom/google/gson/JsonElement;", "getMJson", "()Lcom/google/gson/JsonElement;", "setMJson", "(Lcom/google/gson/JsonElement;)V", "version", "", "getVersion", "()I", "commit", "", "ensureJson", "getJson", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class g extends ECAScript {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f7409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JsonElement f7410b;

    public g() {
        this.f7409a = 3;
    }

    private final JsonElement c() {
        commit();
        JsonElement r0 = a();
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public JsonElement a() {
        return this.f7410b;
    }

    public void a(JsonElement r1) {
        this.f7410b = r1;
    }

    public JsonElement b() {
        return c();
    }

    @Override // com.obric.capabilitykit.common.execution.eca.ECAModifiable
    public void commit() {
        JsonElement r0 = a();
        if (r0 != null) goto L6;
        r0 = (JsonElement) ZeusTransformUtils.preCheckCast(new JsonObject(), JsonElement.class, "com.obric.memorydata.plugin");
    L6:
        if (ZeusTransformUtils.instanceOf(r0, JsonObject.class) == false) goto L8;
        JsonObject r1 = (JsonObject) ZeusTransformUtils.preCheckCast(r0, JsonObject.class, "com.obric.memorydata.plugin");
    L9:
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(getJobs(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L18;
        ECAJob r5 = (ECAJob) ZeusTransformUtils.preCheckCast(r3.next(), ECAJob.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, f.class) == false) goto L15;
        JsonElement r6 = ((f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.memorydata.plugin")).b();
    L16:
        if (r6 == null) goto L11;
        r4.add(r6);
        goto L11
    L15:
        r6 = null;
        goto L16
    L18:
        List r7 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L21;
        r1.add("jobs", UtilsKt.getGson().toJsonTree(r7));
    L21:
        a((JsonElement) ZeusTransformUtils.preCheckCast(r1, JsonElement.class, "com.obric.memorydata.plugin"));
        return;
    L8:
        r1 = null;
        goto L9
    }

    @Override // com.obric.capabilitykit.common.execution.eca.ECAScript
    public int getVersion() {
        return this.f7409a;
    }
}
