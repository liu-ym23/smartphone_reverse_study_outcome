package com.obric.oui.dialog.v2.alert.style;

import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "待废弃")
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/obric/oui/dialog/v2/alert/style/ButtonStyleController$TextColorType", "", "Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController$TextColorType;", "TextReverse", "TextReverse2", "Negative", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum ButtonStyleController$TextColorType extends Enum<ButtonStyleController$TextColorType> {
    public static final ButtonStyleController$TextColorType Negative = null;
    public static final ButtonStyleController$TextColorType TextReverse = null;
    public static final ButtonStyleController$TextColorType TextReverse2 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ButtonStyleController$TextColorType[] f13172a = null;

    static {
        ButtonStyleController$TextColorType r5 = new ButtonStyleController$TextColorType("TextReverse", 0);
        TextReverse = r5;
        ButtonStyleController$TextColorType r10 = new ButtonStyleController$TextColorType("TextReverse2", 1);
        TextReverse2 = r10;
        ButtonStyleController$TextColorType r11 = new ButtonStyleController$TextColorType("Negative", 2);
        Negative = r11;
        f13172a = new ButtonStyleController$TextColorType[]{r5, r10, r11};
    }

    public static ButtonStyleController$TextColorType valueOf(String r5) {
        return (ButtonStyleController$TextColorType) Enum.valueOf(ButtonStyleController$TextColorType.class, r5);
    }

    public static ButtonStyleController$TextColorType[] values() {
        return (ButtonStyleController$TextColorType[]) f13172a.clone();
    }
}
