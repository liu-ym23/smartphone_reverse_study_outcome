package com.larus.platform.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/api/AppletDebuggerEntryState;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "HIDDEN", "VISIBLE", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum AppletDebuggerEntryState extends Enum<AppletDebuggerEntryState> {
    public static final AppletDebuggerEntryState HIDDEN = null;
    public static final AppletDebuggerEntryState LOADING = null;
    public static final AppletDebuggerEntryState VISIBLE = null;
    public static final /* synthetic */ AppletDebuggerEntryState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AppletDebuggerEntryState> getEntries() {
        return b;
    }

    static {
        AppletDebuggerEntryState r0 = new AppletDebuggerEntryState("LOADING", 0);
        LOADING = r0;
        AppletDebuggerEntryState r1 = new AppletDebuggerEntryState("HIDDEN", 1);
        HIDDEN = r1;
        AppletDebuggerEntryState r3 = new AppletDebuggerEntryState("VISIBLE", 2);
        VISIBLE = r3;
        AppletDebuggerEntryState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static AppletDebuggerEntryState[] values() {
        return (AppletDebuggerEntryState[]) a.clone();
    }

    public static AppletDebuggerEntryState valueOf(String r1) {
        return (AppletDebuggerEntryState) r27.a.a(AppletDebuggerEntryState.class, r1);
    }

    public AppletDebuggerEntryState(String r1, int r2) {
        super(r1, r2);
    }
}
