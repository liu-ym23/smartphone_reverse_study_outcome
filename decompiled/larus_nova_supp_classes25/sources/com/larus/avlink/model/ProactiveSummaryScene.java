package com.larus.avlink.model;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/avlink/model/ProactiveSummaryScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SystemNotify", "Music", "News", "Remind", "ProactiveMsg", "DeepResearch", "DoraAutoGreet", "dora_avlink_api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum ProactiveSummaryScene extends Enum<ProactiveSummaryScene> {
    public static final ProactiveSummaryScene DeepResearch = null;
    public static final ProactiveSummaryScene DoraAutoGreet = null;
    public static final ProactiveSummaryScene Music = null;
    public static final ProactiveSummaryScene News = null;
    public static final ProactiveSummaryScene ProactiveMsg = null;
    public static final ProactiveSummaryScene Remind = null;
    public static final ProactiveSummaryScene SystemNotify = null;
    public static final /* synthetic */ ProactiveSummaryScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ProactiveSummaryScene> getEntries() {
        return b;
    }

    static {
        ProactiveSummaryScene r0 = new ProactiveSummaryScene("SystemNotify", 0, 1);
        SystemNotify = r0;
        ProactiveSummaryScene r1 = new ProactiveSummaryScene("Music", 1, 2);
        Music = r1;
        ProactiveSummaryScene r4 = new ProactiveSummaryScene("News", 2, 3);
        News = r4;
        ProactiveSummaryScene r6 = new ProactiveSummaryScene("Remind", 3, 4);
        Remind = r6;
        ProactiveSummaryScene r8 = new ProactiveSummaryScene("ProactiveMsg", 4, 5);
        ProactiveMsg = r8;
        ProactiveSummaryScene r10 = new ProactiveSummaryScene("DeepResearch", 5, 6);
        DeepResearch = r10;
        ProactiveSummaryScene r12 = new ProactiveSummaryScene("DoraAutoGreet", 6, 7);
        DoraAutoGreet = r12;
        ProactiveSummaryScene[] r14 = {r0, r1, r4, r6, r8, r10, r12};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
    }

    public static ProactiveSummaryScene[] values() {
        return (ProactiveSummaryScene[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ProactiveSummaryScene valueOf(String r1) {
        return (ProactiveSummaryScene) r27.a.a(ProactiveSummaryScene.class, r1);
    }

    public ProactiveSummaryScene(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
