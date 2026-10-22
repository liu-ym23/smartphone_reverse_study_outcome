package com.ss.android.lark.officewebview.webview_api.platform.sandwich;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officewebview/webview_api/platform/sandwich/SandwichRectCallType;", "", "<init>", "(Ljava/lang/String;I)V", "Show", "UpdateBounds", "UpdateScroll", "webview_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum SandwichRectCallType extends Enum<SandwichRectCallType> {
    public static final SandwichRectCallType Show = null;
    public static final SandwichRectCallType UpdateBounds = null;
    public static final SandwichRectCallType UpdateScroll = null;
    public static final /* synthetic */ SandwichRectCallType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SandwichRectCallType> getEntries() {
        return b;
    }

    static {
        SandwichRectCallType r0 = new SandwichRectCallType("Show", 0);
        Show = r0;
        SandwichRectCallType r1 = new SandwichRectCallType("UpdateBounds", 1);
        UpdateBounds = r1;
        SandwichRectCallType r3 = new SandwichRectCallType("UpdateScroll", 2);
        UpdateScroll = r3;
        SandwichRectCallType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static SandwichRectCallType[] values() {
        return (SandwichRectCallType[]) a.clone();
    }

    public static SandwichRectCallType valueOf(String r1) {
        return (SandwichRectCallType) a.a(SandwichRectCallType.class, r1);
    }

    public SandwichRectCallType(String r1, int r2) {
        super(r1, r2);
    }
}
