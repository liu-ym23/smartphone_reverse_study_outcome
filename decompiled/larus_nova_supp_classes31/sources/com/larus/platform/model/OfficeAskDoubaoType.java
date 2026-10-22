package com.larus.platform.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/platform/model/OfficeAskDoubaoType;", "", "configValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getConfigValue", "()Ljava/lang/String;", "FILE", "DOC", "PPT", "SHEET", "BITABLE", "MINDNOTE", "WIKI", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum OfficeAskDoubaoType extends Enum<OfficeAskDoubaoType> {

    @SerializedName("bitable")
    public static final OfficeAskDoubaoType BITABLE = null;

    @SerializedName("doc")
    public static final OfficeAskDoubaoType DOC = null;

    @SerializedName("file")
    public static final OfficeAskDoubaoType FILE = null;

    @SerializedName("mindnote")
    public static final OfficeAskDoubaoType MINDNOTE = null;

    @SerializedName("ppt")
    public static final OfficeAskDoubaoType PPT = null;

    @SerializedName("sheet")
    public static final OfficeAskDoubaoType SHEET = null;

    @SerializedName("wiki")
    public static final OfficeAskDoubaoType WIKI = null;
    public static final /* synthetic */ OfficeAskDoubaoType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String configValue;

    public static EnumEntries<OfficeAskDoubaoType> getEntries() {
        return b;
    }

    static {
        OfficeAskDoubaoType r0 = new OfficeAskDoubaoType("FILE", 0, "file");
        FILE = r0;
        OfficeAskDoubaoType r1 = new OfficeAskDoubaoType("DOC", 1, "doc");
        DOC = r1;
        OfficeAskDoubaoType r2 = new OfficeAskDoubaoType("PPT", 2, "ppt");
        PPT = r2;
        OfficeAskDoubaoType r4 = new OfficeAskDoubaoType("SHEET", 3, "sheet");
        SHEET = r4;
        OfficeAskDoubaoType r6 = new OfficeAskDoubaoType("BITABLE", 4, "bitable");
        BITABLE = r6;
        OfficeAskDoubaoType r8 = new OfficeAskDoubaoType("MINDNOTE", 5, "mindnote");
        MINDNOTE = r8;
        OfficeAskDoubaoType r10 = new OfficeAskDoubaoType("WIKI", 6, "wiki");
        WIKI = r10;
        OfficeAskDoubaoType[] r12 = {r0, r1, r2, r4, r6, r8, r10};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static OfficeAskDoubaoType[] values() {
        return (OfficeAskDoubaoType[]) a.clone();
    }

    public final String getConfigValue() {
        return this.configValue;
    }

    public static OfficeAskDoubaoType valueOf(String r1) {
        return (OfficeAskDoubaoType) a.a(OfficeAskDoubaoType.class, r1);
    }

    public OfficeAskDoubaoType(String r1, int r2, String r3) {
        super(r1, r2);
        this.configValue = r3;
    }
}
