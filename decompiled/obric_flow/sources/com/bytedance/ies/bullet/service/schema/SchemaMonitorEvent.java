package com.bytedance.ies.bullet.service.schema;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/bullet/service/schema/SchemaMonitorEvent;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum SchemaMonitorEvent extends Enum<SchemaMonitorEvent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SchemaMonitorEvent f6129a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ SchemaMonitorEvent[] f6130b = null;

    static {
        SchemaMonitorEvent r5 = new SchemaMonitorEvent("CONVERT", 0);
        f6129a = r5;
        f6130b = new SchemaMonitorEvent[]{r5, new SchemaMonitorEvent("GENERATE", 1)};
    }

    public SchemaMonitorEvent(String r5, int r10) {
        super(r5, r10);
    }

    public static SchemaMonitorEvent valueOf(String r5) {
        return (SchemaMonitorEvent) Enum.valueOf(SchemaMonitorEvent.class, r5);
    }

    public static SchemaMonitorEvent[] values() {
        return (SchemaMonitorEvent[]) f6130b.clone();
    }
}
