package com.ss.android.lark.pb.improto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PipeEntity extends Message<PipeEntity, Builder> {
    public static final ProtoAdapter<PipeEntity> ADAPTER = null;
    public static final Long DEFAULT_ID = null;
    public static final String DEFAULT_TYPE = "";
    private static final long serialVersionUID = 0;
    public final Long mid;
    public final String mtype;

    public static final class Builder extends Message.Builder<PipeEntity, Builder> {
        public Long mid;
        public String mtype;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PipeEntity m1760build() {
            String r0 = this.mtype;
            if (r0 == null) goto L7;
            return new PipeEntity(this.mtype, this.mid, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mtype"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1760build();
        }

        public Builder id(Long r1) {
            this.mid = r1;
            return this;
        }

        public Builder type(String r1) {
            this.mtype = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PipeEntity extends ProtoAdapter<PipeEntity> {
        public ProtoAdapter_PipeEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, PipeEntity.class);
        }

        public PipeEntity decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mtype = "";
            r0.mid = 0L;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mtype = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 3) goto L9;
            r0.mid = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m1760build();
        }

        public int encodedSize(PipeEntity r5) {
            int r0 = ProtoAdapter.STRING.encodedSizeWithTag(1, r5.mtype);
            Long r1 = r5.mid;
            if (r1 == null) goto L5;
            int r2 = ProtoAdapter.INT64.encodedSizeWithTag(3, r1);
        L7:
            return (r0 + r2) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1761decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PipeEntity) r1);
        }

        public void encode(ProtoWriter r4, PipeEntity r5) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.mtype);
            Long r0 = r5.mid;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 3, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PipeEntity) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PipeEntity();
        DEFAULT_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1759newBuilder() {
        Builder r0 = new Builder();
        r0.mtype = this.mtype;
        r0.mid = this.mid;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PipeEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1759newBuilder();
    }

    public PipeEntity(String r2, Long r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public PipeEntity(String r2, Long r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mtype = r2;
        this.mid = r3;
    }
}
