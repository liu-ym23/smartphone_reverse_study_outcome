package com.bytedance.ai.bridge.context;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/bridge/context/RefType;", "", "applet-bridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum RefType extends Enum<RefType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RefType f1803a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final RefType f1804b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ RefType[] f1805c = null;

    static {
        RefType r5 = new RefType("NORMAL", 0);
        f1803a = r5;
        RefType r10 = new RefType("WEAK", 1);
        f1804b = r10;
        RefType[] r11 = {r5, r10};
        f1805c = r11;
        EnumEntriesKt.enumEntries(r11);
    }

    public RefType(String r5, int r10) {
        super(r5, r10);
    }

    public static RefType valueOf(String r5) {
        return (RefType) Enum.valueOf(RefType.class, r5);
    }

    public static RefType[] values() {
        return (RefType[]) f1805c.clone();
    }
}
