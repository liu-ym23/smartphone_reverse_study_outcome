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
public final class SameDeviceJudgeItem extends Message<SameDeviceJudgeItem, Builder> {
    public static final ProtoAdapter<SameDeviceJudgeItem> ADAPTER = null;
    public static final String DEFAULT_DEVICE_FINGERPRINT = "";
    public static final Long DEFAULT_DID = null;
    public static final Long DEFAULT_REPORT_TIME_MS = null;
    public static final Long DEFAULT_UID = null;
    private static final long serialVersionUID = 0;
    public final AppId mapp_id;
    public final String mdevice_fingerprint;
    public final Long mdid;
    public final AppId mpeer_app_id;
    public final Long mreport_time_ms;
    public final Long muid;

    public static final class Builder extends Message.Builder<SameDeviceJudgeItem, Builder> {
        public AppId mapp_id;
        public String mdevice_fingerprint;
        public Long mdid;
        public AppId mpeer_app_id;
        public Long mreport_time_ms;
        public Long muid;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SameDeviceJudgeItem m1769build() {
            Long r0 = this.muid;
            if (r0 == null) goto L11;
            if (this.mdid == null) goto L11;
            if (this.mdevice_fingerprint == null) goto L11;
            return new SameDeviceJudgeItem(this.mapp_id, this.muid, this.mdid, this.mdevice_fingerprint, this.mpeer_app_id, this.mreport_time_ms, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r0, "muid", this.mdid, "mdid", this.mdevice_fingerprint, "mdevice_fingerprint"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1769build();
        }

        public Builder app_id(AppId r1) {
            this.mapp_id = r1;
            return this;
        }

        public Builder device_fingerprint(String r1) {
            this.mdevice_fingerprint = r1;
            return this;
        }

        public Builder did(Long r1) {
            this.mdid = r1;
            return this;
        }

        public Builder peer_app_id(AppId r1) {
            this.mpeer_app_id = r1;
            return this;
        }

        public Builder report_time_ms(Long r1) {
            this.mreport_time_ms = r1;
            return this;
        }

        public Builder uid(Long r1) {
            this.muid = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SameDeviceJudgeItem extends ProtoAdapter<SameDeviceJudgeItem> {
        public ProtoAdapter_SameDeviceJudgeItem() {
            super(FieldEncoding.LENGTH_DELIMITED, SameDeviceJudgeItem.class);
        }

        public SameDeviceJudgeItem decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.muid = 0L;
            r0.mdid = 0L;
            r0.mdevice_fingerprint = "";
            r0.mreport_time_ms = 0L;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L30;
            if (r3 != 1) goto L8;
            r0.mapp_id = (AppId) AppId.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L28
        L28:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.muid = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mdid = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.mdevice_fingerprint = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L14:
            if (r3 != 5) goto L16;
            r0.mpeer_app_id = (AppId) AppId.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L16:
            if (r3 != 7) goto L17;
            r0.mreport_time_ms = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L17:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L30:
            r9.endMessage(r1);
            return r0.m1769build();
        }

        public int encodedSize(SameDeviceJudgeItem r7) {
            AppId r0 = r7.mapp_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = AppId.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            ProtoAdapter r3 = ProtoAdapter.INT64;
            int r4 = ((r2 + r3.encodedSizeWithTag(2, r7.muid)) + r3.encodedSizeWithTag(3, r7.mdid)) + ProtoAdapter.STRING.encodedSizeWithTag(4, r7.mdevice_fingerprint);
            AppId r5 = r7.mpeer_app_id;
            if (r5 == null) goto L9;
            int r6 = AppId.ADAPTER.encodedSizeWithTag(5, r5);
        L10:
            int r8 = r4 + r6;
            Long r9 = r7.mreport_time_ms;
            if (r9 == null) goto L14;
            r1 = r3.encodedSizeWithTag(7, r9);
        L14:
            return (r8 + r1) + r7.unknownFields().size();
        L9:
            r6 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1770decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SameDeviceJudgeItem) r1);
        }

        public void encode(ProtoWriter r5, SameDeviceJudgeItem r6) throws IOException {
            AppId r0 = r6.mapp_id;
            if (r0 == null) goto L5;
            AppId.ADAPTER.encodeWithTag(r5, 1, r0);
        L5:
            ProtoAdapter r1 = ProtoAdapter.INT64;
            r1.encodeWithTag(r5, 2, r6.muid);
            r1.encodeWithTag(r5, 3, r6.mdid);
            ProtoAdapter.STRING.encodeWithTag(r5, 4, r6.mdevice_fingerprint);
            AppId r2 = r6.mpeer_app_id;
            if (r2 == null) goto L8;
            AppId.ADAPTER.encodeWithTag(r5, 5, r2);
        L8:
            Long r3 = r6.mreport_time_ms;
            if (r3 == null) goto L11;
            r1.encodeWithTag(r5, 7, r3);
        L11:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SameDeviceJudgeItem) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SameDeviceJudgeItem();
        DEFAULT_UID = 0L;
        DEFAULT_DID = 0L;
        DEFAULT_REPORT_TIME_MS = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1768newBuilder() {
        Builder r0 = new Builder();
        r0.mapp_id = this.mapp_id;
        r0.muid = this.muid;
        r0.mdid = this.mdid;
        r0.mdevice_fingerprint = this.mdevice_fingerprint;
        r0.mpeer_app_id = this.mpeer_app_id;
        r0.mreport_time_ms = this.mreport_time_ms;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SameDeviceJudgeItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1768newBuilder();
    }

    public SameDeviceJudgeItem(AppId r9, Long r10, Long r11, String r12, AppId r13, Long r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public SameDeviceJudgeItem(AppId r2, Long r3, Long r4, String r5, AppId r6, Long r7, ByteString r8) {
        super(ADAPTER, r8);
        this.mapp_id = r2;
        this.muid = r3;
        this.mdid = r4;
        this.mdevice_fingerprint = r5;
        this.mpeer_app_id = r6;
        this.mreport_time_ms = r7;
    }
}
