package com.bytedance.android.live.liveinteract.plantform.dynamicframe.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/UpdateLayoutType;", "", "UPDATE", "RESET", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum UpdateLayoutType extends Enum<UpdateLayoutType> {
    public static final UpdateLayoutType RESET = null;
    public static final UpdateLayoutType UPDATE = null;
    public static final /* synthetic */ UpdateLayoutType[] a = null;

    static {
        UpdateLayoutType r1 = new UpdateLayoutType("UPDATE", 0);
        UPDATE = r1;
        UpdateLayoutType r2 = new UpdateLayoutType("RESET", 1);
        RESET = r2;
        a = new UpdateLayoutType[]{r1, r2};
    }

    public static UpdateLayoutType valueOf(String r1) {
        return (UpdateLayoutType) a.a(UpdateLayoutType.class, r1);
    }

    public static UpdateLayoutType[] values() {
        return (UpdateLayoutType[]) a.clone();
    }

    public UpdateLayoutType(String r1, int r2) {
        super(r1, r2);
    }
}
