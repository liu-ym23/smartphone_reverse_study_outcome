package com.lark.wire;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0010¢\u0006\u0002\u0010\u0011J!\u0010\u0012\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0010¢\u0006\u0002\u0010\u0011J\b\u0010\u0013\u001a\u00020\u0002H\u0017J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\u001a\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/lark/wire/AnyMessage;", "Lcom/lark/wire/Message;", "", "typeUrl", "", "value", "Lokio/ByteString;", "<init>", "(Ljava/lang/String;Lokio/ByteString;)V", "getTypeUrl", "()Ljava/lang/String;", "getValue", "()Lokio/ByteString;", "unpack", "T", "adapter", "Lcom/lark/wire/ProtoAdapter;", "(Lcom/lark/wire/ProtoAdapter;)Ljava/lang/Object;", "unpackOrNull", "newBuilder", "equals", "", "other", "", "hashCode", "", "toString", "copy", "Companion", "wire-runtime"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AnyMessage extends Message {
    public static final ProtoAdapter<AnyMessage> ADAPTER = null;
    public static final b Companion = null;
    private final String typeUrl;
    private final ByteString value;

    public static final class a extends ProtoAdapter<AnyMessage> {
        @Override // com.lark.wire.ProtoAdapter
        public final AnyMessage b(h0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            ByteString r1 = ByteString.EMPTY;
            int r2 = r7.h();
            String r3 = "";
        L3:
            int r4 = r7.nextTag();
            if (r4 == (-1)) goto L12;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r3 = r7.e();
            goto L3
        L8:
            if (r4 != 2) goto L9;
            ProtoAdapter.p.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1 = r7.f();
            goto L3
        L9:
            r7.m(r4);
            goto L3
        L12:
            r7.k(r2);
            return new AnyMessage(r3, r1);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final AnyMessage c(g0 r8) {
            Intrinsics.checkNotNullParameter(r8, "reader");
            ByteString r1 = ByteString.EMPTY;
            long r2 = r8.c();
            String r4 = "";
        L3:
            int r5 = r8.e();
            if (r5 == (-1)) goto L12;
            if (r5 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r8, "reader");
            r4 = r8.i();
            goto L3
        L8:
            if (r5 != 2) goto L9;
            ProtoAdapter.p.getClass();
            Intrinsics.checkNotNullParameter(r8, "reader");
            r1 = r8.f();
            goto L3
        L9:
            r8.j(r5);
            goto L3
        L12:
            r8.d(r2);
            return new AnyMessage(r4, r1);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(AnyMessage r4) {
            AnyMessage r5 = r4;
            Intrinsics.checkNotNullParameter(r5, "value");
            return ProtoAdapter.q.l(1, r5.getTypeUrl()) + ProtoAdapter.p.l(2, r5.getValue());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, AnyMessage r5) {
            AnyMessage r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.i(r4, 1, r6.getTypeUrl());
            ProtoAdapter.p.i(r4, 2, r6.getValue());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, AnyMessage r5) {
            AnyMessage r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.p.j(r4, 2, r6.getValue());
            ProtoAdapter.q.j(r4, 1, r6.getTypeUrl());
        }

        public a(FieldEncoding r8, KClass<AnyMessage> r9, Syntax r10) {
            super(r8, r9, "type.googleapis.com/google.protobuf.Any", r10, null, 48);
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
        ADAPTER = new a(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AnyMessage.class), Syntax.PROTO_3);
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (((r0 * 37) + this.typeUrl.hashCode()) * 37) + this.value.hashCode();
        this.hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return "Any{type_url=" + this.typeUrl + ", value=" + this.value + '}';
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return (Message.a) m205newBuilder();
    }

    public final String getTypeUrl() {
        return this.typeUrl;
    }

    public final ByteString getValue() {
        return this.value;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Shouldn't be used in Kotlin")
    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* synthetic */ Void m205newBuilder() {
        throw new AssertionError();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof AnyMessage) == true) goto L8;
        return false;
    L8:
        AnyMessage r6 = (AnyMessage) r5;
        if (Intrinsics.areEqual(this.typeUrl, r6.typeUrl) == true) goto L11;
    L13:
        return false;
    L11:
        if (Intrinsics.areEqual(this.value, r6.value) == false) goto L13;
        return true;
    }

    public final <T> T unpack(ProtoAdapter<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "adapter");
        if (Intrinsics.areEqual(this.typeUrl, r3.c) == false) goto L7;
        return r3.d(this.value);
    L7:
        throw new IllegalStateException(("type mismatch: " + this.typeUrl + " != " + r3.c).toString());
    }

    public final <T> T unpackOrNull(ProtoAdapter<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "adapter");
        if (Intrinsics.areEqual(this.typeUrl, r3.c) == true) goto L7;
        return null;
    L7:
        return r3.d(this.value);
    }

    public AnyMessage(String r3, ByteString r4) {
        Intrinsics.checkNotNullParameter(r3, "typeUrl");
        Intrinsics.checkNotNullParameter(r4, "value");
        super(ADAPTER, ByteString.EMPTY);
        this.typeUrl = r3;
        this.value = r4;
    }

    public final AnyMessage copy(String r2, ByteString r3) {
        Intrinsics.checkNotNullParameter(r2, "typeUrl");
        Intrinsics.checkNotNullParameter(r3, "value");
        return new AnyMessage(r2, r3);
    }

    public /* synthetic */ AnyMessage(String r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }

    public static /* synthetic */ AnyMessage copy$default(AnyMessage r0, String r1, ByteString r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.typeUrl;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.value;
    L9:
        return r0.copy(r1, r2);
    }
}
