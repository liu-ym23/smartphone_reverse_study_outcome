package com.larus.canvas.feature.component.instruction.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/canvas/feature/component/instruction/model/TabDataSource;", "", "<init>", "(Ljava/lang/String;I)V", "FROM_LOCAL", "FROM_REMOTE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TabDataSource extends Enum<TabDataSource> {
    public static final TabDataSource FROM_LOCAL = null;
    public static final TabDataSource FROM_REMOTE = null;
    public static final /* synthetic */ TabDataSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TabDataSource> getEntries() {
        return b;
    }

    static {
        TabDataSource r0 = new TabDataSource("FROM_LOCAL", 0);
        FROM_LOCAL = r0;
        TabDataSource r1 = new TabDataSource("FROM_REMOTE", 1);
        FROM_REMOTE = r1;
        TabDataSource[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static TabDataSource[] values() {
        return (TabDataSource[]) a.clone();
    }

    public static TabDataSource valueOf(String r1) {
        return (TabDataSource) r27.a.a(TabDataSource.class, r1);
    }

    public TabDataSource(String r1, int r2) {
        super(r1, r2);
    }
}
