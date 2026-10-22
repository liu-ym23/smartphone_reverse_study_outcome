package com.obric.capabilitykit.common;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/capabilitykit/common/ToolType;", "", "(Ljava/lang/String;I)V", "UNDEF", "APP", "SHORTCUT", "INTENT", "APPLET", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final enum ToolType extends Enum<ToolType> {
    private static final /* synthetic */ ToolType[] $VALUES = null;
    public static final ToolType APP = null;
    public static final ToolType APPLET = null;
    public static final ToolType INTENT = null;
    public static final ToolType SHORTCUT = null;
    public static final ToolType UNDEF = null;

    private static final /* synthetic */ ToolType[] $values() {
        return new ToolType[]{UNDEF, APP, SHORTCUT, INTENT, APPLET};
    }

    static {
        UNDEF = new ToolType("UNDEF", 0);
        APP = new ToolType("APP", 1);
        SHORTCUT = new ToolType("SHORTCUT", 2);
        INTENT = new ToolType("INTENT", 3);
        APPLET = new ToolType("APPLET", 4);
        $VALUES = $values();
    }

    private ToolType(String r1, int r2) {
        super(r1, r2);
    }

    public static ToolType valueOf(String r1) {
        return (ToolType) a.a(ToolType.class, r1);
    }

    public static ToolType[] values() {
        return (ToolType[]) $VALUES.clone();
    }
}
