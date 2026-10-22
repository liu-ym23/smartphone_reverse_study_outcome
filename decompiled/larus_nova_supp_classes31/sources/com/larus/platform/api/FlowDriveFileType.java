package com.larus.platform.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0000j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\f"}, d2 = {"Lcom/larus/platform/api/FlowDriveFileType;", "", "<init>", "(Ljava/lang/String;I)V", "FILE", "IMAGE", "VIDEO", "AUDIO", "NON_FILE", "isMediaType", "", "toMixCategory", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum FlowDriveFileType extends Enum<FlowDriveFileType> {
    public static final FlowDriveFileType AUDIO = null;
    public static final FlowDriveFileType FILE = null;
    public static final FlowDriveFileType IMAGE = null;
    public static final FlowDriveFileType NON_FILE = null;
    public static final FlowDriveFileType VIDEO = null;
    public static final /* synthetic */ FlowDriveFileType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<FlowDriveFileType> getEntries() {
        return b;
    }

    static {
        FlowDriveFileType r0 = new FlowDriveFileType("FILE", 0);
        FILE = r0;
        FlowDriveFileType r1 = new FlowDriveFileType("IMAGE", 1);
        IMAGE = r1;
        FlowDriveFileType r3 = new FlowDriveFileType("VIDEO", 2);
        VIDEO = r3;
        FlowDriveFileType r5 = new FlowDriveFileType("AUDIO", 3);
        AUDIO = r5;
        FlowDriveFileType r7 = new FlowDriveFileType("NON_FILE", 4);
        NON_FILE = r7;
        FlowDriveFileType[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static FlowDriveFileType[] values() {
        return (FlowDriveFileType[]) a.clone();
    }

    public final boolean isMediaType() {
        if (this != IMAGE) goto L5;
    L8:
        return true;
    L5:
        if (this == VIDEO) goto L8;
        return false;
    }

    public final FlowDriveFileType toMixCategory() {
        if (isMediaType() == false) goto L6;
        return IMAGE;
    L6:
        return FILE;
    }

    public static FlowDriveFileType valueOf(String r1) {
        return (FlowDriveFileType) r27.a.a(FlowDriveFileType.class, r1);
    }

    public FlowDriveFileType(String r1, int r2) {
        super(r1, r2);
    }
}
