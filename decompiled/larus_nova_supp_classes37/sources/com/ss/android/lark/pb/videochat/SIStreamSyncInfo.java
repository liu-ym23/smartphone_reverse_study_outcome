package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SIStreamSyncInfo extends Message<SIStreamSyncInfo, Builder> {
    public static final ProtoAdapter<SIStreamSyncInfo> ADAPTER = null;
    public static final Boolean DEFAULT_CHANGE_TO_ORIGIN = null;
    public static final Boolean DEFAULT_IS_SCREEN = null;
    public static final Long DEFAULT_SEQ_ID = null;
    public static final Long DEFAULT_SI_DID = null;
    public static final String DEFAULT_SOURCE_LANGUAGE = "";
    private static final long serialVersionUID = 0;
    public final Boolean mchange_to_origin;
    public final ChangeToOriginReason mchange_to_origin_reason;
    public final Boolean mis_screen;
    public final List<SegmentIndex> msegments;
    public final Long mseq_id;
    public final Long msi_did;
    public final String msource_language;

    public static final class Builder extends Message.Builder<SIStreamSyncInfo, Builder> {
        public Boolean mchange_to_origin;
        public ChangeToOriginReason mchange_to_origin_reason;
        public Boolean mis_screen;
        public List<SegmentIndex> msegments;
        public Long mseq_id;
        public Long msi_did;
        public String msource_language;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SIStreamSyncInfo m3179build() {
            return new SIStreamSyncInfo(this.mseq_id, this.msi_did, this.mis_screen, this.msource_language, this.msegments, this.mchange_to_origin, this.mchange_to_origin_reason, super.buildUnknownFields());
        }

        public Builder() {
            this.msegments = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3179build();
        }

        public Builder change_to_origin(Boolean r1) {
            this.mchange_to_origin = r1;
            return this;
        }

        public Builder change_to_origin_reason(ChangeToOriginReason r1) {
            this.mchange_to_origin_reason = r1;
            return this;
        }

        public Builder is_screen(Boolean r1) {
            this.mis_screen = r1;
            return this;
        }

        public Builder segments(List<SegmentIndex> r1) {
            Internal.checkElementsNotNull(r1);
            this.msegments = r1;
            return this;
        }

        public Builder seq_id(Long r1) {
            this.mseq_id = r1;
            return this;
        }

        public Builder si_did(Long r1) {
            this.msi_did = r1;
            return this;
        }

        public Builder source_language(String r1) {
            this.msource_language = r1;
            return this;
        }
    }

    public static final enum ChangeToOriginReason extends Enum<ChangeToOriginReason> implements WireEnum {
        private static final /* synthetic */ ChangeToOriginReason[] $VALUES = null;
        public static final ProtoAdapter<ChangeToOriginReason> ADAPTER = null;
        public static final ChangeToOriginReason SAME_LAN = null;
        public static final ChangeToOriginReason SOURCE_LAN_NOT_SUPPORT = null;
        public static final ChangeToOriginReason UNKNOWN = null;
        private final int value;

        static {
            ChangeToOriginReason r0 = new ChangeToOriginReason("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ChangeToOriginReason r1 = new ChangeToOriginReason("SAME_LAN", 1, 1);
            SAME_LAN = r1;
            ChangeToOriginReason r3 = new ChangeToOriginReason("SOURCE_LAN_NOT_SUPPORT", 2, 2);
            SOURCE_LAN_NOT_SUPPORT = r3;
            $VALUES = new ChangeToOriginReason[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(ChangeToOriginReason.class);
        }

        public static ChangeToOriginReason[] values() {
            return (ChangeToOriginReason[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ChangeToOriginReason fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return SOURCE_LAN_NOT_SUPPORT;
        L12:
            return SAME_LAN;
        L14:
            return UNKNOWN;
        }

        public static ChangeToOriginReason valueOf(String r1) {
            return (ChangeToOriginReason) a.a(ChangeToOriginReason.class, r1);
        }

        private ChangeToOriginReason(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_SIStreamSyncInfo extends ProtoAdapter<SIStreamSyncInfo> {
        public ProtoAdapter_SIStreamSyncInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, SIStreamSyncInfo.class);
        }

        public SIStreamSyncInfo decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mseq_id = 0L;
            r0.msi_did = 0L;
            Boolean r1 = Boolean.FALSE;
            r0.mis_screen = r1;
            r0.msource_language = "";
            r0.mchange_to_origin = r1;
            long r2 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L30;
            if (r3 != 1) goto L8;
            r0.mseq_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.msi_did = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L10:
            if (r3 != 4) goto L12;
            r0.mis_screen = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L12:
            if (r3 != 5) goto L14;
            r0.msource_language = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L14:
            if (r3 != 7) goto L16;
            r0.msegments.add((SegmentIndex) SegmentIndex.ADAPTER.decode(r9));
            goto L3
        L16:
            if (r3 != 8) goto L18;
            r0.mchange_to_origin = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L18:
            if (r3 != 9) goto L19;
            r0.mchange_to_origin_reason = (ChangeToOriginReason) ChangeToOriginReason.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L19:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L30:
            r9.endMessage(r2);
            return r0.m3179build();
        }

        public int encodedSize(SIStreamSyncInfo r6) {
            Long r0 = r6.mseq_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
        L6:
            Long r3 = r6.msi_did;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Boolean r7 = r6.mis_screen;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.msource_language;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(5, r10);
        L18:
            int r12 = (r9 + r11) + SegmentIndex.ADAPTER.asRepeated().encodedSizeWithTag(7, r6.msegments);
            Boolean r13 = r6.mchange_to_origin;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r13);
        L22:
            int r15 = r12 + r14;
            ChangeToOriginReason r16 = r6.mchange_to_origin_reason;
            if (r16 == null) goto L26;
            r1 = ChangeToOriginReason.ADAPTER.encodedSizeWithTag(9, r16);
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
        public /* bridge */ /* synthetic */ Object m3180decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SIStreamSyncInfo) r1);
        }

        public void encode(ProtoWriter r4, SIStreamSyncInfo r5) throws IOException {
            Long r0 = r5.mseq_id;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
        L5:
            Long r1 = r5.msi_did;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
        L8:
            Boolean r2 = r5.mis_screen;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 4, r2);
        L11:
            String r3 = r5.msource_language;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 5, r3);
        L14:
            SegmentIndex.ADAPTER.asRepeated().encodeWithTag(r4, 7, r5.msegments);
            Boolean r6 = r5.mchange_to_origin;
            if (r6 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r4, 8, r6);
        L17:
            ChangeToOriginReason r7 = r5.mchange_to_origin_reason;
            if (r7 == null) goto L20;
            ChangeToOriginReason.ADAPTER.encodeWithTag(r4, 9, r7);
        L20:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SIStreamSyncInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SIStreamSyncInfo();
        DEFAULT_SEQ_ID = 0L;
        DEFAULT_SI_DID = 0L;
        Boolean r0 = Boolean.FALSE;
        DEFAULT_IS_SCREEN = r0;
        DEFAULT_CHANGE_TO_ORIGIN = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3178newBuilder() {
        Builder r0 = new Builder();
        r0.mseq_id = this.mseq_id;
        r0.msi_did = this.msi_did;
        r0.mis_screen = this.mis_screen;
        r0.msource_language = this.msource_language;
        r0.msegments = Internal.copyOf("msegments", this.msegments);
        r0.mchange_to_origin = this.mchange_to_origin;
        r0.mchange_to_origin_reason = this.mchange_to_origin_reason;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SIStreamSyncInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3178newBuilder();
    }

    public SIStreamSyncInfo(Long r10, Long r11, Boolean r12, String r13, List<SegmentIndex> r14, Boolean r15, ChangeToOriginReason r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public SIStreamSyncInfo(Long r2, Long r3, Boolean r4, String r5, List<SegmentIndex> r6, Boolean r7, ChangeToOriginReason r8, ByteString r9) {
        super(ADAPTER, r9);
        this.mseq_id = r2;
        this.msi_did = r3;
        this.mis_screen = r4;
        this.msource_language = r5;
        this.msegments = Internal.immutableCopyOf("msegments", r6);
        this.mchange_to_origin = r7;
        this.mchange_to_origin_reason = r8;
    }
}
