package com.larus.platform.kmp.chat;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/platform/kmp/chat/TemplateInfo$DefaultTab;", "", "<init>", "(Ljava/lang/String;I)V", "CHAT", "TEMPLATE", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum TemplateInfo$DefaultTab extends Enum<TemplateInfo$DefaultTab> {
    public static final TemplateInfo$DefaultTab CHAT = null;
    public static final TemplateInfo$DefaultTab TEMPLATE = null;
    public static final /* synthetic */ TemplateInfo$DefaultTab[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TemplateInfo$DefaultTab> getEntries() {
        return b;
    }

    static {
        TemplateInfo$DefaultTab r0 = new TemplateInfo$DefaultTab("CHAT", 0);
        CHAT = r0;
        TemplateInfo$DefaultTab r1 = new TemplateInfo$DefaultTab("TEMPLATE", 1);
        TEMPLATE = r1;
        TemplateInfo$DefaultTab[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static TemplateInfo$DefaultTab[] values() {
        return (TemplateInfo$DefaultTab[]) a.clone();
    }

    public static TemplateInfo$DefaultTab valueOf(String r1) {
        return (TemplateInfo$DefaultTab) a.a(TemplateInfo$DefaultTab.class, r1);
    }

    public TemplateInfo$DefaultTab(String r1, int r2) {
        super(r1, r2);
    }
}
