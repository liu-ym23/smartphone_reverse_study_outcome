package com.bytedance.android.anniex.solutions.card;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/anniex/solutions/card/AirActionConstant$AirSolutionLifecycle", "", "Lcom/bytedance/android/anniex/solutions/card/AirActionConstant$AirSolutionLifecycle;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum AirActionConstant$AirSolutionLifecycle extends Enum<AirActionConstant$AirSolutionLifecycle> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AirActionConstant$AirSolutionLifecycle f3459a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AirActionConstant$AirSolutionLifecycle f3460b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AirActionConstant$AirSolutionLifecycle f3461c = null;
    public static final /* synthetic */ AirActionConstant$AirSolutionLifecycle[] d = null;

    static {
        AirActionConstant$AirSolutionLifecycle r5 = new AirActionConstant$AirSolutionLifecycle("OnShow", 0);
        f3459a = r5;
        AirActionConstant$AirSolutionLifecycle r10 = new AirActionConstant$AirSolutionLifecycle("OnHide", 1);
        f3460b = r10;
        AirActionConstant$AirSolutionLifecycle r11 = new AirActionConstant$AirSolutionLifecycle("OnViewLoad", 2);
        f3461c = r11;
        d = new AirActionConstant$AirSolutionLifecycle[]{r5, r10, r11};
    }

    public AirActionConstant$AirSolutionLifecycle(String r5, int r10) {
        super(r5, r10);
    }

    public static AirActionConstant$AirSolutionLifecycle valueOf(String r5) {
        return (AirActionConstant$AirSolutionLifecycle) Enum.valueOf(AirActionConstant$AirSolutionLifecycle.class, r5);
    }

    public static AirActionConstant$AirSolutionLifecycle[] values() {
        return (AirActionConstant$AirSolutionLifecycle[]) d.clone();
    }
}
