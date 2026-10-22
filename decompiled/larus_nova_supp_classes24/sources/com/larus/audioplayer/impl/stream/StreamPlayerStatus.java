package com.larus.audioplayer.impl.stream;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/audioplayer/impl/stream/StreamPlayerStatus;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PREPARE", "PLAYING", "PAUSED", "STOPPED", "FINISH", "ERROR", "RESUME", "UNKNOWN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum StreamPlayerStatus extends Enum<StreamPlayerStatus> {
    public static final StreamPlayerStatus ERROR = null;
    public static final StreamPlayerStatus FINISH = null;
    public static final StreamPlayerStatus PAUSED = null;
    public static final StreamPlayerStatus PLAYING = null;
    public static final StreamPlayerStatus PREPARE = null;
    public static final StreamPlayerStatus RESUME = null;
    public static final StreamPlayerStatus STOPPED = null;
    public static final StreamPlayerStatus UNKNOWN = null;
    public static final /* synthetic */ StreamPlayerStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<StreamPlayerStatus> getEntries() {
        return b;
    }

    static {
        StreamPlayerStatus r0 = new StreamPlayerStatus("PREPARE", 0, "prepare");
        PREPARE = r0;
        StreamPlayerStatus r1 = new StreamPlayerStatus("PLAYING", 1, "playing");
        PLAYING = r1;
        StreamPlayerStatus r2 = new StreamPlayerStatus("PAUSED", 2, "paused");
        PAUSED = r2;
        StreamPlayerStatus r4 = new StreamPlayerStatus("STOPPED", 3, "stopped");
        STOPPED = r4;
        StreamPlayerStatus r6 = new StreamPlayerStatus("FINISH", 4, "finish");
        FINISH = r6;
        StreamPlayerStatus r8 = new StreamPlayerStatus("ERROR", 5, "error");
        ERROR = r8;
        StreamPlayerStatus r10 = new StreamPlayerStatus("RESUME", 6, "resume");
        RESUME = r10;
        StreamPlayerStatus r12 = new StreamPlayerStatus("UNKNOWN", 7, "unknown");
        UNKNOWN = r12;
        StreamPlayerStatus[] r14 = {r0, r1, r2, r4, r6, r8, r10, r12};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
    }

    public static StreamPlayerStatus[] values() {
        return (StreamPlayerStatus[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static StreamPlayerStatus valueOf(String r1) {
        return (StreamPlayerStatus) r27.a.a(StreamPlayerStatus.class, r1);
    }

    public StreamPlayerStatus(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
