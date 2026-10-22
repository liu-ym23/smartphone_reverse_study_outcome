package com.larus.settings.provider.chat;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/larus/settings/provider/chat/FlowForkConfig;", "", "rawEnableFork", "Lcom/google/gson/JsonElement;", "<init>", "(Lcom/google/gson/JsonElement;)V", "enableFork", "", "getEnableFork$settings_mainlandRelease", "()Z", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class FlowForkConfig {

    @SerializedName("enable_fork")
    private final JsonElement rawEnableFork;

    public FlowForkConfig() {
        JsonElement r0 = null;
        this(r0, 1, r0);
    }

    public final boolean getEnableFork$settings_mainlandRelease() {
        JsonElement r0 = this.rawEnableFork;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isJsonPrimitive() == true) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == true) goto L13;
        r0 = null;
    L13:
        if (r0 != null) goto L15;
        return false;
    L15:
        if (r0.getAsBoolean() != true) goto L20;
        return true;
    L20:
        return false;
    L7:
        if (r0.getAsJsonPrimitive().isBoolean() == false) goto L9;
        r2 = true;
        goto L10
    }

    public FlowForkConfig(JsonElement r1) {
        this.rawEnableFork = r1;
    }

    public /* synthetic */ FlowForkConfig(JsonElement r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
