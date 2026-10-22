package com.bytedance.ai.infra.thread_pool;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/infra/thread_pool/ThreadPriority;", "", "<init>", "(Ljava/lang/String;I)V", "LOW", "NORMAL", "HIGH", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ThreadPriority extends Enum<ThreadPriority> {
    public static final ThreadPriority HIGH = null;
    public static final ThreadPriority LOW = null;
    public static final ThreadPriority NORMAL = null;
    public static final /* synthetic */ ThreadPriority[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ThreadPriority> getEntries() {
        return b;
    }

    static {
        ThreadPriority r0 = new ThreadPriority("LOW", 0);
        LOW = r0;
        ThreadPriority r1 = new ThreadPriority("NORMAL", 1);
        NORMAL = r1;
        ThreadPriority r10 = new ThreadPriority("HIGH", 2);
        HIGH = r10;
        ThreadPriority[] r11 = {r0, r1, r10};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static ThreadPriority[] values() {
        return (ThreadPriority[]) a.clone();
    }

    public static ThreadPriority valueOf(String r1) {
        return (ThreadPriority) r27.a.a(ThreadPriority.class, r1);
    }

    public ThreadPriority(String r1, int r10) {
        super(r1, r10);
    }
}
