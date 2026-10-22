package com.larus.canvas.feature.component.instruction.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/canvas/feature/component/instruction/model/UIOptionStatus;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "LOADING", "SELECTED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UIOptionStatus extends Enum<UIOptionStatus> {
    public static final UIOptionStatus LOADING = null;
    public static final UIOptionStatus NORMAL = null;
    public static final UIOptionStatus SELECTED = null;
    public static final /* synthetic */ UIOptionStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UIOptionStatus> getEntries() {
        return b;
    }

    static {
        UIOptionStatus r0 = new UIOptionStatus("NORMAL", 0);
        NORMAL = r0;
        UIOptionStatus r1 = new UIOptionStatus("LOADING", 1);
        LOADING = r1;
        UIOptionStatus r3 = new UIOptionStatus("SELECTED", 2);
        SELECTED = r3;
        UIOptionStatus[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static UIOptionStatus[] values() {
        return (UIOptionStatus[]) a.clone();
    }

    public static UIOptionStatus valueOf(String r1) {
        return (UIOptionStatus) r27.a.a(UIOptionStatus.class, r1);
    }

    public UIOptionStatus(String r1, int r2) {
        super(r1, r2);
    }
}
