package com.larus.dora.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/api/DoraServerResourceSource;", "", "<init>", "(Ljava/lang/String;I)V", "APK", "LOCAL", "CLOUD", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraServerResourceSource extends Enum<DoraServerResourceSource> {
    public static final DoraServerResourceSource APK = null;
    public static final DoraServerResourceSource CLOUD = null;
    public static final DoraServerResourceSource LOCAL = null;
    public static final /* synthetic */ DoraServerResourceSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraServerResourceSource> getEntries() {
        return b;
    }

    static {
        DoraServerResourceSource r0 = new DoraServerResourceSource("APK", 0);
        APK = r0;
        DoraServerResourceSource r1 = new DoraServerResourceSource("LOCAL", 1);
        LOCAL = r1;
        DoraServerResourceSource r3 = new DoraServerResourceSource("CLOUD", 2);
        CLOUD = r3;
        DoraServerResourceSource[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static DoraServerResourceSource[] values() {
        return (DoraServerResourceSource[]) a.clone();
    }

    public static DoraServerResourceSource valueOf(String r1) {
        return (DoraServerResourceSource) a.a(DoraServerResourceSource.class, r1);
    }

    public DoraServerResourceSource(String r1, int r2) {
        super(r1, r2);
    }
}
