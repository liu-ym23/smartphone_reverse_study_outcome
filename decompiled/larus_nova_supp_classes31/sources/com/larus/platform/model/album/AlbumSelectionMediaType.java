package com.larus.platform.model.album;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/platform/model/album/AlbumSelectionMediaType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum AlbumSelectionMediaType extends Enum<AlbumSelectionMediaType> {
    public static final AlbumSelectionMediaType IMAGE = null;
    public static final AlbumSelectionMediaType VIDEO = null;
    public static final /* synthetic */ AlbumSelectionMediaType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AlbumSelectionMediaType> getEntries() {
        return b;
    }

    static {
        AlbumSelectionMediaType r0 = new AlbumSelectionMediaType("IMAGE", 0);
        IMAGE = r0;
        AlbumSelectionMediaType r1 = new AlbumSelectionMediaType("VIDEO", 1);
        VIDEO = r1;
        AlbumSelectionMediaType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static AlbumSelectionMediaType[] values() {
        return (AlbumSelectionMediaType[]) a.clone();
    }

    public static AlbumSelectionMediaType valueOf(String r1) {
        return (AlbumSelectionMediaType) a.a(AlbumSelectionMediaType.class, r1);
    }

    public AlbumSelectionMediaType(String r1, int r2) {
        super(r1, r2);
    }
}
