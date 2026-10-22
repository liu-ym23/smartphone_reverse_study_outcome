package com.lark.wire;

import com.lark.wire.Message;
import com.lark.wire.Message.a;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 '*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0000*\u0014\b\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u00020\u0004:\u0002&'B\u001f\b\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u0016\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0017J\u000b\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0004J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0006\u0010\u001e\u001a\u00020\"J\u0006\u0010#\u001a\u00020\bJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%R\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068G¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000bR\u001c\u0010\u0007\u001a\u00020\b8WX\u0096\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u0007\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u00020\u00108\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/lark/wire/Message;", "M", "B", "Lcom/lark/wire/Message$Builder;", "Ljava/io/Serializable;", "adapter", "Lcom/lark/wire/ProtoAdapter;", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/wire/ProtoAdapter;Lokio/ByteString;)V", "()Lcom/lark/wire/ProtoAdapter;", "unknownFields$annotations", "()V", "()Lokio/ByteString;", "cachedSerializedSize", "", "getCachedSerializedSize$wire_runtime", "()I", "setCachedSerializedSize$wire_runtime", "(I)V", "hashCode", "newBuilder", "()Lcom/lark/wire/Message$Builder;", "withoutUnknownFields", "()Lcom/lark/wire/Message;", "toString", "", "writeReplace", "", "encode", "", "sink", "Lokio/BufferedSink;", "", "encodeByteString", "stream", "Ljava/io/OutputStream;", "Builder", "Companion", "wire-runtime"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public abstract class Message<M extends Message<M, B>, B extends a<M, B>> implements Serializable {
    public static final b Companion = null;
    private static final long serialVersionUID = 0;
    public final transient ProtoAdapter<M> a;
    public final transient ByteString c;
    public transient int d;
    protected transient int hashCode;

    public static abstract class a<M extends Message<M, B>, B extends a<M, B>> {
        public transient ByteString a;
        public transient Buffer b;
        public transient j0 c;

        public abstract M b();

        public final ByteString c() {
            Buffer r0 = this.b;
            if (r0 == null) goto L6;
            Intrinsics.checkNotNull(r0);
            this.a = r0.readByteString();
            this.b = null;
            this.c = null;
        L6:
            return this.a;
        }

        public a() {
            this.a = ByteString.EMPTY;
        }

        public final void a(ByteString r3) {
            Intrinsics.checkNotNullParameter(r3, "unknownFields");
            if (r3.size() > 0) goto L5;
            return;
        L5:
            if (this.b != null) goto L7;
            this.b = new Buffer();
            Buffer r1 = this.b;
            Intrinsics.checkNotNull(r1);
            j0 r0 = new j0(r1);
            this.c = r0;
            Intrinsics.checkNotNull(r0);
            r0.a(this.a);
            this.a = ByteString.EMPTY;
        L7:
            j0 r2 = this.c;
            Intrinsics.checkNotNull(r2);
            r2.a(r3);
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
    }

    public static /* synthetic */ void unknownFields$annotations() {
    }

    public abstract B newBuilder();

    public final byte[] encode() {
        ProtoAdapter<M> r0 = this.a;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type M of com.lark.wire.Message");
        r0.getClass();
        Buffer r1 = new Buffer();
        r0.h(r1, this);
        return r1.readByteArray();
    }

    public final ByteString encodeByteString() {
        ProtoAdapter<M> r0 = this.a;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type M of com.lark.wire.Message");
        r0.getClass();
        Buffer r1 = new Buffer();
        r0.h(r1, this);
        return r1.readByteString();
    }

    public String toString() {
        ProtoAdapter<M> r0 = this.a;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type M of com.lark.wire.Message");
        r0.getClass();
        return String.valueOf(this);
    }

    public ByteString unknownFields() {
        ByteString r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return ByteString.EMPTY;
    }

    public final Object writeReplace() throws ObjectStreamException {
        byte[] r1 = encode();
        Class<?> r2 = getClass();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type java.lang.Class<M of com.lark.wire.Message>");
        return new MessageSerializedForm(r1, r2);
    }

    public final M withoutUnknownFields() {
        a r0 = newBuilder();
        r0.getClass();
        r0.a = ByteString.EMPTY;
        Buffer r1 = r0.b;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNull(r1);
        r1.clear();
        r0.b = null;
    L5:
        r0.c = null;
        return (M) r0.b();
    }

    public final ProtoAdapter<M> adapter() {
        return this.a;
    }

    public final int getCachedSerializedSize$wire_runtime() {
        return this.d;
    }

    public final void encode(OutputStream r4) throws IOException {
        Intrinsics.checkNotNullParameter(r4, "stream");
        ProtoAdapter<M> r1 = this.a;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type M of com.lark.wire.Message");
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "stream");
        BufferedSink r5 = Okio.buffer(Okio.sink(r4));
        r1.h(r5, this);
        r5.emit();
    }

    public final void setCachedSerializedSize$wire_runtime(int r1) {
        this.d = r1;
    }

    public final void encode(BufferedSink r3) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "sink");
        ProtoAdapter<M> r0 = this.a;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type M of com.lark.wire.Message");
        r0.h(r3, this);
    }

    public Message(ProtoAdapter<M> r2, ByteString r3) {
        Intrinsics.checkNotNullParameter(r2, "adapter");
        Intrinsics.checkNotNullParameter(r3, "unknownFields");
        this.a = r2;
        this.c = r3;
    }
}
