package com.obric.memorydata.database.util.file_utils;

import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/FileExtension;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TXT", "PDF", "DOC", "DOCX", "CSV", "XLSX", "XLS", "PPT", "PPTX", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum FileExtension extends Enum<FileExtension> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ FileExtension[] $VALUES = null;
    public static final FileExtension CSV = null;
    public static final a Companion = null;
    public static final FileExtension DOC = null;
    public static final FileExtension DOCX = null;
    public static final FileExtension PDF = null;
    public static final FileExtension PPT = null;
    public static final FileExtension PPTX = null;
    public static final FileExtension TXT = null;
    public static final FileExtension XLS = null;
    public static final FileExtension XLSX = null;
    private final String value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/FileExtension$Companion;", "", "<init>", "()V", "fromText", "Lcom/obric/memorydata/database/util/file_utils/FileExtension;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final FileExtension a(String r6) {
            Intrinsics.checkNotNullParameter(r6, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            FileExtension[] r5 = FileExtension.values();
            int r0 = r5.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            FileExtension r2 = r5[r1];
            if (StringsKt.equals(r2.getValue(), r6, true) == true) goto L12;
            r1 = r1 + 1;
            goto L3
        L12:
            return r2;
        L8:
            return null;
        }
    }

    private static final /* synthetic */ FileExtension[] $values() {
        return new FileExtension[]{TXT, PDF, DOC, DOCX, CSV, XLSX, XLS, PPT, PPTX};
    }

    static {
        TXT = new FileExtension("TXT", 0, "txt");
        PDF = new FileExtension("PDF", 1, "pdf");
        DOC = new FileExtension("DOC", 2, "doc");
        DOCX = new FileExtension("DOCX", 3, "docx");
        CSV = new FileExtension("CSV", 4, "csv");
        XLSX = new FileExtension("XLSX", 5, "xlsx");
        XLS = new FileExtension("XLS", 6, "xls");
        PPT = new FileExtension("PPT", 7, "ppt");
        PPTX = new FileExtension("PPTX", 8, "pptx");
        FileExtension[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private FileExtension(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static EnumEntries<FileExtension> getEntries() {
        return $ENTRIES;
    }

    public static FileExtension valueOf(String r2) {
        return (FileExtension) ZeusTransformUtils.preCheckCast(Enum.valueOf(FileExtension.class, r2), FileExtension.class, "com.obric.memorydata.plugin");
    }

    public static FileExtension[] values() {
        return (FileExtension[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FileExtension[].class, "com.obric.memorydata.plugin");
    }

    public final String getValue() {
        return this.value;
    }
}
