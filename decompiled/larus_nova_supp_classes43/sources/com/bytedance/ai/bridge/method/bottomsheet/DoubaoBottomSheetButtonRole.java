package com.bytedance.ai.bridge.method.bottomsheet;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/bridge/method/bottomsheet/DoubaoBottomSheetButtonRole;", "", "<init>", "(Ljava/lang/String;I)V", "AGREE_MAIN", "AGREE_SUB", "REJECT", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoubaoBottomSheetButtonRole extends Enum<DoubaoBottomSheetButtonRole> {
    public static final DoubaoBottomSheetButtonRole AGREE_MAIN = null;
    public static final DoubaoBottomSheetButtonRole AGREE_SUB = null;
    public static final DoubaoBottomSheetButtonRole REJECT = null;
    public static final /* synthetic */ DoubaoBottomSheetButtonRole[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoubaoBottomSheetButtonRole> getEntries() {
        return b;
    }

    static {
        DoubaoBottomSheetButtonRole r0 = new DoubaoBottomSheetButtonRole("AGREE_MAIN", 0);
        AGREE_MAIN = r0;
        DoubaoBottomSheetButtonRole r1 = new DoubaoBottomSheetButtonRole("AGREE_SUB", 1);
        AGREE_SUB = r1;
        DoubaoBottomSheetButtonRole r10 = new DoubaoBottomSheetButtonRole("REJECT", 2);
        REJECT = r10;
        DoubaoBottomSheetButtonRole[] r11 = {r0, r1, r10};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static DoubaoBottomSheetButtonRole[] values() {
        return (DoubaoBottomSheetButtonRole[]) a.clone();
    }

    public static DoubaoBottomSheetButtonRole valueOf(String r1) {
        return (DoubaoBottomSheetButtonRole) r27.a.a(DoubaoBottomSheetButtonRole.class, r1);
    }

    public DoubaoBottomSheetButtonRole(String r1, int r10) {
        super(r1, r10);
    }
}
