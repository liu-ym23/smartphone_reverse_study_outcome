package com.larus.platform.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/platform/api/DriveFileSelectScene;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNKNOWN", "ATTACHMENT_PANEL", "CHAT_SELECTOR", "INPUT_UPLOAD", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum DriveFileSelectScene extends Enum<DriveFileSelectScene> {
    public static final DriveFileSelectScene ATTACHMENT_PANEL = null;
    public static final DriveFileSelectScene CHAT_SELECTOR = null;
    public static final a Companion = null;
    public static final DriveFileSelectScene INPUT_UPLOAD = null;
    public static final DriveFileSelectScene UNKNOWN = null;
    public static final /* synthetic */ DriveFileSelectScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<DriveFileSelectScene> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.platform.api.DriveFileSelectScene$a] */
    static {
        DriveFileSelectScene r0 = new DriveFileSelectScene("UNKNOWN", 0, "unknown");
        UNKNOWN = r0;
        DriveFileSelectScene r1 = new DriveFileSelectScene("ATTACHMENT_PANEL", 1, "attachment_panel");
        ATTACHMENT_PANEL = r1;
        DriveFileSelectScene r3 = new DriveFileSelectScene("CHAT_SELECTOR", 2, "chat_selector");
        CHAT_SELECTOR = r3;
        DriveFileSelectScene r5 = new DriveFileSelectScene("INPUT_UPLOAD", 3, "input_upload");
        INPUT_UPLOAD = r5;
        DriveFileSelectScene[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
    }

    public static DriveFileSelectScene[] values() {
        return (DriveFileSelectScene[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static DriveFileSelectScene valueOf(String r1) {
        return (DriveFileSelectScene) r27.a.a(DriveFileSelectScene.class, r1);
    }

    public DriveFileSelectScene(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
