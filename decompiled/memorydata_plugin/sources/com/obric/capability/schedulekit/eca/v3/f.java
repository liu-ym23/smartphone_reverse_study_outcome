package com.obric.capability.schedulekit.eca.v3;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.capabilitykit.common.UtilsKt;
import com.obric.capabilitykit.common.execution.eca.ECAJob;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\nH\u0002J\b\u0010\u0012\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/obric/capability/schedulekit/eca/v3/ECAJobV3;", "Lcom/obric/capabilitykit/common/execution/eca/ECAJob;", "Lcom/obric/capability/schedulekit/eca/json/JsonBasedECAScriptPiece;", "actions", "", "Lcom/obric/capability/schedulekit/eca/v3/ECAAppIntentV3;", "(Ljava/util/List;)V", "getActions", "()Ljava/util/List;", "mJson", "Lcom/google/gson/JsonElement;", "getMJson", "()Lcom/google/gson/JsonElement;", "setMJson", "(Lcom/google/gson/JsonElement;)V", "commit", "", "ensureJson", "getJson", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class f implements ECAJob {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<b> f7407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JsonElement f7408b;

    public f(List<b> r3) {
        List<b> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "actions");
        this.f7407a = r4;
    }

    private final JsonElement c() {
        JsonElement r0 = a();
        if (r0 == null) goto L5;
        return r0;
    L5:
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(getActions(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r2.add(((b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.memorydata.plugin")).b());
        goto L7
    L9:
        List r4 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        JsonObject r5 = new JsonObject();
        r5.add("actions", UtilsKt.getGson().toJsonTree(r4));
        a((JsonElement) ZeusTransformUtils.preCheckCast(r5, JsonElement.class, "com.obric.memorydata.plugin"));
        return (JsonElement) ZeusTransformUtils.preCheckCast(r5, JsonElement.class, "com.obric.memorydata.plugin");
    }

    public JsonElement a() {
        return this.f7408b;
    }

    public void a(JsonElement r1) {
        this.f7408b = r1;
    }

    public JsonElement b() {
        return c();
    }

    @Override // com.obric.capabilitykit.common.execution.eca.ECAModifiable
    public void commit() {
        c();
        Iterator<b> r3 = getActions().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.memorydata.plugin")).commit();
        goto L4
    }

    @Override // com.obric.capabilitykit.common.execution.eca.ECAJob
    public List<b> getActions() {
        return this.f7407a;
    }

    @Override // com.obric.capabilitykit.common.execution.eca.ECAModifiable
    public boolean isDirty() {
        return ECAJob.DefaultImpls.isDirty(this);
    }

    @Override // com.obric.capabilitykit.common.execution.eca.ECAJob
    public boolean update(ECAJob r3) {
        return ECAJob.DefaultImpls.update(this, (ECAJob) ZeusTransformUtils.wrapperContextForParams(r3, ECAJob.class, "com.obric.memorydata.plugin"));
    }
}
