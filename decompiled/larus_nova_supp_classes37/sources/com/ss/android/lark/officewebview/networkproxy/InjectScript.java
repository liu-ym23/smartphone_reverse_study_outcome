package com.ss.android.lark.officewebview.networkproxy;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officewebview/networkproxy/InjectScript;", "", "<init>", "(Ljava/lang/String;I)V", "HTTP_TRAFFIC", "WSS", "webview_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum InjectScript extends Enum<InjectScript> {
    public static final InjectScript HTTP_TRAFFIC = null;
    public static final InjectScript WSS = null;
    public static final /* synthetic */ InjectScript[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<InjectScript> getEntries() {
        return b;
    }

    static {
        InjectScript r0 = new InjectScript("HTTP_TRAFFIC", 0);
        HTTP_TRAFFIC = r0;
        InjectScript r1 = new InjectScript("WSS", 1);
        WSS = r1;
        InjectScript[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static InjectScript[] values() {
        return (InjectScript[]) a.clone();
    }

    public static InjectScript valueOf(String r1) {
        return (InjectScript) a.a(InjectScript.class, r1);
    }

    public InjectScript(String r1, int r2) {
        super(r1, r2);
    }
}
