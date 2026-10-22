package com.larus.platform.model.album;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/platform/model/album/TouchState;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "ACTION_DOWN", "ACTION_MOVE_CONSUMED", "ACTION_UP", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum TouchState extends Enum<TouchState> {
    public static final TouchState ACTION_DOWN = null;
    public static final TouchState ACTION_MOVE_CONSUMED = null;
    public static final TouchState ACTION_UP = null;
    public static final TouchState DEFAULT = null;
    public static final /* synthetic */ TouchState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TouchState> getEntries() {
        return b;
    }

    static {
        TouchState r0 = new TouchState("DEFAULT", 0);
        DEFAULT = r0;
        TouchState r1 = new TouchState("ACTION_DOWN", 1);
        ACTION_DOWN = r1;
        TouchState r3 = new TouchState("ACTION_MOVE_CONSUMED", 2);
        ACTION_MOVE_CONSUMED = r3;
        TouchState r5 = new TouchState("ACTION_UP", 3);
        ACTION_UP = r5;
        TouchState[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static TouchState[] values() {
        return (TouchState[]) a.clone();
    }

    public static TouchState valueOf(String r1) {
        return (TouchState) a.a(TouchState.class, r1);
    }

    public TouchState(String r1, int r2) {
        super(r1, r2);
    }
}
