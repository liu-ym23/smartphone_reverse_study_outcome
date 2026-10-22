package com.obric.memorydata.awareness.impl.data;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/awareness/impl/data/AwarenessEventTriggerConfig;", "", "type", "", ActivityLifecycle.NAME, "featureSwitch", "Lcom/google/gson/JsonElement;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonElement;)V", "getType", "()Ljava/lang/String;", "getName", "getFeatureSwitch", "()Lcom/google/gson/JsonElement;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AwarenessEventTriggerConfig {

    @SerializedName("feature_switch")
    private final JsonElement featureSwitch;

    @SerializedName(ActivityLifecycle.NAME)
    private final String name;

    @SerializedName("type")
    private final String type;

    public AwarenessEventTriggerConfig(String r2, String r3, JsonElement r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        this.type = r2;
        this.name = r3;
        this.featureSwitch = r4;
    }

    public /* synthetic */ AwarenessEventTriggerConfig(String r1, String r2, JsonElement r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }

    public static /* synthetic */ AwarenessEventTriggerConfig copy$default(AwarenessEventTriggerConfig r0, String r1, String r2, JsonElement r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.name;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.featureSwitch;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.name;
    }

    public final JsonElement component3() {
        return this.featureSwitch;
    }

    public final AwarenessEventTriggerConfig copy(String r1, String r2, JsonElement r3) {
        Intrinsics.checkNotNullParameter(r1, "type");
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        return new AwarenessEventTriggerConfig(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AwarenessEventTriggerConfig.class) == true) goto L8;
        return false;
    L8:
        AwarenessEventTriggerConfig r6 = (AwarenessEventTriggerConfig) ZeusTransformUtils.preCheckCast(r5, AwarenessEventTriggerConfig.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.featureSwitch, r6.featureSwitch) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final JsonElement getFeatureSwitch() {
        return this.featureSwitch;
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int r0 = ((this.type.hashCode() * 31) + this.name.hashCode()) * 31;
        JsonElement r2 = this.featureSwitch;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "AwarenessEventTriggerConfig(type=" + this.type + ", name=" + this.name + ", featureSwitch=" + this.featureSwitch + ')';
    }
}
