package av;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.util.Properties;
import org.sqlite.SQLiteConfig$Pragma;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Driver {
    static {
        DriverManager.registerDriver(new d());     // Catch: SQLException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static boolean a(String r5) {
        if (r5 != null) goto L4;
    L6:
        return false;
    L4:
        if (r5.toLowerCase().startsWith("jdbc:sqlite:") == false) goto L6;
        return true;
    }

    @Override // java.sql.Driver
    public boolean acceptsURL(String r5) {
        return a(r5);
    }

    @Override // java.sql.Driver
    public Connection connect(String r5, Properties r10) {
        if (a(r5) == true) goto L5;
        return null;
    L5:
        String r11 = r5.trim();
        return new dv.a(r11, r11.substring(12), r10);
    }

    @Override // java.sql.Driver
    public int getMajorVersion() {
        String[] r5 = i.q().split("\\.");
        if (r5.length > 0) goto L7;
        return 1;
    L7:
        return Integer.parseInt(r5[0]);
    }

    @Override // java.sql.Driver
    public int getMinorVersion() {
        String[] r5 = i.q().split("\\.");
        if (r5.length > 1) goto L7;
        return 0;
    L7:
        return Integer.parseInt(r5[1]);
    }

    @Override // java.sql.Driver
    public DriverPropertyInfo[] getPropertyInfo(String r10, Properties r11) {
        String[] r12 = f.e;
        DriverPropertyInfo[] r13 = new DriverPropertyInfo[SQLiteConfig$Pragma.values().length];
        SQLiteConfig$Pragma[] r14 = SQLiteConfig$Pragma.values();
        int r15 = r14.length;
        int r5 = 0;
        int r16 = 0;
    L3:
        if (r5 >= r15) goto L5;
        SQLiteConfig$Pragma r17 = r14[r5];
        DriverPropertyInfo r18 = new DriverPropertyInfo(r17.pragmaName, null);
        r18.choices = r17.choices;
        r18.description = r17.description;
        r18.required = false;
        r13[r16] = r18;
        r5 = r5 + 1;
        r16 = r16 + 1;
        goto L3
    L5:
        return r13;
    }

    @Override // java.sql.Driver
    public boolean jdbcCompliant() {
        return false;
    }
}
