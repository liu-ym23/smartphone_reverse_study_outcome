package com.bytedance.android.livesdk.gift.util;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/util/GiftListFetchAction;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "I", "getValue", "()I", "FETCH_ACTION_DEFAULT", "FETCH_ACTION_FIRST_ENTER_ROOM", "FETCH_ACTION_FIRST_OPEN_GIFT_PANEL", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GiftListFetchAction extends Enum<GiftListFetchAction> {
    public static final GiftListFetchAction FETCH_ACTION_DEFAULT = null;
    public static final GiftListFetchAction FETCH_ACTION_FIRST_ENTER_ROOM = null;
    public static final GiftListFetchAction FETCH_ACTION_FIRST_OPEN_GIFT_PANEL = null;
    public static final /* synthetic */ GiftListFetchAction[] a = null;
    private final int value;

    static {
        GiftListFetchAction r1 = new GiftListFetchAction("FETCH_ACTION_DEFAULT", 0, 0);
        FETCH_ACTION_DEFAULT = r1;
        GiftListFetchAction r2 = new GiftListFetchAction("FETCH_ACTION_FIRST_ENTER_ROOM", 1, 1);
        FETCH_ACTION_FIRST_ENTER_ROOM = r2;
        GiftListFetchAction r3 = new GiftListFetchAction("FETCH_ACTION_FIRST_OPEN_GIFT_PANEL", 2, 2);
        FETCH_ACTION_FIRST_OPEN_GIFT_PANEL = r3;
        a = new GiftListFetchAction[]{r1, r2, r3};
    }

    public static GiftListFetchAction valueOf(String r1) {
        return (GiftListFetchAction) r27.a.a(GiftListFetchAction.class, r1);
    }

    public static GiftListFetchAction[] values() {
        return (GiftListFetchAction[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public GiftListFetchAction(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
