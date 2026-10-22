package com.bytedance.ai.infra.thread_pool;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/infra/thread_pool/ThreadPriority;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ThreadPriority extends Enum<ThreadPriority> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadPriority f2164a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadPriority f2165b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ ThreadPriority[] f2166c = null;

    static {
        ThreadPriority r5 = new ThreadPriority("LOW", 0);
        f2164a = r5;
        ThreadPriority r10 = new ThreadPriority("NORMAL", 1);
        f2165b = r10;
        ThreadPriority[] r11 = {r5, r10, new ThreadPriority("HIGH", 2)};
        f2166c = r11;
        EnumEntriesKt.enumEntries(r11);
    }

    public ThreadPriority(String r5, int r10) {
        super(r5, r10);
    }

    public static ThreadPriority valueOf(String r5) {
        return (ThreadPriority) Enum.valueOf(ThreadPriority.class, r5);
    }

    public static ThreadPriority[] values() {
        return (ThreadPriority[]) f2166c.clone();
    }
}
