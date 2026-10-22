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
public final class Entity extends Message<Entity, Builder> {
    public static final ProtoAdapter<Entity> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    private static final long serialVersionUID = 0;
    public final EntityType mentity_type;
    public final String mid;

    public static final class Builder extends Message.Builder<Entity, Builder> {
        public EntityType mentity_type;
        public String mid;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Entity m833build() {
            String r0 = this.mid;
            if (r0 == null) goto L9;
            if (this.mentity_type == null) goto L9;
            return new Entity(this.mid, this.mentity_type, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "mid", this.mentity_type, "mentity_type"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m833build();
        }

        public Builder entity_type(EntityType r1) {
            this.mentity_type = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_Entity extends ProtoAdapter<Entity> {
        public ProtoAdapter_Entity() {
            super(FieldEncoding.LENGTH_DELIMITED, Entity.class);
        }

        public Entity decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mentity_type = (EntityType) EntityType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.m833build();
        }

        public int encodedSize(Entity r5) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r5.mid) + EntityType.ADAPTER.encodedSizeWithTag(2, r5.mentity_type)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m834decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Entity) r1);
        }

        public void encode(ProtoWriter r4, Entity r5) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.mid);
            EntityType.ADAPTER.encodeWithTag(r4, 2, r5.mentity_type);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Entity) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Entity();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m832newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mentity_type = this.mentity_type;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return Entity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m832newBuilder();
    }

    public Entity(String r2, EntityType r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public Entity(String r2, EntityType r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mid = r2;
        this.mentity_type = r3;
    }
}
