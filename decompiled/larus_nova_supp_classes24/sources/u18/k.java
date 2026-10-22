package u18;

import com.larksuite.framework.apiplugin.validator.format.Valid;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class k extends a {
    public final Valid e;

    @Override // u18.a
    public final String b() {
        return this.e.warning();
    }

    @Override // v18.a
    public final boolean check() {
        return this.e.value();
    }

    @Override // v18.a
    public final boolean isGray() {
        return this.e.gray();
    }

    public k(Field r1, Valid r2, Object r3, w18.a r4) {
        super(r1, r3, r4);
        this.e = r2;
    }
}
