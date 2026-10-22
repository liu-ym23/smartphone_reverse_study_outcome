package com.obric.assistant.spi.miniapp;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/spi/miniapp/ObricIntentWidgetUpdateMode;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "UPDATE_IN_PLACE", "RECREATE", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricIntentWidgetUpdateMode extends Enum<ObricIntentWidgetUpdateMode> {
    public static final ObricIntentWidgetUpdateMode DEFAULT = null;
    public static final ObricIntentWidgetUpdateMode RECREATE = null;
    public static final ObricIntentWidgetUpdateMode UPDATE_IN_PLACE = null;
    public static final /* synthetic */ ObricIntentWidgetUpdateMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ObricIntentWidgetUpdateMode> getEntries() {
        return b;
    }

    static {
        ObricIntentWidgetUpdateMode r0 = new ObricIntentWidgetUpdateMode("DEFAULT", 0);
        DEFAULT = r0;
        ObricIntentWidgetUpdateMode r1 = new ObricIntentWidgetUpdateMode("UPDATE_IN_PLACE", 1);
        UPDATE_IN_PLACE = r1;
        ObricIntentWidgetUpdateMode r3 = new ObricIntentWidgetUpdateMode("RECREATE", 2);
        RECREATE = r3;
        ObricIntentWidgetUpdateMode[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ObricIntentWidgetUpdateMode[] values() {
        return (ObricIntentWidgetUpdateMode[]) a.clone();
    }

    public static ObricIntentWidgetUpdateMode valueOf(String r1) {
        return (ObricIntentWidgetUpdateMode) a.a(ObricIntentWidgetUpdateMode.class, r1);
    }

    public ObricIntentWidgetUpdateMode(String r1, int r2) {
        super(r1, r2);
    }
}
