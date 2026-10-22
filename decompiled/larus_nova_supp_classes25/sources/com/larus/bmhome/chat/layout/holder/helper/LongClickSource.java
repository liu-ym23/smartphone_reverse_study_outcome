package com.larus.bmhome.chat.layout.holder.helper;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/helper/LongClickSource;", "", "source", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getSource", "()Ljava/lang/String;", "All", "Thinking", "Content", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum LongClickSource extends Enum<LongClickSource> {
    public static final LongClickSource All = null;
    public static final LongClickSource Content = null;
    public static final LongClickSource Thinking = null;
    public static final /* synthetic */ LongClickSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String source;

    public static EnumEntries<LongClickSource> getEntries() {
        return b;
    }

    static {
        LongClickSource r0 = new LongClickSource("All", 0, "all");
        All = r0;
        LongClickSource r1 = new LongClickSource("Thinking", 1, "thinking");
        Thinking = r1;
        LongClickSource r2 = new LongClickSource("Content", 2, "content");
        Content = r2;
        LongClickSource[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static LongClickSource[] values() {
        return (LongClickSource[]) a.clone();
    }

    public final String getSource() {
        return this.source;
    }

    public static LongClickSource valueOf(String r1) {
        return (LongClickSource) r27.a.a(LongClickSource.class, r1);
    }

    public LongClickSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.source = r3;
    }
}
