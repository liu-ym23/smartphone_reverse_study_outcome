package com.obric.oui.dialog.v2.alert.style;

import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "待废弃")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController$TextColorType;", "", "<init>", "(Ljava/lang/String;I)V", "TextReverse", "TextReverse2", "Negative", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum ButtonStyleController$TextColorType extends Enum<ButtonStyleController$TextColorType> {
    private static final /* synthetic */ ButtonStyleController$TextColorType[] $VALUES = null;
    public static final ButtonStyleController$TextColorType Negative = null;
    public static final ButtonStyleController$TextColorType TextReverse = null;
    public static final ButtonStyleController$TextColorType TextReverse2 = null;

    static {
        ButtonStyleController$TextColorType r10 = new ButtonStyleController$TextColorType("TextReverse", 0);
        TextReverse = r10;
        ButtonStyleController$TextColorType r11 = new ButtonStyleController$TextColorType("TextReverse2", 1);
        TextReverse2 = r11;
        ButtonStyleController$TextColorType r12 = new ButtonStyleController$TextColorType("Negative", 2);
        Negative = r12;
        $VALUES = new ButtonStyleController$TextColorType[]{r10, r11, r12};
    }

    private ButtonStyleController$TextColorType(String r10, int r11) {
        super(r10, r11);
    }

    public static ButtonStyleController$TextColorType valueOf(String r10) {
        return (ButtonStyleController$TextColorType) Enum.valueOf(ButtonStyleController$TextColorType.class, r10);
    }

    public static ButtonStyleController$TextColorType[] values() {
        return (ButtonStyleController$TextColorType[]) $VALUES.clone();
    }
}
