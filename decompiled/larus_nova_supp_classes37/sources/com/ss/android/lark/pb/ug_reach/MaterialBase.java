package com.ss.android.lark.pb.ug_reach;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MaterialBase extends Message<MaterialBase, Builder> {
    public static final ProtoAdapter<MaterialBase> ADAPTER = null;
    public static final String DEFAULT_AB_VERSION = "";
    public static final Long DEFAULT_ID = null;
    public static final String DEFAULT_KEY = "";
    public static final Long DEFAULT_TASK_ID = null;
    public static final Integer DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final String mab_version;
    public final ConsumeType mconsume_type;
    public final Long mid;
    public final String mkey;
    public final Long mtask_id;
    public final Integer mversion;

    public static final class Builder extends Message.Builder<MaterialBase, Builder> {
        public String mab_version;
        public ConsumeType mconsume_type;
        public Long mid;
        public String mkey;
        public Long mtask_id;
        public Integer mversion;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MaterialBase m2447build() {
            return new MaterialBase(this.mkey, this.mid, this.mversion, this.mab_version, this.mtask_id, this.mconsume_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2447build();
        }

        public Builder ab_version(String r1) {
            this.mab_version = r1;
            return this;
        }

        public Builder consume_type(ConsumeType r1) {
            this.mconsume_type = r1;
            return this;
        }

        public Builder id(Long r1) {
            this.mid = r1;
            return this;
        }

        public Builder key(String r1) {
            this.mkey = r1;
            return this;
        }

        public Builder task_id(Long r1) {
            this.mtask_id = r1;
            return this;
        }

        public Builder version(Integer r1) {
            this.mversion = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MaterialBase extends ProtoAdapter<MaterialBase> {
        public ProtoAdapter_MaterialBase() {
            super(FieldEncoding.LENGTH_DELIMITED, MaterialBase.class);
        }

        public MaterialBase decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mkey = "";
            r0.mid = 0L;
            r0.mversion = 0;
            r0.mab_version = "";
            r0.mtask_id = 0L;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L16;
            switch(r3) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L18;
                default: goto L6;
            };
        L18:
            r0.mconsume_type = (ConsumeType) ConsumeType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r0.mtask_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L12:
            r0.mab_version = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L13:
            r0.mversion = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L14:
            r0.mid = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L15:
            r0.mkey = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L16:
            r9.endMessage(r1);
            return r0.m2447build();
        }

        public int encodedSize(MaterialBase r6) {
            String r0 = r6.mkey;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            Long r3 = r6.mid;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Integer r7 = r6.mversion;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.INT32.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.mab_version;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            Long r13 = r6.mtask_id;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.INT64.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            ConsumeType r16 = r6.mconsume_type;
            if (r16 == null) goto L26;
            r1 = ConsumeType.ADAPTER.encodedSizeWithTag(6, r16);
        L26:
            return (r15 + r1) + r6.unknownFields().size();
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2448decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MaterialBase) r1);
        }

        public void encode(ProtoWriter r4, MaterialBase r5) throws IOException {
            String r0 = r5.mkey;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            Long r1 = r5.mid;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
        L8:
            Integer r2 = r5.mversion;
            if (r2 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.mab_version;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            Long r6 = r5.mtask_id;
            if (r6 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r4, 5, r6);
        L17:
            ConsumeType r7 = r5.mconsume_type;
            if (r7 == null) goto L20;
            ConsumeType.ADAPTER.encodeWithTag(r4, 6, r7);
        L20:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MaterialBase) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MaterialBase();
        DEFAULT_ID = 0L;
        DEFAULT_VERSION = 0;
        DEFAULT_TASK_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2446newBuilder() {
        Builder r0 = new Builder();
        r0.mkey = this.mkey;
        r0.mid = this.mid;
        r0.mversion = this.mversion;
        r0.mab_version = this.mab_version;
        r0.mtask_id = this.mtask_id;
        r0.mconsume_type = this.mconsume_type;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MaterialBase.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2446newBuilder();
    }

    public MaterialBase(String r9, Long r10, Integer r11, String r12, Long r13, ConsumeType r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public MaterialBase(String r2, Long r3, Integer r4, String r5, Long r6, ConsumeType r7, ByteString r8) {
        super(ADAPTER, r8);
        this.mkey = r2;
        this.mid = r3;
        this.mversion = r4;
        this.mab_version = r5;
        this.mtask_id = r6;
        this.mconsume_type = r7;
    }
}
