package com.ss.android.lark.pb.security_event;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ObjectEntity extends Message<ObjectEntity, Builder> {
    public static final ProtoAdapter<ObjectEntity> ADAPTER = null;
    public static final String DEFAULT_VALUE = "";
    private static final long serialVersionUID = 0;
    public final ObjectDetail mDetail;
    public final EntityType mType;
    public final String mValue;

    public static final class Builder extends Message.Builder<ObjectEntity, Builder> {
        public ObjectDetail mDetail;
        public EntityType mType;
        public String mValue;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ObjectEntity m2183build() {
            EntityType r0 = this.mType;
            if (r0 == null) goto L9;
            if (this.mValue == null) goto L9;
            return new ObjectEntity(this.mType, this.mValue, this.mDetail, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "mType", this.mValue, "mValue"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2183build();
        }

        public Builder Detail(ObjectDetail r1) {
            this.mDetail = r1;
            return this;
        }

        public Builder Type(EntityType r1) {
            this.mType = r1;
            return this;
        }

        public Builder Value(String r1) {
            this.mValue = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ObjectEntity extends ProtoAdapter<ObjectEntity> {
        public ProtoAdapter_ObjectEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, ObjectEntity.class);
        }

        public ObjectEntity decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mValue = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mType = (EntityType) EntityType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mValue = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mDetail = (ObjectDetail) ObjectDetail.ADAPTER.decode(r9);
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m2183build();
        }

        public int encodedSize(ObjectEntity r5) {
            int r0 = EntityType.ADAPTER.encodedSizeWithTag(1, r5.mType) + ProtoAdapter.STRING.encodedSizeWithTag(2, r5.mValue);
            ObjectDetail r1 = r5.mDetail;
            if (r1 == null) goto L5;
            int r2 = ObjectDetail.ADAPTER.encodedSizeWithTag(3, r1);
        L7:
            return (r0 + r2) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2184decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ObjectEntity) r1);
        }

        public void encode(ProtoWriter r4, ObjectEntity r5) throws IOException {
            EntityType.ADAPTER.encodeWithTag(r4, 1, r5.mType);
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r5.mValue);
            ObjectDetail r0 = r5.mDetail;
            if (r0 == null) goto L5;
            ObjectDetail.ADAPTER.encodeWithTag(r4, 3, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ObjectEntity) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ObjectEntity();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2182newBuilder() {
        Builder r0 = new Builder();
        r0.mType = this.mType;
        r0.mValue = this.mValue;
        r0.mDetail = this.mDetail;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ObjectEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2182newBuilder();
    }

    public ObjectEntity(EntityType r2, String r3, ObjectDetail r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public ObjectEntity(EntityType r2, String r3, ObjectDetail r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mType = r2;
        this.mValue = r3;
        this.mDetail = r4;
    }
}
