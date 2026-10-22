package com.google.common.graph;

/* JADX INFO: loaded from: classes2.dex */
final enum GraphConstants$Presence extends Enum<GraphConstants$Presence> {
    public static final GraphConstants$Presence EDGE_EXISTS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GraphConstants$Presence[] f9252a = null;

    static {
        GraphConstants$Presence r5 = new GraphConstants$Presence("EDGE_EXISTS", 0);
        EDGE_EXISTS = r5;
        f9252a = new GraphConstants$Presence[]{r5};
    }

    public static GraphConstants$Presence valueOf(String r5) {
        return (GraphConstants$Presence) Enum.valueOf(GraphConstants$Presence.class, r5);
    }

    public static GraphConstants$Presence[] values() {
        return (GraphConstants$Presence[]) f9252a.clone();
    }
}
