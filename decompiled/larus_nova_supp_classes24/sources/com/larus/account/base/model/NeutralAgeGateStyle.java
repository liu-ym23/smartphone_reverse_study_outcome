package com.larus.account.base.model;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/larus/account/base/model/NeutralAgeGateStyle;", "", "style", "", "mobType", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getStyle", "()I", "getMobType", "()Ljava/lang/String;", "DIALOG", "ROLLER", "INPUT", "CLICK_STEP", "YEAR", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum NeutralAgeGateStyle extends Enum<NeutralAgeGateStyle> {
    public static final NeutralAgeGateStyle CLICK_STEP = null;
    public static final a Companion = null;
    public static final NeutralAgeGateStyle DIALOG = null;
    public static final NeutralAgeGateStyle INPUT = null;
    public static final NeutralAgeGateStyle ROLLER = null;
    public static final NeutralAgeGateStyle YEAR = null;
    public static final /* synthetic */ NeutralAgeGateStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String mobType;
    private final int style;

    public static EnumEntries<NeutralAgeGateStyle> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.account.base.model.NeutralAgeGateStyle$a] */
    static {
        NeutralAgeGateStyle r0 = new NeutralAgeGateStyle("DIALOG", 0, 1, "dialog");
        DIALOG = r0;
        NeutralAgeGateStyle r1 = new NeutralAgeGateStyle("ROLLER", 1, 2, "roller");
        ROLLER = r1;
        NeutralAgeGateStyle r4 = new NeutralAgeGateStyle("INPUT", 2, 3, "input");
        INPUT = r4;
        NeutralAgeGateStyle r6 = new NeutralAgeGateStyle("CLICK_STEP", 3, 4, "click");
        CLICK_STEP = r6;
        NeutralAgeGateStyle r8 = new NeutralAgeGateStyle("YEAR", 4, 5, "year");
        YEAR = r8;
        NeutralAgeGateStyle[] r10 = {r0, r1, r4, r6, r8};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
        Companion = new a();
    }

    public static NeutralAgeGateStyle[] values() {
        return (NeutralAgeGateStyle[]) a.clone();
    }

    public final String getMobType() {
        return this.mobType;
    }

    public final int getStyle() {
        return this.style;
    }

    public static NeutralAgeGateStyle valueOf(String r1) {
        return (NeutralAgeGateStyle) r27.a.a(NeutralAgeGateStyle.class, r1);
    }

    public NeutralAgeGateStyle(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.style = r3;
        this.mobType = r4;
    }
}
