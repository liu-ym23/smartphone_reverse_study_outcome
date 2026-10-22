package u18;

import com.larksuite.framework.apiplugin.validator.format.NotBlank;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d extends a {
    public final NotBlank e;

    @Override // u18.a
    public final String b() {
        return this.b.getName() + " is empty";
    }

    @Override // v18.a
    public final boolean check() {
        Object r0 = this.c;
        if ((r0 instanceof String) == false) goto L9;
        ((w18.b) this.d).getClass();
        if (((String) r0).isEmpty() == false) goto L14;
        c(this.e.warning());
        return false;
    L14:
        return true;
    L9:
        if ((r0 instanceof List) == false) goto L16;
        ((w18.b) this.d).getClass();
        if (((List) r0).isEmpty() == false) goto L17;
        c(this.e.warning());
        return false;
    L17:
        return true;
    L16:
        return true;
    }

    @Override // v18.a
    public final boolean isGray() {
        return this.e.gray();
    }

    public d(Field r1, NotBlank r2, Object r3, w18.a r4) {
        super(r1, r3, r4);
        this.e = r2;
    }
}
