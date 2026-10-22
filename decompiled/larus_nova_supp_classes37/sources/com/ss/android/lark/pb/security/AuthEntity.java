package com.ss.android.lark.pb.security;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class AuthEntity extends Message<AuthEntity, Builder> {
    public static final ProtoAdapter<AuthEntity> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final EntityType mentity_type;

    public static final class Builder extends Message.Builder<AuthEntity, Builder> {
        public EntityType mentity_type;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public AuthEntity m2153build() {
            return new AuthEntity(this.mentity_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2153build();
        }

        public Builder entity_type(EntityType r1) {
            this.mentity_type = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_AuthEntity extends ProtoAdapter<AuthEntity> {
        public ProtoAdapter_AuthEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, AuthEntity.class);
        }

        public AuthEntity decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L7;
            r0.mentity_type = (EntityType) EntityType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L12:
            r9.endMessage(r1);
            return r0.m2153build();
        }

        public int encodedSize(AuthEntity r4) {
            EntityType r0 = r4.mentity_type;
            if (r0 == null) goto L5;
            int r1 = EntityType.ADAPTER.encodedSizeWithTag(1, r0);
        L7:
            return r1 + r4.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2154decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((AuthEntity) r1);
        }

        public void encode(ProtoWriter r4, AuthEntity r5) throws IOException {
            EntityType r0 = r5.mentity_type;
            if (r0 == null) goto L5;
            EntityType.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (AuthEntity) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AuthEntity();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2152newBuilder() {
        Builder r0 = new Builder();
        r0.mentity_type = this.mentity_type;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return AuthEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2152newBuilder();
    }

    public AuthEntity(EntityType r2) {
        this(r2, ByteString.EMPTY);
    }

    public AuthEntity(EntityType r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mentity_type = r2;
    }
}
