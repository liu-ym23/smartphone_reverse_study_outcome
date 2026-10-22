package com.bytedance.android.accessibilityLib_Core.base.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/base/api/AbstractAccessibilityLibIsolation$ReStartAccessibilityEngineCondition;", "", "APP_FOREGROUND_FROM_BACKGROUND", "PRIVACY_POLICY_AGREE", "ACCESSIBILITY_STATE_CHANGE", "accessibilityLib_Core_release"}, k = 1, mv = {1, 4, 1})
public final enum AbstractAccessibilityLibIsolation$ReStartAccessibilityEngineCondition extends Enum<AbstractAccessibilityLibIsolation$ReStartAccessibilityEngineCondition> {
    public static final AbstractAccessibilityLibIsolation$ReStartAccessibilityEngineCondition ACCESSIBILITY_STATE_CHANGE = null;
    public static final AbstractAccessibilityLibIsolation$ReStartAccessibilityEngineCondition APP_FOREGROUND_FROM_BACKGROUND = null;
    public static final AbstractAccessibilityLibIsolation$ReStartAccessibilityEngineCondition PRIVACY_POLICY_AGREE = null;
    public static final /* synthetic */ AbstractAccessibilityLibIsolation$ReStartAccessibilityEngineCondition[] a = null;

    static {
        AbstractAccessibilityLibIsolation$ReStartAccessibilityEngineCondition r1 = new AbstractAccessibilityLibIsolation$ReStartAccessibilityEngineCondition("APP_FOREGROUND_FROM_BACKGROUND", 0);
        APP_FOREGROUND_FROM_BACKGROUND = r1;
        AbstractAccessibilityLibIsolation$ReStartAccessibilityEngineCondition r10 = new AbstractAccessibilityLibIsolation$ReStartAccessibilityEngineCondition("PRIVACY_POLICY_AGREE", 1);
        PRIVACY_POLICY_AGREE = r10;
        AbstractAccessibilityLibIsolation$ReStartAccessibilityEngineCondition r11 = new AbstractAccessibilityLibIsolation$ReStartAccessibilityEngineCondition("ACCESSIBILITY_STATE_CHANGE", 2);
        ACCESSIBILITY_STATE_CHANGE = r11;
        a = new AbstractAccessibilityLibIsolation$ReStartAccessibilityEngineCondition[]{r1, r10, r11};
    }

    public static AbstractAccessibilityLibIsolation$ReStartAccessibilityEngineCondition valueOf(String r1) {
        return (AbstractAccessibilityLibIsolation$ReStartAccessibilityEngineCondition) r27.a.a(AbstractAccessibilityLibIsolation$ReStartAccessibilityEngineCondition.class, r1);
    }

    public static AbstractAccessibilityLibIsolation$ReStartAccessibilityEngineCondition[] values() {
        return (AbstractAccessibilityLibIsolation$ReStartAccessibilityEngineCondition[]) a.clone();
    }

    public AbstractAccessibilityLibIsolation$ReStartAccessibilityEngineCondition(String r1, int r10) {
        super(r1, r10);
    }
}
