package com.obric.memorydata.awareness.impl.gate;

import com.google.gson.JsonElement;
import com.obric.memorydata.awareness.impl.data.AwarenessEventTriggerConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerPackageSwitchConfig;", "", "packageSwitches", "Lcom/google/gson/JsonElement;", "awarenessEventTriggers", "", "Lcom/obric/memorydata/awareness/impl/data/AwarenessEventTriggerConfig;", "<init>", "(Lcom/google/gson/JsonElement;Ljava/util/List;)V", "getPackageSwitches", "()Lcom/google/gson/JsonElement;", "getAwarenessEventTriggers", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JsonElement f8680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<AwarenessEventTriggerConfig> f8681b;

    public b(JsonElement r3, List<AwarenessEventTriggerConfig> r4) {
        List<AwarenessEventTriggerConfig> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.f8680a = r3;
        this.f8681b = r5;
    }

    public final JsonElement a() {
        return this.f8680a;
    }

    public final List<AwarenessEventTriggerConfig> b() {
        return this.f8681b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f8680a, r6.f8680a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8681b, r6.f8681b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        JsonElement r0 = this.f8680a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<AwarenessEventTriggerConfig> r4 = this.f8681b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AutoTriggerPackageSwitchConfig(packageSwitches=" + this.f8680a + ", awarenessEventTriggers=" + this.f8681b + ')';
    }
}
