package com.bytedance.android.live.base.model.longpresspanel;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/base/model/longpresspanel/LiveLongPressItemType;", "", "", "value", "I", "getValue", "()I", "NORMAL", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveLongPressItemType extends Enum<LiveLongPressItemType> {
    public static final LiveLongPressItemType NORMAL = null;
    public static final /* synthetic */ LiveLongPressItemType[] a = null;
    private final int value;

    static {
        LiveLongPressItemType r1 = new LiveLongPressItemType();
        NORMAL = r1;
        a = new LiveLongPressItemType[]{r1};
    }

    public static LiveLongPressItemType valueOf(String r1) {
        return (LiveLongPressItemType) a.a(LiveLongPressItemType.class, r1);
    }

    public static LiveLongPressItemType[] values() {
        return (LiveLongPressItemType[]) a.clone();
    }

    public LiveLongPressItemType() {
        super("NORMAL", 0);
        this.value = 1;
    }

    public final int getValue() {
        return this.value;
    }
}
