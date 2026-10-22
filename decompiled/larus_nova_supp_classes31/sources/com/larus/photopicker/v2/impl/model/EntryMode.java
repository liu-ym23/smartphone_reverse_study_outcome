package com.larus.photopicker.v2.impl.model;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/photopicker/v2/impl/model/EntryMode;", "", "<init>", "(Ljava/lang/String;I)V", "BOTTOM", "NORMAL", "INIT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum EntryMode extends Enum<EntryMode> {
    public static final EntryMode BOTTOM = null;
    public static final EntryMode INIT = null;
    public static final EntryMode NORMAL = null;
    public static final /* synthetic */ EntryMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<EntryMode> getEntries() {
        return b;
    }

    static {
        EntryMode r0 = new EntryMode("BOTTOM", 0);
        BOTTOM = r0;
        EntryMode r1 = new EntryMode("NORMAL", 1);
        NORMAL = r1;
        EntryMode r3 = new EntryMode("INIT", 2);
        INIT = r3;
        EntryMode[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static EntryMode[] values() {
        return (EntryMode[]) a.clone();
    }

    public static EntryMode valueOf(String r1) {
        return (EntryMode) a.a(EntryMode.class, r1);
    }

    public EntryMode(String r1, int r2) {
        super(r1, r2);
    }
}
