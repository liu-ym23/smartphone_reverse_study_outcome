package com.bytedance.ies.bullet.service.popup.ui;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ies/bullet/service/popup/ui/AnimController$AnimProcessType", "", "Lcom/bytedance/ies/bullet/service/popup/ui/AnimController$AnimProcessType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum AnimController$AnimProcessType extends Enum<AnimController$AnimProcessType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AnimController$AnimProcessType f6091a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AnimController$AnimProcessType f6092b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AnimController$AnimProcessType f6093c = null;
    public static final /* synthetic */ AnimController$AnimProcessType[] d = null;

    static {
        AnimController$AnimProcessType r5 = new AnimController$AnimProcessType("NONE", 0);
        f6091a = r5;
        AnimController$AnimProcessType r10 = new AnimController$AnimProcessType("DOING", 1);
        f6092b = r10;
        AnimController$AnimProcessType r11 = new AnimController$AnimProcessType("DONE", 2);
        f6093c = r11;
        d = new AnimController$AnimProcessType[]{r5, r10, r11};
    }

    public AnimController$AnimProcessType(String r5, int r10) {
        super(r5, r10);
    }

    public static AnimController$AnimProcessType valueOf(String r5) {
        return (AnimController$AnimProcessType) Enum.valueOf(AnimController$AnimProcessType.class, r5);
    }

    public static AnimController$AnimProcessType[] values() {
        return (AnimController$AnimProcessType[]) d.clone();
    }
}
