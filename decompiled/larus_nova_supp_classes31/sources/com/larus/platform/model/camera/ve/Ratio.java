package com.larus.platform.model.camera.ve;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/model/camera/ve/Ratio;", "", "<init>", "(Ljava/lang/String;I)V", "RATIO_3_4", "RATIO_9_16", "RATIO_FULL_SCREEN", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum Ratio extends Enum<Ratio> {
    public static final Ratio RATIO_3_4 = null;
    public static final Ratio RATIO_9_16 = null;
    public static final Ratio RATIO_FULL_SCREEN = null;
    public static final /* synthetic */ Ratio[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<Ratio> getEntries() {
        return b;
    }

    static {
        Ratio r0 = new Ratio("RATIO_3_4", 0);
        RATIO_3_4 = r0;
        Ratio r1 = new Ratio("RATIO_9_16", 1);
        RATIO_9_16 = r1;
        Ratio r3 = new Ratio("RATIO_FULL_SCREEN", 2);
        RATIO_FULL_SCREEN = r3;
        Ratio[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static Ratio[] values() {
        return (Ratio[]) a.clone();
    }

    public static Ratio valueOf(String r1) {
        return (Ratio) a.a(Ratio.class, r1);
    }

    public Ratio(String r1, int r2) {
        super(r1, r2);
    }
}
