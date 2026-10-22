package com.larus.bmhome.chat.layout.holder.helper;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/helper/TargetDataSource;", "", "target", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTarget", "()Ljava/lang/String;", "ALL", "Thinking", "Content", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum TargetDataSource extends Enum<TargetDataSource> {
    public static final TargetDataSource ALL = null;
    public static final TargetDataSource Content = null;
    public static final TargetDataSource Thinking = null;
    public static final /* synthetic */ TargetDataSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String target;

    public static EnumEntries<TargetDataSource> getEntries() {
        return b;
    }

    static {
        TargetDataSource r0 = new TargetDataSource("ALL", 0, "all");
        ALL = r0;
        TargetDataSource r1 = new TargetDataSource("Thinking", 1, "thinking");
        Thinking = r1;
        TargetDataSource r2 = new TargetDataSource("Content", 2, "content");
        Content = r2;
        TargetDataSource[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static TargetDataSource[] values() {
        return (TargetDataSource[]) a.clone();
    }

    public final String getTarget() {
        return this.target;
    }

    public static TargetDataSource valueOf(String r1) {
        return (TargetDataSource) r27.a.a(TargetDataSource.class, r1);
    }

    public TargetDataSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.target = r3;
    }
}
