package com.bytedance.forest.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/forest/model/ForestBuffer$Companion$State", "", "Lcom/bytedance/forest/model/ForestBuffer$Companion$State;", "forest_release"}, k = 1, mv = {1, 4, 0})
final enum ForestBuffer$Companion$State extends Enum<ForestBuffer$Companion$State> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ForestBuffer$Companion$State f4315a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ForestBuffer$Companion$State f4316b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ForestBuffer$Companion$State f4317c = null;
    public static final ForestBuffer$Companion$State d = null;
    public static final /* synthetic */ ForestBuffer$Companion$State[] e = null;

    static {
        ForestBuffer$Companion$State r5 = new ForestBuffer$Companion$State("Initial", 0);
        f4315a = r5;
        ForestBuffer$Companion$State r10 = new ForestBuffer$Companion$State("Caching", 1);
        f4316b = r10;
        ForestBuffer$Companion$State r11 = new ForestBuffer$Companion$State("Finished", 2);
        f4317c = r11;
        ForestBuffer$Companion$State r12 = new ForestBuffer$Companion$State("Clear", 3);
        d = r12;
        e = new ForestBuffer$Companion$State[]{r5, r10, r11, r12};
    }

    public ForestBuffer$Companion$State(String r5, int r10) {
        super(r5, r10);
    }

    public static ForestBuffer$Companion$State valueOf(String r5) {
        return (ForestBuffer$Companion$State) Enum.valueOf(ForestBuffer$Companion$State.class, r5);
    }

    public static ForestBuffer$Companion$State[] values() {
        return (ForestBuffer$Companion$State[]) e.clone();
    }
}
