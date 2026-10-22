package com.larus.trace;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/trace/RealtimeCallEntry;", "", "trackName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTrackName", "()Ljava/lang/String;", "CHAT_TITLE_BAR", "MAIN_ACTION_BAR", "MAIN_PLUS_PANEL", "LIST_MAIN_ICON", "LIST_UGC_BOTS_ICON", "DISCOVER_UGC_BOTS_ICON", "INPUT_ACTION", "trace_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum RealtimeCallEntry extends Enum<RealtimeCallEntry> {
    public static final RealtimeCallEntry CHAT_TITLE_BAR = null;
    public static final RealtimeCallEntry DISCOVER_UGC_BOTS_ICON = null;
    public static final RealtimeCallEntry INPUT_ACTION = null;
    public static final RealtimeCallEntry LIST_MAIN_ICON = null;
    public static final RealtimeCallEntry LIST_UGC_BOTS_ICON = null;
    public static final RealtimeCallEntry MAIN_ACTION_BAR = null;
    public static final RealtimeCallEntry MAIN_PLUS_PANEL = null;
    public static final /* synthetic */ RealtimeCallEntry[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String trackName;

    public static EnumEntries<RealtimeCallEntry> getEntries() {
        return b;
    }

    static {
        RealtimeCallEntry r0 = new RealtimeCallEntry("CHAT_TITLE_BAR", 0, "chat_title_bar");
        CHAT_TITLE_BAR = r0;
        RealtimeCallEntry r1 = new RealtimeCallEntry("MAIN_ACTION_BAR", 1, "main_action_bar");
        MAIN_ACTION_BAR = r1;
        RealtimeCallEntry r2 = new RealtimeCallEntry("MAIN_PLUS_PANEL", 2, "main_plus_panel");
        MAIN_PLUS_PANEL = r2;
        RealtimeCallEntry r4 = new RealtimeCallEntry("LIST_MAIN_ICON", 3, "list_main_icon");
        LIST_MAIN_ICON = r4;
        RealtimeCallEntry r6 = new RealtimeCallEntry("LIST_UGC_BOTS_ICON", 4, "list_ugc_bots_icon");
        LIST_UGC_BOTS_ICON = r6;
        RealtimeCallEntry r8 = new RealtimeCallEntry("DISCOVER_UGC_BOTS_ICON", 5, "discover_ugc_bots_icon");
        DISCOVER_UGC_BOTS_ICON = r8;
        RealtimeCallEntry r10 = new RealtimeCallEntry("INPUT_ACTION", 6, "input_action");
        INPUT_ACTION = r10;
        RealtimeCallEntry[] r12 = {r0, r1, r2, r4, r6, r8, r10};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static RealtimeCallEntry[] values() {
        return (RealtimeCallEntry[]) a.clone();
    }

    public final String getTrackName() {
        return this.trackName;
    }

    public static RealtimeCallEntry valueOf(String r1) {
        return (RealtimeCallEntry) a.a(RealtimeCallEntry.class, r1);
    }

    public RealtimeCallEntry(String r1, int r2, String r3) {
        super(r1, r2);
        this.trackName = r3;
    }
}
