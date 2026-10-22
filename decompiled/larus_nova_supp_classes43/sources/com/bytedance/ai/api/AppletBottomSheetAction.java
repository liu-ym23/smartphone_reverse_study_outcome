package com.bytedance.ai.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/api/AppletBottomSheetAction;", "", "<init>", "(Ljava/lang/String;I)V", "BUTTON_CLICK", "CANCEL", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletBottomSheetAction extends Enum<AppletBottomSheetAction> {
    public static final AppletBottomSheetAction BUTTON_CLICK = null;
    public static final AppletBottomSheetAction CANCEL = null;
    public static final /* synthetic */ AppletBottomSheetAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AppletBottomSheetAction> getEntries() {
        return b;
    }

    static {
        AppletBottomSheetAction r0 = new AppletBottomSheetAction("BUTTON_CLICK", 0);
        BUTTON_CLICK = r0;
        AppletBottomSheetAction r1 = new AppletBottomSheetAction("CANCEL", 1);
        CANCEL = r1;
        AppletBottomSheetAction[] r10 = {r0, r1};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static AppletBottomSheetAction[] values() {
        return (AppletBottomSheetAction[]) a.clone();
    }

    public static AppletBottomSheetAction valueOf(String r1) {
        return (AppletBottomSheetAction) r27.a.a(AppletBottomSheetAction.class, r1);
    }

    public AppletBottomSheetAction(String r1, int r10) {
        super(r1, r10);
    }
}
