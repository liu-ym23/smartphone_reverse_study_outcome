package com.larus.chat.gallery.impl.preview.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/chat/gallery/impl/preview/data/SourceType;", "", "<init>", "(Ljava/lang/String;I)V", "USER_SEND", "BOT_RESP", "CREATION_CARD", "CREATION_RECORD", "ALBUM", "ATTACHMENT", "CAMERA_RESULT", "CLOUD_DRIVE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SourceType extends Enum<SourceType> {
    public static final SourceType ALBUM = null;
    public static final SourceType ATTACHMENT = null;
    public static final SourceType BOT_RESP = null;
    public static final SourceType CAMERA_RESULT = null;
    public static final SourceType CLOUD_DRIVE = null;
    public static final SourceType CREATION_CARD = null;
    public static final SourceType CREATION_RECORD = null;
    public static final SourceType USER_SEND = null;
    public static final /* synthetic */ SourceType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SourceType> getEntries() {
        return b;
    }

    static {
        SourceType r0 = new SourceType("USER_SEND", 0);
        USER_SEND = r0;
        SourceType r1 = new SourceType("BOT_RESP", 1);
        BOT_RESP = r1;
        SourceType r3 = new SourceType("CREATION_CARD", 2);
        CREATION_CARD = r3;
        SourceType r5 = new SourceType("CREATION_RECORD", 3);
        CREATION_RECORD = r5;
        SourceType r7 = new SourceType("ALBUM", 4);
        ALBUM = r7;
        SourceType r9 = new SourceType("ATTACHMENT", 5);
        ATTACHMENT = r9;
        SourceType r11 = new SourceType("CAMERA_RESULT", 6);
        CAMERA_RESULT = r11;
        SourceType r13 = new SourceType("CLOUD_DRIVE", 7);
        CLOUD_DRIVE = r13;
        SourceType[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static SourceType[] values() {
        return (SourceType[]) a.clone();
    }

    public static SourceType valueOf(String r1) {
        return (SourceType) a.a(SourceType.class, r1);
    }

    public SourceType(String r1, int r2) {
        super(r1, r2);
    }
}
