package com.lynx.markdown;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g {
    public final ByteArrayOutputStream a;
    public final k b;

    public g() {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        this.a = r0;
        this.b = new k(r0);
    }

    public final void a(ArrayList<Object> r3) throws IOException {
        this.b.writeInt(2);
        if (r3 != null) goto L6;
        this.b.writeInt(0);
        return;
    L6:
        this.b.writeInt(r3.size());
        Iterator<Object> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        c(r4.next());
        goto L8
    }

    public final void b(HashMap<String, Object> r7) throws IOException {
        this.b.writeInt(1);
        if (r7 != null) goto L6;
        this.b.writeInt(0);
        return;
    L6:
        this.b.writeInt(r7.size());
        Iterator<String> r1 = r7.keySet().iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        String r2 = r1.next();
        k r3 = this.b;
        r3.getClass();
        byte[] r4 = r2.getBytes(StandardCharsets.UTF_8);
        r3.writeInt(r4.length);
        r3.write(r4, 0, r4.length);
        c(r7.get(r2));
        goto L8
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void c(Object r4) throws IOException {
        if (r4 != null) goto L6;
        this.b.writeInt(0);
        return;
    L6:
        if ((r4 instanceof Boolean) == false) goto L9;
        boolean r5 = ((Boolean) r4).booleanValue();
        this.b.writeInt(3);
        this.b.writeByte(r5 ? 1 : 0);
        return;
    L9:
        if ((r4 instanceof Integer) == false) goto L12;
        int r6 = ((Integer) r4).intValue();
        this.b.writeInt(4);
        this.b.writeInt(r6);
        return;
    L12:
        if ((r4 instanceof Long) == false) goto L15;
        long r0 = ((Long) r4).longValue();
        this.b.writeInt(5);
        this.b.writeLong(r0);
        return;
    L15:
        if ((r4 instanceof Number) == false) goto L18;
        double r1 = ((Number) r4).doubleValue();
        this.b.writeInt(6);
        this.b.writeDouble(r1);
        return;
    L18:
        if ((r4 instanceof String) == false) goto L21;
        this.b.writeInt(7);
        k r2 = this.b;
        r2.getClass();
        byte[] r7 = ((String) r4).getBytes(StandardCharsets.UTF_8);
        r2.writeInt(r7.length);
        r2.write(r7, 0, r7.length);
        return;
    L21:
        if ((r4 instanceof ArrayList) == false) goto L24;
        a((ArrayList) r4);
        return;
    L24:
        if ((r4 instanceof HashMap) == false) goto L26;
        b((HashMap) r4);
        return;
    L26:
        this.b.writeInt(0);
    }
}
