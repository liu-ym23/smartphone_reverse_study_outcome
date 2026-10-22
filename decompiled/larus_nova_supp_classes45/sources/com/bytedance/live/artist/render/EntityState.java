package com.bytedance.live.artist.render;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/live/artist/render/EntityState;", "", "Init", "Prepared", "Rendering", "WaitDestroy", "Destroyed", "artist"}, k = 1, mv = {1, 4, 0})
public final enum EntityState extends Enum<EntityState> {
    public static final EntityState Destroyed = null;
    public static final EntityState Init = null;
    public static final EntityState Prepared = null;
    public static final EntityState Rendering = null;
    public static final EntityState WaitDestroy = null;
    public static final /* synthetic */ EntityState[] a = null;

    static {
        EntityState r1 = new EntityState("Init", 0);
        Init = r1;
        EntityState r2 = new EntityState("Prepared", 1);
        Prepared = r2;
        EntityState r3 = new EntityState("Rendering", 2);
        Rendering = r3;
        EntityState r4 = new EntityState("WaitDestroy", 3);
        WaitDestroy = r4;
        EntityState r5 = new EntityState("Destroyed", 4);
        Destroyed = r5;
        a = new EntityState[]{r1, r2, r3, r4, r5};
    }

    public static EntityState valueOf(String r1) {
        return (EntityState) r27.a.a(EntityState.class, r1);
    }

    public static EntityState[] values() {
        return (EntityState[]) a.clone();
    }

    public EntityState(String r1, int r2) {
        super(r1, r2);
    }
}
