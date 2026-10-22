package u18;

import com.larksuite.framework.apiplugin.validator.format.Prefix;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g extends a {
    public final Prefix e;

    @Override // u18.a
    public final String b() {
        return this.b.getName() + " is not startWith " + this.e.value();
    }

    @Override // v18.a
    public final boolean check() {
        if ((this.c instanceof String) == false) goto L8;
        w18.a r0 = this.d;
        String r1 = this.e.value();
        String r2 = (String) this.c;
        ((w18.b) r0).getClass();
        if (r2.startsWith(r1) == true) goto L10;
        c(this.e.warning());
        return false;
    L10:
        return true;
    L8:
        return true;
    }

    @Override // v18.a
    public final boolean isGray() {
        return this.e.gray();
    }

    public g(Field r1, Prefix r2, Object r3, w18.a r4) {
        super(r1, r3, r4);
        this.e = r2;
    }
}
