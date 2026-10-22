package com.larus.dora.impl.nl.freq;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/larus/dora/impl/nl/freq/NotificationFreq;", "", "freq", "", "descResId", "<init>", "(Ljava/lang/String;III)V", "getFreq", "()I", "getDescResId", "NOTIFICATION_FREQ_5", "NOTIFICATION_FREQ_10", "NOTIFICATION_FREQ_15", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NotificationFreq extends Enum<NotificationFreq> {
    public static final a Companion = null;
    public static final NotificationFreq NOTIFICATION_FREQ_10 = null;
    public static final NotificationFreq NOTIFICATION_FREQ_15 = null;
    public static final NotificationFreq NOTIFICATION_FREQ_5 = null;
    public static final /* synthetic */ NotificationFreq[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int descResId;
    private final int freq;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<NotificationFreq> getEntries() {
        return b;
    }

    static {
        NotificationFreq r0 = new NotificationFreq("NOTIFICATION_FREQ_5", 0, 5, 2131902249);
        NOTIFICATION_FREQ_5 = r0;
        NotificationFreq r1 = new NotificationFreq("NOTIFICATION_FREQ_10", 1, 10, 2131902247);
        NOTIFICATION_FREQ_10 = r1;
        NotificationFreq r3 = new NotificationFreq("NOTIFICATION_FREQ_15", 2, 15, 2131902248);
        NOTIFICATION_FREQ_15 = r3;
        NotificationFreq[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static NotificationFreq[] values() {
        return (NotificationFreq[]) a.clone();
    }

    public final int getDescResId() {
        return this.descResId;
    }

    public final int getFreq() {
        return this.freq;
    }

    public static NotificationFreq valueOf(String r1) {
        return (NotificationFreq) r27.a.a(NotificationFreq.class, r1);
    }

    public NotificationFreq(String r1, int r2, int r3, int r4) {
        super(r1, r2);
        this.freq = r3;
        this.descResId = r4;
    }
}
