package com.bytedance.platform.godzilla.plugin;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum PluginState extends Enum<PluginState> {
    private static final /* synthetic */ PluginState[] $VALUES = null;
    public static final PluginState DESTROYED = null;
    public static final PluginState INITIALIZED = null;
    public static final PluginState STARTED = null;
    public static final PluginState STOPPED = null;

    static {
        PluginState r0 = new PluginState("INITIALIZED", 0);
        INITIALIZED = r0;
        PluginState r1 = new PluginState("STARTED", 1);
        STARTED = r1;
        PluginState r3 = new PluginState("STOPPED", 2);
        STOPPED = r3;
        PluginState r5 = new PluginState("DESTROYED", 3);
        DESTROYED = r5;
        $VALUES = new PluginState[]{r0, r1, r3, r5};
    }

    private PluginState(String r1, int r2) {
        super(r1, r2);
    }

    public static PluginState valueOf(String r2) {
        return (PluginState) ZeusTransformUtils.preCheckCast(Enum.valueOf(PluginState.class, r2), PluginState.class, "com.obric.memorydata.plugin");
    }

    public static PluginState[] values() {
        return (PluginState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PluginState[].class, "com.obric.memorydata.plugin");
    }
}
