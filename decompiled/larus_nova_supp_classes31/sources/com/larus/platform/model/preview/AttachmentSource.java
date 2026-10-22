package com.larus.platform.model.preview;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/platform/model/preview/AttachmentSource;", "", "<init>", "(Ljava/lang/String;I)V", "LOCAL_ALBUM", "CAMERA", "MESSAGE_REMOTE", "SEARCH", "PRIVATE_ALBUM", "CLOUD_DRIVE", "FILE", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum AttachmentSource extends Enum<AttachmentSource> {
    public static final AttachmentSource CAMERA = null;
    public static final AttachmentSource CLOUD_DRIVE = null;
    public static final AttachmentSource FILE = null;
    public static final AttachmentSource LOCAL_ALBUM = null;
    public static final AttachmentSource MESSAGE_REMOTE = null;
    public static final AttachmentSource PRIVATE_ALBUM = null;
    public static final AttachmentSource SEARCH = null;
    public static final /* synthetic */ AttachmentSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AttachmentSource> getEntries() {
        return b;
    }

    static {
        AttachmentSource r0 = new AttachmentSource("LOCAL_ALBUM", 0);
        LOCAL_ALBUM = r0;
        AttachmentSource r1 = new AttachmentSource("CAMERA", 1);
        CAMERA = r1;
        AttachmentSource r3 = new AttachmentSource("MESSAGE_REMOTE", 2);
        MESSAGE_REMOTE = r3;
        AttachmentSource r5 = new AttachmentSource("SEARCH", 3);
        SEARCH = r5;
        AttachmentSource r7 = new AttachmentSource("PRIVATE_ALBUM", 4);
        PRIVATE_ALBUM = r7;
        AttachmentSource r9 = new AttachmentSource("CLOUD_DRIVE", 5);
        CLOUD_DRIVE = r9;
        AttachmentSource r11 = new AttachmentSource("FILE", 6);
        FILE = r11;
        AttachmentSource[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static AttachmentSource[] values() {
        return (AttachmentSource[]) a.clone();
    }

    public static AttachmentSource valueOf(String r1) {
        return (AttachmentSource) a.a(AttachmentSource.class, r1);
    }

    public AttachmentSource(String r1, int r2) {
        super(r1, r2);
    }
}
