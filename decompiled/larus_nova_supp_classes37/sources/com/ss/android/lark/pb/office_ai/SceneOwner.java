package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SceneOwner extends Message<SceneOwner, Builder> {
    public static final ProtoAdapter<SceneOwner> ADAPTER = null;
    public static final Long DEFAULT_ID = null;
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final Long mid;
    public final String mname;
    public final SceneOwnerType mtype;

    public static final class Builder extends Message.Builder<SceneOwner, Builder> {
        public Long mid;
        public String mname;
        public SceneOwnerType mtype;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SceneOwner m2018build() {
            return new SceneOwner(this.mtype, this.mid, this.mname, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2018build();
        }

        public Builder id(Long r1) {
            this.mid = r1;
            return this;
        }

        public Builder name(String r1) {
            this.mname = r1;
            return this;
        }

        public Builder type(SceneOwnerType r1) {
            this.mtype = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SceneOwner extends ProtoAdapter<SceneOwner> {
        public ProtoAdapter_SceneOwner() {
            super(FieldEncoding.LENGTH_DELIMITED, SceneOwner.class);
        }

        public SceneOwner decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mid = 0L;
            r0.mname = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mtype = (SceneOwnerType) SceneOwnerType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mid = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mname = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m2018build();
        }

        public int encodedSize(SceneOwner r6) {
            SceneOwnerType r0 = r6.mtype;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = SceneOwnerType.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            Long r3 = r6.mid;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mname;
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
        public /* bridge */ /* synthetic */ Object m2019decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SceneOwner) r1);
        }

        public void encode(ProtoWriter r4, SceneOwner r5) throws IOException {
            SceneOwnerType r0 = r5.mtype;
            if (r0 == null) goto L5;
            SceneOwnerType.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            Long r1 = r5.mid;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mname;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SceneOwner) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SceneOwner();
        DEFAULT_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2017newBuilder() {
        Builder r0 = new Builder();
        r0.mtype = this.mtype;
        r0.mid = this.mid;
        r0.mname = this.mname;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SceneOwner.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2017newBuilder();
    }

    public SceneOwner(SceneOwnerType r2, Long r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public SceneOwner(SceneOwnerType r2, Long r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mtype = r2;
        this.mid = r3;
        this.mname = r4;
    }
}
