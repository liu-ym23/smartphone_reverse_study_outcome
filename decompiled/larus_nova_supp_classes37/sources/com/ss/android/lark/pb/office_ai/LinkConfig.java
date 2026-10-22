package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class LinkConfig extends Message<LinkConfig, Builder> {
    public static final ProtoAdapter<LinkConfig> ADAPTER = null;
    public static final String DEFAULT_LINK_ADDR = "";
    private static final long serialVersionUID = 0;
    public final String mlink_addr;
    public final LinkProtocolType mprotocol_type;

    public static final class Builder extends Message.Builder<LinkConfig, Builder> {
        public String mlink_addr;
        public LinkProtocolType mprotocol_type;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public LinkConfig m1964build() {
            return new LinkConfig(this.mprotocol_type, this.mlink_addr, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1964build();
        }

        public Builder link_addr(String r1) {
            this.mlink_addr = r1;
            return this;
        }

        public Builder protocol_type(LinkProtocolType r1) {
            this.mprotocol_type = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_LinkConfig extends ProtoAdapter<LinkConfig> {
        public ProtoAdapter_LinkConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, LinkConfig.class);
        }

        public LinkConfig decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mlink_addr = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mprotocol_type = (LinkProtocolType) LinkProtocolType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mlink_addr = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.m1964build();
        }

        public int encodedSize(LinkConfig r5) {
            LinkProtocolType r0 = r5.mprotocol_type;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = LinkProtocolType.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.mlink_addr;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1965decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((LinkConfig) r1);
        }

        public void encode(ProtoWriter r4, LinkConfig r5) throws IOException {
            LinkProtocolType r0 = r5.mprotocol_type;
            if (r0 == null) goto L5;
            LinkProtocolType.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mlink_addr;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (LinkConfig) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LinkConfig();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1963newBuilder() {
        Builder r0 = new Builder();
        r0.mprotocol_type = this.mprotocol_type;
        r0.mlink_addr = this.mlink_addr;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return LinkConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1963newBuilder();
    }

    public LinkConfig(LinkProtocolType r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public LinkConfig(LinkProtocolType r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mprotocol_type = r2;
        this.mlink_addr = r3;
    }
}
