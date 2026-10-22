package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CustomSummaryKeypoint extends Message<CustomSummaryKeypoint, Builder> {
    public static final ProtoAdapter<CustomSummaryKeypoint> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    private static final long serialVersionUID = 0;
    public final String mcontent;

    public static final class Builder extends Message.Builder<CustomSummaryKeypoint, Builder> {
        public String mcontent;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CustomSummaryKeypoint m3254build() {
            return new CustomSummaryKeypoint(this.mcontent, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3254build();
        }

        public Builder content(String r1) {
            this.mcontent = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomSummaryKeypoint extends ProtoAdapter<CustomSummaryKeypoint> {
        public ProtoAdapter_CustomSummaryKeypoint() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomSummaryKeypoint.class);
        }

        public CustomSummaryKeypoint decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mcontent = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mcontent = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m3254build();
        }

        public int encodedSize(CustomSummaryKeypoint r4) {
            String r0 = r4.mcontent;
            if (r0 == null) goto L5;
            int r1 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L7:
            return r1 + r4.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3255decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CustomSummaryKeypoint) r1);
        }

        public void encode(ProtoWriter r4, CustomSummaryKeypoint r5) throws IOException {
            String r0 = r5.mcontent;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CustomSummaryKeypoint) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CustomSummaryKeypoint();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3253newBuilder() {
        Builder r0 = new Builder();
        r0.mcontent = this.mcontent;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CustomSummaryKeypoint.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3253newBuilder();
    }

    public CustomSummaryKeypoint(String r2) {
        this(r2, ByteString.EMPTY);
    }

    public CustomSummaryKeypoint(String r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mcontent = r2;
    }
}
