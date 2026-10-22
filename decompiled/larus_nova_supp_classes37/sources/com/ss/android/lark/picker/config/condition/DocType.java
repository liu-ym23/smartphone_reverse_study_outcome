package com.ss.android.lark.picker.config.condition;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/DocType;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "DOC", "SHEET", "BITABLE", "MINDNOTE", "FILE", "SLIDE", "WIKI", "DOCX", "FOLDER", "CATALOG", "SLIDES", "SHORTCUT", "DOCX_SYNCED_BLOCK", "MIAODA", "MIAODA_APP_DEVELOPMENT", "ALL", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum DocType extends Enum<DocType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DocType[] $VALUES = null;
    public static final DocType ALL = null;
    public static final DocType BITABLE = null;
    public static final DocType CATALOG = null;
    public static final DocType DOC = null;
    public static final DocType DOCX = null;
    public static final DocType DOCX_SYNCED_BLOCK = null;
    public static final DocType FILE = null;
    public static final DocType FOLDER = null;
    public static final DocType MIAODA = null;
    public static final DocType MIAODA_APP_DEVELOPMENT = null;
    public static final DocType MINDNOTE = null;
    public static final DocType NONE = null;
    public static final DocType SHEET = null;
    public static final DocType SHORTCUT = null;
    public static final DocType SLIDE = null;
    public static final DocType SLIDES = null;
    public static final DocType WIKI = null;

    private static final /* synthetic */ DocType[] $values() {
        return new DocType[]{NONE, DOC, SHEET, BITABLE, MINDNOTE, FILE, SLIDE, WIKI, DOCX, FOLDER, CATALOG, SLIDES, SHORTCUT, DOCX_SYNCED_BLOCK, MIAODA, MIAODA_APP_DEVELOPMENT, ALL};
    }

    public static EnumEntries<DocType> getEntries() {
        return $ENTRIES;
    }

    static {
        NONE = new DocType("NONE", 0);
        DOC = new DocType("DOC", 1);
        SHEET = new DocType("SHEET", 2);
        BITABLE = new DocType("BITABLE", 3);
        MINDNOTE = new DocType("MINDNOTE", 4);
        FILE = new DocType("FILE", 5);
        SLIDE = new DocType("SLIDE", 6);
        WIKI = new DocType("WIKI", 7);
        DOCX = new DocType("DOCX", 8);
        FOLDER = new DocType("FOLDER", 9);
        CATALOG = new DocType("CATALOG", 10);
        SLIDES = new DocType("SLIDES", 11);
        SHORTCUT = new DocType("SHORTCUT", 12);
        DOCX_SYNCED_BLOCK = new DocType("DOCX_SYNCED_BLOCK", 13);
        MIAODA = new DocType("MIAODA", 14);
        MIAODA_APP_DEVELOPMENT = new DocType("MIAODA_APP_DEVELOPMENT", 15);
        ALL = new DocType("ALL", 16);
        DocType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static DocType[] values() {
        return (DocType[]) $VALUES.clone();
    }

    public static DocType valueOf(String r1) {
        return (DocType) a.a(DocType.class, r1);
    }

    private DocType(String r1, int r2) {
        super(r1, r2);
    }
}
