package com.bytedance.android.anniex.container.popup;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/anniex/container/popup/CloseType;", "", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG, "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "SystemBack", "PullDown", "MaskClick", "UnKnown", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum CloseType extends Enum<CloseType> {
    public static final CloseType MaskClick = null;
    public static final CloseType PullDown = null;
    public static final CloseType SystemBack = null;
    public static final CloseType UnKnown = null;
    public static final /* synthetic */ CloseType[] a = null;
    private final String tag;

    public static CloseType valueOf(String r1) {
        return (CloseType) r27.a.a(CloseType.class, r1);
    }

    public static CloseType[] values() {
        return (CloseType[]) a.clone();
    }

    static {
        CloseType r0 = new CloseType("SystemBack", 0, "systemBack");
        SystemBack = r0;
        CloseType r1 = new CloseType("PullDown", 1, "pullDown");
        PullDown = r1;
        CloseType r10 = new CloseType("MaskClick", 2, "maskClick");
        MaskClick = r10;
        CloseType r11 = new CloseType("UnKnown", 3, "unKnown");
        UnKnown = r11;
        a = new CloseType[]{r0, r1, r10, r11};
    }

    public final String getTag() {
        return this.tag;
    }

    public CloseType(String r1, int r10, String r11) {
        super(r1, r10);
        this.tag = r11;
    }
}
