package com.bytedance.android.live.profit.fansclub.widget.entrance.mvistate;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/widget/entrance/mvistate/EntranceAnimState;", "", "NONE", "FOLLOWED_TICKING", "FOLLOWED_HIDING", "FOLLOWED_SHOWING", "ACTIVATED_HIDING", "ACTIVATED_SHOWING", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EntranceAnimState extends Enum<EntranceAnimState> {
    public static final EntranceAnimState ACTIVATED_HIDING = null;
    public static final EntranceAnimState ACTIVATED_SHOWING = null;
    public static final EntranceAnimState FOLLOWED_HIDING = null;
    public static final EntranceAnimState FOLLOWED_SHOWING = null;
    public static final EntranceAnimState FOLLOWED_TICKING = null;
    public static final EntranceAnimState NONE = null;
    public static final /* synthetic */ EntranceAnimState[] a = null;

    static {
        EntranceAnimState r1 = new EntranceAnimState("NONE", 0);
        NONE = r1;
        EntranceAnimState r2 = new EntranceAnimState("FOLLOWED_TICKING", 1);
        FOLLOWED_TICKING = r2;
        EntranceAnimState r3 = new EntranceAnimState("FOLLOWED_HIDING", 2);
        FOLLOWED_HIDING = r3;
        EntranceAnimState r4 = new EntranceAnimState("FOLLOWED_SHOWING", 3);
        FOLLOWED_SHOWING = r4;
        EntranceAnimState r5 = new EntranceAnimState("ACTIVATED_HIDING", 4);
        ACTIVATED_HIDING = r5;
        EntranceAnimState r6 = new EntranceAnimState("ACTIVATED_SHOWING", 5);
        ACTIVATED_SHOWING = r6;
        a = new EntranceAnimState[]{r1, r2, r3, r4, r5, r6};
    }

    public static EntranceAnimState valueOf(String r1) {
        return (EntranceAnimState) a.a(EntranceAnimState.class, r1);
    }

    public static EntranceAnimState[] values() {
        return (EntranceAnimState[]) a.clone();
    }

    public EntranceAnimState(String r1, int r2) {
        super(r1, r2);
    }
}
