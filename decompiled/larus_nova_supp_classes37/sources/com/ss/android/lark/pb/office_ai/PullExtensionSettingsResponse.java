package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.ss.android.lark.pb.entities.ExtensionMode;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullExtensionSettingsResponse extends Message<PullExtensionSettingsResponse, Builder> {
    public static final ProtoAdapter<PullExtensionSettingsResponse> ADAPTER = null;
    public static final Long DEFAULT_MAX_NUM = null;
    public static final Long DEFAULT_MIN_NUM = null;
    public static final Boolean DEFAULT_SHOW_NOTICE = null;
    private static final long serialVersionUID = 0;
    public final Long mmax_num;
    public final Long mmin_num;
    public final ExtensionMode mmode;
    public final Boolean mshow_notice;

    public static final class Builder extends Message.Builder<PullExtensionSettingsResponse, Builder> {
        public Long mmax_num;
        public Long mmin_num;
        public ExtensionMode mmode;
        public Boolean mshow_notice;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullExtensionSettingsResponse m1985build() {
            return new PullExtensionSettingsResponse(this.mmax_num, this.mmin_num, this.mmode, this.mshow_notice, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1985build();
        }

        public Builder max_num(Long r1) {
            this.mmax_num = r1;
            return this;
        }

        public Builder min_num(Long r1) {
            this.mmin_num = r1;
            return this;
        }

        public Builder mode(ExtensionMode r1) {
            this.mmode = r1;
            return this;
        }

        public Builder show_notice(Boolean r1) {
            this.mshow_notice = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullExtensionSettingsResponse extends ProtoAdapter<PullExtensionSettingsResponse> {
        public ProtoAdapter_PullExtensionSettingsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullExtensionSettingsResponse.class);
        }

        public PullExtensionSettingsResponse decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mmax_num = 0L;
            r0.mmin_num = 0L;
            r0.mshow_notice = Boolean.FALSE;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mmax_num = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mmin_num = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mmode = (ExtensionMode) ExtensionMode.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mshow_notice = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L13:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L21:
            r9.endMessage(r1);
            return r0.m1985build();
        }

        public int encodedSize(PullExtensionSettingsResponse r6) {
            Long r0 = r6.mmax_num;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
        L6:
            Long r3 = r6.mmin_num;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            ExtensionMode r7 = r6.mmode;
            if (r7 == null) goto L13;
            int r8 = ExtensionMode.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            Boolean r10 = r6.mshow_notice;
            if (r10 == null) goto L18;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r10);
        L18:
            return (r9 + r1) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m1986decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullExtensionSettingsResponse) r1);
        }

        public void encode(ProtoWriter r4, PullExtensionSettingsResponse r5) throws IOException {
            Long r0 = r5.mmax_num;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
        L5:
            Long r1 = r5.mmin_num;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
        L8:
            ExtensionMode r2 = r5.mmode;
            if (r2 == null) goto L11;
            ExtensionMode.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            Boolean r3 = r5.mshow_notice;
            if (r3 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullExtensionSettingsResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullExtensionSettingsResponse();
        DEFAULT_MAX_NUM = 0L;
        DEFAULT_MIN_NUM = 0L;
        DEFAULT_SHOW_NOTICE = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1984newBuilder() {
        Builder r0 = new Builder();
        r0.mmax_num = this.mmax_num;
        r0.mmin_num = this.mmin_num;
        r0.mmode = this.mmode;
        r0.mshow_notice = this.mshow_notice;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullExtensionSettingsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1984newBuilder();
    }

    public PullExtensionSettingsResponse(Long r7, Long r8, ExtensionMode r9, Boolean r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public PullExtensionSettingsResponse(Long r2, Long r3, ExtensionMode r4, Boolean r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mmax_num = r2;
        this.mmin_num = r3;
        this.mmode = r4;
        this.mshow_notice = r5;
    }
}
