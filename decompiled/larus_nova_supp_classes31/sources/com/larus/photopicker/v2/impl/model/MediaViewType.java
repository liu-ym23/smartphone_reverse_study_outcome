package com.larus.photopicker.v2.impl.model;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/photopicker/v2/impl/model/MediaViewType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "ITEM", "HEADER", "FOOTER", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum MediaViewType extends Enum<MediaViewType> {
    public static final MediaViewType FOOTER = null;
    public static final MediaViewType HEADER = null;
    public static final MediaViewType ITEM = null;
    public static final /* synthetic */ MediaViewType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static EnumEntries<MediaViewType> getEntries() {
        return b;
    }

    static {
        MediaViewType r0 = new MediaViewType("ITEM", 0, 0);
        ITEM = r0;
        MediaViewType r1 = new MediaViewType("HEADER", 1, 1001);
        HEADER = r1;
        MediaViewType r3 = new MediaViewType("FOOTER", 2, 1002);
        FOOTER = r3;
        MediaViewType[] r4 = {r0, r1, r3};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static MediaViewType[] values() {
        return (MediaViewType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static MediaViewType valueOf(String r1) {
        return (MediaViewType) a.a(MediaViewType.class, r1);
    }

    public MediaViewType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
