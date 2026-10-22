package com.ss.android.lark.officewebview.monitor.webview;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officewebview/monitor/webview/LarkWebViewMonitorParams$BIZ;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "DOC", "GADGET", "MAIL", "webview_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum LarkWebViewMonitorParams$BIZ extends Enum<LarkWebViewMonitorParams$BIZ> {
    public static final LarkWebViewMonitorParams$BIZ DEFAULT = null;
    public static final LarkWebViewMonitorParams$BIZ DOC = null;
    public static final LarkWebViewMonitorParams$BIZ GADGET = null;
    public static final LarkWebViewMonitorParams$BIZ MAIL = null;
    public static final /* synthetic */ LarkWebViewMonitorParams$BIZ[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<LarkWebViewMonitorParams$BIZ> getEntries() {
        return b;
    }

    static {
        LarkWebViewMonitorParams$BIZ r0 = new LarkWebViewMonitorParams$BIZ("DEFAULT", 0);
        DEFAULT = r0;
        LarkWebViewMonitorParams$BIZ r1 = new LarkWebViewMonitorParams$BIZ("DOC", 1);
        DOC = r1;
        LarkWebViewMonitorParams$BIZ r3 = new LarkWebViewMonitorParams$BIZ("GADGET", 2);
        GADGET = r3;
        LarkWebViewMonitorParams$BIZ r5 = new LarkWebViewMonitorParams$BIZ("MAIL", 3);
        MAIL = r5;
        LarkWebViewMonitorParams$BIZ[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static LarkWebViewMonitorParams$BIZ[] values() {
        return (LarkWebViewMonitorParams$BIZ[]) a.clone();
    }

    public static LarkWebViewMonitorParams$BIZ valueOf(String r1) {
        return (LarkWebViewMonitorParams$BIZ) a.a(LarkWebViewMonitorParams$BIZ.class, r1);
    }

    public LarkWebViewMonitorParams$BIZ(String r1, int r2) {
        super(r1, r2);
    }
}
