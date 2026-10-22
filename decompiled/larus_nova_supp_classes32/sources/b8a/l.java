package b8a;

import com.miui.easygo.constant.EasyGoDbTable;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class l {
    public final String a;
    public final String b;
    public boolean c;
    public final HashMap<String, Object> d;

    public l(HashMap<String, Object> r3) {
        this.a = m.d(r3, EasyGoDbTable.Server.NAME);
        this.b = m.d(r3, "entryType");
        this.c = m.a(r3, "typeResolved", Boolean.TRUE).booleanValue();
        this.d = r3;
    }
}
