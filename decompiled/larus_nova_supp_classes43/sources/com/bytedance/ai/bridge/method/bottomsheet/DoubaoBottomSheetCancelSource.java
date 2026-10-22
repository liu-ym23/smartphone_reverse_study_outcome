package com.bytedance.ai.bridge.method.bottomsheet;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/bridge/method/bottomsheet/DoubaoBottomSheetCancelSource;", "", "<init>", "(Ljava/lang/String;I)V", "MASK", "GESTURE", "HOST_UNAVAILABLE", "UNKNOWN", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoubaoBottomSheetCancelSource extends Enum<DoubaoBottomSheetCancelSource> {
    public static final DoubaoBottomSheetCancelSource GESTURE = null;
    public static final DoubaoBottomSheetCancelSource HOST_UNAVAILABLE = null;
    public static final DoubaoBottomSheetCancelSource MASK = null;
    public static final DoubaoBottomSheetCancelSource UNKNOWN = null;
    public static final /* synthetic */ DoubaoBottomSheetCancelSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoubaoBottomSheetCancelSource> getEntries() {
        return b;
    }

    static {
        DoubaoBottomSheetCancelSource r0 = new DoubaoBottomSheetCancelSource("MASK", 0);
        MASK = r0;
        DoubaoBottomSheetCancelSource r1 = new DoubaoBottomSheetCancelSource("GESTURE", 1);
        GESTURE = r1;
        DoubaoBottomSheetCancelSource r10 = new DoubaoBottomSheetCancelSource("HOST_UNAVAILABLE", 2);
        HOST_UNAVAILABLE = r10;
        DoubaoBottomSheetCancelSource r11 = new DoubaoBottomSheetCancelSource("UNKNOWN", 3);
        UNKNOWN = r11;
        DoubaoBottomSheetCancelSource[] r12 = {r0, r1, r10, r11};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static DoubaoBottomSheetCancelSource[] values() {
        return (DoubaoBottomSheetCancelSource[]) a.clone();
    }

    public static DoubaoBottomSheetCancelSource valueOf(String r1) {
        return (DoubaoBottomSheetCancelSource) r27.a.a(DoubaoBottomSheetCancelSource.class, r1);
    }

    public DoubaoBottomSheetCancelSource(String r1, int r10) {
        super(r1, r10);
    }
}
