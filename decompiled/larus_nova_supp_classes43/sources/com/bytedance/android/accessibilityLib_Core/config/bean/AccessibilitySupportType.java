package com.bytedance.android.accessibilityLib_Core.config.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/config/bean/AccessibilitySupportType;", "", "SetLabel", "Merge", "CustomView", "accessibilityLib_Core_release"}, k = 1, mv = {1, 4, 1})
public final enum AccessibilitySupportType extends Enum<AccessibilitySupportType> {
    public static final AccessibilitySupportType CustomView = null;
    public static final AccessibilitySupportType Merge = null;
    public static final AccessibilitySupportType SetLabel = null;
    public static final /* synthetic */ AccessibilitySupportType[] a = null;

    static {
        AccessibilitySupportType r1 = new AccessibilitySupportType("SetLabel", 0);
        SetLabel = r1;
        AccessibilitySupportType r10 = new AccessibilitySupportType("Merge", 1);
        Merge = r10;
        AccessibilitySupportType r11 = new AccessibilitySupportType("CustomView", 2);
        CustomView = r11;
        a = new AccessibilitySupportType[]{r1, r10, r11};
    }

    public static AccessibilitySupportType valueOf(String r1) {
        return (AccessibilitySupportType) r27.a.a(AccessibilitySupportType.class, r1);
    }

    public static AccessibilitySupportType[] values() {
        return (AccessibilitySupportType[]) a.clone();
    }

    public AccessibilitySupportType(String r1, int r10) {
        super(r1, r10);
    }
}
