package com.larus.platform.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/api/DocExportType;", "", "<init>", "(Ljava/lang/String;I)V", "word", "pdf", "txt", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum DocExportType extends Enum<DocExportType> {
    public static final /* synthetic */ DocExportType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    public static final DocExportType pdf = null;
    public static final DocExportType txt = null;
    public static final DocExportType word = null;

    public static EnumEntries<DocExportType> getEntries() {
        return b;
    }

    static {
        DocExportType r0 = new DocExportType("word", 0);
        word = r0;
        DocExportType r1 = new DocExportType("pdf", 1);
        pdf = r1;
        DocExportType r3 = new DocExportType("txt", 2);
        txt = r3;
        DocExportType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static DocExportType[] values() {
        return (DocExportType[]) a.clone();
    }

    public static DocExportType valueOf(String r1) {
        return (DocExportType) r27.a.a(DocExportType.class, r1);
    }

    public DocExportType(String r1, int r2) {
        super(r1, r2);
    }
}
