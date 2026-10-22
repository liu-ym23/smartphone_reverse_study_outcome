package com.obric.oui.panel.anim;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/obric/oui/panel/anim/AnimController$AnimProcessType", "", "Lcom/obric/oui/panel/anim/AnimController$AnimProcessType;", "NONE", "DOING", "DONE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum AnimController$AnimProcessType extends Enum<AnimController$AnimProcessType> {
    public static final AnimController$AnimProcessType DOING = null;
    public static final AnimController$AnimProcessType DONE = null;
    public static final AnimController$AnimProcessType NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnimController$AnimProcessType[] f13996a = null;

    static {
        AnimController$AnimProcessType r5 = new AnimController$AnimProcessType("NONE", 0);
        NONE = r5;
        AnimController$AnimProcessType r10 = new AnimController$AnimProcessType("DOING", 1);
        DOING = r10;
        AnimController$AnimProcessType r11 = new AnimController$AnimProcessType("DONE", 2);
        DONE = r11;
        f13996a = new AnimController$AnimProcessType[]{r5, r10, r11};
    }

    public static AnimController$AnimProcessType valueOf(String r5) {
        return (AnimController$AnimProcessType) Enum.valueOf(AnimController$AnimProcessType.class, r5);
    }

    public static AnimController$AnimProcessType[] values() {
        return (AnimController$AnimProcessType[]) f13996a.clone();
    }
}
