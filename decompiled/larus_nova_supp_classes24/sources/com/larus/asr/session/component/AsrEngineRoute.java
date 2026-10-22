package com.larus.asr.session.component;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/asr/session/component/AsrEngineRoute;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "NORMAL", "KMP", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum AsrEngineRoute extends Enum<AsrEngineRoute> {
    public static final AsrEngineRoute KMP = null;
    public static final AsrEngineRoute NONE = null;
    public static final AsrEngineRoute NORMAL = null;
    public static final /* synthetic */ AsrEngineRoute[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AsrEngineRoute> getEntries() {
        return b;
    }

    static {
        AsrEngineRoute r0 = new AsrEngineRoute("NONE", 0);
        NONE = r0;
        AsrEngineRoute r1 = new AsrEngineRoute("NORMAL", 1);
        NORMAL = r1;
        AsrEngineRoute r3 = new AsrEngineRoute("KMP", 2);
        KMP = r3;
        AsrEngineRoute[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static AsrEngineRoute[] values() {
        return (AsrEngineRoute[]) a.clone();
    }

    public static AsrEngineRoute valueOf(String r1) {
        return (AsrEngineRoute) r27.a.a(AsrEngineRoute.class, r1);
    }

    public AsrEngineRoute(String r1, int r2) {
        super(r1, r2);
    }
}
