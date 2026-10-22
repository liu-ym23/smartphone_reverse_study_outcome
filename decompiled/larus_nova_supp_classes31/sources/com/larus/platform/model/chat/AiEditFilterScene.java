package com.larus.platform.model.chat;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/platform/model/chat/AiEditFilterScene;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNKNOWN", "EDU", "HEALTH", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum AiEditFilterScene extends Enum<AiEditFilterScene> {
    public static final a Companion = null;
    public static final AiEditFilterScene EDU = null;
    public static final AiEditFilterScene HEALTH = null;
    public static final AiEditFilterScene UNKNOWN = null;
    public static final /* synthetic */ AiEditFilterScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<AiEditFilterScene> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.platform.model.chat.AiEditFilterScene$a] */
    static {
        AiEditFilterScene r0 = new AiEditFilterScene("UNKNOWN", 0, "");
        UNKNOWN = r0;
        AiEditFilterScene r1 = new AiEditFilterScene("EDU", 1, "edu");
        EDU = r1;
        AiEditFilterScene r3 = new AiEditFilterScene("HEALTH", 2, "health");
        HEALTH = r3;
        AiEditFilterScene[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static AiEditFilterScene[] values() {
        return (AiEditFilterScene[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static AiEditFilterScene valueOf(String r1) {
        return (AiEditFilterScene) r27.a.a(AiEditFilterScene.class, r1);
    }

    public AiEditFilterScene(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
