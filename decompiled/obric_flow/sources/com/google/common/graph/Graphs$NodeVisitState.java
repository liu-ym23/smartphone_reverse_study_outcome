package com.google.common.graph;

/* JADX INFO: loaded from: classes2.dex */
final enum Graphs$NodeVisitState extends Enum<Graphs$NodeVisitState> {
    public static final Graphs$NodeVisitState COMPLETE = null;
    public static final Graphs$NodeVisitState PENDING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Graphs$NodeVisitState[] f9253a = null;

    static {
        Graphs$NodeVisitState r5 = new Graphs$NodeVisitState("PENDING", 0);
        PENDING = r5;
        Graphs$NodeVisitState r10 = new Graphs$NodeVisitState("COMPLETE", 1);
        COMPLETE = r10;
        f9253a = new Graphs$NodeVisitState[]{r5, r10};
    }

    public static Graphs$NodeVisitState valueOf(String r5) {
        return (Graphs$NodeVisitState) Enum.valueOf(Graphs$NodeVisitState.class, r5);
    }

    public static Graphs$NodeVisitState[] values() {
        return (Graphs$NodeVisitState[]) f9253a.clone();
    }
}
