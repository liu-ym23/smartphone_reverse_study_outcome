package com.larus.platform.model.album;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/platform/model/album/CreationReferenceAlbumViolation;", "", "<init>", "(Ljava/lang/String;I)V", "UNSUPPORTED_TYPE", "METADATA_UNAVAILABLE", "TYPE_COUNT", "MIXED_COUNT", "SINGLE_DURATION", "TOTAL_DURATION", "MIXED_TOTAL_DURATION", "FILE_SIZE", "RESOLUTION", "RATIO", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum CreationReferenceAlbumViolation extends Enum<CreationReferenceAlbumViolation> {
    public static final CreationReferenceAlbumViolation FILE_SIZE = null;
    public static final CreationReferenceAlbumViolation METADATA_UNAVAILABLE = null;
    public static final CreationReferenceAlbumViolation MIXED_COUNT = null;
    public static final CreationReferenceAlbumViolation MIXED_TOTAL_DURATION = null;
    public static final CreationReferenceAlbumViolation RATIO = null;
    public static final CreationReferenceAlbumViolation RESOLUTION = null;
    public static final CreationReferenceAlbumViolation SINGLE_DURATION = null;
    public static final CreationReferenceAlbumViolation TOTAL_DURATION = null;
    public static final CreationReferenceAlbumViolation TYPE_COUNT = null;
    public static final CreationReferenceAlbumViolation UNSUPPORTED_TYPE = null;
    public static final /* synthetic */ CreationReferenceAlbumViolation[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CreationReferenceAlbumViolation> getEntries() {
        return b;
    }

    static {
        CreationReferenceAlbumViolation r0 = new CreationReferenceAlbumViolation("UNSUPPORTED_TYPE", 0);
        UNSUPPORTED_TYPE = r0;
        CreationReferenceAlbumViolation r1 = new CreationReferenceAlbumViolation("METADATA_UNAVAILABLE", 1);
        METADATA_UNAVAILABLE = r1;
        CreationReferenceAlbumViolation r3 = new CreationReferenceAlbumViolation("TYPE_COUNT", 2);
        TYPE_COUNT = r3;
        CreationReferenceAlbumViolation r5 = new CreationReferenceAlbumViolation("MIXED_COUNT", 3);
        MIXED_COUNT = r5;
        CreationReferenceAlbumViolation r7 = new CreationReferenceAlbumViolation("SINGLE_DURATION", 4);
        SINGLE_DURATION = r7;
        CreationReferenceAlbumViolation r9 = new CreationReferenceAlbumViolation("TOTAL_DURATION", 5);
        TOTAL_DURATION = r9;
        CreationReferenceAlbumViolation r11 = new CreationReferenceAlbumViolation("MIXED_TOTAL_DURATION", 6);
        MIXED_TOTAL_DURATION = r11;
        CreationReferenceAlbumViolation r13 = new CreationReferenceAlbumViolation("FILE_SIZE", 7);
        FILE_SIZE = r13;
        CreationReferenceAlbumViolation r15 = new CreationReferenceAlbumViolation("RESOLUTION", 8);
        RESOLUTION = r15;
        CreationReferenceAlbumViolation r14 = new CreationReferenceAlbumViolation("RATIO", 9);
        RATIO = r14;
        CreationReferenceAlbumViolation[] r12 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static CreationReferenceAlbumViolation[] values() {
        return (CreationReferenceAlbumViolation[]) a.clone();
    }

    public static CreationReferenceAlbumViolation valueOf(String r1) {
        return (CreationReferenceAlbumViolation) a.a(CreationReferenceAlbumViolation.class, r1);
    }

    public CreationReferenceAlbumViolation(String r1, int r2) {
        super(r1, r2);
    }
}
