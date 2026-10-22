package rb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends Message<s, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f11742a = null;

    public static final class a extends Message.Builder<s, a> {
        public final s a() {
            return new s(super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public final /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    public static final class b extends ProtoAdapter<s> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, s.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final s decode(ProtoReader r8) {
            a r10 = new a();
            long r11 = r8.beginMessage();
        L3:
            int r12 = r8.nextTag();
            if (r12 == (-1)) goto L6;
            FieldEncoding r13 = r8.peekFieldEncoding();
            r10.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r8));
            goto L3
        L6:
            r8.endMessage(r11);
            return r10.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final void encode(ProtoWriter r8, s r10) {
            r8.writeBytes(r10.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final int encodedSize(s r8) {
            return r8.unknownFields().l();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final s redact(s r8) {
            s r10 = r8;
            r10.getClass();
            a r11 = new a();
            r11.addUnknownFields(r10.unknownFields());
            r11.clearUnknownFields();
            return r11.a();
        }
    }

    static {
        f11742a = new b();
    }

    public s() {
        this(jf.g.f8841o);
    }

    public final boolean equals(Object r8) {
        return r8 instanceof s;
    }

    public final int hashCode() {
        return unknownFields().hashCode();
    }

    @Override // com.squareup.wire.Message
    public final Message.Builder newBuilder() {
        a r8 = new a();
        r8.addUnknownFields(unknownFields());
        return r8;
    }

    @Override // com.squareup.wire.Message
    public final String toString() {
        StringBuilder r8 = new StringBuilder().replace(0, 2, "SendApplogEventResponse{");
        r8.append('}');
        return r8.toString();
    }

    public s(jf.g r8) {
        super(f11742a, r8);
    }
}
