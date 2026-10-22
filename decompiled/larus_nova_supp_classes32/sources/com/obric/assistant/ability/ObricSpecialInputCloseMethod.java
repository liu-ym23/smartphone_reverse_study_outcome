package com.obric.assistant.ability;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/ability/ObricSpecialInputCloseMethod;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "X_CLOSE_BUTTON", "ARROW_CLOSE_BUTTON", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricSpecialInputCloseMethod extends Enum<ObricSpecialInputCloseMethod> {
    public static final ObricSpecialInputCloseMethod ARROW_CLOSE_BUTTON = null;
    public static final ObricSpecialInputCloseMethod X_CLOSE_BUTTON = null;
    public static final /* synthetic */ ObricSpecialInputCloseMethod[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ObricSpecialInputCloseMethod> getEntries() {
        return b;
    }

    static {
        ObricSpecialInputCloseMethod r0 = new ObricSpecialInputCloseMethod("X_CLOSE_BUTTON", 0);
        X_CLOSE_BUTTON = r0;
        ObricSpecialInputCloseMethod r1 = new ObricSpecialInputCloseMethod("ARROW_CLOSE_BUTTON", 1);
        ARROW_CLOSE_BUTTON = r1;
        ObricSpecialInputCloseMethod[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ObricSpecialInputCloseMethod[] values() {
        return (ObricSpecialInputCloseMethod[]) a.clone();
    }

    public static ObricSpecialInputCloseMethod valueOf(String r1) {
        return (ObricSpecialInputCloseMethod) a.a(ObricSpecialInputCloseMethod.class, r1);
    }

    public ObricSpecialInputCloseMethod(String r1, int r2) {
        super(r1, r2);
    }
}
