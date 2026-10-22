package com.larus.platform.model.album;

import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/platform/model/album/CreationReferenceAlbumMediaType;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "AUDIO", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum CreationReferenceAlbumMediaType extends Enum<CreationReferenceAlbumMediaType> implements Serializable {
    public static final CreationReferenceAlbumMediaType AUDIO = null;
    public static final CreationReferenceAlbumMediaType IMAGE = null;
    public static final CreationReferenceAlbumMediaType VIDEO = null;
    public static final /* synthetic */ CreationReferenceAlbumMediaType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CreationReferenceAlbumMediaType> getEntries() {
        return b;
    }

    static {
        CreationReferenceAlbumMediaType r0 = new CreationReferenceAlbumMediaType("IMAGE", 0);
        IMAGE = r0;
        CreationReferenceAlbumMediaType r1 = new CreationReferenceAlbumMediaType("VIDEO", 1);
        VIDEO = r1;
        CreationReferenceAlbumMediaType r3 = new CreationReferenceAlbumMediaType("AUDIO", 2);
        AUDIO = r3;
        CreationReferenceAlbumMediaType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static CreationReferenceAlbumMediaType[] values() {
        return (CreationReferenceAlbumMediaType[]) a.clone();
    }

    public static CreationReferenceAlbumMediaType valueOf(String r1) {
        return (CreationReferenceAlbumMediaType) a.a(CreationReferenceAlbumMediaType.class, r1);
    }

    public CreationReferenceAlbumMediaType(String r1, int r2) {
        super(r1, r2);
    }
}
