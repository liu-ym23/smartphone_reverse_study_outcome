package com.bytedance.android.anniex.solutions.card;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/bytedance/android/anniex/solutions/card/AirActionConstant$AirSolutionLifecycle", "", "Lcom/bytedance/android/anniex/solutions/card/AirActionConstant$AirSolutionLifecycle;", "OnShow", "OnHide", "OnViewLoad", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AirActionConstant$AirSolutionLifecycle extends Enum<AirActionConstant$AirSolutionLifecycle> {
    public static final AirActionConstant$AirSolutionLifecycle OnHide = null;
    public static final AirActionConstant$AirSolutionLifecycle OnShow = null;
    public static final AirActionConstant$AirSolutionLifecycle OnViewLoad = null;
    public static final /* synthetic */ AirActionConstant$AirSolutionLifecycle[] a = null;

    public static AirActionConstant$AirSolutionLifecycle valueOf(String r1) {
        return (AirActionConstant$AirSolutionLifecycle) a.a(AirActionConstant$AirSolutionLifecycle.class, r1);
    }

    public static AirActionConstant$AirSolutionLifecycle[] values() {
        return (AirActionConstant$AirSolutionLifecycle[]) a.clone();
    }

    static {
        AirActionConstant$AirSolutionLifecycle r0 = new AirActionConstant$AirSolutionLifecycle("OnShow", 0);
        OnShow = r0;
        AirActionConstant$AirSolutionLifecycle r1 = new AirActionConstant$AirSolutionLifecycle("OnHide", 1);
        OnHide = r1;
        AirActionConstant$AirSolutionLifecycle r10 = new AirActionConstant$AirSolutionLifecycle("OnViewLoad", 2);
        OnViewLoad = r10;
        a = new AirActionConstant$AirSolutionLifecycle[]{r0, r1, r10};
    }

    public AirActionConstant$AirSolutionLifecycle(String r1, int r10) {
        super(r1, r10);
    }
}
