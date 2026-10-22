package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class Bandwidth extends Message<Bandwidth, Builder> {
    public static final ProtoAdapter<Bandwidth> ADAPTER = null;
    public static final Boolean DEFAULT_BANDWIDTH_STATUS = null;
    public static final Long DEFAULT_DESKTOP_DOWNSTREAM_BANDWIDTH = null;
    public static final Long DEFAULT_DESKTOP_UPSTREAM_BANDWIDTH = null;
    public static final Long DEFAULT_MOBILE_DOWNSTREAM_BANDWIDTH = null;
    public static final Long DEFAULT_MOBILE_UPSTREAM_BANDWIDTH = null;
    public static final Long DEFAULT_WEB_DOWNSTREAM_BANDWIDTH = null;
    public static final Long DEFAULT_WEB_UPSTREAM_BANDWIDTH = null;
    private static final long serialVersionUID = 0;
    public final Boolean mbandwidth_status;
    public final Long mdesktop_downstream_bandwidth;
    public final Long mdesktop_upstream_bandwidth;
    public final Long mmobile_downstream_bandwidth;
    public final Long mmobile_upstream_bandwidth;
    public final Long mweb_downstream_bandwidth;
    public final Long mweb_upstream_bandwidth;

    public static final class Builder extends Message.Builder<Bandwidth, Builder> {
        public Boolean mbandwidth_status;
        public Long mdesktop_downstream_bandwidth;
        public Long mdesktop_upstream_bandwidth;
        public Long mmobile_downstream_bandwidth;
        public Long mmobile_upstream_bandwidth;
        public Long mweb_downstream_bandwidth;
        public Long mweb_upstream_bandwidth;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Bandwidth m3098build() {
            return new Bandwidth(this.mbandwidth_status, this.mweb_upstream_bandwidth, this.mweb_downstream_bandwidth, this.mmobile_upstream_bandwidth, this.mmobile_downstream_bandwidth, this.mdesktop_upstream_bandwidth, this.mdesktop_downstream_bandwidth, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3098build();
        }

        public Builder bandwidth_status(Boolean r1) {
            this.mbandwidth_status = r1;
            return this;
        }

        public Builder desktop_downstream_bandwidth(Long r1) {
            this.mdesktop_downstream_bandwidth = r1;
            return this;
        }

        public Builder desktop_upstream_bandwidth(Long r1) {
            this.mdesktop_upstream_bandwidth = r1;
            return this;
        }

        public Builder mobile_downstream_bandwidth(Long r1) {
            this.mmobile_downstream_bandwidth = r1;
            return this;
        }

        public Builder mobile_upstream_bandwidth(Long r1) {
            this.mmobile_upstream_bandwidth = r1;
            return this;
        }

        public Builder web_downstream_bandwidth(Long r1) {
            this.mweb_downstream_bandwidth = r1;
            return this;
        }

        public Builder web_upstream_bandwidth(Long r1) {
            this.mweb_upstream_bandwidth = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_Bandwidth extends ProtoAdapter<Bandwidth> {
        public ProtoAdapter_Bandwidth() {
            super(FieldEncoding.LENGTH_DELIMITED, Bandwidth.class);
        }

        public Bandwidth decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mbandwidth_status = Boolean.FALSE;
            r0.mweb_upstream_bandwidth = 0L;
            r0.mweb_downstream_bandwidth = 0L;
            r0.mmobile_upstream_bandwidth = 0L;
            r0.mmobile_downstream_bandwidth = 0L;
            r0.mdesktop_upstream_bandwidth = 0L;
            r0.mdesktop_downstream_bandwidth = 0L;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L14;
            switch(r3) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r0.mdesktop_downstream_bandwidth = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            r0.mdesktop_upstream_bandwidth = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L9:
            r0.mmobile_downstream_bandwidth = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L10:
            r0.mmobile_upstream_bandwidth = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L11:
            r0.mweb_downstream_bandwidth = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L12:
            r0.mweb_upstream_bandwidth = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L13:
            r0.mbandwidth_status = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L14:
            r7.endMessage(r1);
            return r0.m3098build();
        }

        public int encodedSize(Bandwidth r6) {
            Boolean r0 = r6.mbandwidth_status;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
        L6:
            Long r3 = r6.mweb_upstream_bandwidth;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Long r7 = r6.mweb_downstream_bandwidth;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.INT64.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            Long r10 = r6.mmobile_upstream_bandwidth;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.INT64.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            Long r13 = r6.mmobile_downstream_bandwidth;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.INT64.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            Long r16 = r6.mdesktop_upstream_bandwidth;
            if (r16 == null) goto L25;
            int r17 = ProtoAdapter.INT64.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            Long r19 = r6.mdesktop_downstream_bandwidth;
            if (r19 == null) goto L30;
            r1 = ProtoAdapter.INT64.encodedSizeWithTag(7, r19);
        L30:
            return (r18 + r1) + r6.unknownFields().size();
        L25:
            r17 = 0;
            goto L26
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
        public /* bridge */ /* synthetic */ Object m3099decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Bandwidth) r1);
        }

        public void encode(ProtoWriter r4, Bandwidth r5) throws IOException {
            Boolean r0 = r5.mbandwidth_status;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
        L5:
            Long r1 = r5.mweb_upstream_bandwidth;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
        L8:
            Long r2 = r5.mweb_downstream_bandwidth;
            if (r2 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r4, 3, r2);
        L11:
            Long r3 = r5.mmobile_upstream_bandwidth;
            if (r3 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r4, 4, r3);
        L14:
            Long r6 = r5.mmobile_downstream_bandwidth;
            if (r6 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r4, 5, r6);
        L17:
            Long r7 = r5.mdesktop_upstream_bandwidth;
            if (r7 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r4, 6, r7);
        L20:
            Long r8 = r5.mdesktop_downstream_bandwidth;
            if (r8 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r4, 7, r8);
        L23:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Bandwidth) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Bandwidth();
        DEFAULT_BANDWIDTH_STATUS = Boolean.FALSE;
        DEFAULT_WEB_UPSTREAM_BANDWIDTH = 0L;
        DEFAULT_WEB_DOWNSTREAM_BANDWIDTH = 0L;
        DEFAULT_MOBILE_UPSTREAM_BANDWIDTH = 0L;
        DEFAULT_MOBILE_DOWNSTREAM_BANDWIDTH = 0L;
        DEFAULT_DESKTOP_UPSTREAM_BANDWIDTH = 0L;
        DEFAULT_DESKTOP_DOWNSTREAM_BANDWIDTH = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3097newBuilder() {
        Builder r0 = new Builder();
        r0.mbandwidth_status = this.mbandwidth_status;
        r0.mweb_upstream_bandwidth = this.mweb_upstream_bandwidth;
        r0.mweb_downstream_bandwidth = this.mweb_downstream_bandwidth;
        r0.mmobile_upstream_bandwidth = this.mmobile_upstream_bandwidth;
        r0.mmobile_downstream_bandwidth = this.mmobile_downstream_bandwidth;
        r0.mdesktop_upstream_bandwidth = this.mdesktop_upstream_bandwidth;
        r0.mdesktop_downstream_bandwidth = this.mdesktop_downstream_bandwidth;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return Bandwidth.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3097newBuilder();
    }

    public Bandwidth(Boolean r10, Long r11, Long r12, Long r13, Long r14, Long r15, Long r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public Bandwidth(Boolean r2, Long r3, Long r4, Long r5, Long r6, Long r7, Long r8, ByteString r9) {
        super(ADAPTER, r9);
        this.mbandwidth_status = r2;
        this.mweb_upstream_bandwidth = r3;
        this.mweb_downstream_bandwidth = r4;
        this.mmobile_upstream_bandwidth = r5;
        this.mmobile_downstream_bandwidth = r6;
        this.mdesktop_upstream_bandwidth = r7;
        this.mdesktop_downstream_bandwidth = r8;
    }
}
