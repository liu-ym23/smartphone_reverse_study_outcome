package com.larus.platform.model.preview;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/platform/model/preview/MediaEntryScene;", "", "<init>", "(Ljava/lang/String;I)V", "ALBUM", "ATTACHMENT_PANEL", "CAMERA_RESULT", "MESSAGE", "SEARCH", "PRIVATE_ALBUM", "CLOUD_DRIVE", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum MediaEntryScene extends Enum<MediaEntryScene> {
    public static final MediaEntryScene ALBUM = null;
    public static final MediaEntryScene ATTACHMENT_PANEL = null;
    public static final MediaEntryScene CAMERA_RESULT = null;
    public static final MediaEntryScene CLOUD_DRIVE = null;
    public static final MediaEntryScene MESSAGE = null;
    public static final MediaEntryScene PRIVATE_ALBUM = null;
    public static final MediaEntryScene SEARCH = null;
    public static final /* synthetic */ MediaEntryScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MediaEntryScene> getEntries() {
        return b;
    }

    static {
        MediaEntryScene r0 = new MediaEntryScene("ALBUM", 0);
        ALBUM = r0;
        MediaEntryScene r1 = new MediaEntryScene("ATTACHMENT_PANEL", 1);
        ATTACHMENT_PANEL = r1;
        MediaEntryScene r3 = new MediaEntryScene("CAMERA_RESULT", 2);
        CAMERA_RESULT = r3;
        MediaEntryScene r5 = new MediaEntryScene("MESSAGE", 3);
        MESSAGE = r5;
        MediaEntryScene r7 = new MediaEntryScene("SEARCH", 4);
        SEARCH = r7;
        MediaEntryScene r9 = new MediaEntryScene("PRIVATE_ALBUM", 5);
        PRIVATE_ALBUM = r9;
        MediaEntryScene r11 = new MediaEntryScene("CLOUD_DRIVE", 6);
        CLOUD_DRIVE = r11;
        MediaEntryScene[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static MediaEntryScene[] values() {
        return (MediaEntryScene[]) a.clone();
    }

    public static MediaEntryScene valueOf(String r1) {
        return (MediaEntryScene) a.a(MediaEntryScene.class, r1);
    }

    public MediaEntryScene(String r1, int r2) {
        super(r1, r2);
    }
}
