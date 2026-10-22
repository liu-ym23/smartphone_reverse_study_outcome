package com.larus.dora.impl.device.manage;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/impl/device/manage/DiaryDisplayMode;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "ENVIRONMENT_OFF", "NO_CONTENT", "NETWORK_ERROR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DiaryDisplayMode extends Enum<DiaryDisplayMode> {
    public static final DiaryDisplayMode ENVIRONMENT_OFF = null;
    public static final DiaryDisplayMode NETWORK_ERROR = null;
    public static final DiaryDisplayMode NORMAL = null;
    public static final DiaryDisplayMode NO_CONTENT = null;
    public static final /* synthetic */ DiaryDisplayMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DiaryDisplayMode> getEntries() {
        return b;
    }

    static {
        DiaryDisplayMode r0 = new DiaryDisplayMode("NORMAL", 0);
        NORMAL = r0;
        DiaryDisplayMode r1 = new DiaryDisplayMode("ENVIRONMENT_OFF", 1);
        ENVIRONMENT_OFF = r1;
        DiaryDisplayMode r3 = new DiaryDisplayMode("NO_CONTENT", 2);
        NO_CONTENT = r3;
        DiaryDisplayMode r5 = new DiaryDisplayMode("NETWORK_ERROR", 3);
        NETWORK_ERROR = r5;
        DiaryDisplayMode[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static DiaryDisplayMode[] values() {
        return (DiaryDisplayMode[]) a.clone();
    }

    public static DiaryDisplayMode valueOf(String r1) {
        return (DiaryDisplayMode) r27.a.a(DiaryDisplayMode.class, r1);
    }

    public DiaryDisplayMode(String r1, int r2) {
        super(r1, r2);
    }
}
