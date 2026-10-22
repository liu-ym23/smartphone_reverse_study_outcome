package com.bytedance.android.monitorV2.event;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/monitorV2/event/HybridEvent$EventPhase", "", "Lcom/bytedance/android/monitorV2/event/HybridEvent$EventPhase;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum HybridEvent$EventPhase extends Enum<HybridEvent$EventPhase> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HybridEvent$EventPhase f3537a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HybridEvent$EventPhase f3538b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HybridEvent$EventPhase f3539c = null;
    public static final HybridEvent$EventPhase d = null;
    public static final HybridEvent$EventPhase e = null;
    public static final /* synthetic */ HybridEvent$EventPhase[] f = null;

    static {
        HybridEvent$EventPhase r5 = new HybridEvent$EventPhase("EVENT_CREATE", 0);
        f3537a = r5;
        HybridEvent$EventPhase r10 = new HybridEvent$EventPhase("EVENT_TERMINATED", 1);
        f3538b = r10;
        HybridEvent$EventPhase r11 = new HybridEvent$EventPhase("SAMPLE_THROW", 2);
        f3539c = r11;
        HybridEvent$EventPhase r12 = new HybridEvent$EventPhase("EVENT_UPLOAD", 3);
        d = r12;
        HybridEvent$EventPhase r13 = new HybridEvent$EventPhase("EVENT_UPDATED", 4);
        e = r13;
        f = new HybridEvent$EventPhase[]{r5, r10, r11, r12, r13};
    }

    public HybridEvent$EventPhase(String r5, int r10) {
        super(r5, r10);
    }

    public static HybridEvent$EventPhase valueOf(String r5) {
        return (HybridEvent$EventPhase) Enum.valueOf(HybridEvent$EventPhase.class, r5);
    }

    public static HybridEvent$EventPhase[] values() {
        return (HybridEvent$EventPhase[]) f.clone();
    }
}
