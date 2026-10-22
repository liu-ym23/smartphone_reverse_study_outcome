package com.obric.oui.dialog.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/obric/oui/dialog/base/AbstractDialogModal$CloseIconStyle", "", "Lcom/obric/oui/dialog/base/AbstractDialogModal$CloseIconStyle;", "LIGHT", "DARK", "CUSTOM", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum AbstractDialogModal$CloseIconStyle extends Enum<AbstractDialogModal$CloseIconStyle> {
    public static final AbstractDialogModal$CloseIconStyle CUSTOM = null;
    public static final AbstractDialogModal$CloseIconStyle DARK = null;
    public static final AbstractDialogModal$CloseIconStyle LIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AbstractDialogModal$CloseIconStyle[] f13097a = null;

    static {
        AbstractDialogModal$CloseIconStyle r5 = new AbstractDialogModal$CloseIconStyle("LIGHT", 0);
        LIGHT = r5;
        AbstractDialogModal$CloseIconStyle r10 = new AbstractDialogModal$CloseIconStyle("DARK", 1);
        DARK = r10;
        AbstractDialogModal$CloseIconStyle r11 = new AbstractDialogModal$CloseIconStyle("CUSTOM", 2);
        CUSTOM = r11;
        f13097a = new AbstractDialogModal$CloseIconStyle[]{r5, r10, r11};
    }

    public static AbstractDialogModal$CloseIconStyle valueOf(String r5) {
        return (AbstractDialogModal$CloseIconStyle) Enum.valueOf(AbstractDialogModal$CloseIconStyle.class, r5);
    }

    public static AbstractDialogModal$CloseIconStyle[] values() {
        return (AbstractDialogModal$CloseIconStyle[]) f13097a.clone();
    }
}
