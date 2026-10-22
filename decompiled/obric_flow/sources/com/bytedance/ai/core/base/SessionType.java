package com.bytedance.ai.core.base;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/core/base/SessionType;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum SessionType extends Enum<SessionType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SessionType f2087a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SessionType f2088b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SessionType f2089c = null;
    public static final /* synthetic */ SessionType[] d = null;

    static {
        SessionType r5 = new SessionType("CHATUI", 0);
        f2087a = r5;
        SessionType r10 = new SessionType("PLAYGROUND", 1);
        f2088b = r10;
        SessionType r11 = new SessionType("DESKTOP", 2);
        SessionType r12 = new SessionType("DEBUG", 3);
        f2089c = r12;
        SessionType[] r13 = {r5, r10, r11, r12, new SessionType("OTHER", 4)};
        d = r13;
        EnumEntriesKt.enumEntries(r13);
    }

    public SessionType(String r5, int r10) {
        super(r5, r10);
    }

    public static SessionType valueOf(String r5) {
        return (SessionType) Enum.valueOf(SessionType.class, r5);
    }

    public static SessionType[] values() {
        return (SessionType[]) d.clone();
    }
}
