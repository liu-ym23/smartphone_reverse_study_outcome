package av;

import java.util.Properties;
import java.util.TreeSet;
import org.sqlite.SQLiteConfig$DateClass;
import org.sqlite.SQLiteConfig$DatePrecision;
import org.sqlite.SQLiteConfig$Pragma;
import org.sqlite.SQLiteConfig$TransactionMode;
import org.sqlite.SQLiteOpenMode;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static final String[] e = null;
    public static final TreeSet f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Properties f788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f790c;
    public final g d;

    static {
        e = new String[]{"true", "false"};
        f = new TreeSet();
        SQLiteConfig$Pragma[] r5 = SQLiteConfig$Pragma.values();
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        SQLiteConfig$Pragma r12 = r5[r11];
        f.add(r12.pragmaName);
        r11 = r11 + 1;
        goto L3
    }

    public f(Properties r10) {
        this.f789b = 0;
        this.f788a = r10;
        String r5 = r10.getProperty(SQLiteConfig$Pragma.OPEN_MODE.pragmaName);
        if (r5 == null) goto L5;
        this.f789b = Integer.parseInt(r5);
    L6:
        SQLiteConfig$Pragma r11 = SQLiteConfig$Pragma.SHARED_CACHE;
        String r12 = Boolean.toString(Boolean.parseBoolean(r10.getProperty(r11.pragmaName, "false")));
        r10.put(r11.pragmaName, r12);
        SQLiteOpenMode r13 = SQLiteOpenMode.OPEN_URI;
        int r14 = this.f789b;
        this.f789b = r13.flag | r14;
        this.f790c = Integer.parseInt(r10.getProperty(SQLiteConfig$Pragma.BUSY_TIMEOUT.pragmaName, "3000"));
        this.d = new g(SQLiteConfig$DateClass.getDateClass(r10.getProperty(SQLiteConfig$Pragma.DATE_CLASS.pragmaName, SQLiteConfig$DateClass.INTEGER.name())), SQLiteConfig$DatePrecision.getPrecision(r10.getProperty(SQLiteConfig$Pragma.DATE_PRECISION.pragmaName, SQLiteConfig$DatePrecision.MILLISECONDS.name())), r10.getProperty(SQLiteConfig$Pragma.DATE_STRING_FORMAT.pragmaName, "yyyy-MM-dd HH:mm:ss.SSS"), 8, SQLiteConfig$TransactionMode.getMode(r10.getProperty(SQLiteConfig$Pragma.TRANSACTION_MODE.pragmaName, SQLiteConfig$TransactionMode.DEFERRED.name())), true);
        return;
    L5:
        SQLiteOpenMode r15 = SQLiteOpenMode.READWRITE;
        int r16 = this.f789b;
        int r17 = r15.flag | r16;
        this.f789b = r17;
        this.f789b = r17 | SQLiteOpenMode.CREATE.flag;
        goto L6
    }

    public static String[] a(e[] r5) {
        String[] r10 = new String[r5.length];
        int r11 = 0;
    L4:
        if (r11 >= r5.length) goto L6;
        r10[r11] = r5[r11].getValue();
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    public final int b(SQLiteConfig$Pragma r5, int r10) {
        String r11 = r5.pragmaName;
        Properties r12 = this.f788a;
        if (r12.containsKey(r11) == true) goto L9;
        return r10;
    L9:
        return Integer.parseInt(r12.getProperty(r5.pragmaName));
    L8:
        return r10;
    }
}
