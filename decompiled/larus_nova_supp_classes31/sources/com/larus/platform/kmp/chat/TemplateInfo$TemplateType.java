package com.larus.platform.kmp.chat;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateType;", "", "<init>", "(Ljava/lang/String;I)V", "AI_ARTIST", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum TemplateInfo$TemplateType extends Enum<TemplateInfo$TemplateType> {
    public static final TemplateInfo$TemplateType AI_ARTIST = null;
    public static final /* synthetic */ TemplateInfo$TemplateType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TemplateInfo$TemplateType> getEntries() {
        return b;
    }

    static {
        TemplateInfo$TemplateType r0 = new TemplateInfo$TemplateType();
        AI_ARTIST = r0;
        TemplateInfo$TemplateType[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public TemplateInfo$TemplateType() {
        super("AI_ARTIST", 0);
    }

    public static TemplateInfo$TemplateType[] values() {
        return (TemplateInfo$TemplateType[]) a.clone();
    }

    public static TemplateInfo$TemplateType valueOf(String r1) {
        return (TemplateInfo$TemplateType) a.a(TemplateInfo$TemplateType.class, r1);
    }
}
