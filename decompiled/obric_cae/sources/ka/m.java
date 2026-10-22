package ka;

import ha.c0;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public final class m extends n.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f9014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Method f9015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f9016h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ c0 f9017i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ ha.j f9018j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ oa.a f9019k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ boolean f9020l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ boolean f9021m;

    public m(String r8, Field r10, boolean r11, boolean r12, boolean r13, Method r14, boolean r15, c0 r16, ha.j r17, oa.a r18, boolean r19, boolean r110) {
        this.f9014f = r13;
        this.f9015g = r14;
        this.f9016h = r15;
        this.f9017i = r16;
        this.f9018j = r17;
        this.f9019k = r18;
        this.f9020l = r19;
        this.f9021m = r110;
        super(r8, r10, r11, r12);
    }

    @Override // ka.n.b
    public final void a(pa.a r8, int r10, Object[] r11) {
        Object r12 = this.f9017i.a(r8);
        if (r12 == null) goto L5;
    L9:
        r11[r10] = r12;
        return;
    L5:
        if (this.f9020l == false) goto L9;
        throw new ha.t("null is not allowed as value for record component '" + this.f9030c + "' of primitive type; at path " + r8.x());
    }

    @Override // ka.n.b
    public final void b(pa.a r8, Object r10) {
        Object r11 = this.f9017i.a(r8);
        if (r11 == null) goto L5;
    L6:
        boolean r12 = this.f9014f;
        Field r13 = this.f9029b;
        if (r12 == false) goto L10;
        n.b(r10, r13);
    L11:
        r13.set(r10, r11);
        return;
    L10:
        if (this.f9021m == false) goto L11;
        throw new ha.q(defpackage.b.c("Cannot set value of 'static final' ", ma.a.d(r13, false)));
    L5:
        if (this.f9020l == false) goto L6;
    }

    @Override // ka.n.b
    public final void c(pa.c r8, Object r10) {
        if (this.f9031d == true) goto L5;
        return;
    L5:
        boolean r11 = this.f9014f;
        Field r12 = this.f9029b;
        Method r13 = this.f9015g;
        if (r11 == false) goto L10;
        if (r13 != null) goto L9;
        n.b(r10, r12);
        goto L10
    L9:
        n.b(r10, r13);
    L10:
        if (r13 != null) goto L26;
        Object r14 = r12.get(r10);
    L18:
        if (r14 != r10) goto L20;
        return;
    L20:
        r8.w(this.f9028a);
        boolean r15 = this.f9016h;
        c0 r16 = this.f9017i;
        if (r15 == true) goto L24;
        Type r17 = this.f9019k.getType();
        r16 = new q(this.f9018j, r16, r17);
    L24:
        r16.b(r8, r14);
        return;
    L26:
        r14 = r13.invoke(r10, new Object[0]);     // Catch: InvocationTargetException -> L14
    L14:
        e = move-exception;
        throw new ha.q(defpackage.b.d("Accessor ", ma.a.d(r13, false), " threw exception"), e.getCause());
    }
}
