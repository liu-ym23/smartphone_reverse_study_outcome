package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CardActionPacket extends com.squareup.wire.Message<CardActionPacket, Builder> {
    public static final ProtoAdapter<CardActionPacket> ADAPTER = null;
    public static final String DEFAULT_CID = "";
    public static final ByteString DEFAULT_PAYLOAD = null;
    private static final long serialVersionUID = 0;
    public final String mcid;
    public final CardAction.Parameters mparameters;
    public final ByteString mpayload;

    public static final class Builder extends com.squareup.wire.Message.Builder<CardActionPacket, Builder> {
        public String mcid;
        public CardAction.Parameters mparameters;
        public ByteString mpayload;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CardActionPacket m1058build() {
            return new CardActionPacket(this.mcid, this.mparameters, this.mpayload, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1058build();
        }

        public Builder cid(String r1) {
            this.mcid = r1;
            return this;
        }

        public Builder parameters(CardAction.Parameters r1) {
            this.mparameters = r1;
            return this;
        }

        public Builder payload(ByteString r1) {
            this.mpayload = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_CardActionPacket extends ProtoAdapter<CardActionPacket> {
        public ProtoAdapter_CardActionPacket() {
            super(FieldEncoding.LENGTH_DELIMITED, CardActionPacket.class);
        }

        public CardActionPacket decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mcid = "";
            r0.mpayload = ByteString.EMPTY;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mcid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mparameters = (CardAction.Parameters) CardAction.Parameters.ADAPTER.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mpayload = (ByteString) ProtoAdapter.BYTES.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m1058build();
        }

        public int encodedSize(CardActionPacket r6) {
            String r0 = r6.mcid;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            CardAction.Parameters r3 = r6.mparameters;
            if (r3 == null) goto L9;
            int r4 = CardAction.Parameters.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            ByteString r7 = r6.mpayload;
            if (r7 == null) goto L14;
            r1 = ProtoAdapter.BYTES.encodedSizeWithTag(3, r7);
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
        public /* bridge */ /* synthetic */ Object m1059decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CardActionPacket) r1);
        }

        public void encode(ProtoWriter r4, CardActionPacket r5) throws IOException {
            String r0 = r5.mcid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            CardAction.Parameters r1 = r5.mparameters;
            if (r1 == null) goto L8;
            CardAction.Parameters.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            ByteString r2 = r5.mpayload;
            if (r2 == null) goto L11;
            ProtoAdapter.BYTES.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CardActionPacket) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CardActionPacket();
        DEFAULT_PAYLOAD = ByteString.EMPTY;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1057newBuilder() {
        Builder r0 = new Builder();
        r0.mcid = this.mcid;
        r0.mparameters = this.mparameters;
        r0.mpayload = this.mpayload;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CardActionPacket.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1057newBuilder();
    }

    public CardActionPacket(String r2, CardAction.Parameters r3, ByteString r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public CardActionPacket(String r2, CardAction.Parameters r3, ByteString r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mcid = r2;
        this.mparameters = r3;
        this.mpayload = r4;
    }
}
