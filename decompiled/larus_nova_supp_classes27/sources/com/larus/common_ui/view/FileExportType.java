package com.larus.common_ui.view;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u0012"}, d2 = {"Lcom/larus/common_ui/view/FileExportType;", "", "<init>", "(Ljava/lang/String;I)V", "unknown", "word", "pdf", "txt", "pptx", "excel", "iconRes", "", "nameRes", "toH5Type", "getExtension", "", "toFileTypeStr", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FileExportType extends Enum<FileExportType> {
    public static final a Companion = null;
    public static final /* synthetic */ FileExportType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    public static final FileExportType excel = null;
    public static final FileExportType pdf = null;
    public static final FileExportType pptx = null;
    public static final FileExportType txt = null;
    public static final FileExportType unknown = null;
    public static final FileExportType word = null;

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FileExportType.values().length];
            r0[FileExportType.word.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[FileExportType.pdf.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[FileExportType.txt.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[FileExportType.pptx.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[FileExportType.excel.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[FileExportType.unknown.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    public static EnumEntries<FileExportType> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.common_ui.view.FileExportType$a] */
    static {
        FileExportType r0 = new FileExportType("unknown", 0);
        unknown = r0;
        FileExportType r1 = new FileExportType("word", 1);
        word = r1;
        FileExportType r3 = new FileExportType("pdf", 2);
        pdf = r3;
        FileExportType r5 = new FileExportType("txt", 3);
        txt = r5;
        FileExportType r7 = new FileExportType("pptx", 4);
        pptx = r7;
        FileExportType r9 = new FileExportType("excel", 5);
        excel = r9;
        FileExportType[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
        Companion = new a();
    }

    public static FileExportType[] values() {
        return (FileExportType[]) a.clone();
    }

    public final String getExtension() {
        switch(b.a[ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        return "unknown";
    L7:
        return "excel";
    L8:
        return "pptx";
    L9:
        return "txt";
    L10:
        return "pdf";
    L11:
        return "docx";
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final int iconRes() {
        switch(b.a[ordinal()]) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L11;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L11;
            default: goto L5;
        };
    L6:
        return 2131242691;
    L7:
        return 2131242693;
    L8:
        return 2131242692;
    L9:
        return 2131242695;
    L11:
        return 2131242694;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final int nameRes() {
        switch(b.a[ordinal()]) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L11;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L11;
            default: goto L5;
        };
    L6:
        return 2131897839;
    L7:
        return 2131909775;
    L8:
        return 2131905596;
    L9:
        return 2131905599;
    L11:
        return 2131905598;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final String toFileTypeStr() {
        switch(b.a[ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        return "";
    L7:
        return "excel";
    L8:
        return "pptx";
    L9:
        return "txt";
    L10:
        return "pdf";
    L11:
        return "word";
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final int toH5Type() {
        switch(b.a[ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        return -1;
    L7:
        return 4;
    L8:
        return 3;
    L9:
        return 0;
    L10:
        return 2;
    L11:
        return 1;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public static FileExportType valueOf(String r1) {
        return (FileExportType) r27.a.a(FileExportType.class, r1);
    }

    public FileExportType(String r1, int r2) {
        super(r1, r2);
    }
}
