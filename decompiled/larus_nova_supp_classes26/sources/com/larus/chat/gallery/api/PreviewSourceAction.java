package com.larus.chat.gallery.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/chat/gallery/api/PreviewSourceAction;", "", "<init>", "(Ljava/lang/String;I)V", "SHARE", "DOWNLOAD", "RENAME", "MOVE", "DELETE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PreviewSourceAction extends Enum<PreviewSourceAction> {
    public static final PreviewSourceAction DELETE = null;
    public static final PreviewSourceAction DOWNLOAD = null;
    public static final PreviewSourceAction MOVE = null;
    public static final PreviewSourceAction RENAME = null;
    public static final PreviewSourceAction SHARE = null;
    public static final /* synthetic */ PreviewSourceAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PreviewSourceAction> getEntries() {
        return b;
    }

    static {
        PreviewSourceAction r0 = new PreviewSourceAction("SHARE", 0);
        SHARE = r0;
        PreviewSourceAction r1 = new PreviewSourceAction("DOWNLOAD", 1);
        DOWNLOAD = r1;
        PreviewSourceAction r3 = new PreviewSourceAction("RENAME", 2);
        RENAME = r3;
        PreviewSourceAction r5 = new PreviewSourceAction("MOVE", 3);
        MOVE = r5;
        PreviewSourceAction r7 = new PreviewSourceAction("DELETE", 4);
        DELETE = r7;
        PreviewSourceAction[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static PreviewSourceAction[] values() {
        return (PreviewSourceAction[]) a.clone();
    }

    public static PreviewSourceAction valueOf(String r1) {
        return (PreviewSourceAction) r27.a.a(PreviewSourceAction.class, r1);
    }

    public PreviewSourceAction(String r1, int r2) {
        super(r1, r2);
    }
}
