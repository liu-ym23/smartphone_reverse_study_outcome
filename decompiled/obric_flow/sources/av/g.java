package av;

import java.util.EnumMap;
import org.sqlite.SQLiteConfig$DateClass;
import org.sqlite.SQLiteConfig$DatePrecision;
import org.sqlite.SQLiteConfig$TransactionMode;
import org.sqlite.date.FastDateFormat;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Cloneable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final EnumMap f791h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SQLiteConfig$DateClass f792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SQLiteConfig$DatePrecision f793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f794c;
    public final FastDateFormat d;
    public int e;
    public final SQLiteConfig$TransactionMode f;
    public boolean g;

    static {
        EnumMap r5 = new EnumMap(SQLiteConfig$TransactionMode.class);
        f791h = r5;
        r5.put(SQLiteConfig$TransactionMode.DEFERRED, "begin;");
        r5.put(SQLiteConfig$TransactionMode.IMMEDIATE, "begin immediate;");
        r5.put(SQLiteConfig$TransactionMode.EXCLUSIVE, "begin exclusive;");
    }

    public g(SQLiteConfig$DateClass r5, SQLiteConfig$DatePrecision r10, String r11, int r12, SQLiteConfig$TransactionMode r13, boolean r14) {
        this.f792a = SQLiteConfig$DateClass.INTEGER;
        this.f793b = SQLiteConfig$DatePrecision.MILLISECONDS;
        this.f794c = "yyyy-MM-dd HH:mm:ss.SSS";
        this.d = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss.SSS");
        this.e = 8;
        SQLiteConfig$TransactionMode r15 = SQLiteConfig$TransactionMode.DEFERRED;
        this.f = r15;
        this.g = true;
        this.f792a = r5;
        this.f793b = r10;
        this.f794c = r11;
        this.d = FastDateFormat.getInstance(r11);
        this.e = r12;
        if (r13 != SQLiteConfig$TransactionMode.DEFFERED) goto L5;
        r13 = r15;
    L5:
        this.f = r13;
        this.g = r14;
    }

    public final long a() {
        if (this.f793b != SQLiteConfig$DatePrecision.MILLISECONDS) goto L5;
        return 1;
    L5:
        return 1000;
    }
}
