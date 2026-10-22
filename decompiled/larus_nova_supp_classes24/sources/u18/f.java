package u18;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.larksuite.framework.apiplugin.validator.format.Pattern;
import com.ss.android.lark.log.Log;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f extends a {
    public final Pattern e;

    @Override // u18.a
    public final String b() {
        return this.b.getName() + " is not matched regex: " + this.e.value();
    }

    @Override // v18.a
    public final boolean check() {
        if ((this.c instanceof String) == false) goto L15;
        w18.a r0 = this.d;
        String r2 = this.e.value();
        String r3 = (String) this.c;
        ((w18.b) r0).getClass();
        if (r3 == null) goto L11;
        if (r2 == null) goto L11;
        boolean r1 = PatternProtector.compile(r2).matcher(r3).matches();     // Catch: Exception -> L9
    L12:
        if (r1 == true) goto L15;
        c(this.e.warning());
        return false;
    L9:
        e = move-exception;
        Log.e("InternalRuleProvider", "isPattern exception :" + e);
    L11:
        r1 = true;
    L15:
        return true;
    }

    @Override // v18.a
    public final boolean isGray() {
        return this.e.gray();
    }

    public f(Field r1, Pattern r2, Object r3, w18.a r4) {
        super(r1, r3, r4);
        this.e = r2;
    }
}
