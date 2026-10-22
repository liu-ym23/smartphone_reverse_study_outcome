package org.sqlite;

import androidx.room.writer.DaoWriter;
import av.e;

/* JADX INFO: loaded from: classes3.dex */
public final enum SQLiteConfig$Encoding extends Enum<SQLiteConfig$Encoding> implements e {
    public static final SQLiteConfig$Encoding UTF16 = null;
    public static final SQLiteConfig$Encoding UTF16_BIG_ENDIAN = null;
    public static final SQLiteConfig$Encoding UTF16_LITTLE_ENDIAN = null;
    public static final SQLiteConfig$Encoding UTF8 = null;
    public static final SQLiteConfig$Encoding UTF_16 = null;
    public static final SQLiteConfig$Encoding UTF_16BE = null;
    public static final SQLiteConfig$Encoding UTF_16LE = null;
    public static final SQLiteConfig$Encoding UTF_8 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SQLiteConfig$Encoding[] f21043a = null;
    public final String typeName;

    static {
        SQLiteConfig$Encoding r5 = new SQLiteConfig$Encoding("UTF8", 0, "'UTF-8'");
        UTF8 = r5;
        SQLiteConfig$Encoding r10 = new SQLiteConfig$Encoding("UTF16", 1, "'UTF-16'");
        UTF16 = r10;
        SQLiteConfig$Encoding r11 = new SQLiteConfig$Encoding("UTF16_LITTLE_ENDIAN", 2, "'UTF-16le'");
        UTF16_LITTLE_ENDIAN = r11;
        SQLiteConfig$Encoding r12 = new SQLiteConfig$Encoding("UTF16_BIG_ENDIAN", 3, "'UTF-16be'");
        UTF16_BIG_ENDIAN = r12;
        SQLiteConfig$Encoding r13 = new SQLiteConfig$Encoding("UTF_8", 4, r5);
        UTF_8 = r13;
        SQLiteConfig$Encoding r14 = new SQLiteConfig$Encoding("UTF_16", 5, r10);
        UTF_16 = r14;
        SQLiteConfig$Encoding r15 = new SQLiteConfig$Encoding("UTF_16LE", 6, r11);
        UTF_16LE = r15;
        SQLiteConfig$Encoding r16 = new SQLiteConfig$Encoding("UTF_16BE", 7, r12);
        UTF_16BE = r16;
        f21043a = new SQLiteConfig$Encoding[]{r5, r10, r11, r12, r13, r14, r15, r16};
    }

    public SQLiteConfig$Encoding(String r5, int r10, String r11) {
        super(r5, r10);
        this.typeName = r11;
    }

    public static SQLiteConfig$Encoding getEncoding(String r5) {
        return valueOf(r5.replaceAll(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD, "_").toUpperCase());
    }

    public static SQLiteConfig$Encoding valueOf(String r5) {
        return (SQLiteConfig$Encoding) Enum.valueOf(SQLiteConfig$Encoding.class, r5);
    }

    public static SQLiteConfig$Encoding[] values() {
        return (SQLiteConfig$Encoding[]) f21043a.clone();
    }

    @Override // av.e
    public String getValue() {
        return this.typeName;
    }

    public SQLiteConfig$Encoding(String r5, int r10, SQLiteConfig$Encoding r11) {
        super(r5, r10);
        this.typeName = r11.getValue();
    }
}
