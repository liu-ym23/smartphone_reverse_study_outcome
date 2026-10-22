package com.larus.bmhome.chat.standarduikit.richmedia.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/richmedia/view/RichMediaItemAction;", "", "<init>", "(Ljava/lang/String;I)V", "DOWNLOAD", "SHARE", "IMAGE_EDIT", "VIDEO_EDIT", "CITE", "EXTEND", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RichMediaItemAction extends Enum<RichMediaItemAction> {
    public static final RichMediaItemAction CITE = null;
    public static final RichMediaItemAction DOWNLOAD = null;
    public static final RichMediaItemAction EXTEND = null;
    public static final RichMediaItemAction IMAGE_EDIT = null;
    public static final RichMediaItemAction SHARE = null;
    public static final RichMediaItemAction VIDEO_EDIT = null;
    public static final /* synthetic */ RichMediaItemAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<RichMediaItemAction> getEntries() {
        return b;
    }

    static {
        RichMediaItemAction r0 = new RichMediaItemAction("DOWNLOAD", 0);
        DOWNLOAD = r0;
        RichMediaItemAction r1 = new RichMediaItemAction("SHARE", 1);
        SHARE = r1;
        RichMediaItemAction r3 = new RichMediaItemAction("IMAGE_EDIT", 2);
        IMAGE_EDIT = r3;
        RichMediaItemAction r5 = new RichMediaItemAction("VIDEO_EDIT", 3);
        VIDEO_EDIT = r5;
        RichMediaItemAction r7 = new RichMediaItemAction("CITE", 4);
        CITE = r7;
        RichMediaItemAction r9 = new RichMediaItemAction("EXTEND", 5);
        EXTEND = r9;
        RichMediaItemAction[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static RichMediaItemAction[] values() {
        return (RichMediaItemAction[]) a.clone();
    }

    public static RichMediaItemAction valueOf(String r1) {
        return (RichMediaItemAction) a.a(RichMediaItemAction.class, r1);
    }

    public RichMediaItemAction(String r1, int r2) {
        super(r1, r2);
    }
}
