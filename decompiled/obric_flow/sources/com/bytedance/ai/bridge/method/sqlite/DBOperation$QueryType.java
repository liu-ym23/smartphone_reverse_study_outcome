package com.bytedance.ai.bridge.method.sqlite;

import cn.nubia.neopush.commons.Constant;
import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ai/bridge/method/sqlite/DBOperation$QueryType", "", "Lcom/bytedance/ai/bridge/method/sqlite/DBOperation$QueryType;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum DBOperation$QueryType extends Enum<DBOperation$QueryType> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DBOperation$QueryType f1966b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final DBOperation$QueryType f1967c = null;
    public static final DBOperation$QueryType d = null;
    public static final DBOperation$QueryType e = null;
    public static final DBOperation$QueryType f = null;
    public static final /* synthetic */ DBOperation$QueryType[] g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1968a;

    static {
        DBOperation$QueryType r5 = new DBOperation$QueryType("UPDATE", 0, "update");
        f1966b = r5;
        DBOperation$QueryType r10 = new DBOperation$QueryType("INSERT", 1, "insert");
        f1967c = r10;
        DBOperation$QueryType r11 = new DBOperation$QueryType("DELETE", 2, Constant.ClientMessageType.DELETE);
        d = r11;
        DBOperation$QueryType r12 = new DBOperation$QueryType("SELECT", 3, "select");
        e = r12;
        DBOperation$QueryType r13 = new DBOperation$QueryType("OTHER", 4, "other");
        f = r13;
        DBOperation$QueryType[] r14 = {r5, r10, r11, r12, r13};
        g = r14;
        EnumEntriesKt.enumEntries(r14);
    }

    public DBOperation$QueryType(String r5, int r10, String r11) {
        super(r5, r10);
        this.f1968a = r11;
    }

    public static DBOperation$QueryType valueOf(String r5) {
        return (DBOperation$QueryType) Enum.valueOf(DBOperation$QueryType.class, r5);
    }

    public static DBOperation$QueryType[] values() {
        return (DBOperation$QueryType[]) g.clone();
    }
}
