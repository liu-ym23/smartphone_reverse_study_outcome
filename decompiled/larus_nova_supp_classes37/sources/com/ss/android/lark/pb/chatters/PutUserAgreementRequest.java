package com.ss.android.lark.pb.chatters;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PutUserAgreementRequest extends Message<PutUserAgreementRequest, Builder> {
    public static final ProtoAdapter<PutUserAgreementRequest> ADAPTER = null;
    public static final String DEFAULT_AGREEMENT_VERSION = "";
    public static final String DEFAULT_TARGET_USER_ID = "";
    private static final long serialVersionUID = 0;
    public final String magreement_version;
    public final String mtarget_user_id;
    public final UserAgreementType muser_agreement_type;

    public static final class Builder extends Message.Builder<PutUserAgreementRequest, Builder> {
        public String magreement_version;
        public String mtarget_user_id;
        public UserAgreementType muser_agreement_type;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PutUserAgreementRequest m941build() {
            return new PutUserAgreementRequest(this.mtarget_user_id, this.muser_agreement_type, this.magreement_version, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m941build();
        }

        public Builder agreement_version(String r1) {
            this.magreement_version = r1;
            return this;
        }

        public Builder target_user_id(String r1) {
            this.mtarget_user_id = r1;
            return this;
        }

        public Builder user_agreement_type(UserAgreementType r1) {
            this.muser_agreement_type = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PutUserAgreementRequest extends ProtoAdapter<PutUserAgreementRequest> {
        public ProtoAdapter_PutUserAgreementRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PutUserAgreementRequest.class);
        }

        public PutUserAgreementRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mtarget_user_id = "";
            r0.magreement_version = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mtarget_user_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.muser_agreement_type = (UserAgreementType) UserAgreementType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.magreement_version = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m941build();
        }

        public int encodedSize(PutUserAgreementRequest r6) {
            String r0 = r6.mtarget_user_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            UserAgreementType r3 = r6.muser_agreement_type;
            if (r3 == null) goto L9;
            int r4 = UserAgreementType.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.magreement_version;
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
        public /* bridge */ /* synthetic */ Object m942decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PutUserAgreementRequest) r1);
        }

        public void encode(ProtoWriter r4, PutUserAgreementRequest r5) throws IOException {
            String r0 = r5.mtarget_user_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            UserAgreementType r1 = r5.muser_agreement_type;
            if (r1 == null) goto L8;
            UserAgreementType.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.magreement_version;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PutUserAgreementRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PutUserAgreementRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m940newBuilder() {
        Builder r0 = new Builder();
        r0.mtarget_user_id = this.mtarget_user_id;
        r0.muser_agreement_type = this.muser_agreement_type;
        r0.magreement_version = this.magreement_version;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PutUserAgreementRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m940newBuilder();
    }

    public PutUserAgreementRequest(String r2, UserAgreementType r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public PutUserAgreementRequest(String r2, UserAgreementType r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mtarget_user_id = r2;
        this.muser_agreement_type = r3;
        this.magreement_version = r4;
    }
}
