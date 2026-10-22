package com.obric.memorydata.sdk.assistant;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/sdk/assistant/WindowState;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "CHAT_WINDOW", "HALF_WINDOW", "FULL_SCREEN", "INVISIBLE", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final enum WindowState extends Enum<WindowState> {
    public static final WindowState CHAT_WINDOW = null;
    public static final a Companion = null;
    public static final WindowState FULL_SCREEN = null;
    public static final WindowState HALF_WINDOW = null;
    public static final WindowState INVISIBLE = null;
    public static final WindowState NA = null;
    public static final /* synthetic */ WindowState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<WindowState> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.memorydata.sdk.assistant.WindowState$a] */
    static {
        WindowState r0 = new WindowState("NA", 0);
        NA = r0;
        WindowState r1 = new WindowState("CHAT_WINDOW", 1);
        CHAT_WINDOW = r1;
        WindowState r3 = new WindowState("HALF_WINDOW", 2);
        HALF_WINDOW = r3;
        WindowState r5 = new WindowState("FULL_SCREEN", 3);
        FULL_SCREEN = r5;
        WindowState r7 = new WindowState("INVISIBLE", 4);
        INVISIBLE = r7;
        WindowState[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
        Companion = new a();
    }

    public static WindowState[] values() {
        return (WindowState[]) a.clone();
    }

    public static WindowState valueOf(String r1) {
        return (WindowState) r27.a.a(WindowState.class, r1);
    }

    public WindowState(String r1, int r2) {
        super(r1, r2);
    }
}
