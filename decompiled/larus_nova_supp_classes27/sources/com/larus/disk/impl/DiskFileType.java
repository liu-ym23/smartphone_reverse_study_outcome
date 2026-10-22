package com.larus.disk.impl;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/disk/impl/DiskFileType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "AUDIO", "DOCUMENT", "ARCHIVE", "DATABASE", "KV", "LOG", "OFFLINE_RESOURCE", FlowDoraWifiScene.OTHER, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DiskFileType extends Enum<DiskFileType> {
    public static final DiskFileType ARCHIVE = null;
    public static final DiskFileType AUDIO = null;
    public static final DiskFileType DATABASE = null;
    public static final DiskFileType DOCUMENT = null;
    public static final DiskFileType IMAGE = null;
    public static final DiskFileType KV = null;
    public static final DiskFileType LOG = null;
    public static final DiskFileType OFFLINE_RESOURCE = null;
    public static final DiskFileType OTHER = null;
    public static final DiskFileType VIDEO = null;
    public static final /* synthetic */ DiskFileType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DiskFileType> getEntries() {
        return b;
    }

    static {
        DiskFileType r0 = new DiskFileType("IMAGE", 0);
        IMAGE = r0;
        DiskFileType r1 = new DiskFileType("VIDEO", 1);
        VIDEO = r1;
        DiskFileType r3 = new DiskFileType("AUDIO", 2);
        AUDIO = r3;
        DiskFileType r5 = new DiskFileType("DOCUMENT", 3);
        DOCUMENT = r5;
        DiskFileType r7 = new DiskFileType("ARCHIVE", 4);
        ARCHIVE = r7;
        DiskFileType r9 = new DiskFileType("DATABASE", 5);
        DATABASE = r9;
        DiskFileType r11 = new DiskFileType("KV", 6);
        KV = r11;
        DiskFileType r13 = new DiskFileType("LOG", 7);
        LOG = r13;
        DiskFileType r15 = new DiskFileType("OFFLINE_RESOURCE", 8);
        OFFLINE_RESOURCE = r15;
        DiskFileType r14 = new DiskFileType(FlowDoraWifiScene.OTHER, 9);
        OTHER = r14;
        DiskFileType[] r12 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static DiskFileType[] values() {
        return (DiskFileType[]) a.clone();
    }

    public static DiskFileType valueOf(String r1) {
        return (DiskFileType) r27.a.a(DiskFileType.class, r1);
    }

    public DiskFileType(String r1, int r2) {
        super(r1, r2);
    }
}
