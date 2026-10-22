package u18;

import android.text.TextUtils;
import com.ss.android.lark.log.Log;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class a implements v18.a {
    public String a;
    public final Field b;
    public final Object c;
    public final w18.a d;

    public abstract String b();

    @Override // v18.a
    public final String a() {
        return this.a;
    }

    public final void c(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        this.a = b();
    L5:
        Log.w("FieldChecker", this.a);
    }

    public a(Field r1, Object r2, w18.a r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
    }
}
