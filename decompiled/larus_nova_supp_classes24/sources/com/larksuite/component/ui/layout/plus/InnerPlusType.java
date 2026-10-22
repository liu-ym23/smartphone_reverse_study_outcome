package com.larksuite.component.ui.layout.plus;

import com.larksuite.component.ui.layout.ILKUILayout;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u0010"}, d2 = {"Lcom/larksuite/component/ui/layout/plus/InnerPlusType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "PER_MONITOR_RENDER", "ROUND_SHAPE", "HOVER_EVENT_DISALLOW", "createPlus", "Lcom/larksuite/component/ui/layout/plus/BaseInnerPlus;", "layout", "Lcom/larksuite/component/ui/layout/ILKUILayout;", "suite-ui_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public abstract enum InnerPlusType extends Enum<InnerPlusType> {
    public static final InnerPlusType HOVER_EVENT_DISALLOW = null;
    public static final InnerPlusType PER_MONITOR_RENDER = null;
    public static final InnerPlusType ROUND_SHAPE = null;
    public static final InnerPlusType UNKNOWN = null;
    public static final /* synthetic */ InnerPlusType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public InnerPlusType() {
        throw null;
    }

    public static EnumEntries<InnerPlusType> getEntries() {
        return b;
    }

    public abstract BaseInnerPlus createPlus(ILKUILayout r1);

    static {
        final String r1 = "UNKNOWN";
        final int r2 = 0;
        InnerPlusType r0 = new UNKNOWN(r1, r2);
        UNKNOWN = r0;
        final String r3 = "PER_MONITOR_RENDER";
        final int r4 = 1;
        InnerPlusType r5 = new PER_MONITOR_RENDER(r3, r4);
        PER_MONITOR_RENDER = r5;
        final String r6 = "ROUND_SHAPE";
        final int r7 = 2;
        InnerPlusType r8 = new ROUND_SHAPE(r6, r7);
        ROUND_SHAPE = r8;
        final String r9 = "HOVER_EVENT_DISALLOW";
        final int r10 = 3;
        InnerPlusType r11 = new HOVER_EVENT_DISALLOW(r9, r10);
        HOVER_EVENT_DISALLOW = r11;
        InnerPlusType[] r12 = {r0, r5, r8, r11};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static InnerPlusType[] values() {
        return (InnerPlusType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static InnerPlusType valueOf(String r1) {
        return (InnerPlusType) r27.a.a(InnerPlusType.class, r1);
    }

    public InnerPlusType(String r1, int r2, int r3, DefaultConstructorMarker r4) {
        super(r1, r2);
        this.value = r3;
    }
}
