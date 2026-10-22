package com.bytedance.android.live.liveinteract.linkbase.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkbase/api/LoadDurationItemType;", "", "", "value", "I", "getValue", "()I", "NONE_ITEM_TYPE", "LYNX_DYNAMIC_ITEM_TYPE", "linkbase-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LoadDurationItemType extends Enum<LoadDurationItemType> {
    public static final LoadDurationItemType LYNX_DYNAMIC_ITEM_TYPE = null;
    public static final LoadDurationItemType NONE_ITEM_TYPE = null;
    public static final /* synthetic */ LoadDurationItemType[] a = null;
    private final int value;

    static {
        LoadDurationItemType r1 = new LoadDurationItemType("NONE_ITEM_TYPE", 0, 0);
        NONE_ITEM_TYPE = r1;
        LoadDurationItemType r2 = new LoadDurationItemType("LYNX_DYNAMIC_ITEM_TYPE", 1, 1);
        LYNX_DYNAMIC_ITEM_TYPE = r2;
        a = new LoadDurationItemType[]{r1, r2};
    }

    public static LoadDurationItemType valueOf(String r1) {
        return (LoadDurationItemType) a.a(LoadDurationItemType.class, r1);
    }

    public static LoadDurationItemType[] values() {
        return (LoadDurationItemType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LoadDurationItemType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
