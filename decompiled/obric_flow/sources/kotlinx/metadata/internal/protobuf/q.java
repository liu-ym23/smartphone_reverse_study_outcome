package kotlinx.metadata.internal.protobuf;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f19203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f19204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f19205c;
    public final p d;
    public final Method e;

    public q(z r5, Object r10, z r11, p r12, Class r13) {
        if (r5 == null) goto L16;
        WireFormat$FieldType r14 = WireFormat$FieldType.MESSAGE;
        if (r12.f19201c != r14) goto L10;
        if (r11 != null) goto L10;
        throw new IllegalArgumentException("Null messageDefaultInstance");
    L10:
        this.f19203a = r5;
        this.f19204b = r10;
        this.f19205c = r11;
        this.d = r12;
        if (r.class.isAssignableFrom(r13) == false) goto L13;
        this.e = GeneratedMessageLite.getMethodOrDie(r13, "valueOf", new Class[]{Integer.TYPE});
        return;
    L13:
        this.e = null;
        return;
    L16:
        throw new IllegalArgumentException("Null containingTypeDefaultInstance");
    }

    public final Object a(Object r5) {
        if (this.d.f19201c.getJavaType() != WireFormat$JavaType.ENUM) goto L6;
        Method r10 = this.e;
        return GeneratedMessageLite.invokeOrDie(r10, null, new Object[]{(Integer) r5});
    L6:
        return r5;
    }

    public final Object b(Object r5) {
        if (this.d.f19201c.getJavaType() == WireFormat$JavaType.ENUM) goto L5;
        return r5;
    L5:
        return Integer.valueOf(((r) r5).getNumber());
    }
}
