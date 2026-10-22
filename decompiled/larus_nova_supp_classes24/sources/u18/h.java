package u18;

import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h extends a {
    public final LKRequiredParam e;

    @Override // u18.a
    public final String b() {
        return this.b.getName() + " is required ";
    }

    @Override // v18.a
    public final boolean check() {
        w18.a r0 = this.d;
        Object r1 = this.c;
        ((w18.b) r0).getClass();
        if (r1 != null) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        c(this.e.warning());
        return false;
    L9:
        return true;
    L5:
        r2 = false;
        goto L6
    }

    @Override // v18.a
    public final boolean isGray() {
        return this.e.gray();
    }

    public h(Field r1, LKRequiredParam r2, Object r3, w18.a r4) {
        super(r1, r3, r4);
        this.e = r2;
    }
}
