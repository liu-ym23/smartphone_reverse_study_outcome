package com.larus.platform.model.office;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/platform/model/office/AiFilePreviewScene;", "", "<init>", "(Ljava/lang/String;I)V", "AI_CHAT", "P2P_CHAT", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum AiFilePreviewScene extends Enum<AiFilePreviewScene> {
    public static final AiFilePreviewScene AI_CHAT = null;
    public static final AiFilePreviewScene P2P_CHAT = null;
    public static final /* synthetic */ AiFilePreviewScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AiFilePreviewScene> getEntries() {
        return b;
    }

    static {
        AiFilePreviewScene r0 = new AiFilePreviewScene("AI_CHAT", 0);
        AI_CHAT = r0;
        AiFilePreviewScene r1 = new AiFilePreviewScene("P2P_CHAT", 1);
        P2P_CHAT = r1;
        AiFilePreviewScene[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static AiFilePreviewScene[] values() {
        return (AiFilePreviewScene[]) a.clone();
    }

    public static AiFilePreviewScene valueOf(String r1) {
        return (AiFilePreviewScene) a.a(AiFilePreviewScene.class, r1);
    }

    public AiFilePreviewScene(String r1, int r2) {
        super(r1, r2);
    }
}
