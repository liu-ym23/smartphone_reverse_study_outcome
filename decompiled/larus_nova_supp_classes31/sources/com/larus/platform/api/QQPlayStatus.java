package com.larus.platform.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/platform/api/QQPlayStatus;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PLAYING", "PAUSED", "STOPPED", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum QQPlayStatus extends Enum<QQPlayStatus> {
    public static final QQPlayStatus PAUSED = null;
    public static final QQPlayStatus PLAYING = null;
    public static final QQPlayStatus STOPPED = null;
    public static final /* synthetic */ QQPlayStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<QQPlayStatus> getEntries() {
        return b;
    }

    static {
        QQPlayStatus r0 = new QQPlayStatus("PLAYING", 0, "playing");
        PLAYING = r0;
        QQPlayStatus r1 = new QQPlayStatus("PAUSED", 1, "paused");
        PAUSED = r1;
        QQPlayStatus r2 = new QQPlayStatus("STOPPED", 2, "stopped");
        STOPPED = r2;
        QQPlayStatus[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static QQPlayStatus[] values() {
        return (QQPlayStatus[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static QQPlayStatus valueOf(String r1) {
        return (QQPlayStatus) r27.a.a(QQPlayStatus.class, r1);
    }

    public QQPlayStatus(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
