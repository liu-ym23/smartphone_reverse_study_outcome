package com.larus.platform.model.preview;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/platform/model/preview/MediaEntry;", "", "<init>", "(Ljava/lang/String;I)V", "MAIN_INPUT", "ATTACHMENT_PANEL", "CAMERA_ALBUM", "PREVIEW_PLUS", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum MediaEntry extends Enum<MediaEntry> {
    public static final MediaEntry ATTACHMENT_PANEL = null;
    public static final MediaEntry CAMERA_ALBUM = null;
    public static final MediaEntry MAIN_INPUT = null;
    public static final MediaEntry PREVIEW_PLUS = null;
    public static final /* synthetic */ MediaEntry[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MediaEntry> getEntries() {
        return b;
    }

    static {
        MediaEntry r0 = new MediaEntry("MAIN_INPUT", 0);
        MAIN_INPUT = r0;
        MediaEntry r1 = new MediaEntry("ATTACHMENT_PANEL", 1);
        ATTACHMENT_PANEL = r1;
        MediaEntry r3 = new MediaEntry("CAMERA_ALBUM", 2);
        CAMERA_ALBUM = r3;
        MediaEntry r5 = new MediaEntry("PREVIEW_PLUS", 3);
        PREVIEW_PLUS = r5;
        MediaEntry[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static MediaEntry[] values() {
        return (MediaEntry[]) a.clone();
    }

    public static MediaEntry valueOf(String r1) {
        return (MediaEntry) a.a(MediaEntry.class, r1);
    }

    public MediaEntry(String r1, int r2) {
        super(r1, r2);
    }
}
