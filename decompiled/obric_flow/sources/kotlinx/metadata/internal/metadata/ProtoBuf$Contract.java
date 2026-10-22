package kotlinx.metadata.internal.metadata;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.InvalidProtocolBufferException;

/* JADX INFO: loaded from: classes3.dex */
public final class ProtoBuf$Contract extends GeneratedMessageLite implements kotlinx.metadata.internal.protobuf.a0 {
    public static final int EFFECT_FIELD_NUMBER = 1;
    public static kotlinx.metadata.internal.protobuf.b0 PARSER;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoBuf$Contract f19047a = null;
    private static final long serialVersionUID = 0;
    private List<ProtoBuf$Effect> effect_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final kotlinx.metadata.internal.protobuf.e unknownFields;

    static {
        PARSER = new au.b(3);
        ProtoBuf$Contract r5 = new ProtoBuf$Contract();
        f19047a = r5;
        r5.effect_ = Collections.emptyList();
    }

    public ProtoBuf$Contract(kotlinx.metadata.internal.protobuf.m r5, au.a r10) {
        super(r5);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r5.f19190a;
    }

    public static /* synthetic */ List access$23700(ProtoBuf$Contract r5) {
        return r5.effect_;
    }

    public static /* synthetic */ List access$23702(ProtoBuf$Contract r5, List r10) {
        r5.effect_ = r10;
        return r10;
    }

    public static /* synthetic */ kotlinx.metadata.internal.protobuf.e access$23800(ProtoBuf$Contract r5) {
        return r5.unknownFields;
    }

    public static ProtoBuf$Contract getDefaultInstance() {
        return f19047a;
    }

    public static au.g newBuilder(ProtoBuf$Contract r5) {
        au.g r10 = newBuilder();
        r10.g(r5);
        return r10;
    }

    public static ProtoBuf$Contract parseDelimitedFrom(InputStream r5) throws IOException {
        return (ProtoBuf$Contract) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Contract parseFrom(kotlinx.metadata.internal.protobuf.e r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$Contract) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.z getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public ProtoBuf$Effect getEffect(int r5) {
        return this.effect_.get(r5);
    }

    public int getEffectCount() {
        return this.effect_.size();
    }

    public List<ProtoBuf$Effect> getEffectList() {
        return this.effect_;
    }

    public n getEffectOrBuilder(int r5) {
        return this.effect_.get(r5);
    }

    public List<? extends n> getEffectOrBuilderList() {
        return this.effect_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public kotlinx.metadata.internal.protobuf.b0 getParserForType() {
        return PARSER;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public int getSerializedSize() {
        int r5 = this.memoizedSerializedSize;
        if (r5 == (-1)) goto L5;
        return r5;
    L5:
        int r10 = 0;
        int r11 = 0;
    L7:
        if (r10 >= this.effect_.size()) goto L9;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(1, this.effect_.get(r10));
        r10 = r10 + 1;
        goto L7
    L9:
        int r12 = this.unknownFields.size() + r11;
        this.memoizedSerializedSize = r12;
        return r12;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.a0
    public final boolean isInitialized() {
        byte r5 = this.memoizedIsInitialized;
        if (r5 != 1) goto L6;
        return true;
    L6:
        if (r5 != 0) goto L8;
        return false;
    L8:
        int r10 = 0;
    L10:
        if (r10 >= getEffectCount()) goto L16;
        if (getEffect(r10).isInitialized() == false) goto L13;
        r10 = r10 + 1;
        goto L10
    L13:
        this.memoizedIsInitialized = 0;
        return false;
    L16:
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.y newBuilderForType() {
        return newBuilderForType();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.y toBuilder() {
        return toBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public void writeTo(kotlinx.metadata.internal.protobuf.g r5) throws IOException {
        getSerializedSize();
        int r10 = 0;
    L4:
        if (r10 >= this.effect_.size()) goto L6;
        r5.p(1, this.effect_.get(r10));
        r10 = r10 + 1;
        goto L4
    L6:
        r5.r(this.unknownFields);
    }

    public static au.g newBuilder() {
        au.g r5 = new au.g();
        r5.f741c = Collections.emptyList();
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public ProtoBuf$Contract getDefaultInstanceForType() {
        return f19047a;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public au.g newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public au.g toBuilder() {
        return newBuilder(this);
    }

    public static ProtoBuf$Contract parseDelimitedFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Contract) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, r10);
    }

    public static ProtoBuf$Contract parseFrom(kotlinx.metadata.internal.protobuf.e r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$Contract) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, r10);
    }

    public ProtoBuf$Contract() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlinx.metadata.internal.protobuf.e.f19154a;
    }

    public static ProtoBuf$Contract parseFrom(byte[] r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$Contract) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public ProtoBuf$Contract(kotlinx.metadata.internal.protobuf.f r10, kotlinx.metadata.internal.protobuf.i r11, au.a r12) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.effect_ = Collections.emptyList();
        kotlinx.metadata.internal.protobuf.d r13 = new kotlinx.metadata.internal.protobuf.d();
        kotlinx.metadata.internal.protobuf.g r5 = kotlinx.metadata.internal.protobuf.g.j(r13, 1);
        boolean r14 = false;
        boolean r15 = false;
    L3:
        if (r14 == true) goto L34;
        int r16 = r10.n();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        if (r16 == 0) goto L10;
        if (r16 != 10) goto L9;
        if (r15 == true) goto L19;
        this.effect_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r15 = true;
    L19:
        this.effect_.add((ProtoBuf$Effect) r10.g(ProtoBuf$Effect.PARSER, r11));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L3
    L9:
        if (parseUnknownField(r10, r5, r11, r16) == true) goto L3;
    L10:
        r14 = true;
        goto L3
    L11:
        th = move-exception;
        if (r15 != true) goto L46;
        this.effect_ = Collections.unmodifiableList(this.effect_);
    L46:
        r5.i();     // Catch: IOException -> L44 Throwable -> L29
    L29:
        th = move-exception;
        this.unknownFields = r13.e();
        throw th;
    L28:
        this.unknownFields = r13.e();
        makeExtensionsImmutable();
        throw th;
    L15:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L11
    L13:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L11
    L34:
        if (r15 != true) goto L48;
        this.effect_ = Collections.unmodifiableList(this.effect_);
    L48:
        r5.i();     // Catch: IOException -> L43 Throwable -> L38
    L38:
        th = move-exception;
        this.unknownFields = r13.e();
        throw th;
    L37:
        this.unknownFields = r13.e();
        makeExtensionsImmutable();
    }

    public static ProtoBuf$Contract parseFrom(byte[] r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$Contract) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, r10);
    }

    public static ProtoBuf$Contract parseFrom(InputStream r5) throws IOException {
        return (ProtoBuf$Contract) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Contract parseFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Contract) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, r10);
    }

    public static ProtoBuf$Contract parseFrom(kotlinx.metadata.internal.protobuf.f r5) throws IOException {
        return (ProtoBuf$Contract) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Contract parseFrom(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Contract) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, r10);
    }
}
