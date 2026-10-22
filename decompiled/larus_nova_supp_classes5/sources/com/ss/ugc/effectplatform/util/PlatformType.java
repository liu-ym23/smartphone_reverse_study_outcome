package com.ss.ugc.effectplatform.util;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/ugc/effectplatform/util/PlatformType;", "", "ANDROID", "IOS", "PC", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final enum PlatformType extends Enum<PlatformType> {
    public static final PlatformType ANDROID = null;
    public static final PlatformType IOS = null;
    public static final PlatformType PC = null;
    public static final /* synthetic */ PlatformType[] a = null;

    static {
        PlatformType r1 = new PlatformType("ANDROID", 0);
        ANDROID = r1;
        PlatformType r2 = new PlatformType("IOS", 1);
        IOS = r2;
        PlatformType r3 = new PlatformType("PC", 2);
        PC = r3;
        a = new PlatformType[]{r1, r2, r3};
    }

    public static PlatformType valueOf(String r1) {
        return (PlatformType) r27.a.a(PlatformType.class, r1);
    }

    public static PlatformType[] values() {
        return (PlatformType[]) a.clone();
    }

    public PlatformType(String r1, int r2) {
        super(r1, r2);
    }
}
