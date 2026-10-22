package org.bouncycastle.util.encoders;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes7.dex */
public class Base64 {
    private static final Encoder encoder = null;

    static {
        encoder = new Base64Encoder();
    }

    public static byte[] decode(String r3) {
        ByteArrayOutputStream r1 = new ByteArrayOutputStream((r3.length() / 4) * 3);
        encoder.decode(r3, r1);     // Catch: Exception -> L6
        return r1.toByteArray();
    L6:
        e = move-exception;
        throw new DecoderException("unable to decode base64 string: " + e.getMessage(), e);
    }

    public static byte[] encode(byte[] r2) {
        return encode(r2, 0, r2.length);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static byte[] encode(byte[] r3, int r4, int r5) {
        Encoder r0 = encoder;
        ByteArrayOutputStream r2 = new ByteArrayOutputStream(r0.getEncodedLength(r5));
        r0.encode(r3, r4, r5, r2);     // Catch: Exception -> L6
        return r2.toByteArray();
    L6:
        e = move-exception;
        throw new EncoderException("exception encoding base64 string: " + e.getMessage(), e);
    }
}
