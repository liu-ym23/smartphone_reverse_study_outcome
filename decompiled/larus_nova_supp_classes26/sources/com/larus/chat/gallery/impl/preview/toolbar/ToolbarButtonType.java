package com.larus.chat.gallery.impl.preview.toolbar;

import com.larus.bmhome.share.panel.ShareChannel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lcom/larus/chat/gallery/impl/preview/toolbar/ToolbarButtonType;", "", "key", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "SHARE", "DOWNLOAD", "MARK", "CROP", "PUBLISH", "SET_PRIVATE", "VIEW_SOURCE", "DELETE", "RENAME", "MOVE", "MORE", "WATERMARK", "SELECT", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ToolbarButtonType extends Enum<ToolbarButtonType> {
    public static final ToolbarButtonType CROP = null;
    public static final a Companion = null;
    public static final ToolbarButtonType DELETE = null;
    public static final ToolbarButtonType DOWNLOAD = null;
    public static final ToolbarButtonType MARK = null;
    public static final ToolbarButtonType MORE = null;
    public static final ToolbarButtonType MOVE = null;
    public static final ToolbarButtonType PUBLISH = null;
    public static final ToolbarButtonType RENAME = null;
    public static final ToolbarButtonType SELECT = null;
    public static final ToolbarButtonType SET_PRIVATE = null;
    public static final ToolbarButtonType SHARE = null;
    public static final ToolbarButtonType VIEW_SOURCE = null;
    public static final ToolbarButtonType WATERMARK = null;
    public static final /* synthetic */ ToolbarButtonType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String key;

    public static EnumEntries<ToolbarButtonType> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [com.larus.chat.gallery.impl.preview.toolbar.ToolbarButtonType$a] */
    static {
        ToolbarButtonType r0 = new ToolbarButtonType("SHARE", 0, ShareChannel.SHARE);
        SHARE = r0;
        ToolbarButtonType r1 = new ToolbarButtonType("DOWNLOAD", 1, "download");
        DOWNLOAD = r1;
        ToolbarButtonType r3 = new ToolbarButtonType("MARK", 2, "mark");
        MARK = r3;
        ToolbarButtonType r5 = new ToolbarButtonType("CROP", 3, "crop");
        CROP = r5;
        ToolbarButtonType r7 = new ToolbarButtonType("PUBLISH", 4, ShareChannel.PUBLISH);
        PUBLISH = r7;
        ToolbarButtonType r9 = new ToolbarButtonType("SET_PRIVATE", 5, ShareChannel.SET_PRIVATE);
        SET_PRIVATE = r9;
        ToolbarButtonType r11 = new ToolbarButtonType("VIEW_SOURCE", 6, "view_source");
        VIEW_SOURCE = r11;
        ToolbarButtonType r13 = new ToolbarButtonType("DELETE", 7, ShareChannel.DELETE);
        DELETE = r13;
        ToolbarButtonType r12 = new ToolbarButtonType("RENAME", 8, "rename");
        RENAME = r12;
        ToolbarButtonType r10 = new ToolbarButtonType("MOVE", 9, "move");
        MOVE = r10;
        ToolbarButtonType r8 = new ToolbarButtonType("MORE", 10, ShareChannel.MORE);
        MORE = r8;
        ToolbarButtonType r6 = new ToolbarButtonType("WATERMARK", 11, "watermark");
        WATERMARK = r6;
        ToolbarButtonType r4 = new ToolbarButtonType("SELECT", 12, "select");
        SELECT = r4;
        ToolbarButtonType[] r2 = {r0, r1, r3, r5, r7, r9, r11, r13, r12, r10, r8, r6, r4};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
        Companion = new a();
    }

    public static ToolbarButtonType[] values() {
        return (ToolbarButtonType[]) a.clone();
    }

    public final String getKey() {
        return this.key;
    }

    public static ToolbarButtonType valueOf(String r1) {
        return (ToolbarButtonType) r27.a.a(ToolbarButtonType.class, r1);
    }

    public ToolbarButtonType(String r1, int r2, String r3) {
        super(r1, r2);
        this.key = r3;
    }
}
