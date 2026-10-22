package com.larus.platform.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/platform/api/ExternalRouteLaunchMode;", "", "<init>", "(Ljava/lang/String;I)V", "COLD", "HOT", "WARM", "UNKNOWN", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum ExternalRouteLaunchMode extends Enum<ExternalRouteLaunchMode> {
    public static final ExternalRouteLaunchMode COLD = null;
    public static final ExternalRouteLaunchMode HOT = null;
    public static final ExternalRouteLaunchMode UNKNOWN = null;
    public static final ExternalRouteLaunchMode WARM = null;
    public static final /* synthetic */ ExternalRouteLaunchMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ExternalRouteLaunchMode> getEntries() {
        return b;
    }

    static {
        ExternalRouteLaunchMode r0 = new ExternalRouteLaunchMode("COLD", 0);
        COLD = r0;
        ExternalRouteLaunchMode r1 = new ExternalRouteLaunchMode("HOT", 1);
        HOT = r1;
        ExternalRouteLaunchMode r3 = new ExternalRouteLaunchMode("WARM", 2);
        WARM = r3;
        ExternalRouteLaunchMode r5 = new ExternalRouteLaunchMode("UNKNOWN", 3);
        UNKNOWN = r5;
        ExternalRouteLaunchMode[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static ExternalRouteLaunchMode[] values() {
        return (ExternalRouteLaunchMode[]) a.clone();
    }

    public static ExternalRouteLaunchMode valueOf(String r1) {
        return (ExternalRouteLaunchMode) r27.a.a(ExternalRouteLaunchMode.class, r1);
    }

    public ExternalRouteLaunchMode(String r1, int r2) {
        super(r1, r2);
    }
}
