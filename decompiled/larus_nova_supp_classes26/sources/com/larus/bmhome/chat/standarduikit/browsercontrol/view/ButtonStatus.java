package com.larus.bmhome.chat.standarduikit.browsercontrol.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/browsercontrol/view/ButtonStatus;", "", "<init>", "(Ljava/lang/String;I)V", "DISABLED", "ENABLED", "HIDE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ButtonStatus extends Enum<ButtonStatus> {
    public static final ButtonStatus DISABLED = null;
    public static final ButtonStatus ENABLED = null;
    public static final ButtonStatus HIDE = null;
    public static final /* synthetic */ ButtonStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ButtonStatus> getEntries() {
        return b;
    }

    static {
        ButtonStatus r0 = new ButtonStatus("DISABLED", 0);
        DISABLED = r0;
        ButtonStatus r1 = new ButtonStatus("ENABLED", 1);
        ENABLED = r1;
        ButtonStatus r3 = new ButtonStatus("HIDE", 2);
        HIDE = r3;
        ButtonStatus[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ButtonStatus[] values() {
        return (ButtonStatus[]) a.clone();
    }

    public static ButtonStatus valueOf(String r1) {
        return (ButtonStatus) a.a(ButtonStatus.class, r1);
    }

    public ButtonStatus(String r1, int r2) {
        super(r1, r2);
    }
}
