package u18;

import com.larksuite.framework.apiplugin.validator.format.StringEnum;
import com.ss.android.lark.log.Log;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i extends a {
    public final StringEnum e;

    @Override // u18.a
    public final String b() {
        return this.b.getName() + " is not in string enum";
    }

    @Override // v18.a
    public final boolean check() {
        Object r0 = this.c;
        if ((r0 instanceof String) == false) goto L18;
        w18.a r1 = this.d;
        String[] r2 = this.e.values();
        String r4 = (String) this.c;
        ((w18.b) r1).getClass();
        if (r2 == null) goto L13;
        int r3 = r2.length;
        int r5 = 0;
    L7:
        if (r5 >= r3) goto L12;
        if (r2[r5].equalsIgnoreCase(r4) == true) goto L13;
        r5 = r5 + 1;
        goto L7
    L12:
        boolean r6 = false;
    L14:
        if (r6 == true) goto L51;
        c(this.e.warning());
        return false;
    L51:
        return true;
    L13:
        r6 = true;
        goto L14
    L18:
        if ((r0 instanceof List) == false) goto L51;
        w18.a r7 = this.d;
        String[] r8 = this.e.values();
        List r9 = (List) this.c;
        ((w18.b) r7).getClass();
        if (r9 == null) goto L47;
        if (r8 == null) goto L47;
        Iterator r10 = r9.iterator();
    L24:
        if (r10.hasNext() == false) goto L33;
        Object r11 = r10.next();
        if ((r11 instanceof String) == true) goto L24;
        StringBuilder r12 = new StringBuilder("type of v is invalid:");
        if (r11 != null) goto L30;
        String r13 = null;
    L31:
        r12.append(r13);
        Log.i("InternalRuleProvider", r12.toString());
    L46:
        boolean r14 = false;
    L48:
        if (r14 == true) goto L51;
        c(this.e.warning());
        return false;
    L30:
        r13 = r11.getClass().getName();
        goto L31
    L33:
        if (w18.b.a(r9) == true) goto L46;
        Iterator r15 = r9.iterator();
    L37:
        if (r15.hasNext() == false) goto L47;
        String r16 = (String) r15.next();
        int r17 = r8.length;
        int r19 = 0;
    L39:
        if (r19 >= r17) goto L44;
        if (r8[r19].equalsIgnoreCase(r16) == true) goto L42;
        r19 = r19 + 1;
        goto L39
    L42:
        boolean r20 = true;
    L45:
        if (r20 == true) goto L37;
    L44:
        r20 = false;
    L47:
        r14 = true;
        goto L48
    }

    @Override // v18.a
    public final boolean isGray() {
        return this.e.gray();
    }

    public i(Field r1, StringEnum r2, Object r3, w18.a r4) {
        super(r1, r3, r4);
        this.e = r2;
    }
}
