package com.larus.avlink.liveai.model;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\f"}, d2 = {"Lcom/larus/avlink/liveai/model/LiveAiEventScene;", "", "scene", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()Ljava/lang/String;", "MANUAL", "AUTO", "toString", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum LiveAiEventScene extends Enum<LiveAiEventScene> {
    public static final LiveAiEventScene AUTO = null;
    public static final a Companion = null;
    public static final LiveAiEventScene MANUAL = null;
    public static final /* synthetic */ LiveAiEventScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String scene;

    public static EnumEntries<LiveAiEventScene> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.avlink.liveai.model.LiveAiEventScene$a] */
    static {
        LiveAiEventScene r0 = new LiveAiEventScene("MANUAL", 0, "MANUAL");
        MANUAL = r0;
        LiveAiEventScene r1 = new LiveAiEventScene("AUTO", 1, "AUTO");
        AUTO = r1;
        LiveAiEventScene[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
        Companion = new a();
    }

    public static LiveAiEventScene[] values() {
        return (LiveAiEventScene[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "scene:" + this.scene + ' ';
    }

    public final String getScene() {
        return this.scene;
    }

    public static LiveAiEventScene valueOf(String r1) {
        return (LiveAiEventScene) r27.a.a(LiveAiEventScene.class, r1);
    }

    public LiveAiEventScene(String r1, int r2, String r3) {
        super(r1, r2);
        this.scene = r3;
    }
}
