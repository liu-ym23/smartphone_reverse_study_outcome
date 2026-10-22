package com.bytedance.android.accessibilityLib_Core.base;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/base/AccessibilityConfigType;", "", "ContentDesc", "LargeArea", "MergeView", "More", "accessibilityLib_Core_release"}, k = 1, mv = {1, 4, 1})
public final enum AccessibilityConfigType extends Enum<AccessibilityConfigType> {
    public static final AccessibilityConfigType ContentDesc = null;
    public static final AccessibilityConfigType LargeArea = null;
    public static final AccessibilityConfigType MergeView = null;
    public static final AccessibilityConfigType More = null;
    public static final /* synthetic */ AccessibilityConfigType[] a = null;

    static {
        AccessibilityConfigType r1 = new AccessibilityConfigType("ContentDesc", 0);
        ContentDesc = r1;
        AccessibilityConfigType r10 = new AccessibilityConfigType("LargeArea", 1);
        LargeArea = r10;
        AccessibilityConfigType r11 = new AccessibilityConfigType("MergeView", 2);
        MergeView = r11;
        AccessibilityConfigType r12 = new AccessibilityConfigType("More", 3);
        More = r12;
        a = new AccessibilityConfigType[]{r1, r10, r11, r12};
    }

    public static AccessibilityConfigType valueOf(String r1) {
        return (AccessibilityConfigType) a.a(AccessibilityConfigType.class, r1);
    }

    public static AccessibilityConfigType[] values() {
        return (AccessibilityConfigType[]) a.clone();
    }

    public AccessibilityConfigType(String r1, int r10) {
        super(r1, r10);
    }
}
