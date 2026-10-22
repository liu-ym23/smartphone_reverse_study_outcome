package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ies/argus/bean/AspectContext$Companion$TraceStage", "", "Lcom/bytedance/ies/argus/bean/AspectContext$Companion$TraceStage;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum AspectContext$Companion$TraceStage extends Enum<AspectContext$Companion$TraceStage> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AspectContext$Companion$TraceStage f5107a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AspectContext$Companion$TraceStage f5108b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AspectContext$Companion$TraceStage[] f5109c = null;

    static {
        AspectContext$Companion$TraceStage r5 = new AspectContext$Companion$TraceStage("START", 0);
        f5107a = r5;
        AspectContext$Companion$TraceStage r10 = new AspectContext$Companion$TraceStage("END", 1);
        f5108b = r10;
        f5109c = new AspectContext$Companion$TraceStage[]{r5, r10};
    }

    public AspectContext$Companion$TraceStage(String r5, int r10) {
        super(r5, r10);
    }

    public static AspectContext$Companion$TraceStage valueOf(String r5) {
        return (AspectContext$Companion$TraceStage) Enum.valueOf(AspectContext$Companion$TraceStage.class, r5);
    }

    public static AspectContext$Companion$TraceStage[] values() {
        return (AspectContext$Companion$TraceStage[]) f5109c.clone();
    }
}
