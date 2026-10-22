package com.larus.dora.impl.resource;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/resource/DoraDrawableDensity;", "", "densityDpi", "", "<init>", "(Ljava/lang/String;ILjava/lang/Integer;)V", "getDensityDpi$impl_mainlandRelease", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "NONE", "MDPI", "XXHDPI", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraDrawableDensity extends Enum<DoraDrawableDensity> {
    public static final DoraDrawableDensity MDPI = null;
    public static final DoraDrawableDensity NONE = null;
    public static final DoraDrawableDensity XXHDPI = null;
    public static final /* synthetic */ DoraDrawableDensity[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final Integer densityDpi;

    public static EnumEntries<DoraDrawableDensity> getEntries() {
        return b;
    }

    static {
        DoraDrawableDensity r0 = new DoraDrawableDensity("NONE", 0, null);
        NONE = r0;
        DoraDrawableDensity r1 = new DoraDrawableDensity("MDPI", 1, 160);
        MDPI = r1;
        DoraDrawableDensity r2 = new DoraDrawableDensity("XXHDPI", 2, 480);
        XXHDPI = r2;
        DoraDrawableDensity[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static DoraDrawableDensity[] values() {
        return (DoraDrawableDensity[]) a.clone();
    }

    public final Integer getDensityDpi$impl_mainlandRelease() {
        return this.densityDpi;
    }

    public static DoraDrawableDensity valueOf(String r1) {
        return (DoraDrawableDensity) a.a(DoraDrawableDensity.class, r1);
    }

    public DoraDrawableDensity(String r1, int r2, Integer r3) {
        super(r1, r2);
        this.densityDpi = r3;
    }
}
