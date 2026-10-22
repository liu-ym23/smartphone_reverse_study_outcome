package com.larksuite.component.universe_design.datepicker.impl.data;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larksuite/component/universe_design/datepicker/impl/data/MonthShowMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FIXED_SIX_ROW", "AUTO_HEIGHT", "Companion", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum MonthShowMode extends Enum<MonthShowMode> {
    public static final MonthShowMode AUTO_HEIGHT = null;
    public static final a Companion = null;
    public static final MonthShowMode FIXED_SIX_ROW = null;
    public static final /* synthetic */ MonthShowMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MonthShowMode> getEntries() {
        return b;
    }

    static {
        MonthShowMode r0 = new MonthShowMode("FIXED_SIX_ROW", 0, 0);
        FIXED_SIX_ROW = r0;
        MonthShowMode r1 = new MonthShowMode("AUTO_HEIGHT", 1, 1);
        AUTO_HEIGHT = r1;
        MonthShowMode[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
        Companion = new a();
    }

    public static MonthShowMode[] values() {
        return (MonthShowMode[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MonthShowMode valueOf(String r1) {
        return (MonthShowMode) r27.a.a(MonthShowMode.class, r1);
    }

    public MonthShowMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
