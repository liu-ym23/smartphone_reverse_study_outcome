package com.obric.capabilitykit.common;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/capabilitykit/common/ObricCardType;", "", "()V", "OBRIC_CARD_TYPE_ALARM_CLOCK", "", "OBRIC_CARD_TYPE_APP_CHOOSER", "OBRIC_CARD_TYPE_SETTINGS", "OBRIC_CARD_TYPE_TIMER", "OBRIC_CARD_TYPE_WIFI_QRCODE", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ObricCardType {
    public static final ObricCardType INSTANCE = null;
    public static final int OBRIC_CARD_TYPE_ALARM_CLOCK = 1;
    public static final int OBRIC_CARD_TYPE_APP_CHOOSER = 16;
    public static final int OBRIC_CARD_TYPE_SETTINGS = 2;
    public static final int OBRIC_CARD_TYPE_TIMER = 4;
    public static final int OBRIC_CARD_TYPE_WIFI_QRCODE = 8;

    static {
        INSTANCE = new ObricCardType();
    }

    private ObricCardType() {
    }
}
