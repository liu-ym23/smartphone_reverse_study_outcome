package com.bytedance.android.live.liveinteract.plantform.dynamicframe.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/AnimUpdateType;", "", "START_WEBP_ANIM", "SEAT", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AnimUpdateType extends Enum<AnimUpdateType> {
    public static final AnimUpdateType SEAT = null;
    public static final AnimUpdateType START_WEBP_ANIM = null;
    public static final /* synthetic */ AnimUpdateType[] a = null;

    static {
        AnimUpdateType r1 = new AnimUpdateType("START_WEBP_ANIM", 0);
        START_WEBP_ANIM = r1;
        AnimUpdateType r2 = new AnimUpdateType("SEAT", 1);
        SEAT = r2;
        a = new AnimUpdateType[]{r1, r2};
    }

    public static AnimUpdateType valueOf(String r1) {
        return (AnimUpdateType) a.a(AnimUpdateType.class, r1);
    }

    public static AnimUpdateType[] values() {
        return (AnimUpdateType[]) a.clone();
    }

    public AnimUpdateType(String r1, int r2) {
        super(r1, r2);
    }
}
