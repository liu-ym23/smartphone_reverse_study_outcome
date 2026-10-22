package org.ehcache.config.units;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.ehcache.config.j;

/* JADX INFO: loaded from: classes7.dex */
public abstract enum EntryUnit extends Enum<EntryUnit> implements j {
    private static final /* synthetic */ EntryUnit[] $VALUES = null;
    public static final EntryUnit ENTRIES = null;

    static {
        final String r1 = "ENTRIES";
        final int r2 = 0;
        EntryUnit r0 = new AnonymousClass1(r1, r2);
        ENTRIES = r0;
        $VALUES = new EntryUnit[]{r0};
    }

    private EntryUnit(String r1, int r2) {
        super(r1, r2);
    }

    /* synthetic */ EntryUnit(String r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    public static EntryUnit valueOf(String r2) {
        return (EntryUnit) ZeusTransformUtils.preCheckCast(Enum.valueOf(EntryUnit.class, r2), EntryUnit.class, "com.obric.memorydata.plugin");
    }

    public static EntryUnit[] values() {
        return (EntryUnit[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EntryUnit[].class, "com.obric.memorydata.plugin");
    }
}
