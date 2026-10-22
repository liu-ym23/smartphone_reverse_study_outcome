package u18;

import com.larksuite.framework.apiplugin.validator.format.Min;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c extends a {
    public final Min e;
    public String f;

    @Override // u18.a
    public final String b() {
        return this.f + " is less than " + this.e.value();
    }

    @Override // v18.a
    public final boolean check() {
        Object r0 = this.c;
        if ((r0 instanceof Number) == false) goto L15;
        w18.a r1 = this.d;
        double r4 = this.e.value();
        double r6 = ((Number) this.c).doubleValue();
        boolean r2 = this.e.include();
        ((w18.b) r1).getClass();
        if (r2 == false) goto L8;
        if (r6 >= r4) goto L9;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == true) goto L42;
        this.f = this.b.getName();
        c(this.e.warning());
        return false;
    L42:
        return true;
    L9:
        r3 = true;
        goto L11
    L8:
        if (r6 <= r4) goto L10;
    L15:
        if ((r0 instanceof List) == false) goto L27;
        w18.a r5 = this.d;
        double r7 = this.e.value();
        double r8 = ((List) this.c).size();
        boolean r9 = this.e.include();
        ((w18.b) r5).getClass();
        if (r9 == false) goto L20;
        if (r8 >= r7) goto L21;
    L22:
        boolean r10 = false;
    L23:
        if (r10 == true) goto L42;
        this.f = this.b.getName() + "'s length";
        c(this.e.warning());
        return false;
    L21:
        r10 = true;
        goto L23
    L20:
        if (r8 <= r7) goto L22;
    L27:
        if ((r0 instanceof String) == false) goto L42;
        w18.a r11 = this.d;
        double r12 = this.e.value();
        Object r13 = this.c;
        if (r13 != null) goto L31;
        double r14 = 0.0d;
    L32:
        boolean r15 = this.e.include();
        ((w18.b) r11).getClass();
        if (r15 == false) goto L36;
        if (r14 >= r12) goto L37;
    L38:
        boolean r16 = false;
    L39:
        if (r16 == true) goto L42;
        this.f = this.b.getName() + "'s length";
        c(this.e.warning());
        return false;
    L37:
        r16 = true;
        goto L39
    L36:
        if (r14 <= r12) goto L38;
    L31:
        r14 = ((String) r13).length();
        goto L32
    }

    @Override // v18.a
    public final boolean isGray() {
        return this.e.gray();
    }

    public c(Field r1, Min r2, Object r3, w18.a r4) {
        super(r1, r3, r4);
        this.e = r2;
    }
}
