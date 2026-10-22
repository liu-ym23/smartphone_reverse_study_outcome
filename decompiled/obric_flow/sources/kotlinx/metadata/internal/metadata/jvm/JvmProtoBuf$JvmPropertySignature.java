package kotlinx.metadata.internal.metadata.jvm;

import bu.h;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.InvalidProtocolBufferException;
import kotlinx.metadata.internal.protobuf.a0;
import kotlinx.metadata.internal.protobuf.b0;
import kotlinx.metadata.internal.protobuf.f;
import kotlinx.metadata.internal.protobuf.g;
import kotlinx.metadata.internal.protobuf.i;
import kotlinx.metadata.internal.protobuf.m;
import kotlinx.metadata.internal.protobuf.y;
import kotlinx.metadata.internal.protobuf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class JvmProtoBuf$JvmPropertySignature extends GeneratedMessageLite implements a0 {
    public static final int DELEGATE_METHOD_FIELD_NUMBER = 5;
    public static final int FIELD_FIELD_NUMBER = 1;
    public static final int GETTER_FIELD_NUMBER = 3;
    public static b0 PARSER = null;
    public static final int SETTER_FIELD_NUMBER = 4;
    public static final int SYNTHETIC_METHOD_FIELD_NUMBER = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JvmProtoBuf$JvmPropertySignature f19121a = null;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private JvmProtoBuf$JvmMethodSignature delegateMethod_;
    private JvmProtoBuf$JvmFieldSignature field_;
    private JvmProtoBuf$JvmMethodSignature getter_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private JvmProtoBuf$JvmMethodSignature setter_;
    private JvmProtoBuf$JvmMethodSignature syntheticMethod_;
    private final kotlinx.metadata.internal.protobuf.e unknownFields;

    static {
        PARSER = new au.b(24);
        JvmProtoBuf$JvmPropertySignature r5 = new JvmProtoBuf$JvmPropertySignature();
        f19121a = r5;
        r5.field_ = JvmProtoBuf$JvmFieldSignature.getDefaultInstance();
        r5.syntheticMethod_ = JvmProtoBuf$JvmMethodSignature.getDefaultInstance();
        r5.getter_ = JvmProtoBuf$JvmMethodSignature.getDefaultInstance();
        r5.setter_ = JvmProtoBuf$JvmMethodSignature.getDefaultInstance();
        r5.delegateMethod_ = JvmProtoBuf$JvmMethodSignature.getDefaultInstance();
    }

    public JvmProtoBuf$JvmPropertySignature(m r5, bu.e r10) {
        super(r5);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r5.f19190a;
    }

    public static /* synthetic */ JvmProtoBuf$JvmFieldSignature access$3402(JvmProtoBuf$JvmPropertySignature r5, JvmProtoBuf$JvmFieldSignature r10) {
        r5.field_ = r10;
        return r10;
    }

    public static /* synthetic */ JvmProtoBuf$JvmMethodSignature access$3502(JvmProtoBuf$JvmPropertySignature r5, JvmProtoBuf$JvmMethodSignature r10) {
        r5.syntheticMethod_ = r10;
        return r10;
    }

    public static /* synthetic */ JvmProtoBuf$JvmMethodSignature access$3602(JvmProtoBuf$JvmPropertySignature r5, JvmProtoBuf$JvmMethodSignature r10) {
        r5.getter_ = r10;
        return r10;
    }

    public static /* synthetic */ JvmProtoBuf$JvmMethodSignature access$3702(JvmProtoBuf$JvmPropertySignature r5, JvmProtoBuf$JvmMethodSignature r10) {
        r5.setter_ = r10;
        return r10;
    }

    public static /* synthetic */ JvmProtoBuf$JvmMethodSignature access$3802(JvmProtoBuf$JvmPropertySignature r5, JvmProtoBuf$JvmMethodSignature r10) {
        r5.delegateMethod_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$3902(JvmProtoBuf$JvmPropertySignature r5, int r10) {
        r5.bitField0_ = r10;
        return r10;
    }

    public static /* synthetic */ kotlinx.metadata.internal.protobuf.e access$4000(JvmProtoBuf$JvmPropertySignature r5) {
        return r5.unknownFields;
    }

    public static JvmProtoBuf$JvmPropertySignature getDefaultInstance() {
        return f19121a;
    }

    public static h newBuilder(JvmProtoBuf$JvmPropertySignature r5) {
        h r10 = newBuilder();
        r10.h(r5);
        return r10;
    }

    public static JvmProtoBuf$JvmPropertySignature parseDelimitedFrom(InputStream r5) throws IOException {
        return (JvmProtoBuf$JvmPropertySignature) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static JvmProtoBuf$JvmPropertySignature parseFrom(kotlinx.metadata.internal.protobuf.e r5) throws InvalidProtocolBufferException {
        return (JvmProtoBuf$JvmPropertySignature) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public /* bridge */ /* synthetic */ z getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public JvmProtoBuf$JvmMethodSignature getDelegateMethod() {
        return this.delegateMethod_;
    }

    public JvmProtoBuf$JvmFieldSignature getField() {
        return this.field_;
    }

    public JvmProtoBuf$JvmMethodSignature getGetter() {
        return this.getter_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public b0 getParserForType() {
        return PARSER;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public int getSerializedSize() {
        int r5 = this.memoizedSerializedSize;
        if (r5 == (-1)) goto L6;
        return r5;
    L6:
        if ((this.bitField0_ & 1) != 1) goto L8;
        int r10 = g.e(1, this.field_);
    L10:
        if ((this.bitField0_ & 2) != 2) goto L13;
        r10 = r10 + g.e(2, this.syntheticMethod_);
    L13:
        if ((this.bitField0_ & 4) != 4) goto L16;
        r10 = r10 + g.e(3, this.getter_);
    L16:
        if ((this.bitField0_ & 8) != 8) goto L19;
        r10 = r10 + g.e(4, this.setter_);
    L19:
        if ((this.bitField0_ & 16) != 16) goto L21;
        r10 = r10 + g.e(5, this.delegateMethod_);
    L21:
        int r11 = this.unknownFields.size() + r10;
        this.memoizedSerializedSize = r11;
        return r11;
    L8:
        r10 = 0;
        goto L10
    }

    public JvmProtoBuf$JvmMethodSignature getSetter() {
        return this.setter_;
    }

    public JvmProtoBuf$JvmMethodSignature getSyntheticMethod() {
        return this.syntheticMethod_;
    }

    public boolean hasDelegateMethod() {
        if ((this.bitField0_ & 16) != 16) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasField() {
        if ((this.bitField0_ & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean hasGetter() {
        if ((this.bitField0_ & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasSetter() {
        if ((this.bitField0_ & 8) != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasSyntheticMethod() {
        if ((this.bitField0_ & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.a0
    public final boolean isInitialized() {
        byte r5 = this.memoizedIsInitialized;
        if (r5 != 1) goto L5;
        return true;
    L5:
        if (r5 != 0) goto L8;
        return false;
    L8:
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public /* bridge */ /* synthetic */ y newBuilderForType() {
        return newBuilderForType();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public /* bridge */ /* synthetic */ y toBuilder() {
        return toBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public void writeTo(g r5) throws IOException {
        getSerializedSize();
        if ((this.bitField0_ & 1) != 1) goto L6;
        r5.p(1, this.field_);
    L6:
        if ((this.bitField0_ & 2) != 2) goto L9;
        r5.p(2, this.syntheticMethod_);
    L9:
        if ((this.bitField0_ & 4) != 4) goto L12;
        r5.p(3, this.getter_);
    L12:
        if ((this.bitField0_ & 8) != 8) goto L15;
        r5.p(4, this.setter_);
    L15:
        if ((this.bitField0_ & 16) != 16) goto L17;
        r5.p(5, this.delegateMethod_);
    L17:
        r5.r(this.unknownFields);
    }

    public static h newBuilder() {
        return h.g();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public JvmProtoBuf$JvmPropertySignature getDefaultInstanceForType() {
        return f19121a;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public h newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public h toBuilder() {
        return newBuilder(this);
    }

    public static JvmProtoBuf$JvmPropertySignature parseDelimitedFrom(InputStream r5, i r10) throws IOException {
        return (JvmProtoBuf$JvmPropertySignature) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, r10);
    }

    public static JvmProtoBuf$JvmPropertySignature parseFrom(kotlinx.metadata.internal.protobuf.e r5, i r10) throws InvalidProtocolBufferException {
        return (JvmProtoBuf$JvmPropertySignature) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, r10);
    }

    public JvmProtoBuf$JvmPropertySignature() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlinx.metadata.internal.protobuf.e.f19154a;
    }

    public static JvmProtoBuf$JvmPropertySignature parseFrom(byte[] r5) throws InvalidProtocolBufferException {
        return (JvmProtoBuf$JvmPropertySignature) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public JvmProtoBuf$JvmPropertySignature(f r10, i r11, bu.e r12) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.field_ = JvmProtoBuf$JvmFieldSignature.getDefaultInstance();
        this.syntheticMethod_ = JvmProtoBuf$JvmMethodSignature.getDefaultInstance();
        this.getter_ = JvmProtoBuf$JvmMethodSignature.getDefaultInstance();
        this.setter_ = JvmProtoBuf$JvmMethodSignature.getDefaultInstance();
        this.delegateMethod_ = JvmProtoBuf$JvmMethodSignature.getDefaultInstance();
        kotlinx.metadata.internal.protobuf.d r13 = new kotlinx.metadata.internal.protobuf.d();
        g r5 = g.j(r13, 1);
        boolean r14 = false;
    L3:
        if (r14 == true) goto L85;
        int r15 = r10.n();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        if (r15 == 0) goto L18;
        bu.g r16 = null;
        bu.f r17 = null;
        bu.g r18 = null;
        bu.g r19 = null;
        bu.g r20 = null;
        if (r15 != 10) goto L9;
        if ((this.bitField0_ & 1) != 1) goto L56;
        r17 = this.field_.toBuilder();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
    L56:
        JvmProtoBuf$JvmFieldSignature r21 = (JvmProtoBuf$JvmFieldSignature) r10.g(JvmProtoBuf$JvmFieldSignature.PARSER, r11);     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        this.field_ = r21;     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        if (r17 == null) goto L59;
        r17.g(r21);     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        this.field_ = r17.f();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
    L59:
        this.bitField0_ |= 1;     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        goto L3
    L9:
        if (r15 != 18) goto L11;
        if ((this.bitField0_ & 2) != 2) goto L49;
        r18 = this.syntheticMethod_.toBuilder();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
    L49:
        JvmProtoBuf$JvmMethodSignature r22 = (JvmProtoBuf$JvmMethodSignature) r10.g(JvmProtoBuf$JvmMethodSignature.PARSER, r11);     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        this.syntheticMethod_ = r22;     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        if (r18 == null) goto L52;
        r18.g(r22);     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        this.syntheticMethod_ = r18.f();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
    L52:
        this.bitField0_ |= 2;     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        goto L3
    L11:
        if (r15 != 26) goto L13;
        if ((this.bitField0_ & 4) != 4) goto L42;
        r19 = this.getter_.toBuilder();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
    L42:
        JvmProtoBuf$JvmMethodSignature r23 = (JvmProtoBuf$JvmMethodSignature) r10.g(JvmProtoBuf$JvmMethodSignature.PARSER, r11);     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        this.getter_ = r23;     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        if (r19 == null) goto L45;
        r19.g(r23);     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        this.getter_ = r19.f();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
    L45:
        this.bitField0_ |= 4;     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        goto L3
    L13:
        if (r15 != 34) goto L15;
        if ((this.bitField0_ & 8) != 8) goto L35;
        r20 = this.setter_.toBuilder();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
    L35:
        JvmProtoBuf$JvmMethodSignature r24 = (JvmProtoBuf$JvmMethodSignature) r10.g(JvmProtoBuf$JvmMethodSignature.PARSER, r11);     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        this.setter_ = r24;     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        if (r20 == null) goto L38;
        r20.g(r24);     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        this.setter_ = r20.f();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
    L38:
        this.bitField0_ |= 8;     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        goto L3
    L15:
        if (r15 != 42) goto L17;
        if ((this.bitField0_ & 16) != 16) goto L28;
        r16 = this.delegateMethod_.toBuilder();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
    L28:
        JvmProtoBuf$JvmMethodSignature r25 = (JvmProtoBuf$JvmMethodSignature) r10.g(JvmProtoBuf$JvmMethodSignature.PARSER, r11);     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        this.delegateMethod_ = r25;     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        if (r16 == null) goto L31;
        r16.g(r25);     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        this.delegateMethod_ = r16.f();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
    L31:
        this.bitField0_ |= 16;     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        goto L3
    L17:
        if (parseUnknownField(r10, r5, r11, r15) == true) goto L3;
    L18:
        r14 = true;
        goto L3
    L19:
        th = move-exception;
        r5.i();     // Catch: IOException -> L79 Throwable -> L67
    L67:
        th = move-exception;
        this.unknownFields = r13.e();
        throw th;
    L66:
        this.unknownFields = r13.e();
        makeExtensionsImmutable();
        throw th;
    L23:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L19
    L21:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L19
    L85:
        r5.i();     // Catch: IOException -> L80 Throwable -> L74
    L74:
        th = move-exception;
        this.unknownFields = r13.e();
        throw th;
    L73:
        this.unknownFields = r13.e();
        makeExtensionsImmutable();
    }

    public static JvmProtoBuf$JvmPropertySignature parseFrom(byte[] r5, i r10) throws InvalidProtocolBufferException {
        return (JvmProtoBuf$JvmPropertySignature) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, r10);
    }

    public static JvmProtoBuf$JvmPropertySignature parseFrom(InputStream r5) throws IOException {
        return (JvmProtoBuf$JvmPropertySignature) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static JvmProtoBuf$JvmPropertySignature parseFrom(InputStream r5, i r10) throws IOException {
        return (JvmProtoBuf$JvmPropertySignature) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, r10);
    }

    public static JvmProtoBuf$JvmPropertySignature parseFrom(f r5) throws IOException {
        return (JvmProtoBuf$JvmPropertySignature) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static JvmProtoBuf$JvmPropertySignature parseFrom(f r5, i r10) throws IOException {
        return (JvmProtoBuf$JvmPropertySignature) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, r10);
    }
}
