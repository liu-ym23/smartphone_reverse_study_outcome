package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/platform/model/audio/RealtimeCallSceneModeHelloConfig;", "", "enableSceneGuide", "", "enableSceneHello", "<init>", "(ZZ)V", "getEnableSceneGuide", "()Z", "getEnableSceneHello", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class RealtimeCallSceneModeHelloConfig {

    @SerializedName("enable_scene_panel_guide")
    private final boolean enableSceneGuide;

    @SerializedName("enable_enter_scene_hello")
    private final boolean enableSceneHello;

    public RealtimeCallSceneModeHelloConfig() {
        boolean r2 = false;
        this(r2, r2, 3, null);
    }

    public static /* synthetic */ RealtimeCallSceneModeHelloConfig copy$default(RealtimeCallSceneModeHelloConfig r0, boolean r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.enableSceneGuide;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.enableSceneHello;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.enableSceneGuide;
    }

    public final boolean component2() {
        return this.enableSceneHello;
    }

    public final RealtimeCallSceneModeHelloConfig copy(boolean r2, boolean r3) {
        return new RealtimeCallSceneModeHelloConfig(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RealtimeCallSceneModeHelloConfig) == true) goto L8;
        return false;
    L8:
        RealtimeCallSceneModeHelloConfig r6 = (RealtimeCallSceneModeHelloConfig) r5;
        if (this.enableSceneGuide == r6.enableSceneGuide) goto L12;
        return false;
    L12:
        if (this.enableSceneHello == r6.enableSceneHello) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.enableSceneGuide == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.enableSceneHello == true) goto L11;
        r1 = 1237;
    L11:
        return r2 + r1;
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "RealtimeCallSceneModeHelloConfig(enableSceneGuide=" + this.enableSceneGuide + ", enableSceneHello=" + this.enableSceneHello + ')';
    }

    public final boolean getEnableSceneGuide() {
        return this.enableSceneGuide;
    }

    public final boolean getEnableSceneHello() {
        return this.enableSceneHello;
    }

    public RealtimeCallSceneModeHelloConfig(boolean r1, boolean r2) {
        this.enableSceneGuide = r1;
        this.enableSceneHello = r2;
    }

    public /* synthetic */ RealtimeCallSceneModeHelloConfig(boolean r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = true;
    L8:
        this(r1, r2);
    }
}
