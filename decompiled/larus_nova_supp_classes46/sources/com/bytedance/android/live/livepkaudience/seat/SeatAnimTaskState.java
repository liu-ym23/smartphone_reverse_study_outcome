package com.bytedance.android.live.livepkaudience.seat;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/seat/SeatAnimTaskState;", "", "IDLE", "LINK_SUC_ANIM", "DYNAMIC_EMOJI", "KTV_SINGER_ANIMA", "GUEST_BATTLE_ANIM", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SeatAnimTaskState extends Enum<SeatAnimTaskState> {
    public static final SeatAnimTaskState DYNAMIC_EMOJI = null;
    public static final SeatAnimTaskState GUEST_BATTLE_ANIM = null;
    public static final SeatAnimTaskState IDLE = null;
    public static final SeatAnimTaskState KTV_SINGER_ANIMA = null;
    public static final SeatAnimTaskState LINK_SUC_ANIM = null;
    public static final /* synthetic */ SeatAnimTaskState[] a = null;

    static {
        SeatAnimTaskState r1 = new SeatAnimTaskState("IDLE", 0);
        IDLE = r1;
        SeatAnimTaskState r2 = new SeatAnimTaskState("LINK_SUC_ANIM", 1);
        LINK_SUC_ANIM = r2;
        SeatAnimTaskState r3 = new SeatAnimTaskState("DYNAMIC_EMOJI", 2);
        DYNAMIC_EMOJI = r3;
        SeatAnimTaskState r4 = new SeatAnimTaskState("KTV_SINGER_ANIMA", 3);
        KTV_SINGER_ANIMA = r4;
        SeatAnimTaskState r5 = new SeatAnimTaskState("GUEST_BATTLE_ANIM", 4);
        GUEST_BATTLE_ANIM = r5;
        a = new SeatAnimTaskState[]{r1, r2, r3, r4, r5};
    }

    public static SeatAnimTaskState valueOf(String r1) {
        return (SeatAnimTaskState) r27.a.a(SeatAnimTaskState.class, r1);
    }

    public static SeatAnimTaskState[] values() {
        return (SeatAnimTaskState[]) a.clone();
    }

    public SeatAnimTaskState(String r1, int r2) {
        super(r1, r2);
    }
}
