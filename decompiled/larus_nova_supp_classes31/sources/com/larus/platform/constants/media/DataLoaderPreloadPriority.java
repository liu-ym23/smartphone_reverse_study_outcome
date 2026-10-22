package com.larus.platform.constants.media;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/platform/constants/media/DataLoaderPreloadPriority;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "IDLE", "HIGH", "HIGHEST", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum DataLoaderPreloadPriority extends Enum<DataLoaderPreloadPriority> {
    public static final DataLoaderPreloadPriority DEFAULT = null;
    public static final DataLoaderPreloadPriority HIGH = null;
    public static final DataLoaderPreloadPriority HIGHEST = null;
    public static final DataLoaderPreloadPriority IDLE = null;
    public static final /* synthetic */ DataLoaderPreloadPriority[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<DataLoaderPreloadPriority> getEntries() {
        return b;
    }

    static {
        DataLoaderPreloadPriority r0 = new DataLoaderPreloadPriority("DEFAULT", 0, 0);
        DEFAULT = r0;
        DataLoaderPreloadPriority r1 = new DataLoaderPreloadPriority("IDLE", 1, 10);
        IDLE = r1;
        DataLoaderPreloadPriority r3 = new DataLoaderPreloadPriority("HIGH", 2, 100);
        HIGH = r3;
        DataLoaderPreloadPriority r4 = new DataLoaderPreloadPriority("HIGHEST", 3, 10000);
        HIGHEST = r4;
        DataLoaderPreloadPriority[] r6 = {r0, r1, r3, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static DataLoaderPreloadPriority[] values() {
        return (DataLoaderPreloadPriority[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DataLoaderPreloadPriority valueOf(String r1) {
        return (DataLoaderPreloadPriority) a.a(DataLoaderPreloadPriority.class, r1);
    }

    public DataLoaderPreloadPriority(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
