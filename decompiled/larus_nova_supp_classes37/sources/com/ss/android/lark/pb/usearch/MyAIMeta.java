package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.ss.android.lark.pb.entities.ChatterType;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MyAIMeta extends Message<MyAIMeta, Builder> {
    public static final ProtoAdapter<MyAIMeta> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_P2P_CHAT_ID = "";
    private static final long serialVersionUID = 0;
    public final String mid;
    public final String mp2p_chat_id;
    public final ChatterType mtype;

    public static final class Builder extends Message.Builder<MyAIMeta, Builder> {
        public String mid;
        public String mp2p_chat_id;
        public ChatterType mtype;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MyAIMeta m2729build() {
            return new MyAIMeta(this.mid, this.mtype, this.mp2p_chat_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2729build();
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder p2p_chat_id(String r1) {
            this.mp2p_chat_id = r1;
            return this;
        }

        public Builder type(ChatterType r1) {
            this.mtype = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MyAIMeta extends ProtoAdapter<MyAIMeta> {
        public ProtoAdapter_MyAIMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, MyAIMeta.class);
        }

        public MyAIMeta decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mp2p_chat_id = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mtype = (ChatterType) ChatterType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mp2p_chat_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m2729build();
        }

        public int encodedSize(MyAIMeta r6) {
            String r0 = r6.mid;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            ChatterType r3 = r6.mtype;
            if (r3 == null) goto L9;
            int r4 = ChatterType.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mp2p_chat_id;
            if (r7 == null) goto L14;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            return (r5 + r1) + r6.unknownFields().size();
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2730decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MyAIMeta) r1);
        }

        public void encode(ProtoWriter r4, MyAIMeta r5) throws IOException {
            String r0 = r5.mid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            ChatterType r1 = r5.mtype;
            if (r1 == null) goto L8;
            ChatterType.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mp2p_chat_id;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MyAIMeta) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MyAIMeta();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2728newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mtype = this.mtype;
        r0.mp2p_chat_id = this.mp2p_chat_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MyAIMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2728newBuilder();
    }

    public MyAIMeta(String r2, ChatterType r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public MyAIMeta(String r2, ChatterType r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mid = r2;
        this.mtype = r3;
        this.mp2p_chat_id = r4;
    }
}
