package com.larus.platform.kmp.chat;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateOPScene;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "FILL_MESSAGE_TEXT", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum TemplateInfo$TemplateOPScene extends Enum<TemplateInfo$TemplateOPScene> {
    public static final TemplateInfo$TemplateOPScene DEFAULT = null;
    public static final TemplateInfo$TemplateOPScene FILL_MESSAGE_TEXT = null;
    public static final /* synthetic */ TemplateInfo$TemplateOPScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TemplateInfo$TemplateOPScene> getEntries() {
        return b;
    }

    static {
        TemplateInfo$TemplateOPScene r0 = new TemplateInfo$TemplateOPScene("DEFAULT", 0);
        DEFAULT = r0;
        TemplateInfo$TemplateOPScene r1 = new TemplateInfo$TemplateOPScene("FILL_MESSAGE_TEXT", 1);
        FILL_MESSAGE_TEXT = r1;
        TemplateInfo$TemplateOPScene[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static TemplateInfo$TemplateOPScene[] values() {
        return (TemplateInfo$TemplateOPScene[]) a.clone();
    }

    public static TemplateInfo$TemplateOPScene valueOf(String r1) {
        return (TemplateInfo$TemplateOPScene) a.a(TemplateInfo$TemplateOPScene.class, r1);
    }

    public TemplateInfo$TemplateOPScene(String r1, int r2) {
        super(r1, r2);
    }
}
