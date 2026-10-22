package com.larus.asr.direct;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/asr/direct/IAsrDirectFillAbility$DirectFillStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FillBackClickSend", "FillBackEdit", "FillBackClear", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum IAsrDirectFillAbility$DirectFillStatus extends Enum<IAsrDirectFillAbility$DirectFillStatus> {
    public static final a Companion = null;
    public static final IAsrDirectFillAbility$DirectFillStatus FillBackClear = null;
    public static final IAsrDirectFillAbility$DirectFillStatus FillBackClickSend = null;
    public static final IAsrDirectFillAbility$DirectFillStatus FillBackEdit = null;
    public static final /* synthetic */ IAsrDirectFillAbility$DirectFillStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<IAsrDirectFillAbility$DirectFillStatus> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.asr.direct.IAsrDirectFillAbility$DirectFillStatus$a] */
    static {
        IAsrDirectFillAbility$DirectFillStatus r0 = new IAsrDirectFillAbility$DirectFillStatus("FillBackClickSend", 0, 1);
        FillBackClickSend = r0;
        IAsrDirectFillAbility$DirectFillStatus r1 = new IAsrDirectFillAbility$DirectFillStatus("FillBackEdit", 1, 2);
        FillBackEdit = r1;
        IAsrDirectFillAbility$DirectFillStatus r4 = new IAsrDirectFillAbility$DirectFillStatus("FillBackClear", 2, 3);
        FillBackClear = r4;
        IAsrDirectFillAbility$DirectFillStatus[] r6 = {r0, r1, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
        Companion = new a();
    }

    public static IAsrDirectFillAbility$DirectFillStatus[] values() {
        return (IAsrDirectFillAbility$DirectFillStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static IAsrDirectFillAbility$DirectFillStatus valueOf(String r1) {
        return (IAsrDirectFillAbility$DirectFillStatus) r27.a.a(IAsrDirectFillAbility$DirectFillStatus.class, r1);
    }

    public IAsrDirectFillAbility$DirectFillStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
