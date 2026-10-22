package kotlinx.metadata.internal.protobuf;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class GeneratedMessageLite extends b implements Serializable {
    private static final long serialVersionUID = 1;

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType>> extends GeneratedMessageLite implements a0 {
        private final k extensions;

        public ExtendableMessage() {
            this.extensions = new k();
        }

        public static /* synthetic */ k access$200(ExtendableMessage r5) {
            return r5.extensions;
        }

        public final void a(q r5) {
            if (r5.f19203a != getDefaultInstanceForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }

        public boolean extensionsAreInitialized() {
            k r5 = this.extensions;
            int r10 = 0;
        L3:
            g0 r11 = r5.f19181a;
            if (r10 >= r11.f19170b.size()) goto L9;
            if (k.f(r11.c(r10)) == false) goto L22;
            r10 = r10 + 1;
            goto L3
        L22:
            return false;
        L9:
            Iterator r12 = r11.d().iterator();
        L11:
            if (r12.hasNext() == false) goto L15;
            if (k.f((Map.Entry) r12.next()) == true) goto L11;
            return false;
        L15:
            return true;
        }

        public int extensionsSerializedSize() {
            k r5 = this.extensions;
            int r10 = 0;
            int r11 = 0;
        L3:
            g0 r12 = r5.f19181a;
            if (r10 >= r12.f19170b.size()) goto L6;
            Map.Entry r13 = r12.c(r10);
            r11 = r11 + k.d((p) r13.getKey(), r13.getValue());
            r10 = r10 + 1;
            goto L3
        L6:
            Iterator r14 = r12.d().iterator();
        L8:
            if (r14.hasNext() == false) goto L10;
            Map.Entry r15 = (Map.Entry) r14.next();
            r11 = r11 + k.d((p) r15.getKey(), r15.getValue());
            goto L8
        L10:
            return r11;
        }

        public int extensionsSerializedSizeAsMessageSet() {
            k r5 = this.extensions;
            int r10 = 0;
            int r11 = 0;
        L3:
            g0 r12 = r5.f19181a;
            if (r10 >= r12.f19170b.size()) goto L6;
            r11 = r11 + k.e(r12.c(r10));
            r10 = r10 + 1;
            goto L3
        L6:
            Iterator r13 = r12.d().iterator();
        L8:
            if (r13.hasNext() == false) goto L10;
            r11 = r11 + k.e((Map.Entry) r13.next());
            goto L8
        L10:
            return r11;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        public abstract /* synthetic */ z getDefaultInstanceForType();

        /* JADX WARN: Type inference failed for: r0v3, types: [Type, java.util.ArrayList] */
        public final <Type> Type getExtension(q r5) {
            a(r5);
            g0 r10 = this.extensions.f19181a;
            p r11 = r5.d;
            Type r12 = (Type) r10.get(r11);
            if (r12 != null) goto L7;
            return (Type) r5.f19204b;
        L7:
            if (r11.d == false) goto L16;
            if (r11.f19201c.getJavaType() != WireFormat$JavaType.ENUM) goto L18;
            ?? r13 = (Type) new ArrayList();
            Iterator r14 = ((List) r12).iterator();
        L12:
            if (r14.hasNext() == false) goto L19;
            r13.add(r5.a(r14.next()));
            goto L12
        L19:
            return r13;
        L18:
            return r12;
        L16:
            return (Type) r5.a(r12);
        }

        public final <Type> int getExtensionCount(q r5) {
            a(r5);
            k r10 = this.extensions;
            r10.getClass();
            p r11 = r5.d;
            if (r11.d == false) goto L10;
            Object r12 = r10.f19181a.get(r11);
            if (r12 != null) goto L8;
            return 0;
        L8:
            return ((List) r12).size();
        L10:
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
        public abstract /* synthetic */ int getSerializedSize();

        public final <Type> boolean hasExtension(q r5) {
            a(r5);
            k r10 = this.extensions;
            r10.getClass();
            p r11 = r5.d;
            if (r11.d == true) goto L10;
            if (r10.f19181a.get(r11) == null) goto L7;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.a0
        public abstract /* synthetic */ boolean isInitialized();

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        public void makeExtensionsImmutable() {
            this.extensions.g();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
        public abstract /* synthetic */ y newBuilderForType();

        public o newExtensionWriter() {
            return new o(this, false);
        }

        public o newMessageSetExtensionWriter() {
            return new o(this, true);
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        public boolean parseUnknownField(f r10, g r11, i r12, int r13) throws IOException {
            return GeneratedMessageLite.access$100(this.extensions, getDefaultInstanceForType(), r10, r11, r12, r13);
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
        public abstract /* synthetic */ y toBuilder();

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
        public abstract /* synthetic */ void writeTo(g r5) throws IOException;

        public ExtendableMessage(n r5) {
            r5.f19192b.g();
            r5.f19193c = false;
            this.extensions = r5.f19192b;
        }

        public final <Type> Type getExtension(q r5, int r10) {
            a(r5);
            k r11 = this.extensions;
            r11.getClass();
            p r12 = r5.d;
            if (r12.d == false) goto L11;
            Object r13 = r11.f19181a.get(r12);
            if (r13 == null) goto L9;
            return (Type) r5.a(((List) r13).get(r10));
        L9:
            throw new IndexOutOfBoundsException();
        L11:
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
    }

    public static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private byte[] asBytes;
        private String messageClassName;

        public SerializedForm(z r5) {
            this.messageClassName = r5.getClass().getName();
            this.asBytes = r5.toByteArray();
        }

        public Object readResolve() throws ObjectStreamException {
            y r5 = (y) Class.forName(this.messageClassName).getMethod("newBuilder", null).invoke(null, null);     // Catch: InvalidProtocolBufferException -> L4 InvocationTargetException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 ClassNotFoundException -> L12
            m r10 = (m) r5;     // Catch: InvalidProtocolBufferException -> L4 InvocationTargetException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 ClassNotFoundException -> L12
            r10.e(this.asBytes);     // Catch: InvalidProtocolBufferException -> L4 InvocationTargetException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 ClassNotFoundException -> L12
            return r10.buildPartial();
        L12:
            e = move-exception;
            throw new RuntimeException("Unable to find proto buffer class", e);
        L8:
            e = move-exception;
            throw new RuntimeException("Unable to call newBuilder method", e);
        L10:
            e = move-exception;
            throw new RuntimeException("Unable to find newBuilder method", e);
        L6:
            e = move-exception;
            throw new RuntimeException("Error calling newBuilder", e.getCause());
        L4:
            e = move-exception;
            throw new RuntimeException("Unable to understand proto buffer", e);
        }
    }

    public GeneratedMessageLite() {
    }

    public static boolean access$100(k r10, z r11, f r12, g r13, i r14, int r15) throws IOException {
        int r5 = r15 & 7;
        r14.getClass();
        q r16 = (q) r14.f19175a.get(new h(r11, r15 >>> 3));
        if (r16 != null) goto L5;
    L4:
        boolean r17 = false;
        boolean r18 = true;
    L14:
        if (r18 == true) goto L66;
        if (r17 == false) goto L29;
        int r19 = r12.d(r12.k());
        p r110 = r16.d;
        if (r110.f19201c != WireFormat$FieldType.ENUM) goto L26;
    L20:
        if (r12.b() <= 0) goto L28;
        r r111 = r110.f19199a.findValueByNumber(r12.k());
        if (r111 == null) goto L70;
        r10.a(r110, r16.b(r111));
        goto L20
    L70:
        return true;
    L28:
        r12.c(r19);
        return true;
    L26:
        if (r12.b() <= 0) goto L28;
        r10.a(r110, k.i(r12, r110.f19201c));
        goto L26
    L29:
        int r20 = l.f19186a[r16.d.f19201c.getJavaType().ordinal()];
        p r21 = r16.d;
        if (r20 == 1) goto L38;
        if (r20 == 2) goto L33;
        Object r22 = k.i(r12, r21.f19201c);
    L57:
        if (r21.d == false) goto L59;
        r10.a(r21, r16.b(r22));
        return true;
    L59:
        r10.j(r21, r16.b(r22));
        return true;
    L33:
        int r23 = r12.k();
        r r112 = r21.f19199a.findValueByNumber(r23);
        if (r112 != null) goto L36;
        r13.v(r15);
        r13.v(r23);
        return true;
    L36:
        r22 = r112;
        goto L57
    L38:
        if (r21.d == true) goto L42;
        z r113 = (z) r10.f19181a.get(r21);
        if (r113 == null) goto L42;
        y r114 = r113.toBuilder();
    L43:
        if (r114 != null) goto L46;
        r114 = r16.f19205c.newBuilderForType();
    L46:
        if (r21.f19201c != WireFormat$FieldType.GROUP) goto L52;
        int r115 = r12.f19162i;
        if (r115 >= 64) goto L51;
        r12.f19162i = r115 + 1;
        r114.d(r12, r14);
        r12.a((r21.f19200b << 3) | 4);
        r12.f19162i--;
    L55:
        r22 = r114.build();
        goto L57
    L51:
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    L52:
        int r116 = r12.k();
        if (r12.f19162i >= 64) goto L62;
        int r117 = r12.d(r116);
        r12.f19162i++;
        r114.d(r12, r14);
        r12.a(0);
        r12.f19162i--;
        r12.c(r117);
        goto L55
    L62:
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    L42:
        r114 = null;
        goto L43
    L66:
        return r12.q(r15, r13);
    L5:
        p r24 = r16.d;
        WireFormat$FieldType r25 = r24.f19201c;
        k r26 = k.f19180c;
        if (r5 != r25.getWireType()) goto L9;
        r18 = false;
        r17 = false;
        goto L14
    L9:
        if (r24.d == false) goto L4;
        if (r24.f19201c.isPackable() == false) goto L4;
        if (r5 != 2) goto L4;
        r18 = false;
        r17 = true;
        goto L14
    }

    public static Method getMethodOrDie(Class r5, String r10, Class... r11) {
        return r5.getMethod(r10, r11);
    L4:
        e = move-exception;
        String r12 = r5.getName();
        String r13 = String.valueOf(r10);
        int r14 = r12.length() + 45;
        StringBuilder r15 = new StringBuilder(r13.length() + r14);
        androidx.constraintlayout.motion.widget.a.C(r15, "Generated message class \"", r12, "\" missing method \"", r13);
        r15.append("\".");
        throw new RuntimeException(r15.toString(), e);
    }

    public static Object invokeOrDie(Method r5, Object r10, Object... r11) {
        return r5.invoke(r10, r11);
    L15:
        e = move-exception;
        throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
    L4:
        e = move-exception;
        Throwable r12 = e.getCause();
        if ((r12 instanceof RuntimeException) == true) goto L14;
        if ((r12 instanceof Error) == false) goto L12;
        throw ((Error) r12);
    L12:
        throw new RuntimeException("Unexpected exception thrown by generated accessor method.", r12);
    L14:
        throw ((RuntimeException) r12);
    }

    public static <ContainingType extends z, Type> q newRepeatedGeneratedExtension(ContainingType r13, z r14, s r15, int r16, WireFormat$FieldType r17, boolean r18, Class r19) {
        return new q(r13, Collections.emptyList(), r14, new p(r15, r16, r17, true, r18), r19);
    }

    public static <ContainingType extends z, Type> q newSingularGeneratedExtension(ContainingType r10, Type r11, z r12, s r13, int r14, WireFormat$FieldType r15, Class r16) {
        return new q(r10, r11, r12, new p(r13, r14, r15, false, false), r16);
    }

    public abstract /* synthetic */ z getDefaultInstanceForType();

    public b0 getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    @Override // kotlinx.metadata.internal.protobuf.z
    public abstract /* synthetic */ int getSerializedSize();

    @Override // kotlinx.metadata.internal.protobuf.a0
    public abstract /* synthetic */ boolean isInitialized();

    public void makeExtensionsImmutable() {
    }

    @Override // kotlinx.metadata.internal.protobuf.z
    public abstract /* synthetic */ y newBuilderForType();

    public boolean parseUnknownField(f r5, g r10, i r11, int r12) throws IOException {
        return r5.q(r12, r10);
    }

    @Override // kotlinx.metadata.internal.protobuf.z
    public abstract /* synthetic */ y toBuilder();

    public Object writeReplace() throws ObjectStreamException {
        return new SerializedForm(this);
    }

    @Override // kotlinx.metadata.internal.protobuf.z
    public abstract /* synthetic */ void writeTo(g r5) throws IOException;

    public GeneratedMessageLite(m r5) {
    }
}
