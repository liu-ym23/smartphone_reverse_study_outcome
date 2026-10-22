package com.larus.chat.gallery.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/chat/gallery/api/PreviewScene;", "", "<init>", "(Ljava/lang/String;I)V", "MESSAGE", "SEARCH_IMAGE", "CREATION_CARD", "CREATION_RECORD", "ALBUM", "ATTACHMENT_PANEL", "CAMERA_RESULT", "CLOUD_DRIVE", "PRIVATE_ALBUM", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PreviewScene extends Enum<PreviewScene> {
    public static final PreviewScene ALBUM = null;
    public static final PreviewScene ATTACHMENT_PANEL = null;
    public static final PreviewScene CAMERA_RESULT = null;
    public static final PreviewScene CLOUD_DRIVE = null;
    public static final PreviewScene CREATION_CARD = null;
    public static final PreviewScene CREATION_RECORD = null;
    public static final PreviewScene MESSAGE = null;
    public static final PreviewScene PRIVATE_ALBUM = null;
    public static final PreviewScene SEARCH_IMAGE = null;
    public static final /* synthetic */ PreviewScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PreviewScene> getEntries() {
        return b;
    }

    static {
        PreviewScene r0 = new PreviewScene("MESSAGE", 0);
        MESSAGE = r0;
        PreviewScene r1 = new PreviewScene("SEARCH_IMAGE", 1);
        SEARCH_IMAGE = r1;
        PreviewScene r3 = new PreviewScene("CREATION_CARD", 2);
        CREATION_CARD = r3;
        PreviewScene r5 = new PreviewScene("CREATION_RECORD", 3);
        CREATION_RECORD = r5;
        PreviewScene r7 = new PreviewScene("ALBUM", 4);
        ALBUM = r7;
        PreviewScene r9 = new PreviewScene("ATTACHMENT_PANEL", 5);
        ATTACHMENT_PANEL = r9;
        PreviewScene r11 = new PreviewScene("CAMERA_RESULT", 6);
        CAMERA_RESULT = r11;
        PreviewScene r13 = new PreviewScene("CLOUD_DRIVE", 7);
        CLOUD_DRIVE = r13;
        PreviewScene r15 = new PreviewScene("PRIVATE_ALBUM", 8);
        PRIVATE_ALBUM = r15;
        PreviewScene[] r14 = {r0, r1, r3, r5, r7, r9, r11, r13, r15};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
    }

    public static PreviewScene[] values() {
        return (PreviewScene[]) a.clone();
    }

    public static PreviewScene valueOf(String r1) {
        return (PreviewScene) r27.a.a(PreviewScene.class, r1);
    }

    public PreviewScene(String r1, int r2) {
        super(r1, r2);
    }
}
