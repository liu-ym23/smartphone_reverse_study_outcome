package com.ss.android.lark.pb.authorization;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CustomizedEntity extends Message<CustomizedEntity, Builder> {
    public static final ProtoAdapter<CustomizedEntity> ADAPTER = null;
    public static final String DEFAULT_ENTITY_TYPE = "";
    public static final String DEFAULT_ID = "";
    private static final long serialVersionUID = 0;
    public final String mentity_type;
    public final String mid;

    public static final class Builder extends Message.Builder<CustomizedEntity, Builder> {
        public String mentity_type;
        public String mid;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CustomizedEntity m827build() {
            String r0 = this.mid;
            if (r0 == null) goto L9;
            if (this.mentity_type == null) goto L9;
            return new CustomizedEntity(this.mid, this.mentity_type, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "mid", this.mentity_type, "mentity_type"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m827build();
        }

        public Builder entity_type(String r1) {
            this.mentity_type = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomizedEntity extends ProtoAdapter<CustomizedEntity> {
        public ProtoAdapter_CustomizedEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomizedEntity.class);
        }

        public CustomizedEntity decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mentity_type = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mentity_type = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m827build();
        }

        public int encodedSize(CustomizedEntity r5) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            return (r0.encodedSizeWithTag(1, r5.mid) + r0.encodedSizeWithTag(2, r5.mentity_type)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m828decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CustomizedEntity) r1);
        }

        public void encode(ProtoWriter r4, CustomizedEntity r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.mid);
            r0.encodeWithTag(r4, 2, r5.mentity_type);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CustomizedEntity) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CustomizedEntity();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m826newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mentity_type = this.mentity_type;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CustomizedEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m826newBuilder();
    }

    public CustomizedEntity(String r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public CustomizedEntity(String r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mid = r2;
        this.mentity_type = r3;
    }
}
