package com.bytedance.android.ec.core.apt;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/core/apt/ActionType;", "", "", "toString", "Empty", "EnterPage", "NetWork", "ClickProduct", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ActionType extends Enum<ActionType> {
    public static final ActionType ClickProduct = null;
    public static final ActionType Empty = null;
    public static final ActionType EnterPage = null;
    public static final ActionType NetWork = null;
    public static final /* synthetic */ ActionType[] a = null;

    static {
        ActionType r1 = new ActionType("Empty", 0);
        Empty = r1;
        ActionType r10 = new ActionType("EnterPage", 1);
        EnterPage = r10;
        ActionType r11 = new ActionType("NetWork", 2);
        NetWork = r11;
        ActionType r12 = new ActionType("ClickProduct", 3);
        ClickProduct = r12;
        a = new ActionType[]{r1, r10, r11, r12};
    }

    public static ActionType valueOf(String r1) {
        return (ActionType) a.a(ActionType.class, r1);
    }

    public static ActionType[] values() {
        return (ActionType[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return name();
    }

    public ActionType(String r1, int r10) {
        super(r1, r10);
    }
}
