package com.bytedance.android.accessibilityLib_Core.config.remote.dsl;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/config/remote/dsl/SelectMode;", "", "Enable", "Disable", "Default", "accessibilityLib_Core_release"}, k = 1, mv = {1, 4, 1})
public final enum SelectMode extends Enum<SelectMode> {
    public static final SelectMode Default = null;
    public static final SelectMode Disable = null;
    public static final SelectMode Enable = null;
    public static final /* synthetic */ SelectMode[] a = null;

    static {
        SelectMode r1 = new SelectMode("Enable", 0);
        Enable = r1;
        SelectMode r10 = new SelectMode("Disable", 1);
        Disable = r10;
        SelectMode r11 = new SelectMode("Default", 2);
        Default = r11;
        a = new SelectMode[]{r1, r10, r11};
    }

    public static SelectMode valueOf(String r1) {
        return (SelectMode) r27.a.a(SelectMode.class, r1);
    }

    public static SelectMode[] values() {
        return (SelectMode[]) a.clone();
    }

    public SelectMode(String r1, int r10) {
        super(r1, r10);
    }
}
