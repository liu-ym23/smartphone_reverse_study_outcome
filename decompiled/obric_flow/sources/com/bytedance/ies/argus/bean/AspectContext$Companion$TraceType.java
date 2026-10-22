package com.bytedance.ies.argus.bean;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ies/argus/bean/AspectContext$Companion$TraceType", "", "Lcom/bytedance/ies/argus/bean/AspectContext$Companion$TraceType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum AspectContext$Companion$TraceType extends Enum<AspectContext$Companion$TraceType> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AspectContext$Companion$TraceType f5110b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AspectContext$Companion$TraceType f5111c = null;
    public static final /* synthetic */ AspectContext$Companion$TraceType[] d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5112a;

    static {
        AspectContext$Companion$TraceType r5 = new AspectContext$Companion$TraceType("CALCULATE", 0, "cal");
        f5110b = r5;
        AspectContext$Companion$TraceType r10 = new AspectContext$Companion$TraceType("PLUGIN_VERIFY", 1, "plugin");
        AspectContext$Companion$TraceType r11 = new AspectContext$Companion$TraceType("INNER_ASPECT_VERIFY", 2, "inner_total");
        AspectContext$Companion$TraceType r12 = new AspectContext$Companion$TraceType("ASPECT_VERIFY", 3, "total");
        f5111c = r12;
        d = new AspectContext$Companion$TraceType[]{r5, r10, r11, r12, new AspectContext$Companion$TraceType("SERVICE_VERIFY", 4, NotificationCompat.CATEGORY_SERVICE)};
    }

    public AspectContext$Companion$TraceType(String r5, int r10, String r11) {
        super(r5, r10);
        this.f5112a = r11;
    }

    public static AspectContext$Companion$TraceType valueOf(String r5) {
        return (AspectContext$Companion$TraceType) Enum.valueOf(AspectContext$Companion$TraceType.class, r5);
    }

    public static AspectContext$Companion$TraceType[] values() {
        return (AspectContext$Companion$TraceType[]) d.clone();
    }
}
