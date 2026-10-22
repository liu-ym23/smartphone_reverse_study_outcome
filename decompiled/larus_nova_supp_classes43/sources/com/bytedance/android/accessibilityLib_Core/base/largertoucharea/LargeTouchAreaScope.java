package com.bytedance.android.accessibilityLib_Core.base.largertoucharea;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/base/largertoucharea/LargeTouchAreaScope;", "", "ALL", "Activity", "Fragment", "View", "accessibilityLib_Core_release"}, k = 1, mv = {1, 4, 1})
public final enum LargeTouchAreaScope extends Enum<LargeTouchAreaScope> {
    public static final LargeTouchAreaScope ALL = null;
    public static final LargeTouchAreaScope Activity = null;
    public static final LargeTouchAreaScope Fragment = null;
    public static final LargeTouchAreaScope View = null;
    public static final /* synthetic */ LargeTouchAreaScope[] a = null;

    static {
        LargeTouchAreaScope r1 = new LargeTouchAreaScope("ALL", 0);
        ALL = r1;
        LargeTouchAreaScope r10 = new LargeTouchAreaScope("Activity", 1);
        Activity = r10;
        LargeTouchAreaScope r11 = new LargeTouchAreaScope("Fragment", 2);
        Fragment = r11;
        LargeTouchAreaScope r12 = new LargeTouchAreaScope("View", 3);
        View = r12;
        a = new LargeTouchAreaScope[]{r1, r10, r11, r12};
    }

    public static LargeTouchAreaScope valueOf(String r1) {
        return (LargeTouchAreaScope) r27.a.a(LargeTouchAreaScope.class, r1);
    }

    public static LargeTouchAreaScope[] values() {
        return (LargeTouchAreaScope[]) a.clone();
    }

    public LargeTouchAreaScope(String r1, int r10) {
        super(r1, r10);
    }
}
