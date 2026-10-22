package com.larus.avlink.activeSummary;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/avlink/activeSummary/ProactiveMethods;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Frontier", "Push", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum ProactiveMethods extends Enum<ProactiveMethods> {
    public static final ProactiveMethods Frontier = null;
    public static final ProactiveMethods Push = null;
    public static final /* synthetic */ ProactiveMethods[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ProactiveMethods> getEntries() {
        return b;
    }

    static {
        ProactiveMethods r0 = new ProactiveMethods("Frontier", 0, 2);
        Frontier = r0;
        ProactiveMethods r1 = new ProactiveMethods("Push", 1, 3);
        Push = r1;
        ProactiveMethods[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ProactiveMethods[] values() {
        return (ProactiveMethods[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ProactiveMethods valueOf(String r1) {
        return (ProactiveMethods) r27.a.a(ProactiveMethods.class, r1);
    }

    public ProactiveMethods(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
