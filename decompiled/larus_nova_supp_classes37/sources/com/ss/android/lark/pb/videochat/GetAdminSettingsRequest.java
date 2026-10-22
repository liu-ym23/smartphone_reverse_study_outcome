package com.ss.android.lark.pb.videochat;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class GetAdminSettingsRequest extends Message<GetAdminSettingsRequest, Builder> {
    public static final ProtoAdapter<GetAdminSettingsRequest> ADAPTER = null;
    public static final String DEFAULT_MEETING_ID = "";
    public static final Long DEFAULT_TENANT_ID = null;
    public static final String DEFAULT_TENANT_ID_STR = "";
    public static final String DEFAULT_UNIQUE_ID = "";
    public static final Long DEFAULT_USER_ID = null;
    public static final String DEFAULT_USER_ID_STR = "";
    public static final FieldOptions FIELD_OPTIONS_MTENANT_ID = null;
    private static final long serialVersionUID = 0;
    public final String mmeeting_id;
    public final Long mtenant_id;
    public final String mtenant_id_str;
    public final String munique_id;
    public final Long muser_id;
    public final String muser_id_str;

    public static final class Builder extends Message.Builder<GetAdminSettingsRequest, Builder> {
        public String mmeeting_id;
        public Long mtenant_id;
        public String mtenant_id_str;
        public String munique_id;
        public Long muser_id;
        public String muser_id_str;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public GetAdminSettingsRequest m3110build() {
            return new GetAdminSettingsRequest(this.mtenant_id, this.mtenant_id_str, this.muser_id, this.muser_id_str, this.mmeeting_id, this.munique_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3110build();
        }

        public Builder meeting_id(String r1) {
            this.mmeeting_id = r1;
            return this;
        }

        public Builder tenant_id(Long r1) {
            this.mtenant_id = r1;
            return this;
        }

        public Builder tenant_id_str(String r1) {
            this.mtenant_id_str = r1;
            return this;
        }

        public Builder unique_id(String r1) {
            this.munique_id = r1;
            return this;
        }

        public Builder user_id(Long r1) {
            this.muser_id = r1;
            return this;
        }

        public Builder user_id_str(String r1) {
            this.muser_id_str = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_GetAdminSettingsRequest extends ProtoAdapter<GetAdminSettingsRequest> {
        public ProtoAdapter_GetAdminSettingsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetAdminSettingsRequest.class);
        }

        public GetAdminSettingsRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mtenant_id = 0L;
            r0.mtenant_id_str = "";
            r0.muser_id = 0L;
            r0.muser_id_str = "";
            r0.mmeeting_id = "";
            r0.munique_id = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L13;
            switch(r3) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r0.munique_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            r0.mmeeting_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            r0.muser_id_str = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            r0.muser_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L11:
            r0.mtenant_id_str = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            r0.mtenant_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L13:
            r7.endMessage(r1);
            return r0.m3110build();
        }

        public int encodedSize(GetAdminSettingsRequest r6) {
            Long r0 = r6.mtenant_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mtenant_id_str;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Long r7 = r6.muser_id;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.INT64.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.muser_id_str;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            String r13 = r6.mmeeting_id;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            String r16 = r6.munique_id;
            if (r16 == null) goto L26;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(6, r16);
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
        public /* bridge */ /* synthetic */ Object m3111decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GetAdminSettingsRequest) r1);
        }

        public void encode(ProtoWriter r4, GetAdminSettingsRequest r5) throws IOException {
            Long r0 = r5.mtenant_id;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mtenant_id_str;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            Long r2 = r5.muser_id;
            if (r2 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.muser_id_str;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            String r6 = r5.mmeeting_id;
            if (r6 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
        L17:
            String r7 = r5.munique_id;
            if (r7 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r7);
        L20:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GetAdminSettingsRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetAdminSettingsRequest();
        FIELD_OPTIONS_MTENANT_ID = new FieldOptions.Builder().FieldInfo("split,type=tenant").build();
        DEFAULT_TENANT_ID = 0L;
        DEFAULT_USER_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3109newBuilder() {
        Builder r0 = new Builder();
        r0.mtenant_id = this.mtenant_id;
        r0.mtenant_id_str = this.mtenant_id_str;
        r0.muser_id = this.muser_id;
        r0.muser_id_str = this.muser_id_str;
        r0.mmeeting_id = this.mmeeting_id;
        r0.munique_id = this.munique_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GetAdminSettingsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3109newBuilder();
    }

    public GetAdminSettingsRequest(Long r9, String r10, Long r11, String r12, String r13, String r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public GetAdminSettingsRequest(Long r2, String r3, Long r4, String r5, String r6, String r7, ByteString r8) {
        super(ADAPTER, r8);
        this.mtenant_id = r2;
        this.mtenant_id_str = r3;
        this.muser_id = r4;
        this.muser_id_str = r5;
        this.mmeeting_id = r6;
        this.munique_id = r7;
    }
}
