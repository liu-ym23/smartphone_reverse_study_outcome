package com.larksuite.component.blockit.core;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final enum BlockLifeCycleEvent extends Enum<BlockLifeCycleEvent> {
    public static final BlockLifeCycleEvent ON_DESTROY = null;
    public static final BlockLifeCycleEvent ON_HIDE = null;
    public static final BlockLifeCycleEvent ON_INIT = null;
    public static final BlockLifeCycleEvent ON_LOAD = null;
    public static final BlockLifeCycleEvent ON_SHOW = null;
    public static final BlockLifeCycleEvent UNKNOWN = null;
    public static final /* synthetic */ BlockLifeCycleEvent[] a = null;
    String name;

    static {
        BlockLifeCycleEvent r0 = new BlockLifeCycleEvent("ON_INIT", 0, "onInit");
        ON_INIT = r0;
        BlockLifeCycleEvent r1 = new BlockLifeCycleEvent("ON_LOAD", 1, "onLoad");
        ON_LOAD = r1;
        BlockLifeCycleEvent r2 = new BlockLifeCycleEvent("ON_SHOW", 2, "onShow");
        ON_SHOW = r2;
        BlockLifeCycleEvent r4 = new BlockLifeCycleEvent("ON_HIDE", 3, "onHide");
        ON_HIDE = r4;
        BlockLifeCycleEvent r6 = new BlockLifeCycleEvent("ON_DESTROY", 4, "onDestroy");
        ON_DESTROY = r6;
        BlockLifeCycleEvent r8 = new BlockLifeCycleEvent("UNKNOWN", 5, "unknown");
        UNKNOWN = r8;
        a = new BlockLifeCycleEvent[]{r0, r1, r2, r4, r6, r8};
    }

    public static BlockLifeCycleEvent[] values() {
        return (BlockLifeCycleEvent[]) a.clone();
    }

    public static BlockLifeCycleEvent valueOf(String r1) {
        return (BlockLifeCycleEvent) r27.a.a(BlockLifeCycleEvent.class, r1);
    }

    public BlockLifeCycleEvent(String r1, int r2, String r3) {
        super(r1, r2);
        this.name = r3;
    }
}
