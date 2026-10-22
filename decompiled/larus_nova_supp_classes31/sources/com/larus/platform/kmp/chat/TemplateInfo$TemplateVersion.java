package com.larus.platform.kmp.chat;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateVersion;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "MASONRY_LAYOUT", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum TemplateInfo$TemplateVersion extends Enum<TemplateInfo$TemplateVersion> {
    public static final TemplateInfo$TemplateVersion DEFAULT = null;
    public static final TemplateInfo$TemplateVersion MASONRY_LAYOUT = null;
    public static final /* synthetic */ TemplateInfo$TemplateVersion[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TemplateInfo$TemplateVersion> getEntries() {
        return b;
    }

    static {
        TemplateInfo$TemplateVersion r0 = new TemplateInfo$TemplateVersion("DEFAULT", 0);
        DEFAULT = r0;
        TemplateInfo$TemplateVersion r1 = new TemplateInfo$TemplateVersion("MASONRY_LAYOUT", 1);
        MASONRY_LAYOUT = r1;
        TemplateInfo$TemplateVersion[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static TemplateInfo$TemplateVersion[] values() {
        return (TemplateInfo$TemplateVersion[]) a.clone();
    }

    public static TemplateInfo$TemplateVersion valueOf(String r1) {
        return (TemplateInfo$TemplateVersion) a.a(TemplateInfo$TemplateVersion.class, r1);
    }

    public TemplateInfo$TemplateVersion(String r1, int r2) {
        super(r1, r2);
    }
}
