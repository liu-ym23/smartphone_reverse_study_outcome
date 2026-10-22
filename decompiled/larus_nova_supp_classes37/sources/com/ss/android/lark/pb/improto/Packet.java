package com.ss.android.lark.pb.improto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class Packet extends Message<Packet, Builder> {
    public static final ProtoAdapter<Packet> ADAPTER = null;
    public static final String DEFAULT_CID = "";
    public static final Integer DEFAULT_COMMAND = null;
    public static final Long DEFAULT_CURSOR = null;
    public static final ByteString DEFAULT_PAYLOAD = null;
    public static final String DEFAULT_SID = "";
    public static final Integer DEFAULT_STATUS = null;
    public static final Integer DEFAULT_WAIT_RETRY_INTERVAL = null;
    private static final long serialVersionUID = 0;
    public final String mcid;
    public final Command mcmd;
    public final Integer mcommand;
    public final List<Long> mcompacted_sids;
    public final Long mcursor;
    public final ByteString mpayload;
    public final PayloadType mpayload_type;
    public final List<PipeEntity> mpipe_entities;
    public final PipeEntity mpipe_entity;
    public final String msid;
    public final Integer mstatus;
    public final List<VersionPayload> mversion_payloads;
    public final Integer mwait_retry_interval;

    public static final class Builder extends Message.Builder<Packet, Builder> {
        public String mcid;
        public Command mcmd;
        public Integer mcommand;
        public List<Long> mcompacted_sids;
        public Long mcursor;
        public ByteString mpayload;
        public PayloadType mpayload_type;
        public List<PipeEntity> mpipe_entities;
        public PipeEntity mpipe_entity;
        public String msid;
        public Integer mstatus;
        public List<VersionPayload> mversion_payloads;
        public Integer mwait_retry_interval;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Packet m1754build() {
            PayloadType r1 = this.mpayload_type;
            if (r1 == null) goto L9;
            if (this.mcmd == null) goto L9;
            return new Packet(this.msid, this.mpayload_type, this.mcmd, this.mstatus, this.mpayload, this.mcid, this.mpipe_entity, this.mversion_payloads, this.mpipe_entities, this.mwait_retry_interval, this.mcommand, this.mcursor, this.mcompacted_sids, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r1, "mpayload_type", this.mcmd, "mcmd"});
        }

        public Builder() {
            this.mversion_payloads = Internal.newMutableList();
            this.mpipe_entities = Internal.newMutableList();
            this.mcompacted_sids = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1754build();
        }

        public Builder cid(String r1) {
            this.mcid = r1;
            return this;
        }

        public Builder cmd(Command r1) {
            this.mcmd = r1;
            return this;
        }

        public Builder command(Integer r1) {
            this.mcommand = r1;
            return this;
        }

        public Builder compacted_sids(List<Long> r1) {
            Internal.checkElementsNotNull(r1);
            this.mcompacted_sids = r1;
            return this;
        }

        public Builder cursor(Long r1) {
            this.mcursor = r1;
            return this;
        }

        public Builder payload(ByteString r1) {
            this.mpayload = r1;
            return this;
        }

        public Builder payload_type(PayloadType r1) {
            this.mpayload_type = r1;
            return this;
        }

        public Builder pipe_entities(List<PipeEntity> r1) {
            Internal.checkElementsNotNull(r1);
            this.mpipe_entities = r1;
            return this;
        }

        public Builder pipe_entity(PipeEntity r1) {
            this.mpipe_entity = r1;
            return this;
        }

        public Builder sid(String r1) {
            this.msid = r1;
            return this;
        }

        public Builder status(Integer r1) {
            this.mstatus = r1;
            return this;
        }

        public Builder version_payloads(List<VersionPayload> r1) {
            Internal.checkElementsNotNull(r1);
            this.mversion_payloads = r1;
            return this;
        }

        public Builder wait_retry_interval(Integer r1) {
            this.mwait_retry_interval = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_Packet extends ProtoAdapter<Packet> {
        public ProtoAdapter_Packet() {
            super(FieldEncoding.LENGTH_DELIMITED, Packet.class);
        }

        public Packet decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.msid = "";
            r0.mstatus = 200;
            r0.mpayload = ByteString.EMPTY;
            r0.mcid = "";
            r0.mwait_retry_interval = 0;
            r0.mcommand = 0;
            r0.mcursor = 0L;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L26;
            switch(r3) {
                case 1: goto L25;
                case 2: goto L28;
                case 3: goto L30;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L6;
            };
        L28:
            r0.mpayload_type = (PayloadType) PayloadType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L30:
            r0.mcmd = (Command) Command.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mcompacted_sids.add((Long) ProtoAdapter.INT64.decode(r9));
            goto L3
        L8:
            r0.mcursor = (Long) ProtoAdapter.UINT64.decode(r9);
            goto L3
        L9:
            r0.mcommand = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L10:
            r0.mwait_retry_interval = (Integer) ProtoAdapter.UINT32.decode(r9);
            goto L3
        L11:
            r0.mpipe_entities.add((PipeEntity) PipeEntity.ADAPTER.decode(r9));
            goto L3
        L12:
            r0.mversion_payloads.add((VersionPayload) VersionPayload.ADAPTER.decode(r9));
            goto L3
        L13:
            r0.mpipe_entity = (PipeEntity) PipeEntity.ADAPTER.decode(r9);
            goto L3
        L14:
            r0.mcid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L15:
            r0.mpayload = (ByteString) ProtoAdapter.BYTES.decode(r9);
            goto L3
        L16:
            r0.mstatus = (Integer) ProtoAdapter.UINT32.decode(r9);
            goto L3
        L25:
            r0.msid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L26:
            r9.endMessage(r1);
            return r0.m1754build();
        }

        public int encodedSize(Packet r6) {
            String r0 = r6.msid;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            int r3 = (r2 + PayloadType.ADAPTER.encodedSizeWithTag(2, r6.mpayload_type)) + Command.ADAPTER.encodedSizeWithTag(3, r6.mcmd);
            Integer r4 = r6.mstatus;
            if (r4 == null) goto L9;
            int r5 = ProtoAdapter.UINT32.encodedSizeWithTag(4, r4);
        L10:
            int r7 = r3 + r5;
            ByteString r8 = r6.mpayload;
            if (r8 == null) goto L13;
            int r9 = ProtoAdapter.BYTES.encodedSizeWithTag(5, r8);
        L14:
            int r10 = r7 + r9;
            String r11 = r6.mcid;
            if (r11 == null) goto L17;
            int r12 = ProtoAdapter.STRING.encodedSizeWithTag(6, r11);
        L18:
            int r13 = r10 + r12;
            PipeEntity r14 = r6.mpipe_entity;
            if (r14 == null) goto L21;
            int r15 = PipeEntity.ADAPTER.encodedSizeWithTag(7, r14);
        L22:
            int r16 = ((r13 + r15) + VersionPayload.ADAPTER.asRepeated().encodedSizeWithTag(8, r6.mversion_payloads)) + PipeEntity.ADAPTER.asRepeated().encodedSizeWithTag(9, r6.mpipe_entities);
            Integer r17 = r6.mwait_retry_interval;
            if (r17 == null) goto L25;
            int r18 = ProtoAdapter.UINT32.encodedSizeWithTag(10, r17);
        L26:
            int r19 = r16 + r18;
            Integer r20 = r6.mcommand;
            if (r20 == null) goto L29;
            int r21 = ProtoAdapter.INT32.encodedSizeWithTag(11, r20);
        L30:
            int r22 = r19 + r21;
            Long r23 = r6.mcursor;
            if (r23 == null) goto L34;
            r1 = ProtoAdapter.UINT64.encodedSizeWithTag(12, r23);
        L34:
            return ((r22 + r1) + ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(13, r6.mcompacted_sids)) + r6.unknownFields().size();
        L29:
            r21 = 0;
            goto L30
        L25:
            r18 = 0;
            goto L26
        L21:
            r15 = 0;
            goto L22
        L17:
            r12 = 0;
            goto L18
        L13:
            r9 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1755decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Packet) r1);
        }

        public void encode(ProtoWriter r4, Packet r5) throws IOException {
            String r0 = r5.msid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            PayloadType.ADAPTER.encodeWithTag(r4, 2, r5.mpayload_type);
            Command.ADAPTER.encodeWithTag(r4, 3, r5.mcmd);
            Integer r1 = r5.mstatus;
            if (r1 == null) goto L8;
            ProtoAdapter.UINT32.encodeWithTag(r4, 4, r1);
        L8:
            ByteString r2 = r5.mpayload;
            if (r2 == null) goto L11;
            ProtoAdapter.BYTES.encodeWithTag(r4, 5, r2);
        L11:
            String r3 = r5.mcid;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r3);
        L14:
            PipeEntity r6 = r5.mpipe_entity;
            if (r6 == null) goto L17;
            PipeEntity.ADAPTER.encodeWithTag(r4, 7, r6);
        L17:
            VersionPayload.ADAPTER.asRepeated().encodeWithTag(r4, 8, r5.mversion_payloads);
            PipeEntity.ADAPTER.asRepeated().encodeWithTag(r4, 9, r5.mpipe_entities);
            Integer r7 = r5.mwait_retry_interval;
            if (r7 == null) goto L20;
            ProtoAdapter.UINT32.encodeWithTag(r4, 10, r7);
        L20:
            Integer r8 = r5.mcommand;
            if (r8 == null) goto L23;
            ProtoAdapter.INT32.encodeWithTag(r4, 11, r8);
        L23:
            Long r9 = r5.mcursor;
            if (r9 == null) goto L26;
            ProtoAdapter.UINT64.encodeWithTag(r4, 12, r9);
        L26:
            ProtoAdapter.INT64.asRepeated().encodeWithTag(r4, 13, r5.mcompacted_sids);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Packet) r2);
        }
    }

    public static final class VersionPayload extends Message<VersionPayload, Builder> {
        public static final ProtoAdapter<VersionPayload> ADAPTER = null;
        public static final ByteString DEFAULT_PAYLOAD = null;
        private static final long serialVersionUID = 0;
        public final ByteString mpayload;
        public final VersionRange mversion_range;

        public static final class Builder extends Message.Builder<VersionPayload, Builder> {
            public ByteString mpayload;
            public VersionRange mversion_range;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public VersionPayload m1757build() {
                VersionRange r0 = this.mversion_range;
                if (r0 == null) goto L9;
                if (this.mpayload == null) goto L9;
                return new VersionPayload(this.mversion_range, this.mpayload, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r0, "mversion_range", this.mpayload, "mpayload"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m1757build();
            }

            public Builder payload(ByteString r1) {
                this.mpayload = r1;
                return this;
            }

            public Builder version_range(VersionRange r1) {
                this.mversion_range = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_VersionPayload extends ProtoAdapter<VersionPayload> {
            public ProtoAdapter_VersionPayload() {
                super(FieldEncoding.LENGTH_DELIMITED, VersionPayload.class);
            }

            public VersionPayload decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mpayload = ByteString.EMPTY;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mversion_range = (VersionRange) VersionRange.ADAPTER.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mpayload = (ByteString) ProtoAdapter.BYTES.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m1757build();
            }

            public int encodedSize(VersionPayload r5) {
                return (VersionRange.ADAPTER.encodedSizeWithTag(1, r5.mversion_range) + ProtoAdapter.BYTES.encodedSizeWithTag(2, r5.mpayload)) + r5.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1758decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((VersionPayload) r1);
            }

            public void encode(ProtoWriter r4, VersionPayload r5) throws IOException {
                VersionRange.ADAPTER.encodeWithTag(r4, 1, r5.mversion_range);
                ProtoAdapter.BYTES.encodeWithTag(r4, 2, r5.mpayload);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (VersionPayload) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_VersionPayload();
            DEFAULT_PAYLOAD = ByteString.EMPTY;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1756newBuilder() {
            Builder r0 = new Builder();
            r0.mversion_range = this.mversion_range;
            r0.mpayload = this.mpayload;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return VersionPayload.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m1756newBuilder();
        }

        public VersionPayload(VersionRange r2, ByteString r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public VersionPayload(VersionRange r2, ByteString r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mversion_range = r2;
            this.mpayload = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Packet();
        DEFAULT_STATUS = 200;
        DEFAULT_PAYLOAD = ByteString.EMPTY;
        DEFAULT_WAIT_RETRY_INTERVAL = 0;
        DEFAULT_COMMAND = 0;
        DEFAULT_CURSOR = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1753newBuilder() {
        Builder r0 = new Builder();
        r0.msid = this.msid;
        r0.mpayload_type = this.mpayload_type;
        r0.mcmd = this.mcmd;
        r0.mstatus = this.mstatus;
        r0.mpayload = this.mpayload;
        r0.mcid = this.mcid;
        r0.mpipe_entity = this.mpipe_entity;
        r0.mversion_payloads = Internal.copyOf("mversion_payloads", this.mversion_payloads);
        r0.mpipe_entities = Internal.copyOf("mpipe_entities", this.mpipe_entities);
        r0.mwait_retry_interval = this.mwait_retry_interval;
        r0.mcommand = this.mcommand;
        r0.mcursor = this.mcursor;
        r0.mcompacted_sids = Internal.copyOf("mcompacted_sids", this.mcompacted_sids);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return Packet.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1753newBuilder();
    }

    public Packet(String r16, PayloadType r17, Command r18, Integer r19, ByteString r20, String r21, PipeEntity r22, List<VersionPayload> r23, List<PipeEntity> r24, Integer r25, Integer r26, Long r27, List<Long> r28) {
        this(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, ByteString.EMPTY);
    }

    public Packet(String r2, PayloadType r3, Command r4, Integer r5, ByteString r6, String r7, PipeEntity r8, List<VersionPayload> r9, List<PipeEntity> r10, Integer r11, Integer r12, Long r13, List<Long> r14, ByteString r15) {
        super(ADAPTER, r15);
        this.msid = r2;
        this.mpayload_type = r3;
        this.mcmd = r4;
        this.mstatus = r5;
        this.mpayload = r6;
        this.mcid = r7;
        this.mpipe_entity = r8;
        this.mversion_payloads = Internal.immutableCopyOf("mversion_payloads", r9);
        this.mpipe_entities = Internal.immutableCopyOf("mpipe_entities", r10);
        this.mwait_retry_interval = r11;
        this.mcommand = r12;
        this.mcursor = r13;
        this.mcompacted_sids = Internal.immutableCopyOf("mcompacted_sids", r14);
    }
}
