package com.bytedance.android.live.ktv.common.model.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/bean/SetBgmFunctionType;", "", "KSONG", "MULTI_KTV", "PREVIEW_SONGS", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SetBgmFunctionType extends Enum<SetBgmFunctionType> {
    public static final SetBgmFunctionType KSONG = null;
    public static final SetBgmFunctionType MULTI_KTV = null;
    public static final SetBgmFunctionType PREVIEW_SONGS = null;
    public static final /* synthetic */ SetBgmFunctionType[] a = null;

    static {
        SetBgmFunctionType r1 = new SetBgmFunctionType("KSONG", 0);
        KSONG = r1;
        SetBgmFunctionType r2 = new SetBgmFunctionType("MULTI_KTV", 1);
        MULTI_KTV = r2;
        SetBgmFunctionType r3 = new SetBgmFunctionType("PREVIEW_SONGS", 2);
        PREVIEW_SONGS = r3;
        a = new SetBgmFunctionType[]{r1, r2, r3};
    }

    public static SetBgmFunctionType valueOf(String r1) {
        return (SetBgmFunctionType) r27.a.a(SetBgmFunctionType.class, r1);
    }

    public static SetBgmFunctionType[] values() {
        return (SetBgmFunctionType[]) a.clone();
    }

    public SetBgmFunctionType(String r1, int r2) {
        super(r1, r2);
    }
}
